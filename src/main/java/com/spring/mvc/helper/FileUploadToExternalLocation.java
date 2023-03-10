package com.spring.mvc.helper;
import com.spring.mvc.enumeration.SystemDataInt;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.Calendar;
import java.util.Properties;

public class FileUploadToExternalLocation {
    public static ResponseMessage fileUploader(MultipartFile attachedFile, String fileName, String propertiesFileName,
                                               HttpServletRequest request) throws IOException {
        ResponseMessage responseMessage = new ResponseMessage();
        String uploadFileName = fileName;
        if (attachedFile == null) {
            responseMessage.setResponseStatus(SystemDataInt.MESSAGE_STATUS_UNSUCCESSFUL.value());
            responseMessage.setResponseText("Please select the file.");
            return responseMessage;
        }

        String originalFileName = attachedFile.getOriginalFilename();
        String fileExtension = originalFileName.substring(originalFileName.lastIndexOf(".") + 1, originalFileName.length()).toUpperCase();
        responseMessage = FileUploadValidator.isFileValidForUpload(propertiesFileName, fileExtension,
                attachedFile.getSize(), fileName);
        if (responseMessage.getResponseStatus() == 0) {
            responseMessage.setResponseText(responseMessage.getResponseDTO().toString());
            return responseMessage;
        }

        FileUploadDTO fileUploadDTO = fileUploadPathRetriever(request);
        String uploadedDirectory = fileUploadDTO.getUploadFilePath();

        File uploadDirectoryName = new File(uploadedDirectory);
        uploadDirectoryName.mkdirs();

        if (fileName.equals("")) {
            uploadFileName = originalFileName;
        }

        File uploadFile = new File(uploadedDirectory.concat(uploadFileName));

        //check if the directory exists
        if (!uploadDirectoryName.isDirectory()) {
            responseMessage.setResponseStatus(SystemDataInt.MESSAGE_STATUS_UNSUCCESSFUL.value());
            responseMessage.setResponseText("The given file location path " + uploadedDirectory + " does not exist.");
            return responseMessage;
        }
        //check if the file exist in the directory
       /* if (uploadFile.exists()) {
            responseMessage.setResponseStatus(SystemDataInt.MESSAGE_STATUS_UNSUCCESSFUL.value());
            responseMessage.setResponseText("The file name " + fileName + " already exist. Please change the file name and try again.");
            return responseMessage;
        }*/
        //check if the directory has write access
        if (!uploadDirectoryName.canWrite()) {
            responseMessage.setResponseStatus(SystemDataInt.MESSAGE_STATUS_UNSUCCESSFUL.value());
            responseMessage.setResponseText("The given file location path " + uploadedDirectory + " does not have the write permission.");
            return responseMessage;
        }

        FileOutputStream fileOutputStream = new FileOutputStream(uploadFile);
        fileOutputStream.write(attachedFile.getBytes());
        fileOutputStream.close();

        responseMessage.setResponseStatus(SystemDataInt.MESSAGE_STATUS_SUCCESSFUL.value());
        return responseMessage;
    }

    public static FileUploadDTO fileUploadPathRetriever(HttpServletRequest request) throws IOException {
        String propertiesFileName = "fileupload.properties";
        Resource resource = new ClassPathResource("/fileupload/".concat(propertiesFileName));
        Properties props = PropertiesLoaderUtils.loadProperties(resource);
        String propertiesFileWithoutExtension = propertiesFileName.substring(0, propertiesFileName.lastIndexOf("."));

        Calendar calendar = Calendar.getInstance();
        Integer currentYear = calendar.get(Calendar.YEAR);
        Integer currentMonth = calendar.get(Calendar.MONTH) + 1;
        Integer currentDay = calendar.get(Calendar.DATE);
        String day = currentDay.toString().length() == 1 ? "0" + currentDay.toString() : currentDay.toString();
        String month = currentMonth.toString().length() == 1 ? "0" + currentMonth.toString() : currentMonth.toString();
        String year = currentYear.toString().substring(2, 4);
        String folderName = "judiciary/" + year + month + day + "/";

        FileUploadDTO fileUploadDTO = new FileUploadDTO();
        String uploadFilePath = props.getProperty(propertiesFileWithoutExtension + ".fileUploadPath");
        String fileUploadPath = uploadFilePath.concat(folderName);

        fileUploadDTO.setUploadFilePath(fileUploadPath);
        return fileUploadDTO;
    }

    public static ResponseMessage checkIfDownloadPathIsValid(ResponseMessage responseMessage, String uploadFilePath)
            throws IOException {
        String uploadedDirectory = uploadFilePath.substring(0, uploadFilePath.lastIndexOf("/") + 1);
        File uploadDirectoryName = new File(uploadedDirectory);
        File uploadFile = new File(uploadFilePath);

        //check if the directory exists
        if (!uploadDirectoryName.isDirectory()) {
            responseMessage.setResponseStatus(SystemDataInt.MESSAGE_STATUS_UNSUCCESSFUL.value());
            responseMessage.setResponseText("The given file location path " + uploadedDirectory + " does not exist.");
            return responseMessage;
        }
        //check if the file exist in the directory
        if (!uploadFile.exists()) {
            responseMessage.setResponseStatus(SystemDataInt.MESSAGE_STATUS_UNSUCCESSFUL.value());
            responseMessage.setResponseText("The file does not exist.");
            return responseMessage;
        }
        //check if the directory has read access
        if (!uploadDirectoryName.canRead()) {
            responseMessage.setResponseStatus(SystemDataInt.MESSAGE_STATUS_UNSUCCESSFUL.value());
            responseMessage.setResponseText("The given file location path " + uploadedDirectory + " does not have the read permission.");
            return responseMessage;
        }

        responseMessage.setResponseStatus(SystemDataInt.MESSAGE_STATUS_SUCCESSFUL.value());
        return responseMessage;
    }

    /**
     * This method is to convert the file into byte and download the file
     */
    public static ResponseMessage fileDownloader(String fileName, String uploadFilePath, HttpServletResponse response)
            throws IOException {
        ResponseMessage responseMessage = new ResponseMessage();
        String fileExtension = fileName.substring(fileName.indexOf('.') + 1);
        byte[] bytes = convertFileToByte(uploadFilePath);

        if (fileExtension.equals("xlsx")) {
            response.setContentType("application/xlsx");
        }
        if (fileExtension.equals("xls")) {
            response.setContentType("application/xls");
        }
        if (fileExtension.equals("docx")) {
            response.setContentType("application/docx");
        }
        if (fileExtension.equals("doc")) {
            response.setContentType("application/doc");
        }
        if (fileExtension.equals("pdf")) {
            response.setContentType("application/pdf");
        }
        if (fileExtension.equals("png")) {
            response.setContentType("application/png");
        }
        if (fileExtension.equals("jpg")) {
            response.setContentType("application/jpg");
        }
        response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));
        response.setContentLength(bytes.length);
        FileCopyUtils.copy(bytes, response.getOutputStream());
        responseMessage.setResponseStatus(SystemDataInt.MESSAGE_STATUS_SUCCESSFUL.value());
        return responseMessage;
    }

    /**
     * to convert file into array of byte
     */

    public static byte[] convertFileToByte(String fileUploadPath) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            File file = new File(fileUploadPath);
            FileInputStream fileInputStream = new FileInputStream(file);
            byte[] bufferedFile = new byte[1024];
            for (int readNumber; (readNumber = fileInputStream.read(bufferedFile)) != -1; ) {
                byteArrayOutputStream.write(bufferedFile, 0, readNumber);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return byteArrayOutputStream.toByteArray();
    }
}
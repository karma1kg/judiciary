package com.spring.mvc.judiciary.service.icsService;

import com.spring.mvc.enumeration.ServiceTypeEnum;
import com.spring.mvc.enumeration.SystemDataInt;
import com.spring.mvc.helper.BeanValidator;
import com.spring.mvc.helper.FileUploadDTO;
import com.spring.mvc.helper.FileUploadToExternalLocation;
import com.spring.mvc.helper.ResponseMessage;
import com.spring.mvc.judiciary.dao.CommonDao;
import com.spring.mvc.judiciary.dto.*;
import com.spring.mvc.judiciary.entity.ChildMcDetail;
import com.spring.mvc.judiciary.entity.FileAttachment;
import com.spring.mvc.judiciary.service.commonService.CommonService;
import com.spring.mvc.judiciary.util.CommonNotificationUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.math.BigInteger;
import java.text.ParseException;
import java.util.Calendar;

/**
 * Created by kg on 19/08/2022.
 */
@Service
public class NewMarriageCertificateService {
    Calendar calendar = Calendar.getInstance();
    Integer currentYear = calendar.get(Calendar.YEAR);
    @Autowired
    private CommonService commonService;
    @Autowired
    protected BeanValidator beanValidator;

    @Autowired
    private CommonDao commonDao;
    @Transactional(rollbackFor = Exception.class)
    public ResponseMessage saveMarriageCertificate(HttpServletRequest request, ApplicationDetailDTO applicationDetailDTO, ApplicantDetailDTO applicantDetailDTO,
                                                   WitnessDetailDTO witnessDetailDTO, SpouseDetailsDTO spouseDetailsDTO) throws IOException, ParseException {
        ResponseMessage responseMessage = new ResponseMessage();
        Integer globalServiceTypeId = ServiceTypeEnum.NEW_MARRIAGE_CERTIFICATE.getServiceTypeId();
        String applicationType = ServiceTypeEnum.NEW_MARRIAGE_CERTIFICATE.getServiceCode();
        String applicationNo = commonService.generateApplicationNumber(globalServiceTypeId, applicationType);
        Integer courtId = applicationDetailDTO.getCourtId();
        String courtName = commonService.getCourtName(String.valueOf(courtId));
        applicationDetailDTO.setApplicationNo(applicationNo);
        applicantDetailDTO.setMarital_Status("2");
        spouseDetailsDTO.setMarital_Status_Id("2");
        applicantDetailDTO.setApplicationNo(applicationNo);
        witnessDetailDTO.setApplicationNo(applicationNo);
        spouseDetailsDTO.setApplicationNo(applicationNo);
        String applicationYear = currentYear.toString().substring(2, 4);
        applicantDetailDTO.setApplicationYear(applicationYear);
        applicationDetailDTO.setApplicationYear(applicationYear);
        applicationDetailDTO.setServiceSlNo(globalServiceTypeId);
        String serviceName = ServiceTypeEnum.NEW_MARRIAGE_CERTIFICATE.getServiceName();

        commonService.saveApplication(applicationDetailDTO, applicantDetailDTO, witnessDetailDTO, spouseDetailsDTO);

        if(applicationDetailDTO.getChildMCDTOs().get(0).getChildName() != null || applicationDetailDTO.getChildMCDTOs().get(0).getChildName() !=""){
            Integer iterator1 = 0;
            ChildMcDetail childMcDetail = new ChildMcDetail();
            for ( ChildMCDTO childMCDTO : applicationDetailDTO.getChildMCDTOs()) {
                iterator1 = iterator1 + 1;
                childMcDetail.setApplicationNo(applicationNo);
                childMcDetail.setChildName(childMCDTO.getChildName());
                childMcDetail.setChildDoB(childMCDTO.getChildDoB());
                childMcDetail.setChildGender(childMCDTO.getChildGender());
                //ChildMcDetail childMcDetail = convertChildMcDetailsToDTO(childMCDTO);
                commonDao.saveChildMcDetail(childMcDetail);
            }
        }
        for (FileAttachmentDTO fileAttachmentDTO : applicationDetailDTO.getFileAttachmentDTOs()) {
            MultipartFile attachedFile = fileAttachmentDTO.getAttachedFile();
            if (attachedFile != null) {
                String attachedFileName = attachedFile.getOriginalFilename();
                String attachedFileExt = attachedFileName.substring(attachedFileName.lastIndexOf("."));
                String fileName = attachedFileName;
                String propertiesFileName = "attachFile.properties";
                responseMessage = FileUploadToExternalLocation.fileUploader(attachedFile, fileName, propertiesFileName, request);
                if (responseMessage.getResponseStatus() == SystemDataInt.MESSAGE_STATUS_UNSUCCESSFUL.value()) {
                    TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                    return responseMessage;
                }
            }
        }
        Integer iterator = 0;
        for (FileAttachmentDTO fileAttachmentDTO : applicationDetailDTO.getFileAttachmentDTOs()) {
            MultipartFile attachedFile = fileAttachmentDTO.getAttachedFile();
            if (attachedFile != null) {
                String attachedFileName = attachedFile.getOriginalFilename();
                String attachedFileExt = attachedFileName.substring(attachedFileName.lastIndexOf("."));
                String fileName = attachedFileName;

                iterator = iterator + 1;
                FileUploadDTO fileUploadDTO = FileUploadToExternalLocation.fileUploadPathRetriever(request);
                String uploadedDirectory = fileUploadDTO.getUploadFilePath().concat(attachedFileName);
                fileAttachmentDTO.setUploadUrl(uploadedDirectory);
                fileAttachmentDTO.setApplicationNo(applicationNo);
                fileAttachmentDTO.setDocumentName(attachedFileName);
                FileAttachment fileAttachment = convertFileAttachmentEntToDTO(fileAttachmentDTO);
                commonDao.saveAttachFile(fileAttachment);
            }
        }
        //endregion

        responseMessage.setResponseStatus(SystemDataInt.MESSAGE_STATUS_SUCCESSFUL.value());
        responseMessage.setApplicationNumber(applicationNo);
        responseMessage.setCourtName(courtName);
        responseMessage.setServiceName(ServiceTypeEnum.NEW_MARRIAGE_CERTIFICATE.getServiceName());
        responseMessage.setResponseText("Submitted successfully.");
//        ArrayList<String> contactNo = new ArrayList<String>();
//        String[] contactNums;
//        contactNo.add(applicantDetailDTO.getMobileNo());
//        contactNums = contactNo.toArray(new String[contactNo.size()]);
        Boolean result = CommonNotificationUtils.notifyOnSubmission(applicationNo, courtName, applicantDetailDTO.getMobileNo());
        return responseMessage;
    }

    private FileAttachment convertFileAttachmentEntToDTO(FileAttachmentDTO fileAttachmentDTO) {
        FileAttachment fileAttachment = new FileAttachment();
        fileAttachment.setDocumentId(fileAttachmentDTO.getDocumentId());
        fileAttachment.setDocumentTypeId(fileAttachmentDTO.getDocumentTypeId());
        fileAttachment.setApplicationNo(fileAttachmentDTO.getApplicationNo());
        fileAttachment.setDocumentType(fileAttachmentDTO.getDocumentType());
        fileAttachment.setDocumentName(fileAttachmentDTO.getDocumentName());
        fileAttachment.setUploadUrl(fileAttachmentDTO.getUploadUrl());
        fileAttachment.setUuId(fileAttachmentDTO.getUuId());
        return fileAttachment;
    }

    private ChildMcDetail convertChildMcDetailsToDTO(ChildMCDTO childMCDTO) {
        ChildMcDetail childMcDetail = new ChildMcDetail();
        childMcDetail.setChildName(childMCDTO.getChildName());
        childMcDetail.setChildDoB(childMCDTO.getChildDoB());
        childMcDetail.setApplicationNo(childMCDTO.getApplicationNo());
        childMcDetail.setChildGender(childMCDTO.getChildGender());
        return childMcDetail;
    }
    @Transactional
    public BigInteger getCount(String curent_date, Integer courtId, Integer Service_Sl_NO) {
        return commonDao.getCount(curent_date, courtId, Service_Sl_NO);
    }
}

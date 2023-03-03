package com.spring.mvc.judiciary.service.openService;

import com.spring.mvc.enumeration.ServiceTypeEnum;
import com.spring.mvc.enumeration.SystemDataInt;
import com.spring.mvc.helper.BeanValidator;
import com.spring.mvc.helper.FileUploadDTO;
import com.spring.mvc.helper.FileUploadToExternalLocation;
import com.spring.mvc.helper.ResponseMessage;
import com.spring.mvc.judiciary.dao.CommonDao;
import com.spring.mvc.judiciary.dto.*;
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

;

/**
 * Created by USER on 9/5/2019.
 */
@Service
public class OrganTransplantService {
    Calendar calendar = Calendar.getInstance();
    Integer currentYear = calendar.get(Calendar.YEAR);
    @Autowired
    private CommonService commonService;
    @Autowired
    protected BeanValidator beanValidator;
    @Autowired
    private CommonDao commonDao;

    @Transactional(rollbackFor = Exception.class)
    public ResponseMessage saveOrganTransplant(HttpServletRequest request,
                                               ApplicationDetailDTO applicationDetailDTO, ApplicantDetailDTO applicantDetailDTO,
                                               WitnessDetailDTO witnessDetailDTO, SpouseDetailsDTO spouseDetailsDTO) throws IOException, ParseException {
        ResponseMessage responseMessage = new ResponseMessage();
        Integer globalServiceTypeId = ServiceTypeEnum.KIDNEY_TRANSPLANT.getServiceTypeId();
        String applicationType = ServiceTypeEnum.KIDNEY_TRANSPLANT.getServiceCode();
        String applicationNo = commonService.generateApplicationNumber(globalServiceTypeId, applicationType);
        applicationDetailDTO.setApplicationNo(applicationNo);
        applicantDetailDTO.setApplicationNo(applicationNo);
        witnessDetailDTO.setApplicationNo(applicationNo);
        spouseDetailsDTO.setApplicationNo(applicationNo);
        String applicationYear = currentYear.toString().substring(2, 4);
        applicantDetailDTO.setApplicationYear(applicationYear);
        applicationDetailDTO.setApplicationYear(applicationYear);
        applicationDetailDTO.setServiceSlNo(globalServiceTypeId);
        Integer courtId = applicationDetailDTO.getCourtId();
        String courtName = this.commonService.getCourtName(Integer.toString(courtId.intValue()));
        String serviceName = ServiceTypeEnum.KIDNEY_TRANSPLANT.getServiceName();


        commonService.saveApplication(applicationDetailDTO,applicantDetailDTO,witnessDetailDTO,spouseDetailsDTO);

        for (FileAttachmentDTO fileAttachmentDTO : applicationDetailDTO.getFileAttachmentDTOs()) {
            MultipartFile attachedFile = fileAttachmentDTO.getAttachedFile();
            if (attachedFile != null) {
                String attachedFileName = attachedFile.getOriginalFilename();
                String attachedFileExt = attachedFileName.substring(attachedFileName.lastIndexOf("."));
                String fileName = attachedFileName;
                responseMessage = FileUploadToExternalLocation.fileUploader(attachedFile, fileName, "attachFile.properties", request);
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
        responseMessage.setServiceName(ServiceTypeEnum.KIDNEY_TRANSPLANT.getServiceName());
        responseMessage.setResponseText("Submitted successfully.");
        /*ArrayList<String> contactNo = new ArrayList<String>();
        String[] contactNums;
        contactNo.add(applicantDetailDTO.getMobileNo());
        contactNums = contactNo.toArray(new String[contactNo.size()]);
        Boolean result = CommonNotificationUtils.notifyOnSubmission(applicationNo, courtName, contactNums);*/
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
    @Transactional
    public BigInteger getCount(String curent_date, Integer courtId,Integer Service_Sl_NO) {
        return commonDao.getCount(curent_date, courtId,Service_Sl_NO);
    }

}
package com.spring.mvc.judiciary.service.commonService;

import com.spring.mvc.enumeration.SystemDataInt;
import com.spring.mvc.helper.ResponseMessage;
import com.spring.mvc.judiciary.dao.TrackApplicationDao;
import com.spring.mvc.judiciary.dto.ApplicationDetailDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by USER on 8/22/2019.
 */
@Service
public class TrackApplicationService {
    @Autowired
    private TrackApplicationDao trackApplicationDao;

    public ResponseMessage getTrackApplicationDetail(String applicationNo) {
        ResponseMessage responseMessage = new ResponseMessage();
        ApplicationDetailDTO applicationDetailDTO = trackApplicationDao.getTrackApplicationDetail(applicationNo);
        if (applicationDetailDTO != null) {
            responseMessage.setResponseStatus(SystemDataInt.MESSAGE_STATUS_SUCCESSFUL.value());
            responseMessage.setResponseDTO(applicationDetailDTO);
        } else if(applicationNo==null||applicationDetailDTO.getCidNo()==null) {
            responseMessage.setResponseStatus(SystemDataInt.MESSAGE_STATUS_UNSUCCESSFUL.value());
            responseMessage.setResponseText("No information found matching application no. " + applicationNo);
        }
        else {
            responseMessage.setResponseStatus(SystemDataInt.MESSAGE_STATUS_UNSUCCESSFUL.value());
            responseMessage.setResponseText("No information found matching application no. " + applicationNo);
        }
        return responseMessage;
    }

    public ResponseMessage getTrackApplicationDetailMC(String applicationNo, String serviceId) {
        try{
        ResponseMessage responseMessage = new ResponseMessage();
        ApplicationDetailDTO applicationDetailDTO = trackApplicationDao.getTrackApplicationDetailMC(applicationNo,serviceId);
        if (applicationDetailDTO != null) {
            if(applicationDetailDTO.getServiceName().equalsIgnoreCase("Marriage Certificate")){
            responseMessage.setResponseStatus(SystemDataInt.MESSAGE_STATUS_SUCCESSFUL.value());
            responseMessage.setResponseDTO(applicationDetailDTO);
        }
        }
        else if(applicationNo==null||applicationDetailDTO.getCidNo()==null) {
            responseMessage.setResponseStatus(SystemDataInt.MESSAGE_STATUS_UNSUCCESSFUL.value());
            responseMessage.setResponseText("No information found matching application no. " + applicationNo);
        }
        else {
            responseMessage.setResponseStatus(SystemDataInt.MESSAGE_STATUS_UNSUCCESSFUL.value());
            responseMessage.setResponseText("No information found matching application no. " + applicationNo);
        }
        return responseMessage;
    }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public ResponseMessage getTrackApplicationDetailAP(String applicationNo, String serviceId) {
        try{
            ResponseMessage responseMessage = new ResponseMessage();
            ApplicationDetailDTO applicationDetailDTO = trackApplicationDao.getTrackApplicationDetailAP(applicationNo, serviceId);
            if (applicationDetailDTO != null) {
                if(applicationDetailDTO.getServiceName().equalsIgnoreCase("Authentication Personal Details")){
                    responseMessage.setResponseStatus(SystemDataInt.MESSAGE_STATUS_SUCCESSFUL.value());
                    responseMessage.setResponseDTO(applicationDetailDTO);
                }
            }
            else if(applicationNo==null||applicationDetailDTO.getCidNo()==null) {
                responseMessage.setResponseStatus(SystemDataInt.MESSAGE_STATUS_UNSUCCESSFUL.value());
                responseMessage.setResponseText("No information found matching application no. " + applicationNo);
            }
            else {
                responseMessage.setResponseStatus(SystemDataInt.MESSAGE_STATUS_UNSUCCESSFUL.value());
                responseMessage.setResponseText("No information found matching application no. " + applicationNo);
            }
            return responseMessage;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public ResponseMessage getTrackApplicationDetailAM(String applicationNo, String serviceId) {
        try{
            ResponseMessage responseMessage = new ResponseMessage();
            ApplicationDetailDTO applicationDetailDTO = trackApplicationDao.getTrackApplicationDetailAM(applicationNo, serviceId);
            if (applicationDetailDTO != null) {
                if(applicationDetailDTO.getServiceName().equalsIgnoreCase("Affirmation of MC")){
                    responseMessage.setResponseStatus(SystemDataInt.MESSAGE_STATUS_SUCCESSFUL.value());
                    responseMessage.setResponseDTO(applicationDetailDTO);
                }
            }
            else if(applicationNo==null||applicationDetailDTO.getCidNo()==null) {
                responseMessage.setResponseStatus(SystemDataInt.MESSAGE_STATUS_UNSUCCESSFUL.value());
                responseMessage.setResponseText("No information found matching application no. " + applicationNo);
            }
            else {
                responseMessage.setResponseStatus(SystemDataInt.MESSAGE_STATUS_UNSUCCESSFUL.value());
                responseMessage.setResponseText("No information found matching application no. " + applicationNo);
            }
            return responseMessage;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public ResponseMessage getTrackApplicationDetailLD(String applicationNo, String serviceId) {
        try{
            ResponseMessage responseMessage = new ResponseMessage();
            ApplicationDetailDTO applicationDetailDTO = trackApplicationDao.getTrackApplicationDetailLD(applicationNo, serviceId);
            if (applicationDetailDTO != null) {
                if(applicationDetailDTO.getServiceName().equalsIgnoreCase("Lost Documents")){
                    responseMessage.setResponseStatus(SystemDataInt.MESSAGE_STATUS_SUCCESSFUL.value());
                    responseMessage.setResponseDTO(applicationDetailDTO);
                }
            }
            else if(applicationNo==null||applicationDetailDTO.getCidNo()==null) {
                responseMessage.setResponseStatus(SystemDataInt.MESSAGE_STATUS_UNSUCCESSFUL.value());
                responseMessage.setResponseText("No information found matching application no. " + applicationNo);
            }
            else {
                responseMessage.setResponseStatus(SystemDataInt.MESSAGE_STATUS_UNSUCCESSFUL.value());
                responseMessage.setResponseText("No information found matching application no. " + applicationNo);
            }
            return responseMessage;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public ResponseMessage getTrackApplicationDetailSM(String applicationNo, String serviceId) {
        try{
            ResponseMessage responseMessage = new ResponseMessage();
            ApplicationDetailDTO applicationDetailDTO = trackApplicationDao.getTrackApplicationDetailSM(applicationNo, serviceId);
            if (applicationDetailDTO != null) {
                if(applicationDetailDTO.getServiceName().equalsIgnoreCase("Single Status/Marital Status")){
                    responseMessage.setResponseStatus(SystemDataInt.MESSAGE_STATUS_SUCCESSFUL.value());
                    responseMessage.setResponseDTO(applicationDetailDTO);
                }
            }
            else if(applicationNo==null||applicationDetailDTO.getCidNo()==null) {
                responseMessage.setResponseStatus(SystemDataInt.MESSAGE_STATUS_UNSUCCESSFUL.value());
                responseMessage.setResponseText("No information found matching application no. " + applicationNo);
            }
            else {
                responseMessage.setResponseStatus(SystemDataInt.MESSAGE_STATUS_UNSUCCESSFUL.value());
                responseMessage.setResponseText("No information found matching application no. " + applicationNo);
            }
            return responseMessage;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public ResponseMessage getTrackApplicationDetailCD(String applicationNo, String serviceId) {
        try{
            ResponseMessage responseMessage = new ResponseMessage();
            ApplicationDetailDTO applicationDetailDTO = trackApplicationDao.getTrackApplicationDetailCD(applicationNo, serviceId);
            if (applicationDetailDTO != null) {
                if(applicationDetailDTO.getServiceName().equalsIgnoreCase("Single Status/Marital Status")){
                    responseMessage.setResponseStatus(SystemDataInt.MESSAGE_STATUS_SUCCESSFUL.value());
                    responseMessage.setResponseDTO(applicationDetailDTO);
                }
            }
            else if(applicationNo==null||applicationDetailDTO.getCidNo()==null) {
                responseMessage.setResponseStatus(SystemDataInt.MESSAGE_STATUS_UNSUCCESSFUL.value());
                responseMessage.setResponseText("No information found matching application no. " + applicationNo);
            }
            else {
                responseMessage.setResponseStatus(SystemDataInt.MESSAGE_STATUS_UNSUCCESSFUL.value());
                responseMessage.setResponseText("No information found matching application no. " + applicationNo);
            }
            return responseMessage;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public ResponseMessage getTrackApplicationDetailAD(String applicationNo, String serviceId) {
        try{
            ResponseMessage responseMessage = new ResponseMessage();
            ApplicationDetailDTO applicationDetailDTO = trackApplicationDao.getTrackApplicationDetailAD(applicationNo, serviceId);
            if (applicationDetailDTO != null) {
                if(applicationDetailDTO.getServiceName().equalsIgnoreCase("Attestation of Documents")){
                    responseMessage.setResponseStatus(SystemDataInt.MESSAGE_STATUS_SUCCESSFUL.value());
                    responseMessage.setResponseDTO(applicationDetailDTO);
                }
            }
            else if(applicationNo==null||applicationDetailDTO.getCidNo()==null) {
                responseMessage.setResponseStatus(SystemDataInt.MESSAGE_STATUS_UNSUCCESSFUL.value());
                responseMessage.setResponseText("No information found matching application no. " + applicationNo);
            }
            else {
                responseMessage.setResponseStatus(SystemDataInt.MESSAGE_STATUS_UNSUCCESSFUL.value());
                responseMessage.setResponseText("No information found matching application no. " + applicationNo);
            }
            return responseMessage;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public ResponseMessage getTrackApplicationDetailCA(String applicationNo, String serviceId) {
        try{
            ResponseMessage responseMessage = new ResponseMessage();
            ApplicationDetailDTO applicationDetailDTO = trackApplicationDao.getTrackApplicationDetailCA(applicationNo, serviceId);
            if (applicationDetailDTO != null) {
                if(applicationDetailDTO.getServiceName().equalsIgnoreCase("Child Adoption")){
                    responseMessage.setResponseStatus(SystemDataInt.MESSAGE_STATUS_SUCCESSFUL.value());
                    responseMessage.setResponseDTO(applicationDetailDTO);
                }
            }
            else if(applicationNo==null||applicationDetailDTO.getCidNo()==null) {
                responseMessage.setResponseStatus(SystemDataInt.MESSAGE_STATUS_UNSUCCESSFUL.value());
                responseMessage.setResponseText("No information found matching application no. " + applicationNo);
            }
            else {
                responseMessage.setResponseStatus(SystemDataInt.MESSAGE_STATUS_UNSUCCESSFUL.value());
                responseMessage.setResponseText("No information found matching application no. " + applicationNo);
            }
            return responseMessage;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;    }

    public ResponseMessage getTrackApplicationDetailKT(String applicationNo, String serviceId) {
        try{
            ResponseMessage responseMessage = new ResponseMessage();
            ApplicationDetailDTO applicationDetailDTO = trackApplicationDao.getTrackApplicationDetailKT(applicationNo, serviceId);
            if (applicationDetailDTO != null) {
                if(applicationDetailDTO.getServiceName().equalsIgnoreCase("Kidney Transplant")){
                    responseMessage.setResponseStatus(SystemDataInt.MESSAGE_STATUS_SUCCESSFUL.value());
                    responseMessage.setResponseDTO(applicationDetailDTO);
                }
            }
            else if(applicationNo==null||applicationDetailDTO.getCidNo()==null) {
                responseMessage.setResponseStatus(SystemDataInt.MESSAGE_STATUS_UNSUCCESSFUL.value());
                responseMessage.setResponseText("No information found matching application no. " + applicationNo);
            }
            else {
                responseMessage.setResponseStatus(SystemDataInt.MESSAGE_STATUS_UNSUCCESSFUL.value());
                responseMessage.setResponseText("No information found matching application no. " + applicationNo);
            }
            return responseMessage;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public ResponseMessage getTrackApplicationDetailCT(String applicationNo, String serviceId) {
        try{
            ResponseMessage responseMessage = new ResponseMessage();
            ApplicationDetailDTO applicationDetailDTO = trackApplicationDao.getTrackApplicationDetailCT(applicationNo, serviceId);
            if (applicationDetailDTO != null) {
                if(applicationDetailDTO.getServiceName().equalsIgnoreCase("Closing and Transfer of Shares ans Accounts")){
                    responseMessage.setResponseStatus(SystemDataInt.MESSAGE_STATUS_SUCCESSFUL.value());
                    responseMessage.setResponseDTO(applicationDetailDTO);
                }
            }
            else if(applicationNo==null||applicationDetailDTO.getCidNo()==null) {
                responseMessage.setResponseStatus(SystemDataInt.MESSAGE_STATUS_UNSUCCESSFUL.value());
                responseMessage.setResponseText("No information found matching application no. " + applicationNo);
            }
            else {
                responseMessage.setResponseStatus(SystemDataInt.MESSAGE_STATUS_UNSUCCESSFUL.value());
                responseMessage.setResponseText("No information found matching application no. " + applicationNo);
            }
            return responseMessage;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public ResponseMessage getTrackApplicationDetailAA(String applicationNo, String serviceId) {
        try{
            ResponseMessage responseMessage = new ResponseMessage();
            ApplicationDetailDTO applicationDetailDTO = trackApplicationDao.getTrackApplicationDetailAA(applicationNo, serviceId);
            if (applicationDetailDTO != null) {
                if(applicationDetailDTO.getServiceName().equalsIgnoreCase("Attest Agreements,Wills, contracts and Testaments")){
                    responseMessage.setResponseStatus(SystemDataInt.MESSAGE_STATUS_SUCCESSFUL.value());
                    responseMessage.setResponseDTO(applicationDetailDTO);
                }
            }
            else if(applicationNo==null||applicationDetailDTO.getCidNo()==null) {
                responseMessage.setResponseStatus(SystemDataInt.MESSAGE_STATUS_UNSUCCESSFUL.value());
                responseMessage.setResponseText("No information found matching application no. " + applicationNo);
            }
            else {
                responseMessage.setResponseStatus(SystemDataInt.MESSAGE_STATUS_UNSUCCESSFUL.value());
                responseMessage.setResponseText("No information found matching application no. " + applicationNo);
            }
            return responseMessage;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

}

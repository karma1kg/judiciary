package com.spring.mvc.judiciary.service.commonService;

import bt.gov.g2c.aggregator.business.InvokePaymentWS;
import bt.gov.g2c.aggregator.dto.PaymentDTO;
import bt.gov.g2c.aggregator.dto.RequestDTO;
import bt.gov.g2c.framework.common.vo.UserRolePrivilege;
import bt.gov.g2c.framework.userdetail.InvokeWS;
import com.spring.mvc.auth.dto.UserRolePrivilegeDto;
import com.spring.mvc.enumeration.SystemDataInt;
import com.spring.mvc.helper.DropdownDTO;
import com.spring.mvc.helper.FileUploadToExternalLocation;
import com.spring.mvc.helper.ResponseMessage;
import com.spring.mvc.judiciary.dao.CommonDao;
import com.spring.mvc.judiciary.dto.*;
import com.spring.mvc.judiciary.entity.*;
import com.spring.mvc.judiciary.service.APIService;
import com.squareup.okhttp.OkHttpClient;
import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import net.minidev.json.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;
import org.wso2.client.api.ApiClient;
import org.wso2.client.api.DCRC_AllCitizenDetailsAPI.DefaultApi;
import org.wso2.client.model.DCRC_AllCitizenDetailsAPI.CitizendetailObj;
import org.wso2.client.model.DCRC_AllCitizenDetailsAPI.CitizendetailsResponse;
import org.wso2.client.model.G2C_CommonBusinessAPI.UserRolePrivilegeHierarchyObj;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

@Service
public class CommonService {
    @Autowired
    private CommonDao commonDao;

    @Autowired
    private APIService api;
    private CommonService commonService;

    Calendar calendar = Calendar.getInstance();

    Integer currentYear = Integer.valueOf(this.calendar.get(1));

    Integer currentMonth = Integer.valueOf(this.calendar.get(2) + 1);

    Integer currentDay = Integer.valueOf(this.calendar.get(5));

    public ResponseMessage getCitizenDetails(String cidNo) {
        ResponseMessage responseMessage = new ResponseMessage();
        CitizenDetailDTO citizenDetailDTO = new CitizenDetailDTO();
        ResourceBundle resourceBundle1 = ResourceBundle.getBundle("wsEndPointURL_en_US");
        String getCitizenDetails = resourceBundle1.getString("getAllCitizenDetails.endPointURL");
        try {
            OkHttpClient httpClient = new OkHttpClient();
            httpClient.setConnectTimeout(10000L, TimeUnit.MILLISECONDS);
            httpClient.setReadTimeout(10000L, TimeUnit.MILLISECONDS);
            ApiClient apiClient = new ApiClient();
            apiClient.setHttpClient(httpClient);
            apiClient.setBasePath(getCitizenDetails);
            Token token = this.api.getApplicationToken();
            apiClient.setAccessToken(token.getAccess_token());
            DefaultApi api1 = new DefaultApi(apiClient);
            CitizendetailsResponse citizenDetailsResponse = api1.allcitizendetailsCidGet(cidNo);
            if (citizenDetailsResponse.getAllCitizenDetailsResponse().getAllCitizenDetail() != null && !citizenDetailsResponse.getAllCitizenDetailsResponse().getAllCitizenDetail().isEmpty()) {
                CitizendetailObj citizendetailsObj = citizenDetailsResponse.getAllCitizenDetailsResponse().getAllCitizenDetail().get(0);
                citizenDetailDTO.setApplicantName(citizendetailsObj.getFirstName() + " " + citizendetailsObj.getMiddleName() + " " + citizendetailsObj.getLastName());
                citizenDetailDTO.setApplicantName(citizenDetailDTO.getApplicantName().replaceAll("null", ""));
                citizenDetailDTO.setApplicantDob(citizendetailsObj.getDob());
                citizenDetailDTO.setGender(citizendetailsObj.getGender());
                citizenDetailDTO.setFatherName(citizendetailsObj.getFatherName());
                citizenDetailDTO.setMotherName(citizendetailsObj.getMotherName());
                citizenDetailDTO.setTharmNo(citizendetailsObj.getThramNo());
                citizenDetailDTO.setHouseNo(citizendetailsObj.getHouseNo());
                citizenDetailDTO.setVillageId(citizendetailsObj.getVillageSerialNo());
                citizenDetailDTO.setGewogId(citizendetailsObj.getGewogId());
                citizenDetailDTO.setDzongkhagId(citizendetailsObj.getDzongkhagId());
                citizenDetailDTO.setSpouseName(citizendetailsObj.getFirstName() + " " + citizendetailsObj.getMiddleName() + " " + citizendetailsObj.getLastName());
                citizenDetailDTO.setSpouseName(citizenDetailDTO.getSpouseName().replaceAll("null", ""));
                citizenDetailDTO.setSpouseApplicantDob(citizendetailsObj.getDob());
                citizenDetailDTO.setSpouseGender(citizendetailsObj.getGender());
                citizenDetailDTO.setSpouseFathersName(citizendetailsObj.getFatherName());
                citizenDetailDTO.setSpouseMothersName(citizendetailsObj.getMotherName());
                citizenDetailDTO.setSpouseTharmNo(citizendetailsObj.getThramNo());
                citizenDetailDTO.setSpouseHouseNo(citizendetailsObj.getHouseNo());
                citizenDetailDTO.setSpouseVillageId(citizendetailsObj.getVillageSerialNo());
                citizenDetailDTO.setSpouseGewogId(citizendetailsObj.getGewogId());
                citizenDetailDTO.setSpouseDzongkhagId(citizendetailsObj.getDzongkhagId());
                citizenDetailDTO.setWitness1Name(citizendetailsObj.getFirstName() + " " + citizendetailsObj.getMiddleName() + " " + citizendetailsObj.getLastName());
                citizenDetailDTO.setWitness1Name(citizenDetailDTO.getWitness1Name().replaceAll("null", ""));
                citizenDetailDTO.setW1Dob(citizendetailsObj.getDob());
                citizenDetailDTO.setW1Gender(citizendetailsObj.getGender());
                citizenDetailDTO.setW1fathersName(citizendetailsObj.getFatherName());
                citizenDetailDTO.setW1tharmNo(citizendetailsObj.getThramNo());
                citizenDetailDTO.setW1houseNo(citizendetailsObj.getHouseNo());
                citizenDetailDTO.setW1villageId(citizendetailsObj.getVillageSerialNo());
                citizenDetailDTO.setW1gewogId(citizendetailsObj.getGewogId());
                citizenDetailDTO.setW1dzongkhagId(citizendetailsObj.getDzongkhagId());
                citizenDetailDTO.setWitness2Name(citizendetailsObj.getFirstName() + " " + citizendetailsObj.getMiddleName() + " " + citizendetailsObj.getLastName());
                citizenDetailDTO.setWitness2Name(citizenDetailDTO.getWitness2Name().replaceAll("null", ""));
                citizenDetailDTO.setW2Dob(citizendetailsObj.getDob());
                citizenDetailDTO.setW2gender(citizendetailsObj.getGender());
                citizenDetailDTO.setW2fathersName(citizendetailsObj.getFatherName());
                citizenDetailDTO.setW2tharmNo(citizendetailsObj.getThramNo());
                citizenDetailDTO.setW2houseNo(citizendetailsObj.getHouseNo());
                citizenDetailDTO.setW2villageId(citizendetailsObj.getVillageSerialNo());
                citizenDetailDTO.setW2gewogId(citizendetailsObj.getGewogId());
                citizenDetailDTO.setW2dzongkhagId(citizendetailsObj.getDzongkhagId());
                citizenDetailDTO.setOrgFatherName(citizendetailsObj.getFirstName() + " " + citizendetailsObj.getMiddleName() + " " + citizendetailsObj.getLastName());
                citizenDetailDTO.setOrgFatherName(citizenDetailDTO.getOrgFatherName().replaceAll("null", ""));
                citizenDetailDTO.setOrgFatherDob(citizendetailsObj.getDob());
                citizenDetailDTO.setOrgFatherGender(citizendetailsObj.getGender());
                citizenDetailDTO.setOrgFatherFathersName(citizendetailsObj.getFatherName());
                citizenDetailDTO.setOrgFatherTharmNo(citizendetailsObj.getThramNo());
                citizenDetailDTO.setOrgFatherHouseNo(citizendetailsObj.getHouseNo());
                citizenDetailDTO.setOrgFatherVillageId(citizendetailsObj.getVillageSerialNo());
                citizenDetailDTO.setOrgFatherGewogId(citizendetailsObj.getGewogId());
                citizenDetailDTO.setOrgFatherDzongkhagId(citizendetailsObj.getDzongkhagId());
                citizenDetailDTO.setOrgMotherName(citizendetailsObj.getFirstName() + " " + citizendetailsObj.getMiddleName() + " " + citizendetailsObj.getLastName());
                citizenDetailDTO.setOrgMotherName(citizenDetailDTO.getOrgMotherName().replaceAll("null", ""));
                citizenDetailDTO.setOrgMotherDob(citizendetailsObj.getDob());
                citizenDetailDTO.setOrgMotherGender(citizendetailsObj.getGender());
                citizenDetailDTO.setOrgMotherFathersName(citizendetailsObj.getFatherName());
                citizenDetailDTO.setOrgMotherTharmNo(citizendetailsObj.getThramNo());
                citizenDetailDTO.setOrgMotherHouseNo(citizendetailsObj.getHouseNo());
                citizenDetailDTO.setOrgMotherVillageId(citizendetailsObj.getVillageSerialNo());
                citizenDetailDTO.setOrgMotherGewogId(citizendetailsObj.getGewogId());
                citizenDetailDTO.setOrgMotherDzongkhagId(citizendetailsObj.getDzongkhagId());
                citizenDetailDTO.setPatientName(citizendetailsObj.getFirstName() + " " + citizendetailsObj.getMiddleName() + " " + citizendetailsObj.getLastName());
                citizenDetailDTO.setPatientName(citizenDetailDTO.getPatientName().replaceAll("null", ""));
                citizenDetailDTO.setPatientDob(citizendetailsObj.getDob());
                citizenDetailDTO.setPatientGender(citizendetailsObj.getGender());
                citizenDetailDTO.setPatientFathersName(citizendetailsObj.getFatherName());
                citizenDetailDTO.setPatientTharmNo(citizendetailsObj.getThramNo());
                citizenDetailDTO.setPatientHouseNo(citizendetailsObj.getHouseNo());
                citizenDetailDTO.setPatientVillageId(citizendetailsObj.getVillageSerialNo());
                citizenDetailDTO.setPatientGewogId(citizendetailsObj.getGewogId());
                citizenDetailDTO.setPatientDzongkhagId(citizendetailsObj.getDzongkhagId());
                citizenDetailDTO.setDonorName(citizendetailsObj.getFirstName() + " " + citizendetailsObj.getMiddleName() + " " + citizendetailsObj.getLastName());
                citizenDetailDTO.setDonorName(citizenDetailDTO.getDonorName().replaceAll("null", ""));
                citizenDetailDTO.setDonorDob(citizendetailsObj.getDob());
                citizenDetailDTO.setDonorGender(citizendetailsObj.getGender());
                citizenDetailDTO.setDonorFathersName(citizendetailsObj.getFatherName());
                citizenDetailDTO.setDonorTharmNo(citizendetailsObj.getThramNo());
                citizenDetailDTO.setDonorHouseNo(citizendetailsObj.getHouseNo());
                citizenDetailDTO.setDonorVillageId(citizendetailsObj.getVillageSerialNo());
                citizenDetailDTO.setDonorGewogId(citizendetailsObj.getGewogId());
                citizenDetailDTO.setDonorDzongkhagId(citizendetailsObj.getDzongkhagId());
                citizenDetailDTO.setDonorDepName(citizendetailsObj.getFirstName() + " " + citizendetailsObj.getMiddleName() + " " + citizendetailsObj.getLastName());
                citizenDetailDTO.setDonorDepName(citizenDetailDTO.getDonorDepName().replaceAll("null", ""));
                citizenDetailDTO.setDonorDepDob(citizendetailsObj.getDob());
                citizenDetailDTO.setDonorDepGender(citizendetailsObj.getGender());
                citizenDetailDTO.setDonorDepFathersName(citizendetailsObj.getFatherName());
                citizenDetailDTO.setDonorDepTharmNo(citizendetailsObj.getThramNo());
                citizenDetailDTO.setDonorDepHouseNo(citizendetailsObj.getHouseNo());
                citizenDetailDTO.setDonorDepVillageId(citizendetailsObj.getVillageSerialNo());
                citizenDetailDTO.setDonorDepGewogId(citizendetailsObj.getGewogId());
                citizenDetailDTO.setDonorDepDzongkhagId(citizendetailsObj.getDzongkhagId());
                citizenDetailDTO.setTransferorApplicantName(citizendetailsObj.getFirstName() + " " + citizendetailsObj.getMiddleName() + " " + citizendetailsObj.getLastName());
                citizenDetailDTO.setTransferorApplicantName(citizenDetailDTO.getTransferorApplicantName().replaceAll("null", ""));
                citizenDetailDTO.setTransferorApplicantDob(citizendetailsObj.getDob());
                citizenDetailDTO.setTransferorGender(citizendetailsObj.getGender());
                citizenDetailDTO.setTransferorFathersName(citizendetailsObj.getFatherName());
                citizenDetailDTO.setTransferorTharmNo(citizendetailsObj.getThramNo());
                citizenDetailDTO.setTransferorHouseNo(citizendetailsObj.getHouseNo());
                citizenDetailDTO.setTransferorVillageId(citizendetailsObj.getVillageSerialNo());
                citizenDetailDTO.setTransferorGewogId(citizendetailsObj.getGewogId());
                citizenDetailDTO.setTransferorDzongkhagId(citizendetailsObj.getDzongkhagId());
                citizenDetailDTO.setHouseHoldNo(citizendetailsObj.getHouseholdNo());
            }
        } catch (Exception var12) {
            responseMessage.setResponseStatus(Integer.valueOf(SystemDataInt.MESSAGE_STATUS_UNSUCCESSFUL.value()));
            responseMessage.setResponseText("No information found matching CID No " + cidNo);
            return responseMessage;
        }
        responseMessage.setResponseDTO(citizenDetailDTO);
        responseMessage.setResponseStatus(Integer.valueOf(SystemDataInt.MESSAGE_STATUS_SUCCESSFUL.value()));
        responseMessage=commonService.getHouseholdDetails(citizenDetailDTO.getHouseHoldNo());
        return responseMessage;

    }

    public ResponseMessage getAllCitizenDetails(String cidNo) {
        ResponseMessage responseMessage = new ResponseMessage();
        CitizenDetailDTO citizenDetailDTO = new CitizenDetailDTO();
        ResourceBundle resourceBundle1 = ResourceBundle.getBundle("wsEndPointURL_en_US");
        String getAllCitizenDetails = resourceBundle1.getString("getAllCitizenDetails.endPointURL");
        try {
            OkHttpClient httpClient = new OkHttpClient();
            httpClient.setConnectTimeout(10000L, TimeUnit.MILLISECONDS);
            httpClient.setReadTimeout(10000L, TimeUnit.MILLISECONDS);
            ApiClient apiClient = new ApiClient();
            apiClient.setHttpClient(httpClient);
            apiClient.setBasePath(getAllCitizenDetails);
            Token token = this.api.getApplicationToken();
            apiClient.setAccessToken(token.getAccess_token());
            DefaultApi api = new DefaultApi(apiClient);
            CitizendetailsResponse citizenDetailsResponse = api.allcitizendetailsCidGet(cidNo);
            if (citizenDetailsResponse.getAllCitizenDetailsResponse().getAllCitizenDetail() != null &&
                    !citizenDetailsResponse.getAllCitizenDetailsResponse().getAllCitizenDetail().isEmpty()) {
                CitizendetailObj citizendetailsObj = citizenDetailsResponse.getAllCitizenDetailsResponse().getAllCitizenDetail().get(0);
                citizenDetailDTO.setApplicantName(citizendetailsObj.getFirstName() + " " + citizendetailsObj.getMiddleName() + " " + citizendetailsObj.getLastName());
                citizenDetailDTO.setApplicantName(citizenDetailDTO.getApplicantName().replaceAll("null", ""));
                citizenDetailDTO.setApplicantDob(citizendetailsObj.getDob());
                citizenDetailDTO.setGender(citizendetailsObj.getGender());
                citizenDetailDTO.setFatherName(citizendetailsObj.getFatherName());
                citizenDetailDTO.setMotherName(citizendetailsObj.getMotherName());
                citizenDetailDTO.setTharmNo(citizendetailsObj.getThramNo());
                citizenDetailDTO.setHouseNo(citizendetailsObj.getHouseNo());
                citizenDetailDTO.setVillageId(citizendetailsObj.getVillageSerialNo());
                citizenDetailDTO.setGewogId(citizendetailsObj.getGewogId());
                citizenDetailDTO.setDzongkhagId(citizendetailsObj.getDzongkhagId());
                citizenDetailDTO.setSpouseName(citizendetailsObj.getFirstName() + " " + citizendetailsObj.getMiddleName() + " " + citizendetailsObj.getLastName());
                citizenDetailDTO.setSpouseName(citizenDetailDTO.getSpouseName().replaceAll("null", ""));
                citizenDetailDTO.setSpouseApplicantDob(citizendetailsObj.getDob());
                citizenDetailDTO.setSpouseGender(citizendetailsObj.getGender());
                citizenDetailDTO.setSpouseFathersName(citizendetailsObj.getFatherName());
                citizenDetailDTO.setSpouseMothersName(citizendetailsObj.getMotherName());
                citizenDetailDTO.setSpouseTharmNo(citizendetailsObj.getThramNo());
                citizenDetailDTO.setSpouseHouseNo(citizendetailsObj.getHouseNo());
                citizenDetailDTO.setSpouseVillageId(citizendetailsObj.getVillageSerialNo());
                citizenDetailDTO.setSpouseGewogId(citizendetailsObj.getGewogId());
                citizenDetailDTO.setSpouseDzongkhagId(citizendetailsObj.getDzongkhagId());
                citizenDetailDTO.setWitness1Name(citizendetailsObj.getFirstName() + " " + citizendetailsObj.getMiddleName() + " " + citizendetailsObj.getLastName());
                citizenDetailDTO.setWitness1Name(citizenDetailDTO.getWitness1Name().replaceAll("null", ""));
                citizenDetailDTO.setW1Dob(citizendetailsObj.getDob());
                citizenDetailDTO.setW1Gender(citizendetailsObj.getGender());
                citizenDetailDTO.setW1fathersName(citizendetailsObj.getFatherName());
                citizenDetailDTO.setW1tharmNo(citizendetailsObj.getThramNo());
                citizenDetailDTO.setW1houseNo(citizendetailsObj.getHouseNo());
                citizenDetailDTO.setW1villageId(citizendetailsObj.getVillageSerialNo());
                citizenDetailDTO.setW1gewogId(citizendetailsObj.getGewogId());
                citizenDetailDTO.setW1dzongkhagId(citizendetailsObj.getDzongkhagId());
                citizenDetailDTO.setWitness2Name(citizendetailsObj.getFirstName() + " " + citizendetailsObj.getMiddleName() + " " + citizendetailsObj.getLastName());
                citizenDetailDTO.setWitness2Name(citizenDetailDTO.getWitness2Name().replaceAll("null", ""));
                citizenDetailDTO.setW2Dob(citizendetailsObj.getDob());
                citizenDetailDTO.setW2gender(citizendetailsObj.getGender());
                citizenDetailDTO.setW2fathersName(citizendetailsObj.getFatherName());
                citizenDetailDTO.setW2tharmNo(citizendetailsObj.getThramNo());
                citizenDetailDTO.setW2houseNo(citizendetailsObj.getHouseNo());
                citizenDetailDTO.setW2villageId(citizendetailsObj.getVillageSerialNo());
                citizenDetailDTO.setW2gewogId(citizendetailsObj.getGewogId());
                citizenDetailDTO.setW2dzongkhagId(citizendetailsObj.getDzongkhagId());
                citizenDetailDTO.setOrgFatherName(citizendetailsObj.getFirstName() + " " + citizendetailsObj.getMiddleName() + " " + citizendetailsObj.getLastName());
                citizenDetailDTO.setOrgFatherName(citizenDetailDTO.getOrgFatherName().replaceAll("null", ""));
                citizenDetailDTO.setOrgFatherDob(citizendetailsObj.getDob());
                citizenDetailDTO.setOrgFatherGender(citizendetailsObj.getGender());
                citizenDetailDTO.setOrgFatherFathersName(citizendetailsObj.getFatherName());
                citizenDetailDTO.setOrgFatherTharmNo(citizendetailsObj.getThramNo());
                citizenDetailDTO.setOrgFatherHouseNo(citizendetailsObj.getHouseNo());
                citizenDetailDTO.setOrgFatherVillageId(citizendetailsObj.getVillageSerialNo());
                citizenDetailDTO.setOrgFatherGewogId(citizendetailsObj.getGewogId());
                citizenDetailDTO.setOrgFatherDzongkhagId(citizendetailsObj.getDzongkhagId());
                citizenDetailDTO.setOrgMotherName(citizendetailsObj.getFirstName() + " " + citizendetailsObj.getMiddleName() + " " + citizendetailsObj.getLastName());
                citizenDetailDTO.setOrgMotherName(citizenDetailDTO.getOrgMotherName().replaceAll("null", ""));
                citizenDetailDTO.setOrgMotherDob(citizendetailsObj.getDob());
                citizenDetailDTO.setOrgMotherGender(citizendetailsObj.getGender());
                citizenDetailDTO.setOrgMotherFathersName(citizendetailsObj.getFatherName());
                citizenDetailDTO.setOrgMotherTharmNo(citizendetailsObj.getThramNo());
                citizenDetailDTO.setOrgMotherHouseNo(citizendetailsObj.getHouseNo());
                citizenDetailDTO.setOrgMotherVillageId(citizendetailsObj.getVillageSerialNo());
                citizenDetailDTO.setOrgMotherGewogId(citizendetailsObj.getGewogId());
                citizenDetailDTO.setOrgMotherDzongkhagId(citizendetailsObj.getDzongkhagId());
                citizenDetailDTO.setPatientName(citizendetailsObj.getFirstName() + " " + citizendetailsObj.getMiddleName() + " " + citizendetailsObj.getLastName());
                citizenDetailDTO.setPatientName(citizenDetailDTO.getPatientName().replaceAll("null", ""));
                citizenDetailDTO.setPatientDob(citizendetailsObj.getDob());
                citizenDetailDTO.setPatientGender(citizendetailsObj.getGender());
                citizenDetailDTO.setPatientFathersName(citizendetailsObj.getFatherName());
                citizenDetailDTO.setPatientTharmNo(citizendetailsObj.getThramNo());
                citizenDetailDTO.setPatientHouseNo(citizendetailsObj.getHouseNo());
                citizenDetailDTO.setPatientVillageId(citizendetailsObj.getVillageSerialNo());
                citizenDetailDTO.setPatientGewogId(citizendetailsObj.getGewogId());
                citizenDetailDTO.setPatientDzongkhagId(citizendetailsObj.getDzongkhagId());
                citizenDetailDTO.setDonorName(citizendetailsObj.getFirstName() + " " + citizendetailsObj.getMiddleName() + " " + citizendetailsObj.getLastName());
                citizenDetailDTO.setDonorName(citizenDetailDTO.getDonorName().replaceAll("null", ""));
                citizenDetailDTO.setDonorDob(citizendetailsObj.getDob());
                citizenDetailDTO.setDonorGender(citizendetailsObj.getGender());
                citizenDetailDTO.setDonorFathersName(citizendetailsObj.getFatherName());
                citizenDetailDTO.setDonorTharmNo(citizendetailsObj.getThramNo());
                citizenDetailDTO.setDonorHouseNo(citizendetailsObj.getHouseNo());
                citizenDetailDTO.setDonorVillageId(citizendetailsObj.getVillageSerialNo());
                citizenDetailDTO.setDonorGewogId(citizendetailsObj.getGewogId());
                citizenDetailDTO.setDonorDzongkhagId(citizendetailsObj.getDzongkhagId());
                citizenDetailDTO.setDonorDepName(citizendetailsObj.getFirstName() + " " + citizendetailsObj.getMiddleName() + " " + citizendetailsObj.getLastName());
                citizenDetailDTO.setDonorDepName(citizenDetailDTO.getDonorDepName().replaceAll("null", ""));
                citizenDetailDTO.setDonorDepDob(citizendetailsObj.getDob());
                citizenDetailDTO.setDonorDepGender(citizendetailsObj.getGender());
                citizenDetailDTO.setDonorDepFathersName(citizendetailsObj.getFatherName());
                citizenDetailDTO.setDonorDepTharmNo(citizendetailsObj.getThramNo());
                citizenDetailDTO.setDonorDepHouseNo(citizendetailsObj.getHouseNo());
                citizenDetailDTO.setDonorDepVillageId(citizendetailsObj.getVillageSerialNo());
                citizenDetailDTO.setDonorDepGewogId(citizendetailsObj.getGewogId());
                citizenDetailDTO.setDonorDepDzongkhagId(citizendetailsObj.getDzongkhagId());
                citizenDetailDTO.setTransferorApplicantName(citizendetailsObj.getFirstName() + " " + citizendetailsObj.getMiddleName() + " " + citizendetailsObj.getLastName());
                citizenDetailDTO.setTransferorApplicantName(citizenDetailDTO.getTransferorApplicantName().replaceAll("null", ""));
                citizenDetailDTO.setTransferorApplicantDob(citizendetailsObj.getDob());
                citizenDetailDTO.setTransferorGender(citizendetailsObj.getGender());
                citizenDetailDTO.setTransferorFathersName(citizendetailsObj.getFatherName());
                citizenDetailDTO.setTransferorTharmNo(citizendetailsObj.getThramNo());
                citizenDetailDTO.setTransferorHouseNo(citizendetailsObj.getHouseNo());
                citizenDetailDTO.setTransferorVillageId(citizendetailsObj.getVillageSerialNo());
                citizenDetailDTO.setTransferorGewogId(citizendetailsObj.getGewogId());
                citizenDetailDTO.setTransferorDzongkhagId(citizendetailsObj.getDzongkhagId());
            }
        } catch (Exception e) {
            responseMessage.setResponseStatus(Integer.valueOf(SystemDataInt.MESSAGE_STATUS_UNSUCCESSFUL.value()));
            responseMessage.setResponseText("No information found matching CID No " + cidNo);
            return responseMessage;
        }
        responseMessage.setResponseDTO(citizenDetailDTO);
        responseMessage.setResponseStatus(Integer.valueOf(SystemDataInt.MESSAGE_STATUS_SUCCESSFUL.value()));
        return responseMessage;
    }

    public List<DropdownDTO> getAllReligion() {
        return this.commonDao.getAllReligion();
    }

    public List<DropdownDTO> getAllCourt() {
        return this.commonDao.getAllCourt();
    }

    public List<DropdownDTO> getDzongkhagList() {
        return this.commonDao.getDzongkhagList();
    }

    public List<DropdownDTO> getGewogList() {
        return this.commonDao.getGewogList();
    }

    public List<DropdownDTO> getVillageList() {
        return this.commonDao.getVillageList();
    }

    public List<DropdownDTO> getGewogListName(Integer dzoId) {
        return this.commonDao.getGewogListName(dzoId);
    }

    public List<DropdownDTO> getVillageListName(Integer gewogId) {
        return this.commonDao.getVillageListName(gewogId);
    }

    public List<DropdownDTO> getAllCourtOffline(Integer courtId) {
        return this.commonDao.getAllCourtOffline(courtId);
    }

    public List<DropdownDTO> getAuthType() {
        return this.commonDao.getAuthType();
    }

    public List<DropdownDTO> getAllCountry() {
        return this.commonDao.getAllCountry();
    }

    public List<DropdownDTO> documentList() {
        return this.commonDao.documentList();
    }

    public List<DropdownDTO> getRequiredDocumentList(String Service_Id) {
        return this.commonDao.getRequiredDocumentList(Service_Id);
    }

    public List<DropdownDTO> getRelationshiptList() {
        return this.commonDao.getRelationshiptList();
    }

    public String generateApplicationNumber(Integer globalServiceTypeId, String applicationType) {
        String applicationDay = (this.currentDay.toString().length() == 1) ? ("0" + this.currentDay.toString()) : this.currentDay.toString();
        String applicationMonth = (this.currentMonth.toString().length() == 1) ? ("0" + this.currentMonth.toString()) : this.currentMonth.toString();
        String applicationYear = this.currentYear.toString().substring(2, 4);
        String serialId = this.commonDao.getApplicationSerial(globalServiceTypeId, applicationYear, applicationMonth, applicationDay, applicationType);
        serialId = (serialId == null) ? "0" : serialId;
        Integer applicationSerial = Integer.valueOf(Integer.parseInt(serialId));
        applicationSerial = Integer.valueOf(applicationSerial.intValue() + 1);
        String serialNumber = null;
        if (applicationSerial.toString().length() == 1)
            serialNumber = "0000" + applicationSerial.toString();
        if (applicationSerial.toString().length() == 2)
            serialNumber = "000" + applicationSerial.toString();
        if (applicationSerial.toString().length() == 3)
            serialNumber = "00" + applicationSerial.toString();
        if (applicationSerial.toString().length() == 4)
            serialNumber = "0" + applicationSerial.toString();
        if (applicationSerial.toString().length() == 5)
            serialNumber = applicationSerial.toString();
        String applicationNumber = globalServiceTypeId.toString() + "_" + applicationYear + applicationMonth + applicationDay + applicationType + serialNumber;
        return applicationNumber;
    }

    @Transactional(rollbackFor = {Exception.class})
    public void saveApplication(ApplicationDetailDTO applicationDetailDTO, ApplicantDetailDTO applicantDetailDTO, WitnessDetailDTO witnessDetailDTO, SpouseDetailsDTO spouseDetailsDTO) throws ParseException {
        ResponseMessage responseMessage = new ResponseMessage();
        applicationDetailDTO.setCreatedDate(new Date());
        applicationDetailDTO.setCreatedBy("CITIZEN(CITIZEN)");
        applicationDetailDTO.setPrintStatus("N");
        applicationDetailDTO.setPaymentCleared("N");
        if (applicationDetailDTO.getJudgementNo() != null) {
            applicationDetailDTO.setStatusId("8");
            applicationDetailDTO.setPaymentCleared("Y");
        } else {
            applicationDetailDTO.setStatusId("1");
        }
        //new Added marital status
        ApplicantDetail applicantDetail = convertApplicantDTOtoEntity(applicantDetailDTO);
        applicantDetail.setApplicationYear(applicantDetailDTO.getApplicationYear());
        applicantDetail.setMarital_Status(applicantDetailDTO.getMarital_Status());
        applicantDetail.setNationality("Bhutanese");
        this.commonDao.saveApplicant(applicantDetail);
        ApplicationDetail applicationDetail = convertApplicationDTOtoEntity(applicationDetailDTO);
        applicationDetail.setLetterDate(null);
        applicationDetail.setApplicationYear(applicationDetailDTO.getApplicationYear());
        applicationDetail.setRegDate(null);
        this.commonDao.saveApplication(applicationDetail);
        if (spouseDetailsDTO.getSpouseCidNo() != null && spouseDetailsDTO.getSpouseCidNo() != "") {
            SpouseDetail spouseDetail = convertSpouseDTOtoEntity(spouseDetailsDTO);
            spouseDetail.setNationality("Bhutanese");
            this.commonDao.saveSpouse(spouseDetail);
        }
        if (applicationDetailDTO.getPatientCid() != null && applicationDetailDTO.getPatientCid() != "") {
            PatientDetail patientDetail = convertPatientDetailTOEntity(applicationDetailDTO);
            this.commonDao.savePatientDetail(patientDetail);
        }
        if (applicationDetailDTO.getDonorCid() != null && applicationDetailDTO.getDonorCid() != "") {
            DonorDetail donorDetail = convertDonorDetailTOEntity(applicationDetailDTO);
            this.commonDao.saveDonorDetail(donorDetail);
        }
        if (applicationDetailDTO.getTransferorApplicantCid() != null && applicationDetailDTO.getTransferorApplicantCid() != "") {
            TransferorDetail transferorDetail = convertTransferorDetailTOEntity(applicationDetailDTO);
            this.commonDao.saveTransferorDetail(transferorDetail);
        }
        if (applicationDetailDTO.getDonorDepCid() != null && applicationDetailDTO.getDonorDepCid() != "") {
            DependentDetail dependentDetail = convertDependentDetailTOEntity(applicationDetailDTO);
            this.commonDao.saveDependentDetail(dependentDetail);
        }
        if (applicationDetailDTO.getChildName() != null && applicationDetailDTO.getChildName() != "") {
            ChildTravelDetail childTravelDetail = convertChildTravelDetailTOEntity(applicationDetailDTO);
            this.commonDao.saveChildTravelDetail(childTravelDetail);
        }
        if (witnessDetailDTO.getWitness1CidNo() != null && witnessDetailDTO.getWitness1CidNo() != "") {
            witnessDetailDTO.setWitnessTypeId(Integer.valueOf(1));
            WitnessDetail witnessDetail = convertWitnessDTOtoEntity(witnessDetailDTO);
            this.commonDao.saveWitness(witnessDetail);
        }
        if (witnessDetailDTO.getWitness2CidNo() != null && witnessDetailDTO.getWitness2CidNo() != "") {
            witnessDetailDTO.setWitnessTypeId(Integer.valueOf(2));
            WitnessDetail witnessDetail1 = convertWitness1DTOtoEntity(witnessDetailDTO);
            this.commonDao.saveWitness(witnessDetail1);
        }
        WorkFlowDetailDTO workFlowDetailDTO = new WorkFlowDetailDTO();
        Integer workInstanceId = getWorkInstanceId();
        workFlowDetailDTO.setApplicationNo(applicationDetailDTO.getApplicationNo());
        if (applicationDetailDTO.getJudgementNo() != null) {
            workFlowDetailDTO.setApplicationStatusId(Integer.valueOf(8));
        } else {
            workFlowDetailDTO.setApplicationStatusId(Integer.valueOf(1));
        }
        workFlowDetailDTO.setServiceId(applicationDetailDTO.getServiceSlNo());
        workFlowDetailDTO.setCreatedBy(applicationDetailDTO.getCreatedBy());
        workFlowDetailDTO.setCreatedDate(applicationDetailDTO.getCreatedDate());
        WorkFlowDetail workFlowDetail = convertWorkFlowDetailDTOtoEntity(workFlowDetailDTO);
        this.commonDao.saveWorkFlowDetail(workFlowDetail);
        TaskDetailDTO taskDetailDTO = new TaskDetailDTO();
        taskDetailDTO.setApplicationNo(applicationDetailDTO.getApplicationNo());
        if (applicationDetailDTO.getJudgementNo() != null) {
            taskDetailDTO.setApplicationStatus(Integer.valueOf(8));
        } else {
            taskDetailDTO.setApplicationStatus(Integer.valueOf(1));
        }
        taskDetailDTO.setServiceId(applicationDetailDTO.getServiceSlNo());
        taskDetailDTO.setCreatedBy(applicationDetailDTO.getCreatedBy());
        taskDetailDTO.setCreatedOn(applicationDetailDTO.getCreatedDate());
        TaskDetail taskDetail = convertTaskDetailDTOtoEntity(taskDetailDTO);
        this.commonDao.saveTaskDetail(taskDetail);
    }

    public ResponseMessage saveClaimTask(UserRolePrivilegeDto userBean, String applicationNo) {
        ResponseMessage responseMessage = new ResponseMessage();
        ApplicantDetailDTO applicantDetailDTO = new ApplicantDetailDTO();
        ApplicationDetailDTO applicationDetailDTO = this.commonDao.getApplicationDetail(applicationNo);
        SpouseDetailsDTO spouseDetailsDTO = new SpouseDetailsDTO();
        if (applicationDetailDTO == null) {
            responseMessage.setResponseStatus(Integer.valueOf(SystemDataInt.MESSAGE_STATUS_UNSUCCESSFUL.value()));
            responseMessage.setResponseText("Application information not found.");
            return responseMessage;
        }
        if (applicationDetailDTO.getStatusId() == "0") {
            responseMessage.setResponseStatus(Integer.valueOf(SystemDataInt.MESSAGE_STATUS_UNSUCCESSFUL.value()));
            responseMessage.setResponseText("Task already claimed/approved/rejected/unclaimed by someone. Please refresh the page to see the updated task.");
            return responseMessage;
        }
        applicationDetailDTO.setUpdatedBy(userBean.getUserType());
        applicationDetailDTO.setUpdateDate(new Date());
        applicationDetailDTO.setStatusId("2");
        ApplicationDetail applicationDetail = convertApplicationDTOtoEntity(applicationDetailDTO);
        this.commonDao.saveApplication(applicationDetail);
        WorkFlowDetailDTO workFlowDetailDTO = new WorkFlowDetailDTO();
        Integer workInstanceId = getWorkInstanceId();
        workFlowDetailDTO.setApplicationNo(applicationDetailDTO.getApplicationNo());
        workFlowDetailDTO.setServiceId(applicationDetailDTO.getServiceSlNo());
        workFlowDetailDTO.setApplicationStatusId(Integer.valueOf(2));
        workFlowDetailDTO.setCreatedBy(applicationDetailDTO.getCreatedBy());
        workFlowDetailDTO.setCreatedDate(applicationDetailDTO.getCreatedDate());
        workFlowDetailDTO.setUpdateBy(userBean.getUserType());
        workFlowDetailDTO.setUpdateDate(new Date());
        WorkFlowDetail workFlowDetail = convertWorkFlowDetailDTOtoEntity(workFlowDetailDTO);
        this.commonDao.saveWorkFlowDetail(workFlowDetail);
        TaskDetailDTO taskDetailDTO = new TaskDetailDTO();
        taskDetailDTO.setApplicationNo(applicationDetailDTO.getApplicationNo());
        taskDetailDTO.setApplicationStatus(Integer.valueOf(2));
        taskDetailDTO.setOwner(userBean.getUserType());
        taskDetailDTO.setWorkflowInstanceId(Integer.toString(workInstanceId.intValue()));
        taskDetailDTO.setServiceId(applicationDetailDTO.getServiceSlNo());
        taskDetailDTO.setCreatedBy(applicationDetailDTO.getCreatedBy());
        taskDetailDTO.setCreatedOn(applicationDetailDTO.getCreatedDate());
        taskDetailDTO.setModifiedBy(userBean.getUserType());
        taskDetailDTO.setModifiedOn(new Date());
        TaskDetail taskDetail = convertTaskDetailDTOtoEntity(taskDetailDTO);
        this.commonDao.saveTaskDetail(taskDetail);
        responseMessage.setResponseStatus(Integer.valueOf(SystemDataInt.MESSAGE_STATUS_SUCCESSFUL.value()));
        responseMessage.setResponseText("Claimed Successfully.");
        return responseMessage;
    }

    public ResponseMessage saveUnClaimTask(UserRolePrivilegeDto userBean, String applicationNo) {
        ResponseMessage responseMessage = new ResponseMessage();
        ApplicantDetailDTO applicantDetailDTO = new ApplicantDetailDTO();
        ApplicationDetailDTO applicationDetailDTO = new ApplicationDetailDTO();
        applicationDetailDTO.setApplicationYear(applicantDetailDTO.getApplicationYear());
        applicationDetailDTO = this.commonDao.getApplicationDetail(applicationNo);
        if (applicationDetailDTO == null) {
            responseMessage.setResponseStatus(Integer.valueOf(SystemDataInt.MESSAGE_STATUS_UNSUCCESSFUL.value()));
            responseMessage.setResponseText("Application information not found.");
            return responseMessage;
        }
        if (applicationDetailDTO.getStatusId() == "1") {
            responseMessage.setResponseStatus(Integer.valueOf(SystemDataInt.MESSAGE_STATUS_UNSUCCESSFUL.value()));
            responseMessage.setResponseText("Task already claimed/approved/rejected/unclaimed by someone. Please refresh the page to see the updated task.");
            return responseMessage;
        }
        applicationDetailDTO.setUpdatedBy(userBean.getUserType());
        applicationDetailDTO.setUpdateDate(new Date());
        applicationDetailDTO.setStatusId("1");
        ApplicationDetail applicationDetail = convertApplicationDTOtoEntity(applicationDetailDTO);
        this.commonDao.saveApplication(applicationDetail);
        WorkFlowDetailDTO workFlowDetailDTO = new WorkFlowDetailDTO();
        Integer workInstanceId = getWorkInstanceId();
        workFlowDetailDTO.setApplicationNo(applicationDetailDTO.getApplicationNo());
        workFlowDetailDTO.setApplicationStatusId(Integer.valueOf(1));
        workFlowDetailDTO.setCreatedBy(applicationDetailDTO.getCreatedBy());
        workFlowDetailDTO.setCreatedDate(applicationDetailDTO.getCreatedDate());
        workFlowDetailDTO.setUpdateBy(userBean.getUserType());
        workFlowDetailDTO.setUpdateDate(new Date());
        WorkFlowDetail workFlowDetail = convertWorkFlowDetailDTOtoEntity(workFlowDetailDTO);
        this.commonDao.saveWorkFlowDetail(workFlowDetail);
        TaskDetailDTO taskDetailDTO = new TaskDetailDTO();
        taskDetailDTO.setApplicationNo(applicationDetailDTO.getApplicationNo());
        taskDetailDTO.setApplicationStatus(Integer.valueOf(1));
        taskDetailDTO.setOwner(userBean.getUserType());
        taskDetailDTO.setWorkflowInstanceId(Integer.toString(workInstanceId.intValue()));
        taskDetailDTO.setCreatedBy(applicationDetailDTO.getCreatedBy());
        taskDetailDTO.setCreatedOn(applicationDetailDTO.getCreatedDate());
        taskDetailDTO.setModifiedBy(userBean.getUserType());
        taskDetailDTO.setModifiedOn(new Date());
        TaskDetail taskDetail = convertTaskDetailDTOtoEntity(taskDetailDTO);
        this.commonDao.saveTaskDetail(taskDetail);
        responseMessage.setResponseStatus(Integer.valueOf(SystemDataInt.MESSAGE_STATUS_SUCCESSFUL.value()));
        responseMessage.setResponseText("Claimed Successfully.");
        return responseMessage;
    }

    public ResponseMessage saveUpdateClaimTask(UserRolePrivilegeDto userBean, String applicationNo) {
        ResponseMessage responseMessage = new ResponseMessage();
        ApplicationDetailDTO applicationDetailDTO = this.commonDao.getApplicationDetail(applicationNo);
        if (applicationDetailDTO == null) {
            responseMessage.setResponseStatus(Integer.valueOf(SystemDataInt.MESSAGE_STATUS_UNSUCCESSFUL.value()));
            responseMessage.setResponseText("Application information not found.");
            return responseMessage;
        }
        if (applicationDetailDTO.getStatusId() == "7") {
            responseMessage.setResponseStatus(Integer.valueOf(SystemDataInt.MESSAGE_STATUS_UNSUCCESSFUL.value()));
            responseMessage.setResponseText("Task already claimed/approved/rejected/unclaimed by someone. Please refresh the page to see the updated task.");
            return responseMessage;
        }
        applicationDetailDTO.setUpdatedBy(userBean.getUserType());
        applicationDetailDTO.setUpdateDate(new Date());
        applicationDetailDTO.setStatusId("7");
        ApplicationDetail applicationDetail = convertApplicationDTOtoEntity(applicationDetailDTO);
        this.commonDao.saveApplication(applicationDetail);
        WorkFlowDetailDTO workFlowDetailDTO = new WorkFlowDetailDTO();
        Integer workInstanceId = getWorkInstanceId();
        workFlowDetailDTO.setApplicationNo(applicationDetailDTO.getApplicationNo());
        workFlowDetailDTO.setServiceId(applicationDetailDTO.getServiceSlNo());
        workFlowDetailDTO.setApplicationStatusId(Integer.valueOf(7));
        workFlowDetailDTO.setCreatedBy(applicationDetailDTO.getCreatedBy());
        workFlowDetailDTO.setCreatedDate(applicationDetailDTO.getCreatedDate());
        workFlowDetailDTO.setUpdateBy(userBean.getUserType());
        workFlowDetailDTO.setUpdateDate(new Date());
        WorkFlowDetail workFlowDetail = convertWorkFlowDetailDTOtoEntity(workFlowDetailDTO);
        this.commonDao.saveWorkFlowDetail(workFlowDetail);
        TaskDetailDTO taskDetailDTO = new TaskDetailDTO();
        taskDetailDTO.setApplicationNo(applicationDetailDTO.getApplicationNo());
        taskDetailDTO.setApplicationStatus(Integer.valueOf(7));
        taskDetailDTO.setOwner(userBean.getUserType());
        taskDetailDTO.setWorkflowInstanceId(Integer.toString(workInstanceId.intValue()));
        taskDetailDTO.setServiceId(applicationDetailDTO.getServiceSlNo());
        taskDetailDTO.setCreatedBy(applicationDetailDTO.getCreatedBy());
        taskDetailDTO.setCreatedOn(applicationDetailDTO.getCreatedDate());
        taskDetailDTO.setModifiedBy(userBean.getUserType());
        taskDetailDTO.setModifiedOn(new Date());
        TaskDetail taskDetail = convertTaskDetailDTOtoEntity(taskDetailDTO);
        this.commonDao.saveTaskDetail(taskDetail);
        responseMessage.setResponseStatus(Integer.valueOf(SystemDataInt.MESSAGE_STATUS_SUCCESSFUL.value()));
        responseMessage.setResponseText("Claimed Successfully.");
        return responseMessage;
    }

    public ResponseMessage saveUpdateUnClaimTask(UserRolePrivilegeDto userBean, String applicationNo) {
        ResponseMessage responseMessage = new ResponseMessage();
        ApplicationDetailDTO applicationDetailDTO = this.commonDao.getApplicationDetail(applicationNo);
        if (applicationDetailDTO == null) {
            responseMessage.setResponseStatus(Integer.valueOf(SystemDataInt.MESSAGE_STATUS_UNSUCCESSFUL.value()));
            responseMessage.setResponseText("Application information not found.");
            return responseMessage;
        }
        if (applicationDetailDTO.getStatusId() == "6") {
            responseMessage.setResponseStatus(Integer.valueOf(SystemDataInt.MESSAGE_STATUS_UNSUCCESSFUL.value()));
            responseMessage.setResponseText("Task already claimed/approved/rejected/unclaimed by someone. Please refresh the page to see the updated task.");
            return responseMessage;
        }
        applicationDetailDTO.setUpdatedBy(userBean.getUserType());
        applicationDetailDTO.setUpdateDate(new Date());
        applicationDetailDTO.setStatusId("6");
        ApplicationDetail applicationDetail = convertApplicationDTOtoEntity(applicationDetailDTO);
        this.commonDao.saveApplication(applicationDetail);
        WorkFlowDetailDTO workFlowDetailDTO = new WorkFlowDetailDTO();
        Integer workInstanceId = getWorkInstanceId();
        workFlowDetailDTO.setApplicationNo(applicationDetailDTO.getApplicationNo());
        workFlowDetailDTO.setApplicationStatusId(Integer.valueOf(6));
        workFlowDetailDTO.setCreatedBy(applicationDetailDTO.getCreatedBy());
        workFlowDetailDTO.setCreatedDate(applicationDetailDTO.getCreatedDate());
        workFlowDetailDTO.setUpdateBy(userBean.getUserType());
        workFlowDetailDTO.setUpdateDate(new Date());
        WorkFlowDetail workFlowDetail = convertWorkFlowDetailDTOtoEntity(workFlowDetailDTO);
        this.commonDao.saveWorkFlowDetail(workFlowDetail);
        TaskDetailDTO taskDetailDTO = new TaskDetailDTO();
        taskDetailDTO.setApplicationNo(applicationDetailDTO.getApplicationNo());
        taskDetailDTO.setApplicationStatus(Integer.valueOf(6));
        taskDetailDTO.setOwner(userBean.getUserType());
        taskDetailDTO.setWorkflowInstanceId(Integer.toString(workInstanceId.intValue()));
        taskDetailDTO.setCreatedBy(applicationDetailDTO.getCreatedBy());
        taskDetailDTO.setCreatedOn(applicationDetailDTO.getCreatedDate());
        taskDetailDTO.setModifiedBy(userBean.getUserType());
        taskDetailDTO.setModifiedOn(new Date());
        TaskDetail taskDetail = convertTaskDetailDTOtoEntity(taskDetailDTO);
        this.commonDao.saveTaskDetail(taskDetail);
        responseMessage.setResponseStatus(Integer.valueOf(SystemDataInt.MESSAGE_STATUS_SUCCESSFUL.value()));
        responseMessage.setResponseText("Claimed Successfully.");
        return responseMessage;
    }

    public ResponseMessage pushForOnlinePayment(String applicationNo, String courtId) {
        ApplicationDetailDTO applicationDetailDTO = new ApplicationDetailDTO();
        ResourceBundle bundle = ResourceBundle.getBundle("wsEndPointURL_en_US");
        InvokePaymentWS invokews = new InvokePaymentWS(bundle.getString("getPayment.endPointURL"));
        String getPaymentAgencyCode = bundle.getString("getPaymentAgencyCode.endPointURL");
        String serviceId = applicationNo.substring(0, 3);
        applicationDetailDTO = this.commonDao.getPaymentDetails(serviceId);
        RequestDTO requestDTO = new RequestDTO();
        requestDTO.setApplicationNo(applicationNo);
        requestDTO.setAgencyCode(getPaymentAgencyCode);
        requestDTO.setServiceName(applicationDetailDTO.getServiceName());
        requestDTO.setExpiryDate(null);
        ArrayList<PaymentDTO> paymentList = new ArrayList<>();
        PaymentDTO paymentdto = new PaymentDTO();
        paymentdto.setServiceFee(applicationDetailDTO.getApplicationFees());
        paymentdto.setAccountHeadId(applicationDetailDTO.getAccountHeadCode());
        paymentList.add(paymentdto);
        requestDTO.setPaymentList(paymentList.<PaymentDTO>toArray(new PaymentDTO[paymentList.size()]));
        boolean isSaved = invokews.insertPaymentDetailsOnApproval(requestDTO);
        System.out.println("Response from Aggregator: " + isSaved);
        return null;
    }

    public ResponseMessage approveApplication(UserRolePrivilegeDto userBean, String applicationNo, String remarks, String rejectReasonId) {
        ResponseMessage responseMessage = new ResponseMessage();
        ApplicationDetailDTO applicationDetailDTO = this.commonDao.getApplicationDetail(applicationNo);
        Integer courtId = applicationDetailDTO.getCourtId();
        String courtName = this.commonDao.getCourtName(Integer.toString(courtId.intValue()));
        if (applicationDetailDTO == null) {
            responseMessage.setResponseStatus(Integer.valueOf(SystemDataInt.MESSAGE_STATUS_UNSUCCESSFUL.value()));
            responseMessage.setResponseText("Application information not found.");
            return responseMessage;
        }
        if (applicationDetailDTO.getStatusId() == "2") {
            responseMessage.setResponseStatus(Integer.valueOf(SystemDataInt.MESSAGE_STATUS_UNSUCCESSFUL.value()));
            responseMessage.setResponseText("Task already claimed/approved/rejected/unclaimed by someone. Please refresh the page to see the updated task.");
            return responseMessage;
        }
        applicationDetailDTO.setApplicationNo(applicationNo);
        applicationDetailDTO.setUpdatedBy(userBean.getUserType());
        applicationDetailDTO.setUpdateDate(new Date());
        applicationDetailDTO.setRemarks(remarks);
        applicationDetailDTO.setStatusId("3");
        ApplicationDetail applicationDetail = convertApplicationDTOtoEntity(applicationDetailDTO);
        this.commonDao.saveApplication(applicationDetail);
        WorkFlowDetailDTO workFlowDetailDTO = new WorkFlowDetailDTO();
        Integer workInstanceId = getWorkInstanceId();
        workFlowDetailDTO.setApplicationNo(applicationDetailDTO.getApplicationNo());
        workFlowDetailDTO.setServiceId(applicationDetailDTO.getServiceSlNo());
        workFlowDetailDTO.setApplicationStatusId(Integer.valueOf(3));
        workFlowDetailDTO.setCreatedBy(applicationDetailDTO.getCreatedBy());
        workFlowDetailDTO.setCreatedDate(applicationDetailDTO.getCreatedDate());
        workFlowDetailDTO.setUpdateBy(userBean.getUserType());
        workFlowDetailDTO.setUpdateDate(new Date());
        WorkFlowDetail workFlowDetail = convertWorkFlowDetailDTOtoEntity(workFlowDetailDTO);
        this.commonDao.saveWorkFlowDetail(workFlowDetail);
        TaskDetailDTO taskDetailDTO = new TaskDetailDTO();
        taskDetailDTO.setApplicationNo(applicationDetailDTO.getApplicationNo());
        taskDetailDTO.setServiceId(applicationDetailDTO.getServiceSlNo());
        taskDetailDTO.setApplicationStatus(Integer.valueOf(3));
        taskDetailDTO.setOwner(userBean.getUserType());
        taskDetailDTO.setWorkflowInstanceId(Integer.toString(workInstanceId.intValue()));
        taskDetailDTO.setCreatedBy(applicationDetailDTO.getCreatedBy());
        taskDetailDTO.setCreatedOn(applicationDetailDTO.getCreatedDate());
        taskDetailDTO.setModifiedBy(userBean.getUserType());
        taskDetailDTO.setModifiedOn(new Date());
        TaskDetail taskDetail = convertTaskDetailDTOtoEntity(taskDetailDTO);
        this.commonDao.saveTaskDetail(taskDetail);
        responseMessage.setResponseStatus(Integer.valueOf(SystemDataInt.MESSAGE_STATUS_APPROVAL.value()));
        responseMessage.setResponseText("Verified Successfully.");
        responseMessage.setCourtName(courtName);
        responseMessage.setMobileNo(applicationDetailDTO.getMobileNo());
        return responseMessage;
    }

    private ApplicationDetail convertApplicationDTOtoEntity(ApplicationDetailDTO applicationDetailDTO) {
        ApplicationDetail applicationDetail = new ApplicationDetail();
        applicationDetail.setApplicationNo(applicationDetailDTO.getApplicationNo());
        applicationDetail.setServiceSlNo(applicationDetailDTO.getServiceSlNo());
        applicationDetail.setLetterNo(applicationDetailDTO.getLetterNo());
        applicationDetail.setLetterDate(applicationDetailDTO.getLetterDate());
        applicationDetail.setIncorrectType(applicationDetailDTO.getIncorrectType());
        applicationDetail.setApplicationYear(applicationDetailDTO.getApplicationYear());
        applicationDetail.setReject_Reason(applicationDetailDTO.getReject_Reason());
        if (applicationDetailDTO.getIncorrectType() != null)
            if (applicationDetailDTO.getIncorrectType().intValue() == 1) {
                applicationDetail.setIncorrectName(applicationDetailDTO.getIncorrectName());
                applicationDetail.setIncorrectDate(null);
                applicationDetail.setIncorrectCidNo(null);
                applicationDetail.setIncorrectDzongkhagName(null);
                applicationDetail.setIncorrectGewogName(null);
                applicationDetail.setIncorrectVillageName(null);
                applicationDetail.setIncorrectOthers(null);
            } else if (applicationDetailDTO.getIncorrectType().intValue() == 2) {
                applicationDetail.setIncorrectName(null);
                applicationDetail.setIncorrectDate(applicationDetailDTO.getIncorrectDate());
                applicationDetail.setIncorrectCidNo(null);
                applicationDetail.setIncorrectDzongkhagName(null);
                applicationDetail.setIncorrectGewogName(null);
                applicationDetail.setIncorrectVillageName(null);
                applicationDetail.setIncorrectOthers(null);
            } else if (applicationDetailDTO.getIncorrectType().intValue() == 3) {
                applicationDetail.setIncorrectName(null);
                applicationDetail.setIncorrectDate(null);
                applicationDetail.setIncorrectCidNo(applicationDetailDTO.getIncorrectCidNo());
                applicationDetail.setIncorrectDzongkhagName(null);
                applicationDetail.setIncorrectGewogName(null);
                applicationDetail.setIncorrectVillageName(null);
                applicationDetail.setIncorrectOthers(null);
            } else if (applicationDetailDTO.getIncorrectType().intValue() == 4) {
                applicationDetail.setIncorrectName(null);
                applicationDetail.setIncorrectDate(null);
                applicationDetail.setIncorrectCidNo(null);
                applicationDetail.setIncorrectDzongkhagName(applicationDetailDTO.getIncorrectDzongkhagName());
                applicationDetail.setIncorrectGewogName(applicationDetailDTO.getIncorrectGewogName());
                applicationDetail.setIncorrectVillageName(applicationDetailDTO.getIncorrectVillageName());
                applicationDetail.setIncorrectOthers(null);
            } else {
                applicationDetail.setIncorrectName(null);
                applicationDetail.setIncorrectDate(null);
                applicationDetail.setIncorrectCidNo(null);
                applicationDetail.setIncorrectDzongkhagName(null);
                applicationDetail.setIncorrectGewogName(null);
                applicationDetail.setIncorrectVillageName(null);
                applicationDetail.setIncorrectOthers(applicationDetailDTO.getIncorrectOthers());
            }
        applicationDetail.setMcNo(applicationDetailDTO.getMcNo());
        applicationDetail.setCmcNo(applicationDetailDTO.getCmcNo());
        applicationDetail.setHospitalName(applicationDetailDTO.getHospitalName());
        applicationDetail.setRelationship(applicationDetailDTO.getRelationship());
        applicationDetail.setDocName(applicationDetailDTO.getDocName());
        applicationDetail.setLostDocType(applicationDetailDTO.getLostDocType());
        applicationDetail.setCourtId(applicationDetailDTO.getCourtId());
        applicationDetail.setAppoinmentDate(applicationDetailDTO.getAppoinmentDate());
        applicationDetail.setStatusId(applicationDetailDTO.getStatusId());
        applicationDetail.setReason(applicationDetailDTO.getReason());
        applicationDetail.setCreatedBy(applicationDetailDTO.getCreatedBy());
        applicationDetail.setCreatedDate(applicationDetailDTO.getCreatedDate());
        applicationDetail.setCaseNo(applicationDetailDTO.getCaseNo());
        applicationDetail.setJudgementNo(applicationDetailDTO.getJudgementNo());
        applicationDetail.setJudgementDate(applicationDetailDTO.getJudgementDate());
        applicationDetail.setClerk(applicationDetailDTO.getClerk());
        applicationDetail.setLawyer(applicationDetailDTO.getLawyer());
        applicationDetail.setReceiptNo(applicationDetailDTO.getReceiptNo());
        applicationDetail.setReceiptDate(applicationDetailDTO.getReceiptDate());
        applicationDetail.setReceiptAmount(applicationDetailDTO.getReceiptAmount());
        applicationDetail.setUpdatedBy(applicationDetailDTO.getUpdatedBy());
        applicationDetail.setPrintStatus(applicationDetailDTO.getPrintStatus());
        applicationDetail.setPaymentCleared(applicationDetailDTO.getPaymentCleared());
        applicationDetail.setUpdateDate(applicationDetailDTO.getUpdateDate());
        applicationDetail.setRemarks(applicationDetailDTO.getRemarks());
        applicationDetail.setExamYear(applicationDetailDTO.getExamYear());
        applicationDetail.setKuenselDate(applicationDetailDTO.getKuenselDate());
        applicationDetail.setIndexNo(applicationDetailDTO.getIndexNo());
        applicationDetail.setClassType(applicationDetailDTO.getClassType());
        applicationDetail.setTravelReason(applicationDetailDTO.getTravelReason());
        applicationDetail.setChildPassportNo(applicationDetailDTO.getChildPassportNo());
        applicationDetail.setAppPassportNo(applicationDetailDTO.getAppPassportNo());
        applicationDetail.setRegNo(applicationDetailDTO.getRegNo());
        applicationDetail.setRegDate(applicationDetailDTO.getRegDate());
        return applicationDetail;
    }

    private ApplicantDetail convertApplicantDTOtoEntity(ApplicantDetailDTO applicantDetailDTO) throws ParseException {
        ApplicantDetail applicantDetail = new ApplicantDetail();
        applicantDetail.setApplicationNo(applicantDetailDTO.getApplicationNo());
        applicantDetail.setCid(applicantDetailDTO.getCidNo());
        applicantDetail.setName(applicantDetailDTO.getApplicantName());
        applicantDetail.setDob(applicantDetailDTO.getApplicantDob());
        applicantDetail.setGender(applicantDetailDTO.getGender());
        applicantDetail.setMobileNo(applicantDetailDTO.getMobileNo());
        applicantDetail.setEmailId(applicantDetailDTO.getEmail());
        applicantDetail.setFatherName(applicantDetailDTO.getFatherName());
        applicantDetail.setMotherName(applicantDetailDTO.getMotherName());
        applicantDetail.setTharmNo(applicantDetailDTO.getTharmNo());
        applicantDetail.setHouseNo(applicantDetailDTO.getHouseNo());
        applicantDetail.setVillageId(applicantDetailDTO.getVillageId());
        applicantDetail.setGewogId(applicantDetailDTO.getGewogId());
        applicantDetail.setDzongkhagId(applicantDetailDTO.getDzongkhagId());
        applicantDetail.setAddress(applicantDetailDTO.getAddress());
        applicantDetail.setNationality(applicantDetailDTO.getNationality());
        applicantDetail.setReligion(applicantDetailDTO.getReligion());
        applicantDetail.setMarital_Status(applicantDetailDTO.getMarital_Status());
        return applicantDetail;
    }

    private SpouseDetail convertSpouseDTOtoEntity(SpouseDetailsDTO spouseDetailsDTO) throws ParseException {
        SpouseDetail spouseDetail = new SpouseDetail();
        formatDate(spouseDetailsDTO.getSpouseApplicantDob());
        spouseDetail.setApplicationNo(spouseDetailsDTO.getApplicationNo());
        spouseDetail.setCid(spouseDetailsDTO.getSpouseCidNo());
        spouseDetail.setName(spouseDetailsDTO.getSpouseName());
        spouseDetail.setDob(spouseDetailsDTO.getSpouseApplicantDob());
        spouseDetail.setGender(spouseDetailsDTO.getSpouseGender());
        spouseDetail.setFatherName(spouseDetailsDTO.getSpouseFathersName());
        spouseDetail.setMotherName(spouseDetailsDTO.getSpouseMothersName());
        spouseDetail.setTharmNo(spouseDetailsDTO.getSpouseTharmNo());
        spouseDetail.setHouseNo(spouseDetailsDTO.getSpouseHouseNo());
        spouseDetail.setVillageId(spouseDetailsDTO.getSpouseVillageId());
        spouseDetail.setGewogId(spouseDetailsDTO.getSpouseGewogId());
        spouseDetail.setDzongkhagId(spouseDetailsDTO.getSpouseDzongkhagId());
        spouseDetail.setNationality(spouseDetailsDTO.getSpouseNationality());
        spouseDetail.setReligion(spouseDetailsDTO.getSpouseReligion());
        spouseDetail.setMarital_Status_Id(spouseDetailsDTO.getMarital_Status_Id());
        return spouseDetail;
    }

    private PatientDetail convertPatientDetailTOEntity(ApplicationDetailDTO applicationDetailDTO) throws ParseException {
        PatientDetail patientDetail = new PatientDetail();
        patientDetail.setApplicationNo(applicationDetailDTO.getApplicationNo());
        patientDetail.setPatientName(applicationDetailDTO.getPatientName());
        patientDetail.setPatientCid(applicationDetailDTO.getPatientCid());
        patientDetail.setPatientDob(applicationDetailDTO.getPatientDob());
        patientDetail.setPatientGender(applicationDetailDTO.getPatientGender());
        patientDetail.setPatientFathersName(applicationDetailDTO.getPatientFathersName());
        patientDetail.setPatientDzongkhagId(applicationDetailDTO.getPatientDzongkhagId());
        patientDetail.setPatientGewogId(applicationDetailDTO.getPatientGewogId());
        patientDetail.setPatientVillageId(applicationDetailDTO.getPatientVillageId());
        patientDetail.setPatientDonorRelationship(applicationDetailDTO.getPatientDonorRelationship());
        return patientDetail;
    }

    private DonorDetail convertDonorDetailTOEntity(ApplicationDetailDTO applicationDetailDTO) {
        DonorDetail donorDetail = new DonorDetail();
        donorDetail.setApplicationNo(applicationDetailDTO.getApplicationNo());
        donorDetail.setDonorName(applicationDetailDTO.getDonorName());
        donorDetail.setDonorCid(applicationDetailDTO.getDonorCid());
        donorDetail.setDonorDob(applicationDetailDTO.getDonorDob());
        donorDetail.setDonorGender(applicationDetailDTO.getDonorGender());
        donorDetail.setDonorFathersName(applicationDetailDTO.getDonorFathersName());
        donorDetail.setDonorDzongkhagId(applicationDetailDTO.getDonorDzongkhagId());
        donorDetail.setDonorGewogId(applicationDetailDTO.getDonorGewogId());
        donorDetail.setDonorVillageId(applicationDetailDTO.getDonorVillageId());
        donorDetail.setDonorPatientRelationship(applicationDetailDTO.getPatientDonorRelationship());
        donorDetail.setDonorDepRelationship(applicationDetailDTO.getDonorDepRelationship());
        return donorDetail;
    }

    private TransferorDetail convertTransferorDetailTOEntity(ApplicationDetailDTO applicationDetailDTO) {
        TransferorDetail transferorDetail = new TransferorDetail();
        transferorDetail.setApplicationNo(applicationDetailDTO.getApplicationNo());
        transferorDetail.setTransferorApplicantCid(applicationDetailDTO.getTransferorApplicantCid());
        transferorDetail.setTransferorApplicantName(applicationDetailDTO.getTransferorApplicantName());
        transferorDetail.setTransferorApplicantDob(applicationDetailDTO.getTransferorApplicantDob());
        transferorDetail.setTransferorDzongkhagId(applicationDetailDTO.getTransferorDzongkhagId());
        transferorDetail.setTransferorGewogId(applicationDetailDTO.getTransferorGewogId());
        transferorDetail.setTransferorGender(applicationDetailDTO.getTransferorGender());
        transferorDetail.setTransferorVillageId(applicationDetailDTO.getTransferorVillageId());
        transferorDetail.setTransferorHouseNo(applicationDetailDTO.getTransferorHouseNo());
        transferorDetail.setTransferorTharmNo(applicationDetailDTO.getTransferorHouseNo());
        transferorDetail.setBankName(applicationDetailDTO.getBankName());
        transferorDetail.setAccNo(applicationDetailDTO.getAccNo());
        return transferorDetail;
    }

    private DependentDetail convertDependentDetailTOEntity(ApplicationDetailDTO applicationDetailDTO) {
        DependentDetail dependentDetail = new DependentDetail();
        dependentDetail.setApplicationNo(applicationDetailDTO.getApplicationNo());
        dependentDetail.setDonorDepName(applicationDetailDTO.getDonorDepName());
        dependentDetail.setDonorDepCid(applicationDetailDTO.getDonorDepCid());
        dependentDetail.setDonorDepDob(applicationDetailDTO.getDonorDepDob());
        dependentDetail.setDonorDepGender(applicationDetailDTO.getDonorDepGender());
        dependentDetail.setDonorDepFathersName(applicationDetailDTO.getDonorDepFathersName());
        dependentDetail.setDonorDepDzongkhagId(applicationDetailDTO.getDonorDepDzongkhagId());
        dependentDetail.setDonorDepGewogId(applicationDetailDTO.getDonorDepGewogId());
        dependentDetail.setDonorDepVillageId(applicationDetailDTO.getDonorDepVillageId());
        dependentDetail.setDepRelationship(applicationDetailDTO.getDepRelationship());
        return dependentDetail;
    }

    private ChildTravelDetail convertChildTravelDetailTOEntity(ApplicationDetailDTO applicationDetailDTO) {
        ChildTravelDetail childTravelDetail = new ChildTravelDetail();
        childTravelDetail.setApplicationNo(applicationDetailDTO.getApplicationNo());
        childTravelDetail.setChildName(applicationDetailDTO.getChildName());
        childTravelDetail.setChildDob(applicationDetailDTO.getChildDob());
        childTravelDetail.setChildGender(applicationDetailDTO.getChildGender());
        childTravelDetail.setTravelPlace(applicationDetailDTO.getTravelPlace());
        childTravelDetail.setOrgFatherCid(applicationDetailDTO.getOrgFatherCid());
        childTravelDetail.setOrgFatherName(applicationDetailDTO.getOrgFatherName());
        childTravelDetail.setOrgFatherDzongkhagId(applicationDetailDTO.getOrgFatherDzongkhagId());
        childTravelDetail.setOrgFatherGewogId(applicationDetailDTO.getOrgFatherGewogId());
        childTravelDetail.setOrgFatherVillageId(applicationDetailDTO.getOrgFatherVillageId());
        childTravelDetail.setOrgFatherHouseNo(applicationDetailDTO.getOrgFatherHouseNo());
        childTravelDetail.setOrgFatherTharmNo(applicationDetailDTO.getOrgFatherTharmNo());
        childTravelDetail.setOrgMotherCid(applicationDetailDTO.getOrgMotherCid());
        childTravelDetail.setOrgMotherName(applicationDetailDTO.getOrgMotherName());
        childTravelDetail.setOrgMotherDzongkhagId(applicationDetailDTO.getOrgMotherDzongkhagId());
        childTravelDetail.setOrgMotherGewogId(applicationDetailDTO.getOrgMotherGewogId());
        childTravelDetail.setOrgMotherVillageId(applicationDetailDTO.getOrgMotherVillageId());
        childTravelDetail.setOrgMotherHouseNo(applicationDetailDTO.getOrgMotherHouseNo());
        childTravelDetail.setOrgMotherTharmNo(applicationDetailDTO.getOrgMotherTharmNo());
        if (applicationDetailDTO.getRelationship() == null) {
            childTravelDetail.setRelationship(Integer.valueOf(0));
        } else {
            childTravelDetail.setRelationship(Integer.valueOf(applicationDetailDTO.getRelationship()));
        }
        return childTravelDetail;
    }

    private WitnessDetail convertWitnessDTOtoEntity(WitnessDetailDTO witnessDetailDTO) {
        WitnessDetail witnessDetail = new WitnessDetail();
        witnessDetail.setApplicationNo(witnessDetailDTO.getApplicationNo());
        witnessDetail.setCid(witnessDetailDTO.getWitness1CidNo());
        witnessDetail.setName(witnessDetailDTO.getWitness1Name());
        witnessDetail.setDob(witnessDetailDTO.getW1Dob());
        witnessDetail.setGender(witnessDetailDTO.getW1Gender());
        witnessDetail.setFatherName(witnessDetailDTO.getW1fathersName());
        witnessDetail.setDzongkhagId(witnessDetailDTO.getW1dzongkhagId());
        witnessDetail.setGewogId(witnessDetailDTO.getW1gewogId());
        witnessDetail.setVillageId(witnessDetailDTO.getW1villageId());
        witnessDetail.setAddress(witnessDetailDTO.getAddress());
        witnessDetail.setWitnessTypeId(witnessDetailDTO.getWitnessTypeId());
        return witnessDetail;
    }

    private WitnessDetail convertWitness1DTOtoEntity(WitnessDetailDTO witnessDetailDTO) {
        WitnessDetail witnessDetail = new WitnessDetail();
        witnessDetail.setApplicationNo(witnessDetailDTO.getApplicationNo());
        witnessDetail.setCid(witnessDetailDTO.getWitness2CidNo());
        witnessDetail.setName(witnessDetailDTO.getWitness2Name());
        witnessDetail.setDob(witnessDetailDTO.getW2Dob());
        witnessDetail.setGender(witnessDetailDTO.getW2gender());
        witnessDetail.setFatherName(witnessDetailDTO.getW2fathersName());
        witnessDetail.setDzongkhagId(witnessDetailDTO.getW2dzongkhagId());
        witnessDetail.setGewogId(witnessDetailDTO.getW2gewogId());
        witnessDetail.setVillageId(witnessDetailDTO.getW2villageId());
        witnessDetail.setAddress(witnessDetailDTO.getAddress());
        witnessDetail.setWitnessTypeId(witnessDetailDTO.getWitnessTypeId());
        return witnessDetail;
    }

    public ResponseMessage updatePaymentDetail(UserRolePrivilegeDto userBean, PaymentDetailDTO paymentDetailDTO) {
        ResponseMessage responseMessage = new ResponseMessage();
        Calendar calendar = Calendar.getInstance();
        Integer currentYear = Integer.valueOf(calendar.get(1));
        String applicationYear = currentYear.toString().substring(2, 4);
        ApplicationDetailDTO applicationDetailDTO = this.commonDao.getApplicationDetail(paymentDetailDTO.getApplicationNo());
        if (applicationDetailDTO == null) {
            responseMessage.setResponseStatus(Integer.valueOf(SystemDataInt.MESSAGE_STATUS_UNSUCCESSFUL.value()));
            responseMessage.setResponseText("Application information not found.");
            return responseMessage;
        }
        if (applicationDetailDTO.getStatusId() == "6") {
            responseMessage.setResponseStatus(Integer.valueOf(SystemDataInt.MESSAGE_STATUS_UNSUCCESSFUL.value()));
            responseMessage.setResponseText("Payment detail already updated for application no " + applicationDetailDTO.getApplicationNo());
            return responseMessage;
        }
        applicationDetailDTO.setUpdatedBy(userBean.getUserType());
        applicationDetailDTO.setUpdateDate(new Date());
        applicationDetailDTO.setReceiptDate(paymentDetailDTO.getDepositDate());
        applicationDetailDTO.setReceiptNo(paymentDetailDTO.getReceiptNo());
        applicationDetailDTO.setReceiptAmount(paymentDetailDTO.getReceiptAmount());
        applicationDetailDTO.setPaymentCleared("Y");
        applicationDetailDTO.setStatusId("6");
        applicationDetailDTO.setIncorrectDate(null);
        ApplicationDetail applicationDetail = convertApplicationDTOtoEntity(applicationDetailDTO);
        this.commonDao.saveApplication(applicationDetail);
        WorkFlowDetailDTO workFlowDetailDTO = new WorkFlowDetailDTO();
        Integer workInstanceId = getWorkInstanceId();
        workFlowDetailDTO.setApplicationNo(applicationDetailDTO.getApplicationNo());
        workFlowDetailDTO.setApplicationStatusId(Integer.valueOf(6));
        workFlowDetailDTO.setCreatedBy(applicationDetailDTO.getCreatedBy());
        workFlowDetailDTO.setCreatedDate(applicationDetailDTO.getCreatedDate());
        workFlowDetailDTO.setUpdateBy(userBean.getUserType());
        workFlowDetailDTO.setUpdateDate(new Date());
        WorkFlowDetail workFlowDetail = convertWorkFlowDetailDTOtoEntity(workFlowDetailDTO);
        this.commonDao.saveWorkFlowDetail(workFlowDetail);
        TaskDetailDTO taskDetailDTO = new TaskDetailDTO();
        taskDetailDTO.setApplicationNo(applicationDetailDTO.getApplicationNo());
        taskDetailDTO.setApplicationStatus(Integer.valueOf(6));
        taskDetailDTO.setOwner(userBean.getUserType());
        taskDetailDTO.setWorkflowInstanceId(Integer.toString(workInstanceId.intValue()));
        taskDetailDTO.setCreatedBy(applicationDetailDTO.getCreatedBy());
        taskDetailDTO.setCreatedOn(applicationDetailDTO.getCreatedDate());
        taskDetailDTO.setModifiedBy(userBean.getUserType());
        taskDetailDTO.setModifiedOn(new Date());
        TaskDetail taskDetail = convertTaskDetailDTOtoEntity(taskDetailDTO);
        this.commonDao.saveTaskDetail(taskDetail);
        responseMessage.setResponseStatus(Integer.valueOf(SystemDataInt.MESSAGE_STATUS_SUCCESSFUL.value()));
        return responseMessage;
    }

    public ResponseMessage updatePrintStatus(UserRolePrivilegeDto userBean, String applicationNo) {
        ResponseMessage responseMessage = new ResponseMessage();
        Calendar calendar = Calendar.getInstance();
        Integer currentYear = Integer.valueOf(calendar.get(1));
        String applicationYear = currentYear.toString().substring(2, 4);
        ApplicationDetailDTO applicationDetailDTO = this.commonDao.getApplicationDetail(applicationNo);
        if (applicationDetailDTO == null) {
            responseMessage.setResponseStatus(Integer.valueOf(SystemDataInt.MESSAGE_STATUS_UNSUCCESSFUL.value()));
            responseMessage.setResponseText("Application information not found.");
            return responseMessage;
        }
        applicationDetailDTO.setUpdatedBy(userBean.getUserType());
        applicationDetailDTO.setUpdateDate(new Date());
        applicationDetailDTO.setStatusId("6");
        applicationDetailDTO.setPrintStatus("Y");
        ApplicationDetail applicationDetail = convertApplicationDTOtoEntity(applicationDetailDTO);
        this.commonDao.saveApplication(applicationDetail);
        this.commonDao.updatePrintStatus(applicationNo);
        WorkFlowDetailDTO workFlowDetailDTO = new WorkFlowDetailDTO();
        Integer workInstanceId = getWorkInstanceId();
        workFlowDetailDTO.setApplicationNo(applicationDetailDTO.getApplicationNo());
        workFlowDetailDTO.setApplicationStatusId(Integer.valueOf(6));
        workFlowDetailDTO.setApplicationStatusId(Integer.valueOf(5));
        workFlowDetailDTO.setCreatedBy(applicationDetailDTO.getCreatedBy());
        workFlowDetailDTO.setCreatedDate(applicationDetailDTO.getCreatedDate());
        workFlowDetailDTO.setUpdateBy(userBean.getUserType());
        workFlowDetailDTO.setUpdateDate(new Date());
        WorkFlowDetail workFlowDetail = convertWorkFlowDetailDTOtoEntity(workFlowDetailDTO);
        this.commonDao.saveWorkFlowDetail(workFlowDetail);
        TaskDetailDTO taskDetailDTO = new TaskDetailDTO();
        taskDetailDTO.setApplicationNo(applicationDetailDTO.getApplicationNo());
        taskDetailDTO.setApplicationStatus(Integer.valueOf(6));
        taskDetailDTO.setApplicationStatus(Integer.valueOf(6));
        taskDetailDTO.setOwner(userBean.getUserType());
        taskDetailDTO.setWorkflowInstanceId(Integer.toString(workInstanceId.intValue()));
        taskDetailDTO.setCreatedBy(applicationDetailDTO.getCreatedBy());
        taskDetailDTO.setCreatedOn(applicationDetailDTO.getCreatedDate());
        taskDetailDTO.setModifiedBy(userBean.getUserType());
        taskDetailDTO.setModifiedOn(new Date());
        TaskDetail taskDetail = convertTaskDetailDTOtoEntity(taskDetailDTO);
        this.commonDao.saveTaskDetail(taskDetail);
        responseMessage.setResponseStatus(Integer.valueOf(SystemDataInt.MESSAGE_STATUS_SUCCESSFUL.value()));
        return responseMessage;
    }

    public ResponseMessage getApplicationDetail(String applicationNo) {
        ResponseMessage responseMessage = new ResponseMessage();
        try {
            ApplicantDetailDTO applicantDetailDTO = new ApplicantDetailDTO();
            applicantDetailDTO = this.commonDao.getApplicantDetail(applicationNo);
            ApplicationDetailDTO applicationDetailDTO = this.commonDao.getApplicationDetail(applicationNo);
            SpouseDetailsDTO spouseDetailsDTO = this.commonDao.getSpouseDetail(applicationNo);
            ChildMCDTO childMCDTO = this.commonDao.getChildDetail(applicationNo);
            ChildTravelDetailDTO childTravelDetailDTO = this.commonDao.getChildTravelDetail(applicationNo);
            WitnessDetailDTO witnessDetailDTO = this.commonDao.getWitnessDetail(applicationNo);
            WitnessDetailDTO witnessDetailDTO2 = this.commonDao.getWitnessDetail2(applicationNo);
            DonorDTO donorDTO = this.commonDao.getDonorDetail(applicationNo);
            DonorDepDTO donorDepDTO = this.commonDao.getDonorDepDetail(applicationNo);
            OrgFatherDTO orgFatherDTO = this.commonDao.getOrgFatherDetail(applicationNo);
            OrgMotherDTO orgMotherDTO = this.commonDao.getOrgMotherDetail(applicationNo);
            PatientDTO patientDTO = this.commonDao.getPatientDetail(applicationNo);
            TransferorDTO transferorDTO = this.commonDao.getTransferorDetail(applicationNo);
            if (applicationDetailDTO != null) {
                responseMessage.setResponseStatus(Integer.valueOf(SystemDataInt.MESSAGE_STATUS_SUCCESSFUL.value()));
                responseMessage.setResponseDTO(applicationDetailDTO);
                responseMessage.setApplicantDTO(applicantDetailDTO);
                responseMessage.setSpouseDTO(spouseDetailsDTO);
                responseMessage.setWitness1DTO(applicantDetailDTO.getApplicantName());
                responseMessage.setChildDTO(childMCDTO);
                responseMessage.setWitness1DTO(witnessDetailDTO);
                responseMessage.setWitness2DTO(witnessDetailDTO2);
                responseMessage.setDonorDTO(donorDTO);
                responseMessage.setDonorDepDTO(donorDepDTO);
                responseMessage.setFatherDTO(orgFatherDTO);
                responseMessage.setMotherDTO(orgMotherDTO);
                responseMessage.setPatientDTO(patientDTO);
                responseMessage.setTransferorDTO(transferorDTO);
                responseMessage.setChildTravelDetailDTO(childTravelDetailDTO);
                responseMessage.setGender(applicantDetailDTO.getGender());
                responseMessage.setApplicantName(applicantDetailDTO.getApplicantName());
                responseMessage.setApplicantDobh(applicantDetailDTO.getApplicantDobBh());
                responseMessage.setNationality(applicantDetailDTO.getNationality());
                responseMessage.setCensusFormNo(applicantDetailDTO.getCensusFormNo());
                responseMessage.setCidNo(applicantDetailDTO.getCidNo());
                responseMessage.setFatherName(applicantDetailDTO.getFatherName());
                responseMessage.setMotherName(applicantDetailDTO.getMotherName());
                responseMessage.setTharmNo(applicantDetailDTO.getTharmNo());
                responseMessage.setHouseNo(applicantDetailDTO.getHouseNo());
                responseMessage.setDzongkhagName(applicantDetailDTO.getDzongkhagNameBh());
                responseMessage.setGewogName(applicantDetailDTO.getGewogNameBh());
                responseMessage.setVillageName(applicantDetailDTO.getVillageNameBh());
                responseMessage.setReceipt_Amount(applicationDetailDTO.getReceiptAmount());
                responseMessage.setReceipt_No(applicationDetailDTO.getReceiptNo());
                responseMessage.setReceiptDate(applicationDetailDTO.getReceiptDate());
                responseMessage.setServiceName(applicationDetailDTO.getServiceName());
                responseMessage.setIncorrectType(applicationDetailDTO.getIncorrectType());
                    responseMessage.setSpouseApplicantDobBh(spouseDetailsDTO.getSpouseApplicantDobBh());
                  responseMessage.setSpouseName(spouseDetailsDTO.getSpouseName());
                    responseMessage.setSpouseNationality(spouseDetailsDTO.getSpouseNationality());
                    responseMessage.setSpouseCensusFormNo(spouseDetailsDTO.getSpouseCensusFormNo());
                    responseMessage.setSpouseCidNo(spouseDetailsDTO.getSpouseCidNo());
                    responseMessage.setSpouseFathersName(spouseDetailsDTO.getSpouseFathersName());
                    responseMessage.setSpouseMothersName(spouseDetailsDTO.getSpouseMothersName());
                    responseMessage.setSpouseTharmNo(spouseDetailsDTO.getSpouseTharmNo());
                    responseMessage.setSpouseHouseNo(spouseDetailsDTO.getSpouseHouseNo());
                    responseMessage.setSpouseDzongkhagNameBh(spouseDetailsDTO.getSpouseDzongkhagNameBh());
                    responseMessage.setSpouseGewogNameBh(spouseDetailsDTO.getSpouseGewogNameBh());
                    responseMessage.setSpouseVillageNameBh(spouseDetailsDTO.getSpouseVillageNameBh());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
           return responseMessage;
    }

    public ResponseMessage getApplicationDetails(String applicationNo) {
        ResponseMessage responseMessage = new ResponseMessage();
        try {
            ApplicantDetailDTO applicantDetailDTO = new ApplicantDetailDTO();
            applicantDetailDTO = this.commonDao.getApplicantDetail(applicationNo);
            ApplicationDetailDTO applicationDetailDTO = this.commonDao.getApplicationDetail(applicationNo);
            SpouseDetailsDTO spouseDetailsDTO = this.commonDao.getSpouseDetail(applicationNo);
            ChildMCDTO childMCDTO = this.commonDao.getChildDetail(applicationNo);
            ChildTravelDetailDTO childTravelDetailDTO = this.commonDao.getChildTravelDetail(applicationNo);
            WitnessDetailDTO witnessDetailDTO = this.commonDao.getWitnessDetail(applicationNo);
            WitnessDetailDTO witnessDetailDTO2 = this.commonDao.getWitnessDetail2(applicationNo);
            DonorDTO donorDTO = this.commonDao.getDonorDetail(applicationNo);
            DonorDepDTO donorDepDTO = this.commonDao.getDonorDepDetail(applicationNo);
            OrgFatherDTO orgFatherDTO = this.commonDao.getOrgFatherDetail(applicationNo);
            OrgMotherDTO orgMotherDTO = this.commonDao.getOrgMotherDetail(applicationNo);
            PatientDTO patientDTO = this.commonDao.getPatientDetail(applicationNo);
            TransferorDTO transferorDTO = this.commonDao.getTransferorDetail(applicationNo);
            responseMessage.setResponseStatus(Integer.valueOf(SystemDataInt.MESSAGE_STATUS_SUCCESSFUL.value()));
            responseMessage.setResponseDTO(applicationDetailDTO);
            responseMessage.setApplicantDTO(applicantDetailDTO);
            responseMessage.setSpouseDTO(spouseDetailsDTO);
            responseMessage.setWitness1DTO(applicantDetailDTO.getApplicantName());
            responseMessage.setChildDTO(childMCDTO);
            responseMessage.setWitness1DTO(witnessDetailDTO);
            responseMessage.setWitness2DTO(witnessDetailDTO2);
            responseMessage.setDonorDTO(donorDTO);
            responseMessage.setDonorDepDTO(donorDepDTO);
            responseMessage.setFatherDTO(orgFatherDTO);
            responseMessage.setMotherDTO(orgMotherDTO);
            responseMessage.setPatientDTO(patientDTO);
            responseMessage.setTransferorDTO(transferorDTO);
            responseMessage.setChildTravelDetailDTO(childTravelDetailDTO);
            responseMessage.setReceipt_Amount(applicationDetailDTO.getReceiptAmount());
            responseMessage.setReceipt_No(applicationDetailDTO.getReceiptNo());
            responseMessage.setReceiptDate(applicationDetailDTO.getReceiptDate());
            responseMessage.setServiceName(applicationDetailDTO.getServiceName());
            responseMessage.setIncorrectType(applicationDetailDTO.getIncorrectType());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return responseMessage;
    }

    public List<DropdownDTO> getRejectReasons() {
        return this.commonDao.getRejectReasons();
    }

    public ResponseMessage validateDuplicateDocument(String cidNo, String indexNo, Integer serviceTypeId, Integer documentTypeId) {
        ResponseMessage responseMessage = new ResponseMessage();
        String applicationNo = this.commonDao.validateDuplicateDocument(cidNo, indexNo, serviceTypeId, documentTypeId);
        if (applicationNo != null) {
            responseMessage.setResponseStatus(Integer.valueOf(SystemDataInt.MESSAGE_STATUS_UNSUCCESSFUL.value()));
        } else {
            responseMessage.setResponseStatus(Integer.valueOf(SystemDataInt.MESSAGE_STATUS_SUCCESSFUL.value()));
        }
        return responseMessage;
    }

    public String getDocumentName(Integer documentTypeId) {
        return this.commonDao.getDocumentName(documentTypeId);
    }

    private WorkFlowDetail convertWorkFlowDetailDTOtoEntity(WorkFlowDetailDTO workFlowDetailDTO) {
        WorkFlowDetail workFlowDetail = new WorkFlowDetail();
        workFlowDetail.setApplicationNo(workFlowDetailDTO.getApplicationNo());
        workFlowDetail.setApplicationStatusId(workFlowDetailDTO.getApplicationStatusId());
        workFlowDetail.setServiceId(workFlowDetailDTO.getServiceId());
        workFlowDetail.setCreatedBy(workFlowDetailDTO.getCreatedBy());
        workFlowDetail.setCreatedDate(workFlowDetailDTO.getCreatedDate());
        workFlowDetail.setUpdateBy(workFlowDetailDTO.getUpdateBy());
        workFlowDetail.setUpdateDate(workFlowDetailDTO.getUpdateDate());
        return workFlowDetail;
    }

    private TaskDetail convertTaskDetailDTOtoEntity(TaskDetailDTO taskDetailDTO) {
        TaskDetail taskDetail = new TaskDetail();
        taskDetail.setApplicationNo(taskDetailDTO.getApplicationNo());
        taskDetail.setOwner(taskDetailDTO.getOwner());
        taskDetail.setServiceId(taskDetailDTO.getServiceId());
        taskDetail.setCreatedBy(taskDetailDTO.getCreatedBy());
        taskDetail.setCreatedOn(taskDetailDTO.getCreatedOn());
        taskDetail.setModifiedBy(taskDetailDTO.getModifiedBy());
        taskDetail.setModifiedOn(taskDetailDTO.getModifiedOn());
        taskDetail.setApplicationStatus(taskDetailDTO.getApplicationStatus());
        taskDetail.setWorkflowInstanceId(taskDetailDTO.getWorkflowInstanceId());
        return taskDetail;
    }

    private PaymentDetail convertPaymentDetailDtoToEntity(PaymentDetailDTO paymentDetailDTO) {
        PaymentDetail paymentDetail = new PaymentDetail();
        paymentDetail.setPaymentDetailId(paymentDetailDTO.getPaymentDetailId());
        paymentDetail.setApplicationNo(paymentDetailDTO.getApplicationNo());
        paymentDetail.setServiceNo(paymentDetailDTO.getServiceNo());
        paymentDetail.setPaymentType(paymentDetailDTO.getPaymentType());
        paymentDetail.setAmountCharge(paymentDetailDTO.getReceiptAmount());
        paymentDetail.setBankId(paymentDetailDTO.getBankId());
        paymentDetail.setReceiptNo(paymentDetailDTO.getReceiptNo());
        paymentDetail.setVoucherNo(paymentDetailDTO.getVoucherNo());
        paymentDetail.setDepositDate(paymentDetailDTO.getDepositDate());
        paymentDetail.setIsPaid(paymentDetailDTO.getIsPaid());
        return paymentDetail;
    }

    private Integer getWorkInstanceId() {
        Integer workInstanceSerial = this.commonDao.getWorkInstanceSerial();
        return workInstanceSerial;
    }

    private String getTaskInstanceId() {
        String taskInstanceShortCode = "TI";
        String taskInstanceId = null;
        Integer taskInstanceSerial = this.commonDao.getTaskInstanceSerial();
        taskInstanceSerial = Integer.valueOf((taskInstanceSerial == null) ? 0 : taskInstanceSerial.intValue());
        taskInstanceSerial = Integer.valueOf(taskInstanceSerial.intValue() + 1);
        if (taskInstanceSerial.toString().length() == 1)
            taskInstanceId = taskInstanceShortCode + "0000000" + taskInstanceSerial;
        if (taskInstanceSerial.toString().length() == 2)
            taskInstanceId = taskInstanceShortCode + "000000" + taskInstanceSerial;
        if (taskInstanceSerial.toString().length() == 3)
            taskInstanceId = taskInstanceShortCode + "00000" + taskInstanceSerial;
        if (taskInstanceSerial.toString().length() == 4)
            taskInstanceId = taskInstanceShortCode + "0000" + taskInstanceSerial;
        if (taskInstanceSerial.toString().length() == 5)
            taskInstanceId = taskInstanceShortCode + "000" + taskInstanceSerial;
        if (taskInstanceSerial.toString().length() == 6)
            taskInstanceId = taskInstanceShortCode + "00" + taskInstanceSerial;
        if (taskInstanceSerial.toString().length() == 7)
            taskInstanceId = taskInstanceShortCode + "0" + taskInstanceSerial;
        if (taskInstanceSerial.toString().length() == 8)
            taskInstanceId = taskInstanceSerial.toString();
        return taskInstanceId;
    }

    private Integer getPaymentDetailId() {
        Integer lastPaymentDetailId = this.commonDao.getLastPaymentDetailId();
        return Integer.valueOf((lastPaymentDetailId == null) ? 0 : lastPaymentDetailId.intValue());
    }

    private String getRejectReasonByRejectReasonId(String rejectReasonId) {
        String[] aRejectedId = new String[0];
        String reasonasAre = "", sss = "";
        aRejectedId = rejectReasonId.split(",");
        try {
            List<String> aRejectedIdList = Arrays.asList(aRejectedId);
            for (int i = 0; i < aRejectedIdList.size(); i++) {
                reasonasAre = this.commonDao.getRejectReasonByRejectReasonId(aRejectedIdList.get(i));
                sss = reasonasAre.concat(",") + sss;
            }
        } catch (Exception e) {
            System.out.print(e);
        }
        return sss;
    }

    private String getRejectReasonByRejectReasonIds(Integer rejectReasonId) {
        return this.commonDao.getRejectReasonByRejectReasonIds(rejectReasonId);
    }

    private String getRejectReasonOthersById(Integer rejectReasonId) {
        return this.commonDao.getRejectReasonOthersById(rejectReasonId);
    }

    public String getCourtName(String courtId) {
        return this.commonDao.getCourtName(courtId);
    }

    private String formatDate(Date newDob) throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String date = dateFormat.format(newDob);
        return date;
    }

    public ResponseMessage getAttachedFiles(String applicationNo) {
        ResponseMessage responseMessage = new ResponseMessage();
        List<FileAttachmentDTO> fileAttachmentDTOs = this.commonDao.getAttachedFiles(applicationNo);
        if (fileAttachmentDTOs != null) {
            responseMessage.setResponseStatus(Integer.valueOf(SystemDataInt.MESSAGE_STATUS_SUCCESSFUL.value()));
            responseMessage.setResponseDTO(fileAttachmentDTOs);
        }
        return responseMessage;
    }

    public ResponseMessage downloadFile(Integer documentId, HttpServletResponse response) throws IOException {
        ResponseMessage responseMessage = new ResponseMessage();
        FileAttachmentDTO fileAttachmentDTO = this.commonDao.downloadFile(documentId);
        String uploadFilePath = fileAttachmentDTO.getUploadUrl();
        String fileName = fileAttachmentDTO.getDocumentName();
        responseMessage = FileUploadToExternalLocation.fileDownloader(fileName, uploadFilePath, response);
        if (responseMessage.getResponseStatus().intValue() == SystemDataInt.MESSAGE_STATUS_UNSUCCESSFUL.value())
            return responseMessage;
        responseMessage.setResponseDTO(fileAttachmentDTO);
        responseMessage.setResponseStatus(Integer.valueOf(SystemDataInt.MESSAGE_STATUS_SUCCESSFUL.value()));
        return responseMessage;
    }

    public List<DropdownDTO> getServiceName() {
        return this.commonDao.getServiceName();
    }

    public List<DropdownDTO> getServiceNamePrint() {
        return this.commonDao.getServiceNamePrint();
    }

    public void updatePaymentOnline(ApplicationDetailDTO applicationDetailDTO) {
        boolean status = false;
        PaymentDetail paymentDetail = convertPaymentDTOtoEntity(applicationDetailDTO);
        this.commonDao.savePaymentDetail(paymentDetail);
        status = this.commonDao.updatePaymentOnline(applicationDetailDTO);
        if (status == true) {
            this.commonDao.updateWorkFlowPayment(applicationDetailDTO);
            this.commonDao.updateTaskFlowPayment(applicationDetailDTO);
        }
    }

    private PaymentDetail convertPaymentDTOtoEntity(ApplicationDetailDTO applicationDetailDTO) {
        String serviceId = applicationDetailDTO.getApplicationNo().substring(0, 3);
        String paymentDate = applicationDetailDTO.getReceiptDateOnline();
        PaymentDetail paymentDetail = new PaymentDetail();
        try {
            Date date1 = (new SimpleDateFormat("yyyy-MM-dd")).parse(paymentDate);
            paymentDetail.setApplicationNo(applicationDetailDTO.getApplicationNo());
            paymentDetail.setAmountCharge(applicationDetailDTO.getReceiptAmount());
            paymentDetail.setBankId(null);
            paymentDetail.setDepositDate(date1);
            paymentDetail.setIsPaid("Y");
            paymentDetail.setPaymentType("Online");
            paymentDetail.setReceiptNo(applicationDetailDTO.getReceiptNo());
            paymentDetail.setServiceNo(Integer.valueOf(serviceId));
            paymentDetail.setVoucherNo(applicationDetailDTO.getReceiptNo());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return paymentDetail;
    }

    public ResponseMessage checkForAlreadyExistApplicant(String cidNo, String serviceId) {
        ResponseMessage responseMessage = new ResponseMessage();
        DropdownDTO dropdownDTO = new DropdownDTO();
        dropdownDTO = this.commonDao.getServiceNameCheck(serviceId);
        String serviceName = dropdownDTO.getText();
        int cidCount = this.commonDao.checkForAlreadyExistApplicant(cidNo, serviceId).intValue();
        if (cidCount == 0)
            cidCount = this.commonDao.checkForAlreadyExistSpouse(cidNo, serviceId).intValue();
        if (cidCount > 0) {
            responseMessage.setResponseStatus(Integer.valueOf(SystemDataInt.MESSAGE_STATUS_UNSUCCESSFUL.value()));
            responseMessage.setResponseText("CID No. " + cidNo + " has already applied for " + serviceName + " and it's under process.");
        } else {
            responseMessage.setResponseStatus(Integer.valueOf(SystemDataInt.MESSAGE_STATUS_SUCCESSFUL.value()));
        }
        return responseMessage;
    }

    public ResponseMessage checkPreviousJudgementNo(String judgementNo, String serviceId, String courtId, String applicationYear) {
        ResponseMessage responseMessage = new ResponseMessage();
        DropdownDTO dropdownDTO = new DropdownDTO();
        dropdownDTO = this.commonDao.getServiceNameCheck(serviceId);
        String serviceName = dropdownDTO.getText();
        int regNoCount = this.commonDao.checkPreviousJudgementNo(judgementNo, serviceId, courtId, applicationYear).intValue();
        if (regNoCount > 0) {
            responseMessage.setResponseStatus(Integer.valueOf(SystemDataInt.MESSAGE_STATUS_UNSUCCESSFUL.value()));
            responseMessage.setResponseText("Judgement No. " + judgementNo + " has already used for " + serviceName);
        } else {
            responseMessage.setResponseStatus(Integer.valueOf(SystemDataInt.MESSAGE_STATUS_SUCCESSFUL.value()));
        }
        return responseMessage;
    }

    public ResponseMessage checkPreviousRegistrationNo(String regNo, String serviceId, String courtId, String applicationYear) {
        ResponseMessage responseMessage = new ResponseMessage();
        DropdownDTO dropdownDTO = new DropdownDTO();
        dropdownDTO = this.commonDao.getServiceNameCheck(serviceId);
        String serviceName = dropdownDTO.getText();
        int judgementNoCount = this.commonDao.checkPreviousRegistrationNo(regNo, serviceId, courtId, applicationYear).intValue();
        if (judgementNoCount > 0) {
            responseMessage.setResponseStatus(Integer.valueOf(SystemDataInt.MESSAGE_STATUS_UNSUCCESSFUL.value()));
            responseMessage.setResponseText("Registration No. " + regNo + " has already used for " + serviceName);
        } else {
            responseMessage.setResponseStatus(Integer.valueOf(SystemDataInt.MESSAGE_STATUS_SUCCESSFUL.value()));
        }
        return responseMessage;
    }

    public ResponseMessage checkForAlreadyExistSpouse(String cidNo, String serviceId) {
        ResponseMessage responseMessage = new ResponseMessage();
        DropdownDTO dropdownDTO = new DropdownDTO();
        dropdownDTO = this.commonDao.getServiceNameCheck(serviceId);
        String serviceName = dropdownDTO.getText();
        int cidCount = this.commonDao.checkForAlreadyExistSpouse(cidNo, serviceId).intValue();
        if (cidCount == 0)
            cidCount = this.commonDao.checkForAlreadyExistApplicant(cidNo, serviceId).intValue();
        if (cidCount > 0) {
            responseMessage.setResponseStatus(Integer.valueOf(SystemDataInt.MESSAGE_STATUS_UNSUCCESSFUL.value()));
            responseMessage.setResponseText("CID No. " + cidNo + " has already applied for " + serviceName + " and it's under process.");
        } else {
            responseMessage.setResponseStatus(Integer.valueOf(SystemDataInt.MESSAGE_STATUS_SUCCESSFUL.value()));
        }
        return responseMessage;
    }

    public ResponseMessage checkForAlreadyAssigned(Date appoinmentDate, String appoinmentTime) throws ParseException {
        ResponseMessage responseMessage = new ResponseMessage();
        int count = this.commonDao.checkForAlreadyAssigned(formatAppDate(appoinmentDate), formatAppDate(appoinmentTime)).intValue();
        if (count > 0) {
            responseMessage.setResponseStatus(Integer.valueOf(SystemDataInt.MESSAGE_STATUS_UNSUCCESSFUL.value()));
            responseMessage.setResponseText("The given appointment date " + appoinmentDate + " and time " + appoinmentTime + " is already assigned to other applicant.");
        } else {
            responseMessage.setResponseStatus(Integer.valueOf(SystemDataInt.MESSAGE_STATUS_SUCCESSFUL.value()));
        }
        return responseMessage;
    }

    private String formatAppDate(Date appoinmentDate) throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String date = dateFormat.format(appoinmentDate);
        return date;
    }

    private String formatAppDate(String appoinmentTime) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        Date date3 = sdf.parse(appoinmentTime);
        SimpleDateFormat sdf2 = new SimpleDateFormat("hh:mm aa");
        String time = sdf2.format(date3);
        return time;
    }

    public ResponseMessage updateApplicationMC(UserRolePrivilegeDto userBean, ApplicationDetailDTO applicationDetailDTO, ApplicantDetailDTO applicantDetailDTO, SpouseDetailsDTO spouseDetailsDTO) {
        ResponseMessage responseMessage = new ResponseMessage();
        applicationDetailDTO = this.commonDao.getApplicationDetail(applicationDetailDTO.getApplicationNo());
        if (applicationDetailDTO == null) {
            responseMessage.setResponseStatus(Integer.valueOf(SystemDataInt.MESSAGE_STATUS_UNSUCCESSFUL.value()));
            responseMessage.setResponseText("Application information not found.");
            return responseMessage;
        }
        if (applicationDetailDTO.getStatusId() == "5") {
            responseMessage.setResponseStatus(Integer.valueOf(SystemDataInt.MESSAGE_STATUS_UNSUCCESSFUL.value()));
            responseMessage.setResponseText("Task already claimed/approved/rejected/unclaimed by someone. Please refresh the page to see the updated task.");
            return responseMessage;
        }
        applicationDetailDTO.setApplicationNo(applicationDetailDTO.getApplicationNo());
        applicationDetailDTO.setMcNo(applicantDetailDTO.getJudgementNo());
        applicationDetailDTO.setRegNo(applicantDetailDTO.getRegNo());
        applicationDetailDTO.setRegDate(applicantDetailDTO.getRegDate());
        applicationDetailDTO.setJudgementNo(applicantDetailDTO.getJudgementNo());
        applicationDetailDTO.setJudgementDate(applicantDetailDTO.getJudgementDate());
        applicationDetailDTO.setLawyer(applicantDetailDTO.getLawyer());
        applicationDetailDTO.setUpdatedBy(userBean.getUserType());
        applicationDetailDTO.setUpdateDate(new Date());
        applicationDetailDTO.setStatusId("5");
        ApplicationDetail applicationDetail = convertApplicationDTOtoEntity(applicationDetailDTO);
        this.commonDao.saveApplication(applicationDetail);
        HusbandMCDetail husbandMCDetail = convertHusbandDTOtoEntity(applicantDetailDTO);
        this.commonDao.saveHusbandMCDetail(husbandMCDetail);
        WifeMCDetail wifeMCDetail = convertWifeDTOtoEntity(spouseDetailsDTO);
        this.commonDao.saveWifeMCDetail(wifeMCDetail);
        WorkFlowDetailDTO workFlowDetailDTO = new WorkFlowDetailDTO();
        Integer workInstanceId = getWorkInstanceId();
        workFlowDetailDTO.setApplicationNo(applicationDetailDTO.getApplicationNo());
        workFlowDetailDTO.setServiceId(applicationDetailDTO.getServiceSlNo());
        workFlowDetailDTO.setApplicationStatusId(Integer.valueOf(5));
        workFlowDetailDTO.setUpdateBy(userBean.getUserType());
        workFlowDetailDTO.setUpdateDate(new Date());
        WorkFlowDetail workFlowDetail = convertWorkFlowDetailDTOtoEntity(workFlowDetailDTO);
        this.commonDao.saveWorkFlowDetail(workFlowDetail);
        TaskDetailDTO taskDetailDTO = new TaskDetailDTO();
        taskDetailDTO.setApplicationNo(applicationDetailDTO.getApplicationNo());
        taskDetailDTO.setServiceId(applicationDetailDTO.getServiceSlNo());
        taskDetailDTO.setApplicationStatus(Integer.valueOf(5));
        taskDetailDTO.setOwner(userBean.getUserType());
        taskDetailDTO.setWorkflowInstanceId(Integer.toString(workInstanceId.intValue()));
        taskDetailDTO.setCreatedBy(applicationDetailDTO.getCreatedBy());
        taskDetailDTO.setCreatedOn(applicationDetailDTO.getCreatedDate());
        taskDetailDTO.setModifiedBy(userBean.getUserType());
        taskDetailDTO.setModifiedOn(new Date());
        TaskDetail taskDetail = convertTaskDetailDTOtoEntity(taskDetailDTO);
        this.commonDao.saveTaskDetail(taskDetail);
        responseMessage.setResponseStatus(Integer.valueOf(SystemDataInt.MESSAGE_STATUS_APPROVAL.value()));
        responseMessage.setResponseText("Updated Successfully.");
        return responseMessage;
    }

    @Transactional
    public ResponseMessage updateApplication(UserRolePrivilegeDto userBean, String applicationNo, String regNo, Date regDate, String judgementNo, Date judgementDate, String lawyer) {
        ResponseMessage responseMessage = new ResponseMessage();
        ApplicationDetailDTO applicationDetailDTO = this.commonDao.getApplicationDetail(applicationNo);
        if (applicationDetailDTO == null) {
            responseMessage.setResponseStatus(Integer.valueOf(SystemDataInt.MESSAGE_STATUS_UNSUCCESSFUL.value()));
            responseMessage.setResponseText("Application information not found.");
            return responseMessage;
        }
        if (applicationDetailDTO.getStatusId() == "5") {
            responseMessage.setResponseStatus(Integer.valueOf(SystemDataInt.MESSAGE_STATUS_UNSUCCESSFUL.value()));
            responseMessage.setResponseText("Task already claimed/approved/rejected/unclaimed by someone. Please refresh the page to see the updated task.");
            return responseMessage;
        }
        applicationDetailDTO.setApplicationNo(applicationNo);
        applicationDetailDTO.setRegNo(regNo);
        applicationDetailDTO.setRegDate(regDate);
        applicationDetailDTO.setJudgementNo(judgementNo);
        applicationDetailDTO.setJudgementDate(judgementDate);
        applicationDetailDTO.setLawyer(lawyer);
        applicationDetailDTO.setUpdatedBy(userBean.getUserType());
        applicationDetailDTO.setUpdateDate(new Date());
        applicationDetailDTO.setStatusId("5");
        ApplicationDetail applicationDetail = convertApplicationDTOtoEntity(applicationDetailDTO);
        applicationDetail.setReject_Reason(applicationDetailDTO.getReject_Reason());
        this.commonDao.saveApplication(applicationDetail);
        WorkFlowDetailDTO workFlowDetailDTO = new WorkFlowDetailDTO();
        Integer workInstanceId = getWorkInstanceId();
        workFlowDetailDTO.setApplicationNo(applicationDetailDTO.getApplicationNo());
        workFlowDetailDTO.setServiceId(applicationDetailDTO.getServiceSlNo());
        workFlowDetailDTO.setApplicationStatusId(Integer.valueOf(5));
        workFlowDetailDTO.setUpdateBy(userBean.getUserType());
        workFlowDetailDTO.setUpdateDate(new Date());
        WorkFlowDetail workFlowDetail = convertWorkFlowDetailDTOtoEntity(workFlowDetailDTO);
        this.commonDao.saveWorkFlowDetail(workFlowDetail);
        TaskDetailDTO taskDetailDTO = new TaskDetailDTO();
        taskDetailDTO.setApplicationNo(applicationDetailDTO.getApplicationNo());
        taskDetailDTO.setServiceId(applicationDetailDTO.getServiceSlNo());
        taskDetailDTO.setApplicationStatus(Integer.valueOf(5));
        taskDetailDTO.setOwner(userBean.getUserType());
        taskDetailDTO.setWorkflowInstanceId(Integer.toString(workInstanceId.intValue()));
        taskDetailDTO.setCreatedBy(applicationDetailDTO.getCreatedBy());
        taskDetailDTO.setCreatedOn(applicationDetailDTO.getCreatedDate());
        taskDetailDTO.setModifiedBy(userBean.getUserType());
        taskDetailDTO.setModifiedOn(new Date());
        TaskDetail taskDetail = convertTaskDetailDTOtoEntity(taskDetailDTO);
        this.commonDao.saveTaskDetail(taskDetail);
        responseMessage.setResponseStatus(Integer.valueOf(SystemDataInt.MESSAGE_STATUS_APPROVAL.value()));
        responseMessage.setResponseText("Updated Successfully.");
        System.out.print(responseMessage.getResponseText());
        System.out.print(responseMessage.getResponseText());
        return responseMessage;
    }

    private HusbandMCDetail convertHusbandDTOtoEntity(ApplicantDetailDTO applicantDetailDTO) {
        HusbandMCDetail husbandMCDetail = new HusbandMCDetail();
        husbandMCDetail.setApplicationNo(applicantDetailDTO.getApplicationNo());
        husbandMCDetail.setCidNo(applicantDetailDTO.getCidNo());
        husbandMCDetail.setName(applicantDetailDTO.getApplicantName());
        husbandMCDetail.setDob(String.valueOf(applicantDetailDTO.getApplicantDob()));
        husbandMCDetail.setGender(applicantDetailDTO.getGender());
        husbandMCDetail.setFatherName(applicantDetailDTO.getFatherName());
        husbandMCDetail.setMotherName(applicantDetailDTO.getMotherName());
        husbandMCDetail.setTharmNo(applicantDetailDTO.getTharmNo());
        husbandMCDetail.setHouseNo(applicantDetailDTO.getHouseNo());
        husbandMCDetail.setFormId(applicantDetailDTO.getCensusFormNo());
        husbandMCDetail.setDzongkhagId(applicantDetailDTO.getDzongkhagId());
        husbandMCDetail.setDzongkhagNameBh(applicantDetailDTO.getDzongkhagName());
        husbandMCDetail.setGewogId(applicantDetailDTO.getGewogId());
        husbandMCDetail.setGewogNameBh(applicantDetailDTO.getGewogName());
        husbandMCDetail.setVillageId(applicantDetailDTO.getVillageId());
        husbandMCDetail.setVillageNameBh(applicantDetailDTO.getVillageName());
        husbandMCDetail.setNationality(applicantDetailDTO.getNationality());
        husbandMCDetail.setCountry("Bhutan");
        husbandMCDetail.setAddress(applicantDetailDTO.getAddress());
        husbandMCDetail.setCensusNo(applicantDetailDTO.getCensusFormNo());
        husbandMCDetail.setApplicationNoDzo(applicantDetailDTO.getApplicationIdDzo());
        husbandMCDetail.setJudgementNoDzo(applicantDetailDTO.getJudgementNoDzo());
        husbandMCDetail.setJudgementDateDzo(String.valueOf(applicantDetailDTO.getJudgementDate()));
        husbandMCDetail.setLunarDate(applicantDetailDTO.getLunarDateDzo());
        husbandMCDetail.setLawyerNameDzo(applicantDetailDTO.getLawyerDzo());
        return husbandMCDetail;
    }

    private WifeMCDetail convertWifeDTOtoEntity(SpouseDetailsDTO spouseDetailsDTO) {
        WifeMCDetail wifeMCDetail = new WifeMCDetail();
        wifeMCDetail.setApplicationNo(spouseDetailsDTO.getApplicationNo());
        wifeMCDetail.setCidNo(spouseDetailsDTO.getSpouseCidNo());
        wifeMCDetail.setName(spouseDetailsDTO.getSpouseName());
        wifeMCDetail.setDob(String.valueOf(spouseDetailsDTO.getSpouseApplicantDobBh()));
        wifeMCDetail.setGender(spouseDetailsDTO.getSpouseGender());
        wifeMCDetail.setFatherName(spouseDetailsDTO.getSpouseFathersName());
        wifeMCDetail.setMotherName(spouseDetailsDTO.getSpouseMothersName());
        wifeMCDetail.setTharmNo(spouseDetailsDTO.getSpouseTharmNo());
        wifeMCDetail.setHouseNo(spouseDetailsDTO.getSpouseHouseNo());
        wifeMCDetail.setFormId(spouseDetailsDTO.getSpouseCensusFormNo());
        wifeMCDetail.setDzongkhagId(spouseDetailsDTO.getSpouseDzongkhagId());
        wifeMCDetail.setDzongkhagNameBh(spouseDetailsDTO.getSpouseDzongkhagName());
        wifeMCDetail.setGewogId(spouseDetailsDTO.getSpouseGewogId());
        wifeMCDetail.setGewogNameBh(spouseDetailsDTO.getSpouseGewogName());
        wifeMCDetail.setVillageId(spouseDetailsDTO.getSpouseVillageId());
        wifeMCDetail.setVillageNameBh(spouseDetailsDTO.getSpouseVillageName());
        wifeMCDetail.setNationality(spouseDetailsDTO.getSpouseNationality());
        wifeMCDetail.setCountry("Bhutan");
        wifeMCDetail.setAddress(spouseDetailsDTO.getAddress());
        wifeMCDetail.setCensusNo(spouseDetailsDTO.getCensusFormNo());
        wifeMCDetail.setApplicationNoDzo(spouseDetailsDTO.getApplicationIdDzo());
        wifeMCDetail.setJudgementNoDzo(spouseDetailsDTO.getJudgementNoDzo());
        wifeMCDetail.setJudgementDateDzo(String.valueOf(spouseDetailsDTO.getJudgementDate()));
        wifeMCDetail.setLunarDate(spouseDetailsDTO.getLunarDateDzo());
        wifeMCDetail.setLawyerNameDzo(spouseDetailsDTO.getLawyerDzo());
        return wifeMCDetail;
    }

    public String getCourtPhoneNo(UserRolePrivilegeDto userBean) {
        String phoneNo = this.commonDao.getCourtPhoneNo(userBean);
        return phoneNo;
    }

    @Transactional(readOnly = true)
    public UserRolePrivilege populateUserRolePrivilegeHierarchy(UserRolePrivilege userRolePrivilegeBcsea, String roleId, HttpServletRequest request) {
        ResourceBundle resourceBundle1 = ResourceBundle.getBundle("wsEndPointURL_en_US");
        String userRolePrivilegeEndPointUrl = resourceBundle1.getString("getUserRolePrivilege.endPointURL");
        String deptCode = resourceBundle1.getString("getDeptCode.endPointURL");
        HttpSession session = request.getSession();
        try {
            InvokeWS invokeWS = null;
            invokeWS = new InvokeWS(userRolePrivilegeEndPointUrl);
            userRolePrivilegeBcsea = invokeWS.populateUserRolePrivilegeHierarchy(userRolePrivilegeBcsea, roleId, deptCode);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userRolePrivilegeBcsea;
    }

    public Integer getGroupTaskSubmitted(UserRolePrivilegeHierarchyObj userRolePrivilegeHierarchyObj) {
        return this.commonDao.getGroupTaskSubmitted(userRolePrivilegeHierarchyObj);
    }

    public Integer getMyTaskSubmitted(UserRolePrivilegeHierarchyObj userRolePrivilegeHierarchyObj) {
        return this.commonDao.getMyTaskSubmitted(userRolePrivilegeHierarchyObj);
    }

    public Integer getGroupTaskVerified(UserRolePrivilegeHierarchyObj userRolePrivilegeHierarchyObj) {
        return this.commonDao.getGroupTaskVerified(userRolePrivilegeHierarchyObj);
    }

    public Integer getMyTaskVerified(UserRolePrivilegeHierarchyObj userRolePrivilegeHierarchyObj) {
        return this.commonDao.getMyTaskVerified(userRolePrivilegeHierarchyObj);
    }

    public Integer getApplicationCount(UserRolePrivilegeHierarchyObj dto, Integer serviceId, Integer status) {
        return this.commonDao.getApplicationCount(dto, serviceId, status);
    }

    public Integer getUpdatePaymentCount(UserRolePrivilegeDto dto) {
        return this.commonDao.getUpdatePaymentCount(dto);
    }

    public ResponseMessage checkForAlreadyMarriedApplicant(String cidNo, String serviceId, String spouseCid, String judgementNo) {
        ResponseMessage responseMessage = new ResponseMessage();
        DropdownDTO dropdownDTO = new DropdownDTO();
        dropdownDTO = this.commonDao.getServiceNameCheck(serviceId);
        String serviceName = dropdownDTO.getText();
        int cidCount = this.commonDao.checkForAlreadyMarriedApplicant(cidNo, serviceId);
        if (cidCount == 0)
            cidCount = this.commonDao.checkForAlreadyMarriedSpouse(cidNo, serviceId);
        if (cidCount > 0) {
            responseMessage.setResponseStatus(Integer.valueOf(SystemDataInt.MESSAGE_STATUS_UNSUCCESSFUL.value()));
            responseMessage.setResponseText("CID No. " + cidNo + " is married with " + spouseCid + " and it's judgement no is:." + judgementNo);
        } else {
            responseMessage.setResponseStatus(Integer.valueOf(SystemDataInt.MESSAGE_STATUS_SUCCESSFUL.value()));
        }
        return responseMessage;
    }

    public ResponseMessage checkForAlreadyMarriedSpouse(String spouseCidNo, String serviceId, String spouseCid, String judgementNo) {
        ResponseMessage responseMessage = new ResponseMessage();
        DropdownDTO dropdownDTO = new DropdownDTO();
        dropdownDTO = this.commonDao.getServiceNameCheck(serviceId);
        String serviceName = dropdownDTO.getText();
        int cidCount = this.commonDao.checkForAlreadyMarriedSpouse(spouseCidNo, serviceId);
        if (cidCount == 0)
            cidCount = this.commonDao.checkForAlreadyMarriedApplicant(spouseCidNo, serviceId).intValue();
        if (cidCount > 0) {
            responseMessage.setResponseStatus(Integer.valueOf(SystemDataInt.MESSAGE_STATUS_UNSUCCESSFUL.value()));
            responseMessage.setResponseText("CID No. " + spouseCidNo + " has already married with " + spouseCid + " with judgment no." + judgementNo);
        } else {
            responseMessage.setResponseStatus(Integer.valueOf(SystemDataInt.MESSAGE_STATUS_SUCCESSFUL.value()));
        }
        return responseMessage;
    }

    public ResponseMessage approveApplications(UserRolePrivilegeDto userBean, String applicationNo, String remarks, String rejectReasonId) {
        ResponseMessage responseMessage = new ResponseMessage();
        ApplicationDetailDTO applicationDetailDTO = this.commonDao.getApplicationDetail(applicationNo);
        Integer courtId = applicationDetailDTO.getCourtId();
        String courtName = this.commonDao.getCourtName(Integer.toString(courtId.intValue()));
        if (applicationDetailDTO == null) {
            responseMessage.setResponseStatus(Integer.valueOf(SystemDataInt.MESSAGE_STATUS_UNSUCCESSFUL.value()));
            responseMessage.setResponseText("Application information not found.");
            return responseMessage;
        }
        if (applicationDetailDTO.getStatusId() == "2") {
            responseMessage.setResponseStatus(Integer.valueOf(SystemDataInt.MESSAGE_STATUS_UNSUCCESSFUL.value()));
            responseMessage.setResponseText("Task already claimed/approved/rejected/unclaimed by someone. Please refresh the page to see the updated task.");
            return responseMessage;
        }
        applicationDetailDTO.setApplicationNo(applicationNo);
        applicationDetailDTO.setUpdatedBy(userBean.getUserType());
        applicationDetailDTO.setUpdateDate(new Date());
        applicationDetailDTO.setRemarks(remarks);
        applicationDetailDTO.setStatusId("4");
        applicationDetailDTO.setReject_Reason(rejectReasonId);
        ApplicationDetail applicationDetail = convertApplicationDTOtoEntity(applicationDetailDTO);
        applicationDetail.setReject_Reason(rejectReasonId);
        applicationDetail.getReject_Reason();
        this.commonDao.saveApplication(applicationDetail);
        WorkFlowDetailDTO workFlowDetailDTO = new WorkFlowDetailDTO();
        Integer workInstanceId = getWorkInstanceId();
        workFlowDetailDTO.setApplicationNo(applicationDetailDTO.getApplicationNo());
        workFlowDetailDTO.setServiceId(applicationDetailDTO.getServiceSlNo());
        workFlowDetailDTO.setApplicationStatusId(Integer.valueOf(4));
        workFlowDetailDTO.setCreatedBy(applicationDetailDTO.getCreatedBy());
        workFlowDetailDTO.setCreatedDate(applicationDetailDTO.getCreatedDate());
        workFlowDetailDTO.setUpdateBy(userBean.getUserType());
        workFlowDetailDTO.setUpdateDate(new Date());
        WorkFlowDetail workFlowDetail = convertWorkFlowDetailDTOtoEntity(workFlowDetailDTO);
        this.commonDao.saveWorkFlowDetail(workFlowDetail);
        TaskDetailDTO taskDetailDTO = new TaskDetailDTO();
        taskDetailDTO.setApplicationNo(applicationDetailDTO.getApplicationNo());
        taskDetailDTO.setServiceId(applicationDetailDTO.getServiceSlNo());
        taskDetailDTO.setApplicationStatus(Integer.valueOf(4));
        taskDetailDTO.setOwner(userBean.getUserType());
        taskDetailDTO.setWorkflowInstanceId(Integer.toString(workInstanceId.intValue()));
        taskDetailDTO.setCreatedBy(applicationDetailDTO.getCreatedBy());
        taskDetailDTO.setCreatedOn(applicationDetailDTO.getCreatedDate());
        taskDetailDTO.setModifiedBy(userBean.getUserType());
        taskDetailDTO.setModifiedOn(new Date());
        TaskDetail taskDetail = convertTaskDetailDTOtoEntity(taskDetailDTO);
        this.commonDao.saveTaskDetail(taskDetail);
        responseMessage.setResponseStatus(Integer.valueOf(SystemDataInt.MESSAGE_STATUS_REJECT.value()));
        responseMessage.setRejectReason(rejectReasonId);
        responseMessage.setResponseText("Rejected Successfully.");
        responseMessage.setCourtName(courtName);
        responseMessage.setMobileNo(applicationDetailDTO.getMobileNo());
        return responseMessage;
    }

    public ResponseMessage approveApplicationss(UserRolePrivilegeDto userBean, String applicationNo, String remarks, Integer rejectReasonId, String rejectRemarks) {
        ResponseMessage responseMessage = new ResponseMessage();
        Date appoinmentDateApprove = null;
        Date appoinmentTimeApprove = null;
        try {
            ApplicationDetailDTO applicationDetailDTO = this.commonDao.getApplicationDetail(applicationNo);
            Integer courtId = applicationDetailDTO.getCourtId();
            String courtName = this.commonDao.getCourtName(Integer.toString(courtId.intValue()));
            if (applicationDetailDTO == null) {
                responseMessage.setResponseStatus(Integer.valueOf(SystemDataInt.MESSAGE_STATUS_UNSUCCESSFUL.value()));
                responseMessage.setResponseText("Application information not found.");
                return responseMessage;
            }
            if (applicationDetailDTO.getStatusId() == "2") {
                responseMessage.setResponseStatus(Integer.valueOf(SystemDataInt.MESSAGE_STATUS_UNSUCCESSFUL.value()));
                responseMessage.setResponseText("Task already claimed/approved/rejected/unclaimed by someone. Please refresh the page to see the updated task.");
                return responseMessage;
            }
            applicationDetailDTO.setApplicationNo(applicationNo);
            applicationDetailDTO.setUpdatedBy(userBean.getUserType());
            applicationDetailDTO.setUpdateDate(new Date());
            applicationDetailDTO.setRemarks(remarks);
            applicationDetailDTO.setStatusId("4");
            applicationDetailDTO.setRejectReasonId(rejectReasonId);
            applicationDetailDTO.setReject_Reason(rejectRemarks);
            applicationDetailDTO.setAppoinmentDate(appoinmentDateApprove);
            applicationDetailDTO.setAppoinmentDate(appoinmentTimeApprove);
            ApplicationDetail applicationDetail = convertApplicationDTOtoEntity(applicationDetailDTO);
            applicationDetail.setReject_Reason(rejectRemarks);
            this.commonDao.saveApplication(applicationDetail);
            WorkFlowDetailDTO workFlowDetailDTO = new WorkFlowDetailDTO();
            Integer workInstanceId = getWorkInstanceId();
            workFlowDetailDTO.setApplicationNo(applicationDetailDTO.getApplicationNo());
            workFlowDetailDTO.setServiceId(applicationDetailDTO.getServiceSlNo());
            workFlowDetailDTO.setApplicationStatusId(Integer.valueOf(4));
            workFlowDetailDTO.setCreatedBy(applicationDetailDTO.getCreatedBy());
            workFlowDetailDTO.setCreatedDate(applicationDetailDTO.getCreatedDate());
            workFlowDetailDTO.setUpdateBy(userBean.getUserType());
            workFlowDetailDTO.setUpdateDate(new Date());
            WorkFlowDetail workFlowDetail = convertWorkFlowDetailDTOtoEntity(workFlowDetailDTO);
            this.commonDao.saveWorkFlowDetail(workFlowDetail);
            TaskDetailDTO taskDetailDTO = new TaskDetailDTO();
            taskDetailDTO.setApplicationNo(applicationDetailDTO.getApplicationNo());
            taskDetailDTO.setServiceId(applicationDetailDTO.getServiceSlNo());
            taskDetailDTO.setApplicationStatus(Integer.valueOf(4));
            taskDetailDTO.setOwner(userBean.getUserType());
            taskDetailDTO.setWorkflowInstanceId(Integer.toString(workInstanceId.intValue()));
            taskDetailDTO.setCreatedBy(applicationDetailDTO.getCreatedBy());
            taskDetailDTO.setCreatedOn(applicationDetailDTO.getCreatedDate());
            taskDetailDTO.setModifiedBy(userBean.getUserType());
            taskDetailDTO.setModifiedOn(new Date());
            TaskDetail taskDetail = convertTaskDetailDTOtoEntity(taskDetailDTO);
            this.commonDao.saveTaskDetail(taskDetail);
            responseMessage.setResponseStatus(Integer.valueOf(SystemDataInt.MESSAGE_STATUS_REJECT.value()));
            responseMessage.setRejectOthers(getRejectReasonOthersById(rejectReasonId));
            responseMessage.setResponseText("Rejected Successfully.");
            System.out.println(responseMessage.getResponseText());
            responseMessage.setCourtName(courtName);
            responseMessage.setMobileNo(applicationDetailDTO.getMobileNo());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return responseMessage;
    }

    public ApplicantDetailDTO getCidDetails(HttpServletRequest request, String cidNo, ApplicantDetailDTO applicantDetailDTO, String serviceId) {
        ApplicantDetailDTO applicantDetailDTO1 = this.commonDao.getcidDetails(request, cidNo, applicantDetailDTO, serviceId);
        return applicantDetailDTO1;
    }

    public ApplicantDetailDTO get_CidDetails(HttpServletRequest request, String spouseCidNo, ApplicantDetailDTO applicantDetailDTO, String serviceId) {
        ApplicantDetailDTO applicantDetailDTO1 = this.commonDao.get_cidDetails(request, spouseCidNo, applicantDetailDTO, serviceId);
        return applicantDetailDTO1;
    }

    public List<DropdownDTO> getRejectOthers() {
        return this.commonDao.getRejectOthers();
    }

    public List<DropdownDTO> getRejectAttest() {
        try {
            return this.commonDao.getRejectAttest();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ResponseMessage checkForAlreadyDivorce(String cidNo, String serviceId) {
        ResponseMessage responseMessage = new ResponseMessage();
        DropdownDTO dropdownDTO = new DropdownDTO();
        dropdownDTO = this.commonDao.getServiceNameCheck(serviceId);
        String serviceName = dropdownDTO.getText();
        int cidCount = this.commonDao.checkForAlreadyExistApplicant(cidNo, serviceId).intValue();
        if (cidCount == 0)
            cidCount = this.commonDao.checkForAlreadyExistSpouse(cidNo, serviceId).intValue();
        if (cidCount > 0) {
            responseMessage.setResponseStatus(Integer.valueOf(SystemDataInt.MESSAGE_STATUS_UNSUCCESSFUL.value()));
            responseMessage.setResponseText("CID No. " + cidNo + " has already applied for " + serviceName + " and it's under process.");
        } else {
            responseMessage.setResponseStatus(Integer.valueOf(SystemDataInt.MESSAGE_STATUS_SUCCESSFUL.value()));
        }
        return responseMessage;
    }

    public ResponseMessage getDivorceDetails(String cidNo) {
        ResponseMessage responseMessage = new ResponseMessage();
        ApplicantDetailDTO applicantDetailDTO = new ApplicantDetailDTO();
        try {
            applicantDetailDTO = this.commonDao.getDivorceDetails(cidNo);
            responseMessage.setCidNo(applicantDetailDTO.getCidNo());
            responseMessage.setSpouseCidNo(applicantDetailDTO.getCidNo());
            responseMessage.setApplicantName(applicantDetailDTO.getApplicantName());
            responseMessage.setSpouseName(applicantDetailDTO.getApplicantName());
            responseMessage.setApplicantName(applicantDetailDTO.getApplicantName());
            responseMessage.setGender(applicantDetailDTO.getGender());
            responseMessage.setApplicant(applicantDetailDTO.getApplicant());
            responseMessage.setSpouseName(applicantDetailDTO.getSpouseName());
        } catch (Exception e) {
            responseMessage.setResponseStatus(Integer.valueOf(SystemDataInt.MESSAGE_STATUS_UNSUCCESSFUL.value()));
            responseMessage.setResponseText("No information found matching CID No " + cidNo);
            return responseMessage;
        }
        responseMessage.setResponseStatus(Integer.valueOf(SystemDataInt.MESSAGE_STATUS_SUCCESSFUL.value()));
        return responseMessage;
    }

    public Object getApplicantName() {
        return this.commonDao.getApplicantName();
    }

    public ResponseMessage getDivorceDetailsWithSpouse(String cidNo) {
        ResponseMessage responseMessage = new ResponseMessage();
        ApplicantDetailDTO applicantDetailDTO = new ApplicantDetailDTO();
        try {
            applicantDetailDTO = this.commonDao.getDivorceDetails(cidNo);
            responseMessage.setCidNo(applicantDetailDTO.getCidNo());
            responseMessage.setSpouseCidNo(applicantDetailDTO.getCidNo());
            responseMessage.setApplicantName(applicantDetailDTO.getApplicantName());
            responseMessage.setSpouseName(applicantDetailDTO.getApplicantName());
            responseMessage.setApplicantName(applicantDetailDTO.getApplicantName());
            responseMessage.setGender(applicantDetailDTO.getGender());
            responseMessage.setApplicant(applicantDetailDTO.getApplicant());
            responseMessage.setSpouseName(applicantDetailDTO.getSpouseName());
        } catch (Exception e) {
            responseMessage.setResponseStatus(Integer.valueOf(SystemDataInt.MESSAGE_STATUS_UNSUCCESSFUL.value()));
            responseMessage.setResponseText("No information found matching CID No " + cidNo);
            return responseMessage;
        }
        responseMessage.setResponseStatus(Integer.valueOf(SystemDataInt.MESSAGE_STATUS_SUCCESSFUL.value()));
        return responseMessage;
    }

    public ResponseMessage checkForMcApplied3Times(String cidNo, String serviceId) {
        ResponseMessage responseMessage = new ResponseMessage();
        List<ApplicationDetailDTO> applicantDetailDTOList=new ArrayList<ApplicationDetailDTO>();
        applicantDetailDTOList=commonDao.getMcData(cidNo);
        applicantDetailDTOList.get(0).getMarital_status();
        int cidCount = this.commonDao.checkForMcApplied3Times(cidNo,serviceId);

        if (cidCount == 3) {
            responseMessage.setResponseStatus(Integer.valueOf(SystemDataInt.MESSAGE_STATUS_UNSUCCESSFUL.value()));
            responseMessage.setResponseText("CID No. " + cidNo + " is has married 3 times and its not allowed by the system");
        } else {
            responseMessage.setResponseStatus(Integer.valueOf(SystemDataInt.MESSAGE_STATUS_SUCCESSFUL.value()));
        }
        return responseMessage;
    }

    public String getStatusId(String cidNo) {
        return this.commonDao.getStatusId(cidNo);
    }

    public ResponseMessage checkApplicantDivorced(String cidNo, String serviceId, String statusId) {
        return this.commonDao.applicantisDivorced(cidNo);
    }

    public ResponseMessage checkForAlreadyMarriedApplicants(String cidNo, String serviceId, String spouseCid, String judgementNo) {
        ResponseMessage responseMessage = new ResponseMessage();
        DropdownDTO dropdownDTO = new DropdownDTO();
        dropdownDTO = this.commonDao.getServiceNameCheck(serviceId);
        String serviceName = dropdownDTO.getText();
        List<ApplicationDetailDTO> applicationDetailDTOs=new ArrayList<ApplicationDetailDTO>();
        applicationDetailDTOs=commonDao.getMcData(cidNo);
        int cidCount = this.commonDao.checkForAlreadyMarriedApplicant(cidNo, serviceId);
       /* if(applicationDetailDTOs.get(0).getMarital_status().equalsIgnoreCase("3")){
                responseMessage.setResponseStatus(Integer.valueOf(SystemDataInt.MESSAGE_STATUS_SUCCESSFUL.value()));
        }*/
       // else {
            if (cidCount == 0)
                cidCount = this.commonDao.checkForAlreadyMarriedSpouse(cidNo, serviceId);
            if (cidCount > 0&&!(applicationDetailDTOs.get(0).getMarital_status().equalsIgnoreCase("3"))) {
                responseMessage.setResponseStatus(Integer.valueOf(SystemDataInt.MESSAGE_STATUS_UNSUCCESSFUL.value()));
                responseMessage.setResponseText("CID No. " + cidNo + " is married with " + spouseCid + " and it's judgement no is:." + judgementNo);
            } else {
                responseMessage.setResponseStatus(Integer.valueOf(SystemDataInt.MESSAGE_STATUS_SUCCESSFUL.value()));
            }
        return responseMessage;
    }

    public ResponseMessage getCreatedDate(String cidNo, String serviceId) {
        ResponseMessage responseMessage=new ResponseMessage();
        List<ApplicationDetailDTO> applicationDetailDTO=commonDao.getCreatedDate(cidNo,serviceId);
        applicationDetailDTO.get(0).getCreatedDate();
        //String dates= String.valueOf(applicationDetailDTO.get(0).getCreatedDate());
        //LocalDate date=LocalDate.parse(dates);
        try {
            SimpleDateFormat dateFormat1=new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat dateFormat=new SimpleDateFormat("hh:mm:ss");
            SimpleDateFormat dateFormat2=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            Date createdDate=dateFormat2.parse(String.valueOf(applicationDetailDTO.get(0).getCreatedDate()));
            String createdDat= String.valueOf(applicationDetailDTO.get(0).getCreatedDate());
            Date newDate = new Date();
            String newDates=dateFormat1.format(newDate);
            String newTime=dateFormat.format(newDate.getTime());
            String newestDate=newDates+("")+newTime;
           /* final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
            final LocalDate firstDate = LocalDate.parse(createdDat,formatter);
            final LocalDate secondDate = LocalDate.parse(newestDate,formatter);*/
            long dateDifference=Math.abs(createdDate.getTime() - newDate.getTime());
            long times=dateDifference/(24 * 60 * 60 * 1000);
            System.out.print(times);
            System.out.println(dateDifference);
            //System.out.print(noOfDaysBetween);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        responseMessage.setResponseDTO(applicationDetailDTO);
        return responseMessage;
    }

    public ResponseMessage getHouseholdDetails(String houseHoldNo) {
        RestTemplate restTemplate = new RestTemplate();
        JSONParser parse = new JSONParser();
        Object obj = new Object();
        JSONArray jsonarr_1 = new JSONArray();

        JSONObject jobj = new JSONObject();

       // String houseHoldNo = "121100201";
        String userHouseDetials = "https://datahub-apim.dit.gov.bt/dcrc_family_details_api/1.0.0/familyDetailsByHouseHoldNo/"+houseHoldNo;

        try {
            //Generate token
            Token token = api.getApplicationToken();

            // create headers
            HttpHeaders headers = new HttpHeaders();
            headers.set("Content-Type", "application/json");
            headers.set("Authorization", "Bearer 4f3af75f-2211-3c9d-9bea-e00847bf5931");

            String jsonStr = "";
            System.out.print("ccccccccccccccccccccccccccccccc");
            //HttpEntity request1 = new HttpEntity(jsonStr, headers);
            HttpEntity<String> request1 = new HttpEntity<String>(headers);
            ResponseEntity<?> response = restTemplate.exchange(userHouseDetials, HttpMethod.GET, request1, Objects.class);
            System.out.print(response.getBody());
        }catch (ParseException e){
            e.printStackTrace();
        }
        return null;
    }
}

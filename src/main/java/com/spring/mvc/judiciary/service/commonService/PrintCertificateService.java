package com.spring.mvc.judiciary.service.commonService;

import com.spring.mvc.enumeration.SystemDataInt;
import com.spring.mvc.helper.ResponseMessage;
import com.spring.mvc.judiciary.dao.CommonDao;
import com.spring.mvc.judiciary.dao.PrintCertificateDao;
import com.spring.mvc.judiciary.dto.ApplicantDetailDTO;
import com.spring.mvc.judiciary.dto.ApplicationDetailDTO;
import com.spring.mvc.judiciary.dto.SpouseDetailsDTO;
import net.sf.jasperreports.engine.JRException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by USER on 9/13/2019.
 */
@Service
public class PrintCertificateService {
    @Autowired
    private CommonService commonService;

    @Autowired
    private PrintCertificateDao certificateDao;

    @Autowired
    private CommonDao commonDao;

    //region connection manager
    protected EntityManager em;

    @PersistenceContext(unitName = "default")
    public void setEm(EntityManager em) {
        this.em = em;
    }

    protected Session getCurrentSession() {
        return em.unwrap(Session.class);
    }
    //endregion

    public ResponseMessage getCertificateList(Integer serviceId, String courtId) {
        ResponseMessage responseMessage = new ResponseMessage();
        List<ApplicationDetailDTO> applicationDetailDTOs;
        if(serviceId == 501){
           applicationDetailDTOs = certificateDao.getCertificateListMC(serviceId,courtId);
        } else {
            applicationDetailDTOs = certificateDao.getCertificateList(serviceId,courtId);
        }

        if (applicationDetailDTOs != null) {
            responseMessage.setResponseStatus(SystemDataInt.MESSAGE_STATUS_SUCCESSFUL.value());
            responseMessage.setResponseDTO(applicationDetailDTOs);
        } else {
            responseMessage.setResponseStatus(SystemDataInt.MESSAGE_STATUS_UNSUCCESSFUL.value());
            responseMessage.setResponseText("Result not found.");
        }
        return responseMessage;
    }

    @Transactional
    public ResponseMessage printCertificate(String applicationNo) throws JRException, ClassNotFoundException, SQLException {
        ResponseMessage responseMessage = new ResponseMessage();
        ApplicationDetailDTO applicationDetailDTO = new ApplicationDetailDTO();
        ApplicantDetailDTO applicantDetailDTO = new ApplicantDetailDTO();
        SpouseDetailsDTO spouseDetailsDTO = new SpouseDetailsDTO();
        if(applicationNo.startsWith("501")){
             applicantDetailDTO = certificateDao.getHusbandDetail(applicationNo);
             spouseDetailsDTO = certificateDao.getWifeDetail(applicationNo);
            applicationDetailDTO = certificateDao.getPrintApplicationDetailMC(applicationNo);
        }
        if(applicationDetailDTO != null){
            responseMessage.setResponseText("Printed Successfully.");
            responseMessage.setResponseStatus(SystemDataInt.MESSAGE_STATUS_SUCCESSFUL.value());
            responseMessage.setMobileNo(applicationDetailDTO.getMobileNo());
            responseMessage.setCourtName(applicationDetailDTO.getCourtName());
            responseMessage.setApplicantDTO(applicantDetailDTO);
            responseMessage.setSpouseDTO(spouseDetailsDTO);
            responseMessage.setResponseDTO(applicationDetailDTO);
            return responseMessage;
        }
        return responseMessage;
    }

    public ApplicantDetailDTO getHusbandDetail(String applicationNo) {
        return certificateDao.getHusbandDetail(applicationNo);
    }
    public SpouseDetailsDTO getWifeDetail(String applicationNo) {
        return certificateDao.getWifeDetail(applicationNo);
    }
    public ApplicationDetailDTO getPrintApplicationDetailMC(String applicationNo) {
        return certificateDao.getPrintApplicationDetailMC(applicationNo);
    }

}

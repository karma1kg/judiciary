package com.spring.mvc.judiciary.dto;

/**
 * Created by USER on 7/30/2019.
 */
public class CitizenDetailDTO {
    //region private variables
    private String cidNo;
    private String applicantDob;
    private String ApplicantDobBh;
    private String dzongkhagId;
    private String fatherName;
    private String gender;
    private String gewogId;
    private String houseNo;
    private String mobileNo;
    private String motherName;
    private String applicantName;
    private String nationality;
    private String tharmNo;
    private String villageId;

    // for Spouse Details
    private String spouseCidNo;
    private String spouseApplicantDob;
    private String spouseName;
    private String spouseGender;
    private String spouseFathersName;
    private String spouseMothersName;
    private String spouseVillageId;
    private String spouseDzongkhagId;
    private String spouseGewogId;
    private String spouseHouseNo;
    private String spouseTharmNo;
    private String spouseNationality;
    private String spouseReligion;

    // MALE WITNESS DETAILS
    private String witness1CidNo;
    private String witness1Name;
    private String w1Dob;
    private String w1Gender;
    private String w1fathersName;
    private String w1mothersName;
    private String w1villageId;
    private String w1dzongkhagId;
    private String w1gewogId;
    private String w1houseNo;
    private String w1tharmNo;

    // FEMALE WITNESS DETAILS
    private String witness2CidNo;
    private String witness2Name;
    private String w2Dob;
    private String w2gender;
    private String w2fathersName;
    private String w2mothersName;
    private String w2villageId;
    private String w2dzongkhagId;
    private String w2gewogId;
    private String w2houseNo;
    private String w2tharmNo;

    ///ORIGINAL PARENTS RELATED
    /*Biological Father Details*/
    private String orgFatherCid;
    private String orgFatherDob;
    private String orgFatherName;
    private String orgFatherGender;
    private String orgFatherFathersName;
    private String orgFatherDzongkhagId;
    private String orgFatherVillageId;
    private String orgFatherGewogId;
    private String orgFatherHouseNo;
    private String orgFatherTharmNo;

    /*Biological Mother Details*/
    private String orgMotherCid;
    private String orgMotherDob;
    private String orgMotherName;
    private String orgMotherGender;
    private String orgMotherFathersName;
    private String orgMotherDzongkhagId;
    private String orgMotherVillageId;
    private String orgMotherGewogId;
    private String orgMotherHouseNo;
    private String orgMotherTharmNo;

    ///FOR KIDNEY TRANSPLANT
//patient
    private String patientCid;
    private String patientDob;
    private String patientName;
    private String patientGender;
    private String patientFathersName;
    private String patientDzongkhagId;
    private String patientVillageId;
    private String patientGewogId;
    private String patientHouseNo;
    private String patientTharmNo;
    private String patientDonorRelationship;

    //donor
    private String donorCid;
    private String donorDob;
    private String donorName;
    private String donorGender;
    private String donorFathersName;
    private String donorDzongkhagId;
    private String donorVillageId;
    private String donorGewogId;
    private String donorHouseNo;
    private String donorTharmNo;
    private String donorDepRelationship;

    //donor Dependent Details
    private String donorDepCid;
    private String donorDepDob;
    private String donorDepName;
    private String donorDepGender;
    private String donorDepFathersName;
    private String donorDepDzongkhagId;
    private String donorDepVillageId;
    private String donorDepGewogId;
    private String donorDepHouseNo;
    private String donorDepTharmNo;
    private String depRelationship;

    //Transferor Details
    private String transferorApplicantCid;
    private String transferorApplicantDob;
    private String transferorApplicantName;
    private String transferorGender;
    private String transferorFathersName;
    private String transferorMothersName;
    private String transferorDzongkhagId;
    private String transferorVillageId;
    private String transferorGewogId;
    private String transferorHouseNo;
    private String transferorTharmNo;
    private String agencyCode;
    private String houseHoldNo;
    private String dzongkhagName;
    private String gewogName;
    private String villageName;
    public String getAgencyCode() {
        return agencyCode;
    }

    public void setAgencyCode(String agencyCode) {
        this.agencyCode = agencyCode;
    }

    /* private String fathersName;
    private String mothersName;
    private String villageId;
    private String dzongkhagId;
    private String gewogId;
    private String houseNo;
    private String tharmNo;
    private String mobileNo;
    private String emailId;
    private String address;
    private String courtId;
    private String courtName;
    private String serviceId;
    private String dateOfAppointment;
    private String reason;
    private String applType;
    private String taskId;
    private String taskInstanceId;
    private String nationality;
    private String status;
    private String statusId;
    private String country;
    private String srpNo;

    private String fromDate;
    private String toDate;
    private String ageFrom;
    private String ageTo;
    private String totalCount;
    private String receiptAmount;
    private String receiptDate;
    private String print;
    private String lostDoc;
    private String bankName;
    private String accNo;
    private String confirmMarried;
    private String mcCount;
    private String applicationIdDzo;
    private String judgementNoDzo;
    private String dateDzo;
    private String kuenselDate;
    private String indexNo;
    private String standard;
    private String yearOfExam;
    private String docName;
    private String lunarDateDzo;
    private String lawyerDzo;
    private String travelReason;
    private String childPassportNo;
    private String appPassportNo;
    private String regDate;
    private String regNo;
    private String actionBy;
    private String actionDate;
    private String userName;


    *//*For Verifier at ViewList Page*//*
    private String remarks;
    private String appointmentDate;
    private String submittedBy;


    //FOR SUBMISSION INTO REGISTER BY THE DATA MANAGER(DATA ENTRY PART)////
//COMMON
    private String caseNo;
    private String judgementNo;
    private String judgementNoMc;
    private String judgementDate;
    private String date;
    private String clerk;
    private String lawyer;
    private String receiptNo;
    private String referenceNo;

    //Extra(New Register)
//SINGLE/MARITAL STATUS
    private String hearingDate;
    private String letterNo;
    private String letterDate;
    private String issueDateBhutan;

    ///Register Different
    private String oldName;
    private String newName;
    private String mcNo;
    private String issueCourt;
    private String issueDate;

    ///ORIGINAL PARENTS RELATED
    private String orgFatherCid;
    private String orgFatherDob;
    private String orgFatherName;
    private String orgFatherGender;
    private String orgFatherFathersName;
    private String orgFatherDzongkhagId;
    private String orgFatherVillageId;
    private String orgFatherGewogId;
    private String orgFatherHouseNo;
    private String orgFatherTharmNo;
    private String orgMotherCid;
    private String orgMotherDob;
    private String orgMotherName;
    private String orgMotherGender;
    private String orgMotherFathersName;
    private String orgMotherDzongkhagId;
    private String orgMotherVillageId;
    private String orgMotherGewogId;
    private String orgMotherHouseNo;
    private String orgMotherTharmNo;

    ////ADOPTING PARENTS RELATED
    private String adoptFatherCid;
    private String adoptFatherDob;
    private String adoptFatherName;
    private String adoptFatherGender;
    private String adoptFatherFathersName;
    private String adoptFatherDzongkhagName;
    private String adoptFatherVillageName;
    private String adoptFatherGewogName;
    private String adoptFatherDzongkhagId;
    private String adoptFatherVillageId;
    private String adoptFatherGewogId;
    private String adoptFatherHouseNo;
    private String adoptFatherTharmNo;
    private String adoptMotherCid;
    private String adoptMotherDob;
    private String adoptMotherName;
    private String adoptMotherGender;
    private String adoptMotherFathersName;
    private String adoptMotherDzongkhagName;
    private String adoptMotherVillageName;
    private String adoptMotherGewogName;
    private String adoptMotherHouseNo;
    private String adoptMotherTharmNo;

    ///ADOPTION WITNESS RELATED
    private String orgWitnessCid;
    private String orgWitnessDob;
    private String orgWitnessName;
    private String adoptWitnessCid;
    private String adoptWitnessDob;
    private String adoptWitnessName;


    //closing and transfer of Shares
    private String transfereeApplicantCid;
    private String transfereeApplicantDob;
    private String transfereeApplicantName;
    private String transfereeGender;
    private String transfereeFathersName;
    private String transfereeDzongkhagId;
    private String transfereeVillageId;
    private String transfereeGewogId;
    private String transfereeHouseNo;
    private String transfereeTharmNo;
    private String transferorApplicantCid;
    private String transferorApplicantDob;
    private String transferorApplicantName;
    private String transferorGender;
    private String transferorFathersName;
    private String transferorDzongkhagId;
    private String transferorVillageId;
    private String transferorGewogId;
    private String transferorHouseNo;
    private String transferorTharmNo;
    private String relationship;

    ///MARRIAGE CERTIFICATE
///Census Form no
    private String censusFormNo;
    private String spouseCensusFormNo;
    //Witness Details
    private String maleWitnessCid;
    private String maleWitnessDob;
    private String maleWitnessName;
    private String maleWitnessGender;
    private String maleWitnessFathersName;
    private String maleWitnessDzongkhagId;
    private String maleWitnessVillageId;
    private String maleWitnessGewogId;
    private String maleWitnessHouseNo;
    private String maleWitnessTharmNo;

    private String femaleWitnessCid;
    private String femaleWitnessDob;
    private String femaleWitnessName;
    private String femaleWitnessGender;
    private String femaleWitnessFathersName;
    private String femaleWitnessDzongkhagId;
    private String femaleWitnessVillageId;
    private String femaleWitnessGewogId;
    private String femaleWitnessHouseNo;
    private String femaleWitnessTharmNo;

    ///FOR KIDNEY TRANSPLANT
//patient
    private String patientCid;
    private String patientAge;
    private String patientDob;
    private String patientName;
    private String patientGender;
    private String patientFathersName;
    private String patientDzongkhagId;
    private String patientDzongkhagName;
    private String patientVillageId;
    private String patientVillageName;
    private String patientGewogId;
    private String patientGewogName;
    private String patientDonorRelationship;

    private String cmcNo;
    private String dateFormat;
    //Patient witness
    private String patientWitnessCid;
    private String patientWitnessDob;
    private String patientWitnessName;
    private String patientWitnessGender;
    private String patientWitnessFathersName;
    private String patientWitnessDzongkhagId;
    private String patientWitnessVillageId;
    private String patientWitnessGewogId;
    private String patientWitness2Cid;
    private String patientWitness2Dob;
    private String patientWitness2Name;
    private String patientWitness2Gender;
    private String patientWitness2FathersName;
    private String patientWitness2DzongkhagId;
    private String patientWitness2VillageId;
    private String patientWitness2GewogId;

    private String patientWitnessVillageName;
    private String patientWitness2VillageName;
    private String patientWitnessGewogName;
    private String patientWitness2GewogName;
    private String patientWitnessDzongkhagName;
    private String patientWitness2DzongkhagName;

    //donor
    private String donorAge;
    private String donorCid;
    private String donorDob;
    private String donorName;
    private String donorGender;
    private String donorFathersName;
    private String donorDzongkhagId;
    private String donorDzongkhagName;
    private String donorVillageId;
    private String donorVillageName;
    private String donorGewogId;
    private String donorGewogName;
    private String donorDepRelationship;
    //donor Dependent Details
    private String donorDepAge;
    private String donorDepCid;
    private String donorDepDob;
    private String donorDepName;
    private String donorDepGender;
    private String donorDepFathersName;
    private String donorDepDzongkhagId;
    private String donorDepDzongkhagName;
    private String donorDepVillageId;
    private String donorDepVillageName;
    private String donorDepGewogId;
    private String donorDepGewogName;
    private String depRelationship;
    private String hospitalName;
    //Donor Dependent witness
    private String donorDepWitnessCid;
    private String donorDepWitnessDob;
    private String donorDepWitnessName;
    private String donorDepWitnessGender;
    private String donorDepWitnessFathersName;
    private String donorDepWitnessDzongkhagId;
    private String donorDepWitnessVillageId;
    private String donorDepWitnessGewogId;
    private String donorDepWitness2Cid;
    private String donorDepWitness2Dob;
    private String donorDepWitness2Name;
    private String donorDepWitness2Gender;
    private String donorDepWitness2FathersName;
    private String donorDepWitness2DzongkhagId;
    private String donorDepWitness2VillageId;
    private String donorDepWitness2GewogId;

    private String donorDepWitnessVillageName;
    private String donorDepWitness2VillageName;
    private String donorDepWitnessGewogName;
    private String donorDepWitness2GewogName;
    private String donorDepWitnessDzongkhagName;
    private String donorDepWitness2DzongkhagName;

    //Donor witness
    private String donorWitnessCid;
    private String donorWitnessDob;
    private String donorWitnessName;
    private String donorWitnessGender;
    private String donorWitnessFathersName;
    private String donorWitnessDzongkhagId;
    private String donorWitnessVillageId;
    private String donorWitnessGewogId;
    private String donorWitness2Cid;
    private String donorWitness2Dob;
    private String donorWitness2Name;
    private String donorWitness2Gender;
    private String donorWitness2FathersName;
    private String donorWitness2DzongkhagId;
    private String donorWitness2VillageId;
    private String donorWitness2GewogId;

    private String donorWitnessVillageName;
    private String donorWitness2VillageName;
    private String donorWitnessGewogName;
    private String donorWitness2GewogName;
    private String donorWitnessDzongkhagName;
    private String donorWitness2DzongkhagName;

    /////TO VIEW AS NAME
    private String gewogName;
    private String dzongkhagName;
    private String villageName;
    private String spouseGewogName;
    private String spouseDzongkhagName;
    private String spouseVillageName;
    private String orgFatherGewogName;
    private String orgFatherDzongkhagName;
    private String orgFatherVillageName;
    private String orgMotherGewogName;
    private String orgMotherDzongkhagName;
    private String orgMotherVillageName;

    ///CHILD TRAVEL DOCS
    private String childAge;
    private String travelPlace;*/

    public String getCidNo() {
        return cidNo;
    }

    public void setCidNo(String cidNo) {
        this.cidNo = cidNo;
    }

    public String getApplicantDob() {
        return applicantDob;
    }

    public void setApplicantDob(String applicantDob) {
        this.applicantDob = applicantDob;
    }

    public String getDzongkhagId() {
        return dzongkhagId;
    }

    public void setDzongkhagId(String dzongkhagId) {
        this.dzongkhagId = dzongkhagId;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getGewogId() {
        return gewogId;
    }

    public void setGewogId(String gewogId) {
        this.gewogId = gewogId;
    }

    public String getHouseNo() {
        return houseNo;
    }

    public void setHouseNo(String houseNo) {
        this.houseNo = houseNo;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getMotherName() {
        return motherName;
    }

    public void setMotherName(String motherName) {
        this.motherName = motherName;
    }

    public String getApplicantName() {
        return applicantName;
    }

    public void setApplicantName(String applicantName) {
        this.applicantName = applicantName;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getTharmNo() {
        return tharmNo;
    }

    public void setTharmNo(String tharmNo) {
        this.tharmNo = tharmNo;
    }

    public String getVillageId() {
        return villageId;
    }

    public void setVillageId(String villageId) {
        this.villageId = villageId;
    }

    public String getSpouseCidNo() {
        return spouseCidNo;
    }

    public void setSpouseCidNo(String spouseCidNo) {
        this.spouseCidNo = spouseCidNo;
    }

    public String getSpouseApplicantDob() {
        return spouseApplicantDob;
    }

    public void setSpouseApplicantDob(String spouseApplicantDob) {
        this.spouseApplicantDob = spouseApplicantDob;
    }

    public String getSpouseName() {
        return spouseName;
    }

    public void setSpouseName(String spouseName) {
        this.spouseName = spouseName;
    }

    public String getSpouseGender() {
        return spouseGender;
    }

    public void setSpouseGender(String spouseGender) {
        this.spouseGender = spouseGender;
    }

    public String getSpouseFathersName() {
        return spouseFathersName;
    }

    public void setSpouseFathersName(String spouseFathersName) {
        this.spouseFathersName = spouseFathersName;
    }

    public String getSpouseMothersName() {
        return spouseMothersName;
    }

    public void setSpouseMothersName(String spouseMothersName) {
        this.spouseMothersName = spouseMothersName;
    }

    public String getSpouseVillageId() {
        return spouseVillageId;
    }

    public void setSpouseVillageId(String spouseVillageId) {
        this.spouseVillageId = spouseVillageId;
    }

    public String getSpouseDzongkhagId() {
        return spouseDzongkhagId;
    }

    public void setSpouseDzongkhagId(String spouseDzongkhagId) {
        this.spouseDzongkhagId = spouseDzongkhagId;
    }

    public String getSpouseGewogId() {
        return spouseGewogId;
    }

    public void setSpouseGewogId(String spouseGewogId) {
        this.spouseGewogId = spouseGewogId;
    }

    public String getSpouseHouseNo() {
        return spouseHouseNo;
    }

    public void setSpouseHouseNo(String spouseHouseNo) {
        this.spouseHouseNo = spouseHouseNo;
    }

    public String getSpouseTharmNo() {
        return spouseTharmNo;
    }

    public void setSpouseTharmNo(String spouseTharmNo) {
        this.spouseTharmNo = spouseTharmNo;
    }

    public String getSpouseNationality() {
        return spouseNationality;
    }

    public void setSpouseNationality(String spouseNationality) {
        this.spouseNationality = spouseNationality;
    }

    public String getSpouseReligion() {
        return spouseReligion;
    }

    public void setSpouseReligion(String spouseReligion) {
        this.spouseReligion = spouseReligion;
    }

    public String getWitness1CidNo() {
        return witness1CidNo;
    }

    public void setWitness1CidNo(String witness1CidNo) {
        this.witness1CidNo = witness1CidNo;
    }

    public String getWitness1Name() {
        return witness1Name;
    }

    public void setWitness1Name(String witness1Name) {
        this.witness1Name = witness1Name;
    }

    public String getW1Dob() {
        return w1Dob;
    }

    public void setW1Dob(String w1Dob) {
        this.w1Dob = w1Dob;
    }

    public String getW1Gender() {
        return w1Gender;
    }

    public void setW1Gender(String w1Gender) {
        this.w1Gender = w1Gender;
    }

    public String getW1fathersName() {
        return w1fathersName;
    }

    public void setW1fathersName(String w1fathersName) {
        this.w1fathersName = w1fathersName;
    }

    public String getW1mothersName() {
        return w1mothersName;
    }

    public void setW1mothersName(String w1mothersName) {
        this.w1mothersName = w1mothersName;
    }

    public String getW1villageId() {
        return w1villageId;
    }

    public void setW1villageId(String w1villageId) {
        this.w1villageId = w1villageId;
    }

    public String getW1dzongkhagId() {
        return w1dzongkhagId;
    }

    public void setW1dzongkhagId(String w1dzongkhagId) {
        this.w1dzongkhagId = w1dzongkhagId;
    }

    public String getW1gewogId() {
        return w1gewogId;
    }

    public void setW1gewogId(String w1gewogId) {
        this.w1gewogId = w1gewogId;
    }

    public String getW1houseNo() {
        return w1houseNo;
    }

    public void setW1houseNo(String w1houseNo) {
        this.w1houseNo = w1houseNo;
    }

    public String getW1tharmNo() {
        return w1tharmNo;
    }

    public void setW1tharmNo(String w1tharmNo) {
        this.w1tharmNo = w1tharmNo;
    }

    public String getWitness2CidNo() {
        return witness2CidNo;
    }

    public void setWitness2CidNo(String witness2CidNo) {
        this.witness2CidNo = witness2CidNo;
    }

    public String getWitness2Name() {
        return witness2Name;
    }

    public void setWitness2Name(String witness2Name) {
        this.witness2Name = witness2Name;
    }

    public String getW2Dob() {
        return w2Dob;
    }

    public void setW2Dob(String w2Dob) {
        this.w2Dob = w2Dob;
    }

    public String getW2gender() {
        return w2gender;
    }

    public void setW2gender(String w2gender) {
        this.w2gender = w2gender;
    }

    public String getW2fathersName() {
        return w2fathersName;
    }

    public void setW2fathersName(String w2fathersName) {
        this.w2fathersName = w2fathersName;
    }

    public String getW2mothersName() {
        return w2mothersName;
    }

    public void setW2mothersName(String w2mothersName) {
        this.w2mothersName = w2mothersName;
    }

    public String getW2villageId() {
        return w2villageId;
    }

    public void setW2villageId(String w2villageId) {
        this.w2villageId = w2villageId;
    }

    public String getW2dzongkhagId() {
        return w2dzongkhagId;
    }

    public void setW2dzongkhagId(String w2dzongkhagId) {
        this.w2dzongkhagId = w2dzongkhagId;
    }

    public String getW2gewogId() {
        return w2gewogId;
    }

    public void setW2gewogId(String w2gewogId) {
        this.w2gewogId = w2gewogId;
    }

    public String getW2houseNo() {
        return w2houseNo;
    }

    public void setW2houseNo(String w2houseNo) {
        this.w2houseNo = w2houseNo;
    }

    public String getW2tharmNo() {
        return w2tharmNo;
    }

    public void setW2tharmNo(String w2tharmNo) {
        this.w2tharmNo = w2tharmNo;
    }

    public String getOrgFatherCid() {
        return orgFatherCid;
    }

    public void setOrgFatherCid(String orgFatherCid) {
        this.orgFatherCid = orgFatherCid;
    }

    public String getOrgFatherDob() {
        return orgFatherDob;
    }

    public void setOrgFatherDob(String orgFatherDob) {
        this.orgFatherDob = orgFatherDob;
    }

    public String getOrgFatherName() {
        return orgFatherName;
    }

    public void setOrgFatherName(String orgFatherName) {
        this.orgFatherName = orgFatherName;
    }

    public String getOrgFatherGender() {
        return orgFatherGender;
    }

    public void setOrgFatherGender(String orgFatherGender) {
        this.orgFatherGender = orgFatherGender;
    }

    public String getOrgFatherFathersName() {
        return orgFatherFathersName;
    }

    public void setOrgFatherFathersName(String orgFatherFathersName) {
        this.orgFatherFathersName = orgFatherFathersName;
    }

    public String getOrgFatherDzongkhagId() {
        return orgFatherDzongkhagId;
    }

    public void setOrgFatherDzongkhagId(String orgFatherDzongkhagId) {
        this.orgFatherDzongkhagId = orgFatherDzongkhagId;
    }

    public String getOrgFatherVillageId() {
        return orgFatherVillageId;
    }

    public void setOrgFatherVillageId(String orgFatherVillageId) {
        this.orgFatherVillageId = orgFatherVillageId;
    }

    public String getOrgFatherGewogId() {
        return orgFatherGewogId;
    }

    public void setOrgFatherGewogId(String orgFatherGewogId) {
        this.orgFatherGewogId = orgFatherGewogId;
    }

    public String getOrgFatherHouseNo() {
        return orgFatherHouseNo;
    }

    public void setOrgFatherHouseNo(String orgFatherHouseNo) {
        this.orgFatherHouseNo = orgFatherHouseNo;
    }

    public String getOrgFatherTharmNo() {
        return orgFatherTharmNo;
    }

    public void setOrgFatherTharmNo(String orgFatherTharmNo) {
        this.orgFatherTharmNo = orgFatherTharmNo;
    }

    public String getOrgMotherCid() {
        return orgMotherCid;
    }

    public void setOrgMotherCid(String orgMotherCid) {
        this.orgMotherCid = orgMotherCid;
    }

    public String getOrgMotherDob() {
        return orgMotherDob;
    }

    public void setOrgMotherDob(String orgMotherDob) {
        this.orgMotherDob = orgMotherDob;
    }

    public String getOrgMotherName() {
        return orgMotherName;
    }

    public void setOrgMotherName(String orgMotherName) {
        this.orgMotherName = orgMotherName;
    }

    public String getOrgMotherGender() {
        return orgMotherGender;
    }

    public void setOrgMotherGender(String orgMotherGender) {
        this.orgMotherGender = orgMotherGender;
    }

    public String getOrgMotherFathersName() {
        return orgMotherFathersName;
    }

    public void setOrgMotherFathersName(String orgMotherFathersName) {
        this.orgMotherFathersName = orgMotherFathersName;
    }

    public String getOrgMotherDzongkhagId() {
        return orgMotherDzongkhagId;
    }

    public void setOrgMotherDzongkhagId(String orgMotherDzongkhagId) {
        this.orgMotherDzongkhagId = orgMotherDzongkhagId;
    }

    public String getOrgMotherVillageId() {
        return orgMotherVillageId;
    }

    public void setOrgMotherVillageId(String orgMotherVillageId) {
        this.orgMotherVillageId = orgMotherVillageId;
    }

    public String getOrgMotherGewogId() {
        return orgMotherGewogId;
    }

    public void setOrgMotherGewogId(String orgMotherGewogId) {
        this.orgMotherGewogId = orgMotherGewogId;
    }

    public String getOrgMotherHouseNo() {
        return orgMotherHouseNo;
    }

    public void setOrgMotherHouseNo(String orgMotherHouseNo) {
        this.orgMotherHouseNo = orgMotherHouseNo;
    }

    public String getOrgMotherTharmNo() {
        return orgMotherTharmNo;
    }

    public void setOrgMotherTharmNo(String orgMotherTharmNo) {
        this.orgMotherTharmNo = orgMotherTharmNo;
    }

    public String getPatientCid() {
        return patientCid;
    }

    public void setPatientCid(String patientCid) {
        this.patientCid = patientCid;
    }

    public String getPatientDob() {
        return patientDob;
    }

    public void setPatientDob(String patientDob) {
        this.patientDob = patientDob;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getPatientGender() {
        return patientGender;
    }

    public void setPatientGender(String patientGender) {
        this.patientGender = patientGender;
    }

    public String getPatientFathersName() {
        return patientFathersName;
    }

    public void setPatientFathersName(String patientFathersName) {
        this.patientFathersName = patientFathersName;
    }

    public String getPatientDzongkhagId() {
        return patientDzongkhagId;
    }

    public void setPatientDzongkhagId(String patientDzongkhagId) {
        this.patientDzongkhagId = patientDzongkhagId;
    }

    public String getPatientVillageId() {
        return patientVillageId;
    }

    public void setPatientVillageId(String patientVillageId) {
        this.patientVillageId = patientVillageId;
    }

    public String getPatientGewogId() {
        return patientGewogId;
    }

    public void setPatientGewogId(String patientGewogId) {
        this.patientGewogId = patientGewogId;
    }

    public String getPatientHouseNo() {
        return patientHouseNo;
    }

    public void setPatientHouseNo(String patientHouseNo) {
        this.patientHouseNo = patientHouseNo;
    }

    public String getPatientTharmNo() {
        return patientTharmNo;
    }

    public void setPatientTharmNo(String patientTharmNo) {
        this.patientTharmNo = patientTharmNo;
    }

    public String getPatientDonorRelationship() {
        return patientDonorRelationship;
    }

    public void setPatientDonorRelationship(String patientDonorRelationship) {
        this.patientDonorRelationship = patientDonorRelationship;
    }

    public String getDonorCid() {
        return donorCid;
    }

    public void setDonorCid(String donorCid) {
        this.donorCid = donorCid;
    }

    public String getDonorDob() {
        return donorDob;
    }

    public void setDonorDob(String donorDob) {
        this.donorDob = donorDob;
    }

    public String getDonorName() {
        return donorName;
    }

    public void setDonorName(String donorName) {
        this.donorName = donorName;
    }

    public String getDonorGender() {
        return donorGender;
    }

    public void setDonorGender(String donorGender) {
        this.donorGender = donorGender;
    }

    public String getDonorFathersName() {
        return donorFathersName;
    }

    public void setDonorFathersName(String donorFathersName) {
        this.donorFathersName = donorFathersName;
    }

    public String getDonorDzongkhagId() {
        return donorDzongkhagId;
    }

    public void setDonorDzongkhagId(String donorDzongkhagId) {
        this.donorDzongkhagId = donorDzongkhagId;
    }

    public String getDonorVillageId() {
        return donorVillageId;
    }

    public void setDonorVillageId(String donorVillageId) {
        this.donorVillageId = donorVillageId;
    }

    public String getDonorGewogId() {
        return donorGewogId;
    }

    public void setDonorGewogId(String donorGewogId) {
        this.donorGewogId = donorGewogId;
    }

    public String getDonorHouseNo() {
        return donorHouseNo;
    }

    public void setDonorHouseNo(String donorHouseNo) {
        this.donorHouseNo = donorHouseNo;
    }

    public String getDonorTharmNo() {
        return donorTharmNo;
    }

    public void setDonorTharmNo(String donorTharmNo) {
        this.donorTharmNo = donorTharmNo;
    }

    public String getDonorDepRelationship() {
        return donorDepRelationship;
    }

    public void setDonorDepRelationship(String donorDepRelationship) {
        this.donorDepRelationship = donorDepRelationship;
    }

    public String getDonorDepCid() {
        return donorDepCid;
    }

    public void setDonorDepCid(String donorDepCid) {
        this.donorDepCid = donorDepCid;
    }

    public String getDonorDepDob() {
        return donorDepDob;
    }

    public void setDonorDepDob(String donorDepDob) {
        this.donorDepDob = donorDepDob;
    }

    public String getDonorDepName() {
        return donorDepName;
    }

    public void setDonorDepName(String donorDepName) {
        this.donorDepName = donorDepName;
    }

    public String getDonorDepGender() {
        return donorDepGender;
    }

    public void setDonorDepGender(String donorDepGender) {
        this.donorDepGender = donorDepGender;
    }

    public String getDonorDepFathersName() {
        return donorDepFathersName;
    }

    public void setDonorDepFathersName(String donorDepFathersName) {
        this.donorDepFathersName = donorDepFathersName;
    }

    public String getDonorDepDzongkhagId() {
        return donorDepDzongkhagId;
    }

    public void setDonorDepDzongkhagId(String donorDepDzongkhagId) {
        this.donorDepDzongkhagId = donorDepDzongkhagId;
    }

    public String getDonorDepVillageId() {
        return donorDepVillageId;
    }

    public void setDonorDepVillageId(String donorDepVillageId) {
        this.donorDepVillageId = donorDepVillageId;
    }

    public String getDonorDepGewogId() {
        return donorDepGewogId;
    }

    public void setDonorDepGewogId(String donorDepGewogId) {
        this.donorDepGewogId = donorDepGewogId;
    }

    public String getDonorDepHouseNo() {
        return donorDepHouseNo;
    }

    public void setDonorDepHouseNo(String donorDepHouseNo) {
        this.donorDepHouseNo = donorDepHouseNo;
    }

    public String getDonorDepTharmNo() {
        return donorDepTharmNo;
    }

    public void setDonorDepTharmNo(String donorDepTharmNo) {
        this.donorDepTharmNo = donorDepTharmNo;
    }

    public String getDepRelationship() {
        return depRelationship;
    }

    public void setDepRelationship(String depRelationship) {
        this.depRelationship = depRelationship;
    }

    public String getTransferorApplicantCid() {
        return transferorApplicantCid;
    }

    public void setTransferorApplicantCid(String transferorApplicantCid) {
        this.transferorApplicantCid = transferorApplicantCid;
    }

    public String getTransferorApplicantDob() {
        return transferorApplicantDob;
    }

    public void setTransferorApplicantDob(String transferorApplicantDob) {
        this.transferorApplicantDob = transferorApplicantDob;
    }

    public String getTransferorApplicantName() {
        return transferorApplicantName;
    }

    public void setTransferorApplicantName(String transferorApplicantName) {
        this.transferorApplicantName = transferorApplicantName;
    }

    public String getTransferorGender() {
        return transferorGender;
    }

    public void setTransferorGender(String transferorGender) {
        this.transferorGender = transferorGender;
    }

    public String getTransferorFathersName() {
        return transferorFathersName;
    }

    public void setTransferorFathersName(String transferorFathersName) {
        this.transferorFathersName = transferorFathersName;
    }

    public String getTransferorMothersName() {
        return transferorMothersName;
    }

    public void setTransferorMothersName(String transferorMothersName) {
        this.transferorMothersName = transferorMothersName;
    }

    public String getTransferorDzongkhagId() {
        return transferorDzongkhagId;
    }

    public void setTransferorDzongkhagId(String transferorDzongkhagId) {
        this.transferorDzongkhagId = transferorDzongkhagId;
    }

    public String getTransferorVillageId() {
        return transferorVillageId;
    }

    public void setTransferorVillageId(String transferorVillageId) {
        this.transferorVillageId = transferorVillageId;
    }

    public String getTransferorGewogId() {
        return transferorGewogId;
    }

    public void setTransferorGewogId(String transferorGewogId) {
        this.transferorGewogId = transferorGewogId;
    }

    public String getTransferorHouseNo() {
        return transferorHouseNo;
    }

    public void setTransferorHouseNo(String transferorHouseNo) {
        this.transferorHouseNo = transferorHouseNo;
    }

    public String getTransferorTharmNo() {
        return transferorTharmNo;
    }

    public void setTransferorTharmNo(String transferorTharmNo) {
        this.transferorTharmNo = transferorTharmNo;
    }

    public String getApplicantDobBh() {
        return ApplicantDobBh;
    }

    public void setApplicantDobBh(String applicantDobBh) {
        ApplicantDobBh = applicantDobBh;
    }

    public String getHouseHoldNo() {
        return houseHoldNo;
    }

    public void setHouseHoldNo(String houseHoldNo) {
        this.houseHoldNo = houseHoldNo;
    }

    public String getDzongkhagName() {
        return dzongkhagName;
    }

    public void setDzongkhagName(String dzongkhagName) {
        this.dzongkhagName = dzongkhagName;
    }

    public String getGewogName() {
        return gewogName;
    }

    public void setGewogName(String gewogName) {
        this.gewogName = gewogName;
    }

    public String getVillageName() {
        return villageName;
    }

    public void setVillageName(String villageName) {
        this.villageName = villageName;
    }
}

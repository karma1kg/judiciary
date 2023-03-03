<%--
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<meta name="decorator" content="/layout/close-layout.jsp"/>
<html>
<head>
    <title>Marriage Certificate Registration Form</title>
</head>
<body>
<div class="row" id="registration">
    <span style="font-size: 20px"><b>&nbsp;&nbsp;&nbsp;&nbsp;Judicial Service </b> >>Marriage Certificate Registration Form </span>

    <div class="col-12">
        <form class="card form-horizontal" id="offlineMarriageCertificateFormId"
              action="<c:url value="/offlineMarriageCertificate"/>" method="post" enctype="multipart/form-data">
            <div class="card-body">
                <span class="text-danger">
              &nbsp;&nbsp;&nbsp;&nbsp;NOTE:  Label which are mark with * are mandatory fields, you cannot proceed further without those fields.
              Please follow the instruction in &nbsp;&nbsp;<img src="<c:url value='/resources/images/questionMark.jpg'/>"
                                                                class="user-image" width="20px">
          </span>
                <div class="row">
                    <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
                        <div class="panel panel-default">
                            <div class="panel-body">
                                <div class="nav-tabs-custom">
                                    <ul class="nav nav-tabs">
                                        <li id="personalDetails">
                                            <a href="#personalDetailTab" id="personalDetailTabId" data-toggle="tab"
                                               data-placement="top" title='Please use buttons to change tabs.'><i
                                                    class="fa fa-user"></i>&nbsp;Personal Details<span
                                                    class="text-info" style="font-size: 20px"
                                                    id="personalDetailsCheck"></span></a>
                                        </li>
                                        <li id="documentSelection">
                                            <a href="#documentSelectionTab" id="documentSelectionTabId"
                                               data-toggle="tab" data-placement="top"
                                               title='Please use buttons to change tabs.'><i
                                                    class="fa fa-book"></i>&nbsp; Court & Contact Details<span class="text-info" style="font-size: 20px"
                                                               id="documentSelectionCheck"></span></a>
                                        </li>
                                        <li id="otherInformation">
                                            <a href="#documentSelectionTab" id="otherInformationTabId"
                                               data-toggle="tab" data-placement="top"
                                               title='Please use buttons to change tabs.'><i
                                                    class="fa fa-paperclip"></i>&nbsp; Attachment
                                                 <span class="text-info" style="font-size: 20px"
                                                       id="otherInformationCheck"></span></a>
                                        </li>
                                    </ul>
                                </div>
                                <div class="tab-content">
                                    <div class="tab-pane" id="personalDetailTab">
                                        <br/>
                                        <div class="form-group">
                                            <label class="col-sm-2 required">
                                                Cid No:
                                                <a data-toggle="tooltip" data-placement="top"
                                                   title='Please provide 11 digit cid number.'
                                                   class="tooltipCSSSelector">
                                                    <img src="<c:url value="/resources/images/questionMark.jpg"/>" class="user-image"
                                                         width="20px">
                                                    <i class='fa fa-spinner fa-spin hidden' id="spinnerIconId"></i>
                                                </a>
                                            </label>

                                            <div class="col-sm-4">
                                                <input type="text" class="form-control field numeric" id="cidNo"
                                                       name="cidNo" maxlength="11"/>
                                                <span id="cidNoErrorMsg" class="text-danger"></span>
                                            </div>
                                            <label class="col-sm-2">Full Name:</label>

                                            <div class="col-sm-4">
                                                <input type="text" readonly="true" class="form-control field"
                                                       name="applicantName" id="applicantName">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-2">Gender:</label>

                                            <div class="col-sm-4">
                                                <select id="gender" name="gender"  class="form-control field" readonly="true">
                                                    <option value="0">--SELECT--</option>
                                                    <option value="M">Male</option>
                                                    <option value="F">Female</option>
                                                </select>
                                            </div>
                                            <label class="col-sm-2 required">
                                                Religion:
                                                <a data-toggle="tooltip" data-placement="top"
                                                   title='Please select your religion type.'
                                                   class="tooltipCSSSelector">
                                                    <img src="<c:url value="/resources/images/questionMark.jpg"/>" class="user-image"
                                                         width="20px">
                                                    <i class='fa fa-spinner fa-spin hidden' id="spinnerIconId1"></i>
                                                </a>
                                            </label>
                                            <div class="col-sm-4">
                                                <form:select id="religion" name="religion" path="religion_list"
                                                             class="form-control field">
                                                    <form:option value="" label="--SELECT--"></form:option>
                                                    <form:options items="${religion_list}" itemValue="valueInteger"
                                                                  itemLabel="text"></form:options>
                                                </form:select>
                                                <span id="religionErrorMsg" class="text-danger"></span>
                                            </div>
                                        </div>
                                        <input type="hidden" readonly="true" class="form-control field" name="applicantDob" id="applicantDob">
                                        <input type="hidden" readonly="true" class="form-control field" name="fatherName" id="fatherName">
                                        <input type="hidden" readonly="true" class="form-control field" name="motherName" id="motherName">
                                        <input type="hidden" readonly="true" class="form-control field" name="villageId" id="villageId">
                                        <input type="hidden" readonly="true" class="form-control field" name="dzongkhagId" id="dzongkhagId">
                                        <input type="hidden" readonly="true" class="form-control field" name="gewogId" id="gewogId">
                                        <input type="hidden" readonly="true" class="form-control field" name="houseNo" id="houseNo">
                                        <input type="hidden" readonly="true" class="form-control field" name="tharmNo" id="tharmNo">
                                        <hr>
                                        <label><i class="fa fa-user"></i>&nbsp;<u>Spouse Details</u></label></br></br>
                                        <div class="form-group">
                                            <label class="col-sm-2 required">
                                                Cid No:
                                                <a data-toggle="tooltip" data-placement="top"
                                                   title='Please provide 11 digit cid number.'
                                                   class="tooltipCSSSelector">
                                                    <img src="<c:url value="/resources/images/questionMark.jpg"/>" class="user-image"
                                                         width="20px">
                                                    <i class='fa fa-spinner fa-spin hidden' id="spinnerIconId2"></i>
                                                </a>
                                            </label>

                                            <div class="col-sm-4">
                                                <input type="text" class="form-control field numeric" id="spouseCidNo"
                                                       name="spouseCidNo" maxlength="11"/>
                                                <span id="spouseCidNoErrorMsg" class="text-danger"></span>
                                            </div>
                                            <label class="col-sm-2">Full Name:</label>

                                            <div class="col-sm-4">
                                                <input type="text" readonly="true" class="form-control field"
                                                       name="spouseName" id="spouseName">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-2">Gender:</label>

                                            <div class="col-sm-4">
                                                <select id="spouseGender" name="spouseGender"  class="form-control field" readonly="true">
                                                    <option value="">--SELECT--</option>
                                                    <option value="M">Male</option>
                                                    <option value="F">Female</option>
                                                </select>
                                            </div>
                                            <label class="col-sm-2 required">
                                                Religion:
                                                <a data-toggle="tooltip" data-placement="top"
                                                   title='Please select your religion type.'
                                                   class="tooltipCSSSelector">
                                                    <img src="<c:url value="/resources/images/questionMark.jpg"/>" class="user-image"
                                                         width="20px">
                                                    <i class='fa fa-spinner fa-spin hidden' id="spinnerIconId3"></i>
                                                </a>
                                            </label>
                                            <div class="col-sm-4">
                                                <form:select id="spouseReligion" name="spouseReligion" path="religion_list"
                                                             class="form-control field">
                                                    <form:option value="" label="--SELECT--"></form:option>
                                                    <form:options items="${religion_list}" itemValue="valueInteger"
                                                                  itemLabel="text"></form:options>
                                                </form:select>
                                                <span id="religion1ErrorMsg" class="text-danger"></span>
                                            </div>
                                        </div>
                                        <input type="hidden"  readonly="true" class="form-control field" name="spouseApplicantDob" id="spouseApplicantDob">
                                        <input type="hidden" readonly="true" class="form-control field" name="spouseFathersName" id="spouseFathersName">
                                        <input type="hidden" readonly="true" class="form-control field" name="spouseMothersName" id="spouseMothersName">
                                        <input type="hidden" readonly="true" class="form-control field" name="spouseVillageId" id="spouseVillageId">
                                        <input type="hidden" readonly="true" class="form-control field" name="spouseDzongkhagId" id="spouseDzongkhagId">
                                        <input type="hidden" readonly="true" class="form-control field" name="spouseGewogId" id="spouseGewogId">
                                        <input type="hidden" readonly="true" class="form-control field" name="spouseHouseNo" id="spouseHouseNo">
                                        <input type="hidden" readonly="true" class="form-control field" name="spouseTharmNo" id="spouseTharmNo">
                                        <hr>
                                        <div class="form-group">
                                            <label class="col-sm-2 required">
                                                Do you have Child(ern) ?
                                                <a data-toggle="tooltip" data-placement="top"
                                                   title='Please select from below drop down yes or no, for your childern details.'
                                                   class="tooltipCSSSelector">
                                                    <img src="<c:url value="/resources/images/questionMark.jpg"/>" class="user-image"
                                                         width="20px">
                                                    <i class='fa fa-spinner fa-spin hidden' id="spinnerIconId4"></i>
                                                </a>
                                            </label>
                                            <div class="col-sm-4">
                                                <select id="confirmChild" name="confirmChild"  class="form-control field">
                                                    <option value="">--select--</option>
                                                    <option value="Y">--YES--</option>
                                                    <option value="N">--NO--</option>
                                                </select>
                                                <span id="confirmChildErrorMsg" class="text-danger"></span>
                                            </div>
                                        </div>
                                        <div class="form-group" id="confirmChildDiv">
                                            <div class="table-responsive">
                                                <table class="table card-table table-vcenter text-nowrap"
                                                       id="childDtlsId">
                                                    <thead>
                                                    <tr>
                                                        <th>sl no.</th>
                                                        <th><label>Child Name<span style="color: red;">*</span></label></th>
                                                        <th><label>Date of Birth<span style="color: red;">*</span></label></th>
                                                        <th><label>Gender<span style="color: red;">*</span></label>
                                                        </th>
                                                        <th id="actionColumn">Action</th>
                                                    </tr>
                                                    </thead>
                                                    <tbody>
                                                    <tr id="puTr">
                                                        <td>1</td>
                                                        <td>
                                                            <input type="text" class="form-control" id="childName" name='childMCDTOs[0].childName' palceholder="Child Full Name">
                                                            <span id="childNameErrorMsg" class="text-danger"></span>
                                                        </td>
                                                        <td>
                                                            <input type="text" class="form-control datepicker" id="childDoB" name='childMCDTOs[0].childDoB' palceholder="Child Date of Birth" &lt;%&ndash;value="01-Jan-1990"&ndash;%&gt;>
                                                            <span id="childDobErrorMsg" class="text-danger"></span>
                                                        </td>
                                                        <td>
                                                            <select id="childGender" name="childMCDTOs[0].childGender"  class="form-control">
                                                               &lt;%&ndash; <option value=""/>&ndash;%&gt;
                                                                <option value="M">Male</option>
                                                                <option value="F">Female</option>
                                                            </select>
                                                            <span id="childGenderErrorMsg" class="text-danger"></span>
                                                        </td>
                                                        <td>
                                                            <button class='btn btn-sm btn-danger hidden' type='button'
                                                                    id='btnRemove1'><i class='fa fa-times'>Delete</i>
                                                            </button>
                                                            &nbsp;&nbsp;&nbsp;&nbsp;
                                                            <button class='btn btn-sm btn-success' type='button'
                                                                    id='btnAddMore1'><i class='fa fa-plus'>Add
                                                                More</i></button>
                                                        </td>
                                                    </tr>
                                                    </tbody>
                                                </table>
                                            </div>
                                        </div>
                                        <hr>
                                        <label><i class="fa fa-male"></i>&nbsp;<u>Male Witness Details</u></label></br></br>
                                        <span id="w1genderErrorMsg" class="text-danger"></span>
                                        <div class="form-group">
                                            <label class="col-sm-2 required">
                                                Cid No:
                                                <a data-toggle="tooltip" data-placement="top"
                                                   title='Please provide 11 digit cid number.'
                                                   class="tooltipCSSSelector">
                                                    <img src="<c:url value="/resources/images/questionMark.jpg"/>" class="user-image"
                                                         width="20px">
                                                    <i class='fa fa-spinner fa-spin hidden' id="spinnerIconId5"></i>
                                                </a>
                                            </label>

                                            <div class="col-sm-4">
                                                <input type="text" class="form-control field numeric" id="witness1CidNo"
                                                       name="witness1CidNo" maxlength="11"/>
                                                <span id="witness1CidNoErrorMsg" class="text-danger"></span>
                                            </div>
                                            <label class="col-sm-2">Full Name:</label>

                                            <div class="col-sm-4">
                                                <input type="text" readonly="true" class="form-control field"
                                                       name="witness1Name" id="witness1Name">
                                            </div>
                                        </div>
                                        <input type="hidden" readonly="true" class="form-control field" name="w1Dob" id="w1Dob">
                                        <input type="hidden" readonly="true" class="form-control field" name="w1Gender" id="w1Gender">
                                        <input type="hidden" readonly="true" class="form-control field" name="w1fathersName" id="w1fathersName">
                                        <input type="hidden" readonly="true" class="form-control field" name="w1villageId" id="w1villageId">
                                        <input type="hidden" readonly="true" class="form-control field" name="w1gewogId" id="w1gewogId">
                                        <input type="hidden" readonly="true" class="form-control field" name="w1dzongkhagId" id="w1dzongkhagId">
                                        <input type="hidden" readonly="true" class="form-control field" name="w1houseNo" id="w1houseNo">
                                        <input type="hidden" readonly="true" class="form-control field" name="w1tharmNo" id="w1tharmNo">
                                        <hr>
                                        <label><i class="fa fa-female"></i>&nbsp;<u>Female Witness Details</u></label></br></br>
                                        <span id="w2genderErrorMsg" class="text-danger"></span>
                                        <div class="form-group">
                                            <label class="col-sm-2 required">
                                                Cid No:
                                                <a data-toggle="tooltip" data-placement="top"
                                                   title='Please provide 11 digit cid number.'
                                                   class="tooltipCSSSelector">
                                                    <img src="<c:url value="/resources/images/questionMark.jpg"/>" class="user-image"
                                                         width="20px">
                                                    <i class='fa fa-spinner fa-spin hidden' id="spinnerIconId6"></i>
                                                </a>
                                            </label>
                                            <div class="col-sm-4">
                                                <input type="text" class="form-control field numeric" id="witness2CidNo"
                                                       name="witness2CidNo" maxlength="11"/>
                                                <span id="witness2CidNoErrorMsg" class="text-danger"></span>
                                            </div>
                                            <label class="col-sm-2">Full Name:</label>
                                            <div class="col-sm-4">
                                                <input type="text" readonly="true" class="form-control field"
                                                       name="witness2Name" id="witness2Name">
                                            </div>
                                        </div>
                                        <input type="hidden" readonly="true" class="form-control field" name="w2Dob" id="w2Dob">
                                        <input type="hidden" readonly="true" class="form-control field" name="w2gender" id="w2gender">
                                        <input type="hidden" readonly="true" class="form-control field" name="w2fathersName" id="w2fathersName">
                                        <input type="hidden" readonly="true" class="form-control field" name="w2villageId" id="w2villageId">
                                        <input type="hidden" readonly="true" class="form-control field" name="w2gewogId" id="w2gewogId">
                                        <input type="hidden" readonly="true" class="form-control field" name="w2dzongkhagId" id="w2dzongkhagId">
                                        <input type="hidden" readonly="true" class="form-control field" name="w2houseNo" id="w2houseNo">
                                        <input type="hidden" readonly="true" class="form-control field" name="w2tharmNo" id="w2tharmNo">
                                        <hr/>
                                        <div class="form-group pull-right">
                                            <div class="col-sm-4">
                                                <button type="button" id="btnNext_1" class="btn btn-primary">
                                                    <i class="fa fa-arrow-right"></i> Next
                                                </button>
                                            </div>
                                        </div>
                                    </div>

                                    <div class="tab-pane" id="documentSelectionTab">
                                        <br/>
                                        <div class="form-group">
                                            <label class="col-sm-2 required">Mobile Number:<a data-toggle="tooltip"
                                                                                              data-placement="top"
                                                                                              title='Please provide your 8 digit bhutanese mobile number. system will use this number for your sms notification'
                                                                                              class="tooltipCSSSelector">
                                                <img src="<c:url value="/resources/images/questionMark.jpg"/>" class="user-image"
                                                     id="instrumentCountryimg" width="20px">
                                            </a>

                                            </label>

                                            <div class="col-sm-4">
                                                <input type="text" class="form-control field numeric" name="mobileNo"
                                                       id="mobileNo" maxlength="8">
                                                <span id="mobileNoErrorMsg" class="text-danger"></span>
                                            </div>
                                            <label class="col-sm-2">Email:</label>

                                            <div class="col-sm-4">
                                                <input type="text" class="form-control field" id="email" name="email"
                                                       maxlength="100">
                                                <span class="text-danger" id="emailErrorMsg"></span>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-2 required">Present Address: </label>
                                            <div class="col-sm-4">
                                                    <textarea class="form-control field" name="address" id="address"
                                                              placeholder="Present address. Village, Gewog, Dzongkhag"
                                                              maxlength="250"></textarea>
                                                <span class="text-danger" id="addressErrorMsg"></span>
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <label class="col-sm-2 required">
                                                Court:
                                                <a data-toggle="tooltip" data-placement="top"
                                                   title='Select your court for where you want to go to hearing.'
                                                   class="tooltipCSSSelector">
                                                    <img src="<c:url value="/resources/images/questionMark.jpg"/>" class="user-image"
                                                         width="20px">
                                                </a>
                                            </label>
                                            <div class="col-sm-4">
                                                <form:select id="courtId" name="courtId" path="court_list"
                                                             class="form-control field" readonly="true">
                                                    <form:options items="${court_list}" itemValue="valueInteger"
                                                                  itemLabel="text"></form:options>
                                                </form:select>
                                                <span id="courtIdErrorMsg" class="text-danger"></span>
                                            </div>
                                            <div class="form-group">
                                                <label class="col-sm-2 required">Reason: </label>
                                                <div class="col-sm-4">
                                                    <textarea class="form-control field" name="reason" id="reason"
                                                              placeholder="Reason for Marriage Certificate"
                                                              maxlength="250"></textarea>
                                                    <span class="text-danger" id="reasonErrorMsg"></span>
                                                </div>
                                            </div>
                                        </div>
                                        <hr/>
                                        <div class="form-group">
                                            <div class="col-sm-3 pull-right">
                                                <button type="button" id="btnPrevious_1" class="btn btn-success">
                                                    <i class="fa fa-arrow-left"></i>
                                                    Previous
                                                </button>
                                                <button type="button" id="btnNext_2" class="btn btn-primary">
                                                    <i class="fa fa-arrow-right"></i>
                                                    Next
                                                </button>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="tab-pane" id="otherInformationTab">
                                        <br/><hr/>
                                        <div class="col-md-12 col-sm-12 col-lg-12 col-xs-12 form-group">
                                            <label><b> Please note that all the below given list of documents must be attached.</b> </label>
                                                <ol>
                                                <li>Duly filled Affidavit of Parties/Witnesses In-re Marriage Certificate form (Form No G-6 Petition for Marriage Certificate
                                                    and Form No H-8 Affidavit of Parties/Witnesses In re-Marriage Certificate).</li>
                                                <c:forEach var="requriedDocs" items="${RequiredDocsList}">
                                                    <li><option value="${requriedDocs.valueInteger}">${requriedDocs.text}</option></li>
                                                </c:forEach>
                                            </ol>
                                        </div>
                                        <div class="form-group">
                                            <hr/>
                                            <div class="form-group">
                                                <label class="col-sm-6">
                                                    Please attach required files if any:
                                                </label>
                                            </div>
                                            <div class="table-responsive">
                                                <table class="table card-table table-vcenter text-nowrap"
                                                       id="fileAttachmentTableId">
                                                    <tbody>
                                                    <tr style='border-top: hidden'>
                                                        <td>
                                                            <input type="file" class="alert badge-danger attachedFile" id="attachedFile"
                                                                   onchange="validateAttachment(this.value,'attachedFile');"
                                                                   name='fileAttachmentDTOs[0].attachedFile'
                                                                   accept="image/jpeg,image/png,.doc,.docx,.pdf,.xlsx,.xls"
                                                                   required>
                                                        </td>
                                                        <td>
                                                            <button class='btn btn-sm btn-danger hidden' type='button'
                                                                    id='btnRemove'><i class='fa fa-times'>Delete</i>
                                                            </button>
                                                            &nbsp;&nbsp;&nbsp;&nbsp;
                                                            <button class='btn btn-sm btn-success' type='button'
                                                                    id='btnAddMore'><i class='fa fa-plus'>Add
                                                                More</i></button>
                                                        </td>
                                                    </tr>
                                                    </tbody>
                                                </table>
                                            </div>
                                        </div><hr>
                                        <div class="form-group">
                                            <label class="col-sm-2 required">Judge/Registrar</label>
                                            <div class="col-sm-4">
                                                <input type="text" class="form-control " name="lawyer" id="lawyer"/>
                                                <span id="lawyerErrorMsg" class="text-danger"></span>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-2 required">Registration No.</label>
                                            <div class="col-sm-4">
                                                <input type="text" class="form-control numeric" name="regNo" id="regNo">
                                                <span id="regNoErrorMsg" class="text-danger"></span>
                                            </div>
                                            <label class="col-sm-2 required">Registration Date</label>
                                            <div class="col-sm-4">
                                                <input type="text" class="form-control datepicker" name="regDate" id="regDate">
                                                <span id="regDateErrorMsg" class="text-danger"></span>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-2 required">Judgement No.</label>
                                            <div class="col-sm-4">
                                                <input type="text" class="form-control numeric" name="judgementNo" id="judgementNo" />
                                                <span id="judgementNoErrorMsg" class="text-danger"></span>
                                            </div>
                                            <label class="col-sm-2 required">Judgement Date</label>
                                            <div class="col-sm-4">
                                                <input type="text" class="form-control datepicker " name="judgementDate" id="judgementDate"/>
                                                <span id="judgementDateErrorMsg" class="text-danger"></span>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-2 required">Receipt No.</label>
                                            <div class="col-sm-4">
                                                <input type="text" class="form-control field" name="receiptNo" id="receiptNo"/>
                                                <span id="receiptNoErrorMsg" class="text-danger"></span>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-2 required">Receipt Date</label>
                                            <div class="col-sm-4">
                                                <input type="text" class="form-control datepicker field" name="receiptDate" id="receiptDate"/>
                                                <span id="receiptDateErrorMsg" class="text-danger"></span>
                                            </div>
                                            <label class="col-sm-2 required">Receipt Amount</label>
                                            <div class="col-sm-4">
                                                <input type="text" class="form-control field" name="receiptAmount" id="receiptAmount"/>
                                                <span id="receiptAmountErrorMsg" class="text-danger"></span>
                                            </div>
                                        </div>
                                        <hr/>
                                        <div class="form-group">
                                            <div class="col-sm-3 pull-right">
                                                <button type="button" id="btnPrevious_2" class="btn btn-success">
                                                    <i class="fa fa-arrow-left"></i>
                                                    Previous
                                                </button>
                                                <button type="submit" id="btnSubmitOffline" class="btn btn-primary">
                                                    <i class="fa fa-check"></i>
                                                    Update
                                                </button>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </form>
    </div>
</div>
<div class="row hidden" id="acknowledgement">
    <div class="col-12">
            <div class="card-body">
                <h2 class="card-title"><b>Judicial Service</b> >> Acknowledgement</h2>
                <div class="row">
                    <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
                        <div class="panel panel-default">
                            <div class="panel-body">
                                <div class="form-group">
                                    <label class="col-sm-12">
                                        Update successful for <span id="serviceName"></span>. The application number
                                        generated by system is <span id="applicationNo"></span> <br/><br/>
                                        Thank you.
                                    </label>
                                </div>
                                <div class="form-group pull-right">
                                    <a href="<c:url value='/offlineMarriageCertificate'/>" class="btn btn-primary"><i class="fa fa-backward" aria-hidden="true"></i>&nbsp;&nbsp;Update again</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
    </div>
</div>
</body>
</html>
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<meta name="decorator" content="/layout/close-layout.jsp"/>
<html>
<head>
    <title>Marriage Certificate Registration Form</title>
</head>
<body>
<div class="row" id="registration">
    <span style="font-size: 20px"><b>&nbsp;&nbsp;&nbsp;&nbsp;Judicial Service </b> >>Marriage Certificate Registration Form </span>

    <div class="col-12">
        <form class="card form-horizontal" id="offlineMarriageCertificateFormId"
              action="<c:url value="/offlineMarriageCertificate"/>" method="post" enctype="multipart/form-data">
            <div class="card-body">
                <span class="text-danger">
              &nbsp;&nbsp;&nbsp;&nbsp;NOTE:  Label which are mark with * are mandatory fields, you cannot proceed further without those fields.
              Please follow the instruction in &nbsp;&nbsp;<img src="<c:url value='/resources/images/questionMark.jpg'/>"
                                                                class="user-image" width="20px">
          </span>
                <div class="row">
                    <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
                        <div class="panel panel-default">
                            <div class="panel-body">
                                <div class="nav-tabs-custom">
                                    <ul class="nav nav-tabs">
                                        <li id="personalDetails">
                                            <a href="#personalDetailTab" id="personalDetailTabId" data-toggle="tab"
                                               data-placement="top" title='Please use buttons to change tabs.'><i
                                                    class="fa fa-user"></i>&nbsp;Personal Details<span
                                                    class="text-info" style="font-size: 20px"
                                                    id="personalDetailsCheck"></span></a>
                                        </li>
                                        <li id="documentSelection">
                                            <a href="#documentSelectionTab" id="documentSelectionTabId"
                                               data-toggle="tab" data-placement="top"
                                               title='Please use buttons to change tabs.'><i
                                                    class="fa fa-book"></i>&nbsp; Court & Contact Details<span class="text-info" style="font-size: 20px"
                                                                                                               id="documentSelectionCheck"></span></a>
                                        </li>
                                        <li id="otherInformation">
                                            <a href="#documentSelectionTab" id="otherInformationTabId"
                                               data-toggle="tab" data-placement="top"
                                               title='Please use buttons to change tabs.'><i
                                                    class="fa fa-paperclip"></i>&nbsp; Attachment
                                                 <span class="text-info" style="font-size: 20px"
                                                       id="otherInformationCheck"></span></a>
                                        </li>
                                    </ul>
                                </div>
                                <div class="tab-content">
                                    <div class="tab-pane" id="personalDetailTab">
                                        <br/>
                                        <div class="form-group">
                                            <label class="col-sm-2 required">
                                                Cid No:
                                                <a data-toggle="tooltip" data-placement="top"
                                                   title='Please provide 11 digit cid number.'
                                                   class="tooltipCSSSelector">
                                                    <img src="<c:url value="/resources/images/questionMark.jpg"/>" class="user-image"
                                                         width="20px">
                                                    <i class='fa fa-spinner fa-spin hidden' id="spinnerIconId"></i>
                                                </a>
                                            </label>

                                            <div class="col-sm-4">
                                                <input type="text" class="form-control field numeric" id="cidNo"
                                                       name="cidNo" maxlength="11"/>
                                                <span id="cidNoErrorMsg" class="text-danger"></span>
                                            </div>
                                            <label class="col-sm-2">Full Name:</label>

                                            <div class="col-sm-4">
                                                <input type="text" readonly="true" class="form-control field"
                                                       name="applicantName" id="applicantName">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-2">Gender:</label>

                                            <div class="col-sm-4">
                                                <select id="gender" name="gender"  class="form-control field" readonly="true">
                                                    <option value="0">--SELECT--</option>
                                                    <option value="M">Male</option>
                                                    <option value="F">Female</option>
                                                </select>
                                            </div>
                                            <label class="col-sm-2 required">
                                                Religion:
                                                <a data-toggle="tooltip" data-placement="top"
                                                   title='Please select your religion type.'
                                                   class="tooltipCSSSelector">
                                                    <img src="<c:url value="/resources/images/questionMark.jpg"/>" class="user-image"
                                                         width="20px">
                                                    <i class='fa fa-spinner fa-spin hidden' id="spinnerIconId1"></i>
                                                </a>
                                            </label>
                                            <div class="col-sm-4">
                                                <form:select id="religion" name="religion" path="religion_list"
                                                             class="form-control field">
                                                    <form:option value="" label="--SELECT--"></form:option>
                                                    <form:options items="${religion_list}" itemValue="valueInteger"
                                                                  itemLabel="text"></form:options>
                                                </form:select>
                                                <span id="religionErrorMsg" class="text-danger"></span>
                                            </div>
                                        </div>
                                        <input type="hidden" readonly="true" class="form-control field" name="applicantDob" id="applicantDob">
                                        <input type="hidden" readonly="true" class="form-control field" name="fatherName" id="fatherName">
                                        <input type="hidden" readonly="true" class="form-control field" name="motherName" id="motherName">
                                        <input type="hidden" readonly="true" class="form-control field" name="villageId" id="villageId">
                                        <input type="hidden" readonly="true" class="form-control field" name="dzongkhagId" id="dzongkhagId">
                                        <input type="hidden" readonly="true" class="form-control field" name="gewogId" id="gewogId">
                                        <input type="hidden" readonly="true" class="form-control field" name="houseNo" id="houseNo">
                                        <input type="hidden" readonly="true" class="form-control field" name="tharmNo" id="tharmNo">
                                        <hr>
                                        <label><i class="fa fa-user"></i>&nbsp;<u>Spouse Details</u></label></br></br>
                                        <div class="form-group">
                                            <label class="col-sm-2 required">
                                                Cid No:
                                                <a data-toggle="tooltip" data-placement="top"
                                                   title='Please provide 11 digit cid number.'
                                                   class="tooltipCSSSelector">
                                                    <img src="<c:url value="/resources/images/questionMark.jpg"/>" class="user-image"
                                                         width="20px">
                                                    <i class='fa fa-spinner fa-spin hidden' id="spinnerIconId2"></i>
                                                </a>
                                            </label>

                                            <div class="col-sm-4">
                                                <input type="text" class="form-control field numeric" id="spouseCidNo"
                                                       name="spouseCidNo" maxlength="11"/>
                                                <span id="spouseCidNoErrorMsg" class="text-danger"></span>
                                            </div>
                                            <label class="col-sm-2">Full Name:</label>

                                            <div class="col-sm-4">
                                                <input type="text" readonly="true" class="form-control field"
                                                       name="spouseName" id="spouseName">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-2">Gender:</label>

                                            <div class="col-sm-4">
                                                <select id="spouseGender" name="spouseGender"  class="form-control field" readonly="true">
                                                    <option value="">--SELECT--</option>
                                                    <option value="M">Male</option>
                                                    <option value="F">Female</option>
                                                </select>
                                            </div>
                                            <label class="col-sm-2 required">
                                                Religion:
                                                <a data-toggle="tooltip" data-placement="top"
                                                   title='Please select your religion type.'
                                                   class="tooltipCSSSelector">
                                                    <img src="<c:url value="/resources/images/questionMark.jpg"/>" class="user-image"
                                                         width="20px">
                                                    <i class='fa fa-spinner fa-spin hidden' id="spinnerIconId3"></i>
                                                </a>
                                            </label>
                                            <div class="col-sm-4">
                                                <form:select id="spouseReligion" name="spouseReligion" path="religion_list"
                                                             class="form-control field">
                                                    <form:option value="" label="--SELECT--"></form:option>
                                                    <form:options items="${religion_list}" itemValue="valueInteger"
                                                                  itemLabel="text"></form:options>
                                                </form:select>
                                                <span id="religion1ErrorMsg" class="text-danger"></span>
                                            </div>
                                        </div>
                                        <input type="hidden"  readonly="true" class="form-control field" name="spouseApplicantDob" id="spouseApplicantDob">
                                        <input type="hidden" readonly="true" class="form-control field" name="spouseFathersName" id="spouseFathersName">
                                        <input type="hidden" readonly="true" class="form-control field" name="spouseMothersName" id="spouseMothersName">
                                        <input type="hidden" readonly="true" class="form-control field" name="spouseVillageId" id="spouseVillageId">
                                        <input type="hidden" readonly="true" class="form-control field" name="spouseDzongkhagId" id="spouseDzongkhagId">
                                        <input type="hidden" readonly="true" class="form-control field" name="spouseGewogId" id="spouseGewogId">
                                        <input type="hidden" readonly="true" class="form-control field" name="spouseHouseNo" id="spouseHouseNo">
                                        <input type="hidden" readonly="true" class="form-control field" name="spouseTharmNo" id="spouseTharmNo">
                                        <hr>
                                        <div class="form-group">
                                            <label class="col-sm-2 required">
                                                Do you have Child(ern) ?
                                                <a data-toggle="tooltip" data-placement="top"
                                                   title='Please select from below drop down yes or no, for your childern details.'
                                                   class="tooltipCSSSelector">
                                                    <img src="<c:url value="/resources/images/questionMark.jpg"/>" class="user-image"
                                                         width="20px">
                                                    <i class='fa fa-spinner fa-spin hidden' id="spinnerIconId4"></i>
                                                </a>
                                            </label>
                                            <div class="col-sm-4">
                                                <select id="confirmChild" name="confirmChild"  class="form-control field">
                                                    <option value="">--select--</option>
                                                    <option value="Y">--YES--</option>
                                                    <option value="N">--NO--</option>
                                                </select>
                                                <span id="confirmChildErrorMsg" class="text-danger"></span>
                                            </div>
                                        </div>
                                        <div class="form-group" id="confirmChildDiv">
                                            <div class="table-responsive">
                                                <table class="table card-table table-vcenter text-nowrap"
                                                       id="childDtlsId">
                                                    <thead>
                                                    <tr>
                                                        <th>sl no.</th>
                                                        <th><label>Child Name<span style="color: red;">*</span></label></th>
                                                        <th><label>Date of Birth<span style="color: red;">*</span></label></th>
                                                        <th><label>Gender<span style="color: red;">*</span></label>
                                                        </th>
                                                        <th id="actionColumn">Action</th>
                                                    </tr>
                                                    </thead>
                                                    <tbody>
                                                    <tr id="puTr">
                                                        <td>1</td>
                                                        <td>
                                                            <input type="text" class="form-control" id="childName" name='childMCDTOs[0].childName' palceholder="Child Full Name">
                                                            <span id="childNameErrorMsg" class="text-danger"></span>
                                                        </td>
                                                        <td>
                                                            <input type="text" class="form-control datepicker" id="childDoB" name='childMCDTOs[0].childDoB' palceholder="Child Date of Birth" value="01-Jan-1990">
                                                            <span id="childDobErrorMsg" class="text-danger"></span>
                                                        </td>
                                                        <td>
                                                            <select id="childGender" name="childMCDTOs[0].childGender"  class="form-control">
                                                                <option value="M">Male</option>
                                                                <option value="F">Female</option>
                                                            </select>
                                                            <span id="childGenderErrorMsg" class="text-danger"></span>
                                                        </td>
                                                        <td>
                                                            <button class='btn btn-sm btn-danger hidden' type='button'
                                                                    id='btnRemove1'><i class='fa fa-times'>Delete</i>
                                                            </button>
                                                            &nbsp;&nbsp;&nbsp;&nbsp;
                                                            <button class='btn btn-sm btn-success' type='button'
                                                                    id='btnAddMore1'><i class='fa fa-plus'>Add
                                                                More</i></button>
                                                        </td>
                                                    </tr>
                                                    </tbody>
                                                </table>
                                            </div>
                                        </div>
                                        <hr>
                                        <label><i class="fa fa-male"></i>&nbsp;<u>Male Witness Details</u></label></br></br>
                                        <span id="w1genderErrorMsg" class="text-danger"></span>
                                        <div class="form-group">
                                            <label class="col-sm-2 required">
                                                Cid No:
                                                <a data-toggle="tooltip" data-placement="top"
                                                   title='Please provide 11 digit cid number.'
                                                   class="tooltipCSSSelector">
                                                    <img src="<c:url value="/resources/images/questionMark.jpg"/>" class="user-image"
                                                         width="20px">
                                                    <i class='fa fa-spinner fa-spin hidden' id="spinnerIconId5"></i>
                                                </a>
                                            </label>

                                            <div class="col-sm-4">
                                                <input type="text" class="form-control field numeric" id="witness1CidNo"
                                                       name="witness1CidNo" maxlength="11"/>
                                                <span id="witness1CidNoErrorMsg" class="text-danger"></span>
                                            </div>
                                            <label class="col-sm-2">Full Name:</label>

                                            <div class="col-sm-4">
                                                <input type="text" readonly="true" class="form-control field"
                                                       name="witness1Name" id="witness1Name">
                                            </div>
                                        </div>
                                        <input type="hidden" readonly="true" class="form-control field" name="w1Dob" id="w1Dob">
                                        <input type="hidden" readonly="true" class="form-control field" name="w1Gender" id="w1Gender">
                                        <input type="hidden" readonly="true" class="form-control field" name="w1fathersName" id="w1fathersName">
                                        <input type="hidden" readonly="true" class="form-control field" name="w1villageId" id="w1villageId">
                                        <input type="hidden" readonly="true" class="form-control field" name="w1gewogId" id="w1gewogId">
                                        <input type="hidden" readonly="true" class="form-control field" name="w1dzongkhagId" id="w1dzongkhagId">
                                        <input type="hidden" readonly="true" class="form-control field" name="w1houseNo" id="w1houseNo">
                                        <input type="hidden" readonly="true" class="form-control field" name="w1tharmNo" id="w1tharmNo">
                                        <hr>
                                        <label><i class="fa fa-female"></i>&nbsp;<u>Female Witness Details</u></label></br></br>
                                        <span id="w2genderErrorMsg" class="text-danger"></span>
                                        <div class="form-group">
                                            <label class="col-sm-2 required">
                                                Cid No:
                                                <a data-toggle="tooltip" data-placement="top"
                                                   title='Please provide 11 digit cid number.'
                                                   class="tooltipCSSSelector">
                                                    <img src="<c:url value="/resources/images/questionMark.jpg"/>" class="user-image"
                                                         width="20px">
                                                    <i class='fa fa-spinner fa-spin hidden' id="spinnerIconId6"></i>
                                                </a>
                                            </label>
                                            <div class="col-sm-4">
                                                <input type="text" class="form-control field numeric" id="witness2CidNo"
                                                       name="witness2CidNo" maxlength="11"/>
                                                <span id="witness2CidNoErrorMsg" class="text-danger"></span>
                                            </div>
                                            <label class="col-sm-2">Full Name:</label>
                                            <div class="col-sm-4">
                                                <input type="text" readonly="true" class="form-control field"
                                                       name="witness2Name" id="witness2Name">
                                            </div>
                                        </div>
                                        <input type="hidden" readonly="true" class="form-control field" name="w2Dob" id="w2Dob">
                                        <input type="hidden" readonly="true" class="form-control field" name="w2gender" id="w2gender">
                                        <input type="hidden" readonly="true" class="form-control field" name="w2fathersName" id="w2fathersName">
                                        <input type="hidden" readonly="true" class="form-control field" name="w2villageId" id="w2villageId">
                                        <input type="hidden" readonly="true" class="form-control field" name="w2gewogId" id="w2gewogId">
                                        <input type="hidden" readonly="true" class="form-control field" name="w2dzongkhagId" id="w2dzongkhagId">
                                        <input type="hidden" readonly="true" class="form-control field" name="w2houseNo" id="w2houseNo">
                                        <input type="hidden" readonly="true" class="form-control field" name="w2tharmNo" id="w2tharmNo">
                                        <hr/>
                                        <div class="form-group pull-right">
                                            <div class="col-sm-4">
                                                <button type="button" id="btnNext_1" class="btn btn-primary">
                                                    <i class="fa fa-arrow-right"></i> Next
                                                </button>
                                            </div>
                                        </div>
                                    </div>

                                    <div class="tab-pane" id="documentSelectionTab">
                                        <br/>
                                        <div class="form-group">
                                            <label class="col-sm-2 required">Mobile Number:<a data-toggle="tooltip"
                                                                                              data-placement="top"
                                                                                              title='Please provide your 8 digit bhutanese mobile number. system will use this number for your sms notification'
                                                                                              class="tooltipCSSSelector">
                                                <img src="<c:url value="/resources/images/questionMark.jpg"/>" class="user-image"
                                                     id="instrumentCountryimg" width="20px">
                                            </a>

                                            </label>

                                            <div class="col-sm-4">
                                                <input type="text" class="form-control field numeric" name="mobileNo"
                                                       id="mobileNo" maxlength="8">
                                                <span id="mobileNoErrorMsg" class="text-danger"></span>
                                            </div>
                                            <label class="col-sm-2">Email:</label>

                                            <div class="col-sm-4">
                                                <input type="text" class="form-control field" id="email" name="email"
                                                       maxlength="100">
                                                <span class="text-danger" id="emailErrorMsg"></span>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-2 required">Present Address: </label>
                                            <div class="col-sm-4">
                                                    <textarea class="form-control field" name="address" id="address"
                                                              placeholder="Present address. Village, Gewog, Dzongkhag"
                                                              maxlength="250"></textarea>
                                                <span class="text-danger" id="addressErrorMsg"></span>
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <label class="col-sm-2 required">
                                                Court:
                                                <a data-toggle="tooltip" data-placement="top"
                                                   title='Select your court for where you want to go to hearing.'
                                                   class="tooltipCSSSelector">
                                                    <img src="<c:url value="/resources/images/questionMark.jpg"/>" class="user-image"
                                                         width="20px">
                                                </a>
                                            </label>
                                            <div class="col-sm-4">
                                                <form:select id="courtId" name="courtId" path="court_list"
                                                             class="form-control field" readonly="true">
                                                    <form:options items="${court_list}" itemValue="valueInteger"
                                                                  itemLabel="text"></form:options>
                                                </form:select>
                                                <span id="courtIdErrorMsg" class="text-danger"></span>
                                            </div>
                                            <div class="form-group">
                                                <label class="col-sm-2 required">Reason: </label>
                                                <div class="col-sm-4">
                                                    <textarea class="form-control field" name="reason" id="reason"
                                                              placeholder="Reason for Marriage Certificate"
                                                              maxlength="250"></textarea>
                                                    <span class="text-danger" id="reasonErrorMsg"></span>
                                                </div>
                                            </div>
                                        </div>
                                        <hr/>
                                        <div class="form-group">
                                            <div class="col-sm-3 pull-right">
                                                <button type="button" id="btnPrevious_1" class="btn btn-success">
                                                    <i class="fa fa-arrow-left"></i>
                                                    Previous
                                                </button>
                                                <button type="button" id="btnNext_2" class="btn btn-primary">
                                                    <i class="fa fa-arrow-right"></i>
                                                    Next
                                                </button>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="tab-pane" id="otherInformationTab">
                                        <br/><hr/>
                                       <%-- <div class="col-md-12 col-sm-12 col-lg-12 col-xs-12 form-group">
                                            <label><b> Please note that all the below given list of documents must be attached.</b> </label>
                                            <ol>
                                                <li>Duly filled Affidavit of Parties/Witnesses In-re Marriage Certificate form (Form No G-6 Petition for Marriage Certificate
                                                    and Form No H-8 Affidavit of Parties/Witnesses In re-Marriage Certificate).</li>
                                                <c:forEach var="requriedDocs" items="${RequiredDocsList}">
                                                    <li><option value="${requriedDocs.valueInteger}">${requriedDocs.text}</option></li>
                                                </c:forEach>
                                            </ol>
                                        </div>--%>

                                           <%-- <div class="table-responsive">
                                                <table class="table card-table table-vcenter text-nowrap"
                                                       id="fileAttachmentTableId">
                                                    <tbody>
                                                    <tr style='border-top: hidden'>
                                                        <td>
                                                            <input type="file" class="alert badge-danger attachedFile" id="attachedFile"
                                                                   onchange="validateAttachment(this.value,'attachedFile');"
                                                                   name='fileAttachmentDTOs[0].attachedFile'
                                                                   accept="image/jpeg,image/png,.doc,.docx,.pdf,.xlsx,.xls"
                                                                   required>
                                                        </td>
                                                        <td>
                                                            <button class='btn btn-sm btn-danger hidden' type='button'
                                                                    id='btnRemove'><i class='fa fa-times'>Delete</i>
                                                            </button>
                                                            &nbsp;&nbsp;&nbsp;&nbsp;
                                                            <button class='btn btn-sm btn-success' type='button'
                                                                    id='btnAddMore'><i class='fa fa-plus'>Add
                                                                More</i></button>
                                                        </td>
                                                    </tr>
                                                    </tbody>
                                                </table>
                                            </div>--%>
                                        <div class="form-group">
                                            <label class="col-sm-2 required">Judge/Registrar</label>
                                            <div class="col-sm-4">
                                                <input type="text" class="form-control " name="lawyer" id="lawyer"/>
                                                <span id="lawyerErrorMsg" class="text-danger"></span>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-2 required">Registration No.</label>
                                            <div class="col-sm-4">
                                                <input type="text"  name="regNo" id="regNo">
                                                <span id="regNoErrorMsg" class="text-danger"></span>
                                            </div>
                                            <label class="col-sm-2 required">Registration Date</label>
                                            <div class="col-sm-4">
                                                <input type="text" class="form-control datepicker" name="regDate" id="regDate">
                                                <span id="regDateErrorMsg" class="text-danger"></span>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-2 required">Judgement No.</label>
                                            <div class="col-sm-4">
                                                <input type="text" name="judgementNo" id="judgementNo" />
                                                <span id="judgementNoErrorMsg" class="text-danger"></span>
                                            </div>
                                            <label class="col-sm-2 required">Judgement Date</label>
                                            <div class="col-sm-4">
                                                <input type="text" class="form-control datepicker " name="judgementDate" id="judgementDate"/>
                                                <span id="judgementDateErrorMsg" class="text-danger"></span>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-2 required">Receipt No.</label>
                                            <div class="col-sm-4">
                                                <input type="text" class="form-control field" name="receiptNo" id="receiptNo"/>
                                                <span id="receiptNoErrorMsg" class="text-danger"></span>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-2 required">Receipt Date</label>
                                            <div class="col-sm-4">
                                                <input type="text" class="form-control datepicker field" name="receiptDate" id="receiptDate"/>
                                                <span id="receiptDateErrorMsg" class="text-danger"></span>
                                            </div>
                                            <label class="col-sm-2 required">Receipt Amount</label>
                                            <div class="col-sm-4">
                                                <input type="text" class="form-control field" name="receiptAmount" id="receiptAmount"/>
                                                <span id="receiptAmountErrorMsg" class="text-danger"></span>
                                            </div>
                                        </div>
                                        <hr/>
                                        <div class="form-group">
                                            <div class="col-sm-3 pull-right">
                                                <button type="button" id="btnPrevious_2" class="btn btn-success">
                                                    <i class="fa fa-arrow-left"></i>
                                                    Previous
                                                </button>
                                                <button type="submit" id="btnSubmitOffline" class="btn btn-primary">
                                                    <i class="fa fa-check"></i>
                                                    Update
                                                </button>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </form>
    </div>
</div>
<div class="row hidden" id="acknowledgement">
    <div class="col-12">
        <div class="card-body">
            <h2 class="card-title"><b>Judicial Service</b> >> Acknowledgement</h2>
            <div class="row">
                <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-body">
                            <div class="form-group">
                                <label class="col-sm-12">
                                    Update successful for <span id="serviceName"></span>. The application number
                                    generated by system is <span id="applicationNo"></span> <br/><br/>
                                    Thank you.
                                </label>
                            </div>
                            <div class="form-group pull-right">
                                <a href="<c:url value='/offlineMarriageCertificate'/>" class="btn btn-primary"><i class="fa fa-backward" aria-hidden="true"></i>&nbsp;&nbsp;Update again</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>


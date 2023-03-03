<%--
  Created by IntelliJ IDEA.
  User: N-Zepa
  Date: 27-Jul-19
  Time: 7:46 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Application for Child Adoption Registration Form</title>
</head>

<body>
<div class="my-3 my-md-5" id="registration">
    <div class="container">
        <div class="row">
            <span style="font-size: 20px"><b>&nbsp;&nbsp;&nbsp;&nbsp;Judicial Service </b> >>Application for Child Adoption Registration Form </span>

            <div class="col-12">
                <form class="card form-horizontal" id="childAdoptionFormId"
                      action="<c:url value='/childAdoption'/>" method="post" enctype="multipart/form-data">
                    <div class="card-body">
                <span class="text-danger">
              &nbsp;&nbsp;&nbsp;&nbsp;NOTE:  Label which are mark with * are mandatory fields, you cannot proceed further without those fields.
              Please follow the instruction in &nbsp;&nbsp;<img src="<c:url value="/resources/images/questionMark.jpg"/>"
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
                                                       data-toggle="tab"
                                                       data-placement="top" title='Please use buttons to change tabs.'><i
                                                            class="fa fa-book"></i>&nbsp; Court & Contact Details<span class="text-info" style="font-size: 20px"
                                                                                                                       id="documentSelectionCheck"></span></a>
                                                </li>
                                                <li id="otherInformation">
                                                    <a href="#otherInformationTab" id="otherInformationTabId"
                                                       data-toggle="tab" data-placement="top"
                                                       title='Please use buttons to change tabs.'><i
                                                            class="fe fe-paperclip"></i>&nbsp;Attachment<span
                                                            class="text-info" style="font-size: 20px"/></a>
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
                                                            <option value="">--SELECT--</option>
                                                            <option value="M">Male</option>
                                                            <option value="F">Female</option>
                                                        </select>
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
                                                <div class="form-group">
                                                    <label class="col-sm-2">
                                                       Spouse Cid No:
                                                        <a data-toggle="tooltip" data-placement="top"
                                                           title='Please provide 11 digit cid number.'
                                                           class="tooltipCSSSelector">
                                                            <img src="<c:url value="/resources/images/questionMark.jpg"/>" class="user-image"
                                                                 width="20px">
                                                        </a>
                                                    </label>

                                                    <div class="col-sm-4">
                                                        <input type="text" class="form-control" id="spouseCidNo"
                                                               name="spouseCidNo" maxlength="11"/>
                                                        <span id="spouseCidNoErrorMsg" class="text-danger"></span>
                                                    </div>
                                                    <label class="col-sm-2">Spouse Name:</label>

                                                    <div class="col-sm-4">
                                                        <input type="text" readonly="true" class="form-control"
                                                               name="spouseName" id="spouseName">
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-2">Spouse Gender:</label>

                                                    <div class="col-sm-4">
                                                        <select id="spouseGender" name="spouseGender"  class="form-control" readonly="true">
                                                            <option value="">--SELECT--</option>
                                                            <option value="M">Male</option>
                                                            <option value="F">Female</option>
                                                        </select>
                                                    </div>
                                                </div>
                                                <input type="hidden" readonly="true" class="form-control"  name="spouseApplicantDob" id="spouseApplicantDob">
                                                <input type="hidden" readonly="true" class="form-control" name="spouseFathersName" id="spouseFathersName">
                                                <input type="hidden" readonly="true" class="form-control" name="spouseMothersName" id="spouseMothersName">
                                                <input type="hidden" readonly="true" class="form-control" name="spouseVillageId" id="spouseVillageId" value="0">
                                                <input type="hidden" readonly="true" class="form-control" name="spouseDzongkhagId" id="spouseDzongkhagId" value="0">
                                                <input type="hidden" readonly="true" class="form-control" name="spouseGewogId" id="spouseGewogId" value="0">
                                                <input type="hidden" readonly="true" class="form-control" name="spouseHouseNo" id="spouseHouseNo">
                                                <input type="hidden" readonly="true" class="form-control" name="spouseTharmNo" id="spouseTharmNo">
                                                <hr>
                                                <label><i class="fa fa-user"></i>&nbsp;<u>Child Travel Detail</u></label></br></br>
                                                <div class="form-group">
                                                    <label class="col-sm-2 required">
                                                        Child Name:
                                                        <a data-toggle="tooltip" data-placement="top"
                                                           title='Please provide Child travel name.'
                                                           class="tooltipCSSSelector">
                                                            <img src="<c:url value="/resources/images/questionMark.jpg"/>" class="user-image"
                                                                 width="20px">
                                                            <i class='fa fa-spinner fa-spin hidden' id="spinnerIconId12"></i>
                                                        </a>
                                                    </label>

                                                    <div class="col-sm-4">
                                                        <input type="text" class="form-control" id="childName" name='childName' palceholder="Child Full Name" required>
                                                        <span id="childNameErrorMsg" class="text-danger"></span>
                                                    </div>
                                                    <label class="col-sm-2">Child DoB:<i class='fa fa-spinner fa-spin hidden' id="spinnerIconId4"></i></label>

                                                    <div class="col-sm-4">
                                                        <input type="text" class="form-control datepicker field" name="childDob" id="childDob">
                                                        <span id="childDobErrorMsg" class="text-danger"></span>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-2">Child Gender:<i class='fa fa-spinner fa-spin hidden' id="spinnerIconId8"></i></label>

                                                    <div class="col-sm-4">
                                                        <select id="childGender" name="childGender"  class="form-control field" readonly="true">
                                                            <option value="">--SELECT--</option>
                                                            <option value="M">Male</option>
                                                            <option value="F">Female</option>
                                                        </select>
                                                        <span id="childGenderErrorMsg" class="text-danger"></span>
                                                    </div>
                                                </div>
                                                <hr>
                                                <label><i class="fa fa-male"></i>&nbsp;<u>Biological Parent's Details</u></label></br></br>
                                                <div class="form-group">
                                                    <label class="col-sm-2">
                                                        Father Cid No:
                                                        <a data-toggle="tooltip" data-placement="top"
                                                           title='Please provide 11 digit cid number.'
                                                           class="tooltipCSSSelector">
                                                            <img src="<c:url value="/resources/images/questionMark.jpg"/>" class="user-image"
                                                                 width="20px">
                                                            <i class='fa fa-spinner fa-spin hidden' id="spinnerIconId15"></i>
                                                        </a>
                                                    </label>

                                                    <div class="col-sm-4">
                                                        <input type="text" class="form-control" id="orgFatherCid"
                                                               name="orgFatherCid" maxlength="11"/>
                                                        <span id="orgFatherCidErrorMsg" class="text-danger"></span>
                                                    </div>
                                                    <label class="col-sm-2">Father Name:</label>

                                                    <div class="col-sm-4">
                                                        <input type="text" class="form-control"
                                                               name="orgFatherName" id="orgFatherName">
                                                    </div>
                                                </div>
                                                <input type="hidden" readonly="true" class="form-control" name="orgFatherDob" id="orgFatherDob">
                                                <input type="hidden" readonly="true" class="form-control" name="orgFatherGender" id="orgFatherGender">
                                                <input type="hidden" readonly="true" class="form-control" name="orgFatherFathersName" id="orgFatherFathersName">
                                                <input type="hidden" readonly="true" class="form-control" name="orgFatherVillageId" id="orgFatherVillageId" value="0">
                                                <input type="hidden" readonly="true" class="form-control" name="orgFatherGewogId" id="orgFatherGewogId" value="0">
                                                <input type="hidden" readonly="true" class="form-control" name="orgFatherDzongkhagId" id="orgFatherDzongkhagId" value="0">
                                                <input type="hidden" readonly="true" class="form-control" name="orgFatherHouseNo" id="orgFatherHouseNo">
                                                <input type="hidden" readonly="true" class="form-control" name="orgFatherTharmNo" id="orgFatherTharmNo">
                                                <div class="form-group">
                                                    <label class="col-sm-2">
                                                        Mother Cid No:
                                                        <a data-toggle="tooltip" data-placement="top"
                                                           title='Please provide 11 digit cid number.'
                                                           class="tooltipCSSSelector">
                                                            <img src="<c:url value="/resources/images/questionMark.jpg"/>" class="user-image"
                                                                 width="20px">
                                                            <i class='fa fa-spinner fa-spin hidden' id="spinnerIconId16"></i>
                                                        </a>
                                                    </label>

                                                    <div class="col-sm-4">
                                                        <input type="text" class="form-control" id="orgMotherCid"
                                                               name="orgMotherCid" maxlength="11"/>
                                                        <span id="orgMotherCidErrorMsg" class="text-danger"></span>
                                                    </div>
                                                    <label class="col-sm-2">Mother Name:</label>

                                                    <div class="col-sm-4">
                                                        <input type="text" class="form-control"
                                                               name="orgMotherName" id="orgMotherName">
                                                    </div>
                                                </div>
                                                <input type="hidden" readonly="true" class="form-control" name="orgMotherDob" id="orgMotherDob">
                                                <input type="hidden" readonly="true" class="form-control" name="orgMotherGender" id="orgMotherGender">
                                                <input type="hidden" readonly="true" class="form-control" name="orgMotherFathersName" id="orgMotherFathersName">
                                                <input type="hidden" readonly="true" class="form-control" name="orgMotherVillageId" id="orgMotherVillageId" value="0">
                                                <input type="hidden" readonly="true" class="form-control" name="orgMotherGewogId" id="orgMotherGewogId" value="0">
                                                <input type="hidden" readonly="true" class="form-control" name="orgMotherDzongkhagId" id="orgMotherDzongkhagId" value="0">
                                                <input type="hidden" readonly="true" class="form-control" name="orgMotherHouseNo" id="orgMotherHouseNo">
                                                <input type="hidden" readonly="true" class="form-control" name="orgMotherTharmNo" id="orgMotherTharmNo">
                                                <hr>
                                                <label><i class="fa fa-male"></i>&nbsp;<u>Witness 1 Details</u></label></br></br>
                                                <div class="form-group">
                                                    <label class="col-sm-2 required">
                                                        Cid No:
                                                        <a data-toggle="tooltip" data-placement="top"
                                                           title='Please provide 11 digit cid number.'
                                                           class="tooltipCSSSelector">
                                                            <img src="<c:url value="/resources/images/questionMark.jpg"/>" class="user-image"
                                                                 width="20px">
                                                            <i class='fa fa-spinner fa-spin hidden' id="spinnerIconId13"></i>
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
                                                <label><i class="fa fa-female"></i>&nbsp;<u>Witness 2 Details</u></label></br></br>
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
                                                <span><font color="red"><b>NOTE :</b> <i>Please select the court you want to visit for hearing. And please provide correct mobile number to get SMS from court.</i></font></span><br/>
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
                                                                     class="form-control field">
                                                            <form:option value="" label="--SELECT--"></form:option>
                                                            <form:options items="${court_list}" itemValue="valueInteger"
                                                                          itemLabel="text"></form:options>
                                                        </form:select>
                                                        <span id="courtIdErrorMsg" class="text-danger"></span>
                                                    </div>
                                                    <div class="form-group">
                                                        <label class="col-sm-2 required">Reason: </label>
                                                        <div class="col-sm-4">
                                                    <textarea class="form-control field" name="reason" id="reason"
                                                              placeholder="Reason for Child Adoption"
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
                                                    <label><b> Please note that all the below given list of documents must be attached and brought along with you during the date of appointment. Each person applying for the service must produce the following documents:<span class="text-danger">*</span></b></label>
                                                    <ol>
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
                                                </div>
                                                <hr/>
                                                <div class="form-group">
                                                    <div class="col-sm-3 pull-right">
                                                        <button type="button" id="btnPrevious_2" class="btn btn-success">
                                                            <i class="fa fa-arrow-left"></i>
                                                            Previous
                                                        </button>
                                                        <button type="submit" id="btnSubmit" class="btn btn-primary">
                                                            <i class="fa fa-check"></i>
                                                            Submit
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
    </div>
</div>
<div class="row hidden" id="acknowledgement">
    <div class="col-12">
        <form action="#" method="post" class="card form-horizontal">
            <div class="card-body">
                <h2 class="card-title"><b>Judicial Service</b> >> Acknowledgement</h2>

                <div class="row">
                    <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
                        <div class="panel panel-default">
                            <div class="panel-body">
                                <div class="form-group" id="downloadAsPdf">
                                    <label class="col-sm-12">
                                        Thank you for applying <span id="serviceName"></span>. Your application number
                                        generated by
                                        system is <span id="applicationNo"></span> and this application is forwarded to
                                        <span id="courtName"></span> court
                                        for verification and approval. You may track your application status
                                        using this application number from Track Your Application.<br/><br/>
                                        Thank you.
                                    </label>
                                </div>
                                <div class="form-group">
                                    <button type="button" id="btnDownload"
                                            class="btn btn-success col-sm-offset-10">
                                        <i class="fa fa-download"></i> Download
                                    </button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </form>
    </div>
</div>
</body>
</html>

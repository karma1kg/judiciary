<%--
  Created by IntelliJ IDEA.
  User: Sonam Tobgay
  Date: 3/10/2020
  Time: 2:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<meta name="decorator" content="/layout/close-layout.jsp"/>
<html>
<head>
    <title>Verification for New Marriage Certificate</title>
</head>
<body>
<div class="row" id="registration">
    <span style="font-size: 20px"><b>&nbsp;&nbsp;&nbsp;&nbsp;Judicial Service </b> >>Verification for New Marriage Certificate</span>

    <div class="col-12">
        <form class="card form-horizontal" id="approveNewMarriageCertificateFormId"
              action="<c:url value="/approveNewMarriageCertificate"/>" method="post">
            <div class="card-body">
                <span class="text-danger">
              &nbsp;&nbsp;&nbsp;&nbsp;NOTE:  Label which are mark with * are mandatory fields, you cannot proceed further without those fields.
              Please follow the instruction in &nbsp;&nbsp;<img src="<c:url value='/resources/images/questionMark.jpg'/>"
                                                                class="user-image" width="20px">
                     <input type="text" class="form-control hidden" name="applicationNo" id="applicationNo"
                            value="${applicationNo}">
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
                                        <label><i class="fa fa-user"></i>&nbsp;<u>Applicant Details</u></label></br></br>
                                        <div class="form-group">
                                            <label class="col-sm-2">Cid No: </label>
                                            <div class="col-sm-4">
                                                <input type="text" class="form-control readonly-field" id="cidNo" name="cidNo"/>
                                            </div>
                                            <label class="col-sm-2">Full Name:</label>

                                            <div class="col-sm-4">
                                                <input type="text" class="form-control readonly-field" name="applicantName" id="applicantName">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-2">Gender:</label>

                                            <div class="col-sm-4">
                                                <select id="gender" name="gender"  class="form-control readonly-field">
                                                    <option value="M">Male</option>
                                                    <option value="F">Female</option>
                                                </select>
                                            </div>
                                            <label class="col-sm-2"> Religion: </label>
                                            <div class="col-sm-4">
                                                <form:select id="religion" name="religion" path="religion_list"
                                                             class="form-control readonly-field">
                                                    <form:options items="${religion_list}" itemValue="valueInteger"
                                                                  itemLabel="text"></form:options>
                                                </form:select>
                                            </div>
                                        </div>
                                        <hr>
                                        <label><i class="fa fa-user"></i>&nbsp;<u>Spouse Details</u></label></br></br>
                                        <div class="form-group">
                                            <label class="col-sm-2">Cid No:</label>
                                            <div class="col-sm-4">
                                                <input type="text" class="form-control readonly-field" id="spouseCidNo" name="spouseCidNo"/>
                                            </div>
                                            <label class="col-sm-2">Full Name:</label>

                                            <div class="col-sm-4">
                                                <input type="text" class="form-control readonly-field" name="spouseName" id="spouseName"/>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-2">Gender:</label>

                                            <div class="col-sm-4">
                                                <select id="spouseGender" name="spouseGender"  class="form-control readonly-field">
                                                    <option value="M">Male</option>
                                                    <option value="F">Female</option>
                                                </select>
                                            </div>
                                            <label class="col-sm-2"> Religion:</label>
                                            <div class="col-sm-4">
                                                <form:select id="spouseReligion" name="spouseReligion" path="religion_list"
                                                             class="form-control readonly-field">
                                                    <form:options items="${religion_list}" itemValue="valueInteger"
                                                                  itemLabel="text"></form:options>
                                                </form:select>
                                            </div>
                                        </div>
                                        <hr>
                                        <div class="form-group">
                                            <label class="col-sm-2"> Do you have Child(ern) ? </label>
                                            <div class="col-sm-4">
                                                <select id="confirmChild" name="confirmChild"  class="form-control readonly-field">
                                                    <option value="Y">--YES--</option>
                                                    <option value="N">--NO--</option>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="form-group" id="confirmChildDiv">
                                            <div class="table-responsive">
                                                <table class="table card-table table-vcenter text-nowrap"
                                                       id="childDtlsId">
                                                    <thead>
                                                    <tr>
                                                        <th>sl no.</th>
                                                        <th><label>Child Name</label></th>
                                                        <th><label>Date of Birth</label></th>
                                                        <th><label>Gender</label></th>
                                                    </tr>
                                                    </thead>
                                                    <tbody>
                                                    <tr id="puTr">
                                                        <td>1</td>
                                                        <td>
                                                            <input type="text" class="form-control readonly-field" readonly="true" id="childName" name="childName">
                                                        </td>
                                                        <td>
                                                            <input type="text" class="form-control readonly-field" id="childDob" name="childDob"/>
                                                        </td>
                                                        <td>
                                                            <select id="childGender" name="childGender"  class="form-control readonly-field">
                                                                <option value="M">Male</option>
                                                                <option value="F">Female</option>
                                                            </select>
                                                        </td>
                                                    </tr>
                                                    </tbody>
                                                </table>
                                            </div>
                                        </div>
                                        <hr>
                                        <label><i class="fa fa-male"></i>&nbsp;<u>Witness Details</u></label></br></br>
                                        <div class="form-group">
                                            <label><i class="fa fa-male"></i>&nbsp;<u>Male Witness Details</u></label></br></br>
                                            <label class="col-sm-2">Cid No: </label>
                                            <div class="col-sm-4">
                                                <input type="text" class="form-control readonly-field" id="witness1CidNo" name="witness1CidNo"/>
                                            </div>
                                            <label class="col-sm-2">Full Name:</label>

                                            <div class="col-sm-4">
                                                <input type="text" class="form-control readonly-field" name="witness1Name" id="witness1Name"/>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label><i class="fa fa-male"></i>&nbsp;<u>Female Witness Details</u></label></br></br>
                                            <label class="col-sm-2">Cid No: </label>
                                            <div class="col-sm-4">
                                                <input type="text" class="form-control readonly-field" id="witness2CidNo" name="witness2CidNo"/>
                                            </div>
                                            <label class="col-sm-2">Full Name:</label>

                                            <div class="col-sm-4">
                                                <input type="text" class="form-control readonly-field" name="witness2Name" id="witness2Name">
                                            </div>
                                        </div>
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
                                            <label class="col-sm-2">Mobile Number:</label>
                                            <div class="col-sm-4">
                                                <input type="text" class="form-control readonly-field" name="mobileNo" id="mobileNo">
                                            </div>
                                            <label class="col-sm-2">Email:</label>

                                            <div class="col-sm-4">
                                                <input type="text" class="form-control readonly-field" id="email" name="email"/>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-2">Address: </label>
                                            <div class="col-sm-4">
                                                <textarea class="form-control readonly-field" name="address" id="address"></textarea>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-2">Court:</label>
                                            <div class="col-sm-4">
                                                <form:select id="courtId" name="courtId" path="court_list"
                                                             class="form-control readonly-field">
                                                    <form:options items="${court_list}" itemValue="valueInteger"
                                                                  itemLabel="text"></form:options>
                                                </form:select>
                                            </div>
                                            <div class="form-group">
                                                <label class="col-sm-2">Reason: </label>
                                                <div class="col-sm-4">
                                                    <textarea class="form-control readonly-field" name="reason" id="reason"></textarea>
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
                                        <br />
                                        <div class="col-sm-12">
                                            <div class="card">
                                                <div class="card-header" style="background: #898da0;">
                                                    <h3 class="card-title text-white">Attached Files</h3>
                                                </div>
                                                <div class="card-body">
                                                    <div class="table-responsive">
                                                        <table class="table border card-table table-vcenter text-nowrap"
                                                               id="attachmentDocumentTableId">
                                                            <thead>
                                                            <tr>
                                                                <th class="hidden">document Id</th>
                                                                <th class="hidden">Upload URL</th>
                                                                <th>Sl No</th>
                                                                <th>Document Name</th>
                                                                <th>Action</th>
                                                            </tr>
                                                            </thead>
                                                            <tbody>
                                                            </tbody>
                                                        </table>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-2">Appointment Date: </label>
                                            <div class="col-sm-4">
                                                <input type="text" class="form-control datepicker" id="appoinmentDate" name="appoinmentDate">
                                                <span id="appoinmentDateErrorMsg" class="text-danger"></span>
                                            </div>
                                            <label class="col-sm-2">Appointment Time: </label>
                                            <div class="col-sm-4">
                                                <input type="time" class="form-control"  id="appoinmentTime"  name="appoinmentTime" value="24:00" min="09:00" max="15:30" hours_limit = "12" pattern="^\d{1,2}([:.]?\d{1,2})?([ ]?[a|p]m)?$">
                                                <span id="appoinmentTimeErrorMsg" class="text-danger"></span>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-2">Remarks :</label>
                                            <div class="col-sm-4">
                                                    <textarea class="form-control" name="remarks"
                                                              id="remarks"></textarea>
                                                <span id="remarksErrorMsg" class="text-danger"></span>
                                            </div>
                                            <label class="col-sm-2" id="aaa"> Reject Reason: </label>
                                            <div class="col-sm-4" id="bbb">
                                                <%-- <form:select multiple="multiple" id="rejectReason" name="rejectReason" path="rejectReasons" class="form-control">
                                                     <form:option value="0" label="--SELECT--"></form:option>
                                                     <form:options items="${rejectReasons}" itemValue="valueInteger" itemLabel="text">
                                                     </form:options>--%>
                                                <tbody>
                                                <c:forEach var="rejectReason" items="${rejectReasons}" varStatus="counter">
                                                    <tr>
                                                        <td><input type="checkbox" name="reject_Reason" id='rejectReason${counter.index}' value="${rejectReason.text}"/> <input type="text" value="${rejectReason.text}" class="form-control"></td>
                                                    </tr>
                                                </c:forEach>
                                                </tbody>
                                                <span id='rejectReasonErrorMsg' class="text-danger"></span>
                                                <%--</form:select>--%>
                                            </div>
                                        </div>
                                        <hr/>
                                        <div class="form-group">
                                            <div class="col-sm-4 pull-right">
                                                <button type="button" id="btnPrevious_2" class="btn btn-success">
                                                    <i class="fa fa-arrow-left"></i>
                                                    Previous
                                                </button>
                                                <button type="button" id="btnApprove" name="btnValue"
                                                        class="btn btn-primary btnSave" value="btnApprove">
                                                    <i class="fa fa-check"></i>
                                                    Approve
                                                </button>
                                                <button type="button" id="btnReject" class="btn btn-danger btnSaves"
                                                        name="btnValue" value="Reject">
                                                    <i class="fa fa-ban"></i>
                                                    Reject
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
<div class="my-3 my-md-5 hidden" id="approveAcknowledgement">
    <div class="container">
        <div class="row">
            <div class="col-12">
                <form action="#" method="post" class="card form-horizontal">
                    <div class="card-body">
                        <h2 class="card-title"><b>Judicial Service</b> >>
                            Acknowledgement</h2>
                        <div class="row">
                            <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
                                <div class="panel panel-default">
                                    <div class="panel-body">
                                        <div class="form-group" id="downloadAsPdf">
                                            <label class="col-sm-12">
                                                Application for <span id="serviceNameApprove"></span> with application
                                                number <span id="applicationNoApprove"></span> is approved. The appointment date and time is
                                                <span id="appoinmentDateApprove"></span> and time is <span id="appoinmentTimeApprove"></span>
                                                and it is in <span id="courtName"></span> court. <br/>
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
    </div>
</div>
<div class="my-3 my-md-5 hidden" id="rejectAcknowledgement">
    <div class="container">
        <div class="row">
            <div class="col-12">
                <form action="#" method="post" class="card form-horizontal">
                    <div class="card-body">
                        <h2 class="card-title"><b>Judicial Service</b> >>
                            Acknowledgement</h2>
                        <div class="row">
                            <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
                                <div class="panel panel-default">
                                    <div class="panel-body">
                                        <div class="form-group" id="downloadAsPdfReject">
                                            <label class="col-sm-12">
                                                Application for <span id="serviceNameReject"></span> with application
                                                number
                                                <span id="applicationNoReject"></span> is rejected due to <span
                                                    id="rejectReasonReject"></span>. <br/>
                                                Thank you.
                                            </label>
                                        </div>
                                        <div class="form-group">
                                            <button type="button" id="btnDownloadReject"
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
    </div>
</div>
</body>
</html>
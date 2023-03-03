<%--
  Created by IntelliJ IDEA.
  User: Sonam Tobgay
  Date: 3/10/2020
  Time: 2:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="html" uri="http://www.springframework.org/tags/form" %>
<meta name="decorator" content="/layout/close-layout.jsp"/>
<html>
<head>
    <title>Update for Organ Transplant</title>
</head>
<body>
<div class="row" id="registration">
    <span style="font-size: 20px"><b>&nbsp;&nbsp;&nbsp;&nbsp;Judicial Service </b> >>Update for Organ Transplant</span>

    <div class="col-12">
        <form class="card form-horizontal" id="updateOrganTransplantFormId"
              action="<c:url value='/updateOrganTransplant'/>" method="post">
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
                                                    class="fa fa-user"></i>&nbsp;Applicant Details<span
                                                    class="text-info" style="font-size: 20px"
                                                    id="personalDetailsCheck"></span></a>
                                        </li>
                                        <li id="documentSelection">
                                            <a href="#documentSelectionTab" id="documentSelectionTabId"
                                               data-toggle="tab"
                                               data-placement="top" title='Please use buttons to change tabs.'><i
                                                    class="fa fa-book"></i>&nbsp;Judgement Details<span class="text-info" style="font-size: 20px"
                                                                                                       id="documentSelectionCheck"></span></a>
                                        </li>
                                        <li id="otherInformation">
                                            <a href="#otherInformationTab" id="otherInformationTabId"
                                               data-toggle="tab" data-placement="top"
                                               title='Please use buttons to change tabs.'><i
                                                    class="fe fe-paperclip"></i>&nbsp;Payment Details<span
                                                    class="text-info" style="font-size: 20px"/></a>
                                        </li>
                                    </ul>
                                </div>
                                <div class="tab-content">
                                    <div class="tab-pane" id="personalDetailTab">
                                        <br/>
                                        <div class="form-group">
                                        <label class="col-sm-2">CID No. </label>
                                        <div class="col-sm-4">
                                            <input type="text" class="form-control readonly-field" id="cidNo" name="cidNo"/>
                                        </div>
                                        <label class="col-sm-2">Full Name</label>
                                        <div class="col-sm-4">
                                            <input type="text" class="form-control readonly-field" name="applicantName" id="applicantName" />
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-2">Gender</label>
                                        <div class="col-sm-4">
                                            <select id="gender" name="gender"  class="form-control readonly-field">
                                                <option value="M">Male</option>
                                                <option value="F">Female</option>
                                            </select>
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
                                            <label class="col-sm-2">Case No.</label>
                                            <div class="col-sm-4">
                                                <input type="text" class="form-control readonly-field" name="applicationNo" value="${applicationNo}">
                                                <input type="hidden" class="form-control" name="applicationNo" id="applicationNo" value="${applicationNo}">
                                                <input type="hidden" class="form-control" name="applicationYear" id="applicationYear" value="${applicationYear}">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-2">Registration NO.</label>
                                            <div class="col-sm-3">
                                                <input type="text" class="form-control field numeric" name="regNo" id="regNo">
                                                <span id="regNoErrorMsg" class="text-danger"></span>
                                            </div>
                                            <div class="col-sm-1">
                                                <input type="text" class="form-control" value=" ${applicationYear}" />
                                            </div>
                                            <label class="col-sm-2">Registration Date</label>
                                            <div class="col-sm-4">
                                                <input type="text" class="form-control datepicker field" name="regDate" id="regDate">
                                                <span id="regDateErrorMsg" class="text-danger"></span>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-2">Judgement No.</label>
                                            <div class="col-sm-3">
                                                <input type="text" class="form-control field numeric" name="judgementNo" id="judgementNo" />
                                                <span id="judgementNoErrorMsg" class="text-danger"></span>
                                            </div>
                                            <div class="col-sm-1">
                                                <input type="text" class="form-control" value=" ${applicationYear}" />
                                            </div>
                                            <label class="col-sm-2">Judgement Date</label>
                                            <div class="col-sm-4">
                                                <input type="text" class="form-control datepicker field" name="judgementDate" id="judgementDate"/>
                                                <span id="judgementDateErrorMsg" class="text-danger"></span>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-2">Judge/Registrar</label>
                                            <div class="col-sm-4">
                                                <input type="text" class="form-control field" name="lawyer" id="lawyer"/>
                                                <span id="lawyerErrorMsg" class="text-danger"></span>
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
                                        <br/>
                                        <div class="form-group">
                                            <label class="col-sm-2">Receipt No.</label>
                                            <div class="col-sm-4">
                                                <input type="text" class="form-control readonly-field" name="receiptNo" id="receiptNo" value=""/>
                                            </div>
                                            <label class="col-sm-2">Receipt Date</label>
                                            <div class="col-sm-4">
                                                <input type="text" class="form-control readonly-field" name="receiptDate" id="receiptDate"/>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-2">Receipt Amount</label>
                                            <div class="col-sm-4">
                                                <input type="text" class="form-control readonly-field" name="receiptAmount" id="receiptAmount"/>
                                            </div>
                                        </div>
                                        <hr/>
                                        <div class="form-group">
                                            <div class="col-sm-3 pull-right">
                                                <button type="button" id="btnPrevious_2" class="btn btn-success">
                                                    <i class="fa fa-arrow-left"></i>
                                                    Previous
                                                </button>
                                                <button type="submit" id="btnUpdate" class="btn btn-primary">
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
<div class="my-3 my-md-5 hidden" id="approveAcknowledgement">
    <div class="container">
        <div class="row">
            <div class="col-12">
                    <div class="card-body">
                        <h2 class="card-title"><b>Judicial Service</b> >>
                            Acknowledgement</h2>
                        <div class="row">
                            <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
                                <div class="panel panel-default">
                                    <div class="panel-body">
                                        <div class="form-group">
                                            <label class="col-sm-12">
                                                Application for <span id="serviceNameUpdate"></span> with application
                                                number <span id="applicationNoUpdate"></span> is updated successfully. <br/>
                                                Thank you.
                                            </label>
                                        </div>
                                        <div class="form-group pull-right">
                                            <a href="<c:url value='/dataManagerTaskList/ALL'/>" class="btn btn-primary"><i class="fa fa-backward" aria-hidden="true"></i>&nbsp;&nbsp;Back to TaskList</a>
                                        </div>
                                    </div>
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


<%--
  Created by IntelliJ IDEA.
  User: N-Zepa
  Date: 23-Jul-19
  Time: 9:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<meta name="decorator" content="/layout/close-layout.jsp"/>
<html>
<head>
    <title>Reports</title>
</head>
<body>
<div class="row">
    <span style="font-size: 20px"><b>&nbsp;&nbsp;&nbsp;&nbsp;Judicial Service </b> >> Report</span>

    <div class="col-12">
        <form class="card form-horizontal" id="reportsFormId" action="<c:url value='/reports'/>" method="post">
            <div class="card-body">
                <div class="row">
                    <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
                        <div class="panel panel-default">
                            <div class="panel-body">

                                <div class="form-group">
                                    <label class="col-md-2 required">Service Type :</label>

                                    <div class="col-md-4">
                                        <form:select id="serviceId" name="serviceId" path="serviceList"
                                                     class="form-control serviceId">
                                            <form:option value="" label="--SELECT--"></form:option>
                                            <form:option value="ALL" label="ALL"></form:option>
                                            <form:options items="${serviceList}" itemValue="valueInteger"
                                                          itemLabel="text"></form:options>
                                        </form:select>
                                        <span id="serviceIdErrorMsg" class="text-danger"></span>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-2">From Date :<span class="text-danger">*</span></label>

                                    <div class="col-md-4">
                                        <input type="text" class="form-control datepicker field" id="fromDate"
                                               name="fromDate">
                                        <span class="text-danger" id="fromDateErrorMsg"></span>
                                    </div>
                                    <label class="col-md-2">To Date :<span class="text-danger">*</span></label>

                                    <div class="col-md-4">
                                        <input type="text" class="form-control datepicker field" id="toDate"
                                               name="toDate">
                                        <span class="text-danger" id="toDateErrorMsg"></span>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-2">Status :<span class="text-danger">*</span></label>

                                    <div class="col-md-4">
                                        <form:select id="status" name="status" path="statusList"
                                                     class="form-control field">
                                            <form:option value="" label="--SELECT--"></form:option>
                                            <form:option value="ALL" label="ALL"></form:option>
                                            <form:options items="${statusList}" itemValue="valueInteger"
                                                          itemLabel="text"></form:options>
                                        </form:select>
                                        <span class="text-danger" id="statusErrorMsg"></span>
                                    </div>
                                    <div class="form-group">
                                        <div class="col-sm-4 pull-right">
                                            <button type="button" id="btnSearch" class="btn btn-primary">
                                                <i class="fe fe-bar-chart">Generate Report</i></button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12 hidden" id="reportTableIdDiv">
                <div class="panel panel-default">
                    <div class="panel-body">
                        <strong><h2>List of Applications</h2></strong>
                        <div class="pull-right" id="exportButtons"></div>
                        <div class="table-responsive">
                            <table class="table card-table table-vcenter text-nowrap table-bordered"
                                   id="reportsTableId">
                                <thead>
                                <tr>
                                    <th>Sl No.</th>
                                    <th>Application No.</th>
                                    <th>Applicant Name</th>
                                    <th>CID No.</th>
                                    <th>Gender</th>
                                    <th>DOB</th>
                                    <th>Judgement Date</th>
                                    <th>Judgement No.</th>
                                    <th>Court Name</th>
                                    <th>Status</th>
                                </tr>
                                </thead>
                                <tbody>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </form>
    </div>
</div>
</body>
</html>

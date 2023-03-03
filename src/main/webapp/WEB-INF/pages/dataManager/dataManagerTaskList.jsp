<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 8/2/2019
  Time: 5:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<meta name="decorator" content="/layout/close-layout.jsp"/>
<html>
<head>
    <title>Task List</title>
</head>
<body>
<div class="row" id="registration">
    <span style="font-size: 20px"><b>&nbsp;&nbsp;&nbsp;&nbsp;Royal Court of Justice</b> >>Data Manager TaskList</span>

    <div class="col-12">
        <form class="card form-horizontal" id="dataManagerTaskListFormId">

            <div class="card-body">
                <div class="card">
                    <input type="hidden" id="service_id" value="${serviceId}">
                    <div id ="messageBox" class = "hidden alert alert-info">
                        <div>
                        </div>
                    </div>
                    <div class="card-header" style="background: #898da0;">
                        <h3 class="card-title text-white">Group Task</h3>
                    </div>
                    <div class="card-body">
                        <div class="table-responsive">
                            <table class="table card-table table-vcenter text-nowrap table-bordered"
                                   id="dataManagerTaskListTableId">
                                <thead>
                                <tr>
                                    <th class="hidden">Service SLNo</th>
                                    <th>Sl No.</th>
                                    <th>Application Number</th>
                                    <th>Service Name</th>
                                    <th>CID Number</th>
                                    <th>Contact Number</th>
                                    <th>Status</th>
                                    <th>Payment Type</th>
                                    <th>Action Date</th>
                                </tr>
                                </thead>
                                <tbody>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
                <div class="card">
                    <div id ="messageBox2" class = "hidden alert alert-info">
                        <div>
                        </div>
                    </div>
                    <div class="card-header" style="background: #5369d4;">
                        <h3 class="card-title text-white">My Task </h3>
                    </div>
                    <div class="card-body">
                        <div class="table-responsive">
                            <table class="table card-table table-vcenter text-nowrap table-bordered"
                                   id="claimedDataManagerTaskListTableId">
                                <thead>
                                <tr>
                                    <th class="hidden">Service SLNo</th>
                                    <th>Sl No.</th>
                                    <th>Un Claim</th>
                                    <th>Application Number</th>
                                    <th>Service Name</th>
                                    <th>CID Number</th>
                                    <th>Contact Number</th>
                                    <th>Status</th>
                                    <th>Payment Type</th>
                                    <th>Action Date</th>
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

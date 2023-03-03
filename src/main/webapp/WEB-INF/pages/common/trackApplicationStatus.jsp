<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 8/22/2019
  Time: 10:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Track Application</title>
</head>
<body class="">
<div class="my-3 my-md-5">
    <div class="container">
        <div class="row">
            <div class="col-12">
                <form class="card form-horizontal" id="trackApplicationFormId"
                      action="<c:url value='/trackApplication/trackApplicationMC'/>" method="post">
                    <div class="card-body">
                        <h2 class="card-title"><b>Judicial Service</b> >> Track Application</h2>

                        <div class="row">
                            <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
                                <div class="panel panel-default">
                                    <div class="panel-body">
                                        <div class="form-group">
                                            <label class="col-sm-6">
                                                <input type="text" name="applicationNo" class="form-control"
                                                       placeholder="Enter Application Id/ Identity Card Number" id="applicationNo">
                                                <span id="applicationNoErrorMsg" class="text-danger"></span>
                                            </label>

                                            <div class="col-sm-6">
                                                <button type="button" class="btn btn-primary" id="btnView" onclick="getTrackApplicationDetailMC()"><i
                                                        class="fa fa-eye">View Details</i></button>
                                            </div>
                                        </div>
                                        <div style="display: none" id="applicationDetailTableId">
                                            <div class="table-responsive">
                                                <table border="" class="table table-strive">
                                                    <tr>
                                                        <td><label>App Submission Date</label></td>
                                                        <td id="createdDate" class="field"></td>
                                                    </tr>
                                                    <tr>
                                                        <td><label>Application for</label></td>
                                                        <td id="serviceName" class="field"></td>
                                                    </tr>
                                                    <tr>
                                                        <td><label>Application Status</label></td>
                                                        <td id="statusName" class="field"></td>
                                                    </tr>
                                                    <tr>
                                                        <td><label>Location/ Court Name</label></td>
                                                        <td id="courtName" class="field"></td>
                                                    </tr>
                                                    <tr>
                                                        <td><label>Appointment Date</label></td>
                                                        <td id="appoinmentDate" class="field"></td>
                                                    </tr>
                                                    <tr>
                                                        <td><label>Appointment Time</label></td>
                                                        <td id="appoinmentTime" class="field"></td>
                                                    </tr>
                                                </table>
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
<script>
        function getTrackApplicationDetailMC() {
            var applicationNo = $('#applicationNo').val();
            if(applicationNo==null||applicationNo==''){
                $('#applicationNoErrorMsg').html('Please Enter Application No. or CID').show();
                return false;
            }
            if(applicationNo!=null||applicationNo!=''){
                $('#applicationNoErrorMsg').removeClass('error');
                $('#applicationNoErrorMsg').text('');
            }

            var url = '${pageContext.request.contextPath}/trackApplication/getTrackApplicationDetailMC';
            $.ajax({
                url: url
                , type: 'GET'
                , data: {applicationNo: applicationNo}
                , success: function (res) {
                    var data = res.responseDTO;
                    if (res.responseStatus == 1) {
                        $('#applicationDetailTableId').show();
                        $('#createdDate').text(formatAsDate(data.createdDate));
                        $('#serviceName').text(data.serviceName);
                        $('#statusName').text(data.statusName);
                        $('#courtName').text(data.courtName);
                        $('#appoinmentDate').text(data.hospitalName);
                        $('#appoinmentTime').text(data.appoinmentTime);
                    } else {
                       // warningMsg(res.responseText);
                        $('#applicationNo').val();
                        $('#applicationNoErrorMsg').html('Enter valid application no. or CID for MC').show();
                        $('#applicationDetailTableId').hide();
                        $('.field').text('');
                    }
                }
            });
        }



</script>
</body>
</html>

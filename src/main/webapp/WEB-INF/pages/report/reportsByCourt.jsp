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
    <span style="font-size: 20px"><b>&nbsp;&nbsp;&nbsp;&nbsp;Judicial Service </b> >> Statistical Report by Court</span>

    <div class="col-12">
        <form class="card form-horizontal" id="reportByCourtFormId" <%--action="<c:url value='/reportsByCourt'/>"--%> method="post">
            <div class="card-body">
                <div class="row">
                    <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
                        <div class="panel panel-default">
                            <div class="panel-body">

                                <div class="form-group">
                                    <label class="col-md-2 required">Service Lists :</label>

                                    <div class="col-md-4">
                                        <form:select id="serviceId" name="serviceId" path="serviceList"
                                                     class="form-control serviceId">
                                            <form:option value="" label="--SELECT--"></form:option>
                                            <form:options items="${serviceList}" itemValue="valueInteger"
                                                          itemLabel="text"></form:options>
                                        </form:select>
                                        <span id="serviceIdErrorMsg" class="text-danger"></span>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-2 required">Court Lists :</label>
                                  <div class="col-sm-4">
                                      <form:select id="courtId" name="courtId" path="court_list"
                                                   class="form-control courtId">
                                          <form:option value="" label="--SELECT--"></form:option>
                                          <form:options items="${court_list}" itemValue="valueInteger"
                                                        itemLabel="text"></form:options>
                                      </form:select>
                                      <span id="courtIdErrorMsg" class="text-danger"></span>
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
                                        <div class="col-sm-4 pull-right">
                                            <button type="button" id="btnSearchByCourt" <%--onclick="btnSearchByCourt()"--%> class="btn btn-primary">
                                                <i class="fe fe-bar-chart">Generate</i></button>
                                        </div>
                                    </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12 hidden" id="reportByCourtTableIdDiv">
                <div class="panel panel-default">
                    <div class="panel-body">
                        <strong><h2>List of Applications</h2></strong>
                        <div class="pull-right" id="exportButtons"></div>
                        <div class="table-responsive">
                            <table class="table card-table table-vcenter text-nowrap table-bordered"
                                   id="reportsByCourtTableId">
                                <thead>
                                <tr>
                                    <th>Sl No.</th>
                                    <th>Court Name</th>
                                    <th>Total</th>
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
<%--<script>
    function btnSearchByCourt() {
            var serviceId = $('#serviceId').val();
            var courtId= $('#courtId').val();
            var fromDate = $('#fromDate').val();
            var toDate = $('#toDate').val();
            if (!validateReqFieldsByCourt()) {
                return false;
            }
        if(!removeErrorMsg()){
           return false;
        }
        var url = '${pageContext.request.contextPath}/reportsByCourt/getReportByCourt';
            $.ajax({
                url: url
                , type: 'GET'
                , data: {
                    serviceId: serviceId,
                    courtId: courtId,
                    fromDate: fromDate,
                    toDate: toDate
                }
                , success: function (res) {
                    if (res.responseStatus == 1) {
                        $('#reportByCourtTableIdDiv').removeClass('hidden');
                        var data = res.responseDTO;
                        var dataTableDefinition = [
                            {
                                class: "slNo"
                                , "mRender": function (data, type, row, meta) {
                                return meta.row + 1;
                            }
                            }
                            , {"data": "courtName", class: "courtName"}
                            , {"data": "totals", class: "total"}
                        ];
                        $('#reportsByCourtTableId').DataTable({
                            data: data
                            , columns: dataTableDefinition
                            , destroy: true
                            , bSort: false
                            , filter: true
                        });
                        showExportButton();
                    } else {
                        warningMsg(res.responseText);
                        $('#reportsByCourtTableId').DataTable().destroy();
                        $('#reportsTableId tbody').empty();
                    }
                }
            });
    }

    function removeErrorMsg() {
        $('#courtId').on('change', function () {
            var courtId= $(this).val();
            if(courtId != ''){
                $('#courtId').removeClass('error');
                $('#courtIdErrorMsg').text('');
            }
        });

        $('#serviceId').on('change', function () {
            var serviceId = $(this).val();
            if (serviceId != '') {
                $('#serviceId').removeClass('error');
                $('#serviceIdErrorMsg').text('');
            }
        });
        $('#fromDate').on('keyup blur change', function () {
            var fromDate = $(this).val();
            if (fromDate != '') {
                $('#fromDate').removeClass('error');
                $('#fromDateErrorMsg').text('');
            }
        });
        $('#toDate').on('keyup blur change', function () {
            var toDate = $(this).val();
            if (toDate != '') {
                $('#toDate').removeClass('error');
                $('#toDateErrorMsg').text('');
            }
        });
    }

    function validateReqFieldsByCourt() {
        var retval = true;
        if ($('#courtId').val() == '') {
            $('#courtIdErrorMsg').text('');
            $('#courtId').addClass('error');
            $('#courtIdErrorMsg').text('Please select court');
            retval = false;
        }

        if ($('#serviceId').val() == '') {
            $('#serviceIdErrorMsg').text('');
            $('#serviceId').addClass('error');
            $('#serviceIdErrorMsg').text('Please select service type');
            retval = false;
        }
        if ($('#fromDate').val() == '') {
            $('#fromDateErrorMsg').text('');
            $('#fromDate').addClass('error');
            $('#fromDateErrorMsg').text('From date is required');
            retval = false;
        }
        if ($('#toDate').val() == '') {
            $('#toDateErrorMsg').text('');
            $('#toDate').addClass('error');
            $('#toDateErrorMsg').text('To date is required');
            retval = false;
        }
        return retval;
    }
    function showExportButton() {
        var tableId = $('#reportsByCourtTableId').DataTable();
        new $.fn.dataTable.Buttons(tableId, {
                    buttons: [
                        {
                            extend: 'excelHtml5'
                            ,
                            title: ''
                            ,
                            messageTop: 'Reports'
                            ,
                            filename: 'report'
                            ,
                            extension: '.xlsx'
                            ,
                            text: '<i class="fa fa-file-excel-o btn btn-info">Excel</i>'
                            ,
                            pageSize: 'A4'
                            ,
                            exportOptions: {
                                columns: [0, 1, 2, 3, 4, 5, 6]
                                , search: 'applied'
                            }
                            ,
                            orientation: 'portrait'
                        }
                        , {
                            extend: 'pdfHtml5'
                            ,
                            messageTop: 'Reports'
                            ,
                            filename: 'report'
                            ,
                            extension: '.pdf'
                            ,
                            text: '<i class="fa fa-file-pdf-o btn btn-primary">PDF</i>'
                            ,
                            pageSize: 'A4'
                            ,
                            exportOptions: {
                                columns: [0, 1, 2, 3, 4, 5, 6]
                                , search: 'applied'
                            }
                            ,
                            orientation: 'portrait'
                        }
                    ]
                }
        );
        tableId.buttons().container().appendTo('#exportButtons');
    }
</script>--%>


</body>
</html>

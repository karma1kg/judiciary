/*
 * Created by USER on 8/22/2019.*/

reportsByCourt = (function () {
    var form = $('#reportByCourtFormId');
    function _baseURL() {
        return 'reportsByCourt/';
    }

    function removeErrorMsg() {
        $('#courtId').on('change', function(){
            var courtId=$(this).val();
            if(courtId!=''){
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

    function btnSearchByCourt() {
        $('#btnSearchByCourt').on('click', function () {
            var serviceId = $('#serviceId').val();
            var courtId= $('#courtId').val();
            var fromDate = $('#fromDate').val();
            var toDate = $('#toDate').val();
            if (!validateReqFieldsByCourt()) {
                return false;
            }
            var url = _baseURL() + 'getReportByCourt';
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
        });
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


    return {
        removeErrorMsg: removeErrorMsg, btnSearchByCourt: btnSearchByCourt
    }
})
();
$(document).ready(
    function () {
        $('.field').val('');
        reportsByCourt.removeErrorMsg();
        reportsByCourt.btnSearchByCourt();
    });



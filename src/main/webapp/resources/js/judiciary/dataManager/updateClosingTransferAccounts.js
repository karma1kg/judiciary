/**
 * Created by Sonam Tobgay on 21-Jun-19.
 */
updateClosingTransferAccounts = (function () {
    var form = $('#updateClosingTransferAccountsFormId');
    var isSubmitted = false;

    function _baseURL() {
        return 'updateClosingTransferAccounts/';
    }

    function disableTabs() {
        $('#personalDetails').prop('class', 'active');
        $('#personalDetails').not('.active').addClass('disabled');
        $('#personalDetailTab').prop('class', 'tab-pane active');

        $("#personalDetailTabId").css("color", "white");
        $("#personalDetailTabId").css("background-color", "rgb(18, 18, 19)");

        $('#documentSelection').not('.active').addClass('disabled');
        $('#documentSelection').not('.active').find('a').removeAttr("data-toggle");

        $('#otherInformation').not('.active').addClass('disabled');
        $('#otherInformation').not('.active').find('a').removeAttr("data-toggle");
    }

    function getApplicationDetail() {
        var applicationNo = $('#applicationNo').val();
        var url = _baseURL() + 'getApplicationDetail';
        $.ajax({
            url: url
            , type: 'GET'
            , data: {applicationNo: applicationNo}
            , success: function (res) {
                var data = res.responseDTO;
                var data1 = res.transferorDTO;
                var data2 = res.witness1DTO;
                var data3 = res.witness2DTO;
                var data5 = res.applicantDTO;
                if (res.responseStatus == 1) {
                    populate(data);
                    $('#receiptDate').val(formatAsDate(data.receiptDate));
                    populate(data1);
                    populate(data2);
                    populate(data3);
                    populate(data5);
                    $('.readonly-field').prop('disabled', true);
                }
            }
        });
    }

    function btnNext() {
        $('#btnNext_1').on('click', function () {
            $('#documentSelectionTab').prop('class', 'tab-pane active');
            $('#personalDetails').removeClass("active");
            $('#personalDetailTab').removeClass("active");
            $("#personalDetailTabId").css("color", "white");
            $('#personalDetailsCheck').html('<i class="fa fa-check text-white"></i>');
            $("#personalDetailTabId").css("background-color", "#120f65");
            $("#documentSelectionTabId").css("background-color", "rgb(18, 18, 19)");
            $("#documentSelectionTabId").css("color", "white");

            $('#personalDetails').addClass('disabled');
        });
        $('#btnNext_2').on('click', function () {
            if(validateUpdate()){
                $('#otherInformationTab').prop('class', 'tab-pane active');
                $('#documentSelection').removeClass("active");
                $('#documentSelectionTab').removeClass("active");
                $('#documentSelectionCheck').html('<i class="fa fa-check text-white"></i>');
                $("#personalDetailTabId").css("color", "white");
                $("#personalDetailTabId").css("background-color", "#120f65");
                $("#documentSelectionTabId").css("background-color", "#120f65");
                $("#otherInformation").css("background-color", "rgb(18, 18, 19)");
                $("#otherInformation").css("color", "white");
            }
        });
    }

    function btnPrevious() {
        $('#btnPrevious_1').on('click', function () {
            $('#personalDetailTab').prop('class', 'tab-pane active');
            $('#documentSelection').removeClass("active");
            $('#documentSelectionTab').removeClass("active");
            $("#personalDetailTabId").css("background-color", "rgb(18, 18, 19)");
            $("#documentSelectionTabId").css("background-color", "#120f65");
        });

        $('#btnPrevious_2').on('click', function () {
            $('#documentSelectionTab').prop('class', 'tab-pane active');
            $('#otherInformation').removeClass("active");
            $('#otherInformationTab').removeClass("active");
            $("#documentSelectionTabId").css("background-color", "rgb(18, 18, 19)");
            $("#otherInformation").css("background-color", "#120f65");
        });
    }

    function validateUpdate(){
        var retval = true;
        if ($('#regNo').val() ==  '') {
            $('#regNo').addClass('error');
            $('#regNoErrorMsg').text('Registration No. is required');
            retval = false;;
        }
        if ($('#regDate').val() ==  '') {
            $('#regDate').addClass('error');
            $('#regDateErrorMsg').text('Registration date is required');
            retval = false;;
        }
        if ($('#judgementNo').val() ==  '') {
            $('#judgementNo').addClass('error');
            $('#judgementNoErrorMsg').text('Judgement No. is required');
            retval = false;;
        }
        if ($('#judgementDate').val() ==  '') {
            $('#judgementDate').addClass('error');
            $('#judgementDateErrorMsg').text('Judgement date is required');
            retval = false;;
        }
        if ($('#lawyer').val() ==  '') {
            $('#lawyer').addClass('error');
            $('#lawyerErrorMsg').text('Lawyer name is required');
            retval = false;;
        }
        return retval;
    }

    function removeErrorMsg() {
        $('#regNo').on('change', function () {
            var value = $(this).val();
            if (value != '') {
                $('#regNo').removeClass('error');
                $('#regNoErrorMsg').text('');
            }
        });
        $('#regDate').on('keyup blur', function () {
            var value = $(this).val().trim();
            if (value != '') {
                $('#regDate').removeClass('error');
                $('#regDateErrorMsg').text('');
            }
        });
        $('#judgementNo').on('keyup blur', function () {
            var value = $(this).val().trim();
            if (value != '') {
                $('#judgementNo').removeClass('error');
                $('#judgementNoErrorMsg').text('');
            }
        });
        $('#judgementDate').on('keyup blur', function () {
            var value = $(this).val().trim();
            if (value != '') {
                $('#judgementDate').removeClass('error');
                $('#judgementDateErrorMsg').text('');
            }
        });
        $('#lawyer').on('keyup blur', function () {
            var value = $(this).val().trim();
            if (value != '') {
                $('#lawyer').removeClass('error');
                $('#lawyerErrorMsg').text('');
            }
        });
    }

    function updateApplication() {
        $('#btnUpdate').on('click', function () {
            if(validateUpdate()){
                $('#updateClosingTransferAccountsFormId').validate({
                    submitHandler: function (form) {
                        var url = _baseURL() + 'updateClosingTransferAccounts';
                        var formData = new FormData(form);
                        if (isSubmitted) {
                            errorMsg('Your request is processing. Please wait...');
                            return;
                        }
                        isSubmitted = true;
                        $('#btnUpdate').attr('disabled', true);
                        $.ajax({
                            url: url,
                            type: 'POST',
                            data: formData,
                            contentType: false,
                            processData: false,
                            success: function (res) {
                                if (res.responseStatus == 3) {//update
                                    $('#registration').addClass('hidden');
                                    $('#approveAcknowledgement').removeClass('hidden');
                                    $('#serviceNameUpdate').text(res.serviceName);
                                    $('#applicationNoUpdate').text(res.applicationNumber);
                                    //$('.field').val('');
                                } else {
                                    warningMsg(res.responseText);
                                }
                            },
                            complete: function () {
                                isSubmitted = false;
                                $('#btnUpdate').attr('disabled', false);
                            },
                            error: function (res) {
                                errorMsg(res.responseText);
                            }
                        });
                    }
                });
            }
        });
    }

    function checkPreviousJudgementNo(){
        $('#judgementNo').on('change', function () {
            var judgementNo = $('#judgementNo').val();
            var applicationYear=$('#applicationYear').val();
            var url = _baseURL() + 'checkPreviousJudgementNo';
            $.ajax({
                url: url,
                type: 'GET',
                data: {judgementNo: judgementNo, applicationYear: applicationYear},
                success: function (res) {
                    var data = res.responseDTO;
                    if (res.responseStatus == 0) {
                        warningMsg(res.responseText);
                        $('#judgementNo').val('');
                        $('#judgementNo').addClass('error');
                    }
                }
            });
        });
    }

    function checkPreviousRegistrationNo(){
        $('#regNo').on('change', function () {
            var regNo = $('#regNo').val();
            var applicationYear=$('#applicationYear').val();
            var url = _baseURL() + 'checkPreviousRegistrationNo';
            $.ajax({
                url: url,
                type: 'GET',
                data: {regNo: regNo, applicationYear: applicationYear},
                success: function (res) {
                    var data = res.responseDTO;
                    if (res.responseStatus == 0) {
                        warningMsg(res.responseText);
                        $('#regNo').val('');
                        $('#regNo').addClass('error');
                    }
                }
            });
        });
    }

    return {
        disableTabs: disableTabs
        , checkPreviousRegistrationNo: checkPreviousRegistrationNo
        , checkPreviousJudgementNo: checkPreviousJudgementNo
        , getApplicationDetail: getApplicationDetail
        , btnNext: btnNext
        , btnPrevious: btnPrevious
        , removeErrorMsg: removeErrorMsg
        , updateApplication: updateApplication
    }
})
();
$(document).ready(
    function () {
        updateClosingTransferAccounts.disableTabs();
        updateClosingTransferAccounts.checkPreviousRegistrationNo();
        updateClosingTransferAccounts.checkPreviousJudgementNo();
        updateClosingTransferAccounts.getApplicationDetail();
        updateClosingTransferAccounts.btnNext();
        updateClosingTransferAccounts.btnPrevious();
        updateClosingTransferAccounts.removeErrorMsg();
        updateClosingTransferAccounts.updateApplication();
    });
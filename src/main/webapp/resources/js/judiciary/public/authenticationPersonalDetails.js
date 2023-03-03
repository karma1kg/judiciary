/**
 * Created by N-Zepa on 21-Jun-19.
 */
authenticationPersonalDetails = (function () {
    "use strict";
    var form = $('#authenticationPersonalDetailsFormId');
    var isSubmitted = false;

    function _baseURL() {
        return 'authenticationPersonalDetails/';
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

    function btnNext() {
        $('#btnNext_1').on('click', function () {
            var cid = $('#cidNo').val();
            if (validatePersonalDetail() && validateCid(cid)) {
                $('#documentSelectionTab').prop('class', 'tab-pane active');
                $('#personalDetails').removeClass("active");
                $('#personalDetailTab').removeClass("active");
                $("#personalDetailTabId").css("color", "white");
                $('#personalDetailsCheck').html('<i class="fa fa-check text-white"></i>');
                $("#personalDetailTabId").css("background-color", "#120f65");
                $("#documentSelectionTabId").css("background-color", "rgb(18, 18, 19)");
                $("#documentSelectionTabId").css("color", "white");
                $('#personalDetails').addClass('disabled');
            }
        });
        $('#btnNext_2').on('click', function () {
            if (validateDocumentSelection()) {
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

    function onChangeAuthType(){
        $('#incorrectType').on('click', function () {
            if ($('#incorrectType').val() == 1) {
                $('#incorrectNameDiv').show();
                $('#incorrectDobDiv').hide();
                $('#incorrectCidNoDiv').hide();
                $('#incorrectGewogNameDiv').hide();
                $('#otherDiv').hide();
            }else if ($('#incorrectType').val() == 2) {
                $('#incorrectNameDiv').hide();
                $('#incorrectDobDiv').show();
                $('#incorrectCidNoDiv').hide();
                $('#incorrectGewogNameDiv').hide();
                $('#otherDiv').hide();
            }else if ($('#incorrectType').val() == 3) {
                $('#incorrectNameDiv').hide();
                $('#incorrectDobDiv').hide();
                $('#incorrectCidNoDiv').show();
                $('#incorrectGewogNameDiv').hide();
                $('#otherDiv').hide();
            }else if ($('#incorrectType').val() == 4) {
                $('#incorrectNameDiv').hide();
                $('#incorrectDobDiv').hide();
                $('#incorrectCidNoDiv').hide();
                $('#incorrectGewogNameDiv').show();
                $('#otherDiv').hide();
            }else if ($('#incorrectType').val() == 5) {
                $('#incorrectNameDiv').hide();
                $('#incorrectDobDiv').hide();
                $('#incorrectCidNoDiv').hide();
                $('#incorrectGewogNameDiv').hide();
                $('#otherDiv').show();
            } else{
                $('#incorrectNameDiv').hide();
                $('#incorrectDobDiv').hide();
                $('#incorrectCidNoDiv').hide();
                $('#incorrectGewogNameDiv').hide();
                $('#otherDiv').hide();
            }
        });
    }

    function saveAuthenticationPersonalDetails() {
        //if(validateAttachment()){
            $('#btnSubmitAD').on('click', function () {
                $('#authenticationPersonalDetailsFormId').validate({
                    submitHandler: function (form) {
                        var url = _baseURL() + 'saveAuthenticationPersonalDetails';
                        var formData = new FormData(form);
                        if (isSubmitted) {
                            errorMsg('Your request is processing. Please wait...');
                            return;
                        }
                        isSubmitted = true;
                        $('#btnSubmitAD').attr('disabled', true);
                        $.ajax({
                            url: url,
                            type: 'POST',
                            data: formData,
                            enctype: 'multipart/form-data',
                            contentType: false,
                            processData: false,
                            success: function (res) {
                                if (res.responseStatus == 1) {
                                    $('#acknowledgement').removeClass('hidden');
                                    $('#registration').addClass('hidden');
                                    $('#serviceName').text(res.serviceName);
                                    $('#applicationNo').text(res.applicationNumber);
                                    $('#courtName').text(res.courtName);
                                    $('.field').val('');
                                } else {
                                    warningMsg(res.responseText);
                                }
                            },
                            complete: function () {
                                isSubmitted = false;
                                $('#btnSubmitAD').attr('disabled', false);
                            },
                            error: function (res) {
                                errorMsg(res.responseText);
                            }
                        });
                    }
                });
            });
       // }
    }

    function validateAttachment() {
        var retval = true;
        if ($('#attachedFile').val() == "") {
            $('#attachedFileErrorMsg').html('Listed attachment is required');
            $('#attachedFile').addClass('error');
            retval = false;
        }
        return retval;
    }

    function validatePersonalDetail() {
        var retval = true;
        if ($('#cidNo').val() == "") {
            $('#cidNoErrorMsg').html('CID is required');
            $('#cidNo').addClass('error');
            retval = false;
        }
        return retval;
    }

    function validateDocumentSelection() {
        var retval = true;

        if ($('#mobileNo').val() == "") {
            $('#mobileNo').addClass('error');
            $('#mobileNoErrorMsg').html('Mobile Number is required');
            retval = false;
        }
        else if ($('#mobileNo').val().length != "8") {
            $('#mobileNo').addClass('error');
            $('#mobileNoErrorMsg').html('Mobile Number should have 8 digit');
            retval = false;
        }
        if ($('#address').val() == "") {
            $('#address').addClass('error');
            $('#addressErrorMsg').html('Please provide your address');
            retval = false;
        }
        if ($('#courtId').val() == "") {
            $('#courtId').addClass('error');
            $('#courtIdErrorMsg').html('Please select your court');
            retval = false;
        }
        if ($('#reason').val() == "") {
            $('#reason').addClass('error');
            $('#reasonErrorMsg').html('Please provide reason');
            retval = false;
        }
        return retval;
    }

    function validateCid(cid) {
        //age verification
        //security validation
        var retval = true;
        if (cid.substring(0, 1) >= 3) {
            $('#cidNoErrorMsg').html('Cid starting with greater than 3 is not allow');
            $('#fullName').val('');
            $('#cidNo').addClass('error');
            retval = false;
        }
        else if (cid.length != 11 && cid != '') {
            $('#cidNoErrorMsg').html('Bhutanese CID should have 11 digit long');
            $('#fullName').val('');
            $('#cidNo').addClass('error');
            retval = false;
        }
        return retval;
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

    function checkForAlreadyExistApplicant() {
        $('#cidNo').on('change', function () {
            var cidNo = $('#cidNo').val();
                if (validateCid(cidNo)) {
                    if (cidNo != '') {
                        var url = _baseURL() + 'checkForAlreadyExistApplicant';
                        $.ajax({
                            url: url,
                            type: 'GET',
                            data: {cidNo: cidNo},
                            success: function (res) {
                                var data = res.responseDTO;
                                if (res.responseStatus == 1) {
                                    var url = _baseURL() + 'getCitizenDetails';
                                    $.ajax({
                                        url: url,
                                        type: 'GET',
                                        data: {cidNo: cidNo},
                                        success: function (res) {
                                            var data = res.responseDTO;
                                            if (res.responseStatus == 1) {
                                                $('#cidNoErrorMsg').html('');
                                                $('#applicantName').val(data.applicantName);
                                                $('#gender').val(data.gender);
                                                $('#applicantDob').val(data.applicantDob);
                                                $('#fatherName').val(data.fatherName);
                                                $('#motherName').val(data.motherName);
                                                $('#villageId').val(data.villageId);
                                                $('#dzongkhagId').val(data.dzongkhagId);
                                                $('#gewogId').val(data.gewogId);
                                                $('#houseNo').val(data.houseNo);
                                                $('#tharmNo').val(data.tharmNo);
                                            } else {
                                                $('#cidNoErrorMsg').html(res.responseText);
                                                $('#applicantName').val('');
                                                $('#cidNo').val('');
                                                $('#cidNo').addClass('error');
                                            }
                                        }
                                    });
                                } else {
                                    warningMsg(res.responseText);
                                    $('#applicantName').val('');
                                    $('#cidNo').val('');
                                    $('#cidNo').addClass('error');
                                }
                            }
                        });
                    } else {
                        $('#cidNo').val();
                    }
            }

        });
    }

    function removeErrorMsg() {
        $('#cidNo').on('keyup blur', function () {
            var cid = $(this).val();
            if (cid != '') {
                $('#cidNoErrorMsg').text('');
                $('#cidNo').removeClass('error');
            }
        });
        $('#mobileNo').on('keyup blur', function () {
            var val = $(this).val();
            if (val != '') {
                $('#mobileNo').removeClass('error');
                $('#mobileNoErrorMsg').text('');
            }
        });
        $('#fatherName').on('keyup blur', function () {
            var val = $(this).val();
            if (val != '') {
                $('#fatherName').removeClass('error');
                $('#fatherNameErrorMsg').text('');
            }
        });
        $('#email').on('keyup blur', function () {
            var val = $(this).val();
            if (val != '') {
                $('#email').removeClass('error');
                $('#emailErrorMsg').text('');
            }
        });
        $('#address').on('keyup blur', function () {
            var val = $(this).val();
            if (val != '') {
                $('#address').removeClass('error');
                $('#addressErrorMsg').text('');
            }
        });
    }

    function addMoreAttachment() {
        var count = 1;
        $('#fileAttachmentTableId tbody').on('click', '#btnAddMore', function () {
            var row = "<tr style='border-top: hidden'>" +
                "<td>" + "<input type='file' id ='attachedFile"+count+"' class='alert badge-danger attachedFile' onchange='validateAttachment(this.value,this.id)' name ='fileAttachmentDTOs[0].attachedFile' required accept='image/jpeg,image/png,.doc,.docx,.pdf,.xlsx,.xls'/>" + "</td>" +
                "<td>" + "<button class='btn btn-sm btn-danger' type='button' id='btnRemove'><i class='fa fa-times'>Delete</i></button> &nbsp;&nbsp;&nbsp;&nbsp;" +
                "<button class='btn btn-sm btn-success' type='button' id='btnAddMore'><i class='fa fa-plus'>Add More</i></button>" + "</td>" +
                "</tr>";
            $('#fileAttachmentTableId tbody').append(row);
            $(this).addClass('hidden');
            $('#btnRemove').removeClass('hidden');
            formIndexing($('#fileAttachmentTableId tbody'), $('#fileAttachmentTableId tbody').find('tr'));
            count++
        });
    }

    function deleteAttachment() {
        $('#fileAttachmentTableId tbody').on('click', 'tr #btnRemove', function () {
            var rowLen = $('#fileAttachmentTableId tbody tr').length;
            $(this).closest('tr').remove();
            if (rowLen == 2) {
                $('#fileAttachmentTableId tr').last().find('#btnRemove').addClass('hidden');
            }
            $('#fileAttachmentTableId tr').last().find('#btnAddMore').removeClass('hidden');
            formIndexing($('#fileAttachmentTableId tbody'), $('#fileAttachmentTableId tbody').find('tr'));
        });
    }

    function checkFileSize() {
        $('#fileAttachmentTableId tbody').on('change', 'tr input[type=file]', function () {
            if ($('#attachedFile')[0].files.length > 0) {
                if ($('#attachedFile')[0].files[0].size < 20971520 == false) {
                    warningMsg('File too large. Please attach file size less than 20 MB.');
                    $('#attachedFile').val('');
                }
            }
        });
    }

    $('#email').on('blur', function () {
        var email = $(this).val().trim();
        if (email != '' && !isEmail(email)) {
            $('#emailErrorMsg').text('Email format is invalid.');
            $('#email').val('');
            $('#email').addClass('error');
        }
    });

    function downloadApplicationNo() {
        var doc = new jsPDF();
        var specialElementHandlers = {
            '#editor': function (element, renderer) {
                return true;
            }
        };
        $('#btnDownload').click(function () {
            doc.fromHTML($('#downloadAsPdf').html(), 15, 15, {
                'width': 170,
                'elementHandlers': specialElementHandlers
            });
            doc.save('Acknowledgement.pdf');
        });
    }

    function onChangeDzongkhagName(){
        $('#incorrectDzongkhagName').on('change', function () {
            $('#incorrectGewogName').empty();
            $('#incorrectVillageName').empty();
            var dzoId = $('#incorrectDzongkhagName').val();
            var url = _baseURL() + 'getGewogList';
            $.ajax({
                url: url,
                type: 'GET',
                data: {dzoId: dzoId},
                success: function (res) {
                    $('#incorrectGewogName').append("<option value='0'>--Select--</option>");
                    for(var i=0;i<res.length;i++){
                        $('#incorrectGewogName').append("<option value=" + res[i].valueInteger + ">" + res[i].text + "</option>");
                    }
                }
            });
        });
    }

    function onChangeGewogName(){
        $('#incorrectGewogName').on('change', function () {
            $('#incorrectVillageName').empty();
            var gewogId = $('#incorrectGewogName').val();
            var url = _baseURL() + 'getVillageList';
            $.ajax({
                url: url,
                type: 'GET',
                data: {gewogId: gewogId},
                success: function (res) {
                    $('#incorrectVillageName').append("<option value='0'>--Select--</option>");
                    for(var i=0;i<res.length;i++){
                        $('#incorrectVillageName').append("<option value=" + res[i].valueInteger + ">" + res[i].text + "</option>");
                    }
                }
            });
        });
    }

    return {
        disableTabs: disableTabs
        , btnNext: btnNext
        , btnPrevious: btnPrevious
        , onChangeAuthType: onChangeAuthType
        , onChangeDzongkhagName: onChangeDzongkhagName
        , onChangeGewogName: onChangeGewogName
        , removeErrorMsg: removeErrorMsg
        , checkForAlreadyExistApplicant: checkForAlreadyExistApplicant
        , addMoreAttachment: addMoreAttachment
        , checkFileSize: checkFileSize
        , deleteAttachment: deleteAttachment
        , saveAuthenticationPersonalDetails: saveAuthenticationPersonalDetails
        , downloadApplicationNo: downloadApplicationNo
    }
})
();
$(document).ready(
    function () {
        $('.field').val('');
        authenticationPersonalDetails.disableTabs();
        authenticationPersonalDetails.btnNext();
        authenticationPersonalDetails.onChangeAuthType();
        authenticationPersonalDetails.onChangeDzongkhagName();
        authenticationPersonalDetails.onChangeGewogName();
        authenticationPersonalDetails.btnPrevious();
        authenticationPersonalDetails.removeErrorMsg();
        authenticationPersonalDetails.checkForAlreadyExistApplicant();
        authenticationPersonalDetails.addMoreAttachment();
        authenticationPersonalDetails.checkFileSize();
        authenticationPersonalDetails.deleteAttachment();
        authenticationPersonalDetails.saveAuthenticationPersonalDetails();
        authenticationPersonalDetails.downloadApplicationNo();
    });

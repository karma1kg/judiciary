/**
 * Created by N-Zepa on 21-Jun-19.
 */
organTransplant = (function () {
    "use strict";
    var form = $('#organTransplantFormId');
    var isSubmitted = false;

    function _baseURL() {
        return 'organTransplant/';
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

    function validatePersonalDetail() {
        var retval = true;
        if ($('#cidNo').val() == "") {
            $('#cidNo').addClass('error');
            $('#cidNoErrorMsg').html('CID is required');
            retval = false;
        }
        if ($('#patientCid').val() == "") {
            $('#patientCid').addClass('error');
            $('#patientCidErrorMsg').html('Patient CID is required');
            retval = false;
        }
        if ($('#donorCid').val() == "") {
            $('#donorCid').addClass('error');
            $('#donorCidErrorMsg').html('Donor CID is required');
            retval = false;
        }
        if ($('#donorDepCid').val() == "") {
            $('#donorDepCid').addClass('error');
            $('#donorDepCidErrorMsg').html('Dependent CID is required');
            retval = false;
        }
        if ($('#witness1CidNo').val() == "") {
            $('#witness1CidNo').addClass('error');
            $('#witness1CidNoErrorMsg').html('Witness1 CID is required');
            retval = false;
        }
        if ($('#witness2CidNo').val() == "") {
            $('#witness2CidNo').addClass('error');
            $('#witness2CidNoErrorMsg').html('Witness2 CID is required');
            retval = false;
        }
        if ($('#patientDonorRelationship').val() == "") {
            $('#patientDonorRelationship').addClass('error');
            $('#patientDonorRelationshipErrorMsg').html('Patient relationship type is required');
            retval = false;
        }

        if ($('#donorDepRelationship').val() == "") {
            $('#donorDepRelationship').addClass('error');
            $('#donorDepRelationshipErrorMsg').html('Donor relationship type is required');
            retval = false;
        }

        if ($('#depRelationship').val() == "") {
            $('#depRelationship').addClass('error');
            $('#depRelationshipErrorMsg').html('Dependent relationship type is required');
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
        var retval = true;
        if (cid.substring(0, 1) >= 3) {
            $('#cidNoErrorMsg').html('Cid starting with greater than 3 is not allow');
            $('#cidNo').addClass('error');
            $('#fullName').val('');
            retval = false;
        }
        else if (cid.length != 11 && cid != '') {
            $('#cidNo').addClass('error');
            $('#cidNoErrorMsg').html('Bhutanese CID should have 11 digit long');
            $('#fullName').val('');
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
            var witness1CidNo = $('#witness1CidNo').val();
            var witness2CidNo = $('#witness2CidNo').val();
            if(cidNo != witness1CidNo || cidNo != witness2CidNo) {
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
            }else {
                $('#cidNoErrorMsg').text('Cannot use this CID# as applicant cid.');
                $('#cidNo').val('');
                $('#cidNo').addClass('error');
                $('#cidNoErrorMsg').val('');
            }

        });
    }

    function fetchPatientCitizenDetails() {
        $('#patientCid').on('change', function () {
            var cidNo = $('#cidNo').val();
            var witness1CidNo = $('#witness1CidNo').val();
            var witness2CidNo = $('#witness2CidNo').val();
            var patientCid = $('#patientCid').val();
            var donorCid = $('#donorCid').val();
            var donorDepCid = $('#donorDepCid').val();
            if(patientCid != cidNo || patientCid != witness2CidNo || patientCid != donorCid || patientCid != donorDepCid || patientCid != witness1CidNo) {
            if (validateCid(patientCid)) {
                if (patientCid != '') {
                    var url = _baseURL() + 'getCitizenDetails';
                    $.ajax({
                        url: url,
                        type: 'GET',
                        data: {cidNo: patientCid},
                        success: function (res) {
                            var data = res.responseDTO;
                            if (res.responseStatus == 1) {
                                $('#patientCidErrorMsg').html('');
                                $('#patientName').val(data.patientName);
                                $('#patientDob').val(data.patientDob);
                                $('#patientGender').val(data.patientGender);
                                $('#patientFathersName').val(data.patientFathersName);
                                $('#patientVillageId').val(data.patientVillageId);
                                $('#patientGewogId').val(data.patientGewogId);
                                $('#patientDzongkhagId').val(data.patientDzongkhagId);
                                $('#patientHouseNo').val(data.patientHouseNo);
                                $('#patientTharmNo').val(data.patientTharmNo);
                            } else {
                                $('#patientCidErrorMsg').html(res.responseText);
                                $('#patientName').val('');
                                $('#patientCid').val('');
                                $('#patientCid').addClass('error');
                            }
                        }
                    });
                } else {
                    $('#patientName').val('');
                    $('#patientDob').val('');
                    $('#patientGender').val('');
                    $('#patientFathersName').val('');
                    $('#patientVillageId').val('');
                    $('#patientGewogId').val('');
                    $('#patientDzongkhagId').val('');
                    $('#patientHouseNo').val('');
                    $('#patientTharmNo').val('');
                }
            }
        } else {
            $('#patientCidErrorMsg').text('Cannot use this CID# as patient.');
            $('#patientCidpatientCid').val('');
            $('#donorCid').addClass('error');
            $('#patientCidErrorMsg').val('');
        }
        });
    }
    function fetchDonorCitizenDetails() {
        $('#donorCid').on('change', function () {
            var cidNo = $('#cidNo').val();
            var witness1CidNo = $('#witness1CidNo').val();
            var witness2CidNo = $('#witness2CidNo').val();
            var patientCid = $('#patientCid').val();
            var donorCid = $('#donorCid').val();
            var donorDepCid = $('#donorDepCid').val();
            if(donorCid != cidNo || donorCid != witness2CidNo || donorCid != patientCid || donorCid != donorDepCid || donorCid != witness1CidNo) {
            if (validateCid(donorCid)) {
                if (donorCid != '') {
                    var url = _baseURL() + 'getCitizenDetails';
                    $.ajax({
                        url: url,
                        type: 'GET',
                        data: {cidNo: donorCid},
                        success: function (res) {
                            var data = res.responseDTO;
                            if (res.responseStatus == 1) {
                                $('#donorCidErrorMsg').html('');
                                $('#donorName').val(data.donorName);
                                $('#donorDob').val(data.donorDob);
                                $('#donorGender').val(data.donorGender);
                                $('#donorFathersName').val(data.donorFathersName);
                                $('#donorVillageId').val(data.donorVillageId);
                                $('#donorGewogId').val(data.donorGewogId);
                                $('#donorDzongkhagId').val(data.donorDzongkhagId);
                                $('#donorHouseNo').val(data.donorHouseNo);
                                $('#donorTharmNo').val(data.donorTharmNo);
                            } else {
                                $('#donorCidErrorMsg').html(res.responseText);
                                $('#donorName').val('');
                                $('#donorCid').val('');
                                $('#donorCid').addClass('error');
                            }
                        }
                    });
                } else {
                    $('#donorName').val('');
                    $('#donorDob').val('');
                    $('#donorGender').val('');
                    $('#donorFathersName').val('');
                    $('#donorVillageId').val('');
                    $('#donorGewogId').val('');
                    $('#donorDzongkhagId').val('');
                    $('#donorHouseNo').val('');
                    $('#donorTharmNo').val('');
                }
            }
            } else {
                $('#donorCidErrorMsg').text('Cannot use this CID# as donor dependent.');
                $('#donorCid').val('');
                $('#donorCid').addClass('error');
                $('#donorCidErrorMsg').val('');
            }
        });
    }
    function fetchDonorDependentCitizenDetails() {
        $('#donorDepCid').on('change', function () {
            var cidNo = $('#cidNo').val();
            var witness1CidNo = $('#witness1CidNo').val();
            var witness2CidNo = $('#witness2CidNo').val();
            var patientCid = $('#patientCid').val();
            var donorCid = $('#donorCid').val();
            var donorDepCid = $('#donorDepCid').val();
            if(donorDepCid != cidNo || donorDepCid != witness2CidNo || donorDepCid != patientCid || donorDepCid != donorCid || donorDepCid != witness1CidNo) {
            if (validateCid(donorDepCid)) {
                if (donorDepCid != '') {
                    var url = _baseURL() + 'getCitizenDetails';
                    $.ajax({
                        url: url,
                        type: 'GET',
                        data: {cidNo: donorDepCid},
                        success: function (res) {
                            var data = res.responseDTO;
                            if (res.responseStatus == 1) {
                                $('#donorDepCidErrorMsg').html('');
                                $('#donorDepName').val(data.donorDepName);
                                $('#donorDepDob').val(data.donorDepDob);
                                $('#donorDepGender').val(data.donorDepGender);
                                $('#donorDepFathersName').val(data.donorDepFathersName);
                                $('#donorDepVillageId').val(data.donorDepVillageId);
                                $('#donorDepGewogId').val(data.donorDepGewogId);
                                $('#donorDepDzongkhagId').val(data.donorDepDzongkhagId);
                                $('#donorDepHouseNo').val(data.donorDepHouseNo);
                                $('#donorDepTharmNo').val(data.donorDepTharmNo);
                            } else {
                                $('#donorDepCidErrorMsg').html(res.responseText);
                                $('#donorDepName').val('');
                                $('#donorDepCid').val('');
                                $('#donorDepCid').addClass('error');
                            }
                        }
                    });
                } else {
                    $('#donorDepName').val('');
                    $('#donorDepDob').val('');
                    $('#donorDepGender').val('');
                    $('#donorDepFathersName').val('');
                    $('#donorDepVillageId').val('');
                    $('#donorDepGewogId').val('');
                    $('#donorDepDzongkhagId').val('');
                    $('#donorDepHouseNo').val('');
                    $('#donorDepTharmNo').val('');
                }
            }
            } else {
                $('#donorDepCidErrorMsg').text('Cannot use this CID# as donor dependent.');
                $('#donorDepCid').val('');
                $('#donorDepCid').addClass('error');
                $('#donorDepCidErrorMsg').val('');
            }
        });
    }

    function fetchWitness1CitizenDetails() {
        $('#witness1CidNo').on('change', function () {
            var cidNo = $('#cidNo').val();
            var witness1CidNo = $('#witness1CidNo').val();
            var witness2CidNo = $('#witness2CidNo').val();
            var patientCid = $('#patientCid').val();
            var donorCid = $('#donorCid').val();
            var donorDepCid = $('#donorDepCid').val();
            if(witness1CidNo != cidNo || witness1CidNo != witness2CidNo || witness1CidNo != patientCid || witness1CidNo != donorCid || witness1CidNo != donorDepCid) {
            if (validateCid(witness1CidNo)) {
                if (witness1CidNo != '') {
                    var url = _baseURL() + 'getCitizenDetails';
                    $.ajax({
                        url: url,
                        type: 'GET',
                        data: {cidNo: witness1CidNo},
                        success: function (res) {
                            var data = res.responseDTO;
                            if (res.responseStatus == 1) {
                                $('#witness1CidNoErrorMsg').html('');
                                $('#witness1Name').val(data.witness1Name);
                                $('#w1Dob').val(data.w1Dob);
                                $('#w1Gender').val(data.w1Gender);
                                $('#w1fathersName').val(data.w1fathersName);
                                $('#w1villageId').val(data.w1villageId);
                                $('#w1gewogId').val(data.w1gewogId);
                                $('#w1dzongkhagId').val(data.w1dzongkhagId);
                                $('#w1houseNo').val(data.w1houseNo);
                                $('#w1tharmNo').val(data.w1tharmNo);
                            } else {
                                $('#witness1CidNoErrorMsg').html(res.responseText);
                                $('#witness1Name').val('');
                                $('#witness1CidNo').val('');
                                $('#witness1CidNo').addClass('error');
                            }
                        }
                    });
                } else {
                    $('#witness1Name').val('');
                    $('#w1Dob').val('');
                    $('#w1Gender').val('');
                    $('#w1fathersName').val('');
                    $('#w1villageId').val('');
                    $('#w1gewogId').val('');
                    $('#w1dzongkhagId').val('');
                    $('#w1houseNo').val('');
                    $('#w1tharmNo').val('');
                }
            }
            } else {
                $('#witness1CidNoErrorMsg').text('Cannot use this CID# as witness 1.');
                $('#witness1CidNo').val('');
                $('#witness1CidNo').addClass('error');
                $('#witness1CidNoErrorMsg').val('');
            }
        });
    }
    function fetchWitness2CitizenDetails() {
        $('#witness2CidNo').on('change', function () {
            var witness2CidNo = $(this).val();
            var cidNo = $('#cidNo').val();
            var witness1CidNo = $('#witness1CidNo').val();
            var witness2CidNo = $('#witness2CidNo').val();
            var patientCid = $('#patientCid').val();
            var donorCid = $('#donorCid').val();
            var donorDepCid = $('#donorDepCid').val();
            if(witness2CidNo != cidNo || witness2CidNo != witness1CidNo || witness2CidNo != patientCid || witness2CidNo != donorCid || witness2CidNo != donorDepCid) {
            if (validateCid(witness2CidNo)) {
                if (witness2CidNo != '') {
                    var url = _baseURL() + 'getCitizenDetails';
                    $.ajax({
                        url: url,
                        type: 'GET',
                        data: {cidNo: witness2CidNo},
                        success: function (res) {
                            var data = res.responseDTO;
                            if (res.responseStatus == 1) {
                                $('#witness2CidNoErrorMsg').html('');
                                $('#witness2Name').val(data.witness2Name);
                                $('#w2Dob').val(data.w2Dob);
                                $('#w2gender').val(data.w2gender);
                                $('#w2fathersName').val(data.w2fathersName);
                                $('#w2villageId').val(data.w2villageId);
                                $('#w2gewogId').val(data.w2gewogId);
                                $('#w2dzongkhagId').val(data.w2dzongkhagId);
                                $('#w2houseNo').val(data.w2houseNo);
                                $('#w2tharmNo').val(data.w2tharmNo);
                            } else {
                                $('#witness2CidNoErrorMsg').html(res.responseText);
                                $('#witness2Name').val('');
                                $('#witness2CidNo').val('');
                                $('#witness2CidNo').addClass('error');
                            }
                        }
                    });
                } else {
                    $('#witness2Name').val('');
                    $('#w2Dob').val('');
                    $('#w2gender').val('');
                    $('#w2fathersName').val('');
                    $('#w2villageId').val('');
                    $('#w2gewogId').val('');
                    $('#w2dzongkhagId').val('');
                    $('#w2houseNo').val('');
                    $('#w2tharmNo').val('');
                }
            }
        } else {
            $('#witness2CidNoErrorMsg').text('Cannot use this CID# as witness 2.');
            $('#witness2CidNo').val('');
            $('#witness2CidNo').addClass('error');
            $('#witness2CidNoErrorMsg').val('');
        }
        });
    }

    function removeErrorMsg() {
        $('#cidNo').on('keyup blur', function () {
            var cid = $(this).val();
            if (cid != '') {
                $('#cidNo').removeClass('error');
                $('#cidNoErrorMsg').text('');
            }
        });

        $('#patientCid').on('keyup blur', function () {
            var cid = $(this).val();
            if (cid != '') {
                $('#patientCid').removeClass('error');
                $('#patientCidErrorMsg').text('');
            }
        });

        $('#donorCid').on('keyup blur', function () {
            var cid = $(this).val();
            if (cid != '') {
                $('#donorCid').removeClass('error');
                $('#donorCidErrorMsg').text('');
            }
        });

        $('#donorDepCid').on('keyup blur', function () {
            var cid = $(this).val();
            if (cid != '') {
                $('#donorDepCid').removeClass('error');
                $('#donorDepCidErrorMsg').text('');
            }
        });
        $('#witness1CidNo').on('keyup blur', function () {
            var cid = $(this).val();
            if (cid != '') {
                $('#witness1CidNo').removeClass('error');
                $('#witness1CidNoErrorMsg').text('');
            }
        });

        $('#witness2CidNo').on('keyup blur', function () {
            var cid = $(this).val();
            if (cid != '') {
                $('#witness2CidNo').removeClass('error');
                $('#witness2CidNoErrorMsg').text('');
            }
        });

        $('#patientDonorRelationship').on('keyup blur', function () {
            var cid = $(this).val();
            if (cid != '') {
                $('#patientDonorRelationship').removeClass('error');
                $('#patientDonorRelationshipErrorMsg').text('');
            }
        });

        $('#donorDepRelationship').on('keyup blur', function () {
            var cid = $(this).val();
            if (cid != '') {
                $('#donorDepRelationship').removeClass('error');
                $('#donorDepRelationshipErrorMsg').text('');
            }
        });

        $('#depRelationship').on('keyup blur', function () {
            var cid = $(this).val();
            if (cid != '') {
                $('#depRelationship').removeClass('error');
                $('#depRelationshipErrorMsg').text('');
            }
        });

        $('#mobileNo').on('keyup blur', function () {
            var val = $(this).val();
            if (val != '') {
                $('#mobileNo').removeClass('error');
                $('#mobileNoErrorMsg').text('');
            }
        });
        $('#courtId').on('keyup blur', function () {
            var val = $(this).val();
            if (val != '') {
                $('#courtId').removeClass('error');
                $('#courtIdErrorMsg').text('');
            }
        });
        $('#address').on('keyup blur', function () {
            var val = $(this).val();
            if (val != '') {
                $('#address').removeClass('error');
                $('#addressErrorMsg').text('');
            }
        });
        $('#email').on('keyup blur', function () {
            var val = $(this).val();
            if (val != '') {
                $('#email').removeClass('error');
                $('#emailErrorMsg').text('');
            }
        });
        $('#reason').on('keyup blur', function () {
            var val = $(this).val();
            if (val != '') {
                $('#reason').removeClass('error');
                $('#reasonErrorMsg').text('');
            }
        });
    }

    function saveOrganTransplant() {
        $('#btnSubmit').on('click', function () {
            $('#organTransplantFormId').validate({
                submitHandler: function (form) {
                    var url = _baseURL() + 'saveOrganTransplant';
                    var formData = new FormData(form);
                    if (isSubmitted) {
                        errorMsg('Your request is processing. Please wait...');
                        return;
                    }
                    isSubmitted = true;
                    $('#btnSubmit').attr('disabled', true);
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
                            $('#btnSubmit').attr('disabled', false);
                        },
                        error: function (res) {
                            errorMsg(res.responseText);
                        }
                    });
                }
            });
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

    return {
        disableTabs: disableTabs
        , btnNext: btnNext
        , btnPrevious: btnPrevious
        , removeErrorMsg: removeErrorMsg
        , checkForAlreadyExistApplicant: checkForAlreadyExistApplicant
        , fetchPatientCitizenDetails: fetchPatientCitizenDetails
        , fetchDonorCitizenDetails: fetchDonorCitizenDetails
        , fetchDonorDependentCitizenDetails: fetchDonorDependentCitizenDetails
        , fetchWitness1CitizenDetails: fetchWitness1CitizenDetails
        , fetchWitness2CitizenDetails: fetchWitness2CitizenDetails
        , addMoreAttachment: addMoreAttachment
        , checkFileSize: checkFileSize
        , deleteAttachment: deleteAttachment
        , saveOrganTransplant: saveOrganTransplant
        , downloadApplicationNo: downloadApplicationNo
    }
})
();
$(document).ready(
    function () {
        $('.field').val('');
        organTransplant.disableTabs();
        organTransplant.btnNext();
        organTransplant.btnPrevious();
        organTransplant.removeErrorMsg();
        organTransplant.checkForAlreadyExistApplicant();
        organTransplant.fetchPatientCitizenDetails();
        organTransplant.fetchDonorCitizenDetails();
        organTransplant.fetchDonorDependentCitizenDetails();
        organTransplant.fetchWitness1CitizenDetails();
        organTransplant.fetchWitness2CitizenDetails();
        organTransplant.addMoreAttachment();
        organTransplant.deleteAttachment();
        organTransplant.checkFileSize();
        organTransplant.saveOrganTransplant();
        organTransplant.downloadApplicationNo();
    });

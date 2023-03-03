/**
 * Created by N-Zepa on 21-Jun-19.
 */
childTravelDocument = (function () {
    "use strict";
    var form = $('#childTravelDocumentFormId');
    var isSubmitted = false;

    function _baseURL() {
        return 'childTravelDocument/';
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
        if ($('#childName').val() == "") {
            $('#childName').addClass('error');
            $('#childNameErrorMsg').html('Child name is required');
            retval = false;
        }
        if ($('#childDob').val() == "") {
            $('#childDob').addClass('error');
            $('#childDobErrorMsg').html('Child DoB is required');
            retval = false;
        }
        if ($('#childGender').val() == "") {
            $('#childGender').addClass('error');
            $('#childGenderErrorMsg').html('Child gender is required');
            retval = false;
        }
        if ($('#relationShip').val() == "") {
            $('#relationShip').addClass('error');
            $('#relationShipErrorMsg').html('Child relationship is required');
            retval = false;
        }
        if ($('#travelPlace').val() == "") {
            $('#travelPlace').addClass('error');
            $('#travelPlaceErrorMsg').html('Travel place for child is required');
            retval = false;
        }
        if ($('#orgFatherCid').val() == "") {
            $('#orgFatherCid').addClass('error');
            $('#orgFatherCidErrorMsg').html('Biological father Cid is required');
            retval = false;
        }
        if ($('#orgMotherCid').val() == "") {
            $('#orgMotherCid').addClass('error');
            $('#orgMotherCidErrorMsg').html('Biological mother Cid is required');
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
            var orgFatherCid = $('#orgFatherCid').val();
            var orgMotherCid = $('#orgMotherCid').val();
            if(cidNo != orgFatherCid || cidNo != orgMotherCid) {
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
                } else {
                    $('#cidNoErrorMsg').text('Cannot use this CID# as applicant cid.');
                    $('#cidNo').val('');
                    $('#cidNo').addClass('error');
                    $('#cidNoErrorMsg').val('');
                }
        });
    }
    function fetchOrgFatherCitizenDetails() {
        $('#orgFatherCid').on('change', function () {
            var cidNo = $('#cidNo').val();
            var orgFatherCid = $('#orgFatherCid').val();
            var orgMotherCid = $('#orgMotherCid').val();
            if(orgFatherCid != cidNo || orgFatherCid != orgMotherCid) {
            if (validateCid(orgFatherCid)) {
                if (orgFatherCid != '') {
                    var url = _baseURL() + 'getCitizenDetails';
                    $.ajax({
                        url: url,
                        type: 'GET',
                        data: {cidNo: orgFatherCid},
                        success: function (res) {
                            var data = res.responseDTO;
                            if (res.responseStatus == 1) {
                                $('#orgFatherCidErrorMsg').html('');
                                $('#orgFatherName').val(data.orgFatherName);
                                $('#orgFatherGender').val(data.orgFatherGender);
                                $('#orgFatherVillageId').val(data.orgFatherVillageId);
                                $('#orgFatherGewogId').val(data.orgFatherGewogId);
                                $('#orgFatherDzongkhagId').val(data.orgFatherDzongkhagId);
                                $('#orgFatherHouseNo').val(data.orgFatherHouseNo);
                                $('#orgFatherTharmNo').val(data.orgFatherTharmNo);
                            } else {
                                $('#orgFatherCidErrorMsg').html(res.responseText);
                                $('#orgFatherName').val('');
                                $('#orgFatherCid').val('');
                                $('#orgFatherCid').addClass('error');
                            }
                        }
                    });
                } else {
                    $('#orgFatherName').val('');
                    $('#orgFatherDob').val('');
                    $('#orgFatherGender').val('');
                    $('#orgFatherFathersName').val('');
                    $('#orgFatherVillageId').val('');
                    $('#orgFatherGewogId').val('');
                    $('#orgFatherDzongkhagId').val('');
                    $('#orgFatherHouseNo').val('');
                    $('#orgFatherTharmNo').val('');
                }
            }
            }else {
                $('#orgFatherCidErrorMsg').text('Cannot use this CID# as biological father cid.');
                $('#orgFatherCid').val('');
                $('#orgFatherCid').addClass('error');
                $('#orgFatherCidErrorMsg').val('');
            }
        });
    }
    function fetchOrgMotherCitizenDetails() {
        $('#orgMotherCid').on('change', function () {
            var orgMotherCid = $(this).val();
            var cidNo = $('#cidNo').val();
            var orgFatherCid = $('#orgFatherCid').val();
            var orgMotherCid = $('#orgMotherCid').val();
            if(orgMotherCid != cidNo || orgMotherCid != orgFatherCid) {
            if (validateCid(orgMotherCid)) {
                if (orgMotherCid != '') {
                    var url = _baseURL() + 'getCitizenDetails';
                    $.ajax({
                        url: url,
                        type: 'GET',
                        data: {cidNo: orgMotherCid},
                        success: function (res) {
                            var data = res.responseDTO;
                            if (res.responseStatus == 1) {
                                $('#orgMotherCidErrorMsg').html('');
                                $('#orgMotherName').val(data.orgMotherName);
                                $('#orgMotherGender').val(data.orgMotherGender);
                                $('#orgMotherVillageId').val(data.orgMotherVillageId);
                                $('#orgMotherGewogId').val(data.orgMotherGewogId);
                                $('#orgMotherDzongkhagId').val(data.orgMotherDzongkhagId);
                                $('#orgMotherHouseNo').val(data.orgMotherHouseNo);
                                $('#orgMotherTharmNo').val(data.orgMotherTharmNo);
                            } else {
                                $('#orgMotherCidErrorMsg').html(res.responseText);
                                $('#orgMotherName').val('');
                                $('#orgMotherCid').val('');
                                $('#orgMotherCid').addClass('error');
                            }
                        }
                    });
                } else {
                    $('#orgMotherName').val('');
                    $('#orgMotherDob').val('');
                    $('#orgMotherGender').val('');
                    $('#orgMotherFathersName').val('');
                    $('#orgMotherVillageId').val('');
                    $('#orgMotherGewogId').val('');
                    $('#orgMotherDzongkhagId').val('');
                    $('#orgMotherHouseNo').val('');
                    $('#orgMotherTharmNo').val('');
                }
            }
            } else {
                $('#orgMotherCidErrorMsg').text('Cannot use this CID# as biological mother cid.');
                $('#orgMotherCid').val('');
                $('#orgMotherCid').addClass('error');
                $('#orgMotherCidErrorMsg').val('');
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
        $('#childName').on('keyup blur', function () {
            var cid = $(this).val();
            if (cid != '') {
                $('#childName').removeClass('error');
                $('#childNameErrorMsg').text('');
            }
        $('#childDob').on('keyup blur', function () {
            var childDob = $(this).val();
            if (childDob != '') {
                $('#childDob').removeClass('error');
                $('#childDobErrorMsg').text('');
            }
        });
        });
        $('#childGender').on('keyup blur', function () {
            var childGender = $(this).val();
            if (childGender != '') {
                $('#childGender').removeClass('error');
                $('#childGenderErrorMsg').text('');
            }
        });
        $('#relationShip').on('keyup blur', function () {
            var relationShip = $(this).val();
            if (relationShip != '') {
                $('#relationShip').removeClass('error');
                $('#relationShipErrorMsg').text('');
            }
        });
        $('#travelPlace').on('keyup blur', function () {
            var travelPlace = $(this).val();
            if (travelPlace != '') {
                $('#travelPlace').removeClass('error');
                $('#travelPlaceErrorMsg').text('');
            }
        });
        $('#orgMotherCid').on('keyup blur', function () {
            var orgMotherCid = $(this).val();
            if (orgMotherCid != '') {
                $('#orgMotherCid').removeClass('error');
                $('#orgMotherCidErrorMsg').text('');
            }
        });
        $('#orgFatherCid').on('keyup blur', function () {
            var orgFatherCid = $(this).val();
            if (orgFatherCid != '') {
                $('#orgFatherCid').removeClass('error');
                $('#orgFatherCidErrorMsg').text('');
            }
        });
        $('#mobileNo').on('keyup blur', function () {
            var mobileNo = $(this).val();
            if (mobileNo != '') {
                $('#mobileNo').removeClass('error');
                $('#mobileNoErrorMsg').text('');
            }
        });
        $('#courtId').on('keyup blur', function () {
            var courtId = $(this).val();
            if (courtId != '') {
                $('#courtId').removeClass('error');
                $('#courtIdErrorMsg').text('');
            }
        });
        $('#address').on('keyup blur', function () {
            var address = $(this).val();
            if (address != '') {
                $('#address').removeClass('error');
                $('#addressErrorMsg').text('');
            }
        });
        $('#email').on('keyup blur', function () {
            var email = $(this).val();
            if (email != '') {
                $('#email').removeClass('error');
                $('#emailErrorMsg').text('');
            }
        });
        $('#reason').on('keyup blur', function () {
            var reason = $(this).val();
            if (reason != '') {
                $('#reason').removeClass('error');
                $('#reasonErrorMsg').text('');
            }
        });
    }

    function saveChildTravelDocument() {
        $('#btnSubmit').on('click', function () {
            $('#childTravelDocumentFormId').validate({
                submitHandler: function (form) {
                    var url = _baseURL() + 'saveChildTravelDocument';
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
        , fetchOrgFatherCitizenDetails:fetchOrgFatherCitizenDetails
        , fetchOrgMotherCitizenDetails:fetchOrgMotherCitizenDetails
        , addMoreAttachment: addMoreAttachment
        , checkFileSize: checkFileSize
        , deleteAttachment: deleteAttachment
        , saveChildTravelDocument: saveChildTravelDocument
        , downloadApplicationNo: downloadApplicationNo
    }
})
();
$(document).ready(
    function () {
        $('.field').val('');
        childTravelDocument.disableTabs();
        childTravelDocument.btnNext();
        childTravelDocument.btnPrevious();
        childTravelDocument.removeErrorMsg();
        childTravelDocument.checkForAlreadyExistApplicant();
        childTravelDocument.fetchOrgFatherCitizenDetails();
        childTravelDocument.fetchOrgMotherCitizenDetails();
        childTravelDocument.addMoreAttachment();
        childTravelDocument.checkFileSize();
        childTravelDocument.deleteAttachment();
        childTravelDocument.saveChildTravelDocument();
        childTravelDocument.downloadApplicationNo();
});

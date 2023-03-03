/**
 * Created by Kg on 21-Jun-19.
 */
newMarriageCertificate = (function () {
    "use strict";
    var form = $('#newMarriageCertificateFormId');
    var isSubmitted = false;
    $('#confirmChildDiv').hide();

    function _baseURL() {
        return 'newMarriageCertificate/';
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
            var cidNo = $('#cidNo').val();
            var spouseCidNo = $('#spouseCidNo').val();
            var witness1CidNo = $('#witness1CidNo').val();
            var witness2CidNo = $('#witness2CidNo').val();
            if (validatePersonalDetail() && validateCid(cidNo) && validateCid1(spouseCidNo) && validateCid2(witness1CidNo) && validateCid3(witness2CidNo)) {
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
        if ($('#religion').val() == "") {
            $('#religion').addClass('error');
            $('#religionErrorMsg').html('Your religion is required');
            retval = false;
        }
        if ($('#spouseCidNo').val() == "") {
            $('#spouseCidNo').addClass('error');
            $('#spouseCidNoErrorMsg').html('Spouse CID is required');
            retval = false;
        }
        if(($('#spouseCidNo').val()!=null)&& $('#spouseCidNo').val()==$('#cidNo').val()){
            $('#spouseCidNo').addClass('error');
            $('#spouseCidNoErrorMsg').html('You can&apos;t  marry yourself');
            retval = false;
        }
        if ($('#spouseReligion').val() == "") {
            $('#spouseReligion').addClass('error');
            $('#religion1ErrorMsg').html('Your spouse religion is required');
            retval = false;
        }
        if ($('#confirmChild').val() == "") {
            $('#confirmChild').addClass('error');
            $('#confirmChildErrorMsg').html('Select is required');
            retval = false;
        }
        if ($('#confirmChild').val() == "Y") {
            if ($('#childName').val() == "") {
                $('#childName').addClass('error');
                $('#childNameErrorMsg').html('Child name is required');
                retval = false;
            }
            if ($('#childDob').val() == "") {
                $('#childDob').addClass('error');
                $('#childDobErrorMsg').html('Child DOB is required');
                retval = false;
            }

            if ($('#childGender').val() == "") {
                $('#childGender').addClass('error');
                $('#childGenderErrorMsg').html('Child gender is required');
                retval = false;
            }
        }
        if ($('#witness1CidNo').val() == "") {
            $('#witness1CidNo').addClass('error');
            $('#witness1CidNoErrorMsg').html('Witness 1 CID is required');
            retval = false;
        }
        if ($('#witness2CidNo').val() == "") {
            $('#witness2CidNo').addClass('error');
            $('#witness2CidNoErrorMsg').html('Witness 2 CID is required');
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

    function validateCid(cidNo) {
        var retval = true;
        if (cidNo.substr(0, 1) >= 3) {
            $('#cidNo').addClass('error');
            $('#cidNoErrorMsg').html('CID starting with or greater than 3 is not allowed');
            $('#fullName').val('');
            retval = false;
        }
        else if (cidNo.length != 11 && cidNo != '') {
            $('#cidNo').addClass('error');
            $('#cidNoErrorMsg').html('Bhutanese CID should be 11 digit long');
            $('#fullName').val('');
            retval = false;
        }
        /*else if (cidNo == $('#spouseCidNo').val('') || cidNo== $('#witness1CidNo').val('') || cidNo ==$('#witness2CidNo').val('')){
         $('#cidNo').addClass('error');
         $('#cidNoErrorMsg').html('Cannot use same CID# as applicant CID');
         $('#fullName').val('');
         retval = false;
         }*/
        return retval;
    }
    function validateCid1(spouseCidNo) {
        var retval = true;
        if (spouseCidNo.substring(0, 1) >= 3) {
            $('#spouseCidNo').addClass('error');
            $('#spouseCidNoErrorMsg').html('CID starting with greater than 3 is not allow');
            $('#fullName').val('');
            retval = false;
        }
        else if (spouseCidNo.length != 11 && spouseCidNo != '') {
            $('#spouseCidNo').addClass('error');
            $('#spouseCidNoErrorMsg').html('Bhutanese CID should have 11 digit long');
            $('#fullName').val('');
            retval = false;
        }
        /*else if (spouseCidNo == $('#cidNo').val('') || spouseCidNo== $('#witness1CidNo').val('') || spouseCidNo ==$('#witness2CidNo').val('')){
         $('#spouseCidNo').addClass('error');
         $('#spouseCidNoErrorMsg').html('Cannot use same CID# as spouse CID');
         $('#fullName').val('');
         retval = false;
         }*/
        return retval;
    }
    function validateCid2(witness1CidNo) {
        var retval = true;
        if (witness1CidNo.length != 11 && witness1CidNo != '') {
            $('#witness1CidNo').addClass('error');
            $('#witness1CidNoErrorMsg').html('Bhutanese CID should have 11 digit long');
            $('#fullName').val('');
            retval = false;
        }
        else if (witness1CidNo.substring(0, 1) >= 3) {
            $('#witness1CidNo').addClass('error');
            $('#witness1CidNoErrorMsg').html('Cid starting with greater than 3 is not allow');
            $('#fullName').val('');
            retval = false;
        }
        /*else if (witness1CidNo == $('#cidNo').val('') || witness1CidNo== $('#spouseCidNo').val('') || witness1CidNo ==$('#witness2CidNo').val('')){
         $('#witness1CidNo').addClass('error');
         $('#witness1CidNoErrorMsg').html('Cannot use same CID# as male witness CID');
         $('#fullName').val('');
         retval = false;
         }*/
        return retval;
    }
    function validateCid3(witness2CidNo) {
        var retval = true;
        if (witness2CidNo.length != 11 && witness2CidNo != '') {
            $('#witness2CidNo').addClass('error');
            $('#witness2CidNoErrorMsg').html('Bhutanese CID should have 11 digit long');
            $('#fullName').val('');
            retval = false;
        }
        else if (witness2CidNo.substring(0, 1) >= 3) {
            $('#witness2CidNo').addClass('error');
            $('#witness2CidNoErrorMsg').html('Cid starting with greater than 3 is not allow');
            $('#fullName').val('');
            retval = false;
        }
        /*else if (witness2CidNo == $('#cidNo').val('') || witness2CidNo== $('#spouseCidNo').val('') || witness2CidNo ==$('#witness1CidNo').val('')){
         $('#witness2CidNo').addClass('error');
         $('#witness2CidNoErrorMsg').html('Cannot use same CID# as female witness CID');
         $('#fullName').val('');
         retval = false;
         }*/
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

    function onChangeChildDetail() {
        $('#confirmChild').on('change', function () {
            var val = $(this).val();
            if (val == "Y") {
                $('#confirmChildDiv').show();
            }
            else {
                $('#confirmChildDiv').hide();
            }
        });
    }

    function checkForAlreadyExistApplicant() {
        $('#cidNo').on('change', function () {
            var cidNo = $('#cidNo').val();
            var spouseCidNo = $('#spouseCidNo').val();
            var w1CidNo = $('#witness1CidNo').val();
            var w2CidNo = $('#witness2CidNo').val();
            if(cidNo != spouseCidNo || cidNo != w1CidNo || cidNo != w2CidNo) {
                if (validateCid(cidNo)) {
                    if (cidNo != '') {
                        var url = _baseURL() + 'checkForAlreadyExistApplicant';
                        $.ajax({
                            url: url,
                            type: 'GET',
                            data: {cidNo: cidNo},
                            success: function (res) {
                                var data = res.responseDTO;
                                debugger;
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
                                                /*$('#applicantDobBh').val(data.applicantDobBh);*/
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
            }/*else {
             //$('#cidNoErrorMsg').text('Cannot use this CID# as applicant cid.');
             // $('#cidNo').val('');
             //$('#cidNo').addClass('error');
             //$('#cidNoErrorMsg').val('');
             }*/
        });
    }

    function checkForAlreadyExistSpouse() {
        $('#spouseCidNo').on('change', function () {
            var spouseCidNo = $('#spouseCidNo').val();
            var appCidNo = $('#cidNo').val();
            var witness1CidNo = $('#witness1CidNo').val();
            var witness2CidNo = $('#witness2CidNo').val();
            if(spouseCidNo != appCidNo || spouseCidNo != witness1CidNo || spouseCidNo != witness2CidNo){
                if (validateCid1(spouseCidNo)) {
                    if (spouseCidNo != '') {
                        var url = _baseURL() + 'checkForAlreadyExistSpouse';
                        $.ajax({
                            url: url,
                            type: 'GET',
                            data: {cidNo: spouseCidNo},
                            success: function (res) {
                                var data = res.responseDTO;
                                if (res.responseStatus == 1) {
                                    var url = _baseURL() + 'getCitizenDetails';
                                    $.ajax({
                                        url: url,
                                        type: 'GET',
                                        data: {cidNo: spouseCidNo},
                                        success: function (res) {
                                            var data = res.responseDTO;
                                            if (res.responseStatus == 1) {
                                                $('#spouseCidNoErrorMsg').html('');
                                                $('#spouseName').val(data.spouseName);
                                                $('#spouseGender').val(data.spouseGender);
                                                $('#spouseApplicantDob').val(data.spouseApplicantDob);
                                                $('#spouseFathersName').val(data.spouseFathersName);
                                                $('#spouseMothersName').val(data.spouseMothersName);
                                                $('#spouseVillageId').val(data.spouseVillageId);
                                                $('#spouseDzongkhagId').val(data.spouseDzongkhagId);
                                                $('#spouseGewogId').val(data.spouseGewogId);
                                                $('#spouseHouseNo').val(data.spouseHouseNo);
                                                $('#spouseTharmNo').val(data.spouseTharmNo);
                                            } else {
                                                $('#spouseCidNoErrorMsg').html(res.responseText);
                                                $('#fullName').val('');
                                                $('#spouseCidNo').val('');
                                                $('#spouseCidNo').addClass('error');
                                            }
                                        }
                                    });
                                } else {
                                    warningMsg(res.responseText);
                                    $('#spouseName').val('');
                                    $('#spouseCidNo').val('');
                                    $('#spouseCidNo').addClass('error');
                                }
                            }
                        });
                    } else {
                        $('#spouseCidNo').val();
                    }
                } /*else {
                 $('#spouseCidNoErrorMsg').text('Cannot use this CID# as spouse cid.');
                 $('#spouseCidNo').val('');
                 $('#spouseCidNo').addClass('error');
                 $('#spouseCidNoErrorMsg').val('');
                 }*/
            }
        });
    }


    function checkForAlreadyMarriedApplicant() {
        $('#cidNo').on('change', function () {
            var cidNo = $('#cidNo').val();
            var spouseCidNo = $('#spouseCidNo').val();
            if(cidNo != spouseCidNo) {
                if (validateCid(cidNo)) {
                    if (cidNo != '') {
                        var url = _baseURL() + 'checkForAlreadyMarriedApplicant';
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


                        var url = _baseURL() + 'checkForMcApplied3Times';
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
                //$('#cidNoErrorMsg').text('Cannot use this CID# as applicant cid.');
                $('#cidNo').val('');
                $('#cidNo').addClass('error');
                // $('#cidNoErrorMsg').val('');
            }
        });
    }


    function checkForAlreadyMarriedSpouse() {
        $('#spouseCidNo').on('change', function () {
            var spouseCidNo = $('#spouseCidNo').val();
            var appCidNo = $('#cidNo').val();
            if(spouseCidNo != appCidNo) {
                if (validateCid(spouseCidNo)) {
                    if (spouseCidNo != '') {
                        var url = _baseURL() + 'checkForAlreadyMarriedSpouse';
                        $.ajax({
                            url: url,
                            type: 'GET',
                            data: {spouseCidNo: spouseCidNo},
                            success: function (res) {
                                var data = res.responseDTO;
                                if (res.responseStatus == 1) {
                                    var url = _baseURL() + 'getCitizenDetails';
                                    $.ajax({
                                        url: url,
                                        type: 'GET',
                                        data: {spouseCidNo: spouseCidNo},
                                        success: function (res) {
                                            var data = res.responseDTO;
                                            if (res.responseStatus == 1) {
                                                $('#spouseCidNoErrorMsg').html('');
                                                $('#spouseName').val(data.spouseName);
                                                $('#spouseGender').val(data.spouseGender);
                                                $('#spouseApplicantDob').val(data.spouseApplicantDob);
                                                $('#spouseFathersName').val(data.spouseFathersName);
                                                $('#spouseMothersName').val(data.spouseMothersName);
                                                $('#spouseVillageId').val(data.spouseVillageId);
                                                $('#spouseDzongkhagId').val(data.spouseDzongkhagId);
                                                $('#spouseGewogId').val(data.spouseGewogId);
                                                $('#spouseHouseNo').val(data.spouseHouseNo);
                                                $('#spouseTharmNo').val(data.spouseTharmNo);
                                            } else {
                                                $('#spouseCidNoErrorMsg').html(res.responseText);
                                                $('#fullName').val('');
                                                $('#spouseCidNo').val('');
                                                $('#spouseCidNo').addClass('error');
                                            }
                                        }
                                    });
                                } else {
                                    warningMsg(res.responseText);
                                    $('#spouseName').val('');
                                    $('#spouseCidNo').val('');
                                    $('#spouseCidNo').addClass('error');
                                }
                            }
                        });
                    } else {
                        $('#spouseCidNo').val();
                    }
                }
            }else {
                $('#spouseCidNoErrorMsg').text('Cannot use this CID# as spouse cid.');
                $('#spouseCidNo').val('');
                $('#spouseCidNo').addClass('error');
                $('#spouseCidNoErrorMsg').val('');
            }
        });
    }


    function fetchWitnessMaleCitizenDetails() {
        $('#witness1CidNo').on('change', function () {
            var witness1CidNo = $(this).val();
            var w2CidNo = $('#witness2CidNo').val();
            var spouseCidNo = $('#spouseCidNo').val();
            var appCidNo = $('#cidNo').val();
            if(witness1CidNo != appCidNo || witness1CidNo != spouseCidNo || witness1CidNo != w2CidNo) {
                if (validateCid2(witness1CidNo)) {
                    if (witness1CidNo != '') {
                        var url = _baseURL() + 'getCitizenDetails';
                        $.ajax({
                            url: url,
                            type: 'GET',
                            data: {cidNo: witness1CidNo},
                            success: function (res) {
                                var data = res.responseDTO;
                                if (data.w1Gender == "M") {
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
                                } else {
                                    $('#w1genderErrorMsg').html('The male witness CID is required');
                                    $('#w1Gender').val('');
                                    $('#w1Gender').addClass('error');
                                    $('#w1genderErrorMsg').val('');
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
                $('#witness1CidNoErrorMsg').text('Cannot use this CID# as male witness.');
                $('#witness1CidNo').val('');
                $('#witness1CidNo').addClass('error');
                $('#witness1CidNoErrorMsg').val('');
            }
        });
    }
    function fetchWitnessFemaleCitizenDetails() {
        $('#witness2CidNo').on('change', function () {
            var witness2CidNo = $(this).val();
            var appCidNo = $('#cidNo').val();
            var spouseCidNo = $('#spouseCidNo').val();
            var w1CidNo = $('#witness1CidNo').val();
            if(witness2CidNo != appCidNo || witness2CidNo != spouseCidNo || witness2CidNo != w1CidNo){
                if (validateCid3(witness2CidNo)) {
                    if (witness2CidNo != '') {
                        var url = _baseURL() + 'getCitizenDetails';
                        $.ajax({
                            url: url,
                            type: 'GET',
                            data: {cidNo: witness2CidNo},
                            success: function (res) {
                                var data = res.responseDTO;
                                if(data.w2gender == "F"){
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
                                } else {
                                    $('#w2genderErrorMsg').html('The female witness CID is required');
                                    $('#w2gender').val('');
                                    $('#w2gender').addClass('error');
                                    $('#w2genderErrorMsg').val('');
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
                $('#witness2CidNoErrorMsg').text('Cannot use this CID# as female witness.');
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
                // $('#cidNoErrorMsg').text('');
            }
        });
        $('#spouseCidNo').on('keyup blur', function () {
            var cid = $(this).val();
            if (cid != '') {
                $('#spouseCidNo').removeClass('error');
                //$('#spouseCidNoErrorMsg').text('');
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
        $('#religion').on('keyup blur', function () {
            var cid = $(this).val();
            if (cid != '') {
                $('#religion').removeClass('error');
                $('#religionErrorMsg').text('');
            }
        });
        $('#spouseCidNo').on('keyup blur', function () {
            var cid = $(this).val();
            if (cid != '') {
                $('#spouseCidNo').removeClass('error');
                $('#spouseCidNoErrorMsg').text('');
            }
        });
        $('#spouseReligion').on('keyup blur', function () {
            var cid = $(this).val();
            if (cid != '') {
                $('#spouseReligion').removeClass('error');
                $('#religion1ErrorMsg').text('');
            }
        });
        $('#confirmChild').on('keyup blur', function () {
            var cid = $(this).val();
            if (cid != '') {
                $('#confirmChild').removeClass('error');
                $('#confirmChildErrorMsg').text('');
            }
        });
        $('#childName').on('keyup blur', function () {
            var cid = $(this).val();
            if (cid != '') {
                $('#childName').removeClass('error');
                $('#childNameErrorMsg').text('');
            }
        });
        $('#childDob').on('keyup blur', function () {
            var cid = $(this).val();
            if (cid != '') {
                $('#childDob').removeClass('error');
                $('#childDobErrorMsg').text('');
            }
        });

        $('#childGender').on('keyup blur', function () {
            var cid = $(this).val();
            if (cid != '') {
                $('#childGender').removeClass('error');
                $('#childGenderErrorMsg').text('');
            }
        });
        $('#w2gender').on('keyup blur', function () {
            var cid = $(this).val();
            if (cid != '') {
                $('#w2gender').removeClass('error');
                $('#w2genderErrorMsg').text('');
            }
        });
        $('#w1Gender').on('keyup blur', function () {
            var cid = $(this).val();
            if (cid != '') {
                $('#w1Gender').removeClass('error');
                $('#w1genderErrorMsg').text('');
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

    function addMoreChildDetails() {
        $('#childDtlsId tbody').on('click', '#btnAddMore1', function () {
            var row = "<tr id='puTr'>" +
                "<td>" + "1" + "</td>" +
                "<td>" + "<input type='text' id ='childName' class='form-control' name ='childMCDTOs[0].childName'/>" + "</td>" +
                "<td>" + "<input type='text' id ='childDoB' class='form-control datepicker' name ='childMCDTOs[0].childDoB' value='01-Jan-1990'/>" + "</td>" +
                "<td>" + "<select id='childGender' name='childMCDTOs[0].childGender'  class='form-control'><option value='M'>Male</option><option value='F'>Female</option>'</select>" + "</td>" +
                "<td>" + "<button class='btn btn-sm btn-danger' type='button' id='btnRemove1'><i class='fa fa-times'>Delete</i></button> &nbsp;&nbsp;&nbsp;&nbsp;" +
                "<button class='btn btn-sm btn-success' type='button' id='btnAddMore1'><i class='fa fa-plus'>Add More</i></button>" + "</td>" +
                "</tr>";
            $('#childDtlsId tbody').append(row);
            $(this).addClass('hidden');
            $('#btnRemove1').removeClass('hidden');
            formIndexing($('#childDtlsId tbody'), $('#childDtlsId tbody').find('tr'));
        });
    }

    function deleteChildDetails() {
        $('#childDtlsId tbody').on('click', 'tr #btnRemove1', function () {
            var rowLen = $('#childDtlsId tbody tr').length;
            $(this).closest('tr').remove();
            if (rowLen == 2) {
                $('#childDtlsId tr').last().find('#btnRemove1').addClass('hidden');
            }
            $('#childDtlsId tr').last().find('#btnAddMore1').removeClass('hidden');
            formIndexing($('#childDtlsId tbody'), $('#childDtlsId tbody').find('tr'));
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
        $('#fileAttachmentTableId tbody').on('click', 'tr input[type=file]', function () {
            if ($('#attachedFile')[0].files.length > 0) {
                if ($('#attachedFile')[0].files[0].size < 20971520 == false) {
                    warningMsg('File too large. Please attach file size less than 20 MB.');
                    $('#attachedFile').val('');
                }
            }
        });
    }

    function savenewMarriageCertificate() {
        $('#btnSubmit').on('click', function () {
            $('#newMarriageCertificateFormId').validate({
                submitHandler: function (form) {
                    var url = _baseURL() + 'savenewMarriageCertificate';
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

    $('#email').on('blur', function () {
        var email = $(this).val().trim();
        if (email != '' && !isEmail(email)) {
            $('#emailErrorMsg').text('Email format is invalid.');
            $('#email').val('');
            $('#email').addClass('error');
        }
    });

    return {
        disableTabs: disableTabs
        , btnNext: btnNext
        , btnPrevious: btnPrevious
        , onChangeChildDetail: onChangeChildDetail
        , removeErrorMsg: removeErrorMsg
        , addMoreChildDetails: addMoreChildDetails
        , deleteChildDetails: deleteChildDetails
        , checkForAlreadyExistApplicant: checkForAlreadyExistApplicant
        , checkForAlreadyExistSpouse: checkForAlreadyExistSpouse
        , checkForAlreadyMarriedSpouse: checkForAlreadyMarriedSpouse
        , checkForAlreadyMarriedApplicant: checkForAlreadyMarriedApplicant
        , fetchWitnessMaleCitizenDetails: fetchWitnessMaleCitizenDetails
        , fetchWitnessFemaleCitizenDetails: fetchWitnessFemaleCitizenDetails
        , addMoreAttachment: addMoreAttachment
        , checkFileSize: checkFileSize
        , deleteAttachment: deleteAttachment
        ,savenewMarriageCertificate: savenewMarriageCertificate
        , downloadApplicationNo: downloadApplicationNo
    }
})
();
$(document).ready(
    function () {
        $('.field').val('');
        newMarriageCertificate.disableTabs();
        newMarriageCertificate.btnNext();
        newMarriageCertificate.btnPrevious();
        newMarriageCertificate.onChangeChildDetail();
        newMarriageCertificate.removeErrorMsg();
        newMarriageCertificate.addMoreChildDetails();
        newMarriageCertificate.deleteChildDetails();
        newMarriageCertificate.checkForAlreadyExistApplicant();
        newMarriageCertificate.checkForAlreadyExistSpouse();
        newMarriageCertificate.checkForAlreadyMarriedApplicant();
        newMarriageCertificate.checkForAlreadyMarriedSpouse();
        newMarriageCertificate.fetchWitnessMaleCitizenDetails();
        newMarriageCertificate.fetchWitnessFemaleCitizenDetails();
        newMarriageCertificate.addMoreAttachment();
        newMarriageCertificate.checkFileSize();
        newMarriageCertificate.deleteAttachment();
        newMarriageCertificate.savenewMarriageCertificate();
        newMarriageCertificate.downloadApplicationNo();
    });

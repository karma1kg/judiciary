

/**
 * Created by USER on 8/2/2019.
 */
updateMarriageCertificate = (function () {
    var form = $('#updateMarriageCertificateFormId');
    var isSubmitted = false;
    function _baseURL() {
        return 'updateMarriageCertificate/';
    }

    function disableTabs() {
        $('#personalDetails').prop('class', 'active');
        $('#personalDetails').not('.active').addClass('disabled');
        $('#personalDetailTab').prop('class', 'tab-pane active');

        $("#personalDetailTabId").css("color", "white");
        $("#personalDetailTabId").css("background-color", "rgb(18, 18, 19)");
/*
        $('#documentSelection').not('.active').addClass('disabled');
        $('#documentSelection').not('.active').find('a').removeAttr("data-toggle");*/

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
                debugger;
                var data = res.responseDTO;
                var data1 = res.applicantDTO;
                var data2 = res.spouseDTO;
                    if (res.responseStatus == 1) {
                       populate(data);
                          /* populate(data1);
                           populate(data2);*/
                        if(res.gender=='M') {
                            $('#applicantName').val(res.applicantName);
                            $('#applicantDobBh').val(res.applicantDobh);
                            $('#nationality').val(res.nationality);
                            $('#censusFormNo').val(res.censusFormNo);
                            $('#cidNo').val(res.cidNo);
                            $('#fatherName').val(res.fatherName);
                            $('#motherName').val(res.motherName);
                            $('#tharmNo').val(res.tharmNo);
                            $('#houseNo').val(res.houseNo);
                            $('#dzongkhagNameBh').val(res.dzongkhagName);
                            $('#gewogNameBh').val(res.gewogName);
                            $('#villageNameBh').val(res.villageName);
                            $('#spouseName').val(res.spouseName);
                            $('#spouseApplicantDobBh').val(res.spouseApplicantDobBh);
                            $('#spouseNationality').val(res.spouseNationality);
                            $('#spouseCensusFormNo').val(res.spouseCensusFormNo);
                            $('#spouseCidNo').val(res.spouseCidNo);
                            $('#spouseFathersName').val(res.spouseFathersName);
                            $('#spouseMothersName').val(res.spouseMothersName);
                            $('#spouseTharmNo').val(res.spouseTharmNo);
                            $('#spouseHouseNo').val(res.spouseHouseNo);
                            $('#spouseDzongkhagNameBh').val(res.spouseDzongkhagNameBh);
                            $('#spouseGewogNameBh').val(res.spouseGewogNameBh);
                            $('#spouseVillageNameBh').val(res.spouseVillageNameBh);
                            $('.readonly-field').prop('disabled', true);
                        }
                        else{
                            $('#applicantName').val(res.spouseName);
                            $('#applicantDobBh').val(res.spouseApplicantDobBh);
                            $('#nationality').val(res.spouseNationality);
                            $('#censusFormNo').val(res.spouseCensusFormNo);
                            $('#cidNo').val(res.spouseCidNo);
                            $('#fatherName').val(res.spouseFathersName);
                            $('#motherName').val(res.spouseMothersName);
                            $('#tharmNo').val(res.spouseTharmNo);
                            $('#houseNo').val(res.spouseHouseNo);
                            $('#dzongkhagNameBh').val(res.spouseDzongkhagNameBh);
                            $('#gewogNameBh').val(res.spouseGewogNameBh);
                            $('#villageNameBh').val(res.spouseVillageNameBh);

                            $('#spouseName').val(res.applicantName);
                            $('#spouseApplicantDobBh').val(res.applicantDobh);
                            $('#spouseNationality').val(res.nationality);
                            $('#spouseCensusFormNo').val(res.censusFormNo);
                            $('#spouseCidNo').val(res.cidNo);
                            $('#spouseFathersName').val(res.fatherName);
                            $('#spouseMothersName').val(res.motherName);
                            $('#spouseTharmNo').val(res.tharmNo);
                            $('#spouseHouseNo').val(res.houseNo);
                            $('#spouseDzongkhagNameBh').val(res.dzongkhagName);
                            $('#spouseGewogNameBh').val(res.gewogName);
                            $('#spouseVillageNameBh').val(res.villageName);

                            $('.readonly-field').prop('disabled', true);
                        }
                        $('#receiptNo').val(res.receipt_No);
                        $('#receiptDate').val(formatAsDate(data.receiptDate));
                       // $('#receiptDate').val(res.receiptDate);
                        $('#receiptAmount').val(res.receipt_Amount);

                    }
                    /* if(res.gender=='F'){
                         $('#documentSelectionTabId').val().show();
                         $('#spouseName').val(res.spouseName);
                         $('#spouseApplicantDobBh').val(res.spouseApplicantDobBh);
                         $('#spouseNationality').val(res.spouseNationality);
                         $('#spouseCensusFormNo').val(res.spouseCensusFormNo);
                         $('#spouseCidNo').val(res.spouseCidNo);
                         $('#spouseFathersName').val(res.spouseFathersName);
                         $('#spouseMothersName').val(res.spouseMothersName);
                         $('#spouseTharmNo').val(res.spouseTharmNo);
                         $('#spouseHouseNo').val(res.spouseHouseNo);
                         $('#spouseDzongkhagNameBh').val(res.spouseDzongkhagNameBh);
                         $('#spouseGewogNameBh').val(res.spouseGewogNameBh);
                         $('#spouseVillageNameBh').val(res.spouseVillageNameBh);

                     } else if(res.gender=='M'){
                         $('#personalDetailTabId').val().show();
                         $('#applicantName').val(res.applicantName);
                     $('#spouseName').val(res.spouseName);
                         $('#applicantDobBh').val(res.applicantDobBh);
                         $('#nationality').val(res.nationality);
                         $('#censusFormNo').val(res.censusFormNo);
                         $('#cidNo').val(res.cidNo);
                         $('#fatherName').val(res.fatherName);
                         $('#motherName').val(res.motherName);
                         $('#tharmNo').val(res.tharmNo);
                         $('#houseNo').val(res.houseNo);
                         $('#dzongkhagNameBh').val(res.dzongkhagNameBh);
                         $('#gewogNameBh').val(res.gewogNameBh);
                         $('#villageNameBh').val(res.villageNameBh);
                     }*/


            }
        });
    }

    function btnNext() {
     /*   $('#btnNext_1').on('click', function () {
            if(validateHusbandPersonalDetail()){
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
        });*/
        $('#btnNext_2').on('click', function () {
            if(validateHusbandPersonalDetail()){
            /*if(validateWifePersonalDetail())*/
                $('#otherInformationTab').prop('class', 'tab-pane active');
                $('#personalDetails').removeClass("active");
                $('#personalDetailTab').removeClass("active");

                $("#personalDetailTabId").css("color", "white");
                $('#personalDetailsCheck').html('<i class="fa fa-check text-white"></i>');
                $("#personalDetailTabId").css("background-color", "#120f65");
                $("#otherInformation").css("background-color", "rgb(18, 18, 19)");
                $("#otherInformation").css("color", "white");
                $('#personalDetails').addClass('disabled');

            }
        });
    }

    function btnPrevious() {
      /*  $('#btnPrevious_1').on('click', function () {
            $('#personalDetailTab').prop('class', 'tab-pane active');
            //$('#documentSelection').removeClass("active");
            //$('#documentSelectionTab').removeClass("active");
            $("#personalDetailTabId").css("background-color", "rgb(18, 18, 19)");
            //$("#documentSelectionTabId").css("background-color", "#120f65");
        });*/

        $('#btnPrevious_2').on('click', function () {
            $('#personalDetailTab').prop('class', 'tab-pane active');
            $('#otherInformation').removeClass("active");
            $('#otherInformationTab').removeClass("active");
            $("#personalDetailTabId").css("background-color", "rgb(18, 18, 19)");
            $("#otherInformation").css("background-color", "#120f65");
        });
    }


    function removeErrorMsg() {
        $('#applicantName').on('change', function () {
            var value = $(this).val();
            if (value != '') {
                $('#applicantName').removeClass('error');
                $('#applicantNameErrorMsg').text('');
            }
        });
        $('#applicantDobBh').on('change', function () {
            var value = $(this).val();
            if (value != '') {
                $('#applicantDobBh').removeClass('error');
                $('#applicantDobErrorMsg').text('');
            }
        });
        $('#nationality').on('change', function () {
            var value = $(this).val();
            if (value != '') {
                $('#nationality').removeClass('error');
                $('#nationalityErrorMsg').text('');
            }
        });
        $('#censusFormNo').on('change', function () {
            var value = $(this).val();
            if (value != '') {
                $('#censusFormNo').removeClass('error');
                $('#censusFormNoErrorMsg').text('');
            }
        });
        $('#cidNo').on('change', function () {
            var value = $(this).val();
            if (value != '') {
                $('#cidNo').removeClass('error');
                $('#applicantCidErrorMsg').text('');
            }
        });
        $('#fatherName').on('change', function () {
            var value = $(this).val();
            if (value != '') {
                $('#fatherName').removeClass('error');
                $('#fathersNameErrorMsg').text('');
            }
        });
        $('#motherName').on('change', function () {
            var value = $(this).val();
            if (value != '') {
                $('#motherName').removeClass('error');
                $('#mothersNameErrorMsg').text('');
            }
        });
        $('#tharmNo').on('change', function () {
            var value = $(this).val();
            if (value != '') {
                $('#tharmNo').removeClass('error');
                $('#tharmNoErrorMsg').text('');
            }
        });
        $('#houseNo').on('change', function () {
            var value = $(this).val();
            if (value != '') {
                $('#houseNo').removeClass('error');
                $('#houseNoErrorMsg').text('');
            }
        });
        $('#dzongkhagNameBh').on('change', function () {
            var value = $(this).val();
            if (value != '') {
                $('#dzongkhagNameBh').removeClass('error');
                $('#dzongkhagNameErrorMsg').text('');
            }
        });
        $('#gewogNameBh').on('change', function () {
            var value = $(this).val();
            if (value != '') {
                $('#gewogNameBh').removeClass('error');
                $('#gewogNameErrorMsg').text('');
            }
        });
        $('#villageNameBh').on('change', function () {
            var value = $(this).val();
            if (value != '') {
                $('#villageNameBh').removeClass('error');
                $('#villageNameErrorMsg').text('');
            }
        });

        $('#spouseName').on('change', function () {
            var value = $(this).val();
            if (value != '') {
                $('#spouseName').removeClass('error');
                $('#spouseApplicantNameErrorMsg').text('');
            }
        });
        $('#spouseApplicantDobBh').on('change', function () {
            var value = $(this).val();
            if (value != '') {
                $('#spouseApplicantDobBh').removeClass('error');
                $('#spouseApplicantDobErrorMsg').text('');
            }
        });
        $('#spouseNationality').on('change', function () {
            var value = $(this).val();
            if (value != '') {
                $('#spouseNationality').removeClass('error');
                $('#spouseNationalityErrorMsg').text('');
            }
        });
        $('#spouseCensusFormNo').on('change', function () {
            var value = $(this).val();
            if (value != '') {
                $('#spouseCensusFormNo').removeClass('error');
                $('#spouseCensusFormNoErrorMsg').text('');
            }
        });
        $('#spouseCidNo').on('change', function () {
            var value = $(this).val();
            if (value != '') {
                $('#spouseCidNo').removeClass('error');
                $('#spouseApplicantCidErrorMsg').text('');
            }
        });
        $('#spouseFathersName').on('change', function () {
            var value = $(this).val();
            if (value != '') {
                $('#spouseFathersName').removeClass('error');
                $('#spouseFathersNameErrorMsg').text('');
            }
        });
        $('#spouseMothersName').on('change', function () {
            var value = $(this).val();
            if (value != '') {
                $('#spouseMothersName').removeClass('error');
                $('#spouseMothersNameErrorMsg').text('');
            }
        });
        $('#spouseTharmNo').on('change', function () {
            var value = $(this).val();
            if (value != '') {
                $('#spouseTharmNo').removeClass('error');
                $('#spouseTharmNoErrorMsg').text('');
            }
        });
        $('#spouseHouseNo').on('change', function () {
            var value = $(this).val();
            if (value != '') {
                $('#spouseHouseNo').removeClass('error');
                $('#spouseHouseNoErrorMsg').text('');
            }
        });
        $('#spouseDzongkhagNameBh').on('change', function () {
            var value = $(this).val();
            if (value != '') {
                $('#spouseDzongkhagNameBh').removeClass('error');
                $('#spouseDzongkhagNameErrorMsg').text('');
            }
        });
        $('#spouseGewogNameBh').on('change', function () {
            var value = $(this).val();
            if (value != '') {
                $('#spouseGewogNameBh').removeClass('error');
                $('#spouseGewogNameErrorMsg').text('');
            }
        });
        $('#spouseVillageNameBh').on('change', function () {
            var value = $(this).val();
            if (value != '') {
                $('#spouseVillageNameBh').removeClass('error');
                $('#spouseVillageNameErrorMsg').text('');
            }
        });
        $('#applicationIdDzo').on('change', function () {
            var value = $(this).val();
            if (value != '') {
                $('#applicationIdDzo').removeClass('error');
                $('#applicationIdDzoErrorMsg').text('');
            }
        });
        $('#dateDzo').on('change', function () {
            var value = $(this).val();
            if (value != '') {
                $('#dateDzo').removeClass('error');
                $('#dateDzoErrorMsg').text('');
            }
        });
        $('#judgementNoDzo').on('change', function () {
            var value = $(this).val();
            if (value != '') {
                $('#judgementNoDzo').removeClass('error');
                $('#judgementNoDzoErrorMsg').text('');
            }
        });
        $('#lunarDateDzo').on('change', function () {
            var value = $(this).val();
            if (value != '') {
                $('#lunarDateDzo').removeClass('error');
                $('#lunarDateDzoErrorMsg').text('');
            }
        });
        $('#lawyerDzo').on('change', function () {
            var value = $(this).val();
            if (value != '') {
                $('#lawyerDzo').removeClass('error');
                $('#lawyerDzoErrorMsg').text('');
            }
        });
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

    function validateHusbandPersonalDetail() {
        var retval = true;
        if ($('#applicantCid').val() == "") {
            $('#applicantCid').addClass('error');
            $('#applicantCidErrorMsg').html('CID is required');
            retval = false;
        }
        if ($('#applicantName').val() == "") {
            $('#applicantName').addClass('error');
            $('#applicantNameErrorMsg').html('Your name is required');
            retval = false;
        }
        if ($('#applicantDobBh').val() == "") {
            $('#applicantDobBh').addClass('error');
            $('#applicantDobBhErrorMsg').html('Your Date of birth is required');
            retval = false;
        }
        if ($('#nationality').val() == "") {
            $('#nationality').addClass('error');
            $('#nationalityErrorMsg').html('Your nationality is required');
            retval = false;
        }
        if ($('#censusFormNo').val() == "") {
            $('#censusFormNo').addClass('error');
            $('#censusFormNoErrorMsg').html('Your census form number is required');
            retval = false;
        }
        if ($('#fathersName').val() == "") {
            $('#fathersName').addClass('error');
            $('#fathersNameErrorMsg').html('Your father name is required');
            retval = false;
        }
        if ($('#mothersName').val() == "") {
            $('#mothersName').addClass('error');
            $('#mothersNameErrorMsg').html('Your mother name is required');
            retval = false;
        }
        if ($('#tharmNo').val() == "") {
            $('#tharmNo').addClass('error');
            $('#tharmNoErrorMsg').html('Tharm number is required');
            retval = false;
        }
        if ($('#houseNo').val() == "") {
            $('#houseNo').addClass('error');
            $('#houseNoErrorMsg').html('House number is required');
            retval = false;
        }
        if ($('#villageName').val() == "") {
            $('#villageName').addClass('error');
            $('#villageNameErrorMsg').html('Village name is required');
            retval = false;
        }
        if ($('#gewogName').val() == "") {
            $('#gewogName').addClass('error');
            $('#gewogNameErrorMsg').html('Gewog name is required');
            retval = false;
        }
        if ($('#dzongkhagName').val() == "") {
            $('#dzongkhagName').addClass('error');
            $('#dzongkhagNameErrorMsg').html('Dzongkhag name is required');
            retval = false;
        }

        if ($('#spouseApplicantName').val() == "") {
            $('#spouseApplicantName').addClass('error');
            $('#spouseApplicantNameErrorMsg').html('Spouse name is required');
            retval = false;
        }
        if ($('#spouseApplicantDob').val() == "") {
            $('#spouseApplicantDob').addClass('error');
            $('#spouseApplicantDobErrorMsg').html('Spouse DOB is required');
            retval = false;
        }
        if ($('#spouseNationality').val() == "") {
            $('#spouseNationality').addClass('error');
            $('#spouseNationalityErrorMsg').html('Spouse nationality is required');
            retval = false;
        }
        if ($('#spouseCensusFormNo').val() == "") {
            $('#spouseCensusFormNo').addClass('error');
            $('#spouseCensusFormNoErrorMsg').html('Spouse census form number is required');
            retval = false;
        }
        if ($('#spouseApplicantCid').val() == "") {
            $('#spouseApplicantCid').addClass('error');
            $('#spouseApplicantCidErrorMsg').html('Spouse CID is required');
            retval = false;
        }
        if ($('#spouseFathersName').val() == "") {
            $('#spouseFathersName').addClass('error');
            $('#spouseFathersNameErrorMsg').html('Spouse father name is required');
            retval = false;
        }
        if ($('#spouseMothersName').val() == "") {
            $('#spouseMothersName').addClass('error');
            $('#spouseMothersNameErrorMsg').html('Spouse mother name is required');
            retval = false;
        }
        if ($('#spouseTharmNo').val() == "") {
            $('#spouseTharmNo').addClass('error');
            $('#spouseTharmNoErrorMsg').html('Spouse tharm number is required');
            retval = false;
        }
        if ($('#spouseHouseNo').val() == "") {
            $('#spouseHouseNo').addClass('error');
            $('#spouseHouseNoErrorMsg').html('Spouse house number is required');
            retval = false;
        }
        if ($('#spouseVillageName').val() == "") {
            $('#spouseVillageName').addClass('error');
            $('#spouseVillageNameErrorMsg').html('Spouse village name is required');
            retval = false;
        }
        if ($('#spouseGewogName').val() == "") {
            $('#spouseGewogName').addClass('error');
            $('#spouseGewogNameErrorMsg').html('Spouse gewog name is required');
            retval = false;
        }
        if ($('#spouseDzongkhagName').val() == "") {
            $('#spouseDzongkhagName').addClass('error');
            $('#spouseDzongkhagNameErrorMsg').html('Spouse dzongkhag name is required');
            retval = false;
        }

        return retval;
    }

   /* function validateWifePersonalDetail() {
        var retval = true;
        if ($('#spouseApplicantName').val() == "") {
            $('#spouseApplicantName').addClass('error');
            $('#spouseApplicantNameErrorMsg').html('Spouse name is required');
            retval = false;
        }
        if ($('#spouseApplicantDob').val() == "") {
            $('#spouseApplicantDob').addClass('error');
            $('#spouseApplicantDobErrorMsg').html('Spouse DOB is required');
            retval = false;
        }
        if ($('#spouseNationality').val() == "") {
            $('#spouseNationality').addClass('error');
            $('#spouseNationalityErrorMsg').html('Spouse nationality is required');
            retval = false;
        }
        if ($('#spouseCensusFormNo').val() == "") {
            $('#spouseCensusFormNo').addClass('error');
            $('#spouseCensusFormNoErrorMsg').html('Spouse census form number is required');
            retval = false;
        }
        if ($('#spouseApplicantCid').val() == "") {
            $('#spouseApplicantCid').addClass('error');
            $('#spouseApplicantCidErrorMsg').html('Spouse CID is required');
            retval = false;
        }
        if ($('#spouseFathersName').val() == "") {
            $('#spouseFathersName').addClass('error');
            $('#spouseFathersNameErrorMsg').html('Spouse father name is required');
            retval = false;
        }
        if ($('#spouseMothersName').val() == "") {
            $('#spouseMothersName').addClass('error');
            $('#spouseMothersNameErrorMsg').html('Spouse mother name is required');
            retval = false;
        }
        if ($('#spouseTharmNo').val() == "") {
            $('#spouseTharmNo').addClass('error');
            $('#spouseTharmNoErrorMsg').html('Spouse tharm number is required');
            retval = false;
        }
        if ($('#spouseHouseNo').val() == "") {
            $('#spouseHouseNo').addClass('error');
            $('#spouseHouseNoErrorMsg').html('Spouse house number is required');
            retval = false;
        }
        if ($('#spouseVillageName').val() == "") {
            $('#spouseVillageName').addClass('error');
            $('#spouseVillageNameErrorMsg').html('Spouse village name is required');
            retval = false;
        }
        if ($('#spouseGewogName').val() == "") {
            $('#spouseGewogName').addClass('error');
            $('#spouseGewogNameErrorMsg').html('Spouse gewog name is required');
            retval = false;
        }
        if ($('#spouseDzongkhagName').val() == "") {
            $('#spouseDzongkhagName').addClass('error');
            $('#spouseDzongkhagNameErrorMsg').html('Spouse dzongkhag name is required');
            retval = false;
        }
        return retval;
    }*/

    function checkUpdateDetail() {
        var retval = true;
            if ($('#applicationIdDzo').val() == '') {
            $('#applicationIdDzo').addClass('error');
            $('#applicationIdDzoErrorMsg').text('Application number in dzongkha is required');
            retval = false;
            }
        if ($('#dateDzo').val() == '') {
            $('#dateDzo').addClass('error');
            $('#dateDzoErrorMsg').text('Date in dzongkha is required');
            retval = false;
            }
        if ($('#judgementNoDzo').val() == '') {
            $('#judgementNoDzo').addClass('error');
            $('#judgementNoDzoErrorMsg').text('Judgement number in dzongkha is required');
            retval = false;
            }
        if ($('#lunarDateDzo').val() == '') {
            $('#lunarDateDzo').addClass('error');
            $('#lunarDateDzoErrorMsg').text('Bhutanese calendar date in dzongkha is required');
            retval = false;
            }
        if ($('#lawyerDzo').val() == '') {
            $('#lawyerDzo').addClass('error');
            $('#lawyerDzoErrorMsg').text('Name of the lawyer in dzongkha is required');
            retval = false;
            }
        if ($('#regNo').val() ==  '') {
            $('#regNo').addClass('error');
            $('#regNoErrorMsg').text('Registration No. is required');
            retval = false;
        }
        if ($('#regDate').val() ==  '') {
            $('#regDate').addClass('error');
            $('#regDateErrorMsg').text('Registration date is required');
            retval = false;
        }
        if ($('#judgementNo').val() ==  '') {
            $('#judgementNo').addClass('error');
            $('#judgementNoErrorMsg').text('Judgement No. is required');
            retval = false;
        }
        if ($('#judgementDate').val() ==  '') {
            $('#judgementDate').addClass('error');
            $('#judgementDateErrorMsg').text('Judgement date is required');
            retval = false;
        }
        if ($('#lawyer').val() ==  '') {
            $('#lawyer').addClass('error');
            $('#lawyerErrorMsg').text('Lawyer name is required');
            retval = false;
        }
        return retval;
    }

    function updateApplication() {
        $('#btnUpdate').on('click', function () {
            if(checkUpdateDetail()){
                $('#updateMarriageCertificateFormId').validate({
                    submitHandler: function (form) {
                        var url = _baseURL() + 'updateMarriageCertificate';
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
        , checkPreviousJudgementNo: checkPreviousJudgementNo
        , checkPreviousRegistrationNo: checkPreviousRegistrationNo
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
        updateMarriageCertificate.disableTabs();
        updateMarriageCertificate.checkPreviousJudgementNo();
        updateMarriageCertificate.checkPreviousRegistrationNo();
        updateMarriageCertificate.getApplicationDetail();
        updateMarriageCertificate.btnNext();
        updateMarriageCertificate.btnPrevious();
        updateMarriageCertificate.removeErrorMsg();
        updateMarriageCertificate.updateApplication();
    });


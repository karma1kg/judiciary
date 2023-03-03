<%--
  Created by IntelliJ IDEA.
  User: Sonam Tobgay
  Date: 3/10/2020
  Time: 2:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<meta name="decorator" content="/layout/close-layout.jsp"/>
<html>
<head>
    <title>Update for Marriage Certificate</title>
</head>
<body>
<div class="row" id="registration">
    <span style="font-size: 20px"><b>&nbsp;&nbsp;&nbsp;&nbsp;Judicial Service </b> >>Update for Marriage Certificate in Dzongkha</span>
    <div class="col-12">
        <form class="card form-horizontal" id="updateMarriageCertificateFormId" action="<c:url value="/updateMarriageCertificate"/>" method="post">
            <div class="card-body">
                <span class="text-danger">
              &nbsp;&nbsp;&nbsp;&nbsp;NOTE:  Label which are mark with * are mandatory fields, you cannot proceed further without those fields.
              Please follow the instruction in &nbsp;&nbsp;<img src="<c:url value='/resources/images/questionMark.jpg'/>"
                                                                class="user-image" width="20px">
          </span>
                <div class="row">
                    <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
                        <div class="panel panel-default">
                            <div class="panel-body">
                                <div class="nav-tabs-custom">
                                    <ul class="nav nav-tabs">
                                    <li id="personalDetails">
                                            <a href="#personalDetailTab" id="personalDetailTabId" data-toggle="tab"
                                               data-placement="top" title='Please use buttons to change tabs.'><i
                                                    class="fa fa-user"></i>&nbsp;Application Details<span
                                                    class="text-info" style="font-size: 20px"
                                                    id="personalDetailsCheck"></span></a>
                                       <%-- <li id="documentSelection">--%>
                                         <%--   <a href="#documentSelectionTab" id="documentSelectionTabId"
                                               data-toggle="tab" data-placement="top"
                                               title='Please use buttons to change tabs.'><i
                                                    class="fa fa-book"></i>&nbsp; Wife Details<span class="text-info" style="font-size: 20px"
                                                                                                               id="documentSelectionCheck"></span></a>--%>
                                        </li>
                                        <li id="otherInformation">
                                            <a href="#documentSelectionTab" id="otherInformationTabId"
                                               data-toggle="tab" data-placement="top"
                                               title='Please use buttons to change tabs.'><i
                                                    class="fa fa-paperclip"></i>&nbsp;Judgment & Payment Details
                                                 <span class="text-info" style="font-size: 20px"
                                                       id="otherInformationCheck"></span></a>
                                        </li>

                                    </ul>
                                </div>
                                <div class="tab-content">
                                    <div class="tab-pane" id="personalDetailTab">
                                        <br/>
                                        <div class="form-group">
                                            <label class="col-sm-2 required" style="font-size:20px">ཕོའི་མིང་</label>

                                            <div class="col-sm-4">
                                                <input type="text" class="form-control field" id="applicantName" name="" onchange="checkLanguage(this.value,'applicantName')"/>
                                                <span id="applicantNameErrorMsg" class="text-danger"></span>
                                            </div>
                                            <label class="col-sm-2 required" style="font-size:20px">སྐྱེས་ཚེས་</label>

                                            <div class="col-sm-4">
                                                <input type="text" class="form-control field" name="" id="applicantDobBh" onchange="checkLanguage(this.value,'applicantDobBh')"/>
                                                <span id="applicantDobErrorMsg" class="text-danger"></span>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-2 required" style="font-size:20px">མི་ཁུངས་ཀྱི་དབྱེ་བ་</label>
                                            <div class="col-sm-4">
                                                <input type="text" class="form-control " name="" id="nationality" onchange="checkLanguage(this.value,'nationality')"/>
                                                <span id="nationalityErrorMsg" class="text-danger"></span>
                                            </div>
                                            <label class="col-sm-2 required" style="font-size:20px">མི་རྩིས་འབྲི་ཤོག་ཨང</label>
                                            <div class="col-sm-4">
                                                <input type="text" class="form-control " name="" id="censusFormNo" onchange="checkLanguage(this.value,'censusFormNo')"/>
                                                <span id="censusFormNoErrorMsg" class="text-danger"></span>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-2 required" style="font-size:20px">མི་ཁུངས་ལག་ཁྱེར་ཨང་་</label>
                                            <div class="col-sm-4">
                                                <input type="text" class="form-control " name="" id="cidNo" onchange="checkLanguage(this.value,'cidNo')"/>
                                                <span id="applicantCidErrorMsg" class="text-danger"></span>
                                            </div>
                                            <label class="col-sm-2 required" style="font-size:20px">ཕ་མིང</label>
                                            <div class="col-sm-4">
                                                <input type="text" class="form-control " name="" id="fatherName" onchange="checkLanguage(this.value,'fatherName')"/>
                                                <span id="fathersNameErrorMsg" class="text-danger"></span>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-2 required" style="font-size:20px">མ་མིང</label>
                                            <div class="col-sm-4">
                                                <input type="text" class="form-control " name="" id="motherName" onchange="checkLanguage(this.value,'motherName')"/>
                                                <span id="mothersNameErrorMsg" class="text-danger"></span>
                                            </div>
                                            <label class="col-sm-2 required" style="font-size:20px">ཁྲམ་ཨང</label>
                                            <div class="col-sm-4">
                                                <input type="text" class="form-control " name="" id="tharmNo" onchange="checkLanguage(this.value,'tharmNo')"/>
                                                <span id="tharmNoErrorMsg" class="text-danger"></span>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-2 required" style="font-size:20px">གུང་ཨང</label>
                                            <div class="col-sm-4">
                                                <input type="text" class="form-control " name="" id="houseNo" onchange="checkLanguage(this.value,'houseNo')"/>
                                                <span id="houseNoErrorMsg" class="text-danger"></span>
                                            </div>
                                            <label class="col-sm-2 required" style="font-size:20px">རྫོང་ཁག</label>
                                            <div class="col-sm-4">
                                                <input type="text" class="form-control " name="" id="dzongkhagNameBh" onchange="checkLanguage(this.value,'dzongkhagNameBh')"/>
                                                <span id="dzongkhagNameErrorMsg" class="text-danger"></span>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-2 required" style="font-size:20px">རྒེད་འོག་་</label>
                                            <div class="col-sm-4">
                                                <input type="text" class="form-control " name="" id="gewogNameBh" onchange="checkLanguage(this.value,'gewogNameBh')"/>
                                                <span id="gewogNameErrorMsg" class="text-danger"></span>
                                            </div>
                                            <label class="col-sm-2 required" style="font-size:20px">གཡུས</label>
                                            <div class="col-sm-4">
                                                <input type="text" class="form-control " name="" id="villageNameBh" onchange="checkLanguage(this.value,'villageNameBh')"/>
                                                <span id="villageNameErrorMsg" class="text-danger"></span>
                                            </div>
                                        </div>
                                        <hr/>
                                       <%-- <div class="form-group pull-right">
                                            <div class="col-sm-4">
                                                <button type="button" id="btnNext_1" class="btn btn-primary">
                                                    <i class="fa fa-arrow-right"></i> Next
                                                </button>
                                            </div>
                                        </div>--%>
                                            <br/>
                                            <div class="form-group">
                                                <label class="col-sm-2 required" style="font-size:20px">མོའི་མིང་གསལ</label>

                                                <div class="col-sm-4">
                                                    <input type="text" class="form-control " id="spouseName" name="" onchange="checkLanguage(this.value,'spouseName')"/>
                                                    <span id="spouseApplicantNameErrorMsg" class="text-danger"></span>
                                                </div>
                                                <label class="col-sm-2 required" style="font-size:20px">སྐྱེས་ཚེས་</label>
                                                <div class="col-sm-4">
                                                    <input type="text" class="form-control " name="" id="spouseApplicantDobBh" onchange="checkLanguage(this.value,'spouseApplicantDobBh')"/>
                                                    <span id="spouseApplicantDobErrorMsg" class="text-danger"></span>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="col-sm-2 required" style="font-size:20px">མི་ཁུངས་ཀྱི་དབྱེ་བ་</label>
                                                <div class="col-sm-4">
                                                    <input type="text" class="form-control " name="" id="spouseNationality" onchange="checkLanguage(this.value,'spouseNationality')"/>
                                                    <span id="spouseNationalityErrorMsg" class="text-danger"></span>
                                                </div>
                                                <label class="col-sm-2 required" style="font-size:20px">མི་རྩིས་འབྲི་ཤོག་ཨང</label>
                                                <div class="col-sm-4">
                                                    <input type="text" class="form-control " name="" id="spouseCensusFormNo" onchange="checkLanguage(this.value,'spouseCensusFormNo')"/>
                                                    <span id="spouseCensusFormNoErrorMsg" class="text-danger"></span>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="col-sm-2 required" style="font-size:20px">མི་ཁུངས་ལག་ཁྱེར་ཨང་་</label>
                                                <div class="col-sm-4">
                                                    <input type="text" class="form-control " name="" id="spouseCidNo" onchange="checkLanguage(this.value,'spouseCidNo')"/>
                                                    <span id="spouseApplicantCidErrorMsg" class="text-danger"></span>
                                                </div>
                                                <label class="col-sm-2 required" style="font-size:20px">ཕ་མིང</label>
                                                <div class="col-sm-4">
                                                    <input type="text" class="form-control " name="" id="spouseFathersName" onchange="checkLanguage(this.value,'spouseFathersName')"/>
                                                    <span id="spouseFathersNameErrorMsg" class="text-danger"></span>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="col-sm-2 required" style="font-size:20px">མ་མིང</label>
                                                <div class="col-sm-4">
                                                    <input type="text" class="form-control " name="" id="spouseMothersName" onchange="checkLanguage(this.value,'spouseMothersName')"/>
                                                    <span id="spouseMothersNameErrorMsg" class="text-danger"></span>
                                                </div>
                                                <label class="col-sm-2 required" style="font-size:20px">ཁྲམ་ཨང</label>
                                                <div class="col-sm-4">
                                                    <input type="text" class="form-control " name="" id="spouseTharmNo" onchange="checkLanguage(this.value,'spouseTharmNo')"/>
                                                    <span id="spouseTharmNoErrorMsg" class="text-danger"></span>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="col-sm-2 required" style="font-size:20px">གུང་ཨང་་་</label>
                                                <div class="col-sm-4">
                                                    <input type="text" class="form-control " name="" id="spouseHouseNo" onchange="checkLanguage(this.value,'spouseHouseNo')"/>
                                                    <span id="spouseHouseNoErrorMsg" class="text-danger"></span>
                                                </div>
                                                <label class="col-sm-2 required" style="font-size:20px">རྫོང་ཁག</label>
                                                <div class="col-sm-4">
                                                    <input type="text" class="form-control " name="" id="spouseDzongkhagNameBh" onchange="checkLanguage(this.val,'spouseDzongkhagNameBh')"/>
                                                    <span id="spouseDzongkhagNameErrorMsg" class="text-danger"></span>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="col-sm-2 required" style="font-size:20px">རྒེད་འོག་་</label>
                                                <div class="col-sm-4">
                                                    <input type="text" class="form-control " name="" id="spouseGewogNameBh" onchange="checkLanguage(this.value,'spouseGewogNameBh')"/>
                                                    <span id="spouseGewogNameErrorMsg" class="text-danger"></span>
                                                </div>
                                                <label class="col-sm-2 required" style="font-size:20px">གཡུས</label>
                                                <div class="col-sm-4">
                                                    <input type="text" class="form-control " name="" id="spouseVillageNameBh" onchange="checkLanguage(this.value,'spouseVillageNameBh')"/>
                                                    <span id="spouseVillageNameErrorMsg" class="text-danger"></span>
                                                </div>
                                            </div>
                                            <hr/>
                                            <div class="form-group">
                                                <div class="col-sm-3 pull-right">
                                                    <button type="button" id="btnPrevious_1" class="btn btn-success">
                                                        <i class="fa fa-arrow-left"></i>
                                                        Previous
                                                    </button>
                                                    <button type="button" id="btnNext_2" class="btn btn-primary">
                                                        <i class="fa fa-arrow-right"></i>
                                                        Next
                                                    </button>
                                                </div>
                                            </div>
                                        </div>

                                    <div class="tab-pane" id="otherInformationTab">
                                        <br/>
                                        <div class="form-group">
                                            <label class="col-sm-2">Case No.</label>
                                            <div class="col-sm-4">
                                                <input type="text" class="form-control readonly-field" name="applicationNo" value="${applicationNo}">
                                                <input type="hidden" class="form-control" name="applicationNo" id="applicationNo" value="${applicationNo}">
                                                <input type="hidden" class="form-control" name="applicationYear" id="applicationYear" value="${applicationYear}">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-2 required" style="font-size:20px">རྩོད་འཛིན་ཨང་</label>
                                            <div class="col-sm-4">
                                                <input type="text" class="form-control " name="applicationIdDzo" id="applicationIdDzo" onchange="checkLanguage(this.value,'applicationIdDzo')"/>
                                                <span id="applicationIdDzoErrorMsg" class="text-danger"></span>
                                            </div>
                                            <label class="col-sm-2 required" style="font-size:20px">སྤྱི་ཚེས་(Calendar)</label>
                                            <div class="col-sm-4">
                                                <input type="text" class="form-control " name="dateDzo" id="dateDzo" onchange="checkLanguage(this.value,'dateDzo')"/>
                                                <span id="dateDzoErrorMsg" class="text-danger"></span>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-2 required" style="font-size:20px">འཁྲུན་ཆོད་ཨང་་</label>
                                            <div class="col-sm-4">
                                                <input type="text" class="form-control " name="judgementNoDzo" id="judgementNoDzo" onchange="checkLanguage(this.value,'judgementNoDzo')"/>
                                                <span id="judgementNoDzoErrorMsg" class="text-danger"></span>
                                            </div>
                                            <label class="col-sm-2 required" style="font-size:20px">སྤྱི་ཚེས(Lunar)་</label>
                                            <div class="col-sm-4">
                                                <input type="text" class="form-control " name="lunarDateDzo" id="lunarDateDzo" onchange="checkLanguage(this.value,'lunarDateDzo')"/>
                                                <span id="lunarDateDzoErrorMsg" class="text-danger"></span>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-2 required"  style="font-size:20px">དྲང་དཔོན་་</label>
                                            <div class="col-sm-4">
                                                <input type="text" class="form-control " name="lawyerDzo" id="lawyerDzo" onchange="checkLanguage(this.value,'lawyerDzo')"/>
                                                <span id="lawyerDzoErrorMsg" class="text-danger"></span>
                                            </div>
                                            <label class="col-sm-2 required">Judge/Registrar</label>
                                            <div class="col-sm-4">
                                                <input type="text" class="form-control " name="lawyer" id="lawyer"/>
                                                <span id="lawyerErrorMsg" class="text-danger"></span>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-2 required">Registration No.</label>
                                            <div class="col-sm-3">
                                                <input type="text" class="form-control numeric" name="regNo" id="regNo">
                                            </div>
                                            <div class="col-sm-1">
                                                <input type="text" class="form-control" value=" ${applicationYear}" />
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-2 required">Registration Date</label>
                                            <div class="col-sm-4">
                                                <input type="text" class="form-control datepicker" name="regDate" id="regDate">
                                            </div>
                                            <label class="col-sm-2 required">Judgement No.</label>
                                            <div class="col-sm-3">
                                                <input type="text" class="form-control " name="judgementNo" id="judgementNo" />
                                                <span id="judgementNoErrorMsg" class="text-danger"></span>
                                            </div>
                                            <div class="col-sm-1">
                                                <input type="text" class="form-control"  value=" ${applicationYear}" />
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-2 required">Judgement Date</label>
                                            <div class="col-sm-4">
                                                <input type="text" class="form-control datepicker " name="judgementDate" id="judgementDate"/>
                                                <span id="judgementDateDobErrorMsg" class="text-danger"></span>
                                            </div>
                                            <label class="col-sm-2 required">Receipt No.</label>
                                            <div class="col-sm-4">
                                                <input type="text" class="form-control readonly-field" name="" id="receiptNo"/>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-2 required">Receipt Date</label>
                                            <div class="col-sm-4">
                                                <input type="text" class="form-control readonly-field" name="" id="receiptDate"/>
                                            </div>
                                            <label class="col-sm-2 required">Receipt Amount</label>
                                            <div class="col-sm-4">
                                                <input type="text" class="form-control readonly-field" name="" id="receiptAmount"/>
                                            </div>
                                        </div>
                                        <hr/>
                                        <div class="form-group">
                                            <div class="col-sm-3 pull-right">
                                                <button type="button" id="btnPrevious_2" class="btn btn-success">
                                                    <i class="fa fa-arrow-left"></i>
                                                    Previous
                                                </button>
                                                <button type="submit" id="btnUpdate" class="btn btn-primary">
                                                    <i class="fa fa-check"></i>
                                                    Update
                                                </button>
                                            </div>
                                        </div>
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
<div class="my-3 my-md-5 hidden" id="approveAcknowledgement">
    <div class="container">
        <div class="row">
            <div class="col-12">
                    <div class="card-body">
                        <h2 class="card-title"><b>Judicial Service</b> >>
                            Acknowledgement</h2>
                        <div class="row">
                            <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
                                <div class="panel panel-default">
                                    <div class="panel-body">
                                        <div class="form-group">
                                            <label class="col-sm-12">
                                                Application for <span id="serviceNameUpdate"></span> with application
                                                number <span id="applicationNoUpdate"></span> is updated successfully. <br/>
                                                Thank you.
                                            </label>
                                        </div>
                                        <div class="form-group pull-right">
                                            <a href="<c:url value='/dataManagerTaskList/ALL'/>" class="btn btn-primary"><i class="fa fa-backward" aria-hidden="true"></i>&nbsp;&nbsp;Back to TaskList</a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
            </div>
        </div>
    </div>
</div>
</body>
<script type="text/javascript">
    function checkLanguage(evt,id){
        var charCode = (evt.which) ? evt.which : event.keyCode;
        if ((charCode > 48 && charCode < 57) || (charCode > 64 && charCode < 91) || (charCode > 96 && charCode < 123))//0-9
        {
            $("#"+id).addClass('has-error');
            $("#"+id+"ErrorMsg").html('Please select Dzongkha Font.');
            setTimeout('$("#'+id+'").removeClass("has-error")',5000);
            $("#"+id+"ErrorMsg").show();
            setTimeout('$("#'+id+'ErrorMsg").hide()',5000);
            return false;
        }
        else{
            return true;
        }
    }
</script>
</html>

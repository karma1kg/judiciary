<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <%--<meta name="viewport" content="width=device-width, initial-scale=1.0, minimal-ui">--%>
    <meta name="apple-mobile-app-capable" content="yes">
<title>Royal Court of Justice</title>
</head>
<body>
<div class="container">
    <div class="card card-primary">
        <div class="card-body">
            <div class="form-group row">
                <%--<div class="col-md-6 col-sm-6 col-lg-6 col-xs-12">--%>

                    <h5>Royal Court of Justice</h5>
                    <label>
                        Once you have submitted your application and if you have not received any message, kindly keep track of your application number that was generated while submitting. Also, you can use Track Your Application on the right side if you wish to see the status of your application
                        Make sure to attach all the necessary documents that were listed under the attachment. Furthermore, ensure to bring all the original documents during the hearing day.
                    </label>
                </div>
        </div>
    </div>
</div>

<div class="container">
    <div class="form-group row">
        <div class="col-lg-3">
            </div>
        <div class="col-lg-7">
            <strong>
                <a target="_blank" style="color: #ff0000; font-size: 18px;"><i class="fa fa-paperclip">
                </i>CHECKLIST BEFORE PROCESSING ANY APPLICATION</a>
            </strong>
        </div>
    </div>
</div>

<div class="container">


<div class="card card-primary">
    <div class="card-body">
        <section class="accordion">
            <input type="checkbox" name="collapse" id="handleMC" checked="checked">
            <h2 class="handle">
                <label for="handleMC">Marriage Certificate</label>
            </h2>
            <div class="content col-lg-12 col-md-12 col-sm-12 col-xs-12">
                <ol>
                    <li>Duly filled Affidavit of Parties/Witnesses In-re Marriage Certificate form (Form No G-6
                        <a href=" http://www.judiciary.gov.bt/forms/G6.pdf" target="_blank" style="text-decoration: underline;"><span style="color: blue; ">Petition for Marriage Certificate</span></a>
                        and Form No H-8 <a href=" http://www.judiciary.gov.bt/forms/Form8New.pdf" target="_blank"
                                           style="text-decoration: underline;"><span style="color: blue; ">Affidavit of Parties/Witnesses In re-Marriage Certificate</span></a>).
                        Please fill the forms in Dzongkha, each party should sign on an independent legal stamps, mention
                        their full names, sign twice: <b>1)</b> against their respective names on the form, <b>2)</b>on independent
                        legal stamps and put initial signatures on all pages of the form. Please avoid any overwriting otherwise the application will not be accepted)</li>
                    <c:forEach var="mc" items="${RequiredDocsListMC}">
                        <li><option value="${mc.valueInteger}">${mc.text}</option></li>
                    </c:forEach>
                </ol>
                <div class="pull-right">
                    <a href="<c:url value='/marriageCertificate'/>" style="font-size: 24px;">Now Apply for Marriage Certificate<i class="fa fa-arrow-circle-right" style="font-size: 24px;"></i></a>&nbsp;&nbsp;
                </div>
            </div>
        </section>
        <section class="accordion">
            <input type="checkbox" name="collapse" id="handleAP">
            <h2 class="handle">
                <label for="handleAP">Authentication Personal Details</label>
            </h2>
            <div class="content">
                <ol>
                    <c:forEach var="ap" items="${RequiredDocsListAP}">
                        <li><option value="${ap.valueInteger}">${ap.text}</option></li>
                    </c:forEach>
                </ol>
                <div class="pull-right">
                    <a href="<c:url value='/authenticationPersonalDetails'/>" style="font-size: 24px;">Now Apply for Authentication Personal Details<i class="fa fa-arrow-circle-right" style="font-size: 24px;"></i></a>&nbsp;&nbsp;
                </div>
            </div>
        </section>
        <section class="accordion">
            <input type="checkbox" name="collapse" id="handleAM">
            <h2 class="handle">
                <label for="handleAM">Affirmation of Marriage Certificate</label>
            </h2>
            <div class="content">
                <ol>
                    <c:forEach var="am" items="${RequiredDocsListAM}">
                        <li><option value="${am.valueInteger}">${am.text}</option></li>
                    </c:forEach>
                </ol>

                <div class="pull-right">
                    <a href="<c:url value='/affirmationMarriageCertificate'/>" style="font-size: 24px;">Now Apply for Affirmation of Marriage Certificate<i class="fa fa-arrow-circle-right" style="font-size: 24px;"></i></a>&nbsp;&nbsp;
                </div>
            </div>
        </section>
        <section class="accordion">
            <input type="checkbox" name="collapse" id="handleLD">
            <h2 class="handle">
                <label for="handleLD">Lost Documents</label>
            </h2>
            <div class="content">
                <ol>
                    <c:forEach var="ld" items="${RequiredDocsListLD}">
                        <li><option value="${ld.valueInteger}">${ld.text}</option></li>
                    </c:forEach>
                </ol>
                <div class="pull-right">
                    <a href="<c:url value='/lostDocument'/>" style="font-size: 24px;">Now Apply for Lost Documents<i class="fa fa-arrow-circle-right" style="font-size: 24px;"></i></a>&nbsp;&nbsp;
                </div>
            </div>
        </section>
        <section class="accordion">
            <input type="checkbox" name="collapse" id="handleSM">
            <h2 class="handle">
                <label for="handleSM">Single/Marital Status</label>
            </h2>
            <div class="content col-sm-12">
                <ol>
                    <c:forEach var="sm" items="${RequiredDocsListSM}">
                        <li><option value="${sm.valueInteger}">${sm.text}</option></li>
                    </c:forEach>
                </ol>
                <div class="pull-right">
                    <a href="<c:url value='/singleMaritalStatus'/>" style="font-size: 24px;">Now Apply for Single/Marital Status<i class="fa fa-arrow-circle-right" style="font-size: 24px;"></i></a>&nbsp;&nbsp;
                </div>
            </div>
        </section>
        <section class="accordion">
            <input type="checkbox" name="collapse" id="handleCT">
            <h2 class="handle">
                <label for="handleCT">Child Travel Document </label>
            </h2>
            <div class="content">
                <ol>
                    <c:forEach var="ct" items="${RequiredDocsListCT}">
                        <li><option value="${ct.valueInteger}">${ct.text}</option></li>
                    </c:forEach>
                </ol>
                <div class="pull-right">
                    <a href="<c:url value='/childTravelDocument'/>" style="font-size: 24px;">Now Apply for Child Travel Document<i class="fa fa-arrow-circle-right" style="font-size: 24px;"></i></a>&nbsp;&nbsp;
                </div>
            </div>
        </section>
        <section class="accordion">
            <input type="checkbox" name="collapse" id="handleAD">
            <h2 class="handle">
                <label for="handleAD">Attestation of Documents</label>
            </h2>
            <div class="content">
                <ol>
                    <c:forEach var="ad" items="${RequiredDocsListAD}">
                        <li><option value="${ad.valueInteger}">${ad.text}</option></li>
                    </c:forEach>
                </ol>
                <div class="pull-right">
                    <a href="<c:url value='/attestationDocument'/>" style="font-size: 24px;">Now Apply for Attestation of Documents<i class="fa fa-arrow-circle-right" style="font-size: 24px;"></i></a>&nbsp;&nbsp;
                </div>
            </div>
        </section>
        <section class="accordion">
            <input type="checkbox" name="collapse" id="handleCA">
            <h2 class="handle">
                <label for="handleCA">Child Adoption</label>
            </h2>
            <div class="content">
                <ol>
                    <c:forEach var="ad" items="${RequiredDocsListCA}">
                        <li><option value="${ad.valueInteger}">${ad.text}</option></li>
                    </c:forEach>
                </ol>
                <div class="pull-right">
                    <a href="<c:url value='/childAdoption'/>" style="font-size: 24px;">Now Apply for Child Adoption<i class="fa fa-arrow-circle-right" style="font-size: 24px;"></i></a>&nbsp;&nbsp;
                </div>
            </div>
        </section>
        <section class="accordion">
            <input type="checkbox" name="collapse" id="handleKT">
            <h2 class="handle">
                <label for="handleKT">Organ Transplant</label>
            </h2>
            <div class="content">
                <ol>
                    <c:forEach var="kt" items="${RequiredDocsListKT}">
                        <li><option value="${kt.valueInteger}">${kt.text}</option></li>
                    </c:forEach>
                </ol>
                <div class="pull-right">
                    <a href="<c:url value='/organTransplant'/>" style="font-size: 24px;">Now Apply for Organ Transplant<i class="fa fa-arrow-circle-right" style="font-size: 24px;"></i></a>&nbsp;&nbsp;
                </div>
            </div>
        </section>
        <section class="accordion">
            <input type="checkbox" name="collapse" id="handleSA">
            <h2 class="handle">
                <label for="handleSA">Closing of Accounts and Transfer of Shares</label>
            </h2>
            <div class="content">
                <ol>
                    <c:forEach var="sa" items="${RequiredDocsListSA}">
                        <li><option value="${sa.valueInteger}">${sa.text}</option></li>
                    </c:forEach>
                </ol>
                <div class="pull-right">
                    <a href="<c:url value='/closingTransferAccounts'/>" style="font-size: 24px;">Now Apply for Closing of Accounts and Transfer of Shares<i class="fa fa-arrow-circle-right" style="font-size: 24px;"></i></a>&nbsp;&nbsp;
                </div>
            </div>
        </section>
        <section class="accordion">
            <input type="checkbox" name="collapse" id="handleAA">
            <h2 class="handle">
                <label for="handleAA">Attest Wills,Contracts,Agreements and Testaments </label>
            </h2>
            <div class="content">
                <ol>
                    <c:forEach var="aa" items="${RequiredDocsListAA}">
                        <li><option value="${aa.valueInteger}">${aa.text}</option></li>
                    </c:forEach>
                </ol>
                <div class="pull-right">
                    <a href="<c:url value='/attestAgreementWillsContract'/>" style="font-size: 24px;">Now Apply for Attest Wills,Contracts,Agreements and Testaments<i class="fa fa-arrow-circle-right" style="font-size: 24px;"></i></a>&nbsp;&nbsp;
                </div>
            </div>
        </section>

        <section class="accordion">
            <input type="checkbox" name="collapse" id="handleNMC">
            <h2 class="handle">
                <label for="handleNMC">New Marriage Certificate </label>
            </h2>
            <div class="content col-lg-12 col-md-12 col-sm-12 col-xs-12">
                <ol>
                    <li>Duly filled Affidavit of Parties/Witnesses In-re Marriage Certificate form (Form No G-6
                        <a href=" http://www.judiciary.gov.bt/forms/G6.pdf" target="_blank" style="text-decoration: underline;"><span style="color: blue; ">Petition for Marriage Certificate</span></a>
                        and Form No H-8 <a href=" http://www.judiciary.gov.bt/forms/Form8New.pdf" target="_blank"
                                           style="text-decoration: underline;"><span style="color: blue; ">Affidavit of Parties/Witnesses In re-Marriage Certificate</span></a>).
                        Please fill the forms in Dzongkha, each party should sign on an independent legal stamps, mention
                        their full names, sign twice: <b>1)</b> against their respective names on the form, <b>2)</b>on independent
                        legal stamps and put initial signatures on all pages of the form. Please avoid any overwriting otherwise the application will not be accepted)</li>
                    <c:forEach var="nmc" items="${RequiredDocListNMC}">
                        <li><option value="${nmc.valueInteger}">${nmc.text}</option></li>
                    </c:forEach>
                </ol>
                <div class="pull-right">
                    <a href="<c:url value='/newMarriageCertificate'/>" style="font-size: 24px;">Now Apply for New Marriage Certificate<i class="fa fa-arrow-circle-right" style="font-size: 24px;"></i></a>&nbsp;&nbsp;
                </div>
            </div>
        </section>

        <section class="accordion">
            <input type="checkbox" name="collapse" id="handleDA">
            <h2 class="handle">
                <label for="handleDA">Divorce Application </label>
            </h2>
            <div class="content">
                <ol>
                    <c:forEach var="da" items="${RequiredDocListDA}">
                        <li><option value="${da.valueInteger}">${da.text}</option></li>
                    </c:forEach>
                </ol>
                <div class="pull-right">
                    <a href="<c:url value='/divorceApplication'/>" style="font-size: 24px;">Now Apply for Divorce Application<i class="fa fa-arrow-circle-right" style="font-size: 24px;"></i></a>&nbsp;&nbsp;
                </div>
            </div>
        </section>

    </div>
</div>
</div>



<%--For local use login only start--%>
<div class="col-md-6 col-sm-6 col-lg-6 col-xs-12">
    <form class="card" name='login' id="loginformId" action="<c:url value="/login"/>" method="post">
        <div class="card-body p-6">
            <div class="card-title">For official only</div>
            <hr/>
            <div class="form-group">
                <label class="form-label">Username</label>
                <input type="text" name="username" id="username" autofocus="true" class="form-control tabable"
                       tabindex="1" required="true" autocomplete="off" placeholder="Enter Your Username"/>
            </div>
            <div class="form-footer">
                <div class="col-md-4 col-sm-4 col-lg-4 col-xs-4">
                    <input type="submit" class="btn btn-primary btn-block tabable" onclick="systemlogin()" tabindex="4" value="Sign In" style="color: #fff;"/>
                </div>
                <div class="col-md-4 col-sm-4 col-lg-4 col-xs-4">
                    <button type="reset" class="btn btn-warning btn-block">Reset</button>
                </div>
            </div>
        </div>
    </form>
</div>
<%-- For local use login only end --%>

</body>
<script type="text/javascript">
    function systemlogin(){
        $( "#loginformId" ).submit();
    }
</script>

</html>

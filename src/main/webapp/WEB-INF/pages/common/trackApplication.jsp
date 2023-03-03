<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 8/22/2019
  Time: 10:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Track Application</title>
</head>
<body class="">
<div class="my-3 my-md-5">
    <div class="container">
        <div class="row">
            <div class="col-12">

                    <div class="card-body">
                        <h2 class="card-title"><b>Judicial Service</b> >> Track Application</h2>

                        <div class="row">
                            <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
                                <div class="panel panel-default">
                                    <div class="panel-body">
                                        <div class="form-group">
                                            <ul>
                                                <li>
                                                    <a href = "<c:url value = "/trackApplication/trackApplicationMC"/>">Marriage Certificate</a>
                                                </li>
                                                <li>
                                                    <a href = "<c:url value = "/trackApplication/trackApplicationAP"/>">Authentication of Personal Details</a>
                                                </li>
                                                <li>
                                                    <a href = "<c:url value = "/trackApplication/trackApplicationAM"/>">Affirmation of Marriage Certificate</a>
                                                </li>
                                                <li>
                                                    <a href = "<c:url value = "/trackApplication/trackApplicationLD"/>">Lost Documents</a>
                                                </li>
                                                <li>
                                                    <a href = "<c:url value = "/trackApplication/trackApplicationSM"/>">Single Status/Marital Status</a>
                                                </li>
                                                <li>
                                                    <a href = "<c:url value = "/trackApplication/trackApplicationCD"/>">Child Travel Documents</a>
                                                </li>
                                                <li>
                                                    <a href = "<c:url value = "/trackApplication/trackApplicationAD"/>">Attestation of Documents</a>
                                                </li>
                                                <li>
                                                    <a href = "<c:url value = "/trackApplication/trackApplicationCA"/>">Child Adoption</a>
                                                </li>
                                                <li>
                                                    <a href = "<c:url value = "/trackApplication/trackApplicationKT"/>">Organ Transplant</a>
                                                </li>
                                                <li>
                                                    <a href = "<c:url value = "/trackApplication/trackApplicationCA"/>">Closing of Account and Transfers of Shares</a>
                                                </li>
                                                <li>
                                                    <a href = "<c:url value = "/trackApplication/trackApplicationAA"/>">Attest Wills, Contracts, Agreements and Testaments</a>

                                                </li>
                                            </ul>

                                       </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>

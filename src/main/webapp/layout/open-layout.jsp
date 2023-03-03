<%@ page import="bt.gov.ditt.sso.client.dto.UserSessionDetailDTO" %>
<%@ page import="bt.gov.ditt.sso.client.SSOClientConstants" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<%@page session="false" %>
<html>
<head>
    <title><sitemesh:write property="title"/></title>
    <link rel="shortcut icon" class="fa fa-leaf" alt="Royal Court of Justice" style="height:100px;width:100px" href="<c:url value='/resources/images/logo.png' />"
    <jsp:include page="include/css.jsp"/>
    <jsp:include page="include/js.jsp"/>
    <jsp:include page="include/open-header.jsp"/>
    <jsp:include page="include/open-menu.jsp"/>
</head>
<body class="">
<div class="my-3 my-md-5">
    <div class="container">
        <sitemesh:write property="body"/>
    </div>
</div>
<jsp:include page="include/open-footer.jsp"/>
<script type="text/javascript">
    function validateAttachment(vl,id){
        if(vl!=""){
            $('#'+id).prop('class', 'alert badge-info');
        }
        else{
            $('#'+id).prop('class', 'alert badge-danger');
        }
    }
</script>
</body>
</html>

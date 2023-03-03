<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <%@ page import="com.spring.mvc.judiciary.dto.ApplicationDetailDTO" %>
    <!-- FONT AWESOME ICONS  -->
    <script src="<%=request.getContextPath() %>/js/jquery-1.11.1.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.min.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/jspdf.min.js"></script>

    <script language="javascript" type="text/javascript">
        function printRecords() {
            window.print();
        }
    </script>
    <%
        ApplicationDetailDTO dtlDto = (ApplicationDetailDTO) request.getAttribute("");
    %>
</head>
<body>
<form action="viewApplication">
    <div id="content">

        <table width="90%" style="width: 700px" align="center" border="0">
            <tr align="center">
                <td>&nbsp;&nbsp;&nbsp;</td>
                <td width="100%">
                    <img src="images/logo.png" style="width: 23%; heigth: 23%">
                <td>&nbsp;&nbsp;&nbsp;</td>
            </tr>
            <tr align="center" style="font-size: 18px;">
                <td>&nbsp;&nbsp;&nbsp;</td>
                <td width="100%"><b>&nbsp;&nbsp;<b>ROYAL COURT OF JUSTICE</b>&nbsp;&nbsp;</b></td>
                <td>&nbsp;&nbsp;&nbsp;</td>
            </tr>
            <tr>
                <td>&nbsp;&nbsp;&nbsp;</td>
                <td><br/><br/></td>
                <td>&nbsp;&nbsp;&nbsp;</td>
            </tr>
            <tr align="left">
                <td>&nbsp;&nbsp;&nbsp;</td>
                <td>
                    <b><%=dtlDto.getJudgementNo() %> </b>
                </td>
                <td>&nbsp;&nbsp;&nbsp;</td>
            </tr>
            <tr>
                <td>&nbsp;&nbsp;&nbsp;</td>
                <td><br/><br/></td>
                <td>&nbsp;&nbsp;&nbsp;</td>
            </tr>
            <tr align="center">
                <td>&nbsp;&nbsp;&nbsp;</td>
                <td align="center"><b>TO WHOM IT MAY CONCERN</b>  </td>
                <td>&nbsp;&nbsp;&nbsp;</td>
            </tr>
            <tr>
                <td>&nbsp;&nbsp;&nbsp;</td>
                <td><br/><br/></td>
                <td>&nbsp;&nbsp;&nbsp;</td>
            </tr>
            <tr align="justify">
                <td>&nbsp;&nbsp;&nbsp;</td>
                <td>This is to certify that <b>&nbsp;<%=dtlDto.getApplicantName() %> (DOB: <%=dtlDto.getApplicantName() %> )&nbsp;</b> Son/daughter of  <b>&nbsp; <%=dtlDto.getFatherName() %> &nbsp;</b>
                    holding Citizenship Identity Card No.  <b>&nbsp;<%=dtlDto.getCidNo() %>  &nbsp;</b> of<b>&nbsp;  <%=dtlDto.getVillageName() %>&nbsp;</b> village from
                    <b>&nbsp;<%=dtlDto.getGewogName() %> &nbsp;</b> gewog (Block) under <b>&nbsp;  <%=dtlDto.getDzongkhagName() %> &nbsp;</b> dzongkhag (District) has also been reflected as
                    <b>&nbsp;<%=dtlDto.getIncorrectName() %> &nbsp;</b> <b>&nbsp;(DOB: <%=dtlDto.getIncorrectName() %> ) &nbsp;</b> in his/her <b><%=dtlDto.getDocName() %></b>.</td>
                <td>&nbsp;&nbsp;&nbsp;</td>
            </tr>
            <tr>
                <td>&nbsp;&nbsp;&nbsp;</td>
                <td><br/></td>
                <td>&nbsp;&nbsp;&nbsp;</td>
            </tr>
            <tr>
                <td>&nbsp;&nbsp;&nbsp;</td>
                <td>It is hereby certified that  <b>&nbsp;<%=dtlDto.getApplicantName() %> &nbsp;</b> and  <b>&nbsp;<%=dtlDto.getIncorrectName() %>&nbsp;</b> is one and the same person.</td>
                <td>&nbsp;&nbsp;&nbsp;</td>
            </tr>
            <tr>
                <td>&nbsp;&nbsp;&nbsp;</td>
                <td><br/></td>
                <td>&nbsp;&nbsp;&nbsp;</td>
            </tr>
            <tr>
                <td>&nbsp;&nbsp;&nbsp;</td>
                <td>Issued under my hand and seal of this Court in accordance to <b>Section 49 of the Civil and Criminal Procedure Code of Bhutan</b> on <%=dtlDto.getJudgementDate() %>.</td>
                <td>&nbsp;&nbsp;&nbsp;</td>
            </tr>
            <tr>
                <td>&nbsp;&nbsp;&nbsp;</td>
                <td><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/></td>
                <td>&nbsp;&nbsp;&nbsp;</td>
            </tr>
            <tr>
                <td>&nbsp;&nbsp;&nbsp;</td>
                <td><%=dtlDto.getApplicantName() %></td>
                <td>&nbsp;&nbsp;&nbsp;</td>
            </tr>
            <tr>
                <td>&nbsp;&nbsp;&nbsp;</td>
                <td align="center"><b>( <%=dtlDto.getLawyer() %> )</b></td>
                <td>&nbsp;&nbsp;&nbsp;</td>
            </tr>
        </table>
    </div>
</form>
</body>
<!--<input type="button" value="download PDF" class="btn btn-primary" onclick="call_download();" />-->
<script type="text/javascript">

</script>
</html>

<%@ page import="com.spring.mvc.judiciary.dto.ApplicationDetailDTO" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>

<HTML>
<title> </title>
<head>
    <script language="javascript" type="text/javascript">
        function printRecords() {
            window.print();
        }
    </script>
    <%
        ApplicationDetailDTO dtlDto = (ApplicationDetailDTO) request.getAttribute("");
    %>
</head>

<body onload="printRecords()">
<table width="100%" style="width: 900px" align="center" border="0">
    <tr align="center">
        <td>&nbsp;&nbsp;&nbsp;</td>
        <td width="90%">
            <img src="pages/s/Services/PrintHTML/Judiciary.png" style="width: 23%; heigth: 23%">
        <td>&nbsp;&nbsp;&nbsp;</td>
    </tr>
    <tr align="center">
        <td>&nbsp;&nbsp;&nbsp;</td>
        <td width="90%" style="font-size:30px;">༄། དཔལ་ལྡན་འབྲུག་པའི་ཁྲིམས་ཀྱི་འདུན་ས།</td>
    </tr>
    <tr align="center" style="font-size: 18px;">
        <td>&nbsp;&nbsp;&nbsp;</td>
        <td width="90%"><label style="font-size:16px;"><strong><b>&nbsp;&nbsp;<b>ROYAL COURT OF JUSTICE</b>&nbsp;&nbsp;</b></strong></label></td>
        <td>&nbsp;&nbsp;&nbsp;</td>
    </tr>
    <tr align="justify">
        <td><br/><br/></td>
    </tr>
    <tr align="justify">
        <td>&nbsp;&nbsp;&nbsp;</td>
        <td>
            <label style="font-size:16px;"><strong><b><%=dtlDto.getJudgementNo() %>&nbsp;&nbsp;</b></strong></label>
        </td>
    </tr>
    <tr align="justify">
        <td>&nbsp;&nbsp;&nbsp;</td>
        <td align="center"><label><b>CHILD TRAVEL DOCUMENT</b></label></td>
    </tr>
    <tr align="justify">
        <td><br/><br/><br/></td>
    </tr>
    <tr align="justify">
        <td>&nbsp;&nbsp;&nbsp;</td>
        <td>This is to certify that <label style="font-size:16px;"><strong><b><%=dtlDto.getOrgFatherName() %></b></strong></label>
            holder of Bhutanese Citizenship Identity Card No.<label style="font-size:16px;"><strong><b><%=dtlDto.getOrgFatherCid() %>
            </b></strong></label>, resident of <label style="font-size:16px;"><strong><b><%=dtlDto.getOrgFatherVillageName() %></b>
            </strong></label> Village,<label style="font-size:16px;"><strong><b><%=dtlDto.getOrgFatherGewogName() %> </b></strong>
            </label> Gewog, <label style="font-size:16px;"><strong><b> <%=dtlDto.getOrgFatherDzongkhagName() %></b></strong></label>
            Dzongkhag and <label style="font-size:16px;"><strong><b><%=dtlDto.getOrgMotherName() %></b></strong></label>
            holder of Bhutanese Citizenship Identity Card No.<label style="font-size:16px;"><strong><b><%=dtlDto.getOrgMotherCid() %>
            </b></strong></label>, resident of <label style="font-size:16px;"><strong><b> <%=dtlDto.getOrgMotherVillageName() %></b>
            </strong></label> Village,<label style="font-size:16px;"><strong><b><%=dtlDto.getOrgMotherGewogName() %> </b></strong></label>
            Gewog,<label style="font-size:16px;"><strong><b>  <%=dtlDto.getOrgMotherDzongkhagName() %> </b></strong></label> Dzongkhag are the legal parents of
            <label style="font-size:16px;"><strong><b><%=dtlDto.getChildName() %></b></strong></label> of &nbsp;<%=dtlDto.getChildDob() %>
            holding Passport No.<label style="font-size:16px;"><strong><b><%=dtlDto.getChildPassportNo() %></b></strong></label>.</td>
    </tr>
    <tr align="justify">
        <td>&nbsp;&nbsp;&nbsp;</td>
        <td width="90%"></td>
        <td>&nbsp;&nbsp;&nbsp;</td>
    </tr>
    <tr align="justify">
        <td>&nbsp;&nbsp;&nbsp;</td>
        <td>In the best interest of the child,<label style="font-size:16px;"><strong><b>&nbsp;&nbsp;<%=dtlDto.getChildName() %>&nbsp;&nbsp;</b></strong></label>
            may travel with his/her<label style="font-size:16px;"><strong><b>&nbsp;&nbsp;<%=dtlDto.getRelationship() %>, <%=dtlDto.getApplicantName() %>
                &nbsp;</b></strong></label>, Passport No.<label style="font-size:16px;"><strong><b><%=dtlDto.getAppPassportNo() %></b></strong></label>,
            <%if(!dtlDto.getRelationship().equalsIgnoreCase("Father") && !dtlDto.getRelationship().equalsIgnoreCase("Mother")) {%>Citizenship Identity Card No.
            <label style="font-size:16px;"><strong><b><%=dtlDto.getCidNo() %></b></strong></label>, Date of Birth <label style="font-size:16px;"><strong><b>
                <%=dtlDto.getApplicantDob() %></b></strong></label>, from <label style="font-size:16px;"><strong><b><%=dtlDto.getVillageName() %></b></strong></label> village,
            under <label style="font-size:16px;"><strong><b><%=dtlDto.getGewogName() %></b></strong></label> Gewog (Block), <label style="font-size:16px;">
                <strong><b><%=dtlDto.getDzongkhagName() %></b></strong></label> Dzongkhag (District),<%} %> to <label style="font-size:16px;"><strong><b><%=dtlDto.getTravelPlace() %></b></strong></label> <%=dtlDto.getTravelReason() %>.
        </td>
    </tr>
    <tr align="justify">
        <td>&nbsp;&nbsp;&nbsp;</td>
        <td width="90%"></td>
        <td>&nbsp;&nbsp;&nbsp;</td>
    </tr>
    <tr align="justify">
        <td>&nbsp;&nbsp;&nbsp;</td>
        <td>Issued under my hand and seal of the Royal Court of Justice in accordance to <label style="font-size:16px;"><strong><b>Section 22 of the Child Care and
        </b></strong></label><label style="font-size:16px;"><strong><b>Protection Act of Bhutan,&nbsp;&nbsp;</b></strong></label> on <b>&nbsp;&nbsp;
            <%=dtlDto.getJudgementDate() %>.&nbsp;&nbsp;</b>
        </td>
    </tr>
    <tr align="justify">
        <td><br/><br/><br/><br/><br/><br/><br/><br/></td>
    </tr>
    <tr align="justify">
        <td>&nbsp;&nbsp;&nbsp;</td>
        <td align="left"><label style="font-size:16px;"><strong><b><%=dtlDto.getChildName() %> </b></strong></label></td>
    </tr>
    <tr align="justify">
        <td>&nbsp;&nbsp;&nbsp;</td>
        <td width="90%"></td>
        <td>&nbsp;&nbsp;&nbsp;</td>
    </tr>
    <tr>
        <td>&nbsp;&nbsp;&nbsp;</td>
        <td align="center"><label style="font-size:16px;"><strong><b>( <%=dtlDto.getLawyer() %> )</b></strong></label></td>
    </tr>
</table>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <%@ page import="com.spring.mvc.judiciary.dto.ApplicationDetailDTO" %>
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
        <td width="100%">
            <img src="/pages/printCertificate/Judiciary.png" style="width: 23%; heigth: 23%">
        <td>&nbsp;&nbsp;&nbsp;</td>
    </tr>
    <tr align="center">
        <td>&nbsp;&nbsp;&nbsp;</td>
        <td width="100%" style="font-size:30px;">༄། དཔལ་ལྡན་འབྲུག་པའི་ཁྲིམས་ཀྱི་འདུན་ས།</td>
    </tr>
    <tr align="center" style="font-size: 18px;">
        <td>&nbsp;&nbsp;&nbsp;</td>
        <td width="100%"><label><b>ROYAL COURT OF JUSTICE</b></label></td>
        <td>&nbsp;&nbsp;&nbsp;</td>
    </tr>
    <tr align="justify">
        <td>&nbsp;&nbsp;&nbsp;</td>
        <td width="100%"></td>
        <td>&nbsp;&nbsp;&nbsp;</td>
    </tr>
    <tr align="justify">
        <td>&nbsp;&nbsp;&nbsp;</td>
        <td>
            <label><b><%=dtlDto.getJudgementNo() %></b></label>
        </td>
    </tr>
    <tr align="justify">
        <td>&nbsp;&nbsp;&nbsp;</td>
        <td width="100%"></td>
        <td>&nbsp;&nbsp;&nbsp;</td>
    </tr>
    <tr align="justify">
        <td>&nbsp;&nbsp;&nbsp;</td>
        <td align="center"><label><b>AFFIRMATION OF SINGLE STATUS</b></label></td>
    </tr>
    <tr align="justify">
        <td>&nbsp;&nbsp;&nbsp;</td>
        <td width="90%"></td>
        <td>&nbsp;&nbsp;&nbsp;</td>
    </tr>
    <tr align="center">
        <td>&nbsp;&nbsp;&nbsp;</td>
        <td>The petition of affirmation of Single status of Miss/Mr. <label style="font-size:16px;"><strong><b><%=dtlDto.getApplicantName() %></b></strong>
        </label>, holding Bhutanese Citizenship Identity Card No.<label style="font-size:16px;"><strong><b>&nbsp;<%=dtlDto.getCidNo() %>,</b></strong></label>
            &nbsp;born on <label style="font-size:16px;"><strong><b><%=dtlDto.getApplicantDob() %></b></strong></label>, Son/Daughter of  Mr.
            <label style="font-size:16px;"><strong><b><%=dtlDto.getFatherName()%></b></strong></label> and Mrs.<label style="font-size:16px;"><strong>
                <b><%=dtlDto.getMotherName() %></b></strong></label>,
            resident of <label style="font-size:16px;"><strong><b>&nbsp;<%=dtlDto.getVillageName() %>&nbsp;</b></strong></label> village, from
            <label style="font-size:16px;"><strong><b><%=dtlDto.getGewogName() %></b></strong></label> Gewog(Block) under <label style="font-size:16px;"><strong><b>
                <%=dtlDto.getDzongkhagName() %></b></strong></label>
            Dzongkhag (District), was registered and heard by this court vide registration number<label style="font-size:16px;"><strong><b>&nbsp;
                <%=dtlDto.getRegNo() %>&nbsp;</b></strong></label> dated <label style="font-size:16px;"><strong><b>&nbsp;<%=dtlDto.getRegDate() %></b></strong></label>.</td>
    </tr>
    <tr align="center">
        <td>&nbsp;&nbsp;&nbsp;</td>
        <td width="100%"></td>
        <td>&nbsp;&nbsp;&nbsp;</td>
    </tr>
    <tr align="center">
        <td>&nbsp;&nbsp;&nbsp;</td>
        <td>As per the evidence submitted by <label style="font-size:16px;"><strong><b><%=dtlDto.getApplicantName() %>&nbsp;</b></strong></label>
            and the submissions made by his/her parents/father/mother before the court, the applicant has not married any person.</td>
    </tr>
    <tr align="center">
        <td>&nbsp;&nbsp;&nbsp;</td>
        <td width="100%"></td>
        <td>&nbsp;&nbsp;&nbsp;</td>
    </tr>
    <tr align="center">
        <td>&nbsp;&nbsp;&nbsp;</td>
        <td>It has been further affirmed by the Single Status update issued by the Gewog/Thromde office of <b>&nbsp;<%=dtlDto.getGewogName() %>&nbsp;
        </b>, dated <label style="font-size:16px;"><strong><b>&nbsp;<%=dtlDto.getLetterDate() %>&nbsp;</b></strong></label>which authenticates
            <label style="font-size:16px;"><strong><b>&nbsp;<%=dtlDto.getApplicantName() %>'s&nbsp;</b></strong></label> status as currently Single
            and not married as required under Section
            <strong><b>Kha 1-3 of the Marriage Act of Bhutan.</b></strong></td>
    </tr>
    <tr align="justify">
        <td>&nbsp;&nbsp;&nbsp;</td>
        <td width="100%"></td>
        <td>&nbsp;&nbsp;&nbsp;</td>
    </tr>
    <tr align="center">
        <td>&nbsp;&nbsp;&nbsp;</td>
        <td>  Issued under my hand and seal of Royal Court of Justice in accordance to <label style="font-size:16px;">
            <strong><b>&nbsp;Section 49 of the Civil and Criminal Procedure Code,</b></strong></label> on &nbsp;<%=dtlDto.getJudgementDate() %>.</td>
    </tr>
    <tr align="justify">
        <td><br/><br/><br/><br/><br/><br/><br/><br/></td>
    </tr>
    <tr align="justify">
        <td>&nbsp;&nbsp;&nbsp;</td>
        <td> ( <%=dtlDto.getApplicantName() %> ) </td>
        <td>&nbsp;&nbsp;&nbsp;</td>
    </tr>
    <tr align="center">
        <td>&nbsp;&nbsp;&nbsp;</td>
        <td> ( <%=dtlDto.getLawyer() %> ) </td>
        <td>&nbsp;&nbsp;&nbsp;</td>
    </tr>
</table>
</body>

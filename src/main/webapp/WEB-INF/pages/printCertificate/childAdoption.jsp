<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%@ page import="com.spring.mvc.judiciary.dto.ApplicationDetailDTO" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Judiciary</title>
</head>
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
        <td width="90%"><label><b>༄། དཔལ་ལྡན་འབྲུག་པའི་ཁྲིམས་ཀྱི་འདུན་ས</b>།</label></td>
        <td>&nbsp;&nbsp;&nbsp;</td>
    </tr>
    <tr align="center" style="font-size: 18px;">
        <td>&nbsp;&nbsp;&nbsp;</td>
        <td width="90%"><label><b>ROYAL COURT OF JUSTICE</b></label></td>
        <td>&nbsp;&nbsp;&nbsp;</td>
    </tr>
    <tr align="justify">
        <td>&nbsp;&nbsp;&nbsp;</td>
        <td width="90%"></td>
        <td>&nbsp;&nbsp;&nbsp;</td>
    </tr>
    <tr align="justify">
        <td>&nbsp;&nbsp;&nbsp;</td>
        <td width="90%">
        </td>
        <td>&nbsp;&nbsp;&nbsp;</td>
    </tr>
    <tr align="justify">
        <td>&nbsp;&nbsp;&nbsp;</td>
        <td>
            <label><%=dtlDto.getJudgementNo() %></label>
        </td>
    </tr>
    <tr align="justify">
        <td>&nbsp;&nbsp;&nbsp;</td>
        <td align="center"><label><b>CHILD ADOPTION CERTIFICATE</b></label></td>
    </tr>
    <tr align="justify">
        <td>&nbsp;&nbsp;&nbsp;</td>
        <td width="90%"></td>
        <td>&nbsp;&nbsp;&nbsp;</td>
    </tr>
    <tr align="justify">
        <td>&nbsp;&nbsp;&nbsp;</td>
        <td>This adoption certificate is regarding Master/Miss <label style="font-size:16px;"><strong><b>&nbsp;<%=dtlDto.getChildName() %>,&nbsp;</b></strong></label>
            born on <label style="font-size:16px;"><strong><b>&nbsp;<%=dtlDto.getChildDob() %>,&nbsp;</b></strong></label>
            who is adopted by Mr <label style="font-size:16px;"><strong><b>&nbsp;<%=dtlDto.getApplicantName() %>&nbsp;</b></strong></label>
            (CID No <label style="font-size:16px;"><strong><b>&nbsp;<%=dtlDto.getCidNo() %>&nbsp;</b></strong></label>. ) of
            <label style="font-size:16px;"><strong><b>&nbsp;<%=dtlDto.getVillageName() %>.&nbsp;</b></strong></label> Village,
            <label style="font-size:16px;"><strong><b>&nbsp;<%=dtlDto.getGewogName() %>&nbsp;</b></strong></label>
            Gewog, under <label style="font-size:16px;"><strong><b>&nbsp;<%=dtlDto.getDzongkhagName() %>&nbsp;</b></strong></label> Dzongkhag
            <%if(dtlDto.getSpouseCidNo()!=null) {%>
            and Ms.<label style="font-size:16px;"><strong><b>&nbsp;<%=dtlDto.getSpouseName() %>&nbsp;</b></strong></label>.
            (CID No.<label style="font-size:16px;"><strong><b>&nbsp;<%=dtlDto.getSpouseCidNo() %>&nbsp;</b></strong></label>)
            of <label style="font-size:16px;"><strong><b>&nbsp;<%=dtlDto.getSpouseVillageName() %>&nbsp;</b></strong></label>. Village,
            <label style="font-size:16px;"><strong><b>&nbsp;<%=dtlDto.getSpouseGewogName() %>&nbsp;</b></strong></label> Gewog under
            <label style="font-size:16px;"><strong><b>&nbsp;<%=dtlDto.getSpouseDzongkhagName() %>&nbsp;</b></strong></label>Dzongkhag
            <%} %>
            <%if(!dtlDto.getOrgFatherCid().equalsIgnoreCase("")) {%>
            and the biological parents Mr. <label style="font-size:16px;"><strong><b>&nbsp;<%=dtlDto.getOrgFatherName() %>&nbsp;</b></strong></label>.
            (CID No. <label style="font-size:16px;"><strong><b>&nbsp;<%=dtlDto.getOrgFatherCid() %>&nbsp;</b></strong></label>.) of
            <label style="font-size:16px;"><strong><b>&nbsp;<%=dtlDto.getOrgFatherVillageName() %>&nbsp;</b></strong></label>. Village,
            <label style="font-size:16px;"><strong><b>&nbsp;<%=dtlDto.getOrgFatherGewogName() %>&nbsp;</b></strong></label>. Gewog, under <label style="font-size:16px;">
                <strong><b>&nbsp;<%=dtlDto.getOrgFatherDzongkhagName() %>&nbsp;</b></strong></label> Dzongkhag
            <%} %><%if(!dtlDto.getOrgMotherName().equalsIgnoreCase("")) {%>and Mrs. <label style="font-size:16px;"><strong><b>&nbsp;<%=dtlDto.getOrgMotherName() %>
                &nbsp;</b></strong></label>  (CID No. <label style="font-size:16px;"><strong><b>&nbsp;<%=dtlDto.getOrgMotherCid() %>.&nbsp;</b></strong></label>.) of
            <label style="font-size:16px;"><strong><b>&nbsp;<%=dtlDto.getOrgMotherVillageName() %>.&nbsp;</b></strong></label> Village,
            <label style="font-size:16px;"><strong><b>&nbsp;<%=dtlDto.getOrgMotherGewogName() %>&nbsp;</b></strong></label> Gewog, under <label style="font-size:16px;">
                <strong><b>&nbsp;<%=dtlDto.getOrgMotherDzongkhagName() %>&nbsp;</b></strong></label> Dzongkhag<%} %>.
        </td>
    </tr>
    <tr align="justify">
        <td>&nbsp;&nbsp;&nbsp;</td>
        <td width="90%"></td>
        <td>&nbsp;&nbsp;&nbsp;</td>
    </tr>
    <tr align="justify">
        <td>&nbsp;&nbsp;&nbsp;</td>
        <td>The adopted child shall be the child of the adoptive parents as if born to them. The parties share a commitment to relationship that is supportive and
            nurturing of the Childs needs, now and in the future and understand her needs in accordance with section 43 and 47 of The Child Adoption Act
            of Bhutan, 2012. The matter was registered and heard by the Court under Miscellaneous Hearing registration No. <label style="font-size:16px;">
                <strong><b>&nbsp;<%=dtlDto.getJudgementNo() %>&nbsp;</b></strong></label> on <label style="font-size:16px;"><strong><b>&nbsp;<%=dtlDto.getJudgementDate() %>
                &nbsp;</b></strong></label>.
        </td>
    </tr>
    <tr align="justify">
        <td>&nbsp;&nbsp;&nbsp;</td>
        <td width="90%"></td>
        <td>&nbsp;&nbsp;&nbsp;</td>
    </tr>
    <tr align="justify">
        <td>&nbsp;&nbsp;&nbsp;</td>
        <td>Therefore, in the best interest of the minor, Master/Miss <label style="font-size:16px;"><strong><b>&nbsp;<%=dtlDto.getChildName() %>&nbsp;</b></strong></label>.
            has been legally adopted by Mr. <label style="font-size:16px;"><strong><b>&nbsp;<%=dtlDto.getApplicantName() %>&nbsp;</b></strong></label>
            <%if(dtlDto.getSpouseCidNo()!=null) {%>and Mrs. <label style="font-size:16px;"><strong><b>&nbsp;<%=dtlDto.getSpouseCidNo() %>&nbsp;</b>
            </strong></label><%} %>, the adoption certificate
            being issued vide Judgment No.(015-<label style="font-size:16px;"><strong><b>&nbsp;<%=dtlDto.getJudgementNo() %>&nbsp;</b></strong></label>) dated
            <label style="font-size:16px;"><strong><b>&nbsp;<%=dtlDto.getJudgementDate() %>&nbsp;</b></strong></label>, issued by the Royal
            Court of Justice, District Court, <label style="font-size:16px;"><strong><b>&nbsp;<%=dtlDto.getCourtName() %>&nbsp;</b></strong></label>.</td>
    </tr>
    <tr align="justify">
        <td>&nbsp;&nbsp;&nbsp;</td>
        <td width="90%"></td>
        <td>&nbsp;&nbsp;&nbsp;</td>
    </tr>
    <tr align="justify">
        <td>&nbsp;&nbsp;&nbsp;</td>
        <td>Issued under my hand and seal of the Royal Court of Justice, <label style="font-size:16px;"><strong><b>&nbsp;<%=dtlDto.getCourtName() %>&nbsp;</b>
        </strong></label>, Kingdom of
            Bhutan on <label style="font-size:16px;"><strong><b>&nbsp;<%=dtlDto.getJudgementDate() %>&nbsp;</b></strong></label>. </td>
    </tr>
    <tr align="justify">
        <td>&nbsp;&nbsp;&nbsp;</td>
        <td width="90%"></td>
        <td>&nbsp;&nbsp;&nbsp;</td>
    </tr>
    <tr align="justify">
        <td>&nbsp;&nbsp;&nbsp;</td>
        <td width="90%"></td>
        <td>&nbsp;&nbsp;&nbsp;</td>
    </tr>
    <tr align="justify">
        <td>&nbsp;&nbsp;&nbsp;</td>
        <td width="90%"></td>
        <td>&nbsp;&nbsp;&nbsp;</td>
    </tr>
    <tr>
        <td>&nbsp;&nbsp;&nbsp;</td>
        <td align="center"><label style="font-size:16px;"><strong><b>( <%=dtlDto.getLawyer() %> )&nbsp;</b></strong></label></td>
    </tr>
</table>
</body>
</html>
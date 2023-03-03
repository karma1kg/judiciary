<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%@ page import="com.spring.mvc.judiciary.dto.ApplicationDetailDTO" %>
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

<body>
<div id="content">
    <table width="100%" style="width: 900px" align="center" border="0">
        <tr align="center">
            <td>&nbsp;&nbsp;&nbsp;</td>
            <td width="90%">
                <img src="pages/s/Services/PrintHTML/Judiciary.png" style="width: 23%; heigth: 23%">
        </tr>
        <tr align="center">
            <td>&nbsp;&nbsp;&nbsp;</td>
            <td width="90%" style="font-size:30px;">༄། དཔལ་ལྡན་འབྲུག་པའི་ཁྲིམས་ཀྱི་འདུན་ས།</td>
        </tr>
        <tr align="center" style="font-size: 18px;">
            <td>&nbsp;&nbsp;&nbsp;</td>
            <td width="90%"><label style="font-size:16px;"><strong><b>&nbsp;&nbsp;<b>ROYAL COURT OF JUSTICE</b>&nbsp;&nbsp;</b></strong></label></td>
        </tr>
        <tr>
            <td>&nbsp;&nbsp;&nbsp;</td>
            <td width="90%"></td>
            <td>&nbsp;&nbsp;&nbsp;</td>
        </tr>
        <tr>
            <td>&nbsp;&nbsp;&nbsp;</td>
            <td width="90%"></td>
            <td>&nbsp;&nbsp;&nbsp;</td>
        </tr>
        <tr>
            <td>&nbsp;&nbsp;&nbsp;</td>
            <td width="90%"><label><%=dtlDto.getJudgementNo() %></label></td>
        </tr>
        <tr align="right">
            <td>&nbsp;&nbsp;&nbsp;</td>
            <td width="90%"><label>Form-2</label></td>
        </tr>
        <tr>
            <td>&nbsp;&nbsp;&nbsp;</td>
            <td width="90%" align="center"><label style="font-size:18px;"><strong><b>AFFIRMATION OF MARRIAGE</b></strong></label></td>
        </tr>
        <tr>
            <td>&nbsp;&nbsp;&nbsp;</td>
            <td width="90%"></td>
            <td>&nbsp;&nbsp;&nbsp;</td>
        </tr>
        <tr align="justify">
            <td>&nbsp;&nbsp;&nbsp;</td>
            <td>The petition for the affirmation of marriage between Mr.<label style="font-size:16px;"><strong><b><%=dtlDto.getApplicantName() %></b></strong>
            </label>, holder of Bhutanese Citizenship Identity Card No.<label style="font-size:16px;"><strong><b><%=dtlDto.getCidNo() %></b></strong></label>
                born on <label style="font-size:16px;"><strong><b><%=dtlDto.getApplicantDob() %></b></strong></label>, Resident of <label style="font-size:16px;">
                    <strong><b><%=dtlDto.getVillageName() %></b></strong></label> Village from <label style="font-size:16px;"><strong><b><%=dtlDto.getGewogName() %>
                </b></strong></label>
                Gewog (Block) under <label style="font-size:16px;"><strong><b><%=dtlDto.getDzongkhagName() %></b></strong></label> Dzongkhag (District) and Mrs.
                <label style="font-size:16px;"><strong><b><%=dtlDto.getSpouseName() %></b></strong></label>
                holder of Bhutanese Citizenship Identity Card No.<label style="font-size:16px;"><strong><b>&nbsp;&nbsp;<%=dtlDto.getSpouseCidNo() %>
                </b></strong></label>born on <label style="font-size:16px;"><strong><b><%=dtlDto.getSpouseApplicantDob() %></b></strong></label>,
                Resident of <label style="font-size:16px;"><strong><b><%=dtlDto.getSpouseVillageName() %></b></strong></label> Village from
                <label style="font-size:16px;"><strong><b><%=dtlDto.getSpouseGewogName() %></b></strong></label>
                Gewog (Block) under <label style="font-size:16px;"><strong><b><%=dtlDto.getSpouseDzongkhagName() %></b></strong></label>
                Dzongkhag (District)&nbsp;was registered and heard by this court.
            </td>
        </tr>
        <tr>
            <td>&nbsp;&nbsp;&nbsp;</td>
            <td width="90%"></td>
            <td>&nbsp;&nbsp;&nbsp;</td>
        </tr>
        <tr align="justify">
            <td>&nbsp;&nbsp;&nbsp;</td>
            <td>It is affirmed that Mr.<label style="font-size:16px;"><strong><b>&nbsp;&nbsp;<%=dtlDto.getApplicantName() %>&nbsp;&nbsp;</b></strong></label>
                and Mrs.<label style="font-size:16px;"><strong><b>&nbsp;&nbsp;<%=dtlDto.getSpouseName() %>&nbsp;&nbsp;</b></strong></label>
                are legally wedded husband and  wife,
                their marriage being solemnized vide Marriage Certificate No. (<%=dtlDto.getMcNo() %>) dated <label style="font-size:16px;"><strong>
                    <b>&nbsp;&nbsp;<%=dtlDto.getJudgementDate() %>&nbsp;&nbsp;</b></strong></label>and issued in accordance to Section
                <strong>Kha-1-7 of the Marriage Act, 1980 of the Kingdom of Bhutan </strong>
                by the Royal Court of Justice,<%=dtlDto.getJudgementNo()%>.</td>
        </tr>
        <tr>
            <td>&nbsp;&nbsp;&nbsp;</td>
            <td width="90%"></td>
            <td>&nbsp;&nbsp;&nbsp;</td>
        </tr>
        <tr align="justify">
            <td>&nbsp;&nbsp;&nbsp;</td>
            <td>Issued under my hand and seal of the Royal Court of Justice, in accordance to<label style="font-size:16px;"><strong><b>&nbsp;&nbsp;
                Section 49 of the Civil and Criminal Procedure Code of Bhutan, dated <%=dtlDto.getJudgementDate() %>.</b></strong></label></td>
        </tr>
        <tr>
            <td>&nbsp;&nbsp;&nbsp;</td>
            <td><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/></td>
            <td>&nbsp;&nbsp;&nbsp;</td>
        </tr>
        <tr>
            <td>&nbsp;&nbsp;&nbsp;</td>
            <td align="center"><label style="font-size:16px;"><strong><b>( <%=dtlDto.getLawyer() %> )</b></strong></label></td>
        </tr>
    </table>
</div>
</body>
</html>
<%@ page import="com.spring.mvc.judiciary.dto.ApplicationDetailDTO" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
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
        <td width="90%"><label style="font-size:16px;"><strong><b>&nbsp;&nbsp;<b>༄། དཔལ་ལྡན་འབྲུག་པའི་ཁྲིམས་ཀྱི་འདུན་ས</b>།&nbsp;&nbsp;</b></strong></label></td>
        <td>&nbsp;&nbsp;&nbsp;</td>
    </tr>
    <tr align="center" style="font-size: 18px;">
        <td>&nbsp;&nbsp;&nbsp;</td>
        <td width="90%"><label style="font-size:16px;"><strong><b>&nbsp;&nbsp;<b>ROYAL COURT OF JUSTICE</b>&nbsp;&nbsp;</b></strong></label></td>
        <td>&nbsp;&nbsp;&nbsp;</td>
    </tr>
    <tr align="justify">
        <td>&nbsp;&nbsp;&nbsp;</td>
        <td width="90%"></td>
        <td>&nbsp;&nbsp;&nbsp;</td>
    </tr>
    <tr align="justify">
        <td>&nbsp;&nbsp;&nbsp;</td>
        <td>
            <label><%=dtlDto.getJudgementNo() %> </label>
        </td>
    </tr>
    <tr align="right">
        <td>&nbsp;&nbsp;&nbsp;</td>
        <td width="90%">Form-8</td>
        <td>&nbsp;&nbsp;&nbsp;</td>
    </tr>
    <tr align="justify">
        <td>&nbsp;&nbsp;&nbsp;</td>
        <td align="center"><label><b>TO WHOM IT MAY CONCERN</b></label></td>
    </tr>
    <tr align="justify">
        <td>&nbsp;&nbsp;&nbsp;</td>
        <td width="90%"></td>
        <td>&nbsp;&nbsp;&nbsp;</td>
    </tr>
    <tr align="justify">
        <td>&nbsp;&nbsp;&nbsp;</td>
        <td>I, <label><%=dtlDto.getApplicantName() %></label>, holding Bhutanese Citizenship Identity Card No. <label><%=dtlDto.getCidNo() %></label> s/o/d/o of Mr.<label>
            <%=dtlDto.getFatherName()%></label>, resident of<label>&nbsp;<%=dtlDto.getVillageName() %></label> village,  <label><%=dtlDto.getGewogName() %></label> Gewog(Block),
            <label><%=dtlDto.getDzongkhagName() %></label> Dzongkhag (District), do hereby solemnly declare and affirm on <label><%=dtlDto.getJudgementDate() %></label> as under:-</td>
    </tr>
    <tr align="justify">
        <td>&nbsp;&nbsp;&nbsp;</td>
        <td width="90%"></td>
        <td>&nbsp;&nbsp;&nbsp;</td>
    </tr>
    <tr align="justify">
        <td>&nbsp;&nbsp;&nbsp;</td>
        <td>1	That I passed my <b><%if(dtlDto.getClassType().equals("Degree Marksheet") || dtlDto.getClassType().equals("Degree Certificate")) {%>degree
            <%}else if(dtlDto.getClassType().equals("XII Marksheet") || dtlDto.getClassType().equals("XII Certificate")) {%>BHSEC-XII
            <%}else if(dtlDto.getClassType().equals("X Marksheet") || dtlDto.getClassType().equals("X Certificate")) {%>
            BCSE-X<%} %>
        </b> in the year   <b><%=dtlDto.getExamYear() %></b> under Index number <b><%=dtlDto.getIndexNo() %></b>.</td>
    </tr>
    <tr align="justify">
        <td>&nbsp;&nbsp;&nbsp;</td>
        <td>2	That I have lost the original <b><%=dtlDto.getClassType() %></b> of the aforesaid examination issued to me,
            the loss of which has been reported to Royal Bhutan Police<%if(dtlDto.getKuenselDate()!=null) {%>, published in Kuensel/Royal Bhutan Police on date
            <b><%=dtlDto.getKuenselDate() %><%} %>.</b></td>
    </tr>
    <tr align="justify">
        <td>&nbsp;&nbsp;&nbsp;</td>
        <td>3	That I am in need of a duplicate copy of the said certificates. </td>
    </tr>
    <tr align="justify">
        <td>&nbsp;&nbsp;&nbsp;</td>
        <td>4	That the statement in paras 1 to 3 above are true.</td>
    </tr>
    <tr align="justify">
        <td><br/><br/></td>
    </tr>
    <tr align="left">
        <td>&nbsp;&nbsp;&nbsp;</td>
        <td>  ( <%=dtlDto.getApplicantName() %> ) </td>
        <td>&nbsp;&nbsp;&nbsp;</td>
    </tr>
    <tr align="left">
        <td>&nbsp;&nbsp;&nbsp;</td>
        <td> Address: ( <%=dtlDto.getAddress() %> )<label></label> </td>
    </tr>
    <tr align="left">
        <td>&nbsp;&nbsp;&nbsp;</td>
        <td>Bhutan </td>
        <td>&nbsp;&nbsp;&nbsp;</td>
    </tr>
    <tr align="left">
        <td>&nbsp;&nbsp;&nbsp;</td>
        <td>Dated:<%=dtlDto.getJudgementDate() %></td>
        <td>&nbsp;&nbsp;&nbsp;</td>
    </tr>
    <tr align="justify">
        <td>&nbsp;&nbsp;&nbsp;</td>
        <td width="90%"></td>
        <td>&nbsp;&nbsp;&nbsp;</td>
    </tr>
    <tr align="justify">
        <td>&nbsp;&nbsp;&nbsp;</td>
        <td align="center"><label>Verification/undertaking</label></td>
    </tr>
    <tr align="justify">
        <td>&nbsp;&nbsp;&nbsp;</td>
        <td width="90%"></td>
        <td>&nbsp;&nbsp;&nbsp;</td>
    </tr>
    <tr align="justify">
        <td>&nbsp;&nbsp;&nbsp;</td>
        <td>The above statement is true to the best of my knowledge and I sign this affidavit on <label><%=dtlDto.getJudgementDate() %></label>,
            at the Royal Court of Justice. In the event any of the above statement of facts is proven to be false, I shall be liable for perjury
            in accordance with the Penal Code of Bhutan. </td>
    </tr>
    <tr align="justify">
        <td><br/><br/></td>
    </tr>
    <tr align="left">
        <td>&nbsp;&nbsp;&nbsp;</td>
        <td>  ( <%=dtlDto.getApplicantName() %> ) </td>
        <td>&nbsp;&nbsp;&nbsp;</td>
    </tr>
    <tr align="justify">
        <td><br/><br/></td>
    </tr>
    <tr align="justify">
        <td>&nbsp;&nbsp;&nbsp;</td>
        <td align="center">  ( <%=dtlDto.getLawyer() %> ) </td>
        <td>&nbsp;&nbsp;&nbsp;</td>
    </tr>

</table>
</body>

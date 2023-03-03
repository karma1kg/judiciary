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
<style type="text/css">

    /* this is the important part (should be used in HTML head): */

    .pagebreak {
        page-break-after: always;
    }

</style>
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
        <td width="90%"><label><b>ROYAL COURT OF JUSTICE</b></label></td>
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
        <td width="90%"></td>
        <td>&nbsp;&nbsp;&nbsp;</td>
    </tr>
    <tr align="justify">
        <td>&nbsp;&nbsp;&nbsp;</td>
        <td>Affidavit given by the patient, giving consent for a kidney transplant for himself/herself.  </td>
    </tr>
    <tr align="justify">
        <td>&nbsp;&nbsp;&nbsp;</td>
        <td>Before the Notary Public Office  </td>
    </tr>
    <tr align="justify">
        <td>&nbsp;&nbsp;&nbsp;</td>
        <td>Place: <label style="font-size:16px;"><strong><b>&nbsp;<%=dtlDto.getCourtName() %>&nbsp;</b></strong></label>. </td>
    </tr>
    <tr align="justify">
        <td>&nbsp;&nbsp;&nbsp;</td>
        <td>Date: <label style="font-size:16px;"><strong><b>&nbsp;<%=dtlDto.getJudgementDate() %>&nbsp;</b></strong></label>. </td>
    </tr>
    <tr align="justify">
        <td>&nbsp;&nbsp;&nbsp;</td>
        <td width="90%"></td>
        <td>&nbsp;&nbsp;&nbsp;</td>
    </tr>
    <tr align="justify">
        <td>&nbsp;&nbsp;&nbsp;</td>
        <td align="center"><u><b>PATIENT AFFIDAVIT</b></u></td>
    </tr>
    <tr align="justify">
        <td>&nbsp;&nbsp;&nbsp;</td>
        <td width="90%"></td>
        <td>&nbsp;&nbsp;&nbsp;</td>
    </tr>
    <tr align="justify">
        <td>&nbsp;&nbsp;&nbsp;</td>
        <td>I <label style="font-size:16px;"><strong><b>&nbsp;<%=dtlDto.getPatientName() %>&nbsp;</b></strong></label>, born on <label style="font-size:16px;"><strong>
            <b>&nbsp;<%=dtlDto.getPatientDob() %>&nbsp;</b></strong></label> years, son/daughter of <label style="font-size:16px;"><strong><b>&nbsp;
            <%=dtlDto.getPatientFathersName() %>&nbsp;</b></strong></label>
            from <label style="font-size:16px;"><strong><b>&nbsp;<%=dtlDto.getPatientVillageName() %>&nbsp;</b></strong></label>Village,
            <label style="font-size:16px;"><strong><b>&nbsp;<%=dtlDto.getPatientGewogName() %>&nbsp;</b></strong></label>Gewog (Block) under
            <label style="font-size:16px;"><strong><b>&nbsp;<%=dtlDto.getPatientDzongkhagName() %>&nbsp;</b></strong></label>
            Dzongkhag (District) Bhutan, holding Citizenship Identity Card No.<label style="font-size:16px;"><strong><b>&nbsp;<%=dtlDto.getPatientCid() %>&nbsp;
            </b></strong></label>, hereby truthfully and solemnly affirm to the following declaration;
        </td>
    </tr>
    <tr align="justify">
        <td>&nbsp;&nbsp;&nbsp;</td>
        <td width="90%"></td>
        <td>&nbsp;&nbsp;&nbsp;</td>
    </tr>
    <tr align="justify">
        <td>&nbsp;&nbsp;&nbsp;</td>
        <td>As both my kidneys are completely affected by a disease process beyond repair, my <label style="font-size:16px;"><strong><b>&nbsp;
            <%=dtlDto.getRelationship() %>&nbsp;</b></strong></label> has come forward to donate one of his/her kidneys to save my life.</td>
    </tr>
    <tr align="justify">
        <td>&nbsp;&nbsp;&nbsp;</td>
        <td width="90%"></td>
        <td>&nbsp;&nbsp;&nbsp;</td>
    </tr>
    <tr align="justify">
        <td>&nbsp;&nbsp;&nbsp;</td>
        <td>I hereby give my whole hearted consent for a kidney transplantation surgery to be performed on me, after fully knowing about the
            aftereffects of this operation on me on my own knowledge and from the facts made known to me by others, and without any inducements
            or compulsion from any other person.
        </td>
    </tr>
    <tr align="justify">
        <td>&nbsp;&nbsp;&nbsp;</td>
        <td width="90%"></td>
        <td>&nbsp;&nbsp;&nbsp;</td>
    </tr>
    <tr align="justify">
        <td>&nbsp;&nbsp;&nbsp;</td>
        <td>I am living in the above mentioned address with my family and as I am in full possession of all my mental faculties and am in
            good physical condition and in the acceptable age limit, I have come forward to undergo this kidney transplant surgery. I am also aware of the fact
            that the possibility of renal transplant surgery may not be successful on me.
        </td>
    </tr>
    <tr align="justify">
        <td>&nbsp;&nbsp;&nbsp;</td>
        <td width="90%"></td>
        <td>&nbsp;&nbsp;&nbsp;</td>
    </tr>
    <tr align="justify">
        <td>&nbsp;&nbsp;&nbsp;</td>
        <td>I hereby give my wholehearted consent and authorization to the team of Renal Transplantation Surgeons and
            Nephrologists and the team of Anesthetist and doctors working with them to transplant one of the kidneys of
            <label style="font-size:16px;"><strong><b>&nbsp;<%=dtlDto.getDonorName() %>&nbsp;</b></strong></label> to me.
        </td>
    </tr>
    <tr><td><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/></td></tr>

    <tr align="center">
        <td>&nbsp;&nbsp;&nbsp;</td>
        <td width="90%">
            <img src="pages/s/Services/PrintHTML/Judiciary.png" style="width: 23%; heigth: 23%">
        <td>&nbsp;&nbsp;&nbsp;</td>
    </tr>
    <tr align="center">
        <td>&nbsp;&nbsp;&nbsp;</td>
        <td width="90%" style="font-size:30px;">༄། དཔལ་ལྡན་འབྲུག་པའི་ཁྲིམས་ཀྱི་འདུན་ས།</td>
        <td>&nbsp;&nbsp;&nbsp;</td>
    </tr>
    <tr align="center" style="font-size: 18px;">
        <td>&nbsp;&nbsp;&nbsp;</td>
        <td width="90%"><label><b>ROYAL COURT OF JUSTICE</b></label></td>
        <td>&nbsp;&nbsp;&nbsp;</td>
    </tr>
    <tr align="justify">
        <td>&nbsp;&nbsp;&nbsp;</td>
        <td>I also hereby affirm and give my free consent to the team of doctors to take whatever suitable medical decision,
            depending upon my physical status during the time of surgery and I fully agree to abide by the decisions taken by the medical team in the interest of my welfare.</td>
    </tr>
    <tr align="justify">
        <td>&nbsp;&nbsp;&nbsp;</td>
        <td width="90%"></td>
        <td>&nbsp;&nbsp;&nbsp;</td>
    </tr>
    <tr align="justify">
        <td>&nbsp;&nbsp;&nbsp;</td>
        <td>I also solemnly affirm not to hold either the medical teams or team of doctors treating me at <label style="font-size:16px;"><strong><b>&nbsp;
            <%=dtlDto.getHospitalName() %>&nbsp;</b></strong></label>responsible for any possible side effects or complications that may arise after this renal
            transplant operation.</td>
    </tr>
    <tr align="justify">
        <td>&nbsp;&nbsp;&nbsp;</td>
        <td width="90%"></td>
        <td>&nbsp;&nbsp;&nbsp;</td>
    </tr>
    <tr align="justify">
        <td>&nbsp;&nbsp;&nbsp;</td>
        <td>I am also fully aware of the fact that after renal transplant surgery, I must sincerely abide by the advice of my doctors and take medicines
            prescribed regularly failing which my health condition may deteriorate.</td>
    </tr>
    <tr align="justify">
        <td>&nbsp;&nbsp;&nbsp;</td>
        <td width="90%"></td>
        <td>&nbsp;&nbsp;&nbsp;</td>
    </tr>
    <tr align="justify">
        <td>&nbsp;&nbsp;&nbsp;</td>
        <td>This renal transplant surgery is being performed out of my own freewill and consent and I declare that I will not hold anybody at
            a later date responsible or find fault with for whatever side effects or complications like rejection, infection and other complication
            that may arise at a future date.</td>
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
        <td><b>Witnesses: </b></td>
    </tr>
    <tr align="justify">
        <td>&nbsp;&nbsp;&nbsp;</td>
        <td>1.Name :&nbsp;<%=dtlDto.getPatientWitnessName() %>, Village :&nbsp;<%=dtlDto.getPatientWitnessVillageName() %>,
            Gewog :&nbsp;<%=dtlDto.getPatientWitnessGewogName() %>, Dzongkhag :&nbsp;<%=dtlDto.getPatientWitnessDzongkhagName() %>.</td>
    </tr>
    <tr align="justify">
        <td>&nbsp;&nbsp;&nbsp;</td>
        <td>2.Name :&nbsp;<%=dtlDto.getPatientWitness2Name() %>, Village :&nbsp;<%=dtlDto.getPatientWitness2VillageName() %>,
            Gewog :&nbsp;<%=dtlDto.getPatientWitness2GewogName() %>, Dzongkhag :&nbsp;<%=dtlDto.getPatientWitness2DzongkhagName() %>.</td>
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
    <tr align="justify">
        <td>&nbsp;&nbsp;&nbsp;</td>
        <td>Add Photo & Signature of patient</td>
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
    <tr><td><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/></td></tr>
    <tr align="center">
        <td>&nbsp;&nbsp;&nbsp;</td>
        <td width="90%">
            <img src="pages/s/Services/PrintHTML/Judiciary.png" style="width: 23%; heigth: 23%">
        <td>&nbsp;&nbsp;&nbsp;</td>
    </tr>
    <tr align="center">
        <td>&nbsp;&nbsp;&nbsp;</td>
        <td width="90%" style="font-size:30px;">༄། དཔལ་ལྡན་འབྲུག་པའི་ཁྲིམས་ཀྱི་འདུན་ས།</td>
        <td>&nbsp;&nbsp;&nbsp;</td>
    </tr>
    <tr align="center" style="font-size: 18px;">
        <td>&nbsp;&nbsp;&nbsp;</td>
        <td width="90%"><label><b>ROYAL COURT OF JUSTICE</b></label></td>
        <td>&nbsp;&nbsp;&nbsp;</td>
    </tr>
    <tr align="justify">
        <td>&nbsp;&nbsp;&nbsp;</td>
        <td>
            <label style="font-size:16px;"><strong><b>&nbsp;<%=dtlDto.getJudgementNo() %>&nbsp;</b></strong></label>
        </td>
    </tr>
    <tr align="justify">
        <td>&nbsp;&nbsp;&nbsp;</td>
        <td width="90%"></td>
        <td>&nbsp;&nbsp;&nbsp;</td>
    </tr>
    <tr align="justify">
        <td>&nbsp;&nbsp;&nbsp;</td>
        <td>Affidavit given by the donor for offering His/Her kidney for transplant to Mr./Mrs. <label style="font-size:16px;"><strong><b>&nbsp;
            <%=dtlDto.getPatientName() %>&nbsp;</b></strong></label>,  </td>
    </tr>
    <tr align="justify">
        <td>&nbsp;&nbsp;&nbsp;</td>
        <td>Before the Notary Public Office  </td>
    </tr>
    <tr align="justify">
        <td>&nbsp;&nbsp;&nbsp;</td>
        <td>Place: <label style="font-size:16px;"><strong><b>&nbsp;<%=dtlDto.getCourtName() %>&nbsp;</b></strong></label>. </td>
    </tr>
    <tr align="justify">
        <td>&nbsp;&nbsp;&nbsp;</td>
        <td>Date: <label style="font-size:16px;"><strong><b>&nbsp;<%=dtlDto.getJudgementDate() %>&nbsp;</b></strong></label>. </td>
    </tr>
    <tr align="justify">
        <td>&nbsp;&nbsp;&nbsp;</td>
        <td width="90%"></td>
        <td>&nbsp;&nbsp;&nbsp;</td>
    </tr>
    <tr align="justify">
        <td>&nbsp;&nbsp;&nbsp;</td>
        <td align="center"><b><u>DONOR AFFIDAVIT</u></b>  </td>
    </tr>
    <tr align="justify">
        <td>&nbsp;&nbsp;&nbsp;</td>
        <td width="90%"></td>
        <td>&nbsp;&nbsp;&nbsp;</td>
    </tr>
    <tr align="justify">
        <td>&nbsp;&nbsp;&nbsp;</td>
        <td>I, <label style="font-size:16px;"><strong><b>&nbsp;<%=dtlDto.getDonorName() %>&nbsp;</b></strong></label><label style="font-size:16px;">
            <strong><b><%=dtlDto.getCmcNo() %>&nbsp;</b></strong></label>, aged <label style="font-size:16px;"><strong><b>&nbsp;<%=dtlDto.getDonorDob() %>&nbsp;
        </b></strong></label> s/o/d/o  <label style="font-size:16px;"><strong><b>&nbsp;<%=dtlDto.getDonorFathersName() %>&nbsp;</b></strong></label> residing at
            <label style="font-size:16px;"><strong><b>&nbsp;<%=dtlDto.getDonorVillageName() %>&nbsp;</b></strong></label> (village), <label style="font-size:16px;">
                <strong><b>&nbsp;<%=dtlDto.getDonorGewogName() %>&nbsp;</b></strong></label> (Block), <label style="font-size:16px;"><strong><b>&nbsp;
                <%=dtlDto.getDonorDzongkhagName() %>&nbsp;</b></strong></label>(District), do
            hereby solemnly and sincerely affirm and state as follows:</td>
    </tr>
    <tr align="justify">
        <td>&nbsp;&nbsp;&nbsp;</td>
        <td width="90%"></td>
        <td>&nbsp;&nbsp;&nbsp;</td>
    </tr>
    <tr align="justify">
        <td>&nbsp;&nbsp;&nbsp;</td>
        <td>I understand my  <label style="font-size:16px;"><strong><b>&nbsp;<%=dtlDto.getPatientDonorRelationship() %>&nbsp;,<%=dtlDto.getPatientName() %>
        </b></strong></label>  aged <label style="font-size:16px;"><strong><b>&nbsp;<%=dtlDto.getPatientDob() %>&nbsp;</b></strong></label> s/d/o
            <label style="font-size:16px;"><strong><b>&nbsp;<%=dtlDto.getPatientFathersName() %>&nbsp;</b></strong></label>,
            is now undergoing treatment for his/her kidney failure at<label style="font-size:16px;"><strong><b>&nbsp; <%=dtlDto.getHospitalName() %>&nbsp;
            </b></strong></label>. It is further understood that his/her kidneys have been completely destroyed that kidney can be transplanted from one person
            to another person with kidney failure. I also understand the nature of risk involved in the operation for
            removal one of my kidneys as well as possible future permanent injury to my health and the risk that my remaining kidney may be subsequently injured or diseased.</td>
    </tr>
    <tr align="justify">
        <td>&nbsp;&nbsp;&nbsp;</td>
        <td width="90%"></td>
        <td>&nbsp;&nbsp;&nbsp;</td>
    </tr>
    <tr align="justify">
        <td>&nbsp;&nbsp;&nbsp;</td>
        <td> I am also aware of the possibility that such kidney transplant operation may not be successful.</td>
    </tr>
    <tr align="justify">
        <td>&nbsp;&nbsp;&nbsp;</td>
        <td width="90%"></td>
        <td>&nbsp;&nbsp;&nbsp;</td>
    </tr>
    <tr align="justify">
        <td>&nbsp;&nbsp;&nbsp;</td>
        <td> I declare that I am living with my family in the above-mentioned address; I am a person of mature age and sound mind and out of love and compassion,
            I accept to donate one of my kidneys to my  <label style="font-size:16px;"><strong><b>&nbsp;<%=dtlDto.getPatientDonorRelationship() %>&nbsp;</b></strong></label>.</td>
    </tr>
    <tr align="justify">
        <td>&nbsp;&nbsp;&nbsp;</td>
        <td width="90%"></td>
        <td>&nbsp;&nbsp;&nbsp;</td>
    </tr>
    <tr align="justify">
        <td>&nbsp;&nbsp;&nbsp;</td>
        <td>I hereby declare that I, out of my own free will and accord and out of love and affection, voluntarily agree to donate one of my kidneys for
            transplantation to my wife and there is no monetary benefit for me or my family members out of the kidney donation.</td>
    </tr>
    <tr align="justify">
        <td>&nbsp;&nbsp;&nbsp;</td>
        <td width="90%"></td>
        <td>&nbsp;&nbsp;&nbsp;</td>
    </tr>
    <tr align="justify">
        <td>&nbsp;&nbsp;&nbsp;</td>
        <td> In an effort to benefit my family, I authorize the CMC, Vellore team of surgeons, doctors, anesthetists, to operate and or assist in operation on
            me for the purpose of removing one of the kidneys and placing such kidney on the body of <label style="font-size:16px;"><strong><b>&nbsp;
                <%=dtlDto.getPatientName() %>.&nbsp;</b></strong></label> </td>
    </tr>
    <tr align="justify">
        <td>&nbsp;&nbsp;&nbsp;</td>
        <td width="90%"></td>
        <td>&nbsp;&nbsp;&nbsp;</td>
    </tr>
    <tr align="justify">
        <td>&nbsp;&nbsp;&nbsp;</td>
        <td>I further declare that though the team of doctors, surgeons, anesthetists and other staff are doing their best in the operation, still
            unfortunately if some mishap happens I shall not hold other doctors operating on me or giving me anesthesia or any person responsible for any
            consequences that may arise from the removal of one of the kidneys whether at present or in future.</td>
    </tr>
    <tr align="justify">
        <td>&nbsp;&nbsp;&nbsp;</td>
        <td width="90%"></td>
        <td>&nbsp;&nbsp;&nbsp;</td>
    </tr>
    <tr align="justify">
        <td>&nbsp;&nbsp;&nbsp;</td>
        <td> I am fully aware and conscious that the operation is at my own risk and hence I shall not hold anyone responsible or make liable on account of the said operation.</td>
    </tr>
    <tr align="justify">
        <td>&nbsp;&nbsp;&nbsp;</td>
        <td width="90%"></td>
        <td>&nbsp;&nbsp;&nbsp;</td>
    </tr>
    <tr align="justify">
        <td>&nbsp;&nbsp;&nbsp;</td>
        <td> <b>Witnesses:</b>. </td>
    </tr>
    <tr align="justify">
        <td>&nbsp;&nbsp;&nbsp;</td>
        <td>1.Name :&nbsp;<%=dtlDto.getPatientWitnessName() %>, Village :&nbsp;<%=dtlDto.getPatientWitnessVillageName() %>,
            Gewog :&nbsp;<%=dtlDto.getPatientWitnessGewogName() %>, Dzongkhag :&nbsp;<%=dtlDto.getPatientWitnessDzongkhagName() %>.</td>
    </tr>
    <tr align="justify">
        <td>&nbsp;&nbsp;&nbsp;</td>
        <td>2.Name :&nbsp;<%=dtlDto.getPatientWitness2Name() %>, Village :&nbsp;<%=dtlDto.getPatientWitness2VillageName() %>,
            Gewog :&nbsp;<%=dtlDto.getPatientWitness2GewogName() %>, Dzongkhag :&nbsp;<%=dtlDto.getPatientWitness2DzongkhagName() %>.</td>
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
    <tr align="justify">
        <td>&nbsp;&nbsp;&nbsp;</td>
        <td><td>Add Photo & Signature of Donor</td></td>
    </tr>
    <tr><td><br/></td></tr>
    <tr align="center">
        <td>&nbsp;&nbsp;&nbsp;</td>
        <td width="90%">
            <img src="pages/s/Services/PrintHTML/Judiciary.png" style="width: 23%; heigth: 23%">
        <td>&nbsp;&nbsp;&nbsp;</td>
    </tr>
    <tr align="center">
        <td>&nbsp;&nbsp;&nbsp;</td>
        <td width="90%" style="font-size:30px;">༄། དཔལ་ལྡན་འབྲུག་པའི་ཁྲིམས་ཀྱི་འདུན་ས།</td>
        <td>&nbsp;&nbsp;&nbsp;</td>
    </tr>
    <tr align="center" style="font-size: 18px;">
        <td>&nbsp;&nbsp;&nbsp;</td>
        <td width="90%"><label><b>ROYAL COURT OF JUSTICE</b></label></td>
        <td>&nbsp;&nbsp;&nbsp;</td>
    </tr>
    <tr align="justify">
        <td>&nbsp;&nbsp;&nbsp;</td>
        <td>
            <label style="font-size:16px;"><strong><b><%=dtlDto.getJudgementNo() %> &nbsp;</b></strong></label>
        </td>
    </tr>
    <tr align="justify">
        <td>&nbsp;&nbsp;&nbsp;</td>
        <td width="90%"></td>
        <td>&nbsp;&nbsp;&nbsp;</td>
    </tr>
    <tr align="justify">
        <td>&nbsp;&nbsp;&nbsp;</td>
        <td>Affidavit given by the dependant of the kidney donor who offers to donate his/her kidney to  <label style="font-size:16px;"><strong><b>&nbsp;
            <%=dtlDto.getPatientName() %>&nbsp;</b></strong></label>,  </td>
    </tr>
    <tr align="justify">
        <td>&nbsp;&nbsp;&nbsp;</td>
        <td>Before the Notary Public Office  </td>
    </tr>
    <tr align="justify">
        <td>&nbsp;&nbsp;&nbsp;</td>
        <td>Place: <label style="font-size:16px;"><strong><b>&nbsp;<%=dtlDto.getCourtName() %>&nbsp;</b></strong></label>. </td>
    </tr>
    <tr align="justify">
        <td>&nbsp;&nbsp;&nbsp;</td>
        <td>Date: <label style="font-size:16px;"><strong><b>&nbsp;<%=dtlDto.getJudgementDate() %>&nbsp;</b></strong></label>. </td>
    </tr>
    <tr align="justify">
        <td>&nbsp;&nbsp;&nbsp;</td>
        <td width="90%"></td>
        <td>&nbsp;&nbsp;&nbsp;</td>
    </tr>
    <tr align="justify">
        <td>&nbsp;&nbsp;&nbsp;</td>
        <td align="center"><b><u>DONOR’S DEPENDENT AFFIDAVIT</u></b>  </td>
    </tr>
    <tr align="justify">
        <td>&nbsp;&nbsp;&nbsp;</td>
        <td width="90%"></td>
        <td>&nbsp;&nbsp;&nbsp;</td>
    </tr>
    <tr align="justify">
        <td>&nbsp;&nbsp;&nbsp;</td>
        <td>I,<label style="font-size:16px;"><strong><b>&nbsp;<%=dtlDto.getDonorDepName() %>&nbsp;</b></strong></label>aged <label style="font-size:16px;"><strong>
            <b>&nbsp;<%=dtlDto.getDonorDepDob() %>&nbsp;</b></strong></label> residing at <label style="font-size:16px;"><strong><b>&nbsp;<%=dtlDto.getDonorDepVillageName() %>
            &nbsp;</b></strong></label> (village),
            <label style="font-size:16px;"><strong><b>&nbsp;<%=dtlDto.getDonorDepGewogName() %>&nbsp;</b></strong></label> (Block), <label style="font-size:16px;">
                <strong><b>&nbsp;<%=dtlDto.getDonorDepDzongkhagName() %>&nbsp;</b></strong></label> (District) understand that <label style="font-size:16px;"><strong><b>
                &nbsp;<%=dtlDto.getPatientName() %>&nbsp;</b></strong></label> is suffering from kidney failure so my
            <label style="font-size:16px;"><strong><b>&nbsp;<%=dtlDto.getDepRelationship() %>&nbsp;</b></strong></label> has consented to giving one of his/her
            kidneys as donation to <label style="font-size:16px;"><strong><b>&nbsp;<%=dtlDto.getPatientName() %>&nbsp;</b></strong></label></td>
    </tr>
    <tr align="justify">
        <td>&nbsp;&nbsp;&nbsp;</td>
        <td width="90%"></td>
        <td>&nbsp;&nbsp;&nbsp;</td>
    </tr>

    <tr align="justify">
        <td>&nbsp;&nbsp;&nbsp;</td>
        <td>I understand that the donor in such kidney transplant surgeries can have wound infection, pain, bleeding and risk to life. I also understand
            that in future if some damage were to happen to the single kidney left behind, the donor may have to undergo dialysis or transplant. I also understand
            the removal of kidney from a healthy donor could lead to high
            BP and protein leak in urine at a future date.
        </td>
    </tr>
    <tr align="justify">
        <td>&nbsp;&nbsp;&nbsp;</td>
        <td width="90%"></td>
        <td>&nbsp;&nbsp;&nbsp;</td>
    </tr>
    <tr align="justify">
        <td>&nbsp;&nbsp;&nbsp;</td>
        <td>I further declare that though the CMC, Vellore team of doctors, surgeons, anesthetists and other staff are doing their best in the operation,
            still unfortunately if some mishap happens I shall not hold other doctors operating on him or giving anesthesia or any other person responsible for
            any consequences that may arise from the removal of one of the kidneys whether at present or in future.
        </td>
    </tr>
    <tr align="justify">
        <td>&nbsp;&nbsp;&nbsp;</td>
        <td width="90%"></td>
        <td>&nbsp;&nbsp;&nbsp;</td>
    </tr>
    <tr align="justify">
        <td>&nbsp;&nbsp;&nbsp;</td>
        <td>I hereby declare, out of free will and accord, I fully consent to <label style="font-size:16px;"><strong><b>&nbsp;<%=dtlDto.getDonorName() %>&nbsp;</b>
        </strong></label>donating one of his/her kidneys to <label style="font-size:16px;"><strong><b>&nbsp;<%=dtlDto.getPatientName() %>&nbsp;</b></strong></label>
            and neither I nor any of our family members will
            not hold on doctors and other surgeons or anesthetists for any untoward Happening to<label style="font-size:16px;"><strong><b>&nbsp;
                <%=dtlDto.getDonorName() %>&nbsp;</b></strong></label> during surgery or during postoperative period or at a later date I am also aware that I
            or other members of our family have no monetary benefits out of his/her kidney donation. Explained in my mother tongue.</td>
    </tr>
    <tr align="justify">
        <td>&nbsp;&nbsp;&nbsp;</td>
        <td width="90%"></td>
        <td>&nbsp;&nbsp;&nbsp;</td>
    </tr>
    <tr align="justify">
        <td>&nbsp;&nbsp;&nbsp;</td>
        <td> <b>Witnesses:</b>. </td>
    </tr>
    <tr align="justify">
        <td>&nbsp;&nbsp;&nbsp;</td>
        <td>1.Name :&nbsp;<%=dtlDto.getPatientWitnessName() %>, Village :&nbsp;<%=dtlDto.getPatientWitnessVillageName() %>,
            Gewog :&nbsp;<%=dtlDto.getPatientWitnessGewogName() %>, Dzongkhag :&nbsp;<%=dtlDto.getPatientWitnessDzongkhagName() %>.</td>
    </tr>
    <tr align="justify">
        <td>&nbsp;&nbsp;&nbsp;</td>
        <td>2.Name :&nbsp;<%=dtlDto.getPatientWitness2Name() %>, Village :&nbsp;<%=dtlDto.getPatientWitness2VillageName() %>,
            Gewog :&nbsp;<%=dtlDto.getPatientWitness2GewogName() %>, Dzongkhag :&nbsp;<%=dtlDto.getPatientWitness2DzongkhagName() %>.</td>
    </tr>
    <tr align="justify">
        <td><br/><br/><br/><br/></td>
    </tr>
    <tr align="justify">
        <td>&nbsp;&nbsp;&nbsp;</td>
        <td>Photo & Signature of the donor’s dependant</td>
    </tr>
    <tr><td><br/><br/><br/><br/><br/><br/><br/></td></tr>
    <tr align="center">
        <td>&nbsp;&nbsp;&nbsp;</td>
        <td width="90%">
            <img src="pages/s/Services/PrintHTML/Judiciary.png" style="width: 23%; heigth: 23%">
        <td>&nbsp;&nbsp;&nbsp;</td>
    </tr>
    <tr align="center">
        <td>&nbsp;&nbsp;&nbsp;</td>
        <td width="90%" style="font-size:30px;">༄། དཔལ་ལྡན་འབྲུག་པའི་ཁྲིམས་ཀྱི་འདུན་ས།</td>
        <td>&nbsp;&nbsp;&nbsp;</td>
    </tr>
    <tr align="center" style="font-size: 18px;">
        <td>&nbsp;&nbsp;&nbsp;</td>
        <td width="90%"><label><b>ROYAL COURT OF JUSTICE</b></label></td>
        <td>&nbsp;&nbsp;&nbsp;</td>
    </tr>
    <tr align="justify">
        <td>&nbsp;&nbsp;&nbsp;</td>
        <td>
            <label style="font-size:16px;"><strong><b>&nbsp;<%=dtlDto.getJudgementNo() %> </b></strong></label>
        </td>
    </tr>
    <tr align="justify">
        <td><br/><br/><br/><br/></td>
    </tr>
    <tr align="justify">
        <td>&nbsp;&nbsp;&nbsp;</td>
        <td align="center"><b><u>RELATIONSHIP CERTIFICATE</u></b>  </td>
    </tr>
    <tr align="justify">
        <td><br/><br/></td>
    </tr>
    <tr align="justify">
        <td>&nbsp;&nbsp;&nbsp;</td>
        <td>This is to certify that the patient <label style="font-size:16px;"><strong><b>&nbsp;<%=dtlDto.getPatientName() %>&nbsp;</b></strong></label>
            age <label style="font-size:16px;"><strong><b>&nbsp;<%=dtlDto.getPatientDob() %>&nbsp;</b></strong></label> years sex <label style="font-size:16px;">
                <strong><b>&nbsp;<%=dtlDto.getPatientGender() %>&nbsp;</b></strong></label> hailing from<label style="font-size:16px;"><strong><b>&nbsp;
                <%=dtlDto.getPatientVillageName() %>&nbsp;</b></strong></label>. Village in <label style="font-size:16px;"><strong><b>&nbsp;<%=dtlDto.getGewogName() %>
                &nbsp;</b></strong></label>. Gewog/Block under <label style="font-size:16px;"><strong><b>&nbsp;<%=dtlDto.getPatientDzongkhagName() %>&nbsp;</b></strong></label>
            Dzongkhag/District and donor <label style="font-size:16px;"><strong><b>&nbsp;<%=dtlDto.getDonorName() %>&nbsp;</b></strong></label>. age
            <label style="font-size:16px;"><strong><b>&nbsp;<%=dtlDto.getDonorDob() %>&nbsp;</b></strong></label>. years sex <label style="font-size:16px;">
                <strong><b>&nbsp;<%=dtlDto.getDonorGender() %>&nbsp;</b></strong></label> from་  <label style="font-size:16px;"><strong><b>&nbsp;
                <%=dtlDto.getDonorVillageName() %>&nbsp;</b></strong></label> Village in <label style="font-size:16px;"><strong><b>&nbsp;<%=dtlDto.getDonorGewogName() %>
                &nbsp;</b></strong></label>. Gewog/Block under <label style="font-size:16px;"><strong><b>&nbsp;<%=dtlDto.getDonorDzongkhagName() %>&nbsp;</b>
            </strong></label>. Dzongkhag/District, are
            <label style="font-size:16px;"><strong><b>&nbsp;<%=dtlDto.getRelationship() %>&nbsp;</b></strong></label> and <label style="font-size:16px;"><strong>
                <b>&nbsp;<%=dtlDto.getPatientDonorRelationship() %>&nbsp;</b></strong></label></td>
    </tr>
    <tr align="justify">
        <td><br/><br/></td>
    </tr>
    <tr align="justify">
        <td>&nbsp;&nbsp;&nbsp;</td>
        <td>The Office of Notary Public, Royal Court of Justice, Thimphu issues this certificate on verification of the census records of both the donor and patient. </td>
    </tr>
    <tr><td><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>
        <br/><br/><br/><br/><br/><br/><br/><br/></td></tr>
    <tr align="center">
        <td>&nbsp;&nbsp;&nbsp;</td>
        <td width="90%">
            <img src="pages/s/Services/PrintHTML/Judiciary.png" style="width: 23%; heigth: 23%">
        <td>&nbsp;&nbsp;&nbsp;</td>
    </tr>
    <tr align="center">
        <td>&nbsp;&nbsp;&nbsp;</td>
        <td width="90%" style="font-size:30px;">༄། དཔལ་ལྡན་འབྲུག་པའི་ཁྲིམས་ཀྱི་འདུན་ས།</td>
        <td>&nbsp;&nbsp;&nbsp;</td>
    </tr>
    <tr align="center" style="font-size: 18px;">
        <td>&nbsp;&nbsp;&nbsp;</td>
        <td width="90%"><label><b>ROYAL COURT OF JUSTICE</b></label></td>
        <td>&nbsp;&nbsp;&nbsp;</td>
    </tr>
    <tr><td><br/><br/></td></tr>
    <tr align="justify">
        <td>&nbsp;&nbsp;&nbsp;</td>
        <td>
            <label style="font-size:16px;"><strong><b>&nbsp;<%=dtlDto.getJudgementNo() %> </b></strong></label>
        </td>
    </tr>
    <tr align="justify">
        <td><br/><br/><br/><br/></td>
    </tr>
    <tr align="justify">
        <td>&nbsp;&nbsp;&nbsp;</td>
        <td align="center"><b><u>RELATIONSHIP CERTIFICATE</u></b>  </td>
    </tr>
    <tr align="justify">
        <td><br/><br/></td>
    </tr>
    <tr align="justify">
        <td>&nbsp;&nbsp;&nbsp;</td>
        <td>This is to certify that the donor’s dependent <label style="font-size:16px;"><strong><b>&nbsp;<%=dtlDto.getDonorDepName() %>&nbsp;</b>
        </strong></label> age <label style="font-size:16px;"><strong><b>&nbsp;<%=dtlDto.getDonorDepDob() %>&nbsp;</b></strong></label> years sex
            <label style="font-size:16px;"><strong><b>&nbsp;<%=dtlDto.getDonorDepGender() %>&nbsp;</b></strong></label> from་ <label style="font-size:16px;">
                <strong><b>&nbsp;<%=dtlDto.getDonorDepVillageName() %>&nbsp;</b></strong></label>
            Village in <label style="font-size:16px;"><strong><b>&nbsp;<%=dtlDto.getDonorDepGewogName() %>&nbsp;</b></strong></label> Gewog/Block under
            <label style="font-size:16px;"><strong><b>&nbsp;<%=dtlDto.getDonorDepDzongkhagName() %>&nbsp;</b></strong></label> Dzongkhag/District and donor
            <label style="font-size:16px;"><strong><b>&nbsp;<%=dtlDto.getDonorName() %>&nbsp;</b></strong></label> age <label style="font-size:16px;"><strong>
                <b>&nbsp;<%=dtlDto.getDonorDob() %>&nbsp;</b></strong></label>
            years sex <label style="font-size:16px;"><strong><b>&nbsp;<%=dtlDto.getDonorGender() %>&nbsp;</b></strong></label> hailing from
            <label style="font-size:16px;"><strong><b>&nbsp;<%=dtlDto.getDonorVillageName() %>&nbsp;</b></strong></label>Village in <label style="font-size:16px;">
                <strong><b>&nbsp;<%=dtlDto.getDonorGewogName() %>&nbsp;</b></strong></label>. Gewog/Block under <label style="font-size:16px;"><strong>
                <b>&nbsp;<%=dtlDto.getDonorDzongkhagName() %>&nbsp;</b></strong></label>. Dzongkhag/District, are
            <label style="font-size:16px;"><strong><b>&nbsp;<%=dtlDto.getDepRelationship() %>&nbsp;</b></strong></label> and <label style="font-size:16px;">
                <strong><b>&nbsp;<%=dtlDto.getDonorDepRelationship() %>&nbsp;</b></strong></label>
        </td>
    </tr>
    <tr align="justify">
        <td><br/><br/></td>
    </tr>
    <tr align="justify">
        <td>&nbsp;&nbsp;&nbsp;</td>
        <td>The Office of Notary Public, Royal Court of Justice, Thimphu issues this certificate on verification of the census records of both the donor and patient. </td>
    </tr>
    <tr><td><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/></td></tr>
    <tr align="center">
        <td>&nbsp;&nbsp;&nbsp;</td>
        <td width="90%">
            <img src="pages/s/Services/PrintHTML/Judiciary.png" style="width: 23%; heigth: 23%">
        <td>&nbsp;&nbsp;&nbsp;</td>
    </tr>
    <tr align="center">
        <td>&nbsp;&nbsp;&nbsp;</td>
        <td width="90%" style="font-size:30px;">༄། དཔལ་ལྡན་འབྲུག་པའི་ཁྲིམས་ཀྱི་འདུན་ས།</td>
        <td>&nbsp;&nbsp;&nbsp;</td>
    </tr>
    <tr align="center" style="font-size: 18px;">
        <td>&nbsp;&nbsp;&nbsp;</td>
        <td width="90%"><label><b>ROYAL COURT OF JUSTICE</b></label></td>
        <td>&nbsp;&nbsp;&nbsp;</td>
    </tr>
    <tr align="justify">
        <td><br/><br/><br/><br/></td>
    </tr>
    <tr align="justify">
        <td>&nbsp;&nbsp;&nbsp;</td>
        <td>
            <label style="font-size:16px;"><strong><b>&nbsp;<%=dtlDto.getJudgementNo() %> </b></strong></label>
        </td>
    </tr>
    <tr align="justify">
        <td><br/><br/></td>
    </tr>
    <tr align="justify">
        <td>&nbsp;&nbsp;&nbsp;</td>
        <td align="center"><b>TO WHOM IT MAY CONCERN</b>  </td>
    </tr>
    <tr align="justify">
        <td><br/><br/><br/><br/><br/><br/><br/><br/></td>
    </tr>
    <tr align="justify">
        <td>&nbsp;&nbsp;&nbsp;</td>
        <td>The Court hereby attest the photo and thumb print of dependant <label style="font-size:16px;"><strong><b>&nbsp;<%=dtlDto.getDonorDepName() %>&nbsp;</b></strong></label>,
            age <label style="font-size:16px;"><strong><b>&nbsp;<%=dtlDto.getDonorDepDob() %>&nbsp;</b></strong></label> years, hailing from <label style="font-size:16px;">
                <strong><b>&nbsp;<%=dtlDto.getDonorDepVillageName() %>&nbsp;</b></strong></label>.village in
            <label style="font-size:16px;"><strong><b>&nbsp;<%=dtlDto.getDonorDepGewogName() %>&nbsp;</b></strong></label> gewog (Block) under
            <label style="font-size:16px;"><strong><b>&nbsp;<%=dtlDto.getDonorDepDzongkhagName() %>&nbsp;</b></strong></label>. Dzongkhag (District),
            <label style="font-size:16px;"><strong><b>&nbsp;<%=dtlDto.getDepRelationship() %>&nbsp;</b></strong></label>. of the donor
            <label style="font-size:16px;"><strong><b>&nbsp;<%=dtlDto.getDonorName() %>&nbsp;</b></strong></label> as under :</td>
    </tr>
    <tr align="justify">
        <td><br/><br/></td>
    </tr>
    <tr align="justify">
        <td>&nbsp;&nbsp;&nbsp;</td>
        <td>Issued under my hand and seal of the Royal Court of Justice on this <label style="font-size:16px;"><strong><b>&nbsp;
            <%=dtlDto.getJudgementDate() %>&nbsp;</b></strong></label></td>
    </tr>
</table>
</body>
</html>
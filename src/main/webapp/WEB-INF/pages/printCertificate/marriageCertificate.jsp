<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>
<!DOCTYPE html>
<html>
<title> </title>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="<%=request.getContextPath() %>/css/bootstrap.min.css">
    <link rel="stylesheet" href="<%=request.getContextPath() %>/css/font-awesome.min.css">
    <script src="<%=request.getContextPath() %>/js/jquery-2.2.3.min.js"></script>
    <script src="<%=request.getContextPath() %>/js/jspdf.debug.js"></script>
    <script src="<%=request.getContextPath() %>/js/jspdf.plugin.autotable.js"></script>
    <script language="javascript" type="text/javascript">
        function printRecords() {
            window.print();
        }
    </script>
</head>
<div id="printCertificateFrame">
<body onload="printRecords()">
<table width="100%" style="width: 900px" align="center" border="0" id="downloadCertificate">
    <tr align="center">
        <td>&nbsp;&nbsp;&nbsp;</td>
        <td width="90%">
            <label style="font-size: 30px;"><span id="courtTypeDzo"></span>་ཁྲིམས་ཀྱི་འདུན་ས། </label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <img src="<c:url value='/resources/images/judiciary.jpg'/>" style="width: 23%; heigth: 23%">
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<label style="font-size: 25px;"><span id="courtType"></span> COURT</label>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<label style="font-size: 25px;"><span id="courtName"></span></label>
        </td>
    </tr>

    <tr align="center">
        <td>&nbsp;&nbsp;&nbsp;</td>
        <td width="90%" style="font-size: 30px;">༄། དཔལ་ལྡན་འབྲུག་པའི་ཁྲིམས་ཀྱི་འདུན་ས།</td>
    </tr>
    <tr align="center" style="font-size: 18px;">
        <td>&nbsp;&nbsp;&nbsp;</td>
        <td width="90%"><label><b>ROYAL COURT OF JUSTICE</b></label></td>
    </tr>
    <tr>
        <td>&nbsp;&nbsp;&nbsp;</td>
        <td width="90%"></td>
        <td>&nbsp;&nbsp;&nbsp;</td>
    </tr>
    <tr style="font-size: 26px; font-family: tsuyig; line-height: 1.5;">
        <td>&nbsp;&nbsp;&nbsp;</td>
        <td align="left"><label><span id="judgementNoDzo"></span></label></td>
    </tr>
    <tr style="font-size: 26px; font-family: tsuyig; line-height: 1.5;">
        <td>&nbsp;&nbsp;&nbsp;</td>
        <td align="right"><label>བྲི་ཤོག་ཞེ་གུ་པ༼ཨེཆ-༤༩༽</label></td>
    </tr>
    <tr style="font-size: 26px; font-family: tsuyig; line-height: 1.5;">
        <td>&nbsp;&nbsp;&nbsp;</td>
        <td align="right"><label>གཉེན་སྦྱོར་ཆ་འཇོག་གཉེན་ཐམ།</label></td>
    </tr>
    <tr>
        <td>&nbsp;&nbsp;&nbsp;</td>
        <td width="90%"></td>
        <td>&nbsp;&nbsp;&nbsp;</td>
    </tr>
    <tr align="justify" style="font-size: 26px; font-family: tsuyig; line-height: 1.5;">
        <td>&nbsp;&nbsp;&nbsp;</td>
        <td>࿐<label style="font-size: 10px;">&nbsp;</label>ད་ལན༑<label style="font-size: 10px;">&nbsp;</label>གཉེན་ཐམ་ཞུ་མི་ཕོ་མོ་གཉིས་ཀྱིས་<label style="font-size: 10px;">&nbsp;</label>
            ཁྲིམས་ཀྱི་འདུན་སར་ཕུལ་མི་<label style="font-size: 10px;">&nbsp;</label>བཤེར་ཡིག་དེ་<label style="font-size: 10px;">&nbsp;</label> རྩོད་འཛིན་ཨང་༼<span id="applicationIdDzo"></span>༽ཅན་མར་ སྤྱི་ཚེས
            ་<label style="font-size: 10px;">&nbsp;</label><sub><span id="dateDzo"></span>
            </sub><label style="font-size: 10px;">&nbsp;</label><label style="font-size: 10px;">&nbsp;</label>ལུ་བཀོད་གྲུབ།     </td>
    </tr>
    <tr>
        <td>&nbsp;&nbsp;&nbsp;</td>
        <td width="90%"></td>
        <td>&nbsp;&nbsp;&nbsp;</td>
    </tr>
    <tr align="justify" style="font-size: 26px; font-family: tsuyig; line-height: 1.5;">
        <td>&nbsp;&nbsp;&nbsp;</td>
        <td>༡.<label style="font-size: 10px;">&nbsp;</label>ཕོའི་མིང་གསལ་<label style="font-size: 10px;">&nbsp;</label><label><strong><b><span id="applicantName"></span>
        </b></strong></label><label style="font-size: 10px;">&nbsp;</label>སྐྱེས་ཚེས་<strong><b><label style="font-size: 10px;">&nbsp;</label><sub><span id="applicantDobBh"></span>
        </sub></b></strong><label style="font-size: 10px;">&nbsp;</label>མི་ཁུངས་ཀྱི་དབྱེ་བ་<strong><b><label style="font-size: 10px;">&nbsp;</label><span id="nationality"></span>
            ་<label style="font-size: 10px;">&nbsp;</label></b></strong>མི་རྩིས་འབྲི་ཤོག་ཨང་<strong><b><label style="font-size: 10px;">&nbsp;</label><span id="censusFormNo"></span></b></strong>
            མི་ཁུངས་ལག་ཁྱེར་ཨང་<label style="font-size: 10px;">&nbsp;</label><strong><b><sub><span id="cidNo"></span></sub></b></strong><label style="font-size: 10px;">&nbsp;
            </label>ཕ་མིང་<strong><b><label style="font-size: 10px;">&nbsp;</label><span id="fatherName"></span></b></strong> མ་མིང་<label style="font-size: 10px;">&nbsp;
            </label><strong><b><span id="motherName"></span></b></strong><label style="font-size: 10px;">&nbsp;</label>
            ཁྲམ་ཨང་ <label style="font-size: 10px;">&nbsp;</label><strong><b><span id="tharmNo"></span></b></strong><label style="font-size: 10px;">&nbsp;</label>
            གུང་ཨང་<label style="font-size: 10px;">&nbsp;</label><strong><b><span id="houseNo"></span></b></strong><label style="font-size: 10px;">&nbsp;</label>
            གཡུས་<label style="font-size: 10px;">&nbsp;</label><strong><b><span id="villageNameBh"></span></b></strong><label style="font-size: 10px;">&nbsp;</label>
            རྒེད་འོག་<label style="font-size: 10px;">&nbsp;</label><strong><b><span id="gewogNameBh"></span></b></strong><label style="font-size: 10px;">&nbsp;</label>
            རྫོང་ཁག་<label style="font-size: 10px;">&nbsp;</label><strong><b><span id="dzongkhagNameBh"></span></b></strong><label style="font-size: 10px;">&nbsp;</label></td>
    </tr>
    <tr>
        <td>&nbsp;&nbsp;&nbsp;</td>
        <td width="90%"></td>
        <td>&nbsp;&nbsp;&nbsp;</td>
    </tr>
    <tr align="justify" style="font-size: 26px; font-family: tsuyig; line-height: 1.5;">
        <td>&nbsp;&nbsp;&nbsp;</td>
        <td>༢.<label style="font-size: 10px;">&nbsp;</label>མོའི་མིང་གསལ་<label style="font-size: 10px;">&nbsp;</label><label><strong><b><span id="spouseName"></span></b>
        </strong></label><label style="font-size: 10px;">&nbsp;</label>སྐྱེས་ཚེས་<strong><b><label style="font-size: 10px;">&nbsp;</label><sub><span id="spouseApplicantDobBh"></span>
        </sub></b></strong><label style="font-size: 10px;">&nbsp;</label>མི་ཁུངས་ཀྱི་དབྱེ་བ་<strong><b><label style="font-size: 10px;">&nbsp;</label><span id="spouseNationality"></span>
            ་<label style="font-size: 10px;">&nbsp;</label></b></strong>མི་རྩིས་འབྲི་ཤོག་ཨང་<strong><b><label style="font-size: 10px;">&nbsp;</label><span id="spouseCensusFormNo"></span>
        </b></strong>
            མི་ཁུངས་ལག་ཁྱེར་ཨང་<label style="font-size: 10px;">&nbsp;</label><strong><b><sub><span id="spouseCidNo"></span></sub></b></strong><label style="font-size: 10px;">&nbsp;
            </label>ཕ་མིང་<strong><b><label style="font-size: 10px;">&nbsp;</label><span id="spouseFathersName"></span></b></strong>མ་མིང་<label style="font-size: 10px;">&nbsp;
            </label><strong><b><span id="spouseMothersName"></span></b></strong><label style="font-size: 10px;">&nbsp;</label>
            ཁྲམ་ཨང་ <label style="font-size: 10px;">&nbsp;</label><strong><b><span id="spouseTharmNo"></span></b></strong><label style="font-size: 10px;">&nbsp;</label>
            གུང་ཨང་<label style="font-size: 10px;">&nbsp;</label><strong><b><span id="spouseHouseNo"></span></b></strong><label style="font-size: 10px;">&nbsp;</label>
            གཡུས་<label style="font-size: 10px;">&nbsp;</label><strong><b><span id="spouseVillageNameBh"></span></b></strong><label style="font-size: 10px;">&nbsp;</label>
            རྒེད་འོག་<label style="font-size: 10px;">&nbsp;</label><strong><b><span id="spouseGewogNameBh"></span></b></strong><label style="font-size: 10px;">&nbsp;</label>
            རྫོང་ཁག་<label style="font-size: 10px;">&nbsp;</label><strong><b><span id="spouseDzongkhagNameBh"></span></b></strong><label style="font-size: 10px;">&nbsp;</label></td>
    </tr>
    <tr align="justify">
        <td><br/><br/><br/><br/><br/><br/><br/><br/></td>
    </tr>
    <tr align="justify" style="font-size: 26px; font-family: tsuyig; line-height: 1.5;">
        <td>&nbsp;&nbsp;&nbsp;</td>
        <td><b>བཀའ་རྒྱ།</b></td>
    </tr>
    <tr align="justify" style="font-size: 26px; font-family: tsuyig; line-height: 1.5;">
        <td>&nbsp;&nbsp;&nbsp;</td>
        <td><b>ཁྲིམས་ཀྱི་འདུན་ས་ལས་གོང་གསལ་ཕོ་མོ་གཉིས་པོ་&nbsp;&nbsp;<b>གཉེན་ཁྲིམས་ཁ༽<sub>༡-༧</sub>&nbsp;པའི་དགོངས་དོན་ལྟར་</b>&nbsp;བཀྲ་ཤིས་པའི་སྣང་བ་གསར་པའི་ཐོག་ གཉེན་ལམ་དར་གྱིས་སྦྲེལ་བས་ དར་ཆད་ཀྱང་མདུད་པ་མི་ཞིག་ མི་ཚེ་ཡོལ་རུང་དམ་ཚིག་མི་འཁྲུལ་བར་ ཇི་སྲིད་འཚོ་བའི་རིང་</b>
            དེ་སྲིད་བུ་ནོར་   ལོངས་སྤྱོད་ཕུན་སུམ་ཚོགས་པའི་རྟགས་དང་རྟེན་འབྲེལ་གྱི་སྒོ་ལས་འདི་རིང་ནས་བཟུང་སྟེ་གཉེན་སྦྱོར་ངོ་མར་ཆ་འཇོག་གྲུབ་པ་བཅས་ གནམ་ལོ་ <b><span id="lunarDateDzo"></span></b>་ལུའམ་ སྤྱི་ཚེས་<b><span id="dateDzo"></span></b>་ལུ་དཔལ་ལྡན་འབྲུག་པའི་ཁྲིམས་ཀྱི་བཀའ་རྒྱ། </td>
    </tr>
    <tr align="justify">
        <td><br/><br/><br/><br/></td>
    </tr>
    <tr align="justify" style="font-size: 26px; font-family: tsuyig; line-height: 1.5;">
        <td>&nbsp;&nbsp;&nbsp;</td>
        <td align="center"><label ><strong><b>&nbsp;( <span id="lawyerDzo"></span> )&nbsp;</b></strong></label></td>
    </tr>
</table>
<div align="center">
		<button type="button" class="btn btn-flat btn-primary" onclick="downloadReceipt()"><i class="fa fa-download fa-fw"></i> Convert to PDF</button>		
	</div>

</body>
</div>
<script>
    function getDataUri(url, callback) {
        var image = new Image();

        image.onload = function () {
            var canvas = document.createElement('canvas');
            canvas.width = this.naturalWidth; // or 'width' if you want a special/scaled size
            canvas.height = this.naturalHeight; // or 'height' if you want a special/scaled size

            canvas.getContext('2d').drawImage(this, 0, 0);

            // Get raw image data
            callback(canvas.toDataURL('image/png').replace(/^data:image\/(png|jpg);base64,/, ''));

            // ... or get as Data URI
            callback(canvas.toDataURL('image/png'));
        };

        image.src = url;
    }

    var imageDataUri;
    // Usage
    getDataUri('<%=request.getContextPath()%>/pages/s/Services/PrintHTML/Judiciary.png', function(dataUri) {
        imageDataUri = dataUri;
    });

    function downloadReceipt()
    {
        var doc = new jsPDF('p','pt','a4', false);
        var imgData = imageDataUri;
        doc.addImage(imgData, 'PNG',80, 5, 500, 40);
        var elem = document.getElementById("downloadCertificate");
        var res = doc.autoTableHtmlToJson(elem);
        doc.autoTable(res.columns, res.data, {theme: 'plain'});
        doc.save("certificate.pdf");
    }
</script>
</html>


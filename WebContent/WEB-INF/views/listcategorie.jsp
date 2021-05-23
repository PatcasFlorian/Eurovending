

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
     
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>

<!-- let's add tag srping:url -->
<spring:url value="//cdn.crunchify.com/go/crunchify.css" var="crunchifyCSS" />
<spring:url value="//cdn.crunchify.com/go/crunchify.js" var="crunchifyJS" />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<link href="{crunchifyCSS}" rel="stylesheet" />
<script src="${crunchifyJS}"></script>
<!-- Finish adding tags -->

<title>ListCategorii</title>
<style type="text/css">
body {
	background-image: url('https://cdn.crunchify.com/bg.png');
}
</style>

<style>
#myHeader {
  background-color: lightblue;
  color: red;
  padding: 20px;
  text-align: center;
} 
</style>
<style>
table #Stable {
}
table {
    border-collapse: collapse;
    font-family: sans-serif, Arial;
    font-size: 100%;
    box-shadow: 2px 2px 2px #555;
    overflow-x: scroll;
}
thead {color: green;}
tbody {background-color: #CDE;
display: table-row-group;
  vertical-align: middle;
  border-color: inherit; 
  border-radius: 20px;
  padding: 5px;}
tfoot {color: red;}
table, th, td {
  
  background-color:LightGray;
  border: 2px solid black;
}
</style>
<style type="text/css">

</head>

<body>
 <img src="resources/logo-image.png" alt="MicroLogo" style="width:250px;height:150px;" >
	<br>
	<br>
	${message}
	
	<table id="Stable">
 <caption style="color: Tomato" >Lista cu Locatii</caption>
 
<caption style=" background: #245f91;color:#eee;text-align: center;padding: 0px;border-radius: 55px;font-weight: bold;" > Organizator : Eurovendig srl<br>Oradea Str Aleea Rogerius Nr.6,Bihor</caption>
  <tr>
     <th>NR.</th>
    <th>Categorie</th>
    </tr>
     <c:forEach var="locatie" items="${model.categorie }">  
    <tr> 
     <td style="color: Red" ><c:out value="${locatie.id}"></c:out></td>  
  <td style="color: Green"><c:out value="${locatie.denumireCategorie}"></c:out></td>
 </tr>
  </c:forEach>
 
  </table>
	
</body>
</html>
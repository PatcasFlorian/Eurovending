<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>

<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Categorii</h1>
<br>
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
 
  </c:forEach>
 
  </table>
</body>
</html>
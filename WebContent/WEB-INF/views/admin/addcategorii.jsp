<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
       <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Jekyll v4.1.1">
<title>EurovendingAddPrimaryCategory</title>


<link rel="stylesheet" type="text/css" href="resources/Comun/lista-style.css">

<style type="text/css">
table.center {
  margin-left:auto; 
  margin-right:auto;
}
</style>
<style>
a:hover {
  background-color: yellow;
}
</style>
</head>
<body id="myBody">
<p style="color: Red">SuperAdmin :<c:out value="${myUser}"></c:out> </p>
<h3 id="myHeader" > <a style="color:red" href="backhomeadmin.htm" ><==Back</a> <caption style=" background: #245f91;color:#eee;text-align: center;padding: 10px;border-radius: 55px;font-weight: bold;" > Organizator : Eurovending SRL Oradea Str Aleea Rogerius Nr.6,Bihor</caption> <a style="color:red" href="login-portal.htm">. LogOut</a></h3>

<table id="Stable" class="center" >
 <caption style="color: Tomato" >Adaugare Categorie Parinte Noua</caption>
 

  <tr>
     <th>NR.</th>
    <th>NumeCategorie</th>
    <th>Statut Categorie</th>
    </tr>
       <form:form action="insert-categorie-parinte.htm" metod="post" commandName="categorieParinte">
    <tr> 
      
     <td style="color: Red" ><c:out value="${categorie.id}"></c:out></td>  
   <td style="color: Green"><c:out value="${categorie.numeCatParinte}"></c:out>
  <label for="fname"></label>
  <input type="text" id="numeCatParinte" name="numeCatParinte" size="50"> 
  </td>
  <td style="color: Green">
  <label for="statute"><c:out  value="${categorie.statut}"></c:out></label>
  <input list="browsers1" name="statut" id="browser1" size="30" >
  <datalist id="browsers1" >
    <option value="PUBLICAT">
    <option value="FORBIDDEN">
  </datalist>
   </td>
 </table>
 <input type="submit" value="Salveaza"/>
</form:form>
</body>
</html>
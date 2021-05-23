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
<title>EurovendingEditUser</title>


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
<h3 id="myHeader"><button id="button2" onclick="location.href='add-subcategorie.htm?numeCatParinte=${categorie.numeCatParinte}'" type="button">Adauga SubCategorie</button><button id="button2" onclick="location.href='add-product.htm'" type="button">Adauga Produs!!!</button> </h3>

  <div class="table-responsive">
        <table class="table table-striped table-sm">
          <thead>
            <tr>
              <th>NR.</th>
              <th>CategorieParinte</th>
               <th>NumeSubCategorie</th>
              <th>Statut Categorie</th>
            </tr>
          </thead>
          <tbody>
          <c:forEach var="categorie" items="${model.listSubCat }">  
            <tr> 
     <td style="color: Red" ><c:out value="${categorie.id}"></c:out></td>  
       <td style="color: Green"><c:out value="${categorie.categorieParinte}"></c:out></td>
        <td style="color: Green"><c:out value="${categorie.categorieCopil}"></c:out></td>
       <td style="color: Green"><c:out value="${categorie.statut}"></c:out></td> 
        <td style="color: Blue"><a type="button" class="btn btn-secondary" style="color: #fc8c03" href ="<c:url value='show-categorie-copil.htm?numeCategorieCopil=${categorie.categorieCopil}'/>">Produsele SubCategorie</a></td>
        <td style="color: Green"><a type="button" class="btn btn-secondary" style="color: #fc8c03" href ="<c:url value='edit-categorie-copil.htm?numeCategorieCopil=${categorie.categorieCopil}'/>">EditSubCategory</a></td>
      <td style="color: Green"><a type="button" class="btn btn-secondary" style="color: #fc8c03" href ="<c:url value='delete-categorie-copil.htm?numeCategorieCopil=${categorie.categorieCopil}'/>">DeleteSubCategory</a></td>
            </tr>
        </c:forEach>
          </tbody>
        </table>
      </div>
          

</body>
</html>
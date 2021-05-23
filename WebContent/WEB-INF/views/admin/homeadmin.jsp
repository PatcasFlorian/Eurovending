<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>


<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Jekyll v4.1.1">
    <title>Dashboard Admin</title>

    <link rel="canonical" href="https://getbootstrap.com/docs/4.5/examples/dashboard/">

    <!-- Bootstrap core CSS -->
<link href="resources/assets/dist/css/bootstrap.min.css" rel="stylesheet">

    <style>
      .bd-placeholder-img {
        font-size: 1.125rem;
        text-anchor: middle;
        -webkit-user-select: none;
        -moz-user-select: none;
        -ms-user-select: none;
        user-select: none;
      }

      @media (min-width: 768px) {
        .bd-placeholder-img-lg {
          font-size: 3.5rem;
        }
      }
    </style>
    <!-- Custom styles for this template -->
    <link href="resources/dashboard.css" rel="stylesheet">
    
    <!--  modal -->
     <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <!-- Modal -->
  </head>
  <body >
    <nav class="navbar navbar-dark sticky-top bg-dark flex-md-nowrap p-0 shadow">
  <a class="navbar-brand col-md-3 col-lg-2 mr-0 px-3" href="#" style="color: #fc8c03">Eurovending</a>
  <button class="navbar-toggler position-absolute d-md-none collapsed" type="button" data-toggle="collapse" data-target="#sidebarMenu" aria-controls="sidebarMenu" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <input class="form-control form-control-dark w-100" type="text" placeholder="Search" aria-label="Search">
  <ul class="navbar-nav px-3">
    <li class="nav-item text-nowrap">
      <a class="nav-link" href="#" style="color: #fc8c03">Sign out</a>
    </li>
  </ul>
</nav>

<div class="container-fluid">
  <div  class="row" >
    <nav  id="sidebarMenu" class="col-md-3 col-lg-2 d-md-block bg-light sidebar collapse">
      <div class="sidebar-sticky pt-3">
        <ul class="nav flex-column">
          <li class="nav-item" style="color: #fc8c03">
            <a class="nav-link active" href="#" style="color: #fc8c03">
              <span data-feather="home"></span>
              Dashboard <span class="sr-only">(current)</span>
            </a>
          </li>
          <li class="nav-item">
             <!-- Button to Open the Modal Produse -->
    <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModalProduse">
        <span data-feather="file"></span>
              Produsele Mele
           </button>       
          </li>
          <li class="nav-item">
             <!-- Button to Open the Modal Comenzi -->
  <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModalComenzi">
  <span data-feather="shopping-cart"></span>
             Comenzi Clienti
  </button> 
          </li>
          <li class="nav-item">
            <!-- Button to Open the Modal Raportari -->
  <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModalRaportari">
    <span data-feather="users"></span>
             Raport Vanzari
  </button> 
          </li>
           <li class="nav-item">
         <!-- Button to Open the Modal Utilizatori Sistem-->
  <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal">
   <span data-feather="bar-chart-2"></span>
    Utilizatori Sistem
  </button> 
           </li>  
        </ul>

        <h6 class="sidebar-heading d-flex justify-content-between align-items-center px-3 mt-4 mb-1 text-muted">
          <span>Raport Lunar</span>
          <a class="d-flex align-items-center text-muted" href="#" aria-label="Add a new report">
            <span data-feather="plus-circle"></span>
          </a>
        </h6>
        
      </div>
    </nav>
<main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-md-4">
<canvas class="my-4 w-100" id="myChart" width="auto" ></canvas>
 </main>
  </div>
   
  </div>
</div>
 
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
      <script>window.jQuery || document.write('<script src="resources/assets/js/vendor/jquery.slim.min.js"><\/script>')</script><script src="resources/assets/dist/js/bootstrap.bundle.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/feather-icons/4.9.0/feather.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.3/Chart.min.js"></script>
        <script src="resources/dashboard.js"></script>
       
       
         <!-- The Modal Produse -->
  <div class="modal fade" id="myModalProduse">
    <div class="modal-dialog modal-xl">
      <div class="modal-content">
      
        <!-- Modal Header -->
        <div class="modal-header">
          <h4 class="modal-title"><h2>Categorii Produse</h2></h4>
          <button type="button" class="close" data-dismiss="modal">&times;</button>
        </div>
        
        <!-- Modal body -->
        <div class="modal-body">
      <div class="table-responsive">
        <table class="table table-striped table-sm">
          <thead>
            <tr>
              <th>NR.</th>
              <th>Categorie</th>
              <th>Statut Categorie</th>
            </tr>
          </thead>
          <tbody>
          <c:forEach var="categorie" items="${model.categorie }">  
            <tr> 
     <td style="color: Red" ><c:out value="${categorie.id}"></c:out></td>  
       <td style="color: Green"><c:out value="${categorie.numeCatParinte}"></c:out></td>
       <td style="color: Green"><c:out value="${categorie.statut}"></c:out></td>
       <td>
        <td style="color: Blue"><a type="button" class="btn btn-secondary" style="color: #fc8c03" href ="<c:url value='show-categorie-copil.htm?numeCatParinte=${categorie.numeCatParinte}'/>">Produsele/SubGrupe Categorie</a></td>
       </td>
        <td style="color: Green"><a type="button" class="btn btn-secondary" style="color: #fc8c03" href ="<c:url value='edit-categorie-parinte.htm?numeCatParinte=${categorie.numeCatParinte}'/>">EditCategory</a></td>
      <td style="color: Green"><a type="button" class="btn btn-secondary" style="color: #fc8c03" href ="<c:url value='delete-categorie.htm?numeCatParinte=${categorie.numeCatParinte}'/>">DeleteCategory</a></td>
            </tr>
        </c:forEach>
          </tbody>
        </table>
      </div>
          
        </div>
        
        <!-- Modal footer -->
        <div class="modal-footer">
        <a type="button" class="btn btn-secondary" style="color: #fc8c03" href ="<c:url value='add-categorie-parinte.htm'/>">AddCategory</a>
          <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        </div>
        
      </div>
    </div>
  </div>
  
    <!-- The Modal Comenzi -->
  <div class="modal fade" id="myModalComenzi">
    <div class="modal-dialog modal-xl">
      <div class="modal-content">
      
        <!-- Modal Header -->
        <div class="modal-header">
          <h4 class="modal-title"><h2>Comenzi</h2></h4>
          <button type="button" class="close" data-dismiss="modal">&times;</button>
        </div>
        
        <!-- Modal body -->
        <div class="modal-body">
      <div class="table-responsive">
        <table class="table table-striped table-sm">
          <thead>
            <tr>
              <th>Id</th>
              <th>FullName</th>
              <th>PhoneNumber</th>
              <th>email</th>
              <th>Rol</th>
              <th>Statut</th>
            </tr>
          </thead>
          <tbody>
           <c:forEach var="user" items="${model.userList1 }">  
    <tr> 
     <td style="color: Red" ><c:out value="${user.id}"></c:out></td>  
  <td style="color: Green"><c:out value="${user.fullName}"></c:out></td>
  <td style="color: Green"><c:out value="${user.phoneNumber}"></c:out></td>
  <td style="color: Green"><c:out value="${user.email}"></c:out></td>
  <td style="color: Green"><c:out value="${user.role}"></c:out></td>
  <td style="color: Green"><c:out value="${user.statute}"></c:out></td>
  <td style="color: Green"><a type="button" class="btn btn-secondary" style="color: #fc8c03" href ="<c:url value='edit-user.htm?fullName=${user.fullName}'/>">Edit</a></td>
  <td style="color: Green"><a type="button" class="btn btn-secondary" style="color: #fc8c03" href ="<c:url value='delete-user.htm?fullName=${user.fullName}'/>">Delete</a></td>
 </tr>
  </c:forEach>
          </tbody>
        </table>
      </div>
          
        </div>
        
        <!-- Modal footer -->
        <div class="modal-footer">
        <a type="button" class="btn btn-secondary" style="color: #fc8c03" href ="<c:url value='register-admin.htm'/>">AddUser</a>
          <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        </div>
        
      </div>
    </div>
  </div>
       
         <!-- The Modal Raportari -->
  <div class="modal fade" id="myModalRaportari">
    <div class="modal-dialog modal-xl">
      <div class="modal-content">
      
        <!-- Modal Header Raportari -->
        <div class="modal-header">
          <h4 class="modal-title"><h2>Raportari</h2></h4>
          <button type="button" class="close" data-dismiss="modal">&times;</button>
        </div>
        
        <!-- Modal body -->
        <div class="modal-body">
      <div class="table-responsive">
        <table class="table table-striped table-sm">
          <thead>
            <tr>
              <th>Id</th>
              <th>FullName</th>
              <th>PhoneNumber</th>
              <th>email</th>
              <th>Rol</th>
              <th>Statut</th>
            </tr>
          </thead>
          <tbody>
           <c:forEach var="user" items="${model.userList1 }">  
    <tr> 
     <td style="color: Red" ><c:out value="${user.id}"></c:out></td>  
  <td style="color: Green"><c:out value="${user.fullName}"></c:out></td>
  <td style="color: Green"><c:out value="${user.phoneNumber}"></c:out></td>
  <td style="color: Green"><c:out value="${user.email}"></c:out></td>
  <td style="color: Green"><c:out value="${user.role}"></c:out></td>
  <td style="color: Green"><c:out value="${user.statute}"></c:out></td>
  <td style="color: Green"><a type="button" class="btn btn-secondary" style="color: #fc8c03" href ="<c:url value='edit-user.htm?fullName=${user.fullName}'/>">Edit</a></td>
  <td style="color: Green"><a type="button" class="btn btn-secondary" style="color: #fc8c03" href ="<c:url value='delete-user.htm?fullName=${user.fullName}'/>">Delete</a></td>
 </tr>
  </c:forEach>
          </tbody>
        </table>
      </div>
          
        </div>
        
        <!-- Modal footer -->
        <div class="modal-footer">
        <a type="button" class="btn btn-secondary" style="color: #fc8c03" href ="<c:url value='register-admin.htm'/>">AddUser</a>
          <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        </div>
        
      </div>
    </div>
  </div>
       
       
       <!-- The Modal utilizatori -->
  <div class="modal fade" id="myModal">
    <div class="modal-dialog modal-xl">
      <div class="modal-content">
      
        <!-- Modal Header -->
        <div class="modal-header">
          <h4 class="modal-title"><h2>Utilizatori Sistem</h2></h4>
          <button type="button" class="close" data-dismiss="modal">&times;</button>
        </div>
        
        <!-- Modal body -->
        <div class="modal-body">
      <div class="table-responsive">
        <table class="table table-striped table-sm">
          <thead>
            <tr>
              <th>Id</th>
              <th>FullName</th>
              <th>PhoneNumber</th>
              <th>email</th>
              <th>Rol</th>
              <th>Statut</th>
            </tr>
          </thead>
          <tbody>
           <c:forEach var="user" items="${model.userList1 }">  
    <tr> 
     <td style="color: Red" ><c:out value="${user.id}"></c:out></td>  
  <td style="color: Green"><c:out value="${user.fullName}"></c:out></td>
  <td style="color: Green"><c:out value="${user.phoneNumber}"></c:out></td>
  <td style="color: Green"><c:out value="${user.email}"></c:out></td>
  <td style="color: Green"><c:out value="${user.role}"></c:out></td>
  <td style="color: Green"><c:out value="${user.statute}"></c:out></td>
  <td style="color: Green"><a type="button" class="btn btn-secondary" style="color: #fc8c03" href ="<c:url value='edit-user.htm?fullName=${user.fullName}'/>">Edit</a></td>
  <td style="color: Green"><a type="button" class="btn btn-secondary" style="color: #fc8c03" href ="<c:url value='delete-user.htm?fullName=${user.fullName}'/>">Delete</a></td>
 </tr>
  </c:forEach>
          </tbody>
        </table>
      </div>
          
        </div>
        
        <!-- Modal footer -->
        <div class="modal-footer">
        <a type="button" class="btn btn-secondary" style="color: #fc8c03" href ="<c:url value='register-admin.htm'/>">AddUser</a>
          <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        </div>
        
      </div>
    </div>
  </div>
              
        
 </body>
</html>

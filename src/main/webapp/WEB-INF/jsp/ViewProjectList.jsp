<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>

<head>
    <meta charset="ISO-8859-1">
    <title>View Anime List</title>

    <link rel="stylesheet"
        	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <link rel="stylesheet"
            href="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.css">
        <script
        	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script
        	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
        <script
            src="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.js"></script>

    <style>
        a{
            color: white;
        }
        a:hover {
            color: white;
            text-decoration: none;
        }
    </style>
</head>

<body>
    <div class="container">
        <form:form>
            <table class="table table-bordered">
                <tr>
                    <th>Id</th>
                    <th>Name</th>
                    <th>Year</th>
                    <th>Edit</th>
                    <th>Delete</th>
                </tr>
                <c:forEach var="project" items="${projectList}">
                    <tr>
                        <td>${project.id}</td>
                        <td>${project.name}</td>
                        <td>${project.year}</td>
                        <td><button type="button" class="btn btn-success">
                            <a href="/editProject/${project.id}">Edit</a>
                        </button></td>
                        <td><button type="button" class="btn btn-danger">
                            <a href="/deleteProject/${project.id}">Delete</a>
                        </button></td>
                    </tr>

                </c:forEach>
            </table>
         </form:form>
                 <button type="button" class="btn btn-primary btn-block">
                 	<a href="/addProject">Add New Project</a>
                 </button>
    </div>
</body>


</html>
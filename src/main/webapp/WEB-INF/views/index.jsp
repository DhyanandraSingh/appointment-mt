<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style>
	   .container-fluid-corners{
		    left : 5px !important;
            right: 5px !important;
	    }
		
		.bar1x, .bar2x, .bar3x {
			width: 35px;
			height: 5px;
			background-color: #333;
			margin: 6px 0;
			transition: 0.4s;
		}

		.changex .bar1x {
			-webkit-transform: rotate(-45deg) translate(-9px, 6px) ;
			transform: rotate(-45deg) translate(-9px, 6px) ;
		}
		
		.changex .bar2x {opacity: 0;}
		
		.changex .bar3x {
			-webkit-transform: rotate(45deg) translate(-8px, -8px) ;
			transform: rotate(45deg) translate(-8px, -8px) ;
		}
	

		.toggle{
			margin-top:7px;
		}
		
		.navbar-inverse {
			background-color: rgba(137, 217, 240, 0.36) !important;
			border-color: #080808 !important;
		}
		
		.navbar-inverse .navbar-brand {
			color: #f0ffff !important;
	    }
		
		.navbar-default .navbar-brand {
			color: #fffff !important;
		}
		
		.navbar-inverse .navbar-nav>li>a {
			color: #eee !important;
			font-size:18px;
			background-color: rgba(137, 217, 240, 0.7) !important;
		}
		
		
	</style>
	
	<!-- Bootstrap Core CSS -->
    <%--  <link type="text/css" href="<c:url value="/resources/css/bootstrap.min.css"/>" rel="stylesheet">
   --%>
   
   <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
   
   
    <!-- Custom CSS -->
    <link type="text/css" href="<c:url value='/resources/css/simple-sidebar.css'/>" rel="stylesheet">
 
	
<title>Insert title here</title>
</head>
<body background="<c:url value='/resources/images/1646925.jpg' />">

<div id="wrapper">       
        <!-- Page Content -->
       <div id="page-content-wrapper " >
           <div class="navbar navbar-default navbar-inverse navbar-fixed-top container-fluid-corners" role="navigation">
               <div class="container-fluid ">
                   <ul class="nav navbar-nav pull-left toggle" style="display:flex" >
                       <span id="menu-toggle-x" class="" >
	                       <div class="bar1x"></div>
			               <div class="bar2x"></div>
			               <div class="bar3x"></div>
		               </span>
                   </ul>
                   <a class="navbar-brand" style="margin-left:20px;" href="#">Sansha</a>
                   <ul class="nav navbar-nav pull-right" style="display:flex">
                       <li><a href="#home">Home</a></li>
                       <li><a href="#">About</a></li>
                       <li><a href="#">Contacts</a></li>
                   </ul>
                   <ul class="nav navbar-nav pull-right" style="display:flex">
                       <li><a href="#home"><img></img></a></li>
                   </ul>
               </div>
           </div>
       </div>
       <!-- /#page-content-wrapper -->



    <div id="">
		        <!-- Sidebar -->
        <div id="sidebar-wrapper">
            <ul class="sidebar-nav">
                <li class="sidebar-brand">
                    <a href="#" style="font-weight:bold"> Dashboard </a>
                </li>
                <li>
                    <a href="#">Survey Dashboard</a>
                </li>
                <li>
                    <a href="#">Complaint Dashboard</a>
                </li>
                <li>
                    <a href="#">Suggestion Dashboard</a>
                </li>
                <!--    -->
                <li>
                    <a href="#">About</a>
                </li>
                <li>
                    <a href="#">Services</a>
                </li>
                <li>
                    <a href="#">Contact</a>
                </li>
            </ul>
        </div>
        <!-- /#sidebar-wrapper -->

        <!-- Page Content -->
        <div id="page-content-wrapper">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-12">
                       
					</div>
                </div>
            </div>
        </div>
        <!-- /#page-content-wrapper -->

    </div>
    <!-- /#wrapper -->
</div>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>

	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>


    <!-- Menu Toggle Script -->
    <script>
    $("#menu-toggle-x").click(function(e) {
        e.preventDefault();
		$("#wrapper").toggleClass("toggled");
		e.classList.toggle("changex");
    });
	
	
	
    </script>

</body>

</html>
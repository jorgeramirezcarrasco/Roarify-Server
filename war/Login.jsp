<%@ page contentType="text/html;charset=UTF-8" language="java"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<%@page isELIgnored="false"%>
<!DOCTYPE html>


<html>
	<head>
		<title> LOGIN</title>
		<link rel="stylesheet" type="text/css" href="css/login.css" />
		<link href='http://fonts.googleapis.com/css?family=Oleo+Script' rel='stylesheet' type='text/css'>
		<link href='http://fonts.googleapis.com/css?family=Indie+Flower' rel='stylesheet' type='text/css'>
		<meta charset="utf-8">
	
	
	</head>
	
	
	<body>
		<div class = "container">
			<div class="container2">
				<header>
				<img id="logo" src="/images/Roarifyv1.png">
				</header>
			
			
				<section class="body">
		

					<article>
						<div class = "background">
							<div class ="login" >
								<p>Please, Login.</p>
									
									
								
								<form action="/login" method="post"> 
								
								<p>Username:</p>
								<input type="text" id="name" name="name" placeholder="Insert name" />
								<input type="hidden" name="opcion" id="opcion" value="Empty field, insert your name">
								<br>
								<p>Password:</p>
								<input type="password" id="password" name="password" placeholder="Password" />
								<br>
								<button type="submit">Send</button>
								
								<c:if test="${alert == true }">
									<p id="alert">*Username or password incorrect</p>
									
									</c:if>
							  	
							  
								 </form>
							 </div>
						</div>
					</article>
					
				</section>
			</div>
		</div>


	
	
		
	</body>
</html>
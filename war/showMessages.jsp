<%@ page contentType="text/html;charset=UTF-8" language="java"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
	
		<title>MessagesList</title>
		

		<link rel="stylesheet" type="text/css" href="css/showmessages.css" />
		
		<meta charset="utf-8">
	</head>

<body>
<div id='cssmenu'>
<ul>
   <li><a href='RoarifyApp.jsp'><span>Home</span></a></li>
   <li class='has-sub'><a href='/showMessages'><span>Show Messages</span></a></li>
   <li class='has-sub'><a href='/showUsers'><span>Show Users</span></a></li>
      </ul>
</div>

<div id="bg">
	
	
	

<div class="datagrid">
	<table>
		<thead>
			<tr>
				
				<th>UserID</th>
				<th>Title</th>
				<th>Text</th>
				<th>Location</th>
			</tr>
		</thead>
			
		<tbody>
			
			<c:forEach items="${messages}" var="message">
			
				<tr class = "alt">
					
					<td><c:out value="${message.userId}" /></td>
					<td><c:out value="${message.title}"/></td>
					<td><c:out value="${message.text}" /></td>
					<td><c:out value="${message.lat}"/><c:out value=","/><c:out value="${message.lon}"/></td>
				</tr>
			</c:forEach>
			
		</tbody>
			
	</table>
</div>

</div>
</body>


</html>
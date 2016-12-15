<%@ page contentType="text/html;charset=UTF-8" language="java"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
	
		<title>UsersList</title>
		

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
				<th>User Name</th>				
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${users}" var="user">
				<tr class="alt">
					<td><c:out value="${user}" /></td>
					
					
				</tr>
			</c:forEach>
			</tbody>
		</table>
	</div>
</div>
</body>
</html>
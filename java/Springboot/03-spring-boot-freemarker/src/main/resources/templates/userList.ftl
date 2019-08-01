<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title></title>
	</head>
	<body>
		<table>
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Age</th>
			</tr>
			<#list list as user>
				<tr>
					<td>${user.userid}</td>
					<td>${user.username}</td>
					<td>${user.userage}</td>
				</tr>
			</#list>
		</table>
	</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보</title>
</head>
<body>
	<ul>
		<li>ID: ${member.id}</li>
		<li>이름: ${member.name }</li>
		<li>주소: ${member.address.address1 } ${member.address.address2 }
				(우편번호: ${member.address.zipcode })</li>
	</ul>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
index.jsp  ${msg }

	<ul>
		<li>Hello====</li>
		<li><a href="${pageContext.request.contextPath}/hello.do">hello.do</a></li>
		<li><a href="${pageContext.request.contextPath}/hello-raw.do">hello-raw.do</a></li>
		<li><a href="${pageContext.request.contextPath}/hello.do2">hello.do2</a></li>
	</ul>
	
	<ul>
		<li>model</li>
		<li><a href="${pageContext.request.contextPath}/event/list">event/list</a></li>
	</ul>
	
	<ul>
		<li>@RequestMapping, @PathVariable:</li>
		<li><a href="<%=request.getContextPath() %>/member/regist">/member/regist</a>:
			GET/POST 예, RegistrationController</li>
		<li><a href="<%=request.getContextPath() %>/members">/members</a>:
			@PathVariable 사용 위한 목록 출력, MemberController.members()</li>
		<li><a href="<%=request.getContextPath() %>/members/m2">/members/m2</a>:
			@PathVariable 예, MemberController.memberDetail()</li>
			
		<li><a href="<%=request.getContextPath() %>/members/m2/orders/1">/members/m2/orders/1</a>:
			@PathVariable 예, MemberController.memberOrderDetail()</li>
		<li><a href="<%=request.getContextPath() %>/members/m2/orders/1a">/members/m2/orders/1a</a>:
			@PathVariable 400 응답 예, MemberController.memberOrderDetail()</li>
			
		<li><a href="<%=request.getContextPath() %>/files/a123">/files/a123</a>:
			@PathVariable 정규표현식 FileController.filInfo()</li>
		<li><a href="<%=request.getContextPath() %>/files/a1">/files/a1</a>:
			@PathVariable 정규표현식 404, FileController.filInfo()</li>
		<li><a href="<%=request.getContextPath() %>/folders/1/2/3/files">
		/files/1/2/3/files</a>:
			@RequestMapping, FileController.list()</li>
	</ul>
</body>
</html>
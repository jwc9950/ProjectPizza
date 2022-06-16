<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>

<!-- 아이콘 --><!-- //아이디는 나중에 내꺼로 바꿔야함 -->
<script src="https://kit.fontawesome.com/5bbe282217.js" crossorigin="anonymous"></script>


<!-- css -->
<link rel="stylesheet" href="${path}/resources/css/style.css">



<script type="text/javascript">

//값이 있으면 true, 없으면 false
	if('${msg}'){
		alert('${msg}');
	}
</script>
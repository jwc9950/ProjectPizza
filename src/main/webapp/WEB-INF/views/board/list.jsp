<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../include/includeFile.jsp" %>  <!-- 확장자조심 -->

    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%@include file="../header.jsp" %>


		<h2>게시물리스트</h2>
	<form action="${path}/board/list">
		<select name="findkey">  <!-- //dto에 있는 findkey,findvalue -->
		<!-- //세션의 값을 유지하면서 findkey를 받아옴 -->
			<option value="email" <c:out value="${page.findkey=='email'?'selected':''}"/>>이메일</option>
			<option value="subject" <c:out value="${page.findkey=='subject'?'selected':''}"/>>제목</option>
			<option value="content" <c:out value="${page.findkey=='content'?'selected':''}"/>>내용</option>
			<option value="subcon" <c:out value="${page.findkey=='subcon'?'selected':''}"/>>제목+내용</option>
			
		</select>
		<input type="text" name="findvalue" value="${page.findvalue}">
		<button>조회</button>
		
	</form>
	
	
	
		
		<table border="1">
			<tr>
				<th>번호</th>
				<th>이메일</th>
				<th>제목</th>
				
				<th>조회수</th>
				<th>좋아요</th>
				<th>싫어요</th>
				<th>등록일자</th>
				<th>수정일자</th>
				
			</tr>
		
			<c:forEach var="board" items="${blist}">
				<tr>
					<td>${board.bnum}</td>
					<td>${board.email}</td>
					<td><a href="${path}/board/detail?bnum=${board.bnum}">${board.subject}</a> </td>
					<td>${board.readcnt}</td>
					<td>${board.likecnt}</td>
					<td>${board.dislikecnt}</td>
					<td><fmt:formatDate value="${board.regidate}" pattern="yyyy-MM-dd HH:mm:ss"/> </td>
					<td><fmt:formatDate value="${board.modidate}" pattern="yyyy-MM-dd HH:mm:ss"/> </td>
				</tr>
			</c:forEach>
		</table>
		${page}
		<hr>
		
		<c:if test="${page.startPage !=1}">
		<a href="${path}/board/list?curPage=${page.startPage-1}">이전</a>
		</c:if>
		
		
		<!-- 	//페이징처리 -->
		<c:forEach var="i" begin="${page.startPage}" end="${page.entPage}">
			<a href="${path}/board/list?curPage=${i}">${i}</a>
		</c:forEach>
		
		<c:if test="${page.entPage<page.totPage}">
		<a href="${path}/board/list?curPage=${page.entPage+1}">다음</a>
		</c:if>
		
		
</body>
</html>		
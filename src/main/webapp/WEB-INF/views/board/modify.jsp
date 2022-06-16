<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@include file="../include/includeFile.jsp" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>


</head>
<body>
<%-- ${board} 
${bflist}  --%>

<%@include file="../header.jsp" %>


	<h2>수정</h2>
	
	<form id="frmmodify" action="${path}/board/modify" method="post" enctype="multipart/form-data">
	
		<table border="1">
			<tr>
				<th>번호</th>
				<td><input type="text" name="bnum" readonly="readonly" value="${board.bnum}"></td>
			</tr>
		
			<tr>
				<th>이메일</th>
				<td><input type="text" name="email" value="${board.email}"></td>
			</tr>
			<tr>
				<th>제목</th>
				<td><input type="text" name="subject" value="${board.subject}"></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea name="content" rows="5" cols="25">value="${board.content}"</textarea></td>
			</tr>
			<tr>
				<th>파일<br><button onclick="fileAdd(event)">+</button></th>
				<td>
					<!-- 기존파일리스트 -->
					<c:forEach var="boardFile" items="${bflist}">
						${boardFile.bfnum} ${boardFile.filename} <input type="checkbox" name="removeFiles" value="${boardFile.bfnum}">삭제<br>
					</c:forEach>
					
					<hr>
					
				<div id="divFiles">
					<input type="file" name="files"><br>
				</div>
					
					
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<button onclick="modifylist(event)">수정</button>
					<button>취소</button>
				</td>
			</tr>
			
		</table>
	
	
	</form>


</body>
</html>
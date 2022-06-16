<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@include file="../include/includeFile.jsp" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- //핸들바 cdn연결 -->
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/4.7.7/handlebars.min.js"></script>
<script type="text/javascript" src="${path}/resources/js/boardDetail.js"></script>
<script type="text/javascript" src="${path}/resources/js/boardReply.js"></script>

<!-- 댓글리스트 탬플릿 소스 -->
<script type="text/x-handlebars-template" id="template_source">

 
	{{#each .}}
		{{#levelSpace relevel}} <!--헬퍼작성,   levelSpace:헬퍼이름 relevel:매개변수-->
		{{/levelSpace}}
		<div id='reply{{rnum}}'>
			 <span style="display:none">{{rnum}}</span>
			 <span style="display:none" id="restep{{rnum}}">{{restep}}</span>
			 <span style="display:none" id="relevel{{rnum}}">{{relevel}}</span><br>

			이메일 : <span>{{email}}</span><br>
			내용 : <pre id='content{{rnum}}'>{{content}}</pre><br>
			<button class="reReplyAddShow" value="{{rnum}}">댓글추가</button>
			<button class="reReplyModify" value="{{rnum}}">수정</button>
			<button class="reReplyRemove" value="{{rnum}}">삭제</button>
		</div>
		<hr>
	{{/each}}
</script>

<!-- {{#each .}} -->
<!-- <!-- {{rnum}} --><!-- 이 키를 가지고 오는것 --> -->


</head>
<body>
<%@include file="../header.jsp" %>


<div class="container">




<%-- ${bflist}  --%>
	<h2>상세조회</h2>
	
	<%-- ${board} --%> <!-- //항상이렇게 적어야 내용이 조회시 뿌려짐, 항상 커밋잊지말것 -->
	
	
	
	
	<table border="1">
		<tr>
			<th>번호</th>
			<td id="bnum">${board.bnum}</td>
		</tr>
		<tr>
			<th>이메일</th>
			<td>${board.email}</td>
		</tr>
		<tr>
			<th>내용</th>
			<td>${board.content}</td>
		</tr>
		<tr>
			<th>파일</th>
			<td>
				<c:forEach var="boardFile" items="${bflist}">
				 ${boardFile.filename}<br>  
				</c:forEach>
					
			</td>
		</tr>
		
		<tr>
			<th>제목</th>
			<td>${board.subject}</td>
		</tr>
		<tr>
			<th>조회수</th>
			<td>${board.readcnt}</td>
		</tr>
		<tr>
			<!-- 좋아요 -->
			<th><i class="fas fa-thumbs-up" id="like"></i></th>
			<td id="likecnt">${board.likecnt}</td>
		</tr>
			<!-- 싫어요 -->
		<tr>
			<th><i class="fas fa-thumbs-down" id="dislike"></i></th>
			<td id="dislikecnt">${board.dislikecnt}</td>
		</tr>
		<tr>
			<th>등록일자</th>
			<td><fmt:formatDate value="${board.regidate}" pattern="YYYYMMDD"/></td>
		</tr>
		<tr>
			<th>수정일자</th>
			<td><fmt:formatDate value="${board.modidate}" pattern="YYYYMMDD"/></td>
		</tr>
		
		<tr>
			<td colspan="2">
				<button onclick="location.href='${path}/board/modify?bnum=${board.bnum}'">수정</button>
				<button id="replyAddShow">댓글</button>
				<button onclick="removeCheck('${path}', ${board.bnum})">삭제</button>
				<button onclick="location.href='${path}/board/list'">리스트</button>
			</td>
		</tr>
	</table>
	<hr id="hr">
	<div id="divReplyAdd">
	<!-- 댓글추가 -->
		<!-- 댓글중 부모 -->
		<input type="hidden" value="0" id="restep">
	    <input type="hidden" value="0" id="relevel"><br>
		작성자<input type="email" id="replyemail"><br>
		내용<textarea rows="3" cols="25" id="replycontent"></textarea><br>
		<button id="replyAdd">추가</button>
		<button id="replyCancel">취소</button>
	
	</div>
	
		<div id="divReplyModify">
	<!-- 댓글수정 -->
		<input type="hidden" id="replyrnumModify"><br>
		내용<textarea rows="3" cols="25" id="replycontentModify"></textarea><br>
		<button id="replyModify">저장</button>
		<button id="replyModifyCancel">취소</button>
	
	</div>
		
		<!-- 댓글리스트 -->
		<div id="divReplyList"></div>
	
</div>
</body>


</html>
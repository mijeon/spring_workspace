<%@page import="com.edu.springboard.domain.ReBoard"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%
	//꺼내기
	ReBoard reboard=(ReBoard)request.getAttribute("reboard");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<!-- Popper JS -->
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<!-- Latest compiled JavaScript -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
<script type="text/javascript">
	$(function(){
		$("#bt_replyform").click(function(){
			$("#form2").attr({
				action:"/reboard/reply",
				method:"post"
			});
		}
		$("#form2").submit();
	});
	
	//삭제
	$(function() {
		$("#bt_del").click(function() {
			if (confirm("삭제하시겠어요?")) {
				$("#form1").attr({
					action : "/reboard/delete",
					method : "post"
				});
			}
			$("#form1").submit();
		});
		
		//수정
		$("#bt_edit").click(function(){
			if(confirm("수정하시겠어요?")){
				$("#form1").attr({
					action:"/reboard/edit",
					method:"post"
				});
			}
		$("#form1").submit();
		});
		
		//목록
		$("#bt_list").click(function(){
			location.href="/reboard/list";
		});
		
		//답변 숨기기
		$("#reply_section").hide();
		
		//답변달기
		$("#bt_replyform").click(function(){
			//숨겨져 있던 답변 등록 등장 show(), hide()
			$("#reply_section").show();
			reply();
		});
	});
</script>
</head>
<body>
	<div class="container mt-3">
		<div class="row">
			<div class="col">
				<form id="form1">
					<input type="hidden" name="reboard_idx" value="<%=reboard.getReboard_idx()%>">
					<div class="form-group">
						<input type="text" class="form-control" value="<%=reboard.getTitle() %>" name="title">
					</div>
					<div class="form-group">
						<input type="text" class="form-control" value="<%=reboard.getWriter() %>" name="writer">
					</div>
					<div class="form-group">
						<textarea type="text" class="form-control" name="content"><%=reboard.getContent() %></textarea>
					</div>
					<div class="form-group">
						<button type="button" class="btn btn-outline-warning" id="bt_edit">수정</button>
						<button type="button" class="btn btn-outline-warning" id="bt_del">삭제</button>
						<button type="button" class="btn btn-outline-warning" id="bt_list">목록</button>
						<button type="button" class="btn btn-outline-warning" id="bt_replyform">답변하기</button>
					</div>
				</form>
			</div>
		</div>
		<div class="row" id="reply_section">
			<div class="col">
				<form id="form2">
					<input type="hidden" name="reboard_idx" value="<%=reboard.getReboard_idx()%>">
					<div class="form-group">
						<input type="text" class="form-control" value="<%=reboard.getTitle() %>" name="title">
					</div>
					<div class="form-group">
						<input type="text" class="form-control" value="<%=reboard.getWriter() %>" name="writer">
					</div>
					<div class="form-group">
						<textarea type="text" class="form-control" name="content"><%=reboard.getContent() %></textarea>
					</div>
					<div class="form-group">
						<button type="button" class="btn btn-outline-success" id="bt_reply">답변등록</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
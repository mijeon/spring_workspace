<%@page import="com.edu.springboard.domain.ReBoard"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%
	//꺼내기
	int notice_idx=(Integer)request.getAttribute("notice_idx");
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
	//jsp에서 상세 페이지 가기
	function getDetail(){
	    $.ajax({
	        url:"/rest/notices/<%=notice_idx%>",
	        type:"get",
	        success:function(result,status,xhr){
	            console.log("결과는 ", result);
	
	            //재사용 가능성이 없으므로 뷰와 같은 프레임워크는 필요없다
	            $("#form1 input[name='title']").val(result.title);
	            $("#form1 input[name='writer']").val(result.writer);
	            $("#form1 textarea[name='content']").val(result.content);
	        }
	    });
	}

	$(function(){
		getDetail();
		
		$("#bt_del").click(function(){
				if(confirm("삭제하시나요?")){
					$("#form1").attr({
						action:"/reboard/delete",
						method:"post"
					});
					$("#form1").submit();
				}
			});	
		
		$("#bt_edit").click(function(){
			if(confirm("수정하시나요?")){
				$("#form1").attr({
					action:"/reboard/edit",
					method:"post"
				});
				$("#form1").submit();
			}
		});	
		$("#bt_list").click(function(){
			location="/reboard/list";
		});
	});
</script>
</head>
<body>
	<div class="container mt-3">
		<div class="row">
			<div class="col">
				<form id="form1">
					<input type="hidden" name="reboard_idx">
					<div class="form-group">
						<input type="text" class="form-control" name="title">
					</div>
					<div class="form-group">
						<input type="text" class="form-control" name="writer">
					</div>
					<div class="form-group">
						<textarea type="text" class="form-control" name="content"></textarea>
					</div>
					<div class="form-group">
						<button type="button" class="btn btn-outline-warning" id="bt_edit">수정</button>
						<button type="button" class="btn btn-outline-warning" id="bt_del">삭제</button>
						<button type="button" class="btn btn-outline-warning" id="bt_list">목록</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
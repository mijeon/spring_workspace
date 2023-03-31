<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html lang="zxx">

<head>
<%@ include file="../inc/header.jsp"%>
</head>

<body>
	<!-- Page Preloder -->
	<%@ include file="../inc/preloader.jsp"%>

	<!-- Offcanvas Menu Begin -->
	<!-- 
    	jsp 자체에서 지원하는 태그
    	왜 사용해야 하는지? 사실 jsp는 디자인 영역이므로 개발자만 사용하는 것이 아니라 퍼블리셔, 웹디자이너와 공유함
    	이때 JAVA에 대한 비전문가들은 java코드를 이해할 수 없기 때문에 그들이 좀 더 쉽게 다가갈 수 있도록 태그를 지원해줌 (협업)
     -->
	<%@ include file="../inc/main_navi.jsp"%>
	<!-- Offcanvas Menu End -->

	<!-- Header Section Begin -->
	<%@ include file="../inc/header_section.jsp"%>
	<!-- Header Section End -->

	<section>
		<div class="container">
			<div class="row m=5">
				<div class="col">
					<form id="form1">
						<div class="form-group">
							<label for="text">ID:</label> <input type="text" class="form-control" placeholder="Enter id" name="id">
						</div>
						<div class="form-group">
							<label for="pwd">Password:</label> <input type="password" class="form-control" placeholder="Enter password" name="pass">
						</div>
						<div class="form-group">
							<label for="text">Name:</label> <input type="text" class="form-control" placeholder="Enter name" name="name">
						</div>
						<div class="form-group">
							<label for="text">Email:</label> <input type="text" class="form-control" placeholder="Enter email" name="email">
						</div>
						<button type="button" class="btn btn-primary" id="bt_registasync">비동기 가입</button>
						<button type="button" class="btn btn-primary" id="bt_regist">동기 가입</button>
					</form>
				</div>
			</div>
		</div>
	</section>

	<!-- Instagram Begin -->
	<%@ include file="../inc/insta.jsp"%>
	<!-- Instagram End -->

	<!-- Footer Section Begin -->
	<%@ include file="../inc/footer.jsp"%>
	<!-- Footer Section End -->

	<!-- Search Begin -->
	<%@ include file="../inc/search.jsp"%>
	<!-- Search End -->

	<!-- Js Plugins -->
	<%@ include file="../inc/footer_link.jsp"%>
	<!-- 외부 라이브러리 사용 시 script를 밑에 작성함 -->
	<script type="text/javascript">
		//비동기 회원가입 요청
		function registAsync(){
			let formData=$("#form1").serialize();  //쿼리스트링으로 변환
			
			
			$.ajax({
				url:"/rest/member",
				type:"post",
				data:formData,
				success:function(result, status, xhr){
					alert(result.msg);
				},
				error:function(xhr, status, err){
					let json=JSON.parse(xhr.responseText);
					alert(json.msg);
				}
			});
		}
		
		//동기 회원가입 요청
		function regist(){
			$("#form1").attr({
				action:"/member/regist",
				method:"post"
			});
			$("#form1").submit();
		}
		
		$(function(){
			//비동기 회원가입 요청
			$("#bt_registasync").click(function(){
				registAsync();
            });
			
			//동기 회원가입 요청
			$("#bt_regist").click(function(){
                regist();
            });
		});
	</script>
</body>
</html>
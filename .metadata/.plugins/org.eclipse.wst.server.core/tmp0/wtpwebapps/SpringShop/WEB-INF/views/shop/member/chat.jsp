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
							<input type="text" class="form-control" placeholder="Enter message" id="t_send">
						</div>
						<div class="form-group">
							<textarea type="text" class="form-control" id="t_receive"></textarea>
						</div>
						<button type="button" class="btn btn-primary" id="bt_send">Send</button>
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
		let ws;
		
		//웹소켓을 이용한 서버에 접속
		function connect(){
			ws=new WebSocket("ws://localhost:7777/chat");
			
			//서버에 접속
			ws.onopen=function(){
				console.log("서버에 접속됨 onopen");
			}
			
			//서버에 메세지가 도착하면
			ws.onmessage=function(e){
				console.log("서버가 보낸 데이터", e.data);
				
				//서버가 보낸 메세지를 textrea에 누적
				$("#t_receive").append(e.data+"\n");
			}
			
			//서버와 접속이 끊기면
			ws.onclose=function(){
				console.log("서버와 접속 끊김");
				//끊기는 시점을 발견할 때, 1초의 시간 뒤에 다시 재접속(재귀호출)하여 프로그램의 안정성을 높임 
				setTimeout("connect()", 1000);  
			}
			ws.onerror=function(e){
				console.log("에러발생" ,e);
			}
		}
		
		//서버에 메세지 전송
		function sendMsg(){
			let msg=$("#t_send").val();
			ws.send(msg);
			
			$("#t_send").val("");
			
		}
		
		$(function(){
			connect();
			
            $("#bt_send").click(function(){
                sendMsg();
            });
        });
	</script>
</body>
</html>
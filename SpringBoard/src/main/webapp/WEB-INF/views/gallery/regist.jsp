<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 글등록</title>
<style type="text/css">
.boxStyle{
	width:70px;
	height:85px;
	border:2px solid #ccc;
	display:inline-block;  /*lnline : 다른 요소와 공존, block: 크기 설정*/
	margin:5px;
}
.boxStyle img{
	width:70px;
	height:55px;
}
.boxStyle div{
	text-align:right;
	margin-right:5px;
	font-weight:bold;
}
</style>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
<!-- Popper JS -->
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<!-- Latest compiled JavaScript -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
<!-- View.js (https://v2.vuejs.org/v2/guide/#Getting-Started)-->
<script src="https://cdn.jsdelivr.net/npm/vue@2/dist/vue.js"></script>
<script type="text/javascript">
	let app1;
	let key=0;  //유저가 프로그램을 사용하는 동안 그 값을 계속 증가시켜야 유효성이 확보됨 (데이터베이스 연동 안했을 경우)
	
	//사용자 정의 UI 컴포넌트 등록하기
	//등록한 이후엔 마치 태그처럼 사용가능
	const imagebox={
		template:`
			<div class="boxStyle">
				<div @click="delImg(p_idx)"><a href="#">X</a></div>
				<img :src="p_src">  
			</div>	
		`,
		/*이 컴포넌트를 태그로 호출하는 자가 넘긴 속성을 받으려면 props로 받음*/
		props:['src', 'idx'],
		data(){  //이미지 박스 하나당 하나의 정보를 가짐
			return {
				/*	tamplate 변수명 : 해당 속성
					props의 용도 : 외부에서 전달된 속성값을 보관하기 위한 변수
					p_src의 용도 : 내부 템플릿에서 접근하기 위한 변수*/
				p_src:this.src,
				p_idx:this.idx
			};
		},
		methods:{
            delImg:function(idx){
                //alert("삭제할 이미지 고유 idx값은? "+idx);

                //imageList안의 모든 json이 모유한 idx값을 비교하여 일치하면 삭제하기
                for(let i=0; i<app1.imgList.length; i++){
                    let json=app1.imgList[i];

                    if(json.key==idx){
                        app1.imgList.splice(i,1); //지울 요소와 갯수
                    }
                }
            }
        }
	};
	
	function init(){
		app1=new Vue({
			el:"#app1",
			components:{
				imagebox
			},
			data:{
				count:3,
				imgList:[]  /*유저가 선택한 파일에 대한 정보, src, name...(src보다 더많은 정보가 들어있음)*/
			}
		});
	}
	
	//사용자가 선택한 이미지가 app1.imgList에 들어있는지 여부 판단
	function checkDuplicate(filename){
		let count=0;
		for(let i=0;i<app1.imgList.length;i++){
			let json=app1.imgList[i];
			
			if(json.name==filename){  //동일한 파일 이름이 발견된다면
				count++;
				break;
			}
		}
		return count;
	}
	
	
	//이미지 미리보기 구현
	function preview(files){
		console.log("files는 ", files);
		
		//배열 안에 들어있는 파일정보를 하나씩 읽어들여 화면에 출력
		for(let i=0;i<files.length;i++){
			//배열에 들어있는 파일 하나씩 꺼내기
			let file=files[i];  //대상파일에 넣어주기 위해 꺼냄 
			
			//app1.imgList 배열에 존재하지 않을 경우 (중복된 이미지가 없을 경우)
			//1보다 작다면 발견된게 없다는 뜻
			if(checkDuplicate(file.name) < 1){  
				let reader=new FileReader();  //파일 입력스트림 생성
				reader.onload=(e)=>{
					//console.log("이미지 읽기 완료", e.target.result);
					console.log("file 정보는 ", file);
					//console.log("src 정보는 ", e.target.result);  //바이너리 정보
					
					//app1.src.push(e.target.result);
					//console.log("app1.src[0]", app1.src[0]);
					
					//이미지 정보를 낱개로 관리하지 말고, 하나의 json으로 몰아서 마치 DTO 처럼 관리
					key++;  //key 값 먼저 증가시킴 , 1부터 시작됨
					let json=[];  //empty json
					
					//고유값 넣기, 추후 이미지 삭제 시 고유값 사용하기 위해
					json['key']=key;  //삭제할 때 사용
					json['name']=file.name;  //중복 이미지 체크 시 사용
					json['binary']=e.target.result;  //추후 img.src에 대입할 예정
					json['file']=file;  //파일 자체에 대한 모든 정보 (전송할 때 사용)
					
					console.log("key 값은", key);
					//console.log("i 값은", i);  
					
					//app1.imgList.push(file);  //위에 코드 대신에 사용 (file자체)
					app1.imgList.push(json);  //모든 정보가 다 들어있음
					
				}
				reader.readAsDataURL(file);  //(대상파일)
			}
		}
	}
	
		//갤러리 등록
		function regist(){
		//기존 html의 폼을 이용하여 전송할 경우, 제일 마지막에 일으킨 이벤트에 의해 
		//등록된 이미지들만 전송하므로, 누적된 이미지는 전송할 수 없다
		//해결책)  form을 대체하는  formData객체를 이용하여 개발자가 주도하여 
		//폼을 구성하여 전송하면 됨 html5  FormData + JQuery Ajax 사용이 쉽다
		
		let formData = new FormData();//비어 잇는 폼을 하나 생성
		
		//개발자가 직접 파라미터를 구성할 수 있다
		formData.append("title", $("input[name='title']").val());
		formData.append("writer", $("input[name='writer']").val());
		formData.append("content", $("textarea[name='content']").val());
		
		//파일 파라미터 채우기 (2개이상임)
		for(let i=0; i<app1.imgList.length;i++){
			let file = app1.imgList[i].file; //전송할 파일 끄집어내기 
			formData.append("photo", file);   //(변수명, file)
		}
		
		//ajax 비동기 전송
		$.ajax({
			url:"/gallery/regist", 
			type:"post",
			processData:false,  //title=test&writer=ddd 문자열화 방지
			contentType:false, //application/x-www 방지 ...
			data:formData, 
			success:function(result, status, xhr){
				alert(result);
			}
		});
	}
	
	$(function(){
		init();
		
		//이미지를 선택하면 
		$("input[name='photo']").change(function(){
			//files 배열은 readOnly로 조작이 불가능함
			preview(this.files);
		});
		
		//등록버튼 
		$("#bt_regist").click(function(){
			regist();
		});
	});
</script>
</head>
<body>
	<div class="container mt-3" id="app1">
		<div class="row">
			<div class="col">
				<form id="form1">
					<div class="form-group">
   						<input type="text" class="form-control" placeholder="Enter title" name="title">
 					</div>
 					<div class="form-group">
   						<input type="text" class="form-control" placeholder="Enter writer" name="writer">
 					</div>
 					<div class="form-group">
   						<textarea type="text" class="form-control" placeholder="Enter content" name="content"></textarea>
 					</div>
 					<div class="form-group">
   						<input type="file" class="form-control" name="photo" multiple="multiple">
 					</div>
 					<div class="form-group" id="previewArea">
   						<!-- template : 반복문에 관여하지만 디자인에는 관여하지 않음 
   								key 값은 내부적으로 사용하므로 key 값과 동일한 값을 추가해줌-->
   						<template v-for="json in imgList">
   							<imagebox :key="json.key" :src="json.binary" :idx="json.key" />
   						</template>
 					</div>
 					<div class="form-group">
   						<button type="button" class="btn btn-outline-success" id="bt_regist">등록</button>
   						<button type="button" class="btn btn-outline-success" id="bt_list">목록</button>
 					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
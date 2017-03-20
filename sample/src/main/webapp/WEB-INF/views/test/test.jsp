<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script>
	$(document).ready(function(){
		
		$('.uploadFile').on("change",function(){
			ext = $(this).val().split('.').pop().toLowerCase(); //확장자
		
			//배열에 추출한 확장자가 존재하는지 체크
			if($.inArray(ext, ['gif', 'png', 'jpg', 'jpeg']) == -1) {
				resetFormElement($(this)); //폼 초기화
				window.alert('이미지 파일이 아닙니다! (gif, png, jpg, jpeg 만 업로드 가능)');
			} else {
				file = $(this).prop("files")[0];
				blobURL = window.URL.createObjectURL(file);
				console.log(blobURL);
				$(this).siblings('.uploaded_img').removeClass('none_dp');
				$(this).siblings('.uploaded_img').find('img').attr("src", blobURL);
				$(this).siblings('.uploaded_img').slideDown(); //업로드한 이미지 미리보기 
			}
		});
		
		$('#splitImgSize').on("change", function(){
			var splitWd = $("#splitImgSize option:selected").attr("data-wd");
			var splitHt = $("#splitImgSize option:selected").attr("data-ht");
			
			console.log("splitWd : " + splitWd + "  splitHt : " + splitHt);
			
			if($(this).val() != 'none'){
				draw(splitWd, splitHt);
			} else {
				drawClear();
			}
		});
		
	});
	
	function drawClear(){
		var canvas = document.getElementById("CanvasExam"); // canvas DOM 객체 생성
		var context = canvas.getContext("2d"); // 컨텍스트 생성
		// 작업시작
		
		context.clearRect(0, 0, canvas.width, canvas.height);
	}
	
	function draw(splitWd, splitHt){
		var wd = $('#splitImg').width();
		var ht = $('#splitImg').height();
		
		console.log("wd : " + wd + "  ht : " + ht);
		
		var cntWd = wd / splitWd;
		var cntHt = wd / splitHt;
		
		var canvas = document.getElementById("CanvasExam"); // canvas DOM 객체 생성
		var context = canvas.getContext("2d"); // 컨텍스트 생성
		// 작업시작
		
		context.clearRect(0, 0, canvas.width, canvas.height);
		
		context.beginPath();
		for (var i = 1; i < cntWd; i++) {
			context.moveTo(splitWd * i ,0);
			context.lineTo(splitWd * i,540);
		}

		for (var i = 1; i < cntHt; i++) {
			context.moveTo(0 , splitHt * i);
			context.lineTo(960 , splitHt * i);
		}
		context.stroke();
		
	}
	
</script>
<body>
	<input type="file" id="thb_img_file" name="thb_img_file" class="uploadFile"/>
	<p class="uploaded_img none_dp" style="position: relative; width: 960px; height: 540px;">
		<img width="960" id="splitImg" height="540" src="" alt="원본 이미지" style="z-index: 10; position: absolute;"/>
		<canvas id="CanvasExam" width="960" height="540" style="padding: 0px; margin: 0px; z-index: 11; position: absolute;">캔버스를 지원하지 않을떄..... 폴백콘텐츠</canvas>
	</p>
	
<!-- 	1920 1080 -->
	<select id="splitImgSize">
		<option value="none">선택</option><!-- 38*43 -->
		<option value="" data-wd="50" data-ht="25">50X25</option><!-- 38*43 -->
		<option value="" data-wd="150" data-ht="75">150X75</option>
	</select>
</body>
</html>
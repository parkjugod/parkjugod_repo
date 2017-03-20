<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<script>
	function submitCrawling(){
		$('#crawlingForm').attr("action","/crawling.do").submit();		
		
	}
</script>
<body>
	
	<form id="crawlingForm">
		<input type="text" name="url" >
		<input type="button" value="전송" onclick="javascript:submitCrawling();">
	</form>
	
</body>
</html>
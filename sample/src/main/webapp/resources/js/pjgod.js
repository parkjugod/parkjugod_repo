/**
 *  pjgod.js ver1.0 
 */
$(function(){
		
	/** 세부 체크박스에 class 와 전체선택 체크박스의 id 를 같게 한다.
	 *  className, id = checkbox-confirm* 로 하면 된다.
	 */
	$("[class^='checkbox-confirm']").click(function(){
		if($(this).is(":checked")){
			var className = $(this).attr('class');
			var classSize = $("."+className).size();
			
			var chk = false;
			for(var i = 0; i < classSize; i++){
				if(!$('.'+className).eq(i).is(":checked")){
					chk = true;
				}
			}
			
			if(chk){
				$('#'+className).prop("checked", false);
			} else {
				$('#'+className).prop("checked", true);
			}
			
		} else {
			// none check
			var className = $(this).attr('class');
			$('#'+className).prop("checked", false);
		}
	});
	
	$("[id^='checkbox-confirm']").click(function(){
		var id = $(this).attr('id');
		if($(this).is(":checked")){
			$('.'+id).prop("checked",true);
		} else {
			$('.'+id).prop("checked",false);
		}
	});
});
function pageClick(k) {
	   $(k).parent().find("div").removeClass("active");
  	$(k).addClass("active");
  	$("#flTitle").text($(k).text());
  }


$(function(){
	$('.code0').on('click',function(){
		$(location).attr('href','../View/dr.jsp');
	})
})
$(function(){
	$('.code').on('click',function(){
		$(location).attr('href','../View/fj.jsp');
	})
})
$(function(){
	$('.code1').on('click',function(){
		$(location).attr('href','../View/kf.jsp');
	})
})
$(function(){
	$('.code2').on('click',function(){
		$(location).attr('href','../View/tj.jsp');
	})
})
$(function(){
	$('.code3').on('click',function(){
		$(location).attr('href','../View/yh.jsp');
	})
})
// $(function(){
// 	    $(".xs").toggle();
// })
// $(function(){
// 	$('.btn').on('click',function(){
// 		$(".xs").show(100);
// 	})
// })
$(function(){
	$('.active').on('click',function(){
		$(location).attr('href','../View/Login.jsp');
	})
})
$(function(){
	$('.active1').on('click',function(){
		$(location).attr('href','../View/BsLogin.jsp');
	})
})

$( document ).ready(function() {
	var pgurl = document.URL;	
	pgURLs = pgurl.split("?");
	
	$(".nav > li > a").each(function(){
		var hrefURLs = $(this).attr("href");
		var hrefURL = hrefURLs.split("?");      
		if(hrefURL[0].toLowerCase() == pgURLs[0].toLowerCase())
		{
			$(this).parent().addClass("active");
			$(this).removeClass("active");
		}
	})
	/*$(".row-10-col").each(function(){
		var $this = $(this);
  	var newheight = $(this).height();
	$(".row-10-col").css({'height':newheight});
});*/

/*var h1 = $(".row-10-col1").height();
$(".row-10-col1").css({'height':h1});
var h2 = $(".row-10-col2").height();
$(".row-10-col2").css({'height':h2});
var h3 = $(".row-10-col3").height();
$(".row-10-col3").css({'height':h3});
var h4 = $(".row-10-col4").height();
$(".row-10-col4").css({'height':h4});
var h5 = $(".row-10-col5").height();
$(".row-10-col5").css({'height':h5});
var h6 = $(".row-10-col6").height();
$(".row-10-col6").css({'height':h6});
var h7 = $(".row-10-col7").height();
$(".row-10-col7").css({'height':h7});
var h8 = $(".row-10-col8").height();
$(".row-10-col8").css({'height':h8});
var h9 = $(".row-10-col9").height();
$(".row-10-col9").css({'height':h9});
var h10 = $(".row-10-col10").height();
$(".row-10-col10").css({'height':h10});
var h11 = $(".row-10-col11").height();
$(".row-10-col11").css({'height':h11});
var h12 = $(".row-10-col12").height();
$(".row-10-col12").css({'height':h12});
var h13 = $(".row-10-col13").height();
$(".row-10-col14").css({'height':h14});
var h15 = $(".row-10-col15").height();
$(".row-10-col15").css({'height':h15});
var h16 = $(".row-10-col16").height();
$(".row-10-col16").css({'height':h16});
*/
	
	$('ul.nav li.dropdown').hover(function() {
  $(this).find('.dropdown-menu').stop(true, true).delay(200).fadeIn(500);
}, function() {
  $(this).find('.dropdown-menu').stop(true, true).delay(200).fadeOut(500);
});
	$(window).scroll(function () {
			if($(this).scrollTop() > '50')
				{
					$(".header").addClass("header-fix");
					$(".heade-2").addClass("header-fix-2");
					$('.go-to-top').fadeIn();
				} else {
					$(".header").removeClass("header-fix");
					$(".heade-2").removeClass("header-fix-2");
					$('.go-to-top').fadeOut();
				}
				
				
				if($(this).scrollTop() > '200')
				{
					$('.sidebar').show();
				} else {
					$('.sidebar').hide();
				}
				
				
		});
	$('.go-to-top').click(function(){
    $("html, body").animate({ scrollTop: 0 }, 600);
    return false;
 });
 
 $(".navbar-brand").click(function() {
    $('html, body').animate({
        scrollTop: $("#section7").offset().top
    }, 2000);
});
 
 $('.mobile-tab').click(function(){
	 $(".sideview > nav").slideToggle();
	 });
	 
	 if($(window).width() < 991){
		 $('.sideview > nav').click(function(){
	 $(".sideview > nav").slideToggle();
	 });
		 }
		 
	$(".row-4-thumb").click(function(){
        $(this).next(".row-4-thumb-en").slideToggle();
		$(this).toggleClass("row-4-thumb-bg");
		$(this).children(".row-4-thumb-nav").toggleClass("row-4-thumb-nav-top");
    });
	$(".slide-2-sec-n").click(function(){
		$(this).toggleClass("slide-2-sec-n-col");
        $(this).next(".slide-2-sec-nn").slideToggle();
    });
	$('.dropdown-menu-2 > li > a').click(function(){
		$(".col-dropdown").removeClass("open");
		document.getElementById('btn-catagory').innerHTML=$(this).text();
		$(".option-set > li:first-child").show();
		
		if($(this).text() == "All Categories"){
			$(".option-set > li:first-child").hide();
			}
	});
	
	
	$('.popper').popover({
    container: 'body',
    html: true,
    content: function () {
        return $(this).next('.popper-content').html();
    }
});

var frame_src = "";
	$('.play-video').on('click', function(ev) {
		frame_src = $(this).data("index");
		$("#video")[0].src = frame_src + "?autoplay=1&rel=0&iv_load_policy=3";
		ev.preventDefault();
  });
  
  $('.close,.modal').click(function(){
	$("#video")[0].src= frame_src;
    });

});
var getUrlParameter = function getUrlParameter(sParam) 
    {
          var sPageURL = decodeURIComponent(window.location.search.substring(1)),
          sURLVariables = sPageURL.split('&'),
          sParameterName,
          i;
      
        for (i = 0; i < sURLVariables.length; i++) 
        {
          sParameterName = sURLVariables[i].split('=');
          if (sParameterName[0] === sParam) 
          {
            return sParameterName[1] === undefined ? true : sParameterName[1];
           }
        }
      };

     var id=getUrlParameter('id1');
     var id2=$("#"+id).next('div').attr('id');
     
    $("#"+id).removeClass('collapsed');
    $("#"+id2).addClass('in');
		$('html,body').animate({
        scrollTop: $("#"+id).offset().top -80},
        'slow');

    /*$('html, body').animate({
        scrollTop: $("#"+id).parent('div').offset().top
      },'fast');*/

     /*var elementoffset=$("#"+id).offset().top,
     new_height=(elementoffset-80);
     $(document).scrollTop(new_height);*/

$(function () {
  $('[data-toggle="popover"]').popover()
})
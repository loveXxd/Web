
var cangolet1=false;
var cangolet2=false;

{	
let mycanvasdr = document.getElementById("xu1");
  let xx = mycanvasdr.getContext("2d");
  xx.fillStyle="#666666";
   xx.strokeStyle = "black";
   xx.lineWidth = 3;
 //   xx.fillStyle="#ff00ff";
	// xx.fillRect(0,0,870,270);
  let flag = false;
 
   $("#xu1").on('touchstart', function (e) {
 	  //console.log(e);
 	  var _touch = e.originalEvent.targetTouches[0];
  	var mouseX = _touch.pageX - this.offsetLeft;//获得当前页面的x坐标
     var mouseY = _touch.pageY - this.offsetTop;//y
     flag = true;
     xx.moveTo(mouseX,mouseY);//起始位置
	 cangolet1=true;
     // /alert("aaaaa");
  });
  $("#xu1").on('touchmove', function (e) {
  		 var _touch = e.originalEvent.targetTouches[0];
  		var mouseX = _touch.pageX - this.offsetLeft;//获得当前页面的x坐标
  		var mouseY = _touch.pageY - this.offsetTop;//y
  	
  	    if(flag){
  	        xx.lineTo(mouseX,mouseY);//终止位置
  	        xx.stroke();//结束图形
  	    }
  });
  
  $("#xu1").on('touchend', function (e) {
  	 flag = false;
  });
	


  //当鼠标按下时
  $("#xu1").mousedown(function (e) {
	  //alert("111");
      let mouseX = e.pageX - this.offsetLeft;//获得当前页面的x坐标
      let mouseY = e.pageY - this.offsetTop;//y
      flag = true;
	   cangolet1=true;
	  var canvaspic = document.getElementById("xu1");
	  
	  // var context = canvaspic.getContext("2d"); 
	  // context.fillStyle = "#fff";   
	  // context.fillRect(0, 0, canvaspic.width, canvaspic.height);
      xx.moveTo(mouseX,mouseY);//起始位置


  });
  //当鼠标抬起时
  $("#xu1").mouseup(function (e) {
    flag = false;
  });
  //当鼠标移动时
  $("#xu1").mousemove(function (e) {
	 // console.log("111111111111");
      let mouseX = e.pageX - this.offsetLeft;//获得当前页面的x坐标
      let mouseY = e.pageY - this.offsetTop;//y

      if(flag){
          xx.lineTo(mouseX,mouseY);//终止位置
          xx.stroke();//结束图形
      }
  });
 }
  
  
  
  {
  let mycanvasdr = document.getElementById("xu2");
  let xx = mycanvasdr.getContext("2d");
  xx.fillStyle="#666666";
   
  xx.strokeStyle = "black";
  
   xx.lineWidth = 3;
   // xx.fillStyle="#ffff00";
   // 	xx.fillRect(0,0,300,100);
  let flag = false;
  
  
  
  //当鼠标按下时
  $("#xu2").mousedown(function (e) {
      let mouseX = e.pageX - this.offsetLeft;//获得当前页面的x坐标
      let mouseY = e.pageY - this.offsetTop;//y
      flag = true;
      xx.moveTo(mouseX,mouseY);//起始位置
	 cangolet2=true;
  
  });
  //当鼠标抬起时
  $("#xu2").mouseup(function (e) {
    flag = false;
  });
  //当鼠标移动时
  $("#xu2").mousemove(function (e) {
  		//console.log(e.pageX +"----"+ this.offsetLeft);
      let mouseX = e.pageX - this.offsetLeft;//获得当前页面的x坐标
      let mouseY = e.pageY - this.offsetTop;//y
  
      if(flag){
          xx.lineTo(mouseX,mouseY);//终止位置
          xx.stroke();//结束图形
      }
  });
  
   $("#xu2").on('touchstart', function (e) {
   	  //console.log(e);
   	  var _touch = e.originalEvent.targetTouches[0];
  	var mouseX = _touch.pageX - this.offsetLeft;//获得当前页面的x坐标
     var mouseY = _touch.pageY - this.offsetTop;//y
     flag = true;
     xx.moveTo(mouseX,mouseY);//起始位置
	  cangolet2=true;
     // /alert("aaaaa");
  });
  $("#xu2").on('touchmove', function (e) {
  		 var _touch = e.originalEvent.targetTouches[0];
  		var mouseX = _touch.pageX - this.offsetLeft;//获得当前页面的x坐标
  		var mouseY = _touch.pageY - this.offsetTop;//y
  	
  	    if(flag){
  	        xx.lineTo(mouseX,mouseY);//终止位置
  	        xx.stroke();//结束图形
  	    }
  });
  
  $("#xu2").on('touchend', function (e) {
  	 flag = false;
  });
  } 
  
  
 //    $("#xu1").on('touchstart', function (e) {
	// 	var mouseX = e.pageX - this.offsetLeft;//获得当前页面的x坐标
	//    var mouseY = e.pageY - this.offsetTop;//y
	//    flag = true;
	//    xx.moveTo(mouseX,mouseY);//起始位置
	//    alert("aaaaa");
	// });
	// $("#xu1").on('touchmove', function (e) {
	// 		console.log(e.pageX +"----"+ this.offsetLeft);
	// 	    var mouseX = e.pageX - this.offsetLeft;//获得当前页面的x坐标
	// 	    var mouseY = e.pageY - this.offsetTop;//y
	// 	
	// 	    if(flag){
	// 	        xx.lineTo(mouseX,mouseY);//终止位置
	// 	        xx.stroke();//结束图形
	// 	    }
	// });
	// 
	// $("#xu1").on('touchend', function (e) {
	// 	 flag = false;
	// });
  
  // //当鼠标按下时
  // $("#xu1").touchstart(function (e) {
  //     var mouseX = e.pageX - this.offsetLeft;//获得当前页面的x坐标
  //     var mouseY = e.pageY - this.offsetTop;//y
  //     flag = true;
  //     xx.moveTo(mouseX,mouseY);//起始位置
  // 
  // 
  // });
  // //当鼠标抬起时
  // $("#xu1").touchend(function (e) {
  //   flag = false;
  // });
  // //当鼠标移动时
  // $("#xu1").touchmove(function (e) {
  // 		console.log(e.pageX +"----"+ this.offsetLeft);
  //     var mouseX = e.pageX - this.offsetLeft;//获得当前页面的x坐标
  //     var mouseY = e.pageY - this.offsetTop;//y
  // 
  //     if(flag){
  //         xx.lineTo(mouseX,mouseY);//终止位置
  //         xx.stroke();//结束图形
  //     }
  // });
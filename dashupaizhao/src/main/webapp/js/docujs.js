var allbtncl=document.getElementsByClassName("chbtncl");
var contca;
var contcahas=false;
var nameca;
var namecahas=false;
var headca;
var num=0;
var canbtn=true;
var haspic=false;
for(var alb=0;alb<allbtncl.length;alb++){
	allbtncl[alb].addEventListener("mousedown",function(){
		var oldbtnbg=this.style.background;
		var newbtnbg=oldbtnbg.replace("1.","2.");
		this.style.background=newbtnbg;
		
	})
	allbtncl[alb].addEventListener("mouseup",function(){
		var oldbtnbg=this.style.background;
		var newbtnbg=oldbtnbg.replace("2.","1.");
		this.style.background=newbtnbg;
	})
}
/**
  * 将图片压缩后返回base64格式的数据
  * @param {*} image img元素
  * @param {*} width 压缩后图片宽度
  * @param {*} height 压缩后图片高度
  * @param {*} qua //图片质量1-100
  */
 function compressImageTobase64(caid, qua){
     var quality = qua ? qua/100 : 0.8;  
	var canvaspic = document.getElementById(caid);
     var data = canvaspic.toDataURL("image/png", quality); 
     return data;
 }

document.getElementById("flushnameandcon").addEventListener("click",function(){
	if(!canbtn){return;}
	window.location.href=window.location;
})
document.getElementById("uploadnameandcon").addEventListener("click",function(){
	if(!canbtn){return;}
	//if(!canbtn||!cangolet1||!cangolet2){return;}
	
	 contca=compressImageTobase64("xu1",10);
	// var img1=document.getElementById("1");
	// img1.src=contca;
	// img1.style.width="75px";
	// img1.style.height="75px";
	
	nameca=compressImageTobase64("xu2",10);
	// var img2=document.getElementById("2");
	// img2.src=nameca;
	 document.getElementById("selfcont").style.display="block";
})

document.getElementById("usedefpic").addEventListener("click",function(){
	if(!canbtn){return;}
	//draw1();
	headca="defaultimg";
	document.getElementById("xu11").src=document.getElementById("defuimg").src;
	document.getElementById("xu11").style.visibility="visible";
	document.getElementById("selfcont").style.display="none";
	lastfun();
	document.getElementById("caout").style.webkitAnimationName = 'clockwiseSpin';
	canbtn=false;
	setTimeout(function(){
		window.location.href=window.location;
		//document.getElementById("caout").style.webkitAnimationName=""
	},10000)
	
})
document.getElementById("close1").addEventListener("click",function(){
	if(!canbtn){return;}
	headca="";
	document.getElementById("xu11").style.visibility="hidden";
	document.getElementById("selfcont").style.display="none";
})
document.getElementById("close2").addEventListener("click",function(){
	if(!canbtn){return;}
	headca="";
	document.getElementById("xu11").style.visibility="hidden";
	document.getElementById("selfpic").style.display="none";
})


document.getElementById("topic").addEventListener("click",function(){
	if(!canbtn){return;}
	//draw1();
	document.getElementById("selfcont").style.display="none";
	document.getElementById("selfpic").style.display="block";
})



document.getElementById("flushpic").addEventListener("click",function(){
	if(!canbtn){return;}
	// /haspic=false;
	document.getElementById("myvideo").style.display="block";
	document.getElementById("mycanvas").style.display="none";
})
var hascur=false;
    //访问用户媒体设备的兼容方法
    function getUserMedia(constraints, success, error) {
      if (navigator.mediaDevices.getUserMedia) {
        //最新的标准API
        navigator.mediaDevices.getUserMedia(constraints).then(success).catch(error);
      } else if (navigator.webkitGetUserMedia) {
        //webkit核心浏览器
        navigator.webkitGetUserMedia(constraints,success, error)
      } else if (navigator.mozGetUserMedia) {
        //firfox浏览器
        navigator.mozGetUserMedia(constraints, success, error);
      } else if (navigator.getUserMedia) {
        //旧版API
        navigator.getUserMedia(constraints, success, error);
      }
    }
 
    let video = document.getElementById('myvideo');
    let canvaspic = document.getElementById('mycanvas');
    let context = canvaspic.getContext('2d');
 
    function success(stream) {
      //兼容webkit核心浏览器
      let CompatibleURL = window.URL || window.webkitURL;
      //将视频流设置为video元素的源
      //console.log(stream);
 
      //video.src = CompatibleURL.createObjectURL(stream);
      video.srcObject = stream;
      video.play();
    }
 
    function error(error) {
      console.log(`访问用户媒体设备失败${error.name}, ${error.message}`);
    }
 
    if (navigator.mediaDevices.getUserMedia || navigator.getUserMedia || navigator.webkitGetUserMedia || navigator.mozGetUserMedia) {
      //调用用户媒体设备, 访问摄像头
      getUserMedia({video : {width: 750, height: 500}}, success, error);
    } else {
      alert('不支持访问用户媒体');
    }
document.getElementById("picbtn").addEventListener("click",function(){
	if(!canbtn){return;}
		hascur=true;
		//haspic=true;
	context.drawImage(video, 0, 0, 750, 500); 
	//headca=document.getElementById("lastshow").getContext('2d').drawImage(video, 0, 0, 75, 50);
	document.getElementById("mycanvas").style.display="block";
	document.getElementById("myvideo").style.display="none";
	
	
})
document.getElementById("uploadpic").addEventListener("click",function(){
	if(!canbtn){return;}
	
	// if(!haspic){
	// 	context.drawImage(video, 0, 0, 750, 500); 
	// 	//headca=document.getElementById("lastshow").getContext('2d').drawImage(video, 0, 0, 75, 50);
	// 	document.getElementById("mycanvas").style.display="block";
	// 	document.getElementById("myvideo").style.display="none";
	// }
	var picsrc=compressImageTobase64("mycanvas",10);;
	headca=picsrc;
	console.log(headca.length);
	document.getElementById("xu11").src=picsrc;
	document.getElementById("xu11").style.visibility="visible";
	document.getElementById("selfpic").style.display="none";
	document.getElementById("caout").style.webkitAnimationName = 'clockwiseSpin';
	lastfun();
	canbtn=false;
	setTimeout(function(){
		window.location.href=window.location;
		//document.getElementById("caout").style.webkitAnimationName=""
	},10000)
})
function lastfun(){
	
	var socketMsg = {msg:contca,type:"1",imgMsg:headca,name:nameca};
	// var img=document.createElement("img");
	// img.style.width="100px";
	// img.src=contca;
	// var cs=document.createElement("canvas");
	// cs.style.position="absolute";
	// cs.style.top="10%";
	// cs.width="100";
	// cs.height="50";
	// var context = cs.getContext('2d');
	// context.drawImage(img,0,0);
	// document.getElementsByTagName("body")[0].appendChild(cs);
	//var socketMsg = {msg:"contca",type:"1",imgMsg:"contca",name:nameca};
	//console.log(socketMsg);
	 $.ajax({
	     url:"/getfileimg",
	     type: 'post',
		dataType: "json",
	     data: socketMsg,
	     success:function(r){
				 send(socketMsg);
	     },
	     error:function(r){  
	     }
	});
	num++;
}

function draw1(){
	var img2=document.getElementById("0");
	document.getElementById("lastshow").getContext('2d').drawImage(img2, 0, 0, 200, 100);
	var img2=document.getElementById("1");
	document.getElementById("lastshow").getContext('2d').drawImage(img2, 38, 20, 130, 39);
	var img2=document.getElementById("2");
	document.getElementById("lastshow").getContext('2d').drawImage(img2, 82, 71, 36, 11);
	var img2=document.getElementById("xu11");
	document.getElementById("lastshow").getContext('2d').drawImage(img2, 82, 71, 36, 11);
}
/* Define the number of leaves to be used in the animation */  
const NUMBER_OF_LEAVES = 4;   
 
 const allcont=[
		[
			{"outid":"out00","selfid":"co00","selfname":"","nameid":"name00","selfimgid":"img00","top":"10","left":"30","shuyeimg":"images/dashuye.png","touimg":"images/5.png","con":"你是不是傻瓜","qipaoimg":"images/daqipao.png","hasshow":false},
			{"outid":"out01","selfid":"co01","selfname":"","nameid":"name01","selfimgid":"img01","top":"20","left":"58","shuyeimg":"images/dashuye.png","touimg":"images/5.png","con":"你是不是傻瓜","qipaoimg":"images/daqipao.png","hasshow":false},
			{"outid":"out02","selfid":"co02","selfname":"","nameid":"name02","selfimgid":"img02","top":"30","left":"83","shuyeimg":"images/dashuye.png","touimg":"images/5.png","con":"你是不是傻瓜","qipaoimg":"images/daqipao.png","hasshow":false},
			{"outid":"out03","selfid":"co03","selfname":"","nameid":"name03","selfimgid":"img03","top":"34","left":"74","shuyeimg":"images/dashuye.png","touimg":"images/5.png","con":"你是不是傻瓜","qipaoimg":"images/daqipao.png","hasshow":false},
			{"outid":"out04","selfid":"co04","selfname":"","nameid":"name04","selfimgid":"img04","top":"40","left":"85","shuyeimg":"images/dashuye.png","touimg":"images/5.png","con":"你是不是傻瓜","qipaoimg":"images/daqipao.png","hasshow":false}],       
		[   {"outid":"out10","selfid":"co10","selfname":"","nameid":"name10","selfimgid":"img10","top":"50","left":"20","shuyeimg":"images/dashuye.png","touimg":"images/5.png","con":"你是不是傻瓜","qipaoimg":"images/daqipao.png","hasshow":false},
			{"outid":"out11","selfid":"co11","selfname":"","nameid":"name11","selfimgid":"img11","top":"4","left":"48","shuyeimg":"images/dashuye.png","touimg":"images/5.png","con":"你是不是傻瓜","qipaoimg":"images/daqipao.png","hasshow":false},
			{"outid":"out12","selfid":"co12","selfname":"","nameid":"name12","selfimgid":"img12","top":"33","left":"23","shuyeimg":"images/dashuye.png","touimg":"images/5.png","con":"你是不是傻瓜","qipaoimg":"images/daqipao.png","hasshow":false},
			{"outid":"out13","selfid":"co13","selfname":"","nameid":"name13","selfimgid":"img13","top":"50","left":"69","shuyeimg":"images/dashuye.png","touimg":"images/5.png","con":"你是不是傻瓜","qipaoimg":"images/daqipao.png","hasshow":false},
			{"outid":"out14","selfid":"co14","selfname":"","nameid":"name14","selfimgid":"img14","top":"9","left":"56","shuyeimg":"images/dashuye.png","touimg":"images/5.png","con":"你是不是傻瓜","qipaoimg":"images/daqipao.png","hasshow":false}],       
		[   {"outid":"out20","selfid":"co20","selfname":"","nameid":"name20","selfimgid":"img20","top":"40","left":"13","shuyeimg":"images/dashuye.png","touimg":"images/5.png","con":"你是不是傻瓜","qipaoimg":"images/daqipao.png","hasshow":false},
			{"outid":"out21","selfid":"co21","selfname":"","nameid":"name21","selfimgid":"img21","top":"10","left":"70","shuyeimg":"images/dashuye.png","touimg":"images/5.png","con":"你是不是傻瓜","qipaoimg":"images/daqipao.png","hasshow":false},
			{"outid":"out22","selfid":"co22","selfname":"","nameid":"name22","selfimgid":"img22","top":"30","left":"43","shuyeimg":"images/dashuye.png","touimg":"images/5.png","con":"你是不是傻瓜","qipaoimg":"images/daqipao.png","hasshow":false},
			{"outid":"out23","selfid":"co23","selfname":"","nameid":"name23","selfimgid":"img23","top":"17","left":"40","shuyeimg":"images/dashuye.png","touimg":"images/5.png","con":"你是不是傻瓜","qipaoimg":"images/daqipao.png","hasshow":false},
			{"outid":"out24","selfid":"co24","selfname":"","nameid":"name24","selfimgid":"img24","top":"19","left":"47","shuyeimg":"images/dashuye.png","touimg":"images/5.png","con":"你是不是傻瓜","qipaoimg":"images/daqipao.png","hasshow":false}],       
		[   {"outid":"out30","selfid":"co30","selfname":"","nameid":"name30","selfimgid":"img30","top":"20","left":"75","shuyeimg":"images/dashuye.png","touimg":"images/5.png","con":"你是不是傻瓜","qipaoimg":"images/daqipao.png","hasshow":false},
			{"outid":"out31","selfid":"co31","selfname":"","nameid":"name31","selfimgid":"img31","top":"40","left":"35","shuyeimg":"images/dashuye.png","touimg":"images/5.png","con":"你是不是傻瓜","qipaoimg":"images/daqipao.png","hasshow":false},
			{"outid":"out32","selfid":"co32","selfname":"","nameid":"name32","selfimgid":"img32","top":"30","left":"63","shuyeimg":"images/dashuye.png","touimg":"images/5.png","con":"你是不是傻瓜","qipaoimg":"images/daqipao.png","hasshow":false},
			{"outid":"out33","selfid":"co33","selfname":"","nameid":"name33","selfimgid":"img33","top":"20","left":"19","shuyeimg":"images/dashuye.png","touimg":"images/5.png","con":"你是不是傻瓜","qipaoimg":"images/daqipao.png","hasshow":false},
			{"outid":"out34","selfid":"co34","selfname":"","nameid":"name34","selfimgid":"img34","top":"23","left":"32","shuyeimg":"images/dashuye.png","touimg":"images/5.png","con":"你是不是傻瓜","qipaoimg":"images/daqipao.png","hasshow":false}]
	 ];
 
  
/*   
    Called when the "Falling Leaves" page is completely loaded.  
*/  
function init()   
{   
    /* Get a reference to the element that will contain the leaves */  
    var container = document.getElementById('leafContainer');   
    /* Fill the empty container with new leaves */  
    for (var i = 0; i < allcont.length; i++)    
    {   
		for(var j = 0; j < allcont[i].length; j++){
			container.append(createALeaf(i,j));
		}
           
		
    }
	  // document.getElementById('leafContainer').innerHTML("<div>111111111111111111111111</div>");
}   
  
/*  
    Receives the lowest and highest values of a range and  
    returns a random integer that falls within that range.  
*/  
function randomInteger(low, high)   
{   
    return low + Math.floor(Math.random() * (high - low));   
}   
  
/*  
   Receives the lowest and highest values of a range and  
   returns a random float that falls within that range.  
*/  
function randomFloat(low, high)   
{   
    return low + Math.random() * (high - low);   
}   
  
/*  
    Receives a number and returns its CSS pixel value.  
*/  
function pixelValue(value)   
{   
    return value + '%';   
}   
  
/*  
    Returns a duration value for the falling animation.  
*/  
  
function durationValue(value)   
{   
    return value + 's';   
}   
  
/*  
    Uses an img element to create each leaf. "Leaves.css" implements two spin   
    animations for the leaves: clockwiseSpin and counterclockwiseSpinAndFlip. This  
    function determines which of these spin animations should be applied to each leaf.  
 
*/  
function createALeaf(i,j)   
{   
    /* Start by creating a wrapper div, and an empty img element */  
 //    var leafDiv = document.createElement('div');   
 //    var image = document.createElement('img');
	// var selfimgdiv = document.createElement('div'); 
	// var divCon = document.createElement('div'); 
	// selfimgdiv.style=""
	// divCon.innerText="111111111";
	// divCon.className="magscon";
	// divCon.id="conId"+i;
	// divCon.style.position="absolute";
 //    /* Randomly choose a leaf image and assign it to the newly created element */  
 //    //image.src = 'images/realLeaf' + randomInteger(1, 5) + '.png';   
	// image.src='images/shuye.png'
 //    leafDiv.style.top = "-100px";  
	// leafDiv.className="mags" ;
 //  
 //    /* Position the leaf at a random location along the screen */  
 //    //leafDiv.style.left = pixelValue(randomInteger(0, 3000));   
	// leafDiv.style.left = pixelValue(allcont[i].left);  
	// leafDiv.style.top = pixelValue(allcont[i].top); 
  
    /* Randomly choose a spin animation */  
    //var spinAnimationName = (Math.random() < 0.5) ? 'clockwiseSpin' : 'counterclockwiseSpinAndFlip';   
  
    /* Set the -webkit-animation-name property with these values */  
    //leafDiv.style.webkitAnimationName = 'fade, drop';   
    //image.style.webkitAnimationName = spinAnimationName;   
	//divCon.style.webkitAnimationName = spinAnimationName; 
    /* Figure out a random duration for the fade and drop animations */  
    //var fadeAndDropDuration = durationValue(randomFloat(5, 11));   
  
    /* Figure out another random duration for the spin animation */  
   // var spinDuration = durationValue(randomFloat(4, 8));   
    /* Set the -webkit-animation-duration property with these values */  
    //leafDiv.style.webkitAnimationDuration = fadeAndDropDuration + ', ' + fadeAndDropDuration;   
  
   // var leafDelay = durationValue(randomFloat(0, 5));   
    //leafDiv.style.webkitAnimationDelay = leafDelay + ', ' + leafDelay;   
  
    //image.style.webkitAnimationDuration = spinDuration;   
	//divCon.style.webkitAnimationDuration = spinDuration;   
    // add the <img> to the <div>   
    //leafDiv.appendChild(image);  
	//leafDiv.appendChild(divCon);
	//{"left":"30","top":"10","shuyeimg":"images/dashuye.png","touimg":"images/5.png","con":"","qipaoimg":"images/daqipao.png",}
	var div1=document.createElement("div");
	div1.id=allcont[i][j].outid;
	div1.style="width:  5%;height:10%;position: absolute;top:"+allcont[i][j].top +"% ;left: "+allcont[i][j].left+"%;";
	var div1_1=document.createElement("div");
	div1_1.classList.add("shuyeout");
	var div1_1_1=document.createElement("img");
	div1_1_1.style="width: 100%;height: 50%;";
	div1_1_1.src=allcont[i][j].shuyeimg;
	div1_1.appendChild(div1_1_1);
	var div1_1_2=document.createElement("img");
	div1_1_2.style="width: 57%;height: 52%;border-radius: 50%;position: absolute;top: 25%;left: 25%;";
	div1_1_2.classList.add("touxiang");
	div1_1.id=allcont[i][j].selfimgid;
	div1_1_2.src=allcont[i][j].touimg;
	div1_1.appendChild(div1_1_2);
	div1.appendChild(div1_1);
	
	
	
	var div1_2=document.createElement("div");
	// background: url("+allcont[i][j].qipaoimg+") no-repeat;/
	div1_2.classList.add("contout");
	div1_2.style=" height: 50%;width: 100%;position: relative;";
	var div1_2_1=document.createElement("img");
	div1_2_1.src=allcont[i][j].qipaoimg;
	div1_2_1.style="width: 100%;height: 100%;-webkit-transform: rotate(180deg);";
	var div1_2_2=document.createElement("div");
	div1_2_2.style="white-space:normal;position: absolute;top: 0;left: 0;height:75%; margin-top: 25%; width: 100%; overflow:hidden;text-overflow:ellipsis;"
	div1_2_2.innerText=allcont[i][j].con;
	div1_2_2.classList.add("conttxt");
	div1_2.id=allcont[i][j].selfid;
	div1_2.appendChild(div1_2_1);
	div1_2.appendChild(div1_2_2);
	div1.appendChild(div1_2);
	//div1.style.webkitAnimationName = 'fade, drop';
	 var spinAnimationName = (Math.random() < 0.5) ? 'clockwiseSpin' : 'counterclockwiseSpinAndFlip'; 
	div1_1.style.webkitAnimationName = spinAnimationName;
	// var fadeAndDropDuration = durationValue(randomFloat(1, 5));
	// div1_1.style.webkitAnimationDuration = fadeAndDropDuration + ', ' + fadeAndDropDuration;   
	// var leafDelay = durationValue(randomFloat(0, 1));   
	// div1_1.style.webkitAnimationDelay = leafDelay + ', ' + leafDelay; 
	var spinDuration = durationValue(randomFloat(4, 8));
	div1_1.style.webkitAnimationDuration = spinDuration; 
	
	
	
	
	
	//leafDiv.appendChild(selfimgdiv);
	// <div class="outcont" style="width:  5%;height:10%;background: red;position: relative;top: 10%;left: 20%;">
	// 		  <div id="anomadiv">
	// 		  	<img src="images/shuye.png" style="width: 100%;height: 50%;" >
	// 			<img src="images/5.png" style="width: 50%;height: 25%;border-radius: 50%;position: absolute;top: 12%;left: 25%;" >
	// 		  </div>
	// 		  <div id="condiv" style="background: url(images/qipao.png) no-repeat; height: 50%;width: 100%;position: relative;">
	// 			  <img src="images/qipao.png" style="width: 100%;height: 100%;-webkit-transform: rotate(180deg);">
	// 			  <div style="position: absolute;top: 0;left: 0;width: 100%; overflow:hidden;text-overflow:ellipsis;white-space:nowrap;">你是不是筛子啊你个二货加沙华</div>
	// 		  </div>
	// </div>
  
    /* Return this img element so it can be added to the document */ 
	 // "<div class='outcont' style='width:  5%;height:10%;background: red;position: relative;top: "+allcont[i].top+";left:"+allcont[i].left+";'><div id='anomadiv'><img src='images/shuye.png' style='width: 100%;height: 50%;' ><img src='images/5.png' style='width: 50%;height: 25%;border-radius: 50%;position: absolute;top: 12%;left: 25%;' ></div><div id='condiv' style='background: url(images/qipao.png) no-repeat; height: 50%;width: 100%;position: relative;'><img src='images/qipao.png' style='width: 100%;height: 100%;-webkit-transform: rotate(180deg);'><div style='position: absolute;top: 0;left: 0;width: 100%; overflow:hidden;text-overflow:ellipsis;white-space:nowrap;'>你是不是筛子啊你个二货加沙华</div> </div></div>"
    return div1;   
}   
  
/* Calls the init function when the "Falling Leaves" page is full loaded */  
window.addEventListener('load', init, false);
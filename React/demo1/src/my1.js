var myip=null;
				var cookie = function () {
					//expires参数是Date()实例
					var set = function (cookieName, cookieValue, expires, path, domain, secure) {
						var A = arguments;
						var H = arguments.length;
						var B = (2 < H) ? A[2].toGMTString() : "";
						var G = (3 < H) ? A[3] : "";
						var D = (4 < H) ? A[4] : "";
						var F = (5 < H) ? A[5] : false;
						document.cookie = cookieName + "=" + escape(cookieValue) + ";expires =" + B + ";path = " + G + ";domain =" + D + ((F == true) ? ";secure" : " ")
					}
					//cname:cookie名称，itemName:该cookie中某一项名称
					var get = function (cname, itemName) {
						var A = document.cookie.match(new RegExp("(^| )" + cname + "=([^;]*)(;|$)"));
						if (A) {
							if (itemName) {
								A = A[2].match(new RegExp("(?:^|&)" + itemName + "=([^&]*)(?:&|$)"))
								return A ? A[1] : "";
							}
							else {
								return A[2];
							}
						}
						else {
							return "";
						}
					}
					return {
						set: set,
						get: get
					}
				}();
				 //document.getElementById(`您的ip是${returnCitySN.cip}您的所在地是${returnCitySN.cname}`)
				 // 存储
				//sessionStorage.setItem("lastname", "Smith");
				//var myipcan=cookie.get("quanjingip",false);
				
				// 检索
				

				 
				 
				 function dianzanfun(){
					getYourIP();
					addnum();
									
				}
				 function getYourIP(){
						document.getElementById("iconid").style.backgroundPosition="-80px -815px";
						document.getElementById("dianzan").removeEventListener("click",dianzanfun,false);
						cookie.set("quanjingip", "false", new Date(Date.parse('2099-1-1')));
						var num=document.getElementById("diannum").innerHTML;
						document.getElementById("diannum").innerHTML=parseInt(num)+1;
						var RTCPeerConnection = window.RTCPeerConnection || window.webkitRTCPeerConnection || window.mozRTCPeerConnection;
						if (RTCPeerConnection) (function () {
							var rtc = new RTCPeerConnection({iceServers:[]});
							if (1 || window.mozRTCPeerConnection) {     
								rtc.createDataChannel('', {reliable:false});
							};
							
							rtc.onicecandidate = function (evt) {
								if (evt.candidate) grepSDP("a="+evt.candidate.candidate);
							};
							rtc.createOffer(function (offerDesc) {
								grepSDP(offerDesc.sdp);
								rtc.setLocalDescription(offerDesc);
							}, function (e) { console.warn("offer failed", e); });
							
							
							var addrs = Object.create(null);
							addrs["0.0.0.0"] = false;
							function updateDisplay(newAddr) {
								if (newAddr in addrs) return;
								else addrs[newAddr] = true;
								var displayAddrs = Object.keys(addrs).filter(function (k) { return addrs[k]; });
								for(var i = 0; i < displayAddrs.length; i++){
									if(displayAddrs[i].length > 16){
										displayAddrs.splice(i, 1);
										i--;
									}
								}
								myip=displayAddrs[0];
								var data={"ip": myip};
								//data:JSON.stringify(data)
									$.ajax({
										 url:'wrideip',
										 type:'post',
										 dataType:"json",
										 //dataType:'text',
										 data:JSON.stringify(data),
										 success:function(data){
											// document.getElementById("iconid").style.backgroundPosition="-80px -815px";
											// document.getElementById("dianzan").removeEventListener("click",dianzanfun,false);
											// cookie.set("quanjingip", "false", new Date(Date.parse('2099-1-1')));
											// var num=document.getElementById("diannum").innerHTML;
											// document.getElementById("diannum").innerHTML=parseInt(num)+1;
										 },
										 error:function(error){
											 if(error.responseText=="you"){
												// document.getElementById("iconid").style.backgroundPosition="-80px -815px";
												// document.getElementById("dianzan").removeEventListener("click",dianzanfun,false);
												// cookie.set("quanjingip", "false", new Date(Date.parse('2099-1-1')));
												// var num=document.getElementById("diannum").innerHTML;
												// document.getElementById("diannum").innerHTML=parseInt(num)+1;
											 }
										 }
									
								});
							}
							
							function grepSDP(sdp) {
								var hosts = [];
								sdp.split('\r\n').forEach(function (line, index, arr) { 
								   if (~line.indexOf("a=candidate")) {    
										var parts = line.split(' '),       
											addr = parts[4],
											type = parts[7];
										if (type === 'host') updateDisplay(addr);
									} else if (~line.indexOf("c=")) {       
										var parts = line.split(' '),
											addr = parts[2];
										updateDisplay(addr);
									}
								});
							}
						})();
						else{
							//document.getElementById('list').textContent = "请使用主流浏览器：chrome,firefox,opera,safari";
						}
					}
				function iphas(){
					
						var RTCPeerConnection = window.RTCPeerConnection || window.webkitRTCPeerConnection || window.mozRTCPeerConnection;
						if (RTCPeerConnection) (function () {
							var rtc = new RTCPeerConnection({iceServers:[]});
							if (1 || window.mozRTCPeerConnection) {     
								rtc.createDataChannel('', {reliable:false});
							};
							
							rtc.onicecandidate = function (evt) {
								if (evt.candidate) grepSDP("a="+evt.candidate.candidate);
							};
							rtc.createOffer(function (offerDesc) {
								grepSDP(offerDesc.sdp);
								rtc.setLocalDescription(offerDesc);
							}, function (e) { console.warn("offer failed", e); });
							
							
							var addrs = Object.create(null);
							addrs["0.0.0.0"] = false;
							function updateDisplay(newAddr) {
								if (newAddr in addrs) return;
								else addrs[newAddr] = true;
								var displayAddrs = Object.keys(addrs).filter(function (k) { return addrs[k]; });
								for(var i = 0; i < displayAddrs.length; i++){
									if(displayAddrs[i].length > 16){
										displayAddrs.splice(i, 1);
										i--;
									}
								}
								myip=displayAddrs[0];
								var data={"ip": myip};
								//data:JSON.stringify(data)
									$.ajax({
										 url:'findip',
										 type:'post',
										 dataType:"json",
										 //dataType:'text',
										 data:JSON.stringify(data),
										 success:function(data){
											 if(data=="you"){
											 	document.getElementById("iconid").style.backgroundPosition="-80px -815px";
												 document.getElementById("dianzan").removeEventListener("click",dianzanfun,false);
												 cookie.set("quanjingip", "false", new Date(Date.parse('2099-1-1')));
											 }
										 },
										 error:function(error){
											 if(error.responseText=="you"){
												 cookie.set("quanjingip", "false", new Date(Date.parse('2099-1-1')));
												 document.getElementById("dianzan").removeEventListener("click",dianzanfun,false);
												document.getElementById("iconid").style.backgroundPosition="-80px -815px"; 
											 }
										 }
									
								});
							}
							
							function grepSDP(sdp) {
								var hosts = [];
								sdp.split('\r\n').forEach(function (line, index, arr) { 
								   if (~line.indexOf("a=candidate")) {    
										var parts = line.split(' '),       
											addr = parts[4],
											type = parts[7];
										if (type === 'host') updateDisplay(addr);
									} else if (~line.indexOf("c=")) {       
										var parts = line.split(' '),
											addr = parts[2];
										updateDisplay(addr);
									}
								});
							}
						})();
						else{
							//document.getElementById('list').textContent = "请使用主流浏览器：chrome,firefox,opera,safari";
						}
				}
				function getnum(){
					$.ajax({
							 url:'getdianzannum',
							 type:'post',
							 success:function(data){
								console.log(data);
								document.getElementById("diannum").innerHTML=data;
							 },
							 error:function(error){
								console.log("失败了");
							 }
						
					});
				}
				function addnum(){
					$.ajax({
							 url:'dianzannumAdd',
							 type:'post',
							 success:function(data){
								console.log(data);
								document.getElementById("diannum").innerHTML=data;
							 },
							 error:function(error){
								console.log("失败了");
							 }
						
					});
				}
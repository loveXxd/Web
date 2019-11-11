var websocket = null;
     function conectWebSocket(){
         //判断当前浏览器是否支持WebSocket
         if ('WebSocket'in window) {
            // websocket = new WebSocket("ws://localhost:5050/websocket");
             websocket = new WebSocket("ws:"+window.location.href.split("//")[1].split("/winpaizhao")[0]+"/websocket/"+"1"); 
         } else {
             alert('Not support websocket');
         }
         //连接发生错误的回调方法
         websocket.onerror = function() {
             setMessageInnerHTML("error");
         };
         //连接成功建立的回调方法
         websocket.onopen = function(event) {
             setMessageInnerHTML("Loc MSG: 成功建立连接");
         }
         //接收到消息的回调方法
         websocket.onmessage = function(event) {
             setMessageInnerHTML(event.data);
         }
         //连接关闭的回调方法
         websocket.onclose = function() {
             setMessageInnerHTML("Loc MSG:关闭连接");
         }
         //监听窗口关闭事件，当窗口关闭时，主动去关闭websocket连接，防止连接还没断开就关闭窗口，server端会抛异常。
         window.onbeforeunload = function() {
             websocket.close();
         }
     }
     //将消息显示在网页上
     function setMessageInnerHTML(innerHTML) {
		 console.log(innerHTML);
        // document.getElementById('message').innerHTML += innerHTML + '<br/>';
     }
     //关闭连接
     function closeWebSocket() {
         websocket.close();
     }
     //发送消息
     /*function send() {
         var message = document.getElementById('text').value;
         websocket.send(message);
     }*/
   //发送消息
   // var dats={
   //      'imgstr':back_data,
   //     'name':myname,
   //     'cont':mycont
   // 	};
     function send(dats) {
			// console.log(dats);
         //获取输入的文本信息进行发送
         
     //     if(toUser == ''){
     //         //群聊.
     //         socketMsg.type = 0;
     //     }else{
     //         //单聊.
     //         socketMsg.type = 1;
     //     }
         websocket.send(JSON.stringify(dats));
     }
	 conectWebSocket();
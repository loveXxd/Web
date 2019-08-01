package com.wqc.hand.hand.websocket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.html.HTMLDocument;
import java.io.IOException;
import java.util.Iterator;

/**
 * Created by nishuai on 2019/3/18.
 * 可以调用 webSocketServer，向所有客户端发送消息
 */
@Controller
@RequestMapping(value = "/screen")
public class APIController {

    @Autowired
    private WebSocketServer webSocketServer;

    @RequestMapping(value = "/change")
    @ResponseBody
    public String skip(HttpServletRequest request, HttpServletResponse response) throws IOException {

         //向所有客户端发送消息
        String message="该账号已登录，强制下线";
        WebSocketServer ws=new WebSocketServer();
        Iterator< WebSocketServer> iterator = webSocketServer.webSocketSet.iterator();
        while (iterator.hasNext()){
            ws=iterator.next();
            ws.sendMessage(message);
        }
        //webSocketServer.sendMessage(message);
        return "操作成功！";
    }


}

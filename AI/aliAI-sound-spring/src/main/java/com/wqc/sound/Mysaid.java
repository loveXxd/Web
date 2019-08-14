package com.wqc.sound;

import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;

public class Mysaid {
	
	public static String aaString="你是猪吗";
	public static void main(String[] args) {
		 ActiveXComponent xl = new ActiveXComponent("Excel.Application");
	        Dispatch xlo = (Dispatch)(xl.getObject());
	        try {
	             System.out.println("version="+xl.getProperty("Version"));
	             System.out.println("version="+Dispatch.get(xlo, "Version"));
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            xl.invoke("Quit", new Variant[] {});
	        }
		Mysaid.textToSpeechsiad(aaString);
	}
	 public static void textToSpeechsiad(String text) {
	        ActiveXComponent ax = null;
	        try {
	            ax = new ActiveXComponent("Excel.Application");

	            // 运行时输出语音内容
	            Dispatch spVoice = ax.getObject();
	            // 音量 0-100
	            ax.setProperty("Volume", new Variant(100));
	            // 语音朗读速度 -10 到 +10
	            ax.setProperty("Rate", new Variant(-2));
	            // 执行朗读
	            Dispatch.call(spVoice, "Speak", new Variant(text));

	            // 下面是构建文件流把生成语音文件

	            ax = new ActiveXComponent("Sapi.SpFileStream");
	            Dispatch spFileStream = ax.getObject();

	            ax = new ActiveXComponent("Sapi.SpAudioFormat");
	            Dispatch spAudioFormat = ax.getObject();

	            // 设置音频流格式
	            Dispatch.put(spAudioFormat, "Type", new Variant(22));
	            // 设置文件输出流格式
	            Dispatch.putRef(spFileStream, "Format", spAudioFormat);
	            // 调用输出 文件流打开方法，创建一个.wav文件
	            Dispatch.call(spFileStream, "Open", new Variant("./text.wav"), new Variant(3), new Variant(true));
	            // 设置声音对象的音频输出流为输出文件对象
	            Dispatch.putRef(spVoice, "AudioOutputStream", spFileStream);
	            // 设置音量 0到100
	            Dispatch.put(spVoice, "Volume", new Variant(100));
	            // 设置朗读速度
	            Dispatch.put(spVoice, "Rate", new Variant(-2));
	            // 开始朗读
	            Dispatch.call(spVoice, "Speak", new Variant(text));

	            // 关闭输出文件
	            Dispatch.call(spFileStream, "Close");
	            Dispatch.putRef(spVoice, "AudioOutputStream", null);

	            spAudioFormat.safeRelease();
	            spFileStream.safeRelease();
	            spVoice.safeRelease();
	            ax.safeRelease();

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	
}

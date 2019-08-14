package com.wqc.sound;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.TargetDataLine;
import javax.sound.sampled.UnsupportedAudioFileException;

import com.alibaba.nls.client.protocol.InputFormatEnum;
import com.alibaba.nls.client.protocol.NlsClient;
import com.alibaba.nls.client.protocol.SampleRateEnum;
import com.alibaba.nls.client.protocol.asr.SpeechRecognizer;
import com.alibaba.nls.client.protocol.asr.SpeechRecognizerListener;
import com.alibaba.nls.client.protocol.asr.SpeechRecognizerResponse;

public class MyAiSound {

	private MyAiSound demo = null;
    private String appKey = "J1wkir4w5Br6mqwC";
    private String token = "d41c70a70e534257b3beaa85160eed54";
    private String url = "wss://nls-gateway.cn-shanghai.aliyuncs.com/ws/v1";
    private NlsClient client;
    AudioFormat audioFormat;
    TargetDataLine targetDataLine;
    boolean flag = true;
   
    public  MyAiSound() {
	       
	   }
	public  MyAiSound(String appKey, String token) {
	       //创建NlsClient实例,应用全局创建一个即可,默认服务地址为阿里云线上服务地址
	       client = new NlsClient(token);
	   }
	
	   public  MyAiSound(String appKey, String token, String url) {
		   
	       //创建NlsClient实例,应用全局创建一个即可,用户指定服务地址
	       client = new NlsClient(url, token);
	   }





	// private String filePath = "E:\\1jAVE\\ECLIPSE\\obj\\nls-example-recognizer\\src\\main\\resources\\voice_cache.wav";
    //private File audioFile = new File(filePath);
	public static void main(String args[]) throws UnsupportedAudioFileException, IOException {
		MyAiSound myAiSound=new MyAiSound();
		myAiSound.startRecognize();
		 	
    }
				

	

	    

	 
	private void stopRecognize() {
	        flag = false;
	        targetDataLine.stop();
	        targetDataLine.close();
	    }private AudioFormat getAudioFormat() {
	        float sampleRate = 16000;
	        // 8000,11025,16000,22050,44100
	        int sampleSizeInBits = 16;
	        // 8,16
	        int channels = 1;
	        // 1,2
	        boolean signed = true;
	        // true,false
	        boolean bigEndian = false;
	        // true,false
	        return new AudioFormat(sampleRate, sampleSizeInBits, channels, signed, bigEndian);
	    }// end getAudioFormat


	    public void startRecognize() {
	        try {
	            // 获得指定的音频格式
	            audioFormat = getAudioFormat();
	            DataLine.Info dataLineInfo = new DataLine.Info(TargetDataLine.class, audioFormat);
	            targetDataLine = (TargetDataLine) AudioSystem.getLine(dataLineInfo);

	            // Create a thread to capture the microphone
	            // data into an audio file and start the
	            // thread running. It will run until the
	            // Stop button is clicked. This method
	            // will return after starting the thread.
	            
	            new CaptureThread().start();
	        } catch (Exception e) {
	            e.printStackTrace();
	        } // end catch
	    }// end captureAudio method

	    class CaptureThread extends Thread {
	        public void run() {
	        	while(true) {
	        		flag = true;
					AudioFileFormat.Type fileTypes = AudioFileFormat.Type.WAVE;
		            //fileTypes = AudioFileFormat.Type.WAVE;
		            //声音录入的权值
		            int weight = 2;
		            //判断是否停止的计数
		            int downSum = 0;
	
		            ByteArrayInputStream bais = null;
		            ByteArrayOutputStream baos = new ByteArrayOutputStream();
		            AudioInputStream ais = null;
		            try {
		                targetDataLine.open(audioFormat);
		                targetDataLine.start();
		                byte[] fragment = new byte[1024];
	
		                ais = new AudioInputStream(targetDataLine);
		                while (flag) {
	
		                    targetDataLine.read(fragment, 0, fragment.length);
		                    //当数组末位大于weight时开始存储字节（有声音传入），一旦开始不再需要判断末位
		                    if (Math.abs(fragment[fragment.length-1]) > weight || baos.size() > 0) {
		                        baos.write(fragment);
		                        System.out.println("守卫："+fragment[0]+",末尾："+fragment[fragment.length-1]+",lenght"+fragment.length);
		                        //判断语音是否停止
		                        if(Math.abs(fragment[fragment.length-1])<=weight){
		                            downSum++;
		                        }else{
		                            System.out.println("重置奇数");
		                            downSum=0;
		                        }//计数超过20说明此段时间没有声音传入(值也可更改)
		                        if(downSum>20){
		                            System.out.println("停止录入");
		                            break;
		                        }
	
		                    }
		                }
	
		                //取得录音输入流
		                audioFormat = getAudioFormat();
		                byte audioData[] = baos.toByteArray();
		                bais = new ByteArrayInputStream(audioData);
		                ais = new AudioInputStream(bais, audioFormat, audioData.length / audioFormat.getFrameSize());	               
		                demo = new MyAiSound(appKey, token, url);     			
	     	            demo.process(ais);
	     	            demo.shutdown();     	            
		                //定义最终保存的文件名
		                //System.out.println("开始生成语音文件");
	//	                AudioSystem.write(ais, AudioFileFormat.Type.WAVE, audioFile);
		                downSum = 0;
		                stopRecognize();
	
		            } catch (Exception e) {
		                e.printStackTrace();
		            } finally {
		                //关闭流
	
		                try {
		                    ais.close();
		                    bais.close();
		                    baos.reset();
		                } catch (IOException e) {
		                    e.printStackTrace();
		                }
		            }
	
		        }// end run
		    }
	    }// end inner class CaptureThread
	   

	    private static SpeechRecognizerListener getRecognizerListener() {
	        SpeechRecognizerListener listener = new SpeechRecognizerListener() {
	            //识别出中间结果.服务端识别出一个字或词时会返回此消息.仅当setEnableIntermediateResult(true)时,才会有此类消息返回
	            @Override
	            public void onRecognitionResultChanged(SpeechRecognizerResponse response) {
//	                //事件名称 RecognitionResultChanged
//	                System.out.println("nameChanged: " + response.getName() +
//	                    //状态码 20000000 表示识别成功
//	                    ", statusChanged: " + response.getStatus() +
//	                    //语音识别文本
//	                    ", resultChanged: " + response.getRecognizedText());
	            }

	            //识别完毕
				@Override
	            public void onRecognitionCompleted(SpeechRecognizerResponse response) {
	                //事件名称 RecognitionCompleted
	                System.out.println("nameCompleted: " + response.getName() +
	                    //状态码 20000000 表示识别成功
	                    ", statusCompleted: " + response.getStatus() +
	                    //语音识别文本
	                    ", resultCompleted: " + response.getRecognizedText());
	            	String string=response.getRecognizedText();
	            	AllAoder allAoder=new AllAoder();
	            	if (string.indexOf("关机")!=-1) {
						System.out.println("你确认要关机吗");
						
					}else if (string.indexOf("打开浏览器")!=-1) {
						allAoder.OpenGo();
//						String cmd= "C:\\Users\\Administrator\\AppData\\Local\\Google\\Chrome\\Application\\chrome.exe";
//						try {
//							Runtime.getRuntime().exec(cmd);
//						} catch (IOException e) {
//							// TODO Auto-generated catch block
//							e.printStackTrace();
//						}
					}else if (string.indexOf("关闭浏览器")!=-1) {
						try {
							Runtime.getRuntime().exec("taskkill /F /IM chrome.exe");
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
	            }

	            @Override
	            public void onStarted(SpeechRecognizerResponse response) {
	                System.out.println(
	                    "task_id: " + response.getTaskId());
	            }

	            @Override
	            public void onFail(SpeechRecognizerResponse response) {
	                System.out.println(
	                    "task_idonFail: " + response.getTaskId() +
	                        //状态码 20000000 表示识别成功
	                        ", statusonFail: " + response.getStatus() +
	                        //错误信息
	                        ", status_textonFail: " + response.getStatusText());

	            }
	        };
	        return listener;
	    }

	    public void process(InputStream ins) {
	        SpeechRecognizer recognizer = null;
	        try {
	            //创建实例,建立连接
	            recognizer = new SpeechRecognizer(client, getRecognizerListener());
	            recognizer.setAppKey(appKey);
	            //设置音频编码格式
	            recognizer.setFormat(InputFormatEnum.PCM);
	            //设置音频采样率
	            recognizer.setSampleRate(SampleRateEnum.SAMPLE_RATE_16K);
	            //设置是否返回中间识别结果
	            recognizer.setEnableIntermediateResult(true);

	            //此方法将以上参数设置序列化为json发送给服务端,并等待服务端确认
	            recognizer.start();
	            //语音数据来自声音文件用此方法,控制发送速率;若语音来自实时录音,不需控制发送速率直接调用 recognizer.sent(ins)即可
	            recognizer.send(ins, 3200, 100);
	            //通知服务端语音数据发送完毕,等待服务端处理完成
	            recognizer.stop();

	        } catch (Exception e) {
	            System.err.println(e.getMessage());
	        } finally {
	            //关闭连接
	            if (null != recognizer) {
	                recognizer.close();
	            }
	        }
	    }

	    public void shutdown() {
	        client.shutdown();
	    }

	   
}

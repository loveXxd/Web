package com.wqc.hand.hand.util;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 
 * @author Administrator
 *
 */
public class dianzan {
//	@RequestMapping("/dianzan")
//	@ResponseBody
//	public String dianzan() {
////		Map<String, Object>map=new HashMap<>();
////		map.put("msg", "helloword");
//		//writeFile();
//		return "创建成功";
//		//String aaString=readFile();
//		//return aaString;
//	}
//	@RequestMapping("/dianzan")
//	public String getnum(String filename) throws IOException {
//		//String numString= readFile();
//		writeFile();
//		return "点赞成功";
//	}
	public static String replaceBlank(String str) {
		String dest = "";
		if (str!=null) {
			Pattern p = Pattern.compile("\\s*|\t|\r|\n");
			Matcher m = p.matcher(str);
			dest = m.replaceAll("");
		}
		return dest;
	}
	
	 public static boolean readipFile(String ip) {
		 	boolean hasip= false;
		 	String root = System.getProperty("user.dir");
	     	String FileName="allip.txt";
	     	String filePath = root+File.separator+File.separator+FileName;
	     	//System.out.println(filePath);
	        try (FileReader reader = new FileReader(filePath);
	             BufferedReader br = new BufferedReader(reader) // 建立一个对象，它把文件内容转成计算机能读懂的语言
	        ) {
	            String line;
	            //网友推荐更加简洁的写法
	            while ((line = br.readLine()) != null) {
	                // 一次读入一行数据
	            	if (line.equals(ip)) {
	            		hasip=true;
	            		break;
					}
	            }
	            reader.close();
	            br.close();
	            return hasip;
	        } catch (IOException e) {
	            e.printStackTrace();
	            return hasip;
	        }
	    }
	 public static String readnumFile() {
		 	String hasip= "";
		 	String root = System.getProperty("user.dir");
	     	String FileName="num.txt";
	     	String filePath = root+File.separator+File.separator+FileName;
	     	//System.out.println(filePath);
	     	try (FileReader reader = new FileReader(filePath);
	             BufferedReader br = new BufferedReader(reader) // 建立一个对象，它把文件内容转成计算机能读懂的语言
	        ) {
	            String line;
	            //网友推荐更加简洁的写法
	            while ((line = br.readLine()) != null) {
	                // 一次读入一行数据
	               // System.out.println(line);
	            	hasip+=line;
	            	
	            	
	            }
	            reader.close();
	            br.close();
	            return hasip;
	        } catch (IOException e) {
	            e.printStackTrace();
	            return hasip;
	        }
	    }
	 public static void writenumFile(String numString) {
	        try {
	        	String root = System.getProperty("user.dir");
	        	String FileName="num.txt";
	        	String filePath = root+File.separator+File.separator+FileName;
	        	//System.out.println(filePath);
	            File writeName = new File(filePath); // 相对路径，如果没有则要建立一个新的output.txt文件
	            
	            writeName.createNewFile(); // 创建新文件,有同名的文件的话直接覆盖
	            try (FileWriter writer = new FileWriter(writeName);
	                 BufferedWriter out = new BufferedWriter(writer)
	            ) {
	                out.write(numString); // \r\n即为换行
	                out.flush(); // 把缓存区内容压入文件
	                out.close();
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	 }
	
	public static void addipwrite(String ipString) {                         
		 String root = System.getProperty("user.dir");
     	String FileName="allip.txt";
     	String filePath = root+File.separator+File.separator+FileName;
     	//System.out.println(filePath);
         File writeName = new File(filePath); // 相对路径，如果没有则要建立一个新的output.txt文件
         BufferedWriter out = null;                                                 
	        try {                                                                        
	             out = new BufferedWriter(new OutputStreamWriter(                        
	                    new FileOutputStream(filePath, true)));                              
	             out.write(ipString); 
	             
	             //+"\r\n"换行
	         } catch (Exception e) {                                                     
	             e.printStackTrace();                                                    
	         } finally {                                                                 
	            try {                                                                    
	                 out.close();                                                        
	             } catch (IOException e) {                                               
	                 e.printStackTrace();                                                
	             }                                                                       
	         }                                                                           
	     }  
	public static void addcontwrite(HttpServletRequest request) {                         
		 //String root = System.getProperty("user.dir");
		String FileName=Long.toString(System.currentTimeMillis());
    	//String FileName="allimg.txt";
    	String filePath = "D:\\allobj\\"+File.separator+File.separator+FileName;
    	//String filePath = root+File.separator+File.separator+FileName;
    	//System.out.println(filePath);
    	
        File writeName = new File(filePath); // 相对路径，如果没有则要建立一个新的output.txt文件
        //judeFileExists(writeName);
        BufferedWriter out = null;                                                 
	        try {                                                                        
	             out = new BufferedWriter(new OutputStreamWriter(                        
	                    new FileOutputStream(filePath, true)));
	             out.write(request.getParameter("name")+"\r\n"); 
	             out.write(request.getParameter("imgMsg")+"\r\n"); 
	             out.write(request.getParameter("msg")+"\r\n\r\n"); 
	             //+"\r\n"换行
	         } catch (Exception e) {                                                     
	             e.printStackTrace();                                                    
	         } finally {                                                                 
	            try {                                                                    
	                 out.close();                                                        
	             } catch (IOException e) {                                               
	                 e.printStackTrace();                                                
	             }                                                                       
	         }                                                                           
	     } 
	 public static void judeFileExists(File file) {
		  
//		          if (file.exists()) {
//		              System.out.println("file exists");
//		         } else {
//		              System.out.println("file not exists, create it ...");
//		              try {
//		                 file.createNewFile();
//		              } catch (IOException e) {
//		                  // TODO Auto-generated catch block
//		                  e.printStackTrace();
//		              }
//		          }
		  
		      }
}

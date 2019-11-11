package com.wqc.hand.hand.websocket;




import org.springframework.util.StringUtils;
 
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;
 
/**
 * @Author: JCccc
 * @CreateTime: 2018-10-30
 * @Description:
 */
public class SignUtils {
 
 
 
    public String getTimestamp() {
        //生成时间戳
 
        long timestampLong =System.currentTimeMillis();
 
        String timestampStr = String.valueOf(timestampLong);
 
        return timestampStr;
    }
 
 
 
    public String getNonceStr(int length){
 
        //生成随机字符串
 
        String str="zxcvbnmlkjhgfdsaqwertyuiopQWERTYUIOPASDFGHJKLZXCVBNM1234567890";
 
        Random random=new Random();
 
        StringBuffer randomStr=new StringBuffer();
 
        // 设置生成字符串的长度，用于循环
 
        for(int i=0; i<length; ++i){
            //从62个的数字或字母中选择
 
            int number=random.nextInt(62);
 
            //将产生的数字通过length次承载到sb中
 
            randomStr.append(str.charAt(number));
        }
 
        //将承载的字符转换成字符串
 
        return randomStr.toString();
    }
 
 
//类似微信接口的签名生成方法
    public String createSign(Map<String, String> params, String privateKey){
        StringBuilder sb = new StringBuilder();
        // 将参数以参数名的字典升序排序
        Map<String, String> sortParams = new TreeMap<String, String>(params);
        // 遍历排序的字典,并拼接"key=value"格式
        for (Map.Entry<String, String> entry : sortParams.entrySet()) {
            String key = entry.getKey();
            String value =  entry.getValue().trim();
            if (!StringUtils.isEmpty(value))
                sb.append("&").append(key).append("=").append(value);
        }
        String stringA = sb.toString().replaceFirst("&","");
     
        //String stringSignTemp = stringA + "&"+"appkey="+privateKey;
       //将签名使用MD5加密并全部字母变为大写
       // String signValue = Md5Encrypt.md5(stringSignTemp).toUpperCase();
        // System.out.println("stringA+privateKey后MD5加密+转换全部大写生成sign为：       "+signValue);
        return stringA ;
    }
 
 
}

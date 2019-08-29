package Demobank;

import sun.misc.BASE64Encoder;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/*
 * MD5 此类是对密码进行安全保护
 * */
public class MD5 {
    /*
     * 对密码加密操作
     * */
    public String EncoderByMd5(String str) throws NoSuchAlgorithmException, UnsupportedEncodingException{
        //确定计算方法
        /*
         * MessageDigest Java密码学体系结构标准算法名称文档
         * MessageDigest这个类为应用程序提供消息摘要算法的功能，比如SHA-1或SHA-256
         * */
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        BASE64Encoder base64en = new BASE64Encoder();
        //加密后的字符串
        String newstr = base64en.encode(md5.digest(str.getBytes("utf-8")));
        return newstr;
    }
    /*
     * 此方法是检验新密码与旧密码是否一致
     * */
    public boolean checkpassword(String newpasswd,String oldpasswd) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        //进行判断密码是否一致
        if(EncoderByMd5(newpasswd).equals(oldpasswd))
            return true;
        else
            return false;
    }

}

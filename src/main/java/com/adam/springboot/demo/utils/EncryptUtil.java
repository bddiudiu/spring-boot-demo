package com.adam.springboot.demo.utils;

import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.crypto.hash.SimpleHash;

/**
 * Created by adam on 9/11/16.
 */
public class EncryptUtil {

    public static final String algorithmName = "md5";

    /**
     * 将数据加密
     * @param str
     * @param salt
     * @return
     */
    public static String getEncryptPass(String str,String salt){
        int hashIterations = 2;
        SimpleHash hash = new SimpleHash(algorithmName, str,salt, hashIterations);
        String encodedPassword = hash.toHex();
        return encodedPassword;
    }

    /**
     * Md5加密      Shiro中自带MD5没有解密
     * @param str   要加密的值
     * @param salt<span style="white-space:pre">  </span>可以看做是拌料
     * @return
     */
    public static String md5(String str,String salt){
        return new Md5Hash(str,salt).toString();
    }

//    public static void main(String[] args) {
//        String algorithmName = "md5";
//        String username = "admin";
//        String password = "admin";
//        String salt = "8f3e5f19c52742fc82b90abc91b8c211";
////        String salt2 = new SecureRandomNumberGenerator().nextBytes().toHex();
//        int hashIterations = 2;
//        SimpleHash hash = new SimpleHash(algorithmName, password,
//                salt, hashIterations);
//        String encodedPassword = hash.toHex();
//        System.out.println(encodedPassword);
//        System.out.println(salt);
//
//
//
//    }
}

package com.github.candyacao.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

public class PasswordHash {
    private static char[] hex = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /**
     *
     * @param inputStr  输入的明文
     * @param salt  生成的盐值
     */
    public static String MD5WithSalt(String inputStr, String salt) {
        if (inputStr==null){
            inputStr="";
        }
        if (salt == null){
            salt="";
        }
        String ret = "";
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            String inputWithSalt = inputStr + salt;//加盐，输入加盐
            ret = toHexString(md.digest(inputWithSalt.getBytes()));
        } catch (NoSuchAlgorithmException e) {
        }
        return ret;
    }

    public static String toHexString(byte[] bytes) {
        StringBuilder hexString = new StringBuilder();

        for (int i = 0; i < bytes.length; i++) {
            String hex = Integer.toHexString(0xFF & bytes[i]);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }

        return hexString.toString();
    }


    /**
     * @Author: candyacao
     * @Time 2019/02/15
     * @return: salt
     * @Descrption: 自定义简单生成盐，是一个随机生成的长度为16的字符串，每一个字符是随机的十六进制字符
     */
    public static String generateSalt(){
        Random random = new Random();
        StringBuilder sb = new StringBuilder(16);
        for (int i = 0; i < sb.capacity(); i++) {
            sb.append(hex[random.nextInt(16)]);
        }
        return sb.toString();
    }

    public static boolean validHash(String inputStr, String salt, String hash){
        if (hash==null){
            return false;
        }
        return MD5WithSalt(inputStr, salt).equals(hash);
    }

}

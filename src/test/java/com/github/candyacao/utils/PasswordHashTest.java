package com.github.candyacao.utils;


import org.junit.Test;

import static com.github.candyacao.utils.PasswordHash.*;
import static com.github.candyacao.utils.PasswordHash.MD5WithSalt;
import static org.junit.Assert.assertEquals;

public class PasswordHashTest {

    @Test
    public void testMD5WithSalt() {
       // System.out.println(MD5WithSalt("caosdjkhfa", "1D7032F9BBFB5112"));
        assertEquals("不相等", "49a272838a62135ddc53740a42e11199", MD5WithSalt("caosdjkhfa", "1D7032F9BBFB5112"));
        assertEquals("不相等", "1e2caf62c4c31865eeedbbcb3ffa3197", MD5WithSalt("caosdjkhfa", null));
        assertEquals("不相等", "1e2caf62c4c31865eeedbbcb3ffa3197", MD5WithSalt("caosdjkhfa", ""));
        assertEquals("不相等", "50482a48302a8fef1ffebc26956e30dd", MD5WithSalt(null, "1D7032F9BBFB5112"));
        assertEquals("不相等", "50482a48302a8fef1ffebc26956e30dd", MD5WithSalt("", "1D7032F9BBFB5112"));
        assertEquals("不相等", "d41d8cd98f00b204e9800998ecf8427e", MD5WithSalt("", ""));
    }

    @Test
    public void testGenerateSalt() {
        System.out.println(generateSalt());
    }

    @Test
    public void testValidHash() {
       // return validHash();
        assertEquals("不相等", true, validHash("caosdjkhfa","1D7032F9BBFB5112","49a272838a62135ddc53740a42e11199"));

    }
    @Test
    public void tets(){
        assertEquals("不相等", "sjhdsjknull", "sjhdsjk"+null);
        assertEquals("不相等", "nullsjhdsjk", null+"sjhdsjk");
        assertEquals("不相等", "", ""+"");


    }
}
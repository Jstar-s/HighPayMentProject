package com.jstar.util;

/**
 * @author Jayson
 * @version 1.0
 * @date 2023/8/2 20:48
 */
public class TestUtil {

    // 防止实例化
    private TestUtil() throws Exception {
        throw new IllegalStateException("Utility Class");
    }

    public static void TestPrint() {
        System.out.println("this is test for common util");
    }




}

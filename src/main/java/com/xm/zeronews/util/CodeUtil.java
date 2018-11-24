package com.xm.zeronews.util;

import java.util.Random;

/**
 * 作者：Xm Guo
 * 时间：2018/11/15
 **/
public class CodeUtil {

    public static String getCode() {
        Random random = new Random();
        return ""+(random.nextInt(900000)+111111);
    }

    public static void main(String[] args) {
        System.out.println(CodeUtil.getCode());
    }

}

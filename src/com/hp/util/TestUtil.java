package com.hp.util;

public class TestUtil {
    public static void welcome() {
        System. out. println( "先生/女士");
        System. out. println( "欢迎使用ATM取款机" );
        System. out. println( " **********" );
    }
    //客户的1级选择（查询余额）
    public static void oneLeveOption(){
        System.out.println("*****************************************");
        System.out.println("********请输入你想要的操作类型：*********");
        System.out.println("********1.余额查询        2.取款*********");
        System.out.println("********3.转账            4.存款*********");
        System.out.println("********5.退卡                  *********");
        System.out.println("*****************************************");
    }
    //客户的2级选择（取款）
    public static void twoLeveOption() {
        System.out.println("*****************************************");
        System.out.println("********请输入您想取款的数目：*********");
        System.out.println("********1.100        2.200*********");
        System.out.println("********3.300        4.400*********");
        System.out.println("********5.500        6.1000***********");
        System.out.println("********7.2000       8.其他***********");
        System.out.println("*****************************************");
    }
    //客户的3级选择（存款）
    public static void threeLeveOption() {
        System.out.println("*****************************************");
        System.out.println("********请输入您想存款的数目：*********");
        System.out.println("********1.100        2.200*********");
        System.out.println("********3.300        4.400*********");
        System.out.println("********5.500        6.1000***********");
        System.out.println("********7.2000       8.其他***********");
        System.out.println("*****************************************");
    }
}

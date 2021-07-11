package com.hp.service;

import com.hp.bean.Customer;
import com.hp.bean.CustomerData;
import com.hp.util.TestUtil;

import java.util.List;
import java.util.Scanner;

//此类就是完成客户的所有业务（增删改查）
public class CustomerService {
    //成员变量
    private List<Customer> customerList;
    private Customer currentCustomer;
    private Scanner scanner;

    //1、查 登录 判断账号密码是否正确
    public void checkpwd(String cardid, String cardPwd) {
        CustomerData customerData = CustomerData.getInstance();
        customerList = customerData.getCustomerList();
        //1、拿到cardid中的账户名和cardpwd 对list中的数据做对比
        System.out.println("cardid = " + cardid);
        System.out.println("cardPwd = " + cardPwd);
        for (Customer customer : customerList) {
            if (customer.getAccount().equals(cardid) && customer.getPassword().equals(cardPwd)) {
                // 拿出来这个人
                currentCustomer = customer;
                //账户正确
                System.out.println("欢迎" + customer.getCname() + "顾客登录!请注意您的安全");
                TestUtil.oneLeveOption();//界面
                Scanner scanner = new Scanner(System.in);
                String option = scanner.nextLine();
                oneoption(option);
                // 如何 保证 按了 1 3 5... 让他再此回到 此界面呢 ?

            }
        }
}

    private void oneoption(String option) {
        switch(option){
            case "1":
                System.out.println("余额查询");
                // 查询余额外
                doSelectMoney();
                // 当按下1 之后,  回退到  1及选项
                goOneHome();
                break;
            case "2":
                System.out.println("取款");
                TestUtil.twoLeveOption();//取款页面
                do1SelectMoney();//取款
                goOneHome();
                break;
            case "3":
                System.out.println("转账");
                do2SelectMoney();
                goOneHome();
                break;
            case "4":
                System.out.println("存款");
                do3SelectMoney();
                goOneHome();
                break;
            case "5":
                System.out.println("退卡");
                break;
        }
    }

    //查询余额
    private void doSelectMoney() {
        double money = currentCustomer.getMoney();
        System.out.println("你的余额是 " + money);
}
    //取款
    private void do1SelectMoney(){
        scanner = new Scanner(System.in);
        //Double goMoney = scanner.nextDouble();
        String goMoney = scanner.nextLine();
        switch (goMoney) {
            case "1":
                double aa = 100;
                System.out.println("请及时拿走现金100元");
                if (aa < currentCustomer.getMoney()) {
                    System.out.println("**************************");
                    System.out.println("您的余额为 " + (currentCustomer.getMoney() - aa) + "元");
                } else {
                    System.out.println("余额不足，请选择其他业务");
                }
                break;
            case "2":
                double bb = 200;
                System.out.println("请及时拿走现金200元");
                if (bb < currentCustomer.getMoney()) {
                    System.out.println("**************************");
                    System.out.println("您的余额为 " + (currentCustomer.getMoney() - bb) + "元");
                } else {
                    System.out.println("余额不足，请选择其他业务");
                }
                break;
            case "3":
                double cc = 300;
                System.out.println("请及时拿走现金300元");
                if (cc < currentCustomer.getMoney()) {

                    System.out.println("**************************");
                    System.out.println("您的余额为 " + (currentCustomer.getMoney() - cc) + "元");
                } else {
                    System.out.println("余额不足，请选择其他业务");
                }
                break;
            case "4":
                double dd = 400;
                System.out.println("请及时拿走现金400元");
                if (dd < currentCustomer.getMoney()) {

                    System.out.println("**************************");
                    System.out.println("您的余额为 " + (currentCustomer.getMoney() - dd) + "元");
                } else {
                    System.out.println("余额不足，请选择其他业务");
                }
                break;
            case "5":
                double ee = 500;
                System.out.println("请及时拿走现金500元");
                if (ee < currentCustomer.getMoney()) {

                    System.out.println("**************************");
                    System.out.println("您的余额为 " + (currentCustomer.getMoney() - ee) + "元");
                } else {
                    System.out.println("余额不足，请选择其他业务");
                }
                break;
            case "6":
                double ff = 1000;
                System.out.println("请及时拿走现金1000元");
                if (ff < currentCustomer.getMoney()) {

                    System.out.println("**************************");
                    System.out.println("您的余额为 " + (currentCustomer.getMoney() - ff) + "元");
                } else {
                    System.out.println("余额不足，请选择其他业务");
                }
                break;
            case "7":
                double gg = 2000;
                System.out.println("请及时拿走现金2000元");
                if (gg < currentCustomer.getMoney()) {

                    System.out.println("**************************");
                    System.out.println("您的余额为 " + (currentCustomer.getMoney() - gg) + "元");

                } else {
                    System.out.println("余额不足，请选择其他业务");
                }
                break;
            case "8":
                System.out.println("其他");
                Scanner other = new Scanner(System.in);
                double hh = other.nextDouble();
                if (hh < currentCustomer.getMoney()) {

                    System.out.println("请及时拿走现金" + (currentCustomer.getMoney() - hh) + "元");

                    System.out.println("您的余额为" + (currentCustomer.getMoney() - hh));
                }else{
                    System.out.println("余额不足，请选择其他业务");
                }
                break;
            default:
                System.out.println("请输入正确的序号");
                break;
        }
    }
    //转账
    private void do2SelectMoney() {
        System.out.println("请输入您要转账的卡号：");
        Scanner account = new Scanner(System.in);
        double money = account.nextInt();
    }




    //存款
    private void do3SelectMoney(){
        System.out.println("请输入您的存款金额：");
        Scanner scanner = new Scanner(System.in);
        Double money = scanner.nextDouble();
        System.out.println("存款成功!余额为" + (currentCustomer.getMoney() + money));
    }

    //当按下1 之后,  回退到  1及选项
    private  void goOneHome() {
       TestUtil.oneLeveOption();
        Scanner scanner = new Scanner(System.in);
        String option = scanner.nextLine();
        System.out.println("option = " + option);
        oneoption(option);//递归算法
    }
}

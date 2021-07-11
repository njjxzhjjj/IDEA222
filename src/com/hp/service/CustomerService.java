package com.hp.service;

import com.hp.bean.Customer;
import com.hp.bean.CustomerData;
import com.hp.util.TestUtil;

import java.util.List;
import java.util.Scanner;

//此类就是完成客户的所有业务（增删改查）
public class CustomerService {
    private List<Customer> customerList;
    private Customer currentCustomer;

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
                goOneHome();
                break;
            case "3":
                System.out.println("转账");
                goOneHome();
                break;
            case "4":
                System.out.println("存款");
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

    //当按下1 之后,  回退到  1及选项
    private  void goOneHome() {
       TestUtil.oneLeveOption();
        Scanner scanner = new Scanner(System.in);
        String option = scanner.nextLine();
        System.out.println("option = " + option);
        oneoption(option);//递归算法
    }
}

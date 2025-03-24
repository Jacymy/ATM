package com.itheima.hz.service;

import java.util.Scanner;

/**
 * 系统业务类
 *
 * @author HLH
 */
public class ATM {
    /**
     * 由于ATM系统中频繁需要通过键盘与系统交互
     */
    private Scanner sc = new Scanner(System.in);

    /**
     * ATM管理系统主页面(首页)
     */
    public void start() {
        while(true) {
            System.out.println("欢迎来到ATM银行系统");
            System.out.println("1. 用户登录");
            System.out.println("2. 用户开户");
            System.out.println("3. 退出");
            System.out.println("请选择您要操作的选项【1, 2, 3】");
            try {
                // 获取用户输入的选项(choice: 1 and 2 and 3)
                int choice = sc.nextInt();
                // 处理用户的选项
                switch(choice) {
                    case 1:
                        // TODO 登录Login
                        System.out.println(">>> 登录模块正在维护中...... <<<");
                        System.out.println("################################################################");
                        break;
                    case 2:
                        // TODO 注册(开户)register
                        System.out.println(">>> 开户模块正在维护中...... <<<");
                        System.out.println("################################################################");
                        break;
                    case 3:
                        // TODO 退出exit
                        System.out.println(">>> 磁卡已弹出,请妥善保管你的银行卡 <<<");
                        System.out.println("################################################################");
                        sc.close(); // 释放资源
                        return;
                        //break;
                    default:
                        System.out.println(">>> 您输入的选项有误,请重新输入! <<<");
                        System.out.println("################################################################");
                }
            } catch(Exception e) {
                System.out.println("Exception: " + e);
                sc.close();
                break;
            }
        }
    }
}

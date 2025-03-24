package com.itheima.hz;

import com.itheima.hz.service.ATM;

/**
 * 测试ATM的功能
 *
 * @author HLH
 */
public class ATMTest {

    public static void main(String[] args) {
        // 创建一个ATM对象atm
        var atm = new ATM();

        // 进入首页
        atm.start();
    }
}

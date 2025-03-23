package com.itheima.hz.pojo;

/**
 * 账户类
 * 
 * 需求: 定义一个账户类Account，至少需要包含（卡号、姓名、性别、密码、余额、每次取现额度）
 *
 * @author HLH
 */
public class Account {
    
   /**
    * 卡号
    */
    private String cardId;

    /**
     * 姓名
     */
    private String username;

    /**
     * 性别
     */
    private char gender;

    /**
     * 密码
     */
    private String password;

    /**
     * 余额 balance
     * 集群 cluster
     * 负载均衡 load balance
     */
    private String balance;

    /**
     * 限额 quota 此处使用limit
     */
    private double limit;


    // getter and setter method
    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getLimit() {
        return limit;
    }

    public void setLimit(double limit) {
        this.limit = limit;
}

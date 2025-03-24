# 简易的ATM(automated teller machine)自动取款机开发手册(Java版)

## 项目结构设计（MVC分层架构）

### 基础工程搭建

1. 创建标准Java工程
   - 类型：无依赖纯Java项目
   - 开发工具：IntelliJ IDEA/Eclipse

### 包结构规范

1. 主包路径：`com.itheima.hz`

   ```bash
   src/
   └── com.itheima.hz/
       ├── pojo/        # 实体类层
       ├── service/     # 业务逻辑层
       ├── controller/  # 交互控制层（建议新增）
       └── utils/       # 工具类层（建议新增）
   ```

### 核心包说明

1. 分层职责说明：
   - **pojo**（实体对象层）
     - 存放JavaBean类（如：Account账户类）
     - 职责：封装系统核心数据模型
   - **service**（业务服务层）
     - 包含：接口+实现类（推荐`impl`子包）
     - 职责：处理存款/取款等业务逻辑
   - **controller**（控制层）
     - 职责：处理用户输入/输出交互
   - **utils**（工具类层）
     - 职责：提供公共工具方法（如：金额校验）

### 扩展建议

1. 推荐核心类：
   - `ATMController`：主控制类
   - `AccountService`：账户业务类
   - `MoneyUtils`：金额处理工具类

> **注意事项**  
> ① 分层结构使代码更易维护  
> ② 包名全小写，使用复数形式（如：services）

## 项目启动

### 项目基本信息

【项目名称】ATM自动取款机模拟系统  
【技术栈】Java SE + 控制台交互 + 集合框架  
【开发周期】2周（敏捷开发模式）

### 项目目标（面向初级开发者）

1. 掌握控制台程序的交互设计
2. 实践面向对象三大特性：

   ```java
   // 封装示例：Account类的属性私有化
   public class Account {
       private String cardId; // 卡号封装
       // 通过public方法提供访问
       public String getCardId() { return cardId; }
   }
   ```

3. 理解MVC分层架构实现
4. 学习基础金融业务逻辑处理

### 开发流程详解

| 阶段 | 交付物 | 工具/技术 | 预计耗时 |
|------|--------|-----------|----------|
| 系统分析 | 需求文档 | Markdown | 1天 |
| 系统设计 | UML类图 | StarUML | 2天 |
| 编码实现 | 可运行系统 | IntelliJ IDEA | 5天 |
| 单元测试 | 测试用例 | JUnit | 1天 |
| 部署运行 | 可执行JAR | Maven | 1天 |

### 开发任务分解（新人版）

1. 账户管理模块（难度：★）
   - 开户功能实现
   - 登录验证逻辑
2. 交易处理模块（难度：★★）
   - 存款/取款边界条件处理
   - 余额计算精度控制
3. 安全控制模块（难度：★★★）
   - 密码加密存储
   - 交易限额校验

## 系统分析

### 核心需求

1. 基础功能需求：
   - 账户开户/销户
   - 现金存取款
   - 账户间转账
   - 交易记录查询

2. 功能模块划分：

   ```mermaid
   graph TD
   A[ATM系统] --> B[账户管理]
   A --> C[交易处理]
   A --> D[安全控制]
   B --> B1(开户)
   B --> B2(登录)
   C --> C1(存款)
   C --> C2(取款)
   ```

3. 非功能性需求：
   - 响应时间：单操作<1s
   - 数据安全：密码三次错误锁定
   - 兼容性：支持JDK8+

## 系统设计

### 架构设计

采用MVC分层架构：

```bash
src/
├── main/
│   ├── java/
│   │   ├── com.itheima.hz/
│   │   │   ├── model/    # 数据模型
│   │   │   ├── service/  # 业务逻辑
│   │   │   ├── view/     # 界面交互
│   │   │   └── App.java  # 入口类
```

### 类职责说明

1. Account类核心属性：

   ```java
   public class Account {
       private String cardId;    // 卡号
       private String password;  // 密码
       private double balance;   // 余额
       private double limit;     // 取现限额
       // Getter/Setter省略
   }
   ```

### 数据库设计

1. 内存存储方案（暂不使用真实数据库）：

   ```java
   public class ATM {
       // 使用ArrayList模拟数据库
       private ArrayList<Account> accountList = new ArrayList<>();
       
       // 账户查询方法示例
       public Account getAccountByCardId(String cardId) {
           for(Account acc : accountList) {
               if(acc.getCardId().equals(cardId)) {
                   return acc;
               }
           }
           return null;
       }
   }
   ```

## 系统详细设计与编码

### 账户管理模块

1. 开户功能核心逻辑：

   ```java
   public void createAccount() {
       Account acc = new Account();
       // 卡号生成算法
       acc.setCardId(generateCardId(8)); 
       // 密码二次验证
       while(!validatePassword()){
           System.out.println("两次密码不一致");
       }
       accountList.add(acc);
   }
   ```

### 交易处理模块

1. 取款业务流程图：

   ```txt
   开始 -> 输入金额 -> 检查余额
   -> 检查限额 -> 更新余额 -> 打印凭条
   -> 结束
   ```

## 控制层实现

### 核心方法示例

```java
public class ATMController {
    // 登录验证
    public boolean login(String cardId, String password) {
        Account acc = accountService.findAccount(cardId);
        return acc != null && acc.getPassword().equals(password);
    }
    
    // 取款操作
    public void withdraw(double amount) {
        if(amount > currentAccount.getLimit()) {
            throw new LimitExceededException();
        }
        currentAccount.setBalance(
            currentAccount.getBalance() - amount
        );
    }
}
```

## 视图层实现

### 控制台交互设计

```java
public class ConsoleUI {
    public void showMainMenu() {
        System.out.println("1. 存款");
        System.out.println("2. 取款");
        System.out.println("3. 转账");
        System.out.println("请选择操作：");
    }
    
    public String inputPassword() {
        Console console = System.console();
        return new String(console.readPassword());
    }
}
```

## 系统测试

### 测试用例设计

| 测试场景 | 输入数据 | 预期结果 |
|---------|----------|----------|
| 正确登录 | 有效卡号+正确密码 | 登录成功 |
| 密码错误 | 有效卡号+错误密码 | 提示重试 |
| 超额取款 | 取款金额>限额 | 交易拒绝 |

## 系统部署

### 本地运行说明

1. 环境要求：
   - JDK 1.8+
   - Maven 3.6+

2. 启动命令：

   ```bash
   mvn compile exec:java -Dexec.mainClass="com.itheima.hz.App"
   ```

## 学习资源

1. 《Java核心技术 卷I》- 集合框架章节
2. Oracle官方Java教程：控制台IO
3. GitHub开源项目：simple-bank-system


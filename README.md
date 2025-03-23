# 简易的ATM(automated teller machine)自动取款机

## 项目结构设计

### 基础工程搭建

创建标准Java工程

 - 类型: 无依赖纯Java项目
 - 开发工具: Curser/VsCode


### 包结构规范

主包路径: `com.itheima.hz`

```bash
src/
  └── com.itheima.hz/
      ├── pojo/        # 实体类层
      ├── service/     # 业务逻辑层
      ├── controller/  # 交互控制层（建议新增）
      └── utils/       # 工具类层（建议新增）
 ```

### 核心包说明

分层职责说明:

- **pojo** (实体对象层)
    - 存放JavaBean类(如: Account账户类)
    - 职责: 封装系统核心数据模型
- **service** (业务服务层)
    - 包含: 接口+实现类(推荐`impl`子包)
    - 职责: 处理存款/取款等业务逻辑
- **controller** (控制层)
    - 职责: 处理用户输入/输出交互
- ***utils* (工具类层)
    - 职责: 提供公共工具方法(如: 金额校验)

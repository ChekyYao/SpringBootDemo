# C#转Java学习之路 （Start 2020-11）

——目标：快速上手，并应用在API 和 EDI 开发



## 1.安装

安装 [11 JDK](https://www.oracle.com/java/technologies/javase-downloads.html#JDK11) | [Doc](https://docs.oracle.com/en/java/javase/11/docs/api/index.html)

安装 [IntelliJ IDEA Community Edition](https://www.jetbrains.com/zh-cn/idea/download/download-thanks.html?platform=windows&code=IIC) 

安装 MySql [Installer Version (推荐)](https://dev.mysql.com/downloads/windows/installer/) | [Installer 教程](https://www.runoob.com/w3cnote/windows10-mysql-installer.html)；也可以单独安装 [Workbench Version](https://dev.mysql.com/downloads/file/?id=498730) 

环境 [Maven](https://maven.apache.org/) IDEA本身有自动捆绑的



## 2.简介

J2SE 标准版

J2EE 企业版

J2ME 微型版

JDK 开发工具 （JDK 自带 JRE 和 JVM）（命令Javac）

JRE 运行环境 （JRE 自带 JVM）（命令 Java）

JVM 运行环境  (与操作系统交互)



## 3.架构与框架

学习思路：看官方文档 和 源码

### 3.1.架构

 [Springboot](https://spring.io/quickstart) （[Doc](https://spring.io/projects/spring-boot#learn) | [Doc (推荐)](https://docs.spring.io/spring-boot/docs/current/reference/html/spring-boot-features.html#boot-features-external-config)| [Vedio1](https://www.bilibili.com/video/BV1DC4y1H7Xk?p=3) | [Vedio2 **(推荐)**](https://www.bilibili.com/video/BV1Et411Y7tQ?p=4)）: 用来简化 Spring的配置

#### 3.1.1.配置

1. yaml语法；
2. 加载配置 由高覆盖低，所有的配置会形成互补配置；
3. 日志 采用 slf4j [Reference](https://docs.spring.io/spring-boot/docs/current/reference/html/spring-boot-features.html#boot-features-logging)

### 3.2.框架

**Dubbo**：分布式服务框架(RPC) 。[官网-入口](http://dubbo.apache.org/zh-cn/) |[Vedio](https://www.bilibili.com/video/BV1n4411x7tB?from=search&seid=6165747634317706089)

[ZooKeeper](https://baike.baidu.com/item/zookeeper/4836397?fr=aladdin): 一个[分布式](https://baike.baidu.com/item/分布式/19276232)的，开放源码的[分布式应用程序](https://baike.baidu.com/item/分布式应用程序/9854429)协调服务，是[Google](https://baike.baidu.com/item/Google)的Chubby一个[开源](https://baike.baidu.com/item/开源/246339)的实现，是Hadoop和[Hbase](https://baike.baidu.com/item/Hbase/7670213)的重要组件。[官网-入口](https://zookeeper.apache.org/)

[RPC](https://baike.baidu.com/item/%E8%BF%9C%E7%A8%8B%E8%BF%87%E7%A8%8B%E8%B0%83%E7%94%A8/7854346?fromtitle=RPC&fromid=609861&fr=aladdin): 一种技术思想，像调用本地的函数一样去调远程函数。 [Reference](https://www.zhihu.com/question/25536695)



**ORM:**  

MyBatis [官网-入门](https://mybatis.org/mybatis-3/zh/getting-started.html) | [官方-GitHub](https://github.com/mybatis/mybatis-3)

[JPA](https://baike.baidu.com/item/JPA/5660672?fr=aladdin): 一种规范，是JDK 5.0注解或XML描述对象－关系表的映射关系，并将运行期的实体[对象持久化](https://baike.baidu.com/item/对象持久化/7316192)到数据库中。



**DB:**

MySQL [教程](https://www.runoob.com/mysql/mysql-install.html)



**基础**

[Bean](https://baike.baidu.com/item/Bean/3792612?fr=aladdin): 一种规范，表达实体和信息的规范，便于封装重用。 [Reference](https://www.zhihu.com/question/19773379)

[DAO](https://baike.baidu.com/item/DAO/2900358?fr=aladdin): 通俗来讲，就是将数据库操作都封装起来。[Reference](https://www.runoob.com/note/27029)

[AOP](https://baike.baidu.com/item/AOP/1332219?fr=aladdin): 通过[预编译](https://baike.baidu.com/item/预编译/3191547)方式和运行期间动态代理实现程序功能的统一维护的一种技术。[Reference](https://www.zhihu.com/question/24863332)

META-INF: 相当于一个信息包，目录中的文件和目录获得Java 2平台的认可与解释，用来配置应用程序、扩展程序、类加载器和服务manifest.mf文件，在用jar打包时自动生成。[Reference](https://blog.csdn.net/qq_38449518/article/details/82414069)







### 3.3. WebApi编码风格RESTful[CRUD](https://baike.baidu.com/item/crud/3606157?fr=aladdin)

以操作员工Emp为例

|          | 普通CRUD(uri来区分操作)  | RESTfulCRUD       |
| -------- | ------------------------ | ----------------- |
| Create   | addEmp?xxx               | emp---POST        |
| Retrieve | getEmp                   | emp---Get         |
| Update   | updateEmp?id=xx1&col=xx2 | emp/{id}---PUT    |
| Delete   | deleteEmp?id=xxx         | emp/{id}---DELETE |



### 3.4. Repositories & Dependencies

[Maven](https://mvnrepository.com/) (Sample:  Druid)





## 4.基础

### 4.1 面向对象

特征：封装，继承，多态

OOA （Object-Oriented Analysis）>> OOD （Object-Oriented Design）>> OOP （Object-Oriented Programming）



### 4.2 IntelliJ IDEA 快捷键

**常用快捷键**

Ctrl+Alt+S 打开Settings，找到keymap，下拉选项选为Visual studio，这样绝大多数VS快捷键就可以使用了

| 其他常用快捷键        | 描述                                            |
| --------------------- | ----------------------------------------------- |
| Alt+Insert            | 自动生成代码（eg: AutoGenerateGetterAndSetter） |
| Ctrl+Alt+/            | 行注释                                          |
| Ctrl+Shift+/          | 块注释                                          |
| Shift+Shift 或 Ctrl+T | 全局搜索                                        |
| Ctrl+Alt+F            | 显示类中所有的成员（如方法，变量）              |
| Ctrl+Shift+H          | 全局替换                                        |



**有很多的快捷代码块模板**

也可以在settings自定义 live Templates

| 代码块的简写 | 实际生成代码                             |
| ------------ | ---------------------------------------- |
| psvm         | public static void main(String[] args){} |
| sout         | System.out.println();                    |
| fori         | for(int i = 0; i < ; i++){}              |
| list.for     | for(Object o : list){}                   |
| ifn          | if( == null){}                           |
| prsf         | private static final                     |



### 4.3 Java 语法

静态代码块： 类加载的时候会运行。可以应用在 记录类加载的日志信息

实例代码块： 类在实例化的时候会运行，执行顺序在构造方法之前。

package 命名： 一般采用 公司域名倒序 + 项目名 + 模块名 + 功能名

Exception: 分为 运行时异常（概率小）和 编译时异常（概率大，需要提前代码处理）



**关键字转换**

| Java                                 | C#             |
| ------------------------------------ | -------------- |
| instanceof                           | is             |
| super                                | base           |
| final                                | seal, readonly |
| static final                         | const          |
| default                              | internal       |
| extends                              | :              |
| implements                           | :              |
| import                               | using          |
| finalize()                           | Dispose()      |
| Date                                 | DateTime       |
| transient                            | NonSerialized  |
| synchronized                         | lock           |
| ...                                  | params         |
| @interface @Target @Retention 元注解 | Attribute      |
| @Deprecated                          | Obsolete       |



Integer: [-128, 127] 静态类 自动加载，即 自动装箱 不会再 New， 而超过此范围的会New

```Java
//Example
Integer a = 128;
Integer b = 128;
var c = a == b; //false
Integer x = 127;
Integer y = 127;
var z = x == y; //true
```



**常用Collection**

| 集合类     | 描述                                                         |
| ---------- | ------------------------------------------------------------ |
| ArraryList | 有序可重复；数据结构：数组；多线程不安全； C#的List          |
| LinkedList | 有序；数据结构：双向链表                                     |
| Vector     | 与ArraryList类似，但多线程安全；注意：因效率低，现在很少用了 |
| HashSet    | 无序不可重复；数据结构：哈希表                               |
| TreeSet    | 自动按大小排序；数据结构：二叉树                             |

工具类： Collections



**常用Map**

| 集合类  | 描述                                                         |
| ------- | ------------------------------------------------------------ |
| HashMap | 无序不可重复；数据结构：数组和单向链表与红黑树的结合体；对象要重写方法hashCode和equals；C#的 Dictionary |
| TreeMap | 自动按大小排序；数据结构：二叉树                             |



**常用IO**

| 类型                         | 类                   | 描述                     |
| ---------------------------- | -------------------- | ------------------------ |
| 文件专属                     | FileInputStream      |                          |
|                              | FileOutputStream     |                          |
|                              | FileReader           |                          |
|                              | FileWriter           |                          |
| 转换流（字节流转换为字符流） | InputStreamReader    |                          |
|                              | OutputStreamReader   |                          |
| 缓冲流                       | BufferedReader       |                          |
|                              | BufferedWriter       |                          |
|                              | BufferedInputStream  |                          |
|                              | BufferedOutputStream |                          |
| 数据流                       | DataInputStream      | 一定要按输出的顺序来输入 |
|                              | DataOutputStream     |                          |
| 标准输出流                   | PrintWriter          |                          |
|                              | PrintStream          |                          |
| 对象专属流                   | ObjectInputStream    |                          |
|                              | ObjectOutputStream   |                          |



**多线程**

Java 采用的调度模型 是 抢占式调度模型；

变量的线程安全：实例变量（堆） 与 静态变量（方法区） 需要 注意， 而 栈里的局部变量 不会出现线程不安全的情况。



**反射**

Class

Constructor

Field

Method



## 5.实战

### 5.1. 学习Templates

https://github.com/ChekyYao/Java



### 5.2. 综合实践

简介：Springboot + SpringMVC + WebApi(RESTful) + SpringData(JPA) + MyBatis + Druid + JDBC + MySQL + log(slf4j)

准备实施...

https://github.com/ChekyYao/SpringBootDemo



## **参考文献 Reference:**

[1].  [Java零基础教程视频](https://www.bilibili.com/video/BV1Rx411876f?p=834) 与 [Java教程](https://www.runoob.com/java/java-collections.html)

[2]. [IntelliJ IDEA 入门](https://www.bilibili.com/video/BV1DE411r7r1?from=search&seid=5422164101846745456) 与  [IDEA从零基础到专业 **(推荐)**](https://www.bilibili.com/video/BV157411m7VL?p=5)

[3]. [IDEA Plugins](https://plugins.jetbrains.com/)

[4]. [WebJars](https://www.webjars.org/)



## Q & A

1. 无 Spring Initialzr

   安装插件 [Spring Assistant](https://blog.csdn.net/u012860950/article/details/76146072)

   

2. 快速配置快捷键与VS相同

   Settings(Ctrl+Shift+S) >> Keymap >> choose 'Visual Studio'

   

3. 关闭端口号 对于的进程

   [[Reference](https://blog.csdn.net/zhouky1993/article/details/103976320)]

   cmd : 

   netstat -ano | findstr 端口号

   taskkill -PID 进程号 -F
   
   
   
4. IDEA 社区版不支持 Diagrams



---------------

if you have any question, please contact me.

**Author: Cheuk Yao**

**Date: 2020-11**

**EXP Date: 2020-12-31**

**e-Mail: 13925568211@163.com**

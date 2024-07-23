# Smart Bus System

#### 介绍
A smart public transport system that integrates passengers, drivers, and administrators.

#### 软件架构

This project uses `Maven` to build the project. 
Import `MyBatis` to connect to a MySQL database.
Import `slf4j`logs, and print the log information in the console.

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>edu.qingchenjia</groupId>
    <artifactId>demo</artifactId>
    <version>1.0-SNAPSHOT</version>

    <properties>
        <maven.compiler.source>21</maven.compiler.source>
        <maven.compiler.target>21</maven.compiler.target>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    </properties>

    <dependencies>
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <version>8.0.28</version>
        </dependency>

        <dependency>
            <groupId>org.mybatis</groupId>
            <artifactId>mybatis</artifactId>
            <version>3.5.6</version>
        </dependency>

        <!-- 添加slf4j日志api -->
        <dependency>
            <groupId>org.slf4j</groupId>
            <artifactId>slf4j-api</artifactId>
            <version>1.7.20</version>
        </dependency>

        <!-- 添加logback-classic依赖 -->
        <dependency>
            <groupId>ch.qos.logback</groupId>
            <artifactId>logback-classic</artifactId>
            <version>1.2.3</version>
        </dependency>

        <!-- 添加logback-core依赖 -->
        <dependency>
            <groupId>ch.qos.logback</groupId>
            <artifactId>logback-core</artifactId>
            <version>1.2.3</version>
        </dependency>

        <dependency>
            <groupId>org.bouncycastle</groupId>
            <artifactId>bcprov-jdk18on</artifactId>
            <version>1.78.1</version>
        </dependency>
    </dependencies>

    <build>
        <plugins>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-assembly-plugin</artifactId>
                <executions>
                    <execution>
                        <phase>package</phase>
                        <goals>
                            <goal>single</goal>
                        </goals>
                        <configuration>
                            <archive>
                                <manifest>
                                    <!--填写你的main方法所在的主类-->
                                    <mainClass>
                                        SmartBusSystem.App
                                    </mainClass>
                                </manifest>
                            </archive>
                            <descriptorRefs>
                                <descriptorRef>jar-with-dependencies</descriptorRef>
                            </descriptorRefs>
                        </configuration>
                    </execution>
                </executions>
            </plugin>
        </plugins>
    </build>
</project>
```

#### 基本功能

The three identities of passenger, driver, and administrator are all designed with corresponding login entrances. For ordinary users: passengers and drivers, the function of registering and retrieving passwords is designed.

Passengers can change their personal information and change their password. Query information for all bus routes and stops, including searching for navigation routes between any two stops.
Drivers are able to query and modify personal information and change passwords. Be able to keep track of their schedule.
Administrators are able to make edits to the vehicle and make changes to the driver's schedule.

In particular, in order to ensure the basic security of the password, the project uses the AES symmetric encryption algorithm to perform the ciphertext conversion.


#### 使用说明

This project is a stand-alone program, but the code logic has a certain degree of generality. Therefore, if you want to run this project on your own device, you will need to configure your local database accordingly, and make appropriate changes to the project `MybatisConfig.xml` make the appropriate modifications.

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE configuration
        PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-config.dtd">
<configuration>
    <environments default="development">
        <environment id="development">
            <transactionManager type="JDBC"/>
            <dataSource type="POOLED">
                <property name="driver" value="com.mysql.cj.jdbc.Driver"/>
                <property name="url" value="jdbc:mysql:///smartbussystem?useSSL=true"/>
                <property name="username" value="${username}"/>	<!--本地MySql用户名-->
                <property name="password" value="${password}"/>	<!--本地MySql密码-->
            </dataSource>
        </environment>
    </environments>
    <mappers>
        <package name="SmartBusSystem.mapper"/>
    </mappers>
</configuration>
```

#### 关系模式

There are 8 relationship patterns in the database: user, driver, admin, stop, route, route-stop, bus, and schedule.

```sql
CREATE SCHEMA smartbussystem;

USE smartbussystem;

create table `user`
(
    UID      varchar(10)   not null
        primary key,
    Password varchar(50)   not null,
    UName    varchar(10)   null,
    Aptitude int default 0 null,
    PhoneNum varchar(20)   not null
);

create table `driver`
(
    DID          varchar(10)                    not null
        primary key,
    Password     varchar(50)                    not null,
    DrivingYears int                            null,
    DName        varchar(10) default '注册司机' null,
    PhoneNum     varchar(20)                    not null
);

create table `admin`
(
    AID      varchar(10) not null
        primary key,
    Password varchar(50) not null
);

create table stop
(
    SID   varchar(5)  not null
        primary key,
    SName varchar(10) not null
);

create table `route`
(
    RID       varchar(5)    not null
        primary key,
    RName     varchar(10)   not null,
    Status    int default 1 not null,
    StartTime time          null,
    EndTime   time          null,
    Price     double        not null
);

create table `route-stop`
(
    RID     varchar(5) not null,
    SID     varchar(5) not null,
    `Order` int        not null,
    primary key (RID, SID),
    constraint `Route-Stop_route_RID_fk`
        foreign key (RID) references smartbussystem.route (RID),
    constraint `Route-Stop_stop_SID_fk`
        foreign key (SID) references smartbussystem.stop (SID)
);

create table `bus`
(
    LicenseNumber varchar(10)   not null
        primary key,
    Status        int default 1 not null,
    RID           varchar(5)    null,
    constraint bus_route_RID_fk
        foreign key (RID) references smartbussystem.route (RID)
);

create table `schedule`
(
    DID           varchar(10) not null,
    Time          varchar(5)  not null,
    LicenseNumber varchar(10) null,
    primary key (DID, Time),
    constraint schedule_bus_LicenseNumber_fk
        foreign key (LicenseNumber) references smartbussystem.bus (LicenseNumber)
);
```

#### 演示数据

```sql
/* stop */
INSERT INTO stop (SID, SName) VALUES ('S001', '新客运站');
INSERT INTO stop (SID, SName) VALUES ('S002', '红湖新城');
INSERT INTO stop (SID, SName) VALUES ('S003', '市民活动中心');
INSERT INTO stop (SID, SName) VALUES ('S004', '碧桂园');
INSERT INTO stop (SID, SName) VALUES ('S005', '清江商城');
INSERT INTO stop (SID, SName) VALUES ('S006', '锦绣江南');
INSERT INTO stop (SID, SName) VALUES ('S007', '万达广场');
INSERT INTO stop (SID, SName) VALUES ('S008', '湖心公园');
INSERT INTO stop (SID, SName) VALUES ('S009', '湖北银行');
INSERT INTO stop (SID, SName) VALUES ('S010', '人民广场');
INSERT INTO stop (SID, SName) VALUES ('S011', '市交警中队');
INSERT INTO stop (SID, SName) VALUES ('S012', '文峰公园');
INSERT INTO stop (SID, SName) VALUES ('S013', '农业银行');
INSERT INTO stop (SID, SName) VALUES ('S014', '国税局');
INSERT INTO stop (SID, SName) VALUES ('S015', '沁园大厦');
INSERT INTO stop (SID, SName) VALUES ('S016', '冰河时代广场');
INSERT INTO stop (SID, SName) VALUES ('S017', '陆城卫生院');
INSERT INTO stop (SID, SName) VALUES ('S018', '香客岩');
INSERT INTO stop (SID, SName) VALUES ('S019', '疾控中心');
INSERT INTO stop (SID, SName) VALUES ('S020', '九州丽景苑');
INSERT INTO stop (SID, SName) VALUES ('S021', '二桥加油站');
INSERT INTO stop (SID, SName) VALUES ('S022', '市人社局');
INSERT INTO stop (SID, SName) VALUES ('S023', '宜都大酒店');
INSERT INTO stop (SID, SName) VALUES ('S024', '烟草专卖局');
INSERT INTO stop (SID, SName) VALUES ('S025', '工商银行');
INSERT INTO stop (SID, SName) VALUES ('S026', '清江建行');
INSERT INTO stop (SID, SName) VALUES ('S027', '雅斯超市');
INSERT INTO stop (SID, SName) VALUES ('S028', '东方超市');
INSERT INTO stop (SID, SName) VALUES ('S029', '市征兵服务站');
INSERT INTO stop (SID, SName) VALUES ('S030', '电信局');
INSERT INTO stop (SID, SName) VALUES ('S031', '卫生防疫站');
INSERT INTO stop (SID, SName) VALUES ('S032', '陆城一中');
INSERT INTO stop (SID, SName) VALUES ('S033', '市人民医院');
INSERT INTO stop (SID, SName) VALUES ('S034', '孙家河');
INSERT INTO stop (SID, SName) VALUES ('S035', '姚店');
INSERT INTO stop (SID, SName) VALUES ('S036', '杨守敬中学');
INSERT INTO stop (SID, SName) VALUES ('S037', '楠竹园小区');
INSERT INTO stop (SID, SName) VALUES ('S038', '市法院');
INSERT INTO stop (SID, SName) VALUES ('S039', '福利院');
INSERT INTO stop (SID, SName) VALUES ('S040', '林业局');
INSERT INTO stop (SID, SName) VALUES ('S041', '人武部');
INSERT INTO stop (SID, SName) VALUES ('S042', '陆逊广场');
INSERT INTO stop (SID, SName) VALUES ('S043', '东风社区');
INSERT INTO stop (SID, SName) VALUES ('S044', '解放公寓');
INSERT INTO stop (SID, SName) VALUES ('S045', '博霖建筑');
INSERT INTO stop (SID, SName) VALUES ('S046', '车家店供销社');
INSERT INTO stop (SID, SName) VALUES ('S047', '三叉路口');
INSERT INTO stop (SID, SName) VALUES ('S048', '车家店小区');
INSERT INTO stop (SID, SName) VALUES ('S049', '车家店柑桔市场');
INSERT INTO stop (SID, SName) VALUES ('S050', '亮家垴砖厂');
INSERT INTO stop (SID, SName) VALUES ('S051', '黄泥堰');
INSERT INTO stop (SID, SName) VALUES ('S052', '龙窝');
INSERT INTO stop (SID, SName) VALUES ('S053', '宝塔湾');
INSERT INTO stop (SID, SName) VALUES ('S054', '十里铺小学');
INSERT INTO stop (SID, SName) VALUES ('S055', '长江陶瓷');
INSERT INTO stop (SID, SName) VALUES ('S056', '卫计局');
INSERT INTO stop (SID, SName) VALUES ('S057', '杨守敬幼儿园');
INSERT INTO stop (SID, SName) VALUES ('S058', '宜化绿洲');
INSERT INTO stop (SID, SName) VALUES ('S059', '宜都市图书馆');
INSERT INTO stop (SID, SName) VALUES ('S060', '人寿保险公司');
INSERT INTO stop (SID, SName) VALUES ('S061', '中医院');
INSERT INTO stop (SID, SName) VALUES ('S062', '福泽苑');
INSERT INTO stop (SID, SName) VALUES ('S063', '清江阳光城');
INSERT INTO stop (SID, SName) VALUES ('S064', '清江小学');
INSERT INTO stop (SID, SName) VALUES ('S065', '财政印刷厂');
INSERT INTO stop (SID, SName) VALUES ('S066', '台子堰');
INSERT INTO stop (SID, SName) VALUES ('S067', '移民局');
INSERT INTO stop (SID, SName) VALUES ('S068', '市一中');
INSERT INTO stop (SID, SName) VALUES ('S069', '公路局');
INSERT INTO stop (SID, SName) VALUES ('S070', '分路碑');
INSERT INTO stop (SID, SName) VALUES ('S071', '市纪委');
INSERT INTO stop (SID, SName) VALUES ('S072', '秀水苑');
INSERT INTO stop (SID, SName) VALUES ('S073', '杨守敬小学');
INSERT INTO stop (SID, SName) VALUES ('S074', '清江润园');
INSERT INTO stop (SID, SName) VALUES ('S075', '科技孵化中心');
INSERT INTO stop (SID, SName) VALUES ('S076', '鸿瑞华府');
INSERT INTO stop (SID, SName) VALUES ('S077', '茂盛工贸');
INSERT INTO stop (SID, SName) VALUES ('S078', '同创光电');
INSERT INTO stop (SID, SName) VALUES ('S079', '枫相树村委会');

/* route */
INSERT INTO route (RID, RName, Status, StartTime, EndTime, Price) VALUES ('1', '香客岩-孙家河', 1, '06:50:00', '18:00:00', 1);
INSERT INTO route (RID, RName, Status, StartTime, EndTime, Price) VALUES ('2', '新客运站-陆程卫生院', 1, '06:50:00', '18:00:00', 1);
INSERT INTO route (RID, RName, Status, StartTime, EndTime, Price) VALUES ('3', '姚店-龙窝', 1, '07:10:00', '16:40:00', 2);
INSERT INTO route (RID, RName, Status, StartTime, EndTime, Price) VALUES ('4', '宝塔湾-新客运站', 1, '07:10:00', '18:00:00', 1.5);
INSERT INTO route (RID, RName, Status, StartTime, EndTime, Price) VALUES ('7', '财政印刷厂-枫村委会', 1, '06:50:00', '18:00:00', 1.5);

/* route-stop */
INSERT INTO `route-stop` (RID, SID, `Order`) VALUES ('1', 'S007', 4);
INSERT INTO `route-stop` (RID, SID, `Order`) VALUES ('1', 'S018', 1);
INSERT INTO `route-stop` (RID, SID, `Order`) VALUES ('1', 'S019', 2);
INSERT INTO `route-stop` (RID, SID, `Order`) VALUES ('1', 'S020', 3);
INSERT INTO `route-stop` (RID, SID, `Order`) VALUES ('1', 'S021', 5);
INSERT INTO `route-stop` (RID, SID, `Order`) VALUES ('1', 'S022', 6);
INSERT INTO `route-stop` (RID, SID, `Order`) VALUES ('1', 'S023', 7);
INSERT INTO `route-stop` (RID, SID, `Order`) VALUES ('1', 'S024', 8);
INSERT INTO `route-stop` (RID, SID, `Order`) VALUES ('1', 'S025', 9);
INSERT INTO `route-stop` (RID, SID, `Order`) VALUES ('1', 'S026', 10);
INSERT INTO `route-stop` (RID, SID, `Order`) VALUES ('1', 'S027', 11);
INSERT INTO `route-stop` (RID, SID, `Order`) VALUES ('1', 'S028', 12);
INSERT INTO `route-stop` (RID, SID, `Order`) VALUES ('1', 'S029', 13);
INSERT INTO `route-stop` (RID, SID, `Order`) VALUES ('1', 'S030', 14);
INSERT INTO `route-stop` (RID, SID, `Order`) VALUES ('1', 'S031', 15);
INSERT INTO `route-stop` (RID, SID, `Order`) VALUES ('1', 'S032', 16);
INSERT INTO `route-stop` (RID, SID, `Order`) VALUES ('1', 'S033', 17);
INSERT INTO `route-stop` (RID, SID, `Order`) VALUES ('1', 'S034', 18);
INSERT INTO `route-stop` (RID, SID, `Order`) VALUES ('2', 'S001', 1);
INSERT INTO `route-stop` (RID, SID, `Order`) VALUES ('2', 'S002', 2);
INSERT INTO `route-stop` (RID, SID, `Order`) VALUES ('2', 'S003', 3);
INSERT INTO `route-stop` (RID, SID, `Order`) VALUES ('2', 'S004', 4);
INSERT INTO `route-stop` (RID, SID, `Order`) VALUES ('2', 'S005', 5);
INSERT INTO `route-stop` (RID, SID, `Order`) VALUES ('2', 'S006', 6);
INSERT INTO `route-stop` (RID, SID, `Order`) VALUES ('2', 'S007', 7);
INSERT INTO `route-stop` (RID, SID, `Order`) VALUES ('2', 'S008', 8);
INSERT INTO `route-stop` (RID, SID, `Order`) VALUES ('2', 'S009', 9);
INSERT INTO `route-stop` (RID, SID, `Order`) VALUES ('2', 'S010', 10);
INSERT INTO `route-stop` (RID, SID, `Order`) VALUES ('2', 'S011', 11);
INSERT INTO `route-stop` (RID, SID, `Order`) VALUES ('2', 'S012', 12);
INSERT INTO `route-stop` (RID, SID, `Order`) VALUES ('2', 'S013', 13);
INSERT INTO `route-stop` (RID, SID, `Order`) VALUES ('2', 'S014', 14);
INSERT INTO `route-stop` (RID, SID, `Order`) VALUES ('2', 'S015', 15);
INSERT INTO `route-stop` (RID, SID, `Order`) VALUES ('2', 'S016', 16);
INSERT INTO `route-stop` (RID, SID, `Order`) VALUES ('2', 'S017', 17);
INSERT INTO `route-stop` (RID, SID, `Order`) VALUES ('3', 'S024', 7);
INSERT INTO `route-stop` (RID, SID, `Order`) VALUES ('3', 'S025', 8);
INSERT INTO `route-stop` (RID, SID, `Order`) VALUES ('3', 'S026', 9);
INSERT INTO `route-stop` (RID, SID, `Order`) VALUES ('3', 'S027', 10);
INSERT INTO `route-stop` (RID, SID, `Order`) VALUES ('3', 'S028', 11);
INSERT INTO `route-stop` (RID, SID, `Order`) VALUES ('3', 'S030', 13);
INSERT INTO `route-stop` (RID, SID, `Order`) VALUES ('3', 'S031', 14);
INSERT INTO `route-stop` (RID, SID, `Order`) VALUES ('3', 'S035', 1);
INSERT INTO `route-stop` (RID, SID, `Order`) VALUES ('3', 'S036', 2);
INSERT INTO `route-stop` (RID, SID, `Order`) VALUES ('3', 'S037', 3);
INSERT INTO `route-stop` (RID, SID, `Order`) VALUES ('3', 'S038', 4);
INSERT INTO `route-stop` (RID, SID, `Order`) VALUES ('3', 'S039', 5);
INSERT INTO `route-stop` (RID, SID, `Order`) VALUES ('3', 'S040', 6);
INSERT INTO `route-stop` (RID, SID, `Order`) VALUES ('3', 'S041', 12);
INSERT INTO `route-stop` (RID, SID, `Order`) VALUES ('3', 'S042', 15);
INSERT INTO `route-stop` (RID, SID, `Order`) VALUES ('3', 'S043', 16);
INSERT INTO `route-stop` (RID, SID, `Order`) VALUES ('3', 'S044', 17);
INSERT INTO `route-stop` (RID, SID, `Order`) VALUES ('3', 'S045', 18);
INSERT INTO `route-stop` (RID, SID, `Order`) VALUES ('3', 'S046', 19);
INSERT INTO `route-stop` (RID, SID, `Order`) VALUES ('3', 'S047', 20);
INSERT INTO `route-stop` (RID, SID, `Order`) VALUES ('3', 'S048', 21);
INSERT INTO `route-stop` (RID, SID, `Order`) VALUES ('3', 'S049', 22);
INSERT INTO `route-stop` (RID, SID, `Order`) VALUES ('3', 'S050', 23);
INSERT INTO `route-stop` (RID, SID, `Order`) VALUES ('3', 'S051', 24);
INSERT INTO `route-stop` (RID, SID, `Order`) VALUES ('3', 'S052', 25);
INSERT INTO `route-stop` (RID, SID, `Order`) VALUES ('4', 'S001', 18);
INSERT INTO `route-stop` (RID, SID, `Order`) VALUES ('4', 'S004', 17);
INSERT INTO `route-stop` (RID, SID, `Order`) VALUES ('4', 'S030', 12);
INSERT INTO `route-stop` (RID, SID, `Order`) VALUES ('4', 'S031', 11);
INSERT INTO `route-stop` (RID, SID, `Order`) VALUES ('4', 'S042', 10);
INSERT INTO `route-stop` (RID, SID, `Order`) VALUES ('4', 'S043', 9);
INSERT INTO `route-stop` (RID, SID, `Order`) VALUES ('4', 'S053', 1);
INSERT INTO `route-stop` (RID, SID, `Order`) VALUES ('4', 'S054', 2);
INSERT INTO `route-stop` (RID, SID, `Order`) VALUES ('4', 'S055', 3);
INSERT INTO `route-stop` (RID, SID, `Order`) VALUES ('4', 'S056', 4);
INSERT INTO `route-stop` (RID, SID, `Order`) VALUES ('4', 'S057', 5);
INSERT INTO `route-stop` (RID, SID, `Order`) VALUES ('4', 'S058', 6);
INSERT INTO `route-stop` (RID, SID, `Order`) VALUES ('4', 'S059', 7);
INSERT INTO `route-stop` (RID, SID, `Order`) VALUES ('4', 'S060', 8);
INSERT INTO `route-stop` (RID, SID, `Order`) VALUES ('4', 'S061', 13);
INSERT INTO `route-stop` (RID, SID, `Order`) VALUES ('4', 'S062', 14);
INSERT INTO `route-stop` (RID, SID, `Order`) VALUES ('4', 'S063', 15);
INSERT INTO `route-stop` (RID, SID, `Order`) VALUES ('4', 'S064', 16);
INSERT INTO `route-stop` (RID, SID, `Order`) VALUES ('7', 'S008', 18);
INSERT INTO `route-stop` (RID, SID, `Order`) VALUES ('7', 'S009', 17);
INSERT INTO `route-stop` (RID, SID, `Order`) VALUES ('7', 'S028', 10);
INSERT INTO `route-stop` (RID, SID, `Order`) VALUES ('7', 'S032', 4);
INSERT INTO `route-stop` (RID, SID, `Order`) VALUES ('7', 'S033', 3);
INSERT INTO `route-stop` (RID, SID, `Order`) VALUES ('7', 'S038', 22);
INSERT INTO `route-stop` (RID, SID, `Order`) VALUES ('7', 'S041', 11);
INSERT INTO `route-stop` (RID, SID, `Order`) VALUES ('7', 'S042', 5);
INSERT INTO `route-stop` (RID, SID, `Order`) VALUES ('7', 'S043', 6);
INSERT INTO `route-stop` (RID, SID, `Order`) VALUES ('7', 'S059', 9);
INSERT INTO `route-stop` (RID, SID, `Order`) VALUES ('7', 'S061', 12);
INSERT INTO `route-stop` (RID, SID, `Order`) VALUES ('7', 'S062', 13);
INSERT INTO `route-stop` (RID, SID, `Order`) VALUES ('7', 'S065', 1);
INSERT INTO `route-stop` (RID, SID, `Order`) VALUES ('7', 'S066', 2);
INSERT INTO `route-stop` (RID, SID, `Order`) VALUES ('7', 'S067', 7);
INSERT INTO `route-stop` (RID, SID, `Order`) VALUES ('7', 'S068', 8);
INSERT INTO `route-stop` (RID, SID, `Order`) VALUES ('7', 'S069', 14);
INSERT INTO `route-stop` (RID, SID, `Order`) VALUES ('7', 'S070', 15);
INSERT INTO `route-stop` (RID, SID, `Order`) VALUES ('7', 'S071', 16);
INSERT INTO `route-stop` (RID, SID, `Order`) VALUES ('7', 'S072', 19);
INSERT INTO `route-stop` (RID, SID, `Order`) VALUES ('7', 'S073', 20);
INSERT INTO `route-stop` (RID, SID, `Order`) VALUES ('7', 'S074', 21);
INSERT INTO `route-stop` (RID, SID, `Order`) VALUES ('7', 'S075', 23);
INSERT INTO `route-stop` (RID, SID, `Order`) VALUES ('7', 'S076', 24);
INSERT INTO `route-stop` (RID, SID, `Order`) VALUES ('7', 'S077', 25);
INSERT INTO `route-stop` (RID, SID, `Order`) VALUES ('7', 'S078', 26);
INSERT INTO `route-stop` (RID, SID, `Order`) VALUES ('7', 'S079', 27);

/* admin */	/* Password plaintext:123456789 */
INSERT INTO `admin` (AID, Password) VALUES ('admin01', 'RmjJCAAXqVAvr9EQsKb5jQ==');
```

#### 更多背景

This project is submitted as a course design for the 2022 class of database system principles in the School of Computer Science and Technology of `Wuhan University of Science and Technology`. The inspiration for the topic comes from the software engineering training topic of `Hubei Normal University`.

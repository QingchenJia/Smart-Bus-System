# Smart Bus System

#### 介绍
A smart public transport system that integrates passengers, drivers, and administrators.

#### 软件架构

This project uses `Maven` to build the project. 
Import `MyBatis` to connect to a MySQL database.
Import `slf4j`logs, and print the log information in the console.

The three identities of passenger, driver, and administrator are all designed with corresponding login entrances. For ordinary users: passengers and drivers, the function of registering and retrieving passwords is designed.

Passengers can change their personal information and change their password. Query information for all bus routes and stops, including searching for navigation routes between any two stops.
Drivers are able to query and modify personal information and change passwords. Be able to keep track of their schedule.
Administrators are able to make edits to the vehicle and make changes to the driver's schedule.


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

#### 数据库

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

#### 更多背景

This project is submitted as a course design for the 2022 class of database system principles in the School of Computer Science and Technology of `Wuhan University of Science and Technology`. The inspiration for the topic comes from the software engineering training topic of `Hubei Normal University`.

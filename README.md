# Smart Bus System

#### 介绍
A smart public transport system that integrates passengers, drivers, and administrators.

#### 软件架构

This project uses `Maven` to build the project. 
Import `mybatis` to connect to a `MySQL` database.
Import `slf4j` logs, and print the log information in the console.
Import `poi-ooxml` to export tables to local directory.
Import `bouncycastle` for information security protection.

#### 基本功能

The three identities of passenger, driver, and administrator are all designed with corresponding login entrances. For ordinary users: passengers and drivers, the function of registering and retrieving passwords is designed.

Passengers can change their personal information and change their password. Query information for all bus routes and stops, including searching for navigation routes between any two stops.
Drivers are able to query and modify personal information and change passwords. Be able to keep track of their schedule.
Administrators are able to make edits to the vehicle and make changes to the driver's schedule.

In particular, in order to ensure the basic security of the password, the project uses the AES symmetric encryption algorithm to perform the ciphertext conversion. In addition, the table export function is supported, and the export file can be found in the `data/export-excel` directory.


#### 使用说明

This project is a stand-alone program, but the code logic has a certain degree of generality. Therefore, if you want to run this project on your own device, you will need to configure your local database accordingly, and make appropriate changes to the project `MybatisConfig.xml` make the appropriate modifications.

#### 关系模式

There are 8 relationship patterns in the database: user, driver, admin, stop, route, route-stop, bus, and schedule.

In order to present the operation effect of the project, the schema creation `relationship-patterns.sql`, and the data entry `demo-data.sql` have been organized into the `data` directory.

```shell
cd ./data
mysql -u root -p
source ./relationship-patterns.sql
source ./demo-data.sql
```

#### 打包运行

In addition to running the project through the IDE, you can also use `Maven` to package it into a jar package and run it through a command-line tool such as `CMD` and `PowerShell`.

```shell
cd .
mvn clean package
cd ./target
java -jar SmartBusSystem-1.0-SNAPSHOT-jar-with-dependencies.jar
```

#### 更多背景

This project is submitted as a course design for the 2022 class of database system principles in the School of Computer Science and Technology of `Wuhan University of Science and Technology`. The inspiration for the topic comes from the software engineering training topic of `Hubei Normal University`.

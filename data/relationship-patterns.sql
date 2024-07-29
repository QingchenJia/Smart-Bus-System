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
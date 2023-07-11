drop database if exists jsShopBackend;

create database jsShopBackend;

use jsShopBackend;

drop table if exists tblProdukt;

create table tblProdukt (
	P_ID int not null primary key auto_increment,
    P_Artikelnummer varchar(30) not null,
	P_Produktname varchar(30) not null,
    P_Produktpreis decimal(5, 2) not null,
    P_Hersteller varchar(30) not null,
    P_Bild varchar(30) not null
);
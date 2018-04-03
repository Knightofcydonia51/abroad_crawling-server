drop table SHINHAN;
drop table HANA;
drop table WOORI;
drop table KB;
drop table NH;


create table SHINHAN(
	crawltime varchar2(30) primary key,
	buyD varchar2(15) not null,
	sellD varchar2(15) not null,
	buyE varchar2(15) not null,
	sellE varchar2(15) not null,
	buyYu varchar2(15) not null,
	sellYu varchar2(15) not null,
	buyYe varchar2(15) not null,
	sellYe varchar2(15) not null
	);
create table HANA(
	crawltime varchar2(30) primary key,
	buyD varchar2(15) not null,
	sellD varchar2(15) not null,
	buyE varchar2(15) not null,
	sellE varchar2(15) not null,
	buyYu varchar2(15) not null,
	sellYu varchar2(15) not null,
	buyYe varchar2(15) not null,
	sellYe varchar2(15) not null
	);
create table WOORI(
	crawltime varchar2(50) primary key,
	buyD varchar2(20) not null,
	sellD varchar2(50) not null,
	buyE varchar2(50) not null,
	sellE varchar2(50) not null,
	buyYu varchar2(50) not null,
	sellYu varchar2(50) not null,
	buyYe varchar2(50) not null,
	sellYe varchar2(50) not null
	);
create table KB(
	crawltime varchar2(50) primary key,
	buyD varchar2(20) not null,
	sellD varchar2(50) not null,
	buyE varchar2(50) not null,
	sellE varchar2(50) not null,
	buyYu varchar2(50) not null,
	sellYu varchar2(50) not null,
	buyYe varchar2(50) not null,
	sellYe varchar2(50) not null
	);
create table NH(
	crawltime varchar2(50) primary key,
	buyD varchar2(20) not null,
	sellD varchar2(50) not null,
	buyE varchar2(50) not null,
	sellE varchar2(50) not null,
	buyYu varchar2(50) not null,
	sellYu varchar2(50) not null,
	buyYe varchar2(50) not null,
	sellYe varchar2(50) not null
	);

insert into EXCHANGE values(orderId.nextval, 'kpc', '2018/03/15/10:59:25', 'true','1', '200', '1200', '5555');

create sequence orderId start with 1 increment by 1;

select t_id from EXCHANGE where u_id='kpc111' and t_time='2018/03/15/10:59:25';
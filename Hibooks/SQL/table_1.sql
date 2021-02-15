drop table MEMBER;
drop table BOOK;
drop sequence BOOK_SEQ;
purge recyclebin;

create table MEMBER(
	M_EMAIL varchar2(50 char) constraint M_EMAIL_PK primary key,
	M_PWD varchar2(15 char) not null,
	M_NAME varchar2(20 char) not null,
	M_PHONE varchar2(15 char) not null
);
	
--	부가정보는 회원이메일을 참조해서 나중에 자식테이블을 추가해 줄 수 도 있다.
--	M_NICK varchar2,
--	M_JOB varchar2,
--	M_ADDR varchar2,
--	M_BIRTH date,
--	M_MILES number


create table BOOK(
	B_SEQ number, -- 입력순 >> 인기순
	B_ITEMID varchar2(50 char) constraint BOOK_PK primary key,
	B_TITLE varchar2(100 char),
	B_IMG varchar2(200 char),
	B_RATE number,
	B_WRITER varchar2(50 char),
	B_PUBLISHER varchar2(100 char),
	B_PRICE number,
	B_DESC clob
	);

create sequence BOOK_SEQ increment by 1 start with 1 nocache;

create table ADMIN(
	A_EMAIL varchar2(50 char) constraint ADMIN_PK primary key,
	A_PWD varchar2(15 char) not null,
	A_NAME varchar2(20 char) not null,
	A_GRADE varchar2(2 char)
	);

insert into ADMIN values('admin1@gmail.com','1111qqqq````','신동오', null);
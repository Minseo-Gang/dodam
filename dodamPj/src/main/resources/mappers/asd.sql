--사용자 정보 테이블
create table user_info(
    user_id varchar2(20) primary key,
    user_pw varchar2(18) not null,
    user_name varchar2(20) not null,
    user_email varchar2(30),
    phoneNum varchar2(30) default 0,
    user_birth number(10) not null,
    auth_level number default 0
);

--관리자 정보 테이블
create table admin_member(
    admin_id varchar2(20) primary key,
    admin_pw varchar2(18) not null,
    admin_name varchar2(20) not null
);

create table animal_lost(
    a_no number primary key,
    a_name varchar2(20) not null,
    a_age varchar2(18) not null,
    a_type varchar2(20) not null,
    a_gender varchar2(30),
    lost_place varchar2(500)
   
    
);

--공지 사항 테이블
create table notice(
    n_no number primary key,
    n_title varchar2(100),
    n_content varchar2(1000),
    n_date timestamp default sysdate,
    n_readcount number default 0,
    n_group number default 0,
    n_seq number default 0,
    n_level number default 0,
    n_filepath varchar2(200)
);


--자유 게시판 테이블
create table tbl_board(
    t_no number CONSTRAINT pk_board_tno primary key,
    t_title varchar2(50) not null,
    user_id varchar2(20) references user_info(user_id),
    t_content varchar2(500),
    t_date timestamp default sysdate,
    t_readcount number default 0,
    t_group number default 0,
    t_seq number default 0,
    t_level number default 0,
    t_filepath varchar2(200)
);


insert into user_info(user_id,user_pw,user_name,user_email,phoneNum,user_birth,auth_level)
values('admin01','1234','관리자','admin@gmail.com','0100000000',950403,1);



insert into admin_member(admin_id, admin_pw, admin_name)
values('admin02','1234','관리자');

create sequence seq_board_no;
create sequence seq_notice_no;

select * from admin_member
		where admin_id = 'admin01'
		and admin_pw = '1234';
commit;
drop table user_info;
drop table tbl_board;
drop table admin_member;
drop table notice;

commit;

select * from tbl_board;
select * from user_info;

select* from notice;

select * from notice
		where n_no = 1;
commit;
select * from user_info where user_name='홍순이' and phoneNum='0100000000';

drop sequence seq_notice_no;													
create sequence seq_notice_no;												
truncate table notice; -- rollback 안됨													
 delete from tbl_board;											
													
BEGIN													
	FOR I IN 1..300 LOOP												
		INSERT INTO tbl_board(T_NO, T_TITLE, T_CONTENT,user_id, T_GROUP)											
		VALUES (											
			seq_board_no.NEXTVAL,										
			'제목' || I,										
			'내용' || I,	
            '홍길동' || I,																			
seq_board_no.NEXTVAL													
		);											
	END LOOP;												
END;													
/													
													
commit;													
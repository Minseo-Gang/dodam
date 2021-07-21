-- 유실동물 신고 관련
create table tbl_lost (
    b_no number primary key,
    b_title varchar2(50) not null,
    user_name varchar2(10) not null,
    user_email varchar2(50),
    user_tel varchar2(20) not null,
    write_date timestamp default sysdate,
    b_viewcnt number,
    p_name varchar2(10) not null,
    p_species varchar2(20) not null,
    p_age varchar2(20) not null,
    p_gender varchar2(10) not null,
    p_lostdate timestamp not null,
    p_lostplace varchar2(50) not null,
    p_character varchar2(200)
);

alter table tbl_lost
add (p_picture varchar2(100));
create sequence seq_lost_bno;

-- 첨부파일 테이블1
create table tbl_attach(
    file_name varchar2(200) primary key,
    b_no number references tbl_lost(b_no)
);

-- 첨부파일 테이블2(보호동물)
create table tbl_protectAttach(
    file_name varchar2(200) primary key,
    a_no number references tbl_animal(a_no)
);

select * from tbl_lost
order by b_no desc;

-- 보호중인 유실 동물
create table tbl_animal (
    a_no number primary key,
    a_species varchar2(50) not null,
    a_color varchar2(20) not null,
    a_gender varchar2(10) not null,
    a_age varchar2(10) not null,
    a_weight varchar2(10) not null,
    a_findplace varchar2(50) not null,
    a_enterdate varchar2(30) not null,
    a_neut varchar2(10) not null,
    a_character varchar2(200)
);

alter table tbl_animal
add (a_picture varchar2(100));
alter table tbl_animal
add (a_state varchar2(50));
alter table tbl_animal
modify a_age varchar2(30);

create sequence seq_animal_no;

select * from tbl_animal
order by a_no desc;

commit;

-- 입양관련 테이블
create table tbl_adopt (
    ad_no number primary key,
    ad_adoptstate varchar2(20) not null,
    ad_species varchar2(20) not null,
    ad_kind varchar2(40) not null,
    ad_gender varchar2(10) not null,
    ad_age varchar2(30) not null,
    ad_weight varchar2(20) not null,
    ad_color varchar2(50) not null,
    ad_findplace varchar2(100) not null,
    ad_resqueday varchar2(50) not null,
    ad_adoptpossible varchar2(50),
    ad_etc varchar2(500),
    ad_picture varchar2(100)
);

create sequence seq_adopt_no;

-- 첨부파일 테이블3(입양동물)
create table tbl_adoptAttach(
    file_name varchar2(200) primary key,
    ad_no number references tbl_adopt(ad_no)
);

select * from tbl_adopt;

-- 입양 신청폼 작성
create table tbl_apply_user (
    au_no number primary key,
    user_name varchar2(20) not null,
    user_tel varchar2(10) not null,
    adopt_date varchar2(20) not null,
    adopt_time varchar2(10) not null,
    form_title varchar2(50) not null,
    form_content varchar2(1000) not null,
    form_pw varchar2(20) not null
);

create sequence seq_apply_no;

alter table tbl_apply_user
add (ad_no number references tbl_adopt(ad_no));

alter table tbl_apply_user
modify user_tel varchar2(20);

select * from tbl_apply_user;





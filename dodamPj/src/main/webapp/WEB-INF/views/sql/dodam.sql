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










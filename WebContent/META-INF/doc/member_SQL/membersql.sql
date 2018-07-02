-- 회원
DROP TABLE member;
select * from member;

-- 회원상세
DROP TABLE member_detail;
select * from member_detail;

-- 회원
CREATE TABLE member (
	id       varchar2(16) NOT NULL, -- 아이디
	name     varchar2(20) NULL,     -- 이름
	pass     varchar2(16) NULL,     -- 비밀번호
	email1   varchar2(16) NULL,     -- 이메일1
	email2   varchar2(50) NULL,      -- 이메일2
	joindate date default sysdate,     -- 가입일
	
	constraint member_id_pk primary key (id)
	
);
출처: http://ukja.tistory.com/187 [오라클 성능 문제에 대한 통찰 - 조동욱]

-- 회원상세
CREATE TABLE member_detail (
	id      varchar2(16),  -- 아이디
	tel1   varchar2(3)   NULL, -- 전화번호1
	tel2    varchar2(4)   NULL, -- 전화번호2
	tel3    varchar2(4)   NULL, -- 전화번호3	
	zipcode varchar2(5)   NULL, -- 우편번호
	addr1   varchar2(100) NULL, -- 주소
	addr2   varchar2(100) NULL, -- 상세주소

  constraint member_detail_id_fk foreign key (id)
   references member (id)
	
);


-- 입력
insert all
into member (name, id, pass, email1, email2, joindate)
values ('김','user1', '1234', 'many', 'naver.com', sysdate);
into member_detail (id, zipcode, addr1, addr2, tel1, tel2, tel3)
values ('user1', '12345', 'addr1', 'addr2', '010', '1234', '5678')
select * from dual;

insert
into member (name, id, pass, email1, email2, joindate)
values ('김','user1', '1234', 'many', 'naver.com', sysdate);

insert
into member_detail (id, zipcode, addr1, addr2, tel1, tel2, tel3)
values ('user1', '12345', 'addr1', 'addr2', '010', '1234', '5678');
select * from dual;

insert
into member (name, id, pass, email1, email2, joindate)
values ('김','user2', '1234', 'many', 'naver.com', sysdate);

insert
into member_detail (id, zipcode, addr1, addr2, tel1, tel2, tel3)
values ('user2', '12345', 'addr1', 'addr2', '010', '1234', '5678');
select * from dual;

insert
into member (name, id, pass, email1, email2, joindate)
values ('김','admin', '1234', 'many', 'naver.com', sysdate);

insert
into member_detail (id, zipcode, addr1, addr2, tel1, tel2, tel3)
values ('admin', '12345', 'addr1', 'addr2', '010', '1234', '5678');
select * from dual;

insert
into member (name, id, pass, email1, email2, joindate)
values ('김','admin2', '1234', 'many', 'naver.com', sysdate);

insert
into member_detail (id, zipcode, addr1, addr2, tel1, tel2, tel3)
values ('admin2', '12345', 'addr1', 'addr2', '010', '1234', '5678');
select * from dual;

select * from MEMBER_DETAIL;
select * from MEMBER;


--수정
update member 
set 
name = '김정남',
pass='1234',
email1 = 'mama', 
email2 = 'naver.com', 
joindate = sysdate
where id = 'user1';

commit

update member_detail 
set 
zipcode = '12345', 
addr1 = '123', 
addr2 = '123', 
tel1 = '012', 
tel2 = '1234', 
tel3 = '1234'
where id = 'user1';

commit

rollback

-------------------------------------------------------
mysql 지원 오라클 지원 안함
			
update 
(
	SELECT m.id as m_id, m.name as m_name, m.pass as m_pass, m.email1 as m_email1, m.email2 as m_email2,
	       m.joindate as m_joindate, 
    	  md.id as md_id, md.zipcode as md_zipcode, md.addr1 as md_addr1, md.addr2 as md_addr2, md.tel1 as md_tel1, md.tel2 as md_tel2,  
      	  md.tel3 as md_tel3 
    FROM member m, MEMBER_DETAIL md
	where m.id = md.id
	and m.id = 'user1'
) 
set 
m_name = '김정남';

m_email1 = 'mama', 
m_email2 = 'naver.com', 
m_joindate = sysdate , 
md_zipcode = '12345', 
md_addr1 = '123', 
md_addr2 = '123', 
md_tel1 = '012', 
md_tel2 = '1234', 
md_tel3 = '1234'; 

-------------------------------------------------------

--탈퇴
delete from member_detail where id = 'user2';
delete from member where id = 'user2';

--id 찾기
select m.id
from member m 
where m.name = '김' 
and m.email1 = 'many'
and m.email2 = 'naver.com';

select * from
member;

--pass 찾기
select m.pass
from member m 
where m.name = '김' 
and m.email1 = 'many'
and m.email2 = 'naver.com'
and m.id = 'user1';

--id 찾기
select m.id
from member m 
where m.name = '김' 
and m.email1 = 'many'
and m.email2 = 'naver.com'
and m.id = 'user1';

--pass 변경
update member m
set m.pass = '1234'
where m.name = '김' 
and m.email1 = 'many'
and m.email2 = 'naver.com'
and m.id = 'user1';

--비밀번호 바꾸기
update member m
set m.pass = '1234'
where m.id = 'user1';

--조회
select * 
from member
where id = 'many4354137';
--커밋
commit

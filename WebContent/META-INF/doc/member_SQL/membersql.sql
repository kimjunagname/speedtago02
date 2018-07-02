-- ȸ��
DROP TABLE member;
select * from member;

-- ȸ����
DROP TABLE member_detail;
select * from member_detail;

-- ȸ��
CREATE TABLE member (
	id       varchar2(16) NOT NULL, -- ���̵�
	name     varchar2(20) NULL,     -- �̸�
	pass     varchar2(16) NULL,     -- ��й�ȣ
	email1   varchar2(16) NULL,     -- �̸���1
	email2   varchar2(50) NULL,      -- �̸���2
	joindate date default sysdate,     -- ������
	
	constraint member_id_pk primary key (id)
	
);
��ó: http://ukja.tistory.com/187 [����Ŭ ���� ������ ���� ���� - ������]

-- ȸ����
CREATE TABLE member_detail (
	id      varchar2(16),  -- ���̵�
	tel1   varchar2(3)   NULL, -- ��ȭ��ȣ1
	tel2    varchar2(4)   NULL, -- ��ȭ��ȣ2
	tel3    varchar2(4)   NULL, -- ��ȭ��ȣ3	
	zipcode varchar2(5)   NULL, -- �����ȣ
	addr1   varchar2(100) NULL, -- �ּ�
	addr2   varchar2(100) NULL, -- ���ּ�

  constraint member_detail_id_fk foreign key (id)
   references member (id)
	
);


-- �Է�
insert all
into member (name, id, pass, email1, email2, joindate)
values ('��','user1', '1234', 'many', 'naver.com', sysdate);
into member_detail (id, zipcode, addr1, addr2, tel1, tel2, tel3)
values ('user1', '12345', 'addr1', 'addr2', '010', '1234', '5678')
select * from dual;

insert
into member (name, id, pass, email1, email2, joindate)
values ('��','user1', '1234', 'many', 'naver.com', sysdate);

insert
into member_detail (id, zipcode, addr1, addr2, tel1, tel2, tel3)
values ('user1', '12345', 'addr1', 'addr2', '010', '1234', '5678');
select * from dual;

insert
into member (name, id, pass, email1, email2, joindate)
values ('��','user2', '1234', 'many', 'naver.com', sysdate);

insert
into member_detail (id, zipcode, addr1, addr2, tel1, tel2, tel3)
values ('user2', '12345', 'addr1', 'addr2', '010', '1234', '5678');
select * from dual;

insert
into member (name, id, pass, email1, email2, joindate)
values ('��','admin', '1234', 'many', 'naver.com', sysdate);

insert
into member_detail (id, zipcode, addr1, addr2, tel1, tel2, tel3)
values ('admin', '12345', 'addr1', 'addr2', '010', '1234', '5678');
select * from dual;

insert
into member (name, id, pass, email1, email2, joindate)
values ('��','admin2', '1234', 'many', 'naver.com', sysdate);

insert
into member_detail (id, zipcode, addr1, addr2, tel1, tel2, tel3)
values ('admin2', '12345', 'addr1', 'addr2', '010', '1234', '5678');
select * from dual;

select * from MEMBER_DETAIL;
select * from MEMBER;


--����
update member 
set 
name = '������',
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
mysql ���� ����Ŭ ���� ����
			
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
m_name = '������';

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

--Ż��
delete from member_detail where id = 'user2';
delete from member where id = 'user2';

--id ã��
select m.id
from member m 
where m.name = '��' 
and m.email1 = 'many'
and m.email2 = 'naver.com';

select * from
member;

--pass ã��
select m.pass
from member m 
where m.name = '��' 
and m.email1 = 'many'
and m.email2 = 'naver.com'
and m.id = 'user1';

--id ã��
select m.id
from member m 
where m.name = '��' 
and m.email1 = 'many'
and m.email2 = 'naver.com'
and m.id = 'user1';

--pass ����
update member m
set m.pass = '1234'
where m.name = '��' 
and m.email1 = 'many'
and m.email2 = 'naver.com'
and m.id = 'user1';

--��й�ȣ �ٲٱ�
update member m
set m.pass = '1234'
where m.id = 'user1';

--��ȸ
select * 
from member;
where id = 'many4354137';
--Ŀ��
commit

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

select * from MEMBER;
select * from MEMBER_DETAIL;

--����


--����


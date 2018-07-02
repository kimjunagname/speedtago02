select m.name, m.id, m.pass, m.email1, m.email2, m.joindate, md.zipcode, md.addr1, md.addr2, md.tel1, md.tel2, md.tel3 
from member m, MEMBER_DETAIL md
where m.id = md.id
and m.id = 'user1';
select * from dual;

select *
from member;


select * from tab;


"insert all \n";
			sql += "into member (name, pass, email1, email2, joindate) \n";
			sql += "values (?, ?, ?, ?, sysdate) \n";
			sql += "into member_detail ( zipcode, addr1, addr2, tel1, tel2, tel3) \n";
			sql += "values ( ?, ?, ?, ?, ?, ?)";
			sql += "select * from dual";
	
			
alter table member add constraint member_id_pk primary key (id);			
			
alter view member compile;
alter view member_detail compile;

select 
  column_name, updatable, insertable, deletable
from 
  user_updatable_columns
where
  table_name = 'member';		
			





select * from member_detail;
select * from member;







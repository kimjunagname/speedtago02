select m.name, m.id, m.pass, m.email1, m.email2, m.joindate, md.zipcode, md.addr1, md.addr2, md.tel1, md.tel2, md.tel3 
from member m, MEMBER_DETAIL md
where m.id = md.id
and m.id = 'user1';
select * from dual;

select *
from member;


select * from tab;
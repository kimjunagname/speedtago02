 


---2����---
/board �Ϲ�
/reboard �亯
/album ����
/bbs �ڷ��
/memo 

doc > board_create_table ����

����.sql�� �Ʒ� ���� ����־�д� �Ѱ��� ��Ƽ� �����Ѵ�. ���߿�xml�� ���ؼ� �̿��Ѵ�.
--------------------sql ������-------------------------
select b.bcode, b.bname, b.btype, c.ccode, c.cname,

	case
		when b.btype = 5 then 'reboard'
		when b.btype = 6 then 'album'
		when b.btype = 6 then 'bbs'
	end control

from board_list b, category c
where b.ccode = c.ccode
order by bcode asc
------------------------------------------------------

db�� �������, javascript�� ��������, jstl�� ������� ��Ȳ���� �� �����غ����Ѵ�. ��� ������ ���ϰ� ��������.

-------------------------------------------------------
jsp���� ��Ʈ�ѷ� ������ act���� 5���� ���� ��.
��Ʈ�ѷ����� �������� ������ act�� �ʿ����~ bcode, pg, key, word�� ���� ��~

-��ü �Ѱ� �ϸ� �̱��� �������� �ȴ�.

-writeaction 6�� �� �̱��� ����� / ���丮 ����׼ǿ� �� �޼ҵ�

-
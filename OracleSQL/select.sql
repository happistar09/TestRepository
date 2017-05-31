/*
SELECT ��
*/
-- bwriter�� ȫ�浿�� ��� �÷��� ���� �������ÿ�
select *
from board
where bwriter='ȫ�浿';
-- bwriter�� ȫ�浿�� bno, btitle, bwriter�� �������ÿ�
select bno, btitle, bwriter
from board
where bwriter='ȫ�浿';
-- bno�� 1���� 10������ �Խù��� �������ÿ�
select bno, btitle, bwriter
from board
where bno>=1 and bno<=10;
-- bwriter�� 'ȫ'�� �����ϴ� �Խù��� bno, btitle, bwriter�� �������ÿ�
select bno, btitle, bwriter
from board
where bwriter like '%ȫ%';
-- �Խù��� ����, ���� �߿� '�ڹ�'�� ���ԵǾ� �ִ� �Խù��� ��ȣ, ����, �۾���, ������ �������ÿ�
select bno, btitle, bwriter, bcontent
from board
where btitle like '%�ڹ�%' or bcontent like '%�ڹ�%';
-- �۾��̰� '���ڹ�', '��浿', '�����'�� �Խù��� ��ȣ, ����, �۾���, ������ �������ÿ�
select bno, btitle, bwriter, bcontent
from board
where bwriter in('���ڹ�', '��浿', '�����');
-- ÷�� ������ ���� �Խù��� �������ÿ�
select *
from board
where boriginalfilename is null;
-- ÷�� ������ �ִ� �Խù��� �������ÿ�.
select *
from board
where boriginalfilename is not null;
-- �Խù��� �ۼ��� ����� �̸��� �������ÿ�(�ߺ� �����ϰ�)
select distinct bwriter from board;
-- �Խñ��� �� ��¥�� 2016���� �Խñ��� �������ÿ�
select *
from board
where bdate between '2016.01.01' and '2016.12.31';
-- bno->��ȣ, btitle->����, bwriter->�۾��� �� �÷� �̸��� �����ؼ� �������ÿ�
-- as��������, ���SET�� �̸��� �ٲ�°�
select bno as ��ȣ, btitle as ����, bwriter �۾���
from board;
/*
����
*/
-- �Խù��� ��ȣ�� �������� �ø��������� �������ÿ�
select *
from board
order by bno asc;
-- 2017�⵵�� �ۼ��� �Խù��� ��ȣ�� �������� ������������ �������ÿ�
select *
from board
where bdate between '2017.01.01' and '2017.12.31'
order by bno desc;
-- �۾��̸� �������� 1�� ����(�ø�)�ϰ� ����¥�� �������� 2�� ����(����) �Ͻÿ�
select *
from board
order by bwriter asc, bdate desc;
/*
����¡ ó��
*/
--����Ǿ� �ִ� ������� �� ��ȣ �ű��
select rownum, bno, btitle, bwriter,  bdate, bhitcount
from board;
--���� ��, �� ��ȣ �ű��
select rownum, bno, btitle, bwriter,  bdate, bhitcount
from (select bno, btitle, bwriter, bdate, bhitcount from board order by bno desc);
--Ư�� ���ȣ ���ϸ� ��������(Top N�� ��������)
select rownum, bno, btitle, bwriter,  bdate, bhitcount
from (select bno, btitle, bwriter, bdate, bhitcount from board order by bno desc)
where rownum <=10;
--���� ���ȣ�� �� ���ȣ ������ �Խù� ��������
select *
from (
  select rownum as r, bno, btitle, bwriter,  bdate, bhitcount
  from (
    select bno, btitle, bwriter, bdate, bhitcount from board order by bno desc
  )
  --where rownum<=(pageNo*rowsPerPage)
  where rownum<=(2*15)
)
--where r>=((pageNo-1)*rowsPerPage + 1);
where r>=((2-1)*15+1);
/*
�� �� ���ϱ�
*/
--��ü �� �� ���ϱ�
select count(*) from board;
select count(bno) from board;
select count(boriginalfilename) from board;
--Ư�� ���ǿ� �´� �� �� ���ϱ�
select count(*) from board where bwriter <> 'ȫ�浿';
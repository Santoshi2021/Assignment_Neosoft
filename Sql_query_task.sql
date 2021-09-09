select name, content from(
select t2.name, t2.content, row_number() over (partition by id order by created) as rownum from
(select t1.id, t1.name, c.content, c.created from sys.comment c join
(select id, name from sys.post where authorid = (select id from sys.author where name = 'James Bond')) t1
on c.postid = t1.id
order by t1.id, c.created)t2)t3 where rownum <= 10;

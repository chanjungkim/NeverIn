create table messages(
    message_num number primary key,
    title varchar(50),
    userId varchar(20),
    writeDate varchar(10),
    message varchar(3000)
    );
  
create sequence message_num_seq start with 1 increment by 1;

insert into messages(message_num, title, userId, writeDate, message) values(book_id_seq.nextval, '貝 郊左' , '郊左' , '2017/07/28', 'せせせせせせせせせせせせせせせせせせせせせせせせせせせせせ');

select * from messages;

alter sequence book_id_seq increment by 1;

drop table accounts;
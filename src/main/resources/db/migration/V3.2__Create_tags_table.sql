drop TABLE IF EXISTS TAGS, tags, TAGS_PICTURES, tags_pictures;

create table tags (
    id int not null,
    name varchar(100) not null
);

create table tags_pictures (
    tag_id int not null,
    picture_id int not null
);

insert into tags (id, name) values (1, 'cejrowski');
insert into tags (id, name) values (2, 'terka');
insert into tags (id, name) values (3, 'chinskie');
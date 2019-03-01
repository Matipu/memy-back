create table TAGS (
    id int not null,
    name varchar(100) not null
);

create table TAGS_PICTURES (
    tag_id int not null,
    picture_id int not null
);

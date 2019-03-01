create table TAGS (
    ID int not null,
    NAME varchar(100) not null
);

create table TAGS_PICTURES (
    TAG_ID int not null,
    PICTURE_ID int not null
);

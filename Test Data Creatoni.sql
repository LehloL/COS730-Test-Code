insert into person(id,firstname, surname)
values(100, 'Hlengekile', 'Raphiri');



insert into person(id,firstname, surname)
values(200, 'John', 'Tleane');

insert into person(id,firstname, surname)
values(300, 'Victor', 'Raphiri');

insert into person(id,firstname, surname)
values(400, 'Tsebo', 'Raphiri');

insert into person(id,firstname, surname)
values(500, 'Joseph', 'Mokoena');

insert into person(id,firstname, surname)
values(600, 'Thuli', 'Madonsela');

commit

select * from person;


insert into lifecyclestate(id,bibtexentry, percentagecompleted, publicationdate, state)
values(100,  'Authentication on the cloud1', 90, '03/01/16', 'Published');

insert into lifecyclestate(id,bibtexentry, percentagecompleted, publicationdate, state)
values(200,  'Authentication on the cloud2', 90, '03/02/16', 'Rejected');

insert into lifecyclestate(id,bibtexentry, percentagecompleted, publicationdate, state)
values(300,  'Authentication on the cloud3', 90, '03/03/16', 'Submitted');
insert into lifecyclestate(id,bibtexentry, percentagecompleted, publicationdate, state)
values(500,  'Authentication on the cloud2', 90, '03/05/16', 'In Progres');
insert into lifecyclestate(id,bibtexentry, percentagecompleted, publicationdate, state)
values(600,  'Authentication on the cloud5', 90, '03/06/16', 'In Progres');


select * from  lifecyclestate;


insert into publicationtarget(id,name, website)
values(100,  'IEEEE','www.ieee.com');
insert into publicationtarget(id,name, website)
values(200,  'CAM','www.cam.com');
insert into publicationtarget(id,name, website)
values(300,  'springer','www.springer.com');
insert into publicationtarget(id,name, website)
values(400,  'liever','www.liever.com');
insert into publicationtarget(id,name, website)
values(500,  'mcmillin','www.mcmillin.com');



insert into publicationtarget(id,name, website)
values(600,  'mcmillin','Google');
select * from publicationtarget;

insert into publicationtype(id,name)
values(2,  'VIC_PAPERS');

insert into publicationtype(id,name)
values(100,  'Journal');
insert into publicationtype(id,name)
values(200,  'Book');
insert into publicationtype(id,name)
values(300,  'Conference');


insert into publicationtype(id,name)
values(500,  'Google');


commit

select * from publicationtype;

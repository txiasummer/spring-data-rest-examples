
/*** Person ***/
delete from person;
insert into person(id, firstname, lastname)
values(100, 'Mickey', 'Mouse');

insert into person(id, firstname, lastname)
values(101, 'Minnie', 'Mouse');

insert into person(id, firstname, lastname)
values(102, 'Donald', 'Duck');

insert into person(id, firstname, lastname)
values(103, 'Daisy', 'Duck');

/*** Hobby ***/
delete from hobby;
insert into hobby(id, name, description)
values(100, 'magic', 'learning magic tricks from Hogwarts masters');

insert into hobby(id, name, description)
values(101, 'pranks', 'playing pranks on unsuspecting persons');

/*** Personal_Hobby ***/
delete from personal_hobby;
insert into personal_hobby(id, person_id, hobby_id)
values(100, 100, 100);

insert into personal_hobby(id, person_id, hobby_id)
values(101, 100, 101);

insert into personal_hobby(id, person_id, hobby_id)
values(102, 101, 100);

insert into personal_hobby(id, person_id, hobby_id)
values(103, 101, 101);

_hobby(id, person_id, hobby_id)
values(104, 102, 100);

insert into personal_hobby(id, person_id, hobby_id)
values(104, 103, 101);
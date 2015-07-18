
/*** Person ***/
delete from person;
insert into person(id, first_name, last_name, age)
values(100, 'Mickey', 'Mouse', 21);

insert into person(id, first_name, last_name, age)
values(101, 'Minnie', 'Mouse', 19);

insert into person(id, first_name, last_name, age)
values(102, 'Donald', 'Duck', 29);

insert into person(id, first_name, last_name, age)
values(103, 'Daisy', 'Duck', 26);

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

insert into personal_hobby(id, person_id, hobby_id)
values(104, 102, 100);

insert into personal_hobby(id, person_id, hobby_id)
values(105, 103, 101);
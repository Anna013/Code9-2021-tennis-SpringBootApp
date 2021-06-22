insert into tenniser (id_tenniser, first_name, last_name, email, is_paid, method_of_payment)
 values (1, 'Novak', 'Djokovic', 'novak@gmail.com', '0', NULL);
insert into tenniser (id_tenniser, first_name, last_name, email, is_paid, method_of_payment)
 values (2, 'Roger', 'Federer', 'roger@gmail.com', '0', NULL);
 insert into tenniser (id_tenniser, first_name, last_name, email, is_paid, method_of_payment)
 values (3, 'Rafael', 'Nadal', 'rafa@gmail.com', '0', NULL);
 
 insert into tennis_court (id_court, name)
 values (1, 'Clay court');
 insert into tennis_court (id_court, name)
 values (2, 'Hard court');
 insert into tennis_court (id_court, name)
 values (3, 'Grass court');

 insert into timeslot (id_timeslot, start_time, end_time, date, tenniser_id, court_id)
 values (1, '04:30:00', '05:30:00', 2021-06-16, 1, 1);
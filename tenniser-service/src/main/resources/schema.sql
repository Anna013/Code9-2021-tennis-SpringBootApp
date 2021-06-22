CREATE TABLE `tennis_court` (
  `id_court` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`id_court`),
  UNIQUE KEY `name_UNIQUE` (`name`)
) ;

CREATE TABLE `tenniser` (
  `id_tenniser` int NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) NOT NULL,
  `last_name` varchar(45) NOT NULL,
  `e-mail` varchar(45) NOT NULL,
  `is_paid` tinyint DEFAULT '0',
  `method_of_payment` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_tenniser`),
  UNIQUE KEY `e-mail_UNIQUE` (`e-mail`)
) ;



CREATE TABLE `timeslot` (
  `id_timeslot` int NOT NULL AUTO_INCREMENT,
  `start_time` time DEFAULT NULL,
  `end_time` time DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  `tenniser_id` int DEFAULT NULL,
  `id_court` int DEFAULT NULL,
  PRIMARY KEY (`id_timeslot`)
) ;

create table  tennis_court_timeslots (
 court_id int NOT NULL,
 timeslot_id int NOT NULL
);
alter table tennis_court_timeslots
 add foreign key (court_id) references tennis_court(id_court);
alter table tennis_court_timeslots
 add foreign key (timeslot_id) references timelost(id_timeslot);
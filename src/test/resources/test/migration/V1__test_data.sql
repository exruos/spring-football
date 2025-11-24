CREATE TABLE country
(
    id   INTEGER PRIMARY KEY,
    name TEXT UNIQUE
);

INSERT INTO country VALUES(1,'Belgium');
INSERT INTO country VALUES(1729,'England');
INSERT INTO country VALUES(4769,'France');
INSERT INTO country VALUES(7809,'Germany');
INSERT INTO country VALUES(10257,'Italy');
INSERT INTO country VALUES(13274,'Netherlands');
INSERT INTO country VALUES(15722,'Poland');
INSERT INTO country VALUES(17642,'Portugal');
INSERT INTO country VALUES(19694,'Scotland');
INSERT INTO country VALUES(21518,'Spain');
INSERT INTO country VALUES(24558,'Switzerland');
--
CREATE TABLE league (
                        id	INTEGER PRIMARY KEY,
                        country_id	INTEGER,
                        name	TEXT UNIQUE,
                        FOREIGN KEY(country_id) REFERENCES country(id)
);
INSERT INTO league VALUES(1,1,'Belgium Jupiler league');
INSERT INTO league VALUES(1729,1729,'England Premier league');
INSERT INTO league VALUES(4769,4769,'France Ligue 1');
INSERT INTO league VALUES(7809,7809,'Germany 1. Bundesliga');
INSERT INTO league VALUES(10257,10257,'Italy Serie A');
INSERT INTO league VALUES(13274,13274,'Netherlands Eredivisie');
INSERT INTO league VALUES(15722,15722,'Poland Ekstraklasa');
INSERT INTO league VALUES(17642,17642,'Portugal Liga ZON Sagres');
INSERT INTO league VALUES(19694,19694,'Scotland Premier league');
INSERT INTO league VALUES(21518,21518,'Spain LIGA BBVA');
INSERT INTO league VALUES(24558,24558,'Switzerland Super league');
--
CREATE TABLE IF NOT EXISTS team (
                                    id	INTEGER PRIMARY KEY,
                                    team_api_id	INTEGER UNIQUE,
                                    team_fifa_api_id	INTEGER UNIQUE,
                                    team_long_name	TEXT,
                                    team_short_name	TEXT
);
INSERT INTO team VALUES(1,9987,673,'KRC Genk','GEN');
INSERT INTO team VALUES(2,9993,675,'Beerschot AC','BAC');
INSERT INTO team VALUES(3,10000,15005,'SV Zulte-Waregem','ZUL');
INSERT INTO team VALUES(4,9994,2007,'Sporting Lokeren','LOK');
INSERT INTO team VALUES(5,9984,1750,'KSV Cercle Brugge','CEB');
INSERT INTO team VALUES(43053,9906,240,'Atlético Madrid','AMA');
INSERT INTO team VALUES(45330,7878,110832,'Granada CF','GRA');
--
CREATE TABLE player (
                        id	INTEGER PRIMARY KEY,
                        player_api_id	INTEGER UNIQUE,
                        player_name	TEXT,
                        player_fifa_api_id	INTEGER UNIQUE,
                        birthday	TEXT,
                        height	INTEGER,
                        weight	INTEGER
);
INSERT INTO player VALUES(1,505942,'Aaron Appindangoye',218353,'1992-02-29 00:00:00',182.8799999999999955,187);
INSERT INTO player VALUES(2,155782,'Aaron Cresswell',189615,'1989-12-15 00:00:00',170.1800000000000068,146);
INSERT INTO player VALUES(3,162549,'Aaron Doran',186170,'1991-05-13 00:00:00',170.1800000000000068,163);
INSERT INTO player VALUES(4,30572,'Aaron Galindo',140161,'1982-05-08 00:00:00',182.8799999999999955,198);
INSERT INTO player VALUES(5,23780,'Aaron Hughes',17725,'1979-11-08 00:00:00',182.8799999999999955,154);
INSERT INTO player VALUES(6,27316,'Aaron Hunt',158138,'1986-09-04 00:00:00',182.8799999999999955,161);
INSERT INTO player VALUES(7,564793,'Aaron Kuhl',221280,'1996-01-30 00:00:00',172.7199999999999989,146);
INSERT INTO player VALUES(8,30895,'Aaron Lennon',152747,'1987-04-16 00:00:00',165.0999999999999944,139);
INSERT INTO player VALUES(9,528212,'Aaron Lennox',206592,'1993-02-19 00:00:00',190.5,181);
INSERT INTO player VALUES(10,101042,'Aaron Meijers',188621,'1987-10-28 00:00:00',175.259999999999991,170);
INSERT INTO player VALUES(11,23889,'Aaron Mokoena',47189,'1980-11-25 00:00:00',182.8799999999999955,181);
INSERT INTO player VALUES(12,231592,'Aaron Mooy',194958,'1990-09-15 00:00:00',175.259999999999991,150);
INSERT INTO player VALUES(13,163222,'Aaron Muirhead',213568,'1990-08-30 00:00:00',187.9600000000000079,168);
INSERT INTO player VALUES(14,40719,'Aaron Niguez',183853,'1989-04-26 00:00:00',170.1800000000000068,143);
INSERT INTO player VALUES(15,75489,'Aaron Ramsey',186561,'1990-12-26 00:00:00',177.8000000000000113,154);
INSERT INTO player VALUES(16,597948,'Aaron Splaine',226014,'1996-10-13 00:00:00',172.7199999999999989,163);
INSERT INTO player VALUES(17,161644,'Aaron Taylor-Sinclair',213569,'1991-04-08 00:00:00',182.8799999999999955,176);
INSERT INTO player VALUES(18,23499,'Aaron Wilbraham',2335,'1979-10-21 00:00:00',190.5,159);
INSERT INTO player VALUES(19,120919,'Aatif Chahechouhe',187939,'1986-07-02 00:00:00',175.259999999999991,150);
INSERT INTO player VALUES(20,46447,'Abasse Ba',156626,'1976-07-12 00:00:00',187.9600000000000079,185);
INSERT INTO player VALUES(21,167027,'Abdelaziz Barrada',192274,'1989-06-19 00:00:00',177.8000000000000113,161);
INSERT INTO player VALUES(22,245653,'Abdelfettah Boukhriss',202425,'1986-10-22 00:00:00',185.4199999999999875,161);
INSERT INTO player VALUES(23,128456,'Abdelhamid El Kaoutari',188145,'1990-03-17 00:00:00',180.3400000000000034,161);
INSERT INTO player VALUES(24,42664,'Abdelkader Ghezzal',178063,'1984-12-05 00:00:00',182.8799999999999955,172);
INSERT INTO player VALUES(25,425950,'Abdellah Zoubir',212934,'1991-12-05 00:00:00',180.3400000000000034,161);
INSERT INTO player VALUES(26,38423,'Abdelmajid Oulmers',52782,'1978-09-12 00:00:00',172.7199999999999989,143);
INSERT INTO player VALUES(27,3264,'Abdelmalek Cherrad',51868,'1981-01-14 00:00:00',185.4199999999999875,165);
INSERT INTO player VALUES(28,467485,'Abdelmalek El Hasnaoui',209399,'1994-02-09 00:00:00',180.3400000000000034,159);
INSERT INTO player VALUES(29,306735,'Abdelouahed Chakhsi',210504,'1986-10-01 00:00:00',182.8799999999999955,170);
INSERT INTO player VALUES(30,41659,'Abderrazak Jadid',149241,'1983-06-01 00:00:00',177.8000000000000113,157);
INSERT INTO player VALUES(31,31684,'Abdeslam Ouaddou',33022,'1978-11-01 00:00:00',190.5,181);
INSERT INTO player VALUES(32,32637,'Abdessalam Benjelloun',177295,'1985-01-28 00:00:00',187.9600000000000079,179);
INSERT INTO player VALUES(33,563215,'Abdou Diallo',225711,'1996-05-04 00:00:00',182.8799999999999955,159);
INSERT INTO player VALUES(34,41093,'Abdou Traore',187048,'1988-01-17 00:00:00',180.3400000000000034,174);
INSERT INTO player VALUES(35,564712,'Abdoul Ba',225050,'1994-02-08 00:00:00',200.6599999999999966,212);
INSERT INTO player VALUES(36,67334,'Abdoul Karim Yoda',188232,'1988-10-25 00:00:00',182.8799999999999955,161);
INSERT INTO player VALUES(37,173955,'Abdoul Razzagui Camara',193953,'1990-02-20 00:00:00',177.8000000000000113,157);
INSERT INTO player VALUES(38,39562,'Abdoulay Konko',161999,'1984-03-09 00:00:00',182.8799999999999955,157);
INSERT INTO player VALUES(39,191784,'Abdoulaye Ba',204826,'1991-01-01 00:00:00',198.1200000000000045,174);
INSERT INTO player VALUES(40,210400,'Abdoulaye Bamba',199313,'1990-04-25 00:00:00',182.8799999999999955,150);
INSERT INTO player VALUES(41,201915,'Abdoulaye Diaby',202330,'1991-05-21 00:00:00',172.7199999999999989,154);
INSERT INTO player VALUES(42,194479,'Abdoulaye Diallo Sadio,22',204171,'1990-12-28 00:00:00',182.8799999999999955,168);
INSERT INTO player VALUES(43,189181,'Abdoulaye Diallo',197233,'1992-03-30 00:00:00',187.9600000000000079,174);
INSERT INTO player VALUES(44,352887,'Abdoulaye Doucoure',208135,'1993-01-01 00:00:00',182.8799999999999955,165);
INSERT INTO player VALUES(45,40005,'Abdoulaye Faye',100329,'1978-02-26 00:00:00',187.9600000000000079,218);
INSERT INTO player VALUES(46,409003,'Abdoulaye Keita',212280,'1994-01-05 00:00:00',175.259999999999991,165);
INSERT INTO player VALUES(47,37280,'Abdoulaye Meite',41745,'1980-10-06 00:00:00',185.4199999999999875,181);
INSERT INTO player VALUES(48,439366,'Abdoulaye Toure',210450,'1994-03-03 00:00:00',187.9600000000000079,170);
INSERT INTO player VALUES(49,148827,'Abdoulwahid Sissoko',189568,'1990-03-20 00:00:00',182.8799999999999955,165);
INSERT INTO player VALUES(50,173011,'Abdourahman Dampha',197901,'1991-12-27 00:00:00',182.8799999999999955,168);

--
CREATE TABLE team_attributes (
	id	INTEGER PRIMARY KEY,
	team_fifa_api_id	INTEGER,
	team_api_id	INTEGER,
	date	TEXT,
	buildUpPlaySpeed	INTEGER,
	buildUpPlaySpeedClass	TEXT,
	buildUpPlayDribbling	INTEGER,
	buildUpPlayDribblingClass	TEXT,
	buildUpPlayPassing	INTEGER,
	buildUpPlayPassingClass	TEXT,
	buildUpPlayPositioningClass	TEXT,
	chanceCreationPassing	INTEGER,
	chanceCreationPassingClass	TEXT,
	chanceCreationCrossing	INTEGER,
	chanceCreationCrossingClass	TEXT,
	chanceCreationShooting	INTEGER,
	chanceCreationShootingClass	TEXT,
	chanceCreationPositioningClass	TEXT,
	defencePressure	INTEGER,
	defencePressureClass	TEXT,
	defenceAggression	INTEGER,
	defenceAggressionClass	TEXT,
	defenceteamWidth	INTEGER,
	defenceteamWidthClass	TEXT,
	defenceDefenderLineClass	TEXT,
	FOREIGN KEY(team_fifa_api_id) REFERENCES team(team_fifa_api_id),
	FOREIGN KEY(team_api_id) REFERENCES team(team_api_id)
);
INSERT INTO team_attributes VALUES(485,673,9987,'2010-02-22 00:00:00',45,'Balanced',NULL,'Little',45,'Mixed','Organised',50,'Normal',35,'Normal',60,'Normal','Organised',70,'High',65,'Press',70,'Wide','Cover');
INSERT INTO team_attributes VALUES(486,673,9987,'2011-02-22 00:00:00',66,'Balanced',NULL,'Little',52,'Mixed','Organised',65,'Normal',66,'Normal',51,'Normal','Organised',48,'Medium',47,'Press',54,'Normal','Offside Trap');
INSERT INTO team_attributes VALUES(487,673,9987,'2012-02-22 00:00:00',53,'Balanced',NULL,'Little',55,'Mixed','Organised',55,'Normal',48,'Normal',56,'Normal','Organised',47,'Medium',45,'Press',55,'Normal','Cover');
INSERT INTO team_attributes VALUES(488,673,9987,'2013-09-20 00:00:00',58,'Balanced',NULL,'Little',38,'Mixed','Organised',67,'Risky',48,'Normal',56,'Normal','Organised',47,'Medium',45,'Press',55,'Normal','Cover');
INSERT INTO team_attributes VALUES(489,673,9987,'2014-09-19 00:00:00',58,'Balanced',52,'Normal',38,'Mixed','Organised',67,'Risky',48,'Normal',56,'Normal','Organised',47,'Medium',45,'Press',55,'Normal','Cover');
INSERT INTO team_attributes VALUES(490,673,9987,'2015-09-10 00:00:00',58,'Balanced',52,'Normal',38,'Mixed','Organised',30,'Safe',69,'Lots',56,'Normal','Organised',36,'Medium',57,'Press',70,'Wide','Cover');
INSERT INTO team_attributes VALUES(149,675,9993,'2010-02-22 00:00:00',35,'Balanced',NULL,'Little',35,'Mixed','Organised',45,'Normal',40,'Normal',50,'Normal','Organised',70,'High',70,'Double',70,'Wide','Cover');
INSERT INTO team_attributes VALUES(150,675,9993,'2011-02-22 00:00:00',47,'Balanced',NULL,'Little',37,'Mixed','Organised',54,'Normal',64,'Normal',67,'Lots','Organised',33,'Deep',34,'Press',48,'Normal','Offside Trap');
INSERT INTO team_attributes VALUES(151,675,9993,'2012-02-22 00:00:00',55,'Balanced',NULL,'Little',55,'Mixed','Organised',47,'Normal',46,'Normal',49,'Normal','Organised',45,'Medium',46,'Press',50,'Normal','Cover');
INSERT INTO team_attributes VALUES(152,675,9993,'2013-09-20 00:00:00',47,'Balanced',NULL,'Little',39,'Mixed','Organised',38,'Normal',64,'Normal',49,'Normal','Organised',45,'Medium',46,'Press',67,'Wide','Cover');
INSERT INTO team_attributes VALUES(1453,15005,10000,'2010-02-22 00:00:00',65,'Balanced',NULL,'Little',60,'Mixed','Organised',60,'Normal',40,'Normal',50,'Normal','Organised',70,'High',60,'Press',70,'Wide','Cover');
INSERT INTO team_attributes VALUES(1454,15005,10000,'2011-02-22 00:00:00',52,'Balanced',NULL,'Little',52,'Mixed','Organised',52,'Normal',48,'Normal',53,'Normal','Organised',46,'Medium',48,'Press',53,'Normal','Cover');
INSERT INTO team_attributes VALUES(1455,15005,10000,'2012-02-22 00:00:00',54,'Balanced',NULL,'Little',51,'Mixed','Organised',47,'Normal',52,'Normal',50,'Normal','Organised',44,'Medium',55,'Press',53,'Normal','Cover');
INSERT INTO team_attributes VALUES(1456,15005,10000,'2013-09-20 00:00:00',54,'Balanced',NULL,'Little',51,'Mixed','Organised',47,'Normal',52,'Normal',32,'Little','Organised',44,'Medium',58,'Press',37,'Normal','Cover');
INSERT INTO team_attributes VALUES(1457,15005,10000,'2014-09-19 00:00:00',54,'Balanced',42,'Normal',51,'Mixed','Organised',47,'Normal',52,'Normal',32,'Little','Organised',44,'Medium',58,'Press',37,'Normal','Cover');
INSERT INTO team_attributes VALUES(1458,15005,10000,'2015-09-10 00:00:00',54,'Balanced',42,'Normal',51,'Mixed','Organised',47,'Normal',52,'Normal',32,'Little','Organised',44,'Medium',58,'Press',37,'Normal','Cover');
INSERT INTO team_attributes VALUES(759,2007,9994,'2010-02-22 00:00:00',60,'Balanced',NULL,'Little',60,'Mixed','Organised',50,'Normal',40,'Normal',50,'Normal','Organised',65,'Medium',65,'Press',70,'Wide','Cover');
INSERT INTO team_attributes VALUES(760,2007,9994,'2011-02-22 00:00:00',66,'Balanced',NULL,'Little',53,'Mixed','Organised',48,'Normal',46,'Normal',52,'Normal','Organised',48,'Medium',58,'Press',55,'Normal','Cover');
INSERT INTO team_attributes VALUES(761,2007,9994,'2012-02-22 00:00:00',67,'Fast',NULL,'Little',52,'Mixed','Organised',51,'Normal',50,'Normal',50,'Normal','Organised',45,'Medium',52,'Press',52,'Normal','Cover');
INSERT INTO team_attributes VALUES(762,2007,9994,'2013-09-20 00:00:00',67,'Fast',NULL,'Little',52,'Mixed','Organised',31,'Safe',50,'Normal',50,'Normal','Organised',45,'Medium',52,'Press',52,'Normal','Cover');
INSERT INTO team_attributes VALUES(763,2007,9994,'2014-09-19 00:00:00',62,'Balanced',45,'Normal',52,'Mixed','Organised',42,'Normal',50,'Normal',62,'Normal','Organised',45,'Medium',52,'Press',52,'Normal','Cover');
INSERT INTO team_attributes VALUES(764,2007,9994,'2015-09-10 00:00:00',62,'Balanced',45,'Normal',52,'Mixed','Organised',42,'Normal',50,'Normal',62,'Normal','Organised',45,'Medium',52,'Press',52,'Normal','Cover');
INSERT INTO team_attributes VALUES(295,1750,9984,'2010-02-22 00:00:00',45,'Balanced',NULL,'Little',35,'Mixed','Organised',70,'Risky',45,'Normal',55,'Normal','Organised',65,'Medium',60,'Press',70,'Wide','Cover');
INSERT INTO team_attributes VALUES(296,1750,9984,'2011-02-22 00:00:00',50,'Balanced',NULL,'Little',50,'Mixed','Free Form',70,'Risky',65,'Normal',65,'Normal','Organised',60,'Medium',50,'Press',70,'Wide','Cover');
INSERT INTO team_attributes VALUES(297,1750,9984,'2012-02-22 00:00:00',68,'Fast',NULL,'Little',54,'Mixed','Organised',55,'Normal',68,'Lots',42,'Normal','Organised',59,'Medium',47,'Press',62,'Normal','Cover');
INSERT INTO team_attributes VALUES(298,1750,9984,'2013-09-20 00:00:00',53,'Balanced',NULL,'Little',40,'Mixed','Organised',55,'Normal',68,'Lots',42,'Normal','Free Form',59,'Medium',47,'Press',62,'Normal','Cover');
INSERT INTO team_attributes VALUES(299,1750,9984,'2014-09-19 00:00:00',53,'Balanced',49,'Normal',43,'Mixed','Organised',52,'Normal',58,'Normal',42,'Normal','Organised',59,'Medium',47,'Press',62,'Normal','Cover');
INSERT INTO team_attributes VALUES(300,1750,9984,'2015-09-10 00:00:00',53,'Balanced',49,'Normal',43,'Mixed','Organised',52,'Normal',58,'Normal',42,'Normal','Organised',59,'Medium',47,'Press',62,'Normal','Cover');
INSERT INTO team_attributes VALUES(95,240,9906,'2010-02-22 00:00:00',64,'Balanced',NULL,'Little',30,'Short','Free Form',65,'Normal',50,'Normal',70,'Lots','Free Form',70,'High',34,'Press',55,'Normal','Offside Trap');
INSERT INTO team_attributes VALUES(96,240,9906,'2011-02-22 00:00:00',57,'Balanced',NULL,'Little',54,'Mixed','Organised',58,'Normal',69,'Lots',79,'Lots','Organised',58,'Medium',48,'Press',54,'Normal','Cover');
INSERT INTO team_attributes VALUES(97,240,9906,'2012-02-22 00:00:00',47,'Balanced',NULL,'Little',51,'Mixed','Organised',67,'Risky',63,'Normal',54,'Normal','Organised',52,'Medium',37,'Press',55,'Normal','Cover');
INSERT INTO team_attributes VALUES(98,240,9906,'2013-09-20 00:00:00',47,'Balanced',NULL,'Little',51,'Mixed','Organised',70,'Risky',65,'Normal',54,'Normal','Organised',52,'Medium',37,'Press',55,'Normal','Cover');
INSERT INTO team_attributes VALUES(99,240,9906,'2014-09-19 00:00:00',47,'Balanced',52,'Normal',51,'Mixed','Organised',67,'Risky',67,'Lots',54,'Normal','Organised',52,'Medium',37,'Press',55,'Normal','Cover');
INSERT INTO team_attributes VALUES(100,240,9906,'2015-09-10 00:00:00',57,'Balanced',50,'Normal',50,'Mixed','Organised',61,'Normal',62,'Normal',49,'Normal','Organised',49,'Medium',42,'Press',52,'Normal','Cover');
INSERT INTO team_attributes VALUES(525,110832,7878,'2011-02-22 00:00:00',53,'Balanced',NULL,'Little',52,'Mixed','Organised',54,'Normal',59,'Normal',55,'Normal','Organised',54,'Medium',49,'Press',67,'Wide','Cover');
INSERT INTO team_attributes VALUES(526,110832,7878,'2012-02-22 00:00:00',48,'Balanced',NULL,'Little',37,'Mixed','Organised',72,'Risky',76,'Lots',52,'Normal','Organised',49,'Medium',45,'Press',68,'Wide','Cover');
INSERT INTO team_attributes VALUES(527,110832,7878,'2013-09-20 00:00:00',52,'Balanced',NULL,'Little',37,'Mixed','Organised',72,'Risky',76,'Lots',52,'Normal','Organised',49,'Medium',45,'Press',68,'Wide','Cover');
INSERT INTO team_attributes VALUES(528,110832,7878,'2014-09-19 00:00:00',52,'Balanced',62,'Normal',37,'Mixed','Organised',67,'Risky',68,'Lots',52,'Normal','Organised',49,'Medium',45,'Press',64,'Normal','Cover');
INSERT INTO team_attributes VALUES(529,110832,7878,'2015-09-10 00:00:00',57,'Balanced',50,'Normal',59,'Mixed','Organised',61,'Normal',63,'Normal',51,'Normal','Organised',48,'Medium',45,'Press',62,'Normal','Cover');

--
CREATE TABLE IF NOT EXISTS player_attributes (
     id	INTEGER PRIMARY KEY,
     player_fifa_api_id	INTEGER,
     player_api_id	INTEGER,
     date	TEXT,
     overall_rating	INTEGER,
     potential	INTEGER,
     preferred_foot	TEXT,
     attacking_work_rate	TEXT,
     defensive_work_rate	TEXT,
     crossing	INTEGER,
     finishing	INTEGER,
     heading_accuracy	INTEGER,
     short_passing	INTEGER,
     volleys	INTEGER,
     dribbling	INTEGER,
     curve	INTEGER,
     free_kick_accuracy	INTEGER,
     long_passing	INTEGER,
     ball_control	INTEGER,
     acceleration	INTEGER,
     sprint_speed	INTEGER,
     agility	INTEGER,
     reactions	INTEGER,
     balance	INTEGER,
     shot_power	INTEGER,
     jumping	INTEGER,
     stamina	INTEGER,
     strength	INTEGER,
     long_shots	INTEGER,
     aggression	INTEGER,
     interceptions	INTEGER,
     positioning	INTEGER,
     vision	INTEGER,
     penalties	INTEGER,
     marking	INTEGER,
     standing_tackle	INTEGER,
     sliding_tackle	INTEGER,
     gk_diving	INTEGER,
     gk_handling	INTEGER,
     gk_kicking	INTEGER,
     gk_positioning	INTEGER,
     gk_reflexes	INTEGER,
     FOREIGN KEY(player_fifa_api_id) REFERENCES player(player_fifa_api_id),
     FOREIGN KEY(player_api_id) REFERENCES player(player_api_id)
    );
INSERT INTO player_attributes VALUES(1,218353,505942,'2016-02-18 00:00:00',67,71,'right','medium','medium',49,44,71,61,44,51,45,39,64,49,60,64,59,47,65,55,58,54,76,35,71,70,45,54,48,65,69,69,6,11,10,8,8);
INSERT INTO player_attributes VALUES(2,218353,505942,'2015-11-19 00:00:00',67,71,'right','medium','medium',49,44,71,61,44,51,45,39,64,49,60,64,59,47,65,55,58,54,76,35,71,70,45,54,48,65,69,69,6,11,10,8,8);
INSERT INTO player_attributes VALUES(3,218353,505942,'2015-09-21 00:00:00',62,66,'right','medium','medium',49,44,71,61,44,51,45,39,64,49,60,64,59,47,65,55,58,54,76,35,63,41,45,54,48,65,66,69,6,11,10,8,8);
INSERT INTO player_attributes VALUES(4,218353,505942,'2015-03-20 00:00:00',61,65,'right','medium','medium',48,43,70,60,43,50,44,38,63,48,60,64,59,46,65,54,58,54,76,34,62,40,44,53,47,62,63,66,5,10,9,7,7);
INSERT INTO player_attributes VALUES(5,218353,505942,'2007-02-22 00:00:00',61,65,'right','medium','medium',48,43,70,60,43,50,44,38,63,48,60,64,59,46,65,54,58,54,76,34,62,40,44,53,47,62,63,66,5,10,9,7,7);
INSERT INTO player_attributes VALUES(6,189615,155782,'2016-04-21 00:00:00',74,76,'left','high','medium',80,53,58,71,40,73,70,69,68,71,79,78,78,67,90,71,85,79,56,62,68,67,60,66,59,76,75,78,14,7,9,9,12);
INSERT INTO player_attributes VALUES(7,189615,155782,'2016-04-07 00:00:00',74,76,'left','high','medium',80,53,58,71,32,73,70,69,68,71,79,78,78,67,90,71,85,79,56,60,68,67,60,66,59,76,75,78,14,7,9,9,12);
INSERT INTO player_attributes VALUES(8,189615,155782,'2016-01-07 00:00:00',73,75,'left','high','medium',79,52,57,70,29,71,68,69,68,70,79,78,78,67,90,71,84,79,56,59,67,66,58,65,59,76,75,78,14,7,9,9,12);
INSERT INTO player_attributes VALUES(9,189615,155782,'2015-12-24 00:00:00',73,75,'left','high','medium',79,51,57,70,29,71,68,69,68,70,79,78,78,67,90,71,84,79,56,58,67,66,58,65,59,76,75,78,14,7,9,9,12);
INSERT INTO player_attributes VALUES(10,189615,155782,'2015-12-17 00:00:00',73,75,'left','high','medium',79,51,57,70,29,71,68,69,68,70,79,78,78,67,90,71,84,79,56,58,67,66,58,65,59,76,75,78,14,7,9,9,12);
INSERT INTO player_attributes VALUES(11,189615,155782,'2015-10-16 00:00:00',73,77,'left','high','medium',79,51,57,70,29,71,68,69,68,70,79,78,78,67,90,71,84,79,56,58,67,66,58,65,59,76,75,78,14,7,9,9,12);
INSERT INTO player_attributes VALUES(12,189615,155782,'2015-09-25 00:00:00',74,78,'left','high','medium',79,51,57,70,29,71,68,69,68,70,80,78,78,67,90,71,84,79,56,58,67,66,58,65,59,76,75,78,14,7,9,9,12);
INSERT INTO player_attributes VALUES(13,189615,155782,'2015-09-21 00:00:00',73,77,'left','medium','medium',79,51,57,70,29,67,68,69,68,68,79,78,78,67,90,71,84,79,56,58,67,66,58,65,59,76,75,78,14,7,9,9,12);
INSERT INTO player_attributes VALUES(14,189615,155782,'2015-01-09 00:00:00',71,75,'left','medium','medium',78,50,56,69,28,66,67,68,67,67,79,82,79,71,90,70,84,79,50,56,66,65,57,64,58,73,72,72,13,6,8,8,11);
INSERT INTO player_attributes VALUES(15,189615,155782,'2014-12-05 00:00:00',71,77,'left','medium','medium',78,50,56,69,28,66,67,68,67,67,79,82,79,71,90,70,84,79,50,56,66,65,57,64,58,73,72,72,13,6,8,8,11);
INSERT INTO player_attributes VALUES(16,189615,155782,'2014-11-07 00:00:00',71,77,'left','medium','medium',78,50,56,69,28,66,67,68,67,67,79,82,79,71,90,70,84,79,50,56,66,65,57,64,58,73,72,72,13,6,8,8,11);
INSERT INTO player_attributes VALUES(17,189615,155782,'2014-09-18 00:00:00',70,77,'left','medium','medium',77,50,51,67,28,66,67,68,67,66,79,82,79,69,90,70,84,79,50,56,66,62,57,64,58,73,72,72,13,6,8,8,11);
INSERT INTO player_attributes VALUES(18,189615,155782,'2014-05-02 00:00:00',70,79,'left','medium','medium',77,50,51,67,28,66,67,68,67,66,84,82,81,69,90,70,84,80,50,56,66,62,57,64,58,73,72,72,13,6,8,8,11);
INSERT INTO player_attributes VALUES(19,189615,155782,'2014-04-04 00:00:00',70,79,'left','medium','medium',77,50,51,67,28,66,67,68,67,66,84,82,81,69,90,70,84,80,50,56,66,62,57,64,58,73,72,72,13,6,8,8,11);
INSERT INTO player_attributes VALUES(20,189615,155782,'2014-03-14 00:00:00',70,79,'left','medium','medium',77,50,51,67,28,66,66,68,67,65,84,82,81,69,90,70,84,79,49,55,66,62,57,61,58,73,72,72,13,6,8,8,11);
INSERT INTO player_attributes VALUES(21,189615,155782,'2013-12-13 00:00:00',70,79,'left','medium','medium',77,50,51,67,28,66,66,68,67,67,84,82,81,71,90,70,84,79,49,55,66,62,57,61,58,73,72,72,13,6,8,8,11);
INSERT INTO player_attributes VALUES(22,189615,155782,'2013-11-08 00:00:00',70,79,'left','medium','medium',77,50,51,67,28,66,66,68,67,67,84,82,81,71,90,70,84,79,49,55,66,62,57,61,58,73,72,72,13,6,8,8,11);
INSERT INTO player_attributes VALUES(23,189615,155782,'2013-10-04 00:00:00',69,79,'left','medium','medium',77,50,50,64,28,66,66,68,65,67,84,82,81,70,90,70,84,77,48,55,63,62,56,58,58,73,72,72,13,6,8,8,11);
INSERT INTO player_attributes VALUES(24,189615,155782,'2013-09-20 00:00:00',69,79,'left','medium','medium',77,50,50,64,28,66,66,68,65,67,84,82,81,70,90,70,84,76,48,55,63,62,56,58,58,73,72,72,13,6,8,8,11);
INSERT INTO player_attributes VALUES(25,189615,155782,'2013-05-03 00:00:00',69,80,'left','medium','medium',77,50,50,64,28,65,65,68,65,65,84,81,77,70,90,70,77,74,48,55,63,62,56,58,58,72,72,72,13,6,8,8,11);
INSERT INTO player_attributes VALUES(26,189615,155782,'2013-03-22 00:00:00',69,80,'left','medium','medium',77,50,50,64,28,65,65,68,65,65,84,81,77,70,90,70,77,74,48,55,63,62,56,58,58,72,72,72,13,6,8,8,11);
INSERT INTO player_attributes VALUES(27,189615,155782,'2013-03-15 00:00:00',69,80,'left','medium','medium',77,50,50,64,28,65,65,68,65,65,84,81,77,70,90,70,77,74,48,55,63,62,56,58,58,72,72,72,13,6,8,8,11);
INSERT INTO player_attributes VALUES(28,189615,155782,'2013-02-22 00:00:00',69,80,'left','medium','medium',77,50,50,64,28,65,65,68,65,65,85,81,81,70,90,70,77,74,48,55,63,62,56,58,58,72,72,72,13,6,8,8,11);
INSERT INTO player_attributes VALUES(29,189615,155782,'2013-02-15 00:00:00',69,80,'left','medium','medium',77,50,50,64,28,65,65,68,65,65,85,81,81,70,90,70,77,74,48,55,63,62,56,58,58,72,72,72,13,6,8,8,11);
INSERT INTO player_attributes VALUES(30,189615,155782,'2012-08-31 00:00:00',68,80,'left','medium','medium',77,50,50,64,28,64,63,68,65,64,85,81,81,70,90,70,77,73,48,55,63,62,56,63,58,72,72,72,13,6,8,8,11);
INSERT INTO player_attributes VALUES(31,189615,155782,'2012-02-22 00:00:00',65,68,'left','medium','medium',77,53,52,62,30,62,64,68,68,64,69,72,74,66,87,65,73,63,56,54,64,59,56,63,58,66,68,67,13,6,8,8,11);
INSERT INTO player_attributes VALUES(32,189615,155782,'2011-08-30 00:00:00',64,68,'left','medium','medium',74,53,52,59,30,62,64,68,68,64,69,72,74,66,87,65,64,63,56,54,64,59,56,47,58,64,64,67,13,6,8,8,11);
INSERT INTO player_attributes VALUES(33,189615,155782,'2010-08-30 00:00:00',54,65,'left','medium','medium',58,40,52,45,30,44,41,43,46,43,43,47,59,62,62,48,48,59,43,54,64,40,19,38,35,53,60,63,13,6,8,8,11);
INSERT INTO player_attributes VALUES(34,189615,155782,'2010-02-22 00:00:00',51,64,'left','medium','medium',57,39,51,44,30,43,41,42,45,42,42,46,59,61,62,47,48,55,37,53,63,31,27,38,28,52,59,63,6,22,45,22,22);
INSERT INTO player_attributes VALUES(35,189615,155782,'2009-08-30 00:00:00',52,65,'left','medium','medium',58,40,52,45,30,44,41,43,46,43,43,47,59,62,62,48,48,56,38,54,64,32,28,38,29,53,60,63,6,22,46,22,22);
INSERT INTO player_attributes VALUES(36,189615,155782,'2009-02-22 00:00:00',47,60,'left','medium','medium',22,48,52,39,30,26,41,26,49,34,66,59,59,65,62,48,48,56,63,35,64,32,28,38,29,53,45,63,6,22,49,22,22);
INSERT INTO player_attributes VALUES(37,189615,155782,'2008-08-30 00:00:00',53,60,'right','medium','medium',22,48,52,39,30,26,41,26,49,34,66,59,59,65,62,48,48,56,68,35,64,32,28,38,29,53,45,63,6,22,49,22,22);
INSERT INTO player_attributes VALUES(38,189615,155782,'2007-02-22 00:00:00',53,60,'right','medium','medium',22,48,52,39,30,26,41,26,49,34,66,59,59,65,62,48,48,56,68,35,64,32,28,38,29,53,45,63,6,22,49,22,22);
INSERT INTO player_attributes VALUES(39,186170,162549,'2016-01-07 00:00:00',65,67,'right','medium','medium',64,58,60,66,52,66,67,63,62,67,77,74,85,51,92,61,65,66,71,57,60,55,64,68,61,23,22,24,16,11,12,9,13);
INSERT INTO player_attributes VALUES(40,186170,162549,'2015-10-09 00:00:00',66,70,'right','medium','medium',64,58,60,66,52,66,67,63,62,67,81,75,85,51,92,61,65,66,71,57,60,55,64,68,61,23,22,24,16,11,12,9,13);
INSERT INTO player_attributes VALUES(41,186170,162549,'2015-09-21 00:00:00',66,70,'right','medium','medium',64,58,60,66,52,66,67,63,62,67,78,75,85,51,92,61,65,66,71,57,60,55,64,68,61,23,22,24,16,11,12,9,13);
INSERT INTO player_attributes VALUES(42,186170,162549,'2014-12-12 00:00:00',67,72,'right','medium','medium',65,52,59,66,51,66,68,62,64,67,82,80,81,50,92,60,71,72,71,56,59,54,67,71,60,22,21,21,15,10,11,8,12);
INSERT INTO player_attributes VALUES(43,186170,162549,'2014-09-18 00:00:00',68,72,'right','medium','medium',67,52,59,66,51,69,68,62,64,68,82,80,81,50,92,60,71,72,71,56,59,54,67,71,60,22,21,21,15,10,11,8,12);
INSERT INTO player_attributes VALUES(44,186170,162549,'2014-04-18 00:00:00',68,77,'right','medium','medium',67,52,59,66,51,69,68,62,64,68,82,80,81,50,92,60,71,72,71,56,59,54,67,71,60,22,21,21,15,10,11,8,12);
INSERT INTO player_attributes VALUES(45,186170,162549,'2014-03-14 00:00:00',68,77,'right','medium','medium',67,52,59,66,51,69,68,62,64,68,82,80,81,50,92,60,71,72,71,56,59,54,67,71,60,22,21,21,15,10,11,8,12);
INSERT INTO player_attributes VALUES(46,186170,162549,'2014-01-31 00:00:00',69,78,'right','medium','medium',69,52,62,68,51,70,71,64,64,71,82,80,81,50,92,60,71,72,71,56,59,54,67,72,63,22,21,21,15,10,11,8,12);
INSERT INTO player_attributes VALUES(47,186170,162549,'2013-11-29 00:00:00',70,78,'right','medium','medium',72,52,62,71,51,72,72,64,64,71,82,80,81,50,92,60,71,72,71,56,59,54,67,72,63,22,21,21,15,10,11,8,12);
INSERT INTO player_attributes VALUES(48,186170,162549,'2013-09-20 00:00:00',71,78,'right','medium','medium',73,52,62,71,51,74,72,64,64,73,82,80,81,50,92,60,71,72,71,56,59,54,67,72,63,22,21,21,15,10,11,8,12);
INSERT INTO player_attributes VALUES(49,186170,162549,'2013-05-31 00:00:00',70,76,'right','medium','medium',72,52,62,69,51,73,70,64,64,72,74,79,81,50,84,56,71,72,71,51,59,44,68,72,63,22,21,21,15,10,11,8,12);
INSERT INTO player_attributes VALUES(50,186170,162549,'2013-04-26 00:00:00',70,76,'right','medium','medium',72,52,62,69,51,73,70,64,64,72,74,79,81,50,84,56,71,72,71,51,59,44,68,72,63,22,21,21,15,10,11,8,12);
INSERT INTO player_attributes VALUES(51,186170,162549,'2013-04-19 00:00:00',70,76,'right','medium','medium',72,52,62,69,51,73,70,64,64,72,74,79,81,50,84,56,71,72,71,51,59,44,68,73,63,22,21,21,15,10,11,8,12);
INSERT INTO player_attributes VALUES(52,186170,162549,'2013-04-05 00:00:00',70,76,'right','medium','medium',72,52,62,67,51,73,70,64,61,72,74,79,81,50,84,56,71,72,71,51,59,44,68,73,63,22,21,21,15,10,11,8,12);
INSERT INTO player_attributes VALUES(53,186170,162549,'2013-03-22 00:00:00',69,76,'right','medium','medium',72,56,62,66,51,73,70,64,62,72,74,79,81,50,84,62,71,72,71,52,59,44,66,73,63,22,21,21,15,10,11,8,12);
INSERT INTO player_attributes VALUES(54,186170,162549,'2013-03-08 00:00:00',69,76,'right','medium','medium',72,56,62,66,51,73,70,64,62,72,74,79,81,50,84,62,71,72,71,52,59,44,66,73,63,22,21,21,15,10,11,8,12);
INSERT INTO player_attributes VALUES(55,186170,162549,'2013-02-15 00:00:00',69,76,'right','medium','medium',72,56,62,66,51,73,70,64,62,72,74,79,81,50,84,62,71,72,71,52,59,44,66,73,63,22,21,21,15,10,11,8,12);
INSERT INTO player_attributes VALUES(56,186170,162549,'2012-08-31 00:00:00',65,72,'right','medium','medium',63,56,62,61,51,67,43,41,53,67,76,80,81,50,87,62,71,72,71,52,59,44,64,63,63,22,21,21,15,10,11,8,12);
INSERT INTO player_attributes VALUES(57,186170,162549,'2012-02-22 00:00:00',65,75,'right','medium','medium',65,61,62,63,56,66,43,41,57,67,76,75,76,50,84,67,77,81,68,61,59,44,64,63,63,22,21,21,15,10,11,8,12);
INSERT INTO player_attributes VALUES(58,186170,162549,'2011-08-30 00:00:00',65,75,'right','medium','medium',65,61,62,63,56,66,43,41,57,67,76,75,76,50,84,67,77,73,68,61,59,44,64,63,63,22,21,21,15,10,11,8,12);
INSERT INTO player_attributes VALUES(59,186170,162549,'2011-02-22 00:00:00',67,78,'right','medium','medium',69,69,62,65,63,67,43,41,58,74,68,75,66,51,56,74,56,68,68,76,59,44,62,67,64,22,21,21,15,10,11,8,12);
INSERT INTO player_attributes VALUES(60,186170,162549,'2010-08-30 00:00:00',67,78,'right','medium','medium',69,69,62,65,63,67,43,41,58,74,68,75,66,51,56,74,56,68,68,76,59,44,62,67,64,22,21,21,15,10,11,8,12);
INSERT INTO player_attributes VALUES(61,186170,162549,'2010-02-22 00:00:00',65,70,'right','medium','medium',69,69,45,63,63,67,43,41,54,68,71,77,66,51,56,74,56,69,68,67,59,44,50,67,66,22,21,21,8,21,54,21,21);
INSERT INTO player_attributes VALUES(62,186170,162549,'2009-08-30 00:00:00',65,70,'right','medium','medium',69,69,45,63,63,67,43,41,54,68,71,77,66,51,56,74,56,69,68,67,59,44,50,67,66,22,21,21,8,21,54,21,21);
INSERT INTO player_attributes VALUES(63,186170,162549,'2009-02-22 00:00:00',59,70,'right','medium','medium',63,69,45,53,63,65,43,41,54,54,65,72,66,51,56,64,56,69,68,63,59,35,30,67,36,21,21,21,8,21,54,21,21);
INSERT INTO player_attributes VALUES(64,186170,162549,'2007-02-22 00:00:00',59,70,'right','medium','medium',63,69,45,53,63,65,43,41,54,54,65,72,66,51,56,64,56,69,68,63,59,35,30,67,36,21,21,21,8,21,54,21,21);
INSERT INTO player_attributes VALUES(65,140161,30572,'2016-04-21 00:00:00',69,69,'right','medium','medium',57,21,68,65,48,56,38,40,61,62,33,34,62,57,41,59,71,49,90,29,70,62,26,54,37,72,71,68,15,12,13,12,11);
INSERT INTO player_attributes VALUES(66,140161,30572,'2015-10-16 00:00:00',69,69,'right','medium','medium',57,21,68,65,48,56,38,40,61,62,33,34,62,57,41,65,71,49,90,29,70,62,26,54,37,72,71,68,15,12,13,12,11);
INSERT INTO player_attributes VALUES(67,140161,30572,'2015-10-02 00:00:00',69,69,'right','medium','medium',57,21,68,65,48,56,38,40,61,62,33,37,62,57,41,65,71,49,87,29,70,62,26,54,37,72,71,68,15,12,13,12,11);
INSERT INTO player_attributes VALUES(68,140161,30572,'2015-09-21 00:00:00',69,69,'right','medium','medium',57,21,68,65,48,56,38,40,61,62,33,37,62,57,41,65,71,49,87,29,70,62,26,54,37,72,71,68,15,12,13,12,11);
INSERT INTO player_attributes VALUES(69,140161,30572,'2015-07-03 00:00:00',67,67,'right','medium','medium',56,20,67,64,47,55,37,39,60,61,37,40,63,56,44,64,73,59,86,28,68,61,25,53,36,66,68,65,14,11,12,11,10);
INSERT INTO player_attributes VALUES(70,140161,30572,'2015-06-12 00:00:00',67,67,'right','medium','medium',56,20,67,64,47,55,37,39,60,61,37,40,63,56,44,64,73,59,86,28,68,61,25,53,36,66,68,65,14,11,12,11,10);
INSERT INTO player_attributes VALUES(71,140161,30572,'2015-01-16 00:00:00',67,67,'right','medium','medium',56,20,67,64,47,55,37,39,60,61,37,40,63,56,44,64,73,59,86,28,68,61,25,53,36,66,68,65,14,11,12,11,10);
INSERT INTO player_attributes VALUES(72,140161,30572,'2014-11-14 00:00:00',67,67,'right','medium','medium',56,20,67,64,47,55,37,39,60,61,37,40,63,56,44,64,73,59,81,28,68,61,25,53,36,66,68,65,14,11,12,11,10);
INSERT INTO player_attributes VALUES(73,140161,30572,'2014-09-18 00:00:00',67,67,'right','medium','medium',56,20,67,64,47,55,37,39,60,61,37,40,63,56,44,64,73,59,81,28,68,61,25,53,36,66,68,65,14,11,12,11,10);
INSERT INTO player_attributes VALUES(74,140161,30572,'2014-06-06 00:00:00',67,67,'right','medium','medium',57,21,68,65,48,56,38,40,61,62,50,48,63,57,45,65,71,39,78,29,69,62,26,54,37,67,69,66,14,11,12,11,10);
INSERT INTO player_attributes VALUES(75,140161,30572,'2014-04-11 00:00:00',67,67,'right','medium','medium',57,21,68,65,48,56,38,40,61,62,50,48,63,57,45,65,71,39,78,29,69,62,26,54,37,67,69,66,14,11,12,11,10);
INSERT INTO player_attributes VALUES(76,140161,30572,'2013-09-20 00:00:00',67,67,'right','medium','medium',57,21,68,65,48,56,38,40,61,62,50,48,63,57,45,65,71,39,78,29,69,62,26,54,37,67,69,66,14,11,12,11,10);
INSERT INTO player_attributes VALUES(77,140161,30572,'2013-05-10 00:00:00',68,68,'right','medium','medium',57,21,68,65,48,56,38,40,61,62,50,55,63,57,45,65,71,48,77,29,69,62,26,54,37,67,71,70,14,11,12,11,10);
INSERT INTO player_attributes VALUES(78,140161,30572,'2013-02-15 00:00:00',68,70,'right','medium','medium',57,21,68,65,48,56,38,40,61,62,50,55,63,57,45,65,71,48,77,29,69,62,26,54,37,67,71,70,14,11,12,11,10);
INSERT INTO player_attributes VALUES(79,140161,30572,'2012-08-31 00:00:00',70,70,'right','medium','medium',57,21,70,65,48,56,38,40,61,62,50,57,63,57,45,65,71,48,77,29,69,65,26,54,37,73,71,70,14,11,12,11,10);
INSERT INTO player_attributes VALUES(80,140161,30572,'2012-02-22 00:00:00',69,70,'right','medium','medium',57,21,70,65,48,56,38,40,61,62,55,61,63,57,45,65,70,49,75,29,69,65,26,54,37,73,71,70,14,11,12,11,10);
INSERT INTO player_attributes VALUES(81,140161,30572,'2011-08-30 00:00:00',69,70,'right','medium','high',57,21,70,65,48,56,38,40,61,62,55,61,63,57,45,65,69,49,75,29,69,65,26,54,37,73,71,70,14,11,12,11,10);
INSERT INTO player_attributes VALUES(82,140161,30572,'2010-02-22 00:00:00',69,70,'right','medium','high',57,21,70,65,48,56,38,40,61,62,55,61,63,57,45,65,69,49,75,29,69,65,26,54,37,73,71,70,14,11,12,11,10);
INSERT INTO player_attributes VALUES(83,140161,30572,'2009-08-30 00:00:00',74,78,'right','medium','high',59,43,73,71,48,59,38,42,64,70,75,75,63,64,45,67,69,72,72,33,71,65,78,54,59,78,76,70,14,11,64,11,10);
INSERT INTO player_attributes VALUES(84,140161,30572,'2009-02-22 00:00:00',75,82,'right','medium','high',60,44,74,72,48,60,38,43,65,71,76,79,63,65,45,68,69,77,70,34,72,66,81,54,60,80,78,70,14,11,65,11,10);
INSERT INTO player_attributes VALUES(85,140161,30572,'2008-08-30 00:00:00',73,82,'right','medium','high',60,44,79,60,48,52,38,43,61,69,76,79,63,65,45,68,69,77,68,34,70,54,68,54,60,77,74,70,14,11,61,11,10);
INSERT INTO player_attributes VALUES(86,140161,30572,'2007-08-30 00:00:00',71,78,'right','medium','high',58,50,70,60,48,52,38,43,58,66,73,73,63,62,45,65,69,75,68,51,70,54,68,54,60,72,70,70,14,11,58,11,10);
INSERT INTO player_attributes VALUES(87,140161,30572,'2007-02-22 00:00:00',71,78,'right','medium','high',58,50,70,60,48,52,38,43,58,66,73,73,63,62,45,65,69,75,68,51,70,54,68,54,60,72,70,70,14,11,58,11,10);
INSERT INTO player_attributes VALUES(88,17725,23780,'2015-12-24 00:00:00',70,70,'right','medium','medium',46,34,73,65,33,47,42,25,58,58,33,31,41,68,52,48,67,60,75,26,66,68,29,41,45,75,73,71,8,6,16,12,11);
INSERT INTO player_attributes VALUES(89,17725,23780,'2015-09-21 00:00:00',70,70,'right','medium','medium',46,34,73,65,33,47,42,25,58,58,33,31,41,68,52,48,67,60,75,26,66,68,29,41,45,75,73,71,8,6,16,12,11);
INSERT INTO player_attributes VALUES(90,17725,23780,'2015-05-08 00:00:00',69,69,'right','medium','medium',45,33,72,64,32,46,41,24,57,57,33,31,45,67,59,47,67,60,74,25,65,67,28,40,44,72,70,68,7,5,15,11,10);
INSERT INTO player_attributes VALUES(91,17725,23780,'2015-04-10 00:00:00',69,69,'right','medium','medium',45,33,72,64,32,46,41,24,57,57,33,31,45,67,59,47,67,60,74,25,65,70,28,40,44,72,70,68,7,5,15,11,10);
INSERT INTO player_attributes VALUES(92,17725,23780,'2015-03-20 00:00:00',70,70,'right','medium','medium',45,33,72,64,32,46,41,24,57,57,33,31,45,67,59,47,78,60,74,25,65,71,28,40,44,74,71,69,7,5,15,11,10);
INSERT INTO player_attributes VALUES(93,17725,23780,'2014-09-18 00:00:00',72,72,'right','medium','medium',45,33,72,64,32,46,41,24,57,57,33,31,49,70,59,47,83,62,74,25,65,77,28,40,44,78,72,74,7,5,15,11,10);
INSERT INTO player_attributes VALUES(94,17725,23780,'2014-01-31 00:00:00',72,72,'right','medium','medium',45,33,72,64,32,46,41,24,57,57,33,48,49,70,59,47,81,62,74,25,65,77,28,40,44,78,72,74,7,5,15,11,10);
INSERT INTO player_attributes VALUES(95,17725,23780,'2014-01-17 00:00:00',72,72,'right','medium','medium',45,33,72,64,32,46,41,24,57,57,33,48,49,70,59,47,81,62,74,25,65,77,28,40,44,78,72,74,7,5,15,11,10);
INSERT INTO player_attributes VALUES(96,17725,23780,'2013-09-20 00:00:00',73,73,'right','medium','medium',45,33,72,67,32,46,41,24,57,57,33,53,49,70,59,47,81,62,74,25,65,80,28,40,44,80,74,75,7,5,15,11,10);
INSERT INTO player_attributes VALUES(97,17725,23780,'2013-05-10 00:00:00',73,73,'right','medium','medium',45,33,72,67,32,46,41,24,57,57,49,53,49,70,59,47,81,62,74,25,65,80,28,40,44,80,74,75,7,5,15,11,10);
INSERT INTO player_attributes VALUES(98,17725,23780,'2013-04-26 00:00:00',74,74,'right','medium','medium',45,33,72,71,32,48,41,24,57,59,49,53,49,70,59,47,81,62,74,25,65,81,28,40,44,81,75,76,7,5,15,11,10);
INSERT INTO player_attributes VALUES(99,17725,23780,'2013-03-22 00:00:00',74,74,'right','medium','medium',45,33,72,71,32,48,41,24,57,59,49,53,49,70,59,47,81,62,74,25,65,81,28,40,44,81,75,76,7,5,15,11,10);
INSERT INTO player_attributes VALUES(100,17725,23780,'2013-03-08 00:00:00',74,74,'right','medium','medium',45,33,72,71,32,48,41,24,57,59,49,53,49,70,59,47,81,62,74,25,65,81,28,40,44,81,75,76,7,5,15,11,10);
INSERT INTO player_attributes VALUES(101,17725,23780,'2013-02-15 00:00:00',74,74,'right','medium','medium',45,33,72,71,32,48,41,24,57,59,49,53,49,70,59,47,81,62,74,25,65,81,28,40,44,81,75,76,7,5,15,11,10);
INSERT INTO player_attributes VALUES(102,17725,23780,'2012-08-31 00:00:00',74,74,'right','medium','medium',45,33,72,66,32,53,41,24,57,62,54,54,49,70,59,47,81,62,69,25,65,81,28,40,44,79,79,76,7,5,15,11,10);
INSERT INTO player_attributes VALUES(103,17725,23780,'2012-02-22 00:00:00',75,75,'right','medium','medium',45,33,72,66,32,53,52,24,57,62,52,54,49,70,59,47,81,62,69,25,77,81,28,40,44,79,79,76,7,5,15,11,10);
INSERT INTO player_attributes VALUES(104,17725,23780,'2011-08-30 00:00:00',76,76,'right','medium','medium',45,33,72,66,32,53,52,24,57,63,53,55,57,70,66,47,83,62,69,25,77,83,28,40,44,80,80,77,7,5,15,11,10);
INSERT INTO player_attributes VALUES(105,17725,23780,'2011-02-22 00:00:00',75,81,'right','medium','medium',45,33,72,66,32,51,52,24,57,62,70,71,57,68,76,47,78,73,77,25,75,81,28,60,44,80,79,74,7,5,15,11,10);
INSERT INTO player_attributes VALUES(106,17725,23780,'2010-08-30 00:00:00',76,81,'right','medium','medium',45,33,72,66,32,53,52,24,57,63,71,72,57,70,76,47,78,77,77,25,77,83,28,60,44,80,80,77,7,5,15,11,10);
INSERT INTO player_attributes VALUES(107,17725,23780,'2010-02-22 00:00:00',78,81,'right','medium','medium',45,57,76,66,32,53,52,24,57,66,75,77,57,70,76,47,78,78,77,25,77,77,81,60,81,82,83,77,12,20,57,20,20);
INSERT INTO player_attributes VALUES(108,17725,23780,'2009-08-30 00:00:00',78,81,'right','medium','medium',45,57,76,66,32,53,52,24,57,66,75,77,57,70,76,47,78,78,77,25,77,77,81,60,81,82,83,77,12,20,57,20,20);
INSERT INTO player_attributes VALUES(109,17725,23780,'2009-02-22 00:00:00',75,81,'right','medium','medium',45,57,76,63,32,53,52,24,57,66,70,73,57,70,76,47,78,78,76,25,77,77,78,60,81,75,80,77,12,20,57,20,20);
INSERT INTO player_attributes VALUES(110,17725,23780,'2008-08-30 00:00:00',72,78,'right','medium','medium',45,57,76,54,32,63,52,24,55,62,70,73,57,70,76,47,78,78,72,20,76,74,76,60,81,69,79,77,12,20,55,20,20);
INSERT INTO player_attributes VALUES(111,17725,23780,'2007-08-30 00:00:00',71,78,'right','medium','medium',45,57,76,54,32,63,52,24,55,62,70,73,57,70,76,47,78,78,72,20,76,74,76,60,81,74,79,77,12,20,55,20,20);
INSERT INTO player_attributes VALUES(112,17725,23780,'2007-02-22 00:00:00',75,75,'right','medium','medium',45,57,76,54,32,63,52,81,55,62,76,73,57,70,76,47,78,78,72,15,76,74,76,60,81,74,79,77,12,11,55,10,6);
INSERT INTO player_attributes VALUES(113,158138,27316,'2016-04-28 00:00:00',77,77,'left','medium','medium',77,72,64,79,77,78,77,76,70,79,75,69,76,80,72,76,65,75,65,76,59,55,77,76,81,28,34,35,15,12,7,16,15);
INSERT INTO player_attributes VALUES(114,158138,27316,'2016-02-25 00:00:00',77,77,'left','medium','medium',77,72,64,79,77,78,77,76,70,79,75,69,76,80,72,76,65,75,65,76,59,55,77,76,81,28,34,35,15,12,7,16,15);
INSERT INTO player_attributes VALUES(115,158138,27316,'2015-09-25 00:00:00',77,77,'left','medium','medium',77,72,64,79,77,78,77,76,70,79,75,69,76,77,72,76,65,75,65,76,59,55,77,76,81,28,34,35,15,12,7,16,15);
INSERT INTO player_attributes VALUES(116,158138,27316,'2015-09-21 00:00:00',77,77,'left','medium','medium',77,72,64,79,77,78,77,76,70,79,75,69,76,77,72,76,65,75,65,76,59,55,77,76,81,28,34,35,15,12,7,16,15);
INSERT INTO player_attributes VALUES(117,158138,27316,'2015-09-04 00:00:00',77,77,'left','medium','medium',77,72,65,80,77,78,78,76,70,78,77,78,78,79,73,76,69,77,65,75,57,54,77,76,82,36,37,35,14,11,6,15,14);
INSERT INTO player_attributes VALUES(118,158138,27316,'2015-04-10 00:00:00',77,78,'left','medium','medium',77,72,65,80,77,78,78,76,70,78,77,78,78,79,73,76,69,77,65,75,57,54,77,76,82,36,37,35,14,11,6,15,14);
INSERT INTO player_attributes VALUES(119,158138,27316,'2015-01-16 00:00:00',78,78,'left','medium','medium',77,72,65,80,77,78,78,76,70,78,77,78,78,80,73,76,69,77,65,75,57,54,78,80,82,36,37,35,14,11,6,15,14);
INSERT INTO player_attributes VALUES(120,158138,27316,'2014-09-18 00:00:00',78,78,'left','medium','medium',77,72,65,80,77,78,78,76,70,78,77,78,78,80,73,76,69,77,66,75,57,54,78,80,82,36,37,35,14,11,6,15,14);
INSERT INTO player_attributes VALUES(121,158138,27316,'2014-04-18 00:00:00',78,80,'left','medium','medium',77,72,65,80,77,78,78,74,70,78,77,78,79,81,73,78,70,79,66,75,57,54,76,82,82,36,37,35,14,11,6,15,14);
INSERT INTO player_attributes VALUES(122,158138,27316,'2014-02-28 00:00:00',79,81,'left','medium','medium',77,73,66,80,77,80,78,74,70,78,77,78,79,81,73,78,70,79,66,77,57,54,77,82,82,36,37,35,14,11,6,15,14);
INSERT INTO player_attributes VALUES(123,158138,27316,'2014-02-14 00:00:00',79,81,'left','medium','medium',77,74,66,80,77,80,78,74,68,78,77,78,79,81,73,78,70,79,66,77,57,56,77,82,82,36,37,35,14,11,6,15,14);
INSERT INTO player_attributes VALUES(124,158138,27316,'2013-10-18 00:00:00',79,81,'left','medium','medium',77,74,66,80,77,80,78,74,68,78,77,78,79,81,73,78,70,79,66,77,57,56,77,82,82,36,37,35,14,11,6,15,14);
INSERT INTO player_attributes VALUES(125,158138,27316,'2013-09-20 00:00:00',79,81,'left','medium','medium',77,74,66,80,77,80,78,74,68,78,77,78,79,81,73,78,70,79,66,77,57,56,77,82,82,36,37,35,14,11,6,15,14);
INSERT INTO player_attributes VALUES(126,158138,27316,'2013-05-10 00:00:00',79,81,'left','medium','medium',77,71,66,80,77,79,77,73,68,78,77,74,79,78,72,76,70,79,66,78,55,57,77,82,82,30,30,32,14,11,6,15,14);
INSERT INTO player_attributes VALUES(127,158138,27316,'2013-04-19 00:00:00',79,81,'left','medium','medium',77,71,66,80,77,79,77,73,68,78,77,74,79,78,72,76,70,79,66,78,55,57,77,82,81,30,30,32,14,11,6,15,14);
INSERT INTO player_attributes VALUES(128,158138,27316,'2013-03-22 00:00:00',79,81,'left','medium','medium',77,71,66,80,77,79,77,73,68,78,77,75,79,78,72,76,70,78,66,78,55,57,77,82,76,30,30,32,14,11,6,15,14);
INSERT INTO player_attributes VALUES(129,158138,27316,'2013-02-15 00:00:00',79,81,'left','medium','medium',77,71,66,80,77,79,77,73,68,78,77,75,79,78,72,76,70,78,66,78,55,57,77,82,72,30,30,32,14,11,6,15,14);
INSERT INTO player_attributes VALUES(130,158138,27316,'2012-08-31 00:00:00',75,78,'left','medium','medium',75,69,66,75,77,79,77,70,64,76,77,77,79,74,72,76,70,68,66,73,55,57,71,76,68,30,27,29,14,11,6,15,14);
INSERT INTO player_attributes VALUES(131,158138,27316,'2012-02-22 00:00:00',75,78,'left','medium','medium',75,69,66,75,77,79,77,70,64,76,77,77,79,74,72,76,70,68,66,73,55,57,71,76,68,30,27,29,14,11,6,15,14);
INSERT INTO player_attributes VALUES(132,158138,27316,'2011-08-30 00:00:00',75,78,'left','medium','medium',75,69,66,75,77,79,77,70,64,75,77,77,79,74,72,76,70,72,66,73,55,57,71,76,68,30,27,29,14,11,6,15,14);
INSERT INTO player_attributes VALUES(133,158138,27316,'2011-02-22 00:00:00',76,83,'left','medium','medium',75,74,66,77,77,79,79,57,64,77,82,81,79,76,67,76,70,74,68,73,51,57,74,79,67,30,27,29,14,11,6,15,14);
INSERT INTO player_attributes VALUES(134,158138,27316,'2010-08-30 00:00:00',78,83,'left','medium','medium',76,77,66,79,80,81,79,57,64,79,82,81,79,77,67,77,70,74,68,73,51,57,74,83,67,30,27,29,14,11,6,15,14);
INSERT INTO player_attributes VALUES(135,158138,27316,'2010-02-22 00:00:00',78,83,'left','medium','medium',75,77,66,78,80,82,79,57,63,81,82,81,79,77,67,77,70,74,68,73,51,70,75,83,73,30,27,29,9,20,63,20,20);
INSERT INTO player_attributes VALUES(136,158138,27316,'2009-08-30 00:00:00',75,82,'left','medium','medium',63,77,66,76,80,80,79,48,48,79,77,74,79,75,67,77,70,69,66,72,49,67,73,83,68,30,25,29,9,20,48,20,20);
INSERT INTO player_attributes VALUES(137,158138,27316,'2008-08-30 00:00:00',76,86,'left','medium','medium',63,79,66,76,80,80,79,48,48,79,77,74,79,75,67,77,70,69,66,72,49,67,73,83,68,30,25,29,9,20,48,20,20);
INSERT INTO player_attributes VALUES(138,158138,27316,'2007-08-30 00:00:00',77,86,'left','medium','medium',63,79,66,76,80,74,79,48,48,79,77,74,79,73,67,77,70,69,66,68,49,67,73,83,68,30,25,29,9,20,48,20,20);
INSERT INTO player_attributes VALUES(139,158138,27316,'2007-02-22 00:00:00',73,80,'left','medium','medium',46,69,66,70,80,77,79,53,64,76,77,74,79,66,67,73,70,66,62,61,36,67,73,83,53,30,25,29,9,9,64,6,9);
INSERT INTO player_attributes VALUES(140,221280,564793,'2016-04-21 00:00:00',61,74,'right','medium','high',48,32,47,64,34,54,56,40,64,63,69,67,60,61,80,53,71,68,59,38,75,54,39,61,42,52,58,57,8,13,14,14,15);
INSERT INTO player_attributes VALUES(141,221280,564793,'2016-02-04 00:00:00',61,75,'right','medium','high',48,32,47,64,34,54,56,40,64,63,69,67,60,61,80,53,71,68,59,38,75,54,39,61,42,52,58,57,8,13,14,14,15);
INSERT INTO player_attributes VALUES(142,221280,564793,'2015-12-17 00:00:00',61,76,'right','medium','high',48,32,47,64,34,54,56,40,64,63,69,67,60,61,80,53,71,68,59,38,75,54,39,61,42,52,58,57,8,13,14,14,15);
INSERT INTO player_attributes VALUES(143,221280,564793,'2015-09-21 00:00:00',61,76,'right','medium','high',48,32,47,64,34,54,56,40,64,63,69,67,60,61,80,53,71,68,59,38,75,54,39,61,42,52,58,57,8,13,14,14,15);
INSERT INTO player_attributes VALUES(144,221280,564793,'2014-10-02 00:00:00',60,77,'right','medium','high',47,31,46,63,33,53,55,39,63,62,72,67,60,60,80,52,71,68,59,37,74,54,50,60,41,51,56,56,7,12,13,13,14);
INSERT INTO player_attributes VALUES(145,221280,564793,'2014-09-18 00:00:00',60,77,'right','medium','high',47,31,46,63,33,53,55,39,63,62,72,67,60,60,80,52,71,68,59,37,74,54,50,58,41,51,56,56,7,12,13,13,14);
INSERT INTO player_attributes VALUES(146,221280,564793,'2007-02-22 00:00:00',60,77,'right','medium','high',47,31,46,63,33,53,55,39,63,62,72,67,60,60,80,52,71,68,59,37,74,54,50,58,41,51,56,56,7,12,13,13,14);
INSERT INTO player_attributes VALUES(147,152747,30895,'2015-10-16 00:00:00',77,77,'right','high','medium',78,66,28,76,68,84,63,55,54,81,89,89,93,74,92,62,71,75,56,57,57,37,71,73,62,30,34,35,14,7,7,16,11);
INSERT INTO player_attributes VALUES(148,152747,30895,'2015-09-21 00:00:00',77,77,'right','high','medium',78,66,28,76,68,84,63,55,54,81,90,89,93,74,92,62,71,75,56,57,57,37,71,73,62,30,34,35,14,7,7,16,11);
INSERT INTO player_attributes VALUES(149,152747,30895,'2015-09-04 00:00:00',78,78,'right','high','medium',78,65,27,77,67,83,62,54,53,80,92,89,93,77,92,61,71,75,52,56,56,36,73,75,61,29,33,34,13,6,6,15,10);
INSERT INTO player_attributes VALUES(150,152747,30895,'2015-06-05 00:00:00',78,78,'right','high','medium',78,65,27,77,67,83,62,54,53,80,92,89,93,77,92,61,71,75,52,56,56,36,73,75,61,29,33,34,13,6,6,15,10);
INSERT INTO player_attributes VALUES(151,152747,30895,'2015-02-06 00:00:00',78,78,'right','high','medium',78,65,27,77,67,83,62,54,53,80,92,89,93,77,92,61,71,75,52,56,56,36,73,75,61,29,33,34,13,6,6,15,10);
INSERT INTO player_attributes VALUES(152,152747,30895,'2015-01-09 00:00:00',78,78,'right','high','medium',78,65,27,77,67,83,62,54,53,80,92,89,93,77,92,61,71,75,52,56,56,36,73,75,61,25,23,25,13,6,6,15,10);
INSERT INTO player_attributes VALUES(153,152747,30895,'2014-09-18 00:00:00',79,79,'right','high','medium',79,65,27,79,67,83,62,54,53,80,94,91,94,77,92,61,71,75,52,56,56,36,76,77,61,25,23,25,13,6,6,15,10);
INSERT INTO player_attributes VALUES(154,152747,30895,'2014-03-21 00:00:00',79,80,'right','high','medium',79,65,27,79,67,83,62,54,53,82,94,91,94,77,92,61,71,75,52,56,56,36,76,81,61,25,23,25,13,6,6,15,10);
INSERT INTO player_attributes VALUES(155,152747,30895,'2014-02-28 00:00:00',79,80,'right','high','medium',79,65,27,79,67,83,62,54,53,82,94,91,94,77,92,61,71,75,52,56,56,36,76,81,61,25,23,25,13,6,6,15,10);
INSERT INTO player_attributes VALUES(156,152747,30895,'2014-02-07 00:00:00',79,80,'right','high','medium',79,67,27,79,69,83,62,54,53,82,94,91,94,77,92,61,71,75,52,56,56,36,76,81,61,25,23,25,13,6,6,15,10);
INSERT INTO player_attributes VALUES(157,152747,30895,'2013-11-01 00:00:00',79,80,'right','high','medium',80,68,27,79,69,83,62,54,53,82,94,91,94,77,92,61,71,75,52,56,56,36,76,81,61,25,23,25,13,6,6,15,10);
INSERT INTO player_attributes VALUES(158,152747,30895,'2013-09-20 00:00:00',79,79,'right','high','medium',80,68,27,79,69,83,62,54,53,82,94,91,94,77,92,61,71,75,52,56,56,36,76,81,61,25,23,25,13,6,6,15,10);
INSERT INTO player_attributes VALUES(159,152747,30895,'2013-05-24 00:00:00',80,80,'right','high','medium',80,68,27,79,69,83,62,54,53,84,94,91,94,79,92,61,64,85,52,56,56,36,79,81,61,18,23,14,13,6,6,15,10);
INSERT INTO player_attributes VALUES(160,152747,30895,'2013-03-15 00:00:00',81,82,'right','high','medium',80,68,27,79,69,83,62,54,53,84,94,91,94,81,92,61,64,85,52,56,56,36,79,81,61,18,23,14,13,6,6,15,10);
INSERT INTO player_attributes VALUES(161,152747,30895,'2013-02-15 00:00:00',81,82,'right','high','medium',80,68,27,79,69,83,62,54,53,84,94,91,94,81,92,61,64,84,52,56,56,36,79,81,61,18,23,14,13,6,6,15,10);
INSERT INTO player_attributes VALUES(162,152747,30895,'2012-08-31 00:00:00',80,82,'right','high','medium',79,68,27,77,69,82,62,54,53,84,94,91,94,79,92,61,64,84,52,56,56,36,79,79,61,18,23,14,13,6,6,15,10);
INSERT INTO player_attributes VALUES(163,152747,30895,'2012-02-22 00:00:00',81,84,'right','high','medium',79,68,27,77,69,82,62,54,53,88,96,95,94,79,94,61,64,86,52,56,56,36,79,79,61,18,23,14,13,6,6,15,10);
INSERT INTO player_attributes VALUES(164,152747,30895,'2011-08-30 00:00:00',82,83,'right','high','medium',79,68,27,77,69,85,62,54,53,88,96,95,94,84,94,61,64,86,52,56,56,36,79,79,61,18,23,14,13,6,6,15,10);
INSERT INTO player_attributes VALUES(165,152747,30895,'2011-02-22 00:00:00',82,85,'right','high','medium',79,68,27,77,69,90,62,54,53,88,92,93,88,84,76,61,52,86,57,56,56,36,79,79,61,18,23,14,13,6,6,15,10);
INSERT INTO player_attributes VALUES(166,152747,30895,'2010-08-30 00:00:00',82,85,'right','high','medium',79,68,27,77,69,90,62,54,53,88,92,93,88,84,76,61,52,86,57,56,56,36,79,79,61,18,23,14,13,6,6,15,10);
INSERT INTO player_attributes VALUES(167,152747,30895,'2010-02-22 00:00:00',84,87,'right','high','medium',82,70,38,77,69,90,62,53,59,88,93,94,88,84,76,69,52,87,57,62,49,81,77,79,84,23,25,14,12,25,59,25,25);
INSERT INTO player_attributes VALUES(168,152747,30895,'2009-08-30 00:00:00',79,87,'right','high','medium',74,62,38,67,69,88,62,53,59,81,94,94,88,71,76,68,52,84,41,55,49,60,69,79,70,23,25,14,12,25,59,25,25);
INSERT INTO player_attributes VALUES(169,152747,30895,'2009-02-22 00:00:00',79,87,'right','high','medium',71,62,38,67,69,88,62,53,59,81,95,95,88,71,76,68,52,84,41,55,37,60,69,79,67,23,25,14,12,25,59,25,25);
INSERT INTO player_attributes VALUES(170,152747,30895,'2008-08-30 00:00:00',80,87,'right','high','medium',74,62,38,70,69,93,62,53,59,81,95,95,88,71,76,68,52,84,41,55,37,60,69,79,67,23,30,14,12,25,59,25,25);
INSERT INTO player_attributes VALUES(171,152747,30895,'2007-08-30 00:00:00',84,87,'right','high','medium',78,64,49,77,69,94,62,53,59,80,96,92,88,78,76,72,52,86,41,60,46,73,76,79,74,23,34,14,12,25,59,25,25);
INSERT INTO player_attributes VALUES(172,152747,30895,'2007-02-22 00:00:00',79,90,'right','high','medium',71,61,49,69,69,86,62,66,48,83,93,90,88,75,76,70,52,84,33,60,24,73,76,79,66,23,29,14,12,8,48,13,14);
INSERT INTO player_attributes VALUES(173,206592,528212,'2016-02-25 00:00:00',48,56,'right','medium','medium',12,15,16,23,14,15,14,18,18,22,15,26,31,45,24,26,38,18,44,12,21,19,14,15,41,15,15,12,53,41,39,51,53);
INSERT INTO player_attributes VALUES(174,206592,528212,'2016-01-28 00:00:00',48,57,'right','medium','medium',12,15,16,23,14,15,14,18,18,22,15,26,31,45,24,26,38,18,44,12,21,19,14,15,41,15,15,12,53,41,39,51,53);
INSERT INTO player_attributes VALUES(175,206592,528212,'2014-12-27 00:00:00',48,57,'right','medium','medium',12,15,16,23,14,15,14,18,18,22,15,26,31,45,24,26,38,18,44,12,21,19,14,15,41,15,15,12,53,41,39,51,53);
INSERT INTO player_attributes VALUES(176,206592,528212,'2014-10-31 00:00:00',48,57,'right','medium','medium',12,15,16,23,14,15,14,18,18,22,15,26,31,45,24,26,38,18,44,12,21,19,14,15,41,15,15,12,53,41,39,51,53);
INSERT INTO player_attributes VALUES(177,206592,528212,'2014-10-10 00:00:00',48,57,'right','medium','medium',12,15,16,23,14,15,14,18,18,22,15,26,31,45,24,26,38,18,44,12,21,19,14,15,41,15,15,12,53,41,39,51,53);
INSERT INTO player_attributes VALUES(178,206592,528212,'2014-03-21 00:00:00',48,57,'right','medium','medium',12,15,16,23,14,15,14,18,18,22,15,26,31,45,24,26,38,18,44,12,21,19,14,15,41,15,15,12,53,41,39,51,53);
INSERT INTO player_attributes VALUES(179,206592,528212,'2007-02-22 00:00:00',48,57,'right','medium','medium',12,15,16,23,14,15,14,18,18,22,15,26,31,45,24,26,38,18,44,12,21,19,14,15,41,15,15,12,53,41,39,51,53);
INSERT INTO player_attributes VALUES(180,188621,101042,'2015-12-03 00:00:00',69,69,'left','medium','medium',63,42,59,70,60,70,72,67,53,74,75,77,69,70,72,67,70,78,66,61,73,67,65,71,56,67,68,65,7,15,7,10,15);
INSERT INTO player_attributes VALUES(181,188621,101042,'2015-11-26 00:00:00',69,69,'left','medium','medium',63,42,59,70,60,70,72,67,53,74,75,77,69,70,72,67,70,78,66,61,73,67,65,71,56,67,68,65,7,15,7,10,15);
INSERT INTO player_attributes VALUES(182,188621,101042,'2015-10-30 00:00:00',69,69,'left','medium','medium',63,42,59,70,60,70,72,67,53,74,75,77,69,70,72,67,70,78,66,61,73,67,65,71,56,67,68,65,7,15,7,10,15);
INSERT INTO player_attributes VALUES(183,188621,101042,'2015-09-21 00:00:00',69,70,'left','medium','medium',63,42,59,70,60,70,72,67,53,74,75,77,69,70,72,67,70,78,66,61,73,67,65,71,56,67,68,65,7,15,7,10,15);
INSERT INTO player_attributes VALUES(184,188621,101042,'2014-09-18 00:00:00',67,68,'left','medium','medium',62,41,58,69,59,69,71,66,55,73,77,75,69,69,72,66,65,78,66,60,72,65,62,70,55,63,65,61,6,14,6,9,14);
INSERT INTO player_attributes VALUES(185,188621,101042,'2014-04-18 00:00:00',67,69,'left','medium','medium',65,41,58,71,59,69,71,66,60,73,77,75,69,69,79,66,65,77,66,60,72,65,62,62,55,62,65,60,6,14,6,9,14);
INSERT INTO player_attributes VALUES(186,188621,101042,'2014-04-11 00:00:00',67,69,'left','medium','medium',65,41,58,71,59,69,71,66,60,73,77,75,69,69,79,66,65,77,66,60,72,65,62,62,55,62,65,60,6,14,6,9,14);
INSERT INTO player_attributes VALUES(187,188621,101042,'2014-01-03 00:00:00',67,69,'left','medium','medium',65,41,58,71,59,69,71,66,60,73,77,75,69,69,79,66,65,77,66,60,78,64,62,62,55,62,65,60,6,14,6,9,14);
INSERT INTO player_attributes VALUES(188,188621,101042,'2013-11-29 00:00:00',67,69,'left','medium','medium',65,41,58,71,59,69,71,66,60,73,77,78,69,69,79,66,65,80,66,60,78,64,62,62,55,62,65,60,6,14,6,9,14);
INSERT INTO player_attributes VALUES(189,188621,101042,'2013-09-20 00:00:00',67,70,'left','medium','medium',65,41,58,71,59,69,71,66,60,73,77,78,69,69,79,66,65,79,66,60,78,64,62,62,55,62,65,60,6,14,6,9,14);
INSERT INTO player_attributes VALUES(190,188621,101042,'2013-05-31 00:00:00',67,71,'left','medium','medium',65,41,58,71,59,71,71,66,60,73,77,78,69,69,79,66,65,79,66,60,78,64,62,62,55,62,65,60,6,14,6,9,14);
INSERT INTO player_attributes VALUES(191,188621,101042,'2013-05-24 00:00:00',67,71,'left','medium','medium',65,41,58,71,59,71,71,66,60,73,77,78,69,69,79,66,65,79,66,60,78,64,62,62,55,62,65,60,6,14,6,9,14);
INSERT INTO player_attributes VALUES(192,188621,101042,'2013-03-01 00:00:00',68,71,'left','high','medium',64,51,58,71,59,71,71,66,60,73,77,78,69,69,79,66,65,79,66,60,78,65,67,62,55,63,65,62,6,14,6,9,14);
INSERT INTO player_attributes VALUES(193,188621,101042,'2013-02-15 00:00:00',67,71,'left','high','medium',64,51,56,70,59,71,71,66,60,71,77,78,69,67,79,66,65,79,66,60,78,64,66,60,55,63,65,62,6,14,6,9,14);
INSERT INTO player_attributes VALUES(194,188621,101042,'2012-08-31 00:00:00',68,72,'right','medium','high',64,45,61,70,59,71,71,65,58,70,77,78,69,67,77,66,63,78,66,57,65,55,65,66,52,58,62,60,6,14,6,9,14);
INSERT INTO player_attributes VALUES(195,188621,101042,'2012-02-22 00:00:00',67,71,'right','medium','high',64,43,58,64,59,69,71,65,57,68,73,75,72,67,65,66,63,74,65,55,65,55,64,66,52,60,60,62,6,14,6,9,14);
INSERT INTO player_attributes VALUES(196,188621,101042,'2011-08-30 00:00:00',64,67,'right','medium','high',63,63,49,63,59,69,69,55,60,66,63,65,67,65,65,63,63,69,65,67,65,59,58,63,52,60,61,62,6,14,6,9,14);
INSERT INTO player_attributes VALUES(197,188621,101042,'2008-08-30 00:00:00',64,67,'right','medium','high',63,63,49,63,59,69,69,55,60,66,63,65,67,65,65,63,63,69,65,67,65,59,58,63,52,60,61,62,6,14,6,9,14);
INSERT INTO player_attributes VALUES(198,188621,101042,'2007-02-22 00:00:00',64,67,'right','medium','high',63,63,49,63,59,69,69,55,60,66,63,65,67,65,65,63,63,69,65,67,65,59,58,63,52,60,61,62,6,14,6,9,14);

-- Add match table for test
CREATE TABLE match (
    id               INTEGER PRIMARY KEY,
    country_id       INTEGER,
    league_id        INTEGER,
    season           TEXT,
    stage            INTEGER,
    date             TEXT,
    match_api_id     INTEGER,
    home_team_api_id INTEGER,
    away_team_api_id INTEGER,
    home_team_goal   INTEGER,
    away_team_goal   INTEGER,
    home_player_X1   INTEGER,
    home_player_X2   INTEGER,
    home_player_X3   INTEGER,
    home_player_X4   INTEGER,
    home_player_X5   INTEGER,
    home_player_X6   INTEGER,
    home_player_X7   INTEGER,
    home_player_X8   INTEGER,
    home_player_X9   INTEGER,
    home_player_X10  INTEGER,
    home_player_X11  INTEGER,
    away_player_X1   INTEGER,
    away_player_X2   INTEGER,
    away_player_X3   INTEGER,
    away_player_X4   INTEGER,
    away_player_X5   INTEGER,
    away_player_X6   INTEGER,
    away_player_X7   INTEGER,
    away_player_X8   INTEGER,
    away_player_X9   INTEGER,
    away_player_X10  INTEGER,
    away_player_X11  INTEGER,
    home_player_Y1   INTEGER,
    home_player_Y2   INTEGER,
    home_player_Y3   INTEGER,
    home_player_Y4   INTEGER,
    home_player_Y5   INTEGER,
    home_player_Y6   INTEGER,
    home_player_Y7   INTEGER,
    home_player_Y8   INTEGER,
    home_player_Y9   INTEGER,
    home_player_Y10  INTEGER,
    home_player_Y11  INTEGER,
    away_player_Y1   INTEGER,
    away_player_Y2   INTEGER,
    away_player_Y3   INTEGER,
    away_player_Y4   INTEGER,
    away_player_Y5   INTEGER,
    away_player_Y6   INTEGER,
    away_player_Y7   INTEGER,
    away_player_Y8   INTEGER,
    away_player_Y9   INTEGER,
    away_player_Y10  INTEGER,
    away_player_Y11  INTEGER,
    goal             TEXT,
    shoton           TEXT,
    shotoff          TEXT,
    foulcommit       TEXT,
    card             TEXT,
    "cross"          TEXT,
    corner           TEXT,
    possession       TEXT
);

-- Insert test match data
INSERT INTO match VALUES(24446,21518,21518,'2015/2016',33,'2016-04-17 00:00:00',2030486,9906,7878,3,0,1,2,4,6,8,2,4,6,8,4,6,1,2,4,6,8,3,5,7,3,5,7,1,3,3,3,3,7,7,7,7,10,10,1,3,3,3,3,7,7,7,10,10,10,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);

-- Test data for result table calculation
-- Test League: Test League 2023/2024
-- Teams: Team A (id=10001), Team B (id=10002), Team C (id=10003)
-- Expected results:
--   1st: Team C - 4 points (1 win, 1 draw, 0 loss, goals: 4-2, diff: +2)
--   2nd: Team A - 3 points (1 win, 0 draw, 1 loss, goals: 3-3, diff: 0)
--   3rd: Team B - 1 point (0 win, 1 draw, 1 loss, goals: 3-5, diff: -2)

INSERT INTO league VALUES(99999,1729,'Test League');

INSERT INTO team VALUES(10001,10001,10001,'Test Team A','TTA');
INSERT INTO team VALUES(10002,10002,10002,'Test Team B','TTB');
INSERT INTO team VALUES(10003,10003,10003,'Test Team C','TTC');

-- Match 1: Team A vs Team B = 3-1 (Team A wins)
INSERT INTO match VALUES(90001,1729,99999,'2023/2024',1,'2023-08-12 15:00:00',9000001,10001,10002,3,1,1,2,3,4,5,6,7,8,9,10,11,1,2,3,4,5,6,7,8,9,10,11,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);

-- Match 2: Team B vs Team C = 2-2 (Draw)
INSERT INTO match VALUES(90002,1729,99999,'2023/2024',2,'2023-08-19 15:00:00',9000002,10002,10003,2,2,1,2,3,4,5,6,7,8,9,10,11,1,2,3,4,5,6,7,8,9,10,11,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);

-- Match 3: Team A vs Team C = 0-2 (Team C wins)
INSERT INTO match VALUES(90003,1729,99999,'2023/2024',3,'2023-08-26 15:00:00',9000003,10001,10003,0,2,1,2,3,4,5,6,7,8,9,10,11,1,2,3,4,5,6,7,8,9,10,11,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);

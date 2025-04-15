-- Areas
INSERT INTO area_entity (name, description, manager) VALUES ('Brattåsberget', 'Ett kuperat område med tät skog och rikligt med vilt.', 1);
INSERT INTO area_entity (name, description, manager) VALUES ('Rödmyrberget och Mogarna', 'Ett varierat landskap med både myrmarker och skog.', 2);
INSERT INTO area_entity (name, description, manager) VALUES ('Högåsen', 'Ett högt beläget område med god utsikt och mycket älg.', 3);
INSERT INTO area_entity (name, description, manager) VALUES ('Gammelkullen', 'Ett gammalt jaktområde med mycket historia och vilt.', 4);
INSERT INTO area_entity (name, description, manager) VALUES ('Långmyran', 'En långsträckt myr med goda möjligheter för fågeljakt.', 5);
INSERT INTO area_entity (name, description, manager) VALUES ('Storskogen', 'Ett stort skogsområde med varierande terräng och vilt.', 6);
INSERT INTO area_entity (name, description, manager) VALUES ('Björkåsen', 'Ett område med mycket björkskog och goda jaktmöjligheter.', NULL);
INSERT INTO area_entity (name, description, manager) VALUES ('Kråkberget', 'Ett bergigt område med mycket kråkor och andra fåglar.', NULL);
INSERT INTO area_entity (name, description, manager) VALUES ('Varglyan', 'Ett område känt för sina vargrevir och spännande jakt.', NULL);
INSERT INTO area_entity (name, description, manager) VALUES ('Älgmyren', 'En myr med mycket älg och goda jaktmöjligheter.', NULL);

-- Hunters
INSERT INTO hunter_entity (name, area_id) VALUES ('Erik Svensson', 1);
INSERT INTO hunter_entity (name, area_id) VALUES ('Anna Johansson', 2);
INSERT INTO hunter_entity (name, area_id) VALUES ('Lars Karlsson', 3);
INSERT INTO hunter_entity (name, area_id) VALUES ('Karin Nilsson', 4);
INSERT INTO hunter_entity (name, area_id) VALUES ('Johan Andersson', 5);
INSERT INTO hunter_entity (name, area_id) VALUES ('Eva Larsson', 6);

-- Additional Hunters
INSERT INTO hunter_entity (name, area_id) VALUES ('Olof Berg', 1);
INSERT INTO hunter_entity (name, area_id) VALUES ('Maja Lind', 2);
INSERT INTO hunter_entity (name, area_id) VALUES ('Nils Eriksson', 3);
INSERT INTO hunter_entity (name, area_id) VALUES ('Sara Persson', 4);
INSERT INTO hunter_entity (name, area_id) VALUES ('Gustav Åsberg', 1);
INSERT INTO hunter_entity (name, area_id) VALUES ('Elin Bergström', 2);
INSERT INTO hunter_entity (name, area_id) VALUES ('Fredrik Lund', 3);
INSERT INTO hunter_entity (name, area_id) VALUES ('Sofia Sandberg', 4);
INSERT INTO hunter_entity (name, area_id) VALUES ('Henrik Åkesson', 1);
INSERT INTO hunter_entity (name, area_id) VALUES ('Emma Blomberg', 2);
INSERT INTO hunter_entity (name, area_id) VALUES ('Viktor Nyström', 3);
INSERT INTO hunter_entity (name, area_id) VALUES ('Isabella Sjöberg', 4);
INSERT INTO hunter_entity (name, area_id) VALUES ('Alexander Dahl', 5);
INSERT INTO hunter_entity (name, area_id) VALUES ('Matilda Forsberg', 6);
INSERT INTO hunter_entity (name, area_id) VALUES ('Oscar Lindgren', 7);
INSERT INTO hunter_entity (name, area_id) VALUES ('Hanna Berglund', 8);
INSERT INTO hunter_entity (name, area_id) VALUES ('William Ek', 9);
INSERT INTO hunter_entity (name, area_id) VALUES ('Alice Björk', 10);
INSERT INTO hunter_entity (name, area_id) VALUES ('Lucas Ström', 10);
INSERT INTO hunter_entity (name, area_id) VALUES ('Moa Henriksson', 10);

-- Blinds
INSERT INTO blind_entity (description) VALUES ('Ett bra pass med god sikt.');
INSERT INTO blind_entity (description) VALUES ('Ett pass nära vatten med mycket vilt.');
INSERT INTO blind_entity (description) VALUES ('Ett pass i tät skog.');
INSERT INTO blind_entity (description) VALUES ('Ett pass med god utsikt över en dal.');
INSERT INTO blind_entity (description) VALUES ('Ett pass nära en myr.');
INSERT INTO blind_entity (description) VALUES ('Ett pass med mycket älg.');
INSERT INTO blind_entity (description) VALUES ('Ett pass med goda möjligheter för fågeljakt.');
INSERT INTO blind_entity (description) VALUES ('Ett pass med mycket rådjur.');
INSERT INTO blind_entity (description) VALUES ('Ett pass nära en bäck.');
INSERT INTO blind_entity (description) VALUES ( 'Ett pass med god sikt och mycket vilt.');

-- Reports
INSERT INTO report_entity (blind_id, repair, move, clear) VALUES (6, '', TRUE, FALSE);
INSERT INTO report_entity (blind_id, repair, move, clear) VALUES (7, '', FALSE, TRUE);
INSERT INTO report_entity (blind_id, repair, move, clear) VALUES (8, '', FALSE, TRUE);
INSERT INTO report_entity (blind_id, repair, move, clear) VALUES (9, '', TRUE, TRUE);


-- Observations
INSERT INTO observation_entity (blind_id, animal, count) VALUES (1, 'Älg', 2);
INSERT INTO observation_entity (blind_id, animal, count) VALUES (2, 'Rådjur', 3);
INSERT INTO observation_entity (blind_id, animal, count) VALUES (2, 'Rådjur', 1);
INSERT INTO observation_entity (blind_id, animal, count) VALUES (2, 'Älg', 1);
INSERT INTO observation_entity (blind_id, animal, count) VALUES (3, 'Rådjur', 1);
INSERT INTO observation_entity (blind_id, animal, count) VALUES (4, 'Rådjur', 2);

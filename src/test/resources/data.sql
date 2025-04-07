-- Areas
INSERT INTO area_entity (id, name, description, manager) VALUES (1, 'Brattåsberget', 'Ett kuperat område med tät skog och rikligt med vilt.', 1);
INSERT INTO area_entity (id, name, description, manager) VALUES (2, 'Rödmyrberget och Mogarna', 'Ett varierat landskap med både myrmarker och skog.', 2);
INSERT INTO area_entity (id, name, description, manager) VALUES (3, 'Högåsen', 'Ett högt beläget område med god utsikt och mycket älg.', 3);
INSERT INTO area_entity (id, name, description, manager) VALUES (4, 'Gammelkullen', 'Ett gammalt jaktområde med mycket historia och vilt.', 4);
INSERT INTO area_entity (id, name, description, manager) VALUES (5, 'Långmyran', 'En långsträckt myr med goda möjligheter för fågeljakt.', 5);
INSERT INTO area_entity (id, name, description, manager) VALUES (6, 'Storskogen', 'Ett stort skogsområde med varierande terräng och vilt.', 6);
INSERT INTO area_entity (id, name, description, manager) VALUES (7, 'Björkåsen', 'Ett område med mycket björkskog och goda jaktmöjligheter.', NULL);
INSERT INTO area_entity (id, name, description, manager) VALUES (8, 'Kråkberget', 'Ett bergigt område med mycket kråkor och andra fåglar.', NULL);
INSERT INTO area_entity (id, name, description, manager) VALUES (9, 'Varglyan', 'Ett område känt för sina vargrevir och spännande jakt.', NULL);
INSERT INTO area_entity (id, name, description, manager) VALUES (10, 'Älgmyren', 'En myr med mycket älg och goda jaktmöjligheter.', NULL);

-- Hunters
INSERT INTO hunter_entity (id, name, area_id) VALUES (1, 'Erik Svensson', 1);
INSERT INTO hunter_entity (id, name, area_id) VALUES (2, 'Anna Johansson', 2);
INSERT INTO hunter_entity (id, name, area_id) VALUES (3, 'Lars Karlsson', 3);
INSERT INTO hunter_entity (id, name, area_id) VALUES (4, 'Karin Nilsson', 4);
INSERT INTO hunter_entity (id, name, area_id) VALUES (5, 'Johan Andersson', 5);
INSERT INTO hunter_entity (id, name, area_id) VALUES (6, 'Eva Larsson', 6);

-- Additional Hunters
INSERT INTO hunter_entity (id, name, area_id) VALUES (7, 'Olof Berg', 1);
INSERT INTO hunter_entity (id, name, area_id) VALUES (8, 'Maja Lind', 2);
INSERT INTO hunter_entity (id, name, area_id) VALUES (9, 'Nils Eriksson', 3);
INSERT INTO hunter_entity (id, name, area_id) VALUES (10, 'Sara Persson', 4);
INSERT INTO hunter_entity (id, name, area_id) VALUES (11, 'Gustav Åsberg', 1);
INSERT INTO hunter_entity (id, name, area_id) VALUES (12, 'Elin Bergström', 2);
INSERT INTO hunter_entity (id, name, area_id) VALUES (13, 'Fredrik Lund', 3);
INSERT INTO hunter_entity (id, name, area_id) VALUES (14, 'Sofia Sandberg', 4);
INSERT INTO hunter_entity (id, name, area_id) VALUES (15, 'Henrik Åkesson', 1);
INSERT INTO hunter_entity (id, name, area_id) VALUES (16, 'Emma Blomberg', 2);
INSERT INTO hunter_entity (id, name, area_id) VALUES (17, 'Viktor Nyström', 3);
INSERT INTO hunter_entity (id, name, area_id) VALUES (18, 'Isabella Sjöberg', 4);
INSERT INTO hunter_entity (id, name, area_id) VALUES (19, 'Alexander Dahl', 5);
INSERT INTO hunter_entity (id, name, area_id) VALUES (20, 'Matilda Forsberg', 6);
INSERT INTO hunter_entity (id, name, area_id) VALUES (21, 'Oscar Lindgren', 7);
INSERT INTO hunter_entity (id, name, area_id) VALUES (22, 'Hanna Berglund', 8);
INSERT INTO hunter_entity (id, name, area_id) VALUES (23, 'William Ek', 9);
INSERT INTO hunter_entity (id, name, area_id) VALUES (24, 'Alice Björk', 10);
INSERT INTO hunter_entity (id, name, area_id) VALUES (25, 'Lucas Ström', 10);
INSERT INTO hunter_entity (id, name, area_id) VALUES (26, 'Moa Henriksson', 10);

-- Blinds
INSERT INTO blind_entity (id, description) VALUES (1, 'Ett bra pass med god sikt.');
INSERT INTO blind_entity (id, description) VALUES (2, 'Ett pass nära vatten med mycket vilt.');
INSERT INTO blind_entity (id, description) VALUES (3, 'Ett pass i tät skog.');
INSERT INTO blind_entity (id, description) VALUES (4, 'Ett pass med god utsikt över en dal.');
INSERT INTO blind_entity (id, description) VALUES (5, 'Ett pass nära en myr.');
INSERT INTO blind_entity (id, description) VALUES (6, 'Ett pass med mycket älg.');
INSERT INTO blind_entity (id, description) VALUES (7, 'Ett pass med goda möjligheter för fågeljakt.');
INSERT INTO blind_entity (id, description) VALUES (8, 'Ett pass med mycket rådjur.');
INSERT INTO blind_entity (id, description) VALUES (9, 'Ett pass nära en bäck.');
INSERT INTO blind_entity (id, description) VALUES (10, 'Ett pass med god sikt och mycket vilt.');

-- Update auto-increment value for area_entity
ALTER TABLE area_entity ALTER COLUMN id RESTART WITH 11;

-- Update auto-increment value for hunter_entity
ALTER TABLE hunter_entity ALTER COLUMN id RESTART WITH 27;

-- Update auto-increment value for blind_entity
ALTER TABLE blind_entity ALTER COLUMN id RESTART WITH 11;

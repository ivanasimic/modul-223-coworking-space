INSERT INTO "Rollen" (id, name)
VALUES (1, 'Administrator');

INSERT INTO "Rollen" (id, name)
VALUES (2, 'Mitglied');

INSERT INTO "Rollen" (id, name)
VALUES (3, 'Besucher');

INSERT INTO "Benutzer" (id, vorname, nachname, passwort, email)
VALUES (4, 'anna', 'meier', 'annameier123', 'annameier@gmail.com');

INSERT INTO "Benutzer" (id, vorname, nachname, passwort, email)
VALUES (5, 'tim' ,'hauser', 'startuphauser' ,'timhauser@gmail.com');

INSERT INTO "Benutzer" (id, vorname, nachname, passwort, email)
VALUES (6, 'hans', 'müller', 'hansmüller987', 'hansmüller@gmail.com');

INSERT INTO "Buchung" (id, zeit, tag)
VALUES (7, '7:30', 'dienstag');

INSERT INTO "Buchung" (id, zeit, tag)
VALUES (8, '10:00', 'freitag');

INSERT INTO "Mittagsmenue" (id, menue)
VALUES (9, 'pizza');

INSERT INTO "Mittagsmenue" (id, menue)
VALUES (10, 'pasta');

INSERT INTO "Gereat" (id, gereatetyp)
VALUES (11, 'mac book pro');

INSERT INTO "Gereat" (id, gereatetyp)
VALUES (12, 'hp pavilion');

INSERT INTO "Serienbuchung" (id, von, bis, zeitinterval) 
VALUES (13, '6.50', '11.45', '5');



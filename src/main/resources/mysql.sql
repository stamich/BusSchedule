CREATE DATABASE mzk_bielsko;

CREATE TABLE IF NOT EXISTS przystanek
(
    numer_przystanku INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    ulica VARCHAR(30) NOT NULL,
    nazwa_przystanku VARCHAR(30) NOT NULL,
    numer_linii VARCHAR(5) NOT NULL,
    kierunek VARCHAR(20) NOT NULL,
    godzina_odjazdu TIME NOT NULL
);

CREATE TABLE IF NOT EXISTS linia
(
    id_linii INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    numer_linii VARCHAR(5) NOT NULL,
    relacja VARCHAR(30) NOT NULL,
    kierunek VARCHAR(20) NOT NULL,
    wazny_od DATE NOT NULL,
    wazny_do DATE NOT NULL
);

CREATE TABLE IF NOT EXISTS przystanek_linia
(
    id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    `numer przystanku` INT NOT NULL,
    id_linii INT NOT NULL
);

ALTER TABLE przystanek_linia
ADD CONSTRAINT przystanek_linia_przystanek_numer_przystanku_fk
FOREIGN KEY (`numer przystanku`) REFERENCES przystanek (numer_przystanku);
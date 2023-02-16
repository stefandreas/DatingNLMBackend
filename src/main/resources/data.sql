INSERT INTO `characteristics`(characteristics)VALUES('Romantik'), ('Ärlig'),('Modig'), ('Trogen')
ON DUPLICATE KEY UPDATE characteristics = VALUES(characteristics);
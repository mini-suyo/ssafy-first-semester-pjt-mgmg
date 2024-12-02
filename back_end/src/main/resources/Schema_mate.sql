
DROP TABLE IF EXISTS `mate`;

CREATE TABLE `mate` (
	`userNo` INT NOT NULL,
    `mateName` VARCHAR(100) NOT NULL,
    `personality` VARCHAR(100) NOT NULL,
    `diaryCount` INT DEFAULT 0

) ENGINE=InnoDB DEFAULT CHARACTER SET = utf8mb4;

SELECT * FROM mate;
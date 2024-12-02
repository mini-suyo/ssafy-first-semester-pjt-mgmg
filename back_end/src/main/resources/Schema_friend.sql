DROP TABLE IF EXISTS `friend`;

CREATE TABLE `friend` (
    `userNo` INT NOT NULL,
    `friendNo` INT NOT NULL,
    `friendName` VARCHAR(100) NOT NULL
)ENGINE=InnoDB DEFAULT CHARACTER SET = utf8mb4;

SELECT * FROM friend
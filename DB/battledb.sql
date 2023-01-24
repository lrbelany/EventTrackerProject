-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema battledb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `battledb` ;

-- -----------------------------------------------------
-- Schema battledb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `battledb` DEFAULT CHARACTER SET utf8 ;
USE `battledb` ;

-- -----------------------------------------------------
-- Table `battle`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `battle` ;

CREATE TABLE IF NOT EXISTS `battle` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `location` VARCHAR(45) NULL,
  `win` TINYINT NULL,
  `mvp` TINYINT NULL,
  `points` INT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

SET SQL_MODE = '';
DROP USER IF EXISTS dbuser@localhost;
SET SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';
CREATE USER 'dbuser'@'localhost' IDENTIFIED BY 'dbuser';

GRANT SELECT, INSERT, TRIGGER, UPDATE, DELETE ON TABLE * TO 'dbuser'@'localhost';

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `battle`
-- -----------------------------------------------------
START TRANSACTION;
USE `battledb`;
INSERT INTO `battle` (`id`, `location`, `win`, `mvp`, `points`) VALUES (1, 'paradise plaza', NULL, NULL, NULL);

COMMIT;


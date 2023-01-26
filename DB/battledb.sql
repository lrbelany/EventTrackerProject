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
-- Table `arena`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `arena` ;

CREATE TABLE IF NOT EXISTS `arena` (
  `arenaid` INT NOT NULL AUTO_INCREMENT,
  `arena` VARCHAR(45) NULL,
  PRIMARY KEY (`arenaid`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `battle`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `battle` ;

CREATE TABLE IF NOT EXISTS `battle` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `kills` INT NULL,
  `win` TINYINT NULL,
  `mvpI` TINYINT NULL,
  `mvpII` TINYINT NULL,
  `mvpIII` TINYINT NULL,
  `points` INT NULL,
  `firepower` INT NULL,
  `captures` INT NULL,
  `arena_arenaid` INT NOT NULL,
  PRIMARY KEY (`id`, `arena_arenaid`),
  INDEX `fk_battle_arena1_idx` (`arena_arenaid` ASC),
  CONSTRAINT `fk_battle_arena1`
    FOREIGN KEY (`arena_arenaid`)
    REFERENCES `arena` (`arenaid`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
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
-- Data for table `arena`
-- -----------------------------------------------------
START TRANSACTION;
USE `battledb`;
INSERT INTO `arena` (`arenaid`, `arena`) VALUES (1, 'elon station gray');
INSERT INTO `arena` (`arenaid`, `arena`) VALUES (2, 'patterson station');
INSERT INTO `arena` (`arenaid`, `arena`) VALUES (3, 'imperial temple');
INSERT INTO `arena` (`arenaid`, `arena`) VALUES (4, 'paradise plaza');
INSERT INTO `arena` (`arenaid`, `arena`) VALUES (5, 'skyship 11');

COMMIT;


-- -----------------------------------------------------
-- Data for table `battle`
-- -----------------------------------------------------
START TRANSACTION;
USE `battledb`;
INSERT INTO `battle` (`id`, `kills`, `win`, `mvpI`, `mvpII`, `mvpIII`, `points`, `firepower`, `captures`, `arena_arenaid`) VALUES (1, 7, 1, 0, 0, 0, 20600, 421962, 1, 3);
INSERT INTO `battle` (`id`, `kills`, `win`, `mvpI`, `mvpII`, `mvpIII`, `points`, `firepower`, `captures`, `arena_arenaid`) VALUES (2, 10, 1, 1, 1, 0, 18300, 300345, 0, 2);

COMMIT;


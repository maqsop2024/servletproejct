-- MySQL Script generated by MySQL Workbench
-- Sun Oct  6 18:41:41 2024
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema funfit
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `funfit` ;

-- -----------------------------------------------------
-- Schema funfit
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `funfit` ;
-- -----------------------------------------------------
-- Schema funfit
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `funfit` ;

-- -----------------------------------------------------
-- Schema funfit
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `funfit` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `funfit` ;

-- -----------------------------------------------------
-- Table `funfit`.`Batch`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `funfit`.`Batch` ;

CREATE TABLE IF NOT EXISTS `funfit`.`Batch` (
  `BatchId` INT NOT NULL AUTO_INCREMENT,
  `BatchName` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`BatchId`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `funfit`.`Participants`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `funfit`.`Participants` ;

CREATE TABLE IF NOT EXISTS `funfit`.`Participants` (
  `ParticipantsId` INT NOT NULL AUTO_INCREMENT,
  `ParticipantFullName` VARCHAR(145) NULL,
  `BatchId` INT NULL,
  `Age` INT NULL,
  `Sex` VARCHAR(45) NULL,
  INDEX `BatchId_idx` (`BatchId` ASC) VISIBLE,
  PRIMARY KEY (`ParticipantsId`),
  CONSTRAINT `BatchId`
    FOREIGN KEY (`BatchId`)
    REFERENCES `funfit`.`Batch` (`BatchId`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

USE `funfit` ;

-- -----------------------------------------------------
-- Table `funfit`.`batch`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `funfit`.`batch` ;

CREATE TABLE IF NOT EXISTS `funfit`.`batch` (
  `BatchId` INT NOT NULL AUTO_INCREMENT,
  `BatchName` VARCHAR(150) NULL DEFAULT NULL,
  PRIMARY KEY (`BatchId`))
ENGINE = InnoDB
AUTO_INCREMENT = 39
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

ALTER TABLE `funfit`.`batch`  AUTO_INCREMENT = 1;
-- -----------------------------------------------------
-- Table `funfit`.`participants`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `funfit`.`participants` ;

CREATE TABLE IF NOT EXISTS `funfit`.`participants` (
  `ParticipantId` INT NOT NULL AUTO_INCREMENT,
  `BatchId` INT NULL DEFAULT NULL,
  `FullName` VARCHAR(45) NULL DEFAULT NULL,
  `Sex` VARCHAR(1) NULL DEFAULT NULL,
  `Age` INT NULL DEFAULT NULL,
  PRIMARY KEY (`ParticipantId`),
  INDEX `Participant_BatchId_idx` (`BatchId` ASC) VISIBLE,
  CONSTRAINT `Participant_Batch_Id`
    FOREIGN KEY (`BatchId`)
    REFERENCES `funfit`.`batch` (`BatchId`)
    ON DELETE CASCADE)
ENGINE = InnoDB
AUTO_INCREMENT = 27
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

ALTER TABLE `funfit`.`participants`  AUTO_INCREMENT = 1;
SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;



insert  into batch (BatchName) values ('Morning 8AM' );
insert  into batch (BatchName) values ('Morning 10AM' );
insert  into batch (BatchName) values ('Evening 8PM' );
insert  into batch (BatchName) values ('Evening 10PM' );

select * from batch;

insert into participants (BatchId, FullName, Sex, Age) values (1,'Masood Abedin','M',25);
insert into participants (BatchId, FullName, Sex, Age) values (2,'Ajay Devgan','M',25);
insert into participants (BatchId, FullName, Sex, Age) values (3,'Dua Lipa','F',25);
insert into participants (BatchId, FullName, Sex, Age) values (4,'Suzanne Sarandon','F',25); 


select p.ParticipantId, b.BatchName, p.FullName, p.Sex, p.Age
from participants p
join batch b on p.batchId = b.batchId;



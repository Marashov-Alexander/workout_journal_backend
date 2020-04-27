update mysql.user set host = '%' where user='root';

-- MyS-- MySQL Script generated by MySQL Workbench
-- Mon Apr 27 12:47:19 2020
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema WJDB
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema WJDB
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `WJDB` DEFAULT CHARACTER SET utf8 ;
USE `WJDB` ;

-- -----------------------------------------------------
-- Table `WJDB`.`Users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `WJDB`.`Users` (
                                              `id` INT NOT NULL AUTO_INCREMENT,
                                              `first_name` VARCHAR(45) NOT NULL,
                                              `last_name` VARCHAR(45) NULL,
                                              `email` VARCHAR(45) NOT NULL,
                                              `password` VARCHAR(45) NOT NULL,
                                              `is_male` VARCHAR(1) NULL,
                                              `age` INT NULL,
                                              PRIMARY KEY (`id`),
                                              UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE,
                                              UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE)
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `WJDB`.`ExerciseTypes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `WJDB`.`ExerciseTypes` (
                                                      `id` INT NOT NULL AUTO_INCREMENT,
                                                      `name` VARCHAR(45) NOT NULL,
                                                      PRIMARY KEY (`id`),
                                                      UNIQUE INDEX `name_UNIQUE` (`name` ASC) VISIBLE,
                                                      UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE)
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `WJDB`.`ParameterTypes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `WJDB`.`ParameterTypes` (
                                                       `id` INT NOT NULL AUTO_INCREMENT,
                                                       `name` VARCHAR(45) NOT NULL,
                                                       PRIMARY KEY (`id`),
                                                       UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
                                                       UNIQUE INDEX `name_UNIQUE` (`name` ASC) VISIBLE)
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `WJDB`.`MeasureUnits`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `WJDB`.`MeasureUnits` (
                                                     `id` INT NOT NULL AUTO_INCREMENT,
                                                     `name` VARCHAR(45) NOT NULL,
                                                     `acronym` VARCHAR(10) NOT NULL,
                                                     PRIMARY KEY (`id`),
                                                     UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
                                                     UNIQUE INDEX `acronym_UNIQUE` (`acronym` ASC) VISIBLE,
                                                     UNIQUE INDEX `name_UNIQUE` (`name` ASC) VISIBLE)
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `WJDB`.`Parameters`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `WJDB`.`Parameters` (
                                                   `id` INT NOT NULL AUTO_INCREMENT,
                                                   `name` VARCHAR(45) NOT NULL,
                                                   `measure_unit_id` INT NOT NULL,
                                                   `parameter_type_id` INT NOT NULL,
                                                   PRIMARY KEY (`id`),
                                                   UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
                                                   INDEX `measure_unit_id_idx` (`measure_unit_id` ASC) VISIBLE,
                                                   INDEX `exercise_type_id_idx` (`parameter_type_id` ASC) VISIBLE,
                                                   CONSTRAINT `measure_unit_id`
                                                       FOREIGN KEY (`measure_unit_id`)
                                                           REFERENCES `WJDB`.`MeasureUnits` (`id`)
                                                           ON DELETE NO ACTION
                                                           ON UPDATE NO ACTION,
                                                   CONSTRAINT `parameter_type_id`
                                                       FOREIGN KEY (`parameter_type_id`)
                                                           REFERENCES `WJDB`.`ParameterTypes` (`id`)
                                                           ON DELETE NO ACTION
                                                           ON UPDATE NO ACTION)
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `WJDB`.`Exercises`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `WJDB`.`Exercises` (
                                                  `id` INT NOT NULL AUTO_INCREMENT,
                                                  `name` VARCHAR(45) NOT NULL,
                                                  `description` VARCHAR(255) NULL,
                                                  `type_id` INT NOT NULL,
                                                  PRIMARY KEY (`id`),
                                                  INDEX `fk_Exercises_ExerciseTypes1_idx` (`type_id` ASC) VISIBLE,
                                                  CONSTRAINT `fk_Exercises_ExerciseTypes1`
                                                      FOREIGN KEY (`type_id`)
                                                          REFERENCES `WJDB`.`ExerciseTypes` (`id`)
                                                          ON DELETE NO ACTION
                                                          ON UPDATE NO ACTION)
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `WJDB`.`Exercises_Parameters`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `WJDB`.`Exercises_Parameters` (
                                                             `id` INT NOT NULL AUTO_INCREMENT,
                                                             `exercise_id` INT NOT NULL,
                                                             `parameter_id` INT NOT NULL,
                                                             PRIMARY KEY (`id`),
                                                             INDEX `fk_Exercises_Parameters_Exercises1_idx` (`exercise_id` ASC) VISIBLE,
                                                             INDEX `fk_Exercises_Parameters_Parameters1_idx` (`parameter_id` ASC) VISIBLE,
                                                             CONSTRAINT `fk_Exercises_Parameters_Exercises1`
                                                                 FOREIGN KEY (`exercise_id`)
                                                                     REFERENCES `WJDB`.`Exercises` (`id`)
                                                                     ON DELETE NO ACTION
                                                                     ON UPDATE NO ACTION,
                                                             CONSTRAINT `fk_Exercises_Parameters_Parameters1`
                                                                 FOREIGN KEY (`parameter_id`)
                                                                     REFERENCES `WJDB`.`Parameters` (`id`)
                                                                     ON DELETE NO ACTION
                                                                     ON UPDATE NO ACTION)
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `WJDB`.`Workouts`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `WJDB`.`Workouts` (
                                                 `id` INT NOT NULL AUTO_INCREMENT,
                                                 `name` VARCHAR(45) NOT NULL,
                                                 `description` VARCHAR(255) NULL,
                                                 PRIMARY KEY (`id`),
                                                 UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE)
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `WJDB`.`Workouts_Exercises`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `WJDB`.`Workouts_Exercises` (
                                                           `id` INT NOT NULL AUTO_INCREMENT,
                                                           `workout_id` INT NOT NULL,
                                                           `exercise_id` INT NOT NULL,
                                                           PRIMARY KEY (`id`),
                                                           UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
                                                           INDEX `fk_Workouts_Exercises_Workouts1_idx` (`workout_id` ASC) VISIBLE,
                                                           INDEX `fk_Workouts_Exercises_Exercises1_idx` (`exercise_id` ASC) VISIBLE,
                                                           CONSTRAINT `fk_Workouts_Exercises_Workouts1`
                                                               FOREIGN KEY (`workout_id`)
                                                                   REFERENCES `WJDB`.`Workouts` (`id`)
                                                                   ON DELETE NO ACTION
                                                                   ON UPDATE NO ACTION,
                                                           CONSTRAINT `fk_Workouts_Exercises_Exercises1`
                                                               FOREIGN KEY (`exercise_id`)
                                                                   REFERENCES `WJDB`.`Exercises` (`id`)
                                                                   ON DELETE NO ACTION
                                                                   ON UPDATE NO ACTION)
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `WJDB`.`UserWorkouts`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `WJDB`.`UserWorkouts` (
                                                     `id` INT NOT NULL AUTO_INCREMENT,
                                                     `name` VARCHAR(45) NOT NULL,
                                                     `comments` VARCHAR(255) NULL,
                                                     `user_id` INT NOT NULL,
                                                     `workout_id` INT NOT NULL,
                                                     PRIMARY KEY (`id`),
                                                     UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
                                                     INDEX `fk_UserWorkouts_Users1_idx` (`user_id` ASC) VISIBLE,
                                                     INDEX `fk_UserWorkouts_Workouts1_idx` (`workout_id` ASC) VISIBLE,
                                                     CONSTRAINT `fk_UserWorkouts_Users1`
                                                         FOREIGN KEY (`user_id`)
                                                             REFERENCES `WJDB`.`Users` (`id`)
                                                             ON DELETE NO ACTION
                                                             ON UPDATE NO ACTION,
                                                     CONSTRAINT `fk_UserWorkouts_Workouts1`
                                                         FOREIGN KEY (`workout_id`)
                                                             REFERENCES `WJDB`.`Workouts` (`id`)
                                                             ON DELETE NO ACTION
                                                             ON UPDATE NO ACTION)
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `WJDB`.`UserWorkouts_ParameterValues`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `WJDB`.`UserWorkouts_ParameterValues` (
                                                                     `id` INT NOT NULL AUTO_INCREMENT,
                                                                     `userWorkout_id` INT NOT NULL,
                                                                     `parameter_id` INT NOT NULL,
                                                                     `value` INT NOT NULL,
                                                                     PRIMARY KEY (`id`),
                                                                     UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
                                                                     INDEX `fk_UserWorkouts_ParameterValues_UserWorkouts1_idx` (`userWorkout_id` ASC) VISIBLE,
                                                                     INDEX `fk_UserWorkouts_ParameterValues_Parameters1_idx` (`parameter_id` ASC) VISIBLE,
                                                                     CONSTRAINT `fk_UserWorkouts_ParameterValues_UserWorkouts1`
                                                                         FOREIGN KEY (`userWorkout_id`)
                                                                             REFERENCES `WJDB`.`UserWorkouts` (`id`)
                                                                             ON DELETE NO ACTION
                                                                             ON UPDATE NO ACTION,
                                                                     CONSTRAINT `fk_UserWorkouts_ParameterValues_Parameters1`
                                                                         FOREIGN KEY (`parameter_id`)
                                                                             REFERENCES `WJDB`.`Parameters` (`id`)
                                                                             ON DELETE NO ACTION
                                                                             ON UPDATE NO ACTION)
    ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

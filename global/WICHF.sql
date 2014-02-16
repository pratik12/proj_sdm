SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `WICHF` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `WICHF` ;

-- -----------------------------------------------------
-- Table `WICHF`.`User`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `WICHF`.`User` (
  `user_id` VARCHAR(10) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `access_level` VARCHAR(45) NOT NULL DEFAULT 'user',
  PRIMARY KEY (`user_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `WICHF`.`Patient`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `WICHF`.`Patient` (
  `patient_id` INT NOT NULL,
  `h_card_no` VARCHAR(45) NOT NULL,
  `birth_date` DATE NOT NULL,
  `gender` VARCHAR(1) NULL,
  `phone_no` DECIMAL(10,0) NULL,
  `patient_name` VARCHAR(45) NULL,
  `annual_checkup` VARCHAR(1) NOT NULL,
  `Patientcol` VARCHAR(45) NULL,
  `user_id` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`patient_id`, `user_id`),
  INDEX `fk_Patient_User_idx` (`user_id` ASC),
  CONSTRAINT `fk_Patient_User`
    FOREIGN KEY (`user_id`)
    REFERENCES `WICHF`.`User` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `WICHF`.`Doctor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `WICHF`.`Doctor` (
  `doctor_id` INT NOT NULL,
  `doctor_name` VARCHAR(45) NOT NULL,
  `status` VARCHAR(45) NOT NULL,
  `user_id` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`doctor_id`, `user_id`),
  INDEX `fk_Doctor_User1_idx` (`user_id` ASC),
  CONSTRAINT `fk_Doctor_User1`
    FOREIGN KEY (`user_id`)
    REFERENCES `WICHF`.`User` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `WICHF`.`Nurse`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `WICHF`.`Nurse` (
  `nurse_id` INT NOT NULL,
  `nurse_name` VARCHAR(45) NOT NULL,
  `status` VARCHAR(45) NOT NULL,
  `User_user_id` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`nurse_id`, `User_user_id`),
  INDEX `fk_Nurse_User1_idx` (`User_user_id` ASC),
  CONSTRAINT `fk_Nurse_User1`
    FOREIGN KEY (`User_user_id`)
    REFERENCES `WICHF`.`User` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `WICHF`.`Room`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `WICHF`.`Room` (
  `room_id` INT NOT NULL,
  `room_no` INT NOT NULL,
  `room_status` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`room_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `WICHF`.`Appointment`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `WICHF`.`Appointment` (
  `appointment_id` INT NOT NULL AUTO_INCREMENT,
  `time_slot` INT NULL,
  `booked_through` VARCHAR(45) NOT NULL,
  `visit_type_id` INT NOT NULL,
  `active` TINYINT(1) NOT NULL,
  `appointment_date` DATE NOT NULL,
  `booked_date` DATE NOT NULL,
  `doctor_id` INT NULL,
  `room_id` INT NULL,
  `Appointmentcol` VARCHAR(45) NULL,
  `parent_ppointment_id` INT NULL,
  PRIMARY KEY (`appointment_id`, `parent_ppointment_id`),
  INDEX `fk_Appointment_Doctor1_idx` (`doctor_id` ASC),
  INDEX `fk_Appointment_Room1_idx` (`room_id` ASC),
  INDEX `fk_Appointment_Appointment1_idx` (`parent_ppointment_id` ASC),
  CONSTRAINT `fk_Appointment_Doctor1`
    FOREIGN KEY (`doctor_id`)
    REFERENCES `WICHF`.`Doctor` (`doctor_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Appointment_Room1`
    FOREIGN KEY (`room_id`)
    REFERENCES `WICHF`.`Room` (`room_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Appointment_Appointment1`
    FOREIGN KEY (`parent_ppointment_id`)
    REFERENCES `WICHF`.`Appointment` (`appointment_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `WICHF`.`Payment`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `WICHF`.`Payment` (
  `payment_id` INT NOT NULL,
  `card_num` VARCHAR(45) NOT NULL,
  `type_of_card` VARCHAR(45) NULL,
  `appointment_id` INT NOT NULL,
  PRIMARY KEY (`payment_id`),
  INDEX `fk_appoint_id_idx` (`appointment_id` ASC),
  CONSTRAINT `fk_appoint_id`
    FOREIGN KEY (`appointment_id`)
    REFERENCES `WICHF`.`Appointment` (`appointment_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `WICHF`.`Doctor_Non_Availability`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `WICHF`.`Doctor_Non_Availability` (
  `id` INT NOT NULL,
  `doctor_non_available_date` DATE NULL,
  `doctor_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_Doctor_Non_Availability_Doctor1`
    FOREIGN KEY (`doctor_id`)
    REFERENCES `WICHF`.`Doctor` (`doctor_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `WICHF`.`Room_Non_Availablity`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `WICHF`.`Room_Non_Availablity` (
  `room_non_availablity_date` DATE NULL,
  `id` INT NOT NULL,
  `room_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Room_Non_Availablity_Room1_idx` (`room_id` ASC),
  CONSTRAINT `fk_Room_Non_Availablity_Room1`
    FOREIGN KEY (`room_id`)
    REFERENCES `WICHF`.`Room` (`room_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

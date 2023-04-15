-- MySQL Script generated by MySQL Workbench
-- vie 14 abr 2023 21:03:49
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema Portfolio
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema Portfolio
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `Portfolio` ;
USE `Portfolio` ;

-- -----------------------------------------------------
-- Table `Portfolio`.`Person`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Portfolio`.`Person` (
  `idPerson` INT NOT NULL AUTO_INCREMENT,
  `Nombre` VARCHAR(45) NULL,
  `email` VARCHAR(255) NULL,
  PRIMARY KEY (`idPerson`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Portfolio`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Portfolio`.`user` (
  `password` VARCHAR(32) NOT NULL,
  `Person_idPerson` INT NOT NULL,
  PRIMARY KEY (`Person_idPerson`),
  CONSTRAINT `fk_user_Person1`
    FOREIGN KEY (`Person_idPerson`)
    REFERENCES `Portfolio`.`Person` (`idPerson`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table `Portfolio`.`Seccion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Portfolio`.`Seccion` (
  `idSeccion` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `user_Person_idPerson` INT NOT NULL,
  PRIMARY KEY (`idSeccion`, `user_Person_idPerson`),
  INDEX `fk_Seccion_user1_idx` (`user_Person_idPerson` ASC) VISIBLE,
  CONSTRAINT `fk_Seccion_user1`
    FOREIGN KEY (`user_Person_idPerson`)
    REFERENCES `Portfolio`.`user` (`Person_idPerson`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Portfolio`.`Proyectos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Portfolio`.`Proyectos` (
  `idProyectos` INT NOT NULL AUTO_INCREMENT,
  `image` VARCHAR(45) NULL,
  `title` VARCHAR(45) NULL,
  `detalle` VARCHAR(150) NULL,
  `tecnologias` VARCHAR(45) NULL,
  `live_link` VARCHAR(100) NULL,
  `git_link` VARCHAR(100) NULL,
  `Seccion_idSeccion` INT NOT NULL,
  PRIMARY KEY (`idProyectos`, `Seccion_idSeccion`),
  INDEX `fk_Proyectos_Seccion1_idx` (`Seccion_idSeccion` ASC) VISIBLE,
  CONSTRAINT `fk_Proyectos_Seccion1`
    FOREIGN KEY (`Seccion_idSeccion`)
    REFERENCES `Portfolio`.`Seccion` (`idSeccion`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Portfolio`.`Educacion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Portfolio`.`Educacion` (
  `idEducacion` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `image` VARCHAR(45) NULL,
  `time` VARCHAR(45) NULL,
  `detalle` VARCHAR(45) NULL,
  `Seccion_idSeccion` INT NOT NULL,
  PRIMARY KEY (`idEducacion`, `Seccion_idSeccion`),
  INDEX `fk_Educacion_Seccion1_idx` (`Seccion_idSeccion` ASC) VISIBLE,
  CONSTRAINT `fk_Educacion_Seccion1`
    FOREIGN KEY (`Seccion_idSeccion`)
    REFERENCES `Portfolio`.`Seccion` (`idSeccion`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Portfolio`.`Skill_Category`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Portfolio`.`Skill_Category` (
  `idSkill_Category` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `Seccion_idSeccion` INT NOT NULL,
  PRIMARY KEY (`idSkill_Category`, `Seccion_idSeccion`),
  UNIQUE INDEX `habilidad_UNIQUE` (`name` ASC) VISIBLE,
  INDEX `fk_Skill_Category_Seccion1_idx` (`Seccion_idSeccion` ASC) VISIBLE,
  CONSTRAINT `fk_Skill_Category_Seccion1`
    FOREIGN KEY (`Seccion_idSeccion`)
    REFERENCES `Portfolio`.`Seccion` (`idSeccion`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Portfolio`.`Seeker`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Portfolio`.`Seeker` (
  `idSeeker` INT NOT NULL,
  `Person_idPerson` INT NOT NULL,
  PRIMARY KEY (`idSeeker`, `Person_idPerson`),
  INDEX `fk_Seeker_Person1_idx` (`Person_idPerson` ASC) VISIBLE,
  CONSTRAINT `fk_Seeker_Person1`
    FOREIGN KEY (`Person_idPerson`)
    REFERENCES `Portfolio`.`Person` (`idPerson`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Portfolio`.`Experiencia`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Portfolio`.`Experiencia` (
  `idExperiencia` INT NOT NULL,
  `nombreEmpresa` VARCHAR(45) NULL,
  `trabajoActual` TINYINT NULL,
  `fechaDesde` DATE NULL,
  `fechaHasta` DATE NULL,
  `detalle` VARCHAR(150) NULL,
  `Seccion_idSeccion` INT NOT NULL,
  PRIMARY KEY (`idExperiencia`, `Seccion_idSeccion`),
  INDEX `fk_Experiencia_Seccion1_idx` (`Seccion_idSeccion` ASC) VISIBLE,
  CONSTRAINT `fk_Experiencia_Seccion1`
    FOREIGN KEY (`Seccion_idSeccion`)
    REFERENCES `Portfolio`.`Seccion` (`idSeccion`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Portfolio`.`Mensajes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Portfolio`.`Mensajes` (
  `IdMensajes` INT NOT NULL,
  `Asunto` VARCHAR(45) NULL,
  `Mensaje` VARCHAR(2000) NULL,
  `fecha` DATE NULL,
  `Seeker_idSeeker` INT NOT NULL,
  PRIMARY KEY (`IdMensajes`, `Seeker_idSeeker`),
  INDEX `fk_Mensajes_Seeker1_idx` (`Seeker_idSeeker` ASC) VISIBLE,
  CONSTRAINT `fk_Mensajes_Seeker1`
    FOREIGN KEY (`Seeker_idSeeker`)
    REFERENCES `Portfolio`.`Seeker` (`idSeeker`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Portfolio`.`SobreMi`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Portfolio`.`SobreMi` (
  `idSobreMi` INT NOT NULL,
  `ProfileImg` VARCHAR(100) NULL,
  `BannerImg` VARCHAR(100) NULL,
  `AboutMe` VARCHAR(400) NULL,
  `Seccion_idSeccion` INT NOT NULL,
  PRIMARY KEY (`idSobreMi`, `Seccion_idSeccion`),
  INDEX `fk_SobreMi_Seccion1_idx` (`Seccion_idSeccion` ASC) VISIBLE,
  CONSTRAINT `fk_SobreMi_Seccion1`
    FOREIGN KEY (`Seccion_idSeccion`)
    REFERENCES `Portfolio`.`Seccion` (`idSeccion`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Portfolio`.`Skill_Detail`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Portfolio`.`Skill_Detail` (
  `idDetalle_habilidad` INT NOT NULL,
  `name` VARCHAR(45) NULL,
  `Skill_Category_idSkill_Category` INT NOT NULL,
  PRIMARY KEY (`idDetalle_habilidad`, `Skill_Category_idSkill_Category`),
  UNIQUE INDEX `name_UNIQUE` (`name` ASC) VISIBLE,
  INDEX `fk_Skill_Detail_Skill_Category1_idx` (`Skill_Category_idSkill_Category` ASC) VISIBLE,
  CONSTRAINT `fk_Skill_Detail_Skill_Category1`
    FOREIGN KEY (`Skill_Category_idSkill_Category`)
    REFERENCES `Portfolio`.`Skill_Category` (`idSkill_Category`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Portfolio`.`nav`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Portfolio`.`nav` (
  `idnav` INT NOT NULL,
  `logo` VARCHAR(45) NULL,
  `Seccion_idSeccion` INT NOT NULL,
  `Seccion_user_Person_idPerson` INT NOT NULL,
  PRIMARY KEY (`idnav`, `Seccion_idSeccion`, `Seccion_user_Person_idPerson`),
  INDEX `fk_nav_Seccion1_idx` (`Seccion_idSeccion` ASC, `Seccion_user_Person_idPerson` ASC) VISIBLE,
  CONSTRAINT `fk_nav_Seccion1`
    FOREIGN KEY (`Seccion_idSeccion` , `Seccion_user_Person_idPerson`)
    REFERENCES `Portfolio`.`Seccion` (`idSeccion` , `user_Person_idPerson`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Portfolio`.`footer`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Portfolio`.`footer` (
  `idfooter` INT NOT NULL,
  `label` VARCHAR(45) NULL,
  `Seccion_idSeccion` INT NOT NULL,
  PRIMARY KEY (`idfooter`, `Seccion_idSeccion`),
  INDEX `fk_footer_Seccion1_idx` (`Seccion_idSeccion` ASC) VISIBLE,
  CONSTRAINT `fk_footer_Seccion1`
    FOREIGN KEY (`Seccion_idSeccion`)
    REFERENCES `Portfolio`.`Seccion` (`idSeccion`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Portfolio`.`Red_Social`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Portfolio`.`Red_Social` (
  `idRed_Social` INT NOT NULL,
  `nombre` VARCHAR(45) NULL,
  `link` VARCHAR(100) NULL,
  `footer_idfooter` INT NOT NULL,
  `footer_Seccion_idSeccion` INT NOT NULL,
  PRIMARY KEY (`idRed_Social`, `footer_idfooter`, `footer_Seccion_idSeccion`),
  INDEX `fk_Red_Social_footer1_idx` (`footer_idfooter` ASC, `footer_Seccion_idSeccion` ASC) VISIBLE,
  CONSTRAINT `fk_Red_Social_footer1`
    FOREIGN KEY (`footer_idfooter` , `footer_Seccion_idSeccion`)
    REFERENCES `Portfolio`.`footer` (`idfooter` , `Seccion_idSeccion`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

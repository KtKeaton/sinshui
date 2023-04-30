CREATE SCHEMA IF NOT EXISTS tech_salary;

CREATE TABLE IF NOT EXISTS tech_salary.company
(
    id            BIGINT      NOT NULL AUTO_INCREMENT,
    company_name  VARCHAR(20) NOT NULL,
    creation_time DATETIME    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    update_time   DATETIME ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (id),
    UNIQUE INDEX uni_idx_company_company_name (company_name)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

CREATE TABLE IF NOT EXISTS tech_salary.position_type
(
    id            BIGINT      NOT NULL AUTO_INCREMENT,
    position_type_name VARCHAR(20) NOT NULL,
    creation_time DATETIME    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    update_time   DATETIME ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (id),
    UNIQUE INDEX uni_idx_position_type_position_type (position_type_name)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

CREATE TABLE IF NOT EXISTS tech_salary.position_level
(
    id             BIGINT      NOT NULL AUTO_INCREMENT,
    position_level_name VARCHAR(20) NOT NULL,
    creation_time  DATETIME    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    update_time    DATETIME ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (id),
    UNIQUE INDEX uni_idx_position_level_position_level (position_level_name)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

CREATE TABLE IF NOT EXISTS tech_salary.position_detail
(
    id                         BIGINT       NOT NULL AUTO_INCREMENT,
    company_id                 BIGINT       NOT NULL,
    position_type_id           BIGINT       NOT NULL,
    position_level_id          BIGINT       NOT NULL,
    position_title             VARCHAR(20)  NOT NULL,
    relate_seniority           TINYINT      NOT NULL,
    current_seniority          TINYINT      NOT NULL,
    monthly_salary             INT          NOT NULL,
    bonus_money                INT          NOT NULL,
    annual_salary              INT          NOT NULL,
    daily_work_hour            TINYINT      NOT NULL,
    work_load_satisfaction     TINYINT      NOT NULL,
    emotional_satisfaction     TINYINT      NOT NULL,
    work_overtime_satisfaction TINYINT      NOT NULL,
    techniques                 VARCHAR(20)  NULL,
    notes                      VARCHAR(250) NULL,
    mark_time                  DATE         NULL,
    creation_time              DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP,
    update_time                DATETIME ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (id)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;



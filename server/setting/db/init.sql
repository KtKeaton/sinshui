CREATE SCHEMA IF NOT EXISTS tech_salary;

CREATE TABLE IF NOT EXISTS tech_salary.finish_file
(
    id            BIGINT       NOT NULL AUTO_INCREMENT,
    file_name     VARCHAR(100) NOT NULL,
    creation_time DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP,
    update_time   DATETIME ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (id),
    UNIQUE INDEX uni_idx_finish_file_file_name (file_name)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE utf8mb4_unicode_ci;

CREATE TABLE IF NOT EXISTS tech_salary.company_type
(
    id            BIGINT       NOT NULL AUTO_INCREMENT,
    type_name     VARCHAR(100) NOT NULL,
    creation_time DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP,
    update_time   DATETIME ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (id),
    UNIQUE INDEX uni_idx_company_type_type_name (type_name)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE utf8mb4_unicode_ci;

CREATE TABLE IF NOT EXISTS tech_salary.company
(
    id              BIGINT       NOT NULL AUTO_INCREMENT,
    company_type_id BIGINT       NOT NULL,
    company_name    VARCHAR(100) NOT NULL,
    creation_time   DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP,
    update_time     DATETIME ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (id),
    UNIQUE INDEX uni_idx_company_company_name (company_name),
    FOREIGN KEY (company_type_id) REFERENCES company_type (id)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE utf8mb4_unicode_ci;

CREATE TABLE IF NOT EXISTS tech_salary.position
(
    id            BIGINT       NOT NULL AUTO_INCREMENT,
    position_name VARCHAR(100) NOT NULL,
    creation_time DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP,
    update_time   DATETIME ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (id),
    UNIQUE INDEX uni_idx_position_type_position_name (position_name)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE utf8mb4_unicode_ci;

CREATE TABLE IF NOT EXISTS tech_salary.position_detail
(
    id                          BIGINT        NOT NULL AUTO_INCREMENT,
    company_id                  BIGINT        NOT NULL,
    position_id                 BIGINT        NOT NULL,
    job_level                   VARCHAR(100)  NOT NULL,
    relevant_experience         VARCHAR(100)  NOT NULL,
    current_tenure              VARCHAR(100)  NOT NULL,
    monthly_base_salary         VARCHAR(100)  NOT NULL,
    monthly_bonus               VARCHAR(150)  NOT NULL,
    total_annual_compensation   VARCHAR(100)  NOT NULL,
    daily_average_working_hours VARCHAR(100)  NOT NULL,
    overtime_frequency          TINYINT       NOT NULL,
    loading                     TINYINT       NOT NULL,
    job_satisfaction            TINYINT       NOT NULL,
    supplement                  VARCHAR(1000) NOT NULL,
    monthly_overtime            VARCHAR(100)  NULL,
    `timestamp`                 DATETIME      NULL,
    creation_time               DATETIME      NOT NULL DEFAULT CURRENT_TIMESTAMP,
    update_time                 DATETIME ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (id),
    FOREIGN KEY (company_id) REFERENCES company (id),
    FOREIGN KEY (position_id) REFERENCES position (id)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE utf8mb4_unicode_ci;



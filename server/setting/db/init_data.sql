USE tech_salary;

SET NAMES 'utf8';
# SET character_set_client = utf8;
# SET character_set_results = utf8;
# SET character_set_connection = utf8;

INSERT IGNORE INTO position_type (position_type_name)
VALUES ('前端'),
       ('後端'),
       ('全端'),
       ('測試'),
       ('硬體'),
       ('PM'),
       ('主管'),
       ('其他');

INSERT IGNORE INTO position_level (position_level_name)
VALUES ('初階'),
       ('中階'),
       ('高階'),
       ('無');






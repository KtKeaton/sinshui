USE tech_salary;

SET NAMES 'utf8';
# SET character_set_client = utf8;
# SET character_set_results = utf8;
# SET character_set_connection = utf8;
INSERT  IGNORE INTO company_type (type_name, label)
    VALUES ('soft', '純軟'),
            ('design-house', '豬屎屋'),
            ('system', '系統廠'),
            ('chemical', '化工化學'),
            ('device', '設備商'),
            ('semiconductor', '非設計半導體');

INSERT IGNORE INTO position (position_name)
VALUES ('前端'),
       ('後端'),
       ('全端'),
       ('測試'),
       ('硬體'),
       ('PM'),
       ('主管'),
       ('其他');







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







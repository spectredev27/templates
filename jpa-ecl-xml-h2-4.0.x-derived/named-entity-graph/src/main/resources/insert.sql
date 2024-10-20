UPDATE SEQUENCE SET SEQ_COUNT = SEQ_COUNT + 1 WHERE SEQ_NAME = 'SEQ_GEN';
INSERT INTO TEMPLATECLASS (ID, NAME, VERSION) VALUES((SELECT SEQ_COUNT FROM SEQUENCE WHERE SEQ_NAME = 'SEQ_GEN'), 'JPA', '1.0.0');

UPDATE SEQUENCE SET SEQ_COUNT = SEQ_COUNT + 1 WHERE SEQ_NAME = 'SEQ_GEN';
INSERT INTO TEMPLATESUBCLASS (ID, SERIAL, TEMPLATECLASS_ID) VALUES ((SELECT SEQ_COUNT FROM SEQUENCE WHERE SEQ_NAME = 'SEQ_GEN'), '1659101', 1);

UPDATE SEQUENCE SET SEQ_COUNT = SEQ_COUNT + 1 WHERE SEQ_NAME = 'SEQ_GEN';
INSERT INTO TEMPLATESUBCLASSDETAIL (ID, NOTE1, NOTE2, SUBCLASS_ID) VALUES ((SELECT SEQ_COUNT FROM SEQUENCE WHERE SEQ_NAME = 'SEQ_GEN'), 'Note content', NULL, 2);
UPDATE SEQUENCE SET SEQ_COUNT = SEQ_COUNT + 1 WHERE SEQ_NAME = 'SEQ_GEN';
INSERT INTO TEMPLATESUBCLASSDETAIL (ID, NOTE1, NOTE2, SUBCLASS_ID) VALUES ((SELECT SEQ_COUNT FROM SEQUENCE WHERE SEQ_NAME = 'SEQ_GEN'), 'Note content as well', NULL, 2);

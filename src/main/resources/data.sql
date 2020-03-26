--DROPS
DROP TABLE IF EXISTS txn_card_application cascade;
DROP TABLE IF EXISTS txn_status cascade;
DROP TABLE IF EXISTS transaction;

DROP SEQUENCE IF EXISTS TXN_SEQUENCE_ID;

--CREATE TABLES--
CREATE TABLE txn_status (
    id_status   INTEGER NOT NULL PRIMARY KEY,
    dsc_status  VARCHAR2(20)
);

-----

CREATE TABLE txn_card_application (
    id_card_application   INTEGER NOT NULL PRIMARY KEY,
    dsc_card_application  VARCHAR2(40)
);

-----

CREATE TABLE transaction (
    id_txn               INTEGER NOT NULL PRIMARY KEY,
    date	             VARCHAR2(20),
    time	             VARCHAR2(20),
    value                NUMBER,
    id_card_application  INTEGER NOT NULL,
    id_status            INTEGER NOT NULL
);

ALTER TABLE transaction
    ADD CONSTRAINT txn_x_card_app_fk FOREIGN KEY ( id_card_application )
        REFERENCES txn_card_application ( id_card_application );

ALTER TABLE transaction
    ADD CONSTRAINT txn_x_status_fk FOREIGN KEY ( id_status )
        REFERENCES txn_status ( id_status );


--CREATE SEQUENCES
CREATE SEQUENCE TXN_SEQUENCE_ID START WITH 1000 INCREMENT BY 1;

--INSERTS
INSERT INTO TXN_STATUS(id_status, dsc_status) values (1, 'SUCESS');
INSERT INTO TXN_STATUS(id_status, dsc_status) values (2, 'PENDING');
INSERT INTO TXN_STATUS(id_status, dsc_status) values (3, 'CANCELED');
INSERT INTO TXN_STATUS(id_status, dsc_status) values (4, 'FAILED');

INSERT INTO TXN_CARD_APPLICATION(id_card_application, dsc_card_application) values (1, 'DEBITO');
INSERT INTO TXN_CARD_APPLICATION(id_card_application, dsc_card_application) values (2, 'CREDITO');
INSERT INTO TXN_CARD_APPLICATION(id_card_application, dsc_card_application) values (3, 'VOUCHER');

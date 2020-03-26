--DROPS
DROP TABLE IF EXISTS transaction;

DROP SEQUENCE IF EXISTS TXN_SEQUENCE_ID;


CREATE TABLE transaction (
    id_txn               INTEGER NOT NULL PRIMARY KEY,
    date	             VARCHAR2(20),
    time	             VARCHAR2(20),
    value                NUMBER,
    id_card_application  VARCHAR2(30),
    id_status            VARCHAR2(30)
);

--CREATE SEQUENCES
CREATE SEQUENCE TXN_SEQUENCE_ID START WITH 1000 INCREMENT BY 1;
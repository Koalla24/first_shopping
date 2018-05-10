select * from mysql.general_log order by event_time DESC;

ALTER TABLE shopping.sales_table AUTO_INCREMENT = 1;
TRUNCATE TABLE shopping.contragents;
select * from shopping.contragents order by name;

INSERT INTO shopping.contragents(name)
VALUES ('Pupkin Vasya'), ('Roga, Copyta & Co OAO'), ('GAZ - ne vash OAO'), ('Prem gaz u vas OAO'), ('Ochen shustraya co OOO');

commit;

ALTER TABLE shopping.goods CHANGE COLUMN id id BIGINT(20) NOT NULL AUTO_INCREMENT;
ALTER TABLE shopping.goods AUTO_INCREMENT = 1;
TRUNCATE TABLE shopping.goods;
select * from shopping.goods order by name;

INSERT INTO shopping.goods(name)
VALUES ('Vodka palenaya 38%'), ('Otkrovennaya sivuha 31%'), ('Metiloviy spirt 78%'), ('Pochti etanol 61%'),
       ('Milk poroshkovoe badjazhnoe 3.2%'), ('Milk poroshkovoe badjazhnoe 4%'), ('Milk poroshkovoe badjazhnoe 1%'),
       ('Hleb chorniy classic'), ('Hleb chorniy tipa baton');

ALTER TABLE shopping.sales_header CHANGE COLUMN id id BIGINT(20) NOT NULL DEFAULT 1 ;
ALTER TABLE shopping.sales_header CHANGE COLUMN id id BIGINT(20) NOT NULL AUTO_INCREMENT;
ALTER TABLE shopping.sales_header AUTO_INCREMENT = 1;

ALTER TABLE shopping.sales_table CHANGE COLUMN id id BIGINT(20) NOT NULL DEFAULT 1 ;
ALTER TABLE shopping.sales_table CHANGE COLUMN id id BIGINT(20) NOT NULL AUTO_INCREMENT;
ALTER TABLE shopping.sales_table AUTO_INCREMENT = 1;

select * from shopping.sales_header order by id;

INSERT INTO shopping.sales_header(date_doc, num_doc, id_contragent)
VALUES (date('20180401'),'0001/20180401',1), (date('20180504'),'0002/20180504',1), (date('20180417'),'0003/20180417',4),
       (date('20180506'),'0004/20180506',4), (date('20180507'),'0005/20180507',1), (date('20180509'),'0006/20180509',2);


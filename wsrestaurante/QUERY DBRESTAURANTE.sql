
CREATE TABLE dbrestaurante.tbingrediente (
  idingrediente BIGINT NOT NULL AUTO_INCREMENT,
  txnome VARCHAR(255) NOT NULL,
  preco DECIMAL(10,2),
  PRIMARY KEY (idingrediente)
);

CREATE TABLE dbrestaurante.tblanche (
  idlanche BIGINT NOT NULL AUTO_INCREMENT,
  txnome VARCHAR(255) NOT NULL,
  preco DECIMAL(10,2),
  PRIMARY KEY (idlanche)
);

CREATE TABLE dbrestaurante.tblanche_ingrediente (
  idlanche BIGINT NOT NULL,
  idingrediente BIGINT NOT NULL,
  PRIMARY KEY (idlanche, idingrediente),
  FOREIGN KEY (idlanche) REFERENCES dbrestaurante.tblanche (idlanche),
  FOREIGN KEY (idingrediente) REFERENCES dbrestaurante.tbingrediente (idingrediente)
);



INSERT INTO dbrestaurante.tbingrediente (txnome, preco)
VALUES 
('Alface', 0.40),
('Bacon', 2.00),
('Hambúrguer', 3.00),
('Ovo', 0.80),
('Queijo', 1.50),
('Exemplo', 0.40);

INSERT INTO dbrestaurante.tblanche (txnome, preco)
VALUES 
('X-Bacon', 0),
('X-Burger', 0),
('X-Egg', 0),
('X-Egg Bacon', 0),
('NAO SELECIONADO', 0);

update dbrestaurante.tblanche SET IDLANCHE = 0 WHERE IDLANCHE = 5;

INSERT INTO dbrestaurante.tblanche_ingrediente (idlanche, idingrediente)
VALUES 
(1, 2), -- X-Bacon: Bacon, Hambúrguer, Queijo
(1, 3),
(1, 5),
(2, 3), -- X-Burger: Hambúrguer, Queijo
(2, 5),
(3, 3), -- X-Egg: Hambúrguer, Queijo, Ovo
(3, 4),
(3, 5),
(4, 2), -- X-Egg Bacon: Bacon, Hambúrguer, Queijo, Ovo
(4, 3),
(4, 4),
(4, 5);

UPDATE dbrestaurante.tblanche L
JOIN (
  SELECT idlanche, SUM(preco) AS preco
  FROM (
    SELECT DISTINCT L.idlanche, I.preco
    FROM dbrestaurante.tblanche L
    JOIN dbrestaurante.tblanche_ingrediente LI ON L.idlanche = LI.idlanche
    JOIN dbrestaurante.tbingrediente I ON LI.idingrediente = I.idingrediente
  ) AS T
  GROUP BY idlanche
) AS T ON L.idlanche = T.idlanche
SET L.preco = T.preco;

SET SQL_SAFE_UPDATES = 0;

SELECT * FROM dbrestaurante.tbingrediente;
SELECT * FROM dbrestaurante.tblanche;
SELECT * FROM dbrestaurante.tblanche_ingrediente;


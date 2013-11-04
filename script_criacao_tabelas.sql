-- Generated by Oracle SQL Developer Data Modeler 3.3.0.747
--   at:        2013-10-28 09:28:01 BRST
--   site:      Oracle Database 11g
--   type:      Oracle Database 11g




CREATE
  TABLE Arbitro
  (
    codigo NUMBER NOT NULL ,
    nome   VARCHAR2 (30)
  ) ;
COMMENT ON TABLE Arbitro
IS
  'Tabela �rbitro
- Cont�m as informa��es dos �rbitros cadastrados em cada campeonato'
  ;
  ALTER TABLE Arbitro ADD CONSTRAINT Arbitro_PK PRIMARY KEY
  (
    codigo
  )
  ;

CREATE
  TABLE Campeonato
  (
    codigo NUMBER NOT NULL ,
    nome   VARCHAR2 (20) ,
    ano    VARCHAR2 (4)
  ) ;
COMMENT ON TABLE Campeonato
IS
  'Tabela Campeonato
- Tabela Principal' ;
  ALTER TABLE Campeonato ADD CONSTRAINT Campeonato_PK PRIMARY KEY
  (
    codigo
  )
  ;

CREATE
  TABLE Equipe
  (
    codigo NUMBER NOT NULL ,
    nome   VARCHAR2 (30)
  ) ;
COMMENT ON TABLE Equipe
IS
  'Tabel Equipe
- Tabel que cont�m as informa�eos das equipes participantes de cada campeonato'
  ;
  ALTER TABLE Equipe ADD CONSTRAINT Equipe_PK PRIMARY KEY
  (
    codigo
  )
  ;

CREATE
  TABLE Estadio
  (
    codigo NUMBER NOT NULL ,
    nome   VARCHAR2 (30)
  ) ;
COMMENT ON TABLE Estadio
IS
  'Tabela Est�dio
- Cont�m as informa��es referentes aos est�dio cadastrados em cada campeonato'
  ;
  ALTER TABLE Estadio ADD CONSTRAINT Estadio_PK PRIMARY KEY
  (
    codigo
  )
  ;

CREATE
  TABLE Estadio_Equipe
  (
    Estadio_codigo NUMBER NOT NULL ,
    Equipe_codigo  NUMBER NOT NULL
  ) ;
COMMENT ON TABLE Estadio_Equipe
IS
  'Tabela Estadio_Equipe
- Tabela auxliar que cont�m as refer�ncias de Est�dio e Equipe'
  ;
  ALTER TABLE Estadio_Equipe ADD CONSTRAINT Estadio_Equipe_PK PRIMARY KEY
  (
    Estadio_codigo, Equipe_codigo
  )
  ;

CREATE
  TABLE Jogador
  (
    Equipe_codigo NUMBER NOT NULL ,
    codigo        NUMBER NOT NULL ,
    nome          VARCHAR2 (30)
  ) ;
COMMENT ON TABLE Jogador
IS
  'Table Jogador
- Table que armazena as informa��es de cada jogador' ;
  ALTER TABLE Jogador ADD CONSTRAINT Jogador_PK PRIMARY KEY
  (
    codigo
  )
  ;

CREATE
  TABLE Jogador_Time_Campeonato
  (
    Campeonato_codigo NUMBER NOT NULL ,
    Equipe_codigo     NUMBER NOT NULL ,
    Jogador_codigo    NUMBER NOT NULL
  ) ;
COMMENT ON TABLE Jogador_Time_Campeonato
IS
  'Tabela Jogador_Time_Campeonato
- Tabela que cont�m informa��es referentes aos jogadores que participaram de cada campeonato e por qual time'
  ;

CREATE
  TABLE Partida
  (
    Rodada_Campeonato_codigo NUMBER NOT NULL ,
    Rodada_codigo            NUMBER NOT NULL ,
    codigo                   NUMBER NOT NULL ,
    Arbitro_codigo           NUMBER NOT NULL ,
    Estadio_codigo           NUMBER NOT NULL ,
    Equipe_codigo            NUMBER NOT NULL ,
    Equipe_codigo1           NUMBER NOT NULL
  ) ;
COMMENT ON TABLE Partida
IS
  'Tabela Partida
- Tabela que conter� cada partida de cada rodada
- Listar�:   
as duas equipes participantes 
o est�dio em que a partida foi realizada 
o �rbitro que apitou a partida'
  ;
  ALTER TABLE Partida ADD CONSTRAINT Partida_PK PRIMARY KEY
  (
    Rodada_Campeonato_codigo, Rodada_codigo, codigo
  )
  ;

CREATE
  TABLE Rodada
  (
    Campeonato_codigo NUMBER NOT NULL ,
    codigo            NUMBER NOT NULL
  ) ;
COMMENT ON TABLE Rodada
IS
  'Tabela Rodada
- Tabela que listar� a quantidade de rodadas de cada campeonato'
  ;
  ALTER TABLE Rodada ADD CONSTRAINT Rodada_PK PRIMARY KEY
  (
    codigo, Campeonato_codigo
  )
  ;

ALTER TABLE Estadio_Equipe ADD CONSTRAINT Estadio_Equipe_Equipe_FK FOREIGN KEY
( Equipe_codigo ) REFERENCES Equipe ( codigo ) ;

ALTER TABLE Estadio_Equipe ADD CONSTRAINT Estadio_Equipe_Estadio_FK FOREIGN KEY
( Estadio_codigo ) REFERENCES Estadio ( codigo ) ;

ALTER TABLE Jogador_Time_Campeonato ADD CONSTRAINT Jog_Time_Camp_Equipe_FK
FOREIGN KEY ( Equipe_codigo ) REFERENCES Equipe ( codigo ) ;

ALTER TABLE Jogador_Time_Campeonato ADD CONSTRAINT Jog_Time_Camp_Jog_FK FOREIGN
KEY ( Jogador_codigo ) REFERENCES Jogador ( codigo ) ;

ALTER TABLE Jogador_Time_Campeonato ADD CONSTRAINT Jog_Time_Campo_Camp_FK
FOREIGN KEY ( Campeonato_codigo ) REFERENCES Campeonato ( codigo ) ;

ALTER TABLE Jogador ADD CONSTRAINT Jogador_Equipe_FK FOREIGN KEY (
Equipe_codigo ) REFERENCES Equipe ( codigo ) ;

ALTER TABLE Partida ADD CONSTRAINT Partida_Arbitro_FK FOREIGN KEY (
Arbitro_codigo ) REFERENCES Arbitro ( codigo ) ;

ALTER TABLE Partida ADD CONSTRAINT Partida_Equipe1_FK FOREIGN KEY (
Equipe_codigo ) REFERENCES Equipe ( codigo ) ;

ALTER TABLE Partida ADD CONSTRAINT Partida_Equipe2_FK FOREIGN KEY (
Equipe_codigo1 ) REFERENCES Equipe ( codigo ) ;

ALTER TABLE Partida ADD CONSTRAINT Partida_Estadio_FK FOREIGN KEY (
Estadio_codigo ) REFERENCES Estadio ( codigo ) ;

ALTER TABLE Partida ADD CONSTRAINT Partida_Rodada_FK FOREIGN KEY (
Rodada_codigo, Rodada_Campeonato_codigo ) REFERENCES Rodada ( codigo,
Campeonato_codigo ) ;

ALTER TABLE Rodada ADD CONSTRAINT Rodada_Campeonato_FK FOREIGN KEY (
Campeonato_codigo ) REFERENCES Campeonato ( codigo ) ;

commit 
    comment 'cria��o das tabelas';
-- Oracle SQL Developer Data Modeler Summary Report: 
-- 
-- CREATE TABLE                             9
-- CREATE INDEX                             0
-- ALTER TABLE                             20
-- CREATE VIEW                              0
-- CREATE PACKAGE                           0
-- CREATE PACKAGE BODY                      0
-- CREATE PROCEDURE                         0
-- CREATE FUNCTION                          0
-- CREATE TRIGGER                           0
-- ALTER TRIGGER                            0
-- CREATE COLLECTION TYPE                   0
-- CREATE STRUCTURED TYPE                   0
-- CREATE STRUCTURED TYPE BODY              0
-- CREATE CLUSTER                           0
-- CREATE CONTEXT                           0
-- CREATE DATABASE                          0
-- CREATE DIMENSION                         0
-- CREATE DIRECTORY                         0
-- CREATE DISK GROUP                        0
-- CREATE ROLE                              0
-- CREATE ROLLBACK SEGMENT                  0
-- CREATE SEQUENCE                          0
-- CREATE MATERIALIZED VIEW                 0
-- CREATE SYNONYM                           0
-- CREATE TABLESPACE                        0
-- CREATE USER                              0
-- 
-- DROP TABLESPACE                          0
-- DROP DATABASE                            0
-- 
-- ERRORS                                   0
-- WARNINGS                                 0

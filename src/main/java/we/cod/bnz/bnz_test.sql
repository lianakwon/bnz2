-- 전체 SQL 

use bnz_test;

SELECT * FROM user;
SELECT * FROM team;
SELECT * FROM member;
SELECT * FROM board;
SELECT * FROM comment;
SELECT * FROM board_bookmark;
SELECT * FROM comment_bookmark;

-- INSERT INTO user(nickname) VALUE ('11111'), ('22222'), ('33333'), ('44444'), ('55555'), ('66666'),('77777'), ('88888'), ('99999'), ('00000');
-- INSERT INTO team(title) VALUE ('111'), ('222'), ('333'), ('444'), ('555'), ('666'), ('777'), ('888'), ('999'), ('000');
INSERT INTO member(team_id, user_id) VALUE (1,1), (2,1), (3,1), (2,2), (3,2), (4,2), (3,3), (4,3), (5,3), (4,4), (5,4), (6,4), (5,5), (6,5), (7,5), (6,6), (7,6), (8,6), (7,7), (8,7), (9,7), (8,8), (9,8), (10,8), (9,9), (10,9), (1,9), (10,10), (1,10), (2,10);
INSERT INTO board(title, content, author_id) VALUE ('1111','11111111',1), ('2222','22222222',2), ('3333','33333333',3), ('4444','44444444',4), ('5555','55555555',5), ('6666','66666666',6), ('7777','77777777',7), ('8888','88888888',8), ('9999','99999999',9), ('0000','00000000',10);
INSERT INTO comment(content, board_id, writer_id) VALUE ('111',1,1), ('222',1,2), ('333',1,3), ('444',1,4), ('555',1,5), ('666',1,6), ('777',1,7), ('888',1,8), ('999',1,9), ('000',1,10);
INSERT INTO board_bookmark(board_id, user_id) VALUE (1,1), (2,1), (3,1), (4,1), (5,1), (1,2), (1,3), (1,4), (1,5);
INSERT INTO comment_bookmark(comment_id, user_id) VALUE (1,1), (2,1), (3,1), (1,2), (1,3), (1,4), (2,4), (3,4), (1,5), (2,7), (3,7);

-- 1
SELECT *
FROM user
WHERE id = 2;

-- 2
SELECT  T.id,
	T.title
FROM    team T,	member M, user U
WHERE   1 = 1
AND     M.team_id = T.id
AND     U.id = M.user_id
AND     M.user_id = 1;

-- 3_1
SELECT  T.id		AS id,
	T.title		AS title,
	U.nickname	AS member
FROM    team T
JOIN    member M	ON T.id = M.team_id
JOIN    user U		ON U.id = M.user_id
WHERE   T.id    	IN (	SELECT  team_id
				FROM    member
				WHERE   user_id = 1 );

-- 3_2
SELECT  T.id		AS id,
	T.title		AS title,
	U.nickname	AS member
FROM    user U, team T, member M
WHERE   1 = 1
AND     M.user_id = 1
AND     M.team_id = T.id
AND     U.id = (	SELECT  user_id
			FROM    member
			WHERE   team_id = T.id );

-- 4
SELECT  B.id,
	B.title,
	B.content,
	U.nickname	AS  author
FROM    board B
JOIN    user U		ON  U.id = B.author_id
WHERE   B.author_id = 1;

-- 5
SELECT  B.id,
	B.title,
	B.content,
	C.content	AS comment,
	U.nickname	AS writer
FROM    board B
JOIN    comment C	ON B.id = C.board_id
JOIN    user U		ON U.id = C.writer_id
WHERE   C.writer_id = 3;

-- 6
SELECT  B.id,
	B.title,
	U.nickname	AS  author
FROM    board B
JOIN    user U		ON U.id = B.author_id
WHERE   B.id		IN ( 	SELECT  board_id
				FROM    board_bookmark
				WHERE   user_id = 9 );

-- 7
  SELECT  B.id,
          B.title,
          C.content     AS comment,
          U.nickname    AS writer
  FROM    board B
  JOIN    comment C     ON B.id = C.board_id
  JOIN    user U        ON U.id = C.writer_id
  WHERE   C.id		IN  ( 	SELECT  comment_id
	                        FROM    comment_bookmark
	                        WHERE   user_id = 4 )





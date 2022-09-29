
-- #### 멤버 테이블 #####
DROP TABLE scoop_member;
CREATE TABLE scoop_member (
      email	varchar2(320)   primary key NOT NULL,
      wsid	number		    NOT NULL,
      password varchar2(100) ,                          -- JS 유효성으로 체크
      name	varchar2(50)	NOT NULL,                   -- 폼 회원가입일 경우 무조건 받아야함
      picture VARCHAR2(1000) ,                          -- 구글 프로필 사진 (활용 여부는 미정)
      udept	varchar2(50)	,
      role	varchar2(30)
);

----------------------------------------------------------------------------------------------------------
-- #### 내작업 테이블 #####
Drop table scoop_mytask;
CREATE TABLE scoop_mytask (
        tnum	        NUMBER		        primary key ,
        wsid	        number
            references scoop_workspace(wsid) not null ,
        pnum            number
            references scoop_project(pnum)  ,
        tname	        VARCHAR2(300)		NOT NULL,
        tcharge	        VARCHAR2(50)		NOT NULL,
        tstartperiod	DATE,
        tendperiod	    DATE,
        texplain	    VARCHAR2(2000),
        tparticipant	VARCHAR2(200),
        tpublic	        NUMBER	            DEFAULT 0,                          -- 0 비공개 or 1 공개
        tfinish	        NUMBER	            DEFAULT 0,                          -- 0 미완료 or 1 완료
        tcreator	    VARCHAR2(50)		NOT NULL,                           -- 생성자
        regidate        DATE                default sysdate  not null,
        tsession	    number(1)           default '0'                            -- 0 오늘 1 다음주 2 나중에
            check ( tsession in ( '0', '1', '2' ) )
);

CREATE SEQUENCE scoop_myTask_seq;

----------------------------------------------------------------------------------------------------------
-- #### 워크스페이스 테이블 #####
DROP TABLE scoop_workspace;
CREATE TABLE scoop_workspace (
       wsid	    NUMBER	            primary key ,
       wsname	varchar2(50)		NOT NULL,
       wsowner	varchar2(1000)		NOT NULL,
       lately   date    default sysdate
);

create sequence scoop_workspace_seq;

insert into scoop_workspace values (0, '융', '차슈', default);

----------------------------------------------------------------------------------------------------------
-- #### 프로젝트 테이블 #####
drop table scoop_project;
create table scoop_project(
      pnum number(38) primary key, -- 프로젝트 넘버
      uemail varchar2(3200), -- 멤버 아이디 ,멤버 테이블 참조
      wsid number(38) not null, -- 워크스페이스 아이디 , 워크스페이스 아이디 참조
      key number(38) , -- 목표 번호, 목표 참조
      pnotice varchar2(50) , -- 공지사항 타이틀
      ptext varchar2(500) , -- 공지사항 내용
      pname varchar2(50) not null, -- 프로젝트 이름
      powner varchar2(30) not null -- 프로젝트 오너
--       pmember varchar2(1000) -- 프로젝트 참여자
);

create sequence scoop_project_seq;

insert into scoop_project
values (1, 'hah1236.k@gmail.com,hah1236@hotmail.co.jp,hah1236.j@gmail.com,hah1236@naver.com', 1, null, null, null, 'hello1', '차슈');

insert into scoop_project
values (2, 'hah1236.k@gmail.com,hah1236@hotmail.co.jp,hah1236.j@gmail.com,hah1236@naver.com', 1, null, null, null, 'hello2', '차슈');

insert into scoop_project
values (3, 'hah1236.k@gmail.com,hah1236@hotmail.co.jp,hah1236.j@gmail.com,hah1236@naver.com', 1, null, null, null, 'hello3', '차슈');


commit;


DROP TABLE PARTICIPANTS;
DROP TABLE TICKETS;
DROP TABLE EVENTS;
DROP TABLE USERS;
DROP SEQUENCE "EVENTZONE"."EVENTS_SEQ";
DROP SEQUENCE "EVENTZONE"."PARTICIPANTS_SEQ1";
DROP SEQUENCE "EVENTZONE"."TICKETS_SEQ1";

--------------------------------------------------------
--  File created - niedziela-maj-31-2015   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Sequence DEMO_CUST_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "EVENTZONE"."DEMO_CUST_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 21 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence DEMO_ORDER_ITEMS_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "EVENTZONE"."DEMO_ORDER_ITEMS_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 61 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence DEMO_ORD_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "EVENTZONE"."DEMO_ORD_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 11 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence DEMO_PROD_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "EVENTZONE"."DEMO_PROD_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 21 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence DEMO_USERS_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "EVENTZONE"."DEMO_USERS_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 21 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence EVENTS_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "EVENTZONE"."EVENTS_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 40 ORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence PARTICIPANTS_SEQ1
--------------------------------------------------------

   CREATE SEQUENCE  "EVENTZONE"."PARTICIPANTS_SEQ1"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 40 ORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence TICKETS_SEQ1
--------------------------------------------------------

   CREATE SEQUENCE  "EVENTZONE"."TICKETS_SEQ1"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 40 ORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Table EVENTS
--------------------------------------------------------

  CREATE TABLE "EVENTZONE"."EVENTS" 
   (	"ID" NUMBER, 
	"NAME" VARCHAR2(50 BYTE), 
	"ORGANIZER" VARCHAR2(20 BYTE), 
	"PLACE" VARCHAR2(100 BYTE), 
	"DATEOFEVENT" VARCHAR2(10 BYTE), 
	"DATEOFCREATION" VARCHAR2(10 BYTE), 
	"DESCRIPTION" VARCHAR2(1000 BYTE), 
	"PICTURE" VARCHAR2(200 BYTE), 
	"SUBTITLE" VARCHAR2(60 BYTE), 
	"BACKGROUNDFILE" VARCHAR2(200 BYTE), 
	"TIMEOFEVENT" VARCHAR2(20 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table PARTICIPANTS
--------------------------------------------------------

  CREATE TABLE "EVENTZONE"."PARTICIPANTS" 
   (	"EVENTID" NUMBER, 
	"PERSONID" VARCHAR2(20 BYTE), 
	"IFPAID" NUMBER, 
	"TICKETID" NUMBER, 
	"ID" NUMBER
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table TICKETS
--------------------------------------------------------

  CREATE TABLE "EVENTZONE"."TICKETS" 
   (	"EVENTID" NUMBER, 
	"QUANTITY" NUMBER, 
	"COST" NUMBER, 
	"ID" NUMBER
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table USERS
--------------------------------------------------------

  CREATE TABLE "EVENTZONE"."USERS" 
   (	"LOGIN" VARCHAR2(20 BYTE), 
	"PASSWORD" VARCHAR2(20 BYTE), 
	"NAME" VARCHAR2(20 BYTE), 
	"SURNAME" VARCHAR2(40 BYTE), 
	"EMAIL" VARCHAR2(40 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index EVENTS_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "EVENTZONE"."EVENTS_PK" ON "EVENTZONE"."EVENTS" ("ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index USERS_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "EVENTZONE"."USERS_PK" ON "EVENTZONE"."USERS" ("LOGIN") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index TICKETS_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "EVENTZONE"."TICKETS_PK" ON "EVENTZONE"."TICKETS" ("ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index PARTICIPANTS_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "EVENTZONE"."PARTICIPANTS_PK" ON "EVENTZONE"."PARTICIPANTS" ("ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  Constraints for Table TICKETS
--------------------------------------------------------

  ALTER TABLE "EVENTZONE"."TICKETS" ADD CONSTRAINT "TICKETS_PK" PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "EVENTZONE"."TICKETS" MODIFY ("EVENTID" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table PARTICIPANTS
--------------------------------------------------------

  ALTER TABLE "EVENTZONE"."PARTICIPANTS" ADD CONSTRAINT "PARTICIPANTS_PK" PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "EVENTZONE"."PARTICIPANTS" MODIFY ("TICKETID" NOT NULL ENABLE);
  ALTER TABLE "EVENTZONE"."PARTICIPANTS" MODIFY ("IFPAID" NOT NULL ENABLE);
  ALTER TABLE "EVENTZONE"."PARTICIPANTS" MODIFY ("PERSONID" NOT NULL ENABLE);
  ALTER TABLE "EVENTZONE"."PARTICIPANTS" MODIFY ("EVENTID" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table EVENTS
--------------------------------------------------------

  ALTER TABLE "EVENTZONE"."EVENTS" ADD CONSTRAINT "EVENTS_PK" PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "EVENTZONE"."EVENTS" MODIFY ("DATEOFCREATION" NOT NULL ENABLE);
  ALTER TABLE "EVENTZONE"."EVENTS" MODIFY ("ORGANIZER" NOT NULL ENABLE);
  ALTER TABLE "EVENTZONE"."EVENTS" MODIFY ("NAME" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table USERS
--------------------------------------------------------

  ALTER TABLE "EVENTZONE"."USERS" ADD CONSTRAINT "USERS_PK" PRIMARY KEY ("LOGIN")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "EVENTZONE"."USERS" MODIFY ("PASSWORD" NOT NULL ENABLE);
  ALTER TABLE "EVENTZONE"."USERS" MODIFY ("LOGIN" NOT NULL ENABLE);
--------------------------------------------------------
--  Ref Constraints for Table EVENTS
--------------------------------------------------------

  ALTER TABLE "EVENTZONE"."EVENTS" ADD CONSTRAINT "EVENTS_FK1" FOREIGN KEY ("ORGANIZER")
	  REFERENCES "EVENTZONE"."USERS" ("LOGIN") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table PARTICIPANTS
--------------------------------------------------------

  ALTER TABLE "EVENTZONE"."PARTICIPANTS" ADD CONSTRAINT "PARTICIPANTS_FK1" FOREIGN KEY ("EVENTID")
	  REFERENCES "EVENTZONE"."EVENTS" ("ID") ENABLE;
  ALTER TABLE "EVENTZONE"."PARTICIPANTS" ADD CONSTRAINT "PARTICIPANTS_FK2" FOREIGN KEY ("TICKETID")
	  REFERENCES "EVENTZONE"."TICKETS" ("ID") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table TICKETS
--------------------------------------------------------

  ALTER TABLE "EVENTZONE"."TICKETS" ADD CONSTRAINT "TICKETS_FK1" FOREIGN KEY ("EVENTID")
	  REFERENCES "EVENTZONE"."EVENTS" ("ID") ENABLE;
--------------------------------------------------------
--  DDL for Trigger EVENTS_TRG1
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "EVENTZONE"."EVENTS_TRG1" 
BEFORE INSERT ON EVENTS 
FOR EACH ROW 
BEGIN
  <<COLUMN_SEQUENCES>>
  BEGIN
    IF INSERTING AND :NEW.ID IS NULL THEN
      SELECT EVENTS_SEQ.NEXTVAL INTO :NEW.ID FROM SYS.DUAL;
    END IF;
  END COLUMN_SEQUENCES;
END;
/
ALTER TRIGGER "EVENTZONE"."EVENTS_TRG1" ENABLE;
--------------------------------------------------------
--  DDL for Trigger PARTICIPANTS_TRG
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "EVENTZONE"."PARTICIPANTS_TRG" 
BEFORE INSERT ON PARTICIPANTS 
FOR EACH ROW 
BEGIN
  <<COLUMN_SEQUENCES>>
  BEGIN
    IF INSERTING AND :NEW.ID IS NULL THEN
      SELECT PARTICIPANTS_SEQ1.NEXTVAL INTO :NEW.ID FROM SYS.DUAL;
    END IF;
  END COLUMN_SEQUENCES;
END;
/
ALTER TRIGGER "EVENTZONE"."PARTICIPANTS_TRG" ENABLE;
--------------------------------------------------------
--  DDL for Trigger TICKETS_TRG
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "EVENTZONE"."TICKETS_TRG" 
BEFORE INSERT ON TICKETS 
FOR EACH ROW 
BEGIN
  <<COLUMN_SEQUENCES>>
  BEGIN
    IF INSERTING AND :NEW.ID IS NULL THEN
      SELECT TICKETS_SEQ1.NEXTVAL INTO :NEW.ID FROM SYS.DUAL;
    END IF;
  END COLUMN_SEQUENCES;
END;
/
ALTER TRIGGER "EVENTZONE"."TICKETS_TRG" ENABLE;
--------------------------------------------------------
--  DDL for Function CUSTOM_AUTH
--------------------------------------------------------

  CREATE OR REPLACE FUNCTION "EVENTZONE"."CUSTOM_AUTH" (p_username in VARCHAR2, p_password in VARCHAR2)
return BOOLEAN
is
  l_password varchar2(4000);
  l_stored_password varchar2(4000);
  l_expires_on date;
  l_count number;
begin
-- First, check to see if the user is in the user table
select count(*) into l_count from demo_users where user_name = p_username;
if l_count > 0 then
  -- First, we fetch the stored hashed password  date
  select password, expires_on into l_stored_password, l_expires_on
   from demo_users where user_name = p_username;

  -- Next, we check to see if the user's account is expired
  -- If it is, return FALSE
  if l_expires_on > sysdate or l_expires_on is null then

    -- If the account is not expired, we have to apply the custom hash
    -- function to the password
    l_password := custom_hash(p_username, p_password);

    -- Finally, we compare them to see if they are the same and return
    -- either TRUE or FALSE
    if l_password = l_stored_password then
      return true;
    else
      return false;
    end if;
  else
    return false;
  end if;
else
  -- The username provided is not in the DEMO_USERS table
  return false;
end if;
end;

/
--------------------------------------------------------
--  DDL for Function CUSTOM_HASH
--------------------------------------------------------

  CREATE OR REPLACE FUNCTION "EVENTZONE"."CUSTOM_HASH" (p_username in varchar2, p_password in varchar2)
return varchar2
is
  l_password varchar2(4000);
  l_salt varchar2(4000) := 'EV8E0NPS4GCDH4Y3OL9374NA5E3EBT';
begin

-- This function should be wrapped, as the hash algorhythm is exposed here.
-- You can change the value of l_salt or the method of which to call the
-- DBMS_OBFUSCATOIN toolkit, but you much reset all of your passwords
-- if you choose to do this.

l_password := utl_raw.cast_to_raw(dbms_obfuscation_toolkit.md5
  (input_string => p_password || substr(l_salt,10,13) || p_username ||
    substr(l_salt, 4,10)));
return l_password;
end;

/

--------------------------------------------------------
--  File created - niedziela-maj-31-2015   
--------------------------------------------------------
REM INSERTING into EVENTZONE.USERS
SET DEFINE OFF;
Insert into EVENTZONE.USERS (LOGIN,PASSWORD,NAME,SURNAME,EMAIL) values ('zuzanna','password','name','surname','email@email');
Insert into EVENTZONE.USERS (LOGIN,PASSWORD,NAME,SURNAME,EMAIL) values ('bartek','bartek','bartek','bartek','bartek@bartek');
Insert into EVENTZONE.USERS (LOGIN,PASSWORD,NAME,SURNAME,EMAIL) values ('user','password','user','user','user@user');
REM INSERTING into EVENTZONE.EVENTS
SET DEFINE OFF;
Insert into EVENTZONE.EVENTS (ID,NAME,ORGANIZER,PLACE,DATEOFEVENT,DATEOFCREATION,DESCRIPTION,PICTURE,SUBTITLE,BACKGROUNDFILE,TIMEOFEVENT) values ('1','sting','zuzanna','wroclaw',to_date('15/09/11','RR/MM/DD'),to_date('15/04/08','RR/MM/DD'),'it will be awesome',null,null,null,null);
Insert into EVENTZONE.EVENTS (ID,NAME,ORGANIZER,PLACE,DATEOFEVENT,DATEOFCREATION,DESCRIPTION,PICTURE,SUBTITLE,BACKGROUNDFILE,TIMEOFEVENT) values ('2','juwenalia','bartek','krakow',to_date('15/05/14','RR/MM/DD'),to_date('15/04/23','RR/MM/DD'),'have fun',null,null,null,null);
Insert into EVENTZONE.EVENTS (ID,NAME,ORGANIZER,PLACE,DATEOFEVENT,DATEOFCREATION,DESCRIPTION,PICTURE,SUBTITLE,BACKGROUNDFILE,TIMEOFEVENT) values ('3','festiwal','user','warsaw',to_date('15/04/10','RR/MM/DD'),to_date('15/04/01','RR/MM/DD'),'sss',null,null,null,null);
REM INSERTING into EVENTZONE.TICKETS
SET DEFINE OFF;
Insert into EVENTZONE.TICKETS (EVENTID,QUANTITY,COST,ID) values ('1','20','150','5');
Insert into EVENTZONE.TICKETS (EVENTID,QUANTITY,COST,ID) values ('2','10','0','6');
Insert into EVENTZONE.TICKETS (EVENTID,QUANTITY,COST,ID) values ('1','20','150','7');
Insert into EVENTZONE.TICKETS (EVENTID,QUANTITY,COST,ID) values ('2','10','0','8');
REM INSERTING into EVENTZONE.PARTICIPANTS
SET DEFINE OFF;
Insert into EVENTZONE.PARTICIPANTS (EVENTID,PERSONID,IFPAID,TICKETID,ID) values ('1','zuzanna','1','5','10');
Insert into EVENTZONE.PARTICIPANTS (EVENTID,PERSONID,IFPAID,TICKETID,ID) values ('1','bartek','1','5','11');
Insert into EVENTZONE.PARTICIPANTS (EVENTID,PERSONID,IFPAID,TICKETID,ID) values ('2','zuzanna','1','6','12');



insert into Member ( COMPANY , EMPLOYEE_NUMBER , LOGIN_ID , LOGIN_PASSWORD  , MEMBER_STATUS , NAME , ROLE_TYPE ) values ('SK주식회사C&C','09297','seoyeon2924','1234','ACTIVE','안서연','USER');
insert into Member ( COMPANY , EMPLOYEE_NUMBER , LOGIN_ID , LOGIN_PASSWORD  , MEMBER_STATUS , NAME , ROLE_TYPE ) values ('SK텔레콤','06778','mia1234','1234','LOCK','신윤아','ADMIN');
insert into Member ( COMPANY , EMPLOYEE_NUMBER , LOGIN_ID , LOGIN_PASSWORD  , MEMBER_STATUS , NAME , ROLE_TYPE ) values ('SK건설','07787','moon123','1234','ACTIVE','박세진','USER');
insert into Member ( COMPANY , EMPLOYEE_NUMBER , LOGIN_ID , LOGIN_PASSWORD  , MEMBER_STATUS , NAME , ROLE_TYPE ) values ('SKC','099942','sejin1234','1234','LOCK','유식','USER');
insert into Member ( COMPANY , EMPLOYEE_NUMBER , LOGIN_ID , LOGIN_PASSWORD  , MEMBER_STATUS , NAME , ROLE_TYPE ) values ('SK주식회사C&C','06632','yoona','1234','ACTIVE','오지웅','USER');
insert into Member ( COMPANY , EMPLOYEE_NUMBER , LOGIN_ID , LOGIN_PASSWORD  , MEMBER_STATUS , NAME , ROLE_TYPE ) values ('SK하이닉','01121','elena','1234','ACTIVE','정의헌','USER');

insert into Member ( COMPANY , EMPLOYEE_NUMBER , LOGIN_ID , LOGIN_PASSWORD  , MEMBER_STATUS , NAME , ROLE_TYPE ) values ('SK홀딩스','11111','admin01','1234','ACTIVE','관리자1','ADMIN');
insert into Member ( COMPANY , EMPLOYEE_NUMBER , LOGIN_ID , LOGIN_PASSWORD  , MEMBER_STATUS , NAME , ROLE_TYPE ) values ('SK홀딩스','22222','admin02','1234','ACTIVE','관리자2','ADMIN');

insert into BOOK_HISTORY ( booker_name ,book_date, booking_parking_lot_id ,booking_parking_lot_name  , book_status , book_car_no , booker_id ) values ('안서연',sysdate-1,1,'SK서린빌딩','RESERVED','30서8749',1);
insert into BOOK_HISTORY ( booker_name ,book_date, booking_parking_lot_id ,booking_parking_lot_name  , book_status , book_car_no , booker_id ) values ('오지웅',sysdate-13,3,'SK정자사옥','CANCELED','31서8749',2);
insert into BOOK_HISTORY ( booker_name ,book_date, booking_parking_lot_id ,booking_parking_lot_name  , book_status , book_car_no , booker_id ) values ('안서연',sysdate-11,2,'SK판교캠퍼스','CANCELED','30서8749',3);
insert into BOOK_HISTORY ( booker_name ,book_date, booking_parking_lot_id ,booking_parking_lot_name  , book_status , book_car_no , booker_id ) values ('오지웅',sysdate-13,3,'SK정자사옥','CANCELED','34서8749',4);
insert into BOOK_HISTORY ( booker_name ,book_date, booking_parking_lot_id ,booking_parking_lot_name  , book_status , book_car_no , booker_id ) values ('박세진',sysdate,1,'SK서린빌딩','RESERVED','00서1234',5);
insert into BOOK_HISTORY ( booker_name ,book_date, booking_parking_lot_id ,booking_parking_lot_name  , book_status , book_car_no , booker_id ) values ('박세진',sysdate,1,'SK서린빌딩','RESERVED','00서1234',6);
insert into BOOK_HISTORY ( booker_name ,book_date, booking_parking_lot_id ,booking_parking_lot_name  , book_status , book_car_no , booker_id ) values ('오지웅',sysdate,1,'SK서린빌딩','CANCELED','11하1234',7);
insert into BOOK_HISTORY ( booker_name ,book_date, booking_parking_lot_id ,booking_parking_lot_name  , book_status , book_car_no , booker_id ) values ('박세진',sysdate,1,'SK서린빌딩','CANCELED','11하1234',8);
insert into BOOK_HISTORY ( booker_name ,book_date, booking_parking_lot_id ,booking_parking_lot_name  , book_status , book_car_no , booker_id ) values ('이혜진',sysdate,1,'SK서린빌딩','RESERVED','35서8749',9);
insert into BOOK_HISTORY ( booker_name ,book_date, booking_parking_lot_id ,booking_parking_lot_name  , book_status , book_car_no , booker_id ) values ('안서연',sysdate-12,3,'SK정자사옥','RESERVED','123아1234',10);
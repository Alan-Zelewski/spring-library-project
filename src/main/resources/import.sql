insert into `Book` (`title`, `author`, `isbn`, `description`) values ('book1','author1','isbn1','book1description');
insert into `book_availability` (`book_id`,`total_number_of_books`,`books_borrowed`,`books_available`) values (1,10,2,8);
insert into `Book` (`title`, `author`, `isbn`, `description`) values ('diffbook','diffauthor1','isbn2','diffbook1description');
insert into `book_availability` (`book_id`,`total_number_of_books`,`books_borrowed`,`books_available`) values (2,10,2,8);
insert into `Book` (`title`, `author`, `isbn`, `description`) values ('strangebook1','strangeauthor1','isbn3','strangebook1description');
insert into `book_availability` (`book_id`,`total_number_of_books`,`books_borrowed`,`books_available`) values (3,10,2,8);
INSERT INTO `user_role` (`role`) VALUES ('USER');
INSERT INTO `user_role` (`role`) VALUES ('ADMIN');
INSERT INTO `users` (`username`, `password`) VALUES ('tester', '$2a$10$HTTwWcEvb.aE8YXr7PUkGurs7Aleed2mzmMXTBhDvuctlY9oImq0C');
INSERT INTO `users` (`username`, `password`) VALUES ('user', '$2a$10$HTTwWcEvb.aE8YXr7PUkGurs7Aleed2mzmMXTBhDvuctlY9oImq0C');
INSERT INTO `user_user_role` VALUES (2, 1);
INSERT INTO `user_user_role` VALUES (1, 1);
INSERT INTO `user_user_role` VALUES (1, 2);
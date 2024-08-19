INSERT INTO users (name, email, mobileNo, status) VALUES
                                                      ('John', 'john@example.com', '1234567890', 'ACTIVE'),
                                                      ('Jane', 'jane@example.com', '0987654321', 'ACTIVE'),
                                                      ('Sourav', 'sourav@example.com', '1122334455', 'INACTIVE'),
                                                      ('Venu', 'venu@example.com', '2233445566', 'ACTIVE'),
                                                      ('Magdalin', 'magdalin@example.com', '3344556677', 'INACTIVE');


INSERT INTO tasks (name, description, assignee, creator, status) VALUES
                                                                     ('Task 1', 'This is the first task description', 'John', 'Jane', 'TO-DO'),
                                                                     ('Task 2', 'This is the second task description', 'Jane', 'John', 'IN PROGRESS'),
                                                                     ('Task 3', 'This is the third task description', 'Sourav', 'Venu', 'DONE'),
                                                                     ('Task 4', 'This is the fourth task description', 'Venu', 'Magdalin', 'READY FOR QA'),
                                                                     ('Task 5', 'This is the fifth task description', 'Sourav', 'Magdalin', 'TO-DO');

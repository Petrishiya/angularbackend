INSERT INTO tasks (name, description, assignee, creator, status) VALUES
    ('Task 1', 'This is the first task.', 'Magdalin', 'Sourav', 'To-Do');

INSERT INTO tasks (name, description, assignee, creator, status) VALUES
    ('Task 2', 'This is the second task.', 'Sourav', 'Magdalin', 'In Progress');

INSERT INTO tasks (name, description, assignee, creator, status) VALUES
    ('Task 3', 'This is the third task.', 'Venu', 'Sourav', 'Ready for QA');

INSERT INTO tasks (name, description, assignee, creator, status) VALUES
    ('Task 4', 'This is the fourth task.', 'Magdalin', 'Venu', 'Done');


INSERT INTO users (name, email, mobile_no) VALUES ('Magdalin', 'magdalin@example.com', '1234567890');
INSERT INTO users (name, email, mobile_no) VALUES ('Sourav', 'sourav@example.com', '0987654321');
INSERT INTO users (name, email, mobile_no) VALUES ('Venu', 'venu@example.com', '1122334455');



select * from tasks;
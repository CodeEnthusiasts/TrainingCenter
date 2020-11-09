---- ROLES
--INSERT INTO roles(id, name) VALUES
--      (1, 'ROLE_USER'),
--      (2, 'ROLE_ADMIN'),
--      (3, 'ROLE_MODERATOR');

---- IMAGES
--INSERT INTO images(id, file_url) VALUES
--      (1,'https://res.cloudinary.com/dr6odau4r/image/upload/v1604332186/gxiql7mxiykikz1f5rej.jpg'),
--      (2,'https://res.cloudinary.com/dr6odau4r/image/upload/v1604387417/qbu1rpql12lszfyey15u.jpg'),
--      (3,'https://res.cloudinary.com/dr6odau4r/image/upload/v1594185873/sample.jpg');

---- PERSONAL RECORDS (ENTITY NOT FINISHED YET)
--INSERT INTO personal_records(id) VALUES (1), (2), (3);

---- USER
--INSERT INTO users(id, email, password, age, body_weight_unit, height, height_unit, sex, weight, username, image_id, personal_records_id) values
--      (1, 'user@gmail.com', '$2a$10$j3y4WrBpcBLAfir0W5C/6eUEfHwwV9LCN27Eg7libt7HURTirh4O.', 20, 'KILOGRAMS', 183, 'METERS', 'MALE', 93.0, 'usertest', 1, 1);

---- TRAINING PLANS
--INSERT INTO training_plans(id, description, difficulty, end_date, name, number_of_executed_trainings, number_of_planned_trainings, start_date, user_id) VALUES
--      (1, 'Strength training plan description', 'MEDIUM', '2020-09-01', 'Strength v1', 8, 15, '2020-07-01', 1),
--      (2, 'Muscle mass training plan description', 'HARD', '2020-02-01', 'Mass v1', 20, 20, '2020-06-01', 1),
--      (3, 'Power training plan description', 'EASY', '2020-11-02', 'Power v1', 0, 9, '2020-12-01', 1);

---- TRAINING SESSIONS
--INSERT INTO training_sessions(id, date, day_of_week, difficulty, end_time, name, notes, start_time, training_duration) VALUES
--      (1, '2020-09-02', 'MONDAY', 'HARD', '17:00', 'First strength training', 'Heavy squat and knee pain', '14:30', '2:30'),
--      (2, '2020-09-04', 'WEDNESDAY', 'EASY', '18:00', 'Second strength training', 'Light squat and easy bench ', '17:00', '1:00'),
--      (3, '2020-09-06', 'FRIDAY', 'MEDIUM', '19:00', 'Third strength training', 'Medium deadlift and accessories', '17:30', '1:30');

---- PRIORITIES
--INSERT INTO priorities(id, details, name) VALUES
--        (1, 'Lower chest is the weakest part - need to work on it', 'Lower chest growth'),
--        (2, 'Quad is very irresistible to higher reps - needs to get better before strength phase', 'Develop quad endurance'),
--        (3, 'Right scapulae is unstable and destroy whole movement trajectory', 'Improve bench stability'),
--        (4, 'In order to beat 200kg barrier, need to be on 180 in strength phase at least', 'Gain 10kg + in squat'),
--        (5, 'This will improve power generation ability for sure', 'Beat the record in clean and jerk - + 132.5kg'),
--        (6, 'Rest them to heal tendinitis', 'Heal injured elbow');

---- PRIORITIES IN TRAINING PLANS
--INSERT INTO training_plans_priorities(training_plans_id, priorities_id) VALUES
--        (1,1), (1,2), (2,3), (2,4), (3,5), (3,6);

---- SESSIONS IN TRAINING PLANS
--INSERT INTO training_plans_training_sessions(training_plans_id, training_sessions_id) VALUES
--      (1,1),
--      (1,2),
--      (1,3);


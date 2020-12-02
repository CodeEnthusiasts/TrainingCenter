-- ROLES
INSERT INTO role(id, name) VALUES
      (1, 'ROLE_USER'),
      (2, 'ROLE_ADMIN'),
      (3, 'ROLE_MODERATOR');

-- IMAGES
INSERT INTO image(id, file_url) VALUES
      (1,'https://res.cloudinary.com/dr6odau4r/image/upload/v1604332186/gxiql7mxiykikz1f5rej.jpg'),
      (2,'https://res.cloudinary.com/dr6odau4r/image/upload/v1604387417/qbu1rpql12lszfyey15u.jpg'),
      (3,'https://res.cloudinary.com/dr6odau4r/image/upload/v1594185873/sample.jpg'),
      (4,'https://squatuniversity.com/wp-content/uploads/2016/02/859835_577024942352334_10881976_o.jpg'),
      (5,'https://barbend.com/wp-content/uploads/2019/04/Bench-Press-Plateau-1024x538.jpg'),
      (6,'https://barbend.com/wp-content/uploads/2016/11/floating-clean-pull.png'),
      (7,'https://www.yogajournal.com/.image/t_share/MTQ2ODMwNzA2OTE4NTY1NjA5/juneanatomy.jpg'),
      (8,'https://www.performancehealth.com/media/wysiwyg/blog/articles/Hamstring-quadriceps_3.PNG'),
      (9,'https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcQvd9IRdgVMu8sf0J0E_sQG4jYcvuZLFludzw&usqp=CAU');

-- USER
INSERT INTO users(id, email, password, username) values
      (1, 'user@gmail.com', '$2a$10$j3y4WrBpcBLAfir0W5C/6eUEfHwwV9LCN27Eg7libt7HURTirh4O.', 'usertest'),
      (2, 'trainingtest@gmail.com', '$2a$10$KopU7tPDq.bZDxTIAWSdke1krzCxxoKq03kHHyhI/f7Sxfb/I.S36', 'trainingtest');

-- IMAGE FOR USER
UPDATE image SET user_id = 1 WHERE id = 1;

-- PERSONAL RECORDS
INSERT INTO personal_records(id, user_id) VALUES (1,1);

--USER DETAILS
INSERT INTO user_details(id, age, body_weight_unit, height, height_unit, sex, weight, user_id) values
      (1, 20, 'KILOGRAMS', 183, 'METERS', 'MALE', 93.0, 1);

-- ROLES FOR USERS
INSERT INTO users_roles(users_id, roles_id) VALUES (1,2), (2,1);

-- TRAINING PLANS
INSERT INTO training_plan(id, description, difficulty, end_date, name, number_of_executed_trainings, number_of_planned_trainings, start_date, user_id) VALUES
      (1, 'Strength training plan description', 'MEDIUM', '2020-09-01', 'Strength v1', 8, 15, '2020-07-01', 1),
      (2, 'Muscle mass training plan description', 'HARD', '2020-02-01', 'Mass v1', 20, 20, '2020-06-01', 1),
      (3, 'Power training plan description', 'EASY', '2020-11-02', 'Power v1', 0, 9, '2020-12-01', 1),
      (4, 'Clean and jerk training plan description', 'HARD', '2020-12-05', 'Power v1', 3, 20, '2020-12-30', 2),
      (5, 'Snatch training plan description', 'MEDIUM', '2021-01-005', 'Power v1', 2, 23, '2021-02-01', 2);

-- TRAINING SESSIONS
INSERT INTO training_session(id, date, day_of_week, difficulty, end_time, name, notes, start_time, training_duration, training_plan_id) VALUES
      (1, '2020-09-02', 'MONDAY', 'HARD', '17:00', 'First strength training', 'Heavy squat and knee pain', '14:30', '2:30',1),
      (2, '2020-09-04', 'WEDNESDAY', 'EASY', '18:00', 'Second strength training', 'Light squat and easy bench ', '17:00', '1:00',2),
      (3, '2020-09-06', 'FRIDAY', 'MEDIUM', '19:00', 'Third strength training', 'Medium deadlift and accessories', '17:30', '1:30',3),
      (4, '2018-09-06', 'TUESDAY', 'HARD', '19:00', 'Nth strength training', 'Clean and jerk max out and accessories', '17:00', '2:00',4),
      (5, '2021-09-06', 'THURSDAY', 'EASY', '19:00', 'Nth + 1 strength training', 'Light squats for regeneration purposes', '17:30', '1:30',5);

-- PRIORITIES
INSERT INTO priority(id, details, name, training_plan_id) VALUES
        (1, 'Lower chest is the weakest part - need to work on it', 'Lower chest growth', 1),
        (2, 'Quad is very irresistible to higher reps - needs to get better before strength phase', 'Develop quad endurance', 2),
        (3, 'Right scapulae is unstable and destroy whole movement trajectory', 'Improve bench stability', 2),
        (4, 'In order to beat 200kg barrier, need to be on 180 in strength phase at least', 'Gain 10kg + in squat', 3),
        (5, 'This will improve power generation ability for sure', 'Beat the record in clean and jerk - + 132.5kg', 5),
        (6, 'Rest them to heal tendinitis', 'Heal injured elbow', 5);

-- MOVEMENT
INSERT INTO movement(id, name) VALUES
        (1, 'Squat'),
        (2, 'Bench Press'),
        (3, 'Dead lift'),
        (4, 'Pull Up'),
        (5, 'Overhead Press'),
        (6, 'Run outdoor');

-- MUSCLES
INSERT INTO muscle(id, description, name, movement_id) VALUES
        (1, 'Biggest Human Muscle', 'Glute', 1),
        (2, 'Primary knee extensor', 'Quad', 2),
        (3, 'Sign of Arnold, big muscle in front of  ', 'Peck', 3),
        (4, 'Small, but fameous muscle', 'Biceps', 4),
        (5, 'Long, tought muscles on the back thigh', 'Hamsting', 5),
        (6, 'Very important to stabilization of whole arm', 'Shoulder', 2);

-- ADD MUSCLE_ID's TO IMAGES
UPDATE image SET muscle_id = 1 WHERE id = 7;
UPDATE image SET muscle_id = 2 WHERE id = 8;
UPDATE image SET muscle_id = 3 WHERE id = 9;

-- KEY TECHNIQUE ELEMENTS
INSERT INTO key_technique_element(id, content, movement_id) VALUES
        (1, 'Keep chest up', 1),
        (2, 'Plain foot, weight on the middle', 1),
        (3, 'Pull shoulder blades together', 2),
        (4, 'Elbow under the bar', 2),
        (5, 'Kepp air pressure in diapragma', 3),
        (6, 'Push legs to the floow', 3);

-- ADD MUSCLE_ID's TO IMAGES
UPDATE image SET movement_id = 1 WHERE id = 4;
UPDATE image SET movement_id = 2 WHERE id = 5;
UPDATE image SET movement_id = 3 WHERE id = 6;

-- STRENGTH EXERCISES
INSERT INTO strength_exercise(id, repetition_unit, reps, weight,  weight_unit, movement_id, training_session_id) VALUES
        (1, 'MOTION', 8, 100,  'KILOGRAMS', 1, 1), (2, 'MOTION', 8, 100,  'KILOGRAMS', 1, 1), (3, 'MOTION', 8, 100,  'KILOGRAMS', 1, 1),
        (4, 'MOTION', 10, 70,  'KILOGRAMS', 2, 1), (5, 'MOTION', 10, 70,  'KILOGRAMS', 2, 1), (6, 'MOTION', 10, 70,  'KILOGRAMS', 2, 1),
        (7, 'MOTION', 5, 120,  'KILOGRAMS', 3, 1), (8, 'MOTION', 5, 120,  'KILOGRAMS', 3, 1), (9, 'MOTION', 5, 120,  'KILOGRAMS', 3, 1),
        (10, 'MOTION', 8, 60,  'KILOGRAMS', 3, 4), (11, 'MOTION', 8, 60,  'KILOGRAMS', 3, 4), (12, 'MOTION', 8, 60,  'KILOGRAMS', 4, 4),
        (13, 'MOTION', 3, 75,  'KILOGRAMS', 3, 5), (14, 'MOTION', 4, 70,  'KILOGRAMS', 3, 5), (15, 'MOTION', 5, 65,  'KILOGRAMS', 4, 5);

-- STRENGTH EXERCISE DETAILS
INSERT INTO strength_exercise_details(id, lowering, holding_down, raising, holding_up, note, reps_in_reserve, strength_exercise_id)
VALUES  (1, 2, 0, 1, 1, 'Example note 1', 3, 1), (2, 2, 0, 1, 1, 'Example note 2', 3, 2), (3, 2, 0, 1, 1, 'Example note ', 3, 3),
        (4, 2, 0, 1, 1, 'Example note 1', 3, 4), (5, 2, 0, 1, 1, 'Example note 2', 3, 5), (6, 2, 0, 1, 1, 'Example note ', 3, 6),
        (7, 2, 0, 1, 1, 'Example note 1', 3, 7), (8, 2, 0, 1, 1, 'Example note 2', 3, 8), (9, 2, 0, 1, 1, 'Example note ', 3, 9),
        (10, 2, 0, 1, 1, 'Example note 1', 3, 10), (11, 2, 0, 1, 1, 'Example note 2', 3, 11), (12, 2, 0, 1, 1, 'Example note ', 3, 12);

--ENDURANCE EXERCISES
INSERT INTO endurance_exercise(id, distance, distance_unit, heart_rate, vo2max_percentage, duration, time_unit, movement_id, training_session_id) VALUES
        (1, 2.0, 'KILOMETERS', 130, 70, '00:15', 'MINUTES', 6, 2),
        (2, 2.0, 'KILOMETERS', 150, 80, '00:10', 'MINUTES', 6, 2),
        (3, 1.0, 'KILOMETERS', 170, 90, '00:05', 'MINUTES', 6, 2);

-- STRENGTH RECORDS
INSERT INTO strength_record(id, movement_name, reps, repetition_unit, date, weight, weight_unit, personal_records_id) VALUES
        (1, 'Squat', 1, 'MOTION', '2020-09-09', 190, 'KILOGRAMS', 1),
        (2, 'Squat', 5, 'MOTION', '2020-07-09', 140, 'KILOGRAMS', 1),
        (3, 'Bench press', 1, 'MOTION', '2020-05-09', 150, 'KILOGRAMS', 1);


-- ENDURANCE RECORDS
INSERT INTO endurance_record(id, distance, distance_unit, date, movement_name, duration, time_unit, personal_records_id) VALUES
        (1, 1.0, 'KILOMETERS', '2020-05-09','Running',  '00:03','HOURS', 1),
        (2, 5.0, 'KILOMETERS', '2020-07-09','Running',  '00:28','HOURS', 1),
        (3, 100, 'METERS', '2021-05-09','Swimming',  '00:10','HOURS', 1);


-- CUSTOM RECORDS
INSERT INTO custom_record(id, description, date, value, personal_records_id) VALUES
        (1, 'Vertical jump', '2020-10-10', 0.8, 1),
        (2, 'Drive 100km on bike', '2020-03-03', 100, 1);







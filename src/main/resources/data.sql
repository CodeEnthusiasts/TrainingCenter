INSERT INTO roles(id, name) VALUES
      (1, 'ROLE_USER'),
      (2, 'ROLE_ADMIN'),
      (3, 'ROLE_MODERATOR');

INSERT INTO images(id, file_url) VALUES
      (1,'https://res.cloudinary.com/dr6odau4r/image/upload/v1604332186/gxiql7mxiykikz1f5rej.jpg'),
      (2,'https://res.cloudinary.com/dr6odau4r/image/upload/v1604387417/qbu1rpql12lszfyey15u.jpg'),
      (3,'https://res.cloudinary.com/dr6odau4r/image/upload/v1594185873/sample.jpg'),
      (4,'https://squatuniversity.com/wp-content/uploads/2016/02/859835_577024942352334_10881976_o.jpg'),
      (5,'https://barbend.com/wp-content/uploads/2019/04/Bench-Press-Plateau-1024x538.jpg'),
      (6,'https://barbend.com/wp-content/uploads/2016/11/floating-clean-pull.png'),
        (7,'https://www.yogajournal.com/.image/t_share/MTQ2ODMwNzA2OTE4NTY1NjA5/juneanatomy.jpg'),
        (8,'https://www.performancehealth.com/media/wysiwyg/blog/articles/Hamstring-quadriceps_3.PNG'),
        (9,'https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcQvd9IRdgVMu8sf0J0E_sQG4jYcvuZLFludzw&usqp=CAU');

INSERT INTO personal_records(id) VALUES (1), (2), (3);

INSERT INTO users(id, email, password, age, body_weight_unit, height, height_unit, sex, weight, username, image_id, personal_records_id) values
      (1, 'user@gmail.com', '$2a$10$j3y4WrBpcBLAfir0W5C/6eUEfHwwV9LCN27Eg7libt7HURTirh4O.', 20, 'KILOGRAMS', 183, 'METERS', 'MALE', 93.0, 'usertest', 1, 1);

INSERT INTO users_roles(users_id, roles_id) VALUES (1,1);

INSERT INTO training_plans(id, description, difficulty, end_date, name, number_of_executed_trainings, number_of_planned_trainings, start_date, user_id) VALUES
      (1, 'Strength training plan description', 'MEDIUM', '2020-09-01', 'Strength v1', 8, 15, '2020-07-01', 1),
      (2, 'Muscle mass training plan description', 'HARD', '2020-02-01', 'Mass v1', 20, 20, '2020-06-01', 1),
      (3, 'Power training plan description', 'EASY', '2020-11-02', 'Power v1', 0, 9, '2020-12-01', 1);

INSERT INTO training_sessions(id, date, day_of_week, difficulty, end_time, name, notes, start_time, training_duration) VALUES
      (1, '2020-09-02', 'MONDAY', 'HARD', '17:00', 'First strength training', 'Heavy squat and knee pain', '14:30', '2:30'),
      (2, '2020-09-04', 'WEDNESDAY', 'EASY', '18:00', 'Second strength training', 'Light squat and easy bench ', '17:00', '1:00'),
      (3, '2020-09-06', 'FRIDAY', 'MEDIUM', '19:00', 'Third strength training', 'Medium deadlift and accessories', '17:30', '1:30');

INSERT INTO priorities(id, details, name) VALUES
        (1, 'Lower chest is the weakest part - need to work on it', 'Lower chest growth'),
        (2, 'Quad is very irresistible to higher reps - needs to get better before strength phase', 'Develop quad endurance'),
        (3, 'Right scapulae is unstable and destroy whole movement trajectory', 'Improve bench stability'),
        (4, 'In order to beat 200kg barrier, need to be on 180 in strength phase at least', 'Gain 10kg + in squat'),
        (5, 'This will improve power generation ability for sure', 'Beat the record in clean and jerk - + 132.5kg'),
        (6, 'Rest them to heal tendinitis', 'Heal injured elbow');

INSERT INTO training_plans_priorities(training_plans_id, priorities_id) VALUES
        (1,1), (1,2), (2,3), (2,4), (3,5), (3,6);

INSERT INTO training_plans_training_sessions(training_plans_id, training_sessions_id) VALUES
      (1,1),
      (1,2),
      (1,3);

INSERT INTO exercisable(id, name) VALUES
        (1, 'Squat'),
        (2, 'Bench Press'),
        (3, 'Dead lift'),
        (4, 'Pull Up'),
        (5, 'Overhead Press'),
        (6, 'Run outdoor');

INSERT INTO movement(id) VALUES(1),(2),(3),(4),(5);

INSERT INTO muscles(id, description, name) VALUES
        (1, 'Biggest Human Muscle', 'Glute'),
        (2, 'Primary knee extensor', 'Quad'),
        (3, 'Sign of Arnold, big muscle in front of  ', 'Peck'),
        (4, 'Small, but fameous muscle', 'Biceps'),
        (5, 'Long, tought muscles on the back thigh', 'Hamsting'),
        (6, 'Very important to stabilization of whole arm', 'Shoulder');

INSERT INTO muscles_images(muscles_id, images_id) VALUES
        (1, 7), (2,8), (3,9);

INSERT INTO movement_muscles_involved(movement_id, muscles_involved_id) VALUES
        (1, 1), (2,2), (3,3), (4,4), (5,5);

INSERT INTO key_technique_elements(id, content) VALUES
        (1, 'Keep chest up'),
        (2, 'Plain foot, weight on the middle'),
        (3, 'Pull shoulder blades together'),
        (4, 'Elbow under the bar'),
        (5, 'Kepp air pressure in diapragma'),
        (6, 'Push legs to the floow');

INSERT INTO movement_key_technique_elements(movement_id, key_technique_elements_id) VALUES
        (1, 1), (1, 2), (2,3), (2,4), (3,5), (3,6);

INSERT INTO movement_images(movement_id, images_id) VALUES
        (1, 4), (2, 5), (3,6);

INSERT INTO pace(id, holding_down, holding_up, lowering, name, raising) VALUES
        (1, 0, 1, 1, 'Fast', 1),
        (2, 2, 1, 1, 'Short pause', 1),
        (3, 0, 1, 3, 'Long eccentric phase', 1),
        (4, 3, 1, 2, 'Long eccentric and pause', 1),
        (5, 2, 1, 0, 'Fast and short pause', 1);

INSERT INTO strength_exercises(id, repetition_unit, reps, reps_in_reserve, weight,  weight_unit, exercisable_id, training_session_id, pace_id) VALUES
        (1, 'MOTION', 8, 3, 100,  'KILOGRAMS', 1, 1, 1),
        (2, 'MOTION', 8, 2, 100,  'KILOGRAMS', 1, 1, 1),
        (3, 'MOTION', 8, 1, 100,  'KILOGRAMS', 1, 1, 1),
        (4, 'MOTION', 10, 2, 70,  'KILOGRAMS', 2, 1, 2),
        (5, 'MOTION', 10, 2, 70,  'KILOGRAMS', 2, 1, 2),
        (6, 'MOTION', 10, 2, 70,  'KILOGRAMS', 2, 1, 2),
        (7, 'MOTION', 5, 4, 120,  'KILOGRAMS', 3, 1, 3),
        (8, 'MOTION', 5, 4, 120,  'KILOGRAMS', 3, 1, 3),
        (9, 'MOTION', 5, 4, 120,  'KILOGRAMS', 3, 1, 3);

INSERT INTO training_sessions_strength_exercises(training_sessions_id, strength_exercises_id) VALUES
          (1, 1), (1, 2), (1, 3), (1,4), (1,5), (1,6), (1,7), (1,8), (1,9);

INSERT INTO endurance_exercises(id, distance, distance_unit, heart_rate, vo2max_percentage, duration, time_unit, exercisable_id, training_session_id) VALUES
        (1, 2.0, 'KILOMETERS', 130, 70, '00:15', 'MINUTES', 6, 2),
        (2, 2.0, 'KILOMETERS', 150, 80, '00:10', 'MINUTES', 6, 2),
        (3, 1.0, 'KILOMETERS', 170, 90, '00:05', 'MINUTES', 6, 2);

INSERT INTO training_sessions_endurance_exercises(training_sessions_id, endurance_exercises_id) VALUES
          (2, 1), (2, 2), (2, 3);

INSERT INTO strength_records(id, exercise_name, reps, repetition_unit, date, weight, weight_unit) VALUES
        (1, 'Squat', 1, 'MOTION', '2020-09-09', 190, 'KILOGRAMS'),
        (2, 'Squat', 5, 'MOTION', '2020-07-09', 140, 'KILOGRAMS'),
        (3, 'Bench press', 1, 'MOTION', '2020-05-09', 150, 'KILOGRAMS');

INSERT INTO personal_records_strength_records(personal_records_id, strength_records_id) VALUES
        (1, 1), (1,2), (1,3);

INSERT INTO endurance_records(id, distance, distance_unit, date, exercise_name, duration, time_unit) VALUES
        (1, 1.0, 'KILOMETERS', '2020-05-09','Running',  '00:03','HOURS'),
        (2, 5.0, 'KILOMETERS', '2020-07-09','Running',  '00:28','HOURS'),
        (3, 100, 'METERS', '2021-05-09','Swimming',  '00:10','HOURS');

INSERT INTO personal_records_endurance_records(personal_records_id, endurance_records_id) VALUES
        (1, 1), (1,2), (1,3);

INSERT INTO custom_records(id, description, date, value) VALUES
        (1, 'Vertical jump', '2020-10-10', 0.8),
        (2, 'Drive 100km on bike', '2020-03-03', 100);

INSERT INTO personal_records_custom_records(personal_records_id, custom_records_id) VALUES
        (1, 1), (1, 2);






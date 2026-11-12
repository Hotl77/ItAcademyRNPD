-- Состав:
--   usersRequest        20
--   authors      15
--   books        20
--   book_author  20
--   loans        25
--   ИТОГО       100
-- ============================================================================

-- ---------------------------------------------------------------- USERS (20)
INSERT INTO users (first_name, last_name, middle_name, email, phone_number, library_card_number, passport_series_and_number) VALUES
                                                                                                                                 ('Иван',     'Петров',      'Сергеевич',    'ivan.petrov@gmail.com',        '79161110001', '100001', '4516 100001'),
                                                                                                                                 ('Мария',    'Иванова',     'Александровна','maria.ivanova@yandex.ru',      '79161110002', '100002', '4516 100002'),
                                                                                                                                 ('Алексей',  'Смирнов',     'Владимирович', 'alexey.smirnov@mail.ru',       '79161110003', '100003', '4516 100003'),
                                                                                                                                 ('Елена',    'Кузнецова',   'Дмитриевна',   'elena.kuznetsova@gmail.com',   '79161110004', '100004', '4516 100004'),
                                                                                                                                 ('Дмитрий',  'Попов',       'Андреевич',    'dmitry.popov@yahoo.com',       '79161110005', '100005', '4516 100005'),
                                                                                                                                 ('Анна',     'Соколова',    'Игоревна',     'anna.sokolova@yandex.ru',      '79161110006', '100006', '4516 100006'),
                                                                                                                                 ('Сергей',   'Лебедев',     'Николаевич',   'sergey.lebedev@mail.ru',       '79161110007', '100007', '4516 100007'),
                                                                                                                                 ('Ольга',    'Козлова',     'Викторовна',   'olga.kozlova@gmail.com',       '79161110008', '100008', '4516 100008'),
                                                                                                                                 ('Николай',  'Новиков',     'Павлович',     'nikolay.novikov@yandex.ru',    '79161110009', '100009', '4516 100009'),
                                                                                                                                 ('Татьяна',  'Морозова',    'Сергеевна',    'tatiana.morozova@mail.ru',     '79161110010', '100010', '4516 100010'),
                                                                                                                                 ('Павел',    'Волков',      'Олегович',     'pavel.volkov@gmail.com',       '79161110011', '100011', '4516 100011'),
                                                                                                                                 ('Наталья',  'Соловьева',   'Андреевна',    'natalia.soloveva@yandex.ru',   '79161110012', '100012', '4516 100012'),
                                                                                                                                 ('Андрей',   'Васильев',    'Михайлович',   'andrey.vasiliev@mail.ru',      '79161110013', '100013', '4516 100013'),
                                                                                                                                 ('Ирина',    'Зайцева',     'Алексеевна',   'irina.zaytseva@gmail.com',     '79161110014', '100014', '4516 100014'),
                                                                                                                                 ('Максим',   'Павлов',      'Дмитриевич',   'maxim.pavlov@yahoo.com',       '79161110015', '100015', '4516 100015'),
                                                                                                                                 ('Светлана', 'Семенова',    'Владимировна', 'svetlana.semenova@yandex.ru',  '79161110016', '100016', '4516 100016'),
                                                                                                                                 ('Артем',    'Голубев',     'Сергеевич',    'artem.golubev@gmail.com',      '79161110017', '100017', '4516 100017'),
                                                                                                                                 ('Юлия',     'Виноградова', 'Николаевна',   'yulia.vinogradova@mail.ru',    '79161110018', '100018', '4516 100018'),
                                                                                                                                 ('Роман',    'Богданов',    'Игоревич',     'roman.bogdanov@gmail.com',     '79161110019', '100019', '4516 100019'),
                                                                                                                                 ('Екатерина','Воробьева',   'Павловна',     'ekaterina.vorobyeva@yandex.ru','79161110020', '100020', '4516 100020');

-- --------------------------------------------------------------- AUTHORS (15)
INSERT INTO authors (first_name, last_name, middle_name, birth_date, gender, country, native_language) VALUES
                                                                                                           ('Лев',       'Толстой',     'Николаевич', '1828-09-09', 'MALE',   'Россия',         'Русский'),
                                                                                                           ('Фёдор',     'Достоевский', 'Михайлович', '1821-11-11', 'MALE',   'Россия',         'Русский'),
                                                                                                           ('Антон',     'Чехов',       'Павлович',   '1860-01-29', 'MALE',   'Россия',         'Русский'),
                                                                                                           ('Александр', 'Пушкин',      'Сергеевич',  '1799-06-06', 'MALE',   'Россия',         'Русский'),
                                                                                                           ('Михаил',    'Булгаков',    'Афанасьевич','1891-05-15', 'MALE',   'Россия',         'Русский'),
                                                                                                           ('Иван',      'Тургенев',    'Сергеевич',  '1818-11-09', 'MALE',   'Россия',         'Русский'),
                                                                                                           ('Николай',   'Гоголь',      'Васильевич', '1809-04-01', 'MALE',   'Россия',         'Русский'),
                                                                                                           ('Джордж',    'Оруэлл',      NULL,         '1903-06-25', 'MALE',   'Великобритания', 'Английский'),
                                                                                                           ('Джоан',     'Роулинг',     NULL,         '1965-07-31', 'FEMALE', 'Великобритания', 'Английский'),
                                                                                                           ('Стивен',    'Кинг',        NULL,         '1947-09-21', 'MALE',   'США',            'Английский'),
                                                                                                           ('Агата',     'Кристи',      NULL,         '1890-09-15', 'FEMALE', 'Великобритания', 'Английский'),
                                                                                                           ('Рэй',       'Брэдбери',    NULL,         '1920-08-22', 'MALE',   'США',            'Английский'),
                                                                                                           ('Эрнест',    'Хемингуэй',   NULL,         '1899-07-21', 'MALE',   'США',            'Английский'),
                                                                                                           ('Габриэль',  'Маркес',      NULL,         '1927-03-06', 'MALE',   'Колумбия',       'Испанский'),
                                                                                                           ('Франц',     'Кафка',       NULL,         '1883-07-03', 'MALE',   'Австрия',        'Немецкий');

-- ----------------------------------------------------------------- BOOKS (20)
INSERT INTO books (title, genre, number_of_pages, created_at) VALUES
                                                                  ('Война и мир',                            'ROMANCE',  1274, NOW()),
                                                                  ('Анна Каренина',                          'ROMANCE',   864, NOW()),
                                                                  ('Преступление и наказание',               'TRILLER',   671, NOW()),
                                                                  ('Братья Карамазовы',                      'TRILLER',   824, NOW()),
                                                                  ('Вишнёвый сад',                           'ROMANCE',   128, NOW()),
                                                                  ('Евгений Онегин',                         'ROMANCE',   224, NOW()),
                                                                  ('Мастер и Маргарита',                     'FANTASY',   480, NOW()),
                                                                  ('Белая гвардия',                          'ROMANCE',   320, NOW()),
                                                                  ('Отцы и дети',                            'ROMANCE',   288, NOW()),
                                                                  ('Мёртвые души',                           'ROMANCE',   352, NOW()),
                                                                  ('Ревизор',                                'ROMANCE',   128, NOW()),
                                                                  ('1984',                                   'TRILLER',   328, NOW()),
                                                                  ('Скотный двор',                           'FANTASY',   112, NOW()),
                                                                  ('Гарри Поттер и философский камень',      'FANTASY',   332, NOW()),
                                                                  ('Сияние',                                 'TRILLER',   512, NOW()),
                                                                  ('Убийство в Восточном экспрессе',         'TRILLER',   288, NOW()),
                                                                  ('451 градус по Фаренгейту',               'FANTASY',   256, NOW()),
                                                                  ('Старик и море',                          'ROMANCE',   128, NOW()),
                                                                  ('Сто лет одиночества',                    'FANTASY',   448, NOW()),
                                                                  ('Процесс',                                'TRILLER',   256, NOW());

-- ------------------------------------------------------------ BOOK_AUTHOR (20)
INSERT INTO book_author (book_id, author_id)
SELECT b.book_id, a.author_id
FROM (VALUES
          ('Война и мир',                       'Толстой'),
          ('Анна Каренина',                     'Толстой'),
          ('Преступление и наказание',          'Достоевский'),
          ('Братья Карамазовы',                 'Достоевский'),
          ('Вишнёвый сад',                      'Чехов'),
          ('Евгений Онегин',                    'Пушкин'),
          ('Мастер и Маргарита',                'Булгаков'),
          ('Белая гвардия',                     'Булгаков'),
          ('Отцы и дети',                       'Тургенев'),
          ('Мёртвые души',                      'Гоголь'),
          ('Ревизор',                           'Гоголь'),
          ('1984',                              'Оруэлл'),
          ('Скотный двор',                      'Оруэлл'),
          ('Гарри Поттер и философский камень', 'Роулинг'),
          ('Сияние',                            'Кинг'),
          ('Убийство в Восточном экспрессе',    'Кристи'),
          ('451 градус по Фаренгейту',          'Брэдбери'),
          ('Старик и море',                     'Хемингуэй'),
          ('Сто лет одиночества',               'Маркес'),
          ('Процесс',                           'Кафка')
     ) AS v(book_title, author_last_name)
         JOIN books   b ON b.title     = v.book_title
         JOIN authors a ON a.last_name = v.author_last_name;

-- ----------------------------------------------------------------- LOANS (25)
INSERT INTO loans (user_id, book_id, loan_date, due_date, return_date, loan_status)
SELECT u.id, b.book_id, v.loan_date, v.due_date, v.return_date, v.loan_status
FROM (VALUES
          ('ivan.petrov@gmail.com',        'Война и мир',                       NOW() - INTERVAL '2 days',   NOW() + INTERVAL '12 days', NULL::TIMESTAMP,            'ISSUED'),
          ('ivan.petrov@gmail.com',        '1984',                              NOW() - INTERVAL '30 days',  NOW() - INTERVAL '16 days', NOW() - INTERVAL '16 days', 'RETURNED'),
          ('maria.ivanova@yandex.ru',      'Анна Каренина',                     NOW() - INTERVAL '5 days',   NOW() + INTERVAL '9 days',  NULL,                       'ISSUED'),
          ('alexey.smirnov@mail.ru',       'Преступление и наказание',          NOW() - INTERVAL '40 days',  NOW() - INTERVAL '26 days', NULL,                       'OVERDUE'),
          ('elena.kuznetsova@gmail.com',   'Мастер и Маргарита',                NOW() - INTERVAL '7 days',   NOW() + INTERVAL '7 days',  NULL,                       'ISSUED'),
          ('dmitry.popov@yahoo.com',       'Братья Карамазовы',                 NOW() - INTERVAL '60 days',  NOW() - INTERVAL '46 days', NOW() - INTERVAL '45 days', 'RETURNED'),
          ('anna.sokolova@yandex.ru',      'Вишнёвый сад',                      NOW() - INTERVAL '1 day',    NOW() + INTERVAL '13 days', NULL,                       'ISSUED'),
          ('sergey.lebedev@mail.ru',       'Евгений Онегин',                    NOW() - INTERVAL '90 days',  NOW() - INTERVAL '76 days', NOW() - INTERVAL '75 days', 'RETURNED'),
          ('olga.kozlova@gmail.com',       'Мастер и Маргарита',                NOW() - INTERVAL '45 days',  NOW() - INTERVAL '31 days', NOW() - INTERVAL '30 days', 'RETURNED'),
          ('nikolay.novikov@yandex.ru',    'Мёртвые души',                      NOW() - INTERVAL '35 days',  NOW() - INTERVAL '21 days', NULL,                       'OVERDUE'),
          ('tatiana.morozova@mail.ru',     '1984',                              NOW() - INTERVAL '10 days',  NOW() + INTERVAL '4 days',  NULL,                       'ISSUED'),
          ('pavel.volkov@gmail.com',       'Скотный двор',                      NOW() - INTERVAL '100 days', NOW() - INTERVAL '86 days', NOW() - INTERVAL '80 days', 'RETURNED'),
          ('natalia.soloveva@yandex.ru',   'Гарри Поттер и философский камень', NOW() - INTERVAL '3 days',   NOW() + INTERVAL '11 days', NULL,                       'ISSUED'),
          ('andrey.vasiliev@mail.ru',      'Сияние',                            NOW() - INTERVAL '70 days',  NOW() - INTERVAL '56 days', NOW() - INTERVAL '55 days', 'RETURNED'),
          ('irina.zaytseva@gmail.com',     'Убийство в Восточном экспрессе',    NOW() - INTERVAL '6 days',   NOW() + INTERVAL '8 days',  NULL,                       'ISSUED'),
          ('maxim.pavlov@yahoo.com',       '451 градус по Фаренгейту',          NOW() - INTERVAL '30 days',  NOW() - INTERVAL '16 days', NULL,                       'OVERDUE'),
          ('svetlana.semenova@yandex.ru',  'Старик и море',                     NOW() - INTERVAL '4 days',   NOW() + INTERVAL '10 days', NULL,                       'ISSUED'),
          ('artem.golubev@gmail.com',      'Сто лет одиночества',               NOW() - INTERVAL '50 days',  NOW() - INTERVAL '36 days', NOW() - INTERVAL '35 days', 'RETURNED'),
          ('yulia.vinogradova@mail.ru',    'Процесс',                           NOW() - INTERVAL '8 days',   NOW() + INTERVAL '6 days',  NULL,                       'ISSUED'),
          ('roman.bogdanov@gmail.com',     'Белая гвардия',                     NOW() - INTERVAL '80 days',  NOW() - INTERVAL '66 days', NOW() - INTERVAL '65 days', 'RETURNED'),
          ('maria.ivanova@yandex.ru',      'Отцы и дети',                       NOW() - INTERVAL '9 days',   NOW() + INTERVAL '5 days',  NULL,                       'ISSUED'),
          ('elena.kuznetsova@gmail.com',   'Ревизор',                           NOW() - INTERVAL '40 days',  NOW() - INTERVAL '26 days', NOW() - INTERVAL '25 days', 'RETURNED'),
          ('alexey.smirnov@mail.ru',       '1984',                              NOW() - INTERVAL '55 days',  NOW() - INTERVAL '41 days', NOW() - INTERVAL '40 days', 'RETURNED'),
          ('olga.kozlova@gmail.com',       'Гарри Поттер и философский камень', NOW() - INTERVAL '65 days',  NOW() - INTERVAL '51 days', NOW() - INTERVAL '50 days', 'RETURNED'),
          ('svetlana.semenova@yandex.ru',  'Война и мир',                       NOW() - INTERVAL '20 days',  NOW() - INTERVAL '6 days',  NOW() - INTERVAL '6 days',  'RETURNED')
     ) AS v(user_email, book_title, loan_date, due_date, return_date, loan_status)
         JOIN users u ON u.email = v.user_email
         JOIN books b ON b.title = v.book_title;
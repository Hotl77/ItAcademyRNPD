

CREATE EXTENSION IF NOT EXISTS "pgcrypto";  -- для gen_random_uuid()
CREATE EXTENSION IF NOT EXISTS "uuid-ossp";


CREATE TABLE IF NOT EXISTS users (

    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    first_name VARCHAR(50) NOT NULL
        CONSTRAINT chk_first_name_format CHECK (first_name ~ '^[А-ЯЁ][а-яёА-ЯЁ''\- ]{1,}$')
        CONSTRAINT chk_first_name_length CHECK (length(first_name) BETWEEN 2 AND 50),
    last_name VARCHAR(50) NOT NULL
        CONSTRAINT chk_last_name_format CHECK (last_name ~ '^[А-ЯЁ][а-яёА-ЯЁ''\- ]{1,}$')
        CONSTRAINT chk_last_name_length CHECK (length(last_name) BETWEEN 2 AND 50),
    middle_name VARCHAR(50)
        CONSTRAINT chk_middle_name CHECK (
            middle_name IS NULL OR (
                middle_name ~ '^[А-ЯЁ][а-яёА-ЯЁ''\- ]{1,}$' AND
                length(middle_name) BETWEEN 2 AND 50
            )
        ),
    email VARCHAR(100) NOT NULL UNIQUE
        CONSTRAINT chk_email_domain CHECK (email ~* '^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\.[A-Za-z]{2,}$'),
    phone_number VARCHAR(11) NOT NULL
        CONSTRAINT chk_phone_number_format CHECK (phone_number ~ '^7[0-9]{10}$'),
    library_card_number VARCHAR(100) UNIQUE
        CONSTRAINT chk_library_card_number_format CHECK (library_card_number ~ '^[0-9]+$'),       --хз какой должен быть номер

    registration_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,

    passport_series_and_number VARCHAR(11) NOT NULL UNIQUE
        CONSTRAINT chk_passport_series_and_number CHECK (passport_series_and_number ~ '^\d{4} \d{6}$')
    );


CREATE TABLE IF NOT EXISTS authors (

    author_id UUID PRIMARY KEY DEFAULT gen_random_uuid(),

    first_name VARCHAR(50) NOT NULL
        CONSTRAINT chk_first_name_format CHECK (first_name ~ '^[А-ЯЁ][а-яёА-ЯЁ''\- ]{1,}$')
        CONSTRAINT chk_first_name_length CHECK (length(first_name) BETWEEN 2 AND 50),

    last_name VARCHAR(50) NOT NULL
        CONSTRAINT chk_last_name_format CHECK (last_name ~ '^[А-ЯЁ][а-яёА-ЯЁ''\- ]{1,}$')
        CONSTRAINT chk_last_name_length CHECK (length(last_name) BETWEEN 2 AND 50),

    middle_name VARCHAR(50)
    CONSTRAINT chk_middle_name CHECK (
        middle_name IS NULL OR (
            middle_name ~ '^[А-ЯЁ][а-яёА-ЯЁ''\- ]{1,}$' AND
            length(middle_name) BETWEEN 2 AND 50
        )
    ),

    birth_date DATE
        CONSTRAINT chk_birth_date_age CHECK (birth_date <= (CURRENT_DATE - INTERVAL '18 years')),

    gender VARCHAR(20)
        CONSTRAINT chk_gender_enum CHECK (gender IN ('MALE','FEMALE','OTHER')),

    country VARCHAR(100)
        CONSTRAINT chk_country CHECK (country ~ '^[А-ЯЁ][а-яёА-ЯЁ''\- .]{2,}$'),

    native_language VARCHAR(50)
        CONSTRAINT chk_native_language CHECK (native_language ~ '^[А-Яа-яЁё ]+$')
    );


CREATE TABLE IF NOT EXISTS books (

    book_id UUID PRIMARY KEY DEFAULT gen_random_uuid(),

    title VARCHAR(100) NOT NULL
        CONSTRAINT chk_title CHECK (title ~ '^[А-Яа-яЁё0-9 \-:,.!?''()]+$'),

    genre VARCHAR(50)
        CONSTRAINT chk_genre_enum CHECK (genre IN ('TRILLER' ,'FANTASY' ,'ROMANCE')),

    number_of_pages INTEGER
        CONSTRAINT chk_number_of_pages_positive CHECK (number_of_pages BETWEEN 1 AND 2000),


    created_at TIMESTAMP NOT NULL

    );


CREATE TABLE IF NOT EXISTS book_author (

    book_id UUID NOT NULL REFERENCES books(book_id) ON DELETE CASCADE,

    author_id UUID NOT NULL REFERENCES authors(author_id) ON DELETE CASCADE,

    PRIMARY KEY (book_id, author_id)

    );


CREATE TABLE IF NOT EXISTS loans (

    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),

    user_id UUID NOT NULL REFERENCES users(id) ON DELETE RESTRICT,

    book_id UUID NOT NULL REFERENCES books(book_id) ON DELETE RESTRICT,

    loan_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,

    due_date TIMESTAMP,

    return_date TIMESTAMP,

    loan_status VARCHAR(20) NOT NULL DEFAULT 'ISSUED'
        CONSTRAINT chk_loan_status_enum CHECK ( loan_status IN( 'ISSUED','RETURNED','OVERDUE' ))

    );


CREATE INDEX IF NOT EXISTS idx_loans_user_id ON loans(user_id);
CREATE INDEX IF NOT EXISTS idx_loans_book_id ON loans(book_id);
CREATE INDEX IF NOT EXISTS idx_loans_status ON loans(loan_status);
CREATE INDEX IF NOT EXISTS idx_book_author_author_id ON book_author(author_id);
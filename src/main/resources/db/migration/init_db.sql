-- This file used by docker to init db

CREATE DATABASE yandex_rasp_db;

\c yandex_rasp_db;

CREATE EXTENSION IF NOT EXISTS "uuid-ossp";
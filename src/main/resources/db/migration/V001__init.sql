DROP TABLE IF EXISTS "station";
CREATE TABLE "station"
(
    "id"             UUID                        NOT NULL DEFAULT "RANDOM_UUID"(),
    "settlement_id"  UUID                        NOT NULL,
    "esr_code"       VARCHAR,
    "yandex_code"    VARCHAR,
    "title"          VARCHAR,
    "direction"      VARCHAR,
    "station_type"   VARCHAR,
    "transport_type" VARCHAR,
    "latitude"       DOUBLE PRECISION,
    "longitude"      DOUBLE PRECISION,
    "created_at"     TIMESTAMP WITHOUT TIME ZONE NOT NULL DEFAULT NOW(),
    "updated_at"     TIMESTAMP WITHOUT TIME ZONE NOT NULL DEFAULT NOW()
);

DROP TABLE IF EXISTS "settlement";
CREATE TABLE "settlement"
(
    "id"          UUID                        NOT NULL DEFAULT "RANDOM_UUID"(),
    "region_id"   UUID                        NOT NULL,
    "esr_code"    VARCHAR,
    "yandex_code" VARCHAR,
    "title"       VARCHAR,
    "created_at"  TIMESTAMP WITHOUT TIME ZONE NOT NULL DEFAULT NOW(),
    "updated_at"  TIMESTAMP WITHOUT TIME ZONE NOT NULL DEFAULT NOW()
);

DROP TABLE IF EXISTS "region";
CREATE TABLE "region"
(
    "id"          UUID                        NOT NULL DEFAULT "RANDOM_UUID"(),
    "country_id"  UUID                        NOT NULL,
    "esr_code"    VARCHAR,
    "yandex_code" VARCHAR,
    "title"       VARCHAR,
    "created_at"  TIMESTAMP WITHOUT TIME ZONE NOT NULL DEFAULT NOW(),
    "updated_at"  TIMESTAMP WITHOUT TIME ZONE NOT NULL DEFAULT NOW()
);

DROP TABLE IF EXISTS "country";
CREATE TABLE "country"
(
    "id"          UUID                        NOT NULL DEFAULT "RANDOM_UUID"(),
    "esr_code"    VARCHAR,
    "yandex_code" VARCHAR,
    "title"       VARCHAR,
    "created_at"  TIMESTAMP WITHOUT TIME ZONE NOT NULL DEFAULT NOW(),
    "updated_at"  TIMESTAMP WITHOUT TIME ZONE NOT NULL DEFAULT NOW()
);


-- PRIMARY KEY
ALTER TABLE "station"
    DROP CONSTRAINT IF EXISTS "pk__station";
ALTER TABLE "station"
    ADD CONSTRAINT "pk__station" PRIMARY KEY ("id");

ALTER TABLE "settlement"
    DROP CONSTRAINT IF EXISTS "pk__settlement";
ALTER TABLE "settlement"
    ADD CONSTRAINT "pk__settlement" PRIMARY KEY ("id");

ALTER TABLE "region"
    DROP CONSTRAINT IF EXISTS "pk__region";
ALTER TABLE "region"
    ADD CONSTRAINT "pk__region" PRIMARY KEY ("id");

ALTER TABLE "country"
    DROP CONSTRAINT IF EXISTS "pk__country";
ALTER TABLE "country"
    ADD CONSTRAINT "pk__country" PRIMARY KEY ("id");


-- FOREIGN KEY
ALTER TABLE "station"
    DROP CONSTRAINT IF EXISTS "fk__station__settlement";
ALTER TABLE "station"
    ADD CONSTRAINT "fk__station__settlement" FOREIGN KEY ("settlement_id")
        REFERENCES "settlement" ("id") ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE "settlement"
    DROP CONSTRAINT IF EXISTS "fk__settlement__region";
ALTER TABLE "settlement"
    ADD CONSTRAINT "fk__settlement__region" FOREIGN KEY ("region_id")
        REFERENCES "region" ("id") ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE "region"
    DROP CONSTRAINT IF EXISTS "fk__region__country";
ALTER TABLE "region"
    ADD CONSTRAINT "fk__region__country" FOREIGN KEY ("country_id")
        REFERENCES "country" ("id") ON DELETE CASCADE ON UPDATE CASCADE;

-- INDEX
DROP INDEX IF EXISTS "idx__station__latitude";
CREATE INDEX "idx__station__latitude" ON "station" ("latitude");

DROP INDEX IF EXISTS "idx__station__longitude";
CREATE INDEX "idx__station__longitude" ON "station" ("longitude");

DROP INDEX IF EXISTS "idx__station__created_at";
CREATE INDEX "idx__station__created_at" ON "station" ("created_at");

DROP INDEX IF EXISTS "idx__station__updated_at";
CREATE INDEX "idx__station__updated_at" ON "station" ("updated_at");

DROP INDEX IF EXISTS "idx__settlement__created_at";
CREATE INDEX "idx__settlement__created_at" ON "settlement" ("created_at");

DROP INDEX IF EXISTS "idx__settlement__updated_at";
CREATE INDEX "idx__settlement__updated_at" ON "settlement" ("updated_at");

DROP INDEX IF EXISTS "idx__region__created_at";
CREATE INDEX "idx__region__created_at" ON "region" ("created_at");

DROP INDEX IF EXISTS "idx__region__updated_at";
CREATE INDEX "idx__region__updated_at" ON "region" ("updated_at");

DROP INDEX IF EXISTS "idx__country__created_at";
CREATE INDEX "idx__country__created_at" ON "country" ("created_at");

DROP INDEX IF EXISTS "idx__country__updated_at";
CREATE INDEX "idx__country__updated_at" ON "country" ("updated_at");
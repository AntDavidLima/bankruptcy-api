CREATE extension IF NOT EXISTS "uuid-ossp";

CREATE TABLE
  income (
    id uuid DEFAULT uuid_generate_v4 (),
    description text NOT NULL,
    value decimal(8, 2) NOT NULL,
    created_at timestamp NOT NULL,
    updated_at timestamp,
    PRIMARY KEY (id)
  );

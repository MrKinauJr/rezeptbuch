CREATE TABLE IF NOT EXISTS recipe
(
    id          serial       NOT NULL,
    name        VARCHAR(255) NOT NULL,
    description VARCHAR(255) NOT NULL,
    image       VARCHAR(255) NOT NULL,
    time        INT          NOT NULL,
    servings    INT          NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS ingredient
(
    id   serial       NOT NULL,
    name VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);
CREATE TABLE IF NOT EXISTS recipe_ingredient
(
    recipe_id     serial       NOT NULL,
    ingredient_id serial       NOT NULL,
    amount        VARCHAR(255) NOT NULL,
    unit          VARCHAR(255) NOT NULL,
    FOREIGN KEY (recipe_id) REFERENCES recipe (id),
    FOREIGN KEY (ingredient_id) REFERENCES ingredient (id),
    PRIMARY KEY (recipe_id, ingredient_id)
);
CREATE TABLE IF NOT EXISTS step
(
    id          serial       NOT NULL,
    recipe_id   INTEGER      NOT NULL,
    step_number INT          NOT NULL,
    description VARCHAR(512) NOT NULL,
    FOREIGN KEY (recipe_id) REFERENCES recipe (id),
    PRIMARY KEY (id)
);
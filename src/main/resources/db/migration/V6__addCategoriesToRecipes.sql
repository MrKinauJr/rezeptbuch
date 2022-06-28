CREATE TABLE IF NOT EXISTS category (
  id serial PRIMARY KEY,
  name TEXT NOT NULL
);

CREATE TABLE IF NOT EXISTS recipe_category (
  category_id serial NOT NULL,
  recipe_id serial NOT NULL,
  FOREIGN KEY (recipe_id) REFERENCES recipe (id),
  FOREIGN KEY (category_id) REFERENCES category (id),
  PRIMARY KEY (category_id, recipe_id)
);
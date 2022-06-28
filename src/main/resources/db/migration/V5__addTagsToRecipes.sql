CREATE TABLE IF NOT EXISTS tag (
  id serial PRIMARY KEY,
  name TEXT NOT NULL
);

CREATE TABLE IF NOT EXISTS recipe_tag (
  tag_id serial NOT NULL,
  recipe_id serial NOT NULL,

  FOREIGN KEY (recipe_id) REFERENCES recipe (id),
  FOREIGN KEY (tag_id) REFERENCES tag (id),
  PRIMARY KEY (tag_id, recipe_id)
);


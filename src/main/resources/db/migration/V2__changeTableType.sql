SET enable_experimental_alter_column_type_general = true;
alter table recipe_ingredient
    alter column amount type int using amount::int;
SET enable_experimental_alter_column_type_general = false;

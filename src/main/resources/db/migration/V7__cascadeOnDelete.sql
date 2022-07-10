alter table step
    drop constraint fk_recipe_id_ref_recipe;

alter table step
    add constraint fk_recipe_id_ref_recipe
        foreign key (recipe_id) references recipe
            on delete cascade;

alter table recipe_ingredient
    drop constraint fk_recipe_id_ref_recipe;

alter table recipe_ingredient
    add constraint fk_recipe_id_ref_recipe
        foreign key (recipe_id) references recipe
            on update cascade;

alter table recipe_category
    drop constraint fk_recipe_id_ref_recipe;

alter table recipe_category
    add constraint fk_recipe_id_ref_recipe
        foreign key (recipe_id) references recipe
            on update cascade;

alter table recipe_tag
    drop constraint fk_recipe_id_ref_recipe;

alter table recipe_tag
    add constraint fk_recipe_id_ref_recipe
        foreign key (recipe_id) references recipe
            on update cascade;


package network.kinau.recipes.repositories;

import network.kinau.recipes.entities.Recipe;
import network.kinau.recipes.entities.Tag;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TagRepository extends CrudRepository<Tag, Long> {
    Tag findById(String id);

    List<Tag> findAll();
}

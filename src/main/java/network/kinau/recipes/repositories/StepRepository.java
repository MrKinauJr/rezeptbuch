package network.kinau.recipes.repositories;

import network.kinau.recipes.entities.Step;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StepRepository extends CrudRepository<Step, Long> {

}

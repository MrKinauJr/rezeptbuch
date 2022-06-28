package network.kinau.recipes.services;

import network.kinau.recipes.entities.Step;
import network.kinau.recipes.repositories.StepRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StepService{
    @Autowired
    private StepRepository stepRepository;

    public Step saveStep(Step step) {
        return stepRepository.save(step);
    }
}

package npc.martin.aomsbackend.services;

import java.util.List;
import npc.martin.aomsbackend.dao.AnimalDAO;
import npc.martin.aomsbackend.entity.Animal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author bikathi_martin
 */

@Service
public class AnimalServiceImpl implements AnimalService {
    private final AnimalDAO animalDAO;
    
    @Autowired
    public AnimalServiceImpl(AnimalDAO animalDAO) {
        this.animalDAO = animalDAO;
    }
    
    @Override
    @Transactional
    public List<Animal> getAnimals() {
        return animalDAO.getAnimals();
    }

    @Override
    @Transactional
    public void createAnimal(Animal animal) {
        animalDAO.createAnimal(animal);
    }

    @Override
    @Transactional
    public Animal getAnimalById(Integer animalId) {
        return animalDAO.getAnimalById(animalId);
    }

    @Override
    @Transactional
    public void updateAnimal(Animal animal) {
        animalDAO.updateAnimal(animal);
    }

    @Override
    @Transactional
    public void deleteAnimal(Animal animal) {
        animalDAO.deleteAnimal(animal);
    }
}

package npc.martin.aomsbackend.services;

import java.util.List;
import npc.martin.aomsbackend.entity.Animal;

/**
 *
 * @author bikathi_martin
 */
public interface AnimalService {
    public List<Animal> getAnimals();
    public void createAnimal(Animal animal);
    public Animal getAnimalById(Integer animalId);
    public Animal searchAnimalById(Integer animalId);
    public void updateAnimal(Animal animal);
    public void deleteAnimal(Animal animal);
}

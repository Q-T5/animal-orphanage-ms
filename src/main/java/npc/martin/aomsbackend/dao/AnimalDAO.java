package npc.martin.aomsbackend.dao;

import java.util.List;
import npc.martin.aomsbackend.entity.Animal;

/**
 *
 * @author bikathi_martin
 */
public interface AnimalDAO {
    public List<Animal> getAnimals();
    public void createAnimal(Animal animal);
    public Animal getAnimalById(Integer animalId);
    public Animal searchAnimalById(Integer animalId);
    public List<Animal> searchAnimalByCommonName(String commonName);
    public void updateAnimal(Animal animal);
    public void deleteAnimal(Animal animal);
}

package npc.martin.impalabackend.dao;

import java.util.List;
import npc.martin.impalabackend.entity.AnimalBasicDetail;

/**
 *
 * @author bikathi_martin
 */
public interface AnimalBasicDetailDAO {
    public List<AnimalBasicDetail> getAnimals();
    public void createAnimal(AnimalBasicDetail animal);
    public AnimalBasicDetail getAnimalById(Integer animalId);
    public AnimalBasicDetail searchAnimalById(Integer animalId);
    public void updateAnimal(AnimalBasicDetail animal);
    public void deleteAnimal(AnimalBasicDetail animal);
}

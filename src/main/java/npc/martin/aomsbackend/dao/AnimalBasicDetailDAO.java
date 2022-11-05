package npc.martin.aomsbackend.dao;

import java.util.List;
import npc.martin.aomsbackend.entity.AnimalBasicDetail;

/**
 *
 * @author bikathi_martin
 */
public interface AnimalBasicDetailDAO {
    public List<AnimalBasicDetail> getAnimals();
    public void createAnimal(AnimalBasicDetail animal);
    public AnimalBasicDetail getAnimalById(Integer animalId);
    public AnimalBasicDetail searchAnimalById(Integer animalId);
    public List<AnimalBasicDetail> searchAnimalByCommonName(String commonName);
    public void updateAnimal(AnimalBasicDetail animal);
    public void deleteAnimal(AnimalBasicDetail animal);
}

package npc.martin.impalabackend.services;

import java.util.List;
import npc.martin.impalabackend.entity.AnimalBasicDetail;

/**
 *
 * @author bikathi_martin
 */
public interface AnimalBasicDetailService {
    public List<AnimalBasicDetail> getAnimals();
    public void createAnimal(AnimalBasicDetail animal);
    public AnimalBasicDetail getAnimalById(Integer animalId);
    public AnimalBasicDetail searchAnimalById(Integer animalId);
    public List<AnimalBasicDetail> searchAnimalByCommonName(String commonName);
    public void updateAnimal(AnimalBasicDetail animal);
    public void deleteAnimal(AnimalBasicDetail animal);
}

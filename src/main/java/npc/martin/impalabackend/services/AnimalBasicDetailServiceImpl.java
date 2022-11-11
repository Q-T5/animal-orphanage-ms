package npc.martin.impalabackend.services;

import java.util.List;
import npc.martin.impalabackend.entity.AnimalBasicDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import npc.martin.impalabackend.dao.AnimalBasicDetailDAO;

/**
 *
 * @author bikathi_martin
 */

@Service
public class AnimalBasicDetailServiceImpl implements AnimalBasicDetailService {
    private final AnimalBasicDetailDAO animalDAO;
    
    @Autowired
    public AnimalBasicDetailServiceImpl(AnimalBasicDetailDAO animalDAO) {
        this.animalDAO = animalDAO;
    }
    
    @Override
    @Transactional
    public List<AnimalBasicDetail> getAnimals() {
        return animalDAO.getAnimals();
    }

    @Override
    @Transactional
    public void createAnimal(AnimalBasicDetail animal) {
        animalDAO.createAnimal(animal);
    }

    @Override
    @Transactional
    public AnimalBasicDetail getAnimalById(Integer animalId) {
        return animalDAO.getAnimalById(animalId);
    }

    @Override
    @Transactional
    public void updateAnimal(AnimalBasicDetail animal) {
        animalDAO.updateAnimal(animal);
    }

    @Override
    @Transactional
    public void deleteAnimal(AnimalBasicDetail animal) {
        animalDAO.deleteAnimal(animal);
    }

    @Override
    @Transactional
    public AnimalBasicDetail searchAnimalById(Integer animalId) {
        return animalDAO.searchAnimalById(animalId);
    }

    @Override
    @Transactional
    public List<AnimalBasicDetail> searchAnimalByCommonName(String commonName) {
        return animalDAO.searchAnimalByCommonName(commonName);
    }
}

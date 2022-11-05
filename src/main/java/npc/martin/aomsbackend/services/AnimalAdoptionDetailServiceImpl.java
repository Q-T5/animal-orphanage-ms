package npc.martin.aomsbackend.services;

import npc.martin.aomsbackend.entity.AnimalAdoptionDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import npc.martin.aomsbackend.dao.AnimalAdoptionDetailDAO;

/**
 *
 * @author bikathi_martin
 */

@Service
public class AnimalAdoptionDetailServiceImpl implements AnimalAdoptionDetailService {
    private AnimalAdoptionDetailDAO animalDetailsDAO;
    
    @Autowired
    public AnimalAdoptionDetailServiceImpl(AnimalAdoptionDetailDAO animalDetailsDAO) {
        this.animalDetailsDAO = animalDetailsDAO;
    }

    @Override
    @Transactional
    public void addAnimalDetail(AnimalAdoptionDetail animalDetail) {
        animalDetailsDAO.addAnimalDetail(animalDetail);
    }

    @Override
    @Transactional
    public void updateAnimalDetail(AnimalAdoptionDetail animalDetail) {
        animalDetailsDAO.updateAnimalDetail(animalDetail);
    }
    
}

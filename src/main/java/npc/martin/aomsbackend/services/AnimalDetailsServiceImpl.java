package npc.martin.aomsbackend.services;

import npc.martin.aomsbackend.dao.AnimalDetailsDAO;
import npc.martin.aomsbackend.entity.AnimalDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author bikathi_martin
 */

@Service
public class AnimalDetailsServiceImpl implements AnimalDetailsService {
    private AnimalDetailsDAO animalDetailsDAO;
    
    @Autowired
    public AnimalDetailsServiceImpl(AnimalDetailsDAO animalDetailsDAO) {
        this.animalDetailsDAO = animalDetailsDAO;
    }

    @Override
    @Transactional
    public void addAnimalDetail(AnimalDetail animalDetail) {
        animalDetailsDAO.addAnimalDetail(animalDetail);
    }

    @Override
    @Transactional
    public void updateAnimalDetail(AnimalDetail animalDetail) {
        animalDetailsDAO.updateAnimalDetail(animalDetail);
    }
    
}

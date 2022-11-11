package npc.martin.impalabackend.dao;

import javax.persistence.EntityManager;
import npc.martin.impalabackend.entity.AnimalAdoptionDetail;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author bikathi_martin
 */
@Repository
public class AnimalAdoptionDetailDAOImpl implements AnimalAdoptionDetailDAO {
    private EntityManager entityManager;
    
    @Autowired
    public AnimalAdoptionDetailDAOImpl(EntityManager EntityManager) {
        this.entityManager = EntityManager;
    }

    @Override
    public void addAnimalDetail(AnimalAdoptionDetail animalDetail) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.save(animalDetail);
    }

    @Override
    public void updateAnimalDetail(AnimalAdoptionDetail animalDetail) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.update(animalDetail);
    }
    
}

package npc.martin.aomsbackend.dao;

import javax.persistence.EntityManager;
import npc.martin.aomsbackend.entity.AnimalDetail;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author bikathi_martin
 */
@Repository
public class AnimalDetailsDAOImpl implements AnimalDetailsDAO {
    private EntityManager entityManager;
    
    @Autowired
    public AnimalDetailsDAOImpl(EntityManager EntityManager) {
        this.entityManager = EntityManager;
    }

    @Override
    public void addAnimalDetail(AnimalDetail animalDetail) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.save(animalDetail);
    }

    @Override
    public void updateAnimalDetail(AnimalDetail animalDetail) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.update(animalDetail);
    }
    
}

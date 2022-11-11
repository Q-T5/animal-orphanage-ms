package npc.martin.impalabackend.dao;

import java.util.List;
import javax.persistence.EntityManager;
import npc.martin.impalabackend.entity.AnimalBasicDetail;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author bikathi_martin
 */
@Repository
public class AnimalBasicDetailsDAOImpl implements AnimalBasicDetailDAO {
    private final EntityManager entityManager;
    
    @Autowired
    public AnimalBasicDetailsDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<AnimalBasicDetail> getAnimals() {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<AnimalBasicDetail> query = currentSession.createQuery("from AnimalBasicDetail", AnimalBasicDetail.class);

        List<AnimalBasicDetail> animalList = query.getResultList();
        return animalList;
    }

    @Override
    public void createAnimal(AnimalBasicDetail animal) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.save(animal);
    }

    @Override
    public AnimalBasicDetail getAnimalById(Integer animalId) {
        Session currentSession = entityManager.unwrap(Session.class);

        AnimalBasicDetail theAnimal = currentSession.getReference(AnimalBasicDetail.class, animalId);
        return theAnimal;
    }

    @Override
    public void updateAnimal(AnimalBasicDetail animal) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.update(animal);
    }

    @Override
    public void deleteAnimal(AnimalBasicDetail animal) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.delete(animal);
    }

    @Override
    public AnimalBasicDetail searchAnimalById(Integer animalId) {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<AnimalBasicDetail> query = currentSession.createQuery("FROM AnimalBasicDetail A WHERE A.animalId = :animal_id", 
                AnimalBasicDetail.class);
        query.setParameter("animal_id", animalId);
        AnimalBasicDetail theAnimal = query.getSingleResult();
        return theAnimal;
    }

    @Override
    public List<AnimalBasicDetail> searchAnimalByCommonName(String commonName) {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<AnimalBasicDetail> query = currentSession.createQuery(
                "FROM AnimalBasicDetail A WHERE A.commonName = :commonName" +
                " ORDER BY A.animalId DESC"
        );
        query.setParameter("commonName", commonName);
        List<AnimalBasicDetail> animalList = query.list();
        return animalList;
    }
}

package npc.martin.aomsbackend.dao;

import java.util.List;
import javax.persistence.EntityManager;
import npc.martin.aomsbackend.entity.Animal;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author bikathi_martin
 */
@Repository
public class AnimalDAOImpl implements AnimalDAO {
    private EntityManager entityManager;
    
    @Autowired
    public AnimalDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Animal> getAnimals() {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<Animal> query = currentSession.createQuery("from Animal", Animal.class);

        List<Animal> animalList = query.getResultList();
        return animalList;
    }

    @Override
    public void createAnimal(Animal animal) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.save(animal);
    }

    @Override
    public Animal getAnimalById(Integer animalId) {
        Session currentSession = entityManager.unwrap(Session.class);

        Animal theAnimal = currentSession.getReference(Animal.class, animalId);
        return theAnimal;
    }

    @Override
    public void updateAnimal(Animal animal) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.update(animal);
    }

    @Override
    public void deleteAnimal(Animal animal) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.delete(animal);
    }

}

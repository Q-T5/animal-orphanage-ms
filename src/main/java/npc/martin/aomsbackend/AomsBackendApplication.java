package npc.martin.aomsbackend;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import npc.martin.aomsbackend.entity.Animal;
import npc.martin.aomsbackend.entity.AnimalDetail;
import npc.martin.aomsbackend.repository.AnimalDetailRepository;
import npc.martin.aomsbackend.repository.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AomsBackendApplication implements CommandLineRunner {
    private LocalDate theDate = LocalDate.parse("Jun 21 2030", DateTimeFormatter.ofPattern("MMM dd yyyy"));
    
    @Autowired
    private AnimalRepository animalRepository;

    public static void main(String[] args) {
        SpringApplication.run(AomsBackendApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Animal testAnimal = new Animal("yang", "cta", 2);
        
        AnimalDetail testAnimalDetail = new AnimalDetail(100, theDate, theDate, "John Doe", "+1 045-897-672", "Sometown");
        testAnimal.setAnimalDetail(testAnimalDetail);
        
        animalRepository.save(testAnimal);
    }

}

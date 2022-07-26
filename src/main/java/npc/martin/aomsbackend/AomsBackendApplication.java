package npc.martin.aomsbackend;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import npc.martin.aomsbackend.entity.Animal;
import npc.martin.aomsbackend.entity.AnimalDetail;
import npc.martin.aomsbackend.services.AnimalDetailsService;
import npc.martin.aomsbackend.services.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AomsBackendApplication implements CommandLineRunner {
    private LocalDate theDate = LocalDate.parse("22 Feb 2024", DateTimeFormatter.ofPattern("dd MMM yyyy"));
    
    @Autowired
    private AnimalService animalService;
    
    @Autowired
    private AnimalDetailsService animalDetailsService;

    public static void main(String[] args) {
        SpringApplication.run(AomsBackendApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        /*
        Animal theAnimal = new Animal("Hansa", "dog", 3);
        AnimalDetail theDetails = new AnimalDetail(100, theDate, theDate, "Jane Doe", "+254-754-324590 ", "Iowa");
        theAnimal.setAnimalDetail(theDetails);
        
        System.out.println("saving animal and details.. ");
        animalService.createAnimal(theAnimal);
        System.out.println("successfully saved animal and details... ");
        
        
        /*
        System.out.println("Fetching animal from DB... ");
        Animal retrievedAnimal = animalService.getAnimalById(100);
        System.out.println("Retrieved Animal: " + retrievedAnimal);
        
        
        System.out.println("Extracting data from retrieved animal... ");
        AnimalDetail retrievedAnimalDetails = retrievedAnimal.getAnimalDetail();
        
        System.out.println("Retrieved Animal detail: " + retrievedAnimalDetails);
        */
    }
}

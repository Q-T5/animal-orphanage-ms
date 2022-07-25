package npc.martin.aomsbackend;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author bikathi_martin
 */
public class TestDates {
    public static void main(String[] args) {
        LocalDate theDate = LocalDate.parse("Jun 21 2030", DateTimeFormatter.ofPattern("MMM dd yyyy"));
        System.out.println("Date entered: " + theDate);
    }
}

package codeenthusiast.TrainingCenterApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TrainingCenterAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(TrainingCenterAppApplication.class, args);
        System.out.println("/Dodać poprawne mapowanie: DTO bez encji podrzędnych");
        System.out.println("/Dodać security odrazu");
    }
}

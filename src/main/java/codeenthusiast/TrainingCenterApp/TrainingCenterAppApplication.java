package codeenthusiast.TrainingCenterApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
public class TrainingCenterAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(TrainingCenterAppApplication.class, args);
    }

    @GetMapping("/test")
    public String test(){
        return "Test passed";
    }

}

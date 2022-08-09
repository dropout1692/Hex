package wtf.dpt.hex.testapi;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import wtf.dpt.hex.HexMap;
import wtf.dpt.hex.enums.MapMode;

@SpringBootApplication
public class TestApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestApiApplication.class, args);
    }

//    @Bean
//    public CommandLineRunner runApp(ApplicationContext ctx){
//        return args -> {
//
//            HexMap map = new HexMap(10, 8, MapMode.INNER);
//            map.printMap();
//            System.out.println("done bitch!");
//        };
//    }
}

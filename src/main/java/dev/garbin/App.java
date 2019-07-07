package dev.garbin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * appspring_gradle
 *
 * @author Marcelo Garbin
 * @version 1.0
 */
@SpringBootApplication
public class App{
    public static void main(String[] args){
        System.out.println("Iniciando SpringApplication...");
        SpringApplication.run(App.class, args);
    }
}

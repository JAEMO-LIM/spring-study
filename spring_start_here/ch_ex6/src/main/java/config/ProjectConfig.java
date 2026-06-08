package config;

import beans.Parrot;
import beans.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProjectConfig {
    @Bean
    public Parrot parrot1() {
        Parrot p = new Parrot();
        p.setName("Koko");
        return p;
    }

    @Bean
    public Parrot parrot2() {
        Parrot p = new Parrot();
        p.setName("Kiki");
        return p;
    }

    @Bean
    public Person person(Parrot parrot2) {
        Person p = new Person();
        p.setName("Kimi");
        p.setParrot(parrot2);
        return p;
    }
}

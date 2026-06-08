package config;

import beans.Parrot;
import beans.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProjectConfig {

    @Bean
    public Parrot parrot() {
        Parrot p = new Parrot();
        p.setName("KoKo");
        return p;
    }

    @Bean
    public Person person() {
        Person p = new Person();
        p.setName("Kimi");
        p.setParrot(parrot());
        return p;
    }
}

package main;

import Configuration.ProjectConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfiguration.class);
        Parrot p = context.getBean(Parrot.class);
        System.out.println(p.getName());
    }
}
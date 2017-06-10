package by.hector.spring;

import by.hector.spring.service.HeroService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author i.sukach
 */
public class Starter {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context
                = new ClassPathXmlApplicationContext("application-context.xml");
        HeroService heroService = context.getBean(HeroService.class);
        heroService.logDataToConsole();
    }
}

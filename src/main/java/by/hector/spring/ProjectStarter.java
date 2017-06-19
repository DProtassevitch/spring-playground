package by.hector.spring;

import by.hector.project.service.HeroService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author i.sukach
 */
public class ProjectStarter {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context
                = new ClassPathXmlApplicationContext();
        context.getEnvironment().setActiveProfiles("dev");
        context.setConfigLocation("project-application-context.xml");
        context.refresh();
        HeroService service = context.getBean(HeroService.class);
        service.printHeroNameById(1L);
    }
}

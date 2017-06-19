package by.hector.project.service;

import by.hector.project.annotation.InjectRandomGreeting;

import by.hector.project.dao.HeroDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * @author i.sukach
 */
@Service
public class HeroService {

    @InjectRandomGreeting
    private String greetingString;

    private HeroDao heroDao;

    public HeroService() {
        System.out.println("HeroService конструктор вызван");
        logData();
    }

    public void printHeroNameById(Long id) {
        String name = heroDao.getNameById(id);
        System.out.println(name);
    }

    @PostConstruct
    public void init() {
        System.out.println("HeroService инициализируется через @PostConstruct");
        logData();
    }

    @Autowired
    public void setHeroDao(HeroDao heroDao) {
        this.heroDao = heroDao;
    }

    private void logData() {
        System.out.println(greetingString);
        for (int i = 0; i < greetingString.length(); i++) {
            System.out.println("Логирую данные");
        }
    }
}

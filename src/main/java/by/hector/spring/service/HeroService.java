package by.hector.spring.service;

import by.hector.spring.dao.HeroDao;

/**
 * @author i.sukach
 */
public class HeroService {

    private HeroDao heroDao;

    public HeroService(HeroDao heroDao) {
        this.heroDao = heroDao;
    }

    public void logDataToConsole() {
        System.out.println(heroDao.getHeroName());
    }
}

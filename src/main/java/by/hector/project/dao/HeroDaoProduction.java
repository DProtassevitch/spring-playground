package by.hector.project.dao;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

/**
 * @author i.sukach
 */
@Repository
@Profile("prod")
public class HeroDaoProduction implements HeroDao {

    @Override
    public String getNameById(Long id) {
        return "Production hero";
    }
}

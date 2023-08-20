package pl.kurs.finaltest.config;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

@Configuration
public class QuerydslConfig {

    @PersistenceUnit
    private EntityManagerFactory entityManagerFactory;

    @Bean
    public JPAQueryFactory jpaQueryFactory(EntityManager entityManager) {
        return new JPAQueryFactory(entityManager);
    }

    @Bean
    public EntityManager entityManager() {
        return entityManagerFactory.createEntityManager();
    }
}

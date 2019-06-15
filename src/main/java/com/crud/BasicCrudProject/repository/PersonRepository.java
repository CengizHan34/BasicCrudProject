package com.crud.BasicCrudProject.repository;

import com.crud.BasicCrudProject.model.Person;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.concurrent.atomic.AtomicInteger;

@Transactional
@Repository
public class PersonRepository {

    @Autowired
    private EntityManager entityManager;

    private Session getSession() {
        return entityManager.unwrap(Session.class);
    }

    public void createPersons() {
        long startTime = System.currentTimeMillis();
        AtomicInteger counter = new AtomicInteger(0);
//        Person person = new Person("cengiz", "han", true);
        for (int i = 0; i < 50000; i++) {
            getSession().save(new Person("cengiz", "han", true));
            if (counter.get() % 40 == 0) {
                getSession().flush();
                getSession().clear();
            }
            counter.set(counter.get() + 1);

        }
        long endTime = System.currentTimeMillis();
        long estimatedTime = endTime - startTime; // Geçen süreyi milisaniye cinsinden elde ediyoruz
        double seconds = (double) estimatedTime / 1000; // saniyeye çevir
        System.out.println("++ " + seconds);
    }
}

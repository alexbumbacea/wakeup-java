package ro.bumbacea.alex.wakeup.services;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.springframework.orm.hibernate3.annotation.AnnotationSessionFactoryBean;
import org.springframework.stereotype.Service;
import ro.bumbacea.alex.wakeup.entities.Computer;
import java.util.ArrayList;
import java.util.List;

@Service
public class Manager {

    private SessionFactory hibernate;

    List<Computer> data = new ArrayList<Computer>();

    public Manager() {
    }

    public Manager(SessionFactory hibernate) {
        this.hibernate = hibernate;
    }


    public void add(Computer computer) {
        Session s = this.hibernate.openSession();
        Transaction tx = s.beginTransaction();
        s.persist(computer);
        tx.commit();
        s.close();
    }

    public List<Computer> getList() {
        Session session = this.hibernate.openSession();
        List<Computer> data = session.createQuery("from Computer").list();
        session.close();
        return data;
    }

    public void wakeUp(Computer computer) {

    }
}

package CatSalon.Dao.CatDao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import CatSalon.Model.Cat;

import org.hibernate.cfg.Configuration;
import java.util.List;
import java.util.UUID;

public class CatDaoImpl implements CatDao{
    private SessionFactory sessionFactory;

    public CatDaoImpl() {
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        sessionFactory = configuration.buildSessionFactory();
    }
    @Override
    public void save(Cat cat) {
        Session session = sessionFactory.getCurrentSession();
        session.save(cat);
    }

    @Override
    public void update(Cat cat) {
        Session session = sessionFactory.getCurrentSession();
        session.update(cat);
    }

    @Override
    public void delete(Cat cat) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(cat);
    }

    @Override
    public Cat findById(UUID id) {
         Session session = sessionFactory.getCurrentSession();
        return session.get(Cat.class, id);
    }

    @Override
    public List<Cat> findAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("SELECT c FROM Cat c", Cat.class).getResultList();
    }
}

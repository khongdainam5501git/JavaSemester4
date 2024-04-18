package CatSalon.Dao.OwnerDao;

import CatSalon.Model.Owner;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import java.util.List;
import java.util.UUID;

public class OwnerDaoImpl implements OwnerDao {

    private SessionFactory sessionFactory;

    public OwnerDaoImpl() {
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        sessionFactory = configuration.buildSessionFactory();
    }

    @Override
    public void save(Owner owner) {
        Session session = sessionFactory.getCurrentSession();
        session.save(owner);
    }

    @Override
    public void update(Owner owner) {
        Session session = sessionFactory.getCurrentSession();
        session.update(owner);
    }

    @Override
    public void delete(Owner owner) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(owner);
    }

    @Override
    public Owner findById(UUID id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Owner.class, id);
    }

    @Override
    public List<Owner> findAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("SELECT o FROM Owner o", Owner.class).getResultList();
    }

}
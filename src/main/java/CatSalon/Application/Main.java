//package CatSalon.Application;
//
//import CatSalon.Controller.CatController.CatController;
//import CatSalon.Controller.CatController.CatControllerImpl;
//import CatSalon.Controller.OwnerController.OwnerController;
//import CatSalon.Controller.OwnerController.OwnerControllerImpl;
//import CatSalon.Dao.CatDao.CatDao;
//import CatSalon.Dao.CatDao.CatDaoImpl;
//import CatSalon.Dao.OwnerDao.OwnerDao;
//import CatSalon.Dao.OwnerDao.OwnerDaoImpl;
//import CatSalon.Model.Cat;
//import CatSalon.Model.Owner;
//import org.hibernate.SessionFactory;
//import org.hibernate.
//
//
//import java.awt.*;
//import java.time.LocalDate;
//import java.util.List;
//
//public class Main {
//    public static void main(String[] args) {
//        // Create session factories for Hibernate
//        SessionFactory catSessionFactory = HibernateUtil.getSessionFactoryForCat();
//        SessionFactory ownerSessionFactory = HibernateUtil.getSessionFactoryForOwner();
//
//        // Create DAOs using the session factories
//        CatDao catDao = new CatDaoImpl(catSessionFactory);
//        OwnerDao ownerDao = new OwnerDaoImpl(ownerSessionFactory);
//
//        // Create controllers using the DAOs
//        CatController catController = new CatControllerImpl(catDao);
//        OwnerController ownerController = new OwnerControllerImpl(ownerDao);
//
//        // Create sample cat and owner
//        Cat cat = new Cat("Whiskers", LocalDate.of(2018, 1, 1), "Domestic Shorthair", Color.GRAY, "John Doe", null);
//        Owner owner = new Owner("Jane Doe", LocalDate.of(1980, 1, 1), "555-555-5555", null);
//
//        // Save the cat and owner
//        catController.createCat(cat);
//        ownerController.createOwner(owner);
//
//        // Add the cat to the owner's list of cats
//        owner.getCats().add(cat);
//        ownerController.updateOwner(owner);
//
//        // Print the owner's name and cat's name
//        System.out.println("Owner's name: " + owner.getName());
//        System.out.println("Cat's name: " + cat.getName());
//
//        // Find all cats and owners
//        List<Cat> cats = catController.findAllCats();
//        List<Owner> owners = ownerController.findAllOwners();
//
//        // Print the number of cats and owners
//        System.out.println("Number of cats: " + cats.size());
//        System.out.println("Number of owners: " + owners.size());
//
//        // Close the session factories
//        HibernateUtil.closeSessionFactory(catSessionFactory);
//        HibernateUtil.closeSessionFactory(ownerSessionFactory);
//    }
//}
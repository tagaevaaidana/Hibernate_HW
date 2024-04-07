package peaksoft.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import peaksoft.OneToMany.Company;
import peaksoft.OneToMany.Employee;
import peaksoft.oneToOne.Car;
import peaksoft.oneToOne.User;
import peaksoft.oneToOne.entity.Director;
import peaksoft.oneToOne.entity.School;

public class HibernateUtil {

    public static SessionFactory getSessionFactory(){
        return new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Company.class)
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Director.class)
                .addAnnotatedClass(School.class)
                .addAnnotatedClass(Car.class)
                .addAnnotatedClass(User.class)
                .buildSessionFactory();
    }
}

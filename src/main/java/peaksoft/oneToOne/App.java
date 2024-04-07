package peaksoft.oneToOne;
import org.hibernate.Session;
import peaksoft.oneToOne.entity.Director;
import peaksoft.oneToOne.entity.School;
import peaksoft.util.HibernateUtil;

import java.time.LocalDate;

import static peaksoft.util.HibernateUtil.getSessionFactory;

public class App {
    public static void main( String[] args ) {



        School school = new School();
        school.setName("Turusbekov");
        school.setLocation("Kochor - Ata");
        createSchool(school);




        Director director = new Director();
        director.setName("Aidana");
        director.setLastName("Tagaeva");
       director.setDateOfBirthday(LocalDate.of(1998,6,22));
       createDirector(director);




    }

    public static void createDirector(Director director){
        Session session = getSessionFactory().openSession();
        session.persist(director);
        session.getTransaction().commit();
        session.close();
    }

    public static void createSchool(School school){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.persist(school);
        session.getTransaction().commit();
        session.close();
    }


}

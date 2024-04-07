package peaksoft.oneToOne;

import org.hibernate.Session;
import peaksoft.OneToMany.Company;
import peaksoft.OneToMany.Employee;
import peaksoft.oneToOne.entity.Director;
import peaksoft.util.HibernateUtil;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static peaksoft.util.HibernateUtil.getSessionFactory;

public class Main {
    public static void main(String[] args) {
        Car car = new Car();
        car.setName("BMW");
        car.setModel("X5");
        car.setReleaseDate(LocalDate.of(2000,5,31));

        Car car1 = new Car();
        car1.setName("AUDI");
        car1.setModel("Q7");
        car1.setReleaseDate(LocalDate.of(2023,12,8));

        Car car2 = new Car();
        car2.setName("Porche");
        car2.setModel("Macan");
        car2.setReleaseDate(LocalDate.of(2024,2,29));

        User user = new User();
        user.setName("Aidana");
        user.setLastName("Tagaeva");
        user.setAge(25);

        createCar(car);

//        List<Car> cars = new ArrayList<>(List.of(car,car1,car2));
//        User user = getByIdCar(2L);

    }

    public static void createCar(Car car){
        Session session = getSessionFactory().openSession();
        session.persist(car);
        session.getTransaction().commit();
        session.close();
    }
    public Car deleteByIdCar(Long id){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
      Car car = session.get(Car.class,id);
      session.getTransaction().commit();
      session.close();
      return car;
    }
    public Car getByIdCar(Long id){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Car car = session.get(Car.class,id);
        session.getTransaction().commit();
        session.close();
        return car;
    }

    public  static void updateCar(Long id, Car car){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Car car1 = session.get(Car.class,id);
        car1.setName(car1.getName());
        car1.setModel(car1.getModel());
        car1.setReleaseDate(car1.getReleaseDate());
        session.getTransaction().commit();
        session.close();
    }

    public List<Car> getAll(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        List<Car> carList = session.createQuery("FROM Car",Car.class).getResultList();
        session.getTransaction().commit();
        session.close();
        return carList;
    }

    public static void createUser(User user){
        Session session = getSessionFactory().openSession();
        session.persist(user);
        session.getTransaction().commit();
        session.close();
    }

    public User deleteByIdUser(Long id){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
       User user = session.get(User.class,id);
        session.getTransaction().commit();
        session.close();
        return user;
    }
    public  static void updateUser(Long id, User user){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
       User user1 = session.get(User.class,id);
        user1.setName(user1.getName());
        user1.setLastName(user1.getLastName());
        user1.setAge(user1.getAge());
        session.getTransaction().commit();
        session.close();
    }
}

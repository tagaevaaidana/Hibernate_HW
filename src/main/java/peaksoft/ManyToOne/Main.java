package peaksoft.ManyToOne;

import org.hibernate.Session;
import peaksoft.OneToMany.Employee;
import peaksoft.util.HibernateUtil;

import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Pass pass = new Pass();
        pass.setNumber(12222);
        pass.setDate(LocalDate.now());
        pass.setItsTrue(true);

        Employee employee = new Employee();
        employee.setNameEmployee("Aidana");
        employee.setLastNameEmployee("Tagaeva");
        employee.setAge(LocalDate.of(1998,6,22));

        Employee employee1 = new Employee();
        employee1.setNameEmployee("Nur");
        employee1.setLastNameEmployee("Alex");
        employee1.setAge(LocalDate.of(1995,5,31));


    }
    public static void createPass(Pass pass){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.persist(pass);
        session.getTransaction();
        session.close();
    }
    public static void createEmployee(Employee employee){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.persist(employee);
        session.getTransaction();
        session.close();
    }

    public Employee getByIdEmployee(Long id){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Employee employee = session.get(Employee.class,id);
        session.getTransaction().commit();
        session.close();
        return employee;
    }

    public  static void updateEmployee(Long id, String nameEmployee, String lastNameEmployee, LocalDate age){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Employee employee1 = session.get(Employee.class, id);
        employee1.setNameEmployee(nameEmployee);
        employee1.setLastNameEmployee(lastNameEmployee);
        employee1.setAge(age);
        session.getTransaction().commit();
        session.close();
    }

    public List<Employee> getAll(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        List<Employee> employeeList = session.createQuery("FROM Employee",Employee.class).getResultList();
        session.getTransaction().commit();
        session.close();
        return employeeList;
    }
}

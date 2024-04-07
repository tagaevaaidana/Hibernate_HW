package peaksoft.OneToMany;

import org.hibernate.Session;
import peaksoft.util.HibernateUtil;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello");


        Company company = new Company();
        company.setName("Anex");
        company.setOwnerNameCompany("Topal");
        company.setLocation("Moscow");
        createCompany(company);

//        Employee employee = new Employee();
//        employee.setNameEmployee("Aidana");
//        employee.setLastNameEmployee("Tagaeva");
//        employee.setAge(LocalDate.of(1998,6,22));
//
//        Employee employee1 = new Employee();
//        employee1.setNameEmployee("Alex");
//        employee1.setLastNameEmployee("Max");
//        employee1.setAge(LocalDate.of(1993,12,31));
//
//        Employee employee2 = new Employee();
//        employee2.setNameEmployee("Ivan");
//        employee2.setLastNameEmployee("Pasha");
//        employee1.setAge(LocalDate.of(1995,1,27));


//        List<Employee> employeeList = new ArrayList<>(List.of(employee,employee2,employee1));
//        Company company1 = getByIdCompany(1L);
//        company1.setEmployee(employeeList);
//
//        employee1.setCompany(employee);
//        employee2.setCompany(employee2);
//        employee.setCompany(employee);
//
//        createCompany(employee);
//        createCompany(employee1);
//        createCompany(employee2);


    }

    public static void createCompany(Company company){
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.persist(company);
            session.getTransaction().commit();
            session.close();
        }
        public Company deleteByIdCompany(Long id){
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
        Company company = session.get(Company.class,id);
        session.getTransaction().commit();
        session.close();
        return company;
    }

    public Company getByIdCompany(Long id){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Company company = session.get(Company.class,id);
        session.getTransaction().commit();
        session.close();
        return company;
    }
    public  static void updateCompany(Long id, Company company){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Company company1 = session.get(Company.class,id);
        company1.setName(company.getName());
        company1.setOwnerNameCompany(company.getOwnerNameCompany());
        company1.setLocation(company.getLocation());
        session.getTransaction().commit();
        session.close();
    }


    public static void createEmployee(Employee employee){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.getTransaction();
        session.close();
    }

    public Employee deleteByIdEmployee(Long id){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
       Employee employee = session.get(Employee.class,id);
        session.getTransaction().commit();
        session.close();
        return employee;
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

package org.example.db;

import org.example.entity.Employee;
import org.hibernate.Session;
import org.example.until.HibernateUtil;
import org.hibernate.query.Query;

import java.util.List;

public class EmployeeDb {
    public static Employee create(Employee employee) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(employee);
        session.getTransaction().commit();
        session.close();
        return employee;
    }
    public static List<Employee> getAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Employee> employees = session.createQuery("From org.example.entity.Employee").list();
        session.close();
        return employees;
    }
    public  static Employee find (Integer id){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Employee employee = session.load(Employee.class, id);
        session.close();
        return employee;
    }
    public static Employee update(Employee employee) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Employee e = session.load(Employee.class, employee.getId());
        e.setId(employee.getId());
        e.setName(employee.getName());
        e.setAge(employee.getAge());
        session.getTransaction().commit();
        session.close();
        return e;
    }
    public static void delete (Integer id){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Employee e = find(id);
        session.delete(e);
        session.getTransaction().commit();
        session.close();
    }
    public static void deleteAll(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query query = session.createQuery("DELETE FROM org.example.entity.Employee");
        query.executeUpdate();
        session.getTransaction().commit();
        session.close();

    }
}

package com.studentAutomation.DataAcces;



import org.hibernate.query.Query;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.studentAutomation.Entities.Student;


public class StudentDal implements IDataAcces{
	
	private SessionFactory factory = new Configuration() 
				.configure()
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
	
	Student searchEntities;

	public StudentDal() {
	}

	public void add(Student entities) {
		Session session = factory.getCurrentSession();

		try {
			session.beginTransaction();
			session.saveOrUpdate(entities);
			session.getTransaction().commit();			
		}
		finally{
			session.close();
		}
	}

	public void delete(Student entities) {
		Session session = factory.getCurrentSession();
		try {
			session.beginTransaction();
			Student entitiesToDelete = session.get(Student.class, entities.getId());
			session.delete(entitiesToDelete);
			session.getTransaction().commit();
		}finally {
			session.close();
		}

	}

	public void update(Student entities) {
		Session session = factory.getCurrentSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(entities);
			session.getTransaction().commit();
		}finally {
			session.close();
		}
	}

	public Student searchByID(int id) {
		Session session = factory.getCurrentSession();
		try {
			session.beginTransaction();
			searchEntities = session.get(Student.class, id);
			session.getTransaction().commit();
		}finally {
			session.close();
		}
		return searchEntities;
	}
	
	public List<Student> searchByNo(int no) {
		Session session = factory.getCurrentSession();
		String hql = "select s from Student s where s.studentNo like :no";
		List<Student> resultList;
		try {
			session.beginTransaction();
			Query<Student> query = session.createQuery(hql, Student.class);
			query.setParameter("no", no);
			resultList = query.list();
			session.getTransaction().commit();
		}finally {
			session.close();
		}
		return resultList;
	}

}

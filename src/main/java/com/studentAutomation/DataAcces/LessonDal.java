package com.studentAutomation.DataAcces;



import org.hibernate.query.Query;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.studentAutomation.Entities.Lesson;


public class LessonDal implements IDataAccesLesson{
	
	private SessionFactory factory = new Configuration() 
				.configure()
				.addAnnotatedClass(Lesson.class)
				.buildSessionFactory();
	
	Lesson searchEntities;

	public LessonDal() {
	}

	public void add(Lesson entities) {
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

	public void delete(Lesson entities) {
		Session session = factory.getCurrentSession();
		try {
			session.beginTransaction();
			Lesson entitiesToDelete = session.get(Lesson.class, entities.getId());
			session.delete(entitiesToDelete);
			session.getTransaction().commit();
		}finally {
			session.close();
		}

	}

	public void update(Lesson entities) {
		Session session = factory.getCurrentSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(entities);
			session.getTransaction().commit();
		}finally {
			session.close();
		}
	}

	public Lesson searchByID(int id) {
		Session session = factory.getCurrentSession();
		try {
			session.beginTransaction();
			searchEntities = session.get(Lesson.class, id);
			session.getTransaction().commit();
		}finally {
			session.close();
		}
		return searchEntities;
	}
	
	public List<Lesson> searchByNo(int no) {
		Session session = factory.getCurrentSession();
		String hql = "select l from Lesson l where l.studentNo like :no";
		List<Lesson> resultList;
		try {
			session.beginTransaction();
			Query<Lesson> query = session.createQuery(hql, Lesson.class);
			query.setParameter("no", no);
			resultList = query.list();
			session.getTransaction().commit();
		}finally {
			session.close();
		}
		return resultList;
	}
}

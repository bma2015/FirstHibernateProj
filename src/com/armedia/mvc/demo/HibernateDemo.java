package com.armedia.mvc.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.armedia.mvc.dto.MyUser;

public class HibernateDemo {

	public static void main(String[] args) {
		MyUser user = new MyUser();
		user.setId(2);
		user.setName("Second user");

		try {
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			session.save(user);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

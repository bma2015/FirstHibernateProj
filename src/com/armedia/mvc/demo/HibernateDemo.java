package com.armedia.mvc.demo;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.armedia.mvc.dto.MyUser;

public class HibernateDemo {

	public static void main(String[] args) {
		MyUser user = new MyUser();
		user.setId(2);
		user.setName("Second user");
		user.setAddress("Second user's address");
		user.setJoinedDate(new Date());
		user.setDescription("Description of the user goes here");

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

package com.armedia.mvc.demo;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.armedia.mvc.dto.Address;
import com.armedia.mvc.dto.MyUser;

public class HibernateDemo {

	public static void main(String[] args) {
		MyUser user = new MyUser();
		MyUser user2 = new MyUser();

		Address addr = new Address();
		addr.setStreet("Street Name");
		addr.setCity("City Name");
		addr.setState("State Name");
		addr.setPincode("Pincode");
		
		Address addr2 = new Address();
		addr2.setStreet("Second Street Name");
		addr2.setCity("Second City Name");
		addr2.setState("Second State Name");
		addr2.setPincode("Second Pincode");
		
		user.getListOfAddresses().add(addr);
		user.getListOfAddresses().add(addr2);
		
		user.setName("First user");
		user.setHomeAddress(addr);
		user.setOfficeAddress(addr2);
		user.setJoinedDate(new Date());
		user.setDescription("Description of the user goes here");
		
		user2.setName("Second user");
		user2.setHomeAddress(addr);
		user2.setOfficeAddress(addr2);
		user2.setJoinedDate(new Date());
		user2.setDescription("Description of the user goes here");

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();

		try {
			session.beginTransaction();
			session.save(user);
			session.save(user2);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

//		user = null;
//		session = sessionFactory.openSession();
//
//		try {
//			session.beginTransaction();
//			user = (MyUser) session.get(MyUser.class, 2);
//			System.out.println("User name retrieved is " + user.getName());
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			session.close();
//		}
		
		user = null;
		session = sessionFactory.openSession();

		try {
			session.beginTransaction();
			user = (MyUser) session.get(MyUser.class, 1);
			System.out.println("User name retrieved is " + user.getListOfAddresses());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
}

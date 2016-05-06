package com.armedia.mvc.demo;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.armedia.mvc.dto.Address;
import com.armedia.mvc.dto.FourWheeler;
import com.armedia.mvc.dto.MyUser;
import com.armedia.mvc.dto.Permission;
import com.armedia.mvc.dto.TwoWheeler;
import com.armedia.mvc.dto.Vehicle;

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
		
		Vehicle vehicle = new Vehicle();
		vehicle.setName("Yacht");
		vehicle.setOwner(user);
		
		TwoWheeler vehicle2 = new TwoWheeler();
		vehicle2.setName("Schwinn");
		vehicle2.setOwner(user);
		vehicle2.setSteeringHandle("Schwinn Steering Handle");
		
		FourWheeler vehicle3 = new FourWheeler();
		vehicle3.setName("Jeep");
		vehicle3.setOwner(user2);
		vehicle3.setSteeringWheel("Jeep Steering Wheel");
		
		Permission perm = new Permission();
		perm.setName("collaborator");
		
		Permission perm2 = new Permission();
		perm2.setName("contributor");
		
		user.getListOfAddresses().add(addr);
		user.getListOfAddresses().add(addr2);
		
		user.setName("First user");
//		user.setHomeAddress(addr);
//		user.setOfficeAddress(addr2);
//		user.setVehicle(vehicle);
		user.getVehicles().add(vehicle);
		user.getVehicles().add(vehicle2);
		user.setJoinedDate(new Date());
		user.setDescription("Description of the user goes here");
		user.getPermissionList().add(perm);
		user.getPermissionList().add(perm2);
		
		user2.setName("Second user");
//		user2.setHomeAddress(addr);
//		user2.setOfficeAddress(addr2);
		user2.getVehicles().add(vehicle3);
		user2.setJoinedDate(new Date());
		user2.setDescription("Description of the user goes here");
		user2.getPermissionList().add(perm);
		user2.getPermissionList().add(perm2);

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();

		try {
			session.beginTransaction();
			session.persist(user);
			session.persist(user2);
			//session.save(vehicle);
			//session.save(vehicle2);
			//session.save(perm);
			//session.save(perm2);
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
			System.out.println("User address kust retrieved is " + user.getListOfAddresses());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		System.out.println(user.getListOfAddresses().size());
	}
}

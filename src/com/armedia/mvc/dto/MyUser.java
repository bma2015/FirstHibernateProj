package com.armedia.mvc.dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity
@Table(name = "MY_USER")
public class MyUser {

	// @EmbeddedId
	// private LoginName userId;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_id")
	private Integer id;

	// @Transient // Ignore field
	private String name;

	@ElementCollection(fetch = FetchType.EAGER)
	@JoinTable(name = "user_address", joinColumns = @JoinColumn(name = "user_id") )
	@GenericGenerator(name = "hilo-gen", strategy = "hilo")
	@CollectionId(columns = { @Column(name = "address_id") }, generator = "hilo-gen", type = @Type(type = "long") )
	private Collection<Address> listOfAddresses = new ArrayList<Address>();

	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "user_vehicle", joinColumns = @JoinColumn(name = "user_id") , inverseJoinColumns = @JoinColumn(name = "vehicle_id") )
	private Collection<Vehicle> vehicles = new ArrayList<Vehicle>();

	// @OneToOne
	// @JoinColumn(name = "vehicle_id")
	// private Vehicle vehicle;

	@Temporal(TemporalType.DATE)
	private Date joinedDate;

	// @Basic
	// @Embedded
	// @AttributeOverrides({ @AttributeOverride(name = "street", column =
	// @Column(name = "home_street_name") ),
	// @AttributeOverride(name = "city", column = @Column(name =
	// "home_city_name") ),
	// @AttributeOverride(name = "state", column = @Column(name =
	// "home_state_name") ),
	// @AttributeOverride(name = "pincode", column = @Column(name =
	// "home_pin_code") ) })
	// private Address homeAddress;

	// @Embedded
	// @AttributeOverrides({ @AttributeOverride(name = "street", column =
	// @Column(name = "office_street_name") ),
	// @AttributeOverride(name = "city", column = @Column(name =
	// "office_city_name") ),
	// @AttributeOverride(name = "state", column = @Column(name =
	// "office_state_name") ),
	// @AttributeOverride(name = "pincode", column = @Column(name =
	// "office_pin_code") ) })
	// private Address officeAddress;

	@Lob // Large object
	private String description;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "user_permission", joinColumns = @JoinColumn(name = "user_id") , inverseJoinColumns = @JoinColumn(name = "permission_id") )
	private Collection<Permission> permissionList = new ArrayList<Permission>();

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the listOfAddresses
	 */
	public Collection<Address> getListOfAddresses() {
		return listOfAddresses;
	}

	/**
	 * @param listOfAddresses
	 *            the listOfAddresses to set
	 */
	public void setListOfAddresses(Collection<Address> listOfAddresses) {
		this.listOfAddresses = listOfAddresses;
	}

	/**
	 * @return the vehicles
	 */
	public Collection<Vehicle> getVehicles() {
		return vehicles;
	}

	/**
	 * @param vehicles
	 *            the vehicles to set
	 */
	public void setVehicles(Collection<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}

	/**
	 * @return the vehicle
	 */
	// public Vehicle getVehicle() {
	// return vehicle;
	// }

	/**
	 * @param vehicle
	 *            the vehicle to set
	 */
	// public void setVehicle(Vehicle vehicle) {
	// this.vehicle = vehicle;
	// }

	/**
	 * @return the joinedDate
	 */
	public Date getJoinedDate() {
		return joinedDate;
	}

	/**
	 * @param joinedDate
	 *            the joinedDate to set
	 */
	public void setJoinedDate(Date joinedDate) {
		this.joinedDate = joinedDate;
	}

	/**
	 * @return the homeAddress
	 */
	// public Address getHomeAddress() {
	// return homeAddress;
	// }

	/**
	 * @param homeAddress
	 *            the homeAddress to set
	 */
	// public void setHomeAddress(Address homeAddress) {
	// this.homeAddress = homeAddress;
	// }

	/**
	 * @return the officeAddress
	 */
	// public Address getOfficeAddress() {
	// return officeAddress;
	// }

	/**
	 * @param officeAddress
	 *            the officeAddress to set
	 */
	// public void setOfficeAddress(Address officeAddress) {
	// this.officeAddress = officeAddress;
	// }

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the permissionList
	 */
	public Collection<Permission> getPermissionList() {
		return permissionList;
	}

	/**
	 * @param permissionList
	 *            the permissionList to set
	 */
	public void setPermissionList(Collection<Permission> permissionList) {
		this.permissionList = permissionList;
	}
}

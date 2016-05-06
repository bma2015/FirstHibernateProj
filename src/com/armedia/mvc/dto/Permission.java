package com.armedia.mvc.dto;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Permission {
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	
	@ManyToMany (mappedBy="permissionList")
	private Collection<MyUser> memberList = new ArrayList<MyUser>();
	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the memberList
	 */
	public Collection<MyUser> getMemberList() {
		return memberList;
	}
	/**
	 * @param memberList the memberList to set
	 */
	public void setMemberList(Collection<MyUser> memberList) {
		this.memberList = memberList;
	}
}

package com.cxc.ms.service.mvc.ret;

import java.util.LinkedList;
import java.util.List;

import com.cxc.ms.service.mvc.model.Organization;

public class Organizations {

	private List<Organization> school = new LinkedList<>();
	private List<Organization> company = new LinkedList<>();
	private List<Organization> mechanism = new LinkedList<>();
	private List<Organization> organization = new LinkedList<>();
	public List<Organization> getSchool() {
		return school;
	}
	public void setSchool(List<Organization> school) {
		this.school = school;
	}
	public List<Organization> getCompany() {
		return company;
	}
	public void setCompany(List<Organization> company) {
		this.company = company;
	}
	public List<Organization> getMechanism() {
		return mechanism;
	}
	public void setMechanism(List<Organization> mechanism) {
		this.mechanism = mechanism;
	}
	public List<Organization> getOrganization() {
		return organization;
	}
	public void setOrganization(List<Organization> organization) {
		this.organization = organization;
	}
}

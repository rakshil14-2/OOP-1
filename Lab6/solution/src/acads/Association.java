package acads;

import extracurriculars.Organization;

public class Association implements java.lang.Comparable<Association>, IAssociation, Organization{
	private java.lang.String name;

	private java.lang.String prez;

	private int memberCount;

	private int budget;

	private static final int MAX_NO_OF_MEMBERS = 1000;
	
	public Association(String name, String prez, int memberCount) {
		this.name = name;
		this.prez = prez;
		this.memberCount = memberCount;
		this.budget = 0;
	}
	
	public java.lang.String getName(){
		return this.name;
	}

	public java.lang.String getPrez(){
		return this.prez;
	}

	public int getMemberCount() {
		return this.memberCount;
	}
	

	@Override
	public int calculateBudget() {
		this.budget = IAssociation.BASE_BUDGET + this.calculateProjectBudget();
		return this.budget;
	}

	
	@Override
	public boolean addNewMember() {
		if(this.memberCount < MAX_NO_OF_MEMBERS) {
			this.memberCount++;
			return true;
		}
		return false;
	}

	@Override
	public int calculateProjectBudget() {
		return 3000*this.memberCount;
	}
	
	public int extraBudget() {
		return IAssociation.BASE_BUDGET - Organization.BASE_BUDGET;
	}

	@Override
	public int compareTo(Association assoc) {
		if(this.memberCount == assoc.memberCount) {
			return 0;
		}
		if(this.memberCount > assoc.memberCount) {
			return 1;
		}
		return -1;
	}
	
}

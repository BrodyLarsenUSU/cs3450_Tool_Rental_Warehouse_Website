package com.softwareEngineering.Spring.Models;

import java.util.ArrayList;

import org.springframework.data.annotation.Id;

public class Customer{
		@Id 
		public String id;

		private String firstName;
		private String lastName;
		private int age;
		private boolean active;
		private boolean employee;
		private String gender;
		private String password;
		private String username;
		private ArrayList<String> checkedOutTools;
		private ArrayList<String> reservedTools;
		private ArrayList<ToolContainer> containedCheckoutTools;

		public Customer(){
			//firstName = "";
			//lastName = "";
			//age = 0;
			//active = false;
			//employee = false;
			//gender = "";
			checkedOutTools = new ArrayList<>();
			reservedTools = new ArrayList<>();
			containedCheckoutTools = new ArrayList<>();
		}

		public Customer(String fn, String ln, int ag, boolean ac, boolean e, String g, String p, String u){
			firstName = fn;
			lastName = ln;
			age = ag;
			active = ac;
			employee = e;
			gender = g;
			password = p;
			username = u;
			checkedOutTools = new ArrayList<>();
			reservedTools = new ArrayList<>();
		}

		public void addToolToReserve(String id){
			reservedTools.add(id);
		}

		public void addToolsToCheckedOut(ArrayList<String> ids){
			checkedOutTools.addAll(ids);
			reservedTools.removeAll(ids);
		}


		public void addToolsToCheckedOut(ArrayList<String> ids, ArrayList<Tool> tools){
			ArrayList<ToolContainer> temp = new ArrayList<>();
			for(Tool id : tools){
				temp.add(new ToolContainer(id));
			}
			checkedOutTools.addAll(ids);
			containedCheckoutTools.addAll(temp);
			reservedTools.removeAll(ids);
		}

		public void removeReservation(String id) {
			reservedTools.remove(id);
			System.out.println("Removing " + id + " from Reserve");
		}

		public void removeToolCheckout(String id){
			checkedOutTools.remove(id);
			for(ToolContainer i : containedCheckoutTools){
				if(i.getToolId().compareTo(id) == 0){
					containedCheckoutTools.remove(i);
					if(containedCheckoutTools.size() == 0){
						return;
					}
					return;
				}
			}
		}





		//Getters and Setters

		public ArrayList<ToolContainer> getContainedCheckoutTools() {
			return this.containedCheckoutTools;
		}

		public void setContainedCheckoutTools(ArrayList<ToolContainer> containedCheckoutTools) {
			this.containedCheckoutTools = containedCheckoutTools;
		}

		public ArrayList<String> getCheckedOutTools() {
			return this.checkedOutTools;
		}

		public void setCheckedOutTools(ArrayList<String> checkedOutTools) {
			this.checkedOutTools = checkedOutTools;
		}

		public ArrayList<String> getReservedTools() {
			return this.reservedTools;
		}

		public void setReservedTools(ArrayList<String> reservedTools) {
			this.reservedTools = reservedTools;
		}

		public String getUsername() {
			return this.username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getPassword(){
			return password;
		}

		public void setPassword(String password){
			this.password = password;
		}

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}

		public boolean isActive() {
			return active;
		}

		public void setActive(boolean active) {
			this.active = active;
		}

		public boolean isEmployee() {
			return employee;
		}

		public void setEmployee(boolean employee) {
			this.employee = employee;
		}

		public String getGender() {
			return gender;
		}

		public void setGender(String gender) {
			this.gender = gender;
		}

		public String toString(){
			return firstName + " " + lastName;
		}

}

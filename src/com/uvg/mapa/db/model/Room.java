package com.uvg.mapa.db.model;

public class Room {
	
	private int id;
	private String code, department, purpose;
	private Catedratico[] catedraticos;
	
	public Room(int id, String code, String department, String purpose){
		this.id = id;
		this.code = code;
		this.department = department;
		this.purpose = purpose;
		
		catedraticos = null;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getPurpose() {
		return purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	public Catedratico[] getCatedraticos() {
		return catedraticos;
	}

	public void setCatedraticos(Catedratico[] catedraticos) {
		this.catedraticos = catedraticos;
	}
}

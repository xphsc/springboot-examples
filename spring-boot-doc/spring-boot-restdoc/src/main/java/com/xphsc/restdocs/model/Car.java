package com.xphsc.restdocs.model;

import java.util.Date;




import com.fasterxml.jackson.annotation.JsonProperty;



public class Car {
	

	private Long id;
	
	@JsonProperty("id_car")

	private Long idCar;
	
	@JsonProperty("id_user")

	private Long idUser;
	
	@JsonProperty("brand")

	private String brand;
	
	@JsonProperty("model")

	private String model;
	
	@JsonProperty("is_default")

	private Boolean isDefault = true;
	
	@JsonProperty("created_at")

	private Date createdAt;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdCar() {
		return idCar;
	}

	public void setIdCar(Long idCar) {
		this.idCar = idCar;
	}

	public Long getIdUser() {
		return idUser;
	}

	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Boolean getIsDefault() {
		return isDefault;
	}

	public void setIsDefault(Boolean isDefault) {
		this.isDefault = isDefault;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	
}

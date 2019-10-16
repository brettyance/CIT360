package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="automobile")
public class Automobile {

	@Id
	@Column(name="VIN")
	private String vin;
	
	@Column(name="year")
	private int year;
	
	@Column(name="make")
	private String make;
	
	@Column(name="model")
	private String model;
	
	@Column(name="body")
	private String body;
	
	@Column(name="color")
	private String color;
	
	public Automobile() {
		
	}

	public Automobile(String vin, int year, String make, String model, String body, String color) {
		super();
		this.vin = vin;
		this.year = year;
		this.make = make;
		this.model = model;
		this.body = body;
		this.color = color;
	}

	public String getVin() {
		return vin;
	}

	public void setVin(String vin) {
		this.vin = vin;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return "Automobile [vin=" + vin + ", year=" + year + ", make=" + make + ", model=" + model + ", body=" + body
				+ ", color=" + color + "]";
	}
	
	
	
}

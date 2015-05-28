package Model;

import java.sql.Timestamp;

/**
 * Customer entity. @author MyEclipse Persistence Tools
 */

public class Customer implements java.io.Serializable {

	// Fields

	private String customerlId;
	private Parking parking;
	private String name;
	private String phoneNum;
	private Timestamp arrivalTime;
	private Double depositCash;

	// Constructors

	/** default constructor */
	public Customer() {
	}

	/** full constructor */
	public Customer(String customerlId, Parking parking, String name,
			String phoneNum, Timestamp arrivalTime, Double depositCash) {
		this.customerlId = customerlId;
		this.parking = parking;
		this.name = name;
		this.phoneNum = phoneNum;
		this.arrivalTime = arrivalTime;
		this.depositCash = depositCash;
	}

	// Property accessors

	public String getCustomerlId() {
		return this.customerlId;
	}

	public void setCustomerlId(String customerlId) {
		this.customerlId = customerlId;
	}

	public Parking getParking() {
		return this.parking;
	}

	public void setParking(Parking parking) {
		this.parking = parking;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNum() {
		return this.phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public Timestamp getArrivalTime() {
		return this.arrivalTime;
	}

	public void setArrivalTime(Timestamp arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public Double getDepositCash() {
		return this.depositCash;
	}

	public void setDepositCash(Double depositCash) {
		this.depositCash = depositCash;
	}

}
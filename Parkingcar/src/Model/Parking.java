package Model;

import java.util.HashSet;
import java.util.Set;

/**
 * Parking entity. @author MyEclipse Persistence Tools
 */

public class Parking implements java.io.Serializable {

	// Fields

	private String parkingId;
	private String parkingType;
	private String parkingStatus;
	private String parkingTel;
	private Parkingtotal parkingtotal;
	private Set customers = new HashSet(0);
	private Set books = new HashSet(0);

	// Constructors

	/** default constructor */
	public Parking() {
	}

	/** minimal constructor */
	public Parking(String parkingId, String parkingType, String parkingStatus,
			String parkingTel) {
		this.parkingId = parkingId;
		this.parkingType = parkingType;
		this.parkingStatus = parkingStatus;
		this.parkingTel = parkingTel;
	}

	/** full constructor */
	public Parking(String parkingId, String parkingType, String parkingStatus,
			String parkingTel, Parkingtotal parkingtotal, Set customers,
			Set books) {
		this.parkingId = parkingId;
		this.parkingType = parkingType;
		this.parkingStatus = parkingStatus;
		this.parkingTel = parkingTel;
		this.parkingtotal = parkingtotal;
		this.customers = customers;
		this.books = books;
	}

	// Property accessors

	public String getParkingId() {
		return this.parkingId;
	}

	public void setParkingId(String parkingId) {
		this.parkingId = parkingId;
	}

	public String getParkingType() {
		return this.parkingType;
	}

	public void setParkingType(String parkingType) {
		this.parkingType = parkingType;
	}

	public String getParkingStatus() {
		return this.parkingStatus;
	}

	public void setParkingStatus(String parkingStatus) {
		this.parkingStatus = parkingStatus;
	}

	public String getParkingTel() {
		return this.parkingTel;
	}

	public void setParkingTel(String parkingTel) {
		this.parkingTel = parkingTel;
	}

	public Parkingtotal getParkingtotal() {
		return this.parkingtotal;
	}

	public void setParkingtotal(Parkingtotal parkingtotal) {
		this.parkingtotal = parkingtotal;
	}

	public Set getCustomers() {
		return this.customers;
	}

	public void setCustomers(Set customers) {
		this.customers = customers;
	}

	public Set getBooks() {
		return this.books;
	}

	public void setBooks(Set books) {
		this.books = books;
	}

}
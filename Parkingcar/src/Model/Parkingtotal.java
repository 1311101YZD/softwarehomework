package Model;

/**
 * Parkingtotal entity. @author MyEclipse Persistence Tools
 */

public class Parkingtotal implements java.io.Serializable {

	// Fields

	private String parkingType;
	private Parking parking;
	private String parkingCount;

	// Constructors

	/** default constructor */
	public Parkingtotal() {
	}

	/** full constructor */
	public Parkingtotal(String parkingType, Parking parking, String parkingCount) {
		this.parkingType = parkingType;
		this.parking = parking;
		this.parkingCount = parkingCount;
	}

	// Property accessors

	public String getParkingType() {
		return this.parkingType;
	}

	public void setParkingType(String parkingType) {
		this.parkingType = parkingType;
	}

	public Parking getParking() {
		return this.parking;
	}

	public void setParking(Parking parking) {
		this.parking = parking;
	}

	public String getParkingCount() {
		return this.parkingCount;
	}

	public void setParkingCount(String parkingCount) {
		this.parkingCount = parkingCount;
	}

}
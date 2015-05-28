package Model;

import java.sql.Timestamp;

/**
 * Book entity. @author MyEclipse Persistence Tools
 */

public class Book implements java.io.Serializable {

	// Fields

	private Integer no;
	private Parking parking;
	private String bookName;
	private Timestamp arTime;
	private String phoneNum;

	// Constructors

	/** default constructor */
	public Book() {
	}

	/** full constructor */
	public Book(Parking parking, String bookName, Timestamp arTime,
			String phoneNum) {
		this.parking = parking;
		this.bookName = bookName;
		this.arTime = arTime;
		this.phoneNum = phoneNum;
	}

	// Property accessors

	public Integer getNo() {
		return this.no;
	}

	public void setNo(Integer no) {
		this.no = no;
	}

	public Parking getParking() {
		return this.parking;
	}

	public void setParking(Parking parking) {
		this.parking = parking;
	}

	public String getBookName() {
		return this.bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public Timestamp getArTime() {
		return this.arTime;
	}

	public void setArTime(Timestamp arTime) {
		this.arTime = arTime;
	}

	public String getPhoneNum() {
		return this.phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

}
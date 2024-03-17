package project.cmm.myccm.core.model.xml;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "document")
@XmlAccessorType(XmlAccessType.FIELD)
public class Document {
	
	@XmlElement(required = false)
	private Customer seller;
	@XmlElement(required = false)
	private Customer customer;
	@XmlElement(required = false)
	private Vehicle vehicle;
	@XmlElement(required = false)
	private String City;
	@XmlElement(required = false)
	private String Date;

	/**
	 * Constructor.
	 *
	 */
	public Document() {
		super();
	}

	

	/**
	 * Constructor.
	 *
	 * @param seller
	 * @param customer
	 * @param vehicle
	 * @param city
	 * @param date
	 */
	public Document(Customer seller, Customer customer, Vehicle vehicle, String city, String date) {
		super();
		this.seller = seller;
		this.customer = customer;
		this.vehicle = vehicle;
		City = city;
		Date = date;
	}


	

	/**
	 * Getter.
	 *
	 * @return the seller
	 */
	public Customer getSeller() {
		return seller;
	}



	/**
	 * Setter.
	 *
	 * @param seller the seller to set
	 */
	public void setSeller(Customer seller) {
		this.seller = seller;
	}



	/**
	 * Getter.
	 *
	 * @return the customer
	 */
	public Customer getCustomer() {
		return customer;
	}

	/**
	 * Setter.
	 *
	 * @param customer the customer to set
	 */
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	/**
	 * Getter.
	 *
	 * @return the vehicle
	 */
	public Vehicle getVehicle() {
		return vehicle;
	}

	/**
	 * Setter.
	 *
	 * @param vehicle the vehicle to set
	 */
	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	/**
	 * Getter.
	 *
	 * @return the city
	 */
	public String getCity() {
		return City;
	}

	/**
	 * Setter.
	 *
	 * @param city the city to set
	 */
	public void setCity(String city) {
		City = city;
	}

	/**
	 * Getter.
	 *
	 * @return the date
	 */
	public String getDate() {
		return Date;
	}

	/**
	 * Setter.
	 *
	 * @param date the date to set
	 */
	public void setDate(String date) {
		Date = date;
	}

}

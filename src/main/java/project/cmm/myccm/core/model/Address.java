package project.cmm.myccm.core.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Address {

	@Id
	@SequenceGenerator(name = "seqAddressID", initialValue = 1, allocationSize = 100)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqAddressID")
	@Column(name = "address_id")
	private long addressId;
	@Column(nullable = false)
	private String streetName;
	@Column(nullable = false)
	private String streetNumber;
	@Column(nullable = false)
	private String zip;
	@Column(nullable = false)
	private String city;
	private String country;
	private String tel;
	private String email;
	private String website;
	@ManyToOne
	@JoinColumn(name = "company_id", nullable = false)
	private Company company;

	/**
	 * Constructor.
	 *
	 * @param addressId
	 * @param streetName
	 * @param streetNumber
	 * @param zip
	 * @param city
	 * @param country
	 * @param tel
	 * @param email
	 * @param website
	 * @param company
	 */
	public Address(long addressId, String streetName, String streetNumber, String zip, String city, String country,
			String tel, String email, String website, Company company) {
		super();
		this.addressId = addressId;
		this.streetName = streetName;
		this.streetNumber = streetNumber;
		this.zip = zip;
		this.city = city;
		this.country = country;
		this.tel = tel;
		this.email = email;
		this.website = website;
		this.company = company;
	}

	/**
	 * Getter.
	 *
	 * @return the addressId
	 */
	public long getAddressId() {
		return addressId;
	}

	/**
	 * Setter.
	 *
	 * @param addressId the addressId to set
	 */
	public void setAddressId(long addressId) {
		this.addressId = addressId;
	}

	/**
	 * Getter.
	 *
	 * @return the streetName
	 */
	public String getStreetName() {
		return streetName;
	}

	/**
	 * Setter.
	 *
	 * @param streetName the streetName to set
	 */
	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	/**
	 * Getter.
	 *
	 * @return the streetNumber
	 */
	public String getStreetNumber() {
		return streetNumber;
	}

	/**
	 * Setter.
	 *
	 * @param streetNumber the streetNumber to set
	 */
	public void setStreetNumber(String streetNumber) {
		this.streetNumber = streetNumber;
	}

	/**
	 * Getter.
	 *
	 * @return the zip
	 */
	public String getZip() {
		return zip;
	}

	/**
	 * Setter.
	 *
	 * @param zip the zip to set
	 */
	public void setZip(String zip) {
		this.zip = zip;
	}

	/**
	 * Getter.
	 *
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * Setter.
	 *
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * Getter.
	 *
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * Setter.
	 *
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * Getter.
	 *
	 * @return the tel
	 */
	public String getTel() {
		return tel;
	}

	/**
	 * Setter.
	 *
	 * @param tel the tel to set
	 */
	public void setTel(String tel) {
		this.tel = tel;
	}

	/**
	 * Getter.
	 *
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Setter.
	 *
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Getter.
	 *
	 * @return the website
	 */
	public String getWebsite() {
		return website;
	}

	/**
	 * Setter.
	 *
	 * @param website the website to set
	 */
	public void setWebsite(String website) {
		this.website = website;
	}

	/**
	 * Getter.
	 *
	 * @return the company
	 */
	public Company getCompany() {
		return company;
	}

	/**
	 * Setter.
	 *
	 * @param company the company to set
	 */
	public void setCompany(Company company) {
		this.company = company;
	}

}

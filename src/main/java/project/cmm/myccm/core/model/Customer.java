package project.cmm.myccm.core.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Customer {

	@Id
	@SequenceGenerator(name = "seqCustomerID", initialValue = 1, allocationSize = 100)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqCustomerID")
	@Column(name = "customer_id")
	private long customerId;
	@Column(nullable = false)
	private String firstName;
	@Column(nullable = false)
	private String lastName;
	private String birthday;
	private String streetName;
	private String streetNumber;
	private String zip;
	private String city;
	private String country;
	private String tel;
	private String email;

	@ManyToOne
	@JoinColumn(name = "company_id", nullable = false)
	private Company company;

	@OneToMany(mappedBy = "customer")
	private List<Document> documents = new ArrayList<>(1);

	/**
	 * Constructor.
	 *
	 */
	public Customer() {
		super();
	}

	/**
	 * Constructor.
	 *
	 * @param customerId
	 * @param firstName
	 * @param lastName
	 * @param birthday
	 * @param streetName
	 * @param streetNumber
	 * @param zip
	 * @param city
	 * @param country
	 * @param tel
	 * @param email
	 * @param company
	 * @param documents
	 */
	public Customer(long customerId, String firstName, String lastName, String birthday, String streetName,
			String streetNumber, String zip, String city, String country, String tel, String email, Company company,
			List<Document> documents) {
		super();
		this.customerId = customerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthday = birthday;
		this.streetName = streetName;
		this.streetNumber = streetNumber;
		this.zip = zip;
		this.city = city;
		this.country = country;
		this.tel = tel;
		this.email = email;
		this.company = company;
		this.documents = documents;
	}

	/**
	 * Getter.
	 *
	 * @return the customerId
	 */
	public long getCustomerId() {
		return customerId;
	}

	/**
	 * Setter.
	 *
	 * @param customerId the customerId to set
	 */
	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	/**
	 * Getter.
	 *
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Setter.
	 *
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Getter.
	 *
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Setter.
	 *
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Getter.
	 *
	 * @return the birthday
	 */
	public String getBirthday() {
		return birthday;
	}

	/**
	 * Setter.
	 *
	 * @param birthday the birthday to set
	 */
	public void setBirthday(String birthday) {
		this.birthday = birthday;
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

	/**
	 * Getter.
	 *
	 * @return the documents
	 */
	public List<Document> getDocuments() {
		return documents;
	}

	/**
	 * Setter.
	 *
	 * @param documents the documents to set
	 */
	public void setDocuments(List<Document> documents) {
		this.documents = documents;
	}

}

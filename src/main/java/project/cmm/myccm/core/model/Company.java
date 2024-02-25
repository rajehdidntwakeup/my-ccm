package project.cmm.myccm.core.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Company {

	@Id
	@SequenceGenerator(name = "seqCompanyID", initialValue = 1, allocationSize = 100)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqCompanyID")
	@Column(name = "company_id")
	private long companyId;
	@Column(nullable = false)
	private String name;

	@OneToMany(mappedBy = "company", cascade = CascadeType.REMOVE)
	private List<Address> addresses = new ArrayList<>(1);

	@OneToMany(mappedBy = "company", cascade = CascadeType.REMOVE)
	private List<Logo> logos = new ArrayList<>(1);

	@OneToMany(mappedBy = "company", cascade = CascadeType.REMOVE)
	private List<DocumentFormat> documentFormats = new ArrayList<>(1);

	@OneToMany(mappedBy = "company", cascade = CascadeType.REMOVE)
	private List<Customer> customers = new ArrayList<>(1);

	@OneToMany(mappedBy = "company", cascade = CascadeType.REMOVE)
	private List<Vehicle> vehicles = new ArrayList<>(1);

	/**
	 * Constructor.
	 *
	 * @param companyId
	 * @param name
	 * @param addresses
	 * @param logos
	 * @param documentFormats
	 * @param customers
	 * @param vehicles
	 */
	public Company(long companyId, String name, List<Address> addresses, List<Logo> logos,
			List<DocumentFormat> documentFormats, List<Customer> customers, List<Vehicle> vehicles) {
		super();
		this.companyId = companyId;
		this.name = name;
		this.addresses = addresses;
		this.logos = logos;
		this.documentFormats = documentFormats;
		this.customers = customers;
		this.vehicles = vehicles;
	}

	/**
	 * Getter.
	 *
	 * @return the companyId
	 */
	public long getCompanyId() {
		return companyId;
	}

	/**
	 * Setter.
	 *
	 * @param companyId the companyId to set
	 */
	public void setCompanyId(long companyId) {
		this.companyId = companyId;
	}

	/**
	 * Getter.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Setter.
	 *
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Getter.
	 *
	 * @return the addresses
	 */
	public List<Address> getAddresses() {
		return addresses;
	}

	/**
	 * Setter.
	 *
	 * @param addresses the addresses to set
	 */
	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	/**
	 * Getter.
	 *
	 * @return the logos
	 */
	public List<Logo> getLogos() {
		return logos;
	}

	/**
	 * Setter.
	 *
	 * @param logos the logos to set
	 */
	public void setLogos(List<Logo> logos) {
		this.logos = logos;
	}

	/**
	 * Getter.
	 *
	 * @return the documentFormats
	 */
	public List<DocumentFormat> getDocumentFormats() {
		return documentFormats;
	}

	/**
	 * Setter.
	 *
	 * @param documentFormats the documentFormats to set
	 */
	public void setDocumentFormats(List<DocumentFormat> documentFormats) {
		this.documentFormats = documentFormats;
	}

	/**
	 * Getter.
	 *
	 * @return the customers
	 */
	public List<Customer> getCustomers() {
		return customers;
	}

	/**
	 * Setter.
	 *
	 * @param customers the customers to set
	 */
	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}

	/**
	 * Getter.
	 *
	 * @return the vehicles
	 */
	public List<Vehicle> getVehicles() {
		return vehicles;
	}

	/**
	 * Setter.
	 *
	 * @param vehicles the vehicles to set
	 */
	public void setVehicles(List<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}

}

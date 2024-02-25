package project.cmm.myccm.core.model;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Document {

	@Id
	@SequenceGenerator(name = "seqDocumentID", initialValue = 1, allocationSize = 100)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqDocumentID")
	private long documentId;
	@Column(nullable = false)
	private Timestamp timestamp;
	@Column(nullable = false)
	private String City;
	@Enumerated(EnumType.STRING)
	private DocumentStatus documentStatus = DocumentStatus.DRAFT;

	@ManyToOne
	@JoinColumn(name = "customer_id", nullable = false)
	private Customer customer;

	@ManyToOne
	@JoinColumn(name = "doc_format_id", nullable = false)
	private DocumentFormat documentFormat;

	@ManyToOne
	@JoinColumn(name = "vehicle_id", nullable = false)
	private Vehicle vehicle;

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
	 * @param documentId
	 * @param timestamp
	 * @param city
	 * @param documentStatus
	 * @param customer
	 * @param documentFormat
	 * @param vehicle
	 */
	public Document(long documentId, Timestamp timestamp, String city, DocumentStatus documentStatus, Customer customer,
			DocumentFormat documentFormat, Vehicle vehicle) {
		super();
		this.documentId = documentId;
		this.timestamp = timestamp;
		City = city;
		this.documentStatus = documentStatus;
		this.customer = customer;
		this.documentFormat = documentFormat;
		this.vehicle = vehicle;
	}

	/**
	 * Getter.
	 *
	 * @return the documentId
	 */
	public long getDocumentId() {
		return documentId;
	}

	/**
	 * Setter.
	 *
	 * @param documentId the documentId to set
	 */
	public void setDocumentId(long documentId) {
		this.documentId = documentId;
	}

	/**
	 * Getter.
	 *
	 * @return the timestamp
	 */
	public Timestamp getTimestamp() {
		return timestamp;
	}

	/**
	 * Setter.
	 *
	 * @param timestamp the timestamp to set
	 */
	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
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
	 * @return the documentStatus
	 */
	public DocumentStatus getDocumentStatus() {
		return documentStatus;
	}

	/**
	 * Setter.
	 *
	 * @param documentStatus the documentStatus to set
	 */
	public void setDocumentStatus(DocumentStatus documentStatus) {
		this.documentStatus = documentStatus;
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
	 * @return the documentFormat
	 */
	public DocumentFormat getDocumentFormat() {
		return documentFormat;
	}

	/**
	 * Setter.
	 *
	 * @param documentFormat the documentFormat to set
	 */
	public void setDocumentFormat(DocumentFormat documentFormat) {
		this.documentFormat = documentFormat;
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

}

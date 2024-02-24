package project.cmm.myccm.core.model;

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
public class Logo {

	@Id
	@SequenceGenerator(name = "seqLogoID", initialValue = 1, allocationSize = 100)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqLogoID")
	@Column(name = "logo_id")
	private long logoId;
	@Column(nullable = false)
	private String logoName;
	@Column(nullable = false)
	private String logoPath;
	@Enumerated(EnumType.STRING)
	private ColorType logoColoType;
	@ManyToOne
	@JoinColumn(name = "company_id", nullable = false)
	private Company company;

	/**
	 * Constructor.
	 *
	 * @param logoId
	 * @param logoName
	 * @param logoPath
	 * @param logoColoType
	 * @param company
	 */
	public Logo(long logoId, String logoName, String logoPath, ColorType logoColoType, Company company) {
		super();
		this.logoId = logoId;
		this.logoName = logoName;
		this.logoPath = logoPath;
		this.logoColoType = logoColoType;
		this.company = company;
	}

	/**
	 * Getter.
	 *
	 * @return the logoId
	 */
	public long getLogoId() {
		return logoId;
	}

	/**
	 * Setter.
	 *
	 * @param logoId the logoId to set
	 */
	public void setLogoId(long logoId) {
		this.logoId = logoId;
	}

	/**
	 * Getter.
	 *
	 * @return the logoName
	 */
	public String getLogoName() {
		return logoName;
	}

	/**
	 * Setter.
	 *
	 * @param logoName the logoName to set
	 */
	public void setLogoName(String logoName) {
		this.logoName = logoName;
	}

	/**
	 * Getter.
	 *
	 * @return the logoPath
	 */
	public String getLogoPath() {
		return logoPath;
	}

	/**
	 * Setter.
	 *
	 * @param logoPath the logoPath to set
	 */
	public void setLogoPath(String logoPath) {
		this.logoPath = logoPath;
	}

	/**
	 * Getter.
	 *
	 * @return the logoColoType
	 */
	public ColorType getLogoColoType() {
		return logoColoType;
	}

	/**
	 * Setter.
	 *
	 * @param logoColoType the logoColoType to set
	 */
	public void setLogoColoType(ColorType logoColoType) {
		this.logoColoType = logoColoType;
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

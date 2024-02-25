package project.cmm.myccm.core.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

@Entity
public class AppUser {

	@Id
	@SequenceGenerator(name = "seqUserID", initialValue = 1, allocationSize = 100)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqUserID")
	@Column(name = "app_user_id")
	private long appUserId;
	@Column(nullable = false, unique = true)
	private String username;
	@JsonIgnore
	@Column(nullable = false)
	private String password;

	private String title;
	@Column(nullable = false)
	private String firstName;
	@Column(nullable = false)
	private String lastName;
	private String email;
	private String signature;
	@Column(nullable = false)
	private boolean isActive = true;
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private Role role = Role.EMPLOYEE;

	/**
	 * Constructor.
	 *
	 * @param appUserId
	 * @param username
	 * @param password
	 * @param title
	 * @param firstName
	 * @param lastName
	 * @param email
	 * @param signature
	 * @param isActive
	 * @param role
	 */
	public AppUser(long appUserId, String username, String password, String title, String firstName, String lastName,
			String email, String signature, boolean isActive, Role role) {
		super();
		this.appUserId = appUserId;
		this.username = username;
		this.password = password;
		this.title = title;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.signature = signature;
		this.isActive = isActive;
		this.role = role;
	}

	/**
	 * Getter.
	 *
	 * @return the appUserId
	 */
	public long getAppUserId() {
		return appUserId;
	}

	/**
	 * Setter.
	 *
	 * @param appUserId the appUserId to set
	 */
	public void setAppUserId(long appUserId) {
		this.appUserId = appUserId;
	}

	/**
	 * Getter.
	 *
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * Setter.
	 *
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * Getter.
	 *
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Setter.
	 *
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Getter.
	 *
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Setter.
	 *
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
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
	 * @return the signature
	 */
	public String getSignature() {
		return signature;
	}

	/**
	 * Setter.
	 *
	 * @param signature the signature to set
	 */
	public void setSignature(String signature) {
		this.signature = signature;
	}

	/**
	 * Getter.
	 *
	 * @return the isActive
	 */
	public boolean isActive() {
		return isActive;
	}

	/**
	 * Setter.
	 *
	 * @param isActive the isActive to set
	 */
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	/**
	 * Getter.
	 *
	 * @return the role
	 */
	public Role getRole() {
		return role;
	}

	/**
	 * Setter.
	 *
	 * @param role the role to set
	 */
	public void setRole(Role role) {
		this.role = role;
	}

}

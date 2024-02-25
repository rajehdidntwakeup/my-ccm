package project.cmm.myccm.core.model.dto;

public class UserDto {

	private String username;
	private String password;
	private String title;
	private String firstName;
	private String lastName;
	private String email;

	
	/**
	 * Constructor.
	 *
	 * @param username
	 * @param password
	 * @param title
	 * @param firstName
	 * @param lastName
	 * @param email
	 */
	public UserDto(String username, String password, String title, String firstName, String lastName, String email) {
		super();
		this.username = username;
		this.password = password;
		this.title = title;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
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
	 * Getter.
	 *
	 * @return the password
	 */
	public String getPassword() {
		return password;
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
	 * Getter.
	 *
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
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
	 * Getter.
	 *
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}


}

package project.cmm.myccm.core.model.response;

import project.cmm.myccm.core.model.AppUser;
import project.cmm.myccm.core.model.Role;

public class UserResponse {

    private long appUserId;
    private String username;

    private String title;
    private String firstName;
    private String lastName;
    private String email;
    private boolean isActive;
    private Role role;


    /**
     * Constructor.
     */
    public UserResponse(AppUser user) {
        super();
        this.appUserId = user.getAppUserId();
        this.username = user.getUsername();
        this.title = user.getTitle();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.email = user.getEmail();
        this.isActive = user.isActive();
        this.role = user.getRole();

    }

    /**
     * Constructor.
     *
     * @param appUserId
     * @param username
     * @param title
     * @param firstName
     * @param lastName
     * @param email
     * @param isActive
     * @param role
     */
    public UserResponse(long appUserId, String username, String title, String firstName, String lastName, String email,
                        boolean isActive, Role role) {
        super();
        this.appUserId = appUserId;
        this.username = username;
        this.title = title;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
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

package project.cmm.myccm.core.model.xml;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Customer {

    @XmlElement(required = false)
    private String firstName;
    @XmlElement(required = false)
    private String lastName;
    @XmlElement(required = false)
    private String streetName;
    @XmlElement(required = false)
    private String streetNumber;
    @XmlElement(required = false)
    private String zip;
    @XmlElement(required = false)
    private String city;

    /**
     * Constructor.
     */
    public Customer() {
        super();
    }

    /**
     * Constructor.
     *
     * @param firstName
     * @param lastName
     * @param streetName
     * @param streetNumber
     * @param zip
     * @param city
     */
    public Customer(String firstName, String lastName, String streetName, String streetNumber, String zip,
                    String city) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.streetName = streetName;
        this.streetNumber = streetNumber;
        this.zip = zip;
        this.city = city;
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

}

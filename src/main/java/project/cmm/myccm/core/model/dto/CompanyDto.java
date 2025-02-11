package project.cmm.myccm.core.model.dto;

public class CompanyDto {

    private String name;
    private String streetName;
    private String streetNumber;
    private String zip;
    private String city;

    /**
     * Constructor.
     *
     * @param name
     * @param streetName
     * @param streetNumber
     * @param zip
     * @param city
     */
    public CompanyDto(String name, String streetName, String streetNumber, String zip, String city) {
        super();
        this.name = name;
        this.streetName = streetName;
        this.streetNumber = streetNumber;
        this.zip = zip;
        this.city = city;
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

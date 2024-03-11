package project.cmm.myccm.core.model.request;

import project.cmm.myccm.core.model.VehicleType;

public class FopRequest {

	private String firstName;
	private String lastName;
	private String streetName;
	private String streetNumber;
	private String zip;
	private String city;
	private VehicleType vehicleType = VehicleType.PKW;
	private String brand;
	private String modelName;
	private String manufactureYear;
	private double mileage = 0;
	private String motorNumber;
	private String chassisNumber;
	private boolean isTest = false;

	/**
	 * Constructor.
	 *
	 */
	public FopRequest() {
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
	 * @param vehicleType
	 * @param brand
	 * @param modelName
	 * @param manufactureYear
	 * @param mileage
	 * @param motorNumber
	 * @param chassisNumber
	 * @param isTest
	 */
	public FopRequest(String firstName, String lastName, String streetName, String streetNumber, String zip,
			String city, VehicleType vehicleType, String brand, String modelName, String manufactureYear,
			double mileage, String motorNumber, String chassisNumber, boolean isTest) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.streetName = streetName;
		this.streetNumber = streetNumber;
		this.zip = zip;
		this.city = city;
		this.vehicleType = vehicleType;
		this.brand = brand;
		this.modelName = modelName;
		this.manufactureYear = manufactureYear;
		this.mileage = mileage;
		this.motorNumber = motorNumber;
		this.chassisNumber = chassisNumber;
		this.isTest = isTest;
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

	/**
	 * Getter.
	 *
	 * @return the vehicleType
	 */
	public VehicleType getVehicleType() {
		return vehicleType;
	}

	/**
	 * Setter.
	 *
	 * @param vehicleType the vehicleType to set
	 */
	public void setVehicleType(VehicleType vehicleType) {
		this.vehicleType = vehicleType;
	}

	/**
	 * Getter.
	 *
	 * @return the brand
	 */
	public String getBrand() {
		return brand;
	}

	/**
	 * Setter.
	 *
	 * @param brand the brand to set
	 */
	public void setBrand(String brand) {
		this.brand = brand;
	}

	/**
	 * Getter.
	 *
	 * @return the modelName
	 */
	public String getModelName() {
		return modelName;
	}

	/**
	 * Setter.
	 *
	 * @param modelName the modelName to set
	 */
	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	/**
	 * Getter.
	 *
	 * @return the manufactureYear
	 */
	public String getManufactureYear() {
		return manufactureYear;
	}

	/**
	 * Setter.
	 *
	 * @param manufactureYear the manufactureYear to set
	 */
	public void setManufactureYear(String manufactureYear) {
		this.manufactureYear = manufactureYear;
	}

	/**
	 * Getter.
	 *
	 * @return the mileage
	 */
	public double getMileage() {
		return mileage;
	}

	/**
	 * Setter.
	 *
	 * @param mileage the mileage to set
	 */
	public void setMileage(double mileage) {
		this.mileage = mileage;
	}

	/**
	 * Getter.
	 *
	 * @return the motorNumber
	 */
	public String getMotorNumber() {
		return motorNumber;
	}

	/**
	 * Setter.
	 *
	 * @param motorNumber the motorNumber to set
	 */
	public void setMotorNumber(String motorNumber) {
		this.motorNumber = motorNumber;
	}

	/**
	 * Getter.
	 *
	 * @return the chassisNumber
	 */
	public String getChassisNumber() {
		return chassisNumber;
	}

	/**
	 * Setter.
	 *
	 * @param chassisNumber the chassisNumber to set
	 */
	public void setChassisNumber(String chassisNumber) {
		this.chassisNumber = chassisNumber;
	}

	/**
	 * Getter.
	 *
	 * @return the isTest
	 */
	public boolean isTest() {
		return isTest;
	}

	/**
	 * Setter.
	 *
	 * @param isTest the isTest to set
	 */
	public void setTest(boolean isTest) {
		this.isTest = isTest;
	}

}

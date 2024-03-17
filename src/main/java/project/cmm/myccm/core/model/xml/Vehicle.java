package project.cmm.myccm.core.model.xml;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;;


@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Vehicle {

	@XmlElement(required = false)
	private String vehicleType;
	@XmlElement(required = false)
	private String brand;
	@XmlElement(required = false)
	private String modelName;
	@XmlElement(required = false)
	private String manufactureYear;
	@XmlElement(required = false)
	private double mileage = 0;
	@XmlElement(required = false)
	private String motorNumber;
	@XmlElement(required = false)
	private String chassisNumber;

	/**
	 * Constructor.
	 *
	 */
	public Vehicle() {
		super();
	}

	/**
	 * Constructor.
	 *
	 * @param vehicleType
	 * @param brand
	 * @param modelName
	 * @param manufactureYear
	 * @param mileage
	 * @param motorNumber
	 * @param chassisNumber
	 */
	public Vehicle(String vehicleType, String brand, String modelName, String manufactureYear, double mileage,
			String motorNumber, String chassisNumber) {
		super();
		this.vehicleType = vehicleType;
		this.brand = brand;
		this.modelName = modelName;
		this.manufactureYear = manufactureYear;
		this.mileage = mileage;
		this.motorNumber = motorNumber;
		this.chassisNumber = chassisNumber;
	}

	/**
	 * Getter.
	 *
	 * @return the vehicleType
	 */
	public String getVehicleType() {
		return vehicleType;
	}

	/**
	 * Setter.
	 *
	 * @param vehicleType the vehicleType to set
	 */
	public void setVehicleType(String vehicleType) {
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

}

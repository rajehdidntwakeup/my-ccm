package project.cmm.myccm.core.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Vehicle {

    @Id
    @SequenceGenerator(name = "seqVehicleID", initialValue = 1, allocationSize = 100)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqVehicleID")
    @Column(name = "vehicle_id")
    private long vehicleId;
    @Column(nullable = false)
    private VehicleType vehicleType = VehicleType.PKW;
    @Column(nullable = false)
    private String brand;
    @Column(nullable = false)
    private String modelName;
    @Column(nullable = false)
    private String manufactureYear;
    @Column(nullable = false)
    private double mileage;
    private String motorNumber;
    private String chassisNumber;
    private String others;

    @ManyToOne
    @JoinColumn(name = "company_id", nullable = false)
    private Company company;

    @OneToMany(mappedBy = "vehicle")
    private List<Document> documents = new ArrayList<>(1);

    /**
     * Constructor.
     */
    public Vehicle() {
        super();
    }

    /**
     * Constructor.
     *
     * @param vehicleId
     * @param vehicleType
     * @param brand
     * @param modelName
     * @param manufactureYear
     * @param mileage
     * @param motorNumber
     * @param chassisNumber
     * @param others
     * @param company
     * @param documents
     */
    public Vehicle(long vehicleId, VehicleType vehicleType, String brand, String modelName, String manufactureYear,
                   double mileage, String motorNumber, String chassisNumber, String others, Company company,
                   List<Document> documents) {
        super();
        this.vehicleId = vehicleId;
        this.vehicleType = vehicleType;
        this.brand = brand;
        this.modelName = modelName;
        this.manufactureYear = manufactureYear;
        this.mileage = mileage;
        this.motorNumber = motorNumber;
        this.chassisNumber = chassisNumber;
        this.others = others;
        this.company = company;
        this.documents = documents;
    }

    /**
     * Getter.
     *
     * @return the vehicleId
     */
    public long getVehicleId() {
        return vehicleId;
    }

    /**
     * Setter.
     *
     * @param vehicleId the vehicleId to set
     */
    public void setVehicleId(long vehicleId) {
        this.vehicleId = vehicleId;
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
     * @return the others
     */
    public String getOthers() {
        return others;
    }

    /**
     * Setter.
     *
     * @param others the others to set
     */
    public void setOthers(String others) {
        this.others = others;
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

    /**
     * Getter.
     *
     * @return the documents
     */
    public List<Document> getDocuments() {
        return documents;
    }

    /**
     * Setter.
     *
     * @param documents the documents to set
     */
    public void setDocuments(List<Document> documents) {
        this.documents = documents;
    }

}

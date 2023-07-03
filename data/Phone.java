package data;

import java.util.Objects;
import java.util.UUID;

public class Phone {
    private final String phoneId;
    private String brand;
    private String model;
    private String serialNumber;
    private double storageSpace;
    private double filledSpace;
    private double freeSpace;
    private String os;

    public Phone(String brand, String model, String serialNumber, double storageSpace, String os) {
        this.phoneId = UUID.randomUUID().toString();
        this.brand = brand;
        this.model = model;
        this.serialNumber = serialNumber;
        this.storageSpace = storageSpace;
        this.os = os;
        this.freeSpace = this.storageSpace;
        filledSpace = 0;
    }

    public String getPhoneId() {
        return phoneId;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public double getStorageSpace() {
        return storageSpace;
    }

    public void setStorageSpace(int storageSpace) {
        this.storageSpace = storageSpace;
    }

    public double getFilledSpace() {
        return filledSpace;
    }

    public void setFilledSpace(double filledSpace) {
        this.filledSpace = filledSpace;
        setFreeSpace(getStorageSpace() - filledSpace);
    }

    public double getFreeSpace() {
        return freeSpace;
    }

    public void setFreeSpace(double freeSpace) {
        this.freeSpace = freeSpace;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public void freeSpace() {
        System.out.println(this.getFreeSpace());
    }

    @Override
    public String toString() {
        return "Phone{" +
                "phoneId='" + phoneId + '\'' +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", serialNumber='" + serialNumber + '\'' +
                ", storageSpace=" + storageSpace +
                ", os='" + os + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Phone phone)) return false;
        return storageSpace == phone.storageSpace
                && filledSpace == phone.filledSpace
                && freeSpace == phone.freeSpace
                && phoneId.equals(phone.phoneId)
                && brand.equals(phone.brand)
                && model.equals(phone.model)
                && serialNumber.equals(phone.serialNumber)
                && os.equals(phone.os);
    }

    @Override
    public int hashCode() {
        return Objects.hash(phoneId, brand, model, serialNumber, storageSpace, filledSpace, freeSpace, os);
    }
}

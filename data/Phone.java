package data;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class Phone {
    private final String phoneId;
    private String brand;
    private String model;
    private String serialNumber;
    private int storageSpace;
    private int filledSpace;
    private int freeSpace;
    private String os;

    public Phone(String brand, String model, String serialNumber, int storageSpace, String os) {
        this.phoneId = UUID.randomUUID().toString();
        this.brand = brand;
        this.model = model;
        this.serialNumber = serialNumber;
        this.storageSpace = storageSpace;
        this.os = os;
        this.freeSpace = storageSpace - filledSpace;
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

    public int getStorageSpace() {
        return storageSpace;
    }

    public void setStorageSpace(int storageSpace) {
        this.storageSpace = storageSpace;
    }

    public int getFilledSpace() {
        return filledSpace;
    }

    public void setFilledSpace(int filledSpace) {
        this.filledSpace = filledSpace;
    }

    public int getFreeSpace() {
        return freeSpace;
    }

    public void setFreeSpace(int freeSpace) {
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
        return "data.Phone{" +
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

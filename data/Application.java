package data;

import category.ApplicationType;
import supplier.ApplicationIdSupplier;

import java.util.Objects;
import java.util.UUID;

public class Application {
    private final String applicationId;
    private String name;
    private String version;
    private int size;
    private ApplicationType applicationType;
    private ApplicationIdSupplier applicationIdSupplier = new ApplicationIdSupplier();

    public Application(String name, String version, int size, ApplicationType applicationType) {
        this.applicationType = applicationType;
        applicationIdSupplier.registerApplicationIdSupplier(this.applicationType.name(), () ->
                this.applicationType.name().substring(0, 5) + "-" + UUID.randomUUID());
        this.applicationId = applicationIdSupplier.generateApplicationId(this.applicationType.name());
        this.name = name;
        this.version = version;
        this.size = size;
    }

    public String getApplicationId() {
        return applicationId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public ApplicationType getApplicationType() {
        return applicationType;
    }

    public void setApplicationType(ApplicationType applicationType) {
        this.applicationType = applicationType;
    }

    public ApplicationIdSupplier getApplicationIdSupplier() {
        return applicationIdSupplier;
    }

    public void setApplicationIdSupplier(ApplicationIdSupplier applicationIdSupplier) {
        this.applicationIdSupplier = applicationIdSupplier;
    }

    @Override
    public String toString() {
        return "Application{" +
                "applicationId='" + applicationId + '\'' +
                ", name='" + name + '\'' +
                ", version='" + version + '\'' +
                ", size=" + size +
                ", applicationType=" + applicationType +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Application that)) return false;
        return size == that.size
                && Objects.equals(applicationId, that.applicationId)
                && Objects.equals(name, that.name)
                && Objects.equals(version, that.version);
    }

    @Override
    public int hashCode() {
        return Objects.hash(applicationId, name, version, size);
    }
}

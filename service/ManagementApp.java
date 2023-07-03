package service;

import backup.BackUpApplication;
import data.Application;
import data.Phone;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.function.Consumer;

public class ManagementApp implements Management<Application> {
    private Phone phone;
    private Map<String, Application> applications = new HashMap<>();

    public ManagementApp(Phone phone) {
        this.phone = phone;
    }

    @Override
    public void add(Application application) {
        if (application.getSize() > phone.getFreeSpace()) {
            System.out.println("The phone does not have enough storage space");
        } else {
            applications.put(application.getApplicationId(), application);
            System.out.println("The application has been successfully added to your phone book " + application);
            updateStorageSpace(application.getApplicationId(), (phone) -> {
                double newFilledSpace = phone.getFilledSpace() + application.getSize();
                phone.setFilledSpace(newFilledSpace);
            });
            BackUpApplication.backUpApplication(application.getApplicationId(),application);
        }
    }
    @Override
    public Application remove(String applicationId) {
        updateStorageSpace(String.valueOf(applications.get(applicationId)), (phone) -> {
            phone.setFilledSpace(phone.getFilledSpace() - applications.get(applicationId).getSize());
        });
        return applications.remove(applicationId);
    }

    @Override
    public void edit(String applicationId, Consumer<Application> updateApplication) {
        updateApplication.accept(applications.get(applicationId));
    }

    public void updateVersion(String applicationId, String version) {
        edit(applicationId, application -> application.setVersion(version));
    }
    public void listApplication() {
        Iterator<Application> it = applications.values().iterator();
        while (it.hasNext()) {
            Application app = it.next();
            System.out.println("Applications in your phone book: " + app);
        }
    }
    public void updateStorageSpace(String applicationId, Consumer<Phone> updateFunction) {
        updateFunction.accept(phone);
    }

   /* public void sumSize() {
        applications.values().stream().mapToDouble(Application::getSize).sum();
    }*/
}

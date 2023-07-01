package service;

import data.Application;
import data.Phone;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class ManagementApp implements Management<Application> {
    private Phone phone;
    private Application application;
    private Map<String, Application> applications = new HashMap<>();

    @Override
    public void add(Application application) {
        if (application.getSize() > phone.getFreeSpace()) {
            System.out.println("The phone does not have enough storage space");
        } else {
            applications.put(application.getApplicationId(), application);
            System.out.println("The application has been successfully added to your phone book " + application);
            updateStorageSpace(application.getApplicationId(), application.getSize(), (app, phone) -> {
                int newFilledSpace = phone.getFilledSpace() + app.getSize();
                phone.setFilledSpace(newFilledSpace);
            });
        }
    }

    @Override
    public Application remove(String applicationId) {
        applications.remove(applicationId);
        updateStorageSpace(applicationId, applications.get(applicationId).getSize(), (application, phone) -> {
            int newStorageSpace = phone.getFilledSpace() - application.getSize();
            phone.setFilledSpace(newStorageSpace);
        });
        return application;
    }

    @Override
    public void edit(String appId, Consumer<Application> updateApplication) {
        updateApplication.accept(applications.get(appId));
    }

    public void updateVersion(String appid, String version) {
        edit(appid, application -> application.setVersion(version));
    }

    public void listApplication() {
        Iterator<Application> it = applications.values().iterator();
        while (it.hasNext()) {
            Application app = it.next();
            System.out.println("Applications in your phone book: " + app);
        }
    }

    public void updateStorageSpace(String applicationId, int size, BiConsumer<Application, Phone> updateFunction) {
        updateFunction.accept(applications.get(applicationId), phone);
    }
}

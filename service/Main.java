package service;

import category.ApplicationType;
import category.PersonType;
import data.Application;
import data.Person;
import data.Phone;
import exception.EmailInvalidException;
import exception.InValidNumberException;

import java.util.Scanner;

public class Main {
    private static final ManagementPerson managePer = new ManagementPerson();
    private static final Phone phone = new Phone("Apple", "iPhone13", "K0VQ67Y98M", 250000.0, "iOS");
    private static final ManagementApp manageApp = new ManagementApp(phone);
    private static final Scanner scan = new Scanner(System.in);
    private static int exitCode = 1;

    public static void main(String[] args) {
        initData();
        System.out.println("*********** WELCOME **************");
        while (exitCode > 0) {
            writeMenu();
        }
    }
    private static void writeMenu() {
        int choice;
        do {
            System.out.println("********** MAIN MENU *************");
            System.out.println("**  1 - Phone Book");
            System.out.println("**  2 - Application");
            System.out.println("**  3 - Phone Information");
            System.out.println("** -1 - Exit");
            System.out.println("***********************************");
            choice = scan.nextInt();
            switch (choice) {
                case 1 -> {
                    int innerChoice;
                    do {
                        System.out.println("********** PHONE BOOK MENU*****************");
                        System.out.println("** 1 - View contacts in your phone book");
                        System.out.println("** 2 - Add contacts to your phone book");
                        System.out.println("** 3 - Remove contacts to your phone book");
                        System.out.println("** 4 - Make changes to your contacts");
                        System.out.println("** 5 - Search the contact in your phone book ");
                        System.out.println("** 6 - Exit");
                        System.out.println("** 0 - Top menu ");
                        System.out.println("*********************************************");
                        innerChoice = scan.nextInt();
                        switch (innerChoice) {
                            case 1 -> {
                                managePer.listPerson();
                            }
                            case 2 -> {
                                try {
                                    scan.nextLine();
                                    System.out.println("Enter the person name");
                                    String name = scan.nextLine();
                                    System.out.println("Enter the person surname");
                                    String surName = scan.nextLine();
                                    System.out.println("Enter the person phone number");
                                    String phoneNumber = scan.nextLine();
                                    if(!isValidNumber(phoneNumber)){
                                        throw new InValidNumberException("Phone number is invalid. Must be 11 digit numbers");
                                    }
                                    System.out.println("Enter the person email");
                                    String email = scan.nextLine();
                                    if(!isValidEmail(email)){
                                        throw new EmailInvalidException("Email is invalid. " +
                                                "Must contain at least one '@' character and end with .com.");
                                    }
                                    System.out.println("Enter the person type / FAMILY,FRIENDS,WORKFRIENDS,OTHER");
                                    PersonType personType = PersonType.valueOf(scan.nextLine());
                                    Person person = new Person(name, surName, phoneNumber, email, personType);
                                    managePer.add(person);
                                } catch (InValidNumberException e){
                                    System.out.println(e.getMessage());
                                } catch (EmailInvalidException e) {
                                    System.out.println(e.getMessage());
                                }
                            }
                            case 3 -> {
                                System.out.println("Enter id number the person");
                                scan.nextLine();
                                String personId = scan.nextLine();
                                System.out.println(managePer.remove(personId));
                            }
                            case 4 -> {
                                int inChoice;
                                do {
                                    System.out.println("********** EDIT MENU *************");
                                    System.out.println("** 1 - Edit person's name ");
                                    System.out.println("** 2 - Edit person's surname ");
                                    System.out.println("** 3 - Edit person's phone number ");
                                    System.out.println("** 4 - Edit person's email ");
                                    System.out.println("** 5 - Exit ");
                                    System.out.println("** 0 - Top menu ");
                                    System.out.println("*********************************************");
                                    inChoice = scan.nextInt();
                                    switch (inChoice) {
                                        case 1 -> {
                                            System.out.println("Enter id number");
                                            scan.nextLine();
                                            String personId = scan.nextLine();
                                            System.out.println("Enter new name ");
                                            String name = scan.nextLine();
                                            managePer.editPersonName(personId, name);
                                        }
                                        case 2 -> {
                                            System.out.println("Enter id number");
                                            scan.nextLine();
                                            String personId = scan.nextLine();
                                            System.out.println("Enter new surname ");
                                            String surname = scan.nextLine();
                                            managePer.editPersonSurname(personId, surname);
                                        }
                                        case 3 -> {
                                            System.out.println("Enter id number");
                                            scan.nextLine();
                                            String personId = scan.nextLine();
                                            System.out.println("Enter new phone number");
                                            String phoneNumber = scan.nextLine();
                                            managePer.editPersonPhoneNumber(personId, phoneNumber);
                                        }
                                        case 4 -> {
                                            System.out.println("Enter id number");
                                            scan.nextLine();
                                            String personId = scan.nextLine();
                                            System.out.println("Enter new email");
                                            String email = scan.nextLine();
                                            managePer.editPersonEmail(personId, email);
                                        }
                                        case 5 -> {
                                            inChoice = 0;
                                            innerChoice = 0;
                                            choice = -1;
                                        }
                                        case 0 -> {

                                        }
                                        default -> System.out.println("You have entered incorrectly, press 0 for the top menu.");
                                    }
                                } while (inChoice != 0);
                            }
                            case 5 -> {
                                System.out.println("Enter id number");
                                scan.nextLine();
                                String personId = scan.nextLine();
                                managePer.callPerson(personId);
                            }
                            case 6 -> {
                                innerChoice = 0;
                                choice = -1;
                            }
                            case 0 -> {

                            }
                            default -> System.out.println("You have entered incorrectly, press 0 for the top menu.");
                        }
                    } while (innerChoice != 0);
                }
                case 2 -> {
                    int innerChoice;
                    do {
                        System.out.println("********** APPLICATION MENU*****************");
                        System.out.println("** 1 - View app on your phone ");
                        System.out.println("** 2 - Add app on your phone");
                        System.out.println("** 3 - Remove app on your phone");
                        System.out.println("** 4 - Update app on your phone");
                        System.out.println("** 5 - Exit");
                        System.out.println("** 0 - Top menu ");
                        System.out.println("*********************************************");
                        innerChoice = scan.nextInt();
                        switch (innerChoice) {
                            case 1 -> {
                                manageApp.listApplication();
                            }
                            case 2 -> {
                                scan.nextLine();
                                System.out.println("Enter the application name");
                                String name = scan.nextLine();
                                System.out.println("Enter the application version");
                                String version = scan.nextLine();
                                System.out.println("Enter the application size");
                                double size = scan.nextDouble();
                                scan.nextLine();
                                System.out.println("Enter the application type / SOCIAL_MEDIA, INFORMATION_READ," +
                                        "EDUCATION,FINANCE,HEALTH");
                                ApplicationType applicationType = ApplicationType.valueOf(scan.nextLine());
                                Application app = new Application(name, version, size, applicationType);
                                manageApp.add(app);
                            }
                            case 3 -> {
                                System.out.println("Enter id number the application");
                                scan.nextLine();
                                String applicationId = scan.nextLine();
                                System.out.println(manageApp.remove(applicationId));
                            }
                            case 4 -> {
                                System.out.println("Enter id number");
                                scan.nextLine();
                                String applicationId = scan.nextLine();
                                System.out.println("Enter new version ");
                                String version = scan.nextLine();
                                manageApp.updateVersion(applicationId, version);
                            }
                            case 5 -> {
                                innerChoice = 0;
                                choice = -1;
                            }
                            case 0 -> {

                            }
                            default -> System.out.println("You have entered incorrectly, press 0 for the top menu.");
                        }
                    } while (innerChoice != 0);
                }
                case 3 -> {
                    int innerChoice;
                    do {
                        System.out.println("********** PHONE INFORMATION MENU*****************");
                        System.out.println("** 1 - View phone information ");
                        System.out.println("** 2 - View phone full memory");
                        System.out.println("** 3 - View phone free memory");
                        System.out.println("** 4 - Exit");
                        System.out.println("** 0 - Top menu ");
                        System.out.println("*********************************************");
                        innerChoice = scan.nextInt();
                        switch (innerChoice) {
                            case 1 -> {
                                System.out.println(phone);
                            }
                            case 2 -> {
                                System.out.println(phone.getFilledSpace());
                            }
                            case 3 -> {
                                System.out.println(phone.getFreeSpace());
                            }
                            case 4 -> {
                                innerChoice = 0;
                                choice = -1;
                            }
                            case 0 -> {

                            }
                            default -> System.out.println("You have entered incorrectly number, press 0 for the top menu.");
                        }
                    } while (innerChoice != 0);
                }
                case -1 -> {
                    Main.exitCode = -1;
                }
            }
        } while (choice != -1);
    }

    private static void initData() {
        Person person1 = new Person("Burcu", "Sert", "05395575655", "burcusert@", PersonType.FAMILY);
        Person person2 = new Person("Polat", "Sert", "05697215457", "polatsert@", PersonType.FAMILY);
        Person person3 = new Person("Fadile", "Avci", "05367259632", "fadileavci@", PersonType.FRIENDS);
        Person person4 = new Person("Zeynep", "Özdemir", "05419876532", "zeynepozturk@", PersonType.FRIENDS);
        Person person5 = new Person("Kübra", "Kaya", "05378786323", "kubrakaya@", PersonType.WORKFRIENDS);
        Person person6 = new Person("Emine", "Çamlıcalı", "05557896359", "eminecamlicali@", PersonType.WORKFRIENDS);
        Person person7 = new Person("Aslı", "Öztürk", "05468763679", "burcusert@", PersonType.OTHER);
        Person person8 = new Person("Esra", "Demir", "05429638754", "esrademir@", PersonType.OTHER);

        Application app1 = new Application("Instagram", "289.0", 236.2, ApplicationType.SOCIAL_MEDIA);
        Application app2 = new Application("Discord", "183.0", 185.5, ApplicationType.SOCIAL_MEDIA);
        Application app3 = new Application("Twitter", "9.63", 221.6, ApplicationType.SOCIAL_MEDIA);
        Application app4 = new Application("Whatsapp", "23.11.80", 167.2, ApplicationType.SOCIAL_MEDIA);
        Application app5 = new Application("News", "4.0.5", 27.1, ApplicationType.INFORMATION_READ);
        Application app6 = new Application("EnglishCentral", "5.2.3", 169.6, ApplicationType.EDUCATION);
        Application app7 = new Application("Voscreen", "2.1", 24.6, ApplicationType.EDUCATION);
        Application app8 = new Application("Vakıfbank", "3.0.2", 281.3, ApplicationType.FINANCE);
        Application app9 = new Application("GİB", "2.9.0", 61.3, ApplicationType.FINANCE);
        Application app10 = new Application("MHRS", "1.6.3", 17.0, ApplicationType.HEALTH);

        managePer.add(person1);
        managePer.add(person2);
        managePer.add(person3);
        managePer.add(person4);
        managePer.add(person5);
        managePer.add(person6);
        managePer.add(person7);
        managePer.add(person8);
        System.out.println();
        System.out.println();
        manageApp.add(app1);
        manageApp.add(app2);
        manageApp.add(app3);
        manageApp.add(app4);
        manageApp.add(app5);
        manageApp.add(app6);
        manageApp.add(app7);
        manageApp.add(app8);
        manageApp.add(app9);
        manageApp.add(app10);
    }
    private static boolean isValidNumber(String number) {
        if (number.length() != 11) {
            return false;
        }
        for (char c : number.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isValidEmail(String email) {
        return email.contains("@") && email.endsWith(".com");
    }
}
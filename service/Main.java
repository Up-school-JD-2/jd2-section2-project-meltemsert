package service;

import category.PersonType;
import data.Person;

import java.util.Scanner;

public class Main {
    private static final ManagementPerson managePer = new ManagementPerson();
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
                        System.out.println("** 0 - Top menü ");
                        System.out.println("*********************************************");
                        innerChoice = scan.nextInt();
                        switch (innerChoice) {
                            case 1 -> {
                                managePer.listPerson();
                            }
                            case 2 -> {
                                scan.nextLine();
                                System.out.println("Enter the person name");
                                String name = scan.nextLine();
                                System.out.println("Enter the person surname");
                                String surName = scan.nextLine();
                                System.out.println("Enter the person phone number");
                                String phoneNumber = scan.nextLine();
                                System.out.println("Enter the person email");
                                String email = scan.nextLine();
                                System.out.println("enter the person's status / FAMILY,FRIENDS,WORKFRIENDS,OTHER");
                                PersonType personType = PersonType.valueOf(scan.nextLine());
                                Person person = new Person(name, surName, phoneNumber, email, personType);
                                managePer.add(person);

                            }
                            case 3 -> {
                                System.out.println("Enter id number of the person you want to delete");
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
                                    System.out.println("** 0 - Top menü ");
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
                                    }
                                } while (inChoice != 0);
                            }
                            case 5 -> {
                                System.out.println("Enter id number");
                                scan.nextLine();
                                String personId = scan.nextLine();
                                System.out.println(managePer.searchPerson(personId));
                            }
                            case 6 -> {
                                innerChoice = 0;
                                choice = -1;
                            }
                        }
                    } while (innerChoice != 0);
                }
                case 2 -> {
                    System.out.println("********** APPLICATION MENU*****************");
                    System.out.println("** 1 - View app on your phone ");
                    System.out.println("** 2 - Add app on your phone");
                    System.out.println("** 3 - Remove app on your phone");
                    System.out.println("** 4 - Update app on your phone");
                    System.out.println("** 5 - Exit");
                    System.out.println("** 0 - Top menü ");
                    System.out.println("*********************************************");
                }
                case -1 -> {
                    Main.exitCode = -1;
                }
            }
        } while (choice != -1);
    }

    private static void initData() {
        Person person1 = new Person("Burcu", "Sert", "05395579496", "burcusert@", PersonType.FAMILY);
        Person person2 = new Person("Aslı", "Öztürk", "05468763679", "burcusert@", PersonType.OTHER);
        Person person3 = new Person("Kübra", "Kaya", "05378786323", "kubrakaya@", PersonType.WORKFRIENDS);
        Person person4 = new Person("Fadile", "Avci", "05367259632", "fadileavci@", PersonType.FRIENDS);
        Person person5 = new Person("Zeynep", "Özdemir", "05419876532", "zeynepozturk@", PersonType.FRIENDS);
        managePer.add(person1);
        managePer.add(person2);
        managePer.add(person3);
        managePer.add(person4);
        managePer.add(person5);
        managePer.listPerson();

    }

}

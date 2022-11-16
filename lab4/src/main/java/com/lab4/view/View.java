package com.lab4.view;

import com.lab4.controller.*;
import com.lab4.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.sql.In;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class View {
//    public View(AppartmentAdressController appartmentAdressController, AppartmentController appartmentController,
//                AvailableTimeController availableTimeController, RenteeController renteeController,
//                RenterController renterController, RequestController requestController, ResponseController responseController) {
//        this.appartmentAdressController = appartmentAdressController;
//        this.appartmentController = appartmentController;
//        this.availableTimeController = availableTimeController;
//        this.renteeController = renteeController;
//        this.renterController = renterController;
//        this.requestController = requestController;
//        this.responseController = responseController;
//    }
    @Autowired
    private AppartmentAdressController appartmentAdressController;
    @Autowired
    private AppartmentController appartmentController;
    @Autowired
    private AvailableTimeController availableTimeController;
    @Autowired
    private RenteeController renteeController;
    @Autowired
    private RenterController renterController;
    @Autowired
    private RequestController requestController;
    @Autowired
    private ResponseController responseController;
    private final Map<String, String> menu;
    private final Map<String, Printable> methodsMenu;
    private final Scanner input = new Scanner(System.in);
    private final AppartmentAdress nullAppartmentAdress =
            new AppartmentAdress(null, null, null, null, null, null, null);
    private final Appartment nullAppartment =
            new Appartment(null, null, null, null, null, null);
    private final AvailableTime nullAvailableTime = new AvailableTime(null, null, null);
    private final Rentee nullRentee =
            new Rentee(null, null, null, null, null, null, null);
    private final Renter nullRenter = new Renter(null, null, null, null, null);
    private final Request nullRequest = new Request(null, null, null, null, null);
    private final Response nullResponse = new Response(null, null, null, null);

    public View(){
        menu = new LinkedHashMap<>();
        menu.put("A", "  A - Select all table");

        menu.put("1", "   1 - Table: Appartment Adress");
        menu.put("11", "  11 - Create Appartment Adress");
        menu.put("12", "  12 - Update Appartment Adress");
        menu.put("13", "  13 - Delete from Appartment Adress");
        menu.put("14", "  14 - Find all Appartment Adresses");
        menu.put("15", "  15 - Find Appartment Adress by id");

        menu.put("2", "   2 - Table: Appartment");
        menu.put("21", "  21 - Create Appartment");
        menu.put("22", "  22 - Update Appartment");
        menu.put("23", "  23 - Delete from Appartment");
        menu.put("24", "  24 - Find all Appartments");
        menu.put("25", "  25 - Find Appartment by ID");
        menu.put("26", "  26 - Find Appartments by rating");

        menu.put("3", "   3 - Table: Rentee");
        menu.put("31", "  31 - Create Rentee");
        menu.put("32", "  32 - Update Rentee");
        menu.put("33", "  33 - Delete from Rentee");
        menu.put("34", "  34 - Find all Rentees");
        menu.put("35", "  35 - Find Rentee by ID");
        menu.put("36", "  26 - Find Rentees by gender");

        menu.put("4", "   4 - Table: Renter");
        menu.put("41", "  41 - Create Renter");
        menu.put("42", "  42 - Update Renter");
        menu.put("43", "  43 - Delete from Renter");
        menu.put("44", "  44 - Find all Renters");
        menu.put("45", "  45 - Find Renter by ID");

        menu.put("5", "   5 - Table: Request");
        menu.put("51", "  51 - Create Request");
        menu.put("52", "  52 - Update Request");
        menu.put("53", "  53 - Delete from Request");
        menu.put("54", "  54 - Find all Request");
        menu.put("55", "  55 - Find Request by ID");

        menu.put("6", "   6 - Table: Available Time");
        menu.put("61", "  61 - Create Available Time");
        menu.put("62", "  62 - Update Available Time");
        menu.put("63", "  63 - Delete from Available Time");
        menu.put("64", "  64 - Find all Available Time");
        menu.put("65", "  65 - Find Available Time by ID");

        menu.put("7", "   7 - Table: Response");
        menu.put("71", "  71 - Create Response");
        menu.put("72", "  72 - Update Response");
        menu.put("73", "  73 - Delete from Response");
        menu.put("74", "  74 - Find all Responses");
        menu.put("75", "  75 - Find Response by ID");
        menu.put("76", "  76 - Find Responses by rating");

        menu.put("Q", "  Q - exit");

        methodsMenu = new LinkedHashMap<>();
        methodsMenu.put("A", this::selectAll);

        methodsMenu.put("11", this::createAppartmentAdress);
        methodsMenu.put("12", this::updateAppartmentAdress);
        methodsMenu.put("13", this::deleteFromAppartmentAdress);
        methodsMenu.put("14", this::findAllAppartmentAdresses);
        methodsMenu.put("15", this::findAppartmentAdressById);

        methodsMenu.put("21", this::createAppartment);
        methodsMenu.put("22", this::updateAppartment);
        methodsMenu.put("23", this::deleteFromAppartment);
        methodsMenu.put("24", this::findAllAppartment);
        methodsMenu.put("25", this::findAppartmentById);
        methodsMenu.put("26", this::findAppartmentByRating);

        methodsMenu.put("31", this::createRentee);
        methodsMenu.put("32", this::updateRentee);
        methodsMenu.put("33", this::deleteFromRentee);
        methodsMenu.put("34", this::findAllRentee);
        methodsMenu.put("35", this::findRenteeById);
        methodsMenu.put("36", this::findRenteeByGender);

        methodsMenu.put("41", this::createRenter);
        methodsMenu.put("42", this::updateRenter);
        methodsMenu.put("43", this::deleteFromRenter);
        methodsMenu.put("44", this::findAllRenter);
        methodsMenu.put("45", this::findRenterById);

        methodsMenu.put("51", this::createRequest);
        methodsMenu.put("52", this::updateRequest);
        methodsMenu.put("53", this::deleteFromRequest);
        methodsMenu.put("54", this::findAllRequest);
        methodsMenu.put("55", this::findRequestById);

        methodsMenu.put("61", this::createAvailableTime);
        methodsMenu.put("62", this::updateAvailableTime);
        methodsMenu.put("63", this::deleteFromAvailableTime);
        methodsMenu.put("64", this::findAllAvailableTime);
        methodsMenu.put("65", this::findAvailableTimeById);

        methodsMenu.put("71", this::createResponse);
        methodsMenu.put("72", this::updateResponse);
        methodsMenu.put("73", this::deleteFromResponse);
        methodsMenu.put("74", this::findAllResponse);
        methodsMenu.put("75", this::findResponseById);
        methodsMenu.put("76", this::findResponseByRating);
    }

    private void createAppartmentAdress() {
        System.out.println("Enter country:");
        String country = input.nextLine();
        System.out.println("Enter city:");
        String city = input.nextLine();
        System.out.println("Enter street:");
        String street = input.nextLine();
        System.out.println("Enter house number:");
        Integer houseNumber = Integer.valueOf(input.nextLine());
        System.out.println("Enter appartment number:");
        Integer appartmentNumber = Integer.valueOf(input.nextLine());
        System.out.println("Enter appartment id:");
        Integer appartmentId = Integer.valueOf(input.nextLine());
        AppartmentAdress appartmentAdress =
                new AppartmentAdress(null, country, city, street, houseNumber, appartmentNumber, appartmentId);
        System.out.printf("There are created %d rows\n", appartmentAdressController.create(appartmentAdress));
    }

    private void updateAppartmentAdress() {
        System.out.println("Enter id:");
        Integer id = Integer.valueOf(input.nextLine());
        System.out.println("Enter country:");
        String country = input.nextLine();
        System.out.println("Enter city:");
        String city = input.nextLine();
        System.out.println("Enter street:");
        String street = input.nextLine();
        System.out.println("Enter house number:");
        Integer houseNumber = Integer.valueOf(input.nextLine());
        System.out.println("Enter appartment number:");
        Integer appartmentNumber = Integer.valueOf(input.nextLine());
        System.out.println("Enter appartment id:");
        Integer appartmentId = Integer.valueOf(input.nextLine());
        AppartmentAdress appartmentAdress =
                new AppartmentAdress(null, country, city, street, houseNumber, appartmentNumber, appartmentId);
        System.out.printf("There are created %d rows\n", appartmentAdressController.update(id, appartmentAdress));
    }

    private void deleteFromAppartmentAdress() {
        System.out.println("Enter id:");
        Integer id = Integer.valueOf(input.nextLine());
        System.out.printf("There are deleted %d rows\n",appartmentAdressController.delete(id));
    }

    private void findAllAppartmentAdresses() {
        List<AppartmentAdress> appartmentAdresses = appartmentAdressController.findAll();
        for (AppartmentAdress appartmentAdress : appartmentAdresses) {
            System.out.println(appartmentAdress);
        }
        System.out.println("-----------------------------------------------------------");
    }

    private void findAppartmentAdressById() {
        System.out.println("Enter 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));
        Optional<AppartmentAdress> book = appartmentAdressController.findById(id);
        System.out.println(book.orElse(nullAppartmentAdress));
    }

    private void createAppartment() {
        System.out.println("Enter area:");
        Integer area = Integer.valueOf(input.nextLine());
        System.out.println("Enter room number:");
        Integer roomNumber = Integer.valueOf(input.nextLine());
        System.out.println("Enter overall rating:");
        Integer overallRating = Integer.valueOf(input.nextLine());
        System.out.println("Enter price per day:");
        Integer pricePerDay = Integer.valueOf(input.nextLine());
        System.out.println("Enter renter id:");
        Integer renterId = Integer.valueOf(input.nextLine());
        Appartment appartment =
                new Appartment(null, area, roomNumber, overallRating, pricePerDay, renterId);
        System.out.printf("There are created %d rows\n", appartmentController.create(appartment));
    }

    private void updateAppartment() {
        System.out.println("Enter id:");
        Integer id = Integer.valueOf(input.nextLine());
        System.out.println("Enter area:");
        Integer area = Integer.valueOf(input.nextLine());
        System.out.println("Enter room number:");
        Integer roomNumber = Integer.valueOf(input.nextLine());
        System.out.println("Enter overall rating:");
        Integer overallRating = Integer.valueOf(input.nextLine());
        System.out.println("Enter price per day:");
        Integer pricePerDay = Integer.valueOf(input.nextLine());
        System.out.println("Enter renter id:");
        Integer renterId = Integer.valueOf(input.nextLine());
        Appartment appartment =
                new Appartment(null, area, roomNumber, overallRating, pricePerDay, renterId);
        System.out.printf("There are updated %d rows\n", appartmentController.update(id,appartment));
    }

    private void deleteFromAppartment() {
        System.out.println("Enter id:");
        Integer id = Integer.valueOf(input.nextLine());
        System.out.printf("There are deleted %d rows\n",appartmentController.delete(id));
    }

    private void findAllAppartment() {
        List<Appartment> appartments = appartmentController.findAll();
        for (Appartment appartment : appartments) {
            System.out.println(appartment);
        }
        System.out.println("-----------------------------------------------------------");
    }

    private void findAppartmentById() {
        System.out.println("Enter id: ");
        Integer id = Integer.valueOf((input.nextLine()));
        Optional<Appartment> appartment = appartmentController.findById(id);
        System.out.println(appartment.orElse(nullAppartment));
    }

    private void findAppartmentByRating() {
        System.out.println("Enter rating: ");
        Integer rating = Integer.valueOf((input.nextLine()));
        Optional<List<Appartment>> appartment = appartmentController.getAppartmentsByRating(rating);
        System.out.println(appartment.orElse(null));
    }

    private void createRentee() {
        System.out.println("Enter name:");
        String name = input.nextLine();
        System.out.println("Enter surname:");
        String surname = input.nextLine();
        System.out.println("Enter phone number:");
        String phoneNumber = input.nextLine();
        System.out.println("Enter email:");
        String email = input.nextLine();
        System.out.println("Enter gender:");
        String gender = input.nextLine();
        System.out.println("Enter birthday:");
        String birthday = input.nextLine();
        Rentee rentee =
                new Rentee(null, name, surname,phoneNumber, email, gender, birthday);
        System.out.printf("There are created %d rows\n", renteeController.create(rentee));
    }

    private void updateRentee() {
        System.out.println("Enter id:");
        Integer id = Integer.valueOf(input.nextLine());
        System.out.println("Enter name:");
        String name = input.nextLine();
        System.out.println("Enter surname:");
        String surname = input.nextLine();
        System.out.println("Enter phone number:");
        String phoneNumber = input.nextLine();
        System.out.println("Enter email:");
        String email = input.nextLine();
        System.out.println("Enter gender:");
        String gender = input.nextLine();
        System.out.println("Enter birthday:");
        String birthday = input.nextLine();
        Rentee rentee =
                new Rentee(null, name, surname,phoneNumber, email, gender, birthday);
        System.out.printf("There are created %d rows\n", renteeController.update(id, rentee));
    }

    private void deleteFromRentee() {
        System.out.println("Enter id:");
        Integer id = Integer.valueOf(input.nextLine());
        System.out.printf("There are deleted %d rows\n",renteeController.delete(id));
    }

    private void findAllRentee() {
        List<Rentee> rentees = renteeController.findAll();
        for (Rentee rentee : rentees) {
            System.out.println(rentee);
        }
        System.out.println("-----------------------------------------------------------");
    }

    private void findRenteeById() {
        System.out.println("Enter id: ");
        Integer id = Integer.valueOf((input.nextLine()));
        Optional<Rentee> rentee = renteeController.findById(id);
        System.out.println(rentee.orElse(nullRentee));
    }

    private void findRenteeByGender() {
        System.out.println("Enter gender: ");
        String gender = input.nextLine();
        Optional<List<Rentee>> rentees = renteeController.getRenteesByGender(gender);
        System.out.println(rentees.orElse(null));
    }

    private void createRenter() {
        System.out.println("Enter name:");
        String name = input.nextLine();
        System.out.println("Enter surname:");
        String surname = input.nextLine();
        System.out.println("Enter phone number:");
        String phoneNumber = input.nextLine();
        System.out.println("Enter email:");
        String email = input.nextLine();
        Renter renter =
                new Renter(null, name, surname,phoneNumber, email);
        System.out.printf("There are created %d rows\n", renterController.create(renter));
    }

    private void updateRenter() {
        System.out.println("Enter id:");
        Integer id = Integer.valueOf(input.nextLine());
        System.out.println("Enter name:");
        String name = input.nextLine();
        System.out.println("Enter surname:");
        String surname = input.nextLine();
        System.out.println("Enter phone number:");
        String phoneNumber = input.nextLine();
        System.out.println("Enter email:");
        String email = input.nextLine();
        Renter renter =
                new Renter(null, name, surname,phoneNumber, email);
        System.out.printf("There are created %d rows\n", renterController.update(id, renter));
    }

    private void deleteFromRenter() {
        System.out.println("Enter id:");
        Integer id = Integer.valueOf(input.nextLine());
        System.out.printf("There are deleted %d rows\n",renterController.delete(id));
    }

    private void findAllRenter() {
        List<Renter> renters = renterController.findAll();
        for (Renter renter : renters) {
            System.out.println(renter);
        }
        System.out.println("-----------------------------------------------------------");
    }

    private void findRenterById() {
        System.out.println("Enter id: ");
        Integer id = Integer.valueOf((input.nextLine()));
        Optional<Renter> renter = renterController.findById(id);
        System.out.println(renter.orElse(nullRenter));
    }

    private void createRequest() {
        System.out.println("Enter start date:");
        String startDate = input.nextLine();
        System.out.println("Enter end date:");
        String endDate = input.nextLine();
        System.out.println("Enter rentee id:");
        Integer renteeId = Integer.valueOf(input.nextLine());
        System.out.println("Enter appartment id:");
        Integer appartmentId = Integer.valueOf(input.nextLine());
        Request request =
                new Request(null,startDate, endDate, renteeId, appartmentId);
        System.out.printf("There are created %d rows\n", requestController.create(request));
    }

    private void updateRequest() {
        System.out.println("Enter id:");
        Integer id = Integer.valueOf(input.nextLine());
        System.out.println("Enter start date:");
        String startDate = input.nextLine();
        System.out.println("Enter end date:");
        String endDate = input.nextLine();
        System.out.println("Enter rentee id:");
        Integer renteeId = Integer.valueOf(input.nextLine());
        System.out.println("Enter appartment id:");
        Integer appartmentId = Integer.valueOf(input.nextLine());
        Request request =
                new Request(null,startDate, endDate, renteeId, appartmentId);
        System.out.printf("There are updated %d rows\n", requestController.update(id, request));
    }

    private void deleteFromRequest() {
        System.out.println("Enter id:");
        Integer id = Integer.valueOf(input.nextLine());
        System.out.printf("There are deleted %d rows\n",requestController.delete(id));
    }

    private void findAllRequest() {
        List<Request> renters = requestController.findAll();
        for (Request request : renters) {
            System.out.println(request);
        }
        System.out.println("-----------------------------------------------------------");
    }

    private void findRequestById() {
        System.out.println("Enter id: ");
        Integer id = Integer.valueOf((input.nextLine()));
        Optional<Request> request = requestController.findById(id);
        System.out.println(request.orElse(nullRequest));
    }

    private void createAvailableTime() {
        System.out.println("Enter start date:");
        String startDate = input.nextLine();
        System.out.println("Enter end date:");
        String endDate = input.nextLine();
        AvailableTime availableTime =
                new AvailableTime(null,startDate, endDate);
        System.out.printf("There are created %d rows\n", availableTimeController.create(availableTime));
    }

    private void updateAvailableTime() {
        System.out.println("Enter id:");
        Integer id = Integer.valueOf(input.nextLine());
        System.out.println("Enter start date:");
        String startDate = input.nextLine();
        System.out.println("Enter end date:");
        String endDate = input.nextLine();
        AvailableTime availableTime =
                new AvailableTime(null,startDate, endDate);
        System.out.printf("There are update %d rows\n", availableTimeController.update(id, availableTime));
    }

    private void deleteFromAvailableTime() {
        System.out.println("Enter id:");
        Integer id = Integer.valueOf(input.nextLine());
        System.out.printf("There are deleted %d rows\n",availableTimeController.delete(id));
    }

    private void findAllAvailableTime() {
        List<AvailableTime> availableTimes = availableTimeController.findAll();
        for (AvailableTime availableTime : availableTimes) {
            System.out.println(availableTime);
        }
        System.out.println("-----------------------------------------------------------");
    }

    private void findAvailableTimeById() {
        System.out.println("Enter id: ");
        Integer id = Integer.valueOf((input.nextLine()));
        Optional<AvailableTime> request = availableTimeController.findById(id);
        System.out.println(request.orElse(nullAvailableTime));
    }

    private void createResponse() {
        System.out.println("Enter photo href:");
        String photoHref = input.nextLine();
        System.out.println("Enter text response:");
        String textResponse = input.nextLine();
        System.out.println("Enter rating:");
        Integer rating = Integer.valueOf(input.nextLine());
        Response response =
                new Response(null, photoHref, textResponse, rating);
        System.out.printf("There are created %d rows\n", responseController.create(response));
    }

    private void updateResponse() {
        System.out.println("Enter id:");
        Integer id = Integer.valueOf(input.nextLine());
        System.out.println("Enter photo href:");
        String photoHref = input.nextLine();
        System.out.println("Enter text response:");
        String textResponse = input.nextLine();
        System.out.println("Enter rating:");
        Integer rating = Integer.valueOf(input.nextLine());
        Response response =
                new Response(null, photoHref, textResponse, rating);
        System.out.printf("There are updated %d rows\n", responseController.update(id, response));
    }

    private void deleteFromResponse() {
        System.out.println("Enter id:");
        Integer id = Integer.valueOf(input.nextLine());
        System.out.printf("There are deleted %d rows\n",responseController.delete(id));
    }

    private void findAllResponse() {
        List<Response> responses = responseController.findAll();
        for (Response response : responses) {
            System.out.println(response);
        }
        System.out.println("-----------------------------------------------------------");
    }

    private void findResponseById() {
        System.out.println("Enter id: ");
        Integer id = Integer.valueOf((input.nextLine()));
        Optional<Response> response = responseController.findById(id);
        System.out.println(response.orElse(nullResponse));
    }

    private void findResponseByRating() {
        System.out.println("Enter rating: ");
        Integer rating = Integer.valueOf((input.nextLine()));
        Optional<Response> response = responseController.findById(rating);
        System.out.println(response.orElse(nullResponse));
    }

    private void selectAll() {
        findAllAppartmentAdresses();
        findAllAppartment();
        findAllAvailableTime();
        findAllRentee();
        findAllRenter();
        findAllRequest();
        findAllResponse();
    }

    private void outputMenu() {
        System.out.println("\nMENU:");
        for (String key : menu.keySet())
            if (key.length() == 1) System.out.println(menu.get(key));
    }

    private void outputSubMenu(String fig) {

        System.out.println("\nSubMENU:");
        for (String key : menu.keySet())
            if (key.length() != 1 && key.substring(0, 1).equals(fig)) System.out.println(menu.get(key));
    }

    public void show() {
        String keyMenu;
        do {
            outputMenu();
            System.out.println("Select menu point");
            keyMenu = input.nextLine().toUpperCase();

            if (keyMenu.matches("^\\d")) {
                outputSubMenu(keyMenu);
                System.out.println("Select menu point");
                keyMenu = input.nextLine().toUpperCase();
            }

            try {
                methodsMenu.get(keyMenu).print();
            } catch (Exception e) {
                System.out.println(e);
            }
        } while (!keyMenu.equals("Q"));
    }
}

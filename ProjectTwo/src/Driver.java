import java.util.ArrayList;
import java.util.Scanner;

public class Driver {
    private static ArrayList<Dog> dogList = new ArrayList<Dog>();
    private static ArrayList<Monkey> monkeyList = new ArrayList<Monkey>();
    private static Scanner scanner = new Scanner(System.in); // Scanner for user input

    public static void main(String[] args) {
        initializeDogList();
        initializeMonkeyList();

        char choice;

        do {
            displayMenu();
            choice = scanner.nextLine().charAt(0);

            switch (choice) {
                case '1':
                    intakeNewDog();
                    break;
                case '2':
                    intakeNewMonkey();
                    break;
                case '3':
                    reserveAnimal();
                    break;
                case '4':
                    printDogs();
                    break;
                case '5':
                    printMonkeys();
                    break;
                case '6':
                    printAnimals();
                    break;
                case 'q':
                case 'Q':
                    System.out.println("Exiting the application.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        } while (choice != 'q' && choice != 'Q');
    }

    public static void displayMenu() {
        System.out.println("\n\n");
        System.out.println("\t\t\t\tRescue Animal System Menu");
        System.out.println("[1] Intake a new dog");
        System.out.println("[2] Intake a new monkey");
        System.out.println("[3] Reserve an animal");
        System.out.println("[4] Print a list of all dogs");
        System.out.println("[5] Print a list of all monkeys");
        System.out.println("[6] Print a list of all available animals");
        System.out.println("[q] Quit application");
        System.out.println();
        System.out.println("Enter a menu selection");
    }

    public static void initializeDogList() {
        // Existing code to initialize dog list
    }

    public static void initializeMonkeyList() {
        // Existing code to initialize monkey list
    }

    public static void intakeNewDog() {
        System.out.println("Enter the dog's name:");
        String name = scanner.nextLine();

        if (name.isEmpty()) {
            System.out.println("Invalid name. Name cannot be empty.");
            return;
        }

        System.out.println("Enter the dog's breed:");
        String breed = scanner.nextLine();

        System.out.println("Enter the dog's gender (male/female):");
        String gender = scanner.nextLine();

        System.out.println("Enter the dog's age:");
        String age = scanner.nextLine();

        System.out.println("Enter the dog's weight:");
        String weight = scanner.nextLine();

        System.out.println("Enter the dog's birthdate (MM-DD-YYYY):");
        String birthdate = scanner.nextLine();

        System.out.println("Enter the dog's acquisition country:");
        String acquisitionCountry = scanner.nextLine();

        System.out.println("Enter the dog's status (intake/Phase I/in service):");
        String status = scanner.nextLine();

        System.out.println("Is the dog reserved? (true/false):");
        boolean reserved = Boolean.parseBoolean(scanner.nextLine());

        System.out.println("Enter the dog's in-service country:");
        String inServiceCountry = scanner.nextLine();

        Dog newDog = new Dog(name, breed, gender, age, weight, birthdate, acquisitionCountry, status, reserved,
                inServiceCountry);
        dogList.add(newDog);

        System.out.println(name + " has been added to the system.");
    }

    public static void intakeNewMonkey() {
        System.out.println("Enter the monkey's name:");
        String name = scanner.nextLine();

        if (name.isEmpty()) {
            System.out.println("Invalid name. Name cannot be empty.");
            return;
        }

        for (Monkey monkey : monkeyList) {
            if (monkey.getName().equalsIgnoreCase(name)) {
                System.out.println("\nThis monkey is already in our system.");
                return;
            }
        }

        System.out.println("Enter the tail length:");
        String tailLength = scanner.nextLine();

        System.out.println("Enter the height:");
        String height = scanner.nextLine();

        System.out.println("Enter the body length:");
        String bodyLength = scanner.nextLine();

        System.out.println("Enter the species:");
        String species = scanner.nextLine();

        System.out.println("Is the monkey reserved? (true/false):");
        boolean reserved = Boolean.parseBoolean(scanner.nextLine());

        Monkey newMonkey = new Monkey(tailLength, height, bodyLength, species);
        newMonkey.setReserved(reserved);
        monkeyList.add(newMonkey);

        System.out.println(name + " has been added to the system.");
    }

    public static void reserveAnimal() {
        System.out.println("Enter the type of animal you want to reserve (dog/monkey):");
        String animalType = scanner.nextLine();

        if (!animalType.equalsIgnoreCase("dog") && !animalType.equalsIgnoreCase("monkey")) {
            System.out.println("Invalid animal type selection.");
            return;
        }

        System.out.println("Enter the country where the animal is in service:");
        String serviceCountry = scanner.nextLine();

        boolean found = false;

        if (animalType.equalsIgnoreCase("dog")) {
            for (Dog dog : dogList) {
                if (dog.getStatus().equalsIgnoreCase("in service") && !dog.isReserved()
                        && dog.getInServiceCountry().equalsIgnoreCase(serviceCountry)) {
                    dog.setReserved(true);
                    found = true;
                    System.out.println("Dog reserved successfully.");
                    break;
                } else if (dog.getStatus().equalsIgnoreCase("in service") && dog.isReserved()
                        && dog.getInServiceCountry().equalsIgnoreCase(serviceCountry)) {
                    System.out.println("Dog is already reserved.");
                    found = true;
                    break;
                }
            }
        } else if (animalType.equalsIgnoreCase("monkey")) {
            for (Monkey monkey : monkeyList) {
                if (monkey.getStatus().equalsIgnoreCase("in service") && !monkey.isReserved()
                        && monkey.getInServiceCountry().equalsIgnoreCase(serviceCountry)) {
                    monkey.setReserved(true);
                    found = true;
                    System.out.println("Monkey reserved successfully.");
                    break;
                } else if (monkey.getStatus().equalsIgnoreCase("in service") && monkey.isReserved()
                        && monkey.getInServiceCountry().equalsIgnoreCase(serviceCountry)) {
                    System.out.println("Monkey is already reserved.");
                    found = true;
                    break;
                }
            }
        }

        if (!found) {
            System.out.println("No matching animal found for reservation.");
        }
    }

    // Printing details of Dogs
    public static void printDogs() {
        System.out.println("List of Dogs:");
        for (Dog dog : dogList) {
            System.out.println("Name: " + dog.getName());
            System.out.println("Breed: " + dog.getBreed());
            System.out.println("Gender: " + dog.getGender());
            System.out.println("Age: " + dog.getAge());
            System.out.println("Weight: " + dog.getWeight());
            System.out.println("Birthdate: " + dog.getBirthdate());
            System.out.println("Acquisition Country: " + dog.getAcquisitionCountry());
            System.out.println("Status: " + dog.getStatus());
            System.out.println("Reserved: " + (dog.isReserved() ? "Yes" : "No"));
            System.out.println("In Service Country: " + dog.getInServiceCountry());
            System.out.println();
        }
    }

    // Printing details of monkeys
    public static void printMonkeys() {
        System.out.println("List of Monkeys:");
        for (Monkey monkey : monkeyList) {
            System.out.println("Name: " + monkey.getName());
            System.out.println("Tail Length: " + monkey.getTailLength());
            System.out.println("Height: " + monkey.getHeight());
            System.out.println("Body Length: " + monkey.getBodyLength());
            System.out.println("Species: " + monkey.getSpecies());
            System.out.println();
        }
    }

    // Printing Animals
    public static void printAnimals() {
        System.out.println("Enter the type of animals you want to print (dog/monkey/available):");
        String animalType = scanner.nextLine().toLowerCase(); // Convert to lowercase for case-insensitive comparison

        if (animalType.equals("dog")) {
            System.out.println("List of Dogs:");
            for (Dog dog : dogList) {
                System.out.println("Name: " + dog.getName());
                System.out.println("Breed: " + dog.getBreed());
                System.out.println("Gender: " + dog.getGender());
                System.out.println("Age: " + dog.getAge());
                System.out.println("Weight: " + dog.getWeight());
                System.out.println("Birthdate: " + dog.getBirthdate());
                System.out.println("Acquisition Country: " + dog.getAcquisitionCountry());
                System.out.println("Status: " + dog.getStatus());
                System.out.println("Reserved: " + (dog.isReserved() ? "Yes" : "No"));
                System.out.println("In Service Country: " + dog.getInServiceCountry());
                System.out.println();
            }
        } else if (animalType.equals("monkey")) {
            System.out.println("List of Monkeys:");
            for (Monkey monkey : monkeyList) {
                System.out.println("Name: " + monkey.getName());
                System.out.println("Tail Length: " + monkey.getTailLength());
                System.out.println("Height: " + monkey.getHeight());
                System.out.println("Body Length: " + monkey.getBodyLength());
                System.out.println("Species: " + monkey.getSpecies());
                System.out.println();
            }
        } else if (animalType.equals("available")) {
            System.out.println("List of Available Animals:");

            // Print available dogs
            System.out.println("Available Dogs:");
            for (Dog dog : dogList) {
                if (dog.getStatus().equalsIgnoreCase("in service") && !dog.isReserved()) {
                    System.out.println("Name: " + dog.getName());
                    System.out.println("Status: " + dog.getStatus());
                    System.out.println("Acquisition Country: " + dog.getAcquisitionCountry());
                    System.out.println("Reserved: No");
                    System.out.println();
                }
            }

            // Print available monkeys
            System.out.println("Available Monkeys:");
            for (Monkey monkey : monkeyList) {
                if (monkey.getStatus().equalsIgnoreCase("in service") && !monkey.isReserved()) {
                    System.out.println("Name: " + monkey.getName());
                    System.out.println("Status: " + monkey.getStatus());
                    System.out.println("Acquisition Country: " + monkey.getAcquisitionCountry());
                    System.out.println("Reserved: No");
                    System.out.println();
                }
            }
        } else {
            System.out.println("Invalid animal type selection.");
        }
    }
}

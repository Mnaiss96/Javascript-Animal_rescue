import java.util.Scanner;

public class Monkey extends RescueAnimal {
    // Additional instance variables
    private String tailLength;
    private String height;
    private String bodyLength;
    private String species;

    // Constructor
    public Monkey(String tailLength, String height, String bodyLength, String species) {
        this.tailLength = tailLength;
        this.height = height;
        this.bodyLength = bodyLength;
        this.species = species;
    }

    // Accessor methods
    public String getTailLength() {
        return tailLength;
    }

    public void setTailLength(String tailLength) {
        this.tailLength = tailLength;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getBodyLength() {
        return bodyLength;
    }

    public void setBodyLength(String bodyLength) {
        this.bodyLength = bodyLength;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public void setReserveStatusFromUserInput() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("What is the new monkey's reserve status? (true/false)\n");
        boolean reserved = scanner.nextBoolean();
        scanner.nextLine(); // Consume the newline character

        // Set the reserve status using the setter method
        setReserved(reserved);

        // Close the scanner if you don't need it anymore
        scanner.close();
    }

    public String getStatus() {
        return null;
    }

    public boolean isReserved() {
        return false;
    }

    public String getAcquisitionCountry() {
        return null;
    }

    public String getInServiceCountry() {
        return null;
    }
}

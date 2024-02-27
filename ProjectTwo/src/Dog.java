
public class Dog extends RescueAnimal {
    private String name;
    private String breed;
    private String gender;
    private String age;
    private String weight;
    private String birthdate;
    private String acquisitionCountry;
    private String status;
    private boolean reserved;
    private String inServiceCountry;

    public Dog(String name, String breed, String gender, String age, String weight, String birthdate,
            String acquisitionCountry, String status, boolean reserved, String inServiceCountry) {
        // Initialize the instance variables
        this.name = name;
        this.breed = breed;
        this.gender = gender;
        this.age = age;
        this.weight = weight;
        this.birthdate = birthdate;
        this.acquisitionCountry = acquisitionCountry;
        this.status = status;
        this.reserved = reserved;
        this.inServiceCountry = inServiceCountry;
    }

    // Getter methods for Dog attributes
    public String getName() {
        return name;
    }

    public String getBreed() {
        return breed;
    }

    public String getGender() {
        return gender;
    }

    public String getAge() {
        return age;
    }

    public String getWeight() {
        return weight;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public String getAcquisitionCountry() {
        return acquisitionCountry;
    }

    public String getStatus() {
        return status;
    }

    public boolean isReserved() {
        return reserved;
    }

    public String getInServiceCountry() {
        return inServiceCountry;
    }
}

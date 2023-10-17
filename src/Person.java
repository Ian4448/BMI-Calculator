import java.text.DecimalFormat;

public class Person {
    /*
    * initialize variables, we use private so they're specific to this class and dont interfere with other classes.
    * */
    private String firstName, lastName;
    private double heightInches, weightPounds;
    public  DecimalFormat df = new DecimalFormat("0.00");

    // creating a constructor for Person with the four parameters Strings firstName, lastName and int height,weight.
    public Person(String firstName, String lastName, double heightInches, double weightPounds) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.heightInches = heightInches;
        this.weightPounds = weightPounds;
    }
    // getters and setters
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public double getHeightInches() {
        return heightInches;
    }

    public void setHeightInches(double heightInches) {
        this.heightInches = heightInches;
    }

    public double getWeightPounds() {
        return weightPounds;
    }

    public void setWeightPounds(double weightPounds) {
        this.weightPounds = weightPounds;
    }
    // returns a double type with the calculation weight / (height * height *703)
    public double calculateBMI() {
        double bmi = 0;
        bmi = (weightPounds / ((heightInches) * (heightInches))) * 703;
        return bmi;
    }
    // checks for different values of parameter bmi and sets String healthStatus to a different text
    // based off the results, returning healthStatus.
    public String determineHealth(double aBMI) {
        String healthStatus = "";
        if (aBMI < 18.5) {
            healthStatus = "underweight";
        } else if (aBMI >= 18.5 && aBMI < 25) {
            healthStatus = "healthy";
        } else if (aBMI >= 25 && aBMI < 30) {
            healthStatus = "overweight";
        } else if (aBMI >= 30 && aBMI <= 39.9) {
            healthStatus = "obese";
        } else if (aBMI > 39.99) {
            healthStatus = "extremely obese";
        }
        return healthStatus;
    }
    // returns double optimumweight which is 25 * heightInches^2 ) / 703.
    public double recommendedWeight() {
        double optimumWeight = 0;
        //Use the following formula to determine an optimum weight
        // given the weight and height of the person:
        optimumWeight = (25 * Math.pow(heightInches, 2))/703;
        return optimumWeight;
    }
    //general tostring function returning all the values as a string.
    public String toString() {
        return firstName.substring(0,1).toUpperCase() + firstName.substring(1) + " " + lastName.substring(0,1).toUpperCase() + lastName.substring(1) + " weighs " + df.format(weightPounds) + " pounds and measures " + df.format(heightInches) + " inches tall.";
    }
}

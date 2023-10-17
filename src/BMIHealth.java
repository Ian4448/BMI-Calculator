/*
* @Ian Borges
* Title: BMI Health Program
* Semester: COP 2210, Fall 2023
* Professor's Name: Prof. Charters
* Description of Program Functionality:
* The program takes in four user inputs through JOptionPane and uses them to calculate bmi and recommended weight in a
* domain class and then with these calculations output them to a JOptionPane message box for the user to read and learn from.
* The program uses decimal formatting to ensure that the double(s) do not show up as 5.242424444444 for example.
* */

import javax.swing.JOptionPane;
import java.text.DecimalFormat;

public class BMIHealth {
    public static DecimalFormat df = new DecimalFormat("0.00");
    public static void main(String[] args) {
        Person aPerson = createPersonObject();
        showBMI(aPerson);
    } // creating an object and passing it in as a parameter for showBMI

    /*
    object from the Person class that asks the user for four different inputs.
    Strings firstName, lastName and int height,weight.
    returning them as an object with the four parameters of the Person class
     */
    public static Person createPersonObject() {
        String firstName, lastName;
        double height;
        double weight;

        firstName = JOptionPane.showInputDialog("Whats your first name?:");
        lastName = JOptionPane.showInputDialog("Whats your last name?:");

        height = Double.parseDouble(JOptionPane.showInputDialog("Whats your height?(in inches):"));
        weight = Double.parseDouble((JOptionPane.showInputDialog("Whats your weight?(in lbs):")));

        return new Person(firstName, lastName, height, weight);
    }

    /*
    takes in aPerson object as a parameter, and uses the values done from the calculations and getters and setters to
    output the proper bmi, information, and recommended weight for the user.
     */

    public static void showBMI(Person aPerson) {
        JOptionPane.showMessageDialog(null,aPerson);
        JOptionPane.showMessageDialog(null, "Your BMI is " + df.format(aPerson.calculateBMI()));
        JOptionPane.showMessageDialog(null, "You're " +aPerson.determineHealth(aPerson.calculateBMI()) + ".");

        if (aPerson.determineHealth(aPerson.calculateBMI()).equals("underweight") || aPerson.determineHealth(aPerson.calculateBMI()).equals("overweight")||
        aPerson.determineHealth(aPerson.calculateBMI()).equals("obese") || aPerson.determineHealth(aPerson.calculateBMI()).equals("extremely obese")) {
            JOptionPane.showMessageDialog(null, "Your recommended weight is " + df.format(aPerson.recommendedWeight()));
        } // if the person's bmi response is considered to not be at their best, it will calculate their recommended weight.

    }

}

package com.example.project;
public class LinearCalculator{
    //FOR EXTRA CREDIT 
    //you should copy and paste all of your code from the LinearCalculator class
    // but NOT printInfo(). Please update it below
        //INSTANCE VARIABLES 
    //4 INTEGER variables (name them: x1,x2,y1,y2) 
    int x1;
    int x2;
    int y1;
    int y2;


    //CONSTRUCTOR
    //1 constructor with 2 String parameters. Each parameter represents a coordinate. 
    //For example, "(1,2)" and "(3,4)" would be two parameter values 
    //You will have to parse the string into 4 integers, representing the 2 points.
    public LinearCalculator(String point1, String point2){ // <--add 2 string parameters to this constructor
        int commaIndex = point1.indexOf(","); // gets location of divide between x and y
        x1 = Integer.parseInt(point1.substring(1, commaIndex)); // extracts x
        y1 = Integer.parseInt(point1.substring(commaIndex + 1, point1.length()-1)); // extracts y

        commaIndex = point2.indexOf(",");
        x2 = Integer.parseInt(point2.substring(1, commaIndex));
        y2 = Integer.parseInt(point2.substring(commaIndex + 1, point2.length()-1));
    }



    //METHODS
    //getters and setters for the 4 instance variables (8 methods total) 
    public int getX1(){
        return x1;
    }
    public int getY1(){
        return y1;
    }
    public int getX2(){
        return x2;
    }
    public int getY2(){
        return y2;
    }
    public void setX1(int newVal){
        x1 = newVal;
    }
    public void setY1(int newVal){
        y1 = newVal;
    }
    public void setX2(int newVal){
        x2 = newVal;
    }
    public void setY2(int newVal){
        y2 = newVal;
    }


    //distance() -> returns a double. 
    //calculates the distance between the two points to the nearest HUNDREDTH and returns the value.
    public double distance(){
        return roundedToHundredth(Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2))); // uses pythagorean theorem
    }

    //yInt() -> returns a double.
    //calculates the y intercept of the equation and returns the value to the nearest HUNDREDTH
    //if y-int if undefined, should return -999.99
    public double yInt(){
        if(x2-x1 != 0){ // makes sure line is not vertical
            return roundedToHundredth(y1 - (x1*slope())); // solves for y when x = 0
        }
        else{
            return -999.99;
        }
    }

    //slope() -> returns a double. 
    //calculates the slope of the equations and returns the value to the nearest HUNDREDTH
    //if slope is undefined, should return -999.99
    public double slope(){
        if(x2-x1 != 0){ // makes sure line is not vertical
            return roundedToHundredth((double)(y2-y1)/(x2-x1)); // slope is Δx/Δy
        }
        else{
            return -999.99;
        }
    }

    //equations() -> returns a String.
    //calculates the final equation in y=mx+b form and returns the string
    //if the equation has no slope, the equation should return -> "undefined"
    //HINT: You may need other custom methods to decrease the amount of code in the equations() method
    public String equation(){
        String output = "";
        if (x2-x1 == 0){ // if line is vertical, return "undefined"
            return "undefined";
        }
        else{ // otherwise, begin writing equation
            output += "y=";
        }
        if (slope() != 0){ // if slope() == 0, you don't need the x term, and the equation is y=yInt()
            output += slope() + "x";
            if (yInt() > 0){ // if there is a slope, and the yInt is positive, a + sign is neccesary to connect the x and constant terms
                output += "+"; // it is not necesary to account for if yInt is negative here, because the integer will have its own - sign
            }
        }
        if (yInt() != 0){ // if yInt() == 0, the constant term should not be included
            output += yInt();
        }

        return output;
    }


    //roundedToHundredth(double x)-> returns double
    //calculates the input to the nearest hundredth and returns that value
    public double roundedToHundredth(double x){
        if (x > 0){ // x is positive case
            return ((int) (x*100+.5))/100.0;
        }
        else{ // x is negative case
            return ((int) (x*100-.5))/100.0;
        }
    }

    //You will need to concatenate to the string 
    //the results from findSymmetry() and Midpoint()
    public String printInfo(){
        String str = "The two points are: (" + x1 + "," + y1 + ")";
        str += " and " + "(" + x2 + "," + y2 + ")";
        str += "\nThe equation of the line between these points is: "  + equation();
        str += "\nThe slope of this line is: " + slope();
        str += "\nThe y-intercept of the line is: " + yInt();
        str += "\nThe distance between the two points is: " + distance();
        str += "\n" + findSymmetry();
        str += "\n" + Midpoint();
 
        return str;
    }

    //findSymmetry()-> returns a string 
    //the method should determine if there is symmetry between the two points
    // there should be  4 return statements 
    // return "Symmetric about the x-axis";
    // return "Symmetric about the y-axis";
    //return "Symmetric about the origin";
    //return "No symmetry";
    public String findSymmetry(){
        if (x1 == x2 && y1 == -y2){ // there is x-axis symetry when two points have the same xs and their ys are negatives of each other. 
            return "Symmetric about the x-axis";
        }
        else if (y1 == y2 && x1 == -x2){ // there is y-axis symetry when two points have the same ys and their xs are negatives of each other. 
            return "Symmetric about the y-axis";
        }
        else if (x1 == -x2 && y1 == -y2){ // there is origin symetry when the xs and ys are negatives of each other.
            return "Symmetric about the origin";
        }
        else{
            return "No symmetry";
        }
    }

    //Midpoint()->return a string 
    //the method should calculate the midpoint between the two points
    //it should return "The midpoint of this line is: (0,0)";
    public String Midpoint(){
        // the x and y of the midpoint of a line is the average of the x and y coordinates of the two endpoints.
        double x = roundedToHundredth((x1 + x2)/2);
        double y = roundedToHundredth((y1 + y2)/2);

        return "The midpoint of this line is: (" + x + "," + y + ")";
    }

}




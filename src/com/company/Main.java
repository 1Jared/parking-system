package com.company;

import java.util.*;

public class Main {
    static Stack<Integer> parkingLot = new Stack<>();
    static Stack<Integer> street = new Stack<>();
    static Queue<Integer> waiting = new LinkedList<>();

    public static String SpecialParkingDecal = "Park2547";

    public static void main(String[] args) {
        System.out.println("############ PARKING SYSTEM  ########");

        Scanner scanner = new Scanner(System.in);
        System.out.println("(+)in front of the number indicates that you want to park your car");
        System.out.println("");
        System.out.println("(-) in front of the number indicates that you want to remove  your car from the parking lot");
        System.out.println("");
        System.out.println(" (0)Enter zero to cancel operations");
        System.out.println("");

          while (true) {
              Integer licenseNumber = scanner.nextInt();

              //  attempt to park a car
              if (licenseNumber > 0) {
                  System.out.println("Please enter special decal for your car!");
                  //Reading user input for decal
                  String userInput = scanner.next();

                  //checks if decal provided by user is the same to needed decal for parking
                  if (userInput.equals(SpecialParkingDecal)){
                      if (parkingLot.size() < 20 && parkingLot.size() >= 0) {

                          System.out.println("Their is parking space available in the parking lot");
                          parkingLot.push(licenseNumber);

                      } else if (parkingLot.size() == 20) {
                          
                          System.out.println("The parking lot is full,your vehicle will be on waiting ");
                          waiting.add(licenseNumber);

                      }
                  } else {
                      System.out.println("The decal " + userInput + " you have provided is not valid,you are kindly not allowed to use this parking lot");
                  }
                  //prints elements in parking lot
                  System.out.println("The number of parked cars are:");
                  for (int i = 0; i < parkingLot.size(); i++) {
                      System.out.println("Car" + parkingLot.elementAt(i));
                  }

                  System.out.println("The number of cars in the queue");
                  for (Integer element : waiting) {
                      System.out.println(element);

                  }


              }


              //  attempt to remove a car

              else if (licenseNumber < 0) {
                  try {
                      int topCar = parkingLot.peek();  // checks last element of the parking lot
                      int carToBeRemoved = Math.abs(licenseNumber);
                      if (carToBeRemoved == topCar) {
                          parkingLot.pop();
                          if (waiting.isEmpty() == false) {
                              int topElementInQueue = waiting.poll();
                              parkingLot.push(topElementInQueue);
                          }

                      } else {

                          int carPosition = parkingLot.lastIndexOf(carToBeRemoved);     //getting index of car that is  last
                          System.out.println("car position" + carPosition);

                          //pushing to street
                          for (int i = parkingLot.size(); i > carPosition + 1; i--) {
                              int toStreet = parkingLot.pop();
                              street.push(toStreet);
                          }


                          /* System.out.println("The number of cars on the street");
                          for (int i = 0; i < street.size(); i++) {
                              System.out.println("Car" + street.elementAt(i));
                          }  */

                          parkingLot.pop();  //removing car that was not at the last in the parking lot stack


                          //returning cars back
                          for (int j = street.size(); j > 0; j--) {
                              int firstCarOnTheStreet = street.pop(); //is for removing  first car that was taken to the street back to the parking lot
                              parkingLot.push(firstCarOnTheStreet);
                          }

                          //checks if queue is empty,if not it adds the first car to the parking lot
                          if (waiting.isEmpty() == false) {
                              int topElementInQueue = waiting.poll();
                              parkingLot.push(topElementInQueue);
                          }


                          //prints elements in parking lot
                          System.out.println("The number of parked cars are:");
                          for (int i = 0; i < parkingLot.size(); i++) {
                              System.out.println("Car" + parkingLot.elementAt(i));
                          }


                          System.out.println("The number of cars in the queue:");
                          for (Integer element : waiting) {
                              System.out.println(element);

                          }
                      }

                  }catch(Exception exception){
                          System.out.println("Car not parked");
                      }



              }
              // Stopping simulation
              else {
                  System.exit(0);
              }




         System.out.println("############ PARKING SYSTEM  ########");
         System.out.println("");
        System.out.println("(+) in front of the number indicates that you want to park your car");
        System.out.println("");

        System.out.println("(-) in front of the number indicates that you want to remove  your car from the parking lot");

        System.out.println("");

        System.out.println(" (0) Enter zero to cancel operations");
        System.out.println("");




          }
    }
}

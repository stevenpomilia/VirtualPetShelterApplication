import java.util.Scanner;
import java.util.concurrent.TimeUnit;


public class VirtualPetApplication {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        VirtualPetShelter shelter = new VirtualPetShelter();

        System.out.println("Virtual Pet Shelter App v1 is loading...");

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Welcome to the Virtual Pet Shelter!");
        System.out.println("");
        System.out.println("You now own a shelter for housing virtual pets.");
        System.out.println("Do your best to ensure each pet stays healthy!");
        System.out.println("");

        shelter.addPet(new VirtualPet("Zigzag"));
        shelter.addPet(new VirtualPet("Scout"));
        

        while (true) {
            shelter.tickAllPets();

            System.out.println("Your Pets' Stats:");
            for (VirtualPet pet : shelter.getAllPets()) {
                System.out.println(pet.getName() + ":");
                System.out.println("Hunger: " + pet.getHunger());
                System.out.println("Thirst: " + pet.getThirst());
                System.out.println("Waste: " + pet.getWaste());
                System.out.println("Boredom: " + pet.getBoredom());
                System.out.println("Sickness: " + pet.getSickness());
                System.out.println("");
            }

            System.out.println("What action would you like to do? Select action by list #.");
            System.out.println("1. Feed all pets");
            System.out.println("2. Water all pets");
            System.out.println("3. Take all pets out for a potty break");
            System.out.println("4. Play with all pets");
            System.out.println("5. Bring a pet to the vet");
            System.out.println("6. Adopt a pet");
            System.out.println("7. Admit a new pet");
            System.out.println("8. End game");

            int action = input.nextInt();

            switch (action) {
                case 1:
                    shelter.feedAllPets();
                    break;
                case 2:
                    shelter.waterAllPets();
                    break;
                case 3:
                    shelter.pottyBreakAllPets();
                    break;
                case 4:
                    shelter.playWithAllPets();
                    break;
                case 5:
                    System.out.println("Enter the name of the pet you want to bring to the vet:");
                    String petName = input.next();
                    VirtualPet petToVet = shelter.getPetByName(petName);
                    if (petToVet != null) {
                        petToVet.vetVisit();
                    } else {
                        System.out.println("Pet not found in the shelter!");
                    }
                    break;
                case 6:
                    System.out.println("Enter the name of the pet you'd like to adopt:");
                    String petToAdopt = input.next();
                    VirtualPet adoptedPet = shelter.getPetByName(petToAdopt);
                    if (adoptedPet != null) {
                        shelter.removePet(adoptedPet);
                        System.out.println(petToAdopt + " is now yours." + " Congrats!");
                    } else {
                        System.out.println("Pet not found in the shelter!");
                    }
                    break;
                case 7:
                    System.out.println("Enter the name of the pet you would like to admit:");
                    String newPetName = input.next();
                    shelter.addPet(new VirtualPet(newPetName));
                    break;
                case 8:
                    System.out.println("You chose to quit, thus your pets have vanished into thin air...");
                    
                    try {
                        TimeUnit.SECONDS.sleep(2);

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Application terminating.....");

                    try {
                        TimeUnit.SECONDS.sleep(3);

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println("Application terminated.");
                    System.exit(0);
                default:
                    System.out.println("Enter a valid action ID #.");
            }
        input.close();
        }
    }
    
}
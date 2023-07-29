import java.util.ArrayList;
import java.util.List;

public class VirtualPetShelter {

    private List<VirtualPet> pets;

    public VirtualPetShelter() {
        pets = new ArrayList<>();
    }

    public void addPet(VirtualPet pet) {
        pets.add(pet);
    }

    public void removePet(VirtualPet pet) {
        pets.remove(pet);
    }

    public VirtualPet getPetByName(String name) {
        for (VirtualPet pet : pets) {
            if (pet.getName().equals(name)) {
                return pet;
            }
        }
        return null;
    }

    public void feedAllPets() {
        for (VirtualPet pet : pets) {
            pet.feed();
        }
    }

    public void waterAllPets() {
        for (VirtualPet pet : pets) {
            pet.water();
        }
    }

    public void pottyBreakAllPets() {
        for (VirtualPet pet : pets) {
            pet.pottyBreak();
        }
    }

    public void playWithAllPets() {
        for (VirtualPet pet : pets) {
            pet.play();
        }
    }

    public void vetVisitAllPets() {
        for (VirtualPet pet : pets) {
            pet.vetVisit();
        }
    }

    public void tickAllPets() {
        for (VirtualPet pet : pets) {
            pet.tick();
        }
    }

    public List<VirtualPet> getAllPets() {
        return pets;
    }
}
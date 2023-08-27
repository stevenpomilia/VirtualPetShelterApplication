package virtualpet.shelter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class VirtualPetShelterTest {

    @Test
    public void testAdoptPet() {
        VirtualPetShelter shelter = new VirtualPetShelter();
        VirtualPet pet = new VirtualPet("TestPet");
        shelter.addPet(pet);

        assertTrue(shelter.getAllPets().contains(pet));
        shelter.removePet(pet);
        assertFalse(shelter.getAllPets().contains(pet));
    }

    @Test
    public void testTickAllPets() {
        VirtualPetShelter shelter = new VirtualPetShelter();
        VirtualPet pet1 = new VirtualPet("Pet1");
        VirtualPet pet2 = new VirtualPet("Pet2");
        shelter.addPet(pet1);
        shelter.addPet(pet2);

        int pet1HungerBefore = pet1.getHunger();
        int pet2HungerBefore = pet2.getHunger();

        shelter.tickAllPets();

        int pet1HungerAfter = pet1.getHunger();
        int pet2HungerAfter = pet2.getHunger();

        assertTrue(pet1HungerAfter > pet1HungerBefore);
        assertTrue(pet2HungerAfter > pet2HungerBefore);
    }

    @Test
    public void testPlayWithAllPets() {
        VirtualPetShelter shelter = new VirtualPetShelter();
        VirtualPet pet1 = new VirtualPet("Pet1");
        VirtualPet pet2 = new VirtualPet("Pet2");
        shelter.addPet(pet1);
        shelter.addPet(pet2);

        int pet1BoredomBefore = pet1.getBoredom();
        int pet2BoredomBefore = pet2.getBoredom();
        int pet1ThirstBefore = pet1.getThirst();
        int pet2ThirstBefore = pet2.getThirst();
        int pet1SicknessBefore = pet1.getSickness();
        int pet2SicknessBefore = pet2.getSickness();

        shelter.playWithAllPets();

        int pet1BoredomAfter = pet1.getBoredom();
        int pet2BoredomAfter = pet2.getBoredom();
        int pet1ThirstAfter = pet1.getThirst();
        int pet2ThirstAfter = pet2.getThirst();
        int pet1SicknessAfter = pet1.getSickness();
        int pet2SicknessAfter = pet2.getSickness();

        assertEquals(pet1BoredomAfter, pet1BoredomBefore - 30);
        assertEquals(pet2BoredomAfter, pet2BoredomBefore - 30);
        assertEquals(pet1ThirstAfter, pet1ThirstBefore + 10);
        assertEquals(pet2ThirstAfter, pet2ThirstBefore + 10);
        assertEquals(pet1SicknessAfter, pet1SicknessBefore + 10);
        assertEquals(pet2SicknessAfter, pet2SicknessBefore + 10);
    }
}

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
}  
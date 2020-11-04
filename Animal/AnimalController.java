
public class AnimalController {

    public String getAnimal(@PathVariable(value = "id") final int id) { }

    public void postAnimal(@RequestBody final Animal animal) { }

    public void deleteAnimal(@PathVariable(value= "id") final int id){ }


}


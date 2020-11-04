
public class Animal {

    // Constructor para que acepte directamente un json
    public Animal(String json) throws JsonProcessingException { }

    public Animal(int id, String name, boolean checked) { }

    // Constructor por defecto
    public Animal() {}

    //Getter
    public int getId() { }

    public String getName() { }

    //Serializador
    public String serialize() throws JsonProcessingException { }
}

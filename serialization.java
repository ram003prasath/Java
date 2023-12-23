import java.io.*;

class Person implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}

public class SerializationDemo {
    public static void main(String[] args) {
        Person person = new Person("John Doe", 30);

        serializePerson(person);

        Person deserializedPerson = deserializePerson();
        if (deserializedPerson != null) {
            System.out.println("Deserialized Person Details:");
            System.out.println("Name: " + deserializedPerson.getName());
            System.out.println("Age: " + deserializedPerson.getAge());
        }
    }

    private static void serializePerson(Person person) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("person.ser"))) {
            oos.writeObject(person);
            System.out.println("Person object serialized and written to person.ser");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Person deserializePerson() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("person.ser"))) {
            Object obj = ois.readObject();
            if (obj instanceof Person) {
                return (Person) obj;
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}

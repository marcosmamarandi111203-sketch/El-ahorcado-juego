package ec.edu.espe.exam.view;

import ec.edu.espe.exam.model.Person;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class PersonApp {
    public static void main(String[] args) throws Exception {
        ArrayList<Person> items = new ArrayList<>();
        items.addAll(List.of(
            new Person(11, "Ana", 20, "ana@example.com"),
            new Person(12, "Ana", 21, "ana@example.com"),
            new Person(13, "Ana", 22, "ana@example.com")
        ));
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Path jsonFile = Path.of("persons.json");
        Files.writeString(jsonFile, gson.toJson(items), StandardCharsets.UTF_8);
        System.out.println("Saved to: " + jsonFile.toAbsolutePath());
        List<Person> restored = gson.fromJson(Files.readString(jsonFile), new TypeToken<List<Person>>(){}.getType());
        restored.forEach(System.out::println);
        restored.stream().filter(item -> item.getId() == 12).findFirst()
              .ifPresent(item -> System.out.println("Found ID 12: " + item));
    }
}

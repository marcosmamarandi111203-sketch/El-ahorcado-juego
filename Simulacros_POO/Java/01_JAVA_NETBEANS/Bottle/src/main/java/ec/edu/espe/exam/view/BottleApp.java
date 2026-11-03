package ec.edu.espe.exam.view;

import ec.edu.espe.exam.model.Bottle;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class BottleApp {
    public static void main(String[] args) throws Exception {
        ArrayList<Bottle> items = new ArrayList<>();
        items.addAll(List.of(
            new Bottle(11, "Plastic", "Blue", 1.5),
            new Bottle(12, "Plastic", "Blue", 1.75),
            new Bottle(13, "Plastic", "Blue", 2.0)
        ));
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Path jsonFile = Path.of("bottles.json");
        Files.writeString(jsonFile, gson.toJson(items), StandardCharsets.UTF_8);
        System.out.println("Saved to: " + jsonFile.toAbsolutePath());
        List<Bottle> restored = gson.fromJson(Files.readString(jsonFile), new TypeToken<List<Bottle>>(){}.getType());
        restored.forEach(System.out::println);
        restored.stream().filter(item -> item.getId() == 12).findFirst()
              .ifPresent(item -> System.out.println("Found ID 12: " + item));
    }
}

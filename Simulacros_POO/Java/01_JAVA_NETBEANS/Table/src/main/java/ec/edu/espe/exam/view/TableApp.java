package ec.edu.espe.exam.view;

import ec.edu.espe.exam.model.Table;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class TableApp {
    public static void main(String[] args) throws Exception {
        ArrayList<Table> items = new ArrayList<>();
        items.addAll(List.of(
            new Table(11, "Wood", "Brown", "1.5m x 0.8m"),
            new Table(12, "Glass", "Transparent", "1.2m x 1.2m"),
            new Table(13, "Metal", "Black", "2.0m x 1.0m")
        ));
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Path jsonFile = Path.of("tables.json");
        Files.writeString(jsonFile, gson.toJson(items), StandardCharsets.UTF_8);
        System.out.println("Saved to: " + jsonFile.toAbsolutePath());
        List<Table> restored = gson.fromJson(Files.readString(jsonFile), new TypeToken<List<Table>>(){}.getType());
        restored.forEach(System.out::println);
        restored.stream().filter(item -> item.getId() == 12).findFirst()
              .ifPresent(item -> System.out.println("Found ID 12: " + item));
    }
}

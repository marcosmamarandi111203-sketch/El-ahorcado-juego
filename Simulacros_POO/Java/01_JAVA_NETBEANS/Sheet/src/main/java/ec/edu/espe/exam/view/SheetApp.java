package ec.edu.espe.exam.view;

import ec.edu.espe.exam.model.Sheet;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class SheetApp {
    public static void main(String[] args) throws Exception {
        ArrayList<Sheet> items = new ArrayList<>();
        items.addAll(List.of(
            new Sheet(11, "Paper", "White", "A4"),
            new Sheet(12, "Paper", "White", "A4"),
            new Sheet(13, "Paper", "White", "A4")
        ));
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Path jsonFile = Path.of("sheets.json");
        Files.writeString(jsonFile, gson.toJson(items), StandardCharsets.UTF_8);
        System.out.println("Saved to: " + jsonFile.toAbsolutePath());
        List<Sheet> restored = gson.fromJson(Files.readString(jsonFile), new TypeToken<List<Sheet>>(){}.getType());
        restored.forEach(System.out::println);
        restored.stream().filter(item -> item.getId() == 12).findFirst()
              .ifPresent(item -> System.out.println("Found ID 12: " + item));
    }
}

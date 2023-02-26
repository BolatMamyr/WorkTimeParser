import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        var parser = new WorkTimeParser();
        String[][] grafic = {
                {"Ivanov Ivan Ivanovich", "12:00-16:00", "12:00-16:00", "12:00-16:00", "12:00-16:00", "12:00-16:00", "12:00-16:00", ""},
                {"Ivanov Ivan Ivanovich", "08:00-12:00", "08:00-10:00", "08:00-16:00", "", "", "", ""},
                {"Petrov Petr Petrovich", "12:00-16:00", "", "12:00-16:00", "", "12:00-16:00", "", ""},
                {"Petrov Petr Petrovich", "10:00-17:00", "12:00-15:00", "12:00-16:00", "", "", "", ""}
        };
        var result = parser.prepareWorkTime(grafic);

        parser.createHtmlTable(result);
    }
}
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

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("grafic.html"));
            writer.write("<html><body>");
            writer.write("<table>");

            writer.write("<tr>");
            writer.write("<th>Number</th>");
            writer.write("<th>Name</th>");
            writer.write("<th>Mon</th>");
            writer.write("<th>Tue</th>");
            writer.write("<th>Wed</th>");
            writer.write("<th>Thur</th>");
            writer.write("<th>Fri</th>");
            writer.write("<th>Sat</th>");
            writer.write("<th>Sun</th>");
            writer.write("</tr>");

            for (int i = 0; i < result.length; i++) {
                if (result[i][0] != null) {
                    writer.write("<tr>");
                    writer.write("<td>" + (i + 1) + "</td>");
                    for (int j = 0; j < result[i].length; j++) {
                        writer.write("<td>" + result[i][j] + "</td>");
                    }
                    writer.write("</tr>");
                }
            }

            writer.write("</table>");
            writer.write("</body></html>");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
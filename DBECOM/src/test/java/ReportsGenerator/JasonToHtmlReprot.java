package ReportsGenerator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.Test;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class JasonToHtmlReprot {


    //@Test
    public static void main(String[] args) throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        JSONArray a = (JSONArray) parser.parse(new FileReader("C:\\Users\\srafique\\IdeaProjects\\DBECOM\\target\\Reports\\cucumber.json"));

        for (Object o : a)
        {
            JSONObject person = (JSONObject) o;
            JSONArray elements = (JSONArray) person.get("elements");

            for (Object c : elements)
            {
                JSONObject car = (JSONObject) c;
                System.out.println(car.get("id")+" "+car.get("keyword")+" "+car.get("name")+" "+car.get("name"));
                System.out.println(c.toString());


                JSONArray steps = (JSONArray) car.get("steps");
                for (Object b: steps){
                    JSONObject bar = (JSONObject) b;
                    System.out.println(bar.get("keyword")+": "+bar.get("name"));

                }

            }
        }
    }
    @Test
    public String htmlHeader() {


        String header = "<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "    <style>\n" +
                "table {\n" +
                "    font-family: arial, sans-serif;\n" +
                "    border-collapse: collapse;\n" +
                "\n" +
                "    width: 100%;\n" +
                "}\n" +
                "\n" +
                "td, th {\n" +
                "    border: 1px solid #dddddd;\n" +
                "    border-color: blue;\n" +
                "    text-align: left;\n" +
                "    padding: 8px;\n" +
                "}\n" +
                "th {\n" +
                "background-color: powderblue;\n" +
                "}\n" +
                "\n" +
                "}\n" +
                "</style>\n" +
                "</head>\n" +
                "<body>\n" +
                "\n" +
                "<table>\n" +
                "    <tr>";

        return header;

    }
    public String htmlFooter() {

        String footer = "    </tr>\n" +
                "</table>\n" +
                "\n" +
                "</body>\n" +
                "</html>";
        return footer;
    }

    public String Break(){
        String htmlBreak = "</tr>\n" +
                "    <tr>";

        return htmlBreak;
    }
}

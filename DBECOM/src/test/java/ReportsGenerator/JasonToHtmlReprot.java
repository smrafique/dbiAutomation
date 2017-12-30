package ReportsGenerator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Test;


import java.io.*;
import java.util.ArrayList;

public class JasonToHtmlReprot {

    @Test
    public void htmlReportGenerator() throws IOException, ParseException {

        File html = new File("target/Reports/testReport.html");
        BufferedWriter bw = new BufferedWriter(new FileWriter(html));
        ArrayList <String> htmlTestReport = new ArrayList<String>();

        htmlTestReport.add(htmlHeader());



        JSONParser parser = new JSONParser();
        JSONArray a = (JSONArray) parser.parse(new FileReader("target/Reports/cucumber.json"));


        for (Object o : a)
        {
            JSONObject person = (JSONObject) o;
            htmlTestReport.add("<td>"+ person.get("name")+"</td>");
            JSONArray elements = (JSONArray) person.get("elements");

            for (int j=0;j<elements.size();j++) {
                JSONObject car = (JSONObject) elements.get(j);

                if(j==0){
                    htmlTestReport.add("<td>" + car.get("name") + "</td>");
                }else {
                    htmlTestReport.add("<td></td><td>" + car.get("name") + "</td>");
                }
                JSONArray steps = (JSONArray) car.get("steps");
                for (int i=0; i<steps.size();i++){
                    JSONObject bar = (JSONObject) steps.get(i);
                    JSONObject status =(JSONObject) bar.get("result");
                    if(i==0){
                        htmlTestReport.add("<td>" + bar.get("keyword") + "</td><td>" + bar.get("name") + "</td><td ");
                    }else {
                        htmlTestReport.add("<td></td><td></td><td>" + bar.get("keyword") + "</td><td>" + bar.get("name") + "</td><td ");
                    }
                    if(status.get("status").equals("passed")){htmlTestReport.add("style=\"background-color:Green;\"");
                    }else if(status.get("status").equals("failed")){htmlTestReport.add("style=\"background-color:Red;\"");
                    }else {htmlTestReport.add("style=\"background-color:Grey;\"");}

                    htmlTestReport.add(">"+status.get("status")+"</td><td>"+status.get("error_message")+"</td>");
                    htmlTestReport.add(Break());
                }

            }
        }

        htmlTestReport.add(htmlFooter());

        for (int i = 0; i <htmlTestReport.size();i++){
            bw.write(htmlTestReport.get(i));
            bw.newLine();
        }
        bw.flush();
        bw.close();

    }

    public static String htmlHeader() {


        String header = "<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "<style>\n" +
                "table {\n" +
                "    font-family: arial, sans-serif;\n" +
                "    border-collapse: collapse;\n" +
                "    width: 100%;\n" +
                "}\n" +
                "td, th {\n" +
                "    border: 1px solid #dddddd;\n" +
                "    border-color: blue;\n" +
                "    text-align: left;\n" +
                "    padding: 8px;\n" +
                "}\n" +
                "th{\n" +
                "    background-color: powderblue;\n" +
                "}\n" +
                "</style>\n" +
                "</head>\n" +
                "<body>\n" +
                "<table>\n" +
                "  <tr>\n" +
                "    <th>Feature</th>\n" +
                "    <th>Scenario</th>\n" +
                "    <th>Step</th>\n" +
                "    <th>Step Details</th>\n" +
                "\t<th>Status</th>\n" +
                "\t<th>Failing Reason</th>\n" +
                "  </tr>\n" +
                "  <tr>\n";
        return header;

    }


    public static String htmlFooter() {

        String footer = "</tr>\n" +
                "  \n" +
                "</table>\n" +
                "\n" +
                "</body>\n" +
                "</html>";
        return footer;
    }

    public static String Break(){
        String htmlBreak = "</tr>\n" +
                "    <tr>";
        return htmlBreak;
    }
}

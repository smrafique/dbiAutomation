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


        for (int o=0; o<a.size();o++)
        {
            JSONObject reportFile = (JSONObject) a.get(o);
            htmlTestReport.add("<td style=\"font-weight: bold; color: #0000ff\";>"+(o+1)+" :"+ reportFile.get("name")+"</td>");
            JSONArray elements = (JSONArray) reportFile.get("elements");

            for (int j=0;j<elements.size();j++) {
                JSONObject feature = (JSONObject) elements.get(j);

                if(j==0){
                    htmlTestReport.add("<td style=\"font-weight: bold;color: #ffa500\";>" +(j+1)+" :"+ feature.get("name") + "</td>");
                }else {
                    htmlTestReport.add("<td></td><td style=\"font-weight: bold; color: #ffa500\";>" +(j+1)+" :"+ feature.get("name") + "</td>");
                }
                JSONArray steps = (JSONArray) feature.get("steps");
                for (int i=0; i<steps.size();i++){
                    JSONObject stepDetails = (JSONObject) steps.get(i);
                    JSONObject status =(JSONObject) stepDetails.get("result");
                    if(i==0){
                        htmlTestReport.add("<td>"+(i+1)+"</td><td style=\" color: #4CAF50\";>" + stepDetails.get("keyword") + "</td><td>" + stepDetails.get("name") + "</td><td ");
                    }else {
                        htmlTestReport.add("<td></td><td></td><td>"+(i+1)+"</td><td style=\" color: #4CAF50\";>" + stepDetails.get("keyword") + "</td><td>" + stepDetails.get("name") + "</td><td ");
                    }
                    if(status.get("status").equals("passed")){htmlTestReport.add("class=\"btn success\"");
                    }else if(status.get("status").equals("failed")){htmlTestReport.add("class=\"btn danger\"");
                    }else {htmlTestReport.add("class=\"btn default\"");}

                    htmlTestReport.add(">"+toUpperCase((String) status.get("status"))+"</td>");
                    if(status.get("status").equals("failed")) {
                        htmlTestReport.add("<td style=\"border:1px solid Tomato; color: #f44336;\">" + status.get("error_message") + "</td>");
                    }else if(status.get("status").equals("passed")){
                        htmlTestReport.add("<td style=\"border: 1px solid lightgreen; color: #4CAF50;\">Working as Expected</td>");
                    }else{
                        htmlTestReport.add("<td style=\"border: 1px solid grey; color: black;\">Test Skipped</td>");
                    }
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
                ".success {background-color: #4CAF50; color: white;}\n" +
                ".success:hover {background-color: #46a049; color: white}\n" +
                "\n" +
                ".info {background-color: #2196F3;}\n" +
                ".info:hover {background: #0b7dda;}\n" +
                "\n" +
                ".warning {background-color: #ff9800;}\n" +
                ".warning:hover {background: #e68a00;}\n" +
                "\n" +
                ".danger {background-color: #f44336; color: white;} \n" +
                ".danger:hover {background: #da190b; color: white}\n" +
                "\n" +
                ".default {background-color: #e7e7e7; color: black;} \n" +
                ".default:hover {background: #ddd;}\n"+
                "</style>\n" +
                "</head>\n" +
                "<body>\n" +
                "<table>\n" +
                "  <tr>\n" +
                "    <th>Feature</th>\n" +
                "    <th>Scenario</th>\n" +
                "    <th>Step</th>\n" +
                "    <th>Keyword</th>\n" +
                "    <th>Step Details</th>\n" +
                "\t<th>Status</th>\n" +
                "\t<th>Comments</th>\n" +
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

    public static  String toUpperCase(String str){

        str = str.substring(0, 1).toUpperCase() + str.substring(1);

        return str;
    }



}

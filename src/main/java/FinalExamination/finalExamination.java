package FinalExamination;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

import com.codeborne.selenide.*;
import junit.framework.Assert;
import org.apache.commons.io.FileUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class finalExamination {
    private static Assert Assertions;

    @Test

    public void main() throws IOException, ParseException {


        JSONParser parser = new JSONParser();
        JSONObject credentials = (JSONObject) parser.parse(new FileReader("/Users/emilvahakangas/Desktop/ltu.json"));
        JSONObject ltuCredentials = (JSONObject) credentials.get("LTUcredentials");
        String username = (String) ltuCredentials.get("username");
        String password = (String) ltuCredentials.get("password");
        

        open("https://www.ltu.se/");

        try {
            // Click the "Acceptera cookies" button to dismiss the popup
            $(byXpath("//button[text()='Tillåt alla cookies']")).click();

            // Verify that the popup has disappeared
            $(Selectors.byText("Vi använder kakor")).shouldNot(Condition.appear);
        } catch (Exception e) {
            System.out.println("An exception occurred: " + e.getMessage());
        }


        // Click the "Student" link
        $(byXpath("//a[text()='Student']")).click();

        try {
            // Click the "Logga in i Canvas" button
            $(withText("Logga in i Canvas")).click();
        } catch (Exception e) {
            System.out.println("An exception occurred: " + e.getMessage());
        }




        try {
            // Fill in the username and password fields with your LTU credentials
            $("#username").setValue(username);
            $("#password").setValue(password);
            $(byCssSelector(".btn-submit")).click();
        } catch (Exception e) {
            System.out.println("An exception occurred: " + e.getMessage());
        }


        $("svg.ic-icon-svg.ic-icon-svg--courses").click();

        $(byLinkText("I0015N, Test av IT-system, Lp4, V23")).click();

        $(byCssSelector("a[href='/courses/18863/modules'].modules")).click();

        $(byLinkText("Final Examination Information")).click();



        String actualText = "";
        try {
            // Get the actual text from the element using Selenide
            actualText = $("div.show-content").text();
        } catch (Exception e) {
            System.out.println("An exception occurred: " + e.getMessage());
        }

        //retrieving the final examination date and time
        System.out.println($(byXpath("//*[@id='wiki_page_show']/div/p[4]")).getText());



        // Define the expected text
        String expectedText = "Final Examination Information\n" +
                "The final examination will be multiple choice questions.\n" +
                "I'm planning to have all the questions in both Swedish and English.\n" +
                "I'm planning to have all the answers in both Swedish and English.\n" +
                "The examination is on Tuesday, May 30th, from 9:00 - 14:00.\n" +
                "Good Luck, Teacher Todd";


        // Compare the actual text with the expected text
        Assertions.assertEquals(expectedText, actualText);

        // Take a screenshot of the final examination information
        File finalExamScreenshot = Screenshots.takeScreenShotAsFile();

        // Define the path and filename of the screenshot
        String filePath = "target/screenshots/final_examination.jpeg";

        // Save the screenshot to the project directory
        try {
            FileUtils.copyFile(finalExamScreenshot, new File(filePath));
            System.out.println("Screenshot saved to " + filePath);
        } catch (IOException e) {
            System.out.println("An exception occurred while saving the screenshot: " + e.getMessage());


        }

        $("a#global_nav_profile_link").click();
        //logout
        $(("button[class='fOyUs_bGBk fOyUs_fKyb fOyUs_cuDs fOyUs_cBHs fOyUs_eWbJ fOyUs_fmDy fOyUs_eeJl fOyUs_cBtr fOyUs_fuTR fOyUs_cnfU fQfxa_bGBk']")).click();
    }
}

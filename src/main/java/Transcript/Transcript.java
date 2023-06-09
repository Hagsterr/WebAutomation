package Transcript;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;

import com.codeborne.selenide.ex.ElementNotFound;
import com.fasterxml.jackson.databind.JsonNode;
import java.io.File;
import java.io.IOException;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;



public class Transcript {

    File jsonFile = new File("C:\\temp\\ltu.json");


    @Test
    public void main() {

        try {
            Configuration.holdBrowserOpen = true;
            open("https://www.ltu.se/");
            WebDriverRunner.getWebDriver().manage().window().maximize();
        } catch (Exception e) {
            System.out.println("Could not get website.");
        }


        try {
            // Wait for cookie dialog to become visible and click "Endast nödvändiga cookies" button
            $(".CybotCookiebotDialogBodyButton").shouldHave(Condition.visible).click();

        } catch (ElementNotFound e) {
            System.out.println("Could not find clickable element for closing cookies");

        }


        try {
            // Click the "Student" link.
            $(byXpath("//a[text()='Student']")).click();
        } catch (Exception e) {
            System.out.println("Could not click on the 'Student' link.");
        }

        try {
            // Click the "Transcript/registerutdrag" link.
            $(byXpath("//*[@id=\"maincontent\"]/div[1]/div/div[2]/div/div/div/div/ul/li[1]/a/div"))
                    .shouldHave(Condition.visible).click();
        } catch (Exception e) {
            System.out.println("Could not click on the 'Transcript/registerutdrag' link.");
        }

        try {
            // Click the "find your institution" button.
            $(byXpath("/html/body/ladok-root/div/main/div/ladok-inloggning/div/div/div/div/div/div/div/ladok-student/div[1]/a/div/div[2]/span[2]")).click();
        } catch (Exception e) {
            System.out.println("Could not click on the 'find your institution' button.");
        }

        try {
            // Search for ltu.
            $(byXpath("//*[@id=\"searchinput\"]")).setValue("ltu");
        } catch (Exception e) {
            System.out.println("Could not search for 'ltu'.");
        }

        try {
            // Wait for ltu suggestion to become available and then click on it.
            $(byXpath("//*[@id=\"ds-search-list\"]/a/li/div/div[1]"))
                    .shouldHave(Condition.visible).click();
        } catch (Exception e) {
            System.out.println("Could not click on the 'ltu' suggestion.");
        }


        //Create the objectmapper and readability for the json-file containing credentials.
        try {
            //Create the objectmapper and readability for the json-file containing credentials.
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(jsonFile);

            //Fetch the username and password from the credentials file.
            String username = jsonNode.get("ltuCredentials").get("username").asText();
            String password = jsonNode.get("ltuCredentials").get("password").asText();



            //Enter the login information.
            $("#username").val(username);
            $("#password").val(password);
        } catch (IOException e) {
            System.out.println("Error reading credentials from JSON file: " + e.getMessage());
        }

        //Click on login
        $(byXpath("//*[@id=\"fm1\"]/section[3]/input[4]")).click();

        //Click on the Transcript-button.
        $(byXpath("//*[@id=\"sidomeny-ul\"]/li[3]/ladok-behorighetsstyrd-nav-link/a")).click();


        /* @Disabled - the create transcript works.
        //Create a new Transcript.
        $(By.xpath("//*[@id=\"main\"]/div/ladok-intyg/ladok-skapa-intyg-knapp/div/button")).click();
        $(By.xpath("//*[@id=\"intygstyp\"]")).click();
        $(By.xpath("//*[@id=\"intygstyp\"]/option[2]")).click();
        $("#start").val("2022-09-01");
        $("#slut").val("2023-04-01");
        $(By.xpath("//*[@id=\"main\"]/div/ladok-skapa-intyg/ladok-card/div/div/ladok-card-body/div[3]/div/form/div[3]/div/ladok-skapa-intyg-knapprad/div/button[1]/span")).click();

         */

        //Click on the created Transcript to download it.

        $(byXpath("//*[@id=\"main\"]/div/ladok-intyg/ladok-listning-av-skapade-intyg/div/div/ladok-accordion/div/ladok-list-kort[1]/div/div[1]/div/div[1]/a")).click();

        //Log out
        $(byXpath("//*[@id=\"sidomeny\"]/div[1]/ul[3]/li/a")).click();

         Configuration.holdBrowserOpen = false;



    }




}

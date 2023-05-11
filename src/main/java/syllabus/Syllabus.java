package syllabus;

import com.codeborne.selenide.*;
import com.codeborne.selenide.ex.ElementNotFound;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriverException;

import java.io.File;
import java.io.IOException;

import static com.codeborne.selenide.Selenide.*;



public class Syllabus {




    @Test
    public void main() {

        openLTU();
        closeCookies();
        openEducation();
        openProgramCat();
        openProgram();
        openCourses();
        openCourse();
        openSyllabus();
        downloadSyllabus();
        exitTest();
    }


    protected static void openLTU () { // Starts up the webdriver and configures the options

        try {

            open("https://www.ltu.se");
            Configuration.holdBrowserOpen = true;
            WebDriverRunner.getWebDriver().manage().window().maximize(); // Maximizes the window

        } catch (WebDriverException e) {
            System.out.println("Could not get website");
        }
    }
    protected static void closeCookies () {
        try {

            System.out.println("Clicking on cookies");
            $(By.id("CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll")).click();
            sleep(1500); // On my computer I had trouble clicking on cookies unless the program slept.

        } catch (ElementNotFound e) {
            System.out.println("Could not find clickable element by xPath");

        } catch (StaleElementReferenceException e){
            System.out.println("Element no longer valid");
        }

    }
    protected static void openEducation(){
        try {

            System.out.println("Clicking on utbildning");
            $(By.cssSelector("#main-menu > li:nth-child(1) > a")).click();

        } catch (ElementNotFound e) {
            System.out.println("Could not find clickable element by xPath");

        } catch (StaleElementReferenceException e){
            System.out.println("Element no longer valid");
        }

    }
    protected static void openProgramCat() {
        try {

            System.out.println("Clicking on program category");
            $(By.xpath("//*[@id=\"main-menu\"]/li[1]/div/div/div[1]/div/div/ul/li[4]/a")).click();

        } catch (ElementNotFound e) {
            System.out.println("Could not find clickable element by xPath");

        } catch (StaleElementReferenceException e){
            System.out.println("Element no longer valid");
        }
    }

    protected static void openProgram() {
        try {

            System.out.println("Clicking on program");
            $(By.xpath("//*[@id=\"page\"]/div/div/div/div[1]/nav/div/ul/li[7]/a")).click();

        } catch (ElementNotFound e) {
            System.out.println("Could not find clickable element by xPath");

        } catch (StaleElementReferenceException e){
            System.out.println("Element no longer valid");
        }
    }
    protected static void openCourses(){
        try{

            System.out.println("Clicking on mandatory courses");
            $(By.xpath("//*[@id=\"page\"]/div/div/div/div[1]/nav/div[1]/ul/li[2]/ul/li[1]/a")).click();

        } catch (ElementNotFound e) {
            System.out.println("Could not find clickable element by xPath");

        } catch (StaleElementReferenceException e){
            System.out.println("Element no longer valid");
        }
    }
    protected static void openCourse(){
        try{

            System.out.println("Clicking on program course I0006N");
            $(By.xpath("//*[@id=\"utbplan-container\"]/div[5]/table/tbody/tr[2]/td[1]/a")).click();

        } catch (ElementNotFound e) {
            System.out.println("Could not find clickable element by xPath");

        } catch (StaleElementReferenceException e){
            System.out.println("Element no longer valid");
        }
    }
    protected static void openSyllabus(){
        try {

            System.out.println("Clicking on course syllabus");
            $(By.xpath("//*[@id=\"maincontent\"]/article/div[1]/section/div[8]/div/a")).click();

        } catch (ElementNotFound e) {
            System.out.println("Could not find clickable element by xPath");

        } catch (StaleElementReferenceException e){
            System.out.println("Element no longer valid");
        }
    }
    protected static void downloadSyllabus(){
        try{
            System.out.println("Downloading PDF file of I0006N syllabus");
            $(By.xpath("//*[@id=\"utbkatForm\"]/div[4]/a")).click();

        } catch (ElementNotFound e) {
            System.out.println("Could not find clickable element by xPath");

        } catch (StaleElementReferenceException e){
            System.out.println("Element no longer valid");
        }
    }

    protected static void exitTest(){
        Configuration.holdBrowserOpen = false;
    }








}




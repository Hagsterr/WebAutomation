package syllabus;

import com.codeborne.selenide.*;
import com.codeborne.selenide.ex.ElementNotFound;
import org.junit.Test;
import static com.codeborne.selenide.Selectors.*;
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


    public void openLTU () { // Starts up the webdriver and configures the options

        try {
            open("https://www.ltu.se");
            Configuration.holdBrowserOpen = true;
            WebDriverRunner.getWebDriver().manage().window().maximize(); // Maximizes the window
        } catch (Exception e) {
            System.out.println("Could not get website");
        }
    }

    public void closeCookies () {
        try {

            System.out.println("Clicking on cookies");
            $(byId("CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll")).click();
            sleep(1500); // On my computer I had trouble clicking on cookies unless the program slept.

        } catch (ElementNotFound e) {
            System.out.println("Could not find clickable element by xPath");

        } catch (Exception e){
            System.out.println("Unknown error");
        }

    }

    public void openEducation(){
        try {

            System.out.println("Clicking on utbildning");
            $(byCssSelector("#main-menu > li:nth-child(1) > a")).click();

        } catch (ElementNotFound e) {
            System.out.println("Could not find clickable element by xPath");

        } catch (Exception e){
            System.out.println("Unknown error");
        }

    }

    public void openProgramCat() {
        try {

            System.out.println("Clicking on program category");
            $(byXpath("//*[@id=\"main-menu\"]/li[1]/div/div/div[1]/div/div/ul/li[4]/a")).click();

        } catch (ElementNotFound e) {
            System.out.println("Could not find clickable element by xPath");

        } catch (Exception e){
            System.out.println("Unkown error");
        }
    }

    public  void openProgram() {
        try {

            System.out.println("Clicking on program");
            $(byXpath("//*[@id=\"page\"]/div/div/div/div[1]/nav/div/ul/li[7]/a")).click();

        } catch (ElementNotFound e) {
            System.out.println("Could not find clickable element by xPath");

        } catch (Exception e){
            System.out.println("Unknown error");
        }
    }

    public void openCourses(){
        try{

            System.out.println("Clicking on mandatory courses");
            $(byXpath("//*[@id=\"page\"]/div/div/div/div[1]/nav/div[1]/ul/li[2]/ul/li[1]/a")).click();

        } catch (ElementNotFound e) {
            System.out.println("Could not find clickable element by xPath");

        } catch (Exception e){
            System.out.println("Unknown error");
        }
    }

    public void openCourse(){
        try{

            System.out.println("Clicking on program course I0006N");
            $(byXpath("//*[@id=\"utbplan-container\"]/div[5]/table/tbody/tr[2]/td[1]/a")).click();

        } catch (ElementNotFound e) {
            System.out.println("Could not find clickable element by xPath");

        } catch (Exception e){
            System.out.println("Unknown error");
        }
    }

    public void openSyllabus(){
        try {

            System.out.println("Clicking on course syllabus");
            $(byXpath("//*[@id=\"maincontent\"]/article/div[1]/section/div[8]/div/a")).click();

        } catch (ElementNotFound e) {
            System.out.println("Could not find clickable element by xPath");

        } catch (Exception e){
            System.out.println("Unknown error");
        }
    }

    public  void downloadSyllabus(){
        try{
            System.out.println("Downloading PDF file of I0006N syllabus");
            $(byXpath("//*[@id=\"utbkatForm\"]/div[4]/a")).click();

        } catch (ElementNotFound e) {
            System.out.println("Could not find clickable element by xPath");

        } catch (Exception e){
            System.out.println("Unknown error");
        }
    }

    protected static void exitTest(){
        Configuration.holdBrowserOpen = false;
    }








}




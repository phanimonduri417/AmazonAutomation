package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LaunchBrowser {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.in/");
        Thread.sleep(5000);
        System.out.println("Current URL: " + driver.getCurrentUrl());
        System.out.println("Title="+driver.getTitle());
        Thread.sleep(10000);
        driver.quit();
    }
}

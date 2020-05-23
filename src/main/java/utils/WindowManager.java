package utils;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import pages.DynamicLoadingExample2Page;

public class WindowManager {

    private WebDriver driver;
    private WebDriver.Navigation navigate;

    public WindowManager(WebDriver driver) {
        this.driver = driver;
        navigate = driver.navigate();
    }

    public void goBack(){
        navigate.back();
    }

    public void goForward(){
        navigate.forward();
    }

    public void refreshPage(){
        navigate.refresh();
    }

    public void goTo(String url){
        navigate.to(url);
    }

    public void switchToTab(String tabTitle){
        var windows = driver.getWindowHandles();
        System.out.println("Number of tabs: " + windows.size());
        System.out.println("Window handles:");
        windows.forEach(System.out::println);

        for(String window : windows) {
     //       System.out.println("Switching to window: " + window);
            driver.switchTo().window(window);
            System.out.println("Current window title: " + driver.getTitle());
            if(tabTitle.equals(driver.getTitle())){
                driver.switchTo().window(window);
                break;
            }
        }
    }

    public void switchToNewTab(){
        var windows = driver.getWindowHandles();
        windows.forEach(driver.switchTo()::window);
    }

    public String getWindowTitle(){
        return driver.getTitle();
    }

    public void closeAllExtraTabs(){
        var tabs = driver.getWindowHandles();
        int tabsCount = tabs.size();
        while(tabsCount > 1) {
            for(String tab : tabs) {
            driver.switchTo().window(tab);
                if(tabsCount > 1){
                    driver.close();
                    tabsCount--;
                }
            }
        }
    }

}

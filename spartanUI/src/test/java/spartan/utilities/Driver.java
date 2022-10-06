package spartan.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Driver {

    private static WebDriver driver;

    private Driver(){}

    public static WebDriver getDriver(){
        if (driver == null){
            String browser = ConfigurationReader.getProperty("browser");
            switch (browser){
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                default:
                    throw new RuntimeException("No such a browser yet!");
            }
        }
        return driver;
    }

    public static void closeDriver(){
        if (driver!= null){
            driver.quit();
            driver = null;
        }
    }
}



//package com.Spartan.utilities;
//
//import io.github.bonigarcia.wdm.WebDriverManager;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//
//import java.util.concurrent.TimeUnit;
//
//
//public class Driver {// copy of object
//  private static  ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();
//
//  private Driver() {
//
//  }
//
//  public synchronized static WebDriver getDriver(String browser) {
//   if (driverThreadLocal.get() == null) {
//    switch (browser) {
//     case "chrome": {
//      WebDriverManager.chromedriver().setup();
//      driverThreadLocal.set(new ChromeDriver());
//      driverThreadLocal.get().manage().window().maximize();
//     driverThreadLocal.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//      break;
//     }
//     case "firefox": {
//      WebDriverManager.firefoxdriver().setup();
//      driverThreadLocal.set(new FirefoxDriver());
//      driverThreadLocal.get().manage().window().maximize();
//     driverThreadLocal.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//     break;
//     }
//     default:
//      throw new RuntimeException("Unimplemented driver type!");
//    }
//   }
//   return driverThreadLocal.get();
//  }
//
//  public synchronized static void closeDriver() {
//   if (driverThreadLocal.get() != null) {
//    driverThreadLocal.get().quit();
//    driverThreadLocal.remove();
//   }
//  }
// }



// private Driver() {
// }
//
// private static  ThreadLocal<WebDriver> driverPool = new ThreadLocal<>();
//
// public static WebDriver getDriver(String browser) {
//
//  if (driverPool.get() == null) {
//
//   synchronized (Driver.class) {
//
//    switch (browser) {
//     case "chrome":
//      WebDriverManager.chromedriver().setup();
//      driverPool.set(new ChromeDriver());
//      driverPool.get().manage().window().maximize();
//      driverPool.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//      break;
//     case "firefox":
//      WebDriverManager.firefoxdriver().setup();
//      driverPool.set(new FirefoxDriver());
//      driverPool.get().manage().window().maximize();
//      driverPool.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//      break;
//
//    }
//   }
//  }
//
//  //This same driver will be returned every time we call Driver.getDriver() method
//  return driverPool.get();
//
// }
//
// public static void closeDriver() {
//  if (driverPool.get() != null) {
//   driverPool.get().quit();
//   driverPool.remove();
//  }
// }
//}
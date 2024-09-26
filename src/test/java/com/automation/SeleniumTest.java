package com.automation;

import io.qameta.allure.*;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class SeleniumTest extends BaseTest {
    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Description("Test the login functionality")
    @Feature("Login Test Form Authentication")
    public void testingLoginPage() {
        openHomePage();
        //navigateToFormAuthentication();
        fillLoginForm("tomsmith", "SuperSecretPassword!");
        validateLoginSuccess();
    }

    @Step("Open the homepage")
    public void openHomePage() {
        getDriver().get("https://the-internet.herokuapp.com/login");
    }

//    @Step("Navigate to the form authentication")
//    public void navigateToFormAuthentication() {
//        getDriver().findElement(By.linkText("Form Authentication")).click();
//    }

    @Step("Verify the login")
    public void fillLoginForm(String username, String password) {
        getDriver().findElement(By.id("username")).sendKeys("tomsmith");
        getDriver().findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        getDriver().findElement(By.cssSelector("button[type='submit']")).click();
    }

    @Step("Validate Login Success")
    public String validateLoginSuccess() {
        String successMsg = getDriver().findElement(By.cssSelector(".flash.success")).getText();
        assertTrue(getDriver().findElement(By.cssSelector(".flash.success")).isDisplayed());
        return successMsg;

    }
}

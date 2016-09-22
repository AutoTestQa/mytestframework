package com.automation.base.component;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LocatorFind {

	public static String getLocator(String key) {

		String locator = null;

		JSONParser parser = new JSONParser();
		String basePath = new File("").getAbsolutePath();
		Object obj;
		try {
			obj = parser.parse(new FileReader(basePath + "/src/test/resources/utilities/locators" + "/OR.json"));

			JSONObject jsonObject = (JSONObject) obj;

			locator = (String) jsonObject.get(key);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return locator;
	}

	public static WebElement getWebelement(WebDriver driver, String key) {

		String locator = getLocator(key);
		WebElement element = null;

		if (locator != null) {

			String[] refinelocator = locator.split("==");
			String finalLocator = refinelocator[1];

			By locator_strategy;
			if (locator.startsWith("id"))
				locator_strategy = By.id(finalLocator);
			else if (locator.startsWith("css"))
				locator_strategy = By.cssSelector(finalLocator);
			else if (locator.startsWith("xpath"))
				locator_strategy = By.xpath(finalLocator);
			else if (locator.startsWith("name"))
				locator_strategy = By.name(finalLocator);
			else if (locator.startsWith("class"))
				locator_strategy = By.className(finalLocator);
			else if (locator.startsWith("link"))
				locator_strategy = By.linkText(finalLocator);
			else if (locator.startsWith("plink"))
				locator_strategy = By.partialLinkText(finalLocator);
			else if (locator.startsWith("tag"))
				locator_strategy = By.tagName(finalLocator);
			else
				throw new IllegalArgumentException(
						key + " is not valid locator, please recheck the locator once again");
			element = driver.findElement(locator_strategy);
		} else {
			System.out.println("Locator " + "'" + key + "'" + " is not exit in OR, please recheck");
		}
		return element;
	}

}

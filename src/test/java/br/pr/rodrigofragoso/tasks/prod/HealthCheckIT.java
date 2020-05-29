package br.pr.rodrigofragoso.tasks.prod;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class HealthCheckIT {
	
	@Test
	public void deveSalvarTarefaComSucesso() throws MalformedURLException {		
       	DesiredCapabilities cap = DesiredCapabilities.chrome();
		WebDriver driver = new RemoteWebDriver(new URL("http://192.168.25.14:4444/wd/hub"), cap);
		try {
			driver.navigate().to("http://192.168.25.14:9999/tasks");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			String version = driver.findElement(By.id("version")).getText();
			Assert.assertTrue(version.startsWith("build"));
			driver.quit();
		} finally {
			driver.quit();
		}
	}
	
}

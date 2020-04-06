package br.com.edsoft.tasks.funcional;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class TasksTest {
	public WebDriver acessaAplicacao() throws MalformedURLException {
//		WebDriver driver = new ChromeDriver();
		DesiredCapabilities cap = DesiredCapabilities.chrome();
		WebDriver driver = new RemoteWebDriver(new URL("http://192.168.0.107:4444/wd/hub"), cap);
//		driver.navigate().to("http://localhost:8001/tasks/");
		driver.navigate().to("http://192.168.0.107:8001/tasks/");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		return driver;
	}

	@Test
	public void deveSalvaTarefa() throws MalformedURLException {
		WebDriver driver = acessaAplicacao();
		try {
			driver.findElement(By.linkText("Add Todo")).click();
			driver.findElement(By.id("task")).sendKeys("teste5");
			driver.findElement(By.id("dueDate")).sendKeys("01/10/2020");
			driver.findElement(By.id("saveButton")).click();
		} finally {
			driver.quit();
		}
	}

	@Test
	public void naoDeveSalvaTarafaSemDescricao() throws MalformedURLException {
		WebDriver driver = acessaAplicacao();
		try {
			driver.findElement(By.linkText("Add Todo")).click();
			driver.findElement(By.id("dueDate")).sendKeys("01/10/2020");
			driver.findElement(By.id("saveButton")).click();
		} finally {
			driver.quit();
		}
	}

	@Test
	public void naoDeveSalvaTarafaSemData() throws MalformedURLException {
		WebDriver driver = acessaAplicacao();
		try {
			driver.findElement(By.linkText("Add Todo")).click();
			driver.findElement(By.id("task")).sendKeys("teste5");
			driver.findElement(By.id("saveButton")).click();
		} finally {
			driver.quit();
		}
	}

	@Test
	public void naoDeveSalvaTarafaComDataPassada() throws MalformedURLException {
		WebDriver driver = acessaAplicacao();
		try {
			driver.findElement(By.linkText("Add Todo")).click();

			driver.findElement(By.id("dueDate")).sendKeys("01/10/2010");
			driver.findElement(By.id("saveButton")).click();
			
		} finally {
			driver.quit();
		}
	}
	
	@Test
	public void deveSalvaTarafaComDataPassada() throws MalformedURLException {
		WebDriver driver = acessaAplicacao();
		try {
			driver.findElement(By.linkText("Add Todo")).click();
			driver.findElement(By.id("task")).sendKeys("teste5");
			driver.findElement(By.id("dueDate")).sendKeys("01/10/2010");
			driver.findElement(By.id("saveButton")).click();
			
			driver.findElement(By.xpath("//a[@class='btn btn-outline-danger btn-sm']")).click();
		} finally {
			driver.quit();
		}
	}
	
}

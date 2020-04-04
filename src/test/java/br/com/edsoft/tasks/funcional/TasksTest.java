package br.com.edsoft.tasks.funcional;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TasksTest {
	public WebDriver acessaAplicacao() {
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("http://localhost:8001/tasks/");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		return driver;
	}

	@Test
	public void deveSalvaTarefa() {
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
	public void naoDeveSalvaTarafaSemDescricao() {
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
	public void naoDeveSalvaTarafaSemData() {
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
	public void naoDeveSalvaTarafaComDataPassada() {
		WebDriver driver = acessaAplicacao();
		try {
			driver.findElement(By.linkText("Add Todo")).click();
			driver.findElement(By.id("dueDate")).sendKeys("01/10/2010");
			driver.findElement(By.id("saveButton")).click();
		} finally {
			driver.quit();
		}
	}
}

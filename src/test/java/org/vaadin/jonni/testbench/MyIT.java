package org.vaadin.jonni.testbench;

import org.junit.Assert;
import org.junit.Test;

import com.vaadin.flow.component.button.testbench.ButtonElement;
import com.vaadin.flow.component.html.testbench.ParagraphElement;
import com.vaadin.testbench.IPAddress;
import com.vaadin.testbench.TestBenchDriverProxy;
import com.vaadin.testbench.parallel.ParallelTest;

public class MyIT extends ParallelTest {
	public String APP_URL = "http://localhost:8080/";

	@Override
	public void setup() throws Exception {
		super.setup();
		if (getRunLocallyBrowser() == null) {
			APP_URL = "http://" + IPAddress.findSiteLocalAddress() + ":8080/";
		}
	}

	@Override
	public TestBenchDriverProxy getDriver() {
		return (TestBenchDriverProxy) super.getDriver();
	}

	@Test
	public void buttonClickAddsParagraph() {
		TestBenchDriverProxy driver = getDriver();
		driver.get(APP_URL);
		ButtonElement button = $(ButtonElement.class).waitForFirst();
		button.click();
		Assert.assertTrue("Paragraph element should be on page", $(ParagraphElement.class).exists());
		Assert.assertTrue("Paragraph element should contain 'was clicked'",
				$(ParagraphElement.class).get(0).getText().contains("was clicked"));
	}
}
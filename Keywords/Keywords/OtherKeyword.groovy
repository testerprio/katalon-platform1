package Keywords;

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import org.openqa.selenium.WebElement

import java.awt.Robot;
import java.awt.event.KeyEvent;
import internal.GlobalVariable

public class OtherKeyword {

	Robot robot = new Robot()

	/**
	 * select webElement based on index
	 * @param testObject list of webElement
	 * @param index 
	 * @return select the webElement
	 */
	@Keyword
	def selectObjectBasedOnIndex (TestObject to, String idx) {
		List<WebElement> arr = WebUI.findWebElements(to, 10)
		int x = Integer.parseInt(idx)
		arr[x].click()
	}

	/**
	 * Allow alert permission
	 */
	@Keyword
	def allowAllertPermission() {
		robot.delay(1000)
		robot.keyPress(KeyEvent.VK_TAB)
		robot.keyPress(KeyEvent.VK_TAB)
		robot.keyPress(KeyEvent.VK_ENTER)
		robot.keyRelease(KeyEvent.VK_ENTER)
	}
}

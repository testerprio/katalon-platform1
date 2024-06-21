package Keywords;

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty

import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil

import com.kms.katalon.core.webui.exception.WebElementNotFoundException
import org.openqa.selenium.Keys as Keys


class SupportMethod {

	Random rand = new Random()

	/**
	 * Refresh browser
	 */
	@Keyword
	def refreshBrowser() {
		KeywordUtil.logInfo("Refreshing")
		WebDriver webDriver = DriverFactory.getWebDriver()
		webDriver.navigate().refresh()
		KeywordUtil.markPassed("Refresh successfully")
	}

	/**
	 * Click element
	 * @param to Katalon test object
	 */
	@Keyword
	def clickElement(TestObject to) {
		try {
			WebElement element = WebUI.findWebElement(to);
			KeywordUtil.logInfo("Clicking element")
			element.click()
			KeywordUtil.markPassed("Element has been clicked")
		} catch (WebElementNotFoundException e) {
			KeywordUtil.markFailed("Element not found")
		} catch (Exception e) {
			KeywordUtil.markFailed("Fail to click on element")
		}
	}

	/**
	 * Get all rows of HTML table
	 * @param table Katalon test object represent for HTML table
	 * @param outerTagName outer tag name of TR tag, usually is TBODY
	 * @return All rows inside HTML table
	 */
	@Keyword
	def List<WebElement> getHtmlTableRows(TestObject table, String outerTagName) {
		WebElement mailList = WebUI.findWebElement(table)
		List<WebElement> selectedRows = mailList.findElements(By.xpath("./" + outerTagName + "/tr"))
		return selectedRows
	}

	/**
	 * Select randomly from webElements
	 * @param listObject
	 * @return click one of list
	 */
	@Keyword
	def selectRandomlyListobject (TestObject to) {
		List<WebElement> listObj = WebUI.findWebElements(to, 10)
		int length = listObj.size()
		int ranIdx = rand.nextInt(length)
		listObj[ranIdx].click()
	}


	/**
	 * Method Login to Comet
	 * @param text username
	 * @param text password
	 * @return Success login to Comet
	 */
	@Keyword
	def loginToComet (String user, String pass) {
		WebUI.openBrowser(GlobalVariable.URL_Comet)
		WebUI.maximizeWindow()
		WebUI.click(findTestObject('Object Repository/Comet/btn Class', [('className') : 'login']))
		WebUI.setText(findTestObject('Object Repository/Comet/input name', [('txtName') : 'loginfmt']), user)
		WebUI.click(findTestObject('Object Repository/Comet/input ID', [('idName') : 'idSIButton9']))
		WebUI.setEncryptedText(findTestObject('Object Repository/Comet/input name', [('txtName') : 'passwd']), pass)
		WebUI.click(findTestObject('Object Repository/Comet/input ID', [('idName') : 'idSIButton9']))
		WebUI.waitForElementPresent(findTestObject('Object Repository/Comet/input ID', [('idName') : 'KmsiCheckboxField']), 5)
		WebUI.click(findTestObject('Object Repository/Comet/input ID', [('idName') : 'idSIButton9']))
		WebUI.takeScreenshotAsCheckpoint('HomePage')
	}

	/**
	 * Method to logout from Comet
	 * return success logout from Comet
	 */
	@Keyword
	def logoutFromComet () {
		WebUI.click(findTestObject('Comet/RightNav'))
		WebUI.click(findTestObject('Comet/RightNav Logout'))
	}
}
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

WebUI.openBrowser(GlobalVariable.URL_Prioritas)

WebUI.maximizeWindow()

CustomKeywords.'OtherKeyword.selectObjectBasedOnIndex'(findTestObject('btn contains', [('attr') : '@class', ('val') : 'btn-secondary']), 
    '1')

CustomKeywords.'Keywords.OtherKeyword.selectObjectBasedOnIndex'(findTestObject('btn contains', [('attr') : '@class', ('val') : 'radio_picker']), 
    '1')

CustomKeywords.'SupportMethod.selectRandomlyListobject'(findTestObject('btn contains', [('attr') : '@class', ('val') : 'price']))

WebUI.click(findTestObject('btn contains', [('attr') : '@class', ('val') : 'btn-primary']))

CustomKeywords.'SupportMethod.selectRandomlyListobject'(findTestObject('btn contains', [('attr') : '@class', ('val') : 'w-100']))

CustomKeywords.'SupportMethod.selectRandomlyListobject'(findTestObject('btn contains', [('attr') : '@class', ('val') : 'select-square']))

WebUI.setText(findTestObject('input', [('attr') : '@name', ('val') : 'nama_lengkap']), custName)

WebUI.setText(findTestObject('input', [('attr') : '@name', ('val') : 'nomor_hp']), contactNumber)

WebUI.setText(findTestObject('input', [('attr') : '@name', ('val') : 'email']), email)

WebUI.setText(findTestObject('input', [('attr') : '@name', ('val') : 're_email']), email)

WebUI.click(findTestObject('btn contains', [('attr') : '@class', ('val') : 'btn-primary']))

CustomKeywords.'Keywords.OtherKeyword.selectObjectBasedOnIndex'(findTestObject('div contains', [('attr') : '@class', ('val') : 'cursor-pointer']), 
    '1')

CustomKeywords.'Keywords.OtherKeyword.selectObjectBasedOnIndex'(findTestObject('div contains', [('attr') : '@class', ('val') : 'd-flex justify-content-between']), 
    '2')

WebUI.check(findTestObject('div contains', [('attr') : '@class', ('val') : 'checkbox']))

WebUI.click(findTestObject('btn contains', [('attr') : '@class', ('val') : 'btn-primary']))


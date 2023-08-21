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

failedInputNilaiInvestasiBelowMinimum()

def failedInputNilaiInvestasiBelowMinimum() {

WebUI.openBrowser('https://www.shafiq.id/')
WebUI.maximizeWindow()
WebUI.scrollToElement(findTestObject('list_investasi'), 15)
TestObject investasiObject = findTestObject('list_investasi')
WebUI.click(investasiObject)
TestObject element1 = findTestObject('text_simulasi_investasi')
WebUI.scrollToElement(element1, 15)

TestObject inputElement = findTestObject('input_nilai_investasi')
String newValue = '5'

WebUI.sendKeys(findTestObject('input_nilai_investasi'), Keys.chord(Keys.CONTROL, 'a'))
WebUI.sendKeys(findTestObject('input_nilai_investasi'), Keys.chord(Keys.BACK_SPACE))
WebUI.click(inputElement)
WebUI.sendKeys(inputElement, newValue)

WebUI.verifyElementPresent(findTestObject('alertMessageJumlahMinimum'),15)
}
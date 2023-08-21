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

failedInputNilaiInvestasiMoreThanUnitSisa()

def failedInputNilaiInvestasiMoreThanUnitSisa() {

WebUI.openBrowser('https://www.shafiq.id/')
WebUI.maximizeWindow()
WebUI.scrollToElement(findTestObject('list_investasi'), 15)


TestObject investasiObject = findTestObject('list_investasi')
WebUI.click(investasiObject)
TestObject element1 = findTestObject('text_simulasi_investasi')
WebUI.scrollToElement(element1, 15)

def currentSisaUnit = WebUI.getText(findTestObject('get_text_unit_sisa'))

println(currentSisaUnit)

String[] splitresult = currentSisaUnit.split(' ')

TestObject inputElement = findTestObject('input_nilai_investasi')
def cleanedSisaUnit = currentSisaUnit.replaceAll("[^\\d.]", "") 
def newInvestmentValue = cleanedSisaUnit + 1


WebUI.sendKeys(findTestObject('input_nilai_investasi'), Keys.chord(Keys.CONTROL, 'a'))
WebUI.sendKeys(findTestObject('input_nilai_investasi'), Keys.chord(Keys.BACK_SPACE))
WebUI.click(inputElement)
WebUI.sendKeys(inputElement, newInvestmentValue)

def afterInputMoreThan = WebUI.getText(findTestObject('input_nilai_investasi'))

println(afterInputMoreThan)

//disini ouputnya kosong karena text dari input tidak bisa di get text, niatnya saya ingin membuat perbandingan apakah value after input morethan sama dengan yang diinpput sebelumnya atau berubah otomatis

}


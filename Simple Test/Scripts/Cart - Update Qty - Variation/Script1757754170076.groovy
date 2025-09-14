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

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.testobject.TestObject

// Buka browser dan masuk ke halaman Cart
WebUI.openBrowser(GlobalVariable.URLDev)

// Tambah produk pertama
WebUI.click(findTestObject('Object Repository/Cart/Catalog'))
WebUI.takeFullPageScreenshot()

WebUI.click(findTestObject('Object Repository/Cart/jacket'))
WebUI.takeFullPageScreenshot()

WebUI.click(findTestObject('Object Repository/Cart/addtochart'))
WebUI.takeFullPageScreenshot()

WebUI.delay(5)
WebUI.click(findTestObject('Object Repository/Cart/checkout'))
WebUI.takeFullPageScreenshot()

// Lanjut belanja produk kedua
WebUI.click(findTestObject('Object Repository/Cart/continueshopping'))
WebUI.takeFullPageScreenshot()

WebUI.click(findTestObject('Object Repository/Cart/sandals'))
WebUI.takeFullPageScreenshot()

WebUI.click(findTestObject('Object Repository/Cart/addtochart'))
WebUI.takeFullPageScreenshot()

WebUI.delay(5)
WebUI.click(findTestObject('Object Repository/Cart/checkout'))
WebUI.takeFullPageScreenshot()

// Daftar quantity yang akan diuji
def testQuantities = ["2.5", "99999", "0"]

for (qty in testQuantities) {
	WebUI.setText(findTestObject('Object Repository/Cart/qty'), qty)
	WebUI.takeFullPageScreenshot()
	
	WebUI.click(findTestObject('Object Repository/Cart/update'))
	WebUI.takeFullPageScreenshot()
	
	WebUI.delay(2)

}


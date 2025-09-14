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
import com.kms.katalon.core.webui.keyword.internal.WebUIAbstractKeyword
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.testdata.reader.ExcelFactory as ExcelFactory

// Buka browser
WebUI.openBrowser(GlobalVariable.URLDev)

WebUI.click(findTestObject('Object Repository/Page_Create Account  Sauce Demo/Sign_Up'))
WebUI.takeFullPageScreenshot()

// Ambil sheet 'Register' di Excel
def sheetRegisterGagal = ExcelFactory.getExcelDataWithDefaultSheet(
	GlobalVariable.FileProjectSimple + '\\ProjectSimple.xlsx', 'RegisterGagal', true
)

for (def row = 1; row <= sheetRegisterGagal.getRowNumbers(); row++) {
	String firstname = sheetRegisterGagal.getValue(1, row) // kolom A
	String lastname = sheetRegisterGagal.getValue(2, row)  // kolom B
	String email = sheetRegisterGagal.getValue(3, row)     // kolom C
	String password = sheetRegisterGagal.getValue(4, row)  // kolom D

	WebUI.comment("$firstname | $lastname | $email | $password")

	WebUI.setText(findTestObject('Object Repository/Page_Create Account  Sauce Demo/input_First Name'), firstname)
	WebUI.takeFullPageScreenshot()
	WebUI.setText(findTestObject('Object Repository/Page_Create Account  Sauce Demo/input_Last Name'), lastname)
	WebUI.takeFullPageScreenshot()
	WebUI.setText(findTestObject('Object Repository/Page_Create Account  Sauce Demo/input_Email Address'), email)
	WebUI.takeFullPageScreenshot()
	WebUI.setText(findTestObject('Object Repository/Page_Create Account  Sauce Demo/input_Password'), password)
	WebUI.takeFullPageScreenshot()

	WebUI.click(findTestObject('Object Repository/Page_Create Account  Sauce Demo/input_submit'))
	WebUI.takeFullPageScreenshot()
	
	WebUI.delay(10)
}
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
import com.kms.katalon.core.testdata.reader.ExcelFactory as ExcelFactory

// Buka browser
WebUI.openBrowser(GlobalVariable.URLDev)

WebUI.click(findTestObject('Object Repository/Cart/Catalog'))

WebUI.takeFullPageScreenshot()

WebUI.click(findTestObject('Object Repository/Cart/jacket'))

WebUI.takeFullPageScreenshot()

WebUI.click(findTestObject('Object Repository/Cart/addtochart'))

WebUI.takeFullPageScreenshot()

WebUI.delay(10)

WebUI.click(findTestObject('Object Repository/Cart/checkout'))

WebUI.takeFullPageScreenshot()

WebUI.click(findTestObject('Object Repository/Page_Checkout - Sauce Demo/input_Total_checkout'))

WebUI.takeFullPageScreenshot()

WebUI.delay(5)

// Ambil sheet 'Login' di Excel
def sheetcheckout= ExcelFactory.getExcelDataWithDefaultSheet(
	GlobalVariable.FileProjectSimple + '\\ProjectSimple.xlsx', 'checkout', true
)

for (def row = 1; row <= sheetcheckout.getRowNumbers(); row++) {
	String email = sheetcheckout.getValue(1, row)     // kolom A
	String country = sheetcheckout.getValue(2, row)  // kolom B
	String firstname = sheetcheckout.getValue(3, row)  // kolom C
	String lastname = sheetcheckout.getValue(4, row)  // kolom D
	String company = sheetcheckout.getValue(5, row)  // kolom E
	String address = sheetcheckout.getValue(6, row)  // kolom F
	String apartment = sheetcheckout.getValue(7, row)  // kolom G
	String city = sheetcheckout.getValue(8, row)  // kolom H
	String province = sheetcheckout.getValue(9, row)  // kolom I
	String postalcode = sheetcheckout.getValue(10, row)  // kolom J
	String phone = sheetcheckout.getValue(11, row)  // kolom K
	String cardnumber = sheetcheckout.getValue(12, row)  // kolom L
	String expiration = sheetcheckout.getValue(13, row)  // kolom M
	String securitycode = sheetcheckout.getValue(14, row)  // kolom N

	WebUI.comment("$email | $country | $firstname | $lastname | $company | $address | $city | $province | $postalcode | $phone | $cardnumber | $expiration | $securitycode")

	WebUI.setText(findTestObject('Object Repository/Page_Checkout - Sauce Demo/input_Email'), email)
	
	WebUI.click(findTestObject('Object Repository/Page_Checkout - Sauce Demo/ceklis_Email_marketing'))
	WebUI.takeFullPageScreenshot()
	
	// Wait for dropdown to be visible
	WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Checkout - Sauce Demo/Country'), 10)
	
	// Select country
	WebUI.selectOptionByValue(findTestObject('Object Repository/Page_Checkout - Sauce Demo/Country'), country, false)
	
	WebUI.setText(findTestObject('Object Repository/Page_Checkout - Sauce Demo/Firstname'), firstname)
	
	WebUI.setText(findTestObject('Object Repository/Page_Checkout - Sauce Demo/Lastname'), lastname)
	
	WebUI.setText(findTestObject('Object Repository/Page_Checkout - Sauce Demo/company'), company)
	
	WebUI.setText(findTestObject('Object Repository/Page_Checkout - Sauce Demo/address1'), address)
	
	WebUI.setText(findTestObject('Object Repository/Page_Checkout - Sauce Demo/address2'), apartment)
	
	WebUI.setText(findTestObject('Object Repository/Page_Checkout - Sauce Demo/city'), city)
	
	// Wait for dropdown to be visible
	WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Checkout - Sauce Demo/province'), 10)
	
	// Select country
	WebUI.selectOptionByValue(findTestObject('Object Repository/Page_Checkout - Sauce Demo/province'),province , false)
	
	WebUI.setText(findTestObject('Object Repository/Page_Checkout - Sauce Demo/postalcode'), postalcode)
	
	WebUI.setText(findTestObject('Object Repository/Page_Checkout - Sauce Demo/phone'), phone)
	WebUI.takeFullPageScreenshot()
	
	WebUI.click(findTestObject('Object Repository/Page_Checkout - Sauce Demo/ceklis_Phone (optional)_save_shipping_information'))
	WebUI.takeFullPageScreenshot()
	
	
	//WebUI.switchToFrame(findTestObject('Object Repository/Page_Checkout - Sauce Demo/iframe_card'), 10)
	//WebUI.setText(findTestObject('Object Repository/Page_Checkout - Sauce Demo/cardnumber'), cardnumber)
	//WebUI.switchToDefaultContent()
	
	WebUI.delay(20)
	//WebUI.switchToFrame(findTestObject('Object Repository/Page_Checkout - Sauce Demo/iframe_security'), 10)
	//WebUI.click(findTestObject('Object Repository/Page_Checkout - Sauce Demo/securitycode'))
	//WebUI.switchToDefaultContent()
	WebUI.takeFullPageScreenshot()
	
	
	
	WebUI.click(findTestObject('Object Repository/Page_Checkout - Sauce Demo/button_paynow'))
	WebUI.takeFullPageScreenshot()
}

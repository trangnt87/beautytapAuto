import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory as CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as MobileBuiltInKeywords
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testcase.TestCaseFactory as TestCaseFactory
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository as ObjectRepository
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WSBuiltInKeywords
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUiBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

import org.json.JSONObject



String r_string = '842256'

String username = 'auto' + r_string

String email = username + '@mailinator.com'

String password = '123456'

String newpassword = 'test123'

String name = 'Auto User ' + r_string

String birthday = '01/01/1990'

String activation_subject = GlobalVariable.SITE_TITLE + ' Activate your account'

String resetpass_subject = GlobalVariable.SITE_TITLE + ' Password Reset'

String productName = 'Papa Recipe Bombee Black Honey Mask Pack 2 Choices'
String variation="1 set (10ea)"
float price = 35
int quantity = 3
float total= 105
String json = '{"firstname":"FIRSTNAME","lastname":"LASTNAME","country":"COUNTRY","address":"ADDRESS","city":"CITY","state":"STATE","zip":"ZIP","email":"EMAIL"}'

JSONObject billingInfo = new JSONObject(json)
println billingInfo
//CustomKeywords.'beautytap.GeneralAction.openBeautytap'(GlobalVariable.SITE_URL)
//CustomKeywords.'beautytap.ShopAction.globalSearch'(productName)

//CustomKeywords.'beautytap.ShopAction.selectProductOnSearchResult'(productName)
//CustomKeywords.'beautytap.ShopAction.selectProductVariation'(variation)
//int currentItemInCart = CustomKeywords.'beautytap.ShopAction.getNumberItemInCart'()
//println currentItemInCart
//CustomKeywords.'beautytap.ShopAction.addProductToCart'(3)
//CustomKeywords.'beautytap.ShopAction.VerifyNumberItemInCart'(currentItemInCart+quantity)
//println currentItemInCart+quantity
//CustomKeywords.'beautytap.ShopAction.goToCart'()
//CustomKeywords.'beautytap.ShopAction.VerifyProductOnSearchResult'(productName,'$30.00',"grey",'$18.00',"pink")
//println CustomKeywords.'beautytap.ShopAction.getNumberItemInCart'()
//WebUI.selectOptionByLabel(findTestObject('Object Repository/Page_Checkout/drop_billingCountry'), "Australia", false)
//CustomKeywords.'beautytap.ShopAction.VerifyProductInCart'(productName,variation, price, quantity, total)
//CustomKeywords.'beautytap.ShopAction.processToCheckout'()
//CustomKeywords.'beautytap.ShopAction.checkoutViaAmazonPay'('cart', GlobalVariable.AMAZONPAY_EMAIL, GlobalVariable.AMAZONPAY_PASSWORD)
CustomKeywords.'beautytap.ShopAction.fillCustomerInformation'(billingInfo, resetpass_subject, email, null, username)


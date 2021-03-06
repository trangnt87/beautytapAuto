import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.json.JSONArray as JSONArray
import org.json.JSONObject as JSONObject
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

//Set variable
String productName = GlobalVariable.SIMPLE_SALE_PRODUCT

float saleprice = GlobalVariable.SIMPLE_SALE_PRICE

float regularprice = GlobalVariable.SIMPLE_SALE_REGULAR_PRICE

String r_string = new Math().random().toString().substring(2, 8)

String email = ('beauty' + r_string) + '@mailinator.com'

int currentNumberItemInCart 

int quantity = 2

float subtotal = CustomKeywords.'beautytap.ShopAction.calculateTotal'(quantity, saleprice)

float total = subtotal + GlobalVariable.SHIPPING_PRICE

total = CustomKeywords.'beautytap.ShopAction.calculateTotal'(1, total)

JSONArray products = new JSONArray('[{"productname":"' + productName + '","variation":"","quantity":"' + quantity + '","price":"' + saleprice + '"}]')

JSONObject billingInformation = new JSONObject('{"firstname":"Beauty","lastname":"Automation","country":"Vietnam","address":"123 Testing","city":"HCM","state":"","zip":"90012","email":"' + email + '","phone":"0123456789"}')

JSONArray shippingArray = new JSONArray('[{"shippingType":"normal","shippingMethod":"Shipping from Korea","shippingPrice":"'+ GlobalVariable.SHIPPING_PRICE +'","shippingLabel":"'+GlobalVariable.SHIPPING_LABEL+'"}]')

String paymentMethod = 'Credit Card Payment'

//---------------------------------------------------------
CustomKeywords.'beautytap.GeneralAction.openBeautytap'(GlobalVariable.SITE_URL)

CustomKeywords.'beautytap.ShopAction.globalSearch'(productName)

'VP1: Verify product display in search result panel with regular price'
CustomKeywords.'beautytap.ShopAction.VerifyProductOnSearchResult'(productName, regularprice, 'grey', saleprice, 'pink')

CustomKeywords.'beautytap.ShopAction.selectSearchResult'(productName)

'VP2: Verify product detail page display with regular price'
CustomKeywords.'beautytap.ShopAction.VerifyProductDetails'(productName, '', regularprice, 'grey', saleprice, 'pink')

currentNumberItemInCart = CustomKeywords.'beautytap.ShopAction.getNumberItemInCart'()

CustomKeywords.'beautytap.ShopAction.addProductToCart'(quantity)

'VP3:Verify product is added to card: cart number increase and message display “PRODUCT_NAME” has been added to your cart.'
CustomKeywords.'beautytap.ShopAction.VerifyNumberItemInCart'(currentNumberItemInCart + quantity)

CustomKeywords.'beautytap.ShopAction.VerifyProductIsAddedToCart'(productName)

CustomKeywords.'beautytap.ShopAction.goToCart'()

'VP4:Verify product is added to cart with correct price and quantity'
CustomKeywords.'beautytap.ShopAction.VerifyProductInCart'(productName, '', saleprice, quantity, subtotal)

CustomKeywords.'beautytap.ShopAction.processToCheckout'()

CustomKeywords.'beautytap.ShopAction.fillCustomerInformation'(billingInformation, 'no', null, null)

'VP5: Verify order details on checkout page'
CustomKeywords.'beautytap.ShopAction.VerifyOrderDetailsOnCheckout'(products, subtotal, shippingArray, total)

'Checkout by credit card'
CustomKeywords.'beautytap.ShopAction.checkoutViaCreditCard'(GlobalVariable.CREDITCARD_NUMBER, GlobalVariable.CARD_TYPE, 
    GlobalVariable.CARD_EXPIRATION_MONTH, GlobalVariable.CARD_EXPIRATION_YEAR, GlobalVariable.CARD_CVV)

WebUI.closeBrowser()


package pageobjects.client;

	import pageobjects.AbstractBasePageObject;
	import pageobjects.company.ManageReasonsPopup;
	import org.junit.Assert;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.How;
	import org.openqa.selenium.support.ui.WebDriverWait;
	import org.slf4j.Logger;
	import org.slf4j.LoggerFactory;
	import org.springframework.beans.factory.annotation.Autowired;

	/**
	 * Class representing Add Dispute Item Page in CRC application.
	 * Methods Load() and isLoaded() has to be implemented in a way that it represent the actual behaviour in real application.
	 */
	public class AddDisputeItemPage extends AbstractBasePageObject<AddDisputeItemPage> {

	    private static final Logger logger = LoggerFactory.getLogger(AddDisputeItemPage.class);

	    private static final String relativeUrl = "/userdesk/adddisputeitem";

	    @Autowired
	    private AddFurnisherPopup addFurnisherPopup;

	    @Autowired
	    private ManageReasonsPopup manageReasonsPopup;

	    public AddDisputeItemPage(WebDriver driver, WebDriverWait wait, String url) {
	        super(driver, wait, url);
	        setRelativeUrl(relativeUrl);
	        logger.debug("Instantiating page objects for " + getClass().getName());
	    }

	    @Override
	    protected void load() {
	        logger.warn(getClass().getSimpleName() + " was not loaded, attempting to load it now");
	        navigate_and_wait();
	    }

	    @Override
	    public void isLoaded() throws Error {
	        String url = getDriver().getCurrentUrl();
	        Assert.assertTrue("Not on the add new dispute item page: " + url, url.endsWith(relativeUrl));
	        logger.warn(getClass().getSimpleName() + " was loaded successfully");
	    }

	    @FindBy(how = How.XPATH, using = "//div[@class='indata']//div[contains(text(),'Add New Item')]")
	    private WebElement pageTitle;

	    @FindBy(how = How.ID, using = "bu_1")
	    private WebElement equifaxCheckbox;

	    @FindBy(how = How.ID, using = "bu_2")
	    private WebElement experianCheckbox;

	    @FindBy(how = How.ID, using = "bu_3")
	    private WebElement transUnionCheckbox;

	    @FindBy(how = How.ID, using = "cred_furn")
	    private WebElement creditorFurnisher;

	    @FindBy(how = How.ID, using = "manageFurnisher")
	    private WebElement addNewCreditorFurnisher;

	    @FindBy(how = How.ID, using = "ac_no")
	    private WebElement accountNumber;

	    @FindBy(how = How.ID, using = "acno_1")
	    private WebElement accountNumber1; //Only if Different account is enabled

	    @FindBy(how = How.ID, using = "acno_2")
	    private WebElement accountNumber2;

	    @FindBy(how = How.XPATH, using = "//div[@class='indata']//a[contains(text(),'Different for each bureau')]")
	    private WebElement differentAccountNuumberLink;

	    @FindBy(how = How.ID, using = "reason")
	    private WebElement reason;

	    @FindBy(how = How.ID, using = "manageReson")
	    private WebElement manageReason;

	    @FindBy(how = How.ID, using = "explanation_cmb")
	    private WebElement instruction;

	    @FindBy(how = How.ID, using = "explanation")
	    private WebElement instructionText;

	    @FindBy(how = How.XPATH, using = "//div//a[contains(text(),'Add new instruction')]")
	    private WebElement manageInstruction;

	    @FindBy(how = How.ID, using = "add-another-dispute-item-WEF")
	    private WebElement submitButton;

	    public AddFurnisherPopup getAddFurnisherPopup() {
	        return addFurnisherPopup;
	    }

	    public ManageReasonsPopup getManageReasonsPopup() {
	        return manageReasonsPopup;
	    }

	    public WebElement getPageTitle() {
	        return pageTitle;
	    }

	    public WebElement getEquifaxCheckbox() {
	        return equifaxCheckbox;
	    }

	    public WebElement getExperianCheckbox() {
	        return experianCheckbox;
	    }

	    public WebElement getTransUnionCheckbox() {
	        return transUnionCheckbox;
	    }

	    public void selectCreditorFurnisher(int index){
	        select_dropdown_by_index(creditorFurnisher, index);
	    }

	    public WebElement getAddNewCreditorFurnisher() {
	        return addNewCreditorFurnisher;
	    }

	    public void inputAccountNumber(String text) {
	        set_text(accountNumber, text);
	    }

	    public WebElement getAccountNumber1() {
	        return accountNumber1;
	    }

	    public WebElement getAccountNumber2() {
	        return accountNumber2;
	    }

	    public void inputAccountNumber1(String text) {
	        set_text(accountNumber1, text);
	    }

	    public void inputAccountNumber2(String text) {
	        set_text(accountNumber2, text);
	    }

	    public WebElement getDifferentAccountNuumberLink() {
	        return differentAccountNuumberLink;
	    }

	    public void selectReason(int index){
	        select_dropdown_by_index(reason, index);
	    }

	    public WebElement getManageReason() {
	        return manageReason;
	    }

	    public void selectInstruction(int index){
	        select_dropdown_by_index(instruction, index);
	    }

	    public void inputInstruction(String text) {
	        set_text(instructionText, text);
	    }

	    public WebElement getManageInstruction() {
	        return manageInstruction;
	    }

	    public WebElement getSubmitButton() {
	        return submitButton;
	    }

	}


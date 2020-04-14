package pageobjects.messages;

	import pageobjects.AbstractBasePageObject;
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
	 * Class representing Send New Messages Page in CRC application.
	 * Methods Load() and isLoaded() has to be implemented in a way that it represent the actual behaviour in real application.
	 */
	public class SendNewMessagePage extends AbstractBasePageObject<SendNewMessagePage> {

	    private static final Logger logger = LoggerFactory.getLogger(SendNewMessagePage.class);

	    private static final String relativeUrl = "/messages/send";

	    @Autowired
	    private ManageQuickNotesPage manageQuickNotesPage;

	    public SendNewMessagePage(WebDriver driver, WebDriverWait wait, String url) {
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
	        Assert.assertTrue("Not on the send new messages page: " + url, url.endsWith(relativeUrl));
	        logger.warn(getClass().getSimpleName() + " was loaded successfully");
	    }

	    @FindBy(how = How.XPATH, using = "//div[@class='indata']//div[contains(text(),'Send Message')]")
	    private WebElement pageTitle;

	    @FindBy(how = How.ID, using = "client_radio")
	    private WebElement toClient;

	    @FindBy(how = How.ID, using = "affiliate_radio")
	    private WebElement toAffiliate;

	    @FindBy(how = How.ID, using = "teammember_radio")
	    private WebElement toTeamMember;

	    @FindBy(how = How.ID, using = "client_cmb")
	    private WebElement clientSelect;

	    @FindBy(how = How.ID, using = "affiliate_cmb")
	    private WebElement affiliateSelect;

	    @FindBy(how = How.ID, using = "team_cmb")
	    private WebElement teamMemberSelect;

	    @FindBy(how = How.ID, using = "subject")
	    private WebElement subject;

	    @FindBy(how = How.ID, using = "choose_from_quicknotes")
	    private WebElement quickNotesSelect;

	    @FindBy(how = How.XPATH, using = "//form[@name='addmessage']//a[contains(text(),'Manage Quick Notes')]")
	    private WebElement manageQuickNotesLink;

	    @FindBy(how = How.XPATH, using = "html/body")
	    private WebElement messageEditor;

	    @FindBy(how = How.XPATH, using = "//div[@class='MultiFile-wrap']/input")
	    private WebElement attachments;

	    @FindBy(how = How.ID, using = "save_as_qnote")
	    private WebElement saveAsQuoteCheckbox;

	    @FindBy(how = How.ID, using = "qnote_title")
	    private WebElement quickNoteTitle;

	    @FindBy(how = How.ID, using = "submit")
	    private WebElement submitButton;

	    public ManageQuickNotesPage getManageQuickNotesPage() {
	        return manageQuickNotesPage;
	    }

	    public WebElement getPageTitle() {
	        return pageTitle;
	    }

	    public WebElement getToClient() {
	        return toClient;
	    }

	    public WebElement getToAffiliate() {
	        return toAffiliate;
	    }

	    public WebElement getToTeamMember() {
	        return toTeamMember;
	    }

	    public WebElement getClientSelect() {
	        return clientSelect;
	    }

	    public WebElement getAffiliateSelect() {
	        return affiliateSelect;
	    }

	    public WebElement getTeamMemberSelect() {
	        return teamMemberSelect;
	    }

	    public WebElement getManageQuickNotesLink() {
	        return manageQuickNotesLink;
	    }

	    public void inputMessage(String text) {
	        set_text(messageEditor, text);
	    }

	    public WebElement getAttachments() {
	        return attachments;
	    }

	    public WebElement getSaveAsQuoteCheckbox() {
	        return saveAsQuoteCheckbox;
	    }

	    public WebElement getSubmitButton() {
	        return submitButton;
	    }

	    public void selectClient(int index){
	        select_dropdown_by_index(clientSelect, index);
	    }

	    public void selectAffiliate(int index){
	        select_dropdown_by_index(affiliateSelect, index);
	    }

	    public void selectTeamMember(int index){
	        select_dropdown_by_index(teamMemberSelect, index);
	    }

	    public void inputSubject(String text) {
	        set_text(subject, text);
	    }

	    public void selectQuickNotes(int index){
	        select_dropdown_by_index(quickNotesSelect, index);
	    }

	    public WebElement getQuickNoteTitle() {
	        return quickNoteTitle;
	    }

	    public void inputQuickNoteTitle(String text) {
	        set_text(quickNoteTitle, text);
	    }

	}


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

	import java.util.ArrayList;

	/**
	 * Class representing Dispute Wizard Step3 Page in CRC application.
	 * Methods Load() and isLoaded() has to be implemented in a way that it represent the actual behaviour in real application.
	 */
	public class DisputeWizardStep3Page extends AbstractBasePageObject<DisputeWizardStep3Page> {

	    private static final Logger logger = LoggerFactory.getLogger(DisputeWizardStep3Page.class);

	    private static final String relativeUrl = "/wizard/step3/";

	    @Autowired
	    private SavedPendingItemPopup savedPendingItemPopup;

	    @Autowired
	    private SaveDisputeLettersPopup saveDisputeLettersPopup;

	    @Autowired
	    private AddFurnisherPopup addFurnisherPopup;

	    @Autowired
	    private ManageReasonsPopup manageReasonsPopup;

	    @Autowired
	    private PreviewLettersPopup previewLettersPopup;

	    @Autowired
	    private SavedLettersPage savedLettersPage;

	    @Autowired
	    private UnsavedLetterWarningPopup unsavedLetterWarningPopup;

	    public DisputeWizardStep3Page(WebDriver driver, WebDriverWait wait, String url) {
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
	        Assert.assertTrue("Not on the dispute wizard step 3 page: " + url, url.contains(relativeUrl));
	        logger.warn(getClass().getSimpleName() + " was loaded successfully");
	    }

	    @FindBy(how = How.XPATH, using = "//div[@class='chbox normaltext1']//a[@id='vediopopup'][1]")
	    private WebElement addingReportQuickVideo;

	    @FindBy(how = How.XPATH, using = "//div[@class='chbox normaltext1']//a[@id='vediopopup'][2]")
	    private WebElement savedItemsQuickVideo;

	    @FindBy(how = How.CLASS_NAME, using = "fancybox-outer")
	    private WebElement videoPopup;

	    @FindBy(how = How.XPATH, using = "//a[@class='fancybox-item fancybox-close']")
	    private WebElement videoPopupCloseButton;

	    @FindBy(how = How.XPATH, using = "//div[@class='contentbg']//input[@id='letterType_r1']")
	    private WebElement round1Radio;

	    @FindBy(how = How.XPATH, using = "//div[@class='contentbg']//input[@id='letterType_other']")
	    private WebElement round2Radio;

	    @FindBy(how = How.XPATH, using = "//div[@class='contentbg']//tr[@id='Report_Number_Section']")
	    private WebElement reportNumberSection;

	    @FindBy(how = How.XPATH, using = "//div[@class='contentbg']//tr[@id='r2_letterto_spot']")
	    private WebElement bureauFurnisherSection;

	    @FindBy(how = How.XPATH, using = "//div[@class='contentbg']//div[@class='gray-btn btn-r2'][1]")
	    private WebElement addNewItemButton;

	    @FindBy(how = How.XPATH, using = "//div[@class='contentbg']//a[contains(text(),'ADD SAVED/PENDING ITEM')]")
	    private WebElement addSavedPendingItemsButton;

	    @FindBy(how = How.XPATH, using = "//div[@class='contentbg']//a[contains(text(),'PREVIOUSLY SAVED/PENDING ITEM')]")
	    private WebElement addSavedPendingItemsRound2Button;

	    @FindBy(how = How.XPATH, using = "//div[@class='contentbg']//a[contains(text(),'ADD NEW ITEM')]")
	    private WebElement addNewItemRound2Button;

	    @FindBy(how = How.ID, using = "r2_letterto_furn")
	    private WebElement letterToCredFurn;

	    @FindBy(how = How.ID, using = "frm_add_dispute")
	    private WebElement disputeForm;

	    @FindBy(how = How.ID, using = "bu_1")
	    private WebElement equifaxCheckbox;

	    @FindBy(how = How.ID, using = "bu_2")
	    private WebElement experianCheckbox;

	    @FindBy(how = How.ID, using = "bu_3")
	    private WebElement transunionCheckbox;

	    @FindBy(how = How.ID, using = "cred_furn")
	    private WebElement creditorFurnisher;

	    @FindBy(how = How.ID, using = "manageFurnisher")
	    private WebElement addCredtorFurnisher;

	    @FindBy(how = How.ID, using = "ac_no")
	    private WebElement accountNumber;

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

	    @FindBy(how = How.ID, using = "add_item3")
	    private WebElement continueButton;

	    @FindBy(how = How.ID, using = "tmp_dispute_item")
	    private WebElement addedDisputeItemContainer;

	    @FindBy(how = How.ID, using = "checkalltrselected")
	    private WebElement addedDisputeItemContainerHeader;

	    @FindBy(how = How.XPATH, using = "//div[@class='gridtable']//input[@type='checkbox']")
	    private WebElement firstDisputedItemCheckbox;

	    @FindBy(how = How.ID, using = "dispute_added_frm")
	    private WebElement addedDisputeItemForm;

	    @FindBy(how = How.ID, using = "showNextDisputeToLast")
	    private WebElement nextButton;

	    @FindBy(how = How.CLASS_NAME, using = "step5box")
	    private WebElement letterEditor;

	    @FindBy(how = How.ID, using = "1_editor_parent")
	    private WebElement letterEditorContent;

	    @FindBy(how = How.XPATH, using = "html/body")
	    private WebElement letterContent;

	    @FindBy(how = How.ID, using = "export_as")
	    private WebElement exportAsPDFButton;

	    @FindBy(how = How.ID, using = "save_letter_pp")
	    private WebElement saveLettersButton;

	    @FindBy(how = How.ID, using = "preview_letter")
	    private WebElement previewLetterButton;

	    @FindBy(how = How.ID, using = "my_save_letter_pp")
	    private WebElement mySavedLettersButton;

	    @FindBy(how = How.ID, using = "letter_from_library")
	    private WebElement letterFromLibraryRadio;

	    @FindBy(how = How.ID, using = "library_tmpl_area")
	    private WebElement libraryContainer;

	    @FindBy(how = How.ID, using = "selected_tmpl")
	    private WebElement letterSelect;

	    @FindBy(how = How.ID, using = "letter_tmpl_id")
	    private WebElement letterNameSelect;

	    @FindBy(how = How.XPATH, using = "//div[@id='htab']/ul/li[2]") //Only true if all three bureaus are selected
	    private WebElement experianTab;

	    @FindBy(how = How.XPATH, using = "//div[@id='htab']/ul/li[3]") //Only true if all three bureaus are selected
	    private WebElement transUnionTab;

	    @FindBy(how = How.XPATH, using = "//div[@id='htab']/ul/li[last()]")
	    private WebElement clientDocsTab;

	    @FindBy(how = How.XPATH, using = "//div[@id='step5content']//div[@id='htab'][1]//div[@class='normaltext1']")
	    private WebElement clientDocsContainer;

	    @FindBy(how = How.XPATH, using = "//div[@class='step5box']//div[@class='tips']//a[contains(text(),'Saved letters')]")
	    private WebElement tipSavedLettersLink;

	    @FindBy(how = How.XPATH, using = "//div[@class='step5box']//div[@class='tips']//a[contains(text(),'dashboard')]")
	    private WebElement tipClientDashboardLink;

	    public WebElement getAddingReportQuickVideo() {
	        return addingReportQuickVideo;
	    }

	    public WebElement getSavedItemsQuickVideo() {
	        return savedItemsQuickVideo;
	    }

	    public WebElement getVideoPopup() {
	        return videoPopup;
	    }

	    public WebElement getVideoPopupCloseButton() {
	        return videoPopupCloseButton;
	    }

	    public SavedPendingItemPopup getSavedPendingItemPopup() {
	        return savedPendingItemPopup;
	    }

	    public SaveDisputeLettersPopup getSaveDisputeLettersPopup() {
	        return saveDisputeLettersPopup;
	    }

	    public AddFurnisherPopup getAddFurnisherPopup() {
	        return addFurnisherPopup;
	    }

	    public ManageReasonsPopup getManageReasonsPopup() {
	        return manageReasonsPopup;
	    }

	    public PreviewLettersPopup getPreviewLettersPopup() {
	        return previewLettersPopup;
	    }

	    public SavedLettersPage getSavedLettersPage() {
	        return savedLettersPage;
	    }

	    public UnsavedLetterWarningPopup getUnsavedLetterWarningPopup() {
	        return unsavedLetterWarningPopup;
	    }

	    public WebElement getRound1Radio() {
	        return round1Radio;
	    }

	    public WebElement getRound2Radio() {
	        return round2Radio;
	    }

	    public WebElement getReportNumberSection() {
	        return reportNumberSection;
	    }

	    public WebElement getBureauFurnisherSection() {
	        return bureauFurnisherSection;
	    }

	    public WebElement getAddNewItemButton() {
	        return addNewItemButton;
	    }

	    public WebElement getAddSavedPendingItemsButton() {
	        return addSavedPendingItemsButton;
	    }

	    public WebElement getAddSavedPendingItemsRound2Button() {
	        return addSavedPendingItemsRound2Button;
	    }

	    public WebElement getAddNewItemRound2Button() {
	        return addNewItemRound2Button;
	    }

	    public WebElement getDisputeForm() {
	        return disputeForm;
	    }

	    public WebElement getEquifaxCheckbox() {
	        return equifaxCheckbox;
	    }

	    public WebElement getExperianCheckbox() {
	        return experianCheckbox;
	    }

	    public WebElement getTransunionCheckbox() {
	        return transunionCheckbox;
	    }

	    public void selectCreditorFurnisher(int index){
	        select_dropdown_by_index(creditorFurnisher, index);
	    }

	    public void inputAccountNumber(String text) {
	        set_text(accountNumber, text);
	    }

	    public void selectReason(int index){
	        select_dropdown_by_index(reason, index);
	    }

	    public void selectInstruction(int index){
	        select_dropdown_by_index(instruction, index);
	    }

	    public WebElement getContinueButton() {
	        return continueButton;
	    }

	    public WebElement getAddedDisputeItemContainer() {
	        return addedDisputeItemContainer;
	    }

	    public WebElement getAddedDisputeItemContainerHeader() {
	        return addedDisputeItemContainerHeader;
	    }

	    public WebElement getAddedDisputeItemForm() {
	        return addedDisputeItemForm;
	    }

	    public WebElement getFirstDisputedItemCheckbox() {
	        return firstDisputedItemCheckbox;
	    }

	    public WebElement getNextButton() {
	        return nextButton;
	    }

	    public WebElement getLetterEditor() {
	        return letterEditor;
	    }

	    public WebElement getLetterEditorContent() {
	        return letterEditorContent;
	    }

	    public WebElement getExportAsPDFButton() {
	        return exportAsPDFButton;
	    }

	    public WebElement getSaveLettersButton() {
	        return saveLettersButton;
	    }

	    public void pdfLoadedInTab() throws Error, Exception {
	        ArrayList<String> tabs = new ArrayList<String>(webdriver.getWindowHandles());
	        String url = getDriver().getCurrentUrl();
	        logger.debug("url before: {}", url);
	        webdriver.switchTo().window(tabs.get(1)); //switches to new tab
	        Thread.sleep(2000);
	        url = getDriver().getCurrentUrl();
	        logger.debug("url now: {}", url);
	        Assert.assertTrue("Not on the exported pdf page: " + url, url.contains("/common/exportfile/"));
	        logger.warn(getClass().getSimpleName() + " was loaded successfully");
	        getDriver().close();
	        webdriver.switchTo().window(tabs.get(0)); //switches to old tab
	    }

	    public WebElement getLetterFromLibraryRadio() {
	        return letterFromLibraryRadio;
	    }

	    public WebElement getLibraryContainer() {
	        return libraryContainer;
	    }

	    public void selectLetterFromLibrary(int index){
	        select_dropdown_by_index(letterSelect, index);
	    }

	    public void selectLetterName(int index){
	        select_dropdown_by_index(letterNameSelect, index);
	    }

	    public WebElement getAddCredtorFurnisher() {
	        return addCredtorFurnisher;
	    }

	    public WebElement getManageReason() {
	        return manageReason;
	    }

	    public WebElement getManageInstruction() {
	        return manageInstruction;
	    }

	    public void inputInstruction(String text) {
	        set_text(instructionText, text);
	    }

	    public WebElement getLetterContent() {
	        return letterContent;
	    }

	    public void inputLetterContent(String text) {
	        set_text(letterContent, text);
	    }

	    public WebElement getPreviewLetterButton() {
	        return previewLetterButton;
	    }

	    public WebElement getMySavedLettersButton() {
	        return mySavedLettersButton;
	    }

	    public WebElement getLetterToCredFurn() {
	        return letterToCredFurn;
	    }

	    public WebElement getExperianTab() {
	        return experianTab;
	    }

	    public WebElement getTransUnionTab() {
	        return transUnionTab;
	    }

	    public WebElement getClientDocsTab() {
	        return clientDocsTab;
	    }

	    public WebElement getClientDocsContainer() {
	        return clientDocsContainer;
	    }

	    public WebElement getTipSavedLettersLink() {
	        return tipSavedLettersLink;
	    }

	    public WebElement getTipClientDashboardLink() {
	        return tipClientDashboardLink;
	    }
	}

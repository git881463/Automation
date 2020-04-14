package pageobjects.messages;

	import org.springframework.beans.factory.annotation.Autowired;

	/**
	 * Helper class for the Message section.
	 */
	public class MessageSectionHelper {

	    @Autowired
	    private MessageSectionNavigationBar messageSectionNavigationBar;

	    @Autowired
	    private AllMessagesPage allMessagesPage;

	    @Autowired
	    private ClientMessagesPage clientMessagesPage;

	    @Autowired
	    private AffiliateMessagesPage affiliateMessagesPage;

	    @Autowired
	    private TeamMemberMessagesPage teamMemberMessagesPage;

	    @Autowired
	    private SendNewMessagePage sendNewMessagePage;

	    public MessageSectionNavigationBar getMessageSectionNavigationBar() {
	        return messageSectionNavigationBar;
	    }

	    public AllMessagesPage getAllMessagesPage() {
	        return allMessagesPage;
	    }

	    public ClientMessagesPage getClientMessagesPage() {
	        return clientMessagesPage;
	    }

	    public AffiliateMessagesPage getAffiliateMessagesPage() {
	        return affiliateMessagesPage;
	    }

	    public TeamMemberMessagesPage getTeamMemberMessagesPage() {
	        return teamMemberMessagesPage;
	    }

	    public SendNewMessagePage getSendNewMessagePage() {
	        return sendNewMessagePage;
	    }
	}



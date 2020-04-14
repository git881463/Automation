package helper;

	import java.util.ArrayList;
	import java.util.List;

	/**
	 * Helper class that can be used to store exception and later used to verify if certain exception was indeed thrown.
	 * Reference: https://stackoverflow.com/questions/17272161/cucumber-jvm-test-if-the-correct-exception-is-thrown
	 */
	public class ExceptionHandlingHelper {

	    private boolean expectException;
	    private List<RuntimeException> exceptions = new ArrayList<>();

	    public void expectException() {
	        expectException = true;
	    }

	    public void add(RuntimeException e) {
	        if (!expectException) {
	            throw e;
	        }
	        exceptions.add(e);
	    }

	    public List<RuntimeException> getExceptions() {
	        return exceptions;
	    }
	}



package org.wso2.am.analytics.publisher.sample.reporter;

public class CustomDataUsageException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CustomDataUsageException(String msg) {
		super(msg);
	}

	public CustomDataUsageException(String msg, Throwable e) {
		super(msg, e);
	}

	public CustomDataUsageException(Throwable throwable) {
		super(throwable);
	}
}

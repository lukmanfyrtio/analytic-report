package org.wso2.am.analytics.publisher.sample.reporter;

public class PlanData {
	private String monetizationPlan;
	private String currency;
	private String fixedRate;
	private String pricePerRequest;
	private String billingCycle;
	private String subscriptionId;

	public String getMonetizationPlan() {
		return monetizationPlan;
	}

	public void setMonetizationPlan(String monetizationPlan) {
		this.monetizationPlan = monetizationPlan;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getFixedRate() {
		return fixedRate;
	}

	public void setFixedRate(String fixedRate) {
		this.fixedRate = fixedRate;
	}

	public String getPricePerRequest() {
		return pricePerRequest;
	}

	public void setPricePerRequest(String pricePerRequest) {
		this.pricePerRequest = pricePerRequest;
	}

	public String getBillingCycle() {
		return billingCycle;
	}

	public void setBillingCycle(String billingCycle) {
		this.billingCycle = billingCycle;
	}

	public String getSubscriptionId() {
		return subscriptionId;
	}

	public void setSubscriptionId(String subscriptionId) {
		this.subscriptionId = subscriptionId;
	}

	@Override
	public String toString() {
		return "PlanData [monetizationPlan=" + monetizationPlan + ", currency=" + currency + ", fixedRate=" + fixedRate
				+ ", pricePerRequest=" + pricePerRequest + ", billingCycle=" + billingCycle + ", subscriptionId="
				+ subscriptionId + "]";
	}

}

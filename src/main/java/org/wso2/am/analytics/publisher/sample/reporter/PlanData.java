package org.wso2.am.analytics.publisher.sample.reporter;

public class PlanData {
  private String monetizationPlan;
  
  private String currency;
  
  private String fixedRate;
  
  private String pricePerRequest;
  
  private String billingCycle;
  
  private String subscriptionId;
  
  private String subscriptionIdUuid;
  
  private String billingPlan;
  
  public String getMonetizationPlan() {
    return this.monetizationPlan;
  }
  
  public void setMonetizationPlan(String monetizationPlan) {
    this.monetizationPlan = monetizationPlan;
  }
  
  public String getCurrency() {
    return this.currency;
  }
  
  public void setCurrency(String currency) {
    this.currency = currency;
  }
  
  public String getFixedRate() {
    return this.fixedRate;
  }
  
  public void setFixedRate(String fixedRate) {
    this.fixedRate = fixedRate;
  }
  
  public String getPricePerRequest() {
    return this.pricePerRequest;
  }
  
  public void setPricePerRequest(String pricePerRequest) {
    this.pricePerRequest = pricePerRequest;
  }
  
  public String getBillingCycle() {
    return this.billingCycle;
  }
  
  public void setBillingCycle(String billingCycle) {
    this.billingCycle = billingCycle;
  }
  
  public String getSubscriptionId() {
    return this.subscriptionId;
  }
  
  public void setSubscriptionId(String subscriptionId) {
    this.subscriptionId = subscriptionId;
  }
  
  public String toString() {
    return "PlanData [monetizationPlan=" + this.monetizationPlan + ", currency=" + this.currency + ", fixedRate=" + this.fixedRate + ", pricePerRequest=" + this.pricePerRequest + ", billingCycle=" + this.billingCycle + ", subscriptionId=" + this.subscriptionId + "]";
  }
  
  public String getSubscriptionIdUuid() {
    return this.subscriptionIdUuid;
  }
  
  public void setSubscriptionIdUuid(String subscriptionIdUuid) {
    this.subscriptionIdUuid = subscriptionIdUuid;
  }
  
  public String getBillingPlan() {
    return this.billingPlan;
  }
  
  public void setBillingPlan(String billingPlan) {
    this.billingPlan = billingPlan;
  }
}

package org.wso2.am.analytics.publisher.sample.reporter;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MetricData {
  @JsonProperty("apiName")
  private String apiName;
  
  @JsonProperty("proxyResponseCode")
  private int proxyResponseCode;
  
  @JsonProperty("destination")
  private String destination;
  
  @JsonProperty("apiCreatorTenantDomain")
  private String apiCreatorTenantDomain;
  
  @JsonProperty("platform")
  private String platform;
  
  @JsonProperty("apiMethod")
  private String apiMethod;
  
  @JsonProperty("apiVersion")
  private String apiVersion;
  
  @JsonProperty("gatewayType")
  private String gatewayType;
  
  @JsonProperty("apiCreator")
  private String apiCreator;
  
  @JsonProperty("responseCacheHit")
  private boolean responseCacheHit;
  
  @JsonProperty("backendLatency")
  private int backendLatency;
  
  @JsonProperty("correlationId")
  private String correlationId;
  
  @JsonProperty("requestMediationLatency")
  private int requestMediationLatency;
  
  @JsonProperty("keyType")
  private String keyType;
  
  @JsonProperty("apiId")
  private String apiId;
  
  @JsonProperty("applicationName")
  private String applicationName;
  
  @JsonProperty("targetResponseCode")
  private int targetResponseCode;
  
  @JsonProperty("requestTimestamp")
  private String requestTimestamp;
  
  @JsonProperty("applicationOwner")
  private String applicationOwner;
  
  @JsonProperty("userAgent")
  private String userAgent;
  
  @JsonProperty("eventType")
  private String eventType;
  
  @JsonProperty("apiResourceTemplate")
  private String apiResourceTemplate;
  
  @JsonProperty("responseLatency")
  private int responseLatency;
  
  @JsonProperty("regionId")
  private String regionId;
  
  @JsonProperty("responseMediationLatency")
  private int responseMediationLatency;
  
  @JsonProperty("userIp")
  private String userIp;
  
  @JsonProperty("applicationId")
  private String applicationId;
  
  @JsonProperty("apiType")
  private String apiType;
  
  @JsonProperty("errorType")
  private String errorType;
  
  @JsonProperty("errorMessage")
  private String errorMessage;
  
  @JsonProperty("errorCode")
  private String errorCode;
  
  public String getErrorCode() {
    return this.errorCode;
  }
  
  public void setErrorCode(String errorCode) {
    this.errorCode = errorCode;
  }
  
  public String getApiName() {
    return this.apiName;
  }
  
  public void setApiName(String apiName) {
    this.apiName = apiName;
  }
  
  public int getProxyResponseCode() {
    return this.proxyResponseCode;
  }
  
  public void setProxyResponseCode(int proxyResponseCode) {
    this.proxyResponseCode = proxyResponseCode;
  }
  
  public String getDestination() {
    return this.destination;
  }
  
  public void setDestination(String destination) {
    this.destination = destination;
  }
  
  public String getApiCreatorTenantDomain() {
    return this.apiCreatorTenantDomain;
  }
  
  public void setApiCreatorTenantDomain(String apiCreatorTenantDomain) {
    this.apiCreatorTenantDomain = apiCreatorTenantDomain;
  }
  
  public String getPlatform() {
    return this.platform;
  }
  
  public void setPlatform(String platform) {
    this.platform = platform;
  }
  
  public String getApiMethod() {
    return this.apiMethod;
  }
  
  public void setApiMethod(String apiMethod) {
    this.apiMethod = apiMethod;
  }
  
  public String getApiVersion() {
    return this.apiVersion;
  }
  
  public void setApiVersion(String apiVersion) {
    this.apiVersion = apiVersion;
  }
  
  public String getGatewayType() {
    return this.gatewayType;
  }
  
  public void setGatewayType(String gatewayType) {
    this.gatewayType = gatewayType;
  }
  
  public String getApiCreator() {
    return this.apiCreator;
  }
  
  public void setApiCreator(String apiCreator) {
    this.apiCreator = apiCreator;
  }
  
  public boolean isResponseCacheHit() {
    return this.responseCacheHit;
  }
  
  public void setResponseCacheHit(boolean responseCacheHit) {
    this.responseCacheHit = responseCacheHit;
  }
  
  public int getBackendLatency() {
    return this.backendLatency;
  }
  
  public void setBackendLatency(int backendLatency) {
    this.backendLatency = backendLatency;
  }
  
  public String getCorrelationId() {
    return this.correlationId;
  }
  
  public void setCorrelationId(String correlationId) {
    this.correlationId = correlationId;
  }
  
  public int getRequestMediationLatency() {
    return this.requestMediationLatency;
  }
  
  public void setRequestMediationLatency(int requestMediationLatency) {
    this.requestMediationLatency = requestMediationLatency;
  }
  
  public String getKeyType() {
    return this.keyType;
  }
  
  public void setKeyType(String keyType) {
    this.keyType = keyType;
  }
  
  public String getApiId() {
    return this.apiId;
  }
  
  public void setApiId(String apiId) {
    this.apiId = apiId;
  }
  
  public String getApplicationName() {
    return this.applicationName;
  }
  
  public void setApplicationName(String applicationName) {
    this.applicationName = applicationName;
  }
  
  public int getTargetResponseCode() {
    return this.targetResponseCode;
  }
  
  public void setTargetResponseCode(int targetResponseCode) {
    this.targetResponseCode = targetResponseCode;
  }
  
  public String getRequestTimestamp() {
    return this.requestTimestamp;
  }
  
  public void setRequestTimestamp(String requestTimestamp) {
    this.requestTimestamp = requestTimestamp;
  }
  
  public String getApplicationOwner() {
    return this.applicationOwner;
  }
  
  public void setApplicationOwner(String applicationOwner) {
    this.applicationOwner = applicationOwner;
  }
  
  public String getUserAgent() {
    return this.userAgent;
  }
  
  public void setUserAgent(String userAgent) {
    this.userAgent = userAgent;
  }
  
  public String getEventType() {
    return this.eventType;
  }
  
  public void setEventType(String eventType) {
    this.eventType = eventType;
  }
  
  public String getApiResourceTemplate() {
    return this.apiResourceTemplate;
  }
  
  public void setApiResourceTemplate(String apiResourceTemplate) {
    this.apiResourceTemplate = apiResourceTemplate;
  }
  
  public int getResponseLatency() {
    return this.responseLatency;
  }
  
  public void setResponseLatency(int responseLatency) {
    this.responseLatency = responseLatency;
  }
  
  public String getRegionId() {
    return this.regionId;
  }
  
  public void setRegionId(String regionId) {
    this.regionId = regionId;
  }
  
  public int getResponseMediationLatency() {
    return this.responseMediationLatency;
  }
  
  public void setResponseMediationLatency(int responseMediationLatency) {
    this.responseMediationLatency = responseMediationLatency;
  }
  
  public String getUserIp() {
    return this.userIp;
  }
  
  public void setUserIp(String userIp) {
    this.userIp = userIp;
  }
  
  public String getApplicationId() {
    return this.applicationId;
  }
  
  public void setApplicationId(String applicationId) {
    this.applicationId = applicationId;
  }
  
  public String getApiType() {
    return this.apiType;
  }
  
  public void setApiType(String apiType) {
    this.apiType = apiType;
  }
  
  public String getErrorType() {
    return this.errorType;
  }
  
  public void setErrorType(String errorType) {
    this.errorType = errorType;
  }
  
  public String getErrorMessage() {
    return this.errorMessage;
  }
  
  public void setErrorMessage(String errorMessage) {
    this.errorMessage = errorMessage;
  }
  
  public String toString() {
    return "MetricData [apiName=" + this.apiName + ", proxyResponseCode=" + this.proxyResponseCode + ", destination=" + this.destination + ", apiCreatorTenantDomain=" + this.apiCreatorTenantDomain + ", platform=" + this.platform + ", apiMethod=" + this.apiMethod + ", apiVersion=" + this.apiVersion + ", gatewayType=" + this.gatewayType + ", apiCreator=" + this.apiCreator + ", responseCacheHit=" + this.responseCacheHit + ", backendLatency=" + this.backendLatency + ", correlationId=" + this.correlationId + ", requestMediationLatency=" + this.requestMediationLatency + ", keyType=" + this.keyType + ", apiId=" + this.apiId + ", applicationName=" + this.applicationName + ", targetResponseCode=" + this.targetResponseCode + ", requestTimestamp=" + this.requestTimestamp + ", applicationOwner=" + this.applicationOwner + ", userAgent=" + this.userAgent + ", eventType=" + this.eventType + ", apiResourceTemplate=" + this.apiResourceTemplate + ", responseLatency=" + this.responseLatency + ", regionId=" + this.regionId + ", responseMediationLatency=" + this.responseMediationLatency + ", userIp=" + this.userIp + ", applicationId=" + this.applicationId + ", apiType=" + this.apiType + "]";
  }
}

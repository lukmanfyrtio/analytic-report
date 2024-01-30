package org.wso2.am.analytics.publisher.sample.reporter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.wso2.am.analytics.publisher.exception.MetricReportingException;
import org.wso2.am.analytics.publisher.reporter.CounterMetric;
import org.wso2.am.analytics.publisher.reporter.MetricEventBuilder;
import org.wso2.am.analytics.publisher.reporter.MetricSchema;
import org.wso2.am.analytics.publisher.reporter.cloud.DefaultFaultMetricEventBuilder;
import org.wso2.am.analytics.publisher.reporter.cloud.DefaultResponseMetricEventBuilder;

public class LogCounterMetric implements CounterMetric {
  private static final Logger log = LoggerFactory.getLogger(LogCounterMetric.class);
  
  private String name;
  
  private MetricSchema schema;
  
  private final Gson gson;
  
  private CustomDataUsageDAO customDataUsageDAO = CustomDataUsageDAO.getInstance();
  
  public LogCounterMetric(String name, MetricSchema schema) {
    this.name = name;
    this.schema = schema;
    this.gson = new Gson();
  }
  
  public int incrementCount(MetricEventBuilder metricEventBuilder) throws MetricReportingException {
    Map<String, Object> event = metricEventBuilder.build();
    String jsonString = this.gson.toJson(event);
    log.info("apimMetrics: " + this.name.replaceAll("[\r\n]", "") + ", properties :" + jsonString
        .replaceAll("[\r\n]", ""));
    ObjectMapper objectMapper = new ObjectMapper();
    try {
      MetricData metricData = new MetricData();
      metricData.setApiName((String)event.getOrDefault("apiName", ""));
      metricData
        .setProxyResponseCode(Integer.valueOf(String.valueOf(event.getOrDefault("proxyResponseCode", Integer.valueOf(0)))).intValue());
      metricData.setDestination((String)event.getOrDefault("destination", ""));
      metricData.setApiCreatorTenantDomain((String)event.getOrDefault("apiCreatorTenantDomain", ""));
      metricData.setPlatform((String)event.getOrDefault("platform", ""));
      metricData.setApiMethod((String)event.getOrDefault("apiMethod", ""));
      metricData.setApiVersion((String)event.getOrDefault("apiVersion", ""));
      metricData.setGatewayType((String)event.getOrDefault("gatewayType", ""));
      metricData.setApiCreator((String)event.getOrDefault("apiCreator", ""));
      metricData.setResponseCacheHit(((Boolean)event.getOrDefault("responseCacheHit", Boolean.valueOf(false))).booleanValue());
      metricData.setBackendLatency(Integer.valueOf(String.valueOf(event.getOrDefault("backendLatency", Integer.valueOf(0)))).intValue());
      metricData.setCorrelationId((String)event.getOrDefault("correlationId", ""));
      metricData.setRequestMediationLatency(
          Integer.valueOf(String.valueOf(event.getOrDefault("requestMediationLatency", Integer.valueOf(0)))).intValue());
      metricData.setKeyType((String)event.getOrDefault("keyType", ""));
      metricData.setApiId((String)event.getOrDefault("apiId", ""));
      metricData.setApplicationName((String)event.getOrDefault("applicationName", ""));
      metricData.setTargetResponseCode(
          Integer.valueOf(String.valueOf(event.getOrDefault("targetResponseCode", Integer.valueOf(0)))).intValue());
      metricData.setRequestTimestamp((String)event.getOrDefault("requestTimestamp", ""));
      metricData.setApplicationOwner((String)event.getOrDefault("applicationOwner", ""));
      metricData.setUserAgent((String)event.getOrDefault("userAgent", ""));
      metricData.setEventType((String)event.getOrDefault("eventType", ""));
      metricData.setApiResourceTemplate((String)event.getOrDefault("apiResourceTemplate", ""));
      metricData.setResponseLatency(Integer.valueOf(String.valueOf(event.getOrDefault("responseLatency", Integer.valueOf(0)))).intValue());
      metricData.setRegionId((String)event.getOrDefault("regionId", ""));
      metricData.setResponseMediationLatency(
          Integer.valueOf(String.valueOf(event.getOrDefault("responseMediationLatency", Integer.valueOf(0)))).intValue());
      metricData.setUserIp((String)event.getOrDefault("userIp", ""));
      metricData.setApplicationId((String)event.getOrDefault("applicationId", ""));
      metricData.setApiType((String)event.getOrDefault("apiType", ""));
      metricData.setErrorType((String)event.getOrDefault("errorType", ""));
      metricData.setErrorMessage((String)event.getOrDefault("errorMessage", ""));
      metricData.setErrorCode((String)event.getOrDefault("errorCode", ""));
      log.debug("application name ------- " + metricData.getApplicationName());
      log.debug("application id ------- " + metricData.getApplicationId());
      log.debug("application owner ------- " + metricData.getApplicationOwner());
      log.debug("destination ------- " + metricData.getDestination());
      log.debug("API method ------- " + metricData.getApiMethod());
      log.debug("API version ------- " + metricData.getApiVersion());
      log.debug("user IP ------- " + metricData.getUserIp());
      log.debug("Insert data to databases");
      this.customDataUsageDAO.addApiUsage(metricData);
    } catch (Exception e) {
      log.debug("Error when adding api usage to db : " + e.getMessage());
      e.printStackTrace();
    } 
    return 0;
  }
  
  public String getName() {
    return this.name;
  }
  
  public MetricSchema getSchema() {
    return this.schema;
  }
  
  public MetricEventBuilder getEventBuilder() {
    switch (this.schema) {
      case RESPONSE:
        return (MetricEventBuilder)new DefaultResponseMetricEventBuilder();
      case ERROR:
        return (MetricEventBuilder)new DefaultFaultMetricEventBuilder();
    } 
    return null;
  }
}

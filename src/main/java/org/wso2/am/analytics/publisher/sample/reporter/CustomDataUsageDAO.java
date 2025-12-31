package org.wso2.am.analytics.publisher.sample.reporter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.wso2.carbon.apimgt.impl.utils.APIMgtDBUtil;

public class CustomDataUsageDAO {
  private static final Logger log = LoggerFactory.getLogger(CustomDataUsageDAO.class);
  
  private static CustomDataUsageDAO INSTANCE = null;
  
  public static final String GET_BE_PLAN_BY_SUBSCRIBED_ID_SQL = "SELECT ASN.SUBSCRIPTION_ID, ASN.UUID, APS.MONETIZATION_PLAN, APS.BILLING_CYCLE, APS.FIXED_RATE, APS.PRICE_PER_REQUEST, APS.CURRENCY, APS.BILLING_PLAN FROM WSO2AM_DB.AM_POLICY_SUBSCRIPTION APS JOIN AM_SUBSCRIPTION ASN ON ASN.TIER_ID = APS.NAME JOIN AM_API AA ON AA.API_ID = ASN.API_ID JOIN AM_APPLICATION APP ON APP.APPLICATION_ID = ASN.APPLICATION_ID WHERE AA.API_UUID = ? AND APP.UUID = ?";
  
  public static CustomDataUsageDAO getInstance() {
    if (INSTANCE == null)
      INSTANCE = new CustomDataUsageDAO(); 
    return INSTANCE;
  }
  
  public void addApiUsage(MetricData metricData) throws Exception {
    Connection conn = null;
    conn = APIMgtDBUtil.getConnection();
    conn.setAutoCommit(false);
    try {
      PlanData planData = getPlanDataBySubscriberId(metricData.getApiId(), metricData.getApplicationId());
        String insertQuery = "INSERT INTO DATA_USAGE_API (API_NAME, PROXY_RESPONSE_CODE, DESTINATION, API_CREATOR_TENANT_DOMAIN, PLATFORM, API_METHOD, API_VERSION, GATEWAY_TYPE, API_CREATOR, RESPONSE_CACHE_HIT, BACKEND_LATENCY, CORRELATION_ID, REQUEST_MEDIATION_LATENCY, KEY_TYPE, API_ID, APPLICATION_NAME, TARGET_RESPONSE_CODE, REQUEST_TIMESTAMP, APPLICATION_OWNER, USER_AGENT, EVENT_TYPE, API_RESOURCE_TEMPLATE, RESPONSE_LATENCY, REGION_ID, RESPONSE_MEDIATION_LATENCY, USER_IP, APPLICATION_ID, API_TYPE,SUBSCRIPTION_ID,SUBSCRIPTION_UUID) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement insertStmt = conn.prepareStatement(insertQuery);
        insertStmt.setString(1, metricData.getApiName());
        insertStmt.setInt(2, metricData.getProxyResponseCode());
        insertStmt.setString(3, metricData.getDestination());
        insertStmt.setString(4, metricData.getApiCreatorTenantDomain());
        insertStmt.setString(5, metricData.getPlatform());
        insertStmt.setString(6, metricData.getApiMethod());
        insertStmt.setString(7, metricData.getApiVersion());
        insertStmt.setString(8, metricData.getGatewayType());
        insertStmt.setString(9, metricData.getApiCreator());
        insertStmt.setBoolean(10, metricData.isResponseCacheHit());
        insertStmt.setInt(11, metricData.getBackendLatency());
        insertStmt.setString(12, metricData.getCorrelationId());
        insertStmt.setInt(13, metricData.getRequestMediationLatency());
        insertStmt.setString(14, metricData.getKeyType());
        insertStmt.setString(15, metricData.getApiId());
        insertStmt.setString(16, metricData.getApplicationName());
        insertStmt.setInt(17, metricData.getTargetResponseCode());
        Instant instant = Instant.parse(metricData.getRequestTimestamp());

		// WIB zone
		ZoneId wibZone = ZoneId.of("Asia/Jakarta");

		// Konversi ke LocalDateTime WIB
		LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, wibZone);

		// Konversi ke Timestamp (WIB)
		Timestamp wibTimestamp = Timestamp.valueOf(localDateTime);

		// Save ke DB
		insertStmt.setTimestamp(18, wibTimestamp);

        insertStmt.setString(19, metricData.getApplicationOwner());
        insertStmt.setString(20, metricData.getUserAgent());
        insertStmt.setString(21, metricData.getEventType());
        insertStmt.setString(22, metricData.getApiResourceTemplate());
        insertStmt.setInt(23, metricData.getResponseLatency());
        insertStmt.setString(24, metricData.getRegionId());
        insertStmt.setInt(25, metricData.getResponseMediationLatency());
        insertStmt.setString(26, metricData.getUserIp());
        insertStmt.setString(27, metricData.getApplicationId());
        insertStmt.setString(28, metricData.getApiType());
        insertStmt.setString(29, planData.getSubscriptionId());
        insertStmt.setString(30, planData.getSubscriptionIdUuid());
        insertStmt.executeUpdate();
        conn.commit();
        insertStmt.close();
        log.debug("API Data Usage inserted successfully.");
    } catch (SQLException e) {
      if (conn != null)
        try {
          conn.rollback();
        } catch (SQLException ex) {
          String str = "Failed to rollback adding data usage for : " + metricData.getApplicationName();
          log.error(str);
          throw new CustomDataUsageException(str, ex);
        }  
      String errorMessage = "Failed to add data usage for : " + metricData.getApplicationName();
      log.error(errorMessage);
      throw new CustomDataUsageException(errorMessage, e);
    } finally {
      conn.close();
    } 
  }
  
  public PlanData getPlanDataBySubscriberId(String string, String string2) throws Exception {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet result = null;
    PlanData monetizedSubscription = new PlanData();
    String sqlQuery = "SELECT ASN.SUBSCRIPTION_ID, ASN.UUID, APS.MONETIZATION_PLAN, APS.BILLING_CYCLE, APS.FIXED_RATE, APS.PRICE_PER_REQUEST, APS.CURRENCY, APS.BILLING_PLAN FROM WSO2AM_DB.AM_POLICY_SUBSCRIPTION APS JOIN AM_SUBSCRIPTION ASN ON ASN.TIER_ID = APS.NAME JOIN AM_API AA ON AA.API_ID = ASN.API_ID JOIN AM_APPLICATION APP ON APP.APPLICATION_ID = ASN.APPLICATION_ID WHERE AA.API_UUID = ? AND APP.UUID = ?";
    try {
      conn = APIMgtDBUtil.getConnection();
      ps = conn.prepareStatement(sqlQuery);
      ps.setString(1, string);
      ps.setString(2, string2);
      result = ps.executeQuery();
      log.debug(ps.toString());
      log.debug("Parameter API ID : " + string);
      log.debug("Parameter APP ID : " + string2);
      if (result.next()) {
        monetizedSubscription.setSubscriptionId(result.getString("SUBSCRIPTION_ID"));
        monetizedSubscription.setMonetizationPlan(result.getString("MONETIZATION_PLAN"));
        monetizedSubscription.setBillingCycle(result.getString("BILLING_CYCLE"));
        monetizedSubscription.setCurrency(result.getString("CURRENCY"));
        monetizedSubscription.setFixedRate(result.getString("FIXED_RATE"));
        monetizedSubscription.setPricePerRequest(result.getString("PRICE_PER_REQUEST"));
        monetizedSubscription.setSubscriptionIdUuid(result.getString("UUID"));
        monetizedSubscription.setBillingPlan(result.getString("BILLING_PLAN"));
      } 
    } catch (SQLException e) {
      String errorMessage = "Failed to get billing engine Subscription info for API ID : " + string +" details:"+e.getMessage();
      log.error(errorMessage);
      throw new Exception(errorMessage, e);
    } finally {
      APIMgtDBUtil.closeAllConnections(ps, conn, result);
    } 
    return monetizedSubscription;
  }
}

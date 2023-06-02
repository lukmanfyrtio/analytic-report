package org.wso2.am.analytics.publisher.sample.reporter;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.wso2.am.analytics.publisher.exception.MetricReportingException;
import org.wso2.am.analytics.publisher.reporter.CounterMetric;
import org.wso2.am.analytics.publisher.reporter.MetricEventBuilder;
import org.wso2.am.analytics.publisher.reporter.MetricSchema;
import org.wso2.am.analytics.publisher.reporter.cloud.DefaultFaultMetricEventBuilder;
import org.wso2.am.analytics.publisher.reporter.cloud.DefaultResponseMetricEventBuilder;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

public class LogCounterMetric implements CounterMetric {

	private static final Logger log = LoggerFactory.getLogger(LogCounterMetric.class);
	private String name;
	private MetricSchema schema;
	private final Gson gson;
	private CustomDataUsageDAO customDataUsageDAO=CustomDataUsageDAO.getInstance();

	public LogCounterMetric(String name, MetricSchema schema) {
		this.name = name;
		this.schema = schema;
		this.gson = new Gson();
	}

	@Override
	public int incrementCount(MetricEventBuilder metricEventBuilder) throws MetricReportingException {
		Map<String, Object> event = metricEventBuilder.build();
		String jsonString = gson.toJson(event);
		log.info("apimMetrics: " + name.replaceAll("[\r\n]", "") + ", properties :"
				+ jsonString.replaceAll("[\r\n]", ""));

		ObjectMapper objectMapper = new ObjectMapper();

		try {
			MetricData apiResponse = objectMapper.readValue(jsonString, MetricData.class);
			log.info("application name ------- "+apiResponse.getApplicationName());
			log.info("application id ------- "+apiResponse.getApplicationId());
			log.info("application owner ------- "+apiResponse.getApplicationOwner());
			log.info("destination ------- "+apiResponse.getDestination());
			log.info("API method ------- "+apiResponse.getApiMethod());
			log.info("API version ------- "+apiResponse.getApiVersion());
			log.info("user IP ------- "+apiResponse.getUserIp());
			customDataUsageDAO.addApiUsage(apiResponse);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public MetricSchema getSchema() {
		return this.schema;
	}

	@Override
	public MetricEventBuilder getEventBuilder() {
		switch (schema) {
		case RESPONSE:
			return new DefaultResponseMetricEventBuilder();
		case ERROR:
			return new DefaultFaultMetricEventBuilder();
		default:
			// will not happen
			return null;
		}
	}
}

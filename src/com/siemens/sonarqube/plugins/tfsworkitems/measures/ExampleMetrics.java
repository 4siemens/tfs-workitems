package com.siemens.sonarqube.plugins.tfsworkitems.measures;

import org.sonar.api.measures.CoreMetrics;
import org.sonar.api.measures.Metric;
import org.sonar.api.measures.Metrics;

import java.util.List;

import static java.util.Arrays.asList;

@SuppressWarnings("WeakerAccess")
public class ExampleMetrics implements Metrics {

  public static final Metric<Integer> FILENAME_SIZE = new Metric.Builder("filename_size", "Filename Size", Metric.ValueType.INT)
    .setDescription("Number of characters of file names")
    .setDirection(Metric.DIRECTION_BETTER)
    .setQualitative(false)
    .setDomain(CoreMetrics.DOMAIN_GENERAL)
    .create();

  public static final Metric<Integer> FILENAME_SIZE_RATING = new Metric.Builder("filename_size_rating", "Filename Size Rating", Metric.ValueType.RATING)
    .setDescription("Rating based on size of file names")
    .setDirection(Metric.DIRECTION_BETTER)
    .setQualitative(true)
    .setDomain(CoreMetrics.DOMAIN_GENERAL)
    .create();

  public List<Metric> getMetrics() {
    //return asList(FILENAME_SIZE, FILENAME_SIZE_RATING);
    return null;
  }
}

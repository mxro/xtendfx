package xtendfx.util;

import javafx.util.Duration;

@SuppressWarnings("all")
public class DurationExtensions {
  public static Duration millis(final double d) {
    return Duration.millis(d);
  }
  
  public static Duration seconds(final double d) {
    return Duration.seconds(d);
  }
  
  public static Duration minutes(final double d) {
    return Duration.minutes(d);
  }
  
  public static Duration hours(final double d) {
    return Duration.hours(d);
  }
  
  public static Duration operator_multiply(final Duration d, final double times) {
    return d.multiply(times);
  }
  
  public static Duration operator_divide(final Duration d, final double times) {
    return d.divide(times);
  }
  
  public static Duration operator_plus(final Duration d, final Duration other) {
    return d.add(other);
  }
  
  public static Duration operator_minus(final Duration d, final Duration other) {
    return d.subtract(other);
  }
  
  public static Duration operator_not(final Duration d) {
    return d.negate();
  }
}

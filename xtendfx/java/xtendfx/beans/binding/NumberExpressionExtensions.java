package xtendfx.beans.binding;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanBinding;
import javafx.beans.binding.DoubleBinding;
import javafx.beans.binding.NumberExpression;
import javafx.beans.binding.NumberExpressionBase;
import javafx.beans.value.ObservableNumberValue;
import org.eclipse.xtext.xbase.lib.Pure;
import xtendfx.beans.binding.DoubleConstant;

/**
 * Extension methods for {@link NumberExpression}s.
 * Allow to use operators instead of fluent API.
 * 
 * @author koehnlein
 */
@SuppressWarnings("all")
public class NumberExpressionExtensions {
  private static double EPSILON = 1e-9;
  
  @Pure
  public static BooleanBinding operator_lessThan(final NumberExpressionBase a, final ObservableNumberValue b) {
    return a.lessThan(b);
  }
  
  @Pure
  public static BooleanBinding operator_lessEqualsThan(final NumberExpressionBase a, final ObservableNumberValue b) {
    return a.lessThanOrEqualTo(b);
  }
  
  @Pure
  public static BooleanBinding operator_greaterThan(final NumberExpressionBase a, final ObservableNumberValue b) {
    return a.greaterThan(b);
  }
  
  @Pure
  public static BooleanBinding operator_greaterEqualsThan(final NumberExpressionBase a, final ObservableNumberValue b) {
    return a.greaterThanOrEqualTo(b);
  }
  
  @Pure
  public static BooleanBinding operator_equals(final NumberExpressionBase a, final ObservableNumberValue b) {
    return a.isEqualTo(b);
  }
  
  @Pure
  public static BooleanBinding operator_notEquals(final NumberExpressionBase a, final ObservableNumberValue b) {
    return a.isNotEqualTo(b);
  }
  
  @Pure
  public static BooleanBinding operator_lessThan(final double a, final NumberExpressionBase b) {
    DoubleConstant _doubleConstant = new DoubleConstant(a);
    return _doubleConstant.lessThan(b);
  }
  
  @Pure
  public static BooleanBinding operator_lessEqualsThan(final double a, final NumberExpressionBase b) {
    DoubleConstant _doubleConstant = new DoubleConstant(a);
    return _doubleConstant.lessThanOrEqualTo(b);
  }
  
  @Pure
  public static BooleanBinding operator_greaterThan(final double a, final NumberExpressionBase b) {
    DoubleConstant _doubleConstant = new DoubleConstant(a);
    return _doubleConstant.greaterThan(b);
  }
  
  @Pure
  public static BooleanBinding operator_greaterEqualsThan(final double a, final NumberExpressionBase b) {
    DoubleConstant _doubleConstant = new DoubleConstant(a);
    return _doubleConstant.greaterThanOrEqualTo(b);
  }
  
  @Pure
  public static BooleanBinding operator_equals(final double a, final NumberExpressionBase b) {
    DoubleConstant _doubleConstant = new DoubleConstant(a);
    return _doubleConstant.isEqualTo(b);
  }
  
  @Pure
  public static BooleanBinding operator_notEquals(final double a, final NumberExpressionBase b) {
    DoubleConstant _doubleConstant = new DoubleConstant(a);
    return _doubleConstant.isNotEqualTo(b);
  }
  
  @Pure
  public static BooleanBinding operator_lessThan(final NumberExpressionBase a, final double b) {
    return a.lessThan(b);
  }
  
  @Pure
  public static BooleanBinding operator_lessEqualsThan(final NumberExpressionBase a, final double b) {
    return a.lessThanOrEqualTo(b);
  }
  
  @Pure
  public static BooleanBinding operator_greaterThan(final NumberExpressionBase a, final double b) {
    return a.greaterThan(b);
  }
  
  @Pure
  public static BooleanBinding operator_greaterEqualsThan(final NumberExpressionBase a, final double b) {
    return a.greaterThanOrEqualTo(b);
  }
  
  @Pure
  public static BooleanBinding operator_equals(final NumberExpressionBase a, final double b) {
    return a.isEqualTo(b, NumberExpressionExtensions.EPSILON);
  }
  
  @Pure
  public static BooleanBinding operator_notEquals(final NumberExpressionBase a, final double b) {
    return a.isNotEqualTo(b, NumberExpressionExtensions.EPSILON);
  }
  
  @Pure
  public static DoubleBinding operator_multiply(final NumberExpression left, final double right) {
    return Bindings.multiply(left, right);
  }
}

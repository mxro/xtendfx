package xtendfx.beans.binding;

import javafx.beans.binding.FloatBinding;
import javafx.beans.binding.FloatExpression;
import javafx.beans.binding.NumberBinding;
import javafx.beans.value.ObservableNumberValue;
import org.eclipse.xtext.xbase.lib.Pure;
import xtendfx.beans.binding.FloatConstant;

/**
 * Extension methods for {@link FloatExpression}s.
 * Allow to use operators instead of fluent API.
 * 
 * @author koehnlein
 */
@SuppressWarnings("all")
public class FloatExpressionExtensions {
  @Pure
  public static NumberBinding operator_plus(final FloatExpression a, final ObservableNumberValue b) {
    return a.add(b);
  }
  
  @Pure
  public static FloatBinding operator_minus(final FloatExpression a) {
    return a.negate();
  }
  
  @Pure
  public static NumberBinding operator_minus(final FloatExpression a, final ObservableNumberValue b) {
    return a.subtract(b);
  }
  
  @Pure
  public static NumberBinding operator_multiply(final FloatExpression a, final ObservableNumberValue b) {
    return a.multiply(b);
  }
  
  @Pure
  public static NumberBinding operator_divide(final FloatExpression a, final ObservableNumberValue b) {
    return a.divide(b);
  }
  
  @Pure
  public static NumberBinding operator_plus(final float a, final FloatExpression b) {
    FloatConstant _floatConstant = new FloatConstant(a);
    return _floatConstant.add(b);
  }
  
  @Pure
  public static NumberBinding operator_minus(final float a, final FloatExpression b) {
    FloatConstant _floatConstant = new FloatConstant(a);
    return _floatConstant.subtract(b);
  }
  
  @Pure
  public static NumberBinding operator_multiply(final float a, final FloatExpression b) {
    FloatConstant _floatConstant = new FloatConstant(a);
    return _floatConstant.multiply(b);
  }
  
  @Pure
  public static NumberBinding operator_divide(final float a, final FloatExpression b) {
    FloatConstant _floatConstant = new FloatConstant(a);
    return _floatConstant.divide(b);
  }
  
  @Pure
  public static FloatBinding operator_plus(final FloatExpression a, final float b) {
    return a.add(b);
  }
  
  @Pure
  public static FloatBinding operator_minus(final FloatExpression a, final float b) {
    return a.subtract(b);
  }
  
  @Pure
  public static FloatBinding operator_multiply(final FloatExpression a, final float b) {
    return a.multiply(b);
  }
  
  @Pure
  public static FloatBinding operator_divide(final FloatExpression a, final float b) {
    return a.divide(b);
  }
}

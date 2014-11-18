package xtendfx.beans.binding;

import javafx.beans.binding.IntegerBinding;
import javafx.beans.binding.IntegerExpression;
import javafx.beans.binding.NumberBinding;
import javafx.beans.value.ObservableNumberValue;
import org.eclipse.xtext.xbase.lib.Pure;
import xtendfx.beans.binding.IntegerConstant;

/**
 * Extension methods for {@link IntegerExpression}s.
 * Allow to use operators instead of fluent API.
 * 
 * @author koehnlein
 */
@SuppressWarnings("all")
public class IntegerExpressionExtensions {
  @Pure
  public static NumberBinding operator_plus(final IntegerExpression a, final ObservableNumberValue b) {
    return a.add(b);
  }
  
  @Pure
  public static IntegerBinding operator_minus(final IntegerExpression a) {
    return a.negate();
  }
  
  @Pure
  public static NumberBinding operator_minus(final IntegerExpression a, final ObservableNumberValue b) {
    return a.subtract(b);
  }
  
  @Pure
  public static NumberBinding operator_multiply(final IntegerExpression a, final ObservableNumberValue b) {
    return a.multiply(b);
  }
  
  @Pure
  public static NumberBinding operator_divide(final IntegerExpression a, final ObservableNumberValue b) {
    return a.divide(b);
  }
  
  @Pure
  public static NumberBinding operator_plus(final int a, final IntegerExpression b) {
    IntegerConstant _integerConstant = new IntegerConstant(a);
    return _integerConstant.add(b);
  }
  
  @Pure
  public static NumberBinding operator_minus(final int a, final IntegerExpression b) {
    IntegerConstant _integerConstant = new IntegerConstant(a);
    return _integerConstant.subtract(b);
  }
  
  @Pure
  public static NumberBinding operator_multiply(final int a, final IntegerExpression b) {
    IntegerConstant _integerConstant = new IntegerConstant(a);
    return _integerConstant.multiply(b);
  }
  
  @Pure
  public static NumberBinding operator_divide(final int a, final IntegerExpression b) {
    IntegerConstant _integerConstant = new IntegerConstant(a);
    return _integerConstant.divide(b);
  }
  
  @Pure
  public static IntegerBinding operator_plus(final IntegerExpression a, final int b) {
    return a.add(b);
  }
  
  @Pure
  public static IntegerBinding operator_minus(final IntegerExpression a, final int b) {
    return a.subtract(b);
  }
  
  @Pure
  public static IntegerBinding operator_multiply(final IntegerExpression a, final int b) {
    return a.multiply(b);
  }
  
  @Pure
  public static IntegerBinding operator_divide(final IntegerExpression a, final int b) {
    return a.divide(b);
  }
}

package xtendfx.beans.binding;

import javafx.beans.binding.LongBinding;
import javafx.beans.binding.LongExpression;
import javafx.beans.binding.NumberBinding;
import javafx.beans.value.ObservableNumberValue;
import xtendfx.beans.binding.LongConstant;

/**
 * Extension methods for {@link LongExpression}s.
 * Allow to use operators instead of fluent API.
 * 
 * @author koehnlein
 */
@SuppressWarnings("all")
public class LongExpressionExtensions {
  /* @Pure
   */public static NumberBinding operator_plus(final LongExpression a, final ObservableNumberValue b) {
    return a.add(b);
  }
  
  /* @Pure
   */public static LongBinding operator_minus(final LongExpression a) {
    return a.negate();
  }
  
  /* @Pure
   */public static NumberBinding operator_minus(final LongExpression a, final ObservableNumberValue b) {
    return a.subtract(b);
  }
  
  /* @Pure
   */public static NumberBinding operator_multiply(final LongExpression a, final ObservableNumberValue b) {
    return a.multiply(b);
  }
  
  /* @Pure
   */public static NumberBinding operator_divide(final LongExpression a, final ObservableNumberValue b) {
    return a.divide(b);
  }
  
  /* @Pure
   */public static NumberBinding operator_plus(final long a, final LongExpression b) {
    LongConstant _longConstant = new LongConstant(a);
    return _longConstant.add(b);
  }
  
  /* @Pure
   */public static NumberBinding operator_minus(final long a, final LongExpression b) {
    LongConstant _longConstant = new LongConstant(a);
    return _longConstant.subtract(b);
  }
  
  /* @Pure
   */public static NumberBinding operator_multiply(final long a, final LongExpression b) {
    LongConstant _longConstant = new LongConstant(a);
    return _longConstant.multiply(b);
  }
  
  /* @Pure
   */public static NumberBinding operator_divide(final long a, final LongExpression b) {
    LongConstant _longConstant = new LongConstant(a);
    return _longConstant.divide(b);
  }
  
  /* @Pure
   */public static LongBinding operator_plus(final LongExpression a, final long b) {
    return a.add(b);
  }
  
  /* @Pure
   */public static LongBinding operator_minus(final LongExpression a, final long b) {
    return a.subtract(b);
  }
  
  /* @Pure
   */public static LongBinding operator_multiply(final LongExpression a, final long b) {
    return a.multiply(b);
  }
  
  /* @Pure
   */public static LongBinding operator_divide(final LongExpression a, final long b) {
    return a.divide(b);
  }
}

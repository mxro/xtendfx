package xtendfx.beans.binding;

import javafx.beans.binding.BooleanBinding;
import javafx.beans.binding.ObjectExpression;
import javafx.beans.property.Property;
import javafx.beans.value.ObservableObjectValue;
import javafx.beans.value.ObservableValue;

/**
 * Overloaded operators for JavaFX bindings.
 */
@SuppressWarnings("all")
public class BindingExtensions {
  public static <T extends Object> void operator_mappedTo(final Property<T> left, final ObservableValue<? extends T> right) {
    left.bind(right);
  }
  
  public static <T extends Object> void operator_diamond(final Property<T> left, final Property<T> right) {
    left.bindBidirectional(right);
  }
  
  public static BooleanBinding operator_equals(final ObjectExpression<?> left, final Object right) {
    return left.isEqualTo(right);
  }
  
  public static BooleanBinding operator_equals(final ObjectExpression<?> left, final ObservableObjectValue<?> right) {
    return left.isEqualTo(right);
  }
  
  public static BooleanBinding operator_notEquals(final ObjectExpression<?> left, final Object right) {
    return left.isNotEqualTo(right);
  }
  
  public static BooleanBinding operator_notEquals(final ObjectExpression<?> left, final ObservableObjectValue<?> right) {
    return left.isNotEqualTo(right);
  }
}

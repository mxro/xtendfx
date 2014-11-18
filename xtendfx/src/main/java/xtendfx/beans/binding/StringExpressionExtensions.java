package xtendfx.beans.binding;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.StringExpression;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

@SuppressWarnings("all")
public class StringExpressionExtensions {
  public static StringProperty asProperty(final String someString) {
    return new SimpleStringProperty(someString);
  }
  
  public static StringExpression operator_plus(final StringExpression left, final Object right) {
    return Bindings.concat(left, right);
  }
  
  public static StringExpression operator_plus(final StringExpression left, final String right) {
    return Bindings.concat(left, right);
  }
}

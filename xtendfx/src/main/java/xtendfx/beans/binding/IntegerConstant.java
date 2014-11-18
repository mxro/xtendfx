package xtendfx.beans.binding;

import javafx.beans.binding.IntegerBinding;

@SuppressWarnings("all")
public class IntegerConstant extends IntegerBinding {
  private int value;
  
  public IntegerConstant(final int value) {
    this.value = value;
  }
  
  protected int computeValue() {
    return this.value;
  }
}

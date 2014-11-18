package xtendfx.beans.binding;

import javafx.beans.binding.LongBinding;

@SuppressWarnings("all")
public class LongConstant extends LongBinding {
  private long value;
  
  public LongConstant(final long value) {
    this.value = value;
  }
  
  protected long computeValue() {
    return this.value;
  }
}

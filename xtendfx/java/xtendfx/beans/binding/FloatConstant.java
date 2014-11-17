package xtendfx.beans.binding;

import javafx.beans.binding.FloatBinding;

@SuppressWarnings("all")
public class FloatConstant extends FloatBinding {
  private float value;
  
  public FloatConstant(final float value) {
    this.value = value;
  }
  
  protected float computeValue() {
    return this.value;
  }
}

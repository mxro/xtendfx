package xtendfx.beans.binding;

@SuppressWarnings("all")
public class FloatConstant /* implements FloatBinding  */{
  private float value;
  
  public FloatConstant(final float value) {
    this.value = value;
  }
  
  protected float computeValue() {
    return this.value;
  }
}

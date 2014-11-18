package xtendfx.beans.binding;

@SuppressWarnings("all")
public class DoubleConstant /* implements DoubleBinding  */{
  private double value;
  
  public DoubleConstant(final double value) {
    this.value = value;
  }
  
  protected double computeValue() {
    return this.value;
  }
}

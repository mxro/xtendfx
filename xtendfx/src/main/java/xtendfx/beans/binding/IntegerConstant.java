package xtendfx.beans.binding;

@SuppressWarnings("all")
public class IntegerConstant /* implements IntegerBinding  */{
  private int value;
  
  public IntegerConstant(final int value) {
    this.value = value;
  }
  
  protected int computeValue() {
    return this.value;
  }
}

package xtendfx.beans.binding;

@SuppressWarnings("all")
public class LongConstant /* implements LongBinding  */{
  private long value;
  
  public LongConstant(final long value) {
    this.value = value;
  }
  
  protected long computeValue() {
    return this.value;
  }
}

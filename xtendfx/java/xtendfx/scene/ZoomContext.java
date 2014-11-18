package xtendfx.scene;

import javafx.geometry.Point2D;
import org.eclipse.xtend.lib.Property;
import org.eclipse.xtext.xbase.lib.Pure;

@SuppressWarnings("all")
public class ZoomContext {
  @Property
  private double _previousScale = 1;
  
  @Property
  private Point2D _pivotInpane;
  
  public ZoomContext(final Point2D pivotInpane) {
    this.setPivotInpane(pivotInpane);
  }
  
  @Pure
  public double getPreviousScale() {
    return this._previousScale;
  }
  
  public void setPreviousScale(final double previousScale) {
    this._previousScale = previousScale;
  }
  
  @Pure
  public Point2D getPivotInpane() {
    return this._pivotInpane;
  }
  
  public void setPivotInpane(final Point2D pivotInpane) {
    this._pivotInpane = pivotInpane;
  }
}

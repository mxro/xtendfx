package xtendfx.scene;

import javafx.geometry.Point2D;

@SuppressWarnings("all")
public class ZoomContext {
  /* @Property
   */private double previousScale = 1;
  
  /* @Property
   */private Point2D pivotInpane;
  
  public ZoomContext(final Point2D pivotInpane) {
    this.pivotInpane = pivotInpane;
  }
}

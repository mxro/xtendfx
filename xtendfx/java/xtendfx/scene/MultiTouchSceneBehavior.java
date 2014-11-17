package xtendfx.scene;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.RotateEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.input.ZoomEvent;
import javafx.scene.transform.Affine;
import xtendfx.scene.ZoomContext;

/**
 * Adds the corresponding effects for the following multi-touch gestures to a scene.
 * <ul>
 * <li>scrolling
 * <li>zooming to a certain position
 * <li>rotating
 * </ul>
 */
@SuppressWarnings("all")
public class MultiTouchSceneBehavior {
  private Scene scene;
  
  private ZoomContext zoomContext;
  
  private Affine paneTransform;
  
  private EventHandler<ZoomEvent> zoomStartHandler;
  
  private EventHandler<ZoomEvent> zoomHandler;
  
  private EventHandler<ScrollEvent> scrollHandler;
  
  private EventHandler<RotateEvent> rotateHandler;
  
  public MultiTouchSceneBehavior(final Scene scene) {
    throw new Error("Unresolved compilation problems:"
      + "\n+= cannot be resolved."
      + "\n/ cannot be resolved."
      + "\n- cannot be resolved."
      + "\n- cannot be resolved."
      + "\nThe field previousScale is not visible"
      + "\nThe field pivotInpane is not visible"
      + "\nThe field previousScale is not visible");
  }
}

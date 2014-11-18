package xtendfx.scene;

import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.RotateEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.input.ZoomEvent;
import javafx.scene.transform.Affine;
import javafx.scene.transform.Transform;
import xtendfx.scene.ZoomContext;
import xtendfx.scene.transform.TransformExtensions;

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
    this.scene = scene;
    final Parent root = scene.getRoot();
    Affine _affine = new Affine();
    this.paneTransform = _affine;
    ObservableList<Transform> _transforms = root.getTransforms();
    _transforms.clear();
    ObservableList<Transform> _transforms_1 = root.getTransforms();
    _transforms_1.add(this.paneTransform);
    final EventHandler<ZoomEvent> _function = new EventHandler<ZoomEvent>() {
      public void handle(final ZoomEvent it) {
        double _sceneX = it.getSceneX();
        double _sceneY = it.getSceneY();
        Point2D _sceneToLocal = root.sceneToLocal(_sceneX, _sceneY);
        ZoomContext _zoomContext = new ZoomContext(_sceneToLocal);
        MultiTouchSceneBehavior.this.zoomContext = _zoomContext;
      }
    };
    this.zoomStartHandler = _function;
    final EventHandler<ZoomEvent> _function_1 = new EventHandler<ZoomEvent>() {
      public void handle(final ZoomEvent it) {
        double _totalZoomFactor = it.getTotalZoomFactor();
        double _previousScale = MultiTouchSceneBehavior.this.zoomContext.getPreviousScale();
        final double scale = (_totalZoomFactor / _previousScale);
        TransformExtensions.scale(MultiTouchSceneBehavior.this.paneTransform, scale, scale);
        Point2D _pivotInpane = MultiTouchSceneBehavior.this.zoomContext.getPivotInpane();
        final Point2D pivotInScene = root.localToScene(_pivotInpane);
        double _sceneX = it.getSceneX();
        double _x = pivotInScene.getX();
        double _minus = (_sceneX - _x);
        double _sceneY = it.getSceneY();
        double _y = pivotInScene.getY();
        double _minus_1 = (_sceneY - _y);
        TransformExtensions.translate(MultiTouchSceneBehavior.this.paneTransform, _minus, _minus_1);
        double _totalZoomFactor_1 = it.getTotalZoomFactor();
        MultiTouchSceneBehavior.this.zoomContext.setPreviousScale(_totalZoomFactor_1);
      }
    };
    this.zoomHandler = _function_1;
    final EventHandler<ScrollEvent> _function_2 = new EventHandler<ScrollEvent>() {
      public void handle(final ScrollEvent it) {
        double _deltaX = it.getDeltaX();
        double _deltaY = it.getDeltaY();
        TransformExtensions.translate(MultiTouchSceneBehavior.this.paneTransform, _deltaX, _deltaY);
      }
    };
    this.scrollHandler = _function_2;
    final EventHandler<RotateEvent> _function_3 = new EventHandler<RotateEvent>() {
      public void handle(final RotateEvent it) {
        double _angle = it.getAngle();
        double _sceneX = it.getSceneX();
        double _sceneY = it.getSceneY();
        TransformExtensions.rotate(MultiTouchSceneBehavior.this.paneTransform, _angle, _sceneX, _sceneY);
      }
    };
    this.rotateHandler = _function_3;
    scene.<ZoomEvent>addEventHandler(ZoomEvent.ZOOM_STARTED, this.zoomStartHandler);
    scene.<ZoomEvent>addEventHandler(ZoomEvent.ZOOM, this.zoomHandler);
    scene.<ZoomEvent>addEventHandler(ZoomEvent.ZOOM_FINISHED, this.zoomHandler);
    scene.<ScrollEvent>addEventHandler(ScrollEvent.SCROLL, this.scrollHandler);
    scene.<ScrollEvent>addEventHandler(ScrollEvent.SCROLL_FINISHED, this.scrollHandler);
    scene.<RotateEvent>addEventHandler(RotateEvent.ROTATION_STARTED, this.rotateHandler);
    scene.<RotateEvent>addEventHandler(RotateEvent.ROTATE, this.rotateHandler);
    scene.<RotateEvent>addEventHandler(RotateEvent.ROTATION_FINISHED, this.rotateHandler);
  }
}

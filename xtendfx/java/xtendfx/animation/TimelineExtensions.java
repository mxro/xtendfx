package xtendfx.animation;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.value.WritableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.util.Duration;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class TimelineExtensions {
  public static Timeline Timeline(final Procedure1<? super Timeline> init) {
    Timeline _timeline = new Timeline();
    return ObjectExtensions.<Timeline>operator_doubleArrow(_timeline, init);
  }
  
  public static boolean at(final Timeline timeLine, final Duration time, final EventHandler<ActionEvent> action) {
    ObservableList<KeyFrame> _keyFrames = timeLine.getKeyFrames();
    KeyFrame _keyFrame = new KeyFrame(time, action);
    return _keyFrames.add(_keyFrame);
  }
  
  public static boolean at(final Timeline timeLine, final Duration time, final EventHandler<ActionEvent> action, final KeyValue... keyValues) {
    ObservableList<KeyFrame> _keyFrames = timeLine.getKeyFrames();
    KeyFrame _keyFrame = new KeyFrame(time, action, keyValues);
    return _keyFrames.add(_keyFrame);
  }
  
  public static boolean at(final Timeline timeLine, final Duration time, final KeyValue... keyValues) {
    ObservableList<KeyFrame> _keyFrames = timeLine.getKeyFrames();
    KeyFrame _keyFrame = new KeyFrame(time, keyValues);
    return _keyFrames.add(_keyFrame);
  }
  
  public static <T extends Object> KeyValue operator_spaceship(final WritableValue<T> left, final T right) {
    return new <T>KeyValue(left, right);
  }
}

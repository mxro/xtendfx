package xtendfx.animation;

import javafx.animation.AnimationTimer;
import xtendfx.animation.LongCallback;

@SuppressWarnings("all")
public class DelegatingAnimationTimer extends AnimationTimer {
  private LongCallback callback;
  
  public DelegatingAnimationTimer(final LongCallback callback) {
    this.callback = callback;
  }
  
  public void handle(final long now) {
    this.callback.call(now);
  }
}

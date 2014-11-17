package xtendfx.scene;

import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

@SuppressWarnings("all")
public class SceneBuilder {
  public static Scene Scene(final Stage parent, final /*  */Object init) {
    throw new Error("Unresolved compilation problems:"
      + "\n=> cannot be resolved.");
  }
  
  public static Scene StackedScene(final Stage parent, final /*  */Object init) {
    throw new Error("Unresolved compilation problems:"
      + "\napply cannot be resolved");
  }
  
  public static Button Button(final Pane parent, final /*  */Object init) {
    throw new Error("Unresolved compilation problems:"
      + "\n=> cannot be resolved."
      + "\n+= cannot be resolved.");
  }
  
  public static Label Label(final Pane parent, final /*  */Object init) {
    throw new Error("Unresolved compilation problems:"
      + "\n=> cannot be resolved."
      + "\n+= cannot be resolved.");
  }
  
  public static Scene GridPaneScene(final /*  */Object init) {
    throw new Error("Unresolved compilation problems:"
      + "\napply cannot be resolved");
  }
  
  public static ObservableList<Node> getChildren(final Scene it) {
    ObservableList<Node> _switchResult = null;
    Parent _root = it.getRoot();
    final Parent r = _root;
    boolean _matched = false;
    if (!_matched) {
      if (r instanceof Group) {
        _matched=true;
        _switchResult = ((Group)r).getChildren();
      }
    }
    if (!_matched) {
      if (r instanceof Pane) {
        _matched=true;
        _switchResult = ((Pane)r).getChildren();
      }
    }
    if (!_matched) {
      throw new IllegalStateException("no root set");
    }
    return _switchResult;
  }
}

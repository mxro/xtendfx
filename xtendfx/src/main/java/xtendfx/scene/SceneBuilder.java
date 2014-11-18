package xtendfx.scene;

import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class SceneBuilder {
  public static Scene Scene(final Stage parent, final Procedure1<? super Scene> init) {
    Group _group = new Group();
    Scene _scene = new Scene(_group);
    final Scene scene = ObjectExtensions.<Scene>operator_doubleArrow(_scene, init);
    parent.setScene(scene);
    return scene;
  }
  
  public static Scene StackedScene(final Stage parent, final Procedure1<? super StackPane> init) {
    final StackPane stackPane = new StackPane();
    final Scene result = new Scene(stackPane);
    init.apply(stackPane);
    parent.setScene(result);
    return result;
  }
  
  public static Button Button(final Pane parent, final Procedure1<? super Button> init) {
    Button _button = new Button();
    final Button button = ObjectExtensions.<Button>operator_doubleArrow(_button, init);
    ObservableList<Node> _children = parent.getChildren();
    _children.add(button);
    return button;
  }
  
  public static Label Label(final Pane parent, final Procedure1<? super Label> init) {
    Label _label = new Label();
    final Label label = ObjectExtensions.<Label>operator_doubleArrow(_label, init);
    ObservableList<Node> _children = parent.getChildren();
    _children.add(label);
    return label;
  }
  
  public static Scene GridPaneScene(final Procedure1<? super GridPane> init) {
    final GridPane gridPane = new GridPane();
    final Scene result = new Scene(gridPane);
    init.apply(gridPane);
    return result;
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

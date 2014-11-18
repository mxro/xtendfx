package xtendfx.beans;

import org.eclipse.xtend.lib.macro.Active;
import xtendfx.beans.FxBeanCompilationParticipant;

/**
 * An active annotation which turns simple fields into
 * lazy JavaFX properties as described
 * <a href="http://blog.netopyr.com/2011/05/19/creating-javafx-properties/">here</a>.
 * 
 * That is it
 * <ul>
 *  <li> adds a field with the corresponding JavaFX property type,
 *  <li> a getter method
 *  <li> a setter method
 *  <li> and an accessor to the JavaFX property.
 * </ul>
 */
@Active(FxBeanCompilationParticipant.class)
public @interface FXBindable {
}

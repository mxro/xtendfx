package xtendfx;

import org.eclipse.xtend.lib.macro.Active;
import xtendfx.FXAppCompilationParticipant;

/**
 * Lets a class extend {@link javafx.application.Application} and
 * adds a main method calling Application#launch
 */
@Active(FXAppCompilationParticipant.class)
public @interface FXApp {
}

package xtendfx;

import org.eclipse.xtend.lib.macro.AbstractClassProcessor;
import org.eclipse.xtend.lib.macro.TransformationContext;
import org.eclipse.xtend.lib.macro.declaration.MutableClassDeclaration;
import org.eclipse.xtext.xbase.lib.Extension;

@SuppressWarnings("all")
public class FXAppCompilationParticipant extends AbstractClassProcessor {
  public void doTransform(final MutableClassDeclaration annotatedClass, @Extension final TransformationContext ctx) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field Application is undefined for the type FXAppCompilationParticipant"
      + "\nnewTypeReference cannot be resolved");
  }
}

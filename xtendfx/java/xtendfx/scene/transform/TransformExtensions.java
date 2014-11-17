package xtendfx.scene.transform;

import javafx.geometry.Point3D;
import javafx.scene.transform.Affine;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Scale;
import javafx.scene.transform.Transform;

/**
 * A couple of extension methods for manipulationg affine transformations.
 * See <a href="http://koehnlein.blogspot.de/2013/01/accumulating-javafx-transforms-with.html">my blog</a> for details.
 * 
 * @author koehnlein
 */
@SuppressWarnings("all")
public class TransformExtensions {
  /**
   * Accumulates another {@link Transform} in a given {@link Affine} using matrix multiplication.
   * When applying the combined transform, the original trafo is applied first.
   */
  public static void leftMultiply(final Affine it, final Transform l) {
    throw new Error("Unresolved compilation problems:"
      + "\n* cannot be resolved."
      + "\n* cannot be resolved."
      + "\n* cannot be resolved."
      + "\n* cannot be resolved."
      + "\n* cannot be resolved."
      + "\n* cannot be resolved."
      + "\n* cannot be resolved."
      + "\n* cannot be resolved."
      + "\n* cannot be resolved."
      + "\n* cannot be resolved."
      + "\n* cannot be resolved."
      + "\n* cannot be resolved."
      + "\n* cannot be resolved."
      + "\n* cannot be resolved."
      + "\n* cannot be resolved."
      + "\n* cannot be resolved."
      + "\n* cannot be resolved."
      + "\n* cannot be resolved."
      + "\n* cannot be resolved."
      + "\n* cannot be resolved."
      + "\n* cannot be resolved."
      + "\n* cannot be resolved."
      + "\n* cannot be resolved."
      + "\n* cannot be resolved."
      + "\n* cannot be resolved."
      + "\n* cannot be resolved."
      + "\n* cannot be resolved."
      + "\n* cannot be resolved."
      + "\n* cannot be resolved."
      + "\n* cannot be resolved."
      + "\n* cannot be resolved."
      + "\n* cannot be resolved."
      + "\n* cannot be resolved."
      + "\n* cannot be resolved."
      + "\n* cannot be resolved."
      + "\n* cannot be resolved."
      + "\n+ cannot be resolved"
      + "\n+ cannot be resolved"
      + "\n+ cannot be resolved"
      + "\n+ cannot be resolved"
      + "\n+ cannot be resolved"
      + "\n+ cannot be resolved"
      + "\n+ cannot be resolved"
      + "\n+ cannot be resolved"
      + "\n+ cannot be resolved"
      + "\n+ cannot be resolved"
      + "\n+ cannot be resolved"
      + "\n+ cannot be resolved"
      + "\n+ cannot be resolved"
      + "\n+ cannot be resolved"
      + "\n+ cannot be resolved"
      + "\n+ cannot be resolved"
      + "\n+ cannot be resolved"
      + "\n+ cannot be resolved"
      + "\n+ cannot be resolved"
      + "\n+ cannot be resolved"
      + "\n+ cannot be resolved"
      + "\n+ cannot be resolved"
      + "\n+ cannot be resolved"
      + "\n+ cannot be resolved"
      + "\n+ cannot be resolved"
      + "\n+ cannot be resolved"
      + "\n+ cannot be resolved");
  }
  
  /**
   * Accumulates (multiplies) two {@link Transform}s into a new {@link Transform}.
   * When applying the transform, <code>r</code> is applied first.
   */
  public static Transform operator_multiply(final Transform l, final Transform r) {
    throw new Error("Unresolved compilation problems:"
      + "\n* cannot be resolved."
      + "\n* cannot be resolved."
      + "\n* cannot be resolved."
      + "\n* cannot be resolved."
      + "\n* cannot be resolved."
      + "\n* cannot be resolved."
      + "\n* cannot be resolved."
      + "\n* cannot be resolved."
      + "\n* cannot be resolved."
      + "\n* cannot be resolved."
      + "\n* cannot be resolved."
      + "\n* cannot be resolved."
      + "\n* cannot be resolved."
      + "\n* cannot be resolved."
      + "\n* cannot be resolved."
      + "\n* cannot be resolved."
      + "\n* cannot be resolved."
      + "\n* cannot be resolved."
      + "\n* cannot be resolved."
      + "\n* cannot be resolved."
      + "\n* cannot be resolved."
      + "\n* cannot be resolved."
      + "\n* cannot be resolved."
      + "\n* cannot be resolved."
      + "\n* cannot be resolved."
      + "\n* cannot be resolved."
      + "\n* cannot be resolved."
      + "\n* cannot be resolved."
      + "\n* cannot be resolved."
      + "\n* cannot be resolved."
      + "\n* cannot be resolved."
      + "\n* cannot be resolved."
      + "\n* cannot be resolved."
      + "\n* cannot be resolved."
      + "\n* cannot be resolved."
      + "\n* cannot be resolved."
      + "\n+ cannot be resolved"
      + "\n+ cannot be resolved"
      + "\n+ cannot be resolved"
      + "\n+ cannot be resolved"
      + "\n+ cannot be resolved"
      + "\n+ cannot be resolved"
      + "\n+ cannot be resolved"
      + "\n+ cannot be resolved"
      + "\n+ cannot be resolved"
      + "\n+ cannot be resolved"
      + "\n+ cannot be resolved"
      + "\n+ cannot be resolved"
      + "\n+ cannot be resolved"
      + "\n+ cannot be resolved"
      + "\n+ cannot be resolved"
      + "\n+ cannot be resolved"
      + "\n+ cannot be resolved"
      + "\n+ cannot be resolved"
      + "\n+ cannot be resolved"
      + "\n+ cannot be resolved"
      + "\n+ cannot be resolved"
      + "\n+ cannot be resolved"
      + "\n+ cannot be resolved"
      + "\n+ cannot be resolved"
      + "\n+ cannot be resolved"
      + "\n+ cannot be resolved"
      + "\n+ cannot be resolved");
  }
  
  /**
   * Applies a {@link Transform} to a {@link Point3D}.
   */
  public static Point3D operator_multiply(final Transform l, final Point3D x) {
    throw new Error("Unresolved compilation problems:"
      + "\n* cannot be resolved."
      + "\n* cannot be resolved."
      + "\n* cannot be resolved."
      + "\n* cannot be resolved."
      + "\n* cannot be resolved."
      + "\n* cannot be resolved."
      + "\n* cannot be resolved."
      + "\n* cannot be resolved."
      + "\n* cannot be resolved."
      + "\n+ cannot be resolved"
      + "\n+ cannot be resolved"
      + "\n+ cannot be resolved"
      + "\n+ cannot be resolved"
      + "\n+ cannot be resolved"
      + "\n+ cannot be resolved"
      + "\n+ cannot be resolved"
      + "\n+ cannot be resolved"
      + "\n+ cannot be resolved");
  }
  
  /**
   * Adds a translation to the given {@link Affine}
   */
  public static void translate(final Affine it, final double x, final double y) {
    throw new Error("Unresolved compilation problems:"
      + "\n+ cannot be resolved."
      + "\n+ cannot be resolved.");
  }
  
  public static void translate(final Affine it, final double x, final double y, final double z) {
    throw new Error("Unresolved compilation problems:"
      + "\n+ cannot be resolved."
      + "\n+ cannot be resolved."
      + "\n+ cannot be resolved.");
  }
  
  public static void rotate(final Affine it, final double angle) {
    Rotate _rotate = new Rotate(angle);
    TransformExtensions.leftMultiply(it, _rotate);
  }
  
  public static void rotate(final Affine it, final double angle, final double pivotX, final double pivotY) {
    Rotate _rotate = new Rotate(angle, pivotX, pivotY);
    TransformExtensions.leftMultiply(it, _rotate);
  }
  
  public static void rotate(final Affine it, final double angle, final double pivotX, final double pivotY, final double pivotZ) {
    Rotate _rotate = new Rotate(angle, pivotX, pivotY, pivotZ);
    TransformExtensions.leftMultiply(it, _rotate);
  }
  
  public static void rotate(final Affine it, final double angle, final double pivotX, final double pivotY, final double pivotZ, final Point3D axis) {
    Rotate _rotate = new Rotate(angle, pivotX, pivotY, pivotZ, axis);
    TransformExtensions.leftMultiply(it, _rotate);
  }
  
  public static void rotate(final Affine it, final double angle, final Point3D axis) {
    Rotate _rotate = new Rotate(angle, axis);
    TransformExtensions.leftMultiply(it, _rotate);
  }
  
  public static void scale(final Affine it, final double x, final double y) {
    throw new Error("Unresolved compilation problems:"
      + "\n* cannot be resolved."
      + "\n* cannot be resolved."
      + "\n* cannot be resolved."
      + "\n* cannot be resolved."
      + "\n* cannot be resolved."
      + "\n* cannot be resolved."
      + "\n* cannot be resolved."
      + "\n* cannot be resolved.");
  }
  
  public static void scale(final Affine it, final double x, final double y, final double z) {
    throw new Error("Unresolved compilation problems:"
      + "\n* cannot be resolved."
      + "\n* cannot be resolved."
      + "\n* cannot be resolved."
      + "\n* cannot be resolved."
      + "\n* cannot be resolved."
      + "\n* cannot be resolved."
      + "\n* cannot be resolved."
      + "\n* cannot be resolved."
      + "\n* cannot be resolved."
      + "\n* cannot be resolved."
      + "\n* cannot be resolved."
      + "\n* cannot be resolved.");
  }
  
  public static void scale(final Affine it, final double x, final double y, final double pivotX, final double pivotY) {
    Scale _scale = new Scale(x, y, pivotX, pivotY);
    TransformExtensions.leftMultiply(it, _scale);
  }
  
  public static void scale(final Affine it, final double x, final double y, final double z, final double pivotX, final double pivotY, final double pivotZ) {
    Scale _scale = new Scale(x, y, z, pivotX, pivotY, pivotZ);
    TransformExtensions.leftMultiply(it, _scale);
  }
  
  public static void shear(final Affine it, final double x, final double y) {
    throw new Error("Unresolved compilation problems:"
      + "\n+ cannot be resolved."
      + "\n* cannot be resolved."
      + "\n+ cannot be resolved."
      + "\n* cannot be resolved."
      + "\n+ cannot be resolved."
      + "\n* cannot be resolved."
      + "\n+ cannot be resolved."
      + "\n* cannot be resolved."
      + "\n* cannot be resolved."
      + "\n* cannot be resolved."
      + "\n* cannot be resolved."
      + "\n* cannot be resolved."
      + "\n+ cannot be resolved"
      + "\n+ cannot be resolved"
      + "\n+ cannot be resolved"
      + "\n+ cannot be resolved");
  }
  
  public static void shear(final Affine it, final double x, final double y, final double pivotX, final double pivotY) {
    throw new Error("Unresolved compilation problems:"
      + "\n+ cannot be resolved."
      + "\n* cannot be resolved."
      + "\n+ cannot be resolved."
      + "\n* cannot be resolved."
      + "\n+ cannot be resolved."
      + "\n* cannot be resolved."
      + "\n+ cannot be resolved."
      + "\n* cannot be resolved."
      + "\n* cannot be resolved."
      + "\n* cannot be resolved."
      + "\n* cannot be resolved."
      + "\n* cannot be resolved."
      + "\n* cannot be resolved."
      + "\n* cannot be resolved."
      + "\n- cannot be resolved"
      + "\n+ cannot be resolved"
      + "\n+ cannot be resolved"
      + "\n+ cannot be resolved"
      + "\n+ cannot be resolved"
      + "\n- cannot be resolved");
  }
}

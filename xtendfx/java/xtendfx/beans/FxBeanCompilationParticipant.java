package xtendfx.beans;

import com.google.common.base.Objects;
import java.util.List;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.FloatProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ListProperty;
import javafx.beans.property.LongProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.ReadOnlyBooleanProperty;
import javafx.beans.property.ReadOnlyBooleanWrapper;
import javafx.beans.property.ReadOnlyDoubleProperty;
import javafx.beans.property.ReadOnlyDoubleWrapper;
import javafx.beans.property.ReadOnlyFloatProperty;
import javafx.beans.property.ReadOnlyFloatWrapper;
import javafx.beans.property.ReadOnlyIntegerProperty;
import javafx.beans.property.ReadOnlyIntegerWrapper;
import javafx.beans.property.ReadOnlyListProperty;
import javafx.beans.property.ReadOnlyListWrapper;
import javafx.beans.property.ReadOnlyLongProperty;
import javafx.beans.property.ReadOnlyLongWrapper;
import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.property.ReadOnlyStringProperty;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import org.eclipse.xtend.lib.Data;
import org.eclipse.xtend.lib.macro.TransformationContext;
import org.eclipse.xtend.lib.macro.TransformationParticipant;
import org.eclipse.xtend.lib.macro.declaration.AnnotationReference;
import org.eclipse.xtend.lib.macro.declaration.CompilationStrategy;
import org.eclipse.xtend.lib.macro.declaration.MutableAnnotationReference;
import org.eclipse.xtend.lib.macro.declaration.MutableClassDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableFieldDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableMethodDeclaration;
import org.eclipse.xtend.lib.macro.declaration.Type;
import org.eclipse.xtend.lib.macro.declaration.TypeDeclaration;
import org.eclipse.xtend.lib.macro.declaration.TypeReference;
import org.eclipse.xtend.lib.macro.declaration.Visibility;
import org.eclipse.xtend.lib.macro.expression.Expression;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import xtendfx.beans.Immutable;
import xtendfx.beans.NoneLazy;
import xtendfx.beans.Readonly;

@SuppressWarnings("all")
public class FxBeanCompilationParticipant implements TransformationParticipant<MutableClassDeclaration> {
  public void doTransform(final List<? extends MutableClassDeclaration> classes, @Extension final TransformationContext context) {
    final Type fxImmutableAnnotation = context.findTypeGlobally(Immutable.class);
    final Type dataAnnotation = context.findTypeGlobally(Data.class);
    final Type fxReadonlyAnnotation = context.findTypeGlobally(Readonly.class);
    final Type fxNoneLazyAnnotation = context.findTypeGlobally(NoneLazy.class);
    for (final MutableClassDeclaration clazz : classes) {
      Iterable<? extends MutableFieldDeclaration> _declaredFields = clazz.getDeclaredFields();
      for (final MutableFieldDeclaration f : _declaredFields) {
        {
          final boolean readonly = this.readonly(f, fxReadonlyAnnotation);
          final boolean lazy = this.lazy(f, fxNoneLazyAnnotation);
          final boolean immutableType = this.immutableType(f, fxImmutableAnnotation, dataAnnotation);
          final String fieldName = f.getSimpleName();
          final TypeReference fieldType = f.getType();
          String _simpleName = f.getSimpleName();
          final String propName = (_simpleName + "Property");
          TypeReference _type = f.getType();
          final TypeReference propType = this.toPropertyType(_type, readonly, context);
          TypeReference _type_1 = f.getType();
          final TypeReference propTypeAPI = this.toPropertyType_API(_type_1, readonly, context);
          if (lazy) {
            this.createLazyField(immutableType, f, clazz, propName, propType, fieldName, fieldType, readonly, propTypeAPI);
          } else {
            this.createNoneLazyField(immutableType, f, clazz, propName, propType, fieldName, fieldType, readonly, propTypeAPI);
          }
        }
      }
    }
  }
  
  public void createNoneLazyField(final boolean immutableType, final MutableFieldDeclaration f, final MutableClassDeclaration clazz, final String propName, final TypeReference propType, final String fieldName, final TypeReference fieldType, final boolean readonly, final TypeReference propTypeAPI) {
    Expression _initializer = f.getInitializer();
    boolean _tripleEquals = (_initializer == null);
    if (_tripleEquals) {
      final Procedure1<MutableFieldDeclaration> _function = new Procedure1<MutableFieldDeclaration>() {
        public void apply(final MutableFieldDeclaration it) {
          it.setType(propType);
          final CompilationStrategy _function = new CompilationStrategy() {
            public CharSequence compile(final CompilationStrategy.CompilationContext it) {
              StringConcatenation _builder = new StringConcatenation();
              _builder.append("new ");
              String _javaCode = it.toJavaCode(propType);
              _builder.append(_javaCode, "");
              _builder.append("(this, \"");
              _builder.append(fieldName, "");
              _builder.append("\")");
              return _builder;
            }
          };
          it.setInitializer(_function);
        }
      };
      clazz.addField(propName, _function);
    } else {
      final Procedure1<MutableFieldDeclaration> _function_1 = new Procedure1<MutableFieldDeclaration>() {
        public void apply(final MutableFieldDeclaration it) {
          it.setType(propType);
          final CompilationStrategy _function = new CompilationStrategy() {
            public CharSequence compile(final CompilationStrategy.CompilationContext it) {
              StringConcatenation _builder = new StringConcatenation();
              _builder.append("new ");
              String _javaCode = it.toJavaCode(propType);
              _builder.append(_javaCode, "");
              _builder.append("(this, \"");
              _builder.append(fieldName, "");
              _builder.append("\",_init");
              String _firstUpper = StringExtensions.toFirstUpper(fieldName);
              _builder.append(_firstUpper, "");
              _builder.append("())");
              return _builder;
            }
          };
          it.setInitializer(_function);
        }
      };
      clazz.addField(propName, _function_1);
      String _firstUpper = StringExtensions.toFirstUpper(fieldName);
      String _plus = ("_init" + _firstUpper);
      final Procedure1<MutableMethodDeclaration> _function_2 = new Procedure1<MutableMethodDeclaration>() {
        public void apply(final MutableMethodDeclaration it) {
          it.setReturnType(fieldType);
          it.setVisibility(Visibility.PRIVATE);
          it.setStatic(true);
          it.setFinal(true);
          Expression _initializer = f.getInitializer();
          it.setBody(_initializer);
        }
      };
      clazz.addMethod(_plus, _function_2);
    }
    String _firstUpper_1 = StringExtensions.toFirstUpper(fieldName);
    String _plus_1 = ("get" + _firstUpper_1);
    final Procedure1<MutableMethodDeclaration> _function_3 = new Procedure1<MutableMethodDeclaration>() {
      public void apply(final MutableMethodDeclaration it) {
        it.setReturnType(fieldType);
        final CompilationStrategy _function = new CompilationStrategy() {
          public CharSequence compile(final CompilationStrategy.CompilationContext it) {
            StringConcatenation _builder = new StringConcatenation();
            _builder.append("return this.");
            _builder.append(propName, "");
            _builder.append(".get();");
            _builder.newLineIfNotEmpty();
            return _builder;
          }
        };
        it.setBody(_function);
      }
    };
    clazz.addMethod(_plus_1, _function_3);
    if ((!readonly)) {
      String _firstUpper_2 = StringExtensions.toFirstUpper(fieldName);
      String _plus_2 = ("set" + _firstUpper_2);
      final Procedure1<MutableMethodDeclaration> _function_4 = new Procedure1<MutableMethodDeclaration>() {
        public void apply(final MutableMethodDeclaration it) {
          it.addParameter(fieldName, fieldType);
          final CompilationStrategy _function = new CompilationStrategy() {
            public CharSequence compile(final CompilationStrategy.CompilationContext it) {
              StringConcatenation _builder = new StringConcatenation();
              _builder.append("this.");
              _builder.append(propName, "");
              _builder.append(".set(");
              _builder.append(fieldName, "");
              _builder.append(");");
              _builder.newLineIfNotEmpty();
              return _builder;
            }
          };
          it.setBody(_function);
        }
      };
      clazz.addMethod(_plus_2, _function_4);
    }
    final Procedure1<MutableMethodDeclaration> _function_5 = new Procedure1<MutableMethodDeclaration>() {
      public void apply(final MutableMethodDeclaration it) {
        it.setReturnType(propTypeAPI);
        final CompilationStrategy _function = new CompilationStrategy() {
          public CharSequence compile(final CompilationStrategy.CompilationContext it) {
            StringConcatenation _builder = new StringConcatenation();
            _builder.append("return ");
            {
              if (readonly) {
                _builder.append("this.");
                _builder.append(propName, "");
                _builder.append(".getReadOnlyProperty()");
              } else {
                _builder.append("this.");
                _builder.append(propName, "");
              }
            }
            _builder.append(";");
            _builder.newLineIfNotEmpty();
            return _builder;
          }
        };
        it.setBody(_function);
      }
    };
    clazz.addMethod((fieldName + "Property"), _function_5);
    f.remove();
  }
  
  public void createLazyField(final boolean immutableType, final MutableFieldDeclaration f, final MutableClassDeclaration clazz, final String propName, final TypeReference propType, final String fieldName, final TypeReference fieldType, final boolean readonly, final TypeReference propTypeAPI) {
    if (immutableType) {
      Expression _initializer = f.getInitializer();
      boolean _tripleEquals = (_initializer == null);
      if (_tripleEquals) {
        String _simpleName = f.getSimpleName();
        String _upperCase = _simpleName.toUpperCase();
        String _plus = ("DEFAULT_" + _upperCase);
        final Procedure1<MutableFieldDeclaration> _function = new Procedure1<MutableFieldDeclaration>() {
          public void apply(final MutableFieldDeclaration it) {
            TypeReference _type = f.getType();
            it.setType(_type);
            final CompilationStrategy _function = new CompilationStrategy() {
              public CharSequence compile(final CompilationStrategy.CompilationContext it) {
                TypeReference _type = f.getType();
                return FxBeanCompilationParticipant.this.defaultValue(_type);
              }
            };
            it.setInitializer(_function);
            it.setFinal(true);
            it.setStatic(true);
          }
        };
        clazz.addField(_plus, _function);
      } else {
        String _simpleName_1 = f.getSimpleName();
        String _upperCase_1 = _simpleName_1.toUpperCase();
        String _plus_1 = ("DEFAULT_" + _upperCase_1);
        final Procedure1<MutableFieldDeclaration> _function_1 = new Procedure1<MutableFieldDeclaration>() {
          public void apply(final MutableFieldDeclaration it) {
            TypeReference _type = f.getType();
            it.setType(_type);
            Expression _initializer = f.getInitializer();
            it.setInitializer(_initializer);
            it.setFinal(true);
            it.setStatic(true);
          }
        };
        clazz.addField(_plus_1, _function_1);
      }
    }
    final Procedure1<MutableFieldDeclaration> _function_2 = new Procedure1<MutableFieldDeclaration>() {
      public void apply(final MutableFieldDeclaration it) {
        it.setType(propType);
      }
    };
    clazz.addField(propName, _function_2);
    String _firstUpper = StringExtensions.toFirstUpper(fieldName);
    String _plus_2 = ("get" + _firstUpper);
    final Procedure1<MutableMethodDeclaration> _function_3 = new Procedure1<MutableMethodDeclaration>() {
      public void apply(final MutableMethodDeclaration it) {
        it.setReturnType(fieldType);
        final CompilationStrategy _function = new CompilationStrategy() {
          public CharSequence compile(final CompilationStrategy.CompilationContext it) {
            StringConcatenation _builder = new StringConcatenation();
            _builder.append("return (this.");
            _builder.append(propName, "");
            _builder.append(" != null)? this.");
            _builder.append(propName, "");
            _builder.append(".get() : ");
            {
              if (immutableType) {
                _builder.append("DEFAULT_");
                String _upperCase = fieldName.toUpperCase();
                _builder.append(_upperCase, "");
              } else {
                _builder.append("this.");
                _builder.append(fieldName, "");
              }
            }
            _builder.append(";");
            _builder.newLineIfNotEmpty();
            return _builder;
          }
        };
        it.setBody(_function);
      }
    };
    clazz.addMethod(_plus_2, _function_3);
    if ((!readonly)) {
      String _firstUpper_1 = StringExtensions.toFirstUpper(fieldName);
      String _plus_3 = ("set" + _firstUpper_1);
      final Procedure1<MutableMethodDeclaration> _function_4 = new Procedure1<MutableMethodDeclaration>() {
        public void apply(final MutableMethodDeclaration it) {
          it.addParameter(fieldName, fieldType);
          final CompilationStrategy _function = new CompilationStrategy() {
            public CharSequence compile(final CompilationStrategy.CompilationContext it) {
              StringConcatenation _builder = new StringConcatenation();
              {
                if (immutableType) {
                  _builder.append("this.");
                  _builder.append(propName, "");
                  _builder.append("().set(");
                  _builder.append(fieldName, "");
                  _builder.append(");");
                  _builder.newLineIfNotEmpty();
                } else {
                  _builder.append("if (");
                  _builder.append(propName, "");
                  _builder.append(" != null) {");
                  _builder.newLineIfNotEmpty();
                  _builder.append("\t");
                  _builder.append("this.");
                  _builder.append(propName, "\t");
                  _builder.append(".set(");
                  _builder.append(fieldName, "\t");
                  _builder.append(");");
                  _builder.newLineIfNotEmpty();
                  _builder.append("} else {");
                  _builder.newLine();
                  _builder.append("\t");
                  _builder.append("this.");
                  _builder.append(fieldName, "\t");
                  _builder.append(" = ");
                  _builder.append(fieldName, "\t");
                  _builder.append(";");
                  _builder.newLineIfNotEmpty();
                  _builder.append("}");
                  _builder.newLine();
                }
              }
              return _builder;
            }
          };
          it.setBody(_function);
        }
      };
      clazz.addMethod(_plus_3, _function_4);
    }
    final Procedure1<MutableMethodDeclaration> _function_5 = new Procedure1<MutableMethodDeclaration>() {
      public void apply(final MutableMethodDeclaration it) {
        it.setReturnType(propTypeAPI);
        final CompilationStrategy _function = new CompilationStrategy() {
          public CharSequence compile(final CompilationStrategy.CompilationContext it) {
            StringConcatenation _builder = new StringConcatenation();
            _builder.append("if (this.");
            _builder.append(propName, "");
            _builder.append(" == null) { ");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("this.");
            _builder.append(propName, "\t");
            _builder.append(" = new ");
            String _javaCode = it.toJavaCode(propType);
            _builder.append(_javaCode, "\t");
            _builder.append("(this, \"");
            _builder.append(fieldName, "\t");
            _builder.append("\", ");
            {
              if (immutableType) {
                _builder.append("DEFAULT_");
                String _upperCase = fieldName.toUpperCase();
                _builder.append(_upperCase, "\t");
              } else {
                _builder.append("this.");
                _builder.append(fieldName, "\t");
              }
            }
            _builder.append(");");
            _builder.newLineIfNotEmpty();
            _builder.append("}");
            _builder.newLine();
            _builder.append("return ");
            {
              if (readonly) {
                _builder.append("this.");
                _builder.append(propName, "");
                _builder.append(".getReadOnlyProperty()");
              } else {
                _builder.append("this.");
                _builder.append(propName, "");
              }
            }
            _builder.append(";");
            _builder.newLineIfNotEmpty();
            return _builder;
          }
        };
        it.setBody(_function);
      }
    };
    clazz.addMethod((fieldName + "Property"), _function_5);
    if (immutableType) {
      f.remove();
    }
  }
  
  public boolean readonly(final MutableFieldDeclaration field, final Type readonlyAnnotation) {
    MutableAnnotationReference _findAnnotation = field.findAnnotation(readonlyAnnotation);
    return (_findAnnotation != null);
  }
  
  public boolean lazy(final MutableFieldDeclaration field, final Type noneLazyAnnotation) {
    MutableAnnotationReference _findAnnotation = field.findAnnotation(noneLazyAnnotation);
    return (_findAnnotation == null);
  }
  
  public boolean immutableType(final MutableFieldDeclaration field, final Type fxImmutableAnnotation, final Type dataAnnotation) {
    boolean _switchResult = false;
    TypeReference _type = field.getType();
    String _string = _type.toString();
    boolean _matched = false;
    if (!_matched) {
      if (Objects.equal(_string, "boolean")) {
        _matched=true;
        _switchResult = true;
      }
    }
    if (!_matched) {
      if (Objects.equal(_string, "double")) {
        _matched=true;
        _switchResult = true;
      }
    }
    if (!_matched) {
      if (Objects.equal(_string, "float")) {
        _matched=true;
        _switchResult = true;
      }
    }
    if (!_matched) {
      if (Objects.equal(_string, "long")) {
        _matched=true;
        _switchResult = true;
      }
    }
    if (!_matched) {
      if (Objects.equal(_string, "String")) {
        _matched=true;
        _switchResult = true;
      }
    }
    if (!_matched) {
      if (Objects.equal(_string, "int")) {
        _matched=true;
        _switchResult = true;
      }
    }
    if (!_matched) {
      if (Objects.equal(_string, "javafx.collections.ObservableList")) {
        _matched=true;
        _switchResult = false;
      }
    }
    if (!_matched) {
      MutableAnnotationReference _findAnnotation = field.findAnnotation(fxImmutableAnnotation);
      boolean _tripleNotEquals = (_findAnnotation != null);
      if (_tripleNotEquals) {
        return true;
      } else {
        TypeReference _type_1 = field.getType();
        Type _type_2 = _type_1.getType();
        if ((_type_2 instanceof TypeDeclaration)) {
          TypeReference _type_3 = field.getType();
          Type _type_4 = _type_3.getType();
          final TypeDeclaration t = ((TypeDeclaration) _type_4);
          boolean _or = false;
          AnnotationReference _findAnnotation_1 = t.findAnnotation(fxImmutableAnnotation);
          boolean _tripleNotEquals_1 = (_findAnnotation_1 != null);
          if (_tripleNotEquals_1) {
            _or = true;
          } else {
            AnnotationReference _findAnnotation_2 = t.findAnnotation(dataAnnotation);
            boolean _notEquals = (!Objects.equal(_findAnnotation_2, null));
            _or = _notEquals;
          }
          final boolean rv = _or;
          return rv;
        } else {
          return false;
        }
      }
    }
    return _switchResult;
  }
  
  public String defaultValue(final TypeReference ref) {
    String _switchResult = null;
    String _string = ref.toString();
    boolean _matched = false;
    if (!_matched) {
      if (Objects.equal(_string, "boolean")) {
        _matched=true;
        _switchResult = "false";
      }
    }
    if (!_matched) {
      if (Objects.equal(_string, "double")) {
        _matched=true;
        _switchResult = "0d";
      }
    }
    if (!_matched) {
      if (Objects.equal(_string, "float")) {
        _matched=true;
        _switchResult = "0f";
      }
    }
    if (!_matched) {
      if (Objects.equal(_string, "long")) {
        _matched=true;
        _switchResult = "0";
      }
    }
    if (!_matched) {
      if (Objects.equal(_string, "int")) {
        _matched=true;
        _switchResult = "0";
      }
    }
    if (!_matched) {
      _switchResult = "null";
    }
    return _switchResult;
  }
  
  public TypeReference toPropertyType_API(final TypeReference ref, final boolean readonly, @Extension final TransformationContext context) {
    TypeReference _xifexpression = null;
    if (readonly) {
      TypeReference _switchResult = null;
      String _string = ref.toString();
      boolean _matched = false;
      if (!_matched) {
        if (Objects.equal(_string, "boolean")) {
          _matched=true;
          _switchResult = context.newTypeReference(ReadOnlyBooleanProperty.class);
        }
      }
      if (!_matched) {
        if (Objects.equal(_string, "double")) {
          _matched=true;
          _switchResult = context.newTypeReference(ReadOnlyDoubleProperty.class);
        }
      }
      if (!_matched) {
        if (Objects.equal(_string, "float")) {
          _matched=true;
          _switchResult = context.newTypeReference(ReadOnlyFloatProperty.class);
        }
      }
      if (!_matched) {
        if (Objects.equal(_string, "long")) {
          _matched=true;
          _switchResult = context.newTypeReference(ReadOnlyLongProperty.class);
        }
      }
      if (!_matched) {
        if (Objects.equal(_string, "String")) {
          _matched=true;
          _switchResult = context.newTypeReference(ReadOnlyStringProperty.class);
        }
      }
      if (!_matched) {
        if (Objects.equal(_string, "int")) {
          _matched=true;
          _switchResult = context.newTypeReference(ReadOnlyIntegerProperty.class);
        }
      }
      if (!_matched) {
        if (Objects.equal(_string, "javafx.collections.ObservableList")) {
          _matched=true;
          List<TypeReference> _actualTypeArguments = ref.getActualTypeArguments();
          TypeReference _head = IterableExtensions.<TypeReference>head(_actualTypeArguments);
          _switchResult = context.newTypeReference(ReadOnlyListProperty.class, _head);
        }
      }
      if (!_matched) {
        _switchResult = context.newTypeReference(ReadOnlyObjectProperty.class, ref);
      }
      _xifexpression = _switchResult;
    } else {
      TypeReference _switchResult_1 = null;
      String _string_1 = ref.toString();
      boolean _matched_1 = false;
      if (!_matched_1) {
        if (Objects.equal(_string_1, "boolean")) {
          _matched_1=true;
          _switchResult_1 = context.newTypeReference(BooleanProperty.class);
        }
      }
      if (!_matched_1) {
        if (Objects.equal(_string_1, "double")) {
          _matched_1=true;
          _switchResult_1 = context.newTypeReference(DoubleProperty.class);
        }
      }
      if (!_matched_1) {
        if (Objects.equal(_string_1, "float")) {
          _matched_1=true;
          _switchResult_1 = context.newTypeReference(FloatProperty.class);
        }
      }
      if (!_matched_1) {
        if (Objects.equal(_string_1, "long")) {
          _matched_1=true;
          _switchResult_1 = context.newTypeReference(LongProperty.class);
        }
      }
      if (!_matched_1) {
        if (Objects.equal(_string_1, "String")) {
          _matched_1=true;
          _switchResult_1 = context.newTypeReference(StringProperty.class);
        }
      }
      if (!_matched_1) {
        if (Objects.equal(_string_1, "int")) {
          _matched_1=true;
          _switchResult_1 = context.newTypeReference(IntegerProperty.class);
        }
      }
      if (!_matched_1) {
        if (Objects.equal(_string_1, "javafx.collections.ObservableList")) {
          _matched_1=true;
          List<TypeReference> _actualTypeArguments_1 = ref.getActualTypeArguments();
          TypeReference _head_1 = IterableExtensions.<TypeReference>head(_actualTypeArguments_1);
          _switchResult_1 = context.newTypeReference(ListProperty.class, _head_1);
        }
      }
      if (!_matched_1) {
        _switchResult_1 = context.newTypeReference(ObjectProperty.class, ref);
      }
      _xifexpression = _switchResult_1;
    }
    return _xifexpression;
  }
  
  public TypeReference toPropertyType(final TypeReference ref, final boolean readonly, @Extension final TransformationContext context) {
    TypeReference _xifexpression = null;
    if (readonly) {
      TypeReference _switchResult = null;
      String _string = ref.toString();
      boolean _matched = false;
      if (!_matched) {
        if (Objects.equal(_string, "boolean")) {
          _matched=true;
          _switchResult = context.newTypeReference(ReadOnlyBooleanWrapper.class);
        }
      }
      if (!_matched) {
        if (Objects.equal(_string, "double")) {
          _matched=true;
          _switchResult = context.newTypeReference(ReadOnlyDoubleWrapper.class);
        }
      }
      if (!_matched) {
        if (Objects.equal(_string, "float")) {
          _matched=true;
          _switchResult = context.newTypeReference(ReadOnlyFloatWrapper.class);
        }
      }
      if (!_matched) {
        if (Objects.equal(_string, "long")) {
          _matched=true;
          _switchResult = context.newTypeReference(ReadOnlyLongWrapper.class);
        }
      }
      if (!_matched) {
        if (Objects.equal(_string, "String")) {
          _matched=true;
          _switchResult = context.newTypeReference(ReadOnlyStringWrapper.class);
        }
      }
      if (!_matched) {
        if (Objects.equal(_string, "int")) {
          _matched=true;
          _switchResult = context.newTypeReference(ReadOnlyIntegerWrapper.class);
        }
      }
      if (!_matched) {
        if (Objects.equal(_string, "javafx.collections.ObservableList")) {
          _matched=true;
          List<TypeReference> _actualTypeArguments = ref.getActualTypeArguments();
          TypeReference _head = IterableExtensions.<TypeReference>head(_actualTypeArguments);
          _switchResult = context.newTypeReference(ReadOnlyListWrapper.class, _head);
        }
      }
      if (!_matched) {
        _switchResult = context.newTypeReference(ReadOnlyObjectWrapper.class, ref);
      }
      _xifexpression = _switchResult;
    } else {
      TypeReference _switchResult_1 = null;
      String _string_1 = ref.toString();
      boolean _matched_1 = false;
      if (!_matched_1) {
        if (Objects.equal(_string_1, "boolean")) {
          _matched_1=true;
          _switchResult_1 = context.newTypeReference(SimpleBooleanProperty.class);
        }
      }
      if (!_matched_1) {
        if (Objects.equal(_string_1, "double")) {
          _matched_1=true;
          _switchResult_1 = context.newTypeReference(SimpleDoubleProperty.class);
        }
      }
      if (!_matched_1) {
        if (Objects.equal(_string_1, "float")) {
          _matched_1=true;
          _switchResult_1 = context.newTypeReference(SimpleFloatProperty.class);
        }
      }
      if (!_matched_1) {
        if (Objects.equal(_string_1, "long")) {
          _matched_1=true;
          _switchResult_1 = context.newTypeReference(SimpleLongProperty.class);
        }
      }
      if (!_matched_1) {
        if (Objects.equal(_string_1, "String")) {
          _matched_1=true;
          _switchResult_1 = context.newTypeReference(SimpleStringProperty.class);
        }
      }
      if (!_matched_1) {
        if (Objects.equal(_string_1, "int")) {
          _matched_1=true;
          _switchResult_1 = context.newTypeReference(SimpleIntegerProperty.class);
        }
      }
      if (!_matched_1) {
        if (Objects.equal(_string_1, "javafx.collections.ObservableList")) {
          _matched_1=true;
          List<TypeReference> _actualTypeArguments_1 = ref.getActualTypeArguments();
          TypeReference _head_1 = IterableExtensions.<TypeReference>head(_actualTypeArguments_1);
          _switchResult_1 = context.newTypeReference(SimpleListProperty.class, _head_1);
        }
      }
      if (!_matched_1) {
        _switchResult_1 = context.newTypeReference(SimpleObjectProperty.class, ref);
      }
      _xifexpression = _switchResult_1;
    }
    return _xifexpression;
  }
}

package org.chromium.base.annotations;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.CLASS)
@Target({java.lang.annotation.ElementType.METHOD})
public @interface NativeCall {}


/* Location:           F:\apktool\apktool\com.google.android.apps.plus\classes-dex2jar.jar
 * Qualified Name:     org.chromium.base.annotations.NativeCall
 * JD-Core Version:    0.7.0.1
 */
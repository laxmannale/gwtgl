/*
 * Copyright 2009-2011 Sönke Sothmann, Steffen Schäfer and others
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package com.google.gwt.typedarrays.client;

import com.google.gwt.core.client.JsArrayInteger;

/**
 * {@link TypedArray} that contains 16 Bit integer values.
 * 
 */
public class Int16Array extends IntBasedTypedArray<Int16Array> {

  /**
   * Creates a new instance of the {@link Int16Array} using the given {@link ArrayBuffer} to
   * read/write values from/to.
   * 
   * @param buffer the underlying {@link ArrayBuffer} of the newly created {@link TypedArray}.
   * @return the created {@link Int16Array} or null if it isn't supported by the browser.
   */
  public static Int16Array create(ArrayBuffer buffer) {
    if (!TypedArray.isSupported()) {
      return null;
    }
    return createImpl(buffer);
  }

  /**
   * Creates a new instance of the {@link Int16Array} using the given {@link ArrayBuffer} to
   * read/write values from/to.
   * 
   * The {@link Int16Array} is created using the byteOffset to specify the starting point (in bytes)
   * of the {@link Int16Array} relative to the beginning of the underlying {@link ArrayBuffer}. The
   * byte offset must match (multiple) the value length of this {@link TypedArray}.
   * 
   * If the byteOffset is not valid for the given {@link ArrayBuffer}, an exception is thrown
   * 
   * @param buffer the underlying {@link ArrayBuffer} of the newly created {@link TypedArray}.
   * @param byteOffset the offset relative to the beginning of the ArrayBuffer (multiple of the
   *          value length of this {@link TypedArray})
   * @return the newly created {@link Int16Array} or null if it isn't supported by the browser.
   */
  public static Int16Array create(ArrayBuffer buffer, int byteOffset) {
    if (!TypedArray.isSupported()) {
      return null;
    }
    return createImpl(buffer, byteOffset);
  }

  /**
   * Creates a new instance of the {@link TypedArray} using the given {@link ArrayBuffer} to
   * read/write values from/to.
   * 
   * The {@link Int16Array} is created using the byteOffset and length to specify the start and end
   * (in bytes) of the {@link Int16Array} relative to the beginning of the underlying
   * {@link ArrayBuffer}. The byte offset must match (multiple) the value length of this
   * {@link TypedArray}. The length is in values of the type of the {@link TypedArray}.
   * 
   * If the byteOffset or length is not valid for the given {@link ArrayBuffer}, an exception is
   * thrown.
   * 
   * @param buffer the underlying {@link ArrayBuffer} of the newly created {@link TypedArray}.
   * @param byteOffset the offset relative to the beginning of the ArrayBuffer (multiple of the
   *          value length of this {@link TypedArray})
   * @param length the length of the {@link TypedArray} in vales.
   * @return the newly created {@link Int16Array} or null if it isn't supported by the browser.
   */
  public static Int16Array create(ArrayBuffer buffer, int byteOffset, int length) {
    if (!TypedArray.isSupported()) {
      return null;
    }
    return createImpl(buffer, byteOffset, length);
  }

  /**
   * Creates a new instance of the {@link Int16Array} of the given length in values. All values are
   * set to 0.
   * 
   * @param length the length in values of the type used by this {@link Int16Array}
   * @return the created {@link Int16Array}.
   */
  public static Int16Array create(int length) {
    if (!TypedArray.isSupported()) {
      return null;
    }
    return createImpl(length);
  }

  /**
   * Creates a new instance of the {@link Int16Array} of the length of the given array in values.
   * The values contained in the given array are set to the newly created {@link Int16Array}.
   * 
   * @param array the array to get the values from
   * @return the created {@link Int16Array} or null if it isn't supported by the browser.
   */
  public static Int16Array create(int[] array) {
    return create(JsArrayUtil.wrapArray(array));
  }

  /**
   * Creates a new instance of the {@link Int16Array} of the length of the given array in values.
   * The values contained in the given array are set to the newly created {@link Int16Array}.
   * 
   * @param array the array to get the values from
   * @return the created {@link Int16Array} or null if it isn't supported by the browser.
   */
  public static Int16Array create(JsArrayInteger array) {
    if (!TypedArray.isSupported()) {
      return null;
    }
    return createImpl(array);
  }

  /**
   * Creates a new instance of the {@link Int16Array} of the same length (in values) as the given
   * {@link Int16Array} using a new ArrayBuffer. The new {@link TypedArray} is initialized with the
   * values of the given {@link TypedArray}. If necessary the values are converted to the value type
   * of the new {@link TypedArray}.
   * 
   * @param array the {@link TypedArray} to get the values from to initialize the new Array with
   * @return the created {@link Int16Array} or null if it isn't supported by the browser.
   */
  public static Int16Array create(TypedArray<?> array) {
    if (!TypedArray.isSupported()) {
      return null;
    }
    return createImpl(array);
  }

  /**
   * Creates a new instance of the {@link Int16Array} using the given {@link ArrayBuffer} to
   * read/write values from/to.
   * 
   * @param buffer the underlying {@link ArrayBuffer} of the newly created {@link Int16Array}.
   * @return the created {@link Int16Array}.
   */
  private static native Int16Array createImpl(ArrayBuffer buffer) /*-{
		return new Int16Array(buffer);
  }-*/;

  /**
   * Creates a new instance of the {@link TypedArray} using the given {@link ArrayBuffer} to
   * read/write values from/to.
   * 
   * The {@link Int16Array} is created using the byteOffset to specify the starting point (in bytes)
   * of the {@link Int16Array} relative to the beginning of the underlying {@link ArrayBuffer}. The
   * byte offset must match (multiple) the value length of this {@link TypedArray}.
   * 
   * If the byteOffet is not valid for the given {@link ArrayBuffer}, an exception is thrown
   * 
   * @param buffer the underlying {@link ArrayBuffer} of the newly created {@link Int16Array}.
   * @param byteOffset the offset relative to the beginning of the ArrayBuffer (multiple of the
   *          value length of this {@link TypedArray})
   * @return the newly created {@link Int16Array}.
   */
  private static native Int16Array createImpl(ArrayBuffer buffer, int byteOffset) /*-{
		return new Int16Array(buffer, byteOffset);
  }-*/;

  /**
   * Creates a new instance of the {@link Int16Array} using the given {@link ArrayBuffer} to
   * read/write values from/to.
   * 
   * The {@link Int16Array} is created using the byteOffset and length to specify the start and end
   * (in bytes) of the {@link Int16Array} relative to the beginning of the underlying
   * {@link ArrayBuffer}. The byte offset must match (multiple) the value length of this
   * {@link TypedArray}. The length is in values of the type of the {@link TypedArray}
   * 
   * If the byteOffset or length is not valid for the given {@link ArrayBuffer}, an exception is
   * thrown
   * 
   * @param buffer the underlying {@link ArrayBuffer} of the newly created {@link TypedArray}.
   * @param byteOffset the offset relative to the beginning of the ArrayBuffer (multiple of the
   *          value length of this {@link TypedArray})
   * @param length the length of the {@link Int16Array} in vales.
   * @return the newly created {@link Int16Array}.
   */
  private static native Int16Array createImpl(ArrayBuffer buffer, int byteOffset, int length) /*-{
		return new Int16Array(buffer, byteOffset, length);
  }-*/;

  /**
   * Creates a new instance of the {@link Int16Array} of the given length in values. All values are
   * set to 0.
   * 
   * @param length the length in values of the type used by this {@link Int16Array}
   * @return the created {@link Int16Array}.
   */
  private static native Int16Array createImpl(int length) /*-{
		return new Int16Array(length);
  }-*/;

  /**
   * Creates a new instance of the {@link Int16Array} of the length of the given array in values.
   * The values contained in the given array are set to the newly created {@link Int16Array}.
   * 
   * @param array the array to get the values from
   * @return the created {@link Int16Array}.
   */
  private static native Int16Array createImpl(JsArrayInteger array) /*-{
		return new Int16Array(array);
  }-*/;

  /**
   * Creates a new instance of the {@link Int16Array} of the same length (in values) as the given
   * {@link Int16Array} using a new ArrayBuffer. The new {@link TypedArray} is initialized with the
   * values of the given {@link TypedArray}. If necessary the values are converted to the value type
   * of the new {@link TypedArray}.
   * 
   * @param array the {@link TypedArray} to get the values from to initialize the new Array with
   * @return the created {@link Int16Array} or null if it isn't supported by the browser.
   */
  private static native Int16Array createImpl(TypedArray<?> array) /*-{
		return new Int16Array(array);
  }-*/;

  /**
   * protected standard constructor as specified by
   * {@link com.google.gwt.core.client.JavaScriptObject}.
   */
  protected Int16Array() {
    super();
  }

}

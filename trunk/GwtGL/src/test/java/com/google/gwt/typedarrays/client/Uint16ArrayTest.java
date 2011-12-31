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
import com.google.gwt.junit.DoNotRunWith;
import com.google.gwt.junit.Platform;
import com.google.gwt.junit.client.GWTTestCase;

/**
 * Tests for {@link Uint16Array}.
 */
@DoNotRunWith(Platform.HtmlUnitUnknown)
public class Uint16ArrayTest extends GWTTestCase {
  private static final int numBytes = 2;

  private static final int[] testData = new int[] {0, 1, 2, 3, 65535};

  private static final int[] testDataPart1 = new int[] {0, 1, 2, 3};

  private static final int[] testDataPart2 = new int[] {65535};

  private static native JsArrayInteger testDataJsArray() /*-{
    return [ 0, 1, 2, 3, 65535 ];
  }-*/;

  private static native JsArrayInteger testDataJsArrayPart1() /*-{
    return [ 0, 1, 2, 3 ];
  }-*/;

  private static native JsArrayInteger testDataJsArrayPart2() /*-{
    return [ 65535 ];
  }-*/;

  // 2^32-1, 0, 0-1, 2^32
  private static native JsArrayInteger testDataValueRange() /*-{
    return [ 65535, 0, -1, 65536 ];
  }-*/;

  @Override
  public String getModuleName() {
    return "com.google.gwt.typedarrays.TypedArrays";
  }

  public void testInitWithArrayBuffer() {
    ArrayBuffer arrayBuffer = ArrayBuffer.create(testData.length * numBytes);

    Uint16Array array = Uint16Array.create(arrayBuffer);

    array.set(testData);
    assertIsTestData(array);
  }

  public void testInitWithArrayBufferAndOffset() {
    ArrayBuffer arrayBuffer = ArrayBuffer.create((testData.length + 1) * numBytes);

    Uint16Array array = Uint16Array.create(arrayBuffer, numBytes);

    array.set(testData);
    assertIsTestData(array);
  }

  public void testInitWithArrayBufferAndOffsetAndLength() {
    ArrayBuffer arrayBuffer = ArrayBuffer.create((testData.length + 2) * numBytes);

    Uint16Array array = Uint16Array.create(arrayBuffer, numBytes, testData.length);

    array.set(testData);
    assertIsTestData(array);
  }

  public void testInitWithJavaArray() {
    Uint16Array array = Uint16Array.create(testData);

    assertIsTestData(array);
  }

  public void testInitWithJsArray() {
    Uint16Array array = Uint16Array.create(testDataJsArray());

    assertIsTestData(array);
  }

  public void testInitWithTypedArray() {
    Uint16Array arraySrc = Uint16Array.create(testData);

    Uint16Array array = Uint16Array.create(arraySrc);

    assertIsTestData(array);
  }

  public void testSetJavaArray() {
    Uint16Array array = Uint16Array.create(testData.length);

    array.set(testData);
    assertIsTestData(array);
  }

  public void testSetJavaArrayWithOffset() {
    Uint16Array array = Uint16Array.create(testData.length);

    array.set(testDataPart1);
    array.set(testDataPart2, 4);
    assertIsTestData(array);
  }

  public void testSetJsArray() {
    Uint16Array array = Uint16Array.create(testData.length);

    array.set(testDataJsArray());
    assertIsTestData(array);
  }

  public void testSetJsArrayWithOffset() {
    Uint16Array array = Uint16Array.create(testData.length);

    array.set(testDataJsArrayPart1());
    array.set(testDataJsArrayPart2(), 4);
    assertIsTestData(array);
  }

  public void testSetTypedArray() {
    Uint16Array arraySrc = Uint16Array.create(testData);

    Uint16Array array = Uint16Array.create(testData.length);

    array.set(arraySrc);
    assertIsTestData(array);
  }

  public void testSetTypedArrayWithOffset() {
    Uint16Array arraySrc1 = Uint16Array.create(testDataPart1);
    Uint16Array arraySrc2 = Uint16Array.create(testDataPart2);

    Uint16Array array = Uint16Array.create(testData.length);

    array.set(arraySrc1);
    array.set(arraySrc2, 4);
    assertIsTestData(array);
  }

  public void testSetValues() {
    Uint16Array array = Uint16Array.create(testData.length);

    for (int i = 0; i < testData.length; i++) {
      array.set(i, testData[i]);
    }

    assertIsTestData(array);
  }

  public void testValueRange() {
    Uint16Array array = Uint16Array.create(2);

    array.set(0, 0);
    // 2^16-1
    array.set(1, 65535);

    assertEquals(0, array.get(0));
    assertEquals(65535, array.get(1));
  }

  @DoNotRunWith(Platform.Devel)
  public void testValueRangeProdOnly() {
    Uint16Array array = Uint16Array.create(testDataValueRange());

    assertEquals(65535, array.get(0));
    assertEquals(0, array.get(1));
    assertEquals(65535, array.get(2));
    assertEquals(0, array.get(3));
  }

  private void assertIsTestData(Uint16Array array) {
    assertEquals(testData.length, array.getLength());

    for (int i = 0; i < testData.length; i++) {
      assertEquals(testData[i], array.get(i));
    }
  }
}

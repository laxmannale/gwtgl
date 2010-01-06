/**   
 * Copyright 2009 Sönke Sothmann & Steffen Schäfer
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.googlecode.gwtgl.gen.api;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 
 * Defines that the method is an initializer of the generated JS binding object.
 * The initializer method must have one parameter of type JavaScriptObject which is the
 * object to create the binding for. The initializer method must not have a return type.
 * 
 * @author Steffen Schäfer
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(value={java.lang.annotation.ElementType.TYPE})
public @interface GenConst {
	String typeProperty();
}
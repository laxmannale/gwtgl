/**   
 * Copyright 2009-2010 Sönke Sothmann, Steffen Schäfer and others
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
package com.googlecode.gwtgl.example.client;

import com.google.gwt.canvas.client.Canvas;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.PushButton;
import com.googlecode.gwtgl.binding.WebGLContextAttributes;
import com.googlecode.gwtgl.binding.WebGLCanvas;
import com.googlecode.gwtgl.binding.WebGLRenderingContext;

/**
 * Abstract parent class for the GwtGL examples that creates an launch button
 * and a Canvas to render on.
 * 
 * @author Steffen Schäfer
 * 
 */
public abstract class AbstractGwtGLExample extends FlexTable {

	/** The Canvas to render on. */
	protected final Canvas webGLCanvas;
	/** The Canvas' 3D rendering context. */
	protected final WebGLRenderingContext glContext;

	/**
	 * Constructs a new instance of a GwtGL example with a launch button and a
	 * Canvas to render on.
	 */
	protected AbstractGwtGLExample() {
		// create the button to launch the example
		final PushButton button = new PushButton("Launch example!");
		setWidget(0, 0, button);
		
		// create the WebGL Canvas
		webGLCanvas = Canvas.createIfSupported();
		webGLCanvas.setCoordinateSpaceHeight(500);
		webGLCanvas.setCoordinateSpaceWidth(500);
		glContext = (WebGLRenderingContext) webGLCanvas.getContext("experimental-webgl");
		if(glContext == null) {
			Window.alert("Sorry, Your Browser doesn't support WebGL!");
		}
		glContext.viewport(0, 0, 500, 500);

		setWidget(1, 0, webGLCanvas);

		// add a ClickHandler to start the example when the button is clicked
		button.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				button.setEnabled(false);
				start();
				webGLCanvas.setFocus(true);
			}
		});
	}

	/**
	 * Starts the execution of the example. First the example is initialized
	 * using {@link AbstractGwtGLExample#init()}. After that the rendering loop
	 * is executed with 50 fps. Each frame is rendered using
	 * {@link AbstractGwtGLExample#draw()}.
	 */
	private void start() {
		init();

		Timer timer = new Timer() {
			@Override
			public void run() {
				draw();
			}
		};
		timer.scheduleRepeating(20);

	}

	/**
	 * Initializes the needed resources of the example.
	 */
	protected abstract void init();

	/**
	 * Draws the examle.
	 */
	protected abstract void draw();

}

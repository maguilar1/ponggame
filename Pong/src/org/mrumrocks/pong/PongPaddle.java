package org.mrumrocks.pong;

import jgame.GSprite;
import jgame.ImageCache;
import jgame.controller.ControlScheme;
import jgame.controller.KeyboardLocationController;

public class PongPaddle extends GSprite {

	public PongPaddle(){
		/*
		ImageCache cache = ImageCache.forClass(Pong.class);
		Image paddle = cache.get("paddle.png");
		super(paddle);
		*/
		super(ImageCache.forClass(Pong.class).get("paddle.png"));
		
		// Create a keyboard movement controller.
		KeyboardLocationController klc = new KeyboardLocationController(
		        ControlScheme.WASD, 10);

		// Add the new controller.
		addController(klc);
		// Disable horizontal movement.
		klc.setHorizontalAllowed(false);
	}
}

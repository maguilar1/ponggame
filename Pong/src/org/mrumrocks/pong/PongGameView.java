package org.mrumrocks.pong;

import jgame.GContainer;

public class PongGameView extends GContainer {

	public PongGameView () {
        setSize(640, 480);
        
        PongPaddle paddle = new PongPaddle();
        add(paddle);
        paddle.setLocation(50, 480 / 2);
        
        PongPuck puck = new PongPuck();
		addAtCenter(puck);
        
	}
}

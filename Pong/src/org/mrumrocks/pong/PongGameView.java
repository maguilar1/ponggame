package org.mrumrocks.pong;

import java.util.List;

import jgame.Context;
import jgame.GContainer;
import jgame.GObject;
import jgame.controller.ControlScheme;
import jgame.listener.FrameListener;
import org.mrumrocks.pong.Pong.View;
public class PongGameView extends GContainer {

	public PongGameView () {
        setSize(640, 480);
        
        PongPaddle paddle = new PongPaddle(ControlScheme.WASD);
        add(paddle);
        paddle.setLocation(50, 480 / 2);
        
        PongPuck puck = new PongPuck();
		addAtCenter(puck);
        
		PongPaddle paddle2 = new PongPaddle(ControlScheme.IJKL);
		add(paddle2);
		paddle2.setLocation(640 - 50, 480 / 2);
		
		FrameListener fl = new FrameListener() {

		
		    public void invoke(GObject target, Context context) {
		       
		        List<PongPuck> pucks = context.getInstancesOfClass(PongPuck.class);

		        
		        boolean noPucksLeft = pucks.isEmpty();
		      
		       {
		    	   context.setCurrentGameView(Pong.View.GAME_OVER);
		       }
		       
		    }
		   
		};
	}
	
	
}
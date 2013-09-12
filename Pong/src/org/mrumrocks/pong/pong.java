package org.mrumrocks.pong;

import java.awt.Color;

import jgame.GRootContainer;
import jgame.Game;

public class pong extends Game {
	
	public enum View{
		GAME, GAME_OVER;
	}

	public static void main(String[] args)
	{
		
	}
	
	public pong()
	{
	GRootContainer root = new GRootContainer(Color.BLACK);
	setRootContainer(root);
	
	PongGameView gameView = new PongGameView();
	root.addView(View.GAME, gameView);
	
	}
	
	
}

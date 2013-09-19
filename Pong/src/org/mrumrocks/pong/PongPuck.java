package org.mrumrocks.pong;

import jgame.Context;
import jgame.GObject;
import jgame.GSprite;
import jgame.ImageCache;
import jgame.controller.ConstantMovementController;
import jgame.listener.BoundaryRemovalListener;
import jgame.listener.HitTestListener;

public class PongPuck extends GSprite 
{
	private ConstantMovementController cmc;

	public PongPuck ()
	{
		super(ImageCache.forClass(Pong.class).get("puck.png"));

		cmc = new ConstantMovementController(-5, 0);

		addController(cmc);

		

		addListener(new BoundaryRemovalListener());

		HitTestListener htl = new HitTestListener(PongPaddle.class)
		{
			
			
			public void invoke(GObject target, Context context) 
			{
				flip();
			}
		};
		
		addListener(htl);
		
		setPrimitive(PrimitiveShape.CIRCLE);
	}
	public void flip ()
	{
		cmc.setVelocityX(-cmc.getVelocityX());
	}



}

package org.mrumrocks.pong;

import java.util.List;

import jgame.Context;
import jgame.GObject;
import jgame.GSprite;
import jgame.ImageCache;
import jgame.controller.ConstantMovementController;
import jgame.listener.BoundaryRemovalListener;
import jgame.listener.HitTestListener;
import jgame.listener.ParentBoundsListener;

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
			//ParentBoundsListener bounce = new ParentBoundsListener() {
			
			public void invoke(GObject target, Context context) 
			{
				flip();
				
				List<PongPaddle> paddlesHit = context.hitTestClass(PongPaddle.class);
				double offset = getY() - context.hitTestClass(PongPaddle.class).get(0).getY();
			    cmc.setVelocityY(cmc.getVelocityY() + offset * 0.1);
			   
			    ParentBoundsListener bounce = new ParentBoundsListener() {
			        
			        public void invoke(GObject target, Context context) {
			            cmc.setVelocityY(-cmc.getVelocityY());
			        }
			    };

			    
			    bounce.setValidateHorizontal(false);

			  
			    addListener(bounce);

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

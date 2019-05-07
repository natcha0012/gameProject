package sharedObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javafx.scene.image.Image;
import javafx.scene.media.AudioClip;
import logic.Field;
import logic.Enemy;
import logic.Hero;

public class RenderableHolder {
	private static final RenderableHolder instance = new RenderableHolder();
	
	private List<IRenderable> entities;
	private Comparator<IRenderable> comparator;
	public static Image mapSprite;				//not finish + edit load resources
	public static Image mineSprite;				//not finish + edit load resources 
	public static AudioClip slashSound;			//not finish + edit load resources
	public static AudioClip gameoverSound;		//not finish + edit load resources
	public static AudioClip backgroundSound;	//not finish
	
	static {
		loadResource();
	}
	
	public RenderableHolder() {
		entities = new ArrayList<IRenderable>();
		comparator = (IRenderable o1, IRenderable o2) -> {
			if (o1.getZ() > o2.getZ())
				return 1;
			return -1;
		};
	}
	
	public static RenderableHolder getInstance() {
		return instance;
	}

	public static void loadResource() {			//not finish + edit load resources(picture)
		mapSprite = new Image(ClassLoader.getSystemResource("Map.png").toString());
		mineSprite = new Image(ClassLoader.getSystemResource("Mine.png").toString());
		slashSound = new AudioClip(ClassLoader.getSystemResource("Slash.wav").toString());
		gameoverSound = new AudioClip(ClassLoader.getSystemResource("Gameover.wav").toString());
		backgroundSound = new AudioClip(ClassLoader.getSystemResource("Background.mp3").toString());
	}
	
	public void add(IRenderable entity) {
		System.out.println("add");
		entities.add(entity);
		Collections.sort(entities, comparator);
		for(IRenderable x: entities){
			if(x instanceof Hero) System.out.println("hero");
			if(x instanceof Enemy) System.out.println("enemy");
			if(x instanceof Field) System.out.println("field");
			
		}
	}
	
	public void update() {
		for (int i = entities.size() - 1; i >= 0; i--) {
			if (entities.get(i).isDestroyed())
				entities.remove(i);
		}
	}
	
	public List<IRenderable> getEntities() {
		return entities;
	}
}

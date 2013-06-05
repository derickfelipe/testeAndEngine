package com.example.teste2;

import org.andengine.engine.Engine;
import org.andengine.engine.camera.Camera;
import org.andengine.opengl.texture.TextureOptions;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlas;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlasTextureRegionFactory;
import org.andengine.opengl.texture.region.ITextureRegion;
import org.andengine.opengl.vbo.VertexBufferObjectManager;

import com.example.teste2.GameActivity;

public class ResourcesManager {

	private static final ResourcesManager INSTANCE = new ResourcesManager();
	
	public Engine engine;
	public GameActivity activity;
	public Camera camera;
	public VertexBufferObjectManager vbom;
	
	public ITextureRegion splash_region;
	private BitmapTextureAtlas splashTextureAtlas;
	
	public void loadMenuResources(){
		loadMenuGraphics();
		loadMenuAudio();
	}
	
	public void loadGameResources(){
		loadGameGraphics();
		loadGameFonts();
		loadGameAudio();
	}
	
	public void loadMenuGraphics(){
		
	}
	
	public void loadMenuAudio(){
		
	}
	
	public void loadGameGraphics(){
		
	}
	
	public void loadGameFonts(){
		
	}
	
	public void loadGameAudio(){
		
	}
	
	public void loadSplashScreen(){
		
		BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("gfx/");
		splashTextureAtlas = new BitmapTextureAtlas(activity.getTextureManager(), 256, 256, TextureOptions.BILINEAR);
		splash_region = BitmapTextureAtlasTextureRegionFactory.createFromAsset(splashTextureAtlas, activity, "splash.png", 0, 0);
		splashTextureAtlas.load();
		
		
	}
	
	public void unloadSplashScreen(){
		splashTextureAtlas.unload();
		splash_region = null;
		
	}
	
	public static void prepareManager(Engine engine, GameActivity activity, Camera camera, VertexBufferObjectManager vbom){
		getInstance().engine = engine;
		getInstance().activity = activity;
		getInstance().camera = camera;
		getInstance().vbom = vbom;
		
	}
	
	public static ResourcesManager getInstance(){
		return INSTANCE;
	}
	
}

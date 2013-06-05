package com.example.teste2;

import org.andengine.engine.Engine;
import org.andengine.ui.IGameInterface.OnCreateSceneCallback;

//import com.example.teste2.base.BaseScene;

public class SceneManager {
	
	private BaseScene splashScene;
	private BaseScene menuScene;
	private BaseScene gameScene;
	private BaseScene loadingScene;
	
	private static final SceneManager INSTANCE = new SceneManager();
	
	private SceneType currentSceneType = SceneType.SCENE_SPLASH;
	
	private BaseScene currentScene;
	
	private Engine engine = ResourcesManager.getInstance().engine;
	
	public enum SceneType {
		SCENE_SPLASH,
		SCENE_MENU,
		SCENE_GAME,
		SCENE_LOADING,
	}
	
	public void setScene(BaseScene scene) {
		engine.setScene(scene);
		currentScene = scene;
		currentSceneType = scene.getSceneType();
	}
	
	public void setScene(SceneType sceneType) {
		switch (sceneType) {
		case SCENE_MENU:
			setScene(menuScene);
			break;
		case SCENE_GAME:
			setScene(gameScene);
			break;
		case SCENE_SPLASH:
			//setScene(splashScreen);
			break;
		case SCENE_LOADING:
		//	setScene(loadingScreen);
			break;
		default:
			break;
		}
	}
	
	public static SceneManager getInstance() {
		return INSTANCE;
	}
	
	public SceneType getCurrentSceneType() {
		return currentSceneType;
	}
	
	public BaseScene getCurrentScene() {
		return currentScene;
	}

	public BaseScene getSplashScene() {
		return splashScene;
	}
	
	public void createSplashScene(OnCreateSceneCallback pOnCreateSceneCallback)
	{
	    ResourcesManager.getInstance().loadSplashScreen();
	    splashScene = new SplashScene();
	    currentScene = splashScene;
	    pOnCreateSceneCallback.onCreateSceneFinished(splashScene);
	}
	
	private void disposeSplashScene()
	{
	    ResourcesManager.getInstance().unloadSplashScreen();
	    splashScene.disposeScene();
	    splashScene = null;
	}
	
	// GETTERS e SETTERS gerados automaticamente

	public void setSplashScene(BaseScene splashScene) {
		this.splashScene = splashScene;
	}

	public BaseScene getLoadingScene() {
		return loadingScene;
	}

	public void setLoadingScene(BaseScene loadingScene) {
		this.loadingScene = loadingScene;
	}

}

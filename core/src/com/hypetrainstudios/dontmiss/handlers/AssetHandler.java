package com.hypetrainstudios.dontmiss.handlers;

import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class AssetHandler {
	public static final AssetManager manager = new AssetManager();

	public static final AssetDescriptor<Texture> imgTurretLayout = new AssetDescriptor<Texture>("turretLayout.png", Texture.class);
	
	
	public static final AssetDescriptor<Texture> imgTurret = new AssetDescriptor<Texture>("turret/turret.png", Texture.class);
	public static final AssetDescriptor<Texture> imgTurretShield = new AssetDescriptor<Texture>("turret/turretShield.png", Texture.class);
	public static final AssetDescriptor<Texture> imgShield = new AssetDescriptor<Texture>("turret/shield.png", Texture.class);
	
	public static final AssetDescriptor<Texture> imgProjectileRed = new AssetDescriptor<Texture>("projectileRed.png", Texture.class);
	public static final AssetDescriptor<Texture> imgProjectileBlue = new AssetDescriptor<Texture>("projectileBlue.png", Texture.class);
	public static final AssetDescriptor<Texture> imgProjectileYellow = new AssetDescriptor<Texture>("projectileYellow.png", Texture.class);

	public static final AssetDescriptor<Texture> imgEnemyRed = new AssetDescriptor<Texture>("enemyRed.png", Texture.class);
	public static final AssetDescriptor<Texture> imgEnemyBlue = new AssetDescriptor<Texture>("enemyBlue.png", Texture.class);
	public static final AssetDescriptor<Texture> imgEnemyYellow = new AssetDescriptor<Texture>("enemyYellow.png", Texture.class);
	public static final AssetDescriptor<Texture> imgTank = new AssetDescriptor<Texture>("enemies/tank.png", Texture.class);
	
	public static final AssetDescriptor<Texture> imgMiscSpikes = new AssetDescriptor<Texture>("bonus/miscSpikes.png", Texture.class);
	public static final AssetDescriptor<Texture> imgMiscLandMine = new AssetDescriptor<Texture>("bonus/miscLandmine.png", Texture.class);
	
	public static final AssetDescriptor<Texture> imgTintBG = new AssetDescriptor<Texture>("tintBG.png", Texture.class);
	
	public static final AssetDescriptor<TextureAtlas> atlasButtons = new AssetDescriptor<TextureAtlas>("buttons/buttons.pack", TextureAtlas.class);
	public static final AssetDescriptor<TextureAtlas> atlasReload = new AssetDescriptor<TextureAtlas>("reload/reload.pack", TextureAtlas.class);
	public static final AssetDescriptor<TextureAtlas> atlasBonuses = new AssetDescriptor<TextureAtlas>("bonus/bonus.pack", TextureAtlas.class);
	
	public static final AssetDescriptor<BitmapFont> fontPlay = new AssetDescriptor<BitmapFont>("playFont/play.fnt", BitmapFont.class);
	
	
	
	
	public static final AssetDescriptor<Texture> mainMenuBG = new AssetDescriptor<Texture>("backgrounds/mainMenuBG.png", Texture.class);
	public static final AssetDescriptor<Texture> playMenuBG = new AssetDescriptor<Texture>("backgrounds/playMenuBG.png", Texture.class);
	public static final AssetDescriptor<Texture> inGameBG = new AssetDescriptor<Texture>("backgrounds/inGameBG.png", Texture.class);
	
	public static void load(){
		manager.load(imgTurretLayout);
		manager.load(imgTurret);
		manager.load(imgTurretShield);
		manager.load(imgShield);
		
		manager.load(imgProjectileRed);
		manager.load(imgProjectileBlue);
		manager.load(imgProjectileYellow);

		manager.load(imgEnemyRed);
		manager.load(imgEnemyBlue);
		manager.load(imgEnemyYellow);
		manager.load(imgTank);
		
		manager.load(imgMiscSpikes);
		manager.load(imgMiscLandMine);
		
		manager.load(imgTintBG);
		
		manager.load(atlasButtons);
		manager.load(atlasReload);
		manager.load(atlasBonuses);
		
		
		manager.load(fontPlay);
		
		manager.load(mainMenuBG);
		manager.load(inGameBG);
		manager.load(playMenuBG);
	}

	public static void setTextures(){
		manager.get(imgTurretLayout).setFilter(TextureFilter.Linear,TextureFilter.Linear);
		manager.get(imgTurret).setFilter(TextureFilter.Linear, TextureFilter.Linear);
		manager.get(imgTurretShield).setFilter(TextureFilter.Linear, TextureFilter.Linear);
		manager.get(imgShield).setFilter(TextureFilter.Linear, TextureFilter.Linear);
		
		manager.get(imgProjectileRed).setFilter(TextureFilter.Linear,TextureFilter.Linear);
		manager.get(imgProjectileBlue).setFilter(TextureFilter.Linear,TextureFilter.Linear);
		manager.get(imgProjectileYellow).setFilter(TextureFilter.Linear,TextureFilter.Linear);
		
		manager.get(imgEnemyRed).setFilter(TextureFilter.Linear,TextureFilter.Linear);
		manager.get(imgEnemyBlue).setFilter(TextureFilter.Linear,TextureFilter.Linear);
		manager.get(imgEnemyYellow).setFilter(TextureFilter.Linear,TextureFilter.Linear);
		manager.get(imgTank).setFilter(TextureFilter.Linear,TextureFilter.Linear);
		
		manager.get(imgMiscSpikes).setFilter(TextureFilter.Linear,TextureFilter.Linear);
		manager.get(imgMiscLandMine).setFilter(TextureFilter.Linear,TextureFilter.Linear);
		
		manager.get(imgTintBG).setFilter(TextureFilter.Linear,TextureFilter.Linear);
		
		manager.get(mainMenuBG).setFilter(TextureFilter.Linear, TextureFilter.Linear);
		manager.get(inGameBG).setFilter(TextureFilter.Linear, TextureFilter.Linear);
		manager.get(playMenuBG).setFilter(TextureFilter.Linear, TextureFilter.Linear);
	}

	public static void dispose(){
		manager.dispose();
	}
}

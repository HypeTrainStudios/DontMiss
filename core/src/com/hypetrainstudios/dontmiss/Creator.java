package com.hypetrainstudios.dontmiss;

import java.util.ArrayList;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation.PlayMode;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.hypetrainstudios.dontmiss.bonuses.BonusEffect;
import com.hypetrainstudios.dontmiss.bonuses.CollateralProjectilesBonus;
import com.hypetrainstudios.dontmiss.bonuses.ExplosiveProjectilesBonus;
import com.hypetrainstudios.dontmiss.bonuses.LandMineBonus;
import com.hypetrainstudios.dontmiss.bonuses.MultipleProjectilesBonus;
import com.hypetrainstudios.dontmiss.bonuses.NukeBonus;
import com.hypetrainstudios.dontmiss.bonuses.SheildBonus;
import com.hypetrainstudios.dontmiss.bonuses.SlowEnemyBonus;
import com.hypetrainstudios.dontmiss.bonuses.SpikeBonus;
import com.hypetrainstudios.dontmiss.challenges.Challenge;
import com.hypetrainstudios.dontmiss.enemies.EnemyType;
import com.hypetrainstudios.dontmiss.entity.Bonus;
import com.hypetrainstudios.dontmiss.entity.Enemy;
import com.hypetrainstudios.dontmiss.entity.Misc;
import com.hypetrainstudios.dontmiss.entity.Projectile;
import com.hypetrainstudios.dontmiss.entity.Turret;
import com.hypetrainstudios.dontmiss.handlers.AssetHandler;
import com.hypetrainstudios.dontmiss.handlers.BonusHandler;
import com.hypetrainstudios.dontmiss.handlers.ChallengeHandler;
import com.hypetrainstudios.dontmiss.handlers.InGameUIHandler;
import com.hypetrainstudios.dontmiss.handlers.SpawnHandler;


public class Creator {
	
	public static float projectileSpeed = 35f;
	public static float enemySpeed = .05f;
	public static float turretRotationSpeed = 155f;
	public static int totalProjectiles = 5;
	
	public static float gameTime = 180;
	public static boolean gameOver = false;
	
	public static float spawnWaveRate = 7;
	public static float spawnWaveCounter = 7;
	public static final float spawnRateMax = 7f,spawnRateMin = 4f;
	
	public static float fireRate = .8f;
	public static final float  fireRateMin = .3f,fireRateMax = 3f;
	public static float fireRateCounter = .8f;
	
	public static ArrayList<Challenge> challenges = new ArrayList<Challenge>();
	public static ArrayList<BonusEffect> bonusTypes = new ArrayList<BonusEffect>();
	public static ArrayList<EnemyType> enemyTypes = new ArrayList<EnemyType>();
	public static ArrayList<Enemy> enemies = new ArrayList<Enemy>();
	public static ArrayList<Projectile> projectiles = new ArrayList<Projectile>();
	public static ArrayList<Misc> misc = new ArrayList<Misc>();
	public static ArrayList<Bonus> bonuses = new ArrayList<Bonus>();
	public static Turret midTurret = new Turret(new Sprite(AssetHandler.manager.get(AssetHandler.imgTurretLayout)),turretRotationSpeed);
	
	
	
	public static void createMiscProjectileLoading(){
		Misc reloadingProjectileMisc = new Misc(new Sprite(AssetHandler.manager.get(AssetHandler.atlasLoadingProjBlue).findRegion("loadingProjBlue")),"reloadingProjectileBlue");
		reloadingProjectileMisc.setCenter(Gdx.graphics.getWidth()/2, Gdx.graphics.getHeight()/2);
		reloadingProjectileMisc.createLivingAnimation(30, AssetHandler.manager.get(AssetHandler.atlasLoadingProjBlue).findRegions("loadingProjBlue"), PlayMode.NORMAL,true);
		
		misc.add(reloadingProjectileMisc);
	}
	public static void createProjectile(){
		if(fireRateCounter >= fireRate){
			fireRateCounter = 0;
			if(BonusHandler.currentBonus==5){
				projectiles.add(new Projectile(new Sprite(AssetHandler.manager.get(AssetHandler.imgProjectileBlue)), projectileSpeed,midTurret.getRotationCounter()+(90)));
				projectiles.add(new Projectile(new Sprite(AssetHandler.manager.get(AssetHandler.imgProjectileBlue)), projectileSpeed,midTurret.getRotationCounter()-(90)));
			}
			projectiles.add(new Projectile(new Sprite(AssetHandler.manager.get(AssetHandler.imgProjectileBlue)), projectileSpeed));
		}
	}
	public static void createEnemy(float degrees){
			enemies.add(new Enemy(new Sprite(AssetHandler.manager.get(AssetHandler.imgEnemyBlue)),midTurret.getSprite(),enemySpeed,degrees));
	}
	public static void createBonus(int bonusType){
		if(bonusType==0)	bonuses.add(new Bonus(new Sprite(AssetHandler.manager.get(AssetHandler.atlasBonuses).findRegion("bonusAlly"))));
		else if(bonusType==1)	bonuses.add(new Bonus(new Sprite(AssetHandler.manager.get(AssetHandler.atlasBonuses).findRegion("bonusAssassin"))));
		else if(bonusType==2)	bonuses.add(new Bonus(new Sprite(AssetHandler.manager.get(AssetHandler.atlasBonuses).findRegion("bonusBigger"))));
		else if(bonusType==3)	bonuses.add(new Bonus(new Sprite(AssetHandler.manager.get(AssetHandler.atlasBonuses).findRegion("bonusCollateral"))));
		else if(bonusType==4)	bonuses.add(new Bonus(new Sprite(AssetHandler.manager.get(AssetHandler.atlasBonuses).findRegion("bonusExplosive"))));
		else if(bonusType==5)	bonuses.add(new Bonus(new Sprite(AssetHandler.manager.get(AssetHandler.atlasBonuses).findRegion("bonusLandMine"))));
		else if(bonusType==6)	bonuses.add(new Bonus(new Sprite(AssetHandler.manager.get(AssetHandler.atlasBonuses).findRegion("bonusMultiples"))));
		else if(bonusType==7)	bonuses.add(new Bonus(new Sprite(AssetHandler.manager.get(AssetHandler.atlasBonuses).findRegion("bonusNuke"))));
		else if(bonusType==8)	bonuses.add(new Bonus(new Sprite(AssetHandler.manager.get(AssetHandler.atlasBonuses).findRegion("bonusSheild"))));
		else if(bonusType==9)	bonuses.add(new Bonus(new Sprite(AssetHandler.manager.get(AssetHandler.atlasBonuses).findRegion("bonusSlow"))));
		else if(bonusType==10)	bonuses.add(new Bonus(new Sprite(AssetHandler.manager.get(AssetHandler.atlasBonuses).findRegion("bonusSpikes"))));

	}
	public static void setUp(){
		bonusTypes.add(new CollateralProjectilesBonus());
		bonusTypes.add(new ExplosiveProjectilesBonus());
		bonusTypes.add(new LandMineBonus());
		bonusTypes.add(new MultipleProjectilesBonus());
		bonusTypes.add(new NukeBonus());
		bonusTypes.add(new SheildBonus());
		bonusTypes.add(new SlowEnemyBonus());
		bonusTypes.add(new SpikeBonus());
		
		createMiscProjectileLoading();
		InGameUIHandler.createUI();
		BonusHandler.createChances();
	}
	
	
	public static void reset(){
		gameOver = false;
		SpawnHandler.spawn = true;
		challenges.clear();
		enemies.clear();
		projectiles.clear();
		enemyTypes.clear();
		bonusTypes.clear();
		misc.clear();
		bonuses.clear();
		
		gameTime = 180;
		spawnWaveRate = 7f;
		spawnWaveCounter = 7f;
		fireRate = .8f;
		fireRateCounter = .8f;
		turretRotationSpeed = 155f;
		projectileSpeed = 35f;
		enemySpeed = .05f;
		totalProjectiles = 5;
		
		midTurret.setRotationSpeed(turretRotationSpeed);
		midTurret.getSprite().setRotation(270);
		midTurret.setRotationCounter(0);
		midTurret.getSprite().setAlpha(1);
		
		createMiscProjectileLoading();
		
		ChallengeHandler.challengeCounter = 0;
	}
	
	
	
}

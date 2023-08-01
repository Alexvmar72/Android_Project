package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.g1.Main;
import com.mygdx.game.g1.units.ArbalesterUnit;
import com.mygdx.game.g1.units.BaseUnit;
import com.mygdx.game.g1.units.CountrymanUnit;
import com.mygdx.game.g1.units.MagicianUnit;
import com.mygdx.game.g1.units.MonkUnit;
import com.mygdx.game.g1.units.RobberUnit;
import com.mygdx.game.g1.units.SharpshooterUnit;
import com.mygdx.game.g1.units.SpearmanUnit;

import java.util.Random;

public class MyGdxGame extends ApplicationAdapter {
	SpriteBatch batch;
	Texture fon, crossBowMan, mage, monk, peasant, rouge, sniper, spearMan;
	Main game;
	Music music;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		fon = new Texture("fon/"+Fons.values()[new Random().nextInt(Fons.values().length)]+".png");
		game = new Main();
		game.main();
		music = Gdx.audio.newMusic(Gdx.files.internal("music/paul-romero-rob-king-combat-theme-0"+(new Random().nextInt(4)+1)+".mp3"));
		music.setLooping(true);
		music.setVolume(0.125f);
		music.play();
		crossBowMan = new Texture("pers/CrossBowMan.png");
		mage = new Texture("pers/Mage.png");
		monk = new Texture("pers/Monk.png");
		peasant = new Texture("pers/Peasant.png");
		rouge = new Texture("pers/Rouge.png");
		sniper = new Texture("pers/Sniper.png");
		spearMan = new Texture("pers/SpearMan.png");

	}

	@Override
	public void render () {
		game.run();
		ScreenUtils.clear(1, 0, 0, 1);
		int kx=Gdx.graphics.getWidth()/12;
		int ky=Gdx.graphics.getHeight()/15;
		batch.begin();
		batch.draw(fon, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		for (BaseUnit unit: game.teamAll){
			int mx=1;
			if (unit instanceof ArbalesterUnit) batch.draw(crossBowMan, unit.getCoords()[0]*kx*mx,unit.getCoords()[1]*ky);
			if (unit instanceof MagicianUnit) batch.draw(mage, unit.getCoords()[0]*kx*mx,unit.getCoords()[1]*ky);
			if (unit instanceof MonkUnit) batch.draw(monk, unit.getCoords()[0]*kx*mx,unit.getCoords()[1]*ky);
			if (unit instanceof CountrymanUnit) batch.draw(peasant, unit.getCoords()[0]*kx*mx,unit.getCoords()[1]*ky);
			if (unit instanceof RobberUnit) batch.draw(rouge, unit.getCoords()[0]*kx*mx,unit.getCoords()[1]*ky);
			if (unit instanceof SharpshooterUnit) batch.draw(sniper, unit.getCoords()[0]*kx*mx,unit.getCoords()[1]*ky);
			if (unit instanceof SpearmanUnit) batch.draw(spearMan, unit.getCoords()[0]*kx*mx,unit.getCoords()[1]*ky);
		}
		batch.draw(crossBowMan, 0, 0);
		batch.draw(mage, 0, 0);
		batch.draw(monk, 0, 0);
		batch.draw(peasant, 0, 0);
		batch.draw(rouge, 0, 0);
		batch.draw(sniper, 0, 0);
		batch.draw(spearMan, 0, 0);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		fon.dispose();
		crossBowMan.dispose();
		mage.dispose();
		monk.dispose();
		peasant.dispose();
		rouge.dispose();
		sniper.dispose();
		spearMan.dispose();
	}
}

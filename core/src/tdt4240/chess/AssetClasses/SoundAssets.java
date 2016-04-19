package tdt4240.chess.AssetClasses;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;

import tdt4240.chess.Utility.Options;

public class SoundAssets {

    public static Sound moveChessmanSound;
    public static Sound backgroundMusic;
    public static Sound hitmarkerSound;
    public static Sound victorySound;
    public static Sound rifleSound;
    public static Music technoBackgroundMusic;
    //public static Sound menuMusic;
    public static Music menuMusic;

    public static void loadSounds() {
        moveChessmanSound = Gdx.audio.newSound(Gdx.files.internal("sounds/moveChessmanSound.mp3"));
        backgroundMusic = Gdx.audio.newSound(Gdx.files.internal("sounds/dankTune.mp3"));
        hitmarkerSound = Gdx.audio.newSound(Gdx.files.internal("sounds/hitmarker.wav"));
        //menuMusic = Gdx.audio.newSound(Gdx.files.internal("sounds/menuMusic.mp3"));
        menuMusic = Gdx.audio.newMusic(Gdx.files.internal("sounds/menuMusic.mp3"));
        victorySound = Gdx.audio.newSound(Gdx.files.internal("sounds/victorySound.mp3"));
        rifleSound = Gdx.audio.newSound(Gdx.files.internal("sounds/rifleSound.mp3"));
        technoBackgroundMusic = Gdx.audio.newMusic(Gdx.files.internal("sounds/technoBackgroundMusic.mp3"));
    }

    public static void playMoveChessmanSound() {
        if (Options.SFX_ENABLED) {
            moveChessmanSound.play(1.0f);
        }
    }
    public static void playBackgroundMusic() {
        if (Options.MUSIC_ENABLED) {
            technoBackgroundMusic.play();
            technoBackgroundMusic.setLooping(true);
        }
    }
    public static void stopPlayingBackgroundMusic() {
        if (Options.MUSIC_ENABLED) {
            backgroundMusic.stop();
        }
    }
    public static void playAttackChessmanSound() {
        if (Options.SFX_ENABLED) {
            hitmarkerSound.play(1.0f);
        }
    }
    public static void playMenuMusic() {
        if (Options.MUSIC_ENABLED) {
            menuMusic.play();
            menuMusic.setLooping(true);
            menuMusic.setVolume(1.0f);

        }
    }
    public static void stopMenuMusic() {
        menuMusic.stop();
    }
    public static void stopAllMusic() {
        //menuMusic.setLooping(false);
        menuMusic.pause();
        technoBackgroundMusic.pause();
    }

    public static void playVictorySound() {
        victorySound.play(1.0f);
    }
    public static void playRifleSound() {
        rifleSound.play(1.0f);
    }

}

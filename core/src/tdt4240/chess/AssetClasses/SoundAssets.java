package tdt4240.chess.AssetClasses;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;

import tdt4240.chess.Models.Options;

public class SoundAssets {

    public static Sound moveChessmanSound;
    public static Sound backgroundMusic;
    public static Sound hitmarkerSound;
    public static Sound menuMusic;

    public static void loadSounds() {
        moveChessmanSound = Gdx.audio.newSound(Gdx.files.internal("sounds/moveChessmanSound.mp3"));
        backgroundMusic = Gdx.audio.newSound(Gdx.files.internal("sounds/dankTune.mp3"));
        hitmarkerSound = Gdx.audio.newSound(Gdx.files.internal("sounds/hitmarker.wav"));
        menuMusic = Gdx.audio.newSound(Gdx.files.internal("sounds/menuMusic.mp3"));
    }

    public static void playMoveChessmanSound() {
        if (Options.SFX_ENABLED) {
            moveChessmanSound.play(1.0f);
        }

    }
    public static void playBackgroundMusic() {
        if (Options.MUSIC_ENABLED) {
            backgroundMusic.loop(1.0f);
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
            menuMusic.loop(1.0f);
        }
    }
    public static void stopMenuMusic() {
        menuMusic.stop();
    }
    public static void stopAllMusic() {
        menuMusic.stop();
        backgroundMusic.stop();
    }

}

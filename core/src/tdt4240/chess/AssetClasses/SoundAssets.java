package tdt4240.chess.AssetClasses;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;

import tdt4240.chess.Models.Options;

public class SoundAssets {

    public static Sound moveChessmanSound;
    public static Sound backgroundMusic;

    public static void loadSounds() {
        moveChessmanSound = Gdx.audio.newSound(Gdx.files.internal("sounds/moveChessmanSound.mp3"));
        backgroundMusic = Gdx.audio.newSound(Gdx.files.internal("sounds/dankTune.mp3"));
    }

    public static void moveChessman() {
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

}

package tdt4240.chess.AssetClasses;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;

public class SoundAssets {

    public static Sound moveChessmanSound;
    public static Sound backgroundMusic;

    public static void loadSounds() {
        moveChessmanSound = Gdx.audio.newSound(Gdx.files.internal("sounds/moveChessmanSound.mp3"));
        backgroundMusic = Gdx.audio.newSound(Gdx.files.internal("sounds/dankTune.mp3"));
    }

    public static void moveChessman() {
        moveChessmanSound.play(1.0f);
    }
    public static void playBackgroundMusic() {
        backgroundMusic.loop(1.0f);
    }
    public static void stopPlayingBackgroundMusic() {
        backgroundMusic.stop();
    }

}

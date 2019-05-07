package services;

import java.io.*;
import javax.sound.sampled.*;

public class MyPlayer {

    private Long currentFrame;
    private Clip clip;
    private AudioInputStream ais;
    private String filePath;

    public MyPlayer(String filePath)
            throws UnsupportedAudioFileException, LineUnavailableException,
            IOException {
        ais = AudioSystem.getAudioInputStream(new File(filePath).getAbsoluteFile());
        clip = AudioSystem.getClip();
        clip.open(ais);
    }

    public void play() {
        clip.start();
    }

    public void pause() {}

    public void resume() {}

    public void stop() {
        clip.stop();
    }

    public void reset() {}

}
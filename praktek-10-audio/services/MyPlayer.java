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
        this.filePath = filePath;
        reset();
    }

    public void play()
            throws UnsupportedAudioFileException, LineUnavailableException,
            IOException {
        reset();
        clip.start();
    }

    public void pause() {
        clip.stop();
        currentFrame = clip.getMicrosecondPosition();
        clip.close();
    }

    public void resume()
            throws UnsupportedAudioFileException, LineUnavailableException,
            IOException {
        reset();
        clip.setMicrosecondPosition(currentFrame);
        clip.start();
    }

    public void stop() {
        clip.stop();
        clip.close();
    }

    public void reset()
            throws UnsupportedAudioFileException, LineUnavailableException,
            IOException {
        ais = AudioSystem.getAudioInputStream(new File(filePath).getAbsoluteFile());
        clip = AudioSystem.getClip();
        clip.open(ais);
    }

}
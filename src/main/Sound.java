package main;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.net.URL;

public class Sound {
    Clip clip;
    URL[] url = new URL[20];

    public Sound() {
        url[0]= getClass().getResource("/sound/unlock.wav");
        url[1]= getClass().getResource("/sound/yeah_boi.wav");
        url[2]= getClass().getResource("/sound/win.wav");
        url[3]= getClass().getResource("/sound/theme.wav");
        url[4]= getClass().getResource("/sound/key_acquired.wav");
    }

    public void setFile(int i){
        try {
            AudioInputStream ais = AudioSystem.getAudioInputStream(url[i]);
            clip = AudioSystem.getClip();
            clip.open(ais);
        } catch (Exception e) {

        }
    }
    public void play(){
        clip.start();
    }

    public void stop(){
        clip.stop();
    }
    public void loop() {
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }
}

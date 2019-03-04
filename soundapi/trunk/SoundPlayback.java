/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package soundapi;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.Line;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineListener;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 *
 * @author S105_ANSHUL
 */
public class SoundPlayback extends Thread implements LineListener{
    
    Line.Info lineinfo;
    Clip clip;

    public SoundPlayback(Line.Info lineinfo) {
        this.lineinfo = lineinfo;
    }
    
    @Override
    public void run() {
        try {
            File audioFile = new File("sample2.wav");
            clip = (Clip) AudioSystem.getLine(this.lineinfo);
            clip.addLineListener(this);
            AudioInputStream ais = AudioSystem.getAudioInputStream(audioFile);
            clip.open(ais);
            clip.start();
            Thread.sleep(10000);
            
        } catch (LineUnavailableException ex) {
            Logger.getLogger(SoundPlayback.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedAudioFileException ex) {
            Logger.getLogger(SoundPlayback.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SoundPlayback.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(SoundPlayback.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void stopPlayback() {
        clip.stop();
        clip.close();
    }

    @Override
    public void update(LineEvent event) {
        LineEvent.Type typeEvent = event.getType();
        if(typeEvent==LineEvent.Type.STOP){
            SoundApiFrame.btnPlay.setText("Play");
        }
        
    }
}

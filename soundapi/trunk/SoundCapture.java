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
import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Line;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.TargetDataLine;

/**
 *
 * @author S105_ANSHUL
 */
public class SoundCapture extends Thread {

    Line.Info lineinfo;
    TargetDataLine targetline;

    public SoundCapture(Line.Info lineinfo) {
        this.lineinfo = lineinfo;
    }

    @Override
    public void run() {
        try {

            targetline = (TargetDataLine) AudioSystem.getLine(lineinfo);
            targetline.open(getAudioFormat());
            targetline.start();
            AudioInputStream audioinputstream = new AudioInputStream(targetline);
            System.out.println("Capturing Started");
            AudioSystem.write(audioinputstream, AudioFileFormat.Type.WAVE, new File("rec.wav"));
        } catch (IOException | LineUnavailableException ex) {
            Logger.getLogger(Capture.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void stopCapture() {
        System.out.println("Stop Capturing");
        targetline.stop();
        System.out.println("Line Stoped");
        targetline.close();
        System.out.println("Line Closed");
    }

    /**
     * Function to get audio format
     *
     * @return
     */
    AudioFormat getAudioFormat() {
        float sampleRate = 8000.0F;
        int sampleSizeInBits = 16;
        int channels = 1;
        boolean signed = true;
        boolean bigEndian = false;
        AudioFormat audioformat = new AudioFormat(sampleRate, sampleSizeInBits,
                channels, signed, bigEndian);
        return audioformat;
    }
}

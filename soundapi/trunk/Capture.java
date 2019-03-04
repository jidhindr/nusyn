/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package soundapi;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.*;

/**
 *
 * @author JiDHiN
 */
public class Capture {

    void start(Line.Info lineinfo) throws LineUnavailableException {
        
        TargetDataLine targetline = (TargetDataLine) AudioSystem.getLine(lineinfo);
        targetline.open(getAudioFormat());
        targetline.start();
        AudioInputStream audioinputstream = new AudioInputStream(targetline);
        try {
            AudioSystem.write(audioinputstream, AudioFileFormat.Type.WAVE, new File("rec.wav"));
        } catch (IOException ex) {
            Logger.getLogger(Capture.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    void stop(TargetDataLine line){
        line.stop();
        line.close();
    }

    /**
     * Function to get audio format
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

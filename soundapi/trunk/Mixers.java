/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package soundapi;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.*;
import javax.sound.sampled.Mixer.Info;

/**
 *
 * @author JiDHiN
 */
public class Mixers {
 Info[] getInfo(){
    Mixer.Info[] mixer = AudioSystem.getMixerInfo();
    return mixer;
}


    
 
}

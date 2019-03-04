/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package soundapi;

import javax.sound.sampled.Mixer;

/**
 *
 * @author JiDHiN
 */
public class ComboMixer {

    private Mixer.Info mixerinfo;

    public ComboMixer(Mixer.Info mixerinfo) {
        this.mixerinfo = mixerinfo;

    }

    @Override
    public String toString() {
        return mixerinfo.getName();
    }

    public Mixer.Info getMixer() {
        return mixerinfo;
    }
}

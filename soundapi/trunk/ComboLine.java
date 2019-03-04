/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package soundapi;

import javax.sound.sampled.Line;
import javax.sound.sampled.Mixer;

/**
 *
 * @author JiDHiN
 */
public class ComboLine {

    private Line.Info lineinfo;

    public ComboLine(Line.Info lineinfo) {
        this.lineinfo = lineinfo;

    }

    @Override
    public String toString() {
        return lineinfo.toString();
    }

    public Line.Info getLine() {
        return lineinfo;
    }
}

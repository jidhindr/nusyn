/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package soundapi;

import javax.sound.sampled.Line;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.TargetDataLine;

/**
 *
 * @author S105_ANSHUL
 */
public class LivePlayback extends Thread{
    Line.Info sourcelineinfo;
    Line.Info targetlineinfo;
    
    TargetDataLine targetdataline;
    SourceDataLine sourcedataline;
    
    public LivePlayback(Line.Info targetlineinfo, Line.Info sourcelineinfo){
        this.targetlineinfo = targetlineinfo;
        this.sourcelineinfo = sourcelineinfo;
    }
    
    @Override
    public void run(){
        
    }
}

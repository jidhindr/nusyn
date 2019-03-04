/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package soundapi;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Mixer;

/**
 *
 * @author JiDHiN
 */
public class SoundApi {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SoundApiFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SoundApiFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SoundApiFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SoundApiFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        SoundApi s = new SoundApi();

    }

    public SoundApi() {
        SoundApiFrame Frame = new SoundApiFrame();
        Frame.setVisible(true);
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package soundapi;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Line;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.Mixer;
import javax.sound.sampled.Mixer.Info;

/**
 *
 * @author JiDHiN
 */
public class SoundApiFrame extends javax.swing.JFrame {
  SoundCapture t;
  SoundPlayback p;
    /**
     * Creates new form SoundApiFrame
     */
    public SoundApiFrame() {
        initComponents();

        loadMixer();
        initEvents();
    }

    private void initEvents() {
        cmbInputMixer.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent evt) {
                loadLine(((ComboMixer) cmbInputMixer.getSelectedItem()).getMixer(), 'I');
            }
        });

        cmbOutputMixer.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent evt) {
                loadLine(((ComboMixer) cmbOutputMixer.getSelectedItem()).getMixer(), 'O');
            }
        });

        btnCapture.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if ("Capture".equals(btnCapture.getText())) {
                    btnCapture.setText("Stop");
                    t = new SoundCapture(((ComboLine) cmbInputLine.getSelectedItem()).getLine());
                    t.start();
                } else {
                    btnCapture.setText("Capture");
                    t.stopCapture();
                }
            }
        });
        
        
          btnPlay.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                if ("Play".equals(btnPlay.getText())) {
                    btnPlay.setText("Stop");
                    p = new SoundPlayback(((ComboLine) cmbOutputLine.getSelectedItem()).getLine());
                    p.start();
                } else {
                    btnPlay.setText("Play");
                    p.stopPlayback();
                }
            }
        });
    }

    private void loadMixer() {
        Mixer.Info[] arrMixerInfo = AudioSystem.getMixerInfo();
        cmbInputMixer.removeAllItems();
        cmbOutputMixer.removeAllItems();
        cmbInputMixer.addItem("--Select--");
        cmbOutputMixer.addItem("--Select--");
        //Load mixer into combobox
        for (Mixer.Info mixerinfo : arrMixerInfo) {
            cmbInputMixer.addItem(new ComboMixer(mixerinfo));
            //cmbInputputMixer.addItem(mixerinfo);
            cmbOutputMixer.addItem(new ComboMixer(mixerinfo));
        }
    }

    private void loadLine(Mixer.Info mixerinfo, char mode) {
        Mixer m = AudioSystem.getMixer(mixerinfo);

        //Input line
        if (mode == 'I') {
            cmbInputLine.removeAllItems();
            Line.Info[] arrLineInfo = m.getTargetLineInfo();
            for (Line.Info lineinfo : arrLineInfo) {
                cmbInputLine.addItem(new ComboLine(lineinfo));
            }

            //Output line    
        } else {
            cmbOutputLine.removeAllItems();
            Line.Info[] arrLineInfo = m.getSourceLineInfo();
            for (Line.Info lineinfo : arrLineInfo) {
                cmbOutputLine.addItem(new ComboLine(lineinfo));
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooser1 = new javax.swing.JFileChooser();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        cmbInputMixer = new javax.swing.JComboBox();
        cmbInputLine = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cmbOutputMixer = new javax.swing.JComboBox();
        cmbOutputLine = new javax.swing.JComboBox();
        btnCapture = new javax.swing.JButton();
        btnPlay = new javax.swing.JButton();
        btnLive = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel3.setText("Input");

        cmbInputMixer.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "--Select--" }));
        cmbInputMixer.setName("cmbInputMixer"); // NOI18N

        cmbInputLine.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "--Select--" }));

        jLabel4.setText("Mixer");

        jLabel6.setText("Output");

        cmbOutputMixer.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "--Select--" }));
        cmbOutputMixer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbOutputMixerActionPerformed(evt);
            }
        });

        cmbOutputLine.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "--Select--" }));

        btnCapture.setText("Capture");
        btnCapture.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCaptureActionPerformed(evt);
            }
        });

        btnPlay.setText("Play");

        btnLive.setText("Live");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(166, 166, 166))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(cmbInputMixer, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(33, 33, 33))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnCapture)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnPlay, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnLive)
                                .addGap(0, 212, Short.MAX_VALUE))
                            .addComponent(cmbOutputLine, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmbOutputMixer, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmbInputLine, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(33, 33, 33))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cmbInputMixer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cmbInputLine, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbOutputMixer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cmbOutputLine, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCapture)
                    .addComponent(btnPlay)
                    .addComponent(btnLive))
                .addGap(0, 11, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCaptureActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCaptureActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCaptureActionPerformed

    private void cmbOutputMixerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbOutputMixerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbOutputMixerActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCapture;
    private javax.swing.JButton btnLive;
    public static javax.swing.JButton btnPlay;
    private javax.swing.JComboBox cmbInputLine;
    private javax.swing.JComboBox cmbInputMixer;
    private javax.swing.JComboBox cmbOutputLine;
    private javax.swing.JComboBox cmbOutputMixer;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package practicaotravez;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import vistas.InicioSecion;
import vistas.PantallaCarga;

/**
 *
 * @author hol33
 */
public class PracticaOtravez {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Runnable rn1 = () -> {
            AudioInputStream audio = null;
            try {
                File aud = new File("src/audios/audio.wav");
                audio = AudioSystem.getAudioInputStream(aud);
                Clip clip = AudioSystem.getClip();
                clip.open(audio);
                clip.start();
                Thread.sleep(5000);
                clip.close();
            } catch (UnsupportedAudioFileException ex) {
                Logger.getLogger(PracticaOtravez.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(PracticaOtravez.class.getName()).log(Level.SEVERE, null, ex);
            } catch (LineUnavailableException ex) {
                Logger.getLogger(PracticaOtravez.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InterruptedException ex) {
                Logger.getLogger(PracticaOtravez.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    audio.close();
                } catch (IOException ex) {
                    Logger.getLogger(PracticaOtravez.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        };
        
        Runnable rn = () -> {
            
            try {
                PantallaCarga pc = new PantallaCarga();
                pc.setVisible(true);
                
                Thread.sleep(5000);
                pc.dispose();
                
                InicioSecion is = new InicioSecion();
                is.setVisible(true);
            } catch (InterruptedException ex) {
                Logger.getLogger(PracticaOtravez.class.getName()).log(Level.SEVERE, null, ex);
            }
        };
        
        
        Thread a = new Thread(rn);
        a.start();
        Thread b = new Thread(rn1);
        b.start();
        
    }
    
}

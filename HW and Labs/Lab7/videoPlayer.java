package Lab7;

import java.awt.event.*;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import uk.co.caprica.vlcj.binding.LibVlc;
import uk.co.caprica.vlcj.binding.RuntimeUtil;
import uk.co.caprica.vlcj.factory.discovery.NativeDiscovery;
import uk.co.caprica.vlcj.player.component.EmbeddedMediaPlayerComponent;
import java.io.IOException;


public class videoPlayer extends JFrame {
    public static void main(String[] args) throws IOException{
        videoPlayer m = new videoPlayer();
        m.setVisible(true);
    }
    
    public videoPlayer() throws IOException{
        new NativeDiscovery().discover();
        EmbeddedMediaPlayerComponent component = new EmbeddedMediaPlayerComponent();
        // Exit on close
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set the size of the frame (in px)
        setSize(800,600);

        JPanel contentPane = new JPanel();
        contentPane.setLayout(new BorderLayout());
        contentPane.setBorder(new TitledBorder("Media Player"));;
        setContentPane(contentPane);

        //file you want to play
        component.mediaPlayer().media().play("vid.avi");
        
    }
}

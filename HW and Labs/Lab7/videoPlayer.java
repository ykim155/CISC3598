package Lab7;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import uk.co.caprica.vlcj.factory.discovery.NativeDiscovery;
import uk.co.caprica.vlcj.player.component.EmbeddedMediaPlayerComponent;
import java.io.IOException;


public class videoPlayer extends JFrame {
    EmbeddedMediaPlayerComponent component;
    JButton playButton;
    JButton pauseButton;
    public static void main(String[] args) throws IOException{
        videoPlayer m = new videoPlayer();
        m.run();
        m.loadVid();
    }
    
    public videoPlayer() throws IOException{
        new NativeDiscovery().discover();
        component = new EmbeddedMediaPlayerComponent();
    }

    public void run(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set the size of the frame (in px)
        setSize(800,600);

        JPanel contentPane = new JPanel();
        contentPane.setLayout(new BorderLayout());
        contentPane.setBorder(new TitledBorder("Media Player"));;
        contentPane.add(component, BorderLayout.CENTER);

        JPanel controlsPane = new JPanel();

        playButton = new JButton("Play");
        controlsPane.add(playButton);    	
        contentPane.add(controlsPane, BorderLayout.SOUTH);
        playButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                component.mediaPlayer().controls().play();
            }
        });
        
        pauseButton = new JButton("Pause");
        controlsPane.add(pauseButton);
        pauseButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                component.mediaPlayer().controls().pause();
            }
        });

        this.setContentPane(contentPane);
        this.setVisible(true);

        //file you want to play
        
    }

    public void loadVid(){
        component.mediaPlayer().media().startPaused("HW and Labs//Lab7//ow.mp4");
    }
}

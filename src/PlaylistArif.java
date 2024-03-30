import java.awt.Font; // Arif Azinuddin - Section 4
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.sound.sampled.*;
import javax.swing.*;  // Import the library

public class PlaylistArif extends JFrame {

    private final String pathToClip = "soundLab7/Kill Bill.wav";
    private JButton playBtn;
    private boolean soundLoaded;
    private Clip clip;
    private boolean isPlaying;
    private boolean isPaused;

    public PlaylistArif() {
    	setIconImage(Toolkit.getDefaultToolkit().getImage("imgLab7/Spotify.png"));
        setTitle("Spotify"); // Set the JFrame title as "Spotify"
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);
    }

    public void paint(Graphics g) {
        super.paint(g); // Call the parent class paint method
        Toolkit t = Toolkit.getDefaultToolkit(); // Create t object of Toolkit class
        Image i = t.getImage("imgLab7/Kill Bill.png"); // Load the image from source folder
        g.drawImage(i, 75, 40, 150, 150, this); // Draw the image with specific dimensions
    }

    public void initialize() {
        // Add the label
        JLabel nowPlayingLabel = new JLabel("Now Playing: Kill Bill.wav");
        nowPlayingLabel.setBounds(5, 160, 280, 30);
        nowPlayingLabel.setFont(new Font("Arial", Font.BOLD, 16));
        nowPlayingLabel.setHorizontalAlignment(SwingConstants.CENTER);
        getContentPane().add(nowPlayingLabel);

        // Try to load the sound from the file...
        try {
            // Open an audio input stream.
            File file = new File(pathToClip);
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(file);

            // Get a sound clip resource, open audio clip, and
            // load samples from the audio input stream.
            clip = AudioSystem.getClip();
            clip.open(audioIn);
            soundLoaded = true;
        } catch (UnsupportedAudioFileException e) {
            soundLoaded = false;
            e.printStackTrace();
        } catch (IOException e) {
            soundLoaded = false;
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            soundLoaded = false;
            e.printStackTrace();
        }

        playBtn = new JButton("Play");
        playBtn.setBounds(90, 200, 100, 30);
        playBtn.setFont(new Font("Arial Narrow", Font.BOLD, 20));

        playBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (soundLoaded) {
                    if (!isPlaying && !isPaused) {
                        clip.setFramePosition(0); // rewind to the beginning
                        clip.start(); // Start playing
                        isPlaying = true;
                        playBtn.setText("Pause");
                    } else if (isPlaying && !isPaused) {
                        clip.stop(); // Pause the clip
                        isPlaying = false;
                        isPaused = true;
                        playBtn.setText("Resume");
                    } else if (!isPlaying && isPaused) {
                        clip.start(); // Resume playing the clip
                        isPlaying = true;
                        isPaused = false;
                        playBtn.setText("Pause");
                    }
                }
            }
        });

        getContentPane().add(playBtn);
        setVisible(true);
    }

    public static void main(String[] args) {
    	PlaylistArif playlist = new PlaylistArif();
    	playlist.initialize();
    }
}

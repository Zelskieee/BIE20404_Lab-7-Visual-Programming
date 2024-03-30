import java.awt.Canvas; // Arif Azinuddin - Section 4
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JLabel; // Import the library

public class ArifSwag extends Canvas {

	// Override paint method
    public void paint(Graphics g) {
        Toolkit t = Toolkit.getDefaultToolkit(); // Create t object of Toolkit class
        Image i = t.getImage("imgLab7/ARIF SWAG.png"); // Load the image from source folder
        g.drawImage(i, 75, 60, this); // Draw the image with specific dimension
    }

    public static void main(String[] args) {
       
    	ArifSwag m = new ArifSwag(); // Create m object of ArifSwag class

        JFrame f = new JFrame(); // Create JFrame object 
        f.setIconImage(Toolkit.getDefaultToolkit().getImage("imgLab7/ARIF SWAG.png")); // Set JFrame icon
        f.setTitle("Arif Swag"); // Set the title of JFrame
        
        JLabel l = new JLabel("Arif Azinuddin"); // Create JLabel object 
        l.setFont(new Font("Arial Narrow", Font.BOLD, 25)); // Set the font type
        l.setBounds(180, 10, 200, 50); // Set position and size of JLabel
        
        // Add all the source component to the JFrame
        f.getContentPane().add(l);
        f.getContentPane().add(m);
        f.setSize(500, 500);
        f.setVisible(true);
        f.getContentPane().setLayout(null);
    }
}

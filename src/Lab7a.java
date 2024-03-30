import java.awt.Canvas; // Arif Azinuddin - Section 4
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JFrame; // Import the library

public class Lab7a extends Canvas {

	// Override paint method with Graphics object
	public void paint(Graphics g) {
		Toolkit t = Toolkit.getDefaultToolkit(); // Create t object of Toolkit class
		Image i = t.getImage("imgLab7/logo.png"); // Load the image from the source folder
		g.drawImage(i, 75, 40, this); // Draw the image with specific dimensions
		g.setFont(new Font("Arial Narrow", Font.BOLD, 25)); // Set the font type
		g.drawString("Lab 7", 79, 30); // Draw the string "Lab 7" at the specified position
	}

	public static void main(String[] args) {
		Lab7a m = new Lab7a(); // Create m object of Lab7a class

		JFrame f = new JFrame(); // Create JFrame object
		f.setIconImage(Toolkit.getDefaultToolkit().getImage("imgLab7/logo.png")); // Set JFrame icon
		f.setTitle("Java Logo"); // Set the title of JFrame

		// Add the canvas to the JFrame
		f.getContentPane().add(m);
		f.setSize(240, 220);
		f.setVisible(true);
		f.getContentPane().setLayout(null);
	}
}

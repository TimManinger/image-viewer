import java.awt.BorderLayout;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

public class Viewer 
{
	public void OpenViewer(String path)
	{
		Image image = null;
		try {
			image = ImageIO.read(new File(path));
		} catch (IOException e) {
			System.out.println("path not found: " + path);
			e.printStackTrace();
			
		}
		int maxW = 800;
		int maxH = 450;
		int W = image.getWidth(null);
		int H = image.getHeight(null);
		Image scaledImage = null;
		JFrame frame = new JFrame();
		if(H > maxH || W > maxW)
		{
			if(maxH-H > maxW-W)
			{
				scaledImage = image.getScaledInstance(-1,maxH,Image.SCALE_SMOOTH);			
			}
			else
			{
				scaledImage = image.getScaledInstance(maxW,-1,Image.SCALE_SMOOTH);
			}
		}
		else if(W < 128 && H < 128)
		{
			scaledImage = image.getScaledInstance(-1,128,Image.SCALE_SMOOTH);
		}
		else
		{
			scaledImage = image;
		}
		JLabel lblimage = new JLabel(new ImageIcon(scaledImage));
		frame.setTitle("Image Viewer " + "(" + path + ")");
		frame.getContentPane().add(lblimage, BorderLayout.CENTER);
		frame.pack();
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		frame.setVisible(true);
	}
}

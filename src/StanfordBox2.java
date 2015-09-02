import java.awt.image.BufferedImage;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.awt.Panel;
import java.awt.geom.Rectangle2D;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import javax.swing.JFrame;


public class StanfordBox2 {

	public static  final int BOX_SIZE = 300;
	public static final int SIDES = 5;
	public static final int BOX_SPACING = 25;
	public static final int BORDER = 15;
	public static final String TITLE = "Stanford Box Optical Illusion";

	public StanfordBox2() {
		// TODO Auto-generated constructor stub
	}

	
	public static void main(String [] args) {
		
		
		JFrame frame = new JFrame();
		int border = BORDER;
		int boxSize = BOX_SIZE;
		int sides = SIDES;
		int boxSpacing = BOX_SPACING;
		String title = TITLE;
/*
		System.out.println("Border: " + BORDER);
		System.out.println("Box Size: " + BOX_SIZE);
		System.out.println("Sides: " + SIDES);
		System.out.println("Box Spacing: " + BOX_SPACING);
		System.out.println("Width: " + getWindowWidth(border,boxSize, sides, boxSpacing));
*/		
		
		BufferedImage image = new BufferedImage(getWindowWidth(border, boxSize, sides, boxSpacing), 
												getWindowHeighth(border, boxSize, sides, boxSpacing),
												BufferedImage.TYPE_INT_ARGB);
		Graphics2D boxGraphic = image.createGraphics();
        boxGraphic.setPaint(Color.BLACK);
        boxGraphic = fillBoxes(boxGraphic, sides, boxSize, boxSpacing, border);

        ImageIcon icon = new ImageIcon(image);
        JLabel boxLabel = new JLabel(icon);

        frame.setContentPane(boxLabel);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);            // closes all windows
        frame.setTitle(title);
        frame.pack();
        frame.requestFocusInWindow();
        frame.setVisible(true);
        //frame.repaint();
		
	}
	
	public static Graphics2D fillBoxes(Graphics2D boxGraphic, int sides, int boxSize, int boxSpacing, int border) {
        for (int i=0; i < sides ;i++) {
        	for (int j=0; j < sides; j++) {
                boxGraphic.fill(new Rectangle2D.Double(	((boxSize*j) +(boxSpacing*j) + border), 
                										((boxSize*i) +(boxSpacing*i) + border), 
                										boxSize, 
                										boxSize));
        	}
        }
        return boxGraphic;
	}
	

	public static int getWindowWidth(int border, int boxSize, int sides, int spacing) {
		return (2*border)+(boxSize*sides)+(spacing*(sides-1));
	}
	
	public static int getWindowHeighth(int border, int boxSize, int sides, int spacing) {
		return (2*border)+(boxSize*sides)+(spacing*(sides-1));
	}
	
}

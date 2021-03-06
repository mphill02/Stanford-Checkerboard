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


public class StanfordCheckerboard {

    private final Color BLACK      = Color.BLACK;
    private JFrame frame;
    private BufferedImage image;
    private Graphics2D boxGraphic;
    private int rows;
    private int boxSize;
    private int columns;
	private JLabel boxLabel;
	private String title;
	
	public StanfordCheckerboard() {
		this.frame = new JFrame();
	}

	public StanfordCheckerboard(int rows, int columns, int boxSize, String title) {
		this.frame = new JFrame();
		setLayout(rows, columns, boxSize);
		setTitle(title);
		setImage();
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public void show() {
        this.frame = this.setFrameProperties(this.frame, this.boxLabel, false, JFrame.EXIT_ON_CLOSE);
        this.frame.pack();
        this.frame.requestFocusInWindow();
        this.frame.setVisible(true);
        this.frame.repaint();
		
	}

	public void setLayout(int rows, int columns, int boxSize) {
		this.rows = rows;
		this.columns = columns;
		this.boxSize = boxSize;
	}
/*
	public void setImage(BufferedImage image) {
		this.image = image;
	}
*/	
	public void setImage() {
		this.image = new BufferedImage(	getWindowWidth(this.columns, this.boxSize), 
										getWindowHeighth(this.rows, this.boxSize),
										BufferedImage.TYPE_INT_ARGB);
		setGraphic();
		setBoxLabel();
	}
/*
	public void setAttributes(int border, int boxSize, int sides, int boxSpacing, String title) {
		this.border = border;
		this.sides = sides;
		this.boxSize = boxSize;
		this.boxSpacing = boxSpacing;
		this.title = title;

		this.image = new BufferedImage(	getWindowWidth(border, boxSize, sides, boxSpacing), 
										getWindowHeighth(border, boxSize, sides, boxSpacing),
										BufferedImage.TYPE_INT_ARGB);
		setGraphic();
		setBoxLabel();
	}
*/	
	public void setBoxLabel() {
        ImageIcon icon = new ImageIcon(this.image);
        this.boxLabel = new JLabel(icon);
	}
	
	public void setGraphic() {
        boxGraphic = this.image.createGraphics();
        boxGraphic.setPaint(Color.BLACK);
        boxGraphic = this.fillBoxes(boxGraphic);
	}
	
	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
	
	public  JFrame setFrameProperties(JFrame frame, JLabel label, boolean resizeable, int defaultCloseOperation) {
        frame.setContentPane(label);
        frame.setResizable(resizeable);
        frame.setDefaultCloseOperation(defaultCloseOperation);            // closes all windows
        frame.setTitle(this.title);
        return frame;
	}
	
	public  Graphics2D fillBoxes(Graphics2D boxGraphic) {
        for (int i=0; i < this.rows ;i++) {
        	for (int j=0; j < this.columns; j++) {
        		if (((i+j)%2) > 0) {
                boxGraphic.fill(new Rectangle2D.Double(	(this.boxSize*j), 
                										(this.boxSize*i), 
                										this.boxSize, 
                										this.boxSize));
        		}
        	}
        }
        return boxGraphic;
	}
	
	public  int getWindowWidth(int columns, int boxSize) {
		return columns*boxSize;
	}
	
	public int getWindowHeighth(int rows, int boxSize) {
		return rows*boxSize;
	}
	
}

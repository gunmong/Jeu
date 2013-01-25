package com.bm.jeu;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Sprite extends JLabel {
	private ImageIcon image;
	private String label;
	
	public Sprite()
	{
		setSize(32,32);
	}
	
	public boolean _setSpriteLabel(String label)
	{
		if(label != null)
		{
			this.label = label;
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public String _getSpriteLabel()
	{
		return label;
	}
	
	public boolean _setSpriteImage(String pathToSpriteSourceImage)
	{
		if(image != null)
		{
			this.image = new ImageIcon(pathToSpriteSourceImage);
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public ImageIcon _getSpriteImage()
	{
		return image;
	}
}
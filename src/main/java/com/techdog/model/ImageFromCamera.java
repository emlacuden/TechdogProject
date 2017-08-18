package com.techdog.model;

import java.awt.image.BufferedImage;

public class ImageFromCamera {

	private boolean state;
	private BufferedImage image;
	public boolean getState() {
		return state;
	}
	public void setState(boolean state) {
		this.state = state;
	}
	public BufferedImage getImage() {
		return image;
	}
	public void setImage(BufferedImage image) {
		this.image = image;
	}
	public ImageFromCamera() {
		// TODO Auto-generated constructor stub
	}
	public ImageFromCamera(boolean state, BufferedImage image) {
		// TODO Auto-generated constructor stub
		this.state = state;
		this.image = image;
	}
	
}

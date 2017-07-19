package com.techdog.Controller;

import java.awt.image.BufferedImage;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import org.opencv.core.Mat;
import org.opencv.core.Size;
import org.opencv.imgproc.Imgproc;

public class TrainingController {
	public static void loadImageToJlabel(List<Mat> listImage, List<JLabel> listLabel) {
		if (listImage.size() == 0) {
			for(int i=0; i<listLabel.size();i++) {
				listLabel.get(i).setIcon(null);
			}
			return;
		}

		int loadNumber = 0;
		if (listImage.size() <= listLabel.size()) {
			loadNumber = listImage.size();
			for(int i=listImage.size();i<listLabel.size();i++) {
				listLabel.get(i).setIcon(null);
			}
		}
		else
			loadNumber = listLabel.size();
		Mat resizeimage = new Mat();
		Size sz = new Size(145, 84);
		for (int i = 0; i < loadNumber; i++) {

			Imgproc.resize(listImage.get(i), resizeimage, sz);
			BufferedImage img = Camera.matToBufferedImage(resizeimage);
			listLabel.get(i).setIcon(new ImageIcon(img));
		}

	}
}

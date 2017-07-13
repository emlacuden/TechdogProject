package com.techdog.Controller;

import java.awt.image.BufferedImage;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import org.opencv.core.Mat;
import org.opencv.core.Size;
import org.opencv.imgproc.Imgproc;

import com.techdog.Utils.Constant;
import com.techdog.Utils.DirectoryUtils;

public class ImageProcessController {
	public static void loadKnownPersonImage(String name,List<JLabel> listLabel) {
		String pathKPImage = Constant.getConstant("dataurl")+"/"+name;
		List<Mat> listImage = DirectoryUtils.getAllImageInFolder(pathKPImage);
		
		//
		if (listImage.size() == 0)
			return;

		int loadNumber = 0;
		if (listImage.size() < listLabel.size())
			loadNumber = listImage.size();
		else
			loadNumber = listLabel.size();
		Mat resizeimage = new Mat();
		Size sz = new Size(145, 84);
		for (int i = 0; i < loadNumber; i++) {

			Imgproc.resize(listImage.get(i), resizeimage, sz);
			BufferedImage img = Camera.matToBufferedImage(resizeimage);
			// resizeimage = new Mat();

			listLabel.get(i).setIcon(new ImageIcon(img));
		}
	}
	public static List<Mat> deleteAnImage(List<Mat> listImage, int index){
		if(listImage.size()<=index) return listImage;
		int dialogResult = JOptionPane.showConfirmDialog(null, "Are you sure that you want to delete this image!", "Delete Image", JOptionPane.YES_NO_OPTION);
		if(dialogResult == JOptionPane.YES_OPTION)
			listImage.remove(index);
		return listImage;
	}

}

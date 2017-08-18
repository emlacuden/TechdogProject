package com.techdog.Controller;

import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.awt.image.WritableRaster;
import java.util.Queue;
import java.util.concurrent.TimeUnit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Size;
import org.opencv.imgproc.Imgproc;
import org.opencv.videoio.VideoCapture;

import com.techdog.model.ImageFromCamera;

public class Camera {
	static Mat currentFrame;
	
	public static BufferedImage matToBufferedImage(Mat frame) {
		int type = 0;
		if (frame.channels() == 1) {
			type = BufferedImage.TYPE_BYTE_GRAY;
		} else if (frame.channels() == 3) {
			type = BufferedImage.TYPE_3BYTE_BGR;
		}
		BufferedImage image = new BufferedImage(frame.width(), frame.height(), type);
		WritableRaster raster = image.getRaster();
		DataBufferByte dataBuffer = (DataBufferByte) raster.getDataBuffer();
		byte[] data = dataBuffer.getData();
		frame.get(0, 0, data);

		return image;
	}

	public static void displayCamera(JLabel label, int labelWidth, int labelHeight, boolean isGetPicture) {
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		VideoCapture camera = new VideoCapture("rtsp://admin:Minhquan24@192.168.0.105/Streaming/Channels/101");
		if (!camera.isOpened()) {
			JOptionPane.showMessageDialog(new JFrame(), "Camera connot open please config the camera information!",
					"Dialog", JOptionPane.ERROR_MESSAGE);
			return;
		}
		Mat frame = new Mat();
		BufferedImage bufferedImage = null, bufferedImageResize;
		Mat resizeimage = new Mat();
		while (true) {
			if (camera.read(frame)) {
				currentFrame = frame;
				Size sz = new Size(labelWidth, labelHeight);
				Imgproc.resize(frame, resizeimage, sz);
				bufferedImage = matToBufferedImage(resizeimage);
				label.setIcon(new ImageIcon(bufferedImage));
			}
		}
	}
	public static void displayToFrame(JLabel label, Queue<ImageFromCamera> queue) {
		
		while (true) {
			//System.out.println("size of queue display:"+ queue.size());
			try {
				TimeUnit.MILLISECONDS.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(!queue.isEmpty()) {
				System.out.println("display to the frame");
				ImageFromCamera img = queue.element();
				label.setIcon(new ImageIcon(img.getImage()));
				
				queue.remove();
			}
			
		}
	}

	public static void readToQueue(JLabel label, int labelWidth, int labelHeight, Queue<ImageFromCamera> queue) {
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		
		VideoCapture camera = new VideoCapture("rtsp://admin:Minhquan24@192.168.0.105/Streaming/Channels/101");
		if (!camera.isOpened()) {
			JOptionPane.showMessageDialog(new JFrame(), "Camera connot open please config the camera information!",
					"Dialog", JOptionPane.ERROR_MESSAGE);
			return;
		}
		Mat frame = new Mat();
		
		Mat resizeimage = new Mat();
		while (true) {
			if (camera.read(frame)) {
				BufferedImage bufferedImage = null;
				
				Size sz = new Size(labelWidth, labelHeight);
				Imgproc.resize(frame, resizeimage, sz);
				bufferedImage = matToBufferedImage(resizeimage);
				ImageFromCamera imgFromCamera = new ImageFromCamera(true, bufferedImage);
				queue.add(imgFromCamera);
				System.out.println("size of queue: " + queue.size());
			}
		}
		
	}

	public static Mat getCurrentImage() {
		if (currentFrame != null) {
			Mat resultImage = currentFrame.clone();
			return resultImage;
		}

		return null;
	}

}

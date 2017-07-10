package com.techdog.Utils;

import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.awt.image.WritableRaster;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.videoio.VideoCapture;

import net.coobird.thumbnailator.Thumbnails;

public class Camera {
	public static BufferedImage createAwtImage(Mat mat) {

        int type = 0;
        if (mat.channels() == 1) {
            type = BufferedImage.TYPE_BYTE_GRAY;
        } else if (mat.channels() == 3) {
            type = BufferedImage.TYPE_3BYTE_BGR;
        } else {
            return null;
        }

        BufferedImage image = new BufferedImage(mat.width(), mat.height(), type);
        WritableRaster raster = image.getRaster();
        DataBufferByte dataBuffer = (DataBufferByte) raster.getDataBuffer();
        byte[] data = dataBuffer.getData();
        mat.get(0, 0, data);

        return image;
    }
	private static BufferedImage matToBufferedImage(Mat frame) {
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
	public static void displayCamera(JLabel label,int labelWidth, int labelHeight ) {
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
//      String filePath = "G:\\PICTURES\\roxtar vassy\\early days in APSCE.wmv";
//      if (!Paths.get(filePath).toFile().exists()){
//           System.out.println("File " + filePath + " does not exist!");
//           return;
//      }
      
      VideoCapture camera = new VideoCapture("rtsp://admin:Minhquan24@192.168.0.107/Streaming/Channels/101");
      //VideoCapture camera = new VideoCapture(0);
      if (!camera.isOpened()) {
          System.out.println("Error! Camera can't be opened!");
          return;
      }
      Mat frame = new Mat();
      BufferedImage bufferedImage=null,bufferedImageResize;
      while(true){
          if (camera.read(frame)){
              bufferedImage = matToBufferedImage(frame);
              bufferedImageResize = resize(bufferedImage,labelWidth,labelHeight);
               label.setIcon(new ImageIcon(bufferedImageResize));
          }
      }
	}
	public static BufferedImage resize(BufferedImage img, int newW, int newH) {
		
		  try {
			return Thumbnails.of(img).size(newW, newH).asBufferedImage();
		} catch (IOException e) {
			
			e.printStackTrace();
			return null;
		}
		} 
}

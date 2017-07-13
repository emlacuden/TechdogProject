package com.techdog.Utils;

import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

import org.opencv.core.Mat;

public class test {
	static JLabel  jlabel = new JLabel();
	static JFrame jframe = new JFrame();
    public static void main(String[] args) {
    	File file = new File("/home/hungpp");
    	String[] directories = file.list(new FilenameFilter() {
    	  @Override
    	  public boolean accept(File current, String name) {
    		  if(name.charAt(0)=='.') {
    			  return false;
    		  }
    	    return new File(current, name).isDirectory();
    	  }
    	});
    	System.out.println(Arrays.toString(directories));
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
    
    private static void showWindow(BufferedImage img) {
        jlabel.setIcon(new ImageIcon(img));
    	jframe.getContentPane().add(jlabel);
    	jframe.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    	jframe.setSize(img.getWidth(), img.getHeight() + 30);
    	jframe.setTitle("Image captured");
    	jframe.setVisible(true);
    }
}

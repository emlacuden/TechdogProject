package com.techdog.Utils;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;

public class DirectoryUtils {
	

    // array of supported extensions (use a List if you prefer)
    static final String[] EXTENSIONS = new String[]{
        "jpg", "png", "bmp" // and other formats you need
    };
    // filter to identify images based on their extensions
    static final FilenameFilter IMAGE_FILTER = new FilenameFilter() {

        @Override
        public boolean accept(final File dir, final String name) {
            for (final String ext : EXTENSIONS) {
                if (name.endsWith("." + ext)) {
                    return (true);
                }
            }
            return (false);
        }
    };
	
	public static String[] allSubDirectoryName(String path) {
		File file = new File(path);
    	String[] directories = file.list(new FilenameFilter() {
    	  @Override
    	  public boolean accept(File current, String name) {
    		  if(name.charAt(0)=='.') {
    			  return false;
    		  }
    	    return new File(current, name).isDirectory();
    	  }
    	});
    	return directories;
	}
	public static List<Mat> getAllImageInFolder(String path){
		File dir = new File(path);
		List<Mat> listImage = new ArrayList<Mat>();
		if (dir.isDirectory()) { // make sure it's a directory
            for (final File f : dir.listFiles(IMAGE_FILTER)) {
                Mat img = null;

                try {
                	//System.out.println(f.getAbsolutePath());
                    img = Imgcodecs.imread(f.getAbsolutePath());
                    listImage.add(img);
                    // you probably want something more involved here
                    // to display in your UI
//                    System.out.println("image: " + f.getName());
//                    System.out.println(" width : " + img.getWidth());
//                    System.out.println(" height: " + img.getHeight());
//                    System.out.println(" size  : " + f.length());
                } catch (final Exception e) {
                    // handle errors here
                }
            }
            return listImage;
        }
		return null;
	}
}

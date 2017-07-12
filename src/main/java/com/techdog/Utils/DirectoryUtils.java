package com.techdog.Utils;

import java.io.File;
import java.io.FilenameFilter;

public class DirectoryUtils {
	
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
}

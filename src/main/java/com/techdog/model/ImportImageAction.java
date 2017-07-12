package com.techdog.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.filechooser.FileNameExtensionFilter;

public class ImportImageAction {
	public ImportImageAction() {
		// TODO Auto-generated constructor stub
	}

	public void Action(List<JLabel> parent) {
		JFileChooser fileChooser = new JFileChooser();
		javax.swing.filechooser.FileFilter filter = new FileNameExtensionFilter("Image Files", "jpg", "jpeg", "png");
		fileChooser.setFileFilter(filter);
		fileChooser.setMultiSelectionEnabled(true);
		fileChooser.setAcceptAllFileFilterUsed(false);
		if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
			File[] files = fileChooser.getSelectedFiles();
			// parent.setIcon(arg0);
			// setImageForLable(fileChooser.getSelectedFile().getAbsolutePath());
			for (File file : files) {
				String filePath = file.getAbsolutePath();
				InputStream is = null;
				OutputStream os = null;
				try {
					File source = new File(filePath);
					File dest = new File("/home/kibahero2802/TechDogProject/src/main/java/com/techdog/model/dataSave/"
							+ file.getName());
					is = new FileInputStream(source);
					os = new FileOutputStream(dest);

					byte[] buffer = new byte[1024];

					int length;
					while ((length = is.read(buffer)) > 0) {
						os.write(buffer, 0, length);
					}

					if (is != null)
						is.close();
					if (os != null)
						os.close();
					System.out.println("File Copied..");
					
					ImageIcon iIcon = new ImageIcon("/home/kibahero2802/TechDogProject/src/main/java/com/techdog/model/dataSave/"
							+ file.getName());
					for (int i = 0; i < parent.size(); i++) {
						if (parent.get(i) != null || parent.get(i).getIcon() != null) {
							parent.get(i).setIcon(iIcon);
						}
					}
				} catch (IOException e1) {
					e1.printStackTrace();
				}

			}
		} else {
			System.out.println("Failed to Load");
		}

	}
}

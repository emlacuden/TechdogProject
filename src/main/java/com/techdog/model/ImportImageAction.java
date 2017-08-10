package com.techdog.model;

import java.awt.Image;
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
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

public class ImportImageAction {
	public ImportImageAction() {
		// TODO Auto-generated constructor stub
	}

	public void Action(List<JLabel> parent, JTextField name, JTextField phoneNumber) {
		if (name == null) {
			name.setText("");
		}
		if (phoneNumber == null) {
			phoneNumber.setText("");
		}
		JFileChooser fileChooser = new JFileChooser();
		javax.swing.filechooser.FileFilter filter = new FileNameExtensionFilter("Image Files", "jpg", "png");
		fileChooser.setFileFilter(filter);
		fileChooser.setMultiSelectionEnabled(true);
		fileChooser.setAcceptAllFileFilterUsed(false);
		if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
			File[] files = fileChooser.getSelectedFiles();
			int index = -1;
			for (File file : files) {
				index++;
				String filePath = file.getAbsolutePath();
				File folder = new File("/home/kibahero2802/TechDogProject/src/main/java/com/techdog/model/dataSave/"
						+ name.getText() + "-" + phoneNumber.getText());
				folder.mkdir();
				InputStream is = null;
				OutputStream os = null;
				try {
					File source = new File(filePath);
					File dest = new File(folder.getAbsolutePath() + "/" + file.getName());
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
					ImageIcon iIcon = new ImageIcon(dest.getAbsolutePath());
					if (parent.get(index) != null) {
						Image subImg = iIcon.getImage();
						iIcon = new ImageIcon(subImg.getScaledInstance(parent.get(index).getWidth(),
								parent.get(index).getHeight(), Image.SCALE_SMOOTH));
						parent.get(index).setIcon(iIcon);
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

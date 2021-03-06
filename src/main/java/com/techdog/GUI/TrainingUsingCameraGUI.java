package com.techdog.GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

import org.opencv.core.Mat;

import com.techdog.Controller.Camera;
import com.techdog.Controller.ImageProcessController;
import com.techdog.Controller.TrainingController;

public class TrainingUsingCameraGUI {
	List<Mat> listImageForTraining = new ArrayList<Mat>();
	public JFrame frame;
	private JTextField nameTxt;
	private JTextField phoneNumberTxt;

	/**
	 * Create the application.
	 */
	public TrainingUsingCameraGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Color color = new Color(77, 77, 77);
		Border border = BorderFactory.createLineBorder(color, 2);
		frame = new JFrame();
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {
				frame.dispose();
			}
		});
		frame.setBounds(100, 100, 900, 600);
		// frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel cameraLabel = new JLabel("");
		Thread cameraThread = new Thread() {
			public void run() {
				Camera.displayCamera(cameraLabel, 529, 258, true);
			}
		};
		cameraThread.start();

		cameraLabel.setBounds(12, 64, 529, 258);
		cameraLabel.setBorder(border);
		frame.getContentPane().add(cameraLabel);

		JLabel trainingImage_1 = new JLabel("");
		trainingImage_1.setBorder(border);
		trainingImage_1.setBounds(12, 371, 145, 84);
		frame.getContentPane().add(trainingImage_1);

		JLabel trainingImage_6 = new JLabel("");
		trainingImage_6.setBorder(border);
		trainingImage_6.setBounds(12, 467, 145, 84);
		frame.getContentPane().add(trainingImage_6);

		JLabel trainingImage_7 = new JLabel("");
		trainingImage_7.setBorder(border);
		trainingImage_7.setBounds(190, 467, 145, 84);
		frame.getContentPane().add(trainingImage_7);

		JLabel trainingImage_2 = new JLabel("");
		trainingImage_2.setBorder(border);
		trainingImage_2.setBounds(190, 371, 145, 84);
		frame.getContentPane().add(trainingImage_2);

		JLabel trainingImage_8 = new JLabel("");
		trainingImage_8.setBorder(border);
		trainingImage_8.setBounds(369, 467, 145, 84);
		frame.getContentPane().add(trainingImage_8);

		JLabel trainingImage_3 = new JLabel("");
		trainingImage_3.setBorder(border);
		trainingImage_3.setBounds(369, 371, 145, 84);
		frame.getContentPane().add(trainingImage_3);

		JLabel trainingImage_9 = new JLabel("");
		trainingImage_9.setBorder(border);
		trainingImage_9.setBounds(549, 467, 145, 84);
		frame.getContentPane().add(trainingImage_9);

		JLabel trainingImage_4 = new JLabel("");
		trainingImage_4.setBorder(border);
		trainingImage_4.setBounds(549, 371, 145, 84);
		frame.getContentPane().add(trainingImage_4);

		JLabel trainingImage_10 = new JLabel("");
		trainingImage_10.setBorder(border);
		trainingImage_10.setBounds(728, 467, 145, 84);
		frame.getContentPane().add(trainingImage_10);

		JLabel trainingImage_5 = new JLabel("");
		trainingImage_5.setBorder(border);
		trainingImage_5.setBounds(728, 371, 145, 84);
		frame.getContentPane().add(trainingImage_5);

		nameTxt = new JTextField();
		nameTxt.setBounds(583, 91, 250, 36);
		frame.getContentPane().add(nameTxt);
		nameTxt.setColumns(10);

//		phoneNumberTxt = new JTextField();
//		phoneNumberTxt.setColumns(10);
//		phoneNumberTxt.setBounds(583, 190, 250, 36);
//		frame.getContentPane().add(phoneNumberTxt);

		JLabel lblName = new JLabel("Name");
		lblName.setBounds(583, 64, 70, 15);
		frame.getContentPane().add(lblName);

//		JLabel lblPhoneNumber = new JLabel("Phone Number");
//		lblPhoneNumber.setBounds(583, 163, 250, 15);
//		frame.getContentPane().add(lblPhoneNumber);

		JLabel lblTraining = new JLabel("Training");
		lblTraining.setForeground(new Color(51, 51, 51));
		lblTraining.setFont(new Font("Dialog", Font.BOLD, 38));
		lblTraining.setHorizontalAlignment(SwingConstants.CENTER);
		lblTraining.setBounds(12, 0, 861, 52);
		frame.getContentPane().add(lblTraining);

		JButton btnTrain = new JButton("Train");
		btnTrain.setBounds(460, 563, 117, 25);
		frame.getContentPane().add(btnTrain);

		JButton btnTakeAPicture = new JButton("Take A Picture");
		// create list 10 label of this frame
		List<JLabel> listJLabel = Arrays.asList(trainingImage_1, trainingImage_2, trainingImage_3, trainingImage_4,
				trainingImage_5, trainingImage_6, trainingImage_7, trainingImage_8, trainingImage_9, trainingImage_10);
		// Click at Take a Picture button

		btnTakeAPicture.setBounds(166, 334, 168, 25);
		frame.getContentPane().add(btnTakeAPicture);
		btnTakeAPicture.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Mat addImage = Camera.getCurrentImage();
				if (addImage != null) {
					listImageForTraining.add(addImage);
				}
				TrainingController.loadImageToJlabel(listImageForTraining, listJLabel);
			}
		});
		// Button clear
		JButton btnClear = new JButton("Clear All");
		btnClear.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				listImageForTraining.clear();
				nameTxt.setText("");
				phoneNumberTxt.setText("");
				for (int i = 0; i < listJLabel.size(); i++) {
					listJLabel.get(i).setIcon(null);
				}
			}
		});
		btnClear.setBounds(320, 563, 117, 25);
		frame.getContentPane().add(btnClear);
		// action click for label image 1
		trainingImage_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				listImageForTraining = ImageProcessController.deleteAnImage(listImageForTraining, 0);
				TrainingController.loadImageToJlabel(listImageForTraining, listJLabel);
			}
		});
		trainingImage_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				listImageForTraining = ImageProcessController.deleteAnImage(listImageForTraining, 1);
				TrainingController.loadImageToJlabel(listImageForTraining, listJLabel);
			}
		});
		trainingImage_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				listImageForTraining = ImageProcessController.deleteAnImage(listImageForTraining, 2);
				TrainingController.loadImageToJlabel(listImageForTraining, listJLabel);
			}
		});
		trainingImage_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				listImageForTraining = ImageProcessController.deleteAnImage(listImageForTraining, 3);
				TrainingController.loadImageToJlabel(listImageForTraining, listJLabel);
			}
		});
		trainingImage_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				listImageForTraining = ImageProcessController.deleteAnImage(listImageForTraining, 4);
				TrainingController.loadImageToJlabel(listImageForTraining, listJLabel);
			}
		});
		trainingImage_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				listImageForTraining = ImageProcessController.deleteAnImage(listImageForTraining, 5);
				TrainingController.loadImageToJlabel(listImageForTraining, listJLabel);
			}
		});
		trainingImage_7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				listImageForTraining = ImageProcessController.deleteAnImage(listImageForTraining, 6);
				TrainingController.loadImageToJlabel(listImageForTraining, listJLabel);
			}
		});
		trainingImage_8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				listImageForTraining = ImageProcessController.deleteAnImage(listImageForTraining, 7);
				TrainingController.loadImageToJlabel(listImageForTraining, listJLabel);
			}
		});
		trainingImage_9.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				listImageForTraining = ImageProcessController.deleteAnImage(listImageForTraining, 8);
				TrainingController.loadImageToJlabel(listImageForTraining, listJLabel);
			}
		});
		trainingImage_10.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				listImageForTraining = ImageProcessController.deleteAnImage(listImageForTraining, 9);
				TrainingController.loadImageToJlabel(listImageForTraining, listJLabel);
			}
		});
	}
}

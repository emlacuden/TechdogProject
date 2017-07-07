package com.techdog.GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.text.AttributeSet.ColorAttribute;

import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TrainingUsingCameraGUI {

	public JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					TrainingUsingCameraGUI window = new TrainingUsingCameraGUI();
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

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
		Border border = BorderFactory.createLineBorder(color,2);
		frame = new JFrame();
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {
				frame.dispose();
			}
		});
		frame.setBounds(100, 100, 900, 600);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel cameraLabel = new JLabel("");
		cameraLabel.setBounds(12, 64, 529, 258);
		cameraLabel.setBorder(border);
		frame.getContentPane().add(cameraLabel);
		
		
		JButton btnTakeAPicture = new JButton("Take A Picture");
		btnTakeAPicture.setBounds(166, 334, 168, 25);
		frame.getContentPane().add(btnTakeAPicture);
		
		textField = new JTextField();
		textField.setBounds(583, 91, 250, 36);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel trainingImage_1 = new JLabel("");
		trainingImage_1.setBorder(border);
//		trainingImage_1.setBackground(Color.LIGHT_GRAY);
//		trainingImage_1.setForeground(Color.GRAY);
		trainingImage_1.setBounds(12, 371, 145, 84);
		frame.getContentPane().add(trainingImage_1);
		
		JLabel trainingImage_2 = new JLabel("");
		trainingImage_2.setBorder(border);
//		trainingImage_2.setBackground(Color.LIGHT_GRAY);
//		trainingImage_2.setForeground(Color.GRAY);
		trainingImage_2.setBounds(12, 467, 145, 84);
		frame.getContentPane().add(trainingImage_2);
		
		JLabel trainingImage_3 = new JLabel("");
		trainingImage_3.setBorder(border);
//		trainingImage_3.setBackground(Color.LIGHT_GRAY);
//		trainingImage_3.setForeground(Color.GRAY);
		trainingImage_3.setBounds(190, 467, 145, 84);
		frame.getContentPane().add(trainingImage_3);
		
		JLabel trainingImage_4 = new JLabel("");
		trainingImage_4.setBorder(border);
//		trainingImage_4.setBackground(Color.LIGHT_GRAY);
//		trainingImage_4.setForeground(Color.GRAY);
		trainingImage_4.setBounds(190, 371, 145, 84);
		frame.getContentPane().add(trainingImage_4);
		
		JLabel trainingImage_5 = new JLabel("");
		trainingImage_5.setBorder(border);
//		trainingImage_5.setBackground(Color.LIGHT_GRAY);
//		trainingImage_5.setForeground(Color.GRAY);
		trainingImage_5.setBounds(369, 467, 145, 84);
		frame.getContentPane().add(trainingImage_5);
		
		JLabel trainingImage_6 = new JLabel("");
		trainingImage_6.setBorder(border);
//		trainingImage_6.setBackground(Color.LIGHT_GRAY);
//		trainingImage_6.setForeground(Color.GRAY);
		trainingImage_6.setBounds(369, 371, 145, 84);
		frame.getContentPane().add(trainingImage_6);
		
		JLabel trainingImage_7 = new JLabel("");
		trainingImage_7.setBorder(border);
//		trainingImage_7.setBackground(Color.LIGHT_GRAY);
//		trainingImage_7.setForeground(Color.GRAY);
		trainingImage_7.setBounds(549, 467, 145, 84);
		frame.getContentPane().add(trainingImage_7);
		
		JLabel trainingImage_8 = new JLabel("");
		trainingImage_8.setBorder(border);
//		trainingImage_8.setBackground(Color.LIGHT_GRAY);
//		trainingImage_8.setForeground(Color.GRAY);
		trainingImage_8.setBounds(549, 371, 145, 84);
		frame.getContentPane().add(trainingImage_8);
		
		JLabel trainingImage_9 = new JLabel("");
		trainingImage_9.setBorder(border);
//		trainingImage_9.setBackground(Color.LIGHT_GRAY);
//		trainingImage_9.setForeground(Color.GRAY);
		trainingImage_9.setBounds(728, 467, 145, 84);
		frame.getContentPane().add(trainingImage_9);
		
		JLabel trainingImage_10 = new JLabel("");
		trainingImage_10.setBorder(border);
//		trainingImage_10.setBackground(Color.DARK_GRAY);
//		trainingImage_10.setForeground(Color.GRAY);
		trainingImage_10.setBounds(728, 371, 145, 84);
		frame.getContentPane().add(trainingImage_10);
		
		JButton btnTrain = new JButton("Train");
		btnTrain.setBounds(390, 563, 117, 25);
		frame.getContentPane().add(btnTrain);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(583, 190, 250, 36);
		frame.getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(583, 286, 250, 36);
		frame.getContentPane().add(textField_2);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(583, 64, 70, 15);
		frame.getContentPane().add(lblName);
		
		JLabel lblPhoneNumber = new JLabel("Phone Number");
		lblPhoneNumber.setBounds(583, 163, 250, 15);
		frame.getContentPane().add(lblPhoneNumber);
		
		JLabel lblFacebook = new JLabel("Facebook");
		lblFacebook.setBounds(583, 259, 70, 15);
		frame.getContentPane().add(lblFacebook);
		
		JLabel lblTraining = new JLabel("Training");
		lblTraining.setForeground(new Color(51, 51, 51));
		lblTraining.setFont(new Font("Dialog", Font.BOLD, 38));
		lblTraining.setHorizontalAlignment(SwingConstants.CENTER);
		lblTraining.setBounds(12, 0, 861, 52);
		frame.getContentPane().add(lblTraining);
	}
}


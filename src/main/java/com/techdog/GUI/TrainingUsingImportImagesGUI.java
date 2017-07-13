package com.techdog.GUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Arrays;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

import com.techdog.model.ImportImageAction;

public class TrainingUsingImportImagesGUI {
	public JFrame frame;
	private JTextField nametxt;
	private JTextField phoneNumbertxt;
	private JTextField facebooktxt;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TrainingUsingImportImagesGUI window = new TrainingUsingImportImagesGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TrainingUsingImportImagesGUI() {
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
		
		nametxt = new JTextField();
		nametxt.setBounds(335, 90, 250, 36);
		frame.getContentPane().add(nametxt);
		nametxt.setColumns(10);
		
		phoneNumbertxt = new JTextField();
		phoneNumbertxt.setColumns(10);
		phoneNumbertxt.setBounds(335, 150, 250, 36);
		frame.getContentPane().add(phoneNumbertxt);
		
		facebooktxt = new JTextField();
		facebooktxt.setColumns(10);
		facebooktxt.setBounds(335, 210, 250, 36);
		frame.getContentPane().add(facebooktxt);
		
		JLabel lblTraining = new JLabel("Training");
		lblTraining.setForeground(new Color(51, 51, 51));
		lblTraining.setFont(new Font("Dialog", Font.BOLD, 38));
		lblTraining.setHorizontalAlignment(SwingConstants.CENTER);
		lblTraining.setBounds(12, 0, 861, 52);
		frame.getContentPane().add(lblTraining);
		
		JLabel trainingImage_1 = new JLabel("");
		trainingImage_1.setBorder(border);
//		trainingImage_1.setBackground(Color.LIGHT_GRAY);
//		trainingImage_1.setForeground(Color.GRAY);
		trainingImage_1.setBounds(27, 302, 145, 84);
		frame.getContentPane().add(trainingImage_1);
		
		JLabel trainingImage_2 = new JLabel("");
		trainingImage_2.setBorder(border);
//		trainingImage_2.setBackground(Color.LIGHT_GRAY);
//		trainingImage_2.setForeground(Color.GRAY);
		trainingImage_2.setBounds(27, 398, 145, 84);
		frame.getContentPane().add(trainingImage_2);
		
		JLabel trainingImage_3 = new JLabel("");
		trainingImage_3.setBorder(border);
//		trainingImage_3.setBackground(Color.LIGHT_GRAY);
//		trainingImage_3.setForeground(Color.GRAY);
		trainingImage_3.setBounds(205, 398, 145, 84);
		frame.getContentPane().add(trainingImage_3);
		
		JLabel trainingImage_4 = new JLabel("");
		trainingImage_4.setBorder(border);
//		trainingImage_4.setBackground(Color.LIGHT_GRAY);
//		trainingImage_4.setForeground(Color.GRAY);
		trainingImage_4.setBounds(205, 302, 145, 84);
		frame.getContentPane().add(trainingImage_4);
		
		JLabel trainingImage_5 = new JLabel("");
		trainingImage_5.setBorder(border);
//		trainingImage_5.setBackground(Color.LIGHT_GRAY);
//		trainingImage_5.setForeground(Color.GRAY);
		trainingImage_5.setBounds(384, 398, 145, 84);
		frame.getContentPane().add(trainingImage_5);
		
		JLabel trainingImage_6 = new JLabel("");
		trainingImage_6.setBorder(border);
//		trainingImage_6.setBackground(Color.LIGHT_GRAY);
//		trainingImage_6.setForeground(Color.GRAY);
		trainingImage_6.setBounds(384, 302, 145, 84);
		frame.getContentPane().add(trainingImage_6);
		
		JLabel trainingImage_7 = new JLabel("");
		trainingImage_7.setBorder(border);
//		trainingImage_7.setBackground(Color.LIGHT_GRAY);
//		trainingImage_7.setForeground(Color.GRAY);
		trainingImage_7.setBounds(564, 398, 145, 84);
		frame.getContentPane().add(trainingImage_7);
		
		JLabel trainingImage_8 = new JLabel("");
		trainingImage_8.setBorder(border);
//		trainingImage_8.setBackground(Color.LIGHT_GRAY);
//		trainingImage_8.setForeground(Color.GRAY);
		trainingImage_8.setBounds(564, 302, 145, 84);
		frame.getContentPane().add(trainingImage_8);
		
		JLabel trainingImage_9 = new JLabel("");
		trainingImage_9.setBorder(border);
//		trainingImage_9.setBackground(Color.LIGHT_GRAY);
//		trainingImage_9.setForeground(Color.GRAY);
		trainingImage_9.setBounds(743, 398, 145, 84);
		frame.getContentPane().add(trainingImage_9);
		
		JLabel trainingImage_10 = new JLabel("");
		trainingImage_10.setBorder(border);
//		trainingImage_10.setBackground(Color.DARK_GRAY);
//		trainingImage_10.setForeground(Color.GRAY);
		trainingImage_10.setBounds(743, 302, 145, 84);
		frame.getContentPane().add(trainingImage_10);
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(335, 74, 70, 15);
		frame.getContentPane().add(lblName);
		
		JLabel lblPhoneNumber = new JLabel("Phone Number");
		lblPhoneNumber.setBounds(335, 127, 250, 27);
		frame.getContentPane().add(lblPhoneNumber);
		
		JLabel lblFacebook = new JLabel("Facebook");
		lblFacebook.setBounds(335, 195, 70, 15);
		frame.getContentPane().add(lblFacebook);
		
		JButton btnTrain = new JButton("Train");
		btnTrain.setBounds(398, 508, 117, 25);
		frame.getContentPane().add(btnTrain);
		
		JButton btnImport = new JButton("Import");
		btnImport.setBounds(398, 268, 117, 25);
		frame.getContentPane().add(btnImport);
		
		java.util.List<JLabel> listJLabel = Arrays.asList(trainingImage_1,trainingImage_2,trainingImage_3
				,trainingImage_4,trainingImage_5,trainingImage_6,trainingImage_7,trainingImage_8
				,trainingImage_9,trainingImage_10);
		btnImport.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ImportImageAction iIA = new ImportImageAction();
				iIA.Action(listJLabel, nametxt, phoneNumbertxt);
			}
		});
		btnTrain.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
	}
	
}

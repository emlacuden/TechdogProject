package com.techdog.GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Image;

import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Color;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLayeredPane;
import javax.swing.JLabel;
import javax.swing.JToggleButton;
import javax.swing.border.Border;

import com.techdog.Controller.Camera;
import com.techdog.Controller.ImageProcessController;
import com.techdog.Utils.Constant;
import com.techdog.Utils.DirectoryUtils;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;
import java.util.List;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainForm extends Thread {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		// System.out.println(Constant.getConstant("chaoem"));
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainForm window = new MainForm();
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
	public MainForm() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Color color = new Color(77, 77, 77);
		Border border = BorderFactory.createLineBorder(color, 2);
		frame = new JFrame();
		frame.setBounds(100, 100, 900, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 1.0, Double.MIN_VALUE };
		frame.getContentPane().setLayout(gridBagLayout);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		GridBagConstraints gbc_tabbedPane = new GridBagConstraints();
		gbc_tabbedPane.fill = GridBagConstraints.BOTH;
		gbc_tabbedPane.gridx = 0;
		gbc_tabbedPane.gridy = 0;
		frame.getContentPane().add(tabbedPane, gbc_tabbedPane);

		// CAMERA TAB
		JPanel camera = new JPanel();
		camera.setBackground(Color.WHITE);
		tabbedPane.addTab("Camera", null, camera, null);
		camera.setLayout(null);

		Image cameraFrame = null;
		try {
			cameraFrame = ImageIO.read(getClass().getResource("../../../resource/images/cctvImage.jpg"));

		} catch (Exception e) {
			System.out.println(e);
		}
		JLabel lblNewLabel = new JLabel(new ImageIcon(cameraFrame));
		Thread cameraThread = new Thread() {
			public void run() {
				Camera.displayCamera(lblNewLabel, 871, 521);
			}
		};
		cameraThread.start();

		lblNewLabel.setBounds(12, 26, 871, 521);
		camera.add(lblNewLabel);

		// ADMIN TAB
		JPanel admin = new JPanel();
		admin.setBackground(Color.WHITE);
		tabbedPane.addTab("Admin", null, admin, null);
		admin.setLayout(null);

		JLabel trainingImage_1 = new JLabel("");
		trainingImage_1.setBorder(border);
		trainingImage_1.setBounds(12, 107, 145, 84);
		admin.add(trainingImage_1);

		JLabel trainingImage_2 = new JLabel("");
		trainingImage_2.setBorder(border);
		trainingImage_2.setBounds(12, 203, 145, 84);
		admin.add(trainingImage_2);

		JLabel trainingImage_3 = new JLabel("");
		trainingImage_3.setBorder(border);
		trainingImage_3.setBounds(190, 203, 145, 84);
		admin.add(trainingImage_3);

		JLabel trainingImage_4 = new JLabel("");
		trainingImage_4.setBorder(border);
		trainingImage_4.setBounds(190, 107, 145, 84);
		admin.add(trainingImage_4);

		JLabel trainingImage_5 = new JLabel("");
		trainingImage_5.setBorder(border);
		trainingImage_5.setBounds(369, 203, 145, 84);
		admin.add(trainingImage_5);

		JLabel trainingImage_6 = new JLabel("");
		trainingImage_6.setBorder(border);
		trainingImage_6.setBounds(369, 107, 145, 84);
		admin.add(trainingImage_6);

		JLabel trainingImage_7 = new JLabel("");
		trainingImage_7.setBorder(border);
		trainingImage_7.setBounds(549, 203, 145, 84);
		admin.add(trainingImage_7);

		JLabel trainingImage_8 = new JLabel("");
		trainingImage_8.setBorder(border);
		trainingImage_8.setBounds(549, 107, 145, 84);
		admin.add(trainingImage_8);

		JLabel trainingImage_9 = new JLabel("");
		trainingImage_9.setBorder(border);
		trainingImage_9.setBounds(728, 203, 145, 84);
		admin.add(trainingImage_9);

		JLabel trainingImage_10 = new JLabel("");
		trainingImage_10.setBorder(border);
		trainingImage_10.setBounds(728, 107, 145, 84);
		admin.add(trainingImage_10);

		// toggle button for turn on/off NOTIFICATION
		JToggleButton tglbtnNewToggleButton = new JToggleButton("");
		tglbtnNewToggleButton.setBounds(270, 462, 100, 50);
		Image image = null;
		Image image2 = null;
		try {
			image = ImageIO.read(getClass().getResource("../../../resource/images/switchOff.png"));
			image2 = ImageIO.read(getClass().getResource("../../../resource/images/switchOn.png"));
		} catch (Exception e) {
			System.out.println(e);
		}
		tglbtnNewToggleButton.setIcon(new ImageIcon(image));
		tglbtnNewToggleButton.setSelectedIcon(new ImageIcon(image2));
		tglbtnNewToggleButton.setPressedIcon(new ImageIcon(image2));
		tglbtnNewToggleButton.setBorderPainted(false);
		admin.add(tglbtnNewToggleButton);
		// label text NOTIFICATION
		JLabel lblNotification = new JLabel("Notification:");
		lblNotification.setFont(new Font("Dialog", Font.BOLD, 21));
		lblNotification.setBounds(74, 497, 158, 15);
		admin.add(lblNotification);

		// label Set Confidence
		JLabel lblSetConfidence = new JLabel("Set Confidence:");
		lblSetConfidence.setFont(new Font("Dialog", Font.BOLD, 21));
		lblSetConfidence.setBounds(416, 497, 189, 15);
		admin.add(lblSetConfidence);
		// text field for Confidence
		textField = new JTextField();
		textField.setText("60");
		textField.setBounds(654, 479, 100, 33);
		admin.add(textField);
		textField.setColumns(10);
		//create list all label iamge 
		List<JLabel> listJLabel = Arrays.asList(trainingImage_1, trainingImage_2, trainingImage_3, trainingImage_4,
				trainingImage_5, trainingImage_6, trainingImage_7, trainingImage_8, trainingImage_9, trainingImage_10);
		
		// Conbo box to list all directory
		JComboBox comboBox = new JComboBox(DirectoryUtils.allSubDirectoryName(Constant.getConstant("dataurl")));
		ImageProcessController.loadKnownPersonImage(comboBox.getSelectedItem().toString(), listJLabel);
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < listJLabel.size(); i++) {
					listJLabel.get(i).setIcon(null);
				}
				ImageProcessController.loadKnownPersonImage(comboBox.getSelectedItem().toString(), listJLabel);
				//comboBox.getSelectedItem().toString();
				//
			}
		});
		comboBox.setBounds(356, 12, 189, 33);
		admin.add(comboBox);

		JButton btnUpdate = new JButton("Update");
		btnUpdate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

			}
		});
		btnUpdate.setBounds(253, 318, 117, 25);
		admin.add(btnUpdate);

		JButton btnDelete = new JButton("Delete");
		btnDelete.setBounds(533, 318, 117, 25);
		admin.add(btnDelete);

		JPanel trainingImages = new JPanel();
		trainingImages.setBackground(Color.WHITE);
		tabbedPane.addTab("Training Data", null, trainingImages, null);
		trainingImages.setLayout(null);

		JButton usingCameraButton = new JButton("");
		usingCameraButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TrainingUsingCameraGUI trainUsingCamera = new TrainingUsingCameraGUI();
				trainUsingCamera.frame.setVisible(true);
			}
		});
		usingCameraButton.setBackground(Color.WHITE);
		usingCameraButton.setForeground(Color.WHITE);
		try {
			Image cameraIcon = ImageIO.read(getClass().getResource("../../../resource/images/cameraIcon.png"));
			usingCameraButton.setIcon(new ImageIcon(cameraIcon));
		} catch (Exception ex) {
			System.out.println(ex);
		}
		usingCameraButton.setBounds(176, 218, 110, 100);
		trainingImages.add(usingCameraButton);

		JButton usingGallaryButton = new JButton("");
		usingGallaryButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TrainingUsingImportImagesGUI trainUsingImport = new TrainingUsingImportImagesGUI();
				trainUsingImport.frame.setVisible(true);
			}
		});
		usingGallaryButton.setForeground(Color.WHITE);
		usingGallaryButton.setBackground(Color.WHITE);
		try {
			Image gallaryIcon = ImageIO.read(getClass().getResource("../../../resource/images/gallaryIcon.png"));
			usingGallaryButton.setIcon(new ImageIcon(gallaryIcon));
		} catch (Exception e) {
			System.out.println(e);
		}
		usingGallaryButton.setBounds(568, 218, 110, 100);
		trainingImages.add(usingGallaryButton);
	}
}

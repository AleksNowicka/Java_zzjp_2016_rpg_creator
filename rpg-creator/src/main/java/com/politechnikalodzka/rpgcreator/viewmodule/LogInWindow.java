package com.politechnikalodzka.rpgcreator.viewmodule;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.JPasswordField;

public class LogInWindow {

	private JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LogInWindow window = new LogInWindow();
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
	public LogInWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.DARK_GRAY);
		frame.setBounds(100, 100, 227, 172);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblLogin = new JLabel("Login:");
		lblLogin.setForeground(Color.LIGHT_GRAY);
		lblLogin.setBounds(34, 36, 46, 14);
		frame.getContentPane().add(lblLogin);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setForeground(Color.LIGHT_GRAY);
		lblPassword.setBounds(34, 65, 60, 14);
		frame.getContentPane().add(lblPassword);
		
		textField = new JTextField();
		textField.setBounds(91, 33, 86, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setForeground(UIManager.getColor("Button.darkShadow"));
		btnLogin.setBackground(UIManager.getColor("Button.background"));
		btnLogin.setBounds(63, 95, 89, 23);
		frame.getContentPane().add(btnLogin);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(91, 62, 86, 20);
		frame.getContentPane().add(passwordField);
	}
}

package com.politechnikalodzka.rpgcreator.view;

import com.politechnikalodzka.rpgcreator.interfaces.FrameSetter;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.JPasswordField;

public class LogInView extends JFrame implements FrameSetter{

	public JButton loginButton;

	private JTextField loginTextField;
	private JPasswordField passwordField;
	private JLabel loginLabel;
	private JLabel passwordLabel;

	public LogInView(String title) {
		super(title);
		setupContentPane();
		setupComponents();
	}

	public void setupContentPane() {
		getContentPane().setBackground(Color.DARK_GRAY);
		setBounds(100, 100, 227, 172);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
	}

	public void setupComponents() {
		loginLabel = new JLabel("Login:");
		loginLabel.setForeground(Color.LIGHT_GRAY);
		loginLabel.setBounds(34, 36, 46, 14);
		getContentPane().add(loginLabel);

		passwordLabel = new JLabel("Password:");
		passwordLabel.setForeground(Color.LIGHT_GRAY);
		passwordLabel.setBounds(34, 65, 60, 14);
		getContentPane().add(passwordLabel);

		loginTextField = new JTextField();
		loginTextField.setBounds(91, 33, 86, 20);
		getContentPane().add(loginTextField);
		loginTextField.setColumns(10);

		loginButton = new JButton("Login");
		loginButton.setForeground(UIManager.getColor("Button.darkShadow"));
		loginButton.setBackground(UIManager.getColor("Button.background"));
		loginButton.setBounds(63, 95, 89, 23);
		getContentPane().add(loginButton);

		passwordField = new JPasswordField();
		passwordField.setBounds(91, 62, 86, 20);
		getContentPane().add(passwordField);
	}

	public void setupListeners() {

	}
}

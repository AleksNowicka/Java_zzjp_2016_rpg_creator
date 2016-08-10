package com.politechnikalodzka.rpgcreator.view;

import com.politechnikalodzka.rpgcreator.interfaces.FrameSetter;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Color;

public class WelcomeScreen extends JFrame implements FrameSetter{

	public JButton beginButton;

	private JLabel titleLabel;

	public WelcomeScreen(String title){
		super( title );

		setupContentPane();
		setupComponents();
	}

	public void setupContentPane() {
		getContentPane().setBackground(Color.DARK_GRAY);
		setBounds(100, 100, 450, 170);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
	}

	public void setupComponents() {
		titleLabel = new JLabel("RPG Character Creator");
		titleLabel.setForeground(Color.LIGHT_GRAY);
		titleLabel.setBounds(165, 39, 111, 14);
		getContentPane().add(titleLabel);

		beginButton = new JButton("Begin");
		beginButton.setBounds(175, 64, 89, 23);
		getContentPane().add(beginButton);
	}

	public void setupListeners() {

	}
}

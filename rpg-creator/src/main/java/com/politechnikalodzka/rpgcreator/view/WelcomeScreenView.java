package com.politechnikalodzka.rpgcreator.view;

import com.politechnikalodzka.rpgcreator.interfaces.FrameSetter;
import com.politechnikalodzka.rpgcreator.viewmodel.WelcomeScreenViewModel;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WelcomeScreenView extends JFrame implements FrameSetter{

	private WelcomeScreenViewModel welcomeScreenViewModel;
	private String appTitle;

	private JButton beginButton;
	private JLabel titleLabel;

	public WelcomeScreenView(String title){
		super( title );
		welcomeScreenViewModel = new WelcomeScreenViewModel();
		appTitle = title;
		setupContentPane();
		setupComponents();
		setupListeners();
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
		final WelcomeScreenView classInstance = this;

		beginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				welcomeScreenViewModel.setupNewFrame(appTitle);
				welcomeScreenViewModel.switchFrames(classInstance, welcomeScreenViewModel.getLogInView());
			}
		});
	}
}

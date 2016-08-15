package com.politechnikalodzka.rpgcreator.view;

import com.politechnikalodzka.rpgcreator.interfaces.FrameSetter;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JPanel;

public class EditExistingCharactersView extends JFrame implements FrameSetter{

	public JButton goBackButton;

	private JButton editCharacter1Button;
	private JButton editCharacter2Button;
	private JButton editCharacter3Button;
	private JPanel character1IconPanel;
	private JPanel character2IconPanel;
	private JPanel character3IconPanel;
	private JLabel frameNameLabel;
	private JLabel group1Label;
	private JLabel group2Label;
	private JLabel group3Label;

	public EditExistingCharactersView(String title) {
		super(title);

		setupContentPane();
		setupComponents();
	}

	public void setupContentPane() {
		getContentPane().setBackground(Color.DARK_GRAY);
		setResizable(false);
		setBounds(100, 100, 450, 260);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
	}

	public void setupComponents() {
		frameNameLabel = new JLabel("Edit existing characters");
		frameNameLabel.setForeground(Color.LIGHT_GRAY);
		frameNameLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		frameNameLabel.setBounds(100, 11, 260, 25);
		getContentPane().add(frameNameLabel);

		editCharacter1Button = new JButton("Character 1");
		editCharacter1Button.setBounds(21, 47, 89, 23);
		getContentPane().add(editCharacter1Button);

		editCharacter2Button = new JButton("Character 2");
		editCharacter2Button.setBounds(169, 47, 89, 23);
		getContentPane().add(editCharacter2Button);

		editCharacter3Button = new JButton("Character 3");
		editCharacter3Button.setBounds(314, 47, 89, 23);
		getContentPane().add(editCharacter3Button);

		group1Label = new JLabel("Group 1");
		group1Label.setFont(new Font("Tahoma", Font.PLAIN, 12));
		group1Label.setForeground(Color.LIGHT_GRAY);
		group1Label.setBounds(42, 81, 46, 14);
		getContentPane().add(group1Label);

		group2Label = new JLabel("Group 2");
		group2Label.setFont(new Font("Tahoma", Font.PLAIN, 12));
		group2Label.setForeground(Color.LIGHT_GRAY);
		group2Label.setBounds(189, 81, 46, 14);
		getContentPane().add(group2Label);

		group3Label = new JLabel("Group 2");
		group3Label.setForeground(Color.LIGHT_GRAY);
		group3Label.setFont(new Font("Tahoma", Font.PLAIN, 12));
		group3Label.setBounds(339, 81, 46, 14);
		getContentPane().add(group3Label);

		character1IconPanel = new JPanel();
		character1IconPanel.setBounds(21, 106, 89, 70);
		getContentPane().add(character1IconPanel);

		character2IconPanel = new JPanel();
		character2IconPanel.setBounds(171, 106, 87, 70);
		getContentPane().add(character2IconPanel);

		character3IconPanel = new JPanel();
		character3IconPanel.setBounds(314, 106, 89, 70);
		getContentPane().add(character3IconPanel);

		goBackButton = new JButton("Go back");
		goBackButton.setBounds(21, 197, 89, 23);
		getContentPane().add(goBackButton);
	}

	public void setupListeners() {

	}
}

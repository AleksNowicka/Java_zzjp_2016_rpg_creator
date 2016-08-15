package com.politechnikalodzka.rpgcreator.view;

import com.politechnikalodzka.rpgcreator.interfaces.FrameSetter;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class CharacterCreationView extends JFrame implements FrameSetter{

	public JButton saveButton;

	private JButton selectGroupButton;
	private JPanel characterViewPanel;
	private JComboBox genderComboBox;
	private JComboBox hairComboBox;
	private JComboBox hatComboBox;
	private JComboBox outfitComboBox;
	private JComboBox eyesComboBox;
	private JComboBox accessoriesComboBox;
	private JLabel frameNameLabel;
	private JLabel genderLabel;
	private JLabel hairLabel;
	private JLabel hatLabel;
	private JLabel outfitLabel;
	private JLabel eyesLabel;
	private JLabel accessoriesLabel;

	public CharacterCreationView(String title) {
		super(title);

		setupContentPane();
		setupComponents();
	}

	public void setupContentPane() {
		setResizable(false);
		getContentPane().setBackground(Color.DARK_GRAY);
		setBounds(100, 100, 450, 260);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
	}

	public void setupComponents() {
		frameNameLabel = new JLabel("Character Creation");
		frameNameLabel.setForeground(Color.WHITE);
		frameNameLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		frameNameLabel.setBounds(155, 11, 139, 21);
		getContentPane().add(frameNameLabel);

		genderLabel = new JLabel("Gender:");
		genderLabel.setForeground(Color.WHITE);
		genderLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		genderLabel.setBounds(10, 45, 46, 14);
		getContentPane().add(genderLabel);

		hairLabel = new JLabel("Hair:");
		hairLabel.setForeground(Color.WHITE);
		hairLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		hairLabel.setBounds(10, 70, 46, 14);
		getContentPane().add(hairLabel);

		hatLabel = new JLabel("Hat:");
		hatLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		hatLabel.setForeground(Color.WHITE);
		hatLabel.setBounds(10, 95, 46, 14);
		getContentPane().add(hatLabel);

		outfitLabel = new JLabel("Oufit:");
		outfitLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		outfitLabel.setForeground(Color.WHITE);
		outfitLabel.setBounds(10, 120, 46, 14);
		getContentPane().add(outfitLabel);

		eyesLabel = new JLabel("Eyes:");
		eyesLabel.setForeground(Color.WHITE);
		eyesLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		eyesLabel.setBounds(10, 145, 46, 14);
		getContentPane().add(eyesLabel);

		accessoriesLabel = new JLabel("Accessories");
		accessoriesLabel.setForeground(Color.WHITE);
		accessoriesLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		accessoriesLabel.setBounds(10, 170, 63, 14);
		getContentPane().add(accessoriesLabel);

		selectGroupButton = new JButton("Select Group");
		selectGroupButton.setBounds(10, 195, 99, 23);
		getContentPane().add(selectGroupButton);

		saveButton = new JButton("Save");
		saveButton.setBounds(119, 195, 77, 23);
		getContentPane().add(saveButton);

		characterViewPanel = new JPanel();
		characterViewPanel.setBounds(264, 43, 160, 175);
		getContentPane().add(characterViewPanel);

		genderComboBox = new JComboBox();
		genderComboBox.setModel(new DefaultComboBoxModel(new String[] {"male", "female"}));
		genderComboBox.setBounds(97, 43, 99, 20);
		getContentPane().add(genderComboBox);

		hairComboBox = new JComboBox();
		hairComboBox.setModel(new DefaultComboBoxModel(new String[] {"long", "short"}));
		hairComboBox.setBounds(97, 68, 99, 20);
		getContentPane().add(hairComboBox);

		hatComboBox = new JComboBox();
		hatComboBox.setModel(new DefaultComboBoxModel(new String[] {"ON", "OFF"}));
		hatComboBox.setBounds(97, 93, 99, 20);
		getContentPane().add(hatComboBox);

		outfitComboBox = new JComboBox();
		outfitComboBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3"}));
		outfitComboBox.setBounds(97, 118, 99, 20);
		getContentPane().add(outfitComboBox);

		eyesComboBox = new JComboBox();
		eyesComboBox.setModel(new DefaultComboBoxModel(new String[] {"brown", "green", "blue"}));
		eyesComboBox.setBounds(97, 143, 99, 20);
		getContentPane().add(eyesComboBox);

		accessoriesComboBox = new JComboBox();
		accessoriesComboBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3"}));
		accessoriesComboBox.setBounds(97, 168, 99, 20);
		getContentPane().add(accessoriesComboBox);
	}

	public void setupListeners() {

	}
}

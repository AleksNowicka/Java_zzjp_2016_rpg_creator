package com.politechnikalodzka.rpgcreator.view;

import com.politechnikalodzka.rpgcreator.interfaces.FrameSetter;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JEditorPane;

public class EditExistingCharactersView extends JFrame implements FrameSetter{

	public JButton goBackButton;
	private JPanel characterIconPanel;
	private JLabel frameNameLabel;

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

		characterIconPanel = new JPanel();
		characterIconPanel.setBounds(21, 48, 89, 125);
		getContentPane().add(characterIconPanel);

		goBackButton = new JButton("Go back");
		goBackButton.setBounds(21, 197, 89, 23);
		getContentPane().add(goBackButton);
		
		JComboBox characterComboBox = new JComboBox();
		characterComboBox.setModel(new DefaultComboBoxModel(new String[] {"Character1", "Character2", "Character3"}));
		characterComboBox.setBounds(137, 47, 191, 22);
		getContentPane().add(characterComboBox);
		
		JButton btnDeleteCharacter = new JButton("Delete character");
		btnDeleteCharacter.setBounds(309, 197, 113, 23);
		getContentPane().add(btnDeleteCharacter);
		
		JButton btnSave = new JButton("Save character");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnSave.setBounds(125, 197, 113, 23);
		getContentPane().add(btnSave);
		
		JEditorPane assignGroup = new JEditorPane();
		assignGroup.setText("Group1");
		assignGroup.setBounds(137, 88, 106, 20);
		getContentPane().add(assignGroup);
	}

	public void setupListeners() {

	}
}

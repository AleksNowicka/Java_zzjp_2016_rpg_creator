package com.politechnikalodzka.rpgcreator.view;

import com.politechnikalodzka.rpgcreator.interfaces.FrameSetter;
import com.politechnikalodzka.rpgcreator.viewmodel.EditExistingCharactersViewModel;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
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
import javax.swing.JTextField;

public class EditExistingCharactersView extends JFrame implements FrameSetter{

	private EditExistingCharactersViewModel editExistingCharactersViewModel;

	private JButton goBackButton;
	private JButton editCharacter1Button;
	private JButton editCharacter2Button;
	private JButton editCharacter3Button;
	private JPanel characterIconPanel;
	private JPanel character1IconPanel;
	private JPanel character2IconPanel;
	private JPanel character3IconPanel;
	private JLabel frameNameLabel;
	private JTextField textField;

	public EditExistingCharactersView(String title) throws SQLException, ClassNotFoundException {
		super(title);
		editExistingCharactersViewModel = new EditExistingCharactersViewModel(title);
		setupContentPane();
		setupComponents();
		setupListeners();
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
		
		JButton btnSave = new JButton("Edit character");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnSave.setBounds(125, 197, 113, 23);
		getContentPane().add(btnSave);
		
		JLabel lblGroup = new JLabel("Group1");
		lblGroup.setBounds(137, 80, 63, 25);
		getContentPane().add(lblGroup);
		
		textField = new JTextField();
		textField.setBounds(242, 80, 86, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
	}

	public void setupListeners() {
		final EditExistingCharactersView classInstance = this;

		goBackButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editExistingCharactersViewModel.switchFrames(classInstance, editExistingCharactersViewModel.getNavigationView());
			}
		});
	}
}

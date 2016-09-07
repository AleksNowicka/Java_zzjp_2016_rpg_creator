package com.politechnikalodzka.rpgcreator.view;

import com.politechnikalodzka.rpgcreator.interfaces.FrameSetter;
import com.politechnikalodzka.rpgcreator.utils.Pictures;
import com.politechnikalodzka.rpgcreator.viewmodel.EditExistingCharactersViewModel;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;

public class EditExistingCharactersView extends JFrame implements FrameSetter {

    private EditExistingCharactersViewModel editExistingCharactersViewModel;

    private JButton goBackButton;
    private JButton editCharacterButton;
    private JButton deleteCharacterButton;
    private JLabel frameNameLabel;
    private JLabel groupLabel;
    private JLabel groupNameLabel;
    private JComboBox characterComboBox;
    private List<JLabel> characters;

    public EditExistingCharactersView(String title) throws SQLException, ClassNotFoundException {
        super(title);
        editExistingCharactersViewModel = new EditExistingCharactersViewModel(title);
        characters = new ArrayList();
        setupContentPane();
        setupComponents();
        setupListeners();
    }

    public void setupContentPane() {
        getContentPane().setBackground(Color.DARK_GRAY);
        setResizable(false);
        setBounds(100, 100, 500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);
    }

    public void setupComponents() {
        frameNameLabel = new JLabel("Edit existing characters");
        frameNameLabel.setForeground(Color.LIGHT_GRAY);
        frameNameLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
        frameNameLabel.setBounds(100, 11, 260, 25);
        getContentPane().add(frameNameLabel);

        goBackButton = new JButton("Go back");
        goBackButton.setBounds(365, 396, 86, 23);
        getContentPane().add(goBackButton);

        characterComboBox = new JComboBox();
        characterComboBox.setModel(new DefaultComboBoxModel(editExistingCharactersViewModel.getAllUsersCharactersNames()));
        characterComboBox.setBounds(260, 47, 191, 22);
        getContentPane().add(characterComboBox);

        deleteCharacterButton = new JButton("Delete character");
        deleteCharacterButton.setBounds(338, 115, 113, 23);
        getContentPane().add(deleteCharacterButton);

        editCharacterButton = new JButton("Edit character");
        editCharacterButton.setBounds(338, 150, 113, 23);
        getContentPane().add(editCharacterButton);

        groupLabel = new JLabel("Group:");
        groupLabel.setForeground(Color.WHITE);
        groupLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
        groupLabel.setBounds(260, 80, 63, 25);
        getContentPane().add(groupLabel);

        groupNameLabel = new JLabel(editExistingCharactersViewModel.getCharactersGroupName(
                characterComboBox.getSelectedItem().toString()));
        groupNameLabel.setForeground(Color.WHITE);
        groupNameLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
        groupNameLabel.setBounds(365, 80, 86, 20);
        getContentPane().add(groupNameLabel);
    }

    public void setupListeners() {
        final EditExistingCharactersView classInstance = this;

        characterComboBox.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                groupNameLabel.setText(editExistingCharactersViewModel.getCharactersGroupName(
                        e.getItem().toString()));
                editExistingCharactersViewModel.getPictures()
                        .setCurrentCharacter(editExistingCharactersViewModel.getCharacterByName((String) characterComboBox.getSelectedItem()));
                editExistingCharactersViewModel.cleanCharacter(characters);
                editExistingCharactersViewModel.drawCharacter(classInstance, characters, 21, 48);
            }
        });

        deleteCharacterButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    editExistingCharactersViewModel.removeChosenCharacter(
                            characterComboBox.getSelectedItem().toString());
                    characterComboBox.setModel(new DefaultComboBoxModel(editExistingCharactersViewModel.getAllUsersCharactersNames()));
                } catch (SQLException e1) {
                    e1.printStackTrace();
                } catch (ClassNotFoundException e1) {
                    e1.printStackTrace();
                }
            }
        });

		editCharacterButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editExistingCharactersViewModel.setCharacterCreationViewCharacterToEdit(
						characterComboBox.getSelectedItem().toString());
				editExistingCharactersViewModel.switchFrames(classInstance, editExistingCharactersViewModel.getCharacterCreationView());
			}
		});

		goBackButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editExistingCharactersViewModel.switchFrames(classInstance, editExistingCharactersViewModel.getNavigationView());
			}
		});
	}
}

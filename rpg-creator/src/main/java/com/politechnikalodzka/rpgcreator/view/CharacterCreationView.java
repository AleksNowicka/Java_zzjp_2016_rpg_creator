package com.politechnikalodzka.rpgcreator.view;

import com.politechnikalodzka.rpgcreator.enums.Gender;
import com.politechnikalodzka.rpgcreator.enums.TypeOfPictrues;
import com.politechnikalodzka.rpgcreator.enums.ViewModeEnum;
import com.politechnikalodzka.rpgcreator.interfaces.FrameSetter;
import com.politechnikalodzka.rpgcreator.viewmodel.CharacterCreationViewModel;

import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CharacterCreationView extends JFrame implements FrameSetter {

    private CharacterCreationViewModel characterCreationViewModel;

    private JButton saveButton;
	private JPanel characterViewPanel;
	private JComboBox genderComboBox;
	private JComboBox hairComboBox;
	private JComboBox hatComboBox;
	private JComboBox outfitComboBox;
	private JComboBox eyesComboBox;
	private JComboBox accessoriesComboBox;
	private JComboBox selectGroupComboBox;
    private JLabel frameNameLabel;
    private JLabel genderLabel;
    private JLabel hairLabel;
    private JLabel hatLabel;
    private JLabel outfitLabel;
    private JLabel eyesLabel;
    private JLabel accessoriesLabel;
    private List<JLabel> characters;
	private JLabel groupLabel;

    public CharacterCreationView(String title, ViewModeEnum viewModeEnum) throws SQLException, ClassNotFoundException {
        super(title);
        characterCreationViewModel = new CharacterCreationViewModel(title);
        characters = new ArrayList();
        characterCreationViewModel.setDefaultDrawList();
        characterCreationViewModel.drawCharacter(this, characters);
        setupContentPane();
        setupComponents();
        setupListeners();
    }

    public void setupContentPane() {
        setResizable(false);
        getContentPane().setBackground(Color.DARK_GRAY);
        setBounds(100, 100, 450, 500);
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

		groupLabel = new JLabel("Group");
		groupLabel.setForeground(Color.WHITE);
		groupLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		groupLabel.setBounds(10, 195, 63, 14);
		getContentPane().add(groupLabel);

		selectGroupComboBox = new JComboBox();
		selectGroupComboBox.setModel(new DefaultComboBoxModel(characterCreationViewModel.getGroupsNames()));
		selectGroupComboBox.setBounds(97, 195, 99, 20);
		getContentPane().add(selectGroupComboBox);

		saveButton = new JButton("Save");
		saveButton.setBounds(50, 250, 100, 23);
		getContentPane().add(saveButton);

        genderComboBox = new JComboBox();
        genderComboBox.setModel(new DefaultComboBoxModel(characterCreationViewModel.getGenderList()));
        genderComboBox.setBounds(97, 43, 99, 20);
        getContentPane().add(genderComboBox);

        hairComboBox = new JComboBox();
        hairComboBox.setModel(new DefaultComboBoxModel(characterCreationViewModel.getHairList()));
        hairComboBox.setBounds(97, 68, 99, 20);
        getContentPane().add(hairComboBox);

        hatComboBox = new JComboBox();
        hatComboBox.setModel(new DefaultComboBoxModel(characterCreationViewModel.getHatList()));
        hatComboBox.setBounds(97, 93, 99, 20);
        getContentPane().add(hatComboBox);

        outfitComboBox = new JComboBox();
        outfitComboBox.setModel(new DefaultComboBoxModel(characterCreationViewModel.getOutfitList()));
        outfitComboBox.setBounds(97, 118, 99, 20);
        getContentPane().add(outfitComboBox);

        eyesComboBox = new JComboBox();
        eyesComboBox.setModel(new DefaultComboBoxModel(characterCreationViewModel.getEyesList()));
        eyesComboBox.setBounds(97, 143, 99, 20);
        getContentPane().add(eyesComboBox);

        accessoriesComboBox = new JComboBox();
        accessoriesComboBox.setModel(new DefaultComboBoxModel(characterCreationViewModel.getAccessoriesList()));
        accessoriesComboBox.setBounds(97, 168, 99, 20);
        getContentPane().add(accessoriesComboBox);
    }

    public void setupListeners() {
        final CharacterCreationView classInstance = this;

        //TODO Przetestowanie rysowania poszczeg�lnych element�w postaci.
        genderComboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String gender = (String) genderComboBox.getSelectedItem();
                characterCreationViewModel.getPictures().setGender(Gender.valueOf(gender));
                hairComboBox.setModel(new DefaultComboBoxModel(characterCreationViewModel.getHairList()));
                accessoriesComboBox.setModel(new DefaultComboBoxModel(characterCreationViewModel.getAccessoriesList()));
                eyesComboBox.setModel(new DefaultComboBoxModel(characterCreationViewModel.getEyesList()));
                outfitComboBox.setModel(new DefaultComboBoxModel(characterCreationViewModel.getOutfitList()));
                hatComboBox.setModel(new DefaultComboBoxModel(characterCreationViewModel.getHatList()));
                //characterCreationViewModel.setDefaultDrawList();
                characterCreationViewModel.cleanCharacter(characters);                  
                characterCreationViewModel.drawCharacter(classInstance, characters);
            }
        });

        hairComboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Integer id = (Integer) hairComboBox.getSelectedItem();
                characterCreationViewModel.getPictures().choosePicture(id);
                characterCreationViewModel.cleanCharacter(characters);
                characterCreationViewModel.drawCharacter(classInstance, characters);
            }
        }
        );

        hatComboBox.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                Integer id = (Integer) hatComboBox.getSelectedItem();
                characterCreationViewModel.getPictures().choosePicture(id);
                characterCreationViewModel.cleanCharacter(characters);
                characterCreationViewModel.drawCharacter(classInstance, characters);
            }

        });

        outfitComboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Integer id = (Integer) outfitComboBox.getSelectedItem();
                characterCreationViewModel.getPictures().choosePicture(id);
                characterCreationViewModel.cleanCharacter(characters);
                characterCreationViewModel.drawCharacter(classInstance, characters);
            }

        });

        eyesComboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Integer id = (Integer) eyesComboBox.getSelectedItem();
                characterCreationViewModel.getPictures().choosePicture(id);
                characterCreationViewModel.cleanCharacter(characters);
                characterCreationViewModel.drawCharacter(classInstance, characters);
            }

        });

        accessoriesComboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Integer id = (Integer) accessoriesComboBox.getSelectedItem();
                characterCreationViewModel.getPictures().choosePicture(id);
                characterCreationViewModel.cleanCharacter(characters);
                characterCreationViewModel.drawCharacter(classInstance, characters);
            }

        });

        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                characterCreationViewModel.switchFrames(classInstance, characterCreationViewModel.getNavigationView());
            }

        });
    }
}

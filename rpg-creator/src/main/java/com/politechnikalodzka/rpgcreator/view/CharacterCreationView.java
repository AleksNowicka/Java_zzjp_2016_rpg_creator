package com.politechnikalodzka.rpgcreator.view;

import com.politechnikalodzka.rpgcreator.database.Character;
import com.politechnikalodzka.rpgcreator.enums.Gender;
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

    private ViewModeEnum viewMode;

    private JButton saveButton;
    private JButton goBackButton;
    private JTextField nameTextField;
    private JComboBox genderComboBox;
    private JComboBox hairComboBox;
    private JComboBox hatComboBox;
    private JComboBox outfitComboBox;
    private JComboBox eyesComboBox;
    private JComboBox accessoriesComboBox;
    private JComboBox selectGroupComboBox;
    private JLabel frameNameLabel;
    private JLabel nameLabel;
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
        this.viewMode = viewModeEnum;
        characterCreationViewModel = new CharacterCreationViewModel(title);
        setupContentPane();
        setupComponents();
        setupListeners();
        characters = new ArrayList();
        if(viewMode.equals(ViewModeEnum.CREATE)) {
            characterCreationViewModel.setDefaultDrawList();
        }
        characterCreationViewModel.drawCharacter(this, characters, 230, 43);
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

        nameLabel = new JLabel("Name:");
        nameLabel.setForeground(Color.WHITE);
        nameLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
        nameLabel.setBounds(10, 70, 46, 14);
        getContentPane().add(nameLabel);

        genderLabel = new JLabel("Gender:");
        genderLabel.setForeground(Color.WHITE);
        genderLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
        genderLabel.setBounds(10, 95, 46, 14);
        getContentPane().add(genderLabel);

        hairLabel = new JLabel("Hair:");
        hairLabel.setForeground(Color.WHITE);
        hairLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
        hairLabel.setBounds(10, 120, 46, 14);
        getContentPane().add(hairLabel);

        hatLabel = new JLabel("Hat:");
        hatLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
        hatLabel.setForeground(Color.WHITE);
        hatLabel.setBounds(10, 145, 46, 14);
        getContentPane().add(hatLabel);

        outfitLabel = new JLabel("Oufit:");
        outfitLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
        outfitLabel.setForeground(Color.WHITE);
        outfitLabel.setBounds(10, 170, 46, 14);
        getContentPane().add(outfitLabel);

        eyesLabel = new JLabel("Eyes:");
        eyesLabel.setForeground(Color.WHITE);
        eyesLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
        eyesLabel.setBounds(10, 195, 46, 14);
        getContentPane().add(eyesLabel);

        accessoriesLabel = new JLabel("Accessories");
        accessoriesLabel.setForeground(Color.WHITE);
        accessoriesLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
        accessoriesLabel.setBounds(10, 220, 63, 14);
        getContentPane().add(accessoriesLabel);

        groupLabel = new JLabel("Group");
        groupLabel.setForeground(Color.WHITE);
        groupLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
        groupLabel.setBounds(10, 245, 63, 14);
        getContentPane().add(groupLabel);

        selectGroupComboBox = new JComboBox();
        selectGroupComboBox.setModel(new DefaultComboBoxModel(characterCreationViewModel.getGroupsNames()));
        selectGroupComboBox.setBounds(97, 245, 99, 20);
        getContentPane().add(selectGroupComboBox);

        saveButton = new JButton("Save");
        saveButton.setBounds(120, 300, 100, 23);
        getContentPane().add(saveButton);

        goBackButton = new JButton("Go back");
        goBackButton.setBounds(10, 300, 100, 23);
        getContentPane().add(goBackButton);

        nameTextField = new JTextField();
        nameTextField.setBounds(97, 68, 99, 20);
        getContentPane().add(nameTextField);

        genderComboBox = new JComboBox();
        genderComboBox.setModel(new DefaultComboBoxModel(characterCreationViewModel.getGenderList()));
        genderComboBox.setBounds(97, 93, 99, 20);
        getContentPane().add(genderComboBox);

        hairComboBox = new JComboBox();
        hairComboBox.setModel(new DefaultComboBoxModel(characterCreationViewModel.getHairList()));
        hairComboBox.setBounds(97, 118, 99, 20);
        getContentPane().add(hairComboBox);

        hatComboBox = new JComboBox();
        hatComboBox.setModel(new DefaultComboBoxModel(characterCreationViewModel.getHatList()));
        hatComboBox.setBounds(97, 143, 99, 20);
        getContentPane().add(hatComboBox);

        outfitComboBox = new JComboBox();
        outfitComboBox.setModel(new DefaultComboBoxModel(characterCreationViewModel.getOutfitList()));
        outfitComboBox.setBounds(97, 168, 99, 20);
        getContentPane().add(outfitComboBox);

        eyesComboBox = new JComboBox();
        eyesComboBox.setModel(new DefaultComboBoxModel(characterCreationViewModel.getEyesList()));
        eyesComboBox.setBounds(97, 193, 99, 20);
        getContentPane().add(eyesComboBox);

        accessoriesComboBox = new JComboBox();
        accessoriesComboBox.setModel(new DefaultComboBoxModel(characterCreationViewModel.getAccessoriesList()));
        accessoriesComboBox.setBounds(97, 218, 99, 20);
        getContentPane().add(accessoriesComboBox);
    }

    public void setupEditedCharacterData(){
        //TODO - add setting pictures
        nameTextField.setText(characterCreationViewModel.getEditedCharacter().getName());
        genderComboBox.setSelectedItem(characterCreationViewModel.getEditedCharactersGender().toString());
        hairComboBox.setSelectedItem(characterCreationViewModel.getEditedCharacter().getHairId());
        hatComboBox.setSelectedItem(characterCreationViewModel.getEditedCharacter().getHatId());
        outfitComboBox.setSelectedItem(characterCreationViewModel.getEditedCharacter().getOutfitId());
        eyesComboBox.setSelectedItem(characterCreationViewModel.getEditedCharacter().getEyesId());
        accessoriesComboBox.setSelectedItem(characterCreationViewModel.getEditedCharacter().getAccessoriesId());
        selectGroupComboBox.setSelectedItem(characterCreationViewModel.getGroupNammeById(
                characterCreationViewModel.getEditedCharacter().getGroupId()));
        characterCreationViewModel.setSpecificDrawList();
        characterCreationViewModel.drawCharacter(this, characters, 230, 43);
    }

    public void setupListeners() {
        final CharacterCreationView classInstance = this;

        genderComboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String gender = (String) genderComboBox.getSelectedItem();
                characterCreationViewModel.getPictures().setGender(Gender.valueOf(gender));
                hairComboBox.setModel(new DefaultComboBoxModel(characterCreationViewModel.getHairList()));
                accessoriesComboBox.setModel(new DefaultComboBoxModel(characterCreationViewModel.getAccessoriesList()));
                eyesComboBox.setModel(new DefaultComboBoxModel(characterCreationViewModel.getEyesList()));
                outfitComboBox.setModel(new DefaultComboBoxModel(characterCreationViewModel.getOutfitList()));
                hatComboBox.setModel(new DefaultComboBoxModel(characterCreationViewModel.getHatList()));
                characterCreationViewModel.setDefaultDrawList();
                characterCreationViewModel.cleanCharacter(characters);
                characterCreationViewModel.drawCharacter(classInstance, characters, 230, 43);
            }
        });

        hairComboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Integer id = (Integer) hairComboBox.getSelectedItem();
                characterCreationViewModel.getPictures().choosePicture(id);
                characterCreationViewModel.cleanCharacter(characters);
                characterCreationViewModel.drawCharacter(classInstance, characters, 230, 43);
            }
        }
        );

        hatComboBox.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                Integer id = (Integer) hatComboBox.getSelectedItem();
                characterCreationViewModel.getPictures().choosePicture(id);
                characterCreationViewModel.cleanCharacter(characters);
                characterCreationViewModel.drawCharacter(classInstance, characters, 230, 43);
            }

        });

        outfitComboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Integer id = (Integer) outfitComboBox.getSelectedItem();
                characterCreationViewModel.getPictures().choosePicture(id);
                characterCreationViewModel.cleanCharacter(characters);
                characterCreationViewModel.drawCharacter(classInstance, characters, 230, 43);
            }

        });

        eyesComboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Integer id = (Integer) eyesComboBox.getSelectedItem();
                characterCreationViewModel.getPictures().choosePicture(id);
                characterCreationViewModel.cleanCharacter(characters);
                characterCreationViewModel.drawCharacter(classInstance, characters, 230, 43);
            }

        });

        accessoriesComboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Integer id = (Integer) accessoriesComboBox.getSelectedItem();
                characterCreationViewModel.getPictures().choosePicture(id);
                characterCreationViewModel.cleanCharacter(characters);
                characterCreationViewModel.drawCharacter(classInstance, characters, 230, 43);
            }

        });

        goBackButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                characterCreationViewModel.switchFrames(classInstance, characterCreationViewModel.getNavigationView());
            }
        });

        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(viewMode.equals(ViewModeEnum.EDIT)){
                    try {
                        characterCreationViewModel.getEditedCharacter().setName(nameTextField.getText());
                        if(Gender.valueOf(genderComboBox.getSelectedItem().toString()).equals(Gender.FEMALE)) {
                            characterCreationViewModel.getEditedCharacter().setGender(false);
                        }
                        else{
                            characterCreationViewModel.getEditedCharacter().setGender(true);
                        }
                        characterCreationViewModel.getEditedCharacter().setHairId((Integer) hairComboBox.getSelectedItem());
                        characterCreationViewModel.getEditedCharacter().setHatId((Integer) hatComboBox.getSelectedItem());
                        characterCreationViewModel.getEditedCharacter().setOutfitId((Integer) outfitComboBox.getSelectedItem());
                        characterCreationViewModel.getEditedCharacter().setEyesId((Integer) eyesComboBox.getSelectedItem());
                        characterCreationViewModel.getEditedCharacter().setAccessoriesId((Integer) accessoriesComboBox.getSelectedItem());
                        characterCreationViewModel.getEditedCharacter().setGroupId(characterCreationViewModel.getGroupIdByName(
                                selectGroupComboBox.getSelectedItem().toString()));
                        characterCreationViewModel.saveAsEditedCharacter();
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    } catch (ClassNotFoundException e1) {
                        e1.printStackTrace();
                    }
                    characterCreationViewModel.switchFrames(classInstance, characterCreationViewModel.getNavigationView());
                    return;
                }
                try {
                    Character newCharacterToSave = new Character();
                    newCharacterToSave.setName(nameTextField.getText());
                    if(Gender.valueOf(genderComboBox.getSelectedItem().toString()).equals(Gender.FEMALE)) {
                        newCharacterToSave.setGender(false);
                    }
                    else{
                        newCharacterToSave.setGender(true);
                    }
                    newCharacterToSave.setHairId((Integer) hairComboBox.getSelectedItem());
                    newCharacterToSave.setHatId((Integer) hatComboBox.getSelectedItem());
                    newCharacterToSave.setOutfitId((Integer) outfitComboBox.getSelectedItem());
                    newCharacterToSave.setEyesId((Integer) eyesComboBox.getSelectedItem());
                    newCharacterToSave.setAccessoriesId((Integer) accessoriesComboBox.getSelectedItem());
                    newCharacterToSave.setGroupId(characterCreationViewModel.getGroupIdByName(
                            selectGroupComboBox.getSelectedItem().toString()));
                    characterCreationViewModel.saveNewCharacter(newCharacterToSave);
                } catch (ClassNotFoundException e1) {
                    e1.printStackTrace();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
                characterCreationViewModel.switchFrames(classInstance, characterCreationViewModel.getNavigationView());
            }

        });
    }

    public void setCharacterToEdit(Character characterToEdit){
        characterCreationViewModel.setEditedCharacter(characterToEdit);
    }

}

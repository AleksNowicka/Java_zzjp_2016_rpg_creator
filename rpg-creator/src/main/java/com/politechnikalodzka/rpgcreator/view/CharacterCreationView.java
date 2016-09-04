package com.politechnikalodzka.rpgcreator.view;

import com.politechnikalodzka.rpgcreator.enums.ViewModeEnum;
import com.politechnikalodzka.rpgcreator.interfaces.FrameSetter;
import com.politechnikalodzka.rpgcreator.viewmodel.CharacterCreationViewModel;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class CharacterCreationView extends JFrame implements FrameSetter {

    private CharacterCreationViewModel characterCreationViewModel;

    private JButton saveButton;
    private JComboBox selectGroupButton;
    //private JPanel characterViewPanel;
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
    private List<JLabel> characters;

    public CharacterCreationView(String title, ViewModeEnum viewModeEnum) throws SQLException, ClassNotFoundException {
        super(title);
        characterCreationViewModel = new CharacterCreationViewModel(title);
        characters = new ArrayList();
        characterCreationViewModel.getPictures().choosePicture(characterCreationViewModel.getHairList()[0]);
        characterCreationViewModel.getPictures().choosePicture(characterCreationViewModel.getAccessoriesList()[0]);
        characterCreationViewModel.getPictures().choosePicture(characterCreationViewModel.getEyesList()[0]);
        characterCreationViewModel.getPictures().choosePicture(characterCreationViewModel.getHatList()[0]);
        characterCreationViewModel.getPictures().choosePicture(characterCreationViewModel.getOutfitList()[0]);
        characterCreationViewModel.drawCharacter(this, characters);
        setupContentPane();
        setupComponents();
        setupListeners();
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

        //TODO - reorganize with this new combobox
        selectGroupButton = new JComboBox();
        selectGroupButton.setModel(new DefaultComboBoxModel(characterCreationViewModel.getGroupsNames()));
        selectGroupButton.setBounds(10, 195, 99, 23);
        getContentPane().add(selectGroupButton);

        saveButton = new JButton("Save");
        saveButton.setBounds(119, 195, 77, 23);
        getContentPane().add(saveButton);

//        characterViewPanel = new JPanel();
//        characterViewPanel.setBounds(264, 43, 160, 175);
//        getContentPane().add(characterViewPanel);

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

        //TODO Przetestowanie rysowania poszczególnych elementów postaci.
        genderComboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Integer id = (Integer) genderComboBox.getSelectedItem();
                characterCreationViewModel.getPictures().choosePicture(id);
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

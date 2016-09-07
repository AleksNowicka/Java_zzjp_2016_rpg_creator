package com.politechnikalodzka.rpgcreator.view;

import com.politechnikalodzka.rpgcreator.database.Group;
import com.politechnikalodzka.rpgcreator.enums.ViewModeEnum;
import com.politechnikalodzka.rpgcreator.interfaces.FrameSetter;
import com.politechnikalodzka.rpgcreator.viewmodel.GroupCreationViewModel;

import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.SQLException;

public class GroupCreationView extends JFrame implements FrameSetter {

    private GroupCreationViewModel groupCreationViewModel;

    private ViewModeEnum viewMode;

    private JButton saveButton;
    private JButton goBackButton;
    private JButton chooseIconButton;
    private JTextField nameTextField;
    private JTextField descriptionTextField;
    private JLabel frameNameLabel;
    private JLabel nameLabel;
    private JLabel descriptionLabel;
    private JLabel maxGroupMembersLabel;
    private JLabel membersLabel;
    private JComboBox maxGroupMembersComboBox;
    private JLabel groupIconPanel;

    public GroupCreationView(String title, ViewModeEnum viewModeEnum) throws SQLException, ClassNotFoundException {
        super(title);
        groupCreationViewModel = new GroupCreationViewModel(title);
        this.viewMode = viewModeEnum;
        setupContentPane();
        setupComponents();
        setupListeners();
    }

    public void setupContentPane() {
        setResizable(false);
        getContentPane().setBackground(Color.DARK_GRAY);
        getContentPane().setLayout(null);
        setBounds(100, 100, 450, 260);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void setupComponents() {
        frameNameLabel = new JLabel("Group Creation");
        frameNameLabel.setForeground(Color.LIGHT_GRAY);
        frameNameLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
        frameNameLabel.setBounds(143, 11, 153, 25);
        getContentPane().add(frameNameLabel);

        nameLabel = new JLabel("Name:");
        nameLabel.setForeground(Color.LIGHT_GRAY);
        nameLabel.setBounds(24, 62, 46, 14);
        getContentPane().add(nameLabel);

        descriptionLabel = new JLabel("Description:");
        descriptionLabel.setForeground(Color.LIGHT_GRAY);
        descriptionLabel.setBounds(24, 87, 67, 14);
        getContentPane().add(descriptionLabel);

        maxGroupMembersLabel = new JLabel("Max group");
        maxGroupMembersLabel.setHorizontalAlignment(SwingConstants.LEFT);
        maxGroupMembersLabel.setVerticalAlignment(SwingConstants.TOP);
        maxGroupMembersLabel.setForeground(Color.LIGHT_GRAY);
        maxGroupMembersLabel.setBounds(24, 157, 56, 20);
        getContentPane().add(maxGroupMembersLabel);

        nameTextField = new JTextField();
        nameTextField.setBounds(90, 59, 86, 20);
        getContentPane().add(nameTextField);
        nameTextField.setColumns(10);

        descriptionTextField = new JTextField();
        descriptionTextField.setBounds(90, 87, 128, 59);
        getContentPane().add(descriptionTextField);
        descriptionTextField.setColumns(10);

        membersLabel = new JLabel("members:");
        membersLabel.setForeground(Color.LIGHT_GRAY);
        membersLabel.setBounds(24, 173, 67, 14);
        getContentPane().add(membersLabel);

        maxGroupMembersComboBox = new JComboBox();
        maxGroupMembersComboBox.setModel(new DefaultComboBoxModel(new String[]{"3", "5", "10"}));
        maxGroupMembersComboBox.setBounds(90, 163, 46, 20);
        getContentPane().add(maxGroupMembersComboBox);

        groupIconPanel = new JLabel();
        groupIconPanel.setBounds(322, 90, 90, 90);
        getContentPane().add(groupIconPanel);

        chooseIconButton = new JButton("Load image");
        chooseIconButton.setBounds(322, 62, 89, 23);
        getContentPane().add(chooseIconButton);

        saveButton = new JButton("Save ");
        saveButton.setBounds(230, 195, 89, 23);
        getContentPane().add(saveButton);

        goBackButton = new JButton("Go back");
        goBackButton.setBounds(133, 195, 89, 23);
        getContentPane().add(goBackButton);
    }

    public void setupEditedGroupData() {
        //TODO - add reading icon
        nameTextField.setText(groupCreationViewModel.getEditedGroup().getName());
        descriptionTextField.setText(groupCreationViewModel.getEditedGroup().getDescription());
        maxGroupMembersComboBox.setSelectedItem(groupCreationViewModel.getEditedGroup().getMaxGroupMembers());
    }

    public void setupListeners() {
        final GroupCreationView classInstance = this;

        chooseIconButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
                int result = fileChooser.showOpenDialog(classInstance);
                if (result == JFileChooser.APPROVE_OPTION) {
                    groupCreationViewModel.getEditedGroup().setGroupIcon(fileChooser.getSelectedFile().getPath());
                    groupCreationViewModel.drawGroupIcon(groupIconPanel, groupCreationViewModel.getEditedGroup());
                }
            }
        });

        goBackButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                groupCreationViewModel.switchFrames(classInstance, groupCreationViewModel.getNavigationView());
            }
        });

        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (viewMode.equals(ViewModeEnum.EDIT)) {
                    try {
                        //TODO - add saving icon
                        groupCreationViewModel.getEditedGroup().setName(nameTextField.getText());
                        groupCreationViewModel.getEditedGroup().setDescription(descriptionTextField.getText());
                        groupCreationViewModel.getEditedGroup().setMaxGroupMembers(
                                Integer.parseInt(maxGroupMembersComboBox.getSelectedItem().toString()));
                        groupCreationViewModel.saveEditedGroup();
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    } catch (ClassNotFoundException e1) {
                        e1.printStackTrace();
                    }
                    groupCreationViewModel.switchFrames(classInstance, groupCreationViewModel.getNavigationView());
                    return;
                }
                try {
                    //TODO - add saving group icon
                    Group group = new Group();
                    group.setName(nameTextField.getText());
                    group.setDescription(descriptionTextField.getText());
                    group.setMaxGroupMembers(Integer.parseInt(maxGroupMembersComboBox.getSelectedItem().toString()));
                    group.setGroupIcon(groupCreationViewModel.getEditedGroup().getGroupIcon());
                    System.out.println(groupCreationViewModel.getEditedGroup().getGroupIcon());
                    groupCreationViewModel.saveNewGroup(group);
                } catch (ClassNotFoundException e1) {
                    e1.printStackTrace();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
                groupCreationViewModel.switchFrames(classInstance, groupCreationViewModel.getNavigationView());
            }
        });
    }

    public void setGroupToEdit(Group groupToEdit) {
        groupCreationViewModel.setEditedGroup(groupToEdit);
    }
}

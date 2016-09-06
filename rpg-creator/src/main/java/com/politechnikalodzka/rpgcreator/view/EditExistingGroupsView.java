package com.politechnikalodzka.rpgcreator.view;

import com.politechnikalodzka.rpgcreator.interfaces.FrameSetter;
import com.politechnikalodzka.rpgcreator.viewmodel.EditExistingGroupsViewModel;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.SQLException;

public class EditExistingGroupsView extends JFrame implements FrameSetter{

    private EditExistingGroupsViewModel editExistingGroupsViewModel;

    private JButton deleteGroupButton;
    private JButton saveGroupButton;
    private JButton goBackButton;
	private JList characterList;
	private JPanel groupIcon;
	private JLabel frameNameLabel;
	private JComboBox selectGroupComboBox;

	public EditExistingGroupsView(String title) throws SQLException, ClassNotFoundException {
		super(title);
        editExistingGroupsViewModel = new EditExistingGroupsViewModel(title);
		setupContentPane();
		setupComponents();
        setupListeners();
	}

	public void setupContentPane() {
		getContentPane().setBackground(Color.DARK_GRAY);
		getContentPane().setLayout(null);
		setBounds(100, 100, 450, 260);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void setupComponents() {
		frameNameLabel = new JLabel("Edit existing groups");
		frameNameLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		frameNameLabel.setForeground(Color.LIGHT_GRAY);
		frameNameLabel.setBackground(Color.WHITE);
		frameNameLabel.setBounds(123, 11, 211, 25);
		getContentPane().add(frameNameLabel);
		
		selectGroupComboBox = new JComboBox();
		selectGroupComboBox.setModel(new DefaultComboBoxModel(editExistingGroupsViewModel.getUserGroupsNames()));
		selectGroupComboBox.setBounds(137, 47, 191, 22);
		getContentPane().add(selectGroupComboBox);
		
		groupIcon = new JPanel();
		groupIcon.setBounds(18, 47, 89, 125);
		getContentPane().add(groupIcon);
		
		characterList = new JList();
		characterList.setModel(new AbstractListModel() {
			String[] values = editExistingGroupsViewModel.getUserGroupCharactersNames(
					selectGroupComboBox.getSelectedItem().toString());
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		characterList.setBounds(137, 80, 97, 92);
		getContentPane().add(characterList);
		
		goBackButton = new JButton("Go back");
		goBackButton.setBounds(18, 187, 89, 23);
		getContentPane().add(goBackButton);
		
		saveGroupButton = new JButton("Edit group");
		saveGroupButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		saveGroupButton.setBounds(180, 187, 113, 23);
		getContentPane().add(saveGroupButton);
		
		deleteGroupButton = new JButton("Delete group");
		deleteGroupButton.setBounds(299, 187, 113, 23);
		getContentPane().add(deleteGroupButton);
	}

	public void setupListeners() {
        final EditExistingGroupsView classInstance = this;

		selectGroupComboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				characterList.setModel(new AbstractListModel() {
					String[] values = editExistingGroupsViewModel.getUserGroupCharactersNames(
							selectGroupComboBox.getSelectedItem().toString());
					public int getSize() {
						return values.length;
					}
					public Object getElementAt(int index) {
						return values[index];
					}
				});
			}
		});

        goBackButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                editExistingGroupsViewModel.switchFrames(classInstance, editExistingGroupsViewModel.getNavigationView());
            }
        });
	}
}

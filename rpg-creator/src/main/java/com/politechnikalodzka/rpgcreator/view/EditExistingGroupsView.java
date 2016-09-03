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
import javax.swing.JList;
import javax.swing.AbstractListModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EditExistingGroupsView extends JFrame implements FrameSetter{

	private JLabel frameNameLabel;
	private JComboBox groupComboBox;

	public EditExistingGroupsView(String title) {
		super(title);
		setupContentPane();
		setupComponents();
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
		
		groupComboBox = new JComboBox();
		groupComboBox.setModel(new DefaultComboBoxModel(new String[] {"Group1", "Group2", "Group3"}));
		groupComboBox.setBounds(137, 47, 191, 22);
		getContentPane().add(groupComboBox);
		
		JPanel groupIcon = new JPanel();
		groupIcon.setBounds(18, 47, 89, 125);
		getContentPane().add(groupIcon);
		
		JList list = new JList();
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {"Character1", "Character2", "Character3"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		list.setBounds(137, 80, 97, 92);
		getContentPane().add(list);
		
		JButton button = new JButton("Go back");
		button.setBounds(18, 187, 89, 23);
		getContentPane().add(button);
		
		JButton btnSaveGroup = new JButton("Edit group");
		btnSaveGroup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnSaveGroup.setBounds(123, 187, 113, 23);
		getContentPane().add(btnSaveGroup);
		
		JButton btnDeleteGroup = new JButton("Delete group");
		btnDeleteGroup.setBounds(299, 187, 113, 23);
		getContentPane().add(btnDeleteGroup);
	}

	public void setupListeners() {

	}
}

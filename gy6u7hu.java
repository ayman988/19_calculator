package g.edu.alexu.csd.oop.calculator;

import java.awt.EventQueue;
import java.util.*;
import java.lang.*;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.SystemColor;

public class  gy6u7hu {
	calc obj=new calc();
	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gy6u7hu window = new gy6u7hu();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public gy6u7hu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBackground(new Color(211, 211, 211));
		frame.getContentPane().setBackground(new Color(255, 160, 122));
		frame.setBounds(100, 100, 569, 375);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("NEXT");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 10));
		btnNewButton.setForeground(new Color(220, 20, 60));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(obj.iter<obj.index-1) {String s=obj.next();
				textField.setText(s);}
				else {JOptionPane.showMessageDialog(null,"NO HISTORY!");}
			}
		});
		
		textField = new JTextField();
		textField.setBounds(97, 60, 365, 42);
		textField.setBackground(Color.LIGHT_GRAY);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		btnNewButton.setBounds(69, 208, 85, 34);
		btnNewButton.setBackground(Color.LIGHT_GRAY);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("PREV");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 10));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    if(obj.iter==0) {JOptionPane.showMessageDialog(null,"NO HISTORY!");}
			    else{String s=obj.prev();
				textField.setText(s);}
			}
		});
		btnNewButton_1.setForeground(new Color(220, 20, 60));
		btnNewButton_1.setBounds(389, 208, 85, 34);
		btnNewButton_1.setBackground(Color.LIGHT_GRAY);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("SAVE");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(obj.index==0) {JOptionPane.showMessageDialog(null,"NO DATA!");}
				else{obj.save();}
			}
		});
		btnNewButton_2.setForeground(new Color(220, 20, 60));
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 10));
		btnNewButton_2.setBounds(69, 273, 85, 34);
		btnNewButton_2.setBackground(Color.LIGHT_GRAY);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("LOAD");
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 10));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				obj.load();
				
			}
		});
		btnNewButton_3.setForeground(new Color(220, 20, 60));
		btnNewButton_3.setBounds(389, 273, 85, 34);
		btnNewButton_3.setBackground(Color.LIGHT_GRAY);
		frame.getContentPane().add(btnNewButton_3);
		
		JButton btnAns = new JButton("ANS");
		btnAns.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s=textField.getText();
				if(!obj.match(s)) {JOptionPane.showMessageDialog(null,"NOT VALID!");}
				textField.setText(obj.getResult());
				
			}
		});
		btnAns.setForeground(new Color(220, 20, 60));
		btnAns.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 10));
		btnAns.setBounds(235, 273, 85, 34);
		btnAns.setBackground(Color.LIGHT_GRAY);
		frame.getContentPane().add(btnAns);
		
		JButton btnNewButton_4 = new JButton("CLEAR");
		btnNewButton_4.setForeground(new Color(220, 20, 60));
		btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 10));
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
			}
		});
		btnNewButton_4.setBackground(Color.LIGHT_GRAY);
		btnNewButton_4.setBounds(235, 208, 85, 34);
		frame.getContentPane().add(btnNewButton_4);
		
		JLabel lblOperation = new JLabel("operation:");
		lblOperation.setForeground(new Color(0, 128, 128));
		lblOperation.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblOperation.setBounds(10, 60, 77, 42);
		frame.getContentPane().add(lblOperation);
		
		JButton btnNewButton_5 = new JButton("ENTER");
		btnNewButton_5.setForeground(new Color(220, 20, 60));
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s=textField.getText();
				if(!obj.match(s)) {JOptionPane.showMessageDialog(null,"NOT VALID!");}
				else {obj.input(s);}
			}
		});
		btnNewButton_5.setBackground(Color.LIGHT_GRAY);
		btnNewButton_5.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 10));
		btnNewButton_5.setBounds(472, 60, 73, 42);
		frame.getContentPane().add(btnNewButton_5);
	}
}

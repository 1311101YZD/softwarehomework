package UI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Control.LoginControl;
import Model.Login;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class ModifyUsers extends JDialog {

	private JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	final String [] temp = new String[3];
	public SettingUI localfather;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the dialog.
	 */
	public ModifyUsers(SettingUI father) {
		localfather = father;
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u4FEE\u6539\u5BA2\u6237\u4FE1\u606F");
		lblNewLabel.setBounds(144, 10, 111, 23);
		contentPanel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(199, 48, 129, 22);
		contentPanel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(202, 99, 126, 23);
		contentPanel.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(199, 152, 134, 22);
		contentPanel.add(textField_2);
		textField_2.setColumns(10);
		
		final JComboBox comboBox = new JComboBox();
		comboBox.setBounds(43, 196, 102, 21);
		contentPanel.add(comboBox);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"", "超级管理员", "管理员"}));
		
		int rowNum = localfather.getTable().getSelectedRow();
		textField.setText(localfather.getTable().getModel().getValueAt(rowNum, 0).toString());
		textField_1.setText(localfather.getTable().getModel().getValueAt(rowNum, 1).toString());
		if(localfather.getTable().getModel().getValueAt(rowNum, 2).toString().equals("超级管理员"))
		{
			comboBox.setSelectedIndex(1);
		}
		else
		{
			comboBox.setSelectedIndex(2);
		}
		
		JButton btnNewButton_3 = new JButton("\u8FD4\u56DE");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SettingUI mainui = new SettingUI();
				mainui.setVisible(true);
				dispose();
			}
		});
		btnNewButton_3.setBounds(318, 189, 93, 35);
		contentPanel.add(btnNewButton_3);
		{
			JButton okButton = new JButton("\u786E\u5B9A");
			okButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					temp[0] = textField.getText();
					temp[1]	= comboBox.getSelectedItem().toString();
					temp[2] = textField_1.getText();
					
					
					if(temp[2].equals(""))
					{
						JOptionPane.showConfirmDialog(null, "密码不能为空！","提示", JOptionPane.CLOSED_OPTION);
					}
					else if((!temp[2].equals(""))&&(temp[1].equals("")))
					{
						JOptionPane.showConfirmDialog(null, "请选择登录权限！","提示", JOptionPane.CLOSED_OPTION);
					}
					
					else
					{
						String role;
						if(temp[1].equals("超级管理员"))
						{
							role = "0";
						}
						else
						{
							role = "1";
						}
						
						Login newLogin = new Login(temp[0],temp[2],role);
						LoginControl.getLoginControl().merge(newLogin);
						
						localfather.InitialTable();
						
						
						JOptionPane.showMessageDialog(null, "结账成功！", "提示",JOptionPane.INFORMATION_MESSAGE);
						SettingUI ui = new SettingUI();
						ui.setVisible(true);
						dispose();
					}
					
				}
			});
			okButton.setBounds(228, 189, 81, 35);
			contentPanel.add(okButton);
			okButton.setActionCommand("OK");
			getRootPane().setDefaultButton(okButton);
		}
		
		JLabel lblNewLabel_1 = new JLabel("\u7528\u6237\u540D");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(43, 43, 111, 35);
		contentPanel.add(lblNewLabel_1);
		
		JLabel label = new JLabel("\u5BC6\u7801");
		label.setFont(new Font("宋体", Font.PLAIN, 15));
		label.setBounds(43, 93, 111, 35);
		contentPanel.add(label);
		
		JLabel label_1 = new JLabel("\u786E\u8BA4\u5BC6\u7801");
		label_1.setFont(new Font("宋体", Font.PLAIN, 15));
		label_1.setBounds(43, 145, 111, 35);
		contentPanel.add(label_1);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
		}
	}
}

package UI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import Control.LoginControl;
import Model.Login;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddManage extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	static SettingUI localfather;
	final String [] temp = new String[4];

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			AddManage dialog = new AddManage(localfather);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AddManage(SettingUI father) {
		localfather=father;
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u7528\u6237\u540D");
		lblNewLabel.setBounds(25, 10, 109, 40);
		contentPanel.add(lblNewLabel);
		
		JLabel label = new JLabel("\u5BC6\u7801");
		label.setBounds(25, 60, 109, 40);
		contentPanel.add(label);
		
		JLabel label_1 = new JLabel("\u786E\u8BA4\u5BC6\u7801");
		label_1.setBounds(25, 110, 109, 40);
		contentPanel.add(label_1);
		
		final JComboBox comboBox = new JComboBox();
		comboBox.setBounds(189, 167, 99, 21);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"", "超级管理员", "管理员"}));
		contentPanel.add(comboBox);
		
		JLabel label_2 = new JLabel("\u6743\u9650");
		label_2.setBounds(25, 160, 109, 40);
		contentPanel.add(label_2);
		
		textField = new JTextField();
		textField.setBounds(155, 20, 200, 31);
		contentPanel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(155, 60, 200, 31);
		contentPanel.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(155, 120, 200, 31);
		contentPanel.add(textField_2);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("\u786E\u8BA4");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						temp[0] = textField.getText();
						temp[1]	= textField_1.getText();	
						temp[2]	= comboBox.getSelectedItem().toString();
						temp[3] = textField_2.getText();
						
						boolean nameUnique = true;
						for(int i = 0;i < localfather.list.size(); i++)
						{
							if(temp[0].equals(((Login)localfather.list.get(i)).getUserName().toString()))
							{
								nameUnique = false;
								break;
							}
						}
						
						if((temp[0].equals(""))||(temp[1].equals(""))||(temp[3].equals("")))
						{
							JOptionPane.showConfirmDialog(null, "用户名和密码不能为空！","提示", JOptionPane.CLOSED_OPTION);
						}
						else if((!temp[0].equals(""))&&(!temp[1].equals(""))
								&&(!temp[3].equals(""))&&(temp[2].equals("")))
						{
							JOptionPane.showConfirmDialog(null, "请选择登录权限！","提示", JOptionPane.CLOSED_OPTION);
						}
						else if(!temp[1].equals(temp[3]))
						{
							JOptionPane.showConfirmDialog(null, "密码不一致！","提示", JOptionPane.CLOSED_OPTION);
						}
						else if(!nameUnique)
						{
							JOptionPane.showConfirmDialog(null, "用户名已存在！","提示", JOptionPane.CLOSED_OPTION);
						}
						else
						{
							String role;
							if(temp[2].equals("超级管理员"))
							{
								role="0";
							}
							else
							{
								role = "1";
							}
						
							DefaultTableModel tableModel = (DefaultTableModel) localfather.getTable().getModel();
							tableModel.addRow(new Object[] {
									temp[0],temp[1],temp[2]});
							LoginControl.getLoginControl().saveLogin(temp[0], temp[1], role);
							
							localfather.InitialTable();
							JOptionPane.showMessageDialog(null, "添加成功！", "提示",JOptionPane.INFORMATION_MESSAGE);
							dispose();
							}
						}

					
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("\u8FD4\u56DE");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}

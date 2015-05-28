package UI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;

import Control.LoginControl;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginUI extends JDialog {

	private final JPanel contentPanel = new JPanel();
	
	private JButton okButton;
	private int logonResult;
	
	private JTextField usrNameField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			LoginUI dialog = new LoginUI();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public LoginUI() {
		LoginControl.getLoginControl().getLoginByName("a");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u6B22\u8FCE\u4F7F\u7528");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 25));
		lblNewLabel.setBounds(106, 20, 163, 37);
		contentPanel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u7528\u6237\u540D");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(28, 87, 82, 27);
		contentPanel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u5BC6\u7801");
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(28, 143, 82, 37);
		contentPanel.add(lblNewLabel_2);
		
		usrNameField = new JTextField();
		usrNameField.setBounds(118, 92, 243, 27);
		contentPanel.add(usrNameField);
		usrNameField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(120, 150, 243, 27);
		contentPanel.add(passwordField);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
		}
		{
			final JButton okButton = new JButton("\u767B\u5F55");
			okButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(LoginControl.isUser(usrNameField.getText(),String.valueOf(passwordField.getPassword())))
						
						{
								logonResult=Control.LoginControl.getUserRoll(usrNameField.getText());
								okButton.setActionCommand("OK");
								MainUI main =new MainUI();
								main.setVisible(true);
								dispose(); 
						}
						else
						{
								logonResult=-1;
								JOptionPane.showMessageDialog(null, "用户名/密码错误！", "警告",JOptionPane.INFORMATION_MESSAGE);
								passwordField.setText(null);
						}
					
				}
			});
			okButton.setFont(new Font("宋体", Font.PLAIN, 15));
			okButton.setBounds(263, 195, 76, 46);
			contentPanel.add(okButton);
			okButton.setActionCommand("OK");
			getRootPane().setDefaultButton(okButton);
		}
		
		
	}
}

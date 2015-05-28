package UI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;

import org.hibernate.cfg.Configuration;

import Factory.HibernateSessionFactory;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;

public class Backup extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField hotel_13;
	private int Result;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Backup dialog = new Backup();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Backup() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("\u6570\u636E\u5E93\u5907\u4EFD");
			lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 18));
			lblNewLabel.setBounds(147, 26, 184, 34);
			contentPanel.add(lblNewLabel);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("\u6240\u9009\u8DEF\u5F84");
			lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 15));
			lblNewLabel_1.setBounds(29, 85, 103, 34);
			contentPanel.add(lblNewLabel_1);
		}
		{
			textField = new JTextField();
			textField.setBounds(126, 92, 184, 27);
			contentPanel.add(textField);
			textField.setColumns(10);
		}
		{
			JButton okButton = new JButton("\u786E\u5B9A");
			okButton.addActionListener(new ActionListener() {
				private String pwd;
				public void actionPerformed(ActionEvent e) {
					Configuration config = HibernateSessionFactory.getConfiguration();  
		    	     String binPath = config.getProperty("C:/Program Files/mysql-5.6.24-win32/bin");  
		    	     String userName = config.getProperty("root");  
		    	     String pwd = config.getProperty("123456"); 
		    	       Service.BackupService bak = new Service.BackupService(binPath,userName, pwd);
		    	       Result = Service.BackupService.backup(textField.getText(),"hotel_13");
		    	       JOptionPane.showMessageDialog(null, "备份成功！", "提示",JOptionPane.INFORMATION_MESSAGE);
		    	       MainUI main = new MainUI();
		    	       main.setVisible(true);
		    	       dispose();
				}
			});
			okButton.setBounds(356, 195, 68, 23);
			contentPanel.add(okButton);
			okButton.setActionCommand("OK");
			getRootPane().setDefaultButton(okButton);
		}
		{
			JButton btnNewButton = new JButton("...");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JFileChooser fileChooser = new JFileChooser();
					fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
					int returnValue = fileChooser.showOpenDialog(null);
					if (returnValue == JFileChooser.APPROVE_OPTION) {
					File file = fileChooser.getSelectedFile();
					textField.setText(file.getAbsolutePath() + "\\backup.sql");
					}
					
				}
			});
			btnNewButton.setBounds(331, 96, 93, 23);
			contentPanel.add(btnNewButton);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
		}
	}

}

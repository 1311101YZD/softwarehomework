package UI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;

public class MainUI extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			MainUI dialog = new MainUI();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public MainUI() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JButton btnNewButton_1 = new JButton("\u7ED3\u8D26");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CheckOut check = new CheckOut();
				check.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(231, 66, 147, 55);
		contentPanel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("\u7528\u6237\u7BA1\u7406");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SettingUI modify = new SettingUI();
				modify.setVisible(true);
				dispose();
			}
		});
		btnNewButton_2.setBounds(26, 155, 147, 52);
		contentPanel.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("\u8F66\u4F4D\u7BA1\u7406");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ParkingManage park = new ParkingManage();
				park.setVisible(true);
				dispose();
				
			}
		});
		btnNewButton_3.setBounds(26, 66, 147, 55);
		contentPanel.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("\u8FD4\u56DE");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginUI log =new LoginUI();
				log.setVisible(true);
				dispose();
			}
		});
		btnNewButton_4.setBounds(356, 212, 57, 29);
		contentPanel.add(btnNewButton_4);
		
		JLabel lblNewLabel = new JLabel("\u6B22\u8FCE\u4F7F\u7528");
		lblNewLabel.setFont(new Font("ËÎÌו", Font.PLAIN, 24));
		lblNewLabel.setBounds(158, 10, 173, 46);
		contentPanel.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("\u5907\u4EFD\u6570\u636E\u5E93");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Backup ba = new Backup();
				ba.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(238, 155, 140, 52);
		contentPanel.add(btnNewButton);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
		}
	}
}

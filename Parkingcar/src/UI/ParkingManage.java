package UI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ParkingManage extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ParkingManage dialog = new ParkingManage();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ParkingManage() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JButton btnNewButton = new JButton("\u589E\u52A0\u8F66\u4F4D");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddParking add = new AddParking();
				add.setVisible(true);
				dispose();
			
			}
		});
		btnNewButton.setBounds(54, 45, 106, 43);
		contentPanel.add(btnNewButton);
		
		JButton button = new JButton("\u7981\u7528\u8F66\u4F4D");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StopParking stop = new StopParking();
				stop.setVisible(true);
				dispose();
			}
		});
		button.setBounds(243, 45, 106, 43);
		contentPanel.add(button);
		{
			JButton okButton = new JButton("\u8FD4\u56DE");
			okButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					MainUI mainui = new MainUI();
					mainui.setVisible(true);
					dispose();
				}
			});
			okButton.setBounds(243, 143, 106, 43);
			contentPanel.add(okButton);
			okButton.setActionCommand("OK");
			getRootPane().setDefaultButton(okButton);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
		}
	}
}

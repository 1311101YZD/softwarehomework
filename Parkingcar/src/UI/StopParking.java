package UI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;

import Model.Parking;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class StopParking extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			StopParking dialog = new StopParking();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public StopParking() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("\u8F66\u5E93\u53F7");
			lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 20));
			lblNewLabel.setBounds(50, 57, 112, 43);
			contentPanel.add(lblNewLabel);
		}
		{
			JLabel label = new JLabel("\u7C7B\u578B");
			label.setFont(new Font("宋体", Font.PLAIN, 20));
			label.setBounds(50, 142, 112, 43);
			contentPanel.add(label);
		}
		{
			textField = new JTextField();
			textField.setBounds(172, 70, 151, 30);
			contentPanel.add(textField);
			textField.setColumns(10);
		}
		{
			textField_1 = new JTextField();
			textField_1.setColumns(10);
			textField_1.setBounds(172, 155, 151, 30);
			contentPanel.add(textField_1);
		}
		textField.addFocusListener(new FocusAdapter(){
			 public void focusLost(FocusEvent e){
				 Parking parking = Control.ParkingControl.getRoomControl().getRoomByParkingID(textField.getText());
					textField_1.setText(parking.getParkingType());
			 }
		});
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("\u786E\u8BA4");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Parking parking = Control.ParkingControl.getRoomControl().getRoomByParkingID(textField.getText());
						parking.setParkingStatus("3");
						Control.ParkingControl.getRoomControl().update(parking);
						JOptionPane.showMessageDialog(null, "禁用成功！", "提示",JOptionPane.INFORMATION_MESSAGE);
						dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("\u8FD4\u56DE");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						ParkingManage park = new ParkingManage();
						park.setVisible(true);
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}

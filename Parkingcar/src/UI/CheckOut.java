package UI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Control.CustomerControl;
import Model.*;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

public class CheckOut extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the dialog.
	 */
	public CheckOut() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("\u8F66\u5E93\u53F7");
			lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 15));
			lblNewLabel.setBounds(29, 32, 85, 36);
			contentPanel.add(lblNewLabel);
		}
		{
			JLabel label = new JLabel("\u59D3\u540D");
			label.setFont(new Font("宋体", Font.PLAIN, 15));
			label.setBounds(29, 99, 85, 36);
			contentPanel.add(label);
		}
		{
			JLabel label = new JLabel("\u6D88\u8D39");
			label.setFont(new Font("宋体", Font.PLAIN, 15));
			label.setBounds(29, 159, 85, 36);
			contentPanel.add(label);
		}
		{
			textField = new JTextField();
			textField.setBounds(178, 37, 154, 28);
			contentPanel.add(textField);
			textField.setColumns(10);
		}
		{
			textField_1 = new JTextField();
			textField_1.setColumns(10);
			textField_1.setBounds(178, 107, 154, 28);
			contentPanel.add(textField_1);
		}
		{
			textField_2 = new JTextField();
			textField_2.setColumns(10);
			textField_2.setBounds(178, 167, 154, 28);
			contentPanel.add(textField_2);
		}
		
		textField.addFocusListener(new FocusAdapter() {
			 public void focusLost(FocusEvent e) {
				
				 Customer customer = Control.CustomerControl.getCustomerControl().getCustomerByParking(Control.ParkingControl.getRoomControl().getRoomByParkingID(textField.getText()));
				 
				 Timestamp formatTime1=customer.getArrivalTime();
					Timestamp formatTime2=new Timestamp(System.currentTimeMillis());
					SimpleDateFormat timeformat = new SimpleDateFormat("yyyy-MM-dd,HH:mm:ss");
			        long t1 = 0L;
			        long t2 = 0L;
			        try {
			            t1 = timeformat.parse(getTimeStampNumberFormat(formatTime1)).getTime();
			        } catch (ParseException e1) {
			            // TODO Auto-generated catch block
			            e1.printStackTrace();
			        }
			        try {
			            t2 = timeformat.parse(getTimeStampNumberFormat(formatTime2)).getTime();
			        } catch (ParseException e1) {
			            // TODO Auto-generated catch block
			            e1.printStackTrace();
			        }
			        //因为t1-t2得到的是毫秒级,所以要初3600000得出小时.算天数或秒同理
			        int hours=(int) ((t2 - t1)/3600000+1);
			       
				 
				
				 textField_2.setText(String.valueOf((customer.getDepositCash()+20*hours)));	
					
				textField_1.setText(customer.getName()); 
	              
	            }
		});
	
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("\u786E\u5B9A");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						JOptionPane.showMessageDialog(null, "结账成功！", "提示",JOptionPane.INFORMATION_MESSAGE);
					}
				});
				buttonPane.add(okButton);
				okButton.setActionCommand("OK");
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("\u8FD4\u56DE");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						MainUI mainui = new MainUI();
						mainui.setVisible(true);
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	public static String getTimeStampNumberFormat(Timestamp formatTime) {
        SimpleDateFormat m_format = new SimpleDateFormat("yyyy-MM-dd,HH:mm:ss", new Locale("zh", "cn"));
        return m_format.format(formatTime);
    }

}

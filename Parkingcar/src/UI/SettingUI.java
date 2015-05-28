package UI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Control.LoginControl;
import Model.Login;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.List;

public class SettingUI extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	SettingUI gui = this;
	public static List list;
	private String [] itemsOperator = {"���Ӳ���Ա","ɾ������Ա","�޸Ĳ���Ա"};

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			SettingUI dialog = new SettingUI();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public SettingUI() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 291, 208);
		contentPanel.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u7528\u6237\u540D", "\u5BC6\u7801", "\u6743\u9650"
			}
		));
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("\u6DFB\u52A0\u7528\u6237");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddManage add = new AddManage(gui);
				add.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				add.setVisible(true);
			}
		});
		btnNewButton.setBounds(319, 32, 93, 41);
		contentPanel.add(btnNewButton);
		
		JButton button = new JButton("\u4FEE\u6539\u7528\u6237");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(getTable().getSelectedRowCount() == 0)
				{
					JOptionPane.showConfirmDialog(null, "��ѡ��Ҫ�޸ĵļ�¼!","��ʾ", JOptionPane.CLOSED_OPTION);
				}
				else
				{
					ModifyUsers modi = new ModifyUsers(gui);
					modi.setVisible(true);
					dispose();
				}			
				
			}
		});
		button.setBounds(319, 105, 93, 41);
		contentPanel.add(button);
		
		JButton button_1 = new JButton("\u5220\u9664\u7528\u6237");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel tableModel = (DefaultTableModel) getTable().getModel();
				if(getTable().getSelectedRowCount() == 0)
				{
					JOptionPane.showConfirmDialog(null, "��ѡ��Ҫɾ���ļ�¼!","��ʾ", JOptionPane.CLOSED_OPTION);
				}
				else if(getTable().getSelectedRowCount() > 0)
				{
					int choice = JOptionPane.showConfirmDialog(null, "ѡ�еļ�¼����ɾ��!","�Ƿ�ɾ��:", JOptionPane.OK_CANCEL_OPTION);
					if(choice == 0)
					{
						for(int i = getTable().getSelectedRow();i < (getTable().getSelectedRow() +
								getTable().getSelectedRowCount());i++)
						{	
							tableModel.removeRow(i);
							//LoginControl.getLoginControl().delete((Login)list.get(i));
							LoginControl.getLoginControl().delete((Login)list.get(i));
						}
					}
					InitialTable();
				}
			}
		});
		button_1.setBounds(319, 164, 93, 41);
		contentPanel.add(button_1);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton cancelButton = new JButton("\u8FD4\u56DE");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						MainUI ma = new MainUI();
						ma.setVisible(true);
						dispose();
						}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		InitialTable();
	}
	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
		
	}
	
	public void InitialTable()
	{
		DefaultTableModel tableModel = (DefaultTableModel) getTable().getModel();
		if(tableModel.getRowCount() != 0)
		{
			tableModel.setRowCount(0);
		}
		list = LoginControl.getLoginControl().getLoginALL();	
		String role;
		for(int i = 0;i < list.size();i++)
		{
			Login login = (Login)list.get(i);
			if(Integer.parseInt(login.getRole().toString()) == 0);
			{
				role = "��������Ա";
			}
			if(Integer.parseInt(login.getRole().toString()) == 1)
			{
				role ="����Ա";
			}
			
			tableModel.addRow(new Object[] {
				login.getUserName().toString(),login.getPassword().toString(),
				role});
		}
		setLocationRelativeTo(null);
	}
}

package GUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.TitledBorder;

import ControlLayer.CustomerControl;
import UILayer.InputChecker;

import javax.swing.JSeparator;
import javax.swing.SwingConstants;

public class UpdateCustomer extends JFrame {
	
	private JPanel contentPane;
	private JButton btnSearch;
	private JButton btnBack;
	private JButton btnExitProgram;
	private JButton btnChange;
	private JTextField textFieldCPR;
	private JTextField textFieldPrint;
	private JTextField textFieldName;
	private JTextField textFieldAddress;
	private JTextField textFieldEmail;
	private JTextField textFieldPhone;
	private JTextField textFieldCity;
	private JTextField textFieldCPRChg;
	private JTextField textFieldPrintChg;
	private JTextField textFieldNameChg;
	private JTextField textFieldAddressChg;
	private JTextField textFieldEmailChg;
	private JTextField textFieldPhoneChg;
	private JTextField textFieldCityChg;
	private JLabel lblFemale;
	private JLabel lblMale;
	private JLabel mouseDrag;
	int xMouse, yMouse; // for smooth dragging
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateCustomer frame = new UpdateCustomer();
					frame.setUndecorated(true); // bordeless
					frame.setVisible(true);
					frame.setSize(640, 480);
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public UpdateCustomer() {
		initializeComponents();
		createEvents();
	}
	
	private void initializeComponents() {
		// TODO Auto-generated method stub
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 480);
		contentPane = new JPanel();
		contentPane.setOpaque(true);
		contentPane.setBackground(new Color(27,28,28, 255)); // background color
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//BACK BUTTON
			btnBack = new JButton();
			btnBack.setBounds(17, 388, 49, 43);
			btnBack.setContentAreaFilled(false);
			btnBack.setBorder(new LineBorder(Color.orange, 5));
			ImageIcon img = new ImageIcon(CustomerMenu.class.getResource("/components/back.png"));
			ImageIcon btnImageIcon = new ImageIcon( img.getImage().getScaledInstance(btnBack.getWidth()-10, btnBack.getHeight()-10, Image.SCALE_SMOOTH) );
			
			JSeparator separator = new JSeparator();
			separator.setOrientation(SwingConstants.VERTICAL);
			separator.setForeground(Color.ORANGE);
			separator.setBackground(Color.ORANGE);
			separator.setBounds(324, 50, 2, 301);
			contentPane.add(separator);
			btnBack.setIcon(btnImageIcon);
			contentPane.add(btnBack);
				
		//EXIT BUTTON
			btnExitProgram = new JButton();
			btnExitProgram.setBounds(314, 0, 42, 32);
			ImageIcon img1 = new ImageIcon(CustomerMenu.class.getResource("/components/x.png"));
			ImageIcon btnExitProgramImg = new ImageIcon( img1.getImage().getScaledInstance(btnExitProgram.getWidth()-10, btnExitProgram.getHeight()-10, Image.SCALE_SMOOTH) );
			btnExitProgram.setIcon(btnExitProgramImg);
			btnExitProgram.setContentAreaFilled(false);
			btnExitProgram.setBorder(null);
			btnExitProgram.setOpaque(false);
			contentPane.add(btnExitProgram);
				
		//MOUSE DRAG
			mouseDrag =  new JLabel();
			mouseDrag.setBounds(0, 0, 677, 30);
			ImageIcon img2 = new ImageIcon(CustomerMenu.class.getResource("/components/drag.gif"));
			ImageIcon dragImg = new ImageIcon( img2.getImage().getScaledInstance(mouseDrag.getWidth()-5, mouseDrag.getHeight()-5, Image.SCALE_SMOOTH) );
			mouseDrag.setIcon(dragImg);
			contentPane.add(mouseDrag);
			
		//SEARCH BUTTON
			btnSearch = new JButton();
			btnSearch.setBounds(249, 41, 49, 41);
			btnSearch.setContentAreaFilled(false);
			btnSearch.setBorder(null);
			ImageIcon img3 = new ImageIcon(CustomerMenu.class.getResource("/components/searh.png"));
			ImageIcon btnSearchImg = new ImageIcon( img3.getImage().getScaledInstance(btnSearch.getWidth(), btnSearch.getHeight(), Image.SCALE_SMOOTH) );
			btnSearch.setIcon(btnSearchImg);
			contentPane.add(btnSearch);
			
		//CHANGE BUTTON
			btnChange = new JButton();
			btnChange.setBounds(474, 345, 95, 86);
			btnChange.setContentAreaFilled(false);
			btnChange.setBorder(null);
			ImageIcon img4 = new ImageIcon(CustomerMenu.class.getResource("/components/change.png"));
			ImageIcon btnChangeImg = new ImageIcon( img4.getImage().getScaledInstance(btnChange.getWidth(), btnChange.getHeight(), Image.SCALE_SMOOTH) );
			btnChange.setIcon(btnChangeImg);
			contentPane.add(btnChange);
		
		//LABEL
			lblMale = new JLabel();
			lblMale.setBounds(117, 111, 239, 189);
			ImageIcon img5 = new ImageIcon(CustomerMenu.class.getResource("/components/male.png"));
			ImageIcon lblMaleImg = new ImageIcon( img5.getImage().getScaledInstance(lblMale.getWidth()-5, lblMale.getHeight()-5, Image.SCALE_SMOOTH) );
			lblMale.setIcon(lblMaleImg);
			lblMale.setBorder(null);
			lblMale.setVisible(false);
			contentPane.add(lblMale);
			
			lblFemale = new JLabel();
			lblFemale.setBounds(108, 135, 239, 189);
			ImageIcon img6 = new ImageIcon(CustomerMenu.class.getResource("/components/female.png"));
			ImageIcon lblFemaleImg = new ImageIcon( img6.getImage().getScaledInstance(lblFemale.getWidth()-5, lblFemale.getHeight()-5, Image.SCALE_SMOOTH) );
			lblFemale.setIcon(lblFemaleImg);
			lblFemale.setBorder(null);
			lblFemale.setVisible(false);
			contentPane.add(lblFemale);
			
			
			//CURRENT
			JLabel lblSearchByCpr = new JLabel("Search by CPR");
			lblSearchByCpr.setBounds(147, 41, 92, 16);
			lblSearchByCpr.setForeground(Color.ORANGE);
			lblSearchByCpr.setBorder(new LineBorder(Color.ORANGE, 2));
			contentPane.add(lblSearchByCpr);
			
			JLabel lblCpr = new JLabel("CPR ");
			lblCpr.setBounds(10, 97, 56, 16);
			lblCpr.setForeground(Color.ORANGE);
			lblCpr.setBorder(new LineBorder(Color.ORANGE, 2));
			contentPane.add(lblCpr);
			
			JLabel lblName = new JLabel("Name ");
			lblName.setBounds(98, 132, 56, 16);
			lblName.setForeground(Color.ORANGE);
			lblName.setBorder(new LineBorder(Color.ORANGE, 2));
			contentPane.add(lblName);
			
			JLabel lblAddress = new JLabel("Address");
			lblAddress.setBounds(10, 169, 56, 16);
			lblAddress.setForeground(Color.ORANGE);
			lblAddress.setBorder(new LineBorder(Color.ORANGE, 2));
			contentPane.add(lblAddress);
			
			JLabel lblEmail = new JLabel("Email");
			lblEmail.setBounds(10, 208, 56, 16);
			lblEmail.setForeground(Color.ORANGE);
			lblEmail.setBorder(new LineBorder(Color.ORANGE, 2));
			contentPane.add(lblEmail);
			
			JLabel lblPhone = new JLabel("Phone");
			lblPhone.setBounds(98, 249, 56, 16);
			lblPhone.setForeground(Color.ORANGE);
			lblPhone.setBorder(new LineBorder(Color.ORANGE, 2));
			contentPane.add(lblPhone);
			
			JLabel lblCity = new JLabel("City");
			lblCity.setBounds(10, 284, 56, 16);
			lblCity.setForeground(Color.ORANGE);
			lblCity.setBorder(new LineBorder(Color.ORANGE, 2));
			contentPane.add(lblCity);
			
			//CHANGE
			JLabel lblCprChg = new JLabel("CPR ");
			lblCprChg.setBounds(549, 97, 49, 16);
			lblCprChg.setForeground(Color.white);
			lblCprChg.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			contentPane.add(lblCprChg);
			
			JLabel lblNameChg = new JLabel("Name ");
			lblNameChg.setBounds(549, 133, 49, 16);
			lblNameChg.setForeground(Color.WHITE);
			lblNameChg.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			contentPane.add(lblNameChg);
			
			JLabel lblAddressChg = new JLabel("Address");
			lblAddressChg.setBounds(542, 169, 56, 16);
			lblAddressChg.setForeground(Color.WHITE);
			lblAddressChg.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			contentPane.add(lblAddressChg);
			
			JLabel lblEmailChg = new JLabel("Email");
			lblEmailChg.setBounds(549, 208, 49, 16);
			lblEmailChg.setForeground(Color.WHITE);
			lblEmailChg.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			contentPane.add(lblEmailChg);
			
			JLabel lblPhoneChg = new JLabel("Phone");
			lblPhoneChg.setBounds(542, 249, 56, 16);
			lblPhoneChg.setForeground(Color.WHITE);
			lblPhoneChg.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			contentPane.add(lblPhoneChg);
			
			JLabel lblCityChg = new JLabel("City");
			lblCityChg.setBounds(542, 284, 56, 16);
			lblCityChg.setForeground(Color.WHITE);
			lblCityChg.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			contentPane.add(lblCityChg);
			
			//CURRENT
			textFieldPrint = new JTextField();
			textFieldPrint.setBounds(10, 111, 144, 22);
			textFieldPrint.setForeground(Color.black);
			textFieldPrint.setBackground(Color.orange);
			textFieldPrint.setBorder(new LineBorder(Color.ORANGE,1));
			textFieldPrint.setEditable(false);
			contentPane.add(textFieldPrint);
			textFieldPrint.setColumns(10);
			
			textFieldCPR = new JTextField();
			textFieldCPR.setColumns(10);
			textFieldCPR.setBounds(124, 60, 116, 22);
			textFieldCPR.setForeground(Color.ORANGE);
			textFieldCPR.setBackground(Color.black);
			textFieldCPR.setBorder(new LineBorder(Color.ORANGE,1));
			textFieldCPR.setEditable(true);
			contentPane.add(textFieldCPR);
			
			textFieldName = new JTextField();
			textFieldName.setColumns(10);
			textFieldName.setBounds(10, 147, 144, 22);
			textFieldName.setForeground(Color.black);
			textFieldName.setBackground(Color.orange);
			textFieldName.setBorder(new LineBorder(Color.ORANGE,1));
			textFieldName.setEditable(false);
			contentPane.add(textFieldName);
			
			textFieldAddress = new JTextField();
			textFieldAddress.setColumns(10);
			textFieldAddress.setBounds(10, 186, 144, 22);
			textFieldAddress.setForeground(Color.black);
			textFieldAddress.setBackground(Color.orange);
			textFieldAddress.setBorder(new LineBorder(Color.ORANGE,1));
			textFieldAddress.setEditable(false);
			contentPane.add(textFieldAddress);
			
			textFieldEmail = new JTextField();
			textFieldEmail.setColumns(10);
			textFieldEmail.setBounds(10, 225, 144, 22);
			textFieldEmail.setForeground(Color.black);
			textFieldEmail.setBackground(Color.orange);
			textFieldEmail.setBorder(new LineBorder(Color.ORANGE,1));
			textFieldEmail.setEditable(false);
			contentPane.add(textFieldEmail);
			
			textFieldPhone = new JTextField();
			textFieldPhone.setColumns(10);
			textFieldPhone.setBounds(10, 263, 144, 22);
			textFieldPhone.setForeground(Color.black);
			textFieldPhone.setBackground(Color.orange);
			textFieldPhone.setBorder(new LineBorder(Color.ORANGE,1));
			textFieldPhone.setEditable(false);
			contentPane.add(textFieldPhone);
			
			textFieldCity = new JTextField();
			textFieldCity.setColumns(10);
			textFieldCity.setBounds(10, 302, 144, 22);
			textFieldCity.setForeground(Color.black);
			textFieldCity.setBackground(Color.orange);
			textFieldCity.setBorder(new LineBorder(Color.ORANGE,1));
			textFieldCity.setEditable(false);
			contentPane.add(textFieldCity);
			
			//CHANGE
			textFieldPrintChg = new JTextField();
			textFieldPrintChg.setBounds(454, 111, 144, 22);
			textFieldPrintChg.setForeground(Color.orange);
			textFieldPrintChg.setBackground(Color.black);
			textFieldPrintChg.setBorder(new LineBorder(Color.white,1));
			textFieldPrintChg.setEditable(true);
			contentPane.add(textFieldPrintChg);
			textFieldPrintChg.setColumns(10);
			
			textFieldNameChg = new JTextField();
			textFieldNameChg.setColumns(10);
			textFieldNameChg.setBounds(454, 147, 144, 22);
			textFieldNameChg.setForeground(Color.orange);
			textFieldNameChg.setBackground(Color.BLACK);
			textFieldNameChg.setBorder(new LineBorder(Color.white,1));
			textFieldNameChg.setEditable(true);
			contentPane.add(textFieldNameChg);
			
			textFieldAddressChg = new JTextField();
			textFieldAddressChg.setColumns(10);
			textFieldAddressChg.setBounds(454, 186, 144, 22);
			textFieldAddressChg.setForeground(Color.orange);
			textFieldAddressChg.setBackground(Color.black);
			textFieldAddressChg.setBorder(new LineBorder(Color.white,1));
			textFieldAddressChg.setEditable(true);
			contentPane.add(textFieldAddressChg);
			
			textFieldEmailChg = new JTextField();
			textFieldEmailChg.setColumns(10);
			textFieldEmailChg.setBounds(454, 225, 144, 22);
			textFieldEmailChg.setForeground(Color.orange);
			textFieldEmailChg.setBackground(Color.black);
			textFieldEmailChg.setBorder(new LineBorder(Color.white,1));
			textFieldEmailChg.setEditable(true);
			contentPane.add(textFieldEmailChg);
			
			textFieldPhoneChg = new JTextField();
			textFieldPhoneChg.setColumns(10);
			textFieldPhoneChg.setBounds(454, 263, 144, 22);
			textFieldPhoneChg.setForeground(Color.orange);
			textFieldPhoneChg.setBackground(Color.black);
			textFieldPhoneChg.setBorder(new LineBorder(Color.white,1));
			textFieldPhoneChg.setEditable(true);
			contentPane.add(textFieldPhoneChg);
			
			textFieldCityChg = new JTextField();
			textFieldCityChg.setColumns(10);
			textFieldCityChg.setBounds(454, 299, 144, 22);
			textFieldCityChg.setForeground(Color.orange);
			textFieldCityChg.setBackground(Color.black);
			textFieldCityChg.setBorder(new LineBorder(Color.white,1));
			textFieldCityChg.setEditable(true);
			contentPane.add(textFieldCityChg);
		
		
	}
	
	private void createEvents() {
		// TODO Auto-generated method stub
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CustomerMenu customerMenu = new CustomerMenu();
				dispose();
				customerMenu.main(null);
			}
		});
		btnExitProgram.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit the program?");
				if(confirm == JOptionPane.YES_OPTION) {
					LoginMenu.brexit.exit();
					System.exit(0);
				}
			}
		});
		
		mouseDrag.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				xMouse = e.getX();
				yMouse = e.getY();
			}
		});
		mouseDrag.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int x = e.getXOnScreen();
				int y = e.getYOnScreen();
				setLocation(x - xMouse, y - yMouse);
			}
		});
		
		btnChange.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CustomerControl customerControler = new CustomerControl();
				if( textFieldPrint.getText().isEmpty())
					JOptionPane.showMessageDialog(null, "Please search for a Customer, first!");
				else
				{
					if(!textFieldPrintChg.getText().isEmpty())
					{
						String cpr = textFieldPrintChg.getText();
						InputChecker.verifyId(3, cpr);
						customerControler.changeCustomerFieldByCpr(textFieldPrint.getText(), 1, cpr);
					}
					
					if(!textFieldNameChg.getText().isEmpty()){
						String name = textFieldNameChg.getText();
						InputChecker.verifyName(name);
						if( customerControler.changeCustomerFieldByCpr(textFieldPrint.getText(), 2, name)) 
							{
							JOptionPane.showMessageDialog(null, "Operation finished with success.");
							textFieldPrint.setText("");
							}
						else
							JOptionPane.showMessageDialog(null, "Something went wrong.");
					}
						
					if(!textFieldAddressChg.getText().isEmpty()){
						String address = textFieldAddressChg.getText();
						InputChecker.verifyAddress(address);
						if( customerControler.changeCustomerFieldByCpr(textFieldPrint.getText(), 3, address) )
							{
							JOptionPane.showMessageDialog(null, "Operation finished with success.");
							textFieldPrint.setText("");
							}
						else
							JOptionPane.showMessageDialog(null, "Something went wrong.");
					}
					
					if(!textFieldEmailChg.getText().isEmpty()){
						String email = textFieldEmailChg.getText();
						InputChecker.verifyEmail(email);
						if( customerControler.changeCustomerFieldByCpr(textFieldPrint.getText(), 4, email) )
							{
							JOptionPane.showMessageDialog(null, "Operation finished with success.");
							textFieldPrint.setText("");
							}
						else
							JOptionPane.showMessageDialog(null, "Something went wrong.");
					}
					
					if(!textFieldCityChg.getText().isEmpty()){
						String city = textFieldCityChg.getText();
						InputChecker.verifyCity(city);
						if( customerControler.changeCustomerFieldByCpr(textFieldPrint.getText(), 5, city) )
							{
							JOptionPane.showMessageDialog(null, "Operation finished with success.");
							textFieldPrint.setText("");
							}
						else
							JOptionPane.showMessageDialog(null, "Something went wrong.");
					}
						
					if(!textFieldPhoneChg.getText().isEmpty()){
						String phone = textFieldPhoneChg.getText();
						InputChecker.verifyPhone(phone);
						if( customerControler.changeCustomerFieldByCpr(textFieldPrint.getText(), 6, phone) )
							{
							JOptionPane.showMessageDialog(null, "Operation finished with success.");
							textFieldPrint.setText("");
							}
						else
							JOptionPane.showMessageDialog(null, "Something went wrong.");
					}
						
				}
				
			}
		});
		
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CustomerControl customerControl = new CustomerControl();
				
				String cpr = textFieldCPR.getText();
				ArrayList<String> result = customerControl.getCustomerByCpr(cpr);
				
				lblMale.setVisible(false); //reset their visibility
				lblFemale.setVisible(false);

				if(result != null) {
					textFieldPrint.setText(result.get(0).substring(8));
						if( Double.parseDouble( result.get(0).substring(8) ) % 2 == 0) //if the last digit of the CPR is divisible by 2, it means the person is a she
							lblFemale.setVisible(true);
						else
							lblMale.setVisible(true);
					textFieldName.setText(result.get(1).substring(9));
					textFieldAddress.setText(result.get(2).substring(12));
					textFieldEmail.setText(result.get(3).substring(10));
					textFieldPhone.setText(result.get(4).substring(10));
					textFieldCity.setText(result.get(5).substring(9));
                }
                else {
                	JOptionPane.showMessageDialog(null, "Sorry, there is no such user!");
                }
				
			}
		});
	}
}

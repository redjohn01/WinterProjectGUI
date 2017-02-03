package UILayer;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import ControlLayer.ContractorControl;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ContractorUI extends JFrame
{
	private ContractorControl CControl;
	
	private JFrame frame;
	private JPanel panel_Main;
	private JPanel panel_Create;
	private JPanel panel_Read;
	private JPanel panel_Update;
	private JPanel panel_Delete;
	private JPanel panel_BuyFrom;
	private JPanel panel_Verify;
	private JMenuBar menubar;
	private JMenu menu;
	private JMenuItem close;
	private JButton btnOther;
	private JButton btnCreate;
	private JButton btnRead;
	private JButton btnUpdate;
	private JButton btnDelete;
	private JButton btnBuyFrom;
	private JButton btnCCancel;
	private JButton btnRCancel;
	private JButton btnUCancel;
	private JButton btnDCancel;
	private JButton btnBCancel;
	private JButton btnVCancel;
	private JButton btnCDone;
	private JButton btnDDone;
	private JButton btnUName;
	private JButton btnUPhone;
	private JButton btnUEmail;
	private JButton btnUCity;
	private JButton btnUAddress;
	private JButton btnBDone;
	private JLabel lblCvr;
	private JLabel lblName;
	private JLabel lblAddress;
	private JLabel lblEmail;
	private JLabel lblPhone;
	private JLabel lblCity;
	private JLabel lblCVR;
	private JLabel lblIfYouAre;
	private JLabel lblInfo;
	private JLabel lblUName;
	private JLabel lblUPhone;
	private JLabel lblUEmail;
	private JLabel lblUCity;
	private JLabel lblUAddress;
	private JLabel lblBItem;
	private JLabel lblBAmount;
	private JLabel lblBPrice;
	private JTextField txtCvrControl;
	private JTextField txtName;
	private JTextField txtAddress;
	private JTextField txtEmail;
	private JTextField txtPhone;
	private JTextField txtCity;
	private JTextField txtCVR;
	private JTextField txtUName;
	private JTextField txtUPhone;
	private JTextField txtUEmail;
	private JTextField txtUCity;
	private JTextField txtUAddress;
	private JTextField txtBItem;
	private JTextField txtBAmount;
	private JTextField txtBPrice;
	
	public ContractorUI()
	{
		makeFrame();
		this.pack();
        this.setLocation(0, 0);
        this.setVisible(true);
	}
	
	public static void main(String[] args)
    {
        new ContractorUI();
    }
	
	private void makeFrame()
	{
		frame = new JFrame("Main page");        
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 700);
        
        frame.getContentPane().setLayout(new CardLayout(0, 0));
        
        makePanels();
        makeMenuBar();
        makeButtons();
        makeLabelsFields();
	}
	
	private void makeMenuBar()
	{
		menubar = new JMenuBar();
        frame.setJMenuBar(menubar);
        
        menu = new JMenu("Options");
        menubar.add(menu);
        
        close = new JMenuItem("Close");
        close.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) 
        	{
        		
        	}
        });
        menu.add(close);
	}
	
	private void makePanels()
	{
		panel_Main = new JPanel();
	    frame.getContentPane().add(panel_Main, "Main Page");
	    panel_Main.setLayout(null);
	    panel_Main.setVisible(true);
	    
	    panel_Create = new JPanel();
	    frame.getContentPane().add(panel_Create, "Creating Page");
	    panel_Create.setLayout(null);
	    panel_Create.setVisible(false);
	    
	    panel_Read = new JPanel();
	    frame.getContentPane().add(panel_Read, "Read info Page");
	    panel_Read.setLayout(null);
	    panel_Read.setVisible(false);
	    
	    panel_Update = new JPanel();
	    frame.getContentPane().add(panel_Update, "Updating Page");
	    panel_Update.setLayout(null);
	    panel_Update.setVisible(false);
	    
	    panel_Delete = new JPanel();
	    frame.getContentPane().add(panel_Delete, "Deleting Page");
	    panel_Delete.setLayout(null);
	    panel_Delete.setVisible(false);
	    
	    panel_BuyFrom = new JPanel();
	    frame.getContentPane().add(panel_BuyFrom, "Buying Page");
	    panel_BuyFrom.setLayout(null);
	    panel_BuyFrom.setVisible(false);
	    
	    panel_Verify = new JPanel();
	    frame.getContentPane().add(panel_Verify, "Verification Page");
	    panel_Verify.setLayout(null);
	    panel_Verify.setVisible(false);
	}
	
	private void makeButtons()
	{
		btnOther = new JButton("Other Options");
		btnOther.setFont(new Font("Tahoma", Font.PLAIN, 16));
	    btnOther.setBounds(250, 200, 200, 100);
	    panel_Main.add(btnOther);
	    btnOther.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) 
        	{
        		panel_Main.setVisible(false);
        		panel_Verify.setVisible(true);
        	}
        });
	    
	    btnCreate = new JButton("Create Contractor");
	    btnCreate.setFont(new Font("Tahoma", Font.PLAIN, 16));
	    btnCreate.setBounds(250, 55, 200, 100);
	    panel_Main.add(btnCreate);
	    btnCreate.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) 
        	{
        		panel_Main.setVisible(false);
        		panel_Create.setVisible(true);
        	}
        });
	    
	    btnRead = new JButton("Read Contractor");
	    btnRead.setFont(new Font("Tahoma", Font.PLAIN, 16));
	    btnRead.setBounds(250, 155, 200, 60);
	    panel_Verify.add(btnRead);
	    btnRead.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) 
        	{
        		String cvr = txtCvrControl.getText();
        		if(CControl.isInList(cvr))
        		{
        			String s = CControl.readContractor();
        			lblInfo.setText(s);
        			
	        		panel_Verify.setVisible(false);
	        		panel_Read.setVisible(true);
        		}
        		else
        		{
        			System.out.println("ERROR. Contractor not in list.");
        		}
        	}
        });
	    
	    btnUpdate = new JButton("Update Contractor");
	    btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 16));
	    btnUpdate.setBounds(250, 255, 200, 60);
	    panel_Verify.add(btnUpdate);
	    btnUpdate.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) 
        	{
        		String cvr = txtCvrControl.getText();
        		if(CControl.isInList(cvr))
        		{
	        		panel_Verify.setVisible(false);
	        		panel_Update.setVisible(true);
        		}
        		else
        		{
        			System.out.println("ERROR. Contractor not in list.");
        		}
        	}
        });
	    
	    btnDelete = new JButton("Delete Contractor");
	    btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 16));
	    btnDelete.setBounds(250, 355, 200, 60);
	    panel_Verify.add(btnDelete);
	    btnDelete.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) 
        	{
        		String cvr = txtCvrControl.getText();
        		if(CControl.isInList(cvr))
        		{
	        		panel_Verify.setVisible(false);
	        		panel_Delete.setVisible(true);
        		}
        		else
        		{
        			System.out.println("ERROR. Contractor not in list.");
        		}
        	}
        });
	    
	    btnBuyFrom = new JButton("Buy Items");
	    btnBuyFrom.setFont(new Font("Tahoma", Font.PLAIN, 16));
	    btnBuyFrom.setBounds(250, 455, 200, 60);
	    panel_Verify.add(btnBuyFrom);
	    btnBuyFrom.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) 
        	{
        		String cvr = txtCvrControl.getText();
        		if(CControl.isInList(cvr))
        		{
	        		panel_Verify.setVisible(false);
	        		panel_BuyFrom.setVisible(true);
        		}
        		else
        		{
        			System.out.println("ERROR. Contractor not in list.");
        		}
        	}
        });
	    
	    btnCCancel = new JButton("Cancel");
	    btnCCancel.setFont(new Font("Tahoma", Font.PLAIN, 16));
	    btnCCancel.setBounds(420, 510, 200, 60);
	    panel_Create.add(btnCCancel);
	    btnCCancel.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) 
        	{
        		panel_Create.setVisible(false);
        		panel_Main.setVisible(true);
        	}
        });
	    
	    btnRCancel = new JButton("Cancel");
	    btnRCancel.setFont(new Font("Tahoma", Font.PLAIN, 16));
	    btnRCancel.setBounds(250, 370, 200, 60);
	    panel_Read.add(btnRCancel);
	    btnRCancel.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) 
        	{
        		panel_Read.setVisible(false);
        		panel_Main.setVisible(true);
        	}
        });
	    
	    btnUCancel = new JButton("Cancel");
	    btnUCancel.setFont(new Font("Tahoma", Font.PLAIN, 16));
	    btnUCancel.setBounds(233, 510, 200, 60);
	    panel_Update.add(btnUCancel);
	    btnUCancel.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) 
        	{
        		panel_Update.setVisible(false);
        		panel_Main.setVisible(true);
        	}
        });
	    
	    btnDCancel = new JButton("Cancel");
	    btnDCancel.setFont(new Font("Tahoma", Font.PLAIN, 16));
	    btnDCancel.setBounds(348, 282, 200, 60);
	    panel_Delete.add(btnDCancel);
	    btnDCancel.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) 
        	{
        		panel_Delete.setVisible(false);
        		panel_Main.setVisible(true);
        	}
        });
	    
	    btnBCancel = new JButton("Cancel");
	    btnBCancel.setFont(new Font("Tahoma", Font.PLAIN, 16));
	    btnBCancel.setBounds(250, 450, 200, 60);
	    panel_BuyFrom.add(btnBCancel);
	    btnBCancel.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) 
        	{
        		panel_BuyFrom.setVisible(false);
        		panel_Main.setVisible(true);
        	}
        });
	    
	    btnVCancel = new JButton("Cancel");
	    btnVCancel.setBounds(250, 155, 200, 60);
	    panel_Verify.add(btnVCancel);
	    btnVCancel.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) 
        	{
        		panel_Verify.setVisible(false);
        		panel_Main.setVisible(true);
        	}
        });
	    
	    btnCDone = new JButton("DONE");
	    btnCDone.setFont(new Font("Tahoma", Font.PLAIN, 16));
	    btnCDone.setBounds(100, 510, 200, 60);
	    panel_Create.add(btnCDone);
	    btnCDone.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) 
        	{
        		String name = txtName.getText();
        		String phone = txtPhone.getText();
        		String email = txtEmail.getText();
        		String city = txtCity.getText();
        		String address = txtAddress.getText();
        		String cvr = txtCVR.getText();
        		
        		CControl.createContractor(name, phone, email, city, address, cvr);
        		
        		panel_Create.setVisible(false);
        		panel_Main.setVisible(true);
        	}
        });
	    
	    btnDDone = new JButton("DONE");
	    btnDDone.setFont(new Font("Tahoma", Font.PLAIN, 16));
	    btnDDone.setBounds(100, 280, 200, 60);
	    panel_Delete.add(btnDDone);
	    btnDDone.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) 
        	{
        		CControl.deleteContractor();
        		
        		panel_Create.setVisible(false);
        		panel_Main.setVisible(true);
        	}
        });
	    
	    btnUName = new JButton("Update");
	    btnUName.setFont(new Font("Tahoma", Font.PLAIN, 16));
	    btnUName.setBounds(440, 100, 89, 23);
	    panel_Update.add(btnUName);
	    btnUName.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) 
        	{
        		String name = txtUName.getText();
        		CControl.updateCName(name);
        	}
        });
	    
	    btnUPhone = new JButton("Update");
	    btnUPhone.setFont(new Font("Tahoma", Font.PLAIN, 16));
	    btnUPhone.setBounds(440, 158, 89, 23);
	    panel_Update.add(btnUPhone);
	    btnUName.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) 
        	{
        		String phone = txtUPhone.getText();
        		CControl.updateCPhone(phone);
        	}
        });
	    
	    btnUEmail = new JButton("Update");
	    btnUEmail.setFont(new Font("Tahoma", Font.PLAIN, 16));
	    btnUEmail.setBounds(440, 218, 89, 23);
	    panel_Update.add(btnUEmail);
	    btnUName.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) 
        	{
        		String email = txtUEmail.getText();
        		CControl.updateCEmail(email);
        	}
        });
	    
	    btnUCity = new JButton("Update");
	    btnUCity.setFont(new Font("Tahoma", Font.PLAIN, 16));
	    btnUCity.setBounds(440, 278, 89, 23);
	    panel_Update.add(btnUCity);
	    btnUName.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) 
        	{
        		String city = txtUCity.getText();
        		CControl.updateCCity(city);
        	}
        });
	    
	    btnUAddress = new JButton("Update");
	    btnUAddress.setFont(new Font("Tahoma", Font.PLAIN, 16));
	    btnUAddress.setBounds(440, 338, 89, 23);
	    panel_Update.add(btnUAddress);
	    btnUName.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) 
        	{
        		String address = txtUAddress.getText();
        		CControl.updateCAddress(address);
        	}
        });
	    
	    btnBDone = new JButton("DONE");
	    btnBDone.setFont(new Font("Tahoma", Font.PLAIN, 16));
	    btnBDone.setBounds(250, 337, 200, 60);
	    panel_BuyFrom.add(btnBDone);
	    btnBDone.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) 
        	{
        		String item = txtBItem.getText();
        		String amount = txtBAmount.getText();
        		String price = txtBPrice.getText();
        		CControl.buyItems(item, amount, price);
        	}
        });
	}
	
	private void makeLabelsFields()
	{
		lblCvr = new JLabel("CVR:");
	    lblCvr.setFont(new Font("Tahoma", Font.PLAIN, 16));
	    lblCvr.setBounds(190, 73, 60, 30);
	    panel_Verify.add(lblCvr);
	    
	    txtCvrControl = new JTextField();
	    txtCvrControl.setBounds(271, 73, 228, 30);
	    panel_Verify.add(txtCvrControl);
	    txtCvrControl.setColumns(10);
	    
	    lblName = new JLabel("Name:");
	    lblName.setFont(new Font("Tahoma", Font.PLAIN, 16));
	    lblName.setBounds(100, 60, 61, 23);
	    panel_Create.add(lblName);
	    
	    txtName = new JTextField();
	    txtName.setColumns(10);
	    txtName.setBounds(170, 60, 250, 23);
	    panel_Create.add(txtName);
	    
	    lblAddress = new JLabel("Address:");
	    lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 14));
	    lblAddress.setBounds(100, 300, 61, 23);
	    panel_Create.add(lblAddress);
	    
	    txtAddress = new JTextField();
	    txtAddress.setColumns(10);
	    txtAddress.setBounds(170, 300, 250, 23);
	    panel_Create.add(txtAddress);
	    
	    lblEmail = new JLabel("Email:");
	    lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
	    lblEmail.setBounds(100, 180, 86, 23);
	    panel_Create.add(lblEmail);
	    
	    txtEmail = new JTextField();
	    txtEmail.setColumns(10);
	    txtEmail.setBounds(170, 180, 250, 23);
	    panel_Create.add(txtEmail);
	    
	    lblPhone = new JLabel("Phone:");
	    lblPhone.setFont(new Font("Tahoma", Font.PLAIN, 14));
	    lblPhone.setBounds(100, 120, 86, 23);
	    panel_Create.add(lblPhone);
	    
	    txtPhone = new JTextField();
	    txtPhone.setColumns(10);
	    txtPhone.setBounds(170, 120, 250, 23);
	    panel_Create.add(txtPhone);
	    
	    lblCity = new JLabel("City:");
	    lblCity.setFont(new Font("Tahoma", Font.PLAIN, 14));
	    lblCity.setBounds(100, 240, 59, 23);
	    panel_Create.add(lblCity);
	    
	    txtCity = new JTextField();
	    txtCity.setColumns(10);
	    txtCity.setBounds(170, 240, 250, 23);
	    panel_Create.add(txtCity);
	    
	    lblCVR = new JLabel("CVR:");
	    lblCVR.setFont(new Font("Tahoma", Font.PLAIN, 14));
	    lblCVR.setBounds(100, 360, 59, 23);
	    panel_Create.add(lblCVR);
	    
	    txtCVR = new JTextField();
	    txtCVR.setColumns(10);
	    txtCVR.setBounds(170, 360, 250, 23);
	    panel_Create.add(txtCVR);
	    
	    lblInfo = new JLabel();
	    lblInfo.setBounds(72, 128, 541, 155);
	    panel_Read.add(lblInfo);
	    
	    lblUName = new JLabel("Name");
	    lblUName.setFont(new Font("Tahoma", Font.PLAIN, 16));
	    lblUName.setBounds(100, 100, 85, 14);
	    panel_Update.add(lblUName);
	    
	    lblUPhone = new JLabel("Phone");
	    lblUPhone.setFont(new Font("Tahoma", Font.PLAIN, 16));
	    lblUPhone.setBounds(100, 160, 85, 14);
	    panel_Update.add(lblUPhone);
	    
	    lblUEmail = new JLabel("Email");
	    lblUEmail.setFont(new Font("Tahoma", Font.PLAIN, 16));
	    lblUEmail.setBounds(100, 220, 85, 14);
	    panel_Update.add(lblUEmail);
	    
	    lblUCity = new JLabel("City");
	    lblUCity.setFont(new Font("Tahoma", Font.PLAIN, 16));
	    lblUCity.setBounds(100, 280, 85, 14);
	    panel_Update.add(lblUCity);
	    
	    lblUAddress = new JLabel("Address");
	    lblUAddress.setFont(new Font("Tahoma", Font.PLAIN, 16));
	    lblUAddress.setBounds(100, 340, 85, 14);
	    panel_Update.add(lblUAddress);
	    
	    txtUName = new JTextField();
	    txtUName.setFont(new Font("Tahoma", Font.PLAIN, 16));
	    txtUName.setBounds(185, 100, 200, 20);
	    panel_Update.add(txtUName);
	    txtUName.setColumns(10);
	    
	    txtUPhone = new JTextField();
	    txtUPhone.setFont(new Font("Tahoma", Font.PLAIN, 16));
	    txtUPhone.setBounds(185, 159, 200, 20);
	    panel_Update.add(txtUPhone);
	    txtUPhone.setColumns(10);
	    
	    txtUEmail = new JTextField();
	    txtUEmail.setFont(new Font("Tahoma", Font.PLAIN, 16));
	    txtUEmail.setBounds(185, 219, 200, 20);
	    panel_Update.add(txtUEmail);
	    txtUEmail.setColumns(10);
	    
	    txtUCity = new JTextField();
	    txtUCity.setFont(new Font("Tahoma", Font.PLAIN, 16));
	    txtUCity.setBounds(185, 279, 200, 20);
	    panel_Update.add(txtUCity);
	    txtUCity.setColumns(10);
	    
	    txtUAddress = new JTextField();
	    txtUAddress.setFont(new Font("Tahoma", Font.PLAIN, 16));
	    txtUAddress.setBounds(185, 339, 200, 20);
	    panel_Update.add(txtUAddress);
	    txtUAddress.setColumns(10);
	    
	    lblIfYouAre = new JLabel("If you are sure, press DONE");
	    lblIfYouAre.setFont(new Font("Tahoma", Font.PLAIN, 16));
	    lblIfYouAre.setBounds(100, 400, 268, 60);
	    panel_Delete.add(lblIfYouAre);
	    

	    lblBItem = new JLabel("Item");
	    lblBItem.setFont(new Font("Tahoma", Font.PLAIN, 16));
	    lblBItem.setBounds(100, 100, 75, 14);
	    panel_BuyFrom.add(lblBItem);
	    
	    lblBAmount = new JLabel("Amount");
	    lblBAmount.setFont(new Font("Tahoma", Font.PLAIN, 16));
	    lblBAmount.setBounds(100, 160, 75, 14);
	    panel_BuyFrom.add(lblBAmount);
	    
	    lblBPrice = new JLabel("Price");
	    lblBPrice.setFont(new Font("Tahoma", Font.PLAIN, 16));
	    lblBPrice.setBounds(100, 240, 46, 14);
	    panel_BuyFrom.add(lblBPrice);
	    
	    txtBItem = new JTextField();
	    txtBItem.setFont(new Font("Tahoma", Font.PLAIN, 16));
	    txtBItem.setBounds(220, 100, 185, 20);
	    panel_BuyFrom.add(txtBItem);
	    txtBItem.setColumns(10);
	    
	    txtBAmount = new JTextField();
	    txtBAmount.setFont(new Font("Tahoma", Font.PLAIN, 16));
	    txtBAmount.setText("");
	    txtBAmount.setBounds(220, 160, 185, 20);
	    panel_BuyFrom.add(txtBAmount);
	    txtBAmount.setColumns(10);
	    
	    txtBPrice = new JTextField();
	    txtBPrice.setFont(new Font("Tahoma", Font.PLAIN, 16));
	    txtBPrice.setBounds(220, 240, 185, 20);
	    panel_BuyFrom.add(txtBPrice);
	    txtBPrice.setColumns(10);
	}
}

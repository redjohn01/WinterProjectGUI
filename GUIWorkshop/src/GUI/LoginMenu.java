package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import ControlLayer.Brexit;
import UILayer.AesEncrypter;

import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LoginMenu {

	private JFrame mainFrame;
	private JTextField txtUsername;
	private JPasswordField pwdPassword;
	private JMenuItem mbiExit;
	private JButton btnLogin;
	static Brexit brexit = new Brexit();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				AesEncrypter.setKey("EncryptingPassword123");
				brexit.load();
				try {
					LoginMenu window = new LoginMenu();
					window.mainFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LoginMenu() {
		initializeComponents();
		createEvents();
	}

	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initializeComponents() {
		mainFrame = new JFrame();
		mainFrame.setTitle("Vestbjerg System 1.1");
		mainFrame.setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\Programming\\eclipse\\Instal eclipse\\eclipse\\workspace\\GUIWorkshop\\src\\components\\system.png"));
		mainFrame.setBounds(100, 100, 553, 416);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblUsername = new JLabel("USERNAME");
		lblUsername.setFont(new Font("Britannic Bold", Font.BOLD, 17));
		
		JLabel lblPassword = new JLabel("PASSWORD");
		lblPassword.setFont(new Font("Britannic Bold", Font.BOLD, 17));
		
		txtUsername = new JTextField();
		
		txtUsername.setText("//Username");
		txtUsername.setFont(new Font("SansSerif", Font.PLAIN, 15));
		txtUsername.setColumns(10);
		
		pwdPassword = new JPasswordField();
		pwdPassword.setText("password");
		pwdPassword.setFont(new Font("SansSerif", Font.PLAIN, 15));
		
		btnLogin = new JButton("LOGIN");
		btnLogin.setIcon(new ImageIcon("D:\\Programming\\eclipse\\Instal eclipse\\eclipse\\workspace\\GUIWorkshop\\src\\components\\ok.png"));
		GroupLayout groupLayout = new GroupLayout(mainFrame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(56)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnLogin, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblUsername, GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
								.addComponent(lblPassword, GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(txtUsername)
								.addComponent(pwdPassword, GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE))))
					.addGap(223))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(89)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addComponent(lblUsername, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
						.addComponent(txtUsername, GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(6)
							.addComponent(lblPassword, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
						.addComponent(pwdPassword, GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE))
					.addGap(53)
					.addComponent(btnLogin, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addGap(75))
		);
		mainFrame.getContentPane().setLayout(groupLayout);
		
		JMenuBar menuBar = new JMenuBar();
		mainFrame.setJMenuBar(menuBar);
		
		JMenu mbFile = new JMenu("File");
		menuBar.add(mbFile);
		
		mbiExit = new JMenuItem("Exit");
		mbiExit.setIcon(new ImageIcon("D:\\Programming\\eclipse\\Instal eclipse\\eclipse\\workspace\\GUIWorkshop\\src\\components\\exit.png"));
		mbFile.add(mbiExit);
	}

	private void createEvents() {
		mbiExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit the program?");
				if(confirm == JOptionPane.YES_OPTION) {
					brexit.exit();
					System.exit(0);
				}
			}
		});
		
		txtUsername.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				txtUsername.setText("");
			}
		});
		
		pwdPassword.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				pwdPassword.setText("");
			}
		});
		
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = txtUsername.getText();
				String pass = pwdPassword.getText();
				if(username.equals("admin") && pass.equals("adminpass") ) {
					JOptionPane.showMessageDialog(null, "Welcome");
					mainFrame.dispose();
					ChooseMenu chooseMenu = new ChooseMenu();
					chooseMenu.setVisible(true);
				}
				else {
					JOptionPane.showMessageDialog(null, "Wrong username or password!");
				}
			}
		});
	}
}

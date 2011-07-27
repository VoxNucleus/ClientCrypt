package me.victork.clientcrypt.ui;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import me.victork.clientcrypt.core.CryptographyOptions.CRYPTOGRAPHY_OPTIONS;
import me.victork.clientcrypt.ui.action.ClearAllAction;
import me.victork.clientcrypt.ui.action.DecryptAction;
import me.victork.clientcrypt.ui.action.EncryptAction;

public class CryptPanel extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4086156069252745255L;
	private JTextArea input_area;
	private JPasswordField password;
	private JTextArea encrypted_area;
	private JComboBox crypt_choice;
	private JTextField crypt_strength;
	
	
	/**
	 * Constructor
	 */
	public CryptPanel(){
		
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		// Inserting elements
		
		JLabel label_text = new JLabel("Cryptographie");
		this.add(label_text);
		
		crypt_choice = new JComboBox();
		crypt_choice.setModel(new DefaultComboBoxModel(CRYPTOGRAPHY_OPTIONS.values()));
		
		this.add(crypt_choice);
		
		
		crypt_strength = new JTextField();
		crypt_strength.setText("56");
		
		
		this.add(crypt_strength);
		
		JLabel input_label = new JLabel();
		input_label.setBounds(3, 3, 300, 200);
		
		input_area = new JTextArea(10,50);
		JScrollPane scroll_input = new JScrollPane(input_area);
		input_label.add(scroll_input);
		scroll_input.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createTitledBorder("Texte (non crypte)"),
                BorderFactory.createEmptyBorder(5,5,5,5)));
		this.add(scroll_input);
		
		//Password
		
		password= new JPasswordField();
		password.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createTitledBorder("Mot de passe"),
                BorderFactory.createEmptyBorder(5,5,5,5)));
		this.add(password);
		
		//Encrypted area :
		
		encrypted_area = new JTextArea(10,50);
		JScrollPane e_area_input = new JScrollPane(encrypted_area);
		input_label.add(e_area_input);
		e_area_input.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createTitledBorder("Texte (crypte)"),
                BorderFactory.createEmptyBorder(5,5,5,5)));
		
		this.add(e_area_input);
		
		//Buttons
		JPanel buttons_bottom_panel = new JPanel();
		buttons_bottom_panel.setLayout(new BoxLayout(buttons_bottom_panel,BoxLayout.X_AXIS));
		
		JButton encrypt_button = new JButton("Encrypt");
		encrypt_button.addActionListener(new EncryptAction(this));
		
		JButton descrypt_button = new JButton("Decrypt");
		descrypt_button.addActionListener(new DecryptAction(this));
		
		JButton clear_all = new JButton("Clear All");
		clear_all.addActionListener(new ClearAllAction(this));
		
		JButton encrypted_txt_to_form = new JButton("Export to form");
		
		
		
		buttons_bottom_panel.add(encrypt_button);
		buttons_bottom_panel.add(encrypted_txt_to_form);
		buttons_bottom_panel.add(descrypt_button);
		buttons_bottom_panel.add(clear_all);
		
		this.add(buttons_bottom_panel);
	}
	
	
	
	/**
	 * 
	 */
	
	public void clear_all(){
		input_area.setText("");
		password.setText("");
		encrypted_area.setText("");
	}
	
	/**
	 * 
	 */
	
	public void clear_clear_text_password(){
		password.setText("");
		input_area.setText("");
	}
	
	/**
	 * 
	 * @param text
	 */
	
	public void setEncryptedText(String text){
		encrypted_area.setText(text);
	}
	
	/**
	 * 
	 * @return
	 */
	
	public String getEncryptedText(){
		return encrypted_area.getText();
	}
	
	/**
	 * 
	 * @param text
	 */

	public void setDecryptedText(String text){
		input_area.setText(text);
	}
	
	/**
	 * 
	 * @return Returns the decrypted text
	 */
	
	public String getDecryptedText(){
		return input_area.getText();
	}
	
	/**
	 * 
	 * @return the password
	 */
	public String getPassword(){
		return new String(password.getPassword());
	}
	
	/**
	 * 
	 * @return
	 */
	
	public CRYPTOGRAPHY_OPTIONS getCryptographyOption(){
		return CRYPTOGRAPHY_OPTIONS.values()[crypt_choice.getSelectedIndex()];
	}
	
	/**
	 * 
	 * @param strength
	 */
	
	public void setStrength(int strength){
		
	}
	
	
}

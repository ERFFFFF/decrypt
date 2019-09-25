package Vue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import net.miginfocom.swing.MigLayout;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.UIManager;

import Controleur.CLctrlCmpt;

import javax.swing.JTextField;


public class Frm_Inscr extends JFrame implements ActionListener {

	// Content pane principal
	private JPanel pan = new JPanel();

	// Chemin d'acces au fichier 
	private static String CHEMIN_FICHIER = null;
	private static String KEY = "key";

	private JTextField fieldId;
	private JLabel identifiant = new JLabel("Identifiant :");
	private JLabel mdp = new JLabel("Mot de passe :");
	private final JTextField fieldMdp = new JTextField();
	private final JButton btnValider = new JButton("Valider");
	private final JLabel lblAuthentification = new JLabel("Creer votre compte");
	private final JLabel lblResult = new JLabel("");
	private final JButton btnRetour = new JButton("Retour");

	public Frm_Inscr() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Frm_Inscr.class.getResource("/javax/swing/plaf/basic/icons/JavaCup16.png")));

		// Parametres de la fenetre
		this.setResizable(false);
		// Definit un titre
		this.setTitle("MadMax");
		// Definit sa taille
		this.setBounds(100, 100, 461, 238);
		// Positionne la this au centre
		this.setLocationRelativeTo(null);
		// Termine le processus lors du clic sur la croix rouge
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pan.setLayout(new MigLayout("", "[146px][12px][103px][22px][95px]", "[35px][25px][22px][25px][][]"));
		this.setContentPane(pan);
		
		// Ajouts au content pane	
		lblAuthentification.setFont(new Font("Tahoma", Font.PLAIN, 17));
		pan.add(lblAuthentification, "cell 2 0");
	
		identifiant.setHorizontalAlignment(SwingConstants.LEFT);
		identifiant.setForeground(SystemColor.desktop);
		identifiant.setFont(new Font("Arial", Font.BOLD, 14));
		pan.add(identifiant, "cell 0 2,alignx left,aligny center");
		
		fieldId = new JTextField();
		pan.add(fieldId, "cell 2 2");
		fieldId.setColumns(10);
		
		mdp.setHorizontalAlignment(SwingConstants.LEFT);
		mdp.setForeground(SystemColor.desktop);
		mdp.setFont(new Font("Arial", Font.BOLD, 14));
		pan.add(mdp, "cell 0 3,alignx left,aligny center");
		fieldMdp.setColumns(10);
		
		pan.add(fieldMdp, "cell 2 3");
		pan.add(lblResult, "cell 2 4");
		pan.add(btnValider, "cell 2 5");
		pan.add(btnRetour, "cell 4 0");
		btnValider.addActionListener(this);
		btnRetour.addActionListener(this);
		this.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnValider) {
			// Lorsque l'on clique sur le bouton Valider
			if (!fieldId.getText().isEmpty() || !fieldMdp.getText().isEmpty()) {
				CLctrlCmpt ctrl = new CLctrlCmpt();
				ctrl.m_actionRows(fieldId.getText(), fieldMdp.getText());
				frm_Auth insc = new frm_Auth();
				this.dispose();
			}else {
				lblResult.setText("MDP ou login invalide");
			}
			try {
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(arg0.getSource() == btnRetour) {
			frm_Auth auth = new frm_Auth();
			this.dispose();
		}

	}

}

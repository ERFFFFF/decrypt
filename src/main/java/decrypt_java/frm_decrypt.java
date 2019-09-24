package decrypt_java;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class frm_decrypt {
	
	public static String getfilePath() {
		JFileChooser chooser = new JFileChooser();
		chooser.setCurrentDirectory(new java.io.File("."));
		chooser.setDialogTitle("Selection du fichier");
		chooser.setAcceptAllFileFilterUsed(false);
//		FileNameExtensionFilter filter = new FileNameExtensionFilter(
//                "Fichiers xlsx.", "xlsx");
//        chooser.addChoosableFileFilter(filter);
   
		if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
			System.out.println("getCurrentDirectory(): " + chooser.getCurrentDirectory());
		   return String.valueOf(chooser.getSelectedFile());
		   
		} else {
		  return ("No Selection");
		}
	}
	
	public static String getfilePathSave() {
		JFileChooser save = new JFileChooser();
		save.setApproveButtonText("Enregistrer");
		save.setCurrentDirectory(new java.io.File("."));
		save.setDialogTitle("Enregister Sous");
		save.setAcceptAllFileFilterUsed(false);
		FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "Fichiers txt.", "txt");
        save.addChoosableFileFilter(filter);
       
		if (save.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
			System.out.println("getCurrentDirectory(): " + save.getCurrentDirectory());
		   return String.valueOf(save.getSelectedFile());
		   
		} else {
		  return ("No Selection");
		}
	}

}

package decrypt_java;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Sauvegarde {

	public static String getfilePath() {
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

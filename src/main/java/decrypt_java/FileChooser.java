package decrypt_java;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class FileChooser {

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
}

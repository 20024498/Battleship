package view;

import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class ViewLoadFile extends JPanel{

	private JFileChooser fileChooser;
	private File file;
	private int resultOfDialogOperation;
	
	public ViewLoadFile() {
		
		fileChooser = new JFileChooser();
		file = new File("");
		
		resultOfDialogOperation = fileChooser.showOpenDialog(this);
		
		if(resultOfDialogOperation == JFileChooser.APPROVE_OPTION) {
			
			file = fileChooser.getSelectedFile();
		}
	}

	public JFileChooser getFileChooser() {
		return fileChooser;
	}

	public void setFileChooser(JFileChooser fileChooser) {
		this.fileChooser = fileChooser;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public int getResultOfDialogOperation() {
		return resultOfDialogOperation;
	}

	public void setResultOfDialogOperation(int resultOfDialogOperation) {
		this.resultOfDialogOperation = resultOfDialogOperation;
	}
}

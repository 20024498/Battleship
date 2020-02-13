package view_pop_up_panel;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class ViewSavePanel extends JPanel{

	private JFileChooser fileChooser;
	private File file;
	private int resultOfDialogOperation;
	
	public ViewSavePanel() throws IOException {
		
		fileChooser = new JFileChooser();
		file = new File("");
		resultOfDialogOperation = fileChooser.showSaveDialog(this);
		
		if(resultOfDialogOperation == JFileChooser.APPROVE_OPTION) {
			
			file = fileChooser.getSelectedFile();
            BufferedWriter write = new BufferedWriter(new FileWriter(file));
            write.close();
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

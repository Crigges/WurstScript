package de.peeeq.eclipsewurstplugin.builder;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;

import de.peeeq.wurstscript.WLogger;
import de.peeeq.wurstscript.gui.WurstGui;

public class WurstGuiEclipse extends WurstGui {

	private IProgressMonitor monitor;
	private String taskName;
	private int lastPercent = 0;
	
	public WurstGuiEclipse(IProgressMonitor monitor) {
		this.monitor = monitor;
		this.taskName = "Compiling wurst";
		monitor.beginTask(taskName, 100);
	}
	

	@Override
	public void sendProgress(String whatsRunningNow, double percent) {
		if (whatsRunningNow != null) {
			WLogger.info("progress: " + whatsRunningNow);
		}
		int p = (int) (10000*percent);
		int workDone = p - lastPercent;
		if (workDone <= 0) {
			workDone = 1;
		}
		monitor.worked(workDone);
		lastPercent = p;
		monitor.subTask(whatsRunningNow);
	}

	@Override
	public void sendFinished() {
		monitor.done();
	}
	

	@Override
	public void showInfoMessage(final String message) {
		final Display display = Display.getDefault();
		display.syncExec(new Runnable() {
			
			@Override
			public void run() {
				Shell shell = display.getActiveShell();
				MessageBox dialog = 
						  new MessageBox(shell, SWT.ICON_QUESTION | SWT.OK);
						dialog.setText("Wurst Info");
						dialog.setMessage(message);
						dialog.open(); 
			}
		});
	}
}

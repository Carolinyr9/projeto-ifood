package view;

import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.resource.LocalResourceManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class TemplateParaComponentes extends Composite {
		
	private LocalResourceManager localResourceManager;
	private Display display = getDisplay();

    private void createResourceManager() {
		localResourceManager = new LocalResourceManager(JFaceResources.getResources(), this);
	}


    public TemplateParaComponentes(Composite parent, MainPage mainPage) {
		super(parent, SWT.NONE);
		createResourceManager();
		//Pagrão de largura e altura das telas de componente
		setSize(482, 774);
		setLayout(new FormLayout());
		
		
	}

}

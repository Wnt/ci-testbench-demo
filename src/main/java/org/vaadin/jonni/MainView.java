package org.vaadin.jonni;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.HtmlImport;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.Theme;
import com.vaadin.flow.theme.lumo.Lumo;

@HtmlImport("frontend://styles/shared-styles.html")
@Route("")
@Theme(Lumo.class)
public class MainView extends Div {
	public MainView() {
		add(new Button("Click me!", click -> add(new Paragraph("Button was clicked!"))));
	}
}
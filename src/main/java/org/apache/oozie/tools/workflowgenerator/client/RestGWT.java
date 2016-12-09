/*package org.apache.oozie.tools.workflowgenerator.client;

import org.fusesource.restygwt.client.Method;
import org.fusesource.restygwt.client.MethodCallback;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;

public class RestGWT implements EntryPoint {
	public void onModuleLoad() {
		Button button = new Button("Click Me");
		button.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				InfoService.Util.getService().getInfo("",new MethodCallback<OrderConfirmation>() {
					@Override
					public void onSuccess(Method method, OrderConfirmation response) {
						RootPanel.get().add(new Label(response.toString()));
					}

					@Override
					public void onFailure(Method method, Throwable exception) {
						GWT.log("Error");
					}
				});
			}
		});
		RootPanel.get().add(button);
	}
}*/
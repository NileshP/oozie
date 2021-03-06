package org.apache.oozie.tools.workflowgenerator.client;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.fusesource.restygwt.client.Attribute;
import org.fusesource.restygwt.client.MethodCallback;
import org.fusesource.restygwt.client.Resource;
import org.fusesource.restygwt.client.RestService;
import org.fusesource.restygwt.client.RestServiceProxy;

import com.google.gwt.core.client.GWT;

@Path("/service")
public interface InfoService extends RestService {
	public static class Util {
		private static InfoService instance;

		public static InfoService getService() {
			if (instance == null) {
				instance = GWT.create(InfoService.class);
			}
			Resource resource = new Resource(GWT.getModuleBaseURL() + "service");
			((RestServiceProxy) instance).setResource(resource);
			return instance;
		}
	}

	@POST
	@Path("/loadInfo")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void getInfo(OrderConfirmation xml, MethodCallback<OrderConfirmation> callback);
}
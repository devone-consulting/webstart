package es.devone;

import java.util.logging.Logger;

import javax.jnlp.BasicService;
import javax.jnlp.ServiceManager;
import javax.jnlp.UnavailableServiceException;

import es.devone.app.MyAppFrame;

/**
 * 
 * @author luis.aguilar@devone.es
 *
 */
public class MyAppJnlp {

	static BasicService basicService;

	private static final Logger LOG = Logger.getLogger(MyAppJnlp.class.getName());

	public static void main(String args[]) {
		try {
			basicService = (BasicService) ServiceManager.lookup("javax.jnlp.BasicService");
		} catch (UnavailableServiceException e) {
			LOG.severe("Lookup failed: " + e);
		}
		new MyAppFrame(basicService);
	}
}

package ejbClient;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.tma.ejb.*;

public class Client {

	public static void main(String[] args) {
		Properties prop = new Properties();
		prop.put(Context.INITIAL_CONTEXT_FACTORY, "org.jboss.naming.remote.client.InitialContextFactory");
		prop.put(Context.PROVIDER_URL, "http-remoting://localhost:8080");
		prop.put("jboss.naming.client.ejb.context", true);
		prop.put("remote.connectionprovider.create.options.org.xnio.Options.SSL_ENABLED",false);
		Context context = null;
//		HelloWorldRemote bean;
		ValueRemote bean = null;
		try {
			context = new InitialContext(prop);
			bean = (ValueRemote) context.lookup("/ejbStatelessBean/Value!com.tma.ejb.ValueRemote");
			bean.setValue(37);
			
		} catch (NamingException e) {
			e.printStackTrace();
		} finally {
			System.out.println(bean.getValue());
		}
	}

}

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class Utils {
	private static Context context = null;
	
	public static Context getInitialContext( ) throws NamingException {
		Properties props = new Properties();
		props.put(Context.PROVIDER_URL, "http-remoting://localhost:8080");
		props.put(Context.INITIAL_CONTEXT_FACTORY, "org.jboss.naming.remote.client.InitialContextFactory");
		props.put("jboss.naming.client.ejb.context", true);
		context = new InitialContext(props);
		
		return context;
	}
}

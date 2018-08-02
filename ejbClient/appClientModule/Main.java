
import javax.naming.Context;
import javax.naming.NamingException;

import com.tma.ejb.server.business.HelloWorld;
import com.tma.ejb.server.business.ValueHolder;

public class Main {
	public static void main(String[] args) {
		helloWorld();
		
		getValue();
		
		setValue(5);
		
		getValue();
	}

	private static void setValue(float val) {
		try { 
			Context context = Utils.getInitialContext();
			ValueHolder bean = (ValueHolder) context.lookup("/ejbServer/ValueHolderBean!com.tma.ejb.server.business.ValueHolder");
			System.out.println("Setting value to " + val);
			bean.setValue(val);
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	private static void getValue() {
		try {
			Context context = Utils.getInitialContext();
			ValueHolder bean = (ValueHolder) context.lookup("/ejbServer/ValueHolderBean!com.tma.ejb.server.business.ValueHolder");
			System.out.println(bean.getValue());
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	private static void helloWorld() {
		try {
			Context context = Utils.getInitialContext();
			HelloWorld bean = (HelloWorld) context.lookup("/ejbServer/HelloWorldBean!com.tma.ejb.server.business.HelloWorld");
			System.out.println(bean.getMsg());
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	
	
}
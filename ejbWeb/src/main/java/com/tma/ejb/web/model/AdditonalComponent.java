package com.tma.ejb.web.model;

import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.NamingException;

public class AdditonalComponent extends HelloComponent {
	private List<HelloComponent> components;
	
	public AdditonalComponent(float val) {
		this.value = val;
		components = new ArrayList<HelloComponent>();
	}

	public List<HelloComponent> getComponents() {
		return components;
	}

	public void setComponents(List<HelloComponent> components) {
		this.components = components;
	}

	@Override
	public float getValue(Context context) throws NamingException {
		for (HelloComponent helloComponent : components) {
			this.value = helloComponent.getValue(context);
		}
		return this.value;
	}
}

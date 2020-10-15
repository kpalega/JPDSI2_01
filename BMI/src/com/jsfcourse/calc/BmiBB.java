package com.jsfcourse.calc;

import javax.inject.Inject;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

@Named
@RequestScoped
public class BmiBB {
	private String weight;
	private String height;
	private Double result;

	@Inject
	FacesContext ctx;


	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public Double getResult() {
		return result;
	}

	public void setResult(Double result) {
		this.result = result;
	}

	public boolean doTheMath() {
		try {
			double weight = Double.parseDouble(this.weight);
			double height = Double.parseDouble(this.height);
			height = height/100;

			result = weight/(height*height);

			ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Operacja wykonana poprawnie", null));
			return true;
		} catch (Exception e) {
			ctx.addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "B³¹d podczas przetwarzania parametrów", null));
			return false;
		}
	}
	
	public String calc() {
		if (doTheMath()) {
			return "showresult";
		}
		return null;
	}
	
	public String info() {
		return "info";
	}

}

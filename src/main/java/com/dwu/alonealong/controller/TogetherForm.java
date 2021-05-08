package com.dwu.alonealong.controller;

import java.io.Serializable;

import com.dwu.alonealong.domain.Together;

@SuppressWarnings("serial")
public class TogetherForm implements Serializable {
	
	private Together together;
	private boolean newTogether;

	public TogetherForm(Together together) {
		this.together = together;
		this.newTogether = false;
	}
	
	public TogetherForm() {
		this.together = new Together();
		this.newTogether = true;
	}
	
	public Together getTogether() {
		return together;
	}
	
	public boolean isNewTogether() {
		return newTogether;
	}
	
}

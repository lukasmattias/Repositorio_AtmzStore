module PROJETO_ATMZ_STORE_ELETRONICOS {
	exports exception;
	exports dados;
	exports negocio.beans;
	exports gui;
	exports negocio;

	requires javafx.base;
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.graphics;
	
	opens gui;
}
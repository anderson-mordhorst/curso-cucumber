package br.ce.wcaquino.transforms;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import cucumber.api.Transformer;

public class LocalDateTranform extends Transformer<LocalDate> {

	private DateTimeFormatter formatter;
	
	public LocalDateTranform() {
		this.formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	}
	
	@Override
	public LocalDate transform(String value) {		
		try {
			return LocalDate.parse(value, formatter);
		} catch (DateTimeException e) {
			throw new IllegalArgumentException(e);
		}
	}
}

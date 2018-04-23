package com.ahrytsiv.dma.database.columntypes.postgres;

import com.ahrytsiv.dma.database.columntypes.NumericType;

public class PostgresDoublePrecision implements NumericType{
	public static final String NAME = "double precision";
	
	private final Double value;

	public PostgresDoublePrecision(Double value) {
		this.value = value;
	}
	
}

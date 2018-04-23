package com.ahrytsiv.dma.database.columntypes.postgres;

import com.ahrytsiv.dma.database.columntypes.NumericType;

public class PostgresInteger implements NumericType{
	public static final String NAME = "integer";
	
	private final Integer value;

	public PostgresInteger(Integer value) {
		this.value = value;
	}
}

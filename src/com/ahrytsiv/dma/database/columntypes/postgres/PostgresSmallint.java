package com.ahrytsiv.dma.database.columntypes.postgres;

import com.ahrytsiv.dma.database.columntypes.NumericType;

public class PostgresSmallint implements NumericType{
	public static final String NAME = "smallint";
	
	private final Integer value;

	public PostgresSmallint(Integer value) {
		this.value = value;
	}
	
}

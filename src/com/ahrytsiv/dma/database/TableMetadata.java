package com.ahrytsiv.dma.database;

import java.util.List;

public class TableMetadata {
	@SuppressWarnings("unused")
	private final String tableName;
	@SuppressWarnings("unused")
	private final List<String> columnNames;
	@SuppressWarnings("unused")
	private final List<String> columnTypes;
	
	public TableMetadata(String tableName, List<String> columnNames, List<String> columnTypes) {
		this.tableName = tableName;
		this.columnNames = columnNames;
		this.columnTypes = columnTypes;
	}
}

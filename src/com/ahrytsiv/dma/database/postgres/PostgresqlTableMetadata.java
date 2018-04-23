package com.ahrytsiv.dma.database.postgres;

import java.util.List;

import com.ahrytsiv.dma.database.TableMetadata;

public class PostgresqlTableMetadata extends TableMetadata {

	public PostgresqlTableMetadata(String tableName, List<String> columnNames, List<String> columnTypes) {
		super(tableName, columnNames, columnTypes);
	}

}

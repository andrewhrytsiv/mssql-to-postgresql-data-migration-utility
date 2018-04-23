package com.ahrytsiv.dma.database.microsoft;

import java.util.List;

import com.ahrytsiv.dma.database.TableMetadata;

public class MicrosoftTableMetadata extends TableMetadata {

	public MicrosoftTableMetadata(String tableName, List<String> columnNames, List<String> columnTypes) {
		super(tableName, columnNames, columnTypes);
	}

}

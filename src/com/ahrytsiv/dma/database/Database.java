package com.ahrytsiv.dma.database;

import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

import org.jdbi.v3.core.Handle;
import org.jdbi.v3.core.Jdbi;

import com.google.common.collect.Lists;

public abstract class Database {
	private final Jdbi database;
	private final Handle handle;
	
	public Database(String url, String user, String password) {
		database = Jdbi.create(url, user, password);
		handle = createHandle();
	}
	
	public void close(){
		handle.close();
	}
	
	public Handle createHandle(){
		return database.open();
	}
	
	public TableMetadata getTableMetadata(String tableName){
		return null;
	}
	
	public Set<String> getTableNames(){
		Set<String> tablesSet = new TreeSet<String>();
		try {
			DatabaseMetaData databaseMetaData = this.handle.getConnection().getMetaData();
			ResultSet result = databaseMetaData.getTables(null, null, null, null);
			while (result.next()) {
				String tableType = result.getString("TABLE_TYPE");
				if ("TABLE".equals(tableType)) {
					tablesSet.add(result.getString(3));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tablesSet;
	}
	
	private List<Integer> getTablesCountList(List<String> tableNameList) {
		List<String> countSqlList = tableNameList.stream().map( tableName -> "SELECT count(*) FROM " + tableName+";").collect(Collectors.toList());
		List<Integer> countList = Lists.newArrayList();	
		for (int i = 0; i < tableNameList.size(); i++) {
			Integer count = handle.createQuery(countSqlList.get(i)).mapTo(Integer.class).findOnly();
			countList.add(count);
		}
		return countList;
	}
}

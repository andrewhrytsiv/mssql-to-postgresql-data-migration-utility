package com.ahrytsiv.dma.database;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;

public class TableReaderWriterProcess implements Callable<Boolean>{
	
	private BlockingQueue<DataRow> queue = new ArrayBlockingQueue<>(1000);
	private TableReader tableReader;
	private TableWriter tableWriter;
	
	public TableReaderWriterProcess(TableReader tableReader, TableWriter tableWriter) {
		this.tableReader = new TableReader(queue);
		this.tableWriter = new TableWriter(queue);
	}

	@Override
	public Boolean call() throws InterruptedException {
        Thread reader = new Thread(tableReader);
        reader.start();
        Thread writer = new Thread(tableWriter);
        writer.start();
        reader.join();
        writer.join();
		return true;
	}
}

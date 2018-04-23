package com.ahrytsiv.dma.database;

import java.util.concurrent.BlockingQueue;

public class TableReader implements Runnable{
	private BlockingQueue<DataRow> queue;

	public TableReader(BlockingQueue<DataRow> q) {
		this.queue = q;
	}

	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			DataRow msg = new DataRow("" + i);
			try {
				Thread.sleep(i);
				queue.put(msg);
				System.out.println("Produced " + msg.getMsg());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		DataRow msg = new DataRow("exit");
		try {
			queue.put(msg);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

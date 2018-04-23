package com.ahrytsiv.dma.database;

import java.util.concurrent.BlockingQueue;

public class TableWriter implements Runnable{
	private BlockingQueue<DataRow> queue;

	public TableWriter(BlockingQueue<DataRow> q) {
		this.queue = q;
	}

	@Override
	public void run() {
		try {
			DataRow msg;
			while ((msg = queue.take()).getMsg() != "exit") {
				Thread.sleep(10);
				System.out.println("Consumed " + msg.getMsg());
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

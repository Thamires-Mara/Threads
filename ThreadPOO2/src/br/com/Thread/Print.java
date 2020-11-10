package br.com.Thread;

import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Print implements Runnable {
	
	private String past;
	private int arquivos;
	private int docs;
	
	
	public Print(String past) {
		this.past = past;
		this.arquivos = 0;
		this.docs = 0;
	}

	
	@Override
	public void run() {
		
           File pasta = new File(this.past);
           File [] listaPasta = pasta.listFiles();
           this.arquivos = listaPasta.length;
           for (File file : listaPasta) {
        	   if (file.isFile()) {
        		   ++ this.docs;
        		   String fileName = file.getName();
        		   System.out.printf("%s : %d / %d \n" , fileName , this.docs, this.arquivos);
        	   }
           }
   
	}
	
	public static void main(String[] args) {
		Print pt = new Print ("C:\\Users\\Loop\\Documents\\JOBS\\KPIs Equipe Payments");
		
		ExecutorService es = Executors.newCachedThreadPool();
		es.execute(pt);
		es.shutdown();
	}

}

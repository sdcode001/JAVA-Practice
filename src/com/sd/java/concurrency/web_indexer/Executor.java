package com.sd.java.concurrency.web_indexer;

public class Executor {

	public static void main(String[] args) {
		
//		NaiveIndexer.add(new WebLink(2001, "https://docs.oracle.com/javase/tutorial/java/javaOO/nested.html"));
//		NaiveIndexer.add(new WebLink(2002, "https://www.oracle.com/technetwork/java/javase/downloads/index.html"));
//		NaiveIndexer.add(new WebLink(2003, "https://mindprod.com/jgloss/interfacevsabstract.html"));
//		NaiveIndexer.add(new WebLink(2004, "https://tomcat.apache.org/tomcat-6.0-doc/virtual-hosting-howto.html"));
//		NaiveIndexer.go();
		
		WaitNotifyIndexer.add(new WebLink(2001, "https://docs.oracle.com/javase/tutorial/java/javaOO/nested.html"));
		WaitNotifyIndexer.add(new WebLink(2002, "https://www.oracle.com/technetwork/java/javase/downloads/index.html"));
		WaitNotifyIndexer.add(new WebLink(2003, "https://mindprod.com/jgloss/interfacevsabstract.html"));
		WaitNotifyIndexer.add(new WebLink(2004, "https://tomcat.apache.org/tomcat-6.0-doc/virtual-hosting-howto.html"));
		WaitNotifyIndexer.go();
	}

}

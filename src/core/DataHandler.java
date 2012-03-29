package core;

import messageTypes.Message;

public class DataHandler {
    private static DataHandler instance = null;
 
    /**
     * Default-Konstruktor, der nicht au�erhalb dieser Klasse
     * aufgerufen werden kann
     */
    private DataHandler() {}
 
    /**
     * Statische Methode, liefert die einzige Instanz dieser
     * Klasse zur�ck
     */
    public static DataHandler getInstance() {
        if (instance == null) {
            instance = new DataHandler();
        }
        return instance;
    }
    
    public void handleMessage(Message msg){
    	
    	msg.send();
    }
}


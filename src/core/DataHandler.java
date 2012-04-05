package core;

import messageTypes.Message;

public class DataHandler {
    private static DataHandler instance = null;
 
    /**
     * Default-Konstruktor, der nicht ausserhalb dieser Klasse
     * aufgerufen werden kann
     */
    private DataHandler() {}
 
    /**
     * Statische Methode, liefert die einzige Instanz dieser
     * Klasse zurück
     */
    public static DataHandler getInstance() {
        if (instance == null) {
            instance = new DataHandler();
        }
        return instance;
    }
    
    public void handleMessage(Message msg){
    	if (msg.validate()) {
    		msg.send();
    	} else
    		System.out.println("Message not validated correctly!");
    }
}


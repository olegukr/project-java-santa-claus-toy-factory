package org.factoriaf5.singletons;

import org.factoriaf5.db.GoodToyDatabase;

public class GoodToyDatabaseSingleton {
    
    private static GoodToyDatabase INSTANCE;

    private GoodToyDatabaseSingleton() {}

    public static GoodToyDatabase getInstance() {
        if (INSTANCE == null) INSTANCE = new GoodToyDatabase();
        return INSTANCE;
    }
}

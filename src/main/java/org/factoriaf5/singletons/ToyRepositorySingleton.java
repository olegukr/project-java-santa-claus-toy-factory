package org.factoriaf5.singletons;

import org.factoriaf5.repository.ToyRepository;

public class ToyRepositorySingleton {
    private static ToyRepository INSTANCE;
    
        private ToyRepositorySingleton() {}
    
        public static ToyRepository getInstance() {
            if (INSTANCE == null) INSTANCE = new ToyRepository();
        return INSTANCE;
    }
}

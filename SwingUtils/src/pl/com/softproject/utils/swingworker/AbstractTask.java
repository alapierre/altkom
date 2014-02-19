/* 
 * Copyright 2012-11-21 the original author or authors.
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License. 
 */
package pl.com.softproject.utils.swingworker;

import java.util.concurrent.ExecutionException;
import javax.swing.SwingWorker;

/**
 * Bazowy task do obsługi zadań realizowanych w tle
 * 
 * @author Adrian Lapierre <adrian@softproject.com.pl>
 */
public abstract class AbstractTask<T, V> extends SwingWorker<T, V> {
    
    @Override
    protected final void done() {
        try {
            if (isCancelled()) {
                cancelled();
            } else {
                try {
                    succeeded(get());
                } catch (InterruptedException e) {
                    interrupted(e);
                } catch (ExecutionException e) {
                    failed(e.getCause());
                }
            }
        } finally {
            finished();
        }
    }

    /**
     * Metoda zostanie wywołana w przpadku anulowania zadania
     */
    protected void cancelled() {
    }
    
    /**
     * Metoda zostanie wywołana gdy zadanie zostanie wykonane porawnie
     * 
     * @param result 
     */
    protected void succeeded(T result) {
    }

    /**
     * Metoda zostanie wykonana w przypadku przerwania wątku
     * 
     * @param e - zgłoszony wyjątek
     */
    protected void interrupted(InterruptedException e) {
    }
    
    /**
     * Metoda zostawnie wywołana w przypadku powstania błędu w zadaniu
     * 
     * @param cause 
     */
    protected void failed(Throwable cause) {
    }
    
    /**
     * Metoda zostanie wykonanan zawsze na końcu zadania realizowanego w tle
     */
    protected void finished() {
    }
    
}

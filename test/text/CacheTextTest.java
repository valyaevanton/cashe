package com.anton.test.text;

import com.anton.buffer.object.strategies.MostRecentlyUsed;
import com.anton.buffer.text.CacheText;
import com.anton.buffer.object.strategies.LeastRecentlyUsed;
import org.junit.Test;

import static org.junit.Assert.*;

public class CacheTextTest {

    @Test
    public void saveAndRestore() throws Exception {
        try(CacheText cache = new CacheText(5, 10, LeastRecentlyUsed::new)){
            cache.save(5, "Anton");
            assertEquals(5, cache.getExternalBufferUsed());
            assertEquals(0, cache.getInternalBufferUsed());

            Thread.sleep(10);
            cache.save(12, "Ivan");
            assertEquals(4, cache.getExternalBufferUsed());
            assertEquals(5, cache.getInternalBufferUsed());

            Thread.sleep(10);
            assertEquals("Ivan", cache.restore(12));
            assertEquals(5, cache.getExternalBufferUsed());
            assertEquals(0, cache.getInternalBufferUsed());
        }
    }

}
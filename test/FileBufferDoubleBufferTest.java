package com.anton.test;

import com.anton.string.AbstractBuffer;
import com.anton.FileBuffer;
import com.anton.exceptions.BufferIOException;
import com.anton.exceptions.BufferKeyAlreadyExistsException;
import com.anton.exceptions.BufferKeyNotFoundException;
import com.anton.exceptions.BufferOverflowException;
import org.junit.Test;

public class FileBufferDoubleBufferTest extends DoubleBufferTest {
    @Test
    public void saveAndRestore()
            throws BufferOverflowException, BufferKeyAlreadyExistsException,
            BufferIOException, BufferKeyNotFoundException {
        try(
                AbstractBuffer extBuf = new FileBuffer(externalBufferSize, "test1");
                AbstractBuffer intBuf = new FileBuffer(internalBufferSize, "test2")
        ){
            super.saveAndRestore(extBuf, intBuf);
        }
    }
}

package com.anton.buffer.text;

import com.anton.buffer.object.BufferEmulator;

public class BufferEmulatorText extends BufferEmulator<String> implements BufferText {

    public BufferEmulatorText(int bufferSize) {
        super(bufferSize);
    }
}
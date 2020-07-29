package com.lugew.winsim.util;

import lombok.experimental.UtilityClass;

@UtilityClass
public class ByteUtil {
    public  byte arithmeticMoveRight(byte input, int moveBits,int leftBits) {

        int resolver=1;
        while (--leftBits > 0) {
            resolver+=1<<leftBits;
        }
        return (byte) ((input >>> moveBits)&resolver);
    }
}

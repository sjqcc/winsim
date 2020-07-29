package com.lugew.winsim.util;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ByteUtilSpecification {

    @Test
    void givenArithmeticMoveRightWhenNegative112MoveRight4ThenReturn9() {
        assertThat(ByteUtil.arithmeticMoveRight((byte) -112, 4,4))
        .isEqualTo((byte)9);
    }
}
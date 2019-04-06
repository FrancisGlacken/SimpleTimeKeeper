package com.deltorostudios.punchclockmockup2;

import com.deltorostudios.punchclockmockup2.Util.FormatMillisIntoTimer;

import org.junit.Test;

import static org.junit.Assert.*;

public class FormatMillisIntoTimerTest {

    FormatMillisIntoTimer formatMillisIntoTimer = new FormatMillisIntoTimer();

    @Test
    public void formatMillisIntoHMS() {
        final String expected = "24:01:05";
        final String actual = formatMillisIntoTimer.FormatMillisIntoHMS(86465000L);

        assertEquals(expected, actual);
    }

    @Test
    public void formatMillisIntoDHM() {
        final String expected = "1d0h1m";
        final String actual = formatMillisIntoTimer.FormatMillisIntoDHM(86460000L);

        assertEquals(expected, actual);
    }
}
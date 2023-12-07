package com.example.myapplication;

import android.content.Context;
import android.graphics.Path;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        assertEquals("com.example.myapplication", appContext.getPackageName());
    }
    @Test
    public void testPMGetY() {
        // Get the application context using InstrumentationRegistry
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();

        // use the context to create an instance of PathMaker
        int[] roomIndices = {1, 2, 3}; // Replace with your desired room indices for testing
        PathMaker pathMaker = new PathMaker(2.75f, roomIndices);

        assertEquals(2.75f*625, pathMaker.getY(2), 0.0);



    }
    @Test
    public void testPMGetX() {
        // Get the application context using InstrumentationRegistry
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();

        int[] roomIndices = {1, 2, 3}; // Replace with your desired room indices for testing
        PathMaker pathMaker = new PathMaker(2.75f, roomIndices);


        assertEquals(2.75f*92, pathMaker.getX(2), 0.0);


    }
    @Test
    public void testC1getX(){
        C1floor c = new C1floor(2.75F, 110, 120);
        assertEquals(2.75f*106, c.getX(110), 0.0);

    }
    @Test
    public void testC1getY(){
        C1floor c = new C1floor(2.75F, 110, 120);
        assertEquals(2.75f*730, c.getY(110), 0.0);


    }
    @Test
    public void testC1check(){
        C1floor c = new C1floor(2.75F, 110, 120);
        assertTrue(c.check(110));
    }

    @Test
    public void testC1check2(){
        C1floor c = new C1floor(2.75F, 110, 120);
        assertTrue(!c.check(444));
    }
}
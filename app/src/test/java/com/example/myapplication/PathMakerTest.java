package com.example.myapplication;

import android.graphics.Path;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(AndroidJUnit4.class)
public class PathMakerInstrumentedTest {

    @Test
    public void testPathGeneration() {
        // Obtain the app's context using InstrumentationRegistry
        // This is necessary for running Android Instrumented Tests
        android.content.Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();

        // Define a scaling factor and an array of room indices for testing
        float scaler = 1.0f; // You can set your desired scaling factor
        int[] roomIndices = { /* your room indices here */ };

        // Create an instance of PathMaker
        PathMaker pathMaker = new PathMaker(scaler, roomIndices);

        // Get the generated path
        Path generatedPath = pathMaker.getPath();

        // Assert that the generated path is not null
        assertNotNull(generatedPath);

        // You can add more assertions based on your specific requirements
        // For example, you might want to test that the path contains the expected number of segments,
        // or that the scaled coordinates are correct for certain room indices.

        // Example: Assert that the scaled x-coordinate for room index 10 is as expected
        float expectedX = 100.0f * scaler;
        assertEquals(expectedX, pathMaker.getX(10), 0.001); // You can adjust the delta based on your precision requirements
    }
}


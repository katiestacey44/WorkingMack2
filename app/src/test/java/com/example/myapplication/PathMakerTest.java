package com.example.myapplication;

import android.graphics.Path;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(AndroidJUnit4.class)
public class PathMakerTest {

    @Test
    public void testPathGenerationWithScaling() {
        // Get the app's context using InstrumentationRegistry
        android.content.Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();

        // Set up test data
        float scaler = 1.0f;
        int[] roomIndices = { 20,12,14,20 };

        // Create an instance of PathMaker
        PathMaker pathMaker = new PathMaker(scaler, roomIndices);

        // Get the generated path
        Path generatedPath = pathMaker.getPath();

        // Assert that the generated path is not null
        assertNotNull("Generated path should not be null", generatedPath);

        // Test a specific case (e.g., room index 10)
        float expectedX = 100.0f * scaler;
        assertEquals("X-coordinate for room index 10 should match", expectedX, pathMaker.getX(10), 0.001);
    }

    // Add more test methods for additional scenarios
    // ...
}
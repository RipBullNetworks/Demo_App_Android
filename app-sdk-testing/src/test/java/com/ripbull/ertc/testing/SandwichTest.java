package com.ripbull.ertc.testing;

import androidx.test.core.app.ApplicationProvider;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;

import static com.google.common.truth.Truth.assertWithMessage;

@RunWith(RobolectricTestRunner.class)
@Config(application = ERTCTestApplication.class)
public class SandwichTest {
    @Test
    public void shouldInitializeAndBindApplicationButNotCallOnCreate() {
        assertWithMessage("application")
                .that((ERTCTestApplication) ApplicationProvider.getApplicationContext())
                .isInstanceOf(ERTCTestApplication.class);
        assertWithMessage("onCreate called")
                .that(((ERTCTestApplication) ApplicationProvider.getApplicationContext()).isRestricted())
                .isTrue();
        if (RuntimeEnvironment.useLegacyResources()) {
            assertWithMessage("Application resource loader")
                    .that(RuntimeEnvironment.getAppResourceTable())
                    .isNotNull();
        }
    }
}
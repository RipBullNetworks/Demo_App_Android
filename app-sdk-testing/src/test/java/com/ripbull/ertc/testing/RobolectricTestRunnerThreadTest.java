package com.ripbull.ertc.testing;


import android.content.Context;

import androidx.test.core.app.ApplicationProvider;

import com.ripbull.coresdk.Configuration;
import com.ripbull.coresdk.core.type.AccountDetails;
import com.ripbull.coresdk.data.common.Result;
import com.ripbull.coresdk.eRTCSDK;

import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;
import kotlin.jvm.JvmField;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.TestObserver;
import io.reactivex.schedulers.TestScheduler;

import static android.os.Looper.getMainLooper;
import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertEquals;
import static org.robolectric.Shadows.shadowOf;

@RunWith(RobolectricTestRunner.class)
public class RobolectricTestRunnerThreadTest {
  private CompositeDisposable disposable;
  private TestScheduler testScheduler =  new TestScheduler();
  private Context applicationContext;
  private TestObserver<Object> objectTestObserver = TestObserver.create();
  @Rule
  @BeforeClass
  public static void beforeClass() throws Exception {
  }

  @Before
  public void setUp() throws Exception {
    disposable = new CompositeDisposable();
    applicationContext = ApplicationProvider.getApplicationContext();
    Configuration config = new Configuration.Builder()
            .context(applicationContext)
            .apiKey("p0xfmr9v")
            .namespace("tester-13.qa.ertc.com").build();
    eRTCSDK.initializeWithConfig(config);

    /*TestObserver<Result> test = eRTCSDK.initializeWithConfig(config);
    //shadowOf(getMainLooper()).idle();
    test.assertNoErrors();
    test.assertSubscribed();
    test.assertComplete();*/

  }

  @After
  public void tearDown() throws Exception {
    disposable.dispose();
  }

  @Test
  public void test_rx_java(){
    Observable.just(1)
        .test()
        .assertSubscribed()
        .assertValues(1)
        .assertComplete()
        .assertNoErrors();
  }
  @Test
  public void verify_tenant_with_valid_namespace_and_accesscode() {
    //TestObserver<Result> result = eRTCSDK.tenant().validate("tester-13.qa.ertc.com").test();
   /* TestObserver<Result> testObserver = new TestObserver<>();
    Single<Result> validate = eRTCSDK.tenant().validate("tester-13.qa.ertc.com");
    validate.subscribeOn(Schedulers.trampoline()).observeOn(Schedulers.trampoline()).subscribe(testObserver);
    testObserver.awaitTerminalEvent(5, TimeUnit.SECONDS);
    testObserver.assertNoErrors();
    Boolean success = validate.blockingGet().isSuccess();
    assertEquals(true, success);
    testObserver.assertComplete();*/
      eRTCSDK.tenant().validate("tester-13.qa.ertc.com")
          .toObservable()
          .test()
          .assertSubscribed()
          .assertValue(result -> result.isSuccess() == true)
          .assertComplete()
          .assertNoErrors();;
    //shadowOf(getMainLooper()).idle();
    //objectTestObserver.awaitTerminalEvent();

    //result.awaitTerminalEvent(5, TimeUnit.SECONDS);
    //shadowOf(getMainLooper()).idle();
    //result
    //    .assertNoErrors()
    //    .assertValue(result1 -> Objects.equals(result1.getMessage(), "Test"));

    //result.assertNoErrors();
    //result.assertSubscribed();
    //result.assertResult(new Result(true,"",""));
    //result.assertComplete();
    //result.assertNoErrors().assertValue(result1 -> Objects.equals(result1.getMessage(), "Test"));
    //=assertThat(result.isSuccess()).isTrue();
  }

  @Test
  public void verify_login_with_valid_credentials() {
    TestObserver<Result> result = eRTCSDK.tenant()
            .login(AccountDetails.username("manidinesh89@gmail.com", "password@123"))
            .test();
    shadowOf(getMainLooper()).idle();
    result.assertNoErrors().assertValue(Result::isSuccess);
  }

  @AfterClass
  public static void afterClass() throws Exception {
    //assertThat(Thread.currentThread() == sThread).isTrue();
    //assertThat(Thread.currentThread().getContextClassLoader() == sClassLoader).isTrue();
  }
}
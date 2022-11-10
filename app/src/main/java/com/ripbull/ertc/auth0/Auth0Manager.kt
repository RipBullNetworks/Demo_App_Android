package com.ripbull.ertc.auth0

import android.app.Activity
import android.content.Context
import com.auth0.android.Auth0
import com.auth0.android.authentication.AuthenticationAPIClient
import com.auth0.android.authentication.AuthenticationException
import com.auth0.android.authentication.storage.SecureCredentialsManager
import com.auth0.android.authentication.storage.SharedPreferencesStorage
import com.auth0.android.callback.Callback
import com.auth0.android.provider.WebAuthProvider
import com.auth0.android.request.DefaultClient
import com.auth0.android.result.Credentials
import com.auth0.android.result.UserProfile
import com.google.gson.Gson
import com.ripbull.ertc.R
import timber.log.Timber

class Auth0Manager// Only enable network traffic logging on production environments!
    (context: Context) {
    companion object {
        private var instance: Auth0Manager? = null

        @JvmStatic
        fun getInstance(context: Context): Auth0Manager {
            if (instance == null) {
                instance = Auth0Manager(context.applicationContext)
            }
            return instance!!
        }
    }

    private var auth0: Auth0
    private var secureCredentialsManager: SecureCredentialsManager
    private var authenticationAPIClient: AuthenticationAPIClient

    init {
        auth0 = Auth0(
            clientId = context.getString(R.string.com_auth0_client_id),
            domain = context.getString(R.string.com_auth0_domain),
        )
        auth0.networkingClient = DefaultClient(enableLogging = true)
        authenticationAPIClient = AuthenticationAPIClient(auth0)
        secureCredentialsManager = SecureCredentialsManager(
            context,
            authenticationAPIClient,
            SharedPreferencesStorage(context)
        )
    }

    fun login(
        activity: Activity,
        onSuccess: (Credentials) -> Unit,
        onError: (AuthenticationException) -> Unit
    ) {
        WebAuthProvider.login(auth0)
            .withScheme("inappchat")
            .withParameters(mapOf("prompt" to "login"))
            .withScope("openid email profile offline_access")
            .start(activity, object : Callback<Credentials, AuthenticationException> {
                // Called when there is an authentication failure
                override fun onFailure(error: AuthenticationException) {
                    // Something went wrong!
                    Timber.e(error)
                    onError.invoke(error)
                }

                // Called when authentication completed successfully
                override fun onSuccess(result: Credentials) {
                    // Get the access token from the credentials object.
                    // This can be used to call APIs
                    Timber.d(Gson().toJson(result))
                    onSuccess.invoke(result)
                }
            })
    }

    fun register(
        email: String, password: String, connection: String,
        onSuccess: (Credentials) -> Unit,
        onError: (AuthenticationException) -> Unit
    ) {
        authenticationAPIClient.signUp(email = email, password = password, connection = connection)
            .validateClaims()
            .start(object : Callback<Credentials, AuthenticationException> {
                // Called when there is an authentication failure
                override fun onFailure(error: AuthenticationException) {
                    // Something went wrong!
                    Timber.e(error)
                    onError.invoke(error)
                }

                // Called when authentication completed successfully
                override fun onSuccess(result: Credentials) {
                    // Get the access token from the credentials object.
                    // This can be used to call APIs
                    Timber.d(Gson().toJson(result))
                    onSuccess.invoke(result)
                }
            })
    }

    fun logout(activity: Activity, onComplete: () -> Unit) {
        WebAuthProvider.logout(auth0)
            .withScheme("https")
            .start(activity, object : Callback<Void?, AuthenticationException> {
                override fun onSuccess(result: Void?) {
                    onComplete.invoke()
                }

                override fun onFailure(error: AuthenticationException) {
                    Timber.e(error)
                    onComplete.invoke()
                }
            })
    }

    fun showUserProfile(
        credentials: Credentials,
        onError: (AuthenticationException) -> Unit,
        onSuccess: (UserProfile) -> Unit
    ) {
        val client = AuthenticationAPIClient(auth0)

        // With the access token, call `userInfo` and get the profile from Auth0.
        client.userInfo(credentials.accessToken)
            .start(object : Callback<UserProfile, AuthenticationException> {
                override fun onFailure(error: AuthenticationException) {
                    Timber.e(error)
                    onError.invoke(error)
                }

                override fun onSuccess(result: UserProfile) {
                    Timber.d(Gson().toJson(result))
                    onSuccess.invoke(result)
                }
            })
    }

    fun clearCredentials() {
        secureCredentialsManager.clearCredentials()
    }
}
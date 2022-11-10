package com.ripbull.coresdk.wrappers;

import java.lang.System;

/**
 * Created by DK on 12/06/20.
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010\t\u001a\u00020\nH\u0002J\u0016\u0010\u000b\u001a\u00020\n2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0002J\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\u0006\u0010\u0012\u001a\u00020\u0013J\u0018\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\n\u0010\u0015\u001a\u00060\u0016R\u00020\u0017J\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\u0006\u0010\u0019\u001a\u00020\u000eJ\u0014\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\u0006\u0010\u0012\u001a\u00020\u0013J\u0014\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\u0006\u0010\u0012\u001a\u00020\u0013J\u0018\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001d0\u00102\n\u0010\u0015\u001a\u00060\u0016R\u00020\u0017J\u0014\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\u0006\u0010\u001f\u001a\u00020 J\u0018\u0010!\u001a\b\u0012\u0004\u0012\u00020\u001d0\u00102\n\u0010\u0015\u001a\u00060\u0016R\u00020\u0017R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\""}, d2 = {"Lcom/ripbull/coresdk/wrappers/UserWrapper;", "", "dataManager", "Lcom/ripbull/coresdk/data/DataManager;", "(Lcom/ripbull/coresdk/data/DataManager;)V", "gson", "Lcom/google/gson/Gson;", "preferenceManager", "Lcom/ripbull/ertc/cache/preference/PreferenceManager;", "isE2EFeatureEnabled", "", "saveUsersInSync", "userList", "", "Lcom/ripbull/ertc/cache/database/entity/User;", "userAddUpdated", "Lio/reactivex/Observable;", "Lcom/ripbull/coresdk/user/mapper/UserRecord;", "userDBUpdate", "Lcom/ripbull/coresdk/user/model/UserDBUpdate;", "userBlockStatusUpdated", "eventItem", "Lcom/ripbull/ertc/remote/model/response/UserSelfUpdateResponse$EventItem;", "Lcom/ripbull/ertc/remote/model/response/UserSelfUpdateResponse;", "userBlockStatusUpdatedBySelf", "user", "userDeleted", "userInactivated", "userMetaDataUpdated", "Lcom/ripbull/coresdk/user/mapper/UserMetaDataRecord;", "userMetaUpdated", "receivedMessage", "Lcom/ripbull/ertc/mqtt/listener/ReceivedMessage;", "userSelfAvailabilityUpdated", "ripbull-chat-sdk_devDebug"})
public final class UserWrapper {
    private final com.ripbull.coresdk.data.DataManager dataManager = null;
    private final com.google.gson.Gson gson = null;
    private final com.ripbull.ertc.cache.preference.PreferenceManager preferenceManager = null;
    
    public UserWrapper(@org.jetbrains.annotations.NotNull()
    com.ripbull.coresdk.data.DataManager dataManager) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final io.reactivex.Observable<com.ripbull.coresdk.user.mapper.UserMetaDataRecord> userMetaDataUpdated(@org.jetbrains.annotations.NotNull()
    com.ripbull.ertc.remote.model.response.UserSelfUpdateResponse.EventItem eventItem) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final io.reactivex.Observable<com.ripbull.coresdk.user.mapper.UserRecord> userMetaUpdated(@org.jetbrains.annotations.NotNull()
    com.ripbull.ertc.mqtt.listener.ReceivedMessage receivedMessage) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final io.reactivex.Observable<com.ripbull.coresdk.user.mapper.UserMetaDataRecord> userSelfAvailabilityUpdated(@org.jetbrains.annotations.NotNull()
    com.ripbull.ertc.remote.model.response.UserSelfUpdateResponse.EventItem eventItem) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final io.reactivex.Observable<com.ripbull.coresdk.user.mapper.UserRecord> userBlockStatusUpdated(@org.jetbrains.annotations.NotNull()
    com.ripbull.ertc.remote.model.response.UserSelfUpdateResponse.EventItem eventItem) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final io.reactivex.Observable<com.ripbull.coresdk.user.mapper.UserRecord> userAddUpdated(@org.jetbrains.annotations.NotNull()
    com.ripbull.coresdk.user.model.UserDBUpdate userDBUpdate) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final io.reactivex.Observable<com.ripbull.coresdk.user.mapper.UserRecord> userDeleted(@org.jetbrains.annotations.NotNull()
    com.ripbull.coresdk.user.model.UserDBUpdate userDBUpdate) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final io.reactivex.Observable<com.ripbull.coresdk.user.mapper.UserRecord> userInactivated(@org.jetbrains.annotations.NotNull()
    com.ripbull.coresdk.user.model.UserDBUpdate userDBUpdate) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final io.reactivex.Observable<com.ripbull.coresdk.user.mapper.UserRecord> userBlockStatusUpdatedBySelf(@org.jetbrains.annotations.NotNull()
    com.ripbull.ertc.cache.database.entity.User user) {
        return null;
    }
    
    private final boolean saveUsersInSync(java.util.List<com.ripbull.ertc.cache.database.entity.User> userList) {
        return false;
    }
    
    private final boolean isE2EFeatureEnabled() {
        return false;
    }
}
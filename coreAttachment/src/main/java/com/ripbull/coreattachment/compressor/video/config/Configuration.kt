package com.ripbull.coreattachment.compressor.video.config

import com.ripbull.coreattachment.compressor.video.VideoQuality

data class Configuration(
    var quality: VideoQuality = VideoQuality.MEDIUM,
    var frameRate: Int? = null,
    var isMinBitrateCheckEnabled: Boolean = true,
    var videoBitrate: Int? = null
)

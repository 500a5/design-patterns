package proxy.proxy

import proxy.some_cool_media_library.ThirdPartyYouTubeClass
import proxy.some_cool_media_library.ThirdPartyYouTubeLib
import proxy.some_cool_media_library.Video


class YouTubeCacheProxy : ThirdPartyYouTubeLib {
    private val youtubeService: ThirdPartyYouTubeLib
    private var cachePopular: HashMap<String, Video> = HashMap()
    private val cacheAll = HashMap<String, Video>()

    init {
        youtubeService = ThirdPartyYouTubeClass()
    }

    override fun popularVideos(): HashMap<String, Video> {
        if (cachePopular.isEmpty()) {
            cachePopular = youtubeService.popularVideos()
        } else {
            println("Retrieved list from cache.")
        }
        return cachePopular
    }

    override fun getVideo(videoId: String): Video {
        var video = cacheAll[videoId]
        if (video == null) {
            video = youtubeService.getVideo(videoId)
            cacheAll[videoId] = video
        } else {
            println("Retrieved video '$videoId' from cache.")
        }
        return video
    }

    fun reset() {
        cachePopular.clear()
        cacheAll.clear()
    }
}
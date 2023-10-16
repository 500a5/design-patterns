package proxy.some_cool_media_library

interface ThirdPartyYouTubeLib {
    fun popularVideos(): HashMap<String, Video>
    fun getVideo(videoId: String): Video
}
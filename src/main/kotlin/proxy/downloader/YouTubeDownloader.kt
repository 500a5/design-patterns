package proxy.downloader

import proxy.some_cool_media_library.ThirdPartyYouTubeLib


class YouTubeDownloader(private val api: ThirdPartyYouTubeLib) {
    fun renderVideoPage(videoId: String) {
        val video = api.getVideo(videoId)
        println("\n-------------------------------")
        println("Video page (imagine fancy HTML)")
        println("ID: " + video!!.id)
        println("Title: " + video.title)
        println("Video: " + video.data)
        println("-------------------------------\n")
    }

    fun renderPopularVideos() {
        val list = api.popularVideos()
        println("\n-------------------------------")
        println("Most popular videos on YouTube (imagine fancy HTML)")
        for (video in list.values) {
            println("ID: " + video.id + " / Title: " + video.title)
        }
        println("-------------------------------\n")
    }
}
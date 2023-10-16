package proxy

import proxy.downloader.YouTubeDownloader

import proxy.proxy.YouTubeCacheProxy

import proxy.some_cool_media_library.ThirdPartyYouTubeClass


fun main() {
    val naiveDownloader = YouTubeDownloader(ThirdPartyYouTubeClass())
    val smartDownloader = YouTubeDownloader(YouTubeCacheProxy())
    val naive = test(naiveDownloader)
    val smart = test(smartDownloader)
    print("Time saved by caching proxy: " + (naive - smart) + "ms")
}

private fun test(downloader: YouTubeDownloader): Long {
    val startTime = System.currentTimeMillis()

    // User behavior in our app:
    downloader.renderPopularVideos()
    downloader.renderVideoPage("catzzzzzzzzz")
    downloader.renderPopularVideos()
    downloader.renderVideoPage("dancesvideoo")
    // Users might visit the same page quite often.
    downloader.renderVideoPage("catzzzzzzzzz")
    downloader.renderVideoPage("someothervid")
    val estimatedTime = System.currentTimeMillis() - startTime
    print(
        " Time elapsed: ${estimatedTime}ms".trimIndent()
    )
    return estimatedTime
}

/**
 * Заместитель — это структурный паттерн проектирования,
 * который позволяет подставлять вместо реальных объектов специальные объекты-заменители.
 * Эти объекты перехватывают вызовы к оригинальному объекту, позволяя сделать что-то до или после передачи вызова оригиналу.
 *
 * Заместитель — это объект, который выступает прослойкой между клиентом и реальным сервисным объектом.
 * Заместитель получает вызовы от клиента, выполняет свою функцию (контроль доступа, кеширование, изменение запроса и прочее), а затем передаёт вызов сервисному объекту.

Заместитель имеет тот же интерфейс, что и реальный объект, поэтому для клиента нет разницы — работать через заместителя или напрямую.
 */
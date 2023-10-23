package iterator.social_networks

import iterator.iterators.FacebookIterator
import iterator.iterators.ProfileIterator
import iterator.profile.Profile


class Facebook(cache: List<Profile>?) : SocialNetwork {
    private var profiles: List<Profile>? = null

    init {
        profiles = cache ?: ArrayList()
    }

    fun requestProfileFromFacebook(profileEmail: String): Profile? {
        // Здесь бы был POST запрос к одному из адресов API Facebook. Но вместо
        // этого мы эмулируем долгое сетевое соединение, прямо как в реальной
        // жизни...
        simulateNetworkLatency()
        println("Facebook: Loading profile '$profileEmail' over the network...")

        // ...и возвращаем тестовые данные.
        return findProfile(profileEmail)
    }

    fun requestProfileFriendsFromFacebook(profileEmail: String, contactType: String): List<String>? {
        // Здесь бы был POST запрос к одному из адресов API Facebook. Но вместо
        // этого мы эмулируем долгое сетевое соединение, прямо как в реальной
        // жизни...
        simulateNetworkLatency()
        println("Facebook: Loading '$contactType' list of '$profileEmail' over the network...")

        // ...и возвращаем тестовые данные.
        val profile: Profile? = findProfile(profileEmail)
        return profile?.getContacts(contactType)
    }

    private fun findProfile(profileEmail: String): Profile? {
        if (!profiles.isNullOrEmpty())
            for (profile in profiles!!) {
                if (profile.email == profileEmail) {
                    return profile
                }
            }
        return null
    }

    private fun simulateNetworkLatency() {
        try {
            Thread.sleep(2500)
        } catch (ex: InterruptedException) {
            ex.printStackTrace()
        }
    }

    override fun createFriendsIterator(profileEmail: String): ProfileIterator {
        return FacebookIterator(this, "friends", profileEmail)
    }

    override fun createCoworkersIterator(profileEmail: String): ProfileIterator {
        return FacebookIterator(this, "coworkers", profileEmail)
    }
}
package iterator.social_networks

import iterator.iterators.LinkedInIterator
import iterator.iterators.ProfileIterator
import iterator.profile.Profile


class LinkedIn(cache: List<Profile>?) : SocialNetwork {
    private var contacts: List<Profile>? = null

    init {
        contacts = cache ?: ArrayList()
    }

    fun requestContactInfoFromLinkedInAPI(profileEmail: String): Profile? {
        // Здесь бы был POST запрос к одному из адресов API LinkedIn. Но вместо
        // этого мы эмулируем долгое сетевое соединение, прямо как в реальной
        // жизни...
        simulateNetworkLatency()
        println("LinkedIn: Loading profile '$profileEmail' over the network...")

        // ...и возвращаем тестовые данные.
        return findContact(profileEmail)
    }

    fun requestRelatedContactsFromLinkedInAPI(profileEmail: String, contactType: String): List<String>? {
        // Здесь бы был POST запрос к одному из адресов API LinkedIn. Но вместо
        // этого мы эмулируем долгое сетевое соединение, прямо как в реальной
        // жизни...
        simulateNetworkLatency()
        println("LinkedIn: Loading '$contactType' list of '$profileEmail' over the network...")

        // ...и возвращаем тестовые данные.
        return findContact(profileEmail)?.getContacts(contactType)
    }

    private fun findContact(profileEmail: String): Profile? {
        if (!contacts.isNullOrEmpty())
            for (profile in contacts!!) {
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
        return LinkedInIterator(this, "friends", profileEmail)
    }

    override fun createCoworkersIterator(profileEmail: String): ProfileIterator {
        return LinkedInIterator(this, "coworkers", profileEmail)
    }
}
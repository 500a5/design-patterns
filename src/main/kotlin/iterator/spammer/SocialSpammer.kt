package iterator.spammer

import iterator.iterators.ProfileIterator
import iterator.profile.Profile
import iterator.social_networks.SocialNetwork


class SocialSpammer(var network: SocialNetwork) {
    var iterator: ProfileIterator? = null
    fun sendSpamToFriends(profileEmail: String, message: String) {
        println("\nIterating over friends...\n")
        iterator = network.createFriendsIterator(profileEmail)
        while (iterator!!.hasNext()) {
            val profile: Profile? = iterator!!.next
            sendMessage(profile!!.email, message)
        }
    }

    fun sendSpamToCoworkers(profileEmail: String, message: String) {
        println("\nIterating over coworkers...\n")
        iterator = network.createCoworkersIterator(profileEmail)
        while (iterator!!.hasNext()) {
            val profile: Profile? = iterator!!.next
            sendMessage(profile!!.email, message)
        }
    }

    private fun sendMessage(email: String, message: String) {
        println("Sent message to: '$email'. Message body: '$message'")
    }
}
package iterator.iterators

import iterator.profile.Profile
import iterator.social_networks.Facebook

class FacebookIterator( private val facebook: Facebook, private val type: String, private val email: String) :
    ProfileIterator {

    private var currentPosition = 0
    private val emails: MutableList<String> = ArrayList()
    private val profiles: MutableList<Profile?> = ArrayList()



    private fun lazyLoad() {
        if (emails.size == 0) {
            val profiles  = facebook.requestProfileFriendsFromFacebook(
                email,
                type
            )
            if (profiles != null) {
                for (profile in profiles) {
                    emails.add(profile)
                    this.profiles.add(null)
                }
            }
        }
    }

    override fun hasNext(): Boolean {
        lazyLoad()
        return currentPosition < emails.size
    }

    override val next: Profile?
        get() {
            if (!hasNext()) {
                return null
            }
            val friendEmail = emails[currentPosition]
            var friendProfile: Profile? = profiles[currentPosition]
            if (friendProfile == null) {
                friendProfile = facebook.requestProfileFromFacebook(friendEmail)
                profiles[currentPosition] = friendProfile
            }
            currentPosition++
            return friendProfile
        }

    override fun reset() {
        currentPosition = 0
    }
}
package iterator.social_networks

import iterator.iterators.ProfileIterator


interface SocialNetwork {
    fun createFriendsIterator(profileEmail: String): ProfileIterator
    fun createCoworkersIterator(profileEmail: String): ProfileIterator
}
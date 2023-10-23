package iterator.iterators

import iterator.profile.Profile

interface ProfileIterator {

    operator fun hasNext(): Boolean
    val next: Profile?

    fun reset()
}
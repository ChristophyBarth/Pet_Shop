package capps.teaching.petshop.data

import capps.teaching.petshop.model.Pet

class BackendReplica {

    /*"Dogs" -> arrayListOf("Pluto", "Max", "Jack", "Boogie", "Billy", "Densy")
    "Cats" -> arrayListOf("Whiskers", "Mittens", "Luna")
    "Snakes" -> arrayListOf()
    "Birds" -> arrayListOf("Tweety", "Sky", "Feather", "Merlin")
    "Squirrels" -> arrayListOf("Nutty", "Squeaky", "Hazel", "Acorn", "Pippin")
    "Lizards" -> arrayListOf("Spike", "Rex", "Lizzie", "Draco", "Ziggy", "Gex")
    "Rabbits" -> arrayListOf(
    "Floppy", "Thumper", "Coottontail", "Binky", "Snowball", "Hopscotch", "Daisy"
    )*/
    fun dogs(): ArrayList<Pet> {
        val dogList = arrayListOf<Pet>()

        dogList.apply {
            add(
                Pet(
                    "Pluto",
                    "Meet Pluto, who loves long walks in the park.",
                    3.7,
                    52.0,
                    "https://i.imgur.com/bbdDSsm.jpg","#E1CC4F"
                )
            )
            add(
                Pet(
                    "Max",
                    "",
                    1.5,
                    20.0,
                    "https://unsplash.com/photos/m-Doa-GTrUw"
                )
            )
            add(
                Pet(
                    "Jack",
                    "",
                    4.0,
                    65.0,
                    "https://www.pexels.com/photo/brown-pomeranian-puppy-on-grey-concrete-floor-3687770/"
                )
            )
            add(
                Pet(
                    "Boogie",
                    "",
                    3.3,
                    34.99,
                    "https://www.pexels.com/photo/brown-pomeranian-puppy-on-grey-concrete-floor-3687770/"
                )
            )
            add(
                Pet(
                    "Billy",
                    "",
                    3.7,
                    52.0,
                    "https://www.pexels.com/photo/brown-pomeranian-puppy-on-grey-concrete-floor-3687770/"
                )
            )
            add(
                Pet(
                    "Densy",
                    "",
                    4.8,
                    75.99,
                    "https://www.pexels.com/photo/brown-pomeranian-puppy-on-grey-concrete-floor-3687770/"
                )
            )
        }

        return dogList
    }

    fun cats() : ArrayList<Pet> {
       // arrayListOf("Whiskers", "Mittens", "Luna")

        val catList = arrayListOf<Pet>()

        catList.apply {
            add(
                Pet(
                    "Whiskers",
                    "",
                    4.2,
                    75.0,
                    "https://www.pexels.com/photo/brown-pomeranian-puppy-on-grey-concrete-floor-3687770/"
                )
            )
            add(
                Pet(
                    "Max",
                    "",
                    3.8,
                    56.0,
                    "https://www.pexels.com/photo/brown-pomeranian-puppy-on-grey-concrete-floor-3687770/"
                )
            )
            add(
                Pet(
                    "Jack",
                    "",
                    4.6,
                    98.0,
                    "https://www.pexels.com/photo/brown-pomeranian-puppy-on-grey-concrete-floor-3687770/"
                )
            )
        }

        return catList
    }
    fun snakes() : ArrayList<Pet>{
       // arrayListOf("Whiskers", "Mittens", "Luna")

        val catList = arrayListOf<Pet>()

        catList.apply {
            add(
                Pet(
                    "Whiskers",
                    "",
                    4.2,
                    75.0,
                    "https://www.pexels.com/photo/brown-pomeranian-puppy-on-grey-concrete-floor-3687770/"
                )
            )
            add(
                Pet(
                    "Max",
                    "",
                    3.8,
                    56.0,
                    "https://www.pexels.com/photo/brown-pomeranian-puppy-on-grey-concrete-floor-3687770/"
                )
            )
            add(
                Pet(
                    "Jack",
                    "",
                    4.6,
                    98.0,
                    "https://www.pexels.com/photo/brown-pomeranian-puppy-on-grey-concrete-floor-3687770/"
                )
            )
        }

        return catList
    }
}
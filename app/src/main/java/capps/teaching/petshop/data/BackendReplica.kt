package capps.teaching.petshop.data

import capps.teaching.petshop.OurObject
import capps.teaching.petshop.OurObject.imgurJPGLink
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
                    "Densy",
                    "Introducing Densy, a cuddle connoisseur.",
                    4.8,
                    75.99,
                    "https://imgur.com/brW8gqd",
                    "#D5A672"
                )
            )
            add(
                Pet(
                    "Billy",
                    "Meet Billy, a squirrel-chasing expert.",
                    3.7,
                    52.0,
                    "https://imgur.com/5b36jKP",
                    "#475874"
                )
            )
            add(
                Pet(
                    "Boogie",
                    "Meet Boogie, a fetch and nap enthusiast.",
                    3.3,
                    34.99,
                    "https://imgur.com/dYVuzgs",
                    "#DD8AC2"
                )
            )
            add(
                Pet(
                    "Pluto",
                    "This is Pluto, your hiking buddy.",
                    3.7,
                    52.0,
                    "https://imgur.com/lfwK9Uh","#162018"
                )
            )
            add(
                Pet(
                    "Max",
                    "Say hi to Max, a fetching enthusiast!",
                    1.5,
                    20.0,
                    "https://imgur.com/iEHLMul"
                )
            )
            add(
                Pet(
                    "Jack",
                    "Meet Jack, who loves long walks in the park.",
                    4.0,
                    65.0,
                    "https://imgur.com/u8D7WIt",
                    "#000000"
                )
            )
            add(
                Pet(
                    "Bounce",
                    "It's Bounce, the perpetual motion machine who loves to leap and play!",
                    2.3,
                    24.99,
                    "https://imgur.com/2rmedNs",
                    "#D68819"
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
                    "Mittens",
                    "Greet Mittens, the royal ruler of your heart.",
                    4.2,
                    75.0,
                    "https://imgur.com/ROIxYEF"
                )
            )
            add(
                Pet(
                    "Whiskers",
                    "Introducing Whiskers, the purr-fect nap companion.",
                    3.8,
                    56.0,
                    "https://imgur.com/bt05vbM"
                )
            )
            add(
                Pet(
                    "Jack",
                    "Say hi to Jack, the elegant lap cat.",
                    4.6,
                    98.0,
                    "https://imgur.com/YS47PLL",
                    "#B86547"
                )
            )
        }

        return catList
    }
    fun snakes() : ArrayList<Pet>{
       // arrayListOf("Whiskers", "Mittens", "Luna")

        val snakeList = arrayListOf<Pet>()

        snakeList.apply {
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

        return snakeList
    }
}
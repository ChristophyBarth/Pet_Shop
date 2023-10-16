package capps.teaching.petshop.data

import capps.teaching.petshop.OurObject
import capps.teaching.petshop.OurObject.imgurJPGLink
import capps.teaching.petshop.model.Owner
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
                Pet(0,
                    "Densy",
                    "Introducing Densy, a cuddle connoisseur.",
                    "Densy, the cuddle connoisseur, is a canine marvel with a heart full of admirable attributes. This furry friend is the embodiment of loyalty, always there to stand by your side through thick and thin. Densy's playfulness is infectious, bringing boundless joy and excitement to every moment. Densy's affectionate nature shines through in warm snuggles and gentle gazes, offering solace like no other. Densy's intelligence and adaptability make them a quick learner and a versatile companion. With a kind and empathetic spirit, Densy is attuned to your emotions, providing comfort and amplifying happiness. Densy is brave, protective, and endlessly loving, making them not just a pet but a cherished family member whose presence is a daily blessing.",
                    4.8,
                    75.99,
                    "https://imgur.com/brW8gqd",
                    "#D5A672",
                    Owner("https://imgur.com/34taVjD", "Christophy Barth", "Owner", "1.6")
                )
            )
            add(
                Pet(1,
                    "Billy",
                    "Meet Billy, a squirrel-chasing expert.",
                    "",
                    3.7,
                    52.0,
                    "https://imgur.com/5b36jKP",
                    "#475874"
                )
            )
            add(
                Pet(2,
                    "Boogie",
                    "Meet Boogie, a fetch and nap enthusiast.",
                    "",
                    3.3,
                    34.99,
                    "https://imgur.com/dYVuzgs",
                    "#DD8AC2"
                )
            )
            add(
                Pet(3,
                    "Pluto",
                    "This is Pluto, your hiking buddy.",
                    "",
                    3.7,
                    52.0,
                    "https://imgur.com/lfwK9Uh","#162018"
                )
            )
            add(
                Pet(
                    4,
                    "Max",
                    "Say hi to Max, a fetching enthusiast!",
                    "",
                    1.5,
                    20.0,
                    "https://imgur.com/iEHLMul",
                    "#162018"
                )
            )
            add(
                Pet(
                    5,
                    "Jack",
                    "Meet Jack, who loves long walks in the park.",
                    "",
                    4.0,
                    65.0,
                    "https://imgur.com/u8D7WIt",
                    "#000000"
                )
            )
            add(
                Pet(
                    6,
                    "Bounce",
                    "It's Bounce, the perpetual motion machine who loves to leap and play!",
                    "",
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
                Pet(0,
                    "Mittens",
                    "Greet Mittens, the royal ruler of your heart.",
                    "",
                    4.2,
                    75.0,
                    "https://imgur.com/ROIxYEF",
                    "#162018"
                )
            )
            add(
                Pet( 1,
                    "Whiskers",
                    "Introducing Whiskers, the purr-fect nap companion.",
                    "",
                    3.8,
                    56.0,
                    "https://imgur.com/bt05vbM",
                    "#162018"
                )
            )
            add(
                Pet(2,
                    "Jack",
                    "Say hi to Jack, the elegant lap cat.",
                    "",
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
            /*add(
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
            )*/
        }

        return snakeList
    }
}
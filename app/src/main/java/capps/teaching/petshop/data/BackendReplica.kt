package capps.teaching.petshop.data

import capps.teaching.petshop.model.Info
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
                Pet(
                    0,
                    "Densy",
                    "Introducing Densy, a cuddle connoisseur.",
                    "Densy, the cuddle connoisseur, is a canine marvel with a heart full of admirable attributes. This furry friend is the embodiment of loyalty, always there to stand by your side through thick and thin. Densy's playfulness is infectious, bringing boundless joy and excitement to every moment. Densy's affectionate nature shines through in warm snuggles and gentle gazes, offering solace like no other. Densy's intelligence and adaptability make them a quick learner and a versatile companion. With a kind and empathetic spirit, Densy is attuned to your emotions, providing comfort and amplifying happiness. Densy is brave, protective, and endlessly loving, making them not just a pet but a cherished family member whose presence is a daily blessing.",
                    4.8,
                    75.99,
                    "https://imgur.com/brW8gqd",
                    "#D5A672",
                    Owner("https://imgur.com/34taVjD", "Christophy Barth", "Owner", "1.6"),
                    Info("2", "G. Retriever", 'M', 2.45)


                )
            )
            add(
                Pet(
                    1,
                    "Billy",
                    "Meet Billy, a squirrel-chasing expert.",
                    "",
                    3.7,
                    52.0,
                    "https://imgur.com/5b36jKP",
                    "#475874",
                    Owner(
                        "https://www.biewerworld.com/wp-content/uploads/2018/03/24313084_766079160242062_803134831150721829_o.jpg",
                        "Maya Biewer",
                        "Trainer",
                        "2.45"
                    ), Info("1", "Y. Terrier", 'M', 1.7)
                )
            )
            add(
                Pet(
                    2,
                    "Boogie",
                    "Meet Boogie, a fetch and nap enthusiast.",
                    "",
                    3.3,
                    34.99,
                    "https://imgur.com/dYVuzgs",
                    "#DD8AC2",
                    Owner(
                        "data:image/jpeg;base64,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",
                        "Sidhu M.",
                        "Owner",
                        "0.85"
                    ), Info("1", "G. Hound", 'M', 3.0)
                )
            )
            add(
                Pet(
                    3,
                    "Pluto",
                    "This is Pluto, your hiking buddy.",
                    "",
                    3.7,
                    52.0,
                    "https://imgur.com/lfwK9Uh", "#162018",
                    Owner(
                        "https://media-cldnry.s-nbcnews.com/image/upload/newscms/2018_09/1321708/liam-rice-dog-twinning-today-170301-tease.jpg",
                        "Liam Moore", "Owner", "1.0"
                    ), Info("0.5", "Husky", 'M', 2.5)
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
                    "#162018",
                    Owner("", "Wright", "Owner", "4.0"),
                    Info("0.7", "Pomeranian", 'M', 2.0)
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
                    "#000000",
                    Owner(
                        "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTj7Yv4Vs6oBCSscXW7d9Om7YZFo69cm_D-Xg&usqp=CAU",
                        "Dennis E.",
                        "Owner",
                        "12.4"
                    ),
                    Info("1.1", "Bos. terrier", 'M', 2.0)
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
                    "#D68819", Owner(
                        "data:image/jpeg;base64,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",
                        "Bernadine",
                        "Owner",
                        "6.5"
                    ), Info("0.9", "Labradore", 'M', 3.0)
                )
            )
        }

        return dogList
    }

    fun cats(): ArrayList<Pet> {
        // arrayListOf("Whiskers", "Mittens", "Luna")

        val catList = arrayListOf<Pet>()

        catList.apply {
            add(
                Pet(
                    0,
                    "Mittens",
                    "Greet Mittens, the royal ruler of your heart.",
                    "",
                    4.2,
                    75.0,
                    "https://imgur.com/ROIxYEF",
                    "#162018",
                    Owner(
                        "https://usascholarships.com/wp-content/uploads/2017/04/female-accountant-at-the-office-a.jpg",
                        "Laurels N.",
                        "Owner",
                        "1.75"
                    ), Info("2", "Somali", 'M', 1.5)
                )
            )
            add(
                Pet(
                    1,
                    "Whiskers",
                    "Introducing Whiskers, the purr-fect nap companion.",
                    "",
                    3.8,
                    56.0,
                    "https://imgur.com/bt05vbM",
                    "#162018",
                    Owner(
                        "https://usascholarships.com/wp-content/uploads/2017/04/female-accountant-at-the-office-a.jpg",
                        "Laurels N.",
                        "Owner",
                        "1.75"
                    ), Info("1.3", "Devon Rex", 'M', 1.4)
                )
            )
            add(
                Pet(
                    2,
                    "Jack",
                    "Say hi to Jack, the elegant lap cat.",
                    "",
                    4.6,
                    98.0,
                    "https://imgur.com/YS47PLL",
                    "#B86547",
                    Owner(
                        "data:image/jpeg;base64,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",
                        "Marrie",
                        "Owner",
                        "8.0"
                    ), Info("1.5", "Somali", 'M', 1.0)
                )
            )
        }

        return catList
    }


    fun birds(): ArrayList<Pet> {
        val birdList = arrayListOf<Pet>()

        birdList.apply {
            add(
                Pet(
                    0,
                    "Tweety",
                    " With his innocent demeanor and clever wit, Tweety's adventures never fail to bring a smile to our faces.",
                    "Meet Tweety, the charming canary with a personality as vibrant as his feathers. This plucky parrot, known for his cheerful disposition and distinctive speech, has been a beloved character in the world of animation for generations.",
                    4.9,
                    120.0,
                    "https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcQdkF8NqeF1TwRNQjFQ5_97N-IWHMGkeVuwR_iGkyGyOLKekzCz",
                    "#20214F",
                    Owner(
                        "data:image/jpeg;base64,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",
                        "Gandhi",
                        "Owner",
                        "1.23"
                    ), Info("1.3", "Macaw", 'M', 0.7)

                )
            )

        }
        return birdList
    }

    fun snakes(): ArrayList<Pet> {
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
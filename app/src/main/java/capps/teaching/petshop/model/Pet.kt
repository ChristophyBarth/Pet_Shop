package capps.teaching.petshop.model

class Pet {
    var name: String? = null
    var bio: String? = null
    var rating: Double? = null
    var price: Double? = null
    var photoUrl: String? = null
    var themeColor: String? = null
    var owner: Owner? = null

    constructor()
    

    /**
     * If you do not have the themeColor
     */
    constructor(name: String?, bio: String?, rating: Double?, price: Double?, photoUrl: String?) {
        this.name = name
        this.bio = bio
        this.rating = rating
        this.price = price
        this.photoUrl = photoUrl
    }


    constructor(
        name: String?,
        bio: String?,
        rating: Double?,
        price: Double?,
        photoUrl: String?,
        themeColor: String?
    ) {
        this.name = name
        this.bio = bio
        this.rating = rating
        this.price = price
        this.photoUrl = photoUrl
        this.themeColor = themeColor
    }

    constructor(name: String?, bio: String?) {
        this.name = name
        this.bio = bio
    }

    constructor(
        name: String?,
        bio: String?,
        rating: Double?,
        price: Double?,
        photoUrl: String?,
        themeColor: String?,
        owner: Owner?
    ) {
        this.name = name
        this.bio = bio
        this.rating = rating
        this.price = price
        this.photoUrl = photoUrl
        this.themeColor = themeColor
        this.owner = owner
    }


}


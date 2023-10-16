package capps.teaching.petshop.model

class Pet {
    var id: Int? = null
    var name: String? = null
    var title: String? = null
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
    constructor(
        id: Int?,
        name: String?,
        title: String?,
        bio: String?,
        rating: Double?,
        price: Double?,
        photoUrl: String?,
        owner: Owner?
    ) {
        this.id = id
        this.name = name
        this.bio = bio
        this.title = title
        this.rating = rating
        this.price = price
        this.photoUrl = photoUrl
        this.owner = owner
    }


    constructor(
        id: Int?,
        name: String?,
        title: String?,
        bio: String?,
        rating: Double?,
        price: Double?,
        photoUrl: String?,
        themeColor: String?,
        owner: Owner?
    ) {
        this.id = id
        this.name = name
        this.bio = bio
        this.title = title
        this.rating = rating
        this.price = price
        this.photoUrl = photoUrl
        this.themeColor = themeColor
        this.owner = owner
    }

    constructor(
        id: Int?,
        name: String?,
        title: String?,
        bio: String?,
        rating: Double?,
        price: Double?,
        photoUrl: String?,
        themeColor: String?
    ) {
        this.id = id
        this.name = name
        this.bio = bio
        this.title = title
        this.rating = rating
        this.price = price
        this.photoUrl = photoUrl
        this.themeColor = themeColor
    }


}


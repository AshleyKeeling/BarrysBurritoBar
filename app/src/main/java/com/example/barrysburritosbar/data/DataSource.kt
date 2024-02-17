package com.example.barrysburritosbar.data

import com.example.barrysburritosbar.R
object DataSource {
    val navoptions = listOf(
        Pair(R.string.home_screen, 0),
        Pair(R.string.custom_made_burrito_screen, 1),
        Pair(R.string.pre_made_burritos_screen, 2),
        Pair(R.string.basket_screen, 3)
    )

    val fillingOptions = listOf(
        Pair("Grilled Chicken", 0),
        Pair("Beef", 1),
        Pair("Pork", 2),
        Pair("Roasted Vegetables", 3)
    )

    val sauceOptions = listOf(
        Pair("Garlic Mayo", 0),
        Pair("Sweet Chilli", 1),
        Pair("Tomato Relish", 2)
    )

    val preMadeBurritos = listOf(
        listOf("Spicy Fiesta Delight", "Grilled chicken; black beans; rice; salsa.", "7.99", "spicy_fiesta_delight_img", "The Spicy Chicken Cravings Burrito is no stranger to being grilled. With that kind of name, we can only imagine the trouble this Burrito can find itself in. Both literally and figuratively. Literally, because well, duh. You’re getting a burrito which is amazing in itself. But figuratively because it’s got the kick of some major ‘tude with the help of the spicy grilled chicken with those fiery jalapeños. Yeah, that kind of kick."),
        listOf("Vegetarian Harvest", "Roasted vegetables; black beans; rice.", "6.49", "vegetarian_harvest_img", "With 7-layers of completely different and delicious ingredients, the 7-Layer Burrito is kind of like that 7-floor city apartment you see in a US sitcom. Every floor has completely different personalities, but somehow everybody’s unique dynamic created a sort of perfect, 7-layer family. Similar to a 7-Layer Burrito. You know… Black beans live on the first floor and always tells you jokes in a different language, then laughs hysterically. Seasoned Rice is an elderly woman that lives on the second floor and has a lovely patio garden. Guacamole lives on the third floor and is a dancer, you think. Shredded Lettuce is the landlord and lives on the fourth floor. Three-Cheese Blend is a musician on the fifth floor and brings the party to the 7-Layer Burrito. Diced Tomatoes lives on the sixth floor and is probably a dude named Jeff. He’s a pretty cool guy. Again, what’s a 7-Layer Burrito (and apartment building for that matter) without the seventh floor? The penthouse of the building. It’s owned by an eccentric and evasive guy, Sour Cream."),
        listOf("Cheesy Roll-up", "Cheddar cheese; blue cheese.", "5.00", "cheesy_roll_img", "Heavy metal. Astrophysics. The basic rules of football. However, sometimes something as simple as melted three-cheese blend rolled up in a flour tortilla is all you need. We’re taking it back to the basics and back to the simple things in life. You know those days when you can take in the afternoon breeze on your bike humming along to the sweet sound of cardboard pegged on your wheel spokes? Yeah, those days. Well, lucky for all of you, the Cheesy Roll-Up is just like that sweet afternoon. It’s there for you when you need that extra pick me up. It’s like after a long day of work or school and you just need something quick that will get the job done. Cue the Cheesy Roll-Up. Quick and simple without any of the flashy gimmicks to come with it. Because let’s be honest, who needs all those gimmicks. Not only is it reliable, it simply fits your needs. Do you have a picky eater in the family? Then we got you. This will be the safety net you’ll want that will cure the hunger monster within. Grouchy, picky eater, say no more. This cheesy concoction is so simple but all you need. We could probably keep going on this description, but to prove how good simple things can be, we won’t even add another sentence. Oh wait, we blew that idea apparently. Shoot, we did it again. Ahhh…"),
        listOf("Beefy Nacho", "Slow cooked beef; red peppers; cheese.", "8.49", "beefy_nacho_img", "Can’t decide if you want a burrito or nachos? Now you don’t need to! With the Beefy Nacho Cravings Burrito, you can enjoy the best of both worlds."),
        listOf("Crispy Chicken", "Cripsy Chicken; grilled chicken red peppers; cheese.", "9.49", "crispy_chicken_img", "Soft flour tortilla, two crispy chicken strips, creamy jalapeño style sauce, crisp lettuce, diced tomatoes and cheddar cheese. What’s not to love?"),
    )

    val saladOptions = listOf(
        Pair("Lettuce", 0),
        Pair("Red Peppers", 1),
        Pair("Tomato", 2 )
    )

    var CurrentOrder = mutableListOf<List<String>>()

    var FavouriteOrder = mutableListOf(
        listOf("Beefy Nacho", "Slow cooked beef; red peppers; cheese", "12")
    )

    var LastOrder = mutableListOf(
        listOf("Beefy Nacho", "Slow cooked beef; red peppers; cheese", "12"),
        listOf("Crispy Chicken", "Cripsy Chicken; grilled chicken red peppers; cheese.", "9.49"),
    )
}

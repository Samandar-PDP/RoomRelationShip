package com.example.roomrelationship.util

import com.example.roomrelationship.database.Club
import com.example.roomrelationship.database.Player

object ObjectList {
    fun playerList(): List<Player> {
        return listOf(
            Player(
                0,
                "Ronaldo"
            ),
            Player(
                1,
                "Messi"
            ),
            Player(
                2,
                "Kane"
            ),
            Player(
                3,
                "Neymar"
            ),
            Player(
                4,
                "Son"
            ),
            Player(
                5,
                "Lewandowski"
            )
        )
    }

    fun clubList(): List<Club> {
        return listOf(
            Club(
                0,
                "Sporting",
                0
            ),
            Club(
                1,
                "Real Madrid",
                0,
            ),
            Club(
                2,
                "Barcelona",
                1
            ),
            Club(
                3,
                "Psg",
                1
            ),
            Club(
                4,
                "Man Utd",
                0
            ),
            Club(
                5,
                "Borussiya D",
                5
            ),
            Club(
                6,
                "Bavariya",
                5
            ),
            Club(
                7,
                "Barcelona",
                5
            )
        )
    }
}
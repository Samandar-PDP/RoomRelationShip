package com.example.roomrelationship.database

import androidx.room.*

@Entity(tableName = "Player")
data class Player(
    @PrimaryKey(autoGenerate = true)
    var playerId: Int = 0,
    @ColumnInfo(name = "player_name")
    val name: String
)

@Entity(tableName = "Club")
data class Club(
    @PrimaryKey(autoGenerate = true)
    var clubId: Int = 0,
    @ColumnInfo(name = "club_name")
    val name: String,
    val ownerPlayerId: Int
)

data class PlayerAndClub(
    @Embedded val player: Player,
    @Relation(
        parentColumn = "playerId",
        entityColumn = "ownerPlayerId"
    )
    val clubList: List<Club>
)
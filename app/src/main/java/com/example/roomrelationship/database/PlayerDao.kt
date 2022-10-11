package com.example.roomrelationship.database

import androidx.room.*

@Dao
interface PlayerDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun savePlayers(players: List<Player>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveClubs(clubs: List<Club>)

    @Transaction
    @Query("SELECT * FROM Player WHERE playerId = :id")
    fun getPlayerAndClubById(id: Int): List<PlayerAndClub>
}
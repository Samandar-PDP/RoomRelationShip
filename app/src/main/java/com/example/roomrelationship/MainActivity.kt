package com.example.roomrelationship

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.core.text.isDigitsOnly
import com.example.roomrelationship.database.PlayerDatabase
import com.example.roomrelationship.databinding.ActivityMainBinding
import com.example.roomrelationship.util.ObjectList

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val database by lazy { PlayerDatabase.invoke(this) }
    val list = mutableListOf<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        database.dao.saveClubs(ObjectList.clubList())
        database.dao.savePlayers(ObjectList.playerList())

        binding.btnGet.setOnClickListener {
            val id = binding.editText.text.toString().trim()
            if (id.isDigitsOnly()) {
                val playerAndClub = database.dao.getPlayerAndClubById(id.toInt())
                binding.textId.text = playerAndClub[0].player.playerId.toString()
                binding.textName.text = playerAndClub[0].player.name
                for (name in playerAndClub) {
                    playerAndClub.map {
                        for (clubName in it.clubList) {
                            list.add(clubName.name)
                        }
                    }
                }
                val arrayAdapter = ArrayAdapter(
                    this,
                    android.R.layout.simple_spinner_item,
                   list
                )
                binding.spinner.adapter = arrayAdapter
            }
        }
    }
}
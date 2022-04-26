package edu.adehnerova.contactproject

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query


@Dao
interface ContactDAO {

    @Insert
    fun insertContact(contacts: Contact)

    @Query("SELECT * FROM contacts WHERE name LIKE '%' || :name || '%'")
    fun findContact(name: String): List<Contact>

    @Query("SELECT * FROM contacts ORDER BY name DESC")
    fun descSort(): List<Contact>

    @Query("SELECT * FROM contacts ORDER BY name ASC")
    fun ascSort(): List<Contact>

    @Query("DELETE FROM contacts WHERE id = :id")
    fun deleteContact(id: Int)

    @Query("SELECT * FROM contacts")
    fun getAllContacts(): LiveData<List<Contact>>
}
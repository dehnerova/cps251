package edu.adehnerova.contactproject

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "contacts")
class Contact {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name="id")
    var contactId: Int = 0

    @ColumnInfo(name = "name")
    var contactName: String? = null
    var phoneNumber: String? = null

    //default constructor
    constructor(){}

    constructor(name: String, phone: String){
        this.contactName = name
        this.phoneNumber = phone
    }
    constructor(id: Int, name: String, phone: String) {
        this.contactId = id
        this.contactName = name
        this.phoneNumber = phone
    }

}
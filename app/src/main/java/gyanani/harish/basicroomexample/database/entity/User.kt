package gyanani.harish.basicroomexample.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
class User(
    @PrimaryKey @ColumnInfo(name = "username")
    var name: String
) {
}
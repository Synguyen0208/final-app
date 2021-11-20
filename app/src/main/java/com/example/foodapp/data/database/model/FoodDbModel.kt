package com.example.foodapp.data.database.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Fts4
import androidx.room.PrimaryKey
import com.example.foodapp.R

@Entity()
data class FoodDbModel(
  @PrimaryKey(autoGenerate = true) val id: Long = 0,
  @ColumnInfo(name = "name") val name: String,
  @ColumnInfo(name = "image") val image: Int,
  @ColumnInfo(name = "price") val price: Long,
  @ColumnInfo(name = "star") val star: Int
) {

  companion object {
    val DEFAULT_FOODS = listOf(
      FoodDbModel(1, "Gà chiên", R.drawable.gachien, 50000, 5),
      FoodDbModel(2, "Vịt chiên", R.drawable.vit, 50000, 5),
      FoodDbModel(3, "Tôm hùm luộc", R.drawable.tomhum, 50000, 5),
      FoodDbModel(4, "Cua hoàng đế", R.drawable.cua, 50000, 5),
      FoodDbModel(5, "Cơm chiên", R.drawable.conchien, 50000, 5),
      FoodDbModel(6, "Trà sữa", R.drawable.trasua, 50000, 5),
      FoodDbModel(7, "Ốc hút", R.drawable.oc, 50000, 5),
      FoodDbModel(8, "Bánh canh", R.drawable.bangcanh, 50000, 5),
      FoodDbModel(9, "Chân gà sả tắc", R.drawable.changangamsatac, 50000, 5),
      FoodDbModel(10, "Nem chua rán", R.drawable.nem, 50000, 5),
      FoodDbModel(11, "Xúc xích chiên", R.drawable.xucxich, 50000, 5),
      FoodDbModel(12, "Bắp xào", R.drawable.bapxao, 50000, 5)
    )
  }
}

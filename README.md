# Understanding implementing ROOM Database

## Main Components

1. @Entity Represents a table within the database.

2. @Dao - SQL Queries Responsible for defining the methods that access the database.

3. @Database Contains the database holder and serves as the main access point for the underlying
   connection to your app's data.

/**

* FILE 01 * Model - @Entity
*
* Shoe entity to be stored in the shoes_database.
  */

/**

* FILE 02 - *Dao - @Dao
*
* Data Access Object for database interaction.
  */

/**

* FILE 03 - *ViewModel -
*
* Shared [ViewModel] to provide data to the [*ListFragment], [ShoeDetailFragment],
* and [*Fragment] and allow for interaction the the [ShoeDao]
  */

/**

* FILE 04 - *Database - @Database
*
* Room database to persist data for the Shoes Planet app.
* This database stores a [Shoe] entity
  */

/**

* File 05 - BaseApplication
*
* An application class that inherits from [Application], allows for the creation of a singleton
* instance of the [ShoeDatabase]
*

*/

/**

* FILE 06 - *ListAdapter
*
* Adapter for the RecyclerView being used in the ShoeListFragment.kt file
  */ ============= Practice:

Continue:
ROOM Database - Kotlin
https://www.youtube.com/playlist?list=PLSrm9z4zp4mEPOfZNV9O-crOhoMa0G2-o

Next: Android Room with a View - Kotlin
https://developer.android.com/codelabs/android-room-with-a-view-kotlin#0

Learn advanced coroutines with Kotlin Flow and LiveData
https://kiosk-dot-codelabs-site.appspot.com/codelabs/advanced-kotlin-coroutines/index.html?index=..%2F..index#7
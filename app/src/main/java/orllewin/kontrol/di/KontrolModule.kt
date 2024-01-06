package orllewin.kontrol.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import orllewin.kontrol.repository.ShortcutsRepository
import orllewin.kontrol.datastore.ShortcutDao
import orllewin.kontrol.datastore.ShortcutGroupDao
import orllewin.kontrol.datastore.ShortcutsDatabase
import orllewin.kontrol.repository.ShortcutsRepositoryImpl

@Module
@InstallIn(SingletonComponent::class)
class KontrolModule {
    @Provides
    fun shortcutsDatabase(@ApplicationContext context: Context) =
    Room.databaseBuilder(context, ShortcutsDatabase::class.java, "shortcut_database").build()

    @Provides
    fun shortcutsGroupDao(database: ShortcutsDatabase) = database.shortcutGroupDao()

    @Provides
    fun shortcutsDao(database: ShortcutsDatabase) = database.shortcutDao()

    @Provides
    fun provideShortcutsRepository(shortcutDao: ShortcutDao, groupsDao: ShortcutGroupDao): ShortcutsRepository =
        ShortcutsRepositoryImpl(shortcutsDao = shortcutDao, groupsDao = groupsDao)
}
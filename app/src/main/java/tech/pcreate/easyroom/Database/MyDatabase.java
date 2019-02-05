package tech.pcreate.easyroom.Database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;

import tech.pcreate.easyroom.Dao.MyDao;
import tech.pcreate.easyroom.Entity.MyEntity;
import tech.pcreate.easyroom.Utilities.TimeStampConverter;


@Database(entities = {MyEntity.class}, version =  1)
@TypeConverters({TimeStampConverter.class})
public abstract class MyDatabase extends RoomDatabase {

    public abstract MyDao myDao();

}

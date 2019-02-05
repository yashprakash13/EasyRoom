package tech.pcreate.easyroom.Dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import tech.pcreate.easyroom.Entity.MyEntity;

@Dao
public interface MyDao {
    @Insert
    void insert(MyEntity musing);

    @Delete
    void delete(MyEntity musing);

    @Update
    void update(MyEntity musing);

    @Query("select * from my_table order by time desc")
    LiveData<List<MyEntity>> getAllRows();

    @Query("select * from my_table where id =:inputId")
    LiveData<MyEntity> getOneRow(int inputId);


}
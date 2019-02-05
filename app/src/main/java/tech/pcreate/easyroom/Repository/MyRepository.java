package tech.pcreate.easyroom.Repository;

import android.annotation.SuppressLint;
import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Room;
import android.content.Context;
import android.os.AsyncTask;

import java.util.List;

import tech.pcreate.easyroom.Database.MyDatabase;
import tech.pcreate.easyroom.Entity.MyEntity;
import tech.pcreate.easyroom.Utilities.TimeClass;

public class MyRepository {

    private final String DB_NAME = "my_database";

    private MyDatabase myDatabase;

    public MyRepository(Context context) {
        myDatabase = Room.databaseBuilder(context, MyDatabase.class, DB_NAME)
                .build();
    }

    public void insert(String title, String desc){
        MyEntity entity = new MyEntity();
        entity.setTitle(title);
        entity.setContent(desc);
        entity.setWroteAt(TimeClass.getCurrentDateTime());

        new InsertAsync().execute(entity);
    }

    public void updateMusing(MyEntity entity){

        new UpdateAsync().execute(entity);
    }

    @SuppressLint("StaticFieldLeak")
    public void delete(final int id){

        final LiveData<MyEntity> entityLiveData = getOneRow(id);

        if (entityLiveData != null){
            new AsyncTask<Void, Void, Void>(){

                @SuppressLint("WrongThread")
                @Override
                protected Void doInBackground(Void... voids) {
                    myDatabase.myDao().delete(entityLiveData.getValue());
                    return null;
                }
            }.execute();
        }

    }

    @SuppressLint("StaticFieldLeak")
    public void delete(final MyEntity entity) {
        new AsyncTask<Void, Void, Void>() {
            @SuppressLint("WrongThread")
            @Override
            protected Void doInBackground(Void... voids) {
                new DeleteAsync().execute(entity);
                return null;
            }
        }.execute();
    }

    public LiveData<MyEntity> getOneRow(int id){
        return myDatabase.myDao().getOneRow(id);
    }

    public LiveData<List<MyEntity>> getAllRows(){
        return myDatabase.myDao().getAllRows();
    }


    private class InsertAsync extends AsyncTask<MyEntity, Void, Void>{
        @Override
        protected Void doInBackground(MyEntity... entity) {

            myDatabase.myDao().insert(entity[0]);
            return null;
        }

    }


    private class DeleteAsync extends AsyncTask<MyEntity, Void, Void>{
        @Override
        protected Void doInBackground(MyEntity... musings) {

            myDatabase.myDao().delete(musings[0]);
            return null;
        }
    }

    private class UpdateAsync extends AsyncTask<MyEntity, Void, Void>{
        @Override
        protected Void doInBackground(MyEntity... entity) {
            myDatabase.myDao().update(entity[0]);
            return null;
        }
    }


}

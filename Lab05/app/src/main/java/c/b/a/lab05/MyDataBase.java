package c.b.a.lab05;

import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.Database;
import android.content.Context;

@Database(entities = {User.class}, version = 1)
public abstract class MyDataBase extends RoomDatabase {
    private static final String DB_NAME = "MY_DATABASE.db";

    public abstract UserDao userDao();

    private static MyDataBase INSTANCE = null;
    public static MyDataBase getInstance(Context context){
        if(INSTANCE == null) {
            synchronized (MyDataBase.class){
                if (INSTANCE == null){
                    INSTANCE = Room.databaseBuilder(context, MyDataBase.class, DB_NAME)
                            .allowMainThreadQueries()
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}

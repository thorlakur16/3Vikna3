package c.b.a.lab05;


import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void addUser(User... users);

    @Update(onConflict = OnConflictStrategy.REPLACE)
    void updateUser(User... user);

    @Delete
    void remove(User... user);

    @Query("SELECT * FROM USERS")
    List<User> getall();

    @Query("SELECT * FROM USERS WHERE USERNAME = :username")
    User getUserByName(String username);

    @Query("DELETE FROM USERS WHERE USERNAME = :username")
    void removeUserByName(String username);

}

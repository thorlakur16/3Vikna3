package c.b.a.lab05;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

@Entity(tableName = "USERS")
public class User {
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "USERNAME")
    public final String username;

    @Nullable
    @ColumnInfo(name = "NR1")
    public int nr1 = 0;

    @Nullable
    @ColumnInfo(name = "TYPE")
    public String type = "";

    @Nullable
    @ColumnInfo(name = "NR2")
    public int nr2 = 0;

    @Nullable
    @ColumnInfo(name = "ANSWER")
    public int answer = 0;

    @Nullable
    @ColumnInfo(name = "ADDRIGHT")
    public int add_right = 0;

    @Nullable
    @ColumnInfo(name = "ADDPLAYED")
    public int add_played = 0;

    @Nullable
    @ColumnInfo(name = "SUBRIGHT")
    public int sub_right = 0;

    @Nullable
    @ColumnInfo(name = "SUBPLAYED")
    public int sub_played = 0;

    @Nullable
    @ColumnInfo(name = "MULRIGHT")
    public int mul_right = 0;

    @Nullable
    @ColumnInfo(name = "MULPLAYED")
    public int mul_played = 0;

    public User(@NonNull String username){
        this.username = username;
    }
}

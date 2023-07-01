package sg.edu.np.mad.week2t04;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class User implements Parcelable{
    public String name;
    public String description;

    public int id;
    public boolean followed;

    public User(){ }


    public User(String name, String description, int id, boolean followed) {
        this.name = name;
        this.description = description;
        this.id = id;
        this.followed = followed;
    }

    // Passing user object through intent
    protected User(Parcel in){
        name = in.readString();
        description = in.readString();
        id = in.readInt();
        // readBoolean does not work, require API Level 29
        followed = in.readByte() != 0;
    }

    public static final Parcelable.Creator<User> CREATOR = new Parcelable.Creator<User>() {
        @Override
        public User createFromParcel(Parcel source) {
            return new User(source);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(description);
        dest.writeInt(id);
        // true if byte is 1, false if 0
        dest.writeByte(followed ? (byte) 1 :(byte) 0);
    }
}


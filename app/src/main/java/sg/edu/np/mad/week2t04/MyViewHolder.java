package sg.edu.np.mad.week2t04;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyViewHolder extends RecyclerView.ViewHolder {
    ImageView imageView, imageView7;
    TextView name,description;
    Context context;

    public MyViewHolder(@NonNull View itemView){
        super(itemView);
        imageView = itemView.findViewById(R.id.imageView);
        imageView7 = itemView.findViewById(R.id.imageView7);
        name = itemView.findViewById(R.id.textName);
        description = itemView.findViewById(R.id.textDesc);

    }
}

package net.vrgsoft.rollinglayoutmanager;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class SimpleAdapter extends RecyclerView.Adapter<SimpleAdapter.SimpleViewHolder> {
    private List<String> mData;
    public Context context;
    int[] array = new int[]{R.array.current,R.array.voltage,R.array.resistance,R.array.circuit,R.array.power_supply,
            R.array.resistor,R.array.inductance,R.array.safety,R.array.diode,R.array.transistor,
            R.array.measuring_instruments};
    int[] array2 = new int[]{R.array.i_current,R.array.i_voltage,R.array.i_resistance,R.array.i_circuit,R.array.i_power_supply,
            R.array.i_resistor,R.array.i_inductance,R.array.i_safety,R.array.i_diode,R.array.i_transistor,
            R.array.i_measuring_instruments};
    int[] array3 = new int[]{R.array.b_current,R.array.b_voltage,R.array.b_resistance,R.array.b_circuit,R.array.b_power_supply,
            R.array.b_resistor,R.array.b_inductance,R.array.b_safety,R.array.b_diode,R.array.b_transistor,
            R.array.b_measuring_instruments};


    public SimpleAdapter() {
        this(new ArrayList<String>());
    }
    public SimpleAdapter(List<String> data) {
        this.mData = data;
    }
    public SimpleAdapter(List<String> data,Context context) {
        this.mData = data;
        this.context = context;
    }

    public void setData(List<String> data) {
        mData = data;
    }

    @Override
    public SimpleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View item = inflater.inflate(R.layout.item_simple, parent, false);
        return new SimpleViewHolder(item);
    }

    @Override
    public void onBindViewHolder(SimpleViewHolder holder, int position) {
        holder.bind(mData.get(position));
        
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    class SimpleViewHolder extends RecyclerView.ViewHolder{
        private TextView mTextView;
        public ImageView imageView;


        public SimpleViewHolder(final View itemView) {
            super(itemView);
            mTextView = itemView.findViewById(R.id.title);
            mTextView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int i = getAdapterPosition();
                        if(i==11){
                            Intent intent= new Intent(context,QuizActivity.class);
                            context.startActivity(intent);
                        }
                        else{
                            Intent intent = new Intent(context,CurrentActivity.class);
                            intent.putExtra("strings",array[getAdapterPosition()]);
                            intent.putExtra("ints",array2[getAdapterPosition()]);
                            intent.putExtra("before",array3[getAdapterPosition()]);
                            intent.putExtra("title",mData.get(getAdapterPosition()));
                            context.startActivity(intent);
                        }
                }
            });
        }

        public void bind(String data){
            mTextView.setText(data);

        }
    }
}

package com.example.dinedash.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.dinedash.R;
import com.example.dinedash.model.OrderedItem;
import java.util.List;

public class OrderedItemAdapter extends RecyclerView.Adapter<OrderedItemAdapter.ViewHolder> {
    private List<OrderedItem> items;

    public OrderedItemAdapter(List<OrderedItem> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_ordered, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        OrderedItem item = items.get(position);
        holder.name.setText(item.getName());
        holder.quantity.setText("Qty: " + item.getQuantity());
        holder.price.setText("৳ " + item.getPrice());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView name, quantity, price;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.itemName);
            quantity = itemView.findViewById(R.id.itemQuantity);
            price = itemView.findViewById(R.id.itemPrice);
        }
    }
}

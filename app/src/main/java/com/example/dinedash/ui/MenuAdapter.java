package com.example.dinedash.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.dinedash.R;
import com.example.dinedash.model.MenuItem;
import java.util.ArrayList;
import java.util.List;

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.MenuViewHolder> {

    private final List<MenuItem> menuList;
    private final List<MenuItem> selectedItems = new ArrayList<>();

    public MenuAdapter(List<MenuItem> menuList) {
        this.menuList = menuList;
    }

    @NonNull
    @Override
    public MenuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_menu, parent, false);
        return new MenuViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MenuViewHolder holder, int position) {
        MenuItem item = menuList.get(position);
        holder.name.setText(item.getName());
        holder.price.setText("৳" + item.getPrice());

        holder.itemView.setBackgroundColor(
                selectedItems.contains(item) ? 0xFFDDFFDD : 0xFFFFFFFF
        );

        holder.itemView.setOnClickListener(v -> {
            if (!selectedItems.contains(item)) {
                selectedItems.add(item);
            }
            notifyItemChanged(position);
        });
    }

    @Override
    public int getItemCount() {
        return menuList.size();
    }

    public List<MenuItem> getSelectedItems() {
        return selectedItems;
    }

    public static class MenuViewHolder extends RecyclerView.ViewHolder {
        TextView name, price;

        public MenuViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.menuName);
            price = itemView.findViewById(R.id.menuPrice);
        }
    }
}

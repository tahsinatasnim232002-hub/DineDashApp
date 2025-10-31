package com.example.dinedash.ui;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.dinedash.R;
import com.example.dinedash.model.MenuItem;
import java.util.List;

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.MenuViewHolder> {

    private final List<MenuItem> menuList;

    public MenuAdapter(List<MenuItem> menuList) {
        this.menuList = menuList;
        setHasStableIds(true); // optional, ensures stable IDs
    }

    @NonNull
    @Override
    public MenuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_menu, parent, false);
        return new MenuViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull MenuViewHolder holder, int position) {
        MenuItem item = menuList.get(position);
        holder.name.setText(item.getName());
        holder.description.setText(item.getDescription());
        holder.price.setText(String.format("$%s", item.getPrice()));
    }

    @Override
    public int getItemCount() {
        return menuList.size();
    }

    @Override
    public long getItemId(int position) {
        return menuList.get(position).getId(); // use item ID if available
    }

    public static class MenuViewHolder extends RecyclerView.ViewHolder {
        TextView name, description, price;
        public MenuViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.menuName);
            description = itemView.findViewById(R.id.menuDescription);
            price = itemView.findViewById(R.id.menuPrice);
        }
    }
}

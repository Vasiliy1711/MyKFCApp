package com.example.mykfcapp.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mykfcapp.R;
import com.example.mykfcapp.models.ModelCategory;

import java.util.ArrayList;
import java.util.List;

public class AdapterMC extends RecyclerView.Adapter<AdapterMC.MCViewHolder>
{
    public interface onModelCategoryClickListener
    {
        void onModelCategoryClicked(ModelCategory category);
    }

    private onModelCategoryClickListener onModelCategoryClickListener;

    public void setOnModelCategoryClickListener(AdapterMC.onModelCategoryClickListener onModelCategoryClickListener)
    {
        this.onModelCategoryClickListener = onModelCategoryClickListener;
    }

    private List<ModelCategory> categories;

    public AdapterMC()
    {
        categories = new ArrayList<>();
    }

    public void setCategories(List<ModelCategory> categories)
    {
        this.categories = categories;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MCViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_category, parent, false);
        return new MCViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MCViewHolder holder, int position)
    {
        ModelCategory category = categories.get(position);
        holder.bindModelCategory(category);
    }

    @Override
    public int getItemCount()
    {
        if (categories == null)
        {
            return 0;
        }
        return categories.size();
    }

    class MCViewHolder extends RecyclerView.ViewHolder
    {
        private ImageView catImage;
        private TextView catName;
        private TextView catDescription;
        private TextView catDate;
        private TextView fileQuantity;

        public MCViewHolder(@NonNull View itemView)
        {
            super(itemView);
            catImage = itemView.findViewById(R.id.imageCategory);
            catName = itemView.findViewById(R.id.nameOfCategory);
            catDescription = itemView.findViewById(R.id.descriptionOfCategory);
            catDate = itemView.findViewById(R.id.dateCategory);
            fileQuantity = itemView.findViewById(R.id.quantityOfFiles);
        }

        public void bindModelCategory(final ModelCategory category)
        {
            this.catImage.setImageResource(category.getImgId());
            this.catName.setText(category.getCatName());
            this.catDescription.setText(category.getCatDescription());
            this.catDate.setText(category.getCatDate());
            this.fileQuantity.setText(category.getFileQuantity());
            itemView.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    if (onModelCategoryClickListener != null)
                    {
                        onModelCategoryClickListener.onModelCategoryClicked(category);
                    }
                }
            });
        }
    }
}

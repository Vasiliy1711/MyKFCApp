package com.example.mykfcapp.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mykfcapp.R;
import com.example.mykfcapp.models.ModelDocument;

import java.util.ArrayList;
import java.util.List;

public class AdapterMD extends RecyclerView.Adapter<AdapterMD.MDViewHolder>
{
    public interface OnModelDocumentClickListener
    {
        void onModelDocumentClicked(ModelDocument document);
    }

    private OnModelDocumentClickListener onModelDocumentClickListener;

    public void setOnModelDocumentClickListener(OnModelDocumentClickListener onModelDocumentClickListener)
    {
        this.onModelDocumentClickListener = onModelDocumentClickListener;
    }

    private List<ModelDocument> documents;

    public AdapterMD()
    {
        documents = new ArrayList<>();
    }

    public void setDocuments(List<ModelDocument> documents)
    {
        this.documents = documents;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MDViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_document, parent, false);
        return new MDViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MDViewHolder holder, int position)
    {
        ModelDocument document = documents.get(position);
        holder.bindModelDocument(document);
    }

    @Override
    public int getItemCount()
    {
        if (documents == null)
        {
            return 0;
        }
        return documents.size();

    }

    class MDViewHolder extends RecyclerView.ViewHolder
    {
        private ImageView docImage;
        private TextView docName;
        private TextView docDescription;
        private TextView docDate;

        public MDViewHolder(@NonNull View itemView)
        {
            super(itemView);
            docImage = itemView.findViewById(R.id.docImage);
            docName = itemView.findViewById(R.id.item_doc_name);
            docDescription = itemView.findViewById(R.id.doc_description);
            docDate = itemView.findViewById(R.id.doc_update);
        }

        private void bindModelDocument(final ModelDocument document)
        {
            this.docImage.setImageResource(document.getDocImg());
            this.docName.setText(document.getDocName());
            this.docDescription.setText(document.getDocDescription());
            this.docDate.setText(document.getDocDate());
            itemView.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    if (onModelDocumentClickListener != null)
                    {
                        onModelDocumentClickListener.onModelDocumentClicked(document);
                    }
                }
            });
        }
    }
}

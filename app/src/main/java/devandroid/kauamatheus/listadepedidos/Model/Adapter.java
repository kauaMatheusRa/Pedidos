package devandroid.kauamatheus.listadepedidos.Model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import devandroid.kauamatheus.listadepedidos.R;

public class Adapter extends RecyclerView.Adapter<Adapter.RecyclerTesteViewHolder> {

    public static Interface.ClickRecyclerView_Interface clickRecyclerViewInterface;
    Context mctx;
    private List<Item> mList;

    public Adapter(Context ctx, List<Item> list, Interface.ClickRecyclerView_Interface clickRecyclerViewInterface) {
        this.mctx = ctx;
        this.mList = list;
        this.clickRecyclerViewInterface = clickRecyclerViewInterface;
    }

    @Override
    public RecyclerTesteViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activity_order_item, viewGroup, false);
        return new RecyclerTesteViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(RecyclerTesteViewHolder viewHolder, int i) {
        Item item = mList.get(i);

        viewHolder.viewNome.setText(item.getNome());
        viewHolder.viewQntd.setText(String.valueOf(item.getQntd()));
        viewHolder.viewPreco.setText(String.valueOf(item.getPreco()));
        viewHolder.viewTotal.setText(item.getTotal());

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }


    protected class RecyclerTesteViewHolder extends RecyclerView.ViewHolder {

        protected TextView viewNome;
        protected TextView viewQntd;
        protected TextView viewPreco;
        protected TextView viewTotal;

        public RecyclerTesteViewHolder(final View itemView) {
            super(itemView);

            viewNome = (TextView) itemView.findViewById(R.id.TextViewNome);
            viewQntd = (TextView) itemView.findViewById(R.id.textViewQnt);
            viewPreco = (TextView) itemView.findViewById(R.id.textViewPreco);
            viewTotal = (TextView) itemView.findViewById(R.id.textViewTotal);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    clickRecyclerViewInterface.onCustomClick(mList.get(getLayoutPosition()));

                }
            });
        }
    }
}

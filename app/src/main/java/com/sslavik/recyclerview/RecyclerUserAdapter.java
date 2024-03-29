package com.sslavik.recyclerview;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sslavik.recyclerview.Model.UserModel;
import com.sslavik.recyclerview.repository.RepositoryUser;

import java.util.ArrayList;
import java.util.List;

public class RecyclerUserAdapter extends RecyclerView.Adapter<RecyclerUserAdapter.ViewHolder> {

    private Context context;
    private List<UserModel> userModelList;
    private OnItemClickListener listener;
    private OnUserClickListener userListener;
    /*
        La clase que quiera escuchar el evento onClickListener del recyclerView debe implementar la siguiente interfaz.
        Opción 1 : Heredar de View.onClickListener
     */
    public interface OnItemClickListener extends View.OnClickListener {
        @Override
        void onClick(View v);
    }
    /*
        Implementamos un interfaz para tener un Listener que obtenga directamente el usuario para usarlo en el Activity o en el Fragment
        Opcion 2 : Crear un View.OnUserClickListener(UserModel user)
     */
    public interface OnUserClickListener {
        void onClick(UserModel user);
    }
    /**
     * Constructor
     * @param context Contexto de nuestro usuario
     */
    public RecyclerUserAdapter(Context context, OnItemClickListener listener){
        this.context = context;
        this.userModelList = RepositoryUser.getInstance().getUsers();
        this.listener = listener;
    }

    /**
     * Sobreescrito el Constructor para tener un nuevo Listener
     * @param context
     * @param userListener
     */
    public RecyclerUserAdapter(Context context, OnUserClickListener userListener){
        this.context = context;
        this.userModelList = RepositoryUser.getInstance().getUsers();
        this.userListener = userListener;
    }


    /**
     *Método que actualiza / infla desde XML el ViewHolder que hemos creado
     * @param parent
     * @param viewType
     * @return
     */
    @NonNull
    @Override
    public RecyclerUserAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View nuevaVista = LayoutInflater.from(context).inflate(R.layout.recycler_view_item, parent, false);
        // Opción 1 : Se ha aprovechado que el listener OnClick existe en todos los Objetos view
        nuevaVista.setOnClickListener(listener);

        return new ViewHolder(nuevaVista);
    }

    /**
     * Enlaza losdatos a cada componente del View Holder cuando se produce el desplazamiento
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        String name = userModelList.get(position).getName();
        String email = userModelList.get(position).getEmail();

        ((TextView)holder.tvUser).setText(name);
        ((TextView)holder.tvEmail).setText(email);
        // NECESITAMOS ASIGNARLE EL ONLCIKC AL View del HOLDER
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userListener.onClick(userModelList.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return userModelList.size();
    }
    /**
     * Almacena las vistas o los elementos / itemView que componen el RecyclerView
     */

    public UserModel getItem(int position){
        return userModelList.get(position);
    }

    public class ViewHolder extends  RecyclerView.ViewHolder {

        private View tvUser;
        private View tvEmail;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvUser = itemView.findViewById(R.id.tvUser);
            tvEmail = itemView.findViewById(R.id.tvEmail);
        }
    }
}

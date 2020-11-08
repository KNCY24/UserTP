package com.e.usertp


import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.e.usertp.databinding.UserBinding

class MyAdapter(val users : List<User>, val callback: (Int) -> Unit) :
    RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

        // un ViewHolder permet de stocker la vue de chaque item de la liste
        class MyViewHolder(val v: LinearLayout, var binding : UserBinding) : RecyclerView.ViewHolder(v)

        var i = 0

    // appelé quand le ViewHolder doit être créé (probablement parce que l'item devient visible)
    // on crée (inflate) le layout "user" et on le place dans le ViewHolder
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter.MyViewHolder {
            val binding = DataBindingUtil.inflate<UserBinding>(LayoutInflater.from(parent.context), R.layout.user, parent, false)
            val layout = binding.root
            val holder = MyViewHolder(layout as LinearLayout,binding)
            layout.setOnClickListener{
                users.get(i).isSelected=false
                users.get(holder.adapterPosition).isSelected=true
                //notifyItemChanged(holder.adapterPosition)
                //notifyItemChanged(i)
                i = holder.adapterPosition
                callback(holder.adapterPosition)
            }

            return holder
        }

    // appelé quand le recycerview a besoin de connaître la taille de la liste qu'il doit afficher
        override fun getItemCount(): Int = users.size

    // appelé quand on doit peupler le ViewHolder avec le contenu de l'élément numéro "position"
        override fun onBindViewHolder(holder: MyAdapter.MyViewHolder, position: Int) {
            /*val nom = holder.v.findViewById<TextView>(R.id.nom)
            val prenom = holder.v.findViewById<TextView>(R.id.prenom)
            val age = holder.v.findViewById<TextView>(R.id.age)

            nom.text= users[position].nom
            prenom.text= users[position].prenom
            age.text= users[position].age.toString()*/

            holder.binding.user2 = users[position]

            /*if(users[position].age > 40){
                nom.setBackgroundColor(Color.GREEN)
                prenom.setBackgroundColor(Color.GREEN)
                age.setBackgroundColor(Color.GREEN)
            }else{

                nom.setBackgroundColor(Color.YELLOW)
                prenom.setBackgroundColor(Color.YELLOW)
                age.setBackgroundColor(Color.YELLOW)
            }*/
    }
}

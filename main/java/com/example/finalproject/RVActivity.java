package com.example.finalproject;

import static com.example.finalproject.DataBase.RecipeMethodTitle1;
import static com.example.finalproject.DataBase.category1;
import static com.example.finalproject.DataBase.image1;
import static com.example.finalproject.DataBase.name1;
import static com.example.finalproject.DataBase.recipe1;
import static com.example.finalproject.DataBase.recipeIngredients1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class RVActivity extends AppCompatActivity {
    private RecyclerView myrecyclerView;
    private RecyclerViewAdapter myAdapter;
    private List<recipes> itemlist = new ArrayList<>();
    private DataBase databaseClass;
    private SearchView searchview;
    private SearchView searchViewCat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stam);
        searchview = findViewById(R.id.searchView);
        searchview.clearFocus();
        searchview.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filterList2(newText);
                return true;
          }
});
        /*searchViewCat = findViewById(R.id.searchViewCat);
        //searchViewCat.clearFocus();
        searchViewCat.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filterList2(newText);
                return true;
            }
        });*/
        for (int i = 0 ; i < name1.length; i++){
            recipes temp = new recipes(name1[i] , recipeIngredients1[i] , RecipeMethodTitle1[i] , recipe1[i] , category1[i], image1[i] );
            itemlist.add(temp);
        }
        List<recipes> itemList = new ArrayList<>();
        itemList.addAll(itemlist);


        myrecyclerView = (RecyclerView)findViewById(R.id.recyclerView_id);

        myAdapter = new RecyclerViewAdapter(this,itemlist);

        myrecyclerView.setLayoutManager(new GridLayoutManager(this,1));

        myrecyclerView.setAdapter(myAdapter);

    }

    private void filterList2(String newText) {
       List<recipes> filterdList2 = new ArrayList<>();
       for (recipes recipes : itemlist){
           if (recipes.getCategory().toLowerCase().contains(newText.toLowerCase()) || recipes.getRecipeIngredients().toLowerCase().contains(newText.toLowerCase())){
               filterdList2.add((recipes));
           }
           if(filterdList2.isEmpty()){
               Toast.makeText(this , "No recipe from this category" , Toast.LENGTH_LONG).show();
           }
           else {
               myAdapter.setFilteredList2(filterdList2);
           }
       }
    }

   /* private void filterList(String text) {
        List<recipes> filteredList = new ArrayList<>();
        for (recipes recipes : itemlist){
            if (recipes.getRecipeIngredients().toLowerCase().contains(text.toLowerCase())){
                filteredList.add(recipes);
            }
            if(filteredList.isEmpty()){
                Toast.makeText(this , "No recipe with this ingredient", Toast.LENGTH_LONG).show();
            }
            else {
                myAdapter.setFilteredList(filteredList);
            }
  }
} */
}
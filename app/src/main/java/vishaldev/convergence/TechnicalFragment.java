package vishaldev.convergence;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class TechnicalFragment extends ListFragment implements AdapterView.OnItemClickListener {

    ListView listView ;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.fragment_technical, container, false);

        return view;
    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(getActivity(), R.array.Technical, android.R.layout.simple_list_item_1);
        setListAdapter(adapter);
        getListView().setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position,long id) {
      switch (position){
          case 0:
              FragmentManager manager = getFragmentManager();
              LangamingFragment dialog=new LangamingFragment();
              dialog.show(manager,"dialog");
              break;
          case 1:
              FragmentManager manager1 = getFragmentManager();
              SportsFragment dialog1=new SportsFragment();
              dialog1.show(manager1,"dialog");
              break;
          case 2:
              FragmentManager manager2 = getFragmentManager();
              TechnicalquizFragment dialog2=new TechnicalquizFragment();
              dialog2.show(manager2,"dialog");
              break;
          case 3:
              FragmentManager manager3 = getFragmentManager();
              GeneralquizFragment dialog3=new GeneralquizFragment();
              dialog3.show(manager3,"dialog");
              break;
          case 4:
              FragmentManager manager4 = getFragmentManager();
              PPTFragment dialog4=new PPTFragment();
              dialog4.show(manager4,"dialog");
              break;
          case 5:
              FragmentManager manager5 = getFragmentManager();
              ModelMakingFragment dialog5=new ModelMakingFragment();
              dialog5.show(manager5,"dialog");
              break;

          case 6:
              FragmentManager manager6 = getFragmentManager();
              CodehuntFragment dialog6=new CodehuntFragment();
              dialog6.show(manager6,"dialog");
              break;
          case 7:
              FragmentManager manager7 = getFragmentManager();
              BestoutofwasteFragment dialog7=new BestoutofwasteFragment();
              dialog7.show(manager7,"dialog");
              break;



      }




    }

}

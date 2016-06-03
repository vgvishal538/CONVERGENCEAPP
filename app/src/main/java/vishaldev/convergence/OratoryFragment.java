package vishaldev.convergence;


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


/**
 * A simple {@link Fragment} subclass.
 */
public class OratoryFragment extends ListFragment implements AdapterView.OnItemClickListener {

    ListView listView ;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_oratory, container, false);
        return view;
    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(getActivity(), R.array.Oratory, android.R.layout.simple_list_item_1);
        setListAdapter(adapter);
        getListView().setOnItemClickListener(this);
    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position,long id) {
        switch (position){

            case 0:
                FragmentManager manager = getFragmentManager();
                ExtemporeFragment dialog=new ExtemporeFragment();
                dialog.show(manager,"dialog");
                break;
            case 1:
                FragmentManager manager1 = getFragmentManager();
                DebateFragment dialog1=new DebateFragment();
                dialog1.show(manager1,"dialog");
                break;
            case 2:
                FragmentManager manager2 = getFragmentManager();
                PoetryFragment dialog2=new PoetryFragment();
                dialog2.show(manager2,"dialog");
                break;
            case 3:
                FragmentManager manager3 = getFragmentManager();
                SpeechFragment dialog3=new SpeechFragment();
                dialog3.show(manager3,"dialog");
                break;


        }




    }

}

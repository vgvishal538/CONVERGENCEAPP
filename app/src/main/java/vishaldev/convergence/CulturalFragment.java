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
public class CulturalFragment extends ListFragment implements AdapterView.OnItemClickListener {

    ListView listView ;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_cultural, container, false);
        return view;
    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(getActivity(), R.array.Cultural, android.R.layout.simple_list_item_1);
        setListAdapter(adapter);
        getListView().setOnItemClickListener(this);
    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position,long id) {
        switch (position) {

            case 0:
                FragmentManager manager = getFragmentManager();
                SingingFragment dialog=new SingingFragment();
                dialog.show(manager,"dialog");
                break;
            case 1:
                FragmentManager manager1 = getFragmentManager();
                DancingFragment dialog1=new DancingFragment();
                dialog1.show(manager1,"dialog");
                break;
            case 2:
                FragmentManager manager2 = getFragmentManager();
                IntrumentalFragment dialog2=new IntrumentalFragment();
                dialog2.show(manager2,"dialog");
                break;
            case 3:
                FragmentManager manager3 = getFragmentManager();
                BattleofbandsFragment dialog3=new BattleofbandsFragment();
                dialog3.show(manager3,"dialog");
                break;
            case 4:
                FragmentManager manager4 = getFragmentManager();
                PhotographyFragment dialog4=new PhotographyFragment();
                dialog4.show(manager4,"dialog");
                break;
            case 5:
                FragmentManager manager5 = getFragmentManager();
                StreetplayFragment dialog5=new StreetplayFragment();
                dialog5.show(manager5,"dialog");
                break;
            case 6:
                FragmentManager manager6 = getFragmentManager();
                StageplayFragment dialog6=new StageplayFragment();
                dialog6.show(manager6,"dialog");
                break;
            case 7:
                FragmentManager manager7 = getFragmentManager();
                DramaticsFragment dialog7=new DramaticsFragment();
                dialog7.show(manager7,"dialog");
                break;
        }
    }


}
